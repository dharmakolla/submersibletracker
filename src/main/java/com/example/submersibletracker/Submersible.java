public class Submersible {
    private String name;
    private int x;
    private int y;
    private List<List<Integer>> obstacles;
    private List<List<Integer>> path;

    public Submersible(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.path = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getX() { 
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void moveLeft(int dx) {
        if (this.isObstacle(this.x - dx, this.y)) {
            return;
        }
        this.x -= dx;
    }

    public void moveRight(int dx) {
        if (this.isObstacle(this.x + dx, this.y)) {
            return;
        }
        this.x += dx;
    }

    public void moveUp(int dy) {
        if (this.isObstacle(this.x, this.y - dy)) {
            return;
        }
        this.y -= dy;
    }

    public void moveDown(int dy) {
        if (this.isObstacle(this.x, this.y + dy)) {
            return;
        }
        this.y += dy;
    }

    public List<List<Integer>> getObstacles() {
        return this.obstacles;
    }

    public void setObstacles(List<List<Integer>> obstacles) {
        this.obstacles = obstacles;
    }

    public boolean isObstacle(int x, int y) {
        return this.obstacles.contains(Arrays.asList(x, y));
    }

    public String getPath() {
        return this.path.stream()
            .map(Arrays::toString)
            .collect(Collectors.joining(", "));
    }
    
    
}

