package service.impl;

import dao.exception.DAOException;
import dao.DAOFactory;
import dao.UserDao;
import entity.User;
import service.exception.ServiceException;
import service.UserService;
import service.validator.Validator;
import service.validator.ValidatorFactory;

import java.util.List;

public class UserServiceImpl implements UserService {

    private DAOFactory factory = DAOFactory.getInstance();
    private UserDao userDao = factory.getUserDao();
    private ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
    private Validator validator = validatorFactory.getUserValidator();


    public List<User> findUser(String name, String sureName) throws ServiceException {

        if (!validator.validate(new String[]{name, sureName})) {
            return null;
        } else {
            try {
                return userDao.getUser(name, sureName);
            } catch (DAOException e) {
                throw new ServiceException(e);
            }
        }
    }


}
