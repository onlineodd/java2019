package java2019.com.java.project.dao;

import java.util.List;

import java2019.com.java.project.entity.MovieCollection;

public interface MovieCollectionDAO {
public int  save(MovieCollection movieCollection);
public int  update(MovieCollection movieCollection);
public int  delete(int id);
public List<MovieCollection> findAll();
public List<MovieCollection> findTitle(String title);
}
