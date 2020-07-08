package guestbook.dao;

public class MessageDao {
	
	private MessageDao() {}
	static private MessageDao dao = new MessageDao();
	public static MessageDao getInstance() {
		return dao;
	}

}
