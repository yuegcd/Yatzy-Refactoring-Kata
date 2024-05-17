package org.codingdojo.yatzy1;

import java.util.Collections;
import java.util.List;

public class Yatzy1 {

    private final Roll roll;

    public Yatzy1(int d1, int d2, int d3, int d4, int d5) {
        roll = new Roll(List.of(d1, d2, d3, d4, d5));
    }

    public int chance() {
        return roll.sumAll();
    }

    public int yatzy() {
        List<Integer> dieCountBy5 = roll.filterByCount(count -> count == 5);
        boolean isYatzy = !dieCountBy5.isEmpty();
        if (isYatzy) return 50;
        return 0;
    }

    public int ones() {
        return roll.filterByValue(1).sum();
    }

    public int twos() {
        return roll.filterByValue(2).sum();
    }

    public int threes() {
        return roll.filterByValue(3).sum();
    }

    public int fours() {
        return roll.filterByValue(4).sum();
    }

    public int fives() {
        return roll.filterByValue(5).sum();
    }

    public int sixes() {
        return roll.filterByValue(6).sum();
    }

    public int onePair() {
        List<Integer> dice = roll.filterByCount(count -> count >= 2);
        if(dice.isEmpty()) return 0;
        return Collections.max(dice) * 2;
    }

    public int twoPairs() {
        List<Integer> dice = roll.filterByCount(count -> count >= 2);
        if(dice.size() == 2) return dice.stream().mapToInt(Integer::intValue).sum() * 2;
        return 0;
    }

    public int threeOfAKind() {
        List<Integer> dice = roll.filterByCount(count -> count >= 3);
        if(!dice.isEmpty()) return dice.get(0) * 3;
        return 0;
    }

    public int fourOfAKind() {
        List<Integer> dice = roll.filterByCount(count -> count >= 4);
        if(!dice.isEmpty()) return dice.get(0) * 4;
        return 0;
    }

    public int smallStraight() {
        Roll smallStraight = new Roll(List.of(1, 2, 3, 4, 5));
        boolean isSmallStraight = smallStraight.equals(roll);
        if (isSmallStraight) return 15;
        return 0;
    }

    public int largeStraight() {
        Roll largeStraight = new Roll(List.of(2, 3, 4, 5, 6));
        boolean isLargeStraight = largeStraight.equals(roll);
        if (isLargeStraight) return 20;
        return 0;
    }

    public int fullHouse() {
        boolean isFullHouse = threeOfAKind() != 0 && onePair() != 0;
        if (isFullHouse) return roll.sumAll();
        return 0;
    }
}



