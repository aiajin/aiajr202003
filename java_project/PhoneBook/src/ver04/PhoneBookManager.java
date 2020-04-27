package ver04;

import java.util.Scanner;

// PhoneInfo 타입의 배열로 친구들의 정보를 
// 저장, 수정, 삭제, 검색, 출력
public class PhoneBookManager {

	// 1. 배열 선언
	PhoneInfo[] books;
	// 배열에 저장된 요소의 개수
	int numOfInfo;

	Scanner kb;

	// 생성자를 통해서 배열 생성, 요소의 개수 초기화
	PhoneBookManager(int num) {
		// 배열의 생성
		books = new PhoneInfo[num];
		// 요소 개수의 초기화
		numOfInfo = 0;
		// Scanner 초기화
		kb = new Scanner(System.in);
	}

	// 2. 배열에 정보 저장
	// 2.1 배열에 추가
	// 2.2 사용자로 부터 받은 데이터로 인스턴스 생성

	// 2.1 배열에 추가
	void addInfo(PhoneInfo info) {
		// 배열에 numOfInfo 숫자 -> index 로 참조값을 저장
		books[numOfInfo] = info;
		// 입력된 정보의 개수를 +1 증가 시킨다
		numOfInfo++;
	}

	// 2.2 사용자로 부터 받은 데이터로 인스턴스 생성
	void createInfo() {

		System.out.println(" 1.일반 2.대학 3.회사 4.동호회 ");

		System.out.println("입력하고자 하는 번호를 입력해주세요.");

		// int select = kb.nextInt();
		// kb.nextLine();

		// 사용자 선택 번호
		int select = Integer.parseInt(kb.nextLine());
		
		if(!(select>0 && select<5)) {
			System.out.println("정상적인 메뉴 선택이 아닙니다.\n메뉴를 다시 선택해주세요.");
			return;
		}

		// 2.2.1 기본 정보 수집 : 이름, 전번, 주소, 이메일
		System.out.println("이름을 입력해주세요.");
		String name = kb.nextLine();

		System.out.println("전화번호를 입력해주세요.");
		String phoneNumber = kb.nextLine();

		System.out.println("주소를 입력해주세요.");
		String addr = kb.nextLine();

		System.out.println("이메일을 입력해주세요.");
		String email = kb.nextLine();

		PhoneInfo info = null;

		switch (select) {
		case 1:
			// 2.2.2 기본 클래스로 인스턴스 생성
			info = new PhoneInfo(name, phoneNumber, addr, email);
			break;
		case 2:
			System.out.println("전공(학과)를 입력해주세요.");
			String major = kb.nextLine();
			System.out.println("학년 정보를 입력해주세요.");
			String grade = kb.nextLine();
			
			// 2.2.3 대학 클래스로 인스턴스 생성			
			info = new PhoneUnivInfo(name, phoneNumber, addr, email, major, grade);
			break;
		case 3:
			System.out.println("회사의 이름을 입력해주세요.");
			String company = kb.nextLine();
			System.out.println("부서의 이름을 입력해주세요.");
			String dept = kb.nextLine();
			System.out.println("직무(직급)정보를 입력해주세요.");
			String job = kb.nextLine();
			
			// 2.2.4 회사 클래스로 인스턴스 생성
			info = new PhoneCompanyInfo(name, phoneNumber, addr, email, company, dept, job);
			break;
		case 4:
			System.out.println("동호회 이름을 입력해주세요.");
			String cafeName = kb.nextLine();
			System.out.println("닉네임을 입력해주세요.");
			String nickName = kb.nextLine();
			
			// 2.2.5 동호회 클래스로 인스턴스 생성
			info = new PhoneCafeInfo(name, phoneNumber, addr, email, cafeName, nickName);
			break;
		}

		// 2.3 생성된 인스턴스를 배열에 저장
		
		addInfo(info);

	}

	// 3. 배열의 데이터 출력
	void showAllInfo() {
		
		// for each 반복  : 현재 프로그램에서는 사용 불가
		// for 반복문 : 반복의 횟수 지정이 가능 numOfInfo
		
		System.out.println("전체 정보를 출력합니다. ===========");
		for(int i=0; i<numOfInfo ; i++) {
			books[i].showAllInfo();
			System.out.println("----------------");
		}
		
	}
	
	
	// 배열의 index 검색 : 인스턴스의 name 기준
	int searchIndex(String name) {
		
		// 정상적인 index 값은 0~이상의 값, 찾지 못했을 때 구분 값 -1을 사용
		int searchIndex = -1; 
		
		// 배열의 반복으로 name 값을 비교해서 index 값을 찾는다.
		for(int i=0; i<numOfInfo; i++) {
			if(books[i].name.equals(name)) {
				searchIndex=i;
				break;
			}
		}
		
		return searchIndex;
		
	}
	
	
	// 4. 배열의 정보 검색 : 이름 기준
	void showInfo() {
		
		System.out.println("검색하실 이름을 입력해주세요.");
		String name = kb.nextLine();
		
		int index = searchIndex(name);
		
		if(index<0) {
			System.out.println("검색하신 이름의 정보가 없습니다.");
		} else {
			System.out.println("----------------");
			books[index].showBasicInfo();
			System.out.println("----------------");
		}
		
		
	}
	
	
	
	// 5. 배열의 정보를 삭제 : 이름 기준
	void deleteInfo() {
		System.out.println("삭제하고자하는 이름을 입력해주세요.");
		String name = kb.nextLine();
		
		int index = searchIndex(name);
		
		if(index<0) {
			System.out.println("삭제하고자하는 이름의 정보가 없습니다.");
		} else {
			
			// 삭제 위치에서 외쪽으로 시프트
			for(int i=index; i<numOfInfo-1; i++) {
				books[i]=books[i+1];
			}
			// 삭제가 되었으므로 요소의 개수도 -1 
			numOfInfo--;
		}
		
	}
	
	
	// 6. 배열의 정보를 수정 : 이름 기준
	void editInfo() {
		
		System.out.println("변경하고자 하는 이름을 입력해주세요.");
		String name = kb.nextLine();
		
		int index = searchIndex(name);
		
		if(index<0) {
			System.out.println("찾으시는 이름의 정보가 존재하지 않습니다.");
			return;
		} else {
			
			String editName = books[index].name;
			
			System.out.println("수정 데이터 입력을 시작합니다.");
			System.out.println("이름은 " + editName + "입니다.");
			System.out.println("전화번호를 입력해주세요.");
			String phoneNumber = kb.nextLine();
			System.out.println("주소를 입력해주세요.");
			String addr = kb.nextLine();
			System.out.println("이메일을 입력해주세요.");
			String email = kb.nextLine();
			
			PhoneInfo info = null;
			
			// 저장된 인스턴스가 : 기본, 대학, 회사, 동호회
			if(books[index] instanceof PhoneInfo) {
				info = new PhoneInfo(editName, phoneNumber, addr, email);
				
			} else if(books[index] instanceof PhoneUnivInfo) {
				System.out.println("전공을 입력해주세요.");
				String major = kb.nextLine();
				System.out.println("학년을 입력해주세요.");
				String grade = kb.nextLine();
				
				info = new PhoneUnivInfo(editName, phoneNumber, addr, email, major, grade);
				
			} else if(books[index] instanceof PhoneCompanyInfo) {
				
				System.out.println("회사 이름을 입력해주세요.");
				String company = kb.nextLine();
				System.out.println("부서 이름을 입력해주세요.");
				String dept = kb.nextLine();
				System.out.println("직급을 입력해주세요.");
				String job = kb.nextLine();
				
				info = new PhoneCompanyInfo(editName, phoneNumber, addr, email, company, dept, job);
				
			
			} else if(books[index] instanceof PhoneCafeInfo) {
				
				System.out.println("동호회 이름을 입력해주세요.");
				String cafeName = kb.nextLine();
				System.out.println("닉네임을 입력해주세요.");
				String nickName = kb.nextLine();
				
				info = new PhoneCafeInfo(editName, phoneNumber, addr, email, cafeName, nickName);
				
			}
			
			// 배열에 새로운 인스턴스를 저장
			books[index]=info;
			
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
