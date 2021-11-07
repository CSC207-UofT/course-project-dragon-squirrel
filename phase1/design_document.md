# Design Document

## Updated Specification
Refer to the "[UpdatedSpecification.md](UpdatedSpecification.md)", specifically the updated Super Chess part.  
Highlight of the additional functionality: The updated rules and features of Super Chess has been implemented. 
Players are also able to undo. 

## Class Diagram
*Class diagram picture to be updated

## Major Design Decisions + Explanation

## Adherence to Clean Architecture

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

## Progress Report