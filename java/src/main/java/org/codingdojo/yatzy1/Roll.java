package org.codingdojo.yatzy1;

import java.util.*;
import java.util.function.IntPredicate;
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

    public List<Integer> filterByCount(IntPredicate countPredicate) {
        var counts = counts();
        var result = new ArrayList<Integer>();
        for (int i = 0; i < counts.length; i++) {
            int dieValue = i + 1;
            if(countPredicate.test(counts[i])) result.add(dieValue);
        }
        return result;
    }

    /*
    In terms of complexity, both map and array are equivalent,
    with O(n) time complexity and O(1) space complexity for the additional structures they use.
    However, the array-based approach (int[]) is likely to be more efficient in practice for several reasons:
        - Performance:
          Array access and updates are generally faster than HashMap operations
          because arrays have lower overhead and better cache locality.
        - Simplicity:
          The array approach is simpler and more straightforward,
          avoiding the need for boxing/unboxing of integers.
    Therefore, while both methods are efficient, the array-based method is typically preferable for
    counting fixed-range, small-sized elements like dice rolls.
    */
    private int[] counts() {
        int[] counts = new int[6];
        for (int die : dice) {
            counts[die - 1]++;
        }
        return counts;
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
