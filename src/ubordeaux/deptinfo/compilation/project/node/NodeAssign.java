package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Move;
import ubordeaux.deptinfo.compilation.project.type.Type;

public final class NodeAssign extends Node {

	public NodeAssign(NodeExp lhs, NodeExp rhs) {
		super(lhs, rhs);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		if (!get(0).checksType())
			return false;
		if (!get(1).checksType())
			return false;
		Type lhsType = this.getLhs().getType();
		Type rhsType = this.getRhs().getType();
		if (lhsType == null || rhsType == null || !lhsType.equals(rhsType))
			return false;
		else
			return true;
	}

	private NodeExp getLhs() {
		return (NodeExp) this.get(0);
	};

	private NodeExp getRhs() {
		return (NodeExp) this.get(1);
	}

	@Override
	public NodeAssign clone() {
		return new NodeAssign((NodeExp) getLhs().clone(), (NodeExp) getRhs().clone());
	};

	@Override
	public Move generateIntermediateCode() {
		Exp lhs = this.getLhs().generateIntermediateCode();
		Exp rhs = this.getRhs().generateIntermediateCode();
		return new Move(lhs,rhs);
	}
}
