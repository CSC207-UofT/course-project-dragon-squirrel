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
**S**: Class GameRule.GameRule's sole responsibility is to check whether move is valid according to game rules.  

**O**: Both abstract classes Piece and SuperPiece implement its corresponding Piece or SuperPiece interface which 
provides the necessary methods needed to be implemented. Since other classes interact with the methods outlined by the 
interface and concrete piece classes must extend their corresponding abstract class, methods of concrete piece classes
are open for extension, but closed for modification. 

**L**: The methods and attributes in the abstract Piece and SuperPiece classes are all common functionalities that are
required by all concrete pieces. For instance, attribute hasNotMovedDuringGame was not put in the abstract 
Piece/SuperPiece classes because not all concrete pieces require it; It is only used by the rook, king, and pawn, for 
castling and two-square moves.  

**I**: Because Piece and SuperPiece are different in that one has attack levels and health points while the other does 
not, it is not ideal to have only one interface with those additional features when a set of subclasses (the standard 
chess pieces) will not even need to use them. Thus, two different interfaces are made: SuperPieceinterface and 
Pieceinterface.

**D**: High level classes such as GameRule.GameRule depend on the methods outlined by Piece/SuperPiece interfaces rather than 
the low level modules such as the concrete Piece class themselves.

## Packaging Strategies

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
