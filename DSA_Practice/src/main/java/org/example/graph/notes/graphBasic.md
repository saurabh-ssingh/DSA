# Graphs: Basic Terminology, Types, Representation, and Operations

## Basic Terminology
- **Vertices (Nodes):** The fundamental units of a graph, representing entities or objects.
- **Edges (Arcs):** The connections between pairs of vertices, representing relationships or interactions.

## Types of Graphs
- **Undirected Graph:** In this type of graph, edges have no direction. If there is an edge between vertex A and vertex B, you can move from A to B and from B to A.
- **Directed Graph (Digraph):** Here, edges have a direction, indicated by an arrow. If there is a directed edge from vertex A to vertex B, you can only move from A to B, not the other way around.
- **Weighted Graph:** A graph in which each edge has a weight or cost associated with it, often used to represent distances, costs, or capacities.
- **Unweighted Graph:** A graph where all edges are equal, meaning there is no weight associated with any edge.

## Representation of Graphs
- **Adjacency Matrix:** A 2D array where the cell at row `i` and column `j` is `1` (or the weight of the edge) if there is an edge from vertex `i` to vertex `j`; otherwise, it is `0`.
- **Adjacency List:** An array of lists. The index of the array represents a vertex, and the list at each index contains the neighbors of that vertex.

## Basic Operations
- **Add Vertex:** Adding a new vertex to the graph.
- **Add Edge:** Connecting two vertices with an edge.
- **Remove Vertex:** Deleting a vertex and all associated edges.
- **Remove Edge:** Deleting a connection between two vertices.

## Traversal
- **Depth-First Search (DFS):** Explores as far as possible along each branch before backtracking.
- **Breadth-First Search (BFS):** Explores all the neighbors at the present depth before moving on to nodes at the next depth level.

## Applications
- Social networks (modeling friendships or connections)
- Transportation networks (roads, flights)
- Web page linking (hyperlinks between pages)
- Recommendation systems

Graphs are powerful tools for modeling and solving complex problems in various domains.
