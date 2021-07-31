package com.despegar.command;

import com.despegar.tree.Dir;
import com.despegar.tree.TreeFactory;


public interface Command {
    Dir TREE_FACTORY = new TreeFactory().factory();
    void execute(Dir actualDir);
    void execute(Dir actualDir, String parameter);

    static void printString(String text) {
        System.out.print(text + "\n");
    }


}
