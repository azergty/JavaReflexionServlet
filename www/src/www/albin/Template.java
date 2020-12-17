package www.albin;

public class Template{

	private String name;
	private String url;
	private String date;
	public Template(String name,String url) {
		
		
		this.name=name;
		this.url=url;
		this.date ="2020";
		
	}
	public String getDate() {
		return date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	
	@Override
	public String toString() {
		return "Template [name=" + name + ", url=" + url + ", date=" + date + "]";
	}


	
}
