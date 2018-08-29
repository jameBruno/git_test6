package model;
 
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class HospitalDAO {
   
   Connection con; //오라클 서버와 연결할때 사용
   PreparedStatement psmt;//오라클 서버와 쿼리전송 역활
   ResultSet rs;//쿼리의 결과를 받을때 사용
   
   public HospitalDAO() {      
      try {
         Context ctx = new InitialContext();
         DataSource source = 
           (DataSource)
           ctx.lookup("java:comp/env/jdbc/myoracle");
         
         con = source.getConnection();
         System.out.println("DBCP연결성공");
      }
      catch(Exception e) {
         System.out.println("DBCP연결실패");
         e.printStackTrace();
      }      
   }
   
   public void close() {
      try {
         if(rs!=null) rs.close();
         if(psmt!=null) psmt.close();
         if(con!=null) con.close();
      }
      catch(Exception e) {
         System.out.println("자원반납시 예외발생");
         e.printStackTrace();
      }
   }
   
   //회원 가입 
   public int memberRegist_mgr(HospitalMemberDTO dto) {
      //적용된 행의 갯수확인을 위한 변수
      int affected = 0;
      System.out.println("dd");
      try {
         String query = "INSERT INTO hospital_member (mem_idx, "
            + " mem_flag, mem_name, mem_gender, mem_bir, mem_id, mem_pass, mem_dis, "
            + " tel, mobile, zipcode, addr1, addr2, email ) "
            + " VALUES (seq_hp.nextval, "
            + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ? )";
         psmt = con.prepareStatement(query); 
         psmt.setString(1, dto.getMem_flag());
         psmt.setString(2, dto.getMem_name());
         psmt.setString(3, dto.getMem_gender());
         psmt.setString(4, dto.getMem_age());
         psmt.setString(5, dto.getMem_id());
         psmt.setString(6, dto.getMem_pass());
         psmt.setString(7, dto.getMem_dis()); 
         psmt.setString(8, dto.getTel());
         psmt.setString(9, dto.getMobile());
         psmt.setString(10, dto.getZipcode());
         psmt.setString(11, dto.getAddr1());
         psmt.setString(12, dto.getAddr2());
         psmt.setString(13, dto.getEmail());
          
 
         affected = psmt.executeUpdate();
      }
      catch(Exception e) {
         System.out.println("insert중 예외발생");
         e.printStackTrace();
      }
      
      return affected;
   }
   
   public Map<String, String> memberLogin(String id,String pwd){
      
      Map<String, String> maps = new HashMap<String, String>();
      
      String query = " SELECT mem_id , mem_pass , mem_name , email, mem_idx FROM hospital_member WHERE mem_id = ? and mem_pass = ? ";
      try {
         psmt = con.prepareStatement(query);
         psmt.setString(1, id);
         psmt.setString(2, pwd);
         rs = psmt.executeQuery();
         
         //결과셋이 있는 경우에만 레코드를 읽어온다.
         if(rs.next()) {      
            //Map에 추가할때는 put()메소드 사용함.
            maps.put("id", rs.getString(1)); 
            maps.put("pass", rs.getString(2));
            maps.put("name", rs.getString(3));
            maps.put("email", rs.getString(4));
            maps.put("idx", rs.getString(5));
         }
         else {
            System.out.println("결과셋이 없습니다.");
         }
      }
      catch(Exception e) {
         System.out.println("getMemberDTO오류");
         e.printStackTrace();
      }
      
      return maps;
   }
   
 //게시판 리스트 가져오기(검색처리, 페이지처리)
 	public List<EventDTO> selectList(Map<String,Object> map){
 		
 		//1.결과 레코드셋을 담기위한 리스트계열 컬렉션생성 
 		List<EventDTO> bbs = new Vector<EventDTO>();
 		
 		//2.게시물 전체를 가져오기 위한 쿼리작성
 		String query = " "		
 			+" SELECT * FROM ( " 
 			+"	 SELECT Tb.*, ROWNUM rNum FROM ( "
 			+"	    SELECT E.* FROM event E ";

 		if(map.get("Word")!=null) 
 		{
 			if(map.get("Column").equals("both")) 
 			{
 				query +=" WHERE "
 				  + "title LIKE '%"+ map.get("Word") +"%' "
 				  +" OR "
 				  +" content LIKE '%"+ map.get("Word") +"%' ";
 			}
 			else {
 				query +=" WHERE "+ map.get("Column") +" "
 				  +" LIKE '%"+ map.get("Word") +"%' ";
 			}			
 		}else {
 			query += "    	ORDER BY num DESC "
 			    +"    ) Tb "
 			    +" ) "
 			    +" WHERE rNum BETWEEN ? AND ?";			
 		}	
 		System.out.println("쿼리문:"+ query);			
 			
 		try {
 			//3.prepare객체생성 및 실행
 			psmt = con.prepareStatement(query);
 			psmt.setString(2, map.get("start").toString());
 			psmt.setString(3, map.get("end").toString());			
 			//4.쿼리실행후 결과셋 돌려받음
 			rs = psmt.executeQuery();
 			
 			//5.결과셋의 갯수만큼 반복
 			while(rs.next()) {
 				
 				//6.결과셋을 하나씩 DTO객체에 저장
 				EventDTO dto = new EventDTO();
 				
 				dto.setE_num(rs.getInt(1));
 				dto.setE_title(rs.getString("title"));
 				dto.setE_content(rs.getString(3));
 				dto.setE_postdate(rs.getDate(4));
 				dto.setE_id(rs.getString("id"));
 				dto.setE_hits(rs.getInt(6));
 				
 				//7.DTO객체를 컬렉션에 추가
 				bbs.add(dto);
 			}
 		}
 		catch(Exception e) {
 			System.out.println("Select시 예외발생");
 			e.printStackTrace();
 		}
 		
 		return bbs;
 	} 	
   
}