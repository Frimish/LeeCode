package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ominoPairsOptimized {
    static class Pair {
    int x, y;
    Pair(int x, int y){
      this.x = x;
      this.y = y;
    }
    
    @Override
    public boolean equals(Object other){
      return x == ((Pair) other).x && y == ((Pair) other).y;
    }
    
    @Override
    public int hashCode(){
      return (10007 * x) + y;
    }
    
  }
  
  
  // Optimized Version - O(n)
  public static List<Pair> dominoPairsOptimized(Pair[] pairs, int k) {
    ArrayList<Pair> result = new ArrayList<Pair>();
    Set<Pair> set = new HashSet<Pair>();
    
    for (int i = 0; i < pairs.length; i++) {
      Pair complement = new Pair(Math.abs(k - pairs[i].x), Math.abs(k - pairs[i].y));
      if(set.contains(complement)){
        result.add(complement);
        result.add(pairs[i]);
            // for(int t = 0;t < result.size(); t++){
            //   System.out.println(result.get(t).x + " " + result.get(t).y);
            // }
        return result;
      } else {
        set.add(pairs[i]);
      }
    }
    return result;
  }
  
  public static void main(String[] args) {
    Pair pObj3 = new Pair(7,2);
    Pair pObj = new Pair(1,3);
    Pair pObj1 = new Pair(3,1);
    Pair pObj2 = new Pair(5,3);
    Pair[] listPairs = {pObj3, pObj2, pObj1, pObj};
    System.out.println(dominoPairsOptimized(listPairs, 4));
  }
}
