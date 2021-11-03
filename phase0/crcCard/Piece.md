[
  {
    "name": "Piece(entity)",
    "superclasses": "",
    "subclasses": "King; Queen; Rook; Bishop; Knight; Pawn;",
    "type": "abstract",
    "responsibilities": [
      "\\Define how chesspiece move",
      "String name",
      "Color color",
      "boolean status",
      "getName()",
      "getColor()",
      "getStatus()",
      "boolean ValidMove()"
    ],
    "collaborators": [
      "board.Board"
    ]
  }
]