package org.java.learning.designpatterns.creational.builder;


//pizza class is immutable
public class Pizza {
    // Required attributes
    private final String size;

    // Optional attributes
    private final boolean cheese;
    private final boolean pepperoni;
    private final boolean bacon;

    // Private constructor
    private Pizza(PizzaBuilder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.bacon = builder.bacon;
    }

    @Override
    public String toString() {
        return "Pizza [size=" + size + ", cheese=" + cheese +
                ", pepperoni=" + pepperoni + ", bacon=" + bacon + "]";
    }

    // Builder Class
    public static class PizzaBuilder {
        // Required attributes
        private final String size;

        // Optional attributes - initialized to default values
        private boolean cheese = false;
        private boolean pepperoni = false;
        private boolean bacon = false;

        // Builder constructor for required attributes
        public PizzaBuilder(String size) {
            this.size = size;
        }

        // Methods to set optional attributes
        public PizzaBuilder addCheese() {
            this.cheese = true;
            return this;
        }

        public PizzaBuilder addPepperoni() {
            this.pepperoni = true;
            return this;
        }

        public PizzaBuilder addBacon() {
            this.bacon = true;
            return this;
        }

        // Build method
        public Pizza build() {
            return new Pizza(this);
        }
    }
}


class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.PizzaBuilder("Large")
                .addCheese()
                .addPepperoni()
                .addBacon()
                .build();

        System.out.println(pizza);

        Pizza veggiePizza = new Pizza.PizzaBuilder("Medium")
                .addCheese()
                .build();

        System.out.println(veggiePizza);
    }
}
