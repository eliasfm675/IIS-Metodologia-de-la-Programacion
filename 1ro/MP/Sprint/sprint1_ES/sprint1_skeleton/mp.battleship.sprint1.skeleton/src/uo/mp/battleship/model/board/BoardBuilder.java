package uo.mp.battleship.model.board;

import java.util.ArrayList;
import java.util.List;

class BoardBuilder {
    private static final int MIN_GRID_SIZE = 10;
    private static final int MAX_GRID_SIZE = 20;
    private static final int NUM_SUBMARINES = 4;
    private static final int NUM_DESTROYERS = 3;
    private static final int NUM_CRUISERS = 2;
    private static final int NUM_BATTLESHIPS = 1;

    static Square[][] build(int size) {
        if (size < MIN_GRID_SIZE || size > MAX_GRID_SIZE) {
            throw new IllegalArgumentException("Invalid board size");
        }

        Square[][] board = new Square[size][size];
        initializeBoard(board);
        placeShips(board);

        return board;
    }

    private static void initializeBoard(Square[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Square(new Water());
            }
        }
    }

    private static void placeShips(Square[][] board) {
        List<Ship> fleet = createFleet();
        List<Ship> submarines = new ArrayList<>();
        List<Ship> destroyers = new ArrayList<>();
        List<Ship> cruisers = new ArrayList<>();
        List<Ship> battleships = new ArrayList<>();

        for (Ship ship : fleet) {
            if (ship.size() == 1) {
                submarines.add(ship);
            } else if (ship.size() == 2) {
                destroyers.add(ship);
            } else if (ship.size() == 3) {
                cruisers.add(ship);
            } else if (ship.size() == 4) {
                battleships.add(ship);
            }
        }

        placeShipsOfType(board, submarines);
        placeShipsOfType(board, destroyers);
        placeShipsOfType(board, cruisers);
        placeShipsOfType(board, battleships);
    }

    private static List<Ship> createFleet() {
        List<Ship> fleet = new ArrayList<>();
        for (int i = 0; i < NUM_SUBMARINES; i++) {
            fleet.add(new Ship(1));
        }
        for (int i = 0; i < NUM_DESTROYERS; i++) {
            fleet.add(new Ship(2));
        }
        for (int i = 0; i < NUM_CRUISERS; i++) {
            fleet.add(new Ship(3));
        }
        for (int i = 0; i < NUM_BATTLESHIPS; i++) {
            fleet.add(new Ship(4));
        }
        return fleet;
    }

    private static void placeShipsOfType(Square[][] board, List<Ship> ships) {
        for (Ship ship : ships) {
            boolean placed = false;
            while (!placed) {
                int row = (int) (Math.random() * board.length);
                int col = (int) (Math.random() * board[0].length);
                boolean horizontal = Math.random() < 0.5;

                if (canPlaceShip(board, ship, row, col, horizontal)) {
                    placeShip(board, ship, row, col, horizontal);
                    placed = true;
                }
            }
        }
    }

    private static boolean canPlaceShip(Square[][] board, Ship ship, int row, int col, boolean horizontal) {
        int length = ship.size();
        int endRow = row + (horizontal ? 0 : length - 1);
        int endCol = col + (horizontal ? length - 1 : 0);

        if (endRow >= board.length || endCol >= board[0].length) {
            return false;
        }

        for (int i = row; i <= endRow; i++) {
            for (int j = col; j <= endCol; j++) {
                if (!board[i][j].hasContent()) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void placeShip(Square[][] board, Ship ship, int row, int col, boolean horizontal) {
        int length = ship.size();
        for (int i = 0; i < length; i++) {
            if (horizontal) {
                board[row][col + i].setContent(ship);
            } else {
                board[row + i][col].setContent(ship);
            }
        }
    }
}
