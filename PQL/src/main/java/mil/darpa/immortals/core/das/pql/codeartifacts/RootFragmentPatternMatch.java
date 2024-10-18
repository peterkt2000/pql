package mil.darpa.immortals.core.das.pql.codeartifacts;

import java.util.HashMap;
import java.util.Map;

import mil.darpa.immortals.core.das.pql.ContextValue;

public class RootFragmentPatternMatch {
	
	public RootFragmentPatternMatch(FragmentPatternMatch fragmentPatternMatch) {
		this.fragmentPatternMatch = fragmentPatternMatch;
	}
	
	public void addBinding(String key, ContextValue contextValue) {
		
		bindings.put(key, contextValue);
	}
	
	public ContextValue getBinding(String key) {
		return bindings.get(key);
	}
	
	public boolean containsBinding(String key) {
		return bindings.containsKey(key);
	}
		
	public FragmentPatternMatch getFragmentPatternMatch() {
		return fragmentPatternMatch;
	}

	public void setFragmentPatternMatch(FragmentPatternMatch fragmentPatternMatch) {
		this.fragmentPatternMatch = fragmentPatternMatch;
	}

	public void setBindings(Map<String, ContextValue> bindings) {
		this.bindings = bindings;
	}
	
	private FragmentPatternMatch fragmentPatternMatch = null;
	private Map<String, ContextValue> bindings = new HashMap<>();
}
