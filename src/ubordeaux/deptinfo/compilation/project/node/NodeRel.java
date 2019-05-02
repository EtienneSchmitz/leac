package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.*;
import ubordeaux.deptinfo.compilation.project.main.Relation_Operator;
import ubordeaux.deptinfo.compilation.project.type.TypeBoolean;
import ubordeaux.deptinfo.compilation.project.type.TypeInt;

public class NodeRel extends NodeExp {

	protected Relation_Operator operator;

	// Relation binaire
	// f : E X F -> {0,1}
	public NodeRel(Relation_Operator op, Node op1, Node op2) {
		super(op1, op2);
		this.operator = op;
		this.type = new TypeBoolean();
	}
	public NodeRel(Relation_Operator op, Node op1) {
		super(new NodeLiteral(new TypeInt(0), 0), op1);
		this.operator = op;
		this.type = new TypeBoolean();
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return (this.getOp1().getType() instanceof TypeInt) && (this.getOp2().getType() instanceof TypeInt);
	}

	private NodeExp getOp1() {
		return (NodeExp) this.get(0);
	};

	private NodeExp getOp2() {
		return (NodeExp) this.get(1);
	}

	@Override
	public NodeRel clone() {
		return new NodeRel(this.operator, (Node) getOp1().clone(), (Node) getOp2().clone());
	};

	@Override
	public Exp generateIntermediateCode() {

	    // Generate intermediate code of the left / right operator.
		Exp op_left = this.getOp1().generateIntermediateCode();
		Exp op_right = this.getOp2().generateIntermediateCode();

		// Create the modular code.
		LabelLocation lb_true = new LabelLocation(), lb_false = new LabelLocation(), lb_continue = new LabelLocation();

		// Create the all sequence to modularize the code.
		Cjump cond_expr = new Cjump(operator, op_left, op_right, lb_true, lb_false);
		Jump j_continue = new Jump(lb_continue);

		TempValue tmp_value = new TempValue();
		Temp tmp = new Temp(tmp_value);
		Move m_true = new Move(tmp, new Const(1));
		Move m_false = new Move(tmp, new Const(0));

		Seq seq_false = new Seq(new Label(lb_false), new Seq(m_false, new Label(lb_continue)));
		Seq seq_true =  new Seq(new Label(lb_true), new Seq(m_true, new Seq(j_continue, seq_false)));
		Seq seq_general = new Seq(cond_expr,seq_true);

		return new Eseq(seq_general, tmp);
	}

}
