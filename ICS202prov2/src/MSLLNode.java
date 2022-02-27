
public class MSLLNode<T> {
	
	public String info;
	public SLLNode<City> head;
	public SLLNode<City> tail;
	public MSLLNode<T> next;

	public MSLLNode(String info, MSLLNode<T> next) {
		
		this.info = info;
		this.next = next;
	}
	
	 public MSLLNode(String el) {
	        this(el,null);
	    }

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public MSLLNode<T> getNext() {
		return next;
	}

	public void setNext(MSLLNode<T> next) {
		this.next = next;
	}
}



