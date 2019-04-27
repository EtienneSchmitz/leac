package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Const;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;
import ubordeaux.deptinfo.compilation.project.type.*;

public final class NodeLiteral extends NodeExp {

	private Object value;

	public NodeLiteral(Type type, Object value) {
		super();
		this.type = type;
		this.value = value;
		System.out.println(value);
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
			System.out.println("test");
			return new Const((int) this.value);
		}
		else if(this.type instanceof  TypeBoolean) {
			System.out.println("test 2");
			int boolean_choose = (boolean) this.value ? 1 : 0;
			return new Const(boolean_choose);
 		}
		else {
			return null;
		}
	}
}
