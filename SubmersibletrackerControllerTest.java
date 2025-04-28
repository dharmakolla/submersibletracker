public class SubmersibletrackerControllerTest {

    @Mock       
    private SubmersibletrackerController controller;

    @BeforeEach
    public void setUp() {
        controller = new SubmersibletrackerController();
    }

    @AfterEach
    public void tearDown() {
        controller = null;
    }

    @Test
    public void testMove() {
        controller.move(1, 2);
        assertEquals(1, controller.getPosition().getX());
        assertEquals(2, controller.getPosition().getY());
    }

    @Test   
    public void testMoveLeft() {
        controller.moveLeft(1, 2);
        assertEquals(1, controller.getPosition().getX());
        assertEquals(2, controller.getPosition().getY());
    }

    @Test
    public void testMoveRight() {
        controller.moveRight(1, 2);
        assertEquals(1, controller.getPosition().getX());
        assertEquals(2, controller.getPosition().getY());
    }

    @Test
    public void testMoveUp() {
        controller.moveUp(1, 2);
        assertEquals(1, controller.getPosition().getX());
        assertEquals(2, controller.getPosition().getY());
    }

    @Test
    public void testMoveDown() {
        controller.moveDown(1, 2);
        assertEquals(1, controller.getPosition().getX());
        assertEquals(2, controller.getPosition().getY());
    }

    @Test
    public void testSetObstacles() {
        controller.setObstacles(1, 2);
        assertEquals(1, controller.getObstacles().getX());
        assertEquals(2, controller.getObstacles().getY());
    }

    @Test
    public void testSetPath() {
        controller.setPath(1, 2);
        assertEquals(1, controller.getPath().getX());
        assertEquals(2, controller.getPath().getY());
    }

    @Test
    public void testSetPosition() {
        controller.setPosition(1, 2);
        assertEquals(1, controller.getPosition().getX());
        assertEquals(2, controller.getPosition().getY());
    }

    @Test
    public void testSetObstacle() {
        controller.setObstacle(1, 2);
        assertEquals(1, controller.getObstacle().getX());
        assertEquals(2, controller.getObstacle().getY());
    }
}