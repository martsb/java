package majasDarbi;

import java.util.ArrayList;

public class th {
	String  name;
	String lastName;
	int id;
	ArrayList<th> list = new ArrayList<>();
	
	th(String name, String lastName, int id){
		this.name = name;
		this.lastName = lastName;
		this.id = id;
		list.add(this);
	}
	
	public String toString(){
		return "name: "+name+", lastname: "+lastName+", id: "+id;
	}
}
