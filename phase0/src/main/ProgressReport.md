# Progress Report

Group Dragon Squirrel

Members: Future Hu, Jin Shang, Chris Phillips, 
Tingzhou Gu, Dylan Fox, Jennifer Li

## Domain
We decided to program a standard chess game and a modified chess game in Java.

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

## CRC Model
Entities:
- Player:
- Pieces:
1. King
2. Queen
3. Bishop
4. Knight
5. Rook
6. Pawn

Use Case:
- Board(Regular & Modified)
- Game Rule(Regular & Modified)

Controller & Presenter:
- BoardController

We have demonstrated our CRC cards details into a .pdf file as well as separately 
in the crcCard folder. 

Each card belongs to a layer of Clean Architecture and clearly
indicated. We have followed the SOLID principles. 
Details of CRC cards are also uploaded.

## Scenario Walk-Through
From out walk-through, we first build a standard playable chess game, the game rules may differ 
from the regular chess game. There will be two human players play against each other for now, no AI
player in this phase yet. 

We designed to let the UI displays the current board, (updated after each 
move). 

In one player's turn, once the player decides to move a piece, the UI class sends commands by invoking 
BoardManager, BoardManager class then checks whether the player's move is legal by calling methods in the
GameRule class, and GameRule may call functions in Piece class to determine validity. 

If the move is invalid, BoardManager returns false to UI class and UI prompts the player to make another move.
If the move is valid, BoardManager will send commands to Board class to actually move the piece. If the move 
involves pieces interaction(i.e. a piece attack another, etc.), then the BoardManager will invoke GameRule to 
further calculate results before letting Board class make changes.

For the modified chess game, a player can make multiple moves/attacks during one turn(in one of our design). The
above process repeats until all pieces are moved/ limited moves/ or the player manually passes its turn (by calling
methods in BoardManager). The UI class will then tell BoardManager to switch player, so the other player can make moves.

After each successful piece move, BoardManager will check whether the current player wins (i.e. checkmate).

There will be more functions added in the future design. (Timer, Rounds Counting)

#### - From walkthrough.md

## Skeleton Program


## Report