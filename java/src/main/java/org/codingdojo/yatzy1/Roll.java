package org.codingdojo.yatzy1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public record Roll(List<Integer> dice) {
    public int sumAll() {
        return dice.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

    public IntStream filterByValue(int dieValue) {
        return dice.stream()
            .filter(die -> die.equals(dieValue))
            .mapToInt(Integer::intValue);
    }

    public Map<Integer, Integer> counts() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= 6; i++) {
            map.put(i, 0);
        }
        for (int die : dice) {
            map.put(die, map.get(die) + 1);
        }
        return map;
    }

    public Set<Integer> diceOfAKind(int numberOfDiceWithSameValue) {
        return counts().entrySet().stream()
            .filter(entry -> entry.getValue() >= numberOfDiceWithSameValue)
            .map(Map.Entry::getKey)
            .collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roll roll = (Roll) o;
        // Sort both lists and then compare
        List<Integer> sortedThis = new ArrayList<>(this.dice);
        List<Integer> sortedOther = new ArrayList<>(roll.dice);
        Collections.sort(sortedThis);
        Collections.sort(sortedOther);
        return Objects.equals(sortedThis, sortedOther);
    }

    @Override
    public int hashCode() {
        // Sort the list before hashing
        List<Integer> sortedDice = new ArrayList<>(dice);
        Collections.sort(sortedDice);
        return Objects.hashCode(sortedDice);
    }
}
