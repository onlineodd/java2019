package java2019.com.java.project.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java2019.com.java.project.dao.MovieCollectionDAO;
import java2019.com.java.project.entity.MovieCollection;
import java2019.com.java.project.utils.DBUtil;

public class MovieCollectionDAOImpl implements MovieCollectionDAO{
	DBUtil dbUtil=new DBUtil();
	@SuppressWarnings("unused")
	private MovieCollection movieCollection;
	public int save(MovieCollection movieCollection) {
		// TODO Auto-generated method stub
		String sql="insert into tab_movie (id,title,duration,author,link,summary,type)"+"value(?,?,?,?,?,?,?)";
		int i = dbUtil.update(sql, movieCollection.getmId(),movieCollection.getmTitle(),movieCollection.getmDuration(),movieCollection.getmAuthor(),movieCollection.getmLink(),movieCollection.getmSummary(),movieCollection.getmType());
		return i;
	}

	public int update(MovieCollection movieCollection) {
		// TODO Auto-generated method stub
		String sql="update tab_movie set title=?,duration=?,author=?,link=?,summary=?,type=? where id=?";
		int i = dbUtil.update(sql, movieCollection.getmTitle(),movieCollection.getmDuration(),movieCollection.getmAuthor(),movieCollection.getmLink(),movieCollection.getmSummary(),movieCollection.getmType(),movieCollection.getmId());
		return i;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from tab_movie where id=?";
		int i = dbUtil.update(sql, id);
		return i;
	}

	@Override
	public List<MovieCollection> findAll() {
		// TODO Auto-generated method stub
		List<MovieCollection> list=new ArrayList<MovieCollection>();
		String sql="select * from tab_movie";
		ResultSet resultSet = dbUtil.query(sql);
		try {
			while(resultSet.next()){
			   handleDate(list, resultSet);
			}
			
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	private void handleDate(List<MovieCollection> list, ResultSet resultSet) throws SQLException {
		int id=resultSet.getInt("id");
		   String title=resultSet.getString("title");
		   String duration=resultSet.getString("duration");
		   String author=resultSet.getString("author");
		   String link=resultSet.getString("link");
		   String summary=resultSet.getString("summary");
		   String type=resultSet.getString("type");
		   
		   MovieCollection movieCollection=new MovieCollection(id,title,duration,author,link,summary,type);
		   list.add(movieCollection);
	}

	@Override
	public List<MovieCollection> findTitle(String title) {
		List<MovieCollection> list=new ArrayList<MovieCollection>();
		String sql="select * from tab_movie where title like ?";
		title="%"+title+"%";
		ResultSet resultSet = dbUtil.query(sql,title);
		try {
			while(resultSet.next()){
			   handleDate(list, resultSet);
			}
			
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}


}
