package EncapsulationExcercise.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money){
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }
    @Override
    public String toString(){
        if(this.products.size()==0){
            return String.format("%s - Nothing bought%n",
                    getName());
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(getName()).append(" -");
            for(Product product : products){
                sb.append(" ")
                        .append(product.getName())
                        .append(",");
            }
            sb.deleteCharAt(sb.length()-1);
            return sb.toString();

        }
    }

    public void buyProduct(Product product){
        if(product.getCost() > getMoney()){
            throw new IllegalArgumentException(String.format("%s can't afford %s",
                    getName(), product.getName()));
        }
        setMoney(this.money - product.getCost());
        products.add(product);
        System.out.printf("%s bought %s%n",
                getName(), product.getName());
    }

    private void setName(String name) {
        if(name.trim().isBlank() || name.contains("\\s+")){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if(money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }
}
