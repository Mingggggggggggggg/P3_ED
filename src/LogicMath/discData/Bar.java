package LogicMath.discData;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Bar {

    private double x;
    private double y;
    private double width;
    private double height;
    private Color color;



    public Bar(double x, double y, double width, double height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }


    public void drawBar(Graphics2D g) {
        g.setColor(color);
        g.fill(new Rectangle2D.Double(x, y, width, height));
    }
}
