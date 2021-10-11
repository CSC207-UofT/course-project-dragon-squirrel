[
  {
    "name": "Player(entity)",
    "superclasses": "",
    "subclasses": "AI; human",
    "type": "Normal",
    "responsibilities": [
      " \\Create a new player",
      "String name",
      "int ID"
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