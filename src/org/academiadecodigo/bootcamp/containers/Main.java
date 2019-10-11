package org.academiadecodigo.bootcamp.containers;

import org.w3c.dom.ls.LSOutput;

public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList();
        Integer data1 = new Integer(1);

        list.add(data1);
        System.out.println(list.indexOf(data1));
        list.remove(data1);
        System.out.println(list.size());
    }

}
