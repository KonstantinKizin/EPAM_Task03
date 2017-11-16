package service;

import entity.User;
import service.exception.ServiceException;
import java.util.List;

public interface UserService extends Service{

    List<User> findUser(String name , String sureName) throws ServiceException;

}
