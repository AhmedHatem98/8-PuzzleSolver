/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlesolver;

/**
 *
 * @author Ahmed Hatem
 */
public class Heuristics {
  
    
     public int manahttanHeuristic(String currentState,String goalState){
    int distance=0,x1,x2,y1,y2;
    for(int i=0;i<currentState.length();i++){
    for(int j=0;j<goalState.length();j++){
        if(currentState.charAt(i)==goalState.charAt(j))
        {
         x1 = i%3;
         x2=j%3;
         y1= i/3;
         y2 = j/3;
         distance += Math.abs(x1-x2) +Math.abs(y1-y2);
        }
    
    }
    }
    return distance;
    }
    
    public int eucledeanHeuristic(String currentState,String goalState){
    int distance=0,x1,x2,y1,y2;
    for(int i=0;i<currentState.length();i++){
    for(int j=0;j<goalState.length();j++){
        if(currentState.charAt(i)==goalState.charAt(j))
        {
         x1 = i%3;
         x2=j%3;
         y1= i/3;
         y2 = j/3;
         distance += Math.sqrt(((x1-x2)*(x1-x2)) + ((y1-y2)*(y1-y2)));
        }
    
    }
    }
    return distance;
    }
    
}
