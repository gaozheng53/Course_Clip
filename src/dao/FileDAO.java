package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import po.File;
import util.DBHelper;

public class FileDAO {
	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public static List<File> getFileList(Long commentId){
		List<File> res = new LinkedList<>();
		con = DBHelper.getConnection();// 通过DBHelper得到Connection
		String sql = "select * from file where comment_id = ? order by create_time DESC";// 查询语句，先把username设置为？，后面在赋值
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, commentId);// 赋值
			rs = ps.executeQuery();// 执行查询语句，返回一个ResultSet
			while (rs.next()) {
				File file = new File();
				file.setCommentId(commentId);
				file.setPath(rs.getString("path"));
				file.setCreateTime(rs.getTimestamp("create_time"));
				file.setFileName(rs.getString("name"));
				file.setFileId(rs.getLong("file_id"));
				res.add(file);
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
