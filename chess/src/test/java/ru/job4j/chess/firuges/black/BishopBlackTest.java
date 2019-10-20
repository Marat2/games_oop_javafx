package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import org.junit.Assert;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    private Logic logic =new Logic();

    @Test
    public void PositionTest(){
        BishopBlack figure = new BishopBlack(Cell.C8);
        Cell expected=figure.position();
        assertEquals(expected,Cell.C8);
    }
    @Test
    public void CopyTest(){
        BishopBlack figure = new BishopBlack(Cell.C8);
        Figure newposition=figure.copy(Cell.D7);
        assertEquals(newposition.position(),Cell.D7);
    }
    @Test
    public void WayTest(){
        BishopBlack figure = new BishopBlack(Cell.C1);
        Cell[] way=figure.way(Cell.C1,Cell.G5);
        Cell[] steps = {Cell.D2,Cell.E3,Cell.F4,Cell.G5};
        Assert.assertArrayEquals( steps, way );
    }
    @Test
    public void ToRightTop(){
        //C1->E3
        logic.add(new BishopBlack(Cell.C1));
        boolean result=logic.move(Cell.C1,Cell.E3);
        boolean expect=true;
        assertThat(result,is(true));
    }
    @Test
    public void ToLeftDown(){
        //E3->C1
        logic.add(new BishopBlack(Cell.E3));
        boolean result=logic.move(Cell.E3,Cell.C1);
        boolean expect=true;
        assertThat(result,is(true));
    }
    @Test
    public void ToLeftTop(){
        //C1->A3
        logic.add(new BishopBlack(Cell.C1));
        boolean result=logic.move(Cell.C1,Cell.A3);
        boolean expect=true;
        assertThat(result,is(true));
    }
    @Test
    public void ToRightDown(){
        //A3->C1
        logic.add(new BishopBlack(Cell.A3));
        boolean result=logic.move(Cell.A3,Cell.C1);
        boolean expect=true;
        assertThat(result,is(true));
    }
}
