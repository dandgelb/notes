package com.examples.algorithms;

class Maze {

    public boolean inBounds(int row, int col) {
        return false;
    }

    public boolean isWall(int row, int col) {
        return false;
    }

    public void mark(int row, int col) {
    }

    public boolean isOpen(int row, int col) {
        return false;
    }

    public void taint(int row, int col) {
    }
}

class MazeSolver {

    boolean escapeMaze(Maze maze, int row, int col) {
        //base case - multiple
        if(!maze.inBounds(row, col)) {
            return true;
        } else if(maze.isWall(row, col)) {
            return false;
        } else if(maze.isOpen(row, col)){
            maze.mark(row, col);
            boolean result =  escapeMaze(maze, row - 1, col) //up
                || escapeMaze(maze, row + 1, col) //down
                || escapeMaze(maze, row, col - 1)  //left
                || escapeMaze(maze, row, col + 1); //right
            if(!result) {
                maze.taint(row, col);
            }
            return result;
        } else {
            return false;
        }
    }
}
public class EscapeMazeTest {
    //TODO: get the maze implementation from CS106B, Winter 2018 Lecture site, Stanford University
    //https://web.stanford.edu/class/archive/cs/cs106b/cs106b.1152/

}
