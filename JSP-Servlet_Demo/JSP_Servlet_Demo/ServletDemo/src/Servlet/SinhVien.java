package Servlet;

public class SinhVien {
    private String svId;
	private String name;
	private int age;
	/**
     * @return the svId
     */
    public String getSvId() {
        return svId;
    }
    /**
     * @param svId the svId to set
     */
    public void setSvId(String svId) {
        this.svId = svId;
    }
    /**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	public SinhVien(String svId, String name, int age) {
		super();
		this.svId = svId;
		this.name = name;
		this.age = age;
	}
	public SinhVien() {};
	
	
}
