package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Users;
import util.JdbcUtil;

public class UsersDao {
	
	//数据库连接对象
		public  Users  login(String username,String password) throws Exception {
		   Users u=null;
		   Connection conn =null;
		   PreparedStatement pstmt=null;
		   ResultSet rs=null;
	 
		  //赋值
		  try {
			conn=JdbcUtil.getConnection();
			  //静态sql语句
			String sql = "select * from users where username=? and password=?"; 
		    pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);  
			rs = pstmt.executeQuery();
			while(rs.next()){
				u=new Users();
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				System.out.println("登录成功！");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {	
			if(conn != null) {
				 conn.close();
				 conn = null;
			}
		  if(pstmt != null) {
			  pstmt.close();
		  }
		  if(rs != null) {
			  rs.close();
			  rs.close();
		  }
		  
		  
		}
		 return u;
	 
	}
		public void addUsers(Users users) throws Exception {
			Connection conn = null;
			PreparedStatement psmt = null;
			try {
				conn = JdbcUtil.getConnection();
				 
				 String sql  ="insert into users(id,username,password) values(?,?,?);";
				 
				 psmt = conn.prepareStatement(sql);
				 
				 //运用实体对象进行参数赋值
				 psmt.setString(1, users.getId());
				 psmt.setString(2, users.getUsername());
				 psmt.setString(3,users.getPassword());
				 psmt.executeUpdate();		 
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				 conn.close();
				 psmt.close();
			}
		}	
}
