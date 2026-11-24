package rover;

public record Position(int x, int y) {

    public Position next(Direction direction, int step) {
        return new Position(x + direction.dx() * step, y + direction.dy() * step);
    }
}