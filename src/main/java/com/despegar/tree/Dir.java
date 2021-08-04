package com.despegar.tree;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.Collections;
import java.util.List;

@Builder
@Getter
public class Dir implements FileSystem{

    @NonNull
    String name;

    String parent_name;

    @Builder.Default
    List<Dir> dirs = Collections.EMPTY_LIST;

    @Builder.Default
    List<FileMule> files = Collections.EMPTY_LIST;
}
