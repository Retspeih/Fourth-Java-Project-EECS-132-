import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class RailYard<T> {
  
  private TrackStrings[] arr;
  
  public RailYard(int element) {
    //  if () {
   // arr = new TrackStrings[element];
    //  else {
    //arr = new TrackIntegers[element];
  }
  
  private class TrackStrings extends LinkedList<String> implements Comparable<TrackStrings> {
    
    private String name = "";
    
    public TrackStrings() {
    }
    
    public String getName() {
      return name;
    }
    
    public void setName(String name) {
      this.name = name;
    }
    
    public int alphaOrder(char first, char second) {
      Character.toUpperCase(first);
      Character.toUpperCase(second);
      if (first < second) {
        return -1;
      }
      else if (first > second) {
        return 1;
      }
      else {
        return 0;
      }
    }
    
    @Override
    public int compareTo(TrackStrings name2) {
      return 1;
    }
  }
  
  private class TrackIntegers extends LinkedList<Integer> implements Comparable<TrackIntegers> {
    
    private Integer value = null;
    
    public TrackIntegers() {
    }
    
    public Integer getInt() {
      return value;
    }
    
    public void setInt(Integer value) {
      this.value = value;
    }
    
    @Override
    public int compareTo(TrackIntegers name2) {
      if (getInt() < name2.getInt()) {
        return -1;
      }
      else if (getInt() > name2.getInt()) {
        return 1;
      }
      else {
        return 0;
      }
    }
  }
  
  public TrackStrings[] getArray() {
    return arr;
  }
  
  public void cycleSort(T[] train) {
    
  }
  
  public void cycleSort(List<T> train) {
    
  }
  
  public void closestSort(T[] train) {
    
  }
  
  public void closestSort(List<T> train) {
    
  }
}

