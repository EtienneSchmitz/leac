package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.*;
import ubordeaux.deptinfo.compilation.project.main.Operator;
import ubordeaux.deptinfo.compilation.project.main.Relation_Operator;

public final class NodeIf extends Node {

	public NodeIf(Node boolExp, Node stm) {
		super(boolExp, stm);
	}

	public NodeIf(Node e, Node stm1, Node stm2) {
		super(e, stm1, stm2);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	@Override
	public NodeIf clone() {
		Node expNode = this.getExpNode();
		Node thenNode = this.getThenNode();
		Node elseNode = this.getElseNode();
		if (elseNode == null)
			return new NodeIf((Node) expNode.clone(), (Node) thenNode.clone());
		else
			return new NodeIf((Node) expNode, (Node) thenNode.clone(), (Node) elseNode.clone());
	}

	private Node getExpNode() {
		return this.get(0);
	}

	private Node getElseNode() {
		if (this.size() == 3)
			return this.get(2);
		else
			return null;
	}

	private Node getThenNode() {
		return this.get(1);
	}

	@Override
	public IntermediateCode generateIntermediateCode() {
		// Generate intermediate code of the operator, then and else.
		Exp e = ((NodeRel) this.getExpNode()).generateIntermediateCode();

		Stm stm_then = (Stm) this.getThenNode().generateIntermediateCode();


		// Create the Label Location.
		LabelLocation lb_true = new LabelLocation(), lb_false = new LabelLocation(), lb_continue = new LabelLocation();

		// Create the conditional ( operator is equal to true ?)
		Cjump conditional_test = new Cjump(Relation_Operator.EQ, e, new Const(1), lb_true, lb_false);

		Stm stm_else = null;
		if(this.getElseNode() != null) {
			stm_else = (Stm) this.getElseNode().generateIntermediateCode();

			Seq st_else = new Seq(new Label(lb_false), new Seq(stm_else, new Label(lb_continue)));
			Seq st_then_else  = new Seq(new Label(lb_true), new Seq(stm_then, new Seq(new Jump(lb_continue), st_else)));
			// Return the sequence.
			return new Seq(conditional_test, st_then_else);
		} else {
			Seq st_then = new Seq(new Label(lb_true), new Seq(stm_then, new Seq(new Jump(lb_continue),  new Label(lb_continue))));

			return new Seq(conditional_test, st_then);
		}
	}
}
