package com.company.tree;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.Collections;
import java.util.List;

@Builder
@Getter
public class Dir {

    @NonNull
    String name;

    @Builder.Default
    List<Dir> dirs = Collections.EMPTY_LIST;

    @Builder.Default
    List<FileMule> files = Collections.EMPTY_LIST;
}
