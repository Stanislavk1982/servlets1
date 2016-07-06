package com.java.courses.servlets;

import java.io.IOException;
import java.sql.SQLException;

public class Test1 {
    public static void main(String[] args) {
        HelloWorldServlet helloWorldServlet = new HelloWorldServlet();
        try {
            helloWorldServlet.getStudentsFromJDBC();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
