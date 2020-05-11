package com.company;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    private List<Item> items;;
    private Backpack bag;
    private final int MAX_WEIGHT = 65;
    private Item[] goods = {
            new Item("", 15, 100),
            new Item("", 30, 70),
            new Item("", 40, 85)
    };
    public Main() {
        items = new ArrayList<>();
        bag = new Backpack(65);
    }
    public void run() {
        items.add(new Item("Book", 5, 15));
        items.add(new Item("Cheese", 3, 11));
        items.add(new Item("Brick", 7, 9));

        System.out.println(combine(items.size() - 1, bag.getMaxW()));
    }
    private double combine(int len, double weight){
        if (len < 0)
            return 0;
        if (items.get(len).getWeight() > weight)
            return combine(len-1, weight);
        else
            return Math.max(combine(len-1, weight), combine(len - 1, weight - items.get(len).getWeight()) + items.get(len).getValue());
    }
    public class Item {
        private String name;
        private double weight;
        private double value;
        public Item(String name, double weight, double value) {
            this.name = name;
            this.weight = weight;
        }
        public String getName() {
            return name;
        }
        public double getWeight() {
            return weight;
        }
        public double getValue() {
            return value;
        }
        public void setWeight(double weight) {
            this.weight = weight;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setValue(double value) {
            this.value = value;
        }
    }
    public class Backpack {
        private double maxW;
        private double maxC;
        private List<Item> bestItems = null;

        public Backpack(double maxW){
            this.maxW = maxW;
        }
        public double getMaxW(){
            return this.maxW;
        }

    }
}