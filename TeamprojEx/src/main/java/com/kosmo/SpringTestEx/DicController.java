package com.kosmo.SpringTestEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import diction.DicDAO;
import diction.DicVO;
import diction.command.BbsCommandImpl;
import diction.command.ViewCommand;
import diction.mybatis.MybatisDicImpl;
import mybatis.MemberVO;
import mybatis.MyBoardDAO;
import mybatis.MyBoardDTO;
import mybatis.MybatisMemberImpl;
import springBoard.model.JDBCTemplateConst;

@Controller
public class DicController {

	DicDAO dao;
	
	@Autowired	
	public void setDao(DicDAO dao) {
		this.dao = dao;
	}
	
	@Autowired
	private SqlSession sqlSession;
	/*
	private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		
		System.out.println("@Autowired->JDBCTemplate 연결성공");
		
		//JDBCTemplate을 전체에서 사용하기 위한 설정
		JDBCTemplateConst.template = this.template;
	}
	*/
	BbsCommandImpl command = null;
	
	@RequestMapping("/diction/diction.do")
	public String diction(Model model, HttpSession session, HttpServletRequest req) {
		System.out.println("view() 메소드 호출됨");
		
		//컨트롤러가 받은 파라미터 전체를 ViewCommand로 넘김
		model.addAttribute("req", req);
		command = new ViewCommand();
		command.execute(model);
		
		String searchData = "기침";
		
		DicVO vo = sqlSession.getMapper(MybatisDicImpl.class).selection(searchData);		
		
		Map<String,Object> param = new HashMap<String,Object>();
		
		String queryStr = "";
		String searchWord = req.getParameter("searchWord");
		if(searchWord!=null){
			//입력한 검색어가 있다면 맵에 추가함
			param.put("Word", searchWord);
			//파라미터 추가
			queryStr = String.format("searchWord=%s&", searchWord);
		}
		
		model.addAttribute("vo",vo);
		
		return "diction/dictionary";
	}
	
	@RequestMapping("/diction/diclist.do")
	public String diclist(Model model, HttpSession session, HttpServletRequest req) {
		
		String charc = req.getParameter("charc");
		
		ArrayList<DicVO> list = sqlSession.getMapper(MybatisDicImpl.class).dicList(charc);
		
		for(DicVO vo : list) {
			String temp = vo.getTitle().trim();
			vo.setTitle(temp);
		}
		
		model.addAttribute("list",list);
		
		return "diction/diclist";
	}
	
	@RequestMapping("/diction/dicView.do")
	public String dicView(Model model, HttpSession session, HttpServletRequest req) {
		
		String title = req.getParameter("title");
		
		DicVO vo = sqlSession.getMapper(MybatisDicImpl.class).dicView(title);
		
		model.addAttribute("vo",vo);
		
		return "diction/dicView";
	}
}
