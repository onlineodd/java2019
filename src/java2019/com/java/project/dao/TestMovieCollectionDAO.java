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
		MovieCollection movieCollection = new MovieCollection(0, "����������", "1:50:32", "��˹-Τ��",
				"https://cn.bing.com/search?q=����������&qs=AS&pq=����&sk=AS2&sc=9-2&cvid=03ECF6B4CF5747AAAF213E27648800DF&FORM=QBLH&sp=5",
				"��Ҫ�������ǡ����������ˡ�Ӧ�˶����� ���Ǹ�����ͨ���Ž�һ�ģ�������ֹ���������֣���֤�˵���İ�ȫ ... ���������������У�ӥ��������ڹѸ������","��Ӱ ");
		int i = movieCollectionDAO.save(movieCollection);
		Assert.assertEquals(1, i);
	}
	@Test
	public void testupdate(){
		MovieCollection movieCollection = new MovieCollection(1, "����������", "1:50:32", "��˹-Τ��",
				"https://cn.bing.com/search?q=����������&qs=AS&pq=����&sk=AS2&sc=9-2&cvid=03ECF6B4CF5747AAAF213E27648800DF&FORM=QBLH&sp=5",
				"��Ҫ�������ǡ����������ˡ�Ӧ�˶����� ���Ǹ�����ͨ���Ž�һ�ģ�������ֹ���������֣���֤�˵���İ�ȫ ... ���������������У�ӥ��������ڹѸ������...","��Ӱ");
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
