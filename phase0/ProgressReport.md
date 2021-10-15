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
From our scenario walk-through, we have briefly shows that how a game is initialized, and when a player 
wants to move pieces, which classes and functions will be called.

More details can be found in the Markdown file "walkthrough.md".

## Skeleton Program


## Report