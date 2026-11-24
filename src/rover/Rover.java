package rover;

import java.util.Map;
import java.util.Optional;

public class Rover {
    private static final Map<Character, Command> COMMANDS = Map.of(
            'f', rover -> rover.move(1),
            'b', rover -> rover.move(-1),
            'l', rover -> rover.turn(rover.direction.left()),
            'r', rover -> rover.turn(rover.direction.right()));

    private final Grid grid;
    private Position position;
    private Direction direction;
    private Position obstacle;

    public Rover(Position position, Direction direction, Grid grid) {
        this.position = position;
        this.direction = direction;
        this.grid = grid;
    }

    public void execute(char[] commands) {
        obstacle = null;
        for (char symbol : commands) {
            Command command = COMMANDS.get(symbol);
            if (command == null) {
                throw new IllegalArgumentException("Commande inconnue : " + symbol);
            }
            if (!command.executeOn(this)) {
                return;
            }
        }
    }

    private boolean move(int step) {
        Position next = grid.wrap(position.next(direction, step));
        if (grid.hasObstacleAt(next)) {
            obstacle = next;
            return false;
        }
        position = next;
        return true;
    }

    private boolean turn(Direction newDirection) {
        direction = newDirection;
        return true;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public Optional<Position> getObstacle() {
        return Optional.ofNullable(obstacle);
    }
}
