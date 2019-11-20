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
  public void createTracks(int index, int tracks) {
    getArr().add(new ArrayList<LinkedList<T>>(tracks));
    for(int i = 0; i < tracks; i++) {
      getArrIndex(index).add(new LinkedList<T>());
    }
  }
  
  /**
   */
  public void addToLinkedList(int index, int index2, T element) {
    get2DArrIndex(index, index2).add(element);
  }
  
  /**
   */
  public ArrayList<ArrayList<LinkedList<T>>> getArr() {
    return yards;
  }
  
  /**
   */
  public ArrayList<LinkedList<T>> getArrIndex(int index) {
    return getArr().get(index);
  }
  
  /**
   */
  public LinkedList<T> get2DArrIndex(int index, int index2) {
    return getArrIndex(index).get(index2);
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
    for(int i = 0; i < getArr().size(); i++) {
      
      for(int j = 0; j < getArrIndex(i).size(); j++) {
        
        for (int k = 0, counter = 0; counter < train.length; k++, counter++) {
          
          if(counter == 0) {
            get2DArrIndex(i,j).addLast(train[k]);
          }
          else if(train[k].compareTo(get2DArrIndex(i,j).getLast()) >= 0) {
            get2DArrIndex(i,j).addLast(train[k]);
          }
          else if(j < getArrIndex(i).size() - 1) {
            get2DArrIndex(i, j + 1).addLast(train[k]);
          }
          else if(j == getArrIndex(i).size() - 1) {
            k = 0;
            get2DArrIndex(i, k).addLast(train[k]);
          }
        }
      }
      
    }
  }
  
  /**
   * Sorts a list using the cycle sort algorithm
   * @param List<T> represents any object that implements List<T> that will be sorted
   */
  public void cycleSort(List<T> train) {
    for(int i = 0; i < getArr().size(); i++) {
      
      for(int j = 0; j < getArrIndex(i).size(); j++) {
        
        for (int k = 0, counter = 0; counter < train.size(); k++, counter++) {
          
          if(counter == 0) {
            get2DArrIndex(i,j).addLast(train.get(k));
          }
          else if(train.get(k).compareTo(get2DArrIndex(i,j).getLast()) >= 0) {
            get2DArrIndex(i,j).addLast(train.get(k));
          }
          else if(j < getArrIndex(i).size() - 1) {
            get2DArrIndex(i, j + 1).addLast(train.get(k));
          }
          else if(j == getArrIndex(i).size() - 1) {
            get2DArrIndex(i, 0).addLast(train.get(k));
          }
        }
      }
      
    }
    
    
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
    RailYardClone<String> railYard = new RailYardClone<String>(Integer.parseInt(args[1]));
    /*if(args[args.length - 1] instanceof String) {
      railYard = new RailYardClone<String>(Integer.parseInt(args[1]));
    }
    else {
      railYard = new RailYardClone<Integer>(Integer.parseInt(args[1]));
    }*/
    
    if(args[0].equals("cycle")) {      
      for(int i = 0; i < Integer.parseInt(args[1]); i++) {        
        railYard.createTracks(i, Integer.parseInt(args[2 + i]));
      }
      
      ArrayList<String> sortArray = new ArrayList<String>(args.length - (Integer.parseInt(args[1]) + 1));
      for (int i = Integer.parseInt(args[1]) + 2; i < args.length; i++) {
        sortArray.add(args[i]);
      }
      
      for (int i = 0; i < sortArray.size(); i++) {
        railYard.cycleSort(sortArray);
      }
      
      
    }
    
    else if (args[0].equals("closest")){
    }
    
    else {
      System.out.println("You messed up bro");
    }
    
    /*RailYardClone<Integer> railyard = new RailYardClone<Integer>(Integer.parseInt(args[1]));
     int counter = Integer.parseInt(args[1]);
     
     for(int i = 0; i < counter && i < args.length; i++) {
     railyard.initYardIndex(i, Integer.parseInt(args[2 + i]));
     }
     
     for(int i = 0; i < railyard.getCapacity(); i++) {
     for (int j = 0; i < Integer.parseInt(args[2 + i]); j++) {
     railyard.getLinkedList(i,j).add(2);
     System.out.print(railyard.getLinkedList(i,j).getFirst());
     }
     System.out.println();*/
  }
}