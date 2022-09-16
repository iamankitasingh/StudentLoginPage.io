package userController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userDao.UserDao;
import userDto.User;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException , IOException
	{
		resp.setContentType("text/html");
		
	String email = req.getParameter("myemail");
	String password = req.getParameter("mypassword");
	
	//passing string value to integer
	int pwd = Integer.parseInt(password);
	
	UserDao dao = new UserDao();
	try
	{
		User u =dao.validate(email,pwd);
		if(u!=null)
		{
			HttpSession session = req.getSession();
			session.setAttribute("name", u.getName());
			
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			rd.forward(req, resp);
		}
		else
		{
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			PrintWriter pw = resp.getWriter();
			pw.print("invalid username and password");
			
			rd.include(req, resp);
		}
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	}
}
