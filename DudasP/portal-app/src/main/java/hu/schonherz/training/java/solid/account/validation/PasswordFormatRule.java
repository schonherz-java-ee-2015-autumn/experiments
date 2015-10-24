package hu.schonherz.training.java.solid.account.validation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import hu.schonherz.training.java.solid.account.AccountRegistrationRequest;
import hu.schonherz.training.java.solid.validator.Violation;
import hu.schonherz.training.java.solid.validator.rule.ValidationRule;

public class PasswordFormatRule implements ValidationRule<AccountRegistrationRequest> {

  @Override
  public List<Violation> validate(AccountRegistrationRequest object) {
    Validate.notNull(object);
    if (StringUtils.isBlank(object.getPassword())
        || object.getPassword().trim().matches("^[_A-Za-z0-9]+$")) {
      return Collections.<Violation>emptyList();
    } else {
      return Arrays
          .asList(new Violation(
              "password",
              "A valid password must be entered, please use lowercase and uppercase letters (a-z, A-Z), digits (0-9) and underscore (_) in your password."));
    }
  }

}
