package com.java.courses.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Properties;

public class HelloWorldServlet extends HttpServlet {
    private Connection connection;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<p>Hello World1<p/>");
/*
        try {
            getStudentsFromJDBC(writer, connection);
        } catch (SQLException e) {
            writer.println("<p>"+e.getMessage()+"</p>");

        } */
/*
        String str="";
        try {
            str=getStudentsFromJDBC();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        writer.print(str);
        */
        writer.println("<p>Hello World2<p/>");

        writer.println("</body>");
        writer.println("</html>");
    }


    public void getStudentsFromJDBC() throws SQLException, IOException {
        Properties properties = new Properties();
        InputStream stream = getClass().getResourceAsStream("db.properties");
        properties.load(stream);
        Connection connection = DriverManager.getConnection(properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password"));
        //writer.println("Test1");
        String sql = "select * from students";
        Statement statement = connection.createStatement();
        statement.execute(sql);
        ResultSet resultSet = statement.getResultSet();
        String str = "";
        while (resultSet.next()) {
            str += resultSet.getString("name") + ", ";
            str += resultSet.getString("surename") + ", ";
            //writer.println("<p>" + resultSet.getString("name") + "</p>");
            //writer.println("<p>" + resultSet.getString("surename") + "</p>");
            System.out.println(str);
        }
    }
}
