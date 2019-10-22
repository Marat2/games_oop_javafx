package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        /*throw new IllegalStateException(
                String.format("Could not way by diagonal from %s to %s", source, dest)
        );*/
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)
            );
        }
        int size = Math.abs(source.y-dest.y);
        Cell[] steps = new Cell[size];
        int deltaX = Integer.compare(source.x,dest.x)*(-1);
        int deltaY = Integer.compare(source.y,dest.y)*(-1);
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(source.x+index*deltaX+deltaX,source.y+index*deltaY+deltaY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        //TODO check diagonal
        int point_one=Math.abs(source.x-dest.x);
        int point_two=Math.abs(source.y-dest.y);
        if (point_one-point_two==0) {
            return true;
        }
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
