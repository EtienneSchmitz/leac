package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.main.ClonableSymbol;
import ubordeaux.deptinfo.compilation.project.type.TypeFunct;

public class NodeFunction extends Node {

	private TypeFunct funcDecl;
	
	public NodeFunction(TypeFunct funcDecl, NodeList definition) {
		super();
		this.funcDecl = funcDecl;
		
		if(definition != null) {
			this.add(definition);
			setDefined(true);
		} else { 
			setDefined(false);
		}
	}
	
	public TypeFunct getDeclaration() {
		return funcDecl;
	}
	
	public NodeList getDefinition() {
		return (NodeList)this.elts.get(0);
	}
	
	public void setDefined(boolean isDefined) {
		this.funcDecl.setDefined(isDefined);
	}
	
	public boolean isDefined() {
		return this.funcDecl.getDefined();
	}
	
	@Override
	public ClonableSymbol clone() {
		return new NodeFunction(getDeclaration(), getDefinition());
	}

	@Override
	public String toString() {
		return "NodeFunction(" + getDeclaration().getName() + ", " + (isDefined() ? getDefinition().toString() : "Not defined");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funcDecl == null) ? 0 : funcDecl.hashCode());
		return result;
	}
}
