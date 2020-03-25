package com.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {

        for(int i = 0 ; i < 10  ; i ++){
            System.out.println("the i is " + i);
        }
        assertEquals(4, 2 + 2);
    }
}