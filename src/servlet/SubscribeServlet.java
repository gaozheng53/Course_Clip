package servlet;
//written by Tianrou

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SubscribeDAO;

/**
 * Servlet implementation class Subscribe
 */
@WebServlet("/subscribe.do")
public class SubscribeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubscribeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//fetch userid and username from HTTP Session
		String alert = "initial message.";
		boolean isSubscribeSuccess = false;
	    HttpSession session = request.getSession(false); 
		if(session != null){
			String username = (String) session.getAttribute("username");
			Long userid = Long.parseLong(session.getAttribute("userid").toString());
			Long courseid = Long.parseLong(request.getParameter("courseId"));
			isSubscribeSuccess = SubscribeDAO.subscribe(username, userid, courseid);
			if(isSubscribeSuccess) {
				alert = "Subscribe Success!";
				System.out.println(alert);
			}else {
				alert = "You can not subscribe one course twice.";
				System.out.println(alert);
			}
			request.setAttribute("alertmessage", alert);
			//redirect to course detail page.
			String url = "course.do?id=" + courseid;
//			response.setContentType("text/html; charset=gb2312");
//			response.sendRedirect(url).forward(request, response);
			request.getRequestDispatcher(url).forward(request, response);
			return;
		}else{
			request.setAttribute("inf", "You need to log in before post your comment!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		//request.setAttribute("alertmessage", alert);
	}

}
