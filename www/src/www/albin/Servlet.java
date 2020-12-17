package www.albin;



import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.log.MonLogger;
import www.utils.Path;
import www.utils.Translate;
import www.albin.Globals;

/**
 * Servlet implementation class Servlet
 */

public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private static String ucFirst(String value) {
		if(value.length()>1) {
			return value.substring(0, 1).toUpperCase()+value.substring(1);
		}
		else if(value.length()==1){
			return value.toUpperCase();
		}
		return "";
	}
	
	private static Map<String,Object> parserUrl(String url){
		String $controller="";
		String $function="";
		String[] $args=null;
		Map <String,Object > urlParse = new HashMap<>();
		int compteur =0; 

		String urlClean = url.replace("-", "_").toLowerCase();
		String[] str = urlClean.split("/");
		
		ArrayList<String> urlSplit = new ArrayList<>();
		for(String s :  str) if(!s.isEmpty() && s!=null) urlSplit.add(s);
		int size=urlSplit.size();

		if(size==0) {
			$controller = "Controller";
			$function="index";

		}else {
			//System.out.println(" START  "+size);
			$controller=Servlet.ucFirst(urlSplit.get(0));
			
			//System.out.println(" $controller toUppercase  =>  "+$controller);
			if(!Servlet.isControllerExist($controller)) {
				$controller = "Controller";
				compteur--;	
			}	
			//System.out.println(" $controller "+$controller+" Compteur =>"+compteur);
			compteur++;	
			$function=compteur >= urlSplit.size()?  "index" : urlSplit.get(compteur) ;
			//System.out.println(" $function "+$function+" Compteur =>"+compteur+" size"+size);
			
			compteur++;
			
			if(size>compteur) {
				
				int longueur = size-compteur;
				$args = new String[longueur];
				int l =0;
				for(int p=compteur;p<size;p++) {
					$args[l]=(String)urlSplit.get(p);
					l++;
				}
			}
		}
		urlParse.put("$controller",$controller);
		urlParse.put("$function",$function);
		urlParse.put("$args",$args);

		
		/*
			System.out.println(" controller  =>"+urlParse.get("$controller"));
			System.out.println(" function  =>"+urlParse.get("$function"));
			System.out.println(" args  =>"+urlParse.get("$args"));
		 */


		return urlParse;
	}

	private static Boolean isControllerExist(String controller){
			String path = Path.PATH_CONTROLLER.getPath()+controller;
			try {
				Class.forName(path);
			}catch(ClassNotFoundException e) {
				return false;
			}
			return true;
	}
	private static Method getMethod(Object o,String function) throws NoSuchMethodException, SecurityException {
		Method[] ms = o.getClass().getDeclaredMethods();
		for(Method s : ms) {
			if(s.getName().equals(function)) {
				System.out.println("Methode find =>"+s.getName()+" for controller +>"+o.getClass().getName());
				System.out.println("Name =>"+s.getName());
				System.out.println("Count =>"+s.getParameterCount());
				System.out.println("paramaeters =>"+s.getParameters().toString());
				System.out.println("type =>"+s.getParameterTypes().toString());		
				Method m = o.getClass().getDeclaredMethod(function, s.getParameterTypes());
				return m;
			}
		}
		return null;
	}
	private static void reflektionMethod(Map<String,Object> parseUrl) throws ExceptionServlet,Exception404{

			String $controller="";
			String $function="";
			String $path="";
			try {
				$controller =(String) parseUrl.get("$controller");
				$function = (String) parseUrl.get("$function");
				$path = Path.PATH_CONTROLLER.getPath()+$controller;
	        	Class<?> c = Class.forName($path);
	        	Object o = c.getDeclaredConstructor(new Class[] {}).newInstance();
	        	Method m = Servlet.getMethod(o,$function);
	        	Object[] $params = parseUrl.get("$args")==null? new String[0]  : (String[]) parseUrl.get("$args");
	        	if(m.getParameterCount()!= $params.length) throw new ExceptionServlet("Il n'y à pas "+ $params.length+"paramètres à passer pour un atendu de " +m.getParameterCount() +"paramètres,\n CONTROLLER =>'"+parseUrl.get("$controller")+"', \n FUNCTION =>'"+parseUrl.get("$function")+"'");
	        	
	        	try {
	        		Globals.controller = $controller;
	        		Globals.method = $function;	        		
	        		m.invoke(o,$params);	

	        	}catch(Exception e) {
	        		throw new ExceptionServlet("IL Y A UNE ERREUR DE CODE DANS  Class "+$controller+"{ "+$function+"() }");
	        	}
	        }
			catch(Exception e) {
	        	throw new ExceptionServlet("ReflektionMethod doesn't find method for request =>"+Globals.request.getRequestURI()+", \n CONTROLLER =>'"+parseUrl.get("$controller")+"',\n FUNCTION =>'"+parseUrl.get("$function")+"'");
	        }
	}
	

	private static String getHeaders(Map<String,Object> parseUrl) {
		

		String protocole = Globals.request.getScheme();
		String nomDomaine = Globals.request.getServerName();
		String port = ""+Globals.request.getServerPort();
		String nomApplication = Globals.request.getContextPath();
		String chemineRessource = Globals.request.getServletPath();
		String local = Globals.request.getLocale().toString();
		String methode = Globals.request.getMethod();
		String userAgent = Globals.request.getHeader("User-Agent");
		String url = Globals.request.getRequestURI();

		StringBuffer sb = new StringBuffer();
		sb.append("****************************************************************").append(System.lineSeparator());
		sb.append("Protocole :").append(protocole).append(System.lineSeparator());
		sb.append("Nom domaine  :").append(nomDomaine).append(System.lineSeparator());
		sb.append("Port :").append(port).append(System.lineSeparator());
		sb.append("Nom application :").append(nomApplication).append(System.lineSeparator());
		sb.append("Chemin de ressource :").append(chemineRessource).append(System.lineSeparator());
		sb.append("Local : ").append(local).append(System.lineSeparator());
		sb.append("Méthode : ").append(methode).append(System.lineSeparator());
		sb.append("Users Agent : ").append(userAgent).append(System.lineSeparator());
		sb.append("url : ").append(url).append(System.lineSeparator());
		sb.append("*PARSING****").append(System.lineSeparator());		
		sb.append("$CONTROLLER => : ").append(parseUrl.get("$controller")).append(System.lineSeparator());
		sb.append("$FUNCTION => : ").append(parseUrl.get("$function")).append(System.lineSeparator());
		String[] arguments = parseUrl.get("$args")==null? new String[0]  : (String[]) parseUrl.get("$args");
		for(String s :  arguments) {
			sb.append("$ args => ").append(""+s).append(System.lineSeparator());	
		}
		sb.append("****************************************************************").append(System.lineSeparator());
		
		return sb.toString();
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Globals.request = request;
		Globals.response=response;	
		Template template=null;
		Globals.bindingElement.put("Template",template);
		
		
		Template pageLayout=new Template("Pagelayout","/view/includes/pagelayout.jsp"); // mon layout
		Template error404=new Template("Error404","/view/errors/errors.jsp"); // ma page d'erreru au cas ou
		//System.out.println("START doGEt");	.
		Map<String,Object> parseUrl = Servlet.parserUrl(request.getServletPath());
		//System.out.println(" retour parseUrl");
		MonLogger.setLogger("Servlet","INFO",Servlet.getHeaders(parseUrl));
		//System.out.println(" retour logger");
		try {	
				Servlet.reflektionMethod(parseUrl);
	        } catch (Exception404 | ExceptionServlet e ) {
	        	Globals.bindingElement.put("Template",error404);
	        }
		//System.out.println("template binding => "+bindingElement.get("Template"));
		Globals.bindingElement.put("Translate",new Translate());
		if(Globals.bindingElement.get("Template")!=null) {
			
			Servlet.sendAttributes();
			request.getServletContext().getRequestDispatcher(pageLayout.getUrl()).forward(request, response);	
		}
		
	}
	private static void sendAttributes() {


        for (Entry<String,Object> entry : Globals.bindingElement.entrySet()) {
            Globals.request.setAttribute((String) entry.getKey(),entry.getValue()); 
         }	

	}	

	public static void sendRedirect(String url)  {
		System.out.println("REDIRECTING FUNCTION ********************************************************* => "+url);
		try {
			System.out.println("TRY REDIRECTING => "+url);
			Globals.response.sendRedirect(url);
			System.out.println("OK REDIRECTING => "+url);
		}catch(Exception e) {
			
		}
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
