package org.java.learning.dsa.design.ElevatorSystem;

import java.util.PriorityQueue;

public class Elevator {
    private int currentFloor;
    private PriorityQueue<Integer> upQueue;
    private PriorityQueue<Integer> downQueue;
    private boolean goingUp;

    public Elevator() {
        this.currentFloor = 0; // Ground floor
        this.upQueue = new PriorityQueue<>(); // Min-Heap for ascending requests
        this.downQueue = new PriorityQueue<>((a, b) -> b - a); // Max-Heap for descending requests
        this.goingUp = true; // Default direction
    }

    public void requestFloor(int floor) {
        if (floor > currentFloor) {
            upQueue.add(floor);
        } else {
            downQueue.add(floor);
        }
    }

    public void move() {
        while (!upQueue.isEmpty() || !downQueue.isEmpty()) {
            if (goingUp) {
                while (!upQueue.isEmpty()) {
                    currentFloor = upQueue.poll();
                    System.out.println("Elevator stopping at floor: " + currentFloor);
                }
                goingUp = false;
            } else {
                while (!downQueue.isEmpty()) {
                    currentFloor = downQueue.poll();
                    System.out.println("Elevator stopping at floor: " + currentFloor);
                }
                goingUp = true;
            }
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        elevator.requestFloor(3);
        elevator.requestFloor(1);
        elevator.requestFloor(5);
        elevator.requestFloor(2);
        elevator.requestFloor(4);


        elevator.move();

        System.out.println("Current Floor : "+elevator.getCurrentFloor());

        elevator.requestFloor(3);
        elevator.move();
    }
}
