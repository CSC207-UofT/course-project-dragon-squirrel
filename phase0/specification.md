## Introduction
Running the program starts a GUI that allows two humans or one human and an player.AI to enjoy a standard game of chess or a
newly designed chess-based game with added features and rules. Once player type (human v human or human v player.AI), game
type, and piece colour are chosen, a corresponding board is displayed with pieces initialized at their respective
starting positions. Taking turns, each player enters a move until the game ends. Each move must follow the piece
specific behaviours and game specific rules. If the current player is an player.AI, a valid move is directly made

## Chess Game

Each player makes one valid move on their piece during their turn. Invalid moves prompt the current player to reenter a
new move. An opponent's piece can be captured in the process if a move is made to take the opponent's piece's place. The
captured piece is wiped from the board.

A player wins when checkmate occurs: the opponent's king is under attack and no legal move can be made by the opponent
to help the king escape. The game can also end if there is a stalemate, a player gives up, or a player pauses the game
to return to it at a later time.

### Piece Specific Behaviours
pawn: 1 square directly forward, optional 2 squares directly forward if not yet moved, promotion if reach other end.  
rook: horizontal/vertical straight line  
bishop: diagonal straight line  
knight: L-shape move, can "jump" over pieces  
queen: horizontal/vertical/diagonal line  
king: one square any direction, castling

## Modified Chess-Based Game
Each player can make multiple moves during their turn. They may also forfeit their turn. Each modified piece corresponds
to health points and an attack level. An attack counts as one of the multiple moves made during a turn wherein the
attacking piece does not actually move. The attacking piece moves to the location of the attacked piece when the
attacked piece is captured. A piece is captured when it's health points are depleted.

The game ends when the king is dead, a player gives up, or a player pauses the game.

## Additional features
The game may be played with a timer. If players do not make their move(s) within the time limit, they automatically
forfeit their turn. There exists an undo button that undoes the game by one turn. Players have the option of having the
graphical user interface display a piece's available moves. A hint on one of the best possible move can be given if the
player asks.