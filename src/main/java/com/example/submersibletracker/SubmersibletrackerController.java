package com.example.submersibletracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/submersible")
public class SubmersibletrackerController {

    @Autowired
    private Submersible submersible;

    public SubmersibletrackerController(Submersible submersible) {
        this.submersible = submersible;
        this.submersible.setObstacles(Arrays.asList(Arrays.asList()));
    }

    @PostMapping("/commands")
    public ResponseEntity<List<List<Integer>>> executeCommands(@RequestBody List<String> commands) {
        List<List<Integer>> path = new ArrayList<>();
        try {
            for (String command : commands) {
                String[] parts = command.trim().split("\\s+"); // Split by spaces
                if (parts.length != 2) {
                    throw new IllegalArgumentException("Invalid command format: " + command);
                }

                String direction = parts[0].toUpperCase();
                int distance = Integer.parseInt(parts[1]);

                switch (direction) {
                    case "LEFT":
                        submersible = this.moveLeft(Arrays.asList(distance)).getBody();
                        if (submersible != null) {
                            path.add(Arrays.asList(submersible.getX(), submersible.getY())); // Add current position instead
                        }
                        break;
                    case "RIGHT":
                        submersible = this.moveRight(Arrays.asList(distance)).getBody();
                        if (submersible != null) {
                            path.add(Arrays.asList(submersible.getX(), submersible.getY())); // Add current position instead
                        }
                        break;
                    case "UP":
                        submersible = this.moveUp(Arrays.asList(distance)).getBody();
                        if (submersible != null) {
                            path.add(Arrays.asList(submersible.getX(), submersible.getY())); // Add current position instead
                        }
                        break;
                    case "DOWN":
                        submersible = this.moveDown(Arrays.asList(distance)).getBody();
                        if (submersible != null) {
                            path.add(Arrays.asList(submersible.getX(), submersible.getY())); // Add current position instead
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown direction: " + direction);
                }
            }

            return ResponseEntity.ok(path);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }
    }

    @GetMapping("/path")    
    public ResponseEntity<String> getPath() {
        return ResponseEntity.ok(submersible.getPathAsString());
    }

    @GetMapping("/obstacles")
    public ResponseEntity<List<List<Integer>>> getObstacles() {
        return ResponseEntity.ok(submersible.getObstacles());
    }

    @GetMapping("/position")
    public ResponseEntity<List<Integer>> getPosition() {
        return ResponseEntity.ok(Arrays.asList(this.submersible.getX(), this.submersible.getY()));
    }

    @GetMapping("/name")
    public ResponseEntity<String> getName() {
        return ResponseEntity.ok(this.submersible.getName());
    }

    @PostMapping("/move")
    public ResponseEntity<Void> move(@RequestBody List<Integer> position) {
        this.submersible.move(position.get(0), position.get(1));
        this.submersible.setPath(position.get(0), position.get(1));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/moveLeft")
    public ResponseEntity<Submersible> moveLeft(@RequestBody List<Integer> position) {
        this.submersible = this.submersible.moveLeft(position.get(0));
        return ResponseEntity.ok(this.submersible);
    }

    @PostMapping("/moveRight")
    public ResponseEntity<Submersible> moveRight(@RequestBody List<Integer> position) {
        this.submersible = this.submersible.moveRight(position.get(0));
        return ResponseEntity.ok(this.submersible);
    }

    @PostMapping("/moveUp")
    public ResponseEntity<Submersible> moveUp(@RequestBody List<Integer> position) {
        this.submersible = this.submersible.moveUp(position.get(0));
        return ResponseEntity.ok(this.submersible);
    }

    @PostMapping("/moveDown")
    public ResponseEntity<Submersible> moveDown(@RequestBody List<Integer> position) {
        this.submersible = this.submersible.moveDown(position.get(0));
        return ResponseEntity.ok(this.submersible);
    }

    @PostMapping("/setObstacles")
    public ResponseEntity<Void> setObstacles(@RequestBody List<List<Integer>> obstacles) {
        this.submersible.setObstacles(obstacles);
        return ResponseEntity.ok().build();
    }

    public static void main(String[] args) {
        Submersible submersible = new Submersible();
        SubmersibletrackerController controller = new SubmersibletrackerController(submersible);
        //controller.moveLeft(Arrays.asList(0));
    }
}