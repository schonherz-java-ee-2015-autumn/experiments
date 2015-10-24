package hu.schonherz.training.java.solid.account.validation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import hu.schonherz.training.java.solid.account.AccountRegistrationRequest;
import hu.schonherz.training.java.solid.validator.Violation;
import hu.schonherz.training.java.solid.validator.rule.ValidationRule;

public class EmailFormatRule implements ValidationRule<AccountRegistrationRequest> {

  @Override
  public List<Violation> validate(AccountRegistrationRequest object) {
    Validate.notNull(object);
    return StringUtils.isBlank(object.getEmail())
        || object
            .getEmail()
            .trim()
            .matches(
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$") ? Collections
        .<Violation>emptyList() : Arrays.asList(new Violation("email",
        "A valid email address must be entered"));
  }

}
