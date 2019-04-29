package ubordeaux.deptinfo.compilation.project.environment;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Environment<KEY, VALUE> {
	private Map<KEY, VALUE> map;
	
	public Environment() {
		map = new HashMap<>();
	}
	
	public void add(KEY name, VALUE value) {
		System.out.println("Add to env : " + name + " --> " + value);
		map.put(name, value);
	}
	
	public VALUE get(KEY name) {
		return map.get(name);
	}
	
	public void clear() {
		map.clear();
	}
	
	public Collection<Map.Entry<KEY, VALUE>> getAll() {
		return map.entrySet();
	}
}
