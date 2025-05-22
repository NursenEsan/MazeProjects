/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 * @author nursen
 */
public class MazeSolverProject {


    public static void main(String[] args) {
        int grid = 5;
        int[][] maze = getMaze(grid);
        Stack path = new Stack();
        Stack pathNumeric = new Stack<int[]>();

        maze[1][1] = 2;
        MazeUtility.plotMaze(maze);
        solve(maze, 9, 9, 1, 1, path, pathNumeric);
        printSolution(path);

        // To do: starting from the coordinates [1,1], use the path stack to navigate in the maze and 
        // find a way to [2*grid-1, 2*grid-1] coordinates
        // use the following code to print the maze at each step
        // MazeUtility.plotMaze(maze);  
        // DO NOT change any of the given code unless you are adding stuff to this class
    }


    public static void solve(int[][] maze, int endRow, int endColumn, int startRow, int startColumn, Stack path, Stack<int[]> pathNumeric) {

        while (startRow != endRow || startColumn != endColumn) {
            int[] coordinate = {startRow, startColumn};
            pathNumeric.push(coordinate);
            if (maze[startRow][startColumn + 1] == 0) {
                startColumn += 1;
                path.push("RIGHT");
                maze[startRow][startColumn] = 2;
                
                MazeUtility.plotMaze(maze);


            } else if (maze[startRow + 1][startColumn] == 0) {
                startRow += 1;
                path.push("DOWN");
                maze[startRow][startColumn] = 2;
                
                MazeUtility.plotMaze(maze);

            } else if (maze[startRow - 1][startColumn] == 0) {

                startRow -= 1;
                path.push("UP");
                maze[startRow][startColumn] = 2;
                
                MazeUtility.plotMaze(maze);
            } else if (maze[startRow][startColumn - 1] == 0) {
                startColumn -= 1;

                path.push("LEFT");
                maze[startRow][startColumn] = 2;
                
                MazeUtility.plotMaze(maze);

            } else {
                
                MazeUtility.plotMaze(maze);
                if (!pathNumeric.isEmpty()) {
                    int[] oldCoordinate = pathNumeric.pop();
                    maze[oldCoordinate[0]][oldCoordinate[1]] = -1;
                    int[] newCoordinate = pathNumeric.pop();
                    startRow = newCoordinate[0];
                    startColumn = newCoordinate[1];
                }
            }
        }
    }

    public static void printSolution(Stack path) {
        Stack tmp = new Stack();
        while (!path.isEmpty()) {
            tmp.push(path.pop());
        }
        while (!tmp.isEmpty()) {
            switch (tmp.pop().toString()) {
                case "RIGHT":
                    System.out.print(" - ");
                    System.out.print("RIGHT");
                    break;
                case "LEFT":
                    System.out.print(" - ");
                    System.out.print("LEFT");
                    break;
                case "UP":
                    System.out.print(" - ");
                    System.out.print("UP");
                    break;
                case "DOWN":
                    System.out.print(" - ");
                    System.out.print("DOWN");
                    break;
            }
        }
    }

    public static int[][] getMaze(int grid) {
        MazeGenerator maze = new MazeGenerator(grid);
        String str = maze.toString();

        int[][] maze2D = MazeUtility.Convert2D(str);
        return maze2D;
    }


}

