package org.extrahour.password;

import java.util.HashSet;
import java.util.Set;

public class ExtraPassword {

    private final Strategy strategy;

    public ExtraPassword(Strategy strategy) {
        this.strategy = strategy;
    }

    public Set<Error> validate(String password) {
        return validate(password, null);
    }

    public Set<Error> validate(String password, String repeatPassword) {
        return validate(password, repeatPassword, null);
    }

    public Set<Error> validate(String password, String repeatPassword, String[] context) {
        Set<Error> errors = new HashSet<>();
        errors.add(validatePasswordTooShort(password));
        errors.add(validatePasswordTooLong(password));

        errors.remove(null);
        return errors;
    }

    private Error validatePasswordTooShort(String password) {
        if (password == null || password.length() < strategy.getMinLength()) {
            return Error.VALUE_TOO_SHORT;
        }
        return null;
    }

    private Error validatePasswordTooLong(String password) {
        if (password != null && password.length() > strategy.getMaxLength()) {
            return Error.VALUE_TOO_LONG;
        }
        return null;
    }
}
