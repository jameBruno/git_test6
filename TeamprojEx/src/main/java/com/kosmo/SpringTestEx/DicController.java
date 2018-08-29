package com.kosmo.SpringTestEx;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import diction.command.BbsCommandImpl;
import diction.command.ViewCommand;
import springBoard.model.JDBCTemplateConst;

@Controller
public class DicController {

private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		
		System.out.println("@Autowired->JDBCTemplate 연결성공");
		
		//JDBCTemplate을 전체에서 사용하기 위한 설정
		JDBCTemplateConst.template = this.template;
	}
	
	BbsCommandImpl command = null;
	
	@RequestMapping("/diction/diction.do")
	public String diction(Model model, HttpSession session, HttpServletRequest req) {
		System.out.println("view() 메소드 호출됨");
		
		//컨트롤러가 받은 파라미터 전체를 ViewCommand로 넘김
		model.addAttribute("req", req);
		command = new ViewCommand();
		command.execute(model);
		
		return "diction/dictionary";
	}
	
	
}
