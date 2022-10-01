package table;

import java.util.ArrayList;
import java.util.List;

public class StudentList {

	private static List<Student> listStudent = new ArrayList<Student>();
	private static List<Student> listStudentNotDelete = new ArrayList<Student>();
	private static List<Student> listStudentDelete = new ArrayList<Student>();
	
	
	public static void addStudent(String name, String egn, String adress,boolean deleted) {
		Student student = new Student(name,egn,adress,deleted);
		listStudent.add(student);
	}
	public static void deleteList() {
		listStudentDelete.clear();
		for(Student std: listStudent) {
			if(std.isDeleted() == false)
				listStudentDelete.add(std);
		}
	}
	private static void notDeleteList() {
		listStudentNotDelete.clear();
		for(Student student: listStudent) {
			if(student.isDeleted() == true)
				listStudentNotDelete.add(student);
		}
	}
	public static Student getStudent(int id) {
		for(Student student : listStudent){
			if(student.getId() == id)
				return student;
		}
		return null;
	}
	public static int getSize() {
		int size = listStudent.size();
		return size;
	}
	public static void editStudent(int id,String newname, String egn, String adress) {
		Student student = getStudent(id);
		student.setName(newname);
		student.setEGN(egn);
		student.setAdress(adress);
	}
	public static Object[][] list(boolean isDelete) {
		List<Student> list; 
		if(isDelete == true) {
			deleteList();
			list = listStudentDelete;
		}
		else {
			notDeleteList();
			list = listStudentNotDelete;
		}
		Object str[][] = new Object[list.size() ][4];
		for(int i =0; i <  list.size();i++) {
    	 for(int j = 0; j < 4; j++) {
    			 if(j == 0) 
        			 str[i][j] = String.valueOf( list.get(i).getId());
        		 else if(j == 1)
        			 str[i][j] = list.get(i).getName().toString(); 
        		 else if(j == 2)
        			 str[i][j] =  list.get(i).getEGN().toString();
        		 else if(j == 3) str[i][j] =  list.get(i).getAdress().toString();
    	 }
     } return str;
    }
	
	
	
	
	
	

}
