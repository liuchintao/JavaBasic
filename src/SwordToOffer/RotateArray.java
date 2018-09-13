package SwordToOffer;

public class RotateArray {
	private Integer[] rotate;

	public RotateArray(Integer[] t) {
		this.rotate = t;
	}

	public Integer[] getRotate() {
		return rotate;
	}

	public void setRotate(Integer[] rotate) {
		this.rotate = rotate;
	}
	
	public Integer getPivot() {
		if(rotate == null || rotate.length == 0)
			return null;
		int head = 0, tail = rotate.length - 1;
		int mid = head;
		while(rotate[head] >= rotate[tail]) {
			if(rotate[mid].compareTo(rotate[head]) >= 0)
				head=mid;
			else
				tail=mid;
			if(tail - head == 1) {
				mid = tail; 
				break;
			}
			mid=(head+tail)>>1;
		}
		return rotate[mid];
	}
}
