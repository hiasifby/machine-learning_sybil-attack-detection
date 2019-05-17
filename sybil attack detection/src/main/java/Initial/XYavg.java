package Initial;

@SuppressWarnings("serial")
public class XYavg implements java.io.Serializable {

	private int Id;
	private int node;
	private float xavg;
	private float yavg;
	private String type;
	

	public XYavg() {
	}

	public XYavg(int node, float xavg, float yavg, String type) {
		
		this.node = node;
		this.xavg = xavg;
		this.yavg = yavg;
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

	public float getXavg() {
		return this.xavg;
	}
	
	public void setXavg(float xavg) {
		this.xavg = xavg;
	}
	
	public float getYavg() {
		return this.yavg;
	}
	
	public void setYavg(float yavg) {
		this.yavg = yavg;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	
}
