package dlx;

public class Dlx<E> {
    
    class ListNode<E> implements PositionADT<E> {
	    // Constructors
	    public ListNode( E theElement ) {
	        this( null,theElement, null );
	    }
	    public ListNode( ListNode<E> n) { //header
	    	this( null,null, n);
	    	next = n;
	    	
	    }
	    public ListNode( ListNode<E> n0,E theElement, ListNode<E> n2 ) {
	        element = theElement;
	        next    = n2;
	        prev = n0;
	    }
	    
	    public E   element;
	    public ListNode<E> next=null;
	    public ListNode<E> prev=null;
	    public E element()
	    {
	    	return element;
	    }
	}
	
    PositionADT<E> first = null;
   // PositionADT<E> trailer = null;
    
    /**
     * Construct the list
     */
    public Dlx( ) {
        first =  new ListNode<E>((ListNode<E>)first,null,(ListNode<E>)first); // maybe to change last and first parameter to null
      
    }
    public void setFirst(E x ) 
    {
    	ListNode<E> newNode = new ListNode<E>((ListNode<E>)first,x, (ListNode<E>)first);
        ((ListNode<E>)first).next=newNode;
        ((ListNode<E>)first).prev=newNode; //since its in a circular fashion
      
    }
    /**
     * Test if the list is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( ) {
        return ((ListNode<E>)first).next == (ListNode<E> )first;
    }
    
    /**
     * Make the list logically empty.
     */
    public void makeEmpty( ) {
        ((ListNode<E>)first).next =(ListNode<E>)first;
    }
    
    /**
     * Return an iterator representing the first node in the list.
     * This operation is valid for empty lists.
     */
    public PositionADT<E> first( ) {
        return ((ListNode<E>)first).next;
    }
    
    /**
     * Insert after p.
     * @param x the item to insert.
     * @param p the position prior to the newly inserted item.
     */
    public PositionADT<E> insertAfter(E x, PositionADT<E> p ) 
    {
        ListNode<E> newNode = new ListNode<E>((ListNode<E>)p,x, ((ListNode<E>)p).next);
        ((ListNode<E>)p).next = newNode;
        (((ListNode<E>)p).next).prev = newNode;
        return newNode;
    }
    public PositionADT<E> insertBefore(E x, PositionADT<E> p ) 
    {
        ListNode<E> newNode = new ListNode<E>(((ListNode<E>)p).prev,x, (ListNode<E>)p);
        ((ListNode<E>)p).prev = newNode;
        (((ListNode<E>)p).prev).next = newNode;
        return newNode;
    }
    public PositionADT<E> insertElemAtIndex(E x, int i) {
    	PositionADT<E> current = first();
    	if(i>listSize()) return null;
    	else {
    			for(int j = 0; j < i; j++) 
    			{
    				current = ((ListNode<E>)current).next;
    			}
    			
    			current = new ListNode<E>(x);
    			
    		}
    	return current;
    }
    public PositionADT<E> setElemAtIndex(E x, int i) {
    	PositionADT<E> current = first();
    	if(i>listSize()) return null;
    	else {
    			for(int j = 0; j < i; j++) 
    			{
    				current = ((ListNode<E>)current).next;
    			}
    			((ListNode<E>)current).element =x;
    		}
    	return current;
    }
    public PositionADT<E> ElemAtIndex( int i) {
    	PositionADT<E> current = first();
    	if(i>listSize()) return null;
    	else {
    			for(int j = 0; j < i; j++) 
    			{
    				current = ((ListNode<E>)current).next;
    			}
    		}
    	return current;
    }
    
    /**
     * Remove the first occurrence of an item.
     * @param x the item to remove.
     */
    public void remove(PositionADT<E> p) {
		((ListNode<E>)before(p)).next = ((ListNode<E>)p).next;
    }
    
    
    public PositionADT<E> after(PositionADT<E> p) {
    	return ((ListNode<E>)p).next;
    }
    public PositionADT<E> before(PositionADT<E> p) {
    	return ((ListNode<E>)p).prev;
    }
    public E element()
    {
    return first.element();	
    }
    
       
    public int listSize() {
    	if(isEmpty()) return 0;
    	
    	ListNode<E>  current = (ListNode<E>)first;
    	int counter = 0;
    	while(((ListNode<E>)current).next != null) {
    		current = ((ListNode<E>)current).next;
    		counter ++;
    	}
    	return counter;
    }   
    	public void printList()
    	{if(isEmpty()) System.out.println("Empty List");
    	ListNode<E> current = ((ListNode<E>)first).next;
    	
    	while(((ListNode<E>)current).next != first) {  //initial was trailer changed to first
    		System.out.print(" " + current.element());
    		current = ((ListNode<E>)current).next;
    	
    	}	
    		System.out.println(" " + current.element());
    	}   
}
