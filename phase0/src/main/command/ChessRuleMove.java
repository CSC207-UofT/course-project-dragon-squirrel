package command;

public interface ChessRuleMove {
    boolean move();
    int getOldCoordX();
    int getNewCoordX();
    int getOldCoordY();
    int getNewCoordY();

}
