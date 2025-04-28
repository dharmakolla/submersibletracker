package com.example.submersibletracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class Submersible {
    private String name;
    private int x;
    private int y;
    private List<List<Integer>> obstacles;
    private List<List<Integer>> path;

    public Submersible() {
        this("Default", 0, 0);
    }

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

    public Submersible moveLeft(int dx) {
        if (this.isObstacle(this.x - dx, this.y)) {
            return this;
        }
        this.x -= dx;
        return this;
    }

    public Submersible moveRight(int dx) {
        if (this.isObstacle(this.x + dx, this.y)) {
            return this;
        }
        this.x += dx;
        return this;
    }

    public Submersible moveUp(int dy) {
        if (this.isObstacle(this.x, this.y + dy)) {
            return this;
        }
        this.y += dy;
        return this;
    }

    public Submersible moveDown(int dy) {
        if (this.isObstacle(this.x, this.y - dy)) {
            return this;
        }
        this.y -= dy;
        return this;
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

    public String getPathAsString() {
        return this.path.stream()
            .map(list -> list.toString())
            .collect(Collectors.joining(", "));
    }

    public List<List<Integer>> getPath() {
        return this.path;
    }

    public List<List<Integer>> setPath(int x, int y) {
        this.path.add(Arrays.asList(x, y));
        return this.path;
    }
    
}

