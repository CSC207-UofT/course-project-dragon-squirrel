# Design Document

## Updated Specification
Refer to the "[UpdatedSpecification.md](UpdatedSpecification.md)".  
Highlight of the additional functionality: Good-looking GUI. Save and reload state. 

## Class Diagram
- [Cleaner Class Diagram (no dependencies)](Class_Diagrams/class_diagram_all.png)
- [Dependencies Class Diagram](Class_Diagrams/dependency_diagram.png) *(Huge)*
- Separated Class Diagrams by packages located [phase2/Class_Diagrams/Separated Diagram]

## Major Design Decisions + Explanation
### Valid move checks
One big part of the design is that we put the valid move checks in both Piece class and GameRule class.
Since pieces have different behaviors, it makes sense to let themselves decide whether a given move is valid or not.
This way we don't have to use the instanceof operator to determine which type the piece is. But because Piece is in the entity 
layer, it is best to not let it interact with Board. This makes it hard to write all the valid move check code inside
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
(Super)Board, Piece(and its subclasses)

Use cases:\
(Super)BoardManager, ChessMove, Move, MoveRecord, (Super)GameRule, (Super)PieceDecorator, Engine(and its subclasses), State

Controllers/Presenters:\
BoardUpdater, CommandSender, Agent

The outermost layer (GUI):\
Main, LaunchPage, GUI_ChessBoard, GUI_SuperBoard, PieceIcon, SuperChessInstruction

The entity classes contain the essential information of a game play. The position of piece are stored in Board.
BoardManager is responsible for making changes to Board & Piece (i.e. move a piece).\
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

We basically introduce interfaces to every group of modules, so they can depend on interfaces to eliminate potential 
dependencies. For example the entity classes Board and Piece invoke each other, but technically there is no dependency
because they are only calling the methods in interfaces.



## Adherence to SOLID Design Principles
**S**: Class (Super)GameRule's sole responsibility is to check whether move is valid according to its game rules. 
Controller classes are separated into BoardUpdater and CommandSender classes because they have different 
responsibilities, thus avoiding low cohesion. Moreover, we decided to separate different move types into their own 
classes. This is because the implementation of methods execute() and undo() in Move classes are very different from each
other. For example, a castling move requires a specific rook to be placed at a specific spot, whereas an attack move 
requires the health point of a piece to be changed, whereas a regular move simply moves the action piece to its target 
coordinate. If we were to put all these implementations into one main Move class, it would break this principle and 
become overly complicated. Lastly, coordinates of the pieces are not stored in both the pieces themselves 
and the Board class. Rather, it is stored only in a private PieceInterface[][] board attribute in class Board. This way, 
code is not shared between actors.

**O**: Both the abstract Piece class and PieceDecorator class implement PieceInterface. This interface sets 
a skeleton outline of the necessary methods required to be implemented. Because piece classes (Bishop, Knight, etc.)
and the SuperPieceDecorator class extend classes that implement PieceInterface, they are thus closed for modification, 
but open for extension. In any case, the decorator design pattern used here is itself a design which requires that the 
base component remains unchanged and behaviours are only added on top.

**L**: In all the classic chess classes (Board, BoardManager, and GameRule) that are with a corresponding super chess 
subclass, its methods and attributes are shared with the subclass. In other words, there does not exist a method in the 
superclass that is irrelevant to its subclass. For example, the super chess game rules are all extensions of the classic
chess game rules; super chess pieces acquire the exact same behaviours as those in classic chess. 

**I**: Because classic chess pieces and super chess pieces are different in that one has attacks and health points 
while the other does not, PieceInterface does not specify methods related to health points and attacks. Rather, it only
outlines methods that are required by both classic and super chess pieces. 

**D**: High level classes such as GameRule depend on the methods outlined by the PieceInterface rather than 
the low level modules such as the concrete piece classes themselves. Furthermore, we created a board interface so that
high level classes depend on the interface rather than the actual board class itself. We also have a command interface
that outlines the necessary methods, i.e. execute() and undo() required in Move classes. Thus, the high level class
CommandSender will depend on the interface rather than the Move classes themselves. However, it is still worrisome that 
high level classes such as CommandSender depend on classes like GameRule and BoardManager which do not implement an 
interface. If these two classes were to change or if we wanted to add another board game with different rules, 
it may involve high coupling and become quite chaotic. 

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
All the code is written in package Command. The Command class is the interface, and Move class implements it, which has
methods execute() and undo(). Controller.CommandSender creates and sends these commands. On execution, BoardManager as 
the receiver will perform some actions. We decided to break down the command pattern to several move types since our 
super chess with new mechanics will also use the command pattern: RegularMove, EnPassantMove, CastlingMove, CaptureMove 
and AttackMove are all subclasses of Move.

### Decorator Pattern
Our classic chess and super chess have different rules about piece movement. However, because super chess pieces use the
basic behaviour of their corresponding classic chess pieces, it was unnecessary to create a separate class for each super
chess piece. Thus, the decorator pattern allows us to add new features (attack level and health points) to classic 
pieces without creating subclasses for all different pieces, thus making the project more concise. 

Nevertheless, this proved a problem in phase 2. When we designed the program, we had SuperGameRule check the validity 
of moves according to the additional super game rules. However, the GUI implemented in phase 2 uses getValidMoves() in 
the piece classes to highlight available moves to the user. But piece classes only check their corresponding classic 
piece behaviour. In other words, the GUI highlights available moves for the classic pieces even when you are playing 
super chess. Therefore, when playing super chess, the GUI may highlight a coordinate as a possible move when it is 
actually impossible. Thankfully, if you click on the supposedly possible coordinate, SuperGameRule will still stop the 
move from happening. 

### Strategy Pattern
Our chess AI has three difficulty levels. The chess AI makes decisions by searching through the states in a game tree, 
having more than one difficulty level usually means there will be multiple searching algorithms involved. By using the 
strategy pattern, we can easily write each algorithm in separate classes, and load the one into AI as the player specified. \
In package chessAI, Engine class acts like the interface of different behaviors and have method makeDecision(). Engine 
has GreedyButDumb and Minimax as its subclasses, which are two algorithm implementations, they make the actual decisions in different ways. In GUI_JFRAME.LaunchPage, the
Popup class let user choose the difficulty, and initializes AI with the corresponding algorithm. \
If we decide to add more algorithms in the future, this will be very handy.

## Accessibility Document
Refer to the "[accessibility.md](accessibility.md)".

## Progress Report

### Contribution 

- Jin
    - ...
- Jennifer
    - SuperChess GUI + super chess instructions
    - Merge Future and Jin's implementations of command pattern 
      - Polish Future's execute() and undo() in Move classes
      - Polish CommandSender methods containing Move
    - Add javadoc / check and fix team member's code 
    - Updating previous specification / SOLID description / Packaging Strategy description
- Future
    - Chess AI
    - Redesign command pattern
    - Rewrite getValidMoves() in Piece and its subclasses to fix bugs & improve readability
    - Add MouseListener to GUI and connect it up with controller & presenter
    - Other style & bug fix and quality improvement
    - Update CLEAN architecture and design pattern document
- Tingzhou
    - UI Structural design
    - GUI_Chessboard develop
    - PieceIcon class(unicode)
    - Accessibility Document
- Christopher
    - Unit Tests
    - SuperChess design/layout/rules
    - Pieces, Boards, BoardManager getters and setters
    - reset board method
- Dylan
    - ...
