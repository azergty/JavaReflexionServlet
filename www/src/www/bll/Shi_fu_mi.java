package www.bll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.albin.Globals;
import www.albin.Servlet;
import www.albin.Template;
import www.utils.Path;
import www.utils.Utils;

public class Shi_fu_mi {
	
	private String PATH_VIEW ="/view/shi_fu_mi/";

	public  void  play() {
		Template shi_fu_mi = new Template("Shi Fu Mi",PATH_VIEW+"play.jsp");
		Globals.bindingElement.put("Template", shi_fu_mi);
	}	
	public void win() {
		Template win = new Template("Shi Fu Mi - Win",PATH_VIEW+"win.jsp");
		Globals.bindingElement.put("Template", win);

	}
	public void loose() {
		
		Template loose = new Template("Shi Fu Mi - losse",PATH_VIEW+"loose.jsp");
		Globals.bindingElement.put("Template", loose);		

	}		
	public void send_combinaison() {

		Boolean win = false;
		Map<String, String[]> params = Globals.request.getParameterMap();
		if(params.containsKey("combinaison")) {
			String valueString = params.get("combinaison")[0];
			int value = Integer.parseInt(valueString);
			int computer =Utils.getRandomNumberInRange(0,3); 
			if(value>computer) win = true;
		}
		Globals.bindingElement.put("Template", null);	
		if(win) Servlet.sendRedirect(Path.PATH_WEB.getPath()+"shi-fu-mi/win");
		else Servlet.sendRedirect(Path.PATH_WEB.getPath()+"shi-fu-mi/loose");

	}		
	

}
