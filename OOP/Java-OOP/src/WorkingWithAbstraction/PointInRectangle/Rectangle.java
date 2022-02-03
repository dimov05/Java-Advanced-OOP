package WorkingWithAbstraction.PointInRectangle;

public class Rectangle {
    Point bottom;
    Point top;

    public Rectangle(Point bottom, Point top) {
        this.bottom = bottom;
        this.top = top;
    }

    public boolean contains(Point point) {
        return point.getX() >= this.bottom.getX() && point.getX() <= this.top.getX()
                && point.getY() >= this.bottom.getY() && point.getY() <= this.top.getY();
    }
}
