package friend;

public class FriendMain {

	public static void main(String[] args) {
		
		//FriendInfoHandler handler = new FriendInfoHandler(10);
		FriendInfoHandler handler = FriendInfoHandler.getInstance();
		
		while(true) {
			System.out.println("=== 메뉴를 선택해 주세요 =========");
			System.out.println(" "+Menu.INSERT_HEIGH+". 고교 친구 저장");
			System.out.println(" "+Menu.INSERT_UNIV+". 대학 친구 저장");
			System.out.println(" "+Menu.PRINT_BASIC+". 기본 정보 출력");
			System.out.println(" "+Menu.PRINT_ALL+". 전체 정보 출력");
			System.out.println(" "+Menu.EXIT+". 종료");
			System.out.println("=============================");
			
			
			int choice = handler.kb.nextInt();
			// 1
			handler.kb.nextLine(); // 앞의 버퍼 클리어
			
			switch(choice) {
			case Menu.INSERT_HEIGH: case Menu.INSERT_UNIV:
				handler.addFriend(choice);
				break;
			case Menu.PRINT_BASIC:
				handler.showAllSimpleData();
				break;
			case Menu.PRINT_ALL:
				handler.showAllData();
				break;
			case Menu.EXIT:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			
			
		}

	}

}
