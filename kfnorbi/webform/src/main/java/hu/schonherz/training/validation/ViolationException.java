package hu.schonherz.training.validation;

import java.util.List;

public class ViolationException extends Exception {

	List<Violation> violations;

	public ViolationException(List<Violation> violations) {
		super();
		this.violations = violations;
	}

	/**
	 * @return the violations
	 */
	public List<Violation> getViolations() {
		return violations;
	}

}
