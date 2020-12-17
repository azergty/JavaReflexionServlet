package www.rules;

public class RuleMinLength extends Rule {
	
	public int minLength;
	public  String param;
	public Object value;
	public RuleMinLength(int minlength) {
		this.minLength=minlength;
	}
	
	@Override
	public boolean exec(String param,String value) {
		this.value=value;
		this.param=param;

		String val = ""+value;
		return val.length()>=this.minLength;

	}

	@Override
	public String getError() {
		String val = ""+this.value;
		if(val.length()==0) return "Ce champ est obligatoire.";
		return "Ce champ à un nombre de caractères inférieur à "+this.minLength+".";
	}

}
