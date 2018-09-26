package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBHelper;

/* dao层处理业务逻辑，里面有两个方法，
  一个是检查登录，一个是向数据库注册一个用户*/
public class UserDAO {

	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;

	public static boolean checkLogin(String username, String password) {// 检查登录，这里传入的两个参数分别是从jsp传过来的账号和密码
		con = DBHelper.getConnection();// 通过DBHelper得到Connection
		String sql = "select * from user where username = ?";// 查询语句，先把username设置为？，后面在赋值
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, username);// 赋值
			rs = ps.executeQuery();// 执行查询语句，返回一个ResultSet,这个就是我们数据库里面的user
			if (rs.next()) {

				String pwd = rs.getString("password");// 找到数据类里面user所对应的passwrod
				if (pwd.equals(password)) {// 把我们从数据库中找出来的password和从jsp中传过来的passwrod比较
					return true; // ture代表验证成功
				} else {
					return false;// false代表验证失败
				}
			} else {
				return false;
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
		return false;
	}

	public static String register(String username, String password,String email) {// 向数据库注册一个新的用户
		UserDAO dao = new UserDAO();
		System.out.println("start validate");
		if(!dao.userIsExist(username)) {
			return "Username already be used";
		}
		if(!dao.emailIsExist(email)) {
			return "Email already be used";
		}

		con = DBHelper.getConnection();// 通过DBHelper得到Connection
		// 暂时先自动创建role=0  以后update
		String sql = "insert into user(username, password, email,role) values (?,?,?,0)";// 这个语句是向表单插入一个user,username和password先设置为？,后面赋值
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, username);// 给username赋值
			ps.setString(2, password);// 给password赋值
			ps.setString(3, email);// 给email赋值
			int b = ps.executeUpdate();// 执行插入语句，并返回一个int值，大于0表示添加成功，小于0表示添加失败.
			if (b > 0) {
				return "Register success";
			} else {
				return "Register fail";
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
		return "Register success";
	}
	
	
	 public boolean userIsExist(String username){
	        // 获取数据库连接Connection对象
	        Connection conn = DBHelper.getConnection();
	        // 根据指定用户名查询用户信息
	        String sql = "select * from user where username = ?";
	        try {
	            // 获取PreparedStatement对象
	            PreparedStatement ps = conn.prepareStatement(sql);
	            // 对用户对象属性赋值
	            ps.setString(1, username);
	            // 执行查询获取结果集
	            ResultSet rs = ps.executeQuery();
	            // 判断结果集是否有效
	            if(!rs.next()){
	                // 如果无效则证明此用户名可用
	                return true;
	            }
	            // 释放此 ResultSet 对象的数据库和 JDBC 资源
	            rs.close();
	            // 释放此 PreparedStatement 对象的数据库和 JDBC 资源
	            ps.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally { // 这里是一些操作数据库之后的一些关闭操作
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
	        return false;
	    }
	 	
	 public boolean emailIsExist(String email){
	        // 获取数据库连接Connection对象
	        Connection conn = DBHelper.getConnection();
	        // 根据指定用户名查询用户信息
	        String sql = "select * from user where email = ?";
	        try {
	            // 获取PreparedStatement对象
	            PreparedStatement ps = conn.prepareStatement(sql);
	            // 对用户对象属性赋值
	            ps.setString(1, email);
	            // 执行查询获取结果集
	            ResultSet rs = ps.executeQuery();
	            // 判断结果集是否有效
	            if(!rs.next()){
	                // 如果无效则证明此用户名可用
	                return true;
	            }
	            // 释放此 ResultSet 对象的数据库和 JDBC 资源
	            rs.close();
	            // 释放此 PreparedStatement 对象的数据库和 JDBC 资源
	            ps.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally { // 这里是一些操作数据库之后的一些关闭操作
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
	        return false;
	    }

}