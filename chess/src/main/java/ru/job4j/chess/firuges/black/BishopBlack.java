package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(position().getX() - dest.getX()) + 1;
        Cell[] steps = new Cell[size];
        int deltaX = position().getX() > dest.getX() ? -1 : 1;
        int deltaY = position().getY() > dest.getY() ? -1 : 1;
        int x = position.getX();
        int y = position().getY();
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(x, y);
            x += deltaX;
            y += deltaY;
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        if (source.getX() == dest.getX()
                && source.getY() == dest.getY()) {
            return false;
        }
        if (Math.abs(dest.getX() - source.getX())
                == Math.abs(dest.getY() - source.getY())) {
            return true;
        }
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}