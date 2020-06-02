package manager;

import java.util.List;

public class DEPTManager {

	DeptDao dao = new DeptDao();

	/////////////////////////////////////////////////////////////////
	// DEPT MANAGER
	/////////////////////////////////////////////////////////////////

	public void deptManager() {

		System.out.println("DEPT Manager Menu");
		System.out.println("=========================================");
		System.out.println("1. List  2. Insert  3. Search  4. Delete  5. Edit  ");
		System.out.println("=========================================");

		int select = ManageMain.sc.nextInt();

		switch (select) {
		case 1:
			System.out.println("전체 리스트 출력");
			deptList();
			break;
		case 2:
			System.out.println("부서 정보를 입력합니다.");
			deptInsert(); // 사용자의 입력데이터 dept 객체에 담아서 dao insert 메서드로 전달
			break;
		case 3:
			System.out.println("부서 정보를 검색합니다.");
			deptSearch(); // 사용자가 입력한 이름을 dao search 전달
			break;
		case 4:
			System.out.println("부서 정보를 삭제합니다.");
			deptDelete(); // 이름 또는 부서번호 dao delete 전달
			break;
		case 5:
			System.out.println("부서 정보를 수정합니다.");
			deptEdit(); // 1. 수정ㅎ고자 하는 데이터 유무 확인 -> 2.사용자로부터 데이터 받아서 전달
			break;

		}

	}

	public void deptEdit() {

		// 1. 수정하고자 하는 데이터 유무 확인 -> 2.사용자로부터 데이터 받아서 전달

		// 사용자 입력정보 변수

		System.out.println("수정하고자 하는 부서 이름 : ");
		ManageMain.sc.nextLine();
		String searchName = ManageMain.sc.nextLine();
		
		// 1. 수정하고자 하는 데이터 유무 확인
		
		int rowCnt = dao.deptSearchName(searchName);
		System.out.println(rowCnt);
		
		
		
		
		
		
		
		
		
		
		
		

	}

	public void deptInsert() {

		// 사용자 입력정보 변수
		System.out.println("부서 정보를 입력해주세요.");

		System.out.println("부서번호 : ");
		int deptno = ManageMain.sc.nextInt();
		System.out.println("부서이름 : ");
		ManageMain.sc.nextLine();
		String dname = ManageMain.sc.nextLine();
		System.out.println("지역 : ");
		String loc = ManageMain.sc.nextLine();

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		Dept dept = new Dept(deptno, dname, loc);

		int resultCnt = dao.deptInsert(dept);

		if (resultCnt > 0) {
			System.out.println("정상적으로 입력 되었습니다.");
			System.out.println(resultCnt + "행이 입력되었습니다.");
		} else {
			System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
		}

	}

	public void deptDelete() {

		// 사용자 입력정보 변수

		System.out.println("삭제하고자 하는 부서이름 : ");
		ManageMain.sc.nextLine();
		String searchName = ManageMain.sc.nextLine();

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		int resultCnt = dao.deptDelete(searchName);

		if (resultCnt < 1) {
			System.out.println("삭제할 정보가 검색 결과가 없습니다.");
		} else {
			System.out.println(resultCnt + "행이 삭제 되었습니다.");
		}

		System.out.println("=================================");

	}

	public void deptSearch() {

		// 사용자 입력정보 변수

		System.out.println("검색하고자 하는 부서이름 : ");
		ManageMain.sc.nextLine();
		String searchName = ManageMain.sc.nextLine();

		List<Dept> list = dao.deptSearch(searchName);

		System.out.println("검색 결과");
		System.out.println("======================================");
		for (Dept d : list) {
			System.out.printf("%5s", d.getDeptno() + "\t");
			System.out.printf("%12s", d.getDname() + "\t");
			System.out.printf("%12s", d.getLoc() + "\n");
		}
		System.out.println("======================================");

	}

	public void deptList() {

		List<Dept> deptList = dao.deptList();

		if (deptList != null && !deptList.isEmpty()) {

			for (int i = 0; i < deptList.size(); i++) {
				System.out.printf("%5s", deptList.get(i).getDeptno() + "\t");
				System.out.printf("%12s", deptList.get(i).getDname() + "\t");
				System.out.printf("%12s", deptList.get(i).getLoc() + "\n");
			}
		} else {
			System.out.println("입력된 데이터가 없습니다.");
		}

	}

}
