package java2019.com.java.project.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class DBUtil {
	private static String driverName ; 
	private static String url;
	private static String  user;
	private static String password;
	static{
		ResourceBundle resourceBundle=ResourceBundle.getBundle("d b");
		driverName=resourceBundle.getString("drivername");
		url=resourceBundle.getString("url");
		user=resourceBundle.getString("user");
		password=resourceBundle.getString("password");
	}
	private Connection connection=null;
	private PreparedStatement preparedStatement=null;
	private ResultSet resultSet=null;
	public int update(String sql,Object...params){
		int x=0;
				try{
				getcConnection();
				preparedStatement=connection.prepareStatement(sql);
				//受该条sql
				
				if(params!=null){
				for(int i=0;i<params.length;i++){
					preparedStatement.setObject(i+1, params[i]);
				}
				}
				 x=preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				if(preparedStatement!=null){
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(connection!=null){
						try {
							connection.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			return x;	
	}
	public CachedRowSet query(String sql ,Object...params){
		int r=0;
		CachedRowSet cachedRowSet=null;
		try{
			getcConnection();
			RowSetFactory factory=RowSetProvider.newFactory();
			cachedRowSet=factory.createCachedRowSet();
			preparedStatement=connection.prepareStatement(sql);
			if(params!=null){
			for(int i=0;i<params.length;i++){
				preparedStatement.setObject(i+1, params[i]);
			}
			}
			resultSet=preparedStatement.executeQuery();
			cachedRowSet.populate(resultSet);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cachedRowSet;	
	}
	public CachedRowSet querByPage(String sql,int pageSize,int page,Object...params){
		getcConnection();
		CachedRowSet cachedRowSet=null;
		try {
			preparedStatement =connection.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					preparedStatement.setObject(i+1, params[i]);
					
				}
			}
			resultSet=preparedStatement.executeQuery();
			//RowSet进行分页
			RowSetFactory factory=RowSetProvider.newFactory();
			cachedRowSet=factory.createCachedRowSet();
			if(pageSize<1){
				pageSize=1;
			}
			if(page<1){
				page=1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
		return cachedRowSet;
	}
	public void close(){
		if(preparedStatement!=null){
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public Connection getcConnection(){
		try {
			Class.forName(driverName);
			connection=DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	
}
