package table;

public class Student {

	private int id = 0;
	private String name = null;
	private String EGN = null;
	private String adress = null;
	private boolean notDeleted = true;
	static int aid = 1;
	
	
	public Student() {
		this("Sudent","0000000000","City",false);
	}

	public Student(String name, String EGN, String adress,boolean notDeleted) {
		this.id = aid++;
		this.name = name;
		this.EGN = EGN;
		this.adress = adress;
		this.notDeleted = notDeleted;
	}
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getEGN() {
		return EGN;
	}
	public String getAdress() {
		return this.adress;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEGN(String egn) {
		this.EGN = egn;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public boolean isDeleted() {
	     return notDeleted;
	}
	public void setDeleted(boolean deleted) {
	     notDeleted = deleted;
	}
}
