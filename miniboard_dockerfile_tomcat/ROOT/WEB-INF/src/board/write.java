// 23.09.25(월) JSP/Servlet

package com.test.board;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;


@WebServlet("/board/write")
public class write extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        String uri = "jdbc:mariadb://172.30.0.4:3306/webdev";
        String userid = "springdev";
        String userpw = "12345";

        Connection con = null;
        Statement stmt = null;

        String writer = request.getParameter("writer");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        String query = "insert into tbl_board (userid, writer, title, content) values " 
                    + "('jinung','" + writer + "','" + title + "','"  + content + "')";
        System.out.println("게시물 등록 SQL : " + query); 

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(uri, userid, userpw);
            stmt = con.createStatement();
            stmt.executeUpdate(query);

            if(stmt != null) stmt.close();
            if(con != null) con.close();

            response.sendRedirect("/board/list.jsp");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}