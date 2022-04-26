package com.example.android2hm1.data.model;

import java.util.ArrayList;

public class BoardClient {
    public static ArrayList<BoardModel> list = new ArrayList<>();

    public static ArrayList<BoardModel> getList() {
        ArrayList<BoardModel> list = new ArrayList<>();
        list.add(new BoardModel("time2.json", "Экономь время", "Дальше"));
        list.add(new BoardModel("task.json", "Достигай целей", "Дальше"));
        list.add(new BoardModel("evolve.json", "Развивайся", "Начинаем"));
        return list;
    }
}
