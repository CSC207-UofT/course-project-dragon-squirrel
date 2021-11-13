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
    
    
    Piece <-- King : implement
    Piece <-- Queen : implement
    Piece <-- Rook : implement
    Piece <-- Bishop : implement
    Piece <-- Knight : implement
    Piece <-- Pawn : implement
    
    Piece : String name
    Piece : Color color
    Piece : boolean status
    Piece : getName()
    Piece : getColor()
    Piece : getStatus()
    Piece : validMove()
    
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
    
    ModifiedPiece --> Piece
    ModifiedPiece : int hp
    ModifiedPiece : int atk
    ModifiedPiece : getHp()
    ModifiedPiece : getAtk()
    
    
    Board <--> Piece : Collaborators
    Board : String [][] board
    Board : addPiece()
    Board : removePiece()
    Board : isPositionVacant()
    Board : getPiece()
    Board : reset()
    
    ModifiedBoard --> Board : implement
    
    
    GameRule --> Piece : collaborator
    GameRule --> Board : collaborator
    GameRule : Board board
    GameRule : Map<String, Piece> piecesDict 
    GameRule : isMoveValid()
    GameRule : isPathClear()
    GameRule : isCoordinateVacant()
    GameRule : isCoordinateValid()
    GameRule : pieceInteraction()
    GameRule : isPlayerWinning()
    GameRule : getAvailableMoves()
    
    BoardManager --> Piece : Collaborator
    BoardManager <--> Board : Collaborator
    BoardManager : Board board
    BoardManager : Map<String, Piece> pieces
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