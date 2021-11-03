[
  {
    "name": "GameRule(use case)",
    "superclasses": "",
    "subclasses": "",
    "type": "Normal",
    "responsibilities": [
      "\\ Determining whether a player's behavior is in compliance with the rules."
      "board.Board board",
      "Map<String, Piece> piecesDict",
      "isMoveValid",
      "isPathClear",
      "isCoordinateVacant()",
      "isCoordinateValid()",
      "pieceInteraction()",
      "isPlayerWinning()",
      "getAvailableMoves()"
    ],
    "collaborators": [
      "board.Board; Piece"
    ]
  }
]