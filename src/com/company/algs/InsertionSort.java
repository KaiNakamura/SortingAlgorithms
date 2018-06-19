package com.company.algs;

import com.company.Frame;
import com.company.SortingAlgs;
import com.company.util.Algorithm;
import com.company.util.Item;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.awt.*;
import java.util.ArrayList;

public class InsertionSort extends Algorithm
{
    private int lowestValue;
    private int lowestValueIndex;
    private int currentIndex = 0;
    private int i = -1;

    public InsertionSort(Frame frame, ArrayList<Item> list)
    {
        super(frame, list);

        lowestValue = list.size();
    }

    @Override
    public void update()
    {
        if(currentIndex != list.size())
        {
            i++;
            if (i > list.size() - 1)
            {
                i = currentIndex;
            }

            list.get(i).setColor(Color.red);

            int currentValue = list.get(i).getValue();

            if (currentValue < lowestValue)
            {
                lowestValue = currentValue;
                lowestValueIndex = i;
            }

            list.get(currentIndex).setColor(Color.green);

            if (i == list.size() - 1)
            {
                if(lowestValue < list.get(currentIndex).getValue())
                {
                    swap(currentIndex, lowestValueIndex);
                }
                lowestValue = list.size();
                currentIndex++;
            }
        }
        else
        {
            setSorted(true);
        }
    }

    @Override
    public void reset()
    {
        i = -1;
        currentIndex = 0;
        setSorted(false);
    }
}
