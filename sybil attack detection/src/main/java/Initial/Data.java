package Initial;

@SuppressWarnings("serial")
public class Data implements java.io.Serializable {

	private int Id;
	private int sourceNode;
	private int destinationNode;
	private int intId;
	private int malicious;
	private String hofNodes;
	private String type;
	private int hofCount;

	public Data() {
	}

	public Data(int sourceNode, int destinationNode, int intId,
			int malicious, String hofNodes, String type, int hofCount) {
		
		this.sourceNode = sourceNode;
		this.destinationNode = destinationNode;
		this.intId = intId;
		this.malicious = malicious;
		this.hofNodes = hofNodes;
		this.type = type;
		this.hofCount = hofCount;
	}
	
	public int getId() {
		return this.Id;
	}
	
	public void setId(int Id) {
		this.Id = Id;
	}

	public int getSourceNode() {
		return this.sourceNode;
	}
	
	public void setSourceNode(int sourceNode) {
		this.sourceNode = sourceNode;
	}

	public int getDestinationNode() {
		return this.destinationNode;
	}
	
	public void setDestinationNode(int destinationNode) {
		this.destinationNode = destinationNode;
	}
	
	public int getIntId() {
		return this.intId;
	}
	
	public void setIntId(int intId) {
		this.intId = intId;
	}
	
	public int getMalicious() {
		return this.malicious;
	}
	
	public void setMalicious(int malicious) {
		this.malicious = malicious;
	}
	

	public String getHofNodes() {
		return this.hofNodes;
	}

	public void setHofNodes(String hofNodes) {
		this.hofNodes = hofNodes;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHofCount() {
		return this.hofCount;
	}

	public void setHofCount(int hofCount) {
		this.hofCount = hofCount;
	}
}
