package GameRule;

import Board.*;
import Command.MoveRecord;
import piece.PieceInterface;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class SuperGameRule extends GameRule {

    public SuperGameRule(Board superBoard, Map<String, PieceInterface> superPiecesDict, MoveRecord MR) {
        super(superBoard, superPiecesDict, MR);
    }

    /**
     * Check:   pieces move according to classic chess game rules.
     *          pieces beside pawns can not move into the river.
     *          pieces besides knights and pawns can not move over the river.
     * @return true if move is valid according to super chess game rules, false otherwise.
     */
    @Override
    public boolean isMoveValid(int oldX, int oldY, int newX, int newY) {
        if (!super.isMoveValid(oldX, oldY, newX, newY)){
            return false;
        }

        SuperBoard superBoard = (SuperBoard) super.getBoard();
        String pieceName = superBoard.getPiece(oldX, oldY);
        if (!pieceName.contains("pawn") && superBoard.getLandType(newX, newY).equals("river")) {
            System.out.println("invalid move into river");
            return false;
        }

        if (!pieceName.contains("knight") && !pieceName.contains("pawn")
                && !isPathClearOfRiver(oldX, oldY, newX, newY)){
            System.out.println("invalid move over river");
            return false;
        }

        return true;
    }

    /**
     * @return whether target coordinates harbors an opponent's piece
     */
    public boolean isAttackAvailable(int oldX, int oldY, int newX, int newY) {
        SuperBoard superBoard = (SuperBoard) super.getBoard();
        String pieceName = superBoard.getPiece(oldX, oldY);
        String targetPieceName = superBoard.getPiece(newX, newY);
        PieceInterface pieceToMove = super.getPiecesDict().get(pieceName);
        PieceInterface targetPiece = targetPieceName.equals("vacant") ? null : super.getPiecesDict().get(targetPieceName);

        return targetPiece!=null && !pieceToMove.hasSameColor(targetPiece);
    }

    /**
     * @return whether the attack is valid given super chess game rules
     */
    public boolean isAttackValid(int oldX, int oldY, int newX, int newY) {
        SuperBoard superBoard = (SuperBoard) super.getBoard();
        String land = superBoard.getLandType(oldX, oldY);

        if (land.equals("bridge") && !validFromBridgeAttack(oldX, oldY, newX, newY)){
            return false;
        }

        return land.equals("bridge") || validFromElsewhereAttack(oldX, oldY, newX, newY);
    }

    /**
     * If an attack is made from the bridge and the piece is not a pawn, it can only attack pieces on land types
     * besides the river. A pawn on the bridge can attack pieces on all land types.
     * @return whether the attack made from a bridge is valid
     */
    public boolean validFromBridgeAttack(int oldX, int oldY, int newX, int newY){
        SuperBoard superBoard = (SuperBoard) super.getBoard();
        String pieceName = superBoard.getPiece(oldX, oldY);
        if (!pieceName.contains("pawn")) {
            return !superBoard.getLandType(newX, newY).equals("river");
        }
        return true;
    }

    /**
     * If an attack is made from a land type that is not the bridge, it needs to...
     * <P> Check: pieces besides the knight cannot attack over the bridge
     * <P> Check: pieces besides the pawn cannot attack pawns "submerged" in the river
     * <P> Check: pieces cannot attack an opponent piece resting in its safe zone
     * @return whether the attack made from a land type besides the river is valid
     */
    public boolean validFromElsewhereAttack(int oldX, int oldY, int newX, int newY){
        SuperBoard superBoard = (SuperBoard) super.getBoard();
        String pieceName = superBoard.getPiece(oldX, oldY);
        String targetPieceName = superBoard.getPiece(newX, newY);
        PieceInterface pieceToMove = super.getPiecesDict().get(pieceName);
        PieceInterface targetPiece = targetPieceName.equals("vacant") ? null : super.getPiecesDict().get(targetPieceName);
        String targetLand = superBoard.getLandType(newX, newY);

        // Check: pieces cannot attack over the bridge
        if (!isPathClearOfBridge(oldX, oldY, newX, newY)) {
            System.out.println("invalid attack over bridge");
            return false;
        }

        // Check: pieces besides the pawn cannot attack pawns "submerged" in the river
        if (!pieceName.contains("pawn") && targetLand.equals("river")){
            System.out.println("invalid attack into river");
            return false;
        }

        // Check: pieces cannot attack an opponent piece resting in its safe zone
        if (targetPiece != null && !pieceToMove.hasSameColor(targetPiece) &&
                targetLand.contains(targetPiece.getColor().toString().toLowerCase())){
            System.out.println("invalid attack on piece in safe zone");
            return false;
        }

        return true;
    }

    /**
     * Pieces cannot attack over bridges.
     * @return whether path between (oldX, oldY) and (newX, newY) is clear of bridges
     */
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

    /**
     * Pieces besides the knight and pawn cannot cross over and into bridges.
     * @return whether path between (oldX, oldY) and (newX, newY) is clear of river
     */
    public boolean isPathClearOfRiver(int oldX, int oldY, int newX, int newY){
        SuperBoard superBoard = (SuperBoard) super.getBoard();

        ArrayList<Point> coordinates = pathCoordinates(oldX, oldY, newX, newY);
        for (Point point: coordinates) {
            if (superBoard.getLandType(point.x, point.y).equals("river")){
                return false;
            }
        }
        return true;
    }
}