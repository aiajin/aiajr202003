package ver03;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager();		
		PhoneInfor info=null;
		
		while(true) {

			// 사용자의 입력 데이터를 인스턴스 생성
			info = manager.createInstance();
			// 정보를 배열에 저장
			manager.addInfo(info);
			// 전체 리스트 출력
			manager.showAllData();
			// 이름으로 검색
			manager.searchInfo();
			// 이름으로 검색후 삭제
			manager.deleteInfo();
			manager.showAllData();
			
		}

	}

}
