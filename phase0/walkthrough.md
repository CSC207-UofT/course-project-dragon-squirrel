We will first build a basic playable chess game. The game rules may differ from the regular chess game.
There will be two human players play against each other. No AI player during this phase.

The UI class displays the current board (doesn't have to be graphic), and allows player to move a piece.

Once the player decides to move a piece, the UI class send commands by calling BoardManager.movePiece().
BoardManager class then checks whether the player's move is allowed by the rules by calling methods in Board class,
and Board class may need to call methods in Piece class to determine validity.
If the move is invalid, BoardManager return false to UI class and UI let the player make another move.
If the move is valid, BoardManager will send command (call methods) to Board class to actually move the piece. If the 
move involves pieces interaction, then BoardManager will further calculate result and let Board class make changes.

A player can move multiple pieces during its turn (in one of our designs). The above process repeats until all pieces
are moved or the player manually passes its turn (by calling methods in BoardManager).
The UI class will then tell BoardManager to switch player, so the other player can move pieces.

After each successful piece move, BoardManager will check whether the current player wins.

More functions like timer will be added later.
