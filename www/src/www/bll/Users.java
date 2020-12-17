package www.bll;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import www.albin.Globals;
import www.albin.SESSION;
import www.albin.Servlet;
import www.albin.Template;
import www.rules.Rule;
import www.bo.User;
import www.dal.UserDao;
import www.dal.UserNotFoundException;
import www.utils.Affichage;
import www.utils.Attributes;

public class Users {

		private static String PATH_VIEW ="/view/users/";


		public  static void inscription() {
			Template inscription = new Template("Index",PATH_VIEW+"inscription.jsp");
			Globals.bindingElement.put("Template", inscription);
		}
		
		public static void index() {
			if(Globals.request.getSession()!=null) {
				//Template my_account = new Template("mon compte",PATH_VIEW+"account.jsp");
				//Globals.bindingElement.put("Template", my_account);	
				Globals.bindingElement.put("Template", null);
				PrintWriter out=null;
				try {
					out = Globals.response.getWriter();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				HttpSession session = Globals.request.getSession();
				out.print("USER=> "+session.getAttribute("user"));
				//User u = (User) session.getAttribute("user");
			}else Servlet.sendRedirect("/www/users/connexion");
		}
		public  static void connexion() {

				System.out.println("Mathod actuel =>"+Globals.method);
				Template connexion = new Template("Index",PATH_VIEW+"connexion.jsp");
				Globals.bindingElement.put("Template", connexion);				
		}
		
		public  static void deconnexion() {
			SESSION.destroySession();
			Globals.bindingElement.put("Template", null);
			Servlet.sendRedirect("/www/");
		}
			
		public static void request_connexion() {
			
			HashMap<String,Object> newUser = Attributes.get();

			HashMap<String,ArrayList<Rule>> rules  = new HashMap<>();
			rules.put("password",User.getRegisterRules("password"));
			rules.put("email",User.getRegisterRules("email"));
			HashMap <String,ArrayList> errors = Rule.verifForm(newUser,rules);
			ArrayList <String> warning = new ArrayList <>();
			if(errors.isEmpty()) {
				
				try {
					User connection = UserDao.setUserConnection(""+newUser.get("password"),""+newUser.get("email"));
					if(connection==null) {
	
						SESSION.setSession(connection);
						Servlet.sendRedirect("/www/users");						
					}else {
						warning.add("L'email ou mot de passe invalide");
						errors.put("warning", warning);
					}
				}catch(UserNotFoundException e) {
					e.printStackTrace();
					warning.add("Une erreur est sruvenue au sein du serveur");
					errors.put("warning", warning);
				}
			}
			
			if(!errors.isEmpty()) {
				Globals.request.setAttribute("User", newUser);
				Globals.request.setAttribute("Errors", errors);
				Globals.bindingElement.put("Template", null);
				Users.connexion();				
			}
			
		}
		
		
		public  static void  request_inscription() {

			
			HashMap<String,Object> newUser = Attributes.get();
			
			HashMap<String,ArrayList<Rule>> rules = User.getRegisterRules();
			
			HashMap <String,ArrayList> errors = Rule.verifForm(newUser,rules);
			ArrayList <String> warning = new ArrayList <>();
			
			if(errors.isEmpty()) {
				User u = new User(newUser);

				try {
					User test = UserDao.getByEmail(""+newUser.get("email"));
					if(test==null) {
						Boolean ok = UserDao.create(u);
						SESSION.setSession(u);
						Servlet.sendRedirect("/www/users");						
					}else {
						
						warning.add("L'email est déja actuellement utilisé");
						errors.put("warning", warning);
					}
				}
				catch(UserNotFoundException e)
				{
					warning.add("Une erreur est sruvenue au sein du serveur");
					errors.put("warning", warning);
				}
				
			}
			
			if(!errors.isEmpty()) {
				Globals.request.setAttribute("User", newUser);
				Globals.request.setAttribute("Errors", errors);
				Globals.bindingElement.put("Template", null);
				
				Users.inscription();				
			}

			//Servlet.sendRedirect("/www/user/inscription");

		}

	}
