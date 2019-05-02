package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.*;

public final class NodeReturn extends NodeExp {

	public NodeReturn(Node e) {
		super(e);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	@Override
	public NodeReturn clone() {
		return new NodeReturn((Node) get(0).clone());
	}

	@Override
	public Exp generateIntermediateCode() {
		NodeExp e = (NodeExp) this.get(0);
		return new StmExp(new Move(new Temp(new TempValue()), e.generateIntermediateCode()));
	}
}
