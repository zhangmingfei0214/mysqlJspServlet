package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDao;
import entity.Users;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");	
		request.setCharacterEncoding("utf-8");  
         String id = request.getParameter("id");
         String username=request.getParameter("username");  
         String password=request.getParameter("password");
         Users u=new Users();
         u.setId(id);
         u.setUsername(username);
         u.setPassword(password);
         UsersDao udao=new UsersDao(); 
         if(udao != null) {
        	 try {
				udao.addUsers(u);
			} catch (Exception e) {
				e.printStackTrace();
			}
        	 System.out.println("注册成功");
     		request.getRequestDispatcher("/register_success.jsp").forward(request, response);
         }
       
	}

}
