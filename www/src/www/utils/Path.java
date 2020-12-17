package www.utils;

/*public class Path  {
	
	public final static String ROOT =  "/www/";
	public final static String WEB =  "albin/";
	public final static String PATH_LINK = Path.ROOT + Path.WEB;	
	public final static String PATH_FOLDER_CSS = Path.ROOT +"/css/";	*/
	public enum Path {
		 
		PATH_WEB("/www/"),
		PATH_ROOT("ROOT/"), 
		PATH_FOLDER_CSS(Path.PATH_WEB.getPath()+Path.PATH_ROOT.getPath()+"css/"),
		PATH_FOLDER_IMG(Path.PATH_WEB.getPath()+Path.PATH_ROOT.getPath()+"images/"),
		PATH_FOLDER_LOGS("C:/Users/alepesse2020/eclipse-workspace/www/WebContent/logs/"),
		PATH_CONTROLLER("www.bll.");
	    private String path;

	 
	    Path(String path) {
	        this.path = path;
	    }
	 
	    public String getPath() {
	        return path;
	    }


	 
	}

