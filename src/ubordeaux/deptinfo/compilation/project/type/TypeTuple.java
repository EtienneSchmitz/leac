package ubordeaux.deptinfo.compilation.project.type;

import java.util.Iterator;
import java.util.Vector;

// Type servant à la fois pour les arguments d'une fonction et pour les termes d'une liste
public class TypeTuple extends TypeComplex {

	public TypeTuple() {
		super();
	}

	public TypeTuple(Type t) {
		super(t);
	}

	public TypeTuple(Type... ts) {
		super(ts);
	}

	public TypeTuple(Vector<Type> componant) {
		super(componant);
	}

	public Boolean attestAllEqual() {
		Type t = get(0);
		for (Type o : component)
			if (!t.equals(o)) {
				return false;
			}
		return true;
	}

	@Override
	public boolean attestWellFormed() {
		return true;
	}

	@Override
	public String toString() {
		String str = "(";
		boolean first = true;
		for (Type t : component) {
			if (first)
				first = false;
			else
				str += ", ";
			str += t;
		}
		str += ")";
		return str;
	}

	@Override
	public TypeTuple clone() {
		Vector<Type> componant = new Vector<Type>();
		for (Type t : this.component)
			componant.add((Type) t.clone());
		return new TypeTuple(componant);
	}

	public Iterator<Type> iterator() {
		return component.iterator();
	}

	public int size() {
		return this.component.size();
	}

}
