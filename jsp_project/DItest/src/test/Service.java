package test;

public class Service {

	// Service 클래스는 Dao 클래스에 의존한다.
	//Dao dao = new Dao();
	
	Dao dao;
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	public void print() {
		dao.print();
	}
	


	
	
	
	
	
	
}
