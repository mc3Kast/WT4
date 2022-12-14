package main.java.by.bsuir.wt.fourth.service.validator.impl;

import main.java.by.bsuir.wt.fourth.service.validator.AbstractValidator;

public class YearValidatorImpl extends AbstractValidator {
    private static final String YEAR_REGEX = "^[0-9]{4}$";

    @Override
    protected String getRegex() {
        return YEAR_REGEX;
    }
}
