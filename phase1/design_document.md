# Design Document

## Updated Specification
Refer to the "[UpdatedSpecification.md](UpdatedSpecification.md)", specifically the updated Super Chess part.  
Highlight of the additional functionality: The updated rules and features of Super Chess has been implemented. 
Players are also able to undo. 

## Class Diagram
*Class diagram picture to be updated

## Major Design Decisions + Explanation
### Valid move checks
One big part of the design is that we put the valid move checks in both Piece class and GameRule class.
Since pieces have different behaviors, it makes sense to let themselves decide whether a given move is valid or not.
This way we don't have to use the instanceof operator to determine which type the piece is. But because Piece is in the entity 
layer, it is best to not let it interact with Board. This makes it hard to write all of the valid move check code inside
Piece. Therefore, we decide to write more general rule check code in GameRule, which is a use case class.

### Super chess design
Super chess has a different set of rules compared with classic chess, most of them are extensions to the original rules.
So, we extend the chess behavior by adding subclasses to all mechanism related classes. One exception is that we don't 
have a super chess version of Piece class. Because writing subclasses for each type of piece could be tedious and results 
in lots of classes. Thus, we decide to use decorator pattern on super piece instead.

### Split presenter & controller
Originally, the code of BoardUpdater and CommandSender are written in a single class. We seperated the class
later to follow the single responsibility principle: BoardUpdater is presenter and CommandSender is controller.

## Adherence to Clean Architecture
Entities:\
Player, AI, Human, (Super)Board, Piece(and all its subclasses)

Use cases:\
(Super)BoardManager, ChessMove, Move, MoveRecord, (Super)GameRule, (Super)PieceDecorator

Controllers/Presenters:\
BoardUpdater, CommandSender

The outer most layer has only one class:\
GUI

The entity classes contain the essential information of a game play. The position of piece are stored in Board.
BoardManager is responsible for generating move commands and for making changes to Board & Piece (i.e. move a piece).\
ChessMove and Move are utilities of Command Pattern, they package move commands into objects.\
MoveRecord is move history. It is accessed by BoardManager.\
GameRule is responsible for checking whether a given move command is valid, it needs to access Piece to further check
more specific rules.\
PieceDecorator is utility of Decorator Pattern, it adds extra attributes & behaviors to Piece.\
BoardUpdater is responsible for reflecting the changes in Board & Piece to GUI.\
CommandSender is responsible for sending the commands from GUI to use case classes.

Among all the classes, entities only store primitives and depend on no other classes; Use case classes depends on each
other and entities; Controller & presenter depends on each other and use cases; GUI only depends on controller & 
presenter.

One problem: we want to design a game AI, and this requires each piece generate its next available moves. It is hard to 
write the code in Piece classes without depending on Board, and it will also be tedious to write all the code in 
GameRule since we have to use instanceof to check which type the piece is.



## Adherence to SOLID Design Principles
**S**: Class (Super)GameRule's sole responsibility is to check whether move is valid according to its game rules. 
Controller classes are separated into BoardUpdater and CommandSender classes because they have different 
responsibilities, thus avoiding low cohesion. Coordinates of the pieces are not stored in both the pieces themselves 
and the Board class. Rather, it is stored only in a private String[][] board attribute in class Board. This way, code is
not shared between actors.

**O**: Both the abstract Piece class and PieceDecorator class implement PieceInterface. This interface sets 
a skeleton outline of the necessary methods required to be implemented. Because piece classes (Bishop, Knight, etc.)
and the SuperPieceDecorator class extend classes that implement PieceInterface, they are thus closed for modification, 
but open for extension. In any case, the decorator design pattern used here is itself a design which requires that the 
base component remains unchanged and behaviours are only added on top.

**L**: In all the classic chess classes (Board, BoardManager, and GameRule) that are with a corresponding super chess 
subclass, its methods and attributes are shared with the subclass. In other words, there does not exist a method in the 
superclass that is irrelevant to its subclass. For example, the super chess game rules are all extensions of the classic
chess game rules; super chess pieces acquire the exact same behaviours as those in classic chess. Thus, for example, 
the overridden method isMoveValid() in SuperGameRule still calls the isMoveValid() in GameRule. 

**I**: Because classic chess pieces and super chess pieces are different in that one has attacks and health points 
while the other does not, PieceInterface does not specify methods related to health points and attacks. Rather, it only
outlines methods that are required by both classic and super chess pieces. 

**D**: High level classes such as GameRule depend on the methods outlined by the PieceInterface rather than 
the low level modules such as the concrete piece classes themselves. However, it is worrisome that high level classes
such as CommandSender depend on classes like GameRule and BoardManager which do not implement an interface. If these 
two classes were to change, it may involve high coupling and become quite chaotic.

## Packaging Strategies
This is packaging by feature. At first, we put SuperChess and Chess classes into separate folders. However, this proved
difficult since we realized that super chess classes required many of its corresponding classic chess class methods. To 
avoid duplicate code, the super chess classes extend its corresponding classic chess classes and thus putting super 
and classic classes into one folder proved easier. This is why SuperBoard and Board is in a Board package, GameRule and
SuperGameRule is in a GameRule package, etc.

## Summary of present/future Design Patterns 
###Command Pattern
It makes perfect sense to package each move piece command into objects, as this allows us to add move history easily.
A move history can further let us implement undo piece moves. \
When designing a chess AI, it is important to let it generate its next available moves, then decide which move is 
better. This can use the help from command pattern.

### Decorator Pattern
Our classic chess and super chess have different rules about piece movement. The decorator pattern allows us to add new
rules to classic pieces without creating subclasses for all different pieces, thus makeing the project more concise.

### Observer Pattern
The information of pieces locations is stored in the entity class Board, the information need to reflect to other places
like the GUI. Currently, there is only GUI that requires updates from Board, but we may have more in the future.
Additionally, observer pattern helps deliver the information while bypassing the restrictions of clean architecture.\
Due to some technical issues, this part is not yet implemented.

## Progress Report
### Contribution 
*plans to work on next in italics*

- Jin
    - Command design pattern
- Jennifer
    - Updated Specification
    - Decorator design pattern
    - Brief Description of SOLID
    - Brief Description of Packaging Strategy
    - Implementation of SuperChess
      - subclasses: SuperBoard, SuperBoardManager, SuperGameRule
    - *GUI with chessboard*
- Future
    - Major design decisions + Explanation
    - Summary of Present/Future Design Patterns
    - Brief Description of Clean Architecture
    - *Observer design pattern*
    - *AI implementation*
- Tingzhou
    - Class Diagram
    - *GUI with chessboard*
- Christopher
    - Testing
    - *Testing*
- Dylan
    - getAvailableMoves()
