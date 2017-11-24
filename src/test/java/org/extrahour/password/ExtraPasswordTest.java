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

        assertTrue(validator.validate(null).contains(Error.TOO_SHORT));
        assertTrue(validator.validate("hell").contains(Error.TOO_SHORT));
        assertFalse(validator.validate("hello").contains(Error.TOO_SHORT));
    }

    @Test
    public void validate_passwordTooLong() {
        ExtraPassword validator = new ExtraPassword(
                new StrategyBuilder()
                        .setMaxLength(10)
                        .createStrategy());

        assertTrue(validator.validate("very very very long long").contains(Error.TOO_LONG));
        assertFalse(validator.validate(null).contains(Error.TOO_LONG));
        assertFalse(validator.validate("normal").contains(Error.TOO_LONG));
    }

    @Test
    public void validate_repeatPasswordWhenEnabled() {
        ExtraPassword validator = new ExtraPassword(
                new StrategyBuilder()
                        .setValidateRepeatPassword(true)
                        .createStrategy());

        assertTrue(validator.validate("secret string", "secret").contains(Error.REPEAT_DOES_NOT_MATCH));
        assertTrue(validator.validate("secret string", null).contains(Error.REPEAT_DOES_NOT_MATCH));
        assertTrue(validator.validate(null, "secret").contains(Error.REPEAT_DOES_NOT_MATCH));
        assertTrue(validator.validate(null, null).contains(Error.REPEAT_DOES_NOT_MATCH));
        assertFalse(validator.validate("secret string", "secret string").contains(Error.REPEAT_DOES_NOT_MATCH));
    }

    @Test
    public void validate_repeatPasswordWhenDisabled() {
        ExtraPassword validator = new ExtraPassword(
                new StrategyBuilder()
                        .setValidateRepeatPassword(false)
                        .createStrategy());

        assertFalse(validator.validate("secret string", "secret").contains(Error.REPEAT_DOES_NOT_MATCH));
        assertFalse(validator.validate("secret string", null).contains(Error.REPEAT_DOES_NOT_MATCH));
        assertFalse(validator.validate(null, "secret").contains(Error.REPEAT_DOES_NOT_MATCH));
        assertFalse(validator.validate(null, null).contains(Error.REPEAT_DOES_NOT_MATCH));
        assertFalse(validator.validate("secret string", "secret string").contains(Error.REPEAT_DOES_NOT_MATCH));
    }
}
