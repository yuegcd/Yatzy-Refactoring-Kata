package org.codingdojo.yatzy1;

import java.util.*;
import java.util.stream.Collectors;

public class Yatzy1 {

    private final List<Integer> dice;
    private final Map<Integer, Integer> dieToCount;

    public Yatzy1(int d1, int d2, int d3, int d4, int d5) {
        dice = List.of(d1, d2, d3, d4, d5);
        dieToCount = counts();
    }

    public int chance() {
        return sumAll();
    }

    public int yatzy() {
        boolean isYatzy = dieToCount.containsValue(5);
        if (isYatzy) return 50;
        return 0;
    }

    public int ones() {
        return numbers(1);
    }

    public int twos() {
        return numbers(2);
    }

    public int threes() {
        return numbers(3);
    }

    public int fours() {
        return numbers(4);
    }

    public int fives() {
        return numbers(5);
    }

    public int sixes() {
        return numbers(6);
    }

    public int onePair() {
        Set<Integer> onePairDice = diceOfAKind(2);
        Optional<Integer> largestPair = onePairDice.stream().max(Integer::compareTo);
        return largestPair.map(dieValue -> dieValue * 2).orElse(0);
    }

    public int twoPairs() {
        Set<Integer> onePairDice = diceOfAKind(2);
        boolean isTwoParis = onePairDice.size() == 2;
        if (isTwoParis) return sumOf(onePairDice, 2);
        return 0;
    }

    public int threeOfAKind() {
        Set<Integer> threeOfAKindDice = diceOfAKind(3);
        if (threeOfAKindDice.isEmpty()) return 0;
        return sumOf(threeOfAKindDice, 3);
    }

    public int fourOfAKind() {
        Set<Integer> fourOfAKindDice = diceOfAKind(4);
        if (fourOfAKindDice.isEmpty()) return 0;
        return sumOf(fourOfAKindDice, 4);
    }


    public int smallStraight() {
        List<Integer> smallStraight = List.of(1, 2, 3, 4, 5);
        boolean isSmallStraight = new HashSet<>(dice).containsAll(smallStraight);
        if (isSmallStraight) return 15;
        return 0;
    }

    public int largeStraight() {
        List<Integer> largeStraight = List.of(2, 3, 4, 5, 6);
        boolean isLargeStraight = new HashSet<>(dice).containsAll(largeStraight);
        if (isLargeStraight) return 20;
        return 0;
    }

    public int fullHouse() {
        boolean isFullHouse = threeOfAKind() != 0 && onePair() != 0;
        if (isFullHouse) return sumAll();
        return 0;
    }

    private int sumAll() {
        return dice.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

    private int sumOf(Set<Integer> diceByNumber, int numberOfDice) {
        return diceByNumber.stream().mapToInt(Integer::intValue).sum() * numberOfDice;
    }

    private Set<Integer> diceOfAKind(int numberOfDiceWithSameValue) {
        return dieToCount.entrySet().stream()
            .filter(entry -> entry.getValue() >= numberOfDiceWithSameValue)
            .map(Map.Entry::getKey)
            .collect(Collectors.toSet());
    }

    private Map<Integer, Integer> counts() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= 6; i++) {
            map.put(i, 0);
        }
        for (int die : dice) {
            map.put(die, map.get(die) + 1);
        }
        return map;
    }

    private int numbers(int n) {
        int sum = 0;
        for (int die : dice) {
            if (die == n) {
                sum = sum + n;
            }
        }
        return sum;
    }
}



