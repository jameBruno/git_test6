package mybatis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

public class MyBoardDAO {

	public MyBoardDAO() {
	
		/*DB연결이 필요없음. DB연결이 이미 끝났음.
		스프링 설정 파일(servlet-context.xml)에서 이미 생성한 template 빈을 주입받아 사용할 것이므로
		별도의 DB연결 필요 없음 */
		//기본생성자는 만들어 주기는 하지만 명시적으로 만듦.
		
	}
	
	/*스프링 설정파일에서 이미 생성된 빈을 자동으로 주입받기 위한 멤버변수/setter 생성
	@Autowired 어노테이션은 빈의 타입을 기반으로 자동주입 받게 된다.*/
	
	JdbcTemplate template;

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}	
	
	public ArrayList<MyBoardDTO> list() {//쿼리+실행문장
		
		String sql = "SELECT * FROM myboard ORDER BY idx DESC";
		
		ArrayList<MyBoardDTO> lists = 
				(ArrayList<MyBoardDTO>)template.query(sql, new BeanPropertyRowMapper<MyBoardDTO>(MyBoardDTO.class));
		
		return lists;
		
	}
	
	public MemberVO login(String id, String pass) {
		String sql = "SELECT * FROM member WHERE id ='" + id + "' AND pass = '" + pass + "'";
		MemberVO vo = null;
		try{
			vo = template.queryForObject(sql, new BeanPropertyRowMapper<MemberVO>(MemberVO.class));
		
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return vo;
	}
	
	public void write(final String name, final String contents, final String id) {
		
		this.template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				String sql = "INSERT INTO myboard VALUES (myboard_seq.NEXTVAL, ?, ?,?) ";
				
				PreparedStatement psmt = con.prepareStatement(sql);
				psmt.setString(1, id);
				psmt.setString(2, name);
				psmt.setString(3, contents);
				
				return psmt;
			}
		});		
	}
	
	//수정처리를 위한 view메소드
	public MyBoardDTO view(String idx, String id) {
		MyBoardDTO dto = null;
		String sql = "SELECT * FROM myboard WHERE idx='" + idx + "' AND id='" + id + "'";
		try {
			dto = template.queryForObject(sql, new BeanPropertyRowMapper<MyBoardDTO>(MyBoardDTO.class));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public int modify(final String idx, final String name, final String contents, final String id) {
		
		String sql = "UPDATE myboard SET name=?, contents =? WHERE idx = ? AND id = ?";
		
		this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement psmt) throws SQLException {
					
				psmt.setString(1, name);
				psmt.setString(2, contents);
				psmt.setInt(3, Integer.parseInt(idx));
				psmt.setString(4, id);
				
			}
		});
		return 0;//추후에 mybatis로 컨버팅할 때 필요함
	}
	
	public int delete(final String idx, final String id) {
		
		String sql = "DELETE FROM myboard WHERE idx = ? AND id = ?";
		
		this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement psmt) throws SQLException {
				psmt.setInt(1, Integer.parseInt(idx));
				psmt.setString(2, id);
			}
		});
		return 0;
	}
	
}
