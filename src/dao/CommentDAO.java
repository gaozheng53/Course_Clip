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

public class CommentDAO {

	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public static List<Comment> CommentListById(Long id) {
		List<Comment> res = new LinkedList<>(); 
		con = DBHelper.getConnection();// 通过DBHelper得到Connection
		String sql = "select * from comment where user_id = ? order by create_time DESC";// 查询语句，先把username设置为？，后面在赋值
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, id);// 赋值
			rs = ps.executeQuery();// 执行查询语句，返回一个ResultSet
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
		} finally { // 这里是一些操作数据库之后的一些关闭操作
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
}
