package Command;

import java.io.Serializable;
import java.util.LinkedList;

public class MoveRecord implements Serializable {
    LinkedList<ChessMove> record;

    public MoveRecord(){
        record = new LinkedList<>();
    }

    /**
     * Add newChessRuleMove to the beginning of the LinkedList record.
     */
    public void add(ChessMove newChessRuleMove){
        record.addFirst(newChessRuleMove);
    }

    /**
     * @return the ChessMove at the beginning of the LinkedList record, i.e. return the previous move made.
     */
    public ChessMove get(){
        return record.getFirst();
    }

    /**
     * Remove the ChessMove at the beginning of the LinkedList record, i.e. remove the previous ChessMove made from
     * record.
     */
    public void remove(){
        record.removeFirst();
    }

    /**
     * @return true if record is empty, false otherwise.
     */
    public boolean isEmpty(){
        return record.isEmpty();
    }
}
