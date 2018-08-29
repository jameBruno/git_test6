package mybatis;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

public interface MybatisDAOImpl {
	
	public ArrayList<MyBoardDTO> list();
	
	//public void write(String name, String contents, String id);
	
	public void write(@Param("_name") String name, @Param("_contents") String contents, @Param("_id") String id);
	
	//방명록 수정에서 내용 불러오기(가져오기)
	public MyBoardDTO view(String idx, String id);
	
	public int modify(String idx, String name, String contents, String id);
	
	public int delete(String idx, String id);	
	
	//1.게시물 수 카운트하기
	public int getTotalCount();
	//2. start, end값을 받아서 select하기
	public ArrayList<MyBoardDTO> listPage(int s, int e);
	
}
