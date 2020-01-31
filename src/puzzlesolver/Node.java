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
public class Node {

    ArrayList<Node> children;
    String state;
     Node parent;
     boolean visited;
    int totalCost;
    
    public Node(String state) {
        this.state = state;
        parent = null;
        visited = false;
        totalCost=0;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
    

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void expand() {
        int index;
        children = new ArrayList<>();
        index = state.indexOf("0");
        switch (index) {
            case 0: {
                Node child = new Node(moveDown(state));
                child.parent = this;
                children.add(child);
                child = new Node(moveRight(state));
                child.parent = this;
                children.add(child);
                break;
            }
            case 1: {
                Node child = new Node(moveDown(state));
                child.parent = this;
                children.add(child);
                child = new Node(moveLeft(state));
                child.parent = this;
                children.add(child);
                child = new Node(moveRight(state));
                child.parent = this;
                children.add(child);
                break;
            }
            case 2: {
                Node child = new Node(moveDown(state));
                child.parent = this;
                children.add(child);
                child = new Node(moveLeft(state));
                child.parent = this;
                children.add(child);
                break;
            }
            case 3: {
                Node child = new Node(moveUp(state));
                child.parent = this;
                children.add(child);
                child = new Node(moveDown(state));
                child.parent = this;
                children.add(child);
                child = new Node(moveRight(state));
                child.parent = this;
                children.add(child);
                break;
            }
            case 4: {
                Node child = new Node(moveUp(state));
                child.parent = this;
                children.add(child);
                child = new Node(moveDown(state));
                child.parent = this;
                children.add(child);
                child = new Node(moveLeft(state));
                child.parent = this;
                children.add(child);
                child = new Node(moveRight(state));
                child.parent = this;
                children.add(child);
                break;
            }
            case 5: {
                Node child = new Node(moveUp(state));
                child.parent = this;
                children.add(child);
                child = new Node(moveDown(state));
                child.parent = this;
                children.add(child);
                child = new Node(moveLeft(state));
                child.parent = this;
                children.add(child);

                break;
            }
            case 6: {
                Node child = new Node(moveUp(state));
                child.parent = this;
                children.add(child);
                child = new Node(moveRight(state));
                child.parent = this;
                children.add(child);
                break;
            }
            case 7: {
                Node child = new Node(moveUp(state));
                child.parent = this;
                children.add(child);
                child = new Node(moveLeft(state));
                child.parent = this;
                children.add(child);
                child = new Node(moveRight(state));
                child.parent = this;
                children.add(child);
                break;
            }
            case 8: {
                Node child = new Node(moveUp(state));
                child.parent = this;
                children.add(child);
                child = new Node(moveLeft(state));
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
    @Override
    public String toString(){
    
    return this.getState();
    }

}
