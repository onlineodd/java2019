package java2019.com.java.project.controller;

import java.util.List;
import java.util.Scanner;

import java2019.com.java.project.entity.MovieCollection;
import java2019.com.java.project.service.MovieCollectionService;
import java2019.com.java.project.service.impl.MovieCollectionServiceImpl;
 
public class MovieCollectionController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieCollectionService movieCollectionService=new MovieCollectionServiceImpl();
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入：1.新增|2.更新|3.删除|4.查询|5.根据名字模糊查询");
		
		boolean si=true;
		while(si){
			int m=scanner.nextInt();
			switch (m) {
			case 1:
				System.out.println("请输入：电影名,时长,作者,链接,故事概要,类型");
				String movie=scanner.next();
				String []params=movie.split(",");
				MovieCollection movieCollection=new MovieCollection();
				movieCollection.setmId(0);
				movieCollection.setmTitle(params[0]);
				movieCollection.setmDuration(params[1]);
				movieCollection.setmAuthor(params[2]);
				movieCollection.setmLink(params[3]);
				movieCollection.setmSummary(params[4]);
				movieCollection.setmType(params[5]);
				boolean iosk= movieCollectionService.save(movieCollection);
				if(iosk){
					System.out.println("新增成功！");
				}else{
					System.out.println("新增失败！");
				}
				break;
				case 2:
					System.out.println("请输入：电影名,时长,作者,链接,故事概要,类型,编号");
					String movie1=scanner.next();
					String []params1=movie1.split(",");
					MovieCollection movieCollection1=new MovieCollection();
					movieCollection1.setmId(Integer.parseInt(params1[6]));
					movieCollection1.setmTitle(params1[0]);
					movieCollection1.setmDuration(params1[1]);
					movieCollection1.setmAuthor(params1[2]);
					movieCollection1.setmLink(params1[3]);
					movieCollection1.setmSummary(params1[4]);
					movieCollection1.setmType(params1[5]);
					boolean iosk1= movieCollectionService.update(movieCollection1);
					if(iosk1){
						System.out.println("更新成功！");
					}else{
						System.out.println("更新失败！");
					}
					break;
					case 3:
						int id=scanner.nextInt();
						boolean iosk3 = movieCollectionService.delete(id);
						if(iosk3){
							System.out.println("操作成功");
						}else {
							System.out.println("操作失败");
						}
						break;
					case 4:
						List<MovieCollection> list = movieCollectionService.findAll();
						list.forEach(System.out::println);
						break;
					case 5:
						System.out.println("输入电视名模糊查询");
						String title=scanner.next();
						List<MovieCollection> list2=movieCollectionService.findTitle(title);
						list2.forEach(System.out::println);
						break;
			default:
				si=false;
				break;
			}
		}
	}

}
