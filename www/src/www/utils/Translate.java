package www.utils;

import java.util.HashMap;

import www.albin.Globals;

public class Translate {

	public HashMap <String, String> traductions=null;

	public Translate() {
		
		if(traductions == null){
			HashMap <String,String> params = new HashMap<>();
			params.put("controller",Globals.controller);
			params.put("lang", Globals.lang);
			
			
			traductions = new HashMap<String, String>();

			//traductions=LangFactory.get(params);
			
			//on init traductions
			// $controller = (Util.getController(request);
			//select * from traductions where controller = $controller OR controller = 'pagelayout' and lang = 'fr';
			//on le push dans this.traductions;
		}		
	
	}
	
	public String get(String key){

		/*String str = "";
		System.out.println(" Request => "+Globals.request.getParameter("e"));
		if(traductions != null && traductions.containsKey(key)) str = traductions.get(key);
		else str = key;
		
		if( Globals.request.getParameter("e").equals("1")) 
		{
			return "<span contenteditable='true' class='translate' id='"+ key+"'>"+  str + "</span>";
		}*/
		return key;
		
	}
	public String get(String key, boolean editable){

		/*String str = "";
		System.out.println(" Request => "+Globals.request.getParameter("e"));
		if(traductions != null && traductions.containsKey(key)) str = traductions.get(key);
		else str = key;
		
		return str;*/
		return key;
		
	}
	
	
	
	
	
	
	
	
	
}
