package com.company.tree;

import lombok.val;

import java.util.Collections;

import static java.util.Arrays.asList;

public class TreeFactory {

    public Dir factory() {

        val download = Dir.builder().name("downloads").files(asList(
                FileMule.builder().name("download1").size(1).build(),
                FileMule.builder().name("download2").size(2).build(),
                FileMule.builder().name("download3").size(3).build(),
                FileMule.builder().name("download4").size(4).build(),
                FileMule.builder().name("download5").size(5).build())).build();

        val images = Dir.builder().name("images").files(asList(
                FileMule.builder().name("image-1").size(1).build(),
                FileMule.builder().name("image-2").size(2).build(),
                FileMule.builder().name("image-3").size(3).build(),
                FileMule.builder().name("image-4").size(4).build(),
                FileMule.builder().name("image-5").size(5).build())).build();

        val patricia = Dir.builder().name("patricia").dirs(asList(download, images)).build();

        val despegar = Dir.builder().name("despegar").files(Collections.singletonList(FileMule.builder().name("sensitive.conf").size(100).build())).build();

        return Dir.builder().name("/").files(asList(
                FileMule.builder().name("file-1").size(1).build(),
                FileMule.builder().name("file-2").size(1).build(),
                FileMule.builder().name("file-3").size(1).build(),
                FileMule.builder().name("file-4").size(1).build()))
                .dirs(asList(patricia, despegar))
                .build();
    }

}
