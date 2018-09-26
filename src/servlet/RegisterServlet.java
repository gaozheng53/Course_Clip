package servlet;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*

注册是从注册界面得到username和password，再通过dao层中registe()来向数据库添加一条用户

*/

import dao.UserDAO;
@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet{
@Override

 //doGet方法自动跳转到doPost()方法
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
this.doPost(req, resp);   // avoid error 405
}
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  req.setCharacterEncoding("utf-8");//设置编码格式为utf-8
  String username=req.getParameter("username");//从注册界面获得username
  String password=req.getParameter("password");//从注册界面获得password
  String email=req.getParameter("email");//从注册界面获得password
  String registerRes = UserDAO.register(username, password,email);            //dao层中向数据库添加数据
  if("Register success" == registerRes) {
	  // Register successfully
	  System.out.println("Register successfully");
	  req.getRequestDispatcher("login.jsp").forward(req, resp); //重新跳转到登录界面
  }else {
	  // 处理register返回的错误信息给前端
	  // email/username has been used
	  req.setAttribute("message", registerRes); 
	  req.getRequestDispatcher("register.jsp").forward(req, resp);
  }
  
}
}

