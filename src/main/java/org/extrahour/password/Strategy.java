package org.extrahour.password;

public class Strategy {

    private final int minLength;
    private final int maxLength;
    private final double dictionaryLikeness;
    private final double contextLikeness;
    private final boolean validateRepeatPassword;
    private final boolean validateContext;

    public Strategy(int minLength, int maxLength,
                    double dictionaryLikeness, double contextLikeness,
                    boolean validateRepeatPassword, boolean validateContext) {
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.dictionaryLikeness = dictionaryLikeness;
        this.contextLikeness = contextLikeness;
        this.validateRepeatPassword = validateRepeatPassword;
        this.validateContext = validateContext;
    }

    public int getMinLength() {
        return minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public double getDictionaryLikeness() {
        return dictionaryLikeness;
    }

    public double getContextLikeness() {
        return contextLikeness;
    }

    public boolean isValidateRepeatPassword() {
        return validateRepeatPassword;
    }

    public boolean isValidateContext() {
        return validateContext;
    }
}
