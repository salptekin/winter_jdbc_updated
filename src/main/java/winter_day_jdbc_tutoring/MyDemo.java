package winter_day_jdbc_tutoring;

	/*
	 			Steps to create POJO Class
	 	a)Create private variables +
 		b)Create all getters and setters +
 		c)Create Constructor with all variables +
 		d)Create toString() method
	*/

public class MyDemo {
	
	private int demo_id;
	private String name_of_demo;
	private String demo_address;
	private int demo_code;
	
	public MyDemo(int demo_id, String name_of_demo, String demo_address, int demo_code) {
		this.demo_id = demo_id;
		this.name_of_demo = name_of_demo;
		this.demo_address = demo_address;
		this.demo_code = demo_code;
	}
	
	public int getDemo_id() {
		return demo_id;
	}
	public void setDemo_id(int demo_id) {
		this.demo_id = demo_id;
	}
	public String getName_of_demo() {
		return name_of_demo;
	}
	public void setName_of_demo(String name_of_demo) {
		this.name_of_demo = name_of_demo;
	}
	public String getDemo_address() {
		return demo_address;
	}
	public void setDemo_address(String demo_address) {
		this.demo_address = demo_address;
	}
	public int getDemo_code() {
		return demo_code;
	}
	public void setDemo_code(int demo_code) {
		this.demo_code = demo_code;
	}

	@Override
	public String toString() {
		return "MyDemo [demo_id=" + demo_id + ", name_of_demo=" + name_of_demo + ", demo_address=" + demo_address
				+ ", demo_code=" + demo_code + "]";
	}

}
