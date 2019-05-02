package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.*;

import java.util.Iterator;

public final class NodeList extends Node {

	public NodeList(Node stm) {
		super(stm);
	}

	public NodeList() {
		super();
	}

	@Override
	public boolean checksType() {
		super.checksType();
		boolean result = true;
		for (Node elt : this.elts) {
			if (elt != null && !elt.checksType()) {
				result = false;
				break;
			}
		}
		return result;
	}

	public Iterator<Node> iterator() {
		return this.elts.iterator();
	}

	public int size() {
		return this.elts.size();
	}

	@Override
	public NodeList clone() {
		NodeList node = new NodeList();
		for (Node elt : this.elts) {
			node.add((Node) elt.clone());
		}
		return node;
	}

	@Override
	public StmList generateIntermediateCode() {
		StmList stm_list = null;
		for(Node elt: this.elts) {
			IntermediateCode result = elt.generateIntermediateCode();
			if(result instanceof Exp) {
				stm_list = new StmList(new ExpStm((Exp) result), stm_list);
			} else if (result instanceof Stm) {
				stm_list = new StmList((Stm) result, stm_list);
			}
		}

		return stm_list;
	}
}
