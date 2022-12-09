package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {
    @Test
    public void whenPositionThisC1ThenPositionEqualC1() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell position = bishopBlack.position();
        Cell expected = Cell.C1;
        assertThat(position).isEqualTo(expected);
    }

    @Test
    public void whenCopyBishopBlackToG5ThenCopyEqualG5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Figure copy = bishopBlack.copy(Cell.G5);
        Cell newPosition = copy.position();
        Cell expected = Cell.G5;
        assertThat(newPosition).isEqualTo(expected);
    }

    @Test
    public void whenBishopBlackToC1ThenWayG5ArrayCellEqualD2E3F4G5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] way = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(way).isEqualTo(expected);
    }

    @Test
    public void whenBishopBlackToD4ThenWayA1ArrayCellEqualC3B2A1() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell[] way = bishopBlack.way(Cell.A1);
        Cell[] expected = {Cell.C3, Cell.B2, Cell.A1};
        assertThat(way).isEqualTo(expected);
    }

    @Test
    public void whenBishopBlackToD4ThenWayA7ArrayCellEqualC5B6A7() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell[] way = bishopBlack.way(Cell.A7);
        Cell[] expected = {Cell.C5, Cell.B6, Cell.A7};
        assertThat(way).isEqualTo(expected);
    }

    @Test
    public void whenBishopBlackToD4ThenWayG1ArrayCellEqualE3F2G1() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell[] way = bishopBlack.way(Cell.G1);
        Cell[] expected = {Cell.E3, Cell.F2, Cell.G1};
        assertThat(way).isEqualTo(expected);
    }

    @Test
    public void whenExceptionDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    bishopBlack.way(Cell.A6);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from D4 to A6");
    }
}