package com.cundy.workdesign.design.builder.entity;

import com.cundy.workdesign.design.builder.vo.Item;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item)
    {
        items.add(item);
    }

    public float getCost()
    {
        float cost = 0.0f;
        for (Item item :items
             ) {
            cost += item.price();

        }
        return cost;
    }

    public void showItems()
    {
        for (Item item: items
             ) {
            System.out.println(String.format("Item: %s", item.name()));
            System.out.println(String.format("Packing： %s", item.packing().pack()));
            System.out.println(String.format("Price : %s", item.price()));
        }
    }
}

