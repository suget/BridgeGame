package entity;

/**
 * 公告信息类
 * @author Time
 *
 */
public class Note {
	
	/**
	 * 公告信息类的私有成员变量
	 */
	private int id;		// 公告编号
	private String inf;	// 公告内容
	
	
	public Note() {
		super();
	}

	public Note(int id, String inf) {
		super();
		this.id = id;
		this.inf = inf;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInf() {
		return inf;
	}

	public void setInf(String inf) {
		this.inf = inf;
	}
	
	
	public static void main(String[] args) {
		
	}
	
}
