package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UsersDao;
import entity.Users;


/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Users u = new Users();
		u.setUsername(username);
		u.setPassword(password);
		
		UsersDao udao = new UsersDao();
		Users user = null;
		try {
			user = udao.login(username, password);
			System.out.println(username);
			System.out.println(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(user!=null){
			request.getRequestDispatcher("/login_success.jsp").forward(request, response);;
		}else{
			request.getRequestDispatcher("/login_error.jsp").forward(request, response);
		}

		
	}
}
