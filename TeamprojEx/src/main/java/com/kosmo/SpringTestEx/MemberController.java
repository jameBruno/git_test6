package com.kosmo.SpringTestEx;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.HospitalDAO;
import model.HospitalMemberDTO;
import mybatis.MyBoardDAO;
import mybatis.MyBoardDTO;
import mybatis.MybatisDAOImpl;
import springBoard.model.PagingUtil;

@Controller
public class MemberController {
	/*
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
	*/
	@RequestMapping("/member/regis.do")
	public String joinProc(Model model, HttpSession session, HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      String flag = req.getParameter("mem_flag");
	      String name = req.getParameter("name");
	      String gender = req.getParameter("gender");
	      String bir = req.getParameter("bday");
	      String id = req.getParameter("id");
	      String pass = req.getParameter("pass");
	      String dis = req.getParameter("dis");
	      String mobile = req.getParameter("numc1") + "-" + req.getParameter("numc2") + "-" + req.getParameter("numc3");
	      String tel = req.getParameter("numz1") + "-" + req.getParameter("numz2") + "-" + req.getParameter("numz3");
	      String zipcode = req.getParameter("zipcode");
	      String addr1 = req.getParameter("addr1");
	      String addr2 = req.getParameter("addr2");
	      String email = req.getParameter("email1") + "@" + req.getParameter("email2");
	            
	      HospitalMemberDTO dto = new HospitalMemberDTO(flag, name, gender, bir, id, pass, dis, mobile, tel, zipcode,
	            addr1, addr2, email);
	      HospitalDAO dao = new HospitalDAO();
	                  
	      int af = dao.memberRegist_mgr(dto);
	      if (af == 1) {
	         System.out.println("회원가입 성공");
	    	     	  
	         return "member/login";
	      } else {
	         System.out.println("회원가입 실패");
	         resp.setContentType("text/html;charset=UTF-8");
	         // 서블릿에서 out객체를 얻어온다.
	         PrintWriter out = null;
			try {
				out = resp.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         String str = "" + "<script>" + "  alert('회원가입 실패');location.href='../Captcha';" + "</script>";
	         out.println(str);
	         out.flush();
	         return null;
	      }	
	}
	
}
