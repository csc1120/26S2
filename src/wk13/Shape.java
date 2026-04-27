package wk13;

import javafx.scene.paint.Color;
import java.util.Objects;

public class Shape implements Cloneable {
    public static void main(String[] args) {
        Shape s1 = null;
        if (Math.random() < 0.5) {
            s1 = new Shape(0, 0, Color.GREEN);
        } else {
            s1 = new Rectangle(5, 5, Color.PINK, 5, 5);
        }
        // How to make a deep copy of s1?
    }

    private final static class Point implements Cloneable{
        private int x;
        private int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            boolean areEqual = false;
            if (o != null && getClass() == o.getClass()) {
                Point point = (Point) o;
                areEqual = x == point.x && y == point.y;
            }
            return areEqual;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }

        @Override
        public Point clone() {
            return new Point(this.x, this.y);
        }
    }

    private Color color;
    private Point center;

    public Shape(Color color) {
        this(0, 0, color);
    }

    public Shape(int x, int y, Color color) {
        this(new Point(x, y), color);
    }

    public Shape(Point center, Color color) {
        this.center = center;
        this.color = color;
    }

    public Shape(Shape shape) {
        this(new Point(shape.center.getX(), shape.center.getY()),
                new Color(shape.color.getRed(),
                        shape.color.getGreen(),
                        shape.color.getBlue(),
                        shape.color.getOpacity()));
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setCenter(int x, int y) {
        center.setX(x);
        center.setY(y);
    }

    @Override
    public String toString() {
        return "[Shape centered at " + center + " with color " + color + "]";
    }

    @Override
    public Shape clone() {
        Shape clone = null;
        try {
            clone = (Shape) super.clone();
            clone.center = (Point) center.clone();
            clone.color = new Color(color.getRed(),
                    color.getGreen(), color.getBlue(),
                     color.getOpacity());
        } catch (CloneNotSupportedException e) {
            // Should not happen
        }
        return clone;
    }
}
