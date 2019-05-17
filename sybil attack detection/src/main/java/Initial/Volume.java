package Initial;

@SuppressWarnings("serial")
public class Volume implements java.io.Serializable {

	private int Id;
	private String sdNode;
	private float distance;
	private String type;

	public Volume() {
	}

	public Volume(String sdNode, float distance, String type) {
		
		this.sdNode = sdNode;
		this.distance = distance;
		this.type = type;
		
	}
	
	public int getId() {
		return this.Id;
	}
	
	public void setId(int Id) {
		this.Id = Id;
	}

	public String getSdNode() {
		return this.sdNode;
	}
	
	public void setSdNode(String sdNode) {
		this.sdNode = sdNode;
	}

	public float getDistance() {
		return this.distance;
	}
	
	public void setDistance(float distance) {
		this.distance = distance;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
		
}
