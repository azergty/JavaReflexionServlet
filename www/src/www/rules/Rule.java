package www.rules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public abstract class Rule {


	public static HashMap<String,ArrayList> verifForm(HashMap <String,Object> params, HashMap<String,ArrayList<Rule>> rules) {
		
		HashMap<String,ArrayList> errors = new HashMap<>();
		System.out.println(" ------------------------- RULES ------------------------------ ");
		for (Map.Entry mapentry : rules.entrySet()) {
			

			if(params.get(""+mapentry.getKey()) instanceof String) {
				
				String value = (params.containsKey(""+mapentry.getKey())? ""+params.get(""+mapentry.getKey()) : "");
				System.out.println("Key: "+mapentry.getKey() + " => "+ value );
				
				ArrayList<String> errorParam = new ArrayList<>();

				ArrayList <Rule> rule = (ArrayList<Rule>) mapentry.getValue();
				for (int i=0;i<rule.size();i++) {
					System.out.println("\t Rule n° "+i +" "+rule.get(i).getClass().getCanonicalName());
					Rule r = (Rule) rule.get(i);
					boolean b = r.exec((String)mapentry.getKey(),value);
					System.out.println("\t\t  Exec =>boolean "+b);
					if(!b) {
						System.out.println("\t\t ERROR =>error  "+r.getError());
						errorParam.add(r.getError());
					}
					System.out.println("\t\t\t\t  ---------");
				}
				
				if(errorParam.size()>0) errors.put((String)mapentry.getKey(), errorParam);
				
			}
               
         }
		
		
		
		System.out.println(" -------------------------END RULES ------------------------------ ");
		System.out.println(" ------------------------- ERRORS ------------------------------ ");
		for (Map.Entry mapentri : errors.entrySet()) {
			System.out.println("******");
			System.out.println(mapentri.getKey() +" ");	
			ArrayList<String> uno = ((ArrayList) mapentri.getValue());
			
			for(int u=0;u<uno.size();u++) {
				System.out.println(" \t"+ uno.get(u)+" ");
			}
			
			
		}
		System.out.println(" ------------------------- END ERRORS ------------------------------ ");
		
		
		return errors;

	}
	
	
	
	public abstract boolean exec(String param,String value);
	
	public abstract String getError();
}
