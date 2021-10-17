[
  {
    "name": "Player(entity)",
    "superclasses": "",
    "subclasses": "AI; human",
    "type": "Normal",
    "responsibilities": [
      " \\Create a new player",
      "String ID",
    ],
    "collaborators": [
      "Board"
    ]
  },
  {
    "name": "Piece(entity)",
    "superclasses": "",
    "subclasses": "King; Queen; Rook; Bishop; Knight; Pawn;",
    "type": "interface",
    "responsibilities": [
      "\\Define how chesspiece move"
      "boolean isValidMove()"
    ],
    "collaborators": [
      ""
    ]
  },
  {
    "name": "King(entity)",
    "superclasses": "Piece",
    "subclasses": "",
    "type": "Normal",
    "responsibilities": [
      "\\Create new King"
      "Player player",
      "isValidMove()"
    ],
    "collaborators": [
      "Board"
    ]
  },
  {
    "name": "Queen(entity)",
    "superclasses": "Piece",
    "subclasses": "",
    "type": "Normal",
    "responsibilities": [
      "\\Create new Queen"
      "Player player",
      "isValidMove()"
    ],
    "collaborators": [
      "Board"
    ]
  },
  {
    "name": "Rook(entity)",
    "superclasses": "Piece",
    "subclasses": "",
    "type": "Normal",
    "responsibilities": [
      "\\Create new Rook"
      "Player player",
      "isValidMove()"
    ],
    "collaborators": [
      "Board"
    ]
  },
  {
    "name": "Bishop(entity)",
    "superclasses": "Piece",
    "subclasses": "",
    "type": "Normal",
    "responsibilities": [
      "\\Create new Bishop"
      "Player player",
      "isValidMove()"
    ],
    "collaborators": [
      "Board"
    ]
  },
  {
    "name": "Knight(entity)",
    "superclasses": "Piece",
    "subclasses": "",
    "type": "Normal",
    "responsibilities": [
      "\\Create new Bishop"
      "Player player",
      "isValidMove()"
    ],
    "collaborators": [
      "Board"
    ]
  },
  {
    "name": "Pawn(entity)",
    "superclasses": "Piece",
    "subclasses": "",
    "type": "Normal",
    "responsibilities": [
      "\\Create new Pawn"
      "Player player",
      "isValidMove()"
    ],
    "collaborators": [
      "Board"
    ]
  },
  {
    "name": "ModifiedPiece(entity)",
    "superclasses": "Piece",
    "subclasses": "",
    "type": "Normal",
    "responsibilities": [
      "\\ We have not decided on rules yet."
    ],
    "collaborators": [
      "ModifiedBoard"
    ]
  },
  {
    "name": "Board(use case)",
    "superclasses": "",
    "subclasses": "",
    "type": "Abstract",
    "responsibilities": [
      "\\Create a new Chess Board when playing a new game.",
      "Player p"Normal"",
      "Player p2",
      "Player currentPlayer",
      "Piece[][] board",
      "abstract addPiece()",
      "abstract removePiece()",
      "abstract Board()",
      ""
    ],
    "collaborators": [
      "ChessPiece; BoardManager"
    ]
  },
  {
    "name": "OrignialBoard(use case)",
    "superclasses": "Board",
    "subclasses": "",
    "type": "Normal",
    "responsibilities": [
      "Player p1",
      "Player p2",
      "Player currentPlayer",
      "Piece[][] board",
      "boolean isGameEnd()",
      ""
    ],
    "collaborators": [
      "ChessPiece; BoardManager"
    ]
  },
  {
    "name": "ModifiedBoard(use case)",
    "superclasses": "Board",
    "subclasses": "",
    "type": "Normal",
    "responsibilities": [
      "\\ We have not decided on rules yet."
    ],
    "collaborators": [
      ""
    ]
  },
  {
    "name": "GameRule(use case)",
    "superclasses": "",
    "subclasses": "",
    "type": "Normal",
    "responsibilities": [
      "\\ Determining whether a player's behavior is in compliance with the rules."
    ],
    "collaborators": [
      "Board; Piece"
    ]
  },
  {
    "name": "BoardManager(controller & presenter)",
    "superclasses": "",
    "subclasses": "",
    "type": "Normal",
    "responsibilities": [
      "\\\\ control the board and update the information about UI",
      "void movePiece()",
      "getBoardUpdate()"
    ],
    "collaborators": [
      "UI; Board"
    ]
  },
  {
    "name": "UI(UI)",
    "superclasses": "",
    "subclasses": "",
    "type": "Normal",
    "responsibilities": [
      "\\ We have not figured out how to make UI yet."
    ],
    "collaborators": [
      "BoardManager"
    ]
  }
]

|Player (entity)||
|---|---|
|String ID <br> Color color <br> boolean status|Superclass: <br> Subclass: AI, human <br> Collaborators: Board|

|Human (entity)||
|---|---|
|String ID |Superclass: Player <br> Subclass: <br> Collaborators:|

|AI (entity)||
|---|---|
|String ID |Superclass: Player <br> Subclass: <br> Collaborators:|

|Piece (entity) <br> abstract ||
|---|---|
|String name <br> Color color <br> boolean status|Superclass: <br> Subclass: King, Queen, Rook, Bishop, Knight, Pawn <br> Collaborators: Board|
|getName() <br> getColor() <br> getStatus() <br> validMove() // follows piece specific rules

|King (entity)||
|---|---|
|String name <br> Color color <br> boolean status <br> hasMovedDuringGame // for castling <br> |Superclass: Piece <br> Subclass: <br> Collaborators: Board|
|validMove() // either one square any direction or castling

|Queen (entity)||
|---|---|
|String name <br> Color color <br> boolean status|Superclass: Piece <br> Subclass: <br> Collaborators: Board|
|validMove() // horizontal, vertical, diagonal line

|Rook (entity)||
|---|---|
|String name <br> Color color <br> boolean status <br> hasMovedDuringGame // for castling|Superclass: Piece <br> Subclass: <br> Collaborators: Board|
|validMove() // horizontal, vertical straight line

|Bishop (entity)||
|---|---|
|String name <br> Color color <br> boolean status|Superclass: Piece <br> Subclass: <br> Collaborators: Board|
|validMove() // diagonal straight line

|Knight (entity)||
|---|---|
|String name <br> Color color <br> boolean status|Superclass: Piece <br> Subclass: <br> Collaborators: Board|
|validMove() // L-shape move, can "jump" over pieces

|Pawn (entity)||
|---|---|
|String name <br> Color color <br> boolean status <br> hasNotMovedDuringGame // for optional 2 squares (sq) forward|Superclass: Piece <br> Subclass: <br> Collaborators: Board|
|validMove() // 1sq directly forward, optional 2sq directly forward if not yet moved, promotion if reach other end

|ModifiedPiece (entity) <br> interface||
|---|---|
|int hp <br> int atk|Superclass: Piece <br> Subclass: <br> Collaborators: ModifiedBoard|
|getHp() <br> getAtk()

|Board (entity)||
|---|---|
|String[][] board // each cell contains piece name/id |Superclass: <br> Subclass: <br> Collaborators: Piece, BoardManager|
|addPiece() <br> removePiece() <br> isPositionVacant() <br> getPiece() // using coordinates <br> reset() // initializes piece names onto position

|ModifiedBoard (entity)||
|---|---|
|Responsibilities: //may add additional features|Superclass: Board <br> Subclass: <br> Collaborators: ModifiedPiece|

|GameRule (use case)||
|---|---|
|// Determine whether player's behavior is in compliance with the rules|Superclass: <br> Subclass: <br> Collaborators: Piece, Board|
|Board board <br> Map<String, Piece> piecesDict // key: ID, value: Piece
|isMoveValid() <br> isPathClear() <br> isCoordinateVacant() <br> isCoordinateValid() // within boundaries of the game <br> pieceInteraction() // deduct hp <br> isPlayerWinning() <br> getAvailableMoves()

|BoardManager (use case)||
|---|---|
|Board board <br> Map<String, Piece> pieces <br> Player p1 <br> Player p2 <br> Player activePlayer <br> GameStatus|Superclass: <br> Subclass: <br> Collaborators: Piece, Board|
|getActivePlayer() <br> movePiece() <br> deductPieceHp() <br> switchActivePlayer() <br> switchPieceStatus() <br> resetBoard()

|CommandSender (controller)||
|---|---|
|BoardManager <br> GameRule|Superclass: <br> Subclass: <br> Collaborators: BoardManager, GameRule|
|movePiece() <br> passRound() // forfeit turn <br> giveUp() <br> startNewGame() // initializes new BoardManager and new GameRule <br> getBoardUpdate()

|UI (command line interface)||
|---|---|
|CommandSender cs|Superclass: <br> Subclass: <br> Collaborators: CommandSender|