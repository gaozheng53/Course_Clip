package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;
import dao.TeachDAO;
import po.Course;

@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] professoresName = request.getParameterValues("professorName");
		String[] professoresLink = request.getParameterValues("professorLink");
		System.out.println(professoresName.length);
		// 获取到前台的属性，赋值到新对象，执行update
		Course course = new Course();
		course.setId(Long.parseLong(request.getParameter("id")));
		course.setName(request.getParameter("name"));
		course.setDescription(request.getParameter("description"));
		course.setTrack(request.getParameter("track"));
		course.setNumber(Long.parseLong(request.getParameter("number")));
		CourseDAO.EditCourse(course);
		// update teach
		// 封装成po
		TeachDAO.clear(Long.parseLong(request.getParameter("id"))); 
		for(int i = 0; i < professoresName.length; i++) {
			System.out.println(professoresName[i]+"   "+professoresLink[i]);
			TeachDAO.add(course.getId(), professoresName[i], professoresLink[i]);
		}
		List<Course> courseList = CourseDAO.displayCourses();
		request.setAttribute("courseList", courseList);
		request.getRequestDispatcher("manage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
