package ubordeaux.deptinfo.compilation.project.intermediateCode;

import ubordeaux.deptinfo.compilation.project.main.Operator;

public class Binop extends Exp {
	private Operator binop;
	private Exp left, right;

	public Binop(Operator b, Exp l, Exp r) {
		super();
		binop = b;
		left = l;
		right = r;
	}

	/*
	public final static int PLUS = 0, MINUS = 1, MUL = 2, DIV = 3, AND = 4, OR = 5, LSHIFT = 6, RSHIFT = 7, ARSHIFT = 8,
			XOR = 9;
	*/
	public String toString() {
		return "Binop(" + binop.toString() + "," + left + "," + right +  ")";
	}

}
