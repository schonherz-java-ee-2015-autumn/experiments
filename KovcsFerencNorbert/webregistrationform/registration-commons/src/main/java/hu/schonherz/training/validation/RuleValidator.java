package hu.schonherz.training.validation;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;

import hu.schonherz.training.exception.Violation;
import hu.schonherz.training.exception.ViolationException;

public class RuleValidator<T> {

	List<Validator<T>> rules;

	public RuleValidator(List<Validator<T>> rules) {
		Validate.notNull(rules);
		Validate.noNullElements(rules);
		this.rules = rules;
	}
	
	public void validate(T object) throws ViolationException{
		Validate.notNull(object);
		
		List<Violation> violations = new ArrayList<Violation>();
		for (Validator<T> rule:rules){
			violations.addAll(rule.validate(object));
		}
		
		if (!violations.isEmpty()){
			throw new ViolationException(violations);
		}
		
	}

}
