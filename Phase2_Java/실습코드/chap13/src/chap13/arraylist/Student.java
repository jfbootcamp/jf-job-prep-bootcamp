package chap13.arraylist;

public class Student {
	private String name;
	private int score;		// 점수 (0~100)
	
	public Student(String name, int score) {
		//super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		if (score >= 0 && score <= 100) {		// 유효 범위만 허용
			this.score = score;
		}
	}
	
	public String getGrade() {		// 점수 -> 등급 변환
		if (score >= 90) return "A";
		else if (score >= 80) return "B";
		else if (score >= 70) return "C";
		else if (score >= 60) return "D";
		else return "F";
	}

	@Override
	public String toString() {
		return String.format("%-6s | %3d점 | %s", name, score, getGrade());  //이름, 점수, 등급
	}
	
	

}












