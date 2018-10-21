package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CommentDAO;
import dao.CourseDAO;
import dao.FileDAO;
import po.Comment;
import po.Course;
import po.File;

/**
 * Servlet implementation class CourseServlet
 */

@WebServlet("/addcomment.do")
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
				
		//get comment text, courseid, coursename from comment form
		String content = req.getParameter("contentText");
		Long courseid = Long.parseLong(req.getParameter("courseId"));
		String coursename = req.getParameter("courseName");		
		
		//get current date
		String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
	    String createtime = sdf.format(cal.getTime());
	    
	    //fetch userid and username from HTTP Session
	    HttpSession session = req.getSession(false); 
		if(session != null){
			String username = (String) session.getAttribute("username");
			Long userid = Long.parseLong(session.getAttribute("userid").toString());
			CommentDAO.AddComment(courseid, userid, content, username, createtime, coursename);
			String url = "course.do?id=" + courseid;
			//req.getRequestDispatcher(url).forward(req, resp);	
			resp.setContentType("text/html; charset=gb2312");
			resp.sendRedirect(url);
		}
		else{
			req.setAttribute("inf", "You need to log in before post your comment!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
		
		
	}

}
