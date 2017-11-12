package dao;

import dao.impl.UserDaoImpl;

public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private final UserDao userDao = new UserDaoImpl();

    private DAOFactory() {}

    public UserDao getUserDao() {
        return userDao;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}
