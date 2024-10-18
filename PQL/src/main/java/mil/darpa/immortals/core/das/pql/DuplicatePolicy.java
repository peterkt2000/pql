package mil.darpa.immortals.core.das.pql;

public enum DuplicatePolicy {

	HaltOnDuplicate,
	SearchNextUnique,
	CycleChildren,
	AllowDuplicate
}
