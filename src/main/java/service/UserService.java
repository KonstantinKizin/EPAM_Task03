package service;

import entity.User;
import service.exception.ServiceException;

import java.util.List;

public interface UserService{

    List<User> findUser(String name , String sureName) throws ServiceException;

}
