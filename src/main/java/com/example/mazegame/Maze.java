package com.example.mazegame;

public class Maze {
    private static char[][] maze;

    public void switchMaze(String level){
        if (level.equals("easy")){
            maze = new char[][] {
                    {'.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
                    {'.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0'},
                    {'0', '.', '0', '.', '.', '.', '0', '.', '0', '0', '0', '.', '0'},
                    {'0', '.', '.', '.', '0', '0', '0', '.', '.', '.', '.', '.', '0'},
                    {'0', '.', '0', '.', '.', '.', '.', '.', '0', '0', '0', '.', '0'},
                    {'0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '.', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '.', '.', '0', '0', '0', '.', '0'},
                    {'0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0'},
                    {'0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0'},
                    {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '.'}
            };
        } else if (level.equals("medium")) {
            maze = new char[][]{
                    {'.', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
                    {'0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0'},
                    {'0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0'},
                    {'0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0'},
                    {'0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0'},
                    {'0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0'},
                    {'0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0'},
                    {'0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0'},
                    {'0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0'},
                    {'0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0'},
                    {'0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0'},
                    {'0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0'},
                    {'0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0'},
                    {'0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0'} ,
                    {'0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0'} ,
                    {'0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0'},
                    {'0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0'},
                    {'0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0'},
                    {'0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0'},
                    {'0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0'},
                    {'0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0'},
                    {'0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0'},
                    {'0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0'},
                    {'0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0'},
                    {'0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0'},
                    {'0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0'},
                    {'0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0'},
                    {'0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0'},
                    {'0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0'},
                    {'0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0'},
                    {'0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0'},
                    {'0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0'} ,
                    {'0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0'},
                    {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '.'}
            };
        } else if (level.equals("hard")) {
            maze = new char[][] {
                    {'.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
                    {'.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0'},
                    {'0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0'},
                    {'0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0'},
                    {'0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0'},
                    {'0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0'},
                    {'0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0'},
                    {'0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0'},
                    {'0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0'},
                    {'0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0'},
                    {'0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0'},
                    {'0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0'},
                    {'0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0'},
                    {'0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0'},
                    {'0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0'},
                    {'0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0'},
                    {'0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0'},
                    {'0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0'},
                    {'0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0'},
                    {'0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0'},
                    {'0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
                    {'0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0'},
                    {'0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0'},
                    {'0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0'},
                    {'0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0'},
                    {'0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0'},
                    {'0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0'},
                    {'0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0'},
                    {'0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0'},
                    {'0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0'},
                    {'0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0'},
                    {'0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0'},
                    {'0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0'},
                    {'0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0'},
                    {'0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0'},
                    {'0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0'},
                    {'0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0'},
                    {'0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0'},
                    {'0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0'},
                    {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0'},
                    {'0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0'},
                    {'0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0'},
                    {'0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0'},
                    {'0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0'},
                    {'0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0'},
                    {'0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0'},
                    {'0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0'},
                    {'0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0'},
                    {'0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0'},
                    {'0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0'},
                    {'0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0'},
                    {'0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0'},
                    {'0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0'},
                    {'0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0'},
                    {'0', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0'},
                    {'0', '.', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '0', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '.', '0', '.', '0', '.', '0', '0', '0', '0', '0', '.', '0', '0', '0', '.', '0'},
                    {'0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '.', '.', '.'},
                    {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.'}
            };
        }
    }

    public static char[][] getMaze() {
        return maze;
    }
}
