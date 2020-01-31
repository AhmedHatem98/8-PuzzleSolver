/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlesolver;

import java.util.ArrayList;

/**
 *
 * @author Ahmed Hatem
 */
public class InformedNode {
 
private int distanceCovered;  
private int heuristicDistance;
private int totalCost;
ArrayList<InformedNode> children;
static int heuristic;    
private String state;
     private InformedNode parent;
 public InformedNode(String state){
 this.state = state;
        parent = null;
 distanceCovered=0;
 heuristicDistance=0;
 totalCost=0;
 }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public ArrayList<InformedNode> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<InformedNode> children) {
        this.children = children;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public InformedNode getParent() {
        return parent;
    }

    public void setParent(InformedNode parent) {
        this.parent = parent;
    }

   

    public int getDistanceCovered() {
        return distanceCovered;
    }

    public void setDistanceCovered(int distanceCovered) {
        this.distanceCovered = distanceCovered;
    }

    public int getHeuristicDistance() {
        return heuristicDistance;
    }

    public void setHeuristicDistance(int heuristicDistance) {
        this.heuristicDistance = heuristicDistance;
    }

   

 
  

 public void expand(){
 int index;
        children = new ArrayList<InformedNode>();
        index = state.indexOf("0");
        switch (index) {
            case 0: {
                InformedNode child = new InformedNode(moveDown(state));
                child.parent = this;
                children.add(child);
                child = new InformedNode(moveRight(state));
                child.parent = this;
                children.add(child);
                break;
            }
            case 1: {
                InformedNode child = new InformedNode(moveDown(state));
                child.parent = this;
                children.add(child);
                child = new InformedNode(moveLeft(state));
                child.parent = this;
                children.add(child);
                child = new InformedNode(moveRight(state));
                child.parent = this;
                children.add(child);
                break;
            }
            case 2: {
                InformedNode child = new InformedNode(moveDown(state));
                child.parent = this;
                children.add(child);
                child = new InformedNode(moveLeft(state));
                child.parent = this;
                children.add(child);
                break;
            }
            case 3: {
                InformedNode child = new InformedNode(moveUp(state));
                child.parent = this;
                children.add(child);
                child = new InformedNode(moveDown(state));
                child.parent = this;
                children.add(child);
                child = new InformedNode(moveRight(state));
                child.parent = this;
                children.add(child);
                break;
            }
            case 4: {
                InformedNode child = new InformedNode(moveUp(state));
                child.parent = this;
                children.add(child);
                child = new InformedNode(moveDown(state));
                child.parent = this;
                children.add(child);
                child = new InformedNode(moveLeft(state));
                child.parent = this;
                children.add(child);
                child = new InformedNode(moveRight(state));
                child.parent = this;
                children.add(child);
                break;
            }
            case 5: {
                InformedNode child = new InformedNode(moveUp(state));
                child.parent = this;
                children.add(child);
                child = new InformedNode(moveDown(state));
                child.parent = this;
                children.add(child);
                child = new InformedNode(moveLeft(state));
                child.parent = this;
                children.add(child);

                break;
            }
            case 6: {
                InformedNode child = new InformedNode(moveUp(state));
                child.parent = this;
                children.add(child);
                child = new InformedNode(moveRight(state));
                child.parent = this;
                children.add(child);
                break;
            }
            case 7: {
                InformedNode child = new InformedNode(moveUp(state));
                child.parent = this;
                children.add(child);
                child = new InformedNode(moveLeft(state));
                child.parent = this;
                children.add(child);
                child = new InformedNode(moveRight(state));
                child.parent = this;
                children.add(child);
                break;
            }
            case 8: {
                InformedNode child = new InformedNode(moveUp(state));
                child.parent = this;
                children.add(child);
                child = new InformedNode(moveLeft(state));
                child.parent = this;
                children.add(child);
                break;
            }
        }
 
 
 
 }
   protected String moveUp(String state) {
        int index = state.indexOf("0");
        String str = state.replace(state.charAt(index), 'x');
        str = str.replace(state.charAt(index - 3), state.charAt(index));
        return str.replace('x', state.charAt(index - 3));

    }

    protected String moveDown(String state) {
        int index = state.indexOf("0");
        String str = state.replace(state.charAt(index), 'x');
        str = str.replace(state.charAt(index + 3), state.charAt(index));
        return str.replace('x', state.charAt(index + 3));
    }

    protected String moveLeft(String state) {
        int index = state.indexOf("0");
        String str = state.replace(state.charAt(index), 'x');
        str = str.replace(state.charAt(index - 1), state.charAt(index));
        return str.replace('x', state.charAt(index - 1));

    }

    protected String moveRight(String state) {
        int index = state.indexOf("0");
        String str = state.replace(state.charAt(index), 'x');
        str = str.replace(state.charAt(index + 1), state.charAt(index));
        return str.replace('x', state.charAt(index + 1));

    }


 public String toString(){
 
 return this.getState()+" h="+this.getHeuristicDistance()+" g="+this.getDistanceCovered()+" f="+this.getTotalCost();
 
 }
    
}
