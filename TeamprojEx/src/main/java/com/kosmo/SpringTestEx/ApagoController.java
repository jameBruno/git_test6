package com.kosmo.SpringTestEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
	
	@RequestMapping("/mybatis/login.do")
	public String login(Model model, HttpSession session) {
		return "member/login";
	}
	
	@RequestMapping("/Captcha")
	public String captcha(Model model, HttpSession session, HttpServletRequest req, HttpServletResponse resp) {
		String clientId = "42zBWTFtjL22rQYfvhob";
	      String clientSecret = "svMjUgPpxT";
	      try {
	          String code = "0"; // 키 발급 받을 때는 0으로 설정
	          String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;
	          URL url = new URL(apiURL);
	          HttpURLConnection con = (HttpURLConnection)url.openConnection();
	          con.setRequestMethod("GET");
	          con.setRequestProperty("X-Naver-Client-Id", clientId);
	          con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	          int responseCode = con.getResponseCode();
	          BufferedReader br;
	          if(responseCode==200) { 
	              br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	          } else {  
	              br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	          }
	          String inputLine;
	          StringBuffer response = new StringBuffer();
	          while ((inputLine = br.readLine()) != null) {
	              response.append(inputLine);
	          }
	          br.close();
	          System.out.println(response.toString());
	          resp.setContentType("text/html;charset=UTF-8");
	          
				
				//서블릿에서 세션객체를 얻어온다.
				session = req.getSession();
				
				session.setAttribute("key", response.toString());
	          
	      } catch (Exception e) {
	          System.out.println(e);
	      }
		
		return "member/captcha";
	}
	
	@RequestMapping("/CaptchaRes")
	public String result(Model model, HttpSession session, HttpServletRequest req, HttpServletResponse resp) {
		
		String clientId = "42zBWTFtjL22rQYfvhob";
        String clientSecret = "svMjUgPpxT";
        session = req.getSession();
        StringBuffer response = new StringBuffer();
        String apiResult = null;
        try {
            String code = "1"; 
            String key = session.getAttribute("vkey").toString(); 
            String value = req.getParameter("inputText"); 
            String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code +"&key="+ key + "&value="+ value;

            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { 
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            //response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        
        apiResult = response.toString();
        System.out.println(apiResult);
        
		JSONParser parser = new JSONParser();
		Object obj = null;
		try {
			obj = parser.parse(apiResult);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		JSONObject jsonobj = (JSONObject) obj;

		Boolean result = (Boolean) jsonobj.get("result");
        if(result == true) {
        	//한글처리
			resp.setContentType("text/html;charset=UTF-8");
			
			return "member/join_agree";
        }else {
        	//한글처리
			resp.setContentType("text/html;charset=UTF-8");
			//서블릿에서 out객체를 얻어온다.
			return "member/false";
        }		
		
	}
	
	@RequestMapping("/mybatis/join.do")
	public String join(Model model, HttpSession session) {
		return "member/join";
	}	
}
