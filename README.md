## Maze Generator and Solver in Java
This project implements a Maze Generator and Maze Solver in Java using object-oriented principles. The maze is generated using a randomized algorithm and then solved using a pathfinding technique. 

## Project Structure
MazeGenerator.java
Generates a maze with randomized paths using a recursive backtracking algorithm.
Also includes logic to solve the maze using a variation of the A* search algorithm.

MazeSolverProject.java
Contains the main method. Uses the MazeGenerator to generate a maze, converts it to a 2D grid format, and then solves it using depth-first search (DFS) with a stack-based backtracking approach.

Stack.java
A generic stack implementation using linked nodes. Used to manage the movement history and path coordinates during solving.


## How It Works
### Maze Generation
A maze of customizable size is generated.
Each cell is randomly connected to its neighbors while ensuring there's at least one path from start to end.

### Maze Solving
Begins from the top-left corner [1, 1] and tries to reach the bottom-right corner [2 * grid - 1, 2 * grid - 1].
Uses depth-first search with backtracking via a custom Stack to explore valid paths.
When a dead-end is encountered, it backtracks and tries alternative directions.

### Visualization
Every move and backtrack is visualized in the console with MazeUtility.plotMaze().

## Features
- Random maze generation with variable size.
- Pathfinding with DFS and backtracking.
- Visual step-by-step path plotting.
- Custom stack data structure.
- Easy to expand or integrate into a graphical interface.



