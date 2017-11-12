package service;

import entity.User;
import java.util.List;

public interface UserService{

    List<User> findUser(String name , String sureName) throws ServiceException;

}
