package EncapsulationExcercise.ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double calculateSurfaceArea() {
        return    this.getHeight()*this.getLength()*2
                + this.getLength()*this.getWidth()*2
                + this.getWidth()*this.getHeight()*2;
    }

    public double calculateLateralSurfaceArea(){
        return    this.getLength()*getHeight()*2
                + this.getWidth()*getHeight()*2;
    }

    public double calculateVolume(){
        return  this.getHeight()*this.getWidth()*this.getLength();
    }
}
