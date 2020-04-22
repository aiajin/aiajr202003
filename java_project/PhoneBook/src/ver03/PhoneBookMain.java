package ver03;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager();		
				
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			Menu.showMenu();

			
			int selectNum = sc.nextInt();
			
			sc.nextLine();
			
			switch(selectNum) {
			case 1:
				// 사용자의 입력 데이터를 인스턴스 생성
				//PhoneInfor info = manager.createInstance();
				// 정보를 배열에 저장
				//manager.addInfo(info);
				manager.addInfo();
				break;
			case 2:
				// 이름으로 검색
				manager.searchInfo();
				break;
			case 3:
				// 이름으로 검색후 삭제
				manager.deleteInfo();
				break;
			case 4:
				// 전체 리스트 출력
				manager.showAllData();
				break;
			case 5:
				//return;
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
				
				break;
			}
			
			
		}

	}

}
