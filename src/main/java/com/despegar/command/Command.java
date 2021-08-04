package com.despegar.command;

import com.despegar.tree.Dir;

import java.util.Optional;


public interface Command {

    String getPathParameter();
    Dir execute(String actualDir);
    Optional<String> getParameter();
    String getName();
    static void printString(String text) {
        System.out.print(text + "\n");
    }
}
