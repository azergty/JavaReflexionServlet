package www.utils;

import java.util.Enumeration;
import java.util.HashMap;

import www.albin.Globals;

public class Attributes {

	
	
	public static HashMap<String,Object> get() {
		
			HashMap<String,Object> attributes = new HashMap<>();
			
	       Enumeration<String> parameterNames = Globals.request.getParameterNames();
	       
	        while (parameterNames.hasMoreElements()) {
	 
	            String paramName = parameterNames.nextElement();
	            System.out.print(paramName);
	            System.out.print(" = ");
	 
	            String[] paramValues =Globals.request.getParameterValues(paramName);
	            if(paramValues.length == 1) attributes.put(paramName,paramValues[0]);
	            else  attributes.put(paramName,paramValues);
	            
	            for (int i = 0; i < paramValues.length; i++) {
	                String paramValue = paramValues[i];
	                System.out.print("\t " + paramValue);
	                System.out.print("\n");
	            }
	 
	        }
	        return attributes;
		
	}
}
