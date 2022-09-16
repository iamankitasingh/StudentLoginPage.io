package userDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import userDto.User;


public class UserDao {
	
		public Connection getConnection() throws ClassNotFoundException, SQLException
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_jsp_login_project","root","root");
			return con;
		}
		
		public void insertUser(User user)  throws ClassNotFoundException, SQLException
		{
			PreparedStatement ps = getConnection().prepareStatement("insert into user values(?,?,?,?,?)");
			ps.setInt(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3,user.getEmail());
			ps.setLong(4,user.getPhone());
			ps.setInt(5 ,user.getPassword());
			
			ps.execute();
		}
	
		public User validate(String email,int pwd) throws ClassNotFoundException, SQLException
		{
			PreparedStatement ps = getConnection().prepareStatement("select * from  user where Email=? and Password=?");
			ps.setString(1, email);
			ps.setInt(2, pwd);
			
			ResultSet rs =ps.executeQuery();
			
			while(rs.next())
			{
				User u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPhone(rs.getLong(4));
				u.setPassword(rs.getInt(5));
				
				return u;
			}
			return null;
			}
		
		public User displayUser(String name) throws ClassNotFoundException, SQLException
		{
			PreparedStatement ps = getConnection().prepareStatement("select * from user where name=?");
			ps.setString(1, name);
			

			ResultSet rs =ps.executeQuery();
			
			while(rs.next())
			{
				User u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPhone(rs.getLong(4));
				u.setPassword(rs.getInt(5));
				
				return u;
			}
			return null;
			
		}
			
		}

