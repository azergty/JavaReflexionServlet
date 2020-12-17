package www.rules;

public class RuleMaxLength extends Rule{
	
	public static final int LENGTH_TEXT=45;
	public static final int LENGTH_PASSWORD=8;
	public static final int LENGTH_EMAIL=45;
	
	public int length;
	public String param;
	public RuleMaxLength(int length) {
		
		this.length = length;
		
	}
	
	@Override
	public boolean exec(String param,String value) {
		this.param=param;
		String val =""+value;
		return val.length()<=this.length;
	}

	@Override
	public String getError() {
		
		return "Ce champs dépasse les "+this.length+" caractères.";
	}

	
	
	
	
	
	
	
	
	
}
