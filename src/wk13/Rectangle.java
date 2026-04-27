package wk13;

import javafx.geometry.Dimension2D;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {
    protected Dimension2D dimensions;
    public Rectangle(int x, int y, Color color, int width, int height) {
        super(x, y, color);
        this.dimensions = new Dimension2D(width, height);
    }

    public Rectangle(Rectangle rectangle) {
        super(rectangle);
        this.dimensions = new Dimension2D(rectangle.dimensions.getWidth(),
                rectangle.dimensions.getHeight());
    }

    @Override
    public String toString() {
        String string = super.toString();
        return "[" + dimensions.getWidth() + " x "
                + dimensions.getHeight() + " Rectangle"
                + string.substring("[Shape".length());
    }

    public void setDimensions(int width, int height) {
        this.dimensions = new Dimension2D(width, height);
    }

    @Override
    public Rectangle clone() {
        Rectangle clone = (Rectangle) super.clone();
        clone.dimensions = new Dimension2D(this.dimensions.getWidth(),
                this.dimensions.getHeight());
        return clone;
    }
}
