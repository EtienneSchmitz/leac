package ubordeaux.deptinfo.compilation.project.environment;

import java.util.HashMap;
import java.util.Map;

import ubordeaux.deptinfo.compilation.project.node.Node;

public class StackEnvironment {
    private String name;

    private Map<String, Environment> scopes;
    
    public StackEnvironment(String name) {
        this.name = name;
        scopes = new HashMap<>();
    }
    
    
}
