package www.bll;
import java.util.ArrayList;

import www.albin.Globals;
import  www.bo.User;
import www.dal.UserDao;
import www.dal.UserNotFoundException;
import www.utils.Connexion;




public class Administrator {

	private String PATH_VIEW ="/view/administrator/";
	

	public  void connexion()  {
		Globals.out("etat => la connexion est "+(Connexion.cnx == null? "fermée" : "ouverte"));
		Globals.bindingElement.put("Template", null);
	}

	public  void get_all_users() {

			
			ArrayList<User> users=new ArrayList<>();
			try {
				users = UserDao.getAll();
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			User u = new User();
			for(int i =0;i<users.size();i++) {
				Globals.out(users.get(i).toString());
				
			}


	}

}
