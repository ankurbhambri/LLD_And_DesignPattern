package TicTacToe__LLD;

// import com.sun.tools.javac.util.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// Simple generic Pair class since com.sun.tools.javac.util.Pair is not accessible
class Pair<K, V> {
    public final K first;
    public final V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
}

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    public TicTacToeGame() {
        initializeGame();
    }

    public void initializeGame(){

        // Creating 2 Players
        players = new LinkedList<>();
        XPiece crossPiece = new XPiece();
        Player player1 = new Player("Player1", crossPiece);

        OPiece noughtsPiece = new OPiece();
        Player player2 = new Player("Player2", noughtsPiece);

        players.add(player1);
        players.add(player2);

        // Initializing board
        gameBoard = new Board(3);
    }

    public String startGame(){

        boolean noWinner = true;
        try (Scanner inputScanner = new Scanner(System.in)) {

            while(noWinner){

                // Take out the player whose turn is and also put the player in the list back
                Player playerTurn = players.removeFirst();

            //get the free space from the board
            gameBoard.printBoard();
            List<Board.Pair<Integer, Integer>> freeSpaces =  gameBoard.getFreeCells();
            if(freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }

            // Read the user input
            System.out.print("Player: " + playerTurn.name + " Enter row, column: ");
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.parseInt(values[0]);
            int inputColumn = Integer.parseInt(values[1]);


            // place the piece
            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow,inputColumn, playerTurn.playerPiece);

            if(!pieceAddedSuccessfully) {
                //player can not insert the piece into this cell, player has to choose another cell
                System.out.println("Incorrect position, please try again !!");
                players.addFirst(playerTurn);
                continue;
            }

            players.addLast(playerTurn);

            boolean winner = isThereWinner(inputRow, inputColumn, playerTurn.playerPiece.pieceType);
            if(winner) {
                return playerTurn.name;
            }
        }

        return "tie";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred during the game.";
        }
    }

    public boolean isThereWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        // Need to check in row
        for(int i=0;i<gameBoard.size;i++) {

            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType) {
                rowMatch = false;
                break;
            }
        }

        // Need to check in column
        for(int i=0;i<gameBoard.size;i++) {

            if(gameBoard.board[i][column] == null || gameBoard.board[i][column].pieceType != pieceType) {
                columnMatch = false;
                break;
            }
        }

        // Need to check diagonals
        for(int i=0, j=0; i<gameBoard.size;i++,j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
                break;
            }
        }

        // Need to check anti-diagonals
        for(int i=0, j=gameBoard.size-1; i<gameBoard.size;i++,j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
                break;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}
