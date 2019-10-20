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
        int size = ((source.y-dest.y)>0)?(source.y-dest.y):(source.y-dest.y)*(-1);
        Cell[] steps = new Cell[size];
        int deltaX = ((source.x-dest.x)>0)?-1:1;
        int deltaY = ((source.y-dest.y)>0)?-1:1;
        for (int index = 0; index < size; index++) {
            steps[index] =(deltaX==1 && deltaY==1) ? Cell.values()[Cell.valueOf(source.toString()).ordinal()+9*(index+1)]:((deltaX==-1 && deltaY==-1)?Cell.values()[Cell.valueOf(source.toString()).ordinal()-9*(index+1)]:((deltaX==-1 && deltaY==1)?Cell.values()[Cell.valueOf(source.toString()).ordinal()-7*(index+1)]:Cell.values()[Cell.valueOf(source.toString()).ordinal()+7*(index+1)]));
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        //TODO check diagonal
        int point_one=((source.x-dest.x)<0)?(source.x-dest.x)*(-1):(source.x-dest.x);
        int point_two=((source.y-dest.y)<0)?(source.y-dest.y)*(-1):(source.y-dest.y);
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
