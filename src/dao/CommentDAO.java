package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.mysql.jdbc.Statement;

import po.Comment;
import po.Course;
import util.DBHelper;

public class CommentDAO {

	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public static List<Comment> CommentListById(Long id) {
		List<Comment> res = new LinkedList<>(); 
		con = DBHelper.getConnection();
		String sql = "select * from comment where user_id = ? order by create_time DESC";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setUserId(id);
				comment.setContent(rs.getString("content"));
				comment.setCourseName(rs.getString("coursename"));
				comment.setCourseId(rs.getLong("course_id"));
				comment.setCommentId(rs.getLong("comment_id"));
				comment.setCreateTime(rs.getTimestamp("create_time"));
				comment.setUsername(rs.getString("username"));
				comment.setFileList(FileDAO.getFileList(id));
				res.add(comment);
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
	
	public static int AddComment(Long courseid, Long userid, String content, String username, String createtime, String coursename) {
		con = DBHelper.getConnection();
		String sql = "insert into comment (course_id, user_id, content, username, create_time, coursename) values(?,?,?,?,?,?) ";
		int newKey = 0;
		try {
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setLong(1, courseid);
			ps.setLong(2, userid);
			ps.setString(3, content);
			ps.setString(4, username);
			ps.setString(5, createtime);
			ps.setString(6, coursename);
			int affected = ps.executeUpdate();
			if(affected == 1){
				ResultSet keys = ps.getGeneratedKeys();
				keys.next();
	            newKey = keys.getInt(1);
	           return newKey;
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
		return 0;
		
	}
	
	public static void AddCommentFile(String filename, String createtime, int commentid) {
		con = DBHelper.getConnection();
		System.out.println(filename);
		String sql = "insert into file (name, create_time, path, comment_id) values(?,?,?,?) ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, filename);
			ps.setString(2, createtime);
			ps.setString(3, filename);
			ps.setLong(4, commentid);
			ps.executeUpdate();
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
}
