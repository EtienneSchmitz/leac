package ubordeaux.deptinfo.compilation.project.environment;

import ubordeaux.deptinfo.compilation.project.node.Node;

import java.util.HashMap;
import java.util.Map;

public class Environment implements EnvironmentInt {

    private String name;
    private Map<String, Node> map;

    public Environment(String name) {
        this.name = name;
        this.map = new HashMap<String, Node>();
    }
    
    @Override
    public boolean add(String key, Node node) {
        if(map.putIfAbsent(key,node) == null) {
        	System.out.println(key +" registered in scope " + name + ".");
        	return true;
        } else {
        	System.err.println("Unable to add add " + key + " in scope " + name + ".");
        	return false;
        }
    }

    @Override
    public Node get(String key) {
        return map.get(key);
    }
    
	@Override
	public void clear() {
		map.clear();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
    public String getName() {
    	return name;
    }
    
    public void print() {
    	System.out.println("========= SCOPE -> " + name);
    	for(Map.Entry<String, Node> var : map.entrySet()) {
    		System.out.println("===== " + var.getKey());
    	}
    }
}
