package www.rules;

public class RuleRegexp extends Rule{


	public final static String REGEXP_TEXT ="^[a-z 0-9 A-Z\\s@]*$" ;
	public final static String REGEXP_EMAIL ="^[a-zA-Z0-9._%+-]+@[A-Z0-9a-z.-]+\\.[a-zA-Z]{2,6}$" ;
	public final static String REGEXP_PASSWORD ="^[0-9 a-zA-Z\\s@]*$" ;
	public final static String REGEXP_LNG ="^[-+]?([0]{1})?[0-9]{1},[0-9]+$";
	public final static String REGEXP_LAT="^[-+]?[4-5]{1}[0-9]{1},[0-9]+$";
	public final static String REGEXP_POSTAL ="^(([0-8][0-9])|(9[0-5]))[0-9]{3}$";

	
	public String regexp;
	public String param;
	public RuleRegexp(String regexp) {
		this.regexp = regexp;

	}
	@Override
	public boolean exec(String param,String value) {
		this.param=param;
		String val = ""+value;
		return val.matches(this.regexp);
	}
	@Override
	public String getError() {
	
		return "Ce champs n'est pas conforme.";
	}
	
	

}
