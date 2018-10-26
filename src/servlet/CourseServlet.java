package servlet;

import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;
import dao.FileDAO;
import po.Comment;
import po.Course;
import po.UploadDetail;

/**
 * Servlet implementation class CourseServlet
 */

@WebServlet("/course.do")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long course_id = Long.parseLong(request.getParameter("id"));
		Course course = CourseDAO.getCourseDetail(course_id);
		List<String[]> professorList = CourseDAO.getProfessorList(course_id);
		List<Comment> comments = CourseDAO.getCommentsList(Long.parseLong(request.getParameter("id")));
	
		/*
		//display all the files
		String applicationPath = getServletContext().getRealPath("");
		String UPLOAD_DIR = "uploadfile";		
		String uploadFilePath = applicationPath + UPLOAD_DIR;
		File fileUploadDirectory = new File(uploadFilePath);

		UploadDetail details = null;
		File[] allFiles = fileUploadDirectory.listFiles();
		List<UploadDetail> fileList = new ArrayList<UploadDetail>(); 
		
		for (File file : allFiles) {
			details = new UploadDetail();
			details.setFileName(file.getName());
			details.setFileSize(file.length() / 1024);
			fileList.add(details);
		}
		*/

		if(course == null || comments == null) {
			request.getRequestDispatcher("ERROR.jsp").forward(request, response);
		}
		request.setAttribute("course", course);
		request.setAttribute("professorList", professorList);
		request.setAttribute("commentList", comments);
		
		//request.setAttribute("uploadedFiles", fileList);
		
		request.getRequestDispatcher("courseDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
