package ver04;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager(100);
		
		while(true) {
			
			Menu.showMenu();
			
			int select = manager.kb.nextInt();
			manager.kb.nextLine();
			
			
			switch(select) {
			case 1:
				manager.createInfo();
				break;
			case 2:
				manager.showInfo();
				break;
			case 3:
				manager.deleteInfo();
				break;
			case 4:
				manager.editInfo();
				break;
			case 5:
				manager.showAllInfo();
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			
			
			
		}

	}

}









