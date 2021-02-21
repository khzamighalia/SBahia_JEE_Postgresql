/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;




import ConnectionDB.Singleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.User;
import repositories.IUserDAO;

/**
 *
 * @author Admin
 */
public class SUserDAO implements IUserDAO {
    private static SUserDAO instance;
    public SUserDAO(){
    }

    public static SUserDAO getInstance(){
        if(instance==null){
            instance = new SUserDAO();
        }
        return instance;
    }
    public void passwordValidation(String userName, String password)
        {
                boolean valid = true;
                if (password.length() > 15 || password.length() < 8)
                {
                        System.out.println("Password should be less than 15 and more than 8 characters in length.");
                        valid = false;
                }
                if (password.indexOf(userName) > -1)
                {
                        System.out.println("Password Should not be same as user name");
                        valid = false;
                }
                String upperCaseChars = "(.*[A-Z].*)";
                if (!password.matches(upperCaseChars ))
                {
                        System.out.println("Password should contain atleast one upper case alphabet");
                        valid = false;
                }
                String lowerCaseChars = "(.*[a-z].*)";
                if (!password.matches(lowerCaseChars ))
                {
                        System.out.println("Password should contain atleast one lower case alphabet");
                        valid = false;
                }
                String numbers = "(.*[0-9].*)";
                if (!password.matches(numbers ))
                {
                        System.out.println("Password should contain atleast one number.");
                        valid = false;
                }
                String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
                if (!password.matches(specialChars ))
                {
                        System.out.println("Password should contain atleast one special character");
                        valid = false;
                }
                if (valid)
                {
                        System.out.println("Password is valid.");
                }
        }


    @Override
            public User Login(String userName, String password) throws ClassNotFoundException {
                 Connection connection = null;
                 User user=null;

                try {
                    connection =Singleton.getConnection();
                    PreparedStatement st = (PreparedStatement) connection.prepareStatement("SELECT * \n" +
"	FROM public.\"User\" where username=? and passwd= ?;");

                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));

                        System.out.println("You have successfully logged in"); 
                        
                    } else {
                        System.out.println("Wrong Username & Password");  
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
                return user;
            }

            
    @Override
            public void Register(String name,String userName, String password) throws ClassNotFoundException {
                 Connection connection = null;
                 PreparedStatement st = null;

                try {
                    if(_isUserExists(userName)){
                    connection =Singleton.getConnection();
                    String query_POST = "INSERT INTO public.\"User\"(\n" +
"	 name, username, passwd, status)\n" +
"	VALUES ( ?, ?, ?, ?);";
                   st = connection.prepareStatement(query_POST,PreparedStatement.RETURN_GENERATED_KEYS);
            
                    st.setString(1, name);
                    st.setString(2, userName);
                    st.setString(3, password);
                    st.setString(4, "user");
                    st.executeUpdate();
                    ResultSet rs=st.getGeneratedKeys();
                    
                    if (rs.next()) {
                        System.out.println("You have successfully logged in"); 
                    } else {
                        System.out.println("Wrong Username & Password");  
                    }}
                } catch (SQLException sqlException) {
                }
            }
            private boolean _isUserExists(String username) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean exist = false;
          
        try {
              
            connection = Singleton.getConnection();
            String query_CHECK = "SELECT username\n" +
"	FROM public.\"User\" where username like ?;";
            statement = connection.prepareStatement(query_CHECK);
            statement.setString(1, username);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString(3).equals(username)) {
                    System.out.println("Username Already Exists ");
                    exist = true;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
        return exist;
    }

 

}
