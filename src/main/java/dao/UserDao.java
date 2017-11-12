package dao;

import entity.User;

import java.util.List;

public interface UserDao {

    void insert(User user) throws DAOException;

    List<User> getUser(String name , String sureName) throws DAOException;







}
