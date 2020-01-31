/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlesolver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Ahmed Hatem
 */
public class PuzzleSolver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start, end,time;
        
        Search s = new Search();
        Scanner input = new Scanner(System.in);
        String initialState = "", goalState = "";
        int choice, choice2;
        Node state;
        InformedNode informedState;
        DisplayPath d = new DisplayPath();
        System.out.println("Enter your initial state:");
        initialState = parse(input.nextLine());
        System.out.println("Enter your goal state:");
        goalState = parse(input.nextLine());
        System.out.println("\nChoose a search algorithm:\n\n1.BFS\n2.DFS\n3.A*");
        choice = input.nextInt();
        if (choice == 1) {
            start = System.currentTimeMillis();
            state = s.bfs(initialState, goalState);
            end = System.currentTimeMillis();
            time = (end-start);
            System.out.println(time);
            if (state != null) {
                d.setVisible(true);
                d.display(state,time);
                s.writeToFile();
            }
        } else if (choice == 2) {
            start = System.currentTimeMillis();
            state = s.dfs(initialState, goalState);
            end = System.currentTimeMillis();
            time = (end-start);

            d.setVisible(true);
            d.display(state,time);
            s.writeToFile();

        } else if (choice == 3) {
            System.out.println("\nChoose a distance type:\n\n1.Manhattan\n2.Euclidean");
            choice2 = input.nextInt();
            if (choice2 == 1) {
                start = System.currentTimeMillis();

                informedState = s.aStar(initialState, goalState, "Manhattan");
                end = System.currentTimeMillis();
            time = (end-start);

                if (informedState != null) {
                    d.setVisible(true);
                    d.display(informedState,time);
                }
            } else if (choice2 == 2) {
                start = System.currentTimeMillis();

                informedState = s.aStar(initialState, goalState, "Euclidean");
                end = System.currentTimeMillis();
            time = (end-start);

                if (informedState != null) {
                    d.setVisible(true);
                    d.display(informedState,time);
                }
            } else {
                System.out.println("WRONG CHOICE");
            }
            s.writeToFile();

        } else {
            System.out.println("WRONG CHOICE");
        }
        /*
Queue<Node> q = new LinkedList<>();

q.add(new Node("hatem"));

        System.out.println(s.inQueue("hatem", q));
         *//*
Node state = s.dfs("123560784", "123586074");
Stack<InformedNode> st = new Stack();
if(state !=null)       
{
    
    

}
else
 System.out.println("Unable to reach the goal");*/
 /*
        Set<String> explored = new HashSet<String>();
           Queue<Node> frontier =  new LinkedList<Node>();

       String stt = "0123456";
       Node n1 = new Node(stt);
explored.add("0123456");
frontier.add(new Node(stt));
if(explored.contains(stt))
            System.out.println("yes");*/

 /*
n.expand();
    ArrayList<Node> ch = n.getChildren();
    
    for(Node n1 :ch){
        System.out.println(n1.getState());
    }
    

    }*/

    }
    
   static String parse(String s){
    String str="";
    String[] ss = s.split(",",10);
    for(String i: ss)
    {
    str+=i;
    }
        return str.trim();
    }
}
