package hu.schonherz.training.exception;

import java.util.List;

public class ViolationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
