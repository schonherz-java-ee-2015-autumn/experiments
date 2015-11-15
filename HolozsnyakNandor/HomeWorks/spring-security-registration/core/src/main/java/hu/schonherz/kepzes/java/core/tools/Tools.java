package hu.schonherz.kepzes.java.core.tools;

public class Tools {

	public Tools() {
		
	}
	public String determinateOrderBy(String orderBy) {
		switch(orderBy) {
		case "0":
			return new String("user_name");
		case "1":
			return new String("full_name");
		case "2":
			return new String("email");
		case "3":
			return new String("birth_place");
		case "4":
			return new String("birth_date");
		default:
			return new String("user_name");
		}		
	}
}
