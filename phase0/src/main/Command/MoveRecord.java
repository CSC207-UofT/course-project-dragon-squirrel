package Command;

import java.util.LinkedList;

public class MoveRecord {
    LinkedList<ChessMove> record;
    public MoveRecord(){
        record = new LinkedList<ChessMove>();
    }

    public void add(ChessMove newChessRuleMove){
        record.addFirst(newChessRuleMove);
    }

    public ChessMove get(){
        return record.getFirst();
    }

    public void remove(){
        record.removeFirst();
    }

    public boolean isEmpty(){
        return record.isEmpty();
    }
}
