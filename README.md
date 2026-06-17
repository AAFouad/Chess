# Chess Game Implementation

A complete, fully-functional chess game library written in Java. This project provides a robust implementation of chess rules with support for FEN (Forsyth-Edwards Notation) notation, legal move generation, and an interactive command-line interface for playing chess against another human player.

## Features

- **Complete Chess Rules Implementation**: Full support for all standard chess rules including:
  - Piece movement validation for all piece types (Pawns, Knights, Bishops, Rooks, Queens, Kings)
  - En passant captures
  - Pawn promotion
  - Castling
  - Check and checkmate detection

- **FEN Notation Support**: Load any chess position using simplified FEN notation (position string + side to move character)

- **Legal Move Generation**: Generates and validates all legal moves for any position

- **Interactive CLI**: Command-line interface for two-player chess gameplay

- **ICCF Notation**: Supports ICCF numeric notation for move input and piece selection

## Getting Started

### Prerequisites

- Java 8 or higher
- IDE (IntelliJ IDEA recommended, as indicated by the `.iml` project file)

### Running the Application

This project includes both a test harness and a main entry point:

- **Interactive Game**: Run `Test.java` located in `src/test/java/` for the interactive chess interface
- **Main Entry Point**: `Main.java` is available in `src/main/java/chess/` but is not the primary entry point

### Usage

Launch the application using `Test.java`:

```bash
javac -d bin src/main/java/*/*.java src/test/java/*.java
java -cp bin test.java.Test
```

Once running, you'll be presented with options to:
1. Load a custom position using FEN notation
2. Start from the standard chess starting position

### Available Commands

| Command | Description |
|---------|-------------|
| `Render` | Display the current board state |
| `<ICCF Notation>` | Make a move (e.g., `1124` moves piece from square 11 to square 24) |
| `Moves for <index>` | Display all legal moves for a piece at the given ICCF index |
| `Exit` | Quit the application |

### FEN Format

This implementation uses a simplified FEN notation:
- **Position String**: Standard FEN position string (e.g., `rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR`)
- **Side to Move**: Single character (`w` for white, `b` for black)

Example:
```
rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w
```

### ICCF Notation

Moves are input using ICCF notation, where the board is numbered 11-88 (representing a1-h8):
- Row numbers: 1-8 (from bottom to top)
- Column numbers: 1-8 (from left to right)

Example: `1124` means moving a piece from a2 (12) to a4 (14)

## Project Structure

```
src/
├── main/java/
│   ├── board/        # Board representation and position management
│   ├── move/         # Move validation and legality checking
│   ├── pieces/       # Individual piece classes and logic
│   ├── utils/        # Utility functions
│   └── chess/        # Main application entry point
└── test/java/
    └── Test.java     # Interactive test harness (primary entry point)
```

## Implementation Highlights

- **Position Class**: Core class representing the chess board state
  - Parses FEN notation
  - Manages piece placement
  - Handles move execution and validation

- **Piece Classes**: Individual classes for each piece type
  - Implements piece-specific movement rules
  - Validates legal moves within the current position context

- **Move Validation**: Comprehensive move legality checking
  - Prevents illegal moves
  - Handles special moves (en passant, castling, promotion)

## Status

✅ **Project Status**: Complete and functional

## Potential Extensions

This library can be extended with additional features such as:
- Artificial intelligence for computer opponent
- Move history and undo functionality
- Game state analysis and position evaluation
- Graphical user interface (GUI)
- PGN (Portable Game Notation) support

## License

This project is provided as-is for educational and personal use.

## Author

Created by AAFouad

---

**Note**: This is a fully implemented chess game library suitable for learning chess programming concepts, game development, or as a foundation for more advanced chess applications.
