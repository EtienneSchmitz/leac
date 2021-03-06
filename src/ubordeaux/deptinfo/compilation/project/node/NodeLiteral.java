package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.*;
import ubordeaux.deptinfo.compilation.project.type.*;

public final class NodeLiteral extends NodeExp {

	private Object value;

	public NodeLiteral(Type type, Object value) {
		super();
		this.type = type;
		this.value = value;
		System.out.println(value);
	}

	public Object getValue() {
		return value;
	}

	public String toString() {
		return this.getClass().getSimpleName() + '#' + value + ':' + type + '#';
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	public String toDotNodeName() {
		return "NodeLiteral " + value.toString();
	}

	@Override
	public NodeLiteral clone() {
		return new NodeLiteral(type, value);
	}

	@Override
	public Exp generateIntermediateCode() {
		if(this.type instanceof TypeInt) {
			return new Const((int) this.value);
		}
		else if(this.type instanceof  TypeBoolean) {
			int boolean_choose = (boolean) this.value ? 1 : 0;
			return new Const(boolean_choose);
 		}
		else if(this.type instanceof TypeString) {
			return new LabelLocation((String) this.value);
		}
		else {
			return null;
		}
	}
}
