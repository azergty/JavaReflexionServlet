package www.log;


import java.net.URL;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import www.utils.Path;

import java.util.logging.Level;


public class MonLogger {
	    private static String PATH(){

	    	return Path.PATH_FOLDER_LOGS.getPath();
	    }
	    public static FileHandler fh = null;
	    public static ConsoleHandler ch = null;

	    /**
	     * Permet de récuperer un logger.
	     **/
	    private static FileHandler getFilleHandler(String name) {
	    	FileHandler	fh=null;

	        try
	        {
	            fh = new FileHandler(PATH()+name+".txt", true);
		        fh.setFormatter(new SimpleFormatter());
	        }
	        catch (Exception e)
	        {
	        	System.out.println("Impossible de créer ou ouvrir le "+PATH()+name+".txt");
	        	try {
	        		fh = new FileHandler(PATH()+"log.log", true);
	        		 fh.setFormatter(new SimpleFormatter());
	        	}catch(Exception er) {
		        	System.out.println("Impossible de créer ou ouvrir le "+PATH()+"log.txt ");
	        	}
	        }
 
	        return fh;
	    }
	    
	    public static void setLogger(String className,String level,String msg) {
	    	
	    	try {
	    		Logger log = getLogger(className);
		    	 switch (level.toLowerCase().trim()) {
	             case "severe":
	            	 log.log(Level.SEVERE, msg);
	                 break;
	             case "warning":
	            	 log.log(Level.WARNING, msg);
	                 break;
	             case "info":
	            	 log.log(Level.INFO, msg);
	                 break;
	             case "config":
	            	 log.log(Level.CONFIG, msg);
	                 break;
	             case "fine":
	            	 log.log(Level.FINE, msg);
	                 break;
	             case "finer":
	            	 log.log(Level.FINER, msg);
	                 break;
	             case "finest":
	            	 log.log(Level.FINEST, msg);
	                 break;
	             default:
	            	 log.log(Level.CONFIG, msg);
	                 break;
	         }
	    	}catch(SecurityException e) {

	    	}finally {
	    		if(fh!=null) fh.close();
	    		fh=null;
	    	}

	    }
	    
	    private static Logger getLogger(String className)
	    {
	       Logger monLogger = Logger.getLogger(className);
	       monLogger.setUseParentHandlers(false);

	       if(ch == null)
	        {
	            ch = new ConsoleHandler();
	            //ch.setLevel(Level.FINEST);
	        }
	        try {
	        	if (fh==null) fh=getFilleHandler(className);

		      	monLogger.addHandler(ch);

		      	monLogger.addHandler(fh);
	        }catch(Exception e) {
	        	System.out.println(" pas de handler");
	        	e.printStackTrace();
	        }
	        return monLogger;
	    }


	}	

