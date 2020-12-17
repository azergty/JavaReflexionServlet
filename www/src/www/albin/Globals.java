package www.albin;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Globals {

	public static HttpServletRequest request=null;
	public static HttpServletResponse response = null;
	public static String controller = null;
	public static String method = null;
	public static String lang = "fr";
	public static HashMap<String,Object> bindingElement=new HashMap<>();
	public static PrintWriter out = null;

	static PrintWriter getWriter() {
		
		try {
			return  Globals.response.getWriter();
		} catch (IOException e) {
				System.out.println("Probleme avec le printwriter");
		}
		return null;
	}
	
	
	public static void out(String content) {

		out =  Globals.getWriter();
		out.println(content);
	}
	
}
