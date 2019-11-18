package com.basic.java.util;

/**
 * @author hunter
 * @Title: JDBCUtil
 * @ProjectName spring-boot-hello-world
 * @Description: TODO
 * @date 2019/7/22 17:28
 */

import java.sql.*;

public class JDBCUtil {
    private String url;
    private String user;
    private String password;
    private String driver;



   public JDBCUtil(String url, String username, String password, String driver){
        this.url = url;
        this.user = username;
        this.password = password;
        this.driver = driver;
   }

    public Connection getConn() throws Exception{

        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;
    }
    public void close(ResultSet resultSet, PreparedStatement preparedStatement,
                             Connection connection){

        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if(preparedStatement != null ){
                preparedStatement.close();
            }
            if(connection != null ){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

}
