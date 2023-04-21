package app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.google.protobuf.Descriptors.GenericDescriptor;

@WebServlet("/students")
public class ServletStoreUserData extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String yop = req.getParameter("yop");
		
		System.out.println("ID "+id);
		System.out.println("NAME "+name);
		System.out.println("AGE "+age);
		System.out.println("YOP "+yop);
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","admin","Password@123");
			PreparedStatement ps = con.prepareStatement("insert into Students(ID,NAME,AGE,YOP) values(?,?,?,?)") ;
			int id1 = Integer.parseInt(id);
			int age1 = Integer.parseInt(age);
			int yop1 = Integer.parseInt(yop);
			
			ps.setInt(1,id1);
			ps.setString(2,name);
			ps.setInt(3,age1);
			ps.setInt(4,yop1);
			ps.execute();
			
			System.out.println("Data Successfully inserted into table.");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		
		System.out.println("Good Evening");
		
		
	}

}
