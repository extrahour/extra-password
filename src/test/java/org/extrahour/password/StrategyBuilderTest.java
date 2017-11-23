package org.extrahour.password;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StrategyBuilderTest {

    @Test
    public void testSetsFieldsCorrectly() {
        Strategy strategy = new StrategyBuilder()
                .setMinLength(1)
                .setMaxLength(10)
                .setDictionaryLikeness(0.5)
                .setStopOnFirstFailure(true)
                .createStrategy();

        assertEquals(1, strategy.getMinLength());
        assertEquals(10, strategy.getMaxLength());
        assertEquals(0.5, strategy.getDictionaryLikeness(), 0);
        assertEquals(true, strategy.isStopOnFirstFailure());
    }
}
