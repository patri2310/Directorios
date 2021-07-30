package com.company;

import com.company.tree.Dir;
import com.company.tree.TreeFactory;


public interface Command {
    Dir TREE_FACTORY = new TreeFactory().factory();
    void execute(Dir actualDir);

    static void printString(String text) {
        System.out.print(text + "\n");
    }
}
