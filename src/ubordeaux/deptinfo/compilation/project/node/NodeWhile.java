package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.*;
import ubordeaux.deptinfo.compilation.project.main.Relation_Operator;

public final class NodeWhile extends Node {

	public NodeWhile(Node boolExpr, Node stm) {
		super(boolExpr, stm);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		if (!get(0).checksType())
			return false;
		if (!get(1).checksType())
			return false;
		return true;
	}

	@Override
	public NodeWhile clone() {
		return new NodeWhile((Node) this.getExp().clone(), (Node) this.getStm().clone());
	}

	private Node getStm() {
		return this.get(1);
	}

	private Node getExp() {
		return this.get(0);
	}

	@Override
	public Seq generateIntermediateCode() {
		// Create Label
		LabelLocation labelLocation_begin = new LabelLocation(), labelLocation_continue = new LabelLocation(), labelLocation_done = new LabelLocation();
		Label l_begin = new Label(labelLocation_begin), l_continue = new Label(labelLocation_continue), l_done = new Label(labelLocation_done);

		// Generate intermediate code
		Exp e = ((NodeRel) this.getExp()).generateIntermediateCode();
		Stm stm_while = (Stm) getStm().generateIntermediateCode();


		// Create Sequence
		Seq seq_done = new Seq(new Jump(labelLocation_done), l_done);

		Cjump equality = new Cjump(Relation_Operator.EQ, e,new Const(1), labelLocation_continue, labelLocation_done);
		return new Seq(l_begin, new Seq(equality, new Seq(l_continue, new Seq(stm_while, seq_done))));
	}
}
