package Polymorphism.Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    public Double getPerimeter() {
        return perimeter;
    }

    public Double getArea() {
        return area;
    }

    protected Shape() {
        this.perimeter = calculatePerimeter();
        this.area = calculateArea();
    }

    public abstract Double calculatePerimeter();

    public abstract Double calculateArea();

}
