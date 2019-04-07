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
    public void add(String key, Node node) {
        map.put(key,node);
        System.out.println(key +" registered");
    }

    @Override
    public Node getNode(String key) {

        return map.get(key);
    }
}
