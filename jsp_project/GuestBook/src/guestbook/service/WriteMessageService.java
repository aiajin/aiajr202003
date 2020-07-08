package guestbook.service;

import guestbook.dao.MessageDao;
import guestbook.model.Message;

public class WriteMessageService {
	
	private WriteMessageService() {}
	private static WriteMessageService service = new WriteMessageService();
	public static WriteMessageService getIstance() {
		return service;
	}
	
	
	
	MessageDao dao = null;
	
	public int writeMessage(Message mesage) {
		int result = 0;
		dao = MessageDao.getInstance();
		
		
		return result;
	}

}
