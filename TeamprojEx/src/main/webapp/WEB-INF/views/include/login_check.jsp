<%@page import="springBoard.model.JavascriptUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//로그인 후 진입가능
if(session.getAttribute("USER_ID")==null)
{
	String backUrl = request.getRequestURI()+"?"+request.getQueryString();
	
	JavascriptUtil.jsAlertLocation("로그인 정보가 없습니다.", 
			"../main/main.jsp?backUrl="+backUrl, out);
	
	/* 위의 JS함수가 동작후 return이 없으면 아래  
	JSP코드가 실행될수 있기때문에 반드시 return으로
	실행을 멈춰줘야 한다.*/
	return;
}
%>