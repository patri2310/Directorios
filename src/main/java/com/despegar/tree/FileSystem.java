package com.despegar.tree;

public interface FileSystem {

    default String getName(){ return "";}
    default String getParent(){ return "";}
}
