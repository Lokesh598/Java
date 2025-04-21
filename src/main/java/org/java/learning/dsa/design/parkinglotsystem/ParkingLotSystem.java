package org.java.learning.dsa.design.parkinglotsystem;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotSystem {

    enum VehicleSize {
        MOTORCYCLE, COMPACT, LARGE
    }

    static abstract class Vehicle {
        protected VehicleSize size;
        protected String licensePlate;
        protected int spotSize;
        protected List<ParkingSpot> spotsTaken;

        public Vehicle(VehicleSize size, String licensePlate, int spotSize) {
            this.size = size;
            this.licensePlate = licensePlate;
            this.spotSize = spotSize;
            this.spotsTaken = new ArrayList<>();
        }

        public void clearSpots() {
            for (ParkingSpot spot : spotsTaken) {
                spot.removeVehicle();
            }
            spotsTaken.clear();
        }

        public void takeSpot(ParkingSpot spot) {
            spotsTaken.add(spot);
        }

        public abstract boolean canFitInSpot(ParkingSpot spot);

    }
    static class Motorcycle extends Vehicle{
        public Motorcycle(String licensePlate) {
            super(VehicleSize.MOTORCYCLE, licensePlate, 1);
        }

        @Override
        public boolean canFitInSpot(ParkingSpot spot) {
            return true;
        }
    }
    static class Car extends Vehicle{
        public Car(String licensePlate) {
            super(VehicleSize.COMPACT, licensePlate, 1);
        }

        @Override
        public boolean canFitInSpot(ParkingSpot spot) {
            return spot.getSize() == VehicleSize.LARGE || spot.getSize() == VehicleSize.COMPACT;
        }
    }

    static class Bus extends Vehicle {
        public Bus(String licensePlate) {
            super(VehicleSize.LARGE, licensePlate, 5);
        }

        @Override
        public boolean canFitInSpot(ParkingSpot spot) {
            return spot.getSize() == VehicleSize.LARGE;
        }
    }

    static class ParkingLot {
        private List<Level> levels;

        public ParkingLot(int numLevels) {
            levels = new ArrayList<>();
            for (int i = 0; i < numLevels; i++) {
                levels.add(new Level(i, 30)); // Assuming 30 spots per level
            }
        }

        public boolean parkVehicle(Vehicle vehicle) {
            for (Level level : levels) {
                if (level.parkVehicle(vehicle)) {
                    return true;
                }
            }
            return false;
        }
    }

    static class Level {
        private int floor;
        private int numSpots;
        private int availableSpots;
        private List<ParkingSpot> parkingSpots;

        public Level(int floor, int totalSpots) {
            this.floor = floor;
            this.numSpots = totalSpots;
            this.availableSpots = totalSpots;
            this.parkingSpots = new ArrayList<>();
            for (int i = 0; i < totalSpots; i++) {
                parkingSpots.add(new ParkingSpot(this, i, VehicleSize.COMPACT));
            }
        }

        public void spotFreed() {
            availableSpots++;
        }

        public boolean parkVehicle(Vehicle vehicle) {
            ParkingSpot spot = findAvailableSpot(vehicle);
            if (spot == null) {
                return false;
            } else {
                spot.parkVehicle(vehicle);
                return true;
            }
        }

        private ParkingSpot findAvailableSpot(Vehicle vehicle) {
            for (ParkingSpot spot : parkingSpots) {
                if (spot.canFitVehicle(vehicle) && spot.isAvailable()) {
                    return spot;
                }
            }
            return null;
        }
    }
    static class ParkingSpot {
        private Level level;
        private int spotNumber;
        private VehicleSize size;
        private Vehicle vehicle;

        public ParkingSpot(Level level, int spotNumber, VehicleSize size) {
            this.level = level;
            this.spotNumber = spotNumber;
            this.size = size;
            this.vehicle = null;
        }

        public boolean isAvailable() {
            return vehicle == null;
        }

        public boolean canFitVehicle(Vehicle vehicle) {
            if (this.vehicle != null) {
                return false;
            }
            return vehicle.canFitInSpot(this);
        }

        public void parkVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            vehicle.takeSpot(this);
        }

        public void removeVehicle() {
            this.vehicle = null;
            level.spotFreed();
        }

        public VehicleSize getSize() {
            return size;
        }
    }

    static class ParkingLotTest {
        public static void main(String[] args) {
            // Create a parking lot with 3 levels
            ParkingLot parkingLot = new ParkingLot(3);

            // Create vehicles
            Vehicle motorcycle = new Motorcycle("MOTO-123");
            Vehicle car = new Car("CAR-456");
            Vehicle bus = new Bus("BUS-789");

            // Park vehicles
            System.out.println("Parking motorcycle: " + parkingLot.parkVehicle(motorcycle));
            System.out.println("Parking car: " + parkingLot.parkVehicle(car));
            System.out.println("Parking bus: " + parkingLot.parkVehicle(bus));

            // Clear spots
            car.clearSpots();
            System.out.println("Car removed from parking.");
        }
    }

}
