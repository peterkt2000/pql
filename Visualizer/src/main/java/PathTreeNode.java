
public class PathTreeNode {

	public PathTreeNode(String value) {
		this.value = value;
	}
	
	public PathTreeNode(String value, String tag) {
		this.value = value;
		this.tag = tag;
	}
	
	public String getValue() {
		return value;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public String getTag() {
		return tag;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PathTreeNode other = (PathTreeNode) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	private String value = null;
	private String tag = null;
}
