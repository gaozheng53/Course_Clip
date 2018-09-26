package util;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

/*这个类就是为我们得到Connection所服务的。

 *后面我们只需要调用静态方法getConnection()就能直接得到一个Connection了，

 *这里我们使用的是单例模式，不懂的可以百度下。

 */

public class DBHelper {

//这个是添加的jar包里面的一个类。可以在referenced Libraries里面找到

	public static final String driver = "com.mysql.jdbc.Driver";

	/*
	 * 这个是本地数据库中的一个database，名字叫User.localhost表示自己的电脑，
	 * 
	 * 3306是一个端口，表示访问的是数据库。后面?之后的就代表的是编号格式以及使用ssl
	 * 
	 * 协议，想了解的可以百度下。
	 * 
	 */

	public static final String url = "jdbc:mysql://localhost:3306/OOAD?characterEncoding=utf8&useSSL=true";

	public static final String username = "root";

	public static final String password = "123456";

	public static Connection con = null;

	static {

		try {

			Class.forName(driver);// 得到DriverManager，在下面建立连接时使用

		} catch (ClassNotFoundException e) {

// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	public static Connection getConnection() {

		if (con == null) {

			try {

				con = DriverManager.getConnection(url, username, password);// 建立连接,使用的参数就是上面我们所定义的字符串常量。

			} catch (SQLException e) {

// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}

		return con;

	}

}