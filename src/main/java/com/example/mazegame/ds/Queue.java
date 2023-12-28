package com.example.mazegame.ds;

public class Queue {

    private int[] data;
    private int tail;

    public Queue(int n){
        this.data = new int[n];
        this.tail = 0;
    }

    public boolean isEmpty(){
        return this.tail == 0;
    }

    public boolean isFull(){
        return this.tail == this.data.length;
    }

    public void enqueue(int value){
        if (!this.isFull()){
            this.data[this.tail++] = value;
        }else {
            System.out.println("Queue sudah penuh");
        }
    }

    public int dequeue(){
        if (!this.isEmpty()){
            int result = data[0];
            tail--;
            for (int i = 0; i < this.data.length-1; i++) {
                this.data[i] = this.data[i+1];
            }
            this.data[this.data.length-1] = 0;
            return result;
        }else {
            System.out.println("Queue kosong");
            return -1;
        }
    }

}
