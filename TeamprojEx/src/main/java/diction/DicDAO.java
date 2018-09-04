package diction;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import mybatis.MemberVO;
import mybatis.MyBoardDTO;

public class DicDAO {
	
	public DicDAO() {}
	
	JdbcTemplate template;

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}	
	
	public DicVO selection(String search_title) {
		String sql = "SELECT * FROM global_dic WHERE title='"+search_title+"'";
		DicVO vo = null;
		vo = template.queryForObject(sql, new BeanPropertyRowMapper<DicVO>(DicVO.class));
		return vo;
	}	
	
	public ArrayList<DicVO> dicList(String charc) {
		String sql = "SELECT * FROM global_dic WHERE charc='"+charc+"'";
		ArrayList<DicVO> list = (ArrayList<DicVO>)template.query(sql, new BeanPropertyRowMapper<DicVO>(DicVO.class));
		return list;
	}
	
	public DicVO dicView(String title) {
		String sql = "SELECT * FROM global_dic WHERE title='"+title+"'";
		DicVO vo = null;
		vo = template.queryForObject(sql, new BeanPropertyRowMapper<DicVO>(DicVO.class));
		return vo;
	}
}
