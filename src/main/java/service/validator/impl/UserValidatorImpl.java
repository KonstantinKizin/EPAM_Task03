package service.validator.impl;

import service.validator.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserValidatorImpl implements Validator {

    private  String NAME;
    private  String SURE_NAME;
    private final String CORRECT_NAME_REG_EX = "[a-zA-Z]{1,}";
    private final Pattern p1 = Pattern.compile(CORRECT_NAME_REG_EX);
    private final int INDEX_OF_NAME = 0;
    private final int INDEX_OF_SURENAME = 1;

    public UserValidatorImpl(){
    }

    public String getNAME() {
        return NAME;
    }

    public String getSURE_NAME() {
        return SURE_NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setSURE_NAME(String SURE_NAME) {
        this.SURE_NAME = SURE_NAME;
    }

    @Override
    public boolean validate(Object... objects) {
        String name = (String)objects[INDEX_OF_NAME];
        String sureName = (String)objects[INDEX_OF_SURENAME];

        boolean flag = false;
        if(name.isEmpty() || sureName.isEmpty()){
            return false;
        }else{
            Matcher m1 = p1.matcher(name);
            Matcher m2 = p1.matcher(sureName);

            if(!m1.matches() || !m2.matches()){
                return false;
            }else {
                return true;
            }
        }
    }
}
