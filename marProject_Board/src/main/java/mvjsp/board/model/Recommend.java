package mvjsp.board.model;

public class Recommend {
	
	int serialno;
	int boardno;
	int memberno;
	
	
	
	
	public Recommend(int boardno, int memberno) {
		super();
		this.boardno = boardno;
		this.memberno = memberno;
	}


	public Recommend(int serialno, int boardno, int memberno) {
		super();
		this.serialno = serialno;
		this.boardno = boardno;
		this.memberno = memberno;
	}


	
	public int getSerialno() {
		return serialno;
	}


	public void setSerialno(int serialno) {
		this.serialno = serialno;
	}


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


	@Override
	public String toString() {
		return "Recommend [serialno=" + serialno + ", boardno=" + boardno + ", memberno=" + memberno + "]";
	}
	
		

}
