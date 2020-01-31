/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlesolver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Ahmed Hatem
 */
public class Search {

    static int expandedNodes = 0;
    static int count = 0,depth=0;
    String output;

    public Node bfs(String state, String goalState) {
        String st = "";
        output = "";
        Node currentState = new Node("");
        Queue<Node> frontier = new LinkedList<Node>();

        Set<String> explored = new HashSet<String>();
        ArrayList<Node> neighbours;
        Node root = new Node(state);
        root.setParent(null);
        output += "Initial state is " + root.getState() + "\n\n";
        frontier.add(root);
       
        while (!frontier.isEmpty()) {

            count++;
            currentState = frontier.poll();
            st = currentState.getState();
            explored.add(st);
            if (st.equalsIgnoreCase(goalState)) {
                output += "**** Goal state is reached : " + currentState.getState() + " *****";
                return currentState;
            }
            currentState.expand();

            neighbours = currentState.getChildren();
            output += "New State is : " + currentState.getState() + "\n";
            output += currentState.getState() + " expands: ";
            for (Node n : neighbours) {

                if (!(explored.contains(n.getState()) || frontier.contains(n))) {
                    n.setTotalCost(getDistanceCovered(n));
                    expandedNodes++;
                    frontier.add(n);
                    output += n.getState() + "  ";
                }
            }
            output += "\n\n";

        }
        return null;

    }

    public Node dfs(String state, String goalState) {
        String st = "";
        output = "";
        Node currentState = new Node("");
        Stack<Node> frontier = new Stack<Node>();
        Set<String> explored = new HashSet<String>();
        ArrayList<Node> neighbours;
        Node root = new Node(state);
        root.setParent(null);
        root.setTotalCost(0);
        output += "Initial state is " + root.getState() + "\n\n";
        frontier.push(root);
       
        while (!frontier.empty()) {
            count++;
            currentState = frontier.pop();
            st = currentState.getState();
            explored.add(st);
            if (st.equalsIgnoreCase(goalState)) {
                output += "**** Goal state is reached : " + currentState.getState() + " *****";
                return currentState;
            }
            currentState.expand();

            neighbours = currentState.getChildren();
            output += "New State is : " + currentState.getState() + "\n";
            output += currentState.getState() + " expands: ";
            for (Node n : neighbours) {

                if (!(explored.contains(n.getState()) || frontier.contains(n))) {
                    expandedNodes++;
                    n.setTotalCost(getDistanceCovered(n));
                    frontier.add(n);
                    output += n.getState() + "  ";
                }
            }
            output += "\n\n";
        }
        return null;
    }

    public InformedNode aStar(String state, String goalState, String heuristic) {
        String st = "";
        output = "";
        InformedNode currentState = new InformedNode("");
        PriorityQueue<InformedNode> frontier = new PriorityQueue<InformedNode>(10, new PriorityComparator());
        Set<String> explored = new HashSet<String>();
        Heuristics h = new Heuristics();
        ArrayList<InformedNode> neighbours;
        InformedNode root = new InformedNode(state);
        root.setParent(null);
        root.setDistanceCovered(0);
        output += "Initial state is " + root.getState() + "\n\n";

        if (heuristic.equalsIgnoreCase("manhattan")) {
            root.setHeuristicDistance(h.manahttanHeuristic(root.getState(), goalState));
        } else {
            root.setHeuristicDistance(h.eucledeanHeuristic(root.getState(), goalState));
        }
        root.setTotalCost(root.getHeuristicDistance());
        frontier.add(root);
      
        while (!frontier.isEmpty()) {

            count++;
            currentState = frontier.poll();
            st = currentState.getState();
            explored.add(st);
            if (st.equalsIgnoreCase(goalState)) {
                output += "**** Goal state is reached : " + currentState.getState() + " *****";
                return currentState;
            }
            currentState.expand();
            neighbours = currentState.getChildren();
            output += "New State is : " + currentState.getState()
                    + " (h=" + currentState.getHeuristicDistance() + ",g=" + currentState.getDistanceCovered() + ",f=" + currentState.getTotalCost() + ")" + "\n";
            output += currentState.getState() + " expands: ";

            for (InformedNode n : neighbours) {

                if (frontier.contains(n)) {
                    frontier.remove(n);
                    if (heuristic.equalsIgnoreCase("manhattan")) {
                        n.setHeuristicDistance(h.manahttanHeuristic(n.getState(), goalState));
                    } else {
                        n.setHeuristicDistance(h.eucledeanHeuristic(n.getState(), goalState));
                    }

                    n.setDistanceCovered(getDistanceCovered(n));
                    n.setTotalCost(n.getHeuristicDistance() + n.getDistanceCovered());
                    output += "*** State " + n.getState() + "updated with total cost " + n.getTotalCost();
                    frontier.add(n);
                }
                if (!(explored.contains(n.getState()) || frontier.contains(n))) {
                    expandedNodes++;
                    if (heuristic.equalsIgnoreCase("manhattan")) {
                        n.setHeuristicDistance(h.manahttanHeuristic(n.getState(), goalState));
                    } else {
                        n.setHeuristicDistance(h.eucledeanHeuristic(n.getState(), goalState));
                    }

                    n.setDistanceCovered(getDistanceCovered(n));
                    n.setTotalCost(n.getHeuristicDistance() + n.getDistanceCovered());
                    output += n.getState()
                            + "-->(h=" + n.getHeuristicDistance() + ",g=" + n.getDistanceCovered() + ",f=" + n.getTotalCost() + ")  ";
                    frontier.add(n);
                }

            }
            output += "\n\n";
        }
        return null;

    }

    public int getDistanceCovered(InformedNode state) {
        int cost = 0;
        InformedNode n = state;
        while (n.getParent() != null) {
            cost++;
            n = n.getParent();
        }
        return cost;

    }

    public int getDistanceCovered(Node state) {
        int cost = 0;
        Node n = state;
        while (n.getParent() != null) {
            cost++;
            n = n.getParent();
        }
        return cost;

    }

    public void writeToFile() {
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter(new File("output.txt")));
            write.write(output);

            write.close();

        } catch (Exception e) {
            System.out.println("Error");
        }

    }

}