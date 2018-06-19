package com.company;

import com.company.algs.InsertionSort;
import com.company.algs.SelectionSort;
import com.company.util.Algorithm;
import com.company.util.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortingAlgs extends JPanel implements ActionListener, KeyListener
{
    private Frame frame;
    private ArrayList<Algorithm> algorithms = new ArrayList<>();
    private int deltaTime = 1;
    private int pauseTime = 150; /* Time to pause in between algorithms */
    private int timePaused = 0;
    private boolean paused = false;
    private int steps = 0;
    private int currentAlgIndex = 0;

    private int arraySize = 72;

    public SortingAlgs(Frame frame)
    {
        setBackground(Color.black);
        this.frame = frame;
        //Resizing the game before creating the ball ensures that the ball is centered at the start of the game
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);

        algorithms.add(new SelectionSort(frame, newArray(arraySize)));
        algorithms.add(new InsertionSort(frame, newArray(arraySize)));

        addKeyListener(this);
        setFocusable(true);
    }

    private ArrayList<Item> newArray(int size)
    {
        Integer[] integerArr = new Integer[size];

        for(int i = 0; i < size; i++)
        {
            integerArr[i] = i + 1;
        }

        java.util.List<Integer> temp = Arrays.asList(integerArr);
        Collections.shuffle(temp);

        ArrayList<Item> arr = new ArrayList<>();

        for(int i = 0; i < temp.size(); i++)
        {
            arr.add(new Item(temp.get(i)));
        }

        return arr;
    }

    private void update()
    {
        if(!paused)
        {
            algorithms.get(currentAlgIndex).resetColors();
            algorithms.get(currentAlgIndex).update();

            if (!algorithms.get(currentAlgIndex).isSorted())
            {
                steps++;
            }
            else
            {
                paused = true;
            }
        }
        else
        {
            timePaused += deltaTime;
            if(timePaused > pauseTime)
            {
                paused = false;
                timePaused = 0;
                nextAlg();
            }
        }
    }

    public void nextAlg()
    {
        steps = 0;
        currentAlgIndex++;

        if(currentAlgIndex >= algorithms.size())
        {
            currentAlgIndex = 0;
            resetAlgLists();
        }
    }

    public void resetAlgLists()
    {
        for(int i = 0; i < algorithms.size(); i++)
        {
            algorithms.get(i).setArray(newArray(arraySize));
            algorithms.get(i).reset();
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        update();
        repaint();
    }

    //Some KeyListener functions
    public void keyPressed(KeyEvent e)
    {

    }

    public void keyReleased(KeyEvent e)
    {

    }

    public void keyTyped(KeyEvent e){

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        algorithms.get(currentAlgIndex).paint(g);


        g.setColor(Color.white);
        g.drawString(algorithms.get(currentAlgIndex).getClass().getSimpleName() + "    Steps: " + steps + "    Delay: " + deltaTime + "ms", 0, 10);
    }

    public void start(){
        Timer timer = new Timer(deltaTime,this);
        timer.start();
    }
}
