package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SubscribeDAO;

/**
 * Servlet implementation class UnsubscribeServlet
 */
@WebServlet("/unsubscribe.do")
public class UnsubscribeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnsubscribeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String alert = "initial message.";
		boolean isUnsubscribeSuccess = false;
	    HttpSession session = request.getSession(false);
		if(session != null){
			Long userid = Long.parseLong(session.getAttribute("userid").toString());
			Long courseid = Long.parseLong(request.getParameter("courseId"));
			isUnsubscribeSuccess = SubscribeDAO.unsubscribe(userid, courseid);
			if(isUnsubscribeSuccess) {
				alert = "Unsubscribe Success!";
				System.out.println(alert);
			}else {
				alert = "You didn't subscribe this course. Subscribe it now!";
				System.out.println(alert);
			}
			request.setAttribute("uns_alertmessage", alert);
			
			//redirect to course detail page.
			String url = "course.do?id=" + courseid;
			request.getRequestDispatcher(url).forward(request, response);
			return;
		}else{
			request.setAttribute("inf", "You need to log in before post your comment!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}

