package hu.schonherz.training.java.solid.account.validation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import hu.dupetya.common.account.AccountRegistrationRequest;
import hu.schonherz.training.java.solid.validator.Violation;
import hu.schonherz.training.java.solid.validator.rule.ValidationRule;

public class PasswordAndConfirmationAreEqualRule implements
    ValidationRule<AccountRegistrationRequest> {

  @Override
  public List<Violation> validate(AccountRegistrationRequest object) {
    Validate.notNull(object);
    return StringUtils.equals(object.getPassword(), object.getPasswordConfirmation()) ? Collections
        .<Violation>emptyList() : Arrays.asList(new Violation("passwordConfirmation",
        "Password confirmation must match the password entered"));
  }

}
