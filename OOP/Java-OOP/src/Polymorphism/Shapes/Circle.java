package Polymorphism.Shapes;

public class Circle extends Shape {
    public final Double getRadius() {
        return radius;
    }

    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculatePerimeter() {
        return this.radius * 2 * Math.PI;
    }

    @Override
    public Double calculateArea() {
        return this.radius * this.radius * Math.PI;
    }
}
