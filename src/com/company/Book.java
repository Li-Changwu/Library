package com.company;

/**
 * @program: Library
 * @description: 书
 * @author: 李长武
 * @create: 2020-06-05 20:37
 **/
public class Book {
    private int ID;//书编号

    public Book(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "编号" + ID;
    }
}
