package rover;

@FunctionalInterface
public interface Command {
    boolean executeOn(Rover rover);
}
