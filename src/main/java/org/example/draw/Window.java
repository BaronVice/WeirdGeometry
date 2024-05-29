package org.example.draw;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;


public class Window {
    private JFrame mainFrame;
    private JPanel panel;
    private Drawing drawing;
    private JSpinner spinner, spinner1;
    private JLabel label, label1, label2;

    public Window(){
        init();
    }

    private void init(){
        mainFrame = new JFrame();
        panel = new JPanel();
        mainFrame.setMinimumSize(new Dimension(600, 600));

        drawing = new Drawing();
        drawing.setBounds(new Rectangle(100, 100, 100, 100));

        label = new JLabel("Радиус ");
        label1 = new JLabel("  Масштаб 1:");
        label2 = new JLabel(String.format("  S = %.4f", Drawing.findS(100)));

        SpinnerModel model = new SpinnerNumberModel(100, 0, 1000000, 1);
        spinner = new JSpinner(model);
        SpinnerModel model1 = new SpinnerNumberModel(1, 1, 10000, 1);
        spinner1 = new JSpinner(model1);

        panel.add(label);
        panel.add(spinner);
        panel.add(label1);
        panel.add(spinner1);
        panel.add(label2);

        spinner.addChangeListener(
                e -> {
                    drawing.setRealR((int) spinner.getValue(), label2); drawing.setR(mainFrame, spinner); drawing.paint();
                }
        );
        spinner1.addChangeListener(
                e -> {
                    drawing.setScale((int) spinner1.getValue()); drawing.setR(mainFrame, spinner); drawing.paint();
                }
        );
        panel.setBounds(new Rectangle(10, 10, 30, 30));

        mainFrame.add(drawing);
        mainFrame.add(panel);

        mainFrame.setSize(500, 500);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        mainFrame.addComponentListener(new ComponentAdapter()
        {
            public void componentResized(ComponentEvent evt) {
                drawing.setR(mainFrame, spinner);
            }
        });
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public Drawing getDrawing() {
        return drawing;
    }

    public void setDrawing(Drawing drawing) {
        this.drawing = drawing;
    }

    public JSpinner getSpinner() {
        return spinner;
    }

    public void setSpinner(JSpinner spinner) {
        this.spinner = spinner;
    }

    public JSpinner getSpinner1() {
        return spinner1;
    }

    public void setSpinner1(JSpinner spinner1) {
        this.spinner1 = spinner1;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JLabel getLabel1() {
        return label1;
    }

    public void setLabel1(JLabel label1) {
        this.label1 = label1;
    }

    public JLabel getLabel2() {
        return label2;
    }

    public void setLabel2(JLabel label2) {
        this.label2 = label2;
    }
}
