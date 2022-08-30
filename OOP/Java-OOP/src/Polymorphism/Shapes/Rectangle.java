package Polymorphism.Shapes;

public class Rectangle extends Shape {
    private final Double height;

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    private final Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * (this.height + this.width);
    }

    @Override
    public Double calculateArea() {
        return this.height * this.width;
    }
}
