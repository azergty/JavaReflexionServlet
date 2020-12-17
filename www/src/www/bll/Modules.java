package www.bll;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.albin.Globals;
import www.albin.Template;


public class Modules {

	private String PATH_VIEW ="/view/modules/";


	public  void tp_1() {

		Template index = new Template("tp_1",PATH_VIEW+"tp_1.jsp");
		Globals.bindingElement.put("Template", index);

	}

	public  void  tp_2() {

		Template tp_2 =new Template ("tp_2",PATH_VIEW+"tp_2.jsp");
		Globals.bindingElement.put("Template", tp_2);

	}
	public  void  liste_des_modules() {

		Template liste_des_modules = new Template("Liste des modules",PATH_VIEW+"modules.jsp");
		Globals.bindingElement.put("Template", liste_des_modules);

	}	
	

}
