## Class Diagram

Using Mermaid v8.9.1


Class Diagram (Chess Game):
```mermaid
classDiagram
    player.Player <-- player.Human : implement
    player.Player <-- player.AI : implement
    
    player.Player : String ID
    player.Player : Color color
    player.Player : boolean status
    
    player.Human : String ID
    
    player.AI : String ID
    
    
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
    
    
    board.Board <--> Piece : Collaborators
    board.Board : String [][] board
    board.Board : addPiece()
    board.Board : removePiece()
    board.Board : isPositionVacant()
    board.Board : getPiece()
    board.Board : reset()
    
    ModifiedBoard --> board.Board : implement
    
    
    rule.GameRule --> Piece : collaborator
    rule.GameRule --> board.Board : collaborator
    rule.GameRule : board.Board board
    rule.GameRule : Map<String, Piece> piecesDict 
    rule.GameRule : isMoveValid()
    rule.GameRule : isPathClear()
    rule.GameRule : isCoordinateVacant()
    rule.GameRule : isCoordinateValid()
    rule.GameRule : pieceInteraction()
    rule.GameRule : isPlayerWinning()
    rule.GameRule : getAvailableMoves()
    
    board.BoardManager --> Piece : Collaborator
    board.BoardManager <--> board.Board : Collaborator
    board.BoardManager : board.Board board
    board.BoardManager : Map<String, Piece> pieces
    board.BoardManager : player.Player p1
    board.BoardManager : player.Player p2
    board.BoardManager : player.Player activePlayer
    board.BoardManager : board.GameStatus
    board.BoardManager : getActivePlayer()
    board.BoardManager : movePiece()
    board.BoardManager : deductPieceHp()
    board.BoardManager : switchActivePlayer()
    board.BoardManager : switchPieceStatus()
    board.BoardManager : resetBoard()
    
    
    command.CommandSender --> board.BoardManager : controller
    command.CommandSender --> rule.GameRule : controller
    command.CommandSender : movePiece()
    command.CommandSender : passRound()
    command.CommandSender : giveUp()
    command.CommandSender : startNewGame()
    command.CommandSender : getBoardUpdate()
```