package Initial;

@SuppressWarnings("serial")
public class XYhof implements java.io.Serializable {

	private int Id;
	private int node;
	private int xvalue;
	private int yvalue;
	private String type;
	

	public XYhof() {
	}

	public XYhof(int node, int xvalue, int yvalue, String type) {
		
		this.node = node;
		this.xvalue = xvalue;
		this.yvalue = yvalue;
		this.type = type;
		
	}
	
	public int getId() {
		return this.Id;
	}
	
	public void setId(int Id) {
		this.Id = Id;
	}

	public int getNode() {
		return this.node;
	}
	
	public void setNode(int node) {
		this.node = node;
	}

	public int getXvalue() {
		return this.xvalue;
	}
	
	public void setXvalue(int xvalue) {
		this.xvalue = xvalue;
	}
	
	public int getYvalue() {
		return this.yvalue;
	}
	
	public void setYvalue(int yvalue) {
		this.yvalue = yvalue;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
}
