package ubordeaux.deptinfo.compilation.project.environment;

import java.util.Iterator;

import ubordeaux.deptinfo.compilation.project.node.Node;
import ubordeaux.deptinfo.compilation.project.node.NodeId;
import ubordeaux.deptinfo.compilation.project.node.NodeList;

public class StackEnvironment {
    private Scope[] scopes;
    private int scopeIndex;
    
    public final static boolean IS_MAIN_SCOPE_GLOBAL = false;
    public final static int MAX_NESTED_SCOPES = 256;
    
    private class Scope {
    	public NodeList variables = null;
    	public boolean canAccessToParentScope = false;
    	
    	public Scope() {
    	}
    	
    	public Scope(NodeList variables) {
    		this.variables = variables;
    	}
    }
    
    public StackEnvironment() {       
        scopeIndex = 0;
        scopes = new Scope[MAX_NESTED_SCOPES];
        scopes[0] = new Scope(new NodeList());
    }
    
    public void addNewScope(NodeList variables, boolean canAccessToParent) {
    	stackScope();
    	scopes[scopeIndex].variables = variables;
    	scopes[scopeIndex].canAccessToParentScope = canAccessToParent;
    	
    	if(canAccessToParent && scopeIndex < 2)
    		log("Global and first-level scopes can not have acces to their parent.");
    	
    	log(variables.size() + " elements added to the stack. (new scope)");
    }
    
    public void addNewScope(NodeId variable, boolean canAccessToParent) {
    	addNewScope(new NodeList(variable), canAccessToParent);
    }
    
    
    public void addToCurrentScope(NodeList variables) {
    	if(!isStackEmpty()) {
    		Iterator<Node> it = variables.iterator();
    		
    		while(it.hasNext())
    			scopes[scopeIndex].variables.add(it.next());;
    	}
    }
    
    public void addToCurrentScope(NodeId variable) {
    	addToCurrentScope(new NodeList(variable));
    }
    
    private void stackScope() {
    	scopeIndex++;
    	
    	if(scopeIndex >= MAX_NESTED_SCOPES)
    		log("Unable to handle more than " + MAX_NESTED_SCOPES + " nested scopes.");
    	
    	scopes[scopeIndex] = new Scope();
    }
    
    private Scope unstackScope() {
    	if(isStackEmpty())
    		log("Unable to unstack an empty stack.");
    	
    	Scope scope = scopes[scopeIndex];
    	scopes[scopeIndex] = null;
    	scopeIndex--;
    	
    	return scope;
    }
    
    private boolean isStackEmpty() {
    	return scopeIndex < 0;
    }
    
    private Node findInScope(String id, int index) {
    	if(index < 0)
    		return null;
    	
    	Iterator<Node> it = scopes[index].variables.iterator();
    	
    	while(it.hasNext()) {
    		NodeId node = (NodeId)it.next();
    		
    		if(node.getName().equals(id))
    			return node;
    	}
    	
    	if(index > 1 && scopes[index].canAccessToParentScope)
    		return findInScope(id, index - 1);
    	
    	if(index != 0 && IS_MAIN_SCOPE_GLOBAL)
    		return findInScope(id, 0);
    	
    	return null;
    }
    
    public boolean closeCurrentScope() {
    	return unstackScope() != null;
    }
    
    public Node get(String id) {
    	if(!isStackEmpty()) {
    		Node node = findInScope(id, scopeIndex);
    		
    		if(node == null)
    			log("Variable \"" + id + "\" does not exist in this scope.");
    		
    		return node;
    	} else {
    		log("There is no scope to search the variable in.");
    	}
    	return null;
    }
    
    private void log(String msg) {
    	System.out.println(this.getClass().getSimpleName() + " --> " + msg);
    }
}
