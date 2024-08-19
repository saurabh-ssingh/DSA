package org.example.graph;

import java.util.ArrayList;

public class Graph {
  static class Edge{
    int source;
    int destination;

    Edge(int s,int d){
      this.source = s;
      this.destination = d;
    }

  }

  public static void createGraph(ArrayList<Edge> graph[]){
    for(int i=0;i<graph.length;i++){
      graph[i] = new ArrayList<Edge>();
    }
    graph[0].add(new Edge(0,2));

    graph[1].add(new Edge(1,2));
    graph[1].add(new Edge(1,3));

    graph[2].add(new Edge(2,0));
    graph[2].add(new Edge(2,1));
    graph[2].add(new Edge(2,3));

    graph[3].add(new Edge(3,1));
    graph[3].add(new Edge(3,2));

  }

  public static void main(String[] args) {
    int vertex = 4;
    ArrayList<Edge> graph[] = new ArrayList[4];
  }

}
