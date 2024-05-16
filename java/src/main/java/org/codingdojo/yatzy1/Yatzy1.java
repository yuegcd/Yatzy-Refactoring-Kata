package org.codingdojo.yatzy1;

public class Yatzy1 {

    protected int[] dice;
    public Yatzy1() {}
    public Yatzy1(int d1, int d2, int d3, int d4, int d5)
    {
        this();
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;
    }

    public int chance()
    {
        int total = 0;
        for (int i : dice) {
            total += i;
        }
        return total;
    }

    public int yatzy()
    {
        int[] counts = new int[6];
        for (int die : dice)
            counts[die-1]++;
        for (int i = 0; i != 6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
    }

    public int ones() {
        int sum;
        sum = 0;
        for (int at = 0; at != 5; at++) {
            if (dice[at] == 1) {
                sum += 1;
            }
        }
        return sum;
    }

    public int twos(){
        int sum;
        sum = 0;
        for (int at = 0; at != 5; at++) {
            if (dice[at] == 2) {
                sum += 2;
            }
        }
        return sum;
    }

    public int threes() {
        int sum;
        sum = 0;
        for (int at = 0; at != 5; at++) {
            if (dice[at] == 3) {
                sum += 3;
            }
        }
        return sum;
    }

    public int fours()
    {
        int sum;    
        sum = 0;
        for (int at = 0; at != 5; at++) {
            if (dice[at] == 4) {
                sum += 4;
            }
        }
        return sum;
    }

    public int fives()
    {
        int s = 0;
        int i;
        for (i = 0; i < dice.length; i++) 
            if (dice[i] == 5)
                s = s + 5;
        return s;
    }

    public int sixes()
    {
        int sum = 0;
        for (int at = 0; at < dice.length; at++) 
            if (dice[at] == 6)
                sum = sum + 6;
        return sum;
    }

    public int onePair()
    {
        int[] counts = counts();
        int at;
        for (at = 0; at != 6; at++)
            if (counts[6-at-1] >= 2)
                return (6-at)*2;
        return 0;
    }

    public int twoPairs()
    {
        int[] counts = counts();
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6-i-1] >= 2) {
                n++;
                score += (6-i);
            }        
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public int threeOfAKind()
    {
        int[] counts = counts();
        for (int i = 0; i < 6; i++)
            if (counts[i] >= 3)
                return (i+1) * 3;
        return 0;
    }

    public int fourOfAKind()
    {
        int[] counts = counts();
        for (int i = 0; i < 6; i++)
            if (counts[i] >= 4)
                return (i+1) * 4;
        return 0;
    }


    public int smallStraight()
    {
        int[] counts = counts();
        if (counts[0] == 1 &&
            counts[1] == 1 &&
            counts[2] == 1 &&
            counts[3] == 1 &&
            counts[4] == 1)
            return 15;
        return 0;
    }

    public int largeStraight()
    {
        int[] counts = counts();
        if (counts[1] == 1 &&
            counts[2] == 1 &&
            counts[3] == 1 &&
            counts[4] == 1
            && counts[5] == 1)
            return 20;
        return 0;
    }

    public int fullHouse()
    {
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;

        int[] counts = counts();

        for (i = 0; i != 6; i += 1)
            if (counts[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (counts[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }

    private int[] counts() {
        int[] counts = new int[6];
        for(int die: dice) {
            counts[die-1]++;
        }
        return counts;
    }
}



