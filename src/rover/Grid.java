package rover;

import java.util.Set;

public class Grid {
    private final int width;
    private final int height;
    private final Set<Position> obstacles;

    public Grid(int width, int height, Set<Position> obstacles) {
        this.width = width;
        this.height = height;
        this.obstacles = Set.copyOf(obstacles);
    }

    public Position wrap(Position position) {
        return new Position(
                Math.floorMod(position.x(), width),
                Math.floorMod(position.y(), height));
    }

    public boolean hasObstacleAt(Position position) {
        return obstacles.contains(position);
    }
}