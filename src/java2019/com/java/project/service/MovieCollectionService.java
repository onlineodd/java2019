package java2019.com.java.project.service;

import java.util.List;

import java2019.com.java.project.entity.MovieCollection;

public interface MovieCollectionService {
public boolean save(MovieCollection movieCollection);
public boolean update(MovieCollection movieCollection);
public boolean delete(int id);
public List<MovieCollection> findAll();
public List<MovieCollection> findTitle(String title);
}
