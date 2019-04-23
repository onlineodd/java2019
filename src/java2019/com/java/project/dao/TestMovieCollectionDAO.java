package java2019.com.java.project.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java2019.com.java.project.dao.impl.MovieCollectionDAOImpl;
import java2019.com.java.project.entity.MovieCollection;

public class TestMovieCollectionDAO {
	private MovieCollectionDAO movieCollectionDAO;

	@Before
	public void setUp() {
		movieCollectionDAO = new MovieCollectionDAOImpl();
	}

	@Test
	public void test() {
		MovieCollection movieCollection = new MovieCollection(0, "复仇者联盟", "1:50:32", "乔斯-韦登",
				"https://cn.bing.com/search?q=复仇者联盟&qs=AS&pq=复仇&sk=AS2&sc=9-2&cvid=03ECF6B4CF5747AAAF213E27648800DF&FORM=QBLH&sp=5",
				"主要讲述的是“复仇者联盟”应运而生。 他们各显神通，团结一心，终于阻止了外星入侵，保证了地球的安全 ... 在漫威漫画故事中，鹰眼侠曾与黑寡妇有绯闻","电影 ");
		int i = movieCollectionDAO.save(movieCollection);
		Assert.assertEquals(1, i);
	}
	@Test
	public void testupdate(){
		MovieCollection movieCollection = new MovieCollection(1, "复仇者联盟", "1:50:32", "乔斯-韦登",
				"https://cn.bing.com/search?q=复仇者联盟&qs=AS&pq=复仇&sk=AS2&sc=9-2&cvid=03ECF6B4CF5747AAAF213E27648800DF&FORM=QBLH&sp=5",
				"主要讲述的是“复仇者联盟”应运而生。 他们各显神通，团结一心，终于阻止了外星入侵，保证了地球的安全 ... 在漫威漫画故事中，鹰眼侠曾与黑寡妇有绯闻...","电影");
		int i = movieCollectionDAO.update(movieCollection);
		Assert.assertEquals(1, i);
	}
	@Test
	public void testdelect(){
	
		int i = movieCollectionDAO.delete(2);
		Assert.assertEquals(1, i);
	}
	@Test
	public void testfindAll(){
		List<MovieCollection> list = movieCollectionDAO.findAll();
		list.forEach(System.out::println);
	}

}
