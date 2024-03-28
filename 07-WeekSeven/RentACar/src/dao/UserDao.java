package dao;

import core.Db;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
    private final Connection connection;

    public UserDao() {
        this.connection = Db.getInstance();
    }

    public ArrayList<User> findAll(){
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM public.user";
        try  {
            ResultSet resultSet = this.connection.createStatement().executeQuery(query);
            while(resultSet.next()){
                userList.add(this.match(resultSet));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }


    public User findByLogin(String username, String password){
        User obj = null;
        String query = "SELECT * FROM public.user WHERE user_name = ? AND user_password = ?";
        try  {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                obj = this.match(resultSet);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return obj;
    }

    public User match(ResultSet resultSet) throws SQLException{
        User obj = new User();
        obj.setId(resultSet.getInt("user_id"));
        obj.setUsername(resultSet.getString("user_name"));
        obj.setPassword(resultSet.getString("user_password"));
        obj.setRole(resultSet.getString("user_role"));
        return obj;
    }

}
