public abstract class Animal {
    public String getName() {
        return name;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    private String name;
    private String favouriteFood;

    protected Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }


    public String explainSelf(){
        return String.format("I am %s and my favourite food is %s.",
                this.getName(), this.getFavouriteFood());
    }
}
