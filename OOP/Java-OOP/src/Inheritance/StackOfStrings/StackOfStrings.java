package Inheritance.StackOfStrings;

import java.util.ArrayList;


public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String element) {
        this.data.add(element);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    public String peek() {
        return this.data.get(0);
    }

    public String pop() {
        return this.data.get(this.data.toArray().length - 1);
    }
}
