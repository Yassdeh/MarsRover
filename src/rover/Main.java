package rover;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Grid grid = new Grid(100, 100, Set.of());
        Rover rover = new Rover(new Position(0, 0), Direction.N, grid);

        rover.execute("ffrffxYZ".toCharArray());

        System.out.println(rover.getPosition() + " " + rover.getDirection());
    }
}