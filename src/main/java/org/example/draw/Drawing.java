package org.example.draw;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

import static java.lang.Math.min;
import static java.lang.Math.sqrt;

public class Drawing extends JPanel {
    public static Color warningColor = new Color(255, 152, 152);
    private int r = 100;
    private int realR = 100;
    private int scale = 1;

    public void paint(){
        paint(getGraphics());
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(getBackground());
        g2d.fillRect(0, 20, 3000, 3000);

        g2d.setColor(Color.GRAY);
        drawHexagon(g2d);

        g2d.setColor(Color.red);
        drawDiamond(g2d);
        g2d.setColor(Color.white);
        g2d.fillOval(getWidth()/2-r, getHeight()/2-r, 2*r, 2*r);
        g2d.setColor(Color.blue);
        g2d.drawRect(getWidth()/2-r, getHeight()/2-r, 2*r, 2*r);

        g2d.dispose();
    }

    public void drawDiamond(Graphics2D g2d){
        Diamond diamond = new Diamond(2.84*r, 2.84*r);
        int x = (getWidth() - diamond.getBounds().width) / 2;
        int y = (getHeight()- diamond.getBounds().height) / 2;
        AffineTransform at = AffineTransform.getTranslateInstance(x, y);
        Shape shape = at.createTransformedShape(diamond);
        g2d.draw(shape);
    }

    public void drawHexagon(Graphics2D g2d){
        Hexagon hexagon = new Hexagon(2*r);
        int x = (getWidth() - hexagon.getBounds().width) / 2;
        int y = (getHeight()- hexagon.getBounds().height) / 2;
        AffineTransform at = AffineTransform.getTranslateInstance(x, y);
        Shape shape = at.createTransformedShape(hexagon);
        g2d.fill(shape);
        g2d.draw(shape);
    }

    public int getR() {
        return r;
    }
    public int getRealR(){return realR;}

    public void setR(JFrame r, JSpinner spinner) {
        int v = (min(r.getWidth(), r.getHeight()));
        this.r = min(v/4, (v / 5) * realR / 100 / scale);
        setBounds(new Rectangle(10, 12, r.getWidth()-30, r.getHeight()-30));
        if (this.r >= v/4) spinner.getEditor().getComponent(0).setBackground(warningColor);
        else spinner.getEditor().getComponent(0).setBackground(r.getBackground());
    }

    public void setScale(int value){
        scale = value;
    }

    public void setRealR(int val, JLabel jLabel2){
        realR = val;
        jLabel2.setText(String.format("  S = %.4f", Drawing.findS(val)));
        // set S
    }

    public static double findS(int r){
        double v = 2 * r * sqrt(2) / (2 + sqrt(2));
        return (3 * v * v * sqrt(3)) - 3.14 * r * r;
    }
}
