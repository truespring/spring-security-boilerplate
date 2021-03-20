package com.mini2S.board.util;

public class Paging {
    public static long calculatePageCount(Long totalList, int size){
        return ((totalList - 1) / size) + 1;
    }
}
