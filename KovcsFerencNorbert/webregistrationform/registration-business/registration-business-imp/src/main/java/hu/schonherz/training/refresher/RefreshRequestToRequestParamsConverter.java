package hu.schonherz.training.refresher;

import java.util.Arrays;

import hu.schonherz.training.exception.ViolationException;
import hu.schonherz.training.refresher.rules.LengthNumberIsNegativeNumberValidationRule;
import hu.schonherz.training.refresher.rules.OrderColumnNameValidatorRule;
import hu.schonherz.training.refresher.rules.OrderTypeValidatorRule;
import hu.schonherz.training.refresher.rules.StartNumberisNegativeValidationRule;
import hu.schonherz.training.registration.Converter;
import hu.schonherz.training.validation.RuleValidator;

public class RefreshRequestToRequestParamsConverter implements Converter<RefreshParams> {

	RefreshRequest request;

	public RefreshRequestToRequestParamsConverter(RefreshRequest request) {
		this.request = request;
	}

	@Override
	public RefreshParams convert() throws ViolationException {

		RuleValidator<RefreshRequest> validator = new RuleValidator<RefreshRequest>(
				Arrays.asList(new LengthNumberIsNegativeNumberValidationRule(), new OrderColumnNameValidatorRule(),
						new OrderTypeValidatorRule(), new StartNumberisNegativeValidationRule()));

		validator.validate(request);
		
		return new RefreshParams(request.getStart(), request.getLength(), request.getSearchExpression(),
				request.getOrderBy(), request.getOrderType());
	}

}
