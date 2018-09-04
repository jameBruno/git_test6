package diction.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import mybatis.DicVO;
import springBoard.model.JDBCTemplateDAO;
import springBoard.model.SpringBbsDAO;

public class ViewCommand implements BbsCommandImpl{
	
	@Override
	public void execute(Model model) {
		//파라미터 한번에 전달받기
		Map<String, Object> paramMap = model.asMap();
		HttpServletRequest req = (HttpServletRequest)paramMap.get("req");
		
		//파라미터 받기
		//String word = req.getParameter("word");
		String word = "냉방병";
		
		//커넥션 풀 사용한 DAO
		//SpringBbsDAO dao = new SpringBbsDAO();
		
		//Spring JDBC 사용한 DAO
		JDBCTemplateDAO dao = new JDBCTemplateDAO();
		
		DicVO dto = new DicVO();
		dto = dao.view(word);
		
		//dao.updateVisitCount(idx);
		//줄바꿈 처리
		//dto.setDic_contents(dto.getDic_contents().replaceAll("\r\n", "<br/>"));
		model.addAttribute("viewRow",dto);
		dao.close();
	}
	
}
