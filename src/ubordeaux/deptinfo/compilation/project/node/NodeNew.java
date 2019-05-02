package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Mem;

public final class NodeNew extends Node {

	public NodeNew(Node stm) {
		super(stm);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	@Override
	public NodeNew clone() {
		return new NodeNew((Node) this.get(0).clone());
	}

	@Override
	public IntermediateCode generateIntermediateCode() {
		NodeId id = (NodeId) this.get(0);

		return new Mem(id.generateIntermediateCode());
	}
}
