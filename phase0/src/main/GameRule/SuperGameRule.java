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

        if (!pieceName.contains("knight") && !isPathClearOfRiver(oldX, oldY, newX, newY)){
            System.out.println("invalid move over river");
            return false;
        }

        return true;
    }

    public boolean isAttackAvailable(int oldX, int oldY, int newX, int newY) {
        SuperBoard superBoard = (SuperBoard) super.getBoard();
        String pieceName = superBoard.getPiece(oldX, oldY);
        String targetPieceName = superBoard.getPiece(newX, newY);
        PieceInterface pieceToMove = super.getPiecesDict().get(pieceName);
        PieceInterface targetPiece = targetPieceName.equals("vacant") ? null : super.getPiecesDict().get(targetPieceName);

        return targetPiece!=null && !pieceToMove.hasSameColor(targetPiece);
    }

    // Check whether attack is possible and valid
    public boolean isAttackValid(int oldX, int oldY, int newX, int newY) {
        SuperBoard superBoard = (SuperBoard) super.getBoard();
        String pieceName = superBoard.getPiece(oldX, oldY);
        String targetPieceName = superBoard.getPiece(newX, newY);
        String land = superBoard.getLandType(oldX, oldY);

        if (targetPieceName.equals("vacant")) {
            return false;
        } else {
            if (land.equals("bridge") && !validFromBridgeAttack(oldX, oldY, newX, newY)){
                return false;
            }

            if (!land.equals("bridge") && !validFromElsewhereAttack(oldX, oldY, newX, newY)){
                return false;
            }
        }
        return true;
    }

    // If an attack/move is made from the bridge and the piece is...
    // a pawn: it can move to all positions
    // not a pawn: it can move to all positions except for the river
    public boolean validFromBridgeAttack(int oldX, int oldY, int newX, int newY){
        SuperBoard superBoard = (SuperBoard) super.getBoard();
        String pieceName = superBoard.getPiece(oldX, oldY);
        if (!pieceName.contains("pawn")) {
            return !superBoard.getLandType(newX, newY).equals("river");
        }
        return true;
    }

    // Presupposes that a target piece exists.
    // if an attack is made from a land type that is not the bridge, it needs to...
    // Check: pieces besides the knight cannot attack over the bridge
    // Check: pieces cannot attack pawns "submerged" in the river
    // Check: pieces cannot attack an opponent piece resting in its safe zone but can move into the opponent's safe zone
    public boolean validFromElsewhereAttack(int oldX, int oldY, int newX, int newY){
        SuperBoard superBoard = (SuperBoard) super.getBoard();
        String pieceName = superBoard.getPiece(oldX, oldY);
        String targetPieceName = superBoard.getPiece(newX, newY);
        PieceInterface pieceToMove = super.getPiecesDict().get(pieceName);
        PieceInterface targetPiece = targetPieceName.equals("vacant") ? null : super.getPiecesDict().get(targetPieceName);
        String targetLand = superBoard.getLandType(newX, newY);

        // Check: pieces besides the knight cannot move/attack over the bridge
        if (!pieceName.contains("knight") && !isPathClearOfBridge(oldX, oldY, newX, newY)) {
            System.out.println("invalid attack over bridge");
            return false;
        }

        //Check: pieces cannot attack pawns "submerged" in the river or move into the river if it is not a pawn
        if (!pieceName.contains("pawn") && targetLand.equals("river")){
            System.out.println("invalid attack into river");
            return false;
        }

        // Check: pieces cannot attack an opponent piece resting in its safe zone but can move into the opponent's safe zone
        if (targetPiece != null && !pieceToMove.hasSameColor(targetPiece) &&
                targetLand.contains(targetPiece.getColor().toString().toLowerCase())){
            System.out.println("invalid attack on piece in safe zone");
            return false;
        }

        return true;
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