import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class RailYardClone<T extends Comparable<T>> {
  
  /**
   */
  private ArrayList<ArrayList<LinkedList<T>>> yards;
  
  /**
   */
  private boolean isString;
  
  /**
   */
  private boolean isInteger;
  
  /**
   */
  private int capacity;
  
  /**
   */
  public RailYardClone(int amountOfYards) {
    yards = new ArrayList<ArrayList<LinkedList<T>>>(amountOfYards);
    setCapacity(amountOfYards);
  }
  
  /**
   */
  public void setYardIndex(int yardIndex, int amountOfTracks) {
    if (yardIndex < getCapacity()) {
      getArr().add(yardIndex, new ArrayList<LinkedList<T>>(amountOfTracks));
    }
    else {
      System.out.println("Inputted yard index does not exist");
    }
  }
  
  /**
   */
  public void initYardIndex(int yardIndex, int amountOfTracks) {
    int trackAmount = 0;
    for(int i = 0; i < capacity; i++) {
      setYardIndex(yardIndex, amountOfTracks);
      trackAmount = getArr().get(i).size();
      for(int j = 0; j < trackAmount; j++) {
        get2DArr(i).add(j, new LinkedList<T>());
      }
    }
  }
  
  /**
   */
  public ArrayList<ArrayList<LinkedList<T>>> getArr() {
    return yards;
  }
  
  /**
   */
  public ArrayList<LinkedList<T>> get2DArr(int index) {
    return getArr().get(index);
  }
  
  /**
   */
  public LinkedList<T> getLinkedList(int index, int index2) {
    return get2DArr(index).get(index2);
  }
  
  /**
   */
  public void merge(T[] train) {
  }
  
  /**
   */
  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }
  
  /**
   */
  public int getCapacity() {
    return capacity;
  }
  
  /**
   * Sorts an array using the cycle sort algorithm
   * @param T[] represents an array of objects that will be sorted
   */
  public void cycleSort(T[] train) {
    
  }
  
  /**
   * Sorts a list using the cycle sort algorithm
   * @param List<T> represents any object that implements List<T> that will be sorted
   */
  public void cycleSort(List<T> train) {
    
    
    
  }
  
  /**
   * Sorts an array using the closest sort algorithm
   * @param T[] represents an array of objects that will be sorted
   */
  public void closestSort(T[] train) {
    
  }
  
  /**
   * Sorts a list using the closest sort algorithm
   * @param List<T> represents any object that implements List<T> that will be sorted
   */
  public void closestSort(List<T> train) {
    
  }
  
  /**
   */
  public static void main(String[] args) {
    
    if(args[0].equals("cycle")) {
      
      RailYardClone<Integer> railyard = new RailYardClone<Integer>(Integer.parseInt(args[1]));
      int counter = Integer.parseInt(args[1]);
      
      for(int i = 0; i < counter && i < args.length; i++) {
        railyard.initYardIndex(i, Integer.parseInt(args[2 + i]));
      }
      
      for(int i = 0; i < railyard.getCapacity(); i++) {
        for (int j = 0; i < Integer.parseInt(args[2 + i]); j++) {
          railyard.getLinkedList(i,j).add(2);
          System.out.print(railyard.getLinkedList(i,j).getFirst());
        }
        System.out.println();
      }
    }
  }
}