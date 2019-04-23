package java2019.com.java.project.service.impl;

import java.util.List;

import java2019.com.java.project.dao.MovieCollectionDAO;
import java2019.com.java.project.dao.impl.MovieCollectionDAOImpl;
import java2019.com.java.project.entity.MovieCollection;
import java2019.com.java.project.service.MovieCollectionService;

public class MovieCollectionServiceImpl implements MovieCollectionService{
	private MovieCollectionDAO movieCollectionDAO=new MovieCollectionDAOImpl();
	@Override
	public boolean save(MovieCollection movieCollection) {
		// TODO Auto-generated method stub
		int i=movieCollectionDAO.save(movieCollection);
		return i == 1 ? true : false;
	}

	@Override
	public boolean update(MovieCollection movieCollection) {
		// TODO Auto-generated method stub
		int i=movieCollectionDAO.update(movieCollection);
		return i == 1 ? true : false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		int i = movieCollectionDAO.delete(id);
		return i== 1 ? true : false;
	}

	@Override
	public List<MovieCollection> findAll() {
		// TODO Auto-generated method stub
		List<MovieCollection> list = movieCollectionDAO.findAll();
		return list;
	}

	@Override
	public List<MovieCollection> findTitle(String title) {
		// TODO Auto-generated method stub
		List<MovieCollection> list = movieCollectionDAO.findTitle(title);
		return list;
	}

}
