# Progress Report

## Specification
For our specification, we designed to have a standard game of chess and a newly 
designed chess-based game with different rules that allows two human 
players or one player and an AI to play. Once player type and color are chosen, 
we will let the program display a corresponding board with pieces initialized at 
the starting position (with GUI). 

So far, we are mainly working on designing and coding the standard version of chess with
the same rules as a real chess game.
For the modified chess-based game, we designed:
- to let player can make multiple in each turn. 
- Each modified piece corresponds to health point and attack level. An attack counts as one 
of the multiple moves made during a turn wherein the attacking piece does not actually move.
- A piece is captured / removed from game when its health points are depleted.
- The game ends when one king is dead, a player gives up, or a player pauses the game.

We have set specific behaviours for different pieces, which is the same as 
the behaviours of pieces in a real chess game.

Additionally, we are thinking of designing 
- a timer for the game, if players do not make move(s) within the time limit, 
they automatically forfeit their turn. 
- an undo button that undo moves by one turn. 
- Players would have a GUI display piece's available moves. 
- Also, a hint on one of the best possible moves can be given if player asked.
