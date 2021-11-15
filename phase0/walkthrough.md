## Summary
We will first build a basic playable chess game. The game rules may differ from the regular chess game.
There will be two human players who play against each other. No Player.AI player during this phase.

## Walk-through
The GUI pops up a window and allows player to move a piece, the Controller.BoardUpdater displays the current board in text format,

Once the player decides to move a piece (click buttons in GUI), the Controller.CommandSender class is called, and it checks 
whether the player's move is valid by calling methods in GameRule.GameRule class. GameRule.GameRule will further call Board.Board class and
piece class to check the route of the move, and whether it's allowed according to the type of pieces.

If the move is invalid, Controller.CommandSender returns false to GUI class, and player can make another move.
If the move is valid, Controller.CommandSender will send commands (call methods) to BoardManager.BoardManager class to actually move the piece 
and remove the captured piece if applicable.

After a successful move, BoardManager.BoardManager will check whether the current player wins (checkmate), and will also switch 
active player(so that only active player's piece can be moved).

## Phase 2 design
In phase2 design, a player can move multiple pieces during its turn. The above process repeats until all pieces
are moved or the player manually passes its turn (by calling methods in BoardManager.BoardManager), then switch player.

More functions like timer will be added later.
