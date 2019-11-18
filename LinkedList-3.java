import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * A class to represent a linked list of nodes. By making the class Iterable,
 * we are indicating that we can "iterate" (loop) over the elements stored in the list
 */
public class LinkedList<T> implements Iterable<T> {
  /** the first node of the list, or null if the list is empty */
  private LLNode<T> firstNode;
  
  /**
   * Creates an initially empty linked list
   */
  public LinkedList() {
    firstNode = null;
  }
  
  /**
   * Returns the first node.
   */
  protected LLNode<T> getFirstNode() {
    return firstNode;
  }

  /**
   * Changes the first node.
   * @param node  the first node of the new linked list
   */
  protected void setFirstNode(LLNode<T> node) {
    this.firstNode = node;
  }

  /**
   * Add an element to the front of the linked list
   * @param element  the element to add
   */
  public void addToFront(T element) {
    setFirstNode(new LLNode<T>(element, getFirstNode()));
  }
  
  /**
   * Return whether the list is empty
   * @return true if the list is empty
   */
  public boolean isEmpty() {
    return (getFirstNode() == null);
  }
  
  /**
   * Returns the length of the linked list
   * @return the number of nodes in the list
   */
  public int length() {
    int count = 0;                      // counts number of nodes seen
    LLNode<T> nodeptr = getFirstNode();
    while (nodeptr != null) {
      count++;
      nodeptr = nodeptr.getNext();
    }
    return count;
  }
  
  /**
   * Remove and return the element at the front of the list
   * @return the first element of the list
   * @throws NoSuchElementException if there is no such element
   */
  public T removeFromFront() {
    if (isEmpty())
      throw new NoSuchElementException();
    else {
      T save = getFirstNode().getElement();
      setFirstNode(getFirstNode().getNext());
      return save;
    }
  }

  /**
   * Add an element to the very end of the list
   * @param element the element to add to the end of the list
   */
  public void addToEnd(T element) {
    if (isEmpty()) 
      addToFront(element);
    else {
      LLNode<T> nodeptr = getFirstNode();
      // the loop will end with nodeptr looking at the last node in list
      while (nodeptr.getNext() != null)
        nodeptr = nodeptr.getNext();
      nodeptr.setNext(new LLNode<T>(element, null));
    }
  }
  
  /** 
   * Print the contents of a linked list.  
   * This is an example of a method declaring its own generic type.
   * @param <T> the type stored in the linked list
   * @param list  the list to print 
   */
  public static <T> void printList(LinkedList<T> list) {
    LLNode<T> nodeptr = list.getFirstNode();
    
    while (nodeptr != null) {
      System.out.print(nodeptr.getElement().toString() + " ");
      nodeptr = nodeptr.getNext();
    }
    System.out.println();
  }
  
  /** 
   * Print the contents of a linked list.
   * This is an example of a method using a generic wildcard.
   * @param list  the list to print
   */
  public static void printList2(LinkedList<?> list) {
    LLNode<?> nodeptr = list.getFirstNode();
    
    while (nodeptr != null) {
      System.out.print(nodeptr.getElement().toString() + " ");
      nodeptr = nodeptr.getNext();
    }
    System.out.println();
  }
  
  /**
   * This method is required by the Iterable interface.  It returns an iterator
   * that will loop over the elements of the list
   * @return an iterator for the linked list
   */
  public Iterator<T> iterator() {
    return new LinkedListIterator<T>(getFirstNode());
  }
  
  /**
   * Insert an element in order into a linked list
   * This assumes the elements already in the list are in order
   * @param <S> the type stored in the list, it should be Comparable
   * @param element the element to insert
   * @param list a list that is currently storing elements in sorted order
   */
  public static <S extends Comparable<? super S>> void insertInOrder(S element, LinkedList<S> list) {
    if (list.isEmpty() || element.compareTo(list.getFirstNode().getElement()) < 0) {
      list.addToFront(element);
    }
    else {
      LLNode<S> nodeptr = list.getFirstNode();
      // run through the list until the next element is larger than
      //  the element we want to insert OR we reach the end of the list
      while (nodeptr.getNext() != null &&
             nodeptr.getNext().getElement().compareTo(element) < 0) {
        nodeptr = nodeptr.getNext();
      }
      // now nodeptr points at the node in front of where the new element goes
      nodeptr.setNext(new LLNode<S>(element, nodeptr.getNext()));
    }
  }
  
}
