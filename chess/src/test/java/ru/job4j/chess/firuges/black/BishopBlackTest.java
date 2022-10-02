package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BishopBlackTest {

    @Test
    void checkStartPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        Cell actual = bishopBlack.position();
        Cell expected = Cell.A1;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void checkFinalPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        Figure actual = bishopBlack.copy(Cell.B2);
        Cell expected = Cell.B2;
        assertThat(actual.position()).isEqualTo(expected);
    }

    @Test
    void whenIsDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Boolean result = bishopBlack.isDiagonal(bishopBlack.position(), Cell.G5);
        assertTrue(result);
    }

    @Test
    void whenIsDiagonal1() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Boolean result = bishopBlack.isDiagonal(bishopBlack.position(), Cell.A1);
        assertTrue(result);
    }

    @Test
    void whenNotDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D8);
        Boolean result = bishopBlack.isDiagonal(bishopBlack.position(), Cell.E8);
        assertFalse(result);
    }

    @Test
    void wayC1toG5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] actualWay = bishopBlack.way(Cell.G5);
        Cell[] expectedWay = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertTrue(Arrays.equals(expectedWay, actualWay));
    }

    @Test
    void wayA8toD5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A8);
        Cell[] actualWay = bishopBlack.way(Cell.D5);
        Cell[] expectedWay = {Cell.B7, Cell.C6, Cell.D5};
        assertTrue(Arrays.equals(expectedWay, actualWay));
    }
}