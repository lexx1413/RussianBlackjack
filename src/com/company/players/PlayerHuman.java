package com.company.players;

import java.util.Scanner;

public class PlayerHuman extends Player {
    public PlayerHuman(String name) {
        super(name);
    }

    @Override
    public boolean isWillingToTakeCard() {
        Scanner in = new Scanner(System.in);
        System.out.println("  More?");
        String answer = in.next();
        while (!answer.equals("y") && !answer.equals("n")) {
            System.out.println("  Wrong answer. Enter y or n: ");
            answer = in.next();
        }
        return answer.equals("y");
    }
}