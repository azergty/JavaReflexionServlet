package www.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import www.bo.User;
import www.utils.Connexion;

public class UserDao{
   
	static Statement stm=null;
    static ResultSet rs=null;
    static  PreparedStatement pstm=null;
    private static String GET_ALL_USERS="SELECT * FROM users";
    private static String GET_USER_BY_ID="SELECT * FROM users WHERE id =?";
    private static String GET_USER_BY_ID_TYPE_USER="SELECT * FROM users WHERE id_type_user =?";
    private static String UPDATE_USER="UPDATE users SET id_type_user=?, name=?,email=?,password=?,actif=?,adresse=?,ville=?,cp=?,latitude=?,longitude=? WHERE id=?";
    private static String GET_USER_BY_EMAIL="SELECT * FROM users WHERE email =?";
    private static String INSERT_USER="INSERT INTO users (id_type_user,name,email,password,actif,adresse,ville,cp,latitude,longitude) VALUES(?,?,?,?,?,?,?,?,?,?)";
    private static String SELECT_USER_CONNECTION="SELECT * FROM users WHERE password=? AND email = ?";
	public UserDao() {
		
	}
	
	public static User setUserConnection(String password,String email) throws UserNotFoundException {
		
		 User u = null;
			try {
	            pstm=Connexion.cnx.prepareStatement(SELECT_USER_CONNECTION);
	            pstm.setString(1,password);
	            pstm.setString(2,email);
	            rs=pstm.executeQuery();
	            while(rs.next()){
	                u = new User(rs);
	            }
	            return u;	
	        }catch(SQLException e){
	            throw new UserNotFoundException("Une erreur est survenue lors de la requête "+SELECT_USER_CONNECTION+" dans la base de donnée.");
	        }		

	}
	
	public static Boolean create(User u) throws UserNotFoundException {
		try {
            pstm=Connexion.cnx.prepareStatement(INSERT_USER,Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1,u.getActif());
            pstm.setString(2,u.getName());
            pstm.setString(3,u.getEmail());
            pstm.setString(4,u.getPassword());
            pstm.setInt(5,u.getActif());
            pstm.setString(6,u.getAdresse());
            pstm.setString(7,u.getVille());
            pstm.setString(8,u.getCp());
            pstm.setDouble(9,u.getLatitude());
            pstm.setDouble(10,u.getLongitude());

            pstm.executeUpdate();

            int affectedRows = pstm.executeUpdate();
            if (affectedRows == 0) {
            	throw new UserNotFoundException("La création du nouveau User u ="+u.toString()+" a échoué");
            }else {
                try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        u.setId((int) generatedKeys.getLong(1));
                    }else { 
                        throw new UserNotFoundException("La création du nouveau User u ="+u.toString()+" a échoué car Sql n'a pas retourné d'id");
                    }
                }catch(SQLException e) {

                	throw new UserNotFoundException("La création du nouveau User u ="+u.toString()+" a échoué car Resultset-GeneratedKey n'a pas retourné d'id");
                }
            }
            return true;
        }catch(SQLException e ){
            throw new UserNotFoundException("Une erreur inconnue est survenue lors de l'insertion d'un nouveau client pour la requête "+INSERT_USER+" dans la base de donnée");
        }

	}
	
	public static User getById(Integer id) throws UserNotFoundException {
		 User u = null;
		try {
            pstm=Connexion.cnx.prepareStatement(GET_USER_BY_ID);
            pstm.setInt(1,id);
            rs=pstm.executeQuery();
            while(rs.next()){
                u = new User(rs);
            }
            return u;	
        }catch(SQLException e){
            throw new UserNotFoundException("Une erreur est survenue lors de la requête "+GET_USER_BY_ID+" dans la base de donnée.");
        }
	}
	
	public static User getByEmail(String email) throws UserNotFoundException {
		 User u = null;
		try {
           pstm=Connexion.cnx.prepareStatement(GET_USER_BY_EMAIL);
           pstm.setString(1,email);
           rs=pstm.executeQuery();
           while(rs.next()){
               return(new User(rs)); 
           }
           	return null;
       }catch(SQLException e){
           throw new UserNotFoundException("Une erreur est survenue lors de la requête "+GET_USER_BY_ID+" dans la base de donnée.");
       }
	}
	
	public static User update(User u) throws UserNotFoundException {
		try {
            pstm=Connexion.cnx.prepareStatement(UPDATE_USER,Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1,u.getActif());
            pstm.setString(2,u.getName());
            pstm.setString(3,u.getEmail());
            pstm.setString(4,u.getPassword());
            pstm.setInt(5,u.getActif());
            pstm.setString(6,u.getAdresse());
            pstm.setString(7,u.getVille());
            pstm.setString(8,u.getCp());
            pstm.setDouble(9,u.getLatitude());
            pstm.setDouble(10,u.getLongitude());
            pstm.setFloat(11,u.getId());
            pstm.executeUpdate();

            int affectedRows = pstm.executeUpdate();
            if (affectedRows == 0) {
            	throw new UserNotFoundException("La mise à jour du User id ="+u.getId()+" a échoué");
            }
            return u;
        }catch(SQLException e  ){
            throw new UserNotFoundException("Une erreur est survenue lors de la mise à jour du client pour la requête "+UPDATE_USER+" dans la base de donnée");
        }
	}
	
	public static ArrayList<User> getAll() throws UserNotFoundException{
		ArrayList<User> users = new ArrayList<>();
	  try {

          	stm=Connexion.cnx.createStatement();
		  	rs=stm.executeQuery(GET_ALL_USERS);
            while(rs.next()){
                User u = new User(rs);
                users.add(u);
            }
            return users;	
        }catch(SQLException e){
        	e.printStackTrace();
            throw new UserNotFoundException("Une erreur est survenue lors de la requête "+GET_ALL_USERS+" dans la base de donnée.");
        }
	}
	
}
