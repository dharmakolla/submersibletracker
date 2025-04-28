package com.example.submersibletracker;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

class SubmersibletrackerApplicationTests {

    @Mock
    private SubmersibletrackerController controller;

    @Mock
    private Submersible submersible;

    @BeforeEach
    public void setUp() {
        submersible = new Submersible("Submersible", 0, 0);
        controller = new SubmersibletrackerController(submersible);

    }

    @AfterEach
    public void tearDown() {
        controller = null;
    }

    @Test
    public void testMoveLeft() {
        submersible = new Submersible("Submersible", 0, 0);
        ResponseEntity<Submersible> response = controller.moveLeft(Arrays.asList(1, 0));
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(-1, response.getBody().getX());
        assertEquals(0, response.getBody().getY());
    }

    @Test
    public void testMoveRight() {
        submersible = new Submersible("Submersible", 0, 0);
        ResponseEntity<Submersible> response = controller.moveRight(Arrays.asList(1, 0));
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(1, response.getBody().getX());
        assertEquals(0, response.getBody().getY());
    }

    @Test
    public void testMoveUp() {
        submersible = new Submersible("Submersible", 0, 0);
        ResponseEntity<Submersible> response = controller.moveUp(Arrays.asList(1));
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(0, response.getBody().getX());
        assertEquals(1, response.getBody().getY());
    }

    @Test
    public void testMoveDown() {
        submersible = new Submersible("Submersible", 0, 0);
        ResponseEntity<Submersible> response = controller.moveDown(Arrays.asList(1));
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(0, response.getBody().getX());
        assertEquals(-1, response.getBody().getY());
    }
}
