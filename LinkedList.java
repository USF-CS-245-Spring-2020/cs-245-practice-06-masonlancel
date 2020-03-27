public class LinkedList<T> implements List<T>{
	
	Node head;
	int size = 0;

	public class Node<T>{
		T data;
		Node next;
	}

	public void add(T item){
		Node<T> node = new Node<T>();
		node.data = item;
		//node.next = null;
		if(head == null){
			head = node;
		}
		else{
			Node<T> temp = new Node<T>();
			Node<T> prev = new Node<T>();
			temp = head;
			//third variable? 
			while(temp.next!=null){
				prev = temp;
				temp = temp.next;
			}
			prev = temp;
			temp.next = node;
		}
		size++;
	}
	
	public void insertAtStart(T item){
		Node<T> node = new Node<T>();
		node.data = item;
		node.next = null;
		node.next = head;
		head = node;
	}

	public void add(int pos, T item){ 
		Node<T> node = new Node<T>();
		node.data = item;
		node.next = null;
		if(pos == 0){
			insertAtStart(item);
		}
		else{
			Node temp = head;
			for(int i = 0; i<pos-1;i++)
				temp = temp.next;
			node.next = temp.next; 
			temp.next = node;
		}
		size++;
	}

	public T get(int pos){
		Node<T> n = head;
		if(pos > size || pos < 0)
			throw new IndexOutOfBoundsException();
		for(int i = 0; i<pos; i++)
			n = n.next;
		return n.data;
	
	}

	public T remove(int pos){
		Node<T> obj = new Node<T>();
		if(pos == 0){
			obj = head;
			head = head.next;
			size--;
			return obj.data;
		}
		else{
			Node temp = head;
			Node n1 = null;
			for(int i = 0; i<pos-1;i++)
				temp = temp.next;
			obj = temp.next;
			n1 = temp.next;
			temp.next = n1.next;
		}
		size--;
		return obj.data ;
	}

	public int size(){
		return size;
	}
} 
