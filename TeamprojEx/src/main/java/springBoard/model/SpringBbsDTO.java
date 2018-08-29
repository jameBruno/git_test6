package springBoard.model;

import java.sql.Date;

public class SpringBbsDTO {
	
	public int idx; 
    public String name;
    public String title; 
    public String contents; 
    public java.sql.Date postdate; 
    public int hits;
    public int bgroup; 
    public int bstep;
    public int bindent; 
    public String pass; 
    public int virtualNum;
	/*클래스 정의 시 기본 생성자를 만들어 주는 게 좋다
	기본 생성자로 객체 생성하고 싶은 경우가 있기 때문에,
    기본 생성자가 없다면 에러 발생한다.*/
    public SpringBbsDTO() {}

	public SpringBbsDTO(int idx, String name, String title, String contents, Date postdate, int hits, int bgroup,
			int bstep, int bindent, String pass) {
		this.idx = idx;
		this.name = name;
		this.title = title;
		this.contents = contents;
		this.postdate = postdate;
		this.hits = hits;
		this.bgroup = bgroup;
		this.bstep = bstep;
		this.bindent = bindent;
		this.pass = pass;
	}

	public SpringBbsDTO(int idx, String name, String title, String contents, Date postdate, int hits, int bgroup,
			int bstep, int bindent, String pass, int virtualNum) {
		this.idx = idx;
		this.name = name;
		this.title = title;
		this.contents = contents;
		this.postdate = postdate;
		this.hits = hits;
		this.bgroup = bgroup;
		this.bstep = bstep;
		this.bindent = bindent;
		this.pass = pass;
		this.virtualNum = virtualNum;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public java.sql.Date getPostdate() {
		return postdate;
	}

	public void setPostdate(java.sql.Date postdate) {
		this.postdate = postdate;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getBgroup() {
		return bgroup;
	}

	public void setBgroup(int bgroup) {
		this.bgroup = bgroup;
	}

	public int getBstep() {
		return bstep;
	}

	public void setBstep(int bstep) {
		this.bstep = bstep;
	}

	public int getBindent() {
		return bindent;
	}

	public void setBindent(int bindent) {
		this.bindent = bindent;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getVirtualNum() {
		return virtualNum;
	}

	public void setVirtualNum(int virtualNum) {
		this.virtualNum = virtualNum;
	}
       
    
}
