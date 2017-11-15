package service;

import entity.User;
import org.w3c.dom.NodeList;
import service.exception.ServiceException;

import javax.swing.text.Document;
import java.util.List;
import java.util.Map;

public interface UserService extends Service{

    List<User> findUser(String name , String sureName) throws ServiceException;

}
