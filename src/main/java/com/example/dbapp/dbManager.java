package com.example.dbapp;

import org.springframework.stereotype.Component;

import java.sql.*;


@Component
public class dbManager {

    public Connection connection;

    public dbManager()throws SQLException{
        getConnection();
        createtabble();
    }

    public  Connection getConnection() throws SQLException {
        if(connection==null){
            connection= DriverManager.getConnection( "Jdbc:mysql:/localhost:3306/teacherdb", "root", "root");
            //
        }
        return connection;
    }

    public  void createtabble() throws SQLException  {
        String sql=" create table if not exists student_info(id INT primary key auto_increment,age INT, name VARCHAR(30))";
        Statement st=connection.createStatement();
        boolean return_value= st.execute(sql);
        System.out.println(return_value);


    }

    public void student_inf(Student s)throws SQLException{
        String sql="insert into student_info(age,name) values("+s.getAge()+",'"+s.getName()+"')";
        Statement st = connection.createStatement();
        int rows=st.executeUpdate(sql);
        System.out.println("no of rows affected "+ rows);

    }
}
