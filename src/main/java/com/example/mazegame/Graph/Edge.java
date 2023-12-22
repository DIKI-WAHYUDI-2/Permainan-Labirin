package com.example.mazegame.Graph;

public class Edge {
    private Vertice start;
    private Vertice end;

    public Edge(Vertice start, Vertice end) {
        this.start = start;
        this.end = end;
    }

    public Vertice getStart() {
        return start;
    }

    public Vertice getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "(" + start.getRow() + ", " + start.getCol() + ") -> (" + end.getRow() + ", " + end.getCol() + ")";
    }
}

