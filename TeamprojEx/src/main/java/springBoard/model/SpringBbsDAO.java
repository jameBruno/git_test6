package springBoard.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SpringBbsDAO {

	Connection con; //오라클 서버와 연결할때 사용
	PreparedStatement psmt;//오라클 서버와 쿼리전송 역활
	ResultSet rs;//쿼리의 결과를 받을때 사용
	
	public SpringBbsDAO() {		
		try {
			Context ctx = new InitialContext(); 
			DataSource source = 
			  (DataSource)
			  ctx.lookup("java:comp/env/jdbc/myoracle");
			
			con = source.getConnection();
			System.out.println("Spring DBCP연결성공");
		}
		catch(Exception e) {
			System.out.println("Spring DBCP연결실패");
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
	
	public int getTotalCount(Map<String, Object> map) {
		int totalCount = 0;
		try {
			String sql = "SELECT COUNT(*) FROM springboard ";
			if(map.get("Word")!=null) {
				sql += " WHERE "+map.get("Column")+" "
					+ " LIKE '%"+map.get("Word") + "%' ";
			}
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			rs.next();
			totalCount = rs.getInt(1);
		}
		catch(Exception e) {}
		return totalCount;
	}
	
	public ArrayList<SpringBbsDTO> list(Map<String, Object> map){
		ArrayList<SpringBbsDTO> bbs = new ArrayList<SpringBbsDTO>();
		
		String sql = "" 
				+ "SELECT * FROM ("
				+ "	SELECT Tb.*, rownum rNum FROM ("
				+ "		SELECT * FROM springboard ";
		
		if(map.get("Word")!=null) {
			sql += " WHERE "+map.get("Column")+ " "
				+ " LIKE '%"+map.get("Word")+"%' ";
		}
		
		sql += " ORDER BY bgroup DESC, bstep ASC"
		//sql += " ORDER BY idx DESC"
		+ "	) Tb"
		+ ")"
		+ " WHERE rNum BETWEEN ? AND ?";
		
		System.out.println("쿼리문:"+sql);
		
		try {
			
			psmt = con.prepareStatement(sql);
			
			psmt.setInt(1, Integer.parseInt(map.get("start").toString()));
			psmt.setInt(2, Integer.parseInt(map.get("end").toString()));
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				SpringBbsDTO dto = new SpringBbsDTO();
				
				//답변글처리를 위한 로직추가
				int indentNum = rs.getInt(9);
				String spacer = "";
				
				if(indentNum>0){
					for(int i=1 ; i<=indentNum ; i++){
						spacer += "&nbsp;&nbsp;";
					}
					spacer += spacer+"<img src='../common/re2.gif'>";
				}
				
				dto.setIdx(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setTitle(spacer+rs.getString(3));
				//dto.setTitle(rs.getString(3));
				dto.setContents(rs.getString(4));
				dto.setPostdate(rs.getDate(5));
				dto.setHits(rs.getInt(6));
				dto.setBgroup(rs.getInt(7));
				dto.setBstep(rs.getInt(8));
				dto.setBindent(rs.getInt(9));
				dto.setPass(rs.getString(10));
								
				bbs.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bbs;
	}
	
	public SpringBbsDTO view(String idx) {
		
		SpringBbsDTO dto = null;
		
		String sql = "SELECT * FROM springboard "
				+ " WHERE idx = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, idx);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto = new SpringBbsDTO();
				
				dto.setIdx(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				/*내용부분은 줄바꿈 처리 후 dto객체에 저장하는 것이 좋으나,
				해당 메소드를 수정에서 같이 사용하기 위해 줄바꿈처리는 command에서 하도록 한다.
				*/
				dto.setContents(rs.getString(4));
				dto.setPostdate(rs.getDate(5));
				dto.setHits(rs.getInt(6));
				
				dto.setBgroup(rs.getInt(7));
				dto.setBstep(rs.getInt(8));
				dto.setBindent(rs.getInt(9));
				
				dto.setPass(rs.getString(10));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public void write(String name, String title, String contents, String pass) {
				
		try {
			/*답변형게시판에서 원글의 경우 idx와 bgroup은 항상 동일한 번호임.
			답변글인 경우 원글의 idx값을 bgroup으로 가지게 됨*/
			String sql = "INSERT INTO springboard (idx, name, title, contents, hits, bgroup, bstep, bindent, pass) "
					+ " VALUES (springboard_seq.NEXTVAL, ?, ?, ?, 0, springboard_seq.NEXTVAL, 0, 0,?)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setString(2, title);
			psmt.setString(3, contents);
			psmt.setString(4, pass);
			
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public int password(String idx, String pass) {
		int retNum = 0;
		
		try {
			String sql = "SELECT * FROM springboard WHERE pass=? AND idx=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, pass);
			psmt.setString(2, idx);
			rs = psmt.executeQuery();
			if(rs.next()) retNum = rs.getInt(1);//조건에 맞다면 idx값은 무조건 1이상의 값이다.(0인지 양수인지 확인)
		}catch(Exception e) {
			//쿼리 실행 시 예외가 발생하면 false반환
			retNum = 0;
			e.printStackTrace();
		}
		
		return retNum;
	}
	
	//수정처리
	public void modify(String idx, String name, String title, 
			String contents, String pass){
		
		try{
			String sql = "UPDATE springboard "
					+ " SET name=?, title=?, contents=? "
					+ " WHERE idx=? AND pass=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setString(2, title);
			psmt.setString(3, contents);
			psmt.setInt(4, Integer.parseInt(idx));
			psmt.setString(5, pass);
			
			int rn = psmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//수정처리(DTO로 파라미터 받음)
	public void modify(SpringBbsDTO dto) {
		try {
			String sql = "UPDATE springboard SET name=?, title=?, contents=? WHERE idx=? AND pass=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContents());
			psmt.setInt(4, dto.getIdx());
			psmt.setString(5, dto.getPass());
			
			psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//삭제처리
	public void delete(String idx, String pass){
		
		try{
			String sql = "DELETE FROM springboard "
					+ " WHERE idx=? AND pass=?";
			psmt = con.prepareStatement(sql);			
			psmt.setInt(1, Integer.parseInt(idx));
			psmt.setString(2, pass);
			
			int rn = psmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	//답글쓰기폼
	public SpringBbsDTO reply(String idx){
				
		SpringBbsDTO dto = null;
		try{
			String sql = "SELECT * FROM springboard WHERE idx=?";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, Integer.parseInt(idx));
			rs = psmt.executeQuery();
			if(rs.next()){				
				dto = new SpringBbsDTO();
								
				dto.setIdx(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString("title"));
				dto.setContents(rs.getString("contents"));
				dto.setPostdate(rs.getDate(5));
				dto.setHits(rs.getInt(6));
				dto.setBgroup(rs.getInt(7));
				dto.setBstep(rs.getInt(8));
				dto.setBindent(rs.getInt(9));
				dto.setPass(rs.getString(10));				
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return dto;
	}

	public void updateVisitCount(String idx) {
		String sql = "UPDATE springboard SET "
				+ " hits = hits + 1 "
				+ " WHERE idx = ? ";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, idx);
			psmt.executeUpdate();
		}catch(Exception e) {}
	}
	
	//답글처리
	public void reply(String name, String title, String contents,
			String pass, String bgroup, String bstep, String bindent){
		
		//답변글쓰기전 레코드 업데이트
		replyPrevUpdate(bgroup, bstep);
		
		//답변글 입력
		try{
			String sql = "INSERT INTO springboard "
					+ " (idx, name, title, contents, pass, "
					+ "	bgroup, bstep, bindent) "
					+ " VALUES "
					+ " (springboard_seq.nextval, ?, ?, ?, ?,"
					+ " ?, ?, ?)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setString(2, title);
			psmt.setString(3, contents);
			psmt.setString(4, pass);
			
			//답글은 기존글에 bstep+1, bindent+1 해준다.
			//bgroup : 원본글의 idx값을 입력받게 되어 같은 그룹으로 처리됨
			//bstep : 같은 그룹내에서의 정렬순서
			//bindent : 답변글의 깊이(1이라면 첫번째 답변글임)
			psmt.setInt(5, Integer.parseInt(bgroup));
			psmt.setInt(6, Integer.parseInt(bstep) + 1);
			psmt.setInt(7, Integer.parseInt(bindent) + 1);
			
			int rn = psmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	//답글처리
	public void reply(SpringBbsDTO dto){
		
		//답변글쓰기전 레코드 업데이트
		replyPrevUpdate(dto.getBgroup(), dto.getBstep());
		
		//답변글 입력
		try{
			String sql = "INSERT INTO springboard "
					+ " (idx, name, title, contents, pass, "
					+ "	bgroup, bstep, bindent) "
					+ " VALUES "
					+ " (springboard_seq.nextval, ?, ?, ?, ?,"
					+ " ?, ?, ?)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContents());
			psmt.setString(4, dto.getPass());
			
			//답글은 기존글에 bstep+1, bindent+1 해준다.
			//bgroup : 원본글의 idx값을 입력받게 되어 같은 그룹으로 처리됨
			//bstep : 같은 그룹내에서의 정렬순서
			//bindent : 답변글의 깊이(1이라면 첫번째 답변글임)
			psmt.setInt(5, dto.getBgroup());
			psmt.setInt(6, dto.getBstep() + 1);
			psmt.setInt(7, dto.getBindent() + 1);
			
			int rn = psmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	//답변글 입력전 레코드 일괄 업데이트
	public void replyPrevUpdate(int strGroup, int strStep){
		/*
		 * 현재 답변글이 작성되는 위치(bstep)를 확인하여 
		 * 해당 위치보다 큰 레코드를 일괄적으로 +1 처리한다.
		 */
		try{
			String query = "UPDATE springboard "
					+ " SET bstep=bstep+1 "
					+ " WHERE bgroup=? AND bstep>?";
			psmt = con.prepareStatement(query);
			psmt.setInt(1, strGroup);
			psmt.setInt(2, strStep);
			
			int rn = psmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void replyPrevUpdate(String strGroup, String strStep){
		/*
		 * 현재 답변글이 작성되는 위치(bstep)를 확인하여 
		 * 해당 위치보다 큰 레코드를 일괄적으로 +1 처리한다.
		 */
		try{
			String query = "UPDATE springboard "
					+ " SET bstep=bstep+1 "
					+ " WHERE bgroup=? AND bstep>?";
			psmt = con.prepareStatement(query);
			psmt.setInt(1, Integer.parseInt(strGroup));
			psmt.setInt(2, Integer.parseInt(strStep));
			
			int rn = psmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
