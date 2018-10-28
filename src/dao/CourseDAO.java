package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import po.Comment;
import po.Course;
import util.DBHelper;

//  Display the list of courses sorted by NO. of course	
public class CourseDAO {

	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public static List<Course> displayCourses() {
		List<Course> res = new LinkedList<>(); 
		con = DBHelper.getConnection();
		String sql = "select * from course order by course_number";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			int i = 0;
			while (rs.next()) {
				Course course=new Course();  
				course.setId(rs.getLong("course_id"));  
				course.setName(rs.getString("course_name"));
				course.setDescription(rs.getString("description")); 
				course.setNumber(rs.getLong("course_number")); 
				course.setCommentNum(rs.getLong("comment_number"));
				course.setTrack(rs.getString("track"));  
                res.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ps = null;
			}
		}
		return res;
	}

	public static Course getCourseDetail(Long courseId) {
		Course course = new Course(); 
		con = DBHelper.getConnection();
		String sql = "select * from course where course_id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, courseId);
			rs = ps.executeQuery();
			if (rs.next()) {  
				course.setId(rs.getLong("course_id"));  
				course.setName(rs.getString("course_name"));  
				course.setDescription(rs.getString("description")); 
				course.setNumber(rs.getLong("course_number")); 
				course.setCommentNum(rs.getLong("comment_number"));
				course.setTrack(rs.getString("track"));
                return course; 
			}else {
				// no such course
				return null;
			}
			// todo: sort by course number
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				ps = null;
			}
		}
		return course;
	}
	
	public static Course addCourse(Course course) {
		con = DBHelper.getConnection();
		String sql = "INSERT INTO course (course_name,course_number,description,track,comment_number) VALUES (?, ?, ?, ?,0)";
		int re;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, course.getName());
			ps.setLong(2, course.getNumber());
			ps.setString(3, course.getDescription());
			ps.setString(4, course.getTrack());
			
			re = ps.executeUpdate();
			if (re == 0) {
				System.out.println("Insert failed");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				ps = null;
			}
		}
		return course;
	}
	
	public static void EditCourse(Course course) {
		con = DBHelper.getConnection();
		String sql = "UPDATE course SET course_name = ?, course_number = ?, description = ?, track= ? WHERE course_id = ?";
		int re;
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(5, course.getId());
			ps.setString(1, course.getName());
			ps.setLong(2, course.getNumber());
			ps.setString(3, course.getDescription());
			ps.setString(4, course.getTrack());
			
			re = ps.executeUpdate();
			if (re == 0) {
				System.out.println("Update failed");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				ps = null;
			}
		}
	}
	
	public static void DeleteCourse(Long courseId) {
		con = DBHelper.getConnection();
		String sql = "delete from course where course_id = ?";
		int re;
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, courseId);
			re = ps.executeUpdate();
			if (re == 0) {
				System.out.println("Delete failed");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				ps = null;
			}
		}
	}
	
	public static boolean checkUniqueByName(Long courseId, String courseName){
		con = DBHelper.getConnection();
		String sql = "select * from course where course_id != ? and course_name = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, courseId);
			ps.setString(2, courseName);
			rs = ps.executeQuery();
			if (rs.next()) {
				// not unique
				return false;
			}else {
				// no such course
				return true;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				ps = null;
			}
		}
		return true;		
	}
	
	public static boolean checkUniqueByNumber(Long courseId, Long courseNumber){
		con = DBHelper.getConnection();
		String sql = "select * from course where course_id != ? and course_number = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, courseId);
			ps.setLong(2, courseNumber);
			rs = ps.executeQuery();
			if (rs.next()) {
				// not unique
				return false;
			}else {
				// no such course
				return true;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				ps = null;
			}
		}
		return true;		
	}
	
	public static Course searchByNameAndNumber(String courseName, Long courseNumber) {
		Course course = new Course();
		con = DBHelper.getConnection();
		String sql = "select * from course where course_name = ? and course_number = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, courseName);
			ps.setLong(2, courseNumber);
			rs = ps.executeQuery();
			if (rs.next()) {  
				course.setId(rs.getLong("course_id"));  
				course.setName(courseName);  
				course.setDescription(rs.getString("description")); 
				course.setNumber(courseNumber); 
				course.setCommentNum(rs.getLong("comment_number"));
				course.setTrack(rs.getString("track"));
                return course; 
			}else {
				// no such course
				return null;
			}
			// todo: sort by course number
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				ps = null;
			}
		}
		return course;
	}
	public static List<Comment> getCommentsList(Long courseId) {
		List<Comment> list = new LinkedList<>();
		con = DBHelper.getConnection();
		String sql = "select * from comment where course_id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, courseId);
			rs = ps.executeQuery();
			while(rs.next()) { 
				Comment comment = new Comment(); 
				comment.setUserId(rs.getLong("user_id"));
				comment.setCommentId(rs.getLong("comment_id"));
				comment.setCourseId(rs.getLong("course_id"));
				comment.setContent(rs.getString("content"));
				comment.setUsername(rs.getString("username"));
				comment.setCreateTime(rs.getTimestamp("create_time"));
				comment.setFileList(FileDAO.getFileList(rs.getLong("comment_id")));
                list.add(comment); 
			}

			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				ps = null;
			}
		}
		return list;
	}
	
	
	public static List<Course> displayCoursebyTrack(String trackname) {
		List<Course> list = new LinkedList<>();
		con = DBHelper.getConnection();
		String sql = "select * from course where track = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, trackname);
			rs = ps.executeQuery();
			while(rs.next()) { 
				Course course=new Course();  
				course.setId(rs.getLong("course_id"));  
				course.setName(rs.getString("course_name"));  
				course.setDescription(rs.getString("description")); 
				course.setNumber(rs.getLong("course_number")); 
				course.setCommentNum(rs.getLong("comment_number"));
				course.setTrack(rs.getString("track"));  
                list.add(course);  
			}

			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				ps = null;
			}
		}
		return list;
	}	

	public static List<String[]> getProfessorList(Long courseId) {
		List<String[]> list = new LinkedList<>();
		con = DBHelper.getConnection();
		String sql = "select * from teach where course_id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, courseId);
			rs = ps.executeQuery();
			while(rs.next()) {
				String[] professor = new String[] {rs.getString("professor_name"), rs.getString("professor_link")};
                list.add(professor); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ps = null;
			}
		}
		return list;
	}
	
}
