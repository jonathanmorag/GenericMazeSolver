# Generic Maze Solver
A generic maze solver that accepts variety of search algorithms (A*, BFS, DFS, etc...) in order to solve variety of maze search problems (shortest path in matrix, Eight-Puzzle game, word domains, etc...) using dependency injection and smart use of design patterns and generics.

<html>
<h2>The Design</h2>
<p align="center">
  <img src="https://i.imgur.com/Aoeso5s.png" width="900" height="310"/>
</p>
<p>
The above design is called <strong>strategy pattern</strong> - which means that a class behavior or its algorithm can be changed at runtime.
In our project, we're able to solve any searchable problem that meets requirements of a searchable algorithm interface, by getting that
information in runtime.
In fact, this is a bi-directional strategy pattern thanks to this project's flexibility - we can choose any algorithm to solve any searchable problem
(as long as they implement its respectively interfaces).
So, in runtime we could change the behavior of the solution by injecting a new problem, and as well we save duplicate code problems through interfaces and inheritance.
</p>
<h2>Eight Puzzle Solution Example</h2>
<p>
In the Eight Puzzle searchable problem, we calculate the costs thanks to the <strong>hamming function</strong> - which
considers how far are the numbers in the current matrix state compared to the goal state (which is constant).
In each cell where there is a mismatch, we "punish" the state's cost by 1.
We also consider the number of inversions in the cost calculations.
As well as the hamming function, we could have implemented any other heuristic approach (such as Manhattan Distance).
</p>
<p align="center">
  <img src="https://i.ibb.co/wR7qZQ9/Untitled-Diagram-1.jpg" />
</p>
</html>
