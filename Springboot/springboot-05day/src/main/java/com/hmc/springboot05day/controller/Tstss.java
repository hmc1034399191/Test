package com.hmc.springboot05day.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Tstss {
    public static void main(String[] args) {
        Collection collection=new ArrayList();
        ((ArrayList) collection).add("1");
        Iterator it=collection.iterator();
        while(it.hasNext()){
            String str= (String) it.next();
            System.out.println(str);
        }

    }
}
