package ubordeaux.deptinfo.compilation.project.type;

import java.util.Vector;

// Tout type qui compose d'autres types
public abstract class TypeComplex extends Type {

	protected Vector<Type> component;

	public TypeComplex() {
		super();
		this.component = new Vector<Type>();
	}

	public TypeComplex(Vector<Type> componant) {
		super();
		this.component = componant;
	}

	public TypeComplex(Type... ts) {
		this();
		addAll(ts);
	}

	public void add(Type t) {
		this.component.add(t);
	}

	public void addAll(Type... ts) {
		for (Type t : ts)
			this.component.add(t);
	}

	public Type get(int n) {
		return component.get(n);
	}

	@Override
	public boolean equals(Type obj) {
		// System.out.println("EQ" + this + " = " + obj);
		if (this.getClass() != obj.getClass())
			return false;
		if (!(obj instanceof TypeComplex))
			return false;
		TypeComplex real_t = (TypeComplex) obj;
		if (component.size() != real_t.component.size())
			return false;
		for (int i = 0; i < component.size(); ++i)
			if (!component.get(i).equals(real_t.component.get(i)))
				return false;
		return true;
	}

	public int size() {
		return component.size();
	}

	@Override
	public Type mapping(Subst subst) {
		Vector<Type> clone = new Vector<Type>();
		for (Type t : component)
			clone.add(t.mapping(subst));
		component = clone;
		return this;
	}

	@Override
	public String toString() {
		String ret = this.getClass().getSimpleName();
		if (this.component.size() > 0)
			ret += '(';
		boolean first = true;
		for (Type elt : this.component) {
			if (first)
				first = false;
			else
				ret += ", ";
			ret += elt.toString();
		}
		if (this.component.size() > 0)
			ret += ')';
		return ret;
	}

	public void set(int i, Type type) {
		this.component.set(i, type);
	}

}
