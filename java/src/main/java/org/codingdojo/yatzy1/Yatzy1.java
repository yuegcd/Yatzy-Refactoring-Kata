package org.codingdojo.yatzy1;

import java.util.*;

public class Yatzy1 {

    private final Roll roll;

    public Yatzy1(int d1, int d2, int d3, int d4, int d5) {
        roll = new Roll(List.of(d1, d2, d3, d4, d5));
    }

    public int chance() {
        return roll.sumAll();
    }

    public int yatzy() {
        boolean isYatzy = roll.counts().containsValue(5);
        if (isYatzy) return 50;
        return 0;
    }

    public int ones() {
        return roll.numbers(1);
    }

    public int twos() {
        return roll.numbers(2);
    }

    public int threes() {
        return roll.numbers(3);
    }

    public int fours() {
        return roll.numbers(4);
    }

    public int fives() {
        return roll.numbers(5);
    }

    public int sixes() {
        return roll.numbers(6);
    }

    public int onePair() {
        Set<Integer> onePairDice = roll.diceOfAKind(2);
        Optional<Integer> largestPair = onePairDice.stream().max(Integer::compareTo);
        return largestPair.map(dieValue -> dieValue * 2).orElse(0);
    }

    public int twoPairs() {
        Set<Integer> onePairDice = roll.diceOfAKind(2);
        boolean isTwoParis = onePairDice.size() == 2;
        if (isTwoParis) return sumOf(onePairDice, 2);
        return 0;
    }

    public int threeOfAKind() {
        Set<Integer> threeOfAKindDice = roll.diceOfAKind(3);
        if (threeOfAKindDice.isEmpty()) return 0;
        return sumOf(threeOfAKindDice, 3);
    }

    public int fourOfAKind() {
        Set<Integer> fourOfAKindDice = roll.diceOfAKind(4);
        if (fourOfAKindDice.isEmpty()) return 0;
        return sumOf(fourOfAKindDice, 4);
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

    private int sumOf(Set<Integer> diceByNumber, int numberOfDice) {
        return diceByNumber.stream().mapToInt(Integer::intValue).sum() * numberOfDice;
    }
}



