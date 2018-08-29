package diction.command;

import org.springframework.ui.Model;

//게시판의 모든 클래스가 구현할 인터페이스 정의
public interface BbsCommandImpl {

	//추상메소드 : 오버라이딩의 목적으로 정의
	void execute(Model model);
}
