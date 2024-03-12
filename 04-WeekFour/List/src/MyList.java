import java.util.Arrays;

public class MyList<T> {
    private T[] arr;
    private int capacity;
    private int size;

    // Default constructor
    MyList(){
        this.size = 0;
        this.capacity = 10;
        this.arr = (T[]) new Object[capacity];
    }

    // Parameterized constructor
    MyList(int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
    }

    // Returns the capacity of the array
    public int getCapacity() {
        return capacity;
    }

    // Returns number of elements in the list
    public int getSize() {
        return size;
    }

    // Adds an element into list
    public void add(T data){
            if(this.size < this.capacity){
                this.arr[this.size] = data;
                this.size++;
            }else{
                this.capacity *=2;
                System.out.println("Array capacity increase double due to not enough capacity!");
            }
    }

    // Returns list element at given index
    public T get(int index){
        if(index > this.size){
            return null;
        }
        return this.arr[index];
    }

    // Removes list element at given index
    public void remove(int index){
        for(int i = index; i < arr.length-1; i++){
            this.arr[i] = this.arr[i+1];
        }
        arr[arr.length-1] = null;
        size--;
    }

    //
    //Sets the element at the specified index to the given data
    public T set(int index, T data){
       return arr[index] = data;
    }

    // Prints list
    public void print(){
        System.out.print("[ ");
        for (T t : arr) {
            if (t != null) {
                System.out.print(t + " ");
            }
        }
        System.out.print("]");

    }

    // Returns list element at given index or return -1 if not found in list
    public int indexOf(T data){
        for(int i = 0; i < arr.length; i++ ){
            if(arr[i] == data){
                return i;
            }
        }
        return -1;
    }

    // Returns last index of given element or return -1 if not found in list
    public int lastIndexOf(T data){
        int counter = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == data){
                counter = i;
            }
        }
        return counter;
    }

    // Checks if the list is empty or not
    public boolean isEmpty(){
        return this.size == 0;
    }

    // Returns an array containing all elements in list in proper sequence
    public T[] toArray(){
        return Arrays.copyOf(arr,size);
    }

    // Removes all elements in list
    public void clear(){
        arr = (T[]) new Object[10];
        size = 0;
    }

    // Returns a sublist from start to finish index
    public MyList<T> sublist(int start, int finish){
        MyList<T> subList = new MyList<>(finish-start+1);
        for(int i = start; i <=finish; i++){
            subList.add(this.get(i));
        }
        return subList;
    }

    // Checks if list contains given element or not
    public boolean contains(T data){
        return indexOf(data) != -1;
    }
}
