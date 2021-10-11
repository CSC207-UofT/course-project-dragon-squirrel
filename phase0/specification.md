## Introduction
Create a program that allows two humans or one human and an AI to enjoy a standard game of chess or a newly designed 
chess-based game with added features and rules.

Once player type (human v human or human v AI) and game type are chosen, a corresponding board is made with 
pieces initialized at their respective starting positions. Taking turns, a user interface prompts each player to enter 
a move on one of their pieces. The suggested move is executed once it is determined that the move is legal according to 
the piece specific behaviours and game specific rules. If the move is invalid, another prompt for a new move by the same 
player is made. If the move is valid, the above process repeats for the next player. If the next player is an AI, a move 
is directly made. 

The game ends when checkmate occurs: the king is under attack and no legal move can be made to help the king escape.

## Captures

In the standard game, an opponent's piece can be captured in the process if a move is made to take the opponent's 
piece's place. The captured piece is wiped from the board. In the modified game, each modified piece corresponds to 
health points and an attack level. Each modified piece then has the option of attacking an opponent's piece. This counts 
as a move wherein the attacking piece does not actually move. A piece is captured as in the standard game when its 
health points are depleted.

## Standard game: piece specific behaviours
pawn: one square directly forward, optional two squares directly forward if it has not moved yet
rook: horizontal/vertical straight line
bishop: diagonal straight line
knight: L-shape move, can "jump" over pieces
queen: horizontal/vertical/diagonal line
king: one square any direction

## Present Scope
A simple game of chess can be played by two human players by entering coordinate input. No graphical user interface 
exists at the moment but the user interface will let the player know if the suggested move executed or not through its 
prompts. An AI strategy implementation will not be considered at this stage. 
