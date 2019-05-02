package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.*;

public final class NodeDispose extends Node {

	public NodeDispose(Node e) {
		super(e);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	@Override
	public NodeDispose clone() {
		return new NodeDispose((Node) this.get(0).clone());
	}

	@Override
	public Call generateIntermediateCode() {
		NodeExp e = (NodeExp) this.get(0);
		ExpList l_exp = new ExpList(e.generateIntermediateCode(),null);
		return new Call(new Name(new LabelLocation("dispose")),l_exp);
	}
}
