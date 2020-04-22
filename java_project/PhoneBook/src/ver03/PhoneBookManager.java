package ver03;

import java.util.Scanner;

/*
	Project : ver 0.30

배열을 이용해서 프로그램 사용자가 입력하는 정보가 최대 100개까지 유지되도록 프로그램을 변경. 

아래기능 삽입

저장 : 이름, 전화번호, 생년월일 정보를 대상으로 하는 저장
검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력
삭제 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 삭제

데이터 삭제 후 남아있는 데이터 처리는 데이터를 빈 공란이 없이 순차적으로
재정리 2번이 삭제되었다면 3번 이후 데이터들의 주소 값이 -1 처리되어 재저장.
*/
public class PhoneBookManager {
	
	
	final PhoneInfor[] pBooks;
	
	// 입력된 친구의 정보 개수 --> 입력된 배열의 요소 개수
	// 1. 참조할 때 반복의 횟수
	// 2. 새로운 객체를 저장할때 index 로 사용
	int cnt;
	
	Scanner sc;
	
	
	public PhoneBookManager() {		
		// 배열 초기화
		pBooks = new PhoneInfor[100];
		// 저장개수 초기화
		cnt = 0;
		// Scanner 객체 초기화
		sc = new Scanner(System.in);
	}
	
	
	// 저장 : 이름, 전화번호, 생년월일 정보를 대상으로 하는 저장
	// 배열에 PhoneInfor 타입의 참조값을 저장
	void addInfo(PhoneInfor info) {
		
		// 배열에 요소 대입
		pBooks[cnt] = info;
		
		// 등록된 정보의 개수를 증가
		cnt++;
		
	}
	
	void addInfo() {
		
		// 배열에 요소 대입
		pBooks[cnt] = createInstance();
		
		// 등록된 정보의 개수를 증가
		cnt++;
		
	}
	
	
	// 사용자의 입력데이로 PhoneInfor 객체를 생성
	PhoneInfor createInstance() {
		
		PhoneInfor info = null;
		
		
		
		System.out.println("친구의 정보를 저장하기 위한 데이터를 입력합니다. ");
		
		System.out.println("이름을 입력해주세요. >> ");		
		String name = sc.nextLine();
		
		System.out.println("전화번호를 입력해 주세요. >>");
		String phoneNumber = sc.nextLine();
		
		System.out.println("생일을 입력해 주세요.");
		String birthday = sc.nextLine();
		
		// 사용자의 입력 데이터에 따라 인스턴스 생성 방법을 구분
		if(birthday==null||birthday.trim().isEmpty()) {
			info = new PhoneInfor(name, phoneNumber);
		} else {
			info = new PhoneInfor(name, phoneNumber, birthday); 
		}		
		
		return info;		
		
	}
	

	
	// 전체 리스트 출력
	void showAllData() {
		
		// 전체 데이터 ->  입력된 데이터의 개수 cnt
		for(int i=0; i<cnt; i++) {
			pBooks[i].showInfo();
			System.out.println("------------");
		}
		
		
		
	}
	
	
	// 배열에서 이름을 기준으로 검색후 index 값을 반환
	int searchIndex(String name) {
		
		int searchIndex = -1;
		
		// 사용자가 입력한 이름으로 배열에 요소를 검색 -> index
		for(int i=0; i<cnt; i++) {
			if(pBooks[i].checkName(name)) {
				searchIndex = i;
				break;
			}
		}
		
		return searchIndex;
		
	}
	
	
	
	
	// 검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력
	// 배열의 요소(PhoneInfor)의 name 속성 값으로 배열의 요소
	void searchInfo() {
		
		System.out.println("검색하고자하는 이름을 입력해주세요");
		String name = sc.nextLine();
		
		int searchIndex = searchIndex(name);
		
		
		if(searchIndex<0) {
			System.out.println("찾으시는 이름의 데이터가 존재하지 않습니다.");
		} else {
			pBooks[searchIndex].showInfo();
		}
		
	}
	
	
	// 삭제 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 삭제
	void deleteInfo() {
		
		System.out.println("삭제하고자하는 이름을 입력해주세요");
		String name = sc.nextLine();
		
		int searchIndex = searchIndex(name);
		
		
		
		// 삭제
		// pBooks[2] : 삭제 , pBooks[2] = null
		// 데이터 삭제 후 남아있는 데이터 처리는 데이터를 빈 공란이 없이 순차적으로
		// 재정리 2번이 삭제되었다면 3번 이후 데이터들의 주소 값이 -1 처리되어 재저장.
		
		
		if(searchIndex<0) {
			System.out.println("찾으시는 이름의 데이터가 존재하지 않습니다.");
		} else {
			
			// 삭제 : 검색한 index 부터 저장된 위치까지 왼쪽으로 시프트
			for(int i=searchIndex; i<cnt-1; i++) {
				pBooks[i]=pBooks[i+1];
			}
			
			
			// 저장된 정보의 개수를 -1
			cnt--;
			
			System.out.println("요청하신 이름의 정보를 삭제했습니다.");
			
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
}







