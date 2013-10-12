public class Queue<T> {
	
	private QueueNode<T> head;
	private QueueNode<T> tail;

	public Queue(){}

	public void enq(T data){
		QueueNode<T> newHead = new QueueNode<T>(data);
		QueueNode<T> oldHead = this.head;
		newHead.setNext(oldHead);
		if(oldHead!=null){ oldHead.setPrev(newHead);}
		if(this.tail==null){ this.tail = newHead; }
		this.head = newHead;
	}

	public T deq() throws Exception {
		if(this.tail==null){ 
			throw new Exception("Queue is empty");
		}
		QueueNode<T> oldTail = this.tail;
		QueueNode<T> newTail = oldTail.getPrev();
		if(newTail==null){
			this.head = null;
			this.tail = null; //queue is now empty
		} else {
			newTail.setNext(null);
			this.tail = newTail;
		}
		return oldTail.getData();
	}

	public boolean isEmpty(){
		return (this.head==null);
	}


	private class QueueNode<T> {
		private QueueNode<T> prev;
		private QueueNode<T> next;

		private T data;

		private QueueNode(T data){
			this.data = data;
		}

		private T getData(){
			return this.data;
		}

		private QueueNode<T> getPrev(){
			return this.prev;
		}

		private void setPrev(QueueNode<T> prev){
			this.prev = prev;
		}

		private QueueNode<T> getNext(){
			return this.next;
		}

		private void setNext(QueueNode<T> next){
			this.next = next;
		}
	}
}