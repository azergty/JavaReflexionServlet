package www.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import www.rules.Rule;
import www.rules.RuleMaxLength;
import www.rules.RuleMinLength;
import www.rules.RuleRegexp;

public class User {

    private String name;
    private Integer actif;
    private Integer id;
    private String password;
	private Integer id_type_user;
	private String email;
	private String adresse;
	private String ville;
	private String cp;
	private Double latitude;
	private Double longitude;

	private static HashMap <String,ArrayList<Rule>> rules;
	static {
		
		rules = new HashMap <>();
    	
    	ArrayList<Rule> name = new ArrayList<>();
    	name.add(new RuleMinLength(1));
    	name.add(new RuleRegexp(RuleRegexp.REGEXP_TEXT));
    	name.add(new RuleMaxLength(RuleMaxLength.LENGTH_TEXT));
    	rules.put("name",name);
    	
    	ArrayList<Rule> password = new ArrayList<>();
    	password.add(new RuleMinLength(8));
    	password.add(new RuleRegexp(RuleRegexp.REGEXP_PASSWORD));
    	password.add(new RuleMaxLength(RuleMaxLength.LENGTH_PASSWORD));
    	rules.put("password",password);  	
    	
    	ArrayList<Rule> email = new ArrayList<>();
    	email.add(new RuleMinLength(1));
    	email.add(new RuleRegexp(RuleRegexp.REGEXP_EMAIL));
    	email.add(new RuleMaxLength(RuleMaxLength.LENGTH_EMAIL));
    	rules.put("email",email);    	
    	
    	ArrayList<Rule> adresse = new ArrayList<>();
    	adresse.add(new RuleMinLength(1));
    	adresse.add(new RuleRegexp(RuleRegexp.REGEXP_TEXT));
    	adresse.add(new RuleMaxLength(RuleMaxLength.LENGTH_TEXT));
    	rules.put("adresse",adresse); 
    	
    	ArrayList<Rule> cp = new ArrayList<>();
    	cp.add(new RuleMinLength(1));
    	cp.add(new RuleRegexp(RuleRegexp.REGEXP_POSTAL));
    	cp.add(new RuleMaxLength(10));
    	rules.put("cp",cp);     	

    	ArrayList<Rule> ville = new ArrayList<>();
    	ville.add(new RuleMinLength(1));
    	ville.add(new RuleRegexp(RuleRegexp.REGEXP_TEXT));
    	ville.add(new RuleMaxLength(RuleMaxLength.LENGTH_TEXT));
    	rules.put("ville",ville); 	

	}
	
    public User(String name,Integer actif,Integer id,String password,Integer id_type_user,String email,String adresse,String ville,String cp,Double latitude,Double longitude) {
    	this.name=name;
		this.actif = actif;
		this.id=id;
		this.id_type_user=id_type_user;
		this.password=password;
		this.email=email;
		this.adresse=adresse;
		this.ville=ville;
		this.cp=cp;
		this.latitude=latitude;
		this.longitude=longitude;
    }
    
    public User(HashMap <String,Object> u) {
    	
    	this(""+u.get("name"), 1, null, ""+u.get("password"), 2, ""+u.get("email"), ""+u.get("adresse"), ""+u.get("ville"), ""+u.get("cp"), 0.00000, 0.0000000);
    	//this(""+u.get("name"), 1, null, "123", 1, "a@", ""+u.get("adresse"), ""+u.get("ville"), ""+u.get("cp"), 0.00000, 0.0000000);
    	
    }
    public User( ) {
    	this(null, null, null, null, null, null, null, null, null, null, null);
    }
    public User(ResultSet rs) throws SQLException {

    	this(
    			rs.getString("name"),
    			rs.getInt("actif"),
    			rs.getInt("id"),
    			rs.getString("password"),
    			rs.getInt("id_type_user"),
    			rs.getString("email"),
    			rs.getString("adresse"),
    			rs.getString("ville"),
    			rs.getString("cp"),
    			rs.getDouble("latitude"),
    			rs.getDouble("longitude")
    		);

    }
    
    public static HashMap<String,ArrayList<Rule>>getRegisterRules(){

    	return rules;
    }
    public static ArrayList<Rule> getRegisterRules(String key){
    	
    	 ArrayList<Rule> rule = new ArrayList<>();
    	 rule.addAll(rules.get(key));
    	return rule;
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getActif() {
		return actif;
	}

	public void setActif(int actif) {
		this.actif = actif;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId_type_user() {
		return id_type_user;
	}

	public void setId_type_user(int id_user_type) {
		this.id_type_user = id_user_type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", actif=" + actif + ", id=" + id + ", password=" + password + ", id_user_type="
				+ id_type_user + ", email=" + email + ", adresse=" + adresse + ", ville=" + ville + ", cp=" + cp
				+ ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		this.id=id;
	}

}
