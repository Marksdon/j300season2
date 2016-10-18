package priv.xzc.season2.map;
/**
 * javaBeen po bo vo 专门存储数据的类
 * @author randall
 *
 */
public class Letter {
	private String name;
	private int count;

	//快捷键  alt+/
	public Letter() {
	}


	//快捷键 alt+shift+s-->o
	public Letter(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}


	public Letter(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}

	
	//set & get 
	//alt+shift+s+-->r--tab-->enter->shift+tab -->enter

	
	

}
