package org.extrahour.password;

public class StrategyBuilder {
    private int minLength = 6;
    private int maxLength = Integer.MAX_VALUE;
    private double dictionaryLikeness = 0.8;
    private double contextLikeness = 0.8;
    private boolean validateRepeatPassword = true;
    private boolean validateContext = true;

    public StrategyBuilder setMinLength(int minLength) {
        this.minLength = minLength;
        return this;
    }

    public StrategyBuilder setMaxLength(int maxLength) {
        this.maxLength = maxLength;
        return this;
    }

    public StrategyBuilder setDictionaryLikeness(double dictionaryLikeness) {
        this.dictionaryLikeness = dictionaryLikeness;
        return this;
    }

    public StrategyBuilder setContextLikeness(double contextLikeness) {
        this.contextLikeness = contextLikeness;
        return this;
    }

    public StrategyBuilder setValidateRepeatPassword(boolean validateRepeatPassword) {
        this.validateRepeatPassword = validateRepeatPassword;
        return this;
    }

    public StrategyBuilder setValidateContext(boolean validateContext) {
        this.validateContext = validateContext;
        return this;
    }

    public Strategy createStrategy() {
        return new Strategy(minLength, maxLength, dictionaryLikeness, contextLikeness, validateRepeatPassword, validateContext);
    }
}