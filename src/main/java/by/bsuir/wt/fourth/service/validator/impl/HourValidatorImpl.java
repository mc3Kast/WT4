package main.java.by.bsuir.wt.fourth.service.validator.impl;

import main.java.by.bsuir.wt.fourth.service.validator.AbstractValidator;

public class HourValidatorImpl extends AbstractValidator {
    private static final String HOUR_REGEX = "^((1[0-9])|(0)|(2[0-3]))$";

    @Override
    protected String getRegex() {
        return HOUR_REGEX;
    }
}
