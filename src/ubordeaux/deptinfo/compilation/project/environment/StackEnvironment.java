package ubordeaux.deptinfo.compilation.project.environment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ubordeaux.deptinfo.compilation.project.main.CompilationException;
import ubordeaux.deptinfo.compilation.project.node.Node;
import ubordeaux.deptinfo.compilation.project.node.NodeId;
import ubordeaux.deptinfo.compilation.project.node.NodeList;

public class StackEnvironment {
    private Scope[] scopes;
    private int scopeIndex;
    
    public final static boolean IS_MAIN_SCOPE_GLOBAL = false;
    public final static int MAX_NESTED_SCOPES = 256;
    
    private class Scope {
    	public Map<String, NodeId> variables = new HashMap<String, NodeId>();
    	public boolean canAccessToParentScope = false;
    	
    	public Scope() {
    	}
    	
    	public Scope(NodeList variables) {
    		add(variables);
    	}
    	
    	public void add(NodeList variables) {
    		Iterator<Node> it = variables.iterator();
    		
    		while(it.hasNext())
    			add(it.next());
    	}
    	
    	public void add(Node variable) {
    		try {
	    		NodeId node = (NodeId)variable;
	    		if(variables.putIfAbsent(node.getName(), node) != null)
	    			CompilationException.halt("The variable " + node.getName() + " already exist in this scope.", node);
    		} catch (ClassCastException e) {
    			CompilationException.halt("Only NodeId can be added into a scope.");
    		}
    	}
    }
    
    public StackEnvironment() {       
        scopeIndex = 0;
        scopes = new Scope[MAX_NESTED_SCOPES];
        scopes[0] = new Scope(new NodeList());
    }
    
    public void addNewScope(NodeList variables, boolean canAccessToParent) {
    	stackScope();
    	scopes[scopeIndex].add(variables);
    	scopes[scopeIndex].canAccessToParentScope = canAccessToParent;
    	
    	if(canAccessToParent && scopeIndex < 2)
    		CompilationException.halt("Global and first-level scopes can not have acces to their parent.");
    	
    	log(variables.size() + " elements added to the stack. (new scope).");
    }
    
    public void addNewScope(NodeId variable, boolean canAccessToParent) {
    	addNewScope(new NodeList(variable), canAccessToParent);
    }
    
    
    public void addToCurrentScope(NodeList variables) {
    	if(!isStackEmpty()) {
    		scopes[scopeIndex].add(variables);
    			
    		log(variables.size() + " elements added to the stack. (current scope).");
    	} else {
    		CompilationException.halt("There is no scope to work with.");
    	}
    }
    
    public void addToCurrentScope(NodeId variable) {
    	addToCurrentScope(new NodeList(variable));
    }
    
    private void stackScope() {
    	scopeIndex++;
    	
    	if(scopeIndex >= MAX_NESTED_SCOPES)
    		CompilationException.halt("Unable to handle more than " + MAX_NESTED_SCOPES + " nested scopes.");
    	
    	scopes[scopeIndex] = new Scope();
    }
    
    private Scope unstackScope() {
    	if(isStackEmpty())
    		CompilationException.halt("Unable to unstack an empty stack.");
    	
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
    	
    	for(Map.Entry<String, NodeId> var : scopes[index].variables.entrySet()) {
    		if(id.equals(var.getKey()))
    			return var.getValue();
    	}
    	
    	if(index > 1 && scopes[index].canAccessToParentScope)
    		return findInScope(id, index - 1);
    	
    	if(index != 0 && IS_MAIN_SCOPE_GLOBAL)
    		return findInScope(id, 0);
    	
    	return null;
    }
    
    public void closeCurrentScope() {
    	unstackScope();
    }
    
    public Node get(String id) {
    	if(!isStackEmpty()) {
    		Node node = findInScope(id, scopeIndex);
    		
    		if(node == null)
    			CompilationException.halt("Variable \"" + id + "\" does not exist in this scope.");
    		
    		return node;
    	} 
    	CompilationException.halt("There is no scope to search the variable in.");
    	
    	return null;
    }
    
    private void log(String msg) {
    	System.out.println(this.getClass().getSimpleName() + " --> " + msg);
    }
}
