package command;

import java.util.LinkedList;

public class MoveRecord {
    LinkedList<ChessRuleMove> record;
    public MoveRecord(){
        record = new LinkedList<ChessRuleMove>();
    }

    public void add(ChessRuleMove newChessRuleMove){
        record.addFirst(newChessRuleMove);
    }

    public ChessRuleMove get(){
        return record.getFirst();
    }
}
