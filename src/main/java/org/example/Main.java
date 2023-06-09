package org.example;

import org.example.command.Command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//          create_event user from to
//        create_group_event from to user user1 user2 ...
//        favourable_slot duration user user1 user2 ...
//// fetch_free_slot from to duration user user1 user2 ...
//        fetch_conflicts user day
//
//
//        objects
//        event (from to List<User>)
//        User (id, TreeSet<event>)
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/input1");
        Scanner myObj = new Scanner(file);
        while(myObj.hasNext()) {
            try {
                String str = myObj.nextLine();
                String[] arguments = str.split(" ");
                Command cmd = Command.valueOf(arguments[0]);
                cmd.execute(arguments);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}