package DesignPatternsLab.SingletonPattern;

import java.util.HashMap;
import java.util.Map;

public class SingletonPopulationContainer implements SingletonContainer {
    public static SingletonPopulationContainer instance;
    private Map<String, Integer> populationMap;

    private SingletonPopulationContainer() {
        this.populationMap = new HashMap<>();
    }

    public static SingletonPopulationContainer getInstance() {
        if (instance == null) {
            instance = new SingletonPopulationContainer();
        }
        return instance;
    }

    @Override
    public int getPopulation(String city) {
        return this.populationMap.get(city);
    }

    public void increasePopulation(String city, int increment){
        this.populationMap.putIfAbsent(city,0);
        this.populationMap.put(city,this.populationMap.get(city)+increment);
    }
    public void decreasePopulation(String city, int decrement){
        this.populationMap.put(city,this.populationMap.get(city)-decrement);
    }
}
