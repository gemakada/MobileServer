/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Server;

import java.io.BufferedReader;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import static java.time.Clock.system;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;
 


public class GetFavorite extends HttpServlet {
   //private Object obj;
        @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            
                
                
                response.setContentType("text/html");
		PrintWriter out = response.getWriter();
                Connection conn = null;
                PreparedStatement pst = null;
                JSONObject obj = new JSONObject();
                JSONArray list = new JSONArray();
                JSONObject obj1 = new JSONObject();
                
            
            
                String url = "jdbc:mysql://localhost:3306/";  
                String dbName = "test";  
                String driver = "com.mysql.jdbc.Driver";  
                String userName = "root";  
                String password = "";
            
            
                try{
		Class.forName(driver).newInstance();  
                conn = DriverManager  
                    .getConnection(url + dbName, userName, password);  
                pst = conn  
                    .prepareStatement("select Name,latitude,longitude from favorites ");
		
                    System.out.println(url);
                    ResultSet rs = pst.executeQuery();
                    
                    
                
		
                    while(rs.next()){
                
                    String name = rs.getString(1);
                    String lat = rs.getString(2);
                    String lng = rs.getString(3);
               
  
                    obj.put("name", name);
                    obj.put("lat", lat);
                    obj.put("lng", lng);
                    list.add(obj.clone());
                    
                
                
                    }
                    
                    
                    
                    obj1.put("places",list);
                    
                    response.setContentType("application/json");
            
                    
                    out.print(obj1);
                    
                    out.flush();
                    
                    
                    
		
		
		//out.print("faneite paralies ...");
                
                } catch (Exception e)   {
              
                 System.out.println(e);
                }
            
        
         }
       
}
