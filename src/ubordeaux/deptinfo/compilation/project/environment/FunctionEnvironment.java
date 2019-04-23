package ubordeaux.deptinfo.compilation.project.environment;

import java.util.HashMap;
import java.util.Map;

import ubordeaux.deptinfo.compilation.project.node.NodeList;
import ubordeaux.deptinfo.compilation.project.type.TypeFunct;

public class FunctionEnvironment {
	
	public class Function {
		public TypeFunct declaration;
		public NodeList definition;
		
		public Function(TypeFunct declaration, NodeList definition) {
			this.declaration = declaration;
			this.definition = definition;
		}
	}
	
	private Map<String, Function> functions;
	
	public FunctionEnvironment() {
		functions = new HashMap<>();
	}
	
	public void add(String name, TypeFunct declaration, NodeList definition) {
		declaration.setDefined(definition != null);
		functions.put(name, new Function(declaration, definition));
	}
	
	public void add(String name, TypeFunct declaration) {
		add(name, declaration, null);
	}
	
	public Function get(String name) {
		return functions.get(name);
	}
}
