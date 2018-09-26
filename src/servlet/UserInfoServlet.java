package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDAO;
import dao.UserDAO;
import po.Comment;
import po.User;

/**
 * Servlet implementation class UserInfo
 */
@WebServlet("/userinfo.do")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = UserDAO.getUserInfo(Long.parseLong(request.getParameter("id")));
		List<Comment> comments = CommentDAO.CommentListById(Long.parseLong(request.getParameter("id")));
		if(user == null || comments == null) {
			request.getRequestDispatcher("ERROR.jsp").forward(request, response);
			return;
		}
		request.setAttribute("user", user);
		request.setAttribute("commentList", comments);
		request.getRequestDispatcher("profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
