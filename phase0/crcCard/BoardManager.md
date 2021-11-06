[
  {
    "name": "board.BoardManager(use case)",
    "superclasses": "",
    "subclasses": "",
    "type": "Normal",
    "responsibilities": [
      "\\\\ control the board",
      "board.Board board",
      "Map<String, Piece> piecesDict",
      "player.Player p1",
      "player.Player p2",
      "player.Player activePlayer",
      "board.GameStatus",
      "getActivePlayer()","
      "void movePiece()",
      "deductPieceHp()",
      "switchActivePlayer()",
      "switchPieceStatus()",
      "resetBoard()"
    ],
    "collaborators": [
      "Pieces; board.Board"
    ]
  }
]