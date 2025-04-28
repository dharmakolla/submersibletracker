package com.example.submersibletracker;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class SubmersibleTrackerControllerTest {

    @Mock       
    private SubmersibletrackerController controller;

    @BeforeEach
    public void setUp() {
        controller = new SubmersibletrackerController(new Submersible());
    }

    @AfterEach
    public void tearDown() {
        controller = null;
    }

    @Test
    public void testMove() {
        controller.move(Arrays.asList(1, 2));
        assertEquals(1, controller.getPosition().getBody().get(0));
        assertEquals(2, controller.getPosition().getBody().get(1));
    }

    @Test   
    public void testMoveLeft() {
        controller.moveLeft(Arrays.asList(1) );
        assertEquals(-1, controller.getPosition().getBody().get(0));
        assertEquals(0, controller.getPosition().getBody().get(1));
    }

    @Test
    public void testMoveRight() {
        controller.moveRight(Arrays.asList(1));
        assertEquals(1, controller.getPosition().getBody().get(0));
        assertEquals(0, controller.getPosition().getBody().get(1));
    }

    @Test
    public void testMoveUp() {
        controller.moveUp(Arrays.asList(1));
        assertEquals(0, controller.getPosition().getBody().get(0));
        assertEquals(1, controller.getPosition().getBody().get(1));
    }

    @Test
    public void testMoveDown() {
        controller.moveDown(Arrays.asList(1));
        assertEquals(0, controller.getPosition().getBody().get(0));
        assertEquals(-1, controller.getPosition().getBody().get(1));
    }
}