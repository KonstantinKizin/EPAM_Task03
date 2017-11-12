package service.validator;

import service.validator.impl.UserValidatorImpl;

public class ValidatorFactory {

    private static final ValidatorFactory instance = new ValidatorFactory();

    private final Validator userValidator = new UserValidatorImpl();

    private ValidatorFactory() {}

    public Validator getUserValidator() {

        return userValidator;
    }

    public static ValidatorFactory getInstance() {
        return instance;
    }
}
