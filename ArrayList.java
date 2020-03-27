public class ArrayList<T> implements List<T>{
	
	T [] array;
	int size = 0;

	public ArrayList(){
    	array = (T[]) new Object[10];
 	}

	void increaseCapacity(){
        T [] tempArr = (T[]) new Object[array.length * 2];
        for(int i = 0; i < array.length;i++){
       		tempArr[i] = array[i];
       }
       array = tempArr;
	}

	@Override
	public void add(T item){
		if(size == array.length)
			increaseCapacity();
		array[size++] = item;
	}

	@Override
	public void add(int pos, T item){
		if(pos > size || pos < 0){
			throw new IndexOutOfBoundsException();
		}
		if(pos >= 0 && pos < size){
			if(size == array.length){
				increaseCapacity();
			}
			for(int i = size - 1; i > pos-1; i--){
				array[i] = array[i-1];
			}
			array[pos] = item;
			size++;
		}
		else{
			add(item);
		}
	}

	@Override
	public T get(int pos){
		if(pos >= size || pos < 0)
			throw new IndexOutOfBoundsException();
		return array[pos];

	}

	@Override
	public T remove(int pos){
		if(pos >= size || pos < 0)
			throw new IndexOutOfBoundsException();
		T returnValue = array[pos];
		for(int i = pos; i<size-1;i++){
			array[i] = array[i+1];
		}
		size--;
		return returnValue;
	}
	@Override
	public int size(){
		return size;
	}
}