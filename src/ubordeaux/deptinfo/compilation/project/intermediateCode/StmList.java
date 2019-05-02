package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class StmList extends Stm {
	private Stm head;
	private StmList tail;

	public StmList(Stm head, StmList tail) {
		super();
		this.head = head;
		this.tail = tail;
	}

	@Override
	public String toString() {
		if(tail == null) {
			return "StmList(" +  head  + ")";
		}
		return "StmList(" +  head + "," +  tail.toString() + ")";
	}
}
