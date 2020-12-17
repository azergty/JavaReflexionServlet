package www.utils;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;

public class Affichage {

	
	public static void arrayList(ArrayList arr) {
		
		for(int i=0;i<arr.size();i++) {
			System.out.println(" ligne-"+i+" : " +arr.get(i));
		}
		
	}
	
	
	public static void map(Map<Object,Object> arr) {
        for (Map.Entry mapentry : arr.entrySet()) {
           System.out.println("Key: "+mapentry.getKey() + " | value: " + mapentry.getValue());
                              
        }
	}
		
	public static void array(String[] arr) {
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(" ligne-"+i+" : " +arr[i]);
		}
		
	}


	public static void mapArray(Map<String, String[]> params) {

        for (Map.Entry mapentry : params.entrySet()) {
            System.out.print("Key: "+mapentry.getKey() + " | value: ");
            Affichage.array((String[])mapentry.getValue());                 
         }		
	}	
	
	
	
	
	
	
	
}
