package userController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userDao.UserDao;
import userDto.User;


@WebServlet("/getUser")
public class DisplayServlet extends HttpServlet {

		
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException ,IOException {
	
		HttpSession session = req.getSession(false);//telling  the server to use old session n to stop creating new one 
		String uname =(String)session.getAttribute("name");
		
		UserDao dao = new UserDao();
		//passing name to dao class
		try
		{
			User u = dao.displayUser(uname);
			//setting user object to request
			req.setAttribute("user",u);
			
			RequestDispatcher rd = req.getRequestDispatcher("view.jsp");
			rd.forward(req,resp);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
