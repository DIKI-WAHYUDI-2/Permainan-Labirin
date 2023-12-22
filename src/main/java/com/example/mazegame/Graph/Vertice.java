package com.example.mazegame.Graph;

import java.util.Objects;

public class Vertice {
    int row;
    int col;

    public Vertice(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String toString() {
        return "(" + row + ", " + col + ")";
    }

    // Menambahkan metode equals dan hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vertice vertice = (Vertice) obj;
        return row == vertice.row && col == vertice.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
