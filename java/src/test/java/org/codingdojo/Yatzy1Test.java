package org.codingdojo;

import org.codingdojo.yatzy1.Yatzy1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Yatzy1Test {

    @Test
    void should_score_sum_of_all_dice_when_is_chance_category() {
        assertEquals(15, new Yatzy1(2,3,4,5,1).chance());
        assertEquals(16, new Yatzy1(3,3,4,5,1).chance());
    }

    @Test
    void when_is_yatzy_should_score_50_if_all_dies_have_same_number_category() {
        assertEquals(50, new Yatzy1(4,4,4,4,4).yatzy());
        assertEquals(50, new Yatzy1(6,6,6,6,6).yatzy());
        assertEquals(0, new Yatzy1(6,6,6,6,3).yatzy());
    }

    @Test
    void when_is_ones_should_score_sum_of_dice_reads_one_category() {
        assertEquals(1, new Yatzy1(1,2,3,4,5).ones());
        assertEquals(2, new Yatzy1(1,2,1,4,5).ones());
        assertEquals(0, new Yatzy1(6,2,2,4,5).ones());
        assertEquals(4, new Yatzy1(1,2,1,1,1).ones());
    }

    @Test
    void when_is_twos_should_score_sum_of_dice_reads_two_category() {
        assertEquals(4, new Yatzy1(1,2,3,2,6).twos());
        assertEquals(10, new Yatzy1(2,2,2,2,2).twos());
    }

    @Test
    void when_is_threes_should_score_sum_of_dice_reads_three_category() {
        assertEquals(6, new Yatzy1(1,2,3,2,3).threes());
        assertEquals(12, new Yatzy1(2,3,3,3,3).threes());
    }

    @Test
    void when_is_fours_should_score_sum_of_dice_reads_four_category() {
        assertEquals(12, new Yatzy1(4,4,4,5,5).fours());
        assertEquals(8, new Yatzy1(4,4,5,5,5).fours());
        assertEquals(4, new Yatzy1(4,5,5,5,5).fours());
    }

    @Test
    void when_is_fives_should_score_sum_of_dice_reads_five_category() {
        assertEquals(10, new Yatzy1(4,4,4,5,5).fives());
        assertEquals(15, new Yatzy1(4,4,5,5,5).fives());
        assertEquals(20, new Yatzy1(4,5,5,5,5).fives());
    }

    @Test
    void when_is_sixes_should_score_sum_of_dice_reads_six_category() {
        assertEquals(0, new Yatzy1(4,4,4,5,5).sixes());
        assertEquals(6, new Yatzy1(4,4,6,5,5).sixes());
        assertEquals(18, new Yatzy1(6,5,6,6,5).sixes());
    }

    @Test
    void when_is_one_pair_should_score_sum_of_two_highest_matching_dice_category() {
        assertEquals(6, new Yatzy1(3,4,3,5,6).onePair());
        assertEquals(10, new Yatzy1(5,3,3,3,5).onePair());
        assertEquals(12, new Yatzy1(5,3,6,6,5).onePair());
    }

    @Test
    void when_is_two_pairs_should_score_sum_of_two_pairs_of_dice_with_the_same_number_category() {
        assertEquals(16, new Yatzy1(3,3,5,4,5).twoPairs());
        assertEquals(16, new Yatzy1(3,3,5,5,5).twoPairs());
    }

    @Test
    void when_is_three_of_a_kind_should_score_sum_of_three_dice_with_the_same_number()
    {
        assertEquals(9, new Yatzy1(3,3,3,4,5).threeOfAKind());
        assertEquals(15, new Yatzy1(5,3,5,4,5).threeOfAKind());
        assertEquals(9, new Yatzy1(3,3,3,3,5).threeOfAKind());
    }

    @Test
    void when_is_four_of_a_kind_should_score_sum_of_four_dice_with_the_same_number_category() {
        assertEquals(12, new Yatzy1(3,3,3,3,5).fourOfAKind());
        assertEquals(20, new Yatzy1(5,5,5,4,5).fourOfAKind());
        assertEquals(12, new Yatzy1(3,3,3,3,3).fourOfAKind());
    }

    @Test
    void when_is_small_straight_should_score_sum_of_all_dice_if_on_small_straight_category() {
        assertEquals(15, new Yatzy1(1,2,3,4,5).smallStraight());
        assertEquals(15, new Yatzy1(2,3,4,5,1).smallStraight());
        assertEquals(0, new Yatzy1(1,2,2,4,5).smallStraight());
    }

    @Test
    void when_is_large_straight_should_score_sum_of_all_dice_if_on_large_straight_category() {
        assertEquals(20, new Yatzy1(6,2,3,4,5).largeStraight());
        assertEquals(20, new Yatzy1(2,3,4,5,6).largeStraight());
        assertEquals(0, new Yatzy1(1,2,2,4,5).largeStraight());
    }

    @Test
    void when_is_fullHouse_should_score_sum_of_all_dice_if_two_of_a_kind_and_three_of_a_kind_category() {
        assertEquals(18, new Yatzy1(6,2,2,2,6).fullHouse());
        assertEquals(0, new Yatzy1(2,3,4,5,6).fullHouse());
    }
}
