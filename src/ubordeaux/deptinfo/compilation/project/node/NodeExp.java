package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;
import ubordeaux.deptinfo.compilation.project.type.Type;

public abstract class NodeExp extends Node {

	protected Type type;

	public NodeExp(Node... abstTrees) {
		super(abstTrees);
	}

	public Type getType() {
		return this.type;
	}

	@Override
	public Exp generateIntermediateCode() {
		System.err.println("TODO: " + this.getClass().getSimpleName() + ".generateIntermediateCode_Expr()");
		return null;
	}
}
