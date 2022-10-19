package fr.vinbeau;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BillboardMakerTest {

    static Stream<Arguments> getConstraintsArguments() {
/*        5
        20 6 hacker cup
        100 20 hacker cup 2013
        10 20 MUST BE ABLE TO HACK
        55 25 Can you hack
        100 20 Hack your way to the cup*/

        return Stream.of(
                Arguments.arguments(20, 6, "hacker cup"),
                Arguments.arguments(100, 20, "hacker cup 2013"),
                Arguments.arguments(10, 20, "MUST BE ABLE TO HACK"),
                Arguments.arguments(55, 25, "Can you hack"),
                Arguments.arguments(100, 20, "Hack your way to the cup"));
    }

    @ParameterizedTest()
    @MethodSource("getConstraintsArguments")
    public void mustRespectConstraints(int width, int height, String text) {
        System.out.println(BillboardMaker.getTextSize(new MyBillboard(height, width, text)));
    }

    @Test
    public void mustReturnAnInt() {
        assertInstanceOf(Integer.TYPE, BillboardMaker.getTextSize(new MyBillboard(1, 1, "1")));
    }
}
