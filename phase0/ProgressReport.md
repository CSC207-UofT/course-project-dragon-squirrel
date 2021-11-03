# Progress Report

Group Dragon Squirrel

Members: Future Hu, Jin Shang, Chris Phillips, 
Tingzhou Gu, Dylan Fox, Jennifer Li

## Domain
We decided to program a standard chess game and a modified chess game in Java.

## Specification
For our specification, we designed to have a standard game of chess and a newly 
designed chess-based game with different rules that allows two human 
players or one player and an player.AI to play. Once player type and color are chosen, 
we will let the program display a corresponding board with pieces initialized at 
the starting position (with GUI). 

So far, we are mainly working on designing and coding the standard version of chess with
the same rules as a real chess game.
For the modified chess-based game, we designed:
- player.Player can make multiple moves/attacks each turn. 
- Each modified piece corresponds to health point and attack level. An attack counts as one 
of the multiple moves made during a turn wherein the attacking piece does not actually move.
- A piece is captured / removed from game when its health points are depleted.
- The game ends when one king is dead, a player gives up, or a player pauses the game.

We have set specific behaviours for different pieces, which is the same as 
the behaviours of pieces in a real chess game.

Additionally, we are thinking of designing 
- A timer for the game, if players do not make move(s) within the time limit, 
they automatically forfeit their turn. 
- An undo button that undoes moves by one turn. 
- A GUI that displays piece's available moves. 
- Also, a hint on one of the best possible moves can be given if player asks.

Details can be found in the Markdown File "[specification.md](specification.md)"

## CRC Model
**_Entities:_**
- [player.Player](src/main/Player.java):
- board.Board([Regular](src/main/Board.java) & [Modified](src/main/ModifiedPiece.java))
- Pieces:
1. [King](src/main/piece/King.java)
2. [Queen](src/main/piece/Queen.java)
3. [Bishop](src/main/piece/Bishop.java)
4. [Knight](src/main/piece/Knight.java)
5. [Rook](src/main/piece/Rook.java)
6. [Pawn](src/main/piece/Pawn.java)

**_Use Case:_**

- [Game Rule(Regular & Modified)](src/main/GameRule.java)
- [BoardManager](src/main/BoardManager.java)
  
**_Controller & Presenter:_**
- [CommandSender](src/main/CommandSender.java)

**_UI_**
- [UI](src/main/UI.java)

We have demonstrated our CRC cards details into a .pdf file as well as separately 
in the crcCard folder. 

Each card belongs to a layer of Clean Architecture and clearly
indicated. We have followed the SOLID principles. 
Details of CRC cards are also uploaded.

## Scenario Walk-Through
From our scenario walk-through, we have briefly shows that how a game is initialized, and when a player 
wants to move pieces, which classes and functions will be called.

More details can be found in the Markdown file "[walkthrough.md](walkthrough.md)".

## Skeleton Program
For this phase, our skeleton program contains basic classes as shown in the CRC card, with basic methods 
that would allow us to run a basic chess game. A simple GUI allows players to enter their moves.
We have added unittest files for each class under "src/test" folder. ....

Tips on running the code:  
If window popup is blank, expand it.  
Press start new game to see text-based chess board in the console.  
Enter move using (row, column) start and end coordinates.

## Report
### Contribution

- Jin (push CRC card, piece specific rules code)
- Jennifer (specification, non piece specific rules code)
- Future (scenario walkthrough, remaining code)
- Tingzhou (End report, other code)
- Christopher (unitest, other code)
- Dylan (quality improvement, other code)

We have had a discussion with our TA and there were some problems found. 
**Each of us has contribution to discuss, share ideas, and fix those problems we found.**

**For our next phases, we will be working on:**
- Complete and testing the codes
- Packaging classes
- GUI
- A timer for the game, if players do not make move(s) within the time limit,
  they automatically forfeit their turn.
- An undo button that undo moves by one turn.
- Players would have a GUI display piece's available moves.
- A hint option on one of the best possible moves can be given if player asked.

We have designed some great ideas as the beginning of our project, we discussed how to make our designs 
belongs to the Clean Architecture and obey the SOLID principles. We make lots of discussions on the problems 
we found and how to solve the problems.

### Questions
1. Since our UI class is going to show the board to player, but we cannot let UI access the board.Board class due to 
Clean Architecture. Should we let UI store a cache of current board and use methods to deliver updates from the board.Board class each time players make moves?