package place;

public class ClassMember {
	
	String[] members = {
			"고은아", "권재준", "김보겸", "김승연", "김혜림", "남영준",
			"박명훈", "박성민", "박진명", "박현정", "박혜미", "송가람",
			"안정민", "양미선", "양창일", "원윤경", "이민수", "이혜진",
			"임재영85", "임재영96", "장윤원", "정신우", "지용욱", "홍세영"
	};

	String[][] place = new String[5][];

	void shuffle(int cnt) {
		String temp = "";
		int index = 0;
		for (int i = 0; i < cnt; i++) {
			index = (int) (Math.random() * members.length);
			temp = members[0];
			members[0] = members[index];
			members[index] = temp;
		}
	}

	void setPlace() {
		place[0] = new String[3];
		place[1] = new String[3];
		place[2] = new String[3];
		place[3] = new String[8];
		place[4] = new String[7];

		int index = 0;
		for (int i = 0; i < place.length; i++) {
			for (int j = 0; j < place[i].length; j++) {
				place[i][j] = members[index++];
			}
		}
	}

	void printPlace() throws InterruptedException {
		for (int i = 0; i < place.length; i++) {
		//for (int i = place.length-1; i >= 0; i--) {
			for (int j = 0; j < place[i].length; j++) {
				Thread.sleep(1000);
				System.out.print(" " + place[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws InterruptedException {

		ClassMember member = new ClassMember();
		member.shuffle(1000007);
		member.setPlace();
		member.printPlace();
	}
}






