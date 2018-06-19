package com.company.util;

import com.company.Frame;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Algorithm
{
    private Frame frame;
    public ArrayList<Item> list;
    private boolean sorted;

    public Algorithm(Frame frame, ArrayList<Item> list)
    {
        this.frame = frame;
        this.list = list;
    }

    public void setArray(ArrayList<Item> list)
    {
        this.list = list;
    }

    public abstract void update();

    public abstract void reset();

    public void swap(int index1, int index2)
    {
        Collections.swap(list, index1, index2);
    }

    public void resetColors()
    {
        for(int i = 0; i < list.size(); i++)
        {
            list.get(i).setColor(Color.white);
        }
    }

    public void paint(Graphics g)
    {
        int hBuffer = (frame.getWidth() / list.size() / 5);
        int vBuffer = 15;
        frame.setMinimumSize(new Dimension( (list.size() < 500) ? 500 : list.size(), 400));

        double itemWidth = ((((double) frame.getWidth()) / (list.size())) - hBuffer);
        for(int i = 0; i < list.size(); i++)
        {
            double itemHeight = ((((double)frame.getHeight() - frame.getInsets().top - vBuffer) / (double)(list.size())) * (list.get(i).getValue()));
            g.setColor(list.get(i).getColor());
            g.fillRect((int)((itemWidth + hBuffer) * i), (int)((frame.getHeight() - frame.getInsets().top) - itemHeight), (int)itemWidth, (int)itemHeight);
        }
    }

    public void setSorted(boolean value)
    {
        sorted = value;
    }

    public boolean isSorted()
    {
        return sorted;
    }
}
