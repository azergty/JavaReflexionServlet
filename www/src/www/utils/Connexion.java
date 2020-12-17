package www.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import www.albin.Globals;

public class Connexion {

	public static Connection cnx = null;
	static {
		PrintWriter out=null;
		try {
			out = Globals.response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("euhh...");
		}
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/cnx");
				out.println(" ressource ok"); 
			cnx = ds.getConnection();
			out.print("La connextion est "+ (cnx.isClosed()? "fermée" : "ouverte"));
		}catch(NamingException | SQLException e) {
			e.printStackTrace();
			Globals.response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			out.println("Une errerur est survenue lors de l'initilaisiton à l'accès de la base de donnée "+e.getMessage());
		}
		
		
		
	}
	
	static void closed() {
		
		try {
			if(!cnx.isClosed()) {
				cnx.close();
				System.out.println("CLOSED");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERREUR LORS DE L'ESSAIE de la fermeture");
		}
		
	}
	
}
