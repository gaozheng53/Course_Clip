package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;
import dao.UserDAO;
import po.Course;

/*

登录界面是从登录界面获得username和password，再通过dao层中的checkLogin()来判断是否登录

*/
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	@Override

	// doGet方法自动跳转到doPost()方法
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override

	// doGet方法判断从jsp传过来的username和password是否和数据库中的对应，如果对应，则跳转到欢迎界面，如果不对应，则返回登录界面
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");// 设置编码格式为utf-8
		String username = req.getParameter("username");// 从jsp中获取usernmae
		String password = req.getParameter("password");// 从jsp中获取password
		if (UserDAO.checkLogin(username, password)) { // dao层中判断，如果为true，跳转到欢迎界面
			req.getSession().setAttribute("username", username);
			req.getRequestDispatcher("/homepage.do").forward(req, resp);
		} else { // 如果为false，跳转到登录界面，并返回错误信息.
			req.setAttribute("inf", "你的账号或密码错误，请重新登录");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}

	}
}
