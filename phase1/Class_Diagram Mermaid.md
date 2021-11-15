## Class Diagram

Using Mermaid v8.9.1


Class Diagram (Chess Game):

```mermaid
classDiagram
    Player <-- Human : implement
    Player <-- AI : implement
    
    Player : String ID
    Player : Color color
    Player : boolean status
    
    Human : String ID
    
    AI : String ID
    
    
    piece <-- King : implement
    piece <-- Queen : implement
    piece <-- Rook : implement
    piece <-- Bishop : implement
    piece <-- Knight : implement
    piece <-- Pawn : implement
    
    piece : String name
    piece : Color color
    piece : boolean status
    piece : getName()
    piece : getColor()
    piece : getStatus()
    piece : validMove()
    
    King : String name
    King : Color 
    King : boolean status
    King : validmove()
    King : castling()
    
    Queen : String name
    Queen : Color 
    Queen : boolean status
    Queen : validmove()
    
    Rook : String name
    Rook : Color 
    Rook : boolean status
    Rook : validmove()
    
    Bishop : String name
    Bishop : Color 
    Bishop : boolean status
    Bishop : validmove()
    
    Knight : String name
    Knight : Color 
    Knight : boolean status
    Knight : validmove()
    
    Pawn : String name
    Pawn : Color 
    Pawn : boolean status
    Pawn : validmove()
    
    ModifiedPiece --> piece
    ModifiedPiece : int hp
    ModifiedPiece : int atk
    ModifiedPiece : getHp()
    ModifiedPiece : getAtk()
    
    
    Board <--> piece : Collaborators
    Board : String [][] board
    Board : addPiece()
    Board : removePiece()
    Board : isPositionVacant()
    Board : getPiece()
    Board : reset()
    
    ModifiedBoard --> Board : implement
    
    
    GameRule --> piece : collaborator
    GameRule --> Board : collaborator
    GameRule : Board board
    GameRule : Map<String, piece> piecesDict 
    GameRule : isMoveValid()
    GameRule : isPathClear()
    GameRule : isCoordinateVacant()
    GameRule : isCoordinateValid()
    GameRule : pieceInteraction()
    GameRule : isPlayerWinning()
    GameRule : getAvailableMoves()
    
    BoardManager --> piece : Collaborator
    BoardManager <--> Board : Collaborator
    BoardManager : Board board
    BoardManager : Map<String, piece> pieces
    BoardManager : Player p1
    BoardManager : Player p2
    BoardManager : Player activePlayer
    BoardManager : GameStatus
    BoardManager : getActivePlayer()
    BoardManager : movePiece()
    BoardManager : deductPieceHp()
    BoardManager : switchActivePlayer()
    BoardManager : switchPieceStatus()
    BoardManager : resetBoard()
    
    
    CommandSender --> BoardManager : controller
    CommandSender --> GameRule : controller
    CommandSender : movePiece()
    CommandSender : passRound()
    CommandSender : giveUp()
    CommandSender : startNewGame()
    CommandSender : getBoardUpdate()
```