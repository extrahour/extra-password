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

    public Set<Error> validate(String password, String repeat, String[] context) {
        Set<Error> errors = new HashSet<>();
        errors.add(validatePasswordTooShort(password));
        errors.add(validatePasswordTooLong(password));
        errors.add(validateRepeatPassword(password, repeat));

        errors.remove(null);
        return errors;
    }

    private Error validatePasswordTooShort(String password) {
        if (password == null || password.length() < strategy.getMinLength()) {
            return Error.TOO_SHORT;
        }
        return null;
    }

    private Error validatePasswordTooLong(String password) {
        if (password != null && password.length() > strategy.getMaxLength()) {
            return Error.TOO_LONG;
        }
        return null;
    }

    private Error validateRepeatPassword(String password, String repeat) {
        if (!strategy.isValidateRepeatPassword()) {
            return null;
        }
        if (password == null || repeat == null) {
            return Error.REPEAT_DOES_NOT_MATCH;
        }
        return password.equals(repeat) ? null : Error.REPEAT_DOES_NOT_MATCH;
    }
}
