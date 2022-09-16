package userController;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userDao.UserDao;
import userDto.User;


  @WebServlet("/save")
  public class RegisterController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//.....fetching data from request
		String id = req.getParameter("myid");
		String name = req.getParameter("myname");
		String email = req.getParameter("myemail");
		String phone = req.getParameter("myphone");
		String password = req.getParameter("mypassword");
		
		//...creating user object to store all user data
		User u = new User();
		u.setId(Integer.parseInt(id));
		u.setName(name);
		u.setEmail(email);
		u.setPhone(Long.parseLong(phone));
		u.setPassword(Integer.parseInt(password));
		
		//pass the user object to data class
		UserDao dao= new UserDao();//creating Dao class project
		
		try
		{
			dao.insertUser(u);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("login_page.jsp");
		rd.forward(req, resp);
		
		
		
		
	}

}

