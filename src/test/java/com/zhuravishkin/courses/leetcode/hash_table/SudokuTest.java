package com.zhuravishkin.courses.leetcode.hash_table;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SudokuTest {

    @Test
    void isValidSudoku1() {
        List<List<Character>> board = List.of(
                List.of('3', '.', '.', '2', '.', '1', '.', '.', '.'),
                List.of('7', '4', '.', '.', '.', '.', '.', '1', '9'),
                List.of('.', '2', '.', '.', '6', '.', '5', '.', '.'),
                List.of('.', '3', '.', '7', '4', '.', '.', '.', '1'),
                List.of('.', '.', '8', '.', '.', '.', '9', '.', '.'),
                List.of('6', '.', '.', '.', '9', '2', '.', '5', '.'),
                List.of('.', '.', '2', '.', '.', '.', '.', '4', '.'),
                List.of('1', '5', '.', '.', '.', '.', '.', '9', '.'),
                List.of('.', '.', '.', '9', '.', '.', '.', '.', '2')
        );
        assertTrue(Sudoku.isValidSudoku(board));
    }

    @Test
    void isValidSudoku2() {
        List<List<Character>> board = List.of(
                List.of('1', '.', '.', '.', '.', '.', '.', '.', '.'),
                List.of('.', '.', '.', '.', '.', '.', '.', '.', '.'),
                List.of('.', '2', '1', '.', '.', '.', '.', '.', '.'),
                List.of('.', '.', '.', '.', '.', '.', '.', '.', '.'),
                List.of('.', '.', '.', '.', '.', '.', '.', '.', '.'),
                List.of('.', '.', '.', '.', '.', '.', '.', '.', '.'),
                List.of('.', '.', '.', '.', '.', '.', '.', '.', '.'),
                List.of('.', '.', '.', '.', '.', '.', '.', '.', '.'),
                List.of('.', '.', '.', '.', '.', '.', '.', '.', '.')
        );
        assertFalse(Sudoku.isValidSudoku(board));
    }
}