package diction.mybatis;

import java.util.ArrayList;

import diction.DicVO;

public interface MybatisDicImpl {
	
	public DicVO selection(String search_title);
	
	public ArrayList<DicVO> dicList(String charc);
	
	public DicVO dicView(int id);
}
