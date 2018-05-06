package com.examples.algorithms;

class Maze {

    public boolean inBounds(int row, int col) {
    }

    public boolean isWall(int row, int col) {
    }

    public void mark(int row, int col) {
    }
}

class MazeSolver {

    boolean escapeMaze(Maze maze, int row, int col) {
        //base case - multiple
        if(!maze.inBounds(row, col)) {
            return true;
        } else if(maze.isWall(row, col)) {
            return false;
        } else {
            maze.mark(row, col);
            escapeMaze(maze, row - 1, col); //up
            escapeMaze(maze, row + 1, col); //down
            escapeMaze(maze, row, col - 1); //left
            escapeMaze(maze, row, col + 1); //right
            return (?)
        }
    }
}
public class EscapeMazeTest {

}
