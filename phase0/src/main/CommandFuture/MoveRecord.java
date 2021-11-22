package CommandFuture;

import java.util.LinkedList;

public class MoveRecord {
    LinkedList<Move> record;
    public MoveRecord(){
        record = new LinkedList<Move>();
    }

    public void add(Move newChessRuleMove){
        record.addFirst(newChessRuleMove);
    }

    public Move get(){
        return record.getFirst();
    }

    public void remove(){
        record.removeFirst();
    }

    public boolean isEmpty(){
        return record.isEmpty();
    }
}
