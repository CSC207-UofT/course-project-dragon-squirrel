package GameRule;

import Board.SuperBoard;
import piece.PieceInterface;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class SuperGameRule extends GameRule {

    public SuperGameRule(SuperBoard superBoard, Map<String, PieceInterface> superPiecesDict) {
        super(superBoard, superPiecesDict);
    }

    @Override
    public boolean isMoveValid(int oldX, int oldY, int newX, int newY) {
        super.isMoveValid(oldX, oldY, newX, newY);

        SuperBoard superBoard = (SuperBoard) super.getBoard();
        String land = superBoard.getLandType(oldX, oldY);

        if (land.equals("Bridge") && !validFromBridgeAttack(oldX, oldY, newX, newY)){
            return false;
        }

        if (!land.equals("Bridge") && !validFromElsewhereAttack(oldX, oldY, newX, newY)){
            return false;
        }

        return true;
    }

    // If an attack/move is made from the bridge and the piece is...
    // a pawn: it can move to all positions
    // not a pawn: it can move to all positions except for the river
    public boolean validFromBridgeAttack(int oldX, int oldY, int newX, int newY){
        SuperBoard superBoard = (SuperBoard) super.getBoard();
        String pieceName = superBoard.getPiece(oldX, oldY);
        if (!pieceName.equals("pawn")) {
            return !superBoard.getLandType(newX, newY).equals("river");
        }
        return true;
    }

    // if an attack is made from a land type that is not the bridge, it needs to...
    // Check: pieces besides the knight cannot move/attack over the bridge
    // Check: pieces cannot attack pawns "submerged" in the river or move into the river if it is not a pawn
    // Check: pieces cannot attack an opponent piece resting in its safe zone but can move into the opponent's safe zone
    public boolean validFromElsewhereAttack(int oldX, int oldY, int newX, int newY){
        SuperBoard superBoard = (SuperBoard) super.getBoard();
        String pieceName = superBoard.getPiece(oldX, oldY);
        String targetLand = superBoard.getLandType(newX, newY);
        String targetPieceName = superBoard.getPiece(newX, newY);

        // Check: pieces besides the knight cannot move/attack over the bridge
        if (!pieceName.equals("knight") && !isPathClearOfBridge(oldX, oldY, newX, newY)) {
            System.out.println("invalid attack/move over bridge");
            return false;
        }

        //Check: pieces cannot attack pawns "submerged" in the river or move into the river if it is not a pawn
        if (!pieceName.equals("pawn") && targetLand.equals("river")){
            System.out.println("invalid attack/move into river");
            return false;
        }

        // Check: pieces cannot attack an opponent piece resting in its safe zone but can move into the opponent's safe zone
        if (!targetPieceName.equals("vacant") && pieceName.charAt(0) != targetLand.charAt(0)){
            System.out.println("invalid attack on piece in safe zone");
            return false;
        }

        return true;
    }

    @Override
    public boolean isCoordinateValid(int oldX, int oldY, int newX, int newY) {
        return newX >= 0 & newX < 13 & newY >= 0 & newY < 10 & (oldX != newX || oldY != newY);
    }

    // checks if path is clear of bridges because pieces not on bridges can't attack over bridges
    public boolean isPathClearOfBridge(int oldX, int oldY, int newX, int newY){
        SuperBoard superBoard = (SuperBoard) super.getBoard();

        ArrayList<Point> coordinates = pathCoordinates(oldX, oldY, newX, newY);
        for (Point point: coordinates) {
            if (superBoard.getLandType(point.x, point.y).equals("bridge")){
                return false;
            }
        }
        return true;
    }
}