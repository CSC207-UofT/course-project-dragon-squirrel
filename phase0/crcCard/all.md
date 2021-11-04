|Player.Player (entity)||
|---|---|
|String ID <br> Color color <br> boolean status|Superclass: <br> Subclass: Player.AI, human <br> Collaborators: Board.Board|

|Player.Human (entity)||
|---|---|
|String ID |Superclass: Player.Player <br> Subclass: <br> Collaborators:|

|Player.AI (entity)||
|---|---|
|String ID |Superclass: Player.Player <br> Subclass: <br> Collaborators:|

|Piece (entity) <br> abstract ||
|---|---|
|String name <br> Color color <br> boolean status|Superclass: <br> Subclass: King, Queen, Rook, Bishop, Knight, Pawn <br> Collaborators: Board.Board|
|getName() <br> getColor() <br> getStatus() <br> validMove() // follows piece specific rules

|King (entity)||
|---|---|
|String name <br> Color color <br> boolean status <br> hasMovedDuringGame // for castling <br> |Superclass: Piece <br> Subclass: <br> Collaborators: Board.Board|
|validMove() // either one square any direction or castling

|Queen (entity)||
|---|---|
|String name <br> Color color <br> boolean status|Superclass: Piece <br> Subclass: <br> Collaborators: Board.Board|
|validMove() // horizontal, vertical, diagonal line

|Rook (entity)||
|---|---|
|String name <br> Color color <br> boolean status <br> hasMovedDuringGame // for castling|Superclass: Piece <br> Subclass: <br> Collaborators: Board.Board|
|validMove() // horizontal, vertical straight line

|Bishop (entity)||
|---|---|
|String name <br> Color color <br> boolean status|Superclass: Piece <br> Subclass: <br> Collaborators: Board.Board|
|validMove() // diagonal straight line

|Knight (entity)||
|---|---|
|String name <br> Color color <br> boolean status|Superclass: Piece <br> Subclass: <br> Collaborators: Board.Board|
|validMove() // L-shape move, can "jump" over pieces

|Pawn (entity)||
|---|---|
|String name <br> Color color <br> boolean status <br> hasNotMovedDuringGame // for optional 2 squares (sq) forward|Superclass: Piece <br> Subclass: <br> Collaborators: Board.Board|
|validMove() // 1sq directly forward, optional 2sq directly forward if not yet moved, promotion if reach other end

|piece.ModifiedPiece (entity) <br> interface||
|---|---|
|int hp <br> int atk|Superclass: Piece <br> Subclass: <br> Collaborators: ModifiedBoard|
|getHp() <br> getAtk()

|Board.Board (entity)||
|---|---|
|String[][] board // each cell contains piece name/id |Superclass: <br> Subclass: <br> Collaborators: Piece, BoardManager.BoardManager|
|addPiece() <br> removePiece() <br> isPositionVacant() <br> getPiece() // using coordinates <br> reset() // initializes piece names onto position

|ModifiedBoard (entity)||
|---|---|
|Responsibilities: //may add additional features|Superclass: Board.Board <br> Subclass: <br> Collaborators: piece.ModifiedPiece|

|GameRule.GameRule (use case)||
|---|---|
|// Determine whether player's behavior is in compliance with the rules|Superclass: <br> Subclass: <br> Collaborators: Piece, Board.Board|
|Board.Board board <br> Map<String, Piece> piecesDict // key: ID, value: Piece
|isMoveValid() <br> isPathClear() <br> isCoordinateVacant() <br> isCoordinateValid() // within boundaries of the game <br> pieceInteraction() // deduct hp <br> isPlayerWinning() <br> getAvailableMoves()

|BoardManager.BoardManager (use case)||
|---|---|
|Board.Board board <br> Map<String, Piece> pieces <br> Player.Player p1 <br> Player.Player p2 <br> Player.Player activePlayer <br> GameStatus|Superclass: <br> Subclass: <br> Collaborators: Piece, Board.Board|
|getActivePlayer() <br> movePiece() <br> deductPieceHp() <br> switchActivePlayer() <br> switchPieceStatus() <br> resetBoard()

|Controller.CommandSender (controller)||
|---|---|
|BoardManager.BoardManager <br> GameRule.GameRule|Superclass: <br> Subclass: <br> Collaborators: BoardManager.BoardManager, GameRule.GameRule|
|movePiece() <br> passRound() // forfeit turn <br> giveUp() <br> startNewGame() // initializes new BoardManager.BoardManager and new GameRule.GameRule <br> getBoardUpdate()

|UI (command line interface)||
|---|---|
|Controller.CommandSender cs|Superclass: <br> Subclass: <br> Collaborators: Controller.CommandSender|
