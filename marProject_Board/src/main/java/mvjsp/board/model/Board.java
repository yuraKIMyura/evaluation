package mvjsp.board.model;

public class Board {
	
	int boardno;
	int memberno;
	String writer;
	String type;
	String regtime;
	int hits;
	int recommends;
	String title;
	String content;
	
//constructor
		
	
	
	public Board(int boardno, int memberno, String type, String regtime, int hits, int recommends, String title,
			String content) {
		super();
		this.boardno = boardno;
		this.memberno = memberno;
		this.type = type;
		this.regtime = regtime;
		this.hits = hits;
		this.recommends = recommends;
		this.title = title;
		this.content = content;
	}
	

	public Board(int boardno, int memberno, String writer, String type, String regtime, int hits, int recommends,
		String title, String content) {
	super();
	this.boardno = boardno;
	this.memberno = memberno;
	this.writer = writer;
	this.type = type;
	this.regtime = regtime;
	this.hits = hits;
	this.recommends = recommends;
	this.title = title;
	this.content = content;
}

	public Board(int boardno, String type, String title, int hits, int recommends) {
		super();
		this.boardno = boardno;
		this.type = type;
		this.title = title;
		this.hits = hits;
		this.recommends = recommends;
	}
	
	public Board(int boardno, String type, String title, int hits, int recommends, String regtime) {
		super();
		this.boardno = boardno;
		this.type = type;
		this.title = title;
		this.hits = hits;
		this.recommends = recommends;
		this.regtime=regtime;
	}
	
	public Board(int boardno, int memberno, String title, int hits, int recommends) {
		super();
		this.boardno = boardno;
		this.memberno = memberno;
		this.title = title;
		this.hits = hits;
		this.recommends = recommends;
	}
	
	public Board(int memberno, String type, String title, String content) {
		super();
		this.memberno=memberno;
		this.type = type;
		this.title = title;
		this.content = content;
	}
	
	public Board(String type, String title, String content, int boardno) {
		super();

		this.type = type;
		this.title = title;
		this.content = content;
		this.boardno=boardno;
	}
	
	
	
//getters and setters	
	
	
	


	public int getBoardno() {
		return boardno;
	}


	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	public int getMemberno() {
		return memberno;
	}

	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}
	
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getRecommends() {
		return recommends;
	}

	public void setRecommends(int recommends) {
		this.recommends = recommends;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
//toString
		
	@Override
	public String toString() {
		return "Board [boardno=" + boardno + ", memberno=" + memberno + ", type=" + type + ", regtime=" + regtime
				+ ", hits=" + hits + ", recommends=" + recommends + ", title=" + title + ", content=" + content + "]";
	}
			

}//class
