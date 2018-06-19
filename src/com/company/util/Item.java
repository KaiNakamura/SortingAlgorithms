package com.company.util;

import java.awt.*;

public class Item
{
    private int value;
    private Color color;

    public Item(int value)
    {
        this.value = value;
        this.color = Color.white;
    }

    public int getValue()
    {
        return value;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }
}
