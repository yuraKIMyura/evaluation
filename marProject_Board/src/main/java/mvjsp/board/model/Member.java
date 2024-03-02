package mvjsp.board.model;

public class Member {
	
	int memberno;
	int role;
	String id;
	String email;
	String name;
	String question;
	String answer;
	
//constructor	

	public Member(String id, String email, String name, String question, String answer) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.question = question;
		this.answer = answer;
	}	
	
	public Member(int memberno, String id, String email, String name, String question, String answer) {
		this.memberno = memberno;
		this.id = id;
		this.email = email;
		this.name = name;
		this.question = question;
		this.answer = answer;
	}	
	
	public Member(int memberno, int role, String id, String email, String name, String question, String answer) {
		super();
		this.memberno = memberno;
		this.role = role;
		this.id = id;
		this.email = email;
		this.name = name;
		this.question = question;
		this.answer = answer;
	}

//getters and setters	
	public int getMemberno() {
		return memberno;
	}

	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
//toString	
	@Override
	public String toString() {
		return "Member [memberno=" + memberno + ", role=" + role + ", id=" + id + ", email=" + email + ", name=" + name
				+ ", question=" + question + ", answer=" + answer + "]";
	}
	
	
}//class

