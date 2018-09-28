package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDAO;
import dao.CourseDAO;
import dao.UserDAO;
import po.Comment;
import po.Course;
import po.User;

/**
 * Servlet implementation class UserInfo
 */
@WebServlet("/track.do")
public class TrackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String trackname = request.getParameter("name");
		List<Course> courseListbyTrack = CourseDAO.displayCoursebyTrack(trackname);		
		if(courseListbyTrack.size() > 0){
			log(""+courseListbyTrack.get(0).getName()); 
			String text = "msg";
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(text);
			//String json = new Gson().toJson(courseListbyTrack);
			//response.getWriter().write(json);
		}
		else{
//			response.setContentType("text/plain");
//			response.setCharacterEncoding("UTF-8");
//			response.getWriter().write("notfound");
			response.setCharacterEncoding("utf-8");		
			PrintWriter out = response.getWriter();		
			out.print("xixi");		
			out.flush();		
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
