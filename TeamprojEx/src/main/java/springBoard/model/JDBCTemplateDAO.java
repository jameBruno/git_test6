package springBoard.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import diction.DicVO;
/*
 JdbcTemplate 관련 주요 메소드
 
- List query(String sql, RowMapper rowMapper) - executequery와 비슷함
	: 여러개의 레코드를 반환하는 select계열의 쿼리문인 경우 사용함
- List query(String sql, Object[] args, RowMapper rowMapper)
	: 인파라미터를 가진 여러 개의 레코드를 반환하는 select계열의 쿼리문인 경우 사용함
- int queryForInt(String sql) / queryForInt(String sql, Object[] args)
	: 쿼리문의 실행결과로 숫자를 반환하는 select 계열의 쿼리문인 경우 사용함
- Object queryForObject(String sql, RowMapper rowMapper) /
Object queryForObject(String sql, Object[] args, RowMapper rowMapper)
	: 하나의 레코드를 반환하는 select 계열의 쿼리문
- int update(String sql) - executeUpdate와 비슷함
	: 인파라미터가 없는 update/delete/insert 쿼리문인 경우 사용
- int update(String sql, Object[] args)
	: 인파라미터가 있는 update/delete/insert 쿼리문인 경우 사용
	
※인파라미터는 Object계열로 배열 초기화를 통해 전달한다.
Object[] args는 인파라미터를 뜻함

※queryForObject 메소드는 실행결과 레코드가 0개이거나 2개 이상인 경우에 예외가 발생되므로 try~catch문으로
처리해야함
 */
public class JDBCTemplateDAO {
	JdbcTemplate template;
	
	public JDBCTemplateDAO() {
		this.template = JDBCTemplateConst.template;
		System.out.println("JDBCTemplate 이용한 DB연결성공");
	}
	
	public void close() {
		//JDBCTemplate에서는 사용하지 않음
	}
	/*
	public int getTotalCount(Map<String, Object> map) {
		
		String query = "SELECT COUNT(*) FROM springboard";
		
		if(map.get("Word")!=null) {
			query += " WHERE "+map.get("Column")+" "
				+ " LIKE '%"+map.get("Word") + "%' ";
		}
		
		return template.queryForObject(query, Integer.class);
	}
	
	public ArrayList<SpringBbsDTO> list(Map<String, Object> map){
		
		int start = Integer.parseInt(map.get("start").toString());
		
		int end = Integer.parseInt(map.get("end").toString());
		
		String query = "" 
				+ "SELECT * FROM ("
				+ "	SELECT Tb.*, rownum rNum FROM ("
				+ "		SELECT * FROM springboard ";
		
		if(map.get("Word")!=null) {
			query += " WHERE "+map.get("Column")+ " "
				+ " LIKE '%"+map.get("Word")+"%' ";
		}
		
		query += " ORDER BY bgroup DESC, bstep ASC"
		//query += " ORDER BY idx DESC"
		+ "	) Tb"
		+ ")"
		+ " WHERE rNum BETWEEN "+start+" AND "+end;
		
		return (ArrayList<SpringBbsDTO>)template.query(query,
				new BeanPropertyRowMapper<SpringBbsDTO>(SpringBbsDTO.class));
	}
	
	public void write(final String name, final String title, final String contents, final String pass) {
		
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "INSERT INTO springboard (idx, name, title, "
						+ " contents, hits, bgroup, bstep, bindent, pass) "
						+ " VALUES (springboard_seq.NEXTVAL, ?, ?, ?, 0,"
						+ " springboard_seq.NEXTVAL, 0, 0,?)";
				
				PreparedStatement psmt = con.prepareStatement(sql);
				psmt.setString(1, name);
				psmt.setString(2, title);
				psmt.setString(3, contents);
				psmt.setString(4, pass);
				return psmt;
			}
		});
	}
	*/
	public DicVO view(String word) {
		
		DicVO dto = null;
		
		String sql = "SELECT * FROM global_dic "
				+ " WHERE title like '%"+word+"%'";
		//웹브라우저 주소창의 idx값을 임의로 변경하는 경우 예외가 발생할 수 있으므로 예외처리 해주는 것이 좋다.
		try {
			dto = template.queryForObject(sql, new BeanPropertyRowMapper<DicVO>(
					DicVO.class));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	/*
	public void updateHit(final String idx) {
		
		//매개변수를 익명클래스에서 사용해야 하므로 값의 보장을 위해 final로 선언해야 한다.
		System.out.println("조회수 증가");
		
		String sql = "UPDATE springboard SET "
				+ " hits = hits + 1 "
				+ " WHERE idx = ? ";
		
		this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement psmt) throws SQLException {
				psmt.setInt(1, Integer.parseInt(idx));
			}
		});	
	
	}
	
	public int password(String idx, String pass) {
		
		
		패스워드 검증을 위해 select한 후 조건에 맞는 레코드가 있다면
		해당 게시물의 idx값을 반환하고 없다면 0을 반환한다.
		 
		int boardIdx = 0;
		String sql = "SELECT * FROM springboard WHERE pass= "+pass+" AND idx= "+idx;
		//queryForObject는 실행결과가 1이 아니면 무조건 예외가 발생된다. 예외처리해주어야함
		try {	
			SpringBbsDTO dto = 
				template.queryForObject(sql, new BeanPropertyRowMapper<SpringBbsDTO>(SpringBbsDTO.class));
			
			boardIdx = dto.getIdx();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return boardIdx;
	}
	
	//수정처리(DTO로 파라미터 받음)
	public void modify(final SpringBbsDTO dto) {
		
		String sql = "UPDATE springboard SET name=?, title=?, contents=? WHERE idx=? AND pass=?";
		
		this.template.update(sql,
			new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement psmt) throws SQLException {
					
					psmt.setString(1, dto.getName());
					psmt.setString(2, dto.getTitle());
					psmt.setString(3, dto.getContents());
					psmt.setInt(4, dto.getIdx());
					psmt.setString(5, dto.getPass());
					
				}
			});
	}	
	
	public void delete(final String idx, final String pass){
		
		String sql = "DELETE FROM springboard "
					+ " WHERE idx=? AND pass=?";
		
		this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement psmt) throws SQLException {
			
				psmt.setString(1, idx);
				psmt.setString(2, pass);
				
			}
		});
	}
	
	public void reply(final SpringBbsDTO dto){
		
		//답변글쓰기전 레코드 업데이트
		replyPrevUpdate(dto.getBgroup(), dto.getBstep());
		
		String sql = "INSERT INTO springboard "
				+ " (idx, name, title, contents, pass, "
				+ "	bgroup, bstep, bindent) "
				+ " VALUES "
				+ " (springboard_seq.nextval, ?, ?, ?, ?,"
				+ " ?, ?, ?)";
		
		this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement psmt) throws SQLException {
				
				psmt.setString(1, dto.getName());
				psmt.setString(2, dto.getTitle());
				psmt.setString(3, dto.getContents());
				psmt.setString(4, dto.getPass());
				psmt.setInt(5, dto.getBgroup());
				psmt.setInt(6, dto.getBstep()+1);
				psmt.setInt(7, dto.getBindent()+1);
				
			}
		});
		
	}
	
	//답변글 입력전 레코드 일괄 업데이트
	public void replyPrevUpdate(final int strGroup, final int strStep){
		
		 * 현재 답변글이 작성되는 위치(bstep)를 확인하여 
		 * 해당 위치보다 큰 레코드를 일괄적으로 +1 처리한다.
		 		
		String query = "UPDATE springboard "
				+ " SET bstep=bstep+1 "
				+ " WHERE bgroup=? AND bstep>?";
		
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement psmt) throws SQLException {
				psmt.setInt(1, strGroup);
				psmt.setInt(2, strStep);
			}
		});
	}
	*/
}
