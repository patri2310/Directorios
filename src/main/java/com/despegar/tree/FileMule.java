package com.despegar.tree;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
@Getter
public class FileMule implements FileSystem{

    @NonNull
    String name;

    @NonNull
    String parent;

    Integer size;
}
