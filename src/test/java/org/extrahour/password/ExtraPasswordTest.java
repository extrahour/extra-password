package org.extrahour.password;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ExtraPasswordTest {

    @Test
    public void validate_passwordTooShort() {
        ExtraPassword validator = new ExtraPassword(
                new StrategyBuilder()
                        .setMinLength(5)
                        .createStrategy());

        assertTrue(validator.validate(null).contains(Error.VALUE_TOO_SHORT));
        assertTrue(validator.validate("hell").contains(Error.VALUE_TOO_SHORT));
        assertFalse(validator.validate("hello").contains(Error.VALUE_TOO_SHORT));
    }

    @Test
    public void validate_passwordTooLong() {
        ExtraPassword validator = new ExtraPassword(
                new StrategyBuilder()
                        .setMaxLength(10)
                        .createStrategy());

        assertTrue(validator.validate("very very very long long").contains(Error.VALUE_TOO_LONG));
        assertFalse(validator.validate(null).contains(Error.VALUE_TOO_LONG));
        assertFalse(validator.validate("normal").contains(Error.VALUE_TOO_LONG));
    }
}
