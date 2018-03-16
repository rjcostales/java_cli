package com.rjsc.cli;

import java.util.Enumeration;
import java.util.Random;
import java.util.Vector;

public class Blackjack {

    static Random rand = new Random();

    public static void main(String argv[]) {

        Vector<Integer> dealer = new Vector<>();
        Vector<Integer> player = new Vector<>();

        int which;
        boolean dd;

        System.out.println("running...");

        int wins = 0;
        int loses = 0;
        int pushes = 0;
        int busts = 0;
        int doubles = 0;
        int[] cases = new int[5];

        for (int i = 0; i < 12; i++) {

            // clear dealer
            player.clear();
            dealer.clear();
            dd = false;

            // deal two cards
            deal(player);
            deal(dealer);
            deal(player);
            deal(dealer);

            int show = dealer.firstElement();
            int hold = compute(player);

            if ((hold == 10 && (show != 1 && show != 10)) || hold == 11) {

                deal(player);
                doubles++;
                dd = true;
                which = 0;

            } else if (show == 1) {
                while (compute(player) <= 14)
                    deal(player);
                which = 1;

            } else if (show == 2 || show == 3 || show == 4) {
                while (compute(player) <= 15)
                    deal(player);
                which = 2;

            } else if (show == 5 || show == 6 || show == 7) {
                while (compute(player) <= 16)
                    deal(player);
                which = 2;

            } else if (show == 8 || show == 9) {
                while (compute(player) <= 17)
                    deal(player);
                which = 3;

            } else {
                while (compute(player) <= 14)
                    deal(player);
                which = 4;
            }

            if (compute(player) > 21) {
                busts++;
                loses++;
                if (dd)
                    loses++;
                cases[which]--;
                System.out.println("player bust " + player);
                System.out.println("dealer " + dealer + "\n");
                continue;
            }

            while (compute(dealer) < 18)
                deal(dealer);

            if (compute(dealer) > 21) {
                wins++;
                if (dd)
                    wins++;
                cases[which]++;
                System.out.println("player " + player);
                System.out.println("dealer bust " + dealer + "\n");
                continue;
            }

            int pv = compute(player);
            int dv = compute(dealer);

            System.out.println("player " + pv + ", " + player);
            System.out.println("dealer " + dv + ", " + dealer + "\n");

            // who won
            if (pv > dv) {
                wins++;
                if (dd)
                    wins++;
                cases[which]++;

            } else if (dv > pv) {
                loses++;
                if (dd)
                    loses++;
                cases[which]--;

            } else
                pushes++;

        } // end i

        System.out.println("wins   " + wins);
        System.out.println("loses  " + loses + "    busts   " + busts);
        System.out.println("pushes " + pushes + "    doubles " + doubles);
        System.out.println(wins - loses);

        // for (int i = 0; i < 5; i++)
        // System.out.println(i + "\t" + cases[i]);
        // System.out.println("-------------------------------------------");

    } // end main

    static int compute(Vector<Integer> dealer) {

        boolean ace = false;
        int result = 0;
        Integer val;
        Enumeration<Integer> cards = dealer.elements();

        while (cards.hasMoreElements()) {
            val = cards.nextElement();
            if (val == 1)
                ace = true;
            result += val;
        }
        if (ace)
            if (result == 8 || result == 9 || result == 10 || result == 11)
                result += 10;

        if (result > 21)
            result = 22;
        return result;
    }

    static void deal(Vector<Integer> hand) {

        int card = Math.abs(rand.nextInt()) % 13;

        if (card == 0 || card > 10)
            card = 10;
        hand.addElement(card);
    }
}