<%@page import="springBoard.model.JavascriptUtil"%>
<%@page import="model.HospitalDAO"%>
<%@page import="java.util.Map"%>
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	//폼값받기
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String auto_login = request.getParameter("auto_login");
	//dao생성
	HospitalDAO dao = new HospitalDAO();

	//함수호출
	Map<String, String> memberInfo = dao.memberLogin(id, pass);

	if (memberInfo.get("name") != null) {
		//세션영역에 저장
		session.setAttribute("USER_ID", memberInfo.get("id"));
		session.setAttribute("USER_NAME", memberInfo.get("name"));
		session.setAttribute("USER_EMAIL", memberInfo.get("email"));
		session.setAttribute("IDX", memberInfo.get("idx"));

		if (auto_login != null) {
			Cookie ck = new Cookie ("USER_ID",id);
			ck.setPath(request.getContextPath());
			ck.setMaxAge(0);
			response.addCookie(ck);
		}else{
			Cookie ck = new Cookie("USER_ID",id);
			
			//쿠키가 적용될 경로 지정 
			System.out.println(request.getContextPath());
			ck.setPath(request.getContextPath());
			//유효기간 
			ck.setMaxAge(60*60*24*100);
			response.addCookie(ck);
		}
	 
		request.getRequestDispatcher("./login.jsp").forward(request, response);
	
	} else {
		//회원인증이 실패했을경우 
		request.setAttribute("ERROR_MSG", "회원이 아닙니다.");
		JavascriptUtil.jsAlertLocation("비밀번호가 틀립니다 다시로그인해주세요", "../join/login.jsp",out);
	}
%>



