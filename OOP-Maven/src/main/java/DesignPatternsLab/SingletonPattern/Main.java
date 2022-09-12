package DesignPatternsLab.SingletonPattern;

public class Main {
    public static void main(String[] args) {
        SingletonPopulationContainer instance = SingletonPopulationContainer.getInstance();
        instance.increasePopulation("Sofia", 120000);
        instance.increasePopulation("Varna", 90000);
    }
}
