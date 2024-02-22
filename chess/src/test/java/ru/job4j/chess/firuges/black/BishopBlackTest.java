package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.assertj.core.api.Assertions.*;

class BishopBlackTest {
    @Test
    public void whenBishopBlackPositionA1() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        Cell expected = Cell.A1;
        Cell result = bishopBlack.position();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenBishopBlackCopyToB4() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        Cell expected = Cell.B4;
        Cell result = bishopBlack.copy(Cell.B4).position();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenBishopBlackWayFromC1ToG5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] result = bishopBlack.way(Cell.G5);
        assertThat(result).containsExactly(expected);
    }

    @Test
    public void whenImpossibleMoveException() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    bishopBlack.way(Cell.A4);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not way by diagonal from A1 to A4");
    }
}