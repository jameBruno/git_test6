package com.kosmo.SpringTestEx;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mybatis.MyBoardDAO;
import mybatis.MyBoardDTO;
import mybatis.MybatisDAOImpl;
import springBoard.model.PagingUtil;

@Controller
public class ApagoController {
	
	MyBoardDAO dao;
	
	@Autowired	
	public void setDao(MyBoardDAO dao) {
		this.dao = dao;
	}

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/mybatis/list.do")	
	public String list(Model model, HttpServletRequest req) {
		
		//JdbcTemplate 사용
		//ArrayList<MyBoardDTO> lists = dao.list();
		
		int pageSize = 4;
		int blockPage = 2;
		
		int totalRecordCount =sqlSession.getMapper(MybatisDAOImpl.class).getTotalCount();
		
		//전체페이지수계산하기
		int totalPage = (int)Math.ceil((double)totalRecordCount/pageSize);
	
		//시작 및 끝 rownum 구하기
		int nowPage = req.getParameter("nowPage")==null ? 1 :
			Integer.parseInt(req.getParameter("nowPage"));
		int start = (nowPage-1) * pageSize + 1;
		int end = nowPage * pageSize;
	
		ArrayList<MyBoardDTO> lists = sqlSession.getMapper(MybatisDAOImpl.class).listPage(start,
				end);
		
		for(MyBoardDTO dto : lists) {
			String temp = dto.getContents().replace("\r\n", "<br/>");
			dto.setContents(temp);
		}
		
		model.addAttribute("lists",lists);
		
		String pagingImg = PagingUtil.pagingImgServlet(totalRecordCount,
				pageSize, blockPage, nowPage,
				req.getContextPath()+"/mybatis/list.do?");
		model.addAttribute("pagingImg", pagingImg);
		
		return "07Mybatis/list";
	}
	
}
