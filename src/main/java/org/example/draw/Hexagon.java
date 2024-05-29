package org.example.draw;

import java.awt.geom.Path2D;

public class Hexagon extends Path2D.Double {
    public Hexagon(double s) {
        moveTo(0, s / 3.4);
        lineTo(s / 3.4, 0);
        lineTo(s - s / 3.4, 0);
        lineTo(s, s / 3.4);
        lineTo(s, s - s / 3.4);
        lineTo(s - s / 3.4, s);
        lineTo(s / 3.4, s);
        lineTo(0, s - s / 3.4);
        closePath();
    }
}
