package main;

import util.InputUtil;
import util.MenuUtil;

public class Main {
    public static void main(String[] args) {
        int menu = 0;
        while (true) {
            menu = InputUtil.requirenumber("What do you want to do?"
                    + "\n1.Register Student"
                    + "\n2.Show all Student"
                    + "\n3.Find Student"
                    + "\n4.Update Student");
            MenuUtil.menuproces(menu);

        }
    }
}
