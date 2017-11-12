package dao.impl;
import dao.DAOException;
import dao.UserDao;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final static  String URL = "jdbc:postgresql://localhost:5432/Catalog";
    private final static  String PW = "481415";
    private final static  String LOGIN = "postgres";
    private final static String FULL_DRIVER_NAME = "org.postgresql.Driver";

    private Connection getConnection() throws DAOException {
        try{
            Class.forName(FULL_DRIVER_NAME);
            Connection connection = DriverManager.getConnection(URL,LOGIN,PW);
            return connection;
        }catch(SQLException | ClassNotFoundException e){
            throw new DAOException(e);
        }

    }


    public void insert(User user) throws DAOException {

        boolean res = false;
        final String sql = "insert into users values(?,?,?,?)";
        try(final Connection connection =  getConnection();
            final PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setString(1,user.getName());
            statement.setString(2,user.getSureName());
            statement.setString(3,user.getPhoneNumber());
            statement.setString(4,user.getEmailAdress());
            statement.executeUpdate();
        }catch (SQLException | DAOException e) {
            throw new DAOException(e);
        }
    }

    public List<User> getUser(String name, String sureName) throws DAOException {

        List<User> users = new ArrayList<>();
        final String sql = "select * from users where name= ? AND surename=?";
        try(final Connection connection =  getConnection();
            final PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setString(1,name);
            statement.setString(2,sureName);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                String userName = rs.getString("name");
                String userSureName = rs.getString("surename");
                String userPhoneNumber = rs.getString("phone_number");
                String userEmail = rs.getString("e-mail");
                User user = new User(
                        userName,
                        userSureName,
                        userPhoneNumber,
                        userEmail
                );
                users.add(user);
            }

            return users;

        }catch (SQLException | DAOException e) {
            throw new DAOException(e);
        }
    }

}
