|player.Player (entity)||
|---|---|
|String ID <br> Color color <br> boolean status|Superclass: <br> Subclass: player.AI, human <br> Collaborators: board.Board|

|player.Human (entity)||
|---|---|
|String ID |Superclass: player.Player <br> Subclass: <br> Collaborators:|

|player.AI (entity)||
|---|---|
|String ID |Superclass: player.Player <br> Subclass: <br> Collaborators:|

|Piece (entity) <br> abstract ||
|---|---|
|String name <br> Color color <br> boolean status|Superclass: <br> Subclass: King, Queen, Rook, Bishop, Knight, Pawn <br> Collaborators: board.Board|
|getName() <br> getColor() <br> getStatus() <br> validMove() // follows piece specific rules

|King (entity)||
|---|---|
|String name <br> Color color <br> boolean status <br> hasMovedDuringGame // for castling <br> |Superclass: Piece <br> Subclass: <br> Collaborators: board.Board|
|validMove() // either one square any direction or castling

|Queen (entity)||
|---|---|
|String name <br> Color color <br> boolean status|Superclass: Piece <br> Subclass: <br> Collaborators: board.Board|
|validMove() // horizontal, vertical, diagonal line

|Rook (entity)||
|---|---|
|String name <br> Color color <br> boolean status <br> hasMovedDuringGame // for castling|Superclass: Piece <br> Subclass: <br> Collaborators: board.Board|
|validMove() // horizontal, vertical straight line

|Bishop (entity)||
|---|---|
|String name <br> Color color <br> boolean status|Superclass: Piece <br> Subclass: <br> Collaborators: board.Board|
|validMove() // diagonal straight line

|Knight (entity)||
|---|---|
|String name <br> Color color <br> boolean status|Superclass: Piece <br> Subclass: <br> Collaborators: board.Board|
|validMove() // L-shape move, can "jump" over pieces

|Pawn (entity)||
|---|---|
|String name <br> Color color <br> boolean status <br> hasNotMovedDuringGame // for optional 2 squares (sq) forward|Superclass: Piece <br> Subclass: <br> Collaborators: board.Board|
|validMove() // 1sq directly forward, optional 2sq directly forward if not yet moved, promotion if reach other end

|piece.ModifiedPiece (entity) <br> interface||
|---|---|
|int hp <br> int atk|Superclass: Piece <br> Subclass: <br> Collaborators: ModifiedBoard|
|getHp() <br> getAtk()

|board.Board (entity)||
|---|---|
|String[][] board // each cell contains piece name/id |Superclass: <br> Subclass: <br> Collaborators: Piece, board.BoardManager|
|addPiece() <br> removePiece() <br> isPositionVacant() <br> getPiece() // using coordinates <br> reset() // initializes piece names onto position

|ModifiedBoard (entity)||
|---|---|
|Responsibilities: //may add additional features|Superclass: board.Board <br> Subclass: <br> Collaborators: piece.ModifiedPiece|

|rule.GameRule (use case)||
|---|---|
|// Determine whether player's behavior is in compliance with the rules|Superclass: <br> Subclass: <br> Collaborators: Piece, board.Board|
|board.Board board <br> Map<String, Piece> piecesDict // key: ID, value: Piece
|isMoveValid() <br> isPathClear() <br> isCoordinateVacant() <br> isCoordinateValid() // within boundaries of the game <br> pieceInteraction() // deduct hp <br> isPlayerWinning() <br> getAvailableMoves()

|board.BoardManager (use case)||
|---|---|
|board.Board board <br> Map<String, Piece> pieces <br> player.Player p1 <br> player.Player p2 <br> player.Player activePlayer <br> board.GameStatus|Superclass: <br> Subclass: <br> Collaborators: Piece, board.Board|
|getActivePlayer() <br> movePiece() <br> deductPieceHp() <br> switchActivePlayer() <br> switchPieceStatus() <br> resetBoard()

|command.CommandSender (controller)||
|---|---|
|board.BoardManager <br> rule.GameRule|Superclass: <br> Subclass: <br> Collaborators: board.BoardManager, rule.GameRule|
|movePiece() <br> passRound() // forfeit turn <br> giveUp() <br> startNewGame() // initializes new board.BoardManager and new rule.GameRule <br> getBoardUpdate()

|UI (command line interface)||
|---|---|
|command.CommandSender cs|Superclass: <br> Subclass: <br> Collaborators: command.CommandSender|
