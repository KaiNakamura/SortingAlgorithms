package com.company;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame
{
    private SortingAlgs panel;

    public Frame()
    {
        //Maximize screen
        JLabel emptyLabel = new JLabel("");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        emptyLabel.setPreferredSize(new Dimension(screenSize.width, screenSize.height));
        getContentPane().add(emptyLabel, BorderLayout.CENTER);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        //No decoration (That bar thingy)
        setUndecorated(false);

        //More setup stuff
        setTitle("Sorting Algorithms");
        setBackground(Color.black);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new SortingAlgs(this);
        add(panel);
        pack();

        //Show the panel
        setVisible(true);

        getPanel().start();
    }

    public SortingAlgs getPanel()
    {
        return panel;
    }


}
