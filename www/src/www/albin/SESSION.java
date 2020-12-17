package www.albin;

import javax.servlet.http.HttpSession;

import www.bo.User;

public class SESSION {
		private static User user =null;
		
		public static void setSession(User u ) {
			
			user=u;
			
			HttpSession session = Globals.request.getSession();
			
			session.setAttribute("name",u.getName());
			session.setAttribute("id",u.getId());
			session.setAttribute("email",u.getEmail());
			session.setAttribute("id_type_user",u.getId_type_user());
			
		}
		
		public static User getSession() {
			return user;
		}
		
		
		public static void destroySession() {
			user = null;
			Globals.request.getSession().invalidate();
			
		}
		
		
}
