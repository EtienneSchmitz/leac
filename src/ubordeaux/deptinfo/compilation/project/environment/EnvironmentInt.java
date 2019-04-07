package ubordeaux.deptinfo.compilation.project.environment;
import ubordeaux.deptinfo.compilation.project.node.Node;

public interface EnvironmentInt {
    // Add a variable in environment.
    void add(String var, Node node);

    // Get a variable in environment.
    Node getNode(String key);
}
