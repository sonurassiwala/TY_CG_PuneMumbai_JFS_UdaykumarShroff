
public class Facebook {

	final void login(long phno,String pswd) {	//final method can be overloaded
		System.out.println("Logged-In through phno");
	}
	
	final void login(String email, String pswd) {
		System.out.println("Loiggged-In through email");
	}
	
}
