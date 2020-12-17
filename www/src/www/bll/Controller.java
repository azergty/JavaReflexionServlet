package www.bll;

import www.albin.Globals;
import www.albin.Template;
import www.bo.User;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Controller {

	private String PATH_VIEW ="/view/controller/";
	

	public  void index() {

		Template index = new Template("Index","/view/index.jsp");
		Globals.bindingElement.put("Template", index);

	}

	public  void  test() {

		Globals.request.getSession().setAttribute("name","Albin"); // Put user in session.
		System.out.println("User session => "+Globals.request.getSession().getAttribute("name").toString() );
		Template test = new Template("Test",PATH_VIEW+"test.jsp");
		Globals.bindingElement.put("Template", test);

	}

}
