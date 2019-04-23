package java2019.com.java.project.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java2019.com.java.project.entity.MovieCollection;
import java2019.com.java.project.service.impl.MovieCollectionServiceImpl;
 
@SuppressWarnings("unused")
public class TextMovieCollectionService {
	private MovieCollectionService movieCollectionService;
	@Before
	public void setUp() throws Exception {
		movieCollectionService=new MovieCollectionServiceImpl();
	}

	@Test
	public void test() {
		MovieCollection movieCollection=new MovieCollection(0, "����������", "1:50:32", "��˹-Τ��",
				"https://cn.bing.com/search?q=����������&qs=AS&pq=����&sk=AS2&sc=9-2&cvid=03ECF6B4CF5747AAAF213E27648800DF&FORM=QBLH&sp=5",
				"��Ҫ�������ǡ����������ˡ�Ӧ�˶����� ���Ǹ�����ͨ���Ž�һ�ģ�������ֹ���������֣���֤�˵���İ�ȫ ... ���������������У�ӥ��������ڹѸ������ ","��Ӱ");
		movieCollectionService.save(movieCollection);
	
	}
@Test
public void testupdate(){
	MovieCollection movieCollection=new MovieCollection(4, "����������", "1:50:32", "��˹-Τ��",
			"https://cn.bing.com/search?q=����������&qs=AS&pq=����&sk=AS2&sc=9-2&cvid=03ECF6B4CF5747AAAF213E27648800DF&FORM=QBLH&sp=5",
			"��Ҫ�������ǡ����������ˡ�Ӧ�˶����� ���Ǹ�����ͨ���Ž�һ�ģ�������ֹ���������֣���֤�˵���İ�ȫ ... ���������������У�ӥ��������ڹѸ������ ","��Ӱ");
	movieCollectionService.update(movieCollection);

}

}
