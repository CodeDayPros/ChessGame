import java.util.List;
import java.util.ArrayList;
import java.awt.*;

public class LevelGenerator
{
    private int currentLevel;
    private Board board;
    private ArrayList<Level> levelsList;

    public LevelGenerator()
    {
        currentLevel = 0;
        levelsList = new ArrayList<Level>();
        // level 1
        levelsList.add(new Level()
            {
                public void generate(List<Piece> pieces, List<Point> finalLocations, int[][] positions)
                {
                    pieces.add(new Knight(2, 0));
                    finalLocations.add(new Point(1, 2));
                    positions[4][1] = 1;
                    positions[6][0] = 1;
                    positions[7][1] = 1;
                    positions[5][2] = 1;
                    positions[6][3]=1;
                    positions[3][3]=1;
                    positions[4][4]=1;
                    positions[2][5]=1;
                    positions[1][2]=1;
                }
            });
        levelsList.add(new Level()
            {
                public void generate(List<Piece> pieces, List<Point> finalLocations, int[][] positions)
                {
                    pieces.add(new Rook(6,5));
                    finalLocations.add(new Point(2,7));
                    positions[2][7]=1;
                    positions[0][0]=1;
                    positions[0][2]=1;
                    positions[3][0]=1;
                    positions[3][2]=1;
                    positions[3][5]=1;
                    positions[3][7]=1;
                    positions[6][7]=1;
                }
            });
        levelsList.add(new Level()
            {
                public void generate(List<Piece> pieces, List<Point> finalLocations, int[][] positions)
                {
                    pieces.add(new Bishop(2,5));
                    finalLocations.add(new Point(2,1));
                    positions[3][0]=1;
                    positions[2][1]=1;
                    positions[5][2]=1;
                    positions[0][3]=1;
                    positions[4][3]=1;
                    positions[3][6]=1;
                    positions[6][5]=1;
                    positions[3][6]=1;
                    positions[4][7]=1;
                }
            });
        levelsList.add(new Level()
            {
                public void generate(List<Piece> pieces, List<Point> finalLocations, int[][] positions)
                {
                    pieces.add(new Queen(5,6));
                    finalLocations.add(new Point(1,1));
                    positions[1][1]=1;
                    positions[2][3]=1;
                    positions[2][6]=1;
                    positions[4][1]=1;
                    positions[5][3]=1;
                }
            });
        levelsList.add(new Level()
            {
                public void generate(List<Piece> pieces, List<Point> finalLocations, int[][] positions)
                {
                    pieces.add(new King(2,1));
                    finalLocations.add(new Point(0,7));
                    positions[0][7]=1;
                    positions[1][2]=1;
                    positions[2][2]=1;
                    positions[3][2]=1;
                    positions[2][3]=1;
                    positions[3][3]=1;
                    positions[1][5]=1;
                    positions[2][5]=1;
                    positions[1][6]=1;
                    positions[2][4]=1; 
                }
            });

        // level 6
        levelsList.add(new Level()
            {
                public void generate(List<Piece> pieces, List<Point> finalLocations, int[][] positions)
                {
                    pieces.add(new Rook(2,7));
                    pieces.add(new Bishop(4,3));
                    finalLocations.add(new Point(0,3));
                    finalLocations.add(new Point(4,7));
                    positions[0][3]=1;
                    positions[2][1]=1;
                    positions[2][5]=1;
                    positions[4][7]=1;
                    positions[5][3]=1;
                    positions[5][5]=1;
                    positions[6][5]=1;
                }
            });
        levelsList.add(new Level()
            {
                public void generate(List<Piece> pieces, List<Point> finalLocations, int[][] positions)
                {
                    pieces.add(new Knight(1,1));
                    pieces.add(new Bishop(4,7));
                    finalLocations.add(new Point(3,2));
                    finalLocations.add(new Point(6,5));
                    positions[5][0]=1;
                    positions[6][1]=1;
                    positions[6][3]=1;
                    positions[3][2]=1;
                    positions[2][3]=1;
                    positions[4][4]=1;
                    positions[2][5]=1;
                    positions[4][2]=1;
                    positions[6][5]=1;
                }
            });
        levelsList.add(new Level()
            {
                public void generate(List<Piece> pieces, List<Point> finalLocations, int[][] positions)
                {
                    pieces.add(new Bishop(1,7));
                    pieces.add(new Knight(6,3));
                    finalLocations.add(new Point(5,3));
                    finalLocations.add(new Point(1,5));
                    positions[5][3]=1;
                    positions[1][5]=1;
                    positions[5][1]=1;
                    positions[3][2]=1;
                    positions[3][3]=1;
                    positions[7][2]=1;
                    positions[4][4]=1;
                    positions[5][5]=1;
                    positions[0][6]=1;
                    positions[3][7]=1;
                }
            });
        levelsList.add(new Level()
            {
                public void generate(List<Piece> pieces, List<Point> finalLocations, int[][] positions)
                {
                    pieces.add(new Bishop(6,7));
                    pieces.add(new Queen(1,2));
                    finalLocations.add(new Point(2,6));
                    finalLocations.add(new Point(7,2));
                    positions[5][6]=1;
                    positions[2][3]=1;
                    positions[5][3]=1;
                    positions[2][6]=1;
                    positions[7][2]=1;
                    positions[0][1]=1;
                    positions[1][0]=1;
                    positions[5][4]=1;
                }
            });
        levelsList.add(new Level()
            {
                public void generate(List<Piece> pieces, List<Point> finalLocations, int[][] positions)
                {
                    pieces.add(new Knight(4,4));
                    pieces.add(new Queen(0,6));
                    finalLocations.add(new Point(6,1));
                    finalLocations.add(new Point(3,3));
                    positions[3][2]=1;
                    positions[5][2]=1;
                    positions[6][1]=1;
                    positions[1][5]=1;
                    positions[3][3]=1;
                    positions[1][3]=1;
                    positions[4][0]=2;
                }
            });
        // level 11
        levelsList.add(new Level()
            {
                public void generate(List<Piece> pieces, List<Point> finalLocations, int[][] positions)
                {
                    pieces.add(new Rook(3,3));
                    pieces.add(new Knight(4,3));
                    finalLocations.add(new Point(5,1));
                    finalLocations.add(new Point(5,6));
                    positions[5][1]=1;
                    positions[5][6]=1;
                    positions[2][3]=1;
                    positions[3][1]=1;
                    positions[3][4]=1;
                    positions[3][5]=1;
                    positions[6][1]=1;
                    positions[6][4]=1;
                }
            });
        levelsList.add(new Level()
            {
                public void generate(List<Piece> pieces, List<Point> finalLocations, int[][] positions)
                {
                    pieces.add(new Rook(3,4));
                    pieces.add(new Bishop(6,6));
                    pieces.add(new Queen(2,0));
                    finalLocations.add(new Point(1,6));
                    finalLocations.add(new Point(1,1));
                    finalLocations.add(new Point(6,2));
                    positions[1][6]=1;
                    positions[7][5]=1;
                    positions[7][7]=1;
                    positions[3][3]=1;
                    positions[0][6]=1;
                    positions[1][7]=1;
                    positions[1][1]=1;
                    positions[6][2]=1;
                    positions[3][2]=1;
                    positions[1][2]=1;
                }
            });
        levelsList.add(new Level()
            {
                public void generate(List<Piece> pieces, List<Point> finalLocations, int[][] positions)
                {
                    pieces.add(new Knight(3,4));
                    pieces.add(new Rook(1,5));
                    pieces.add(new Bishop(5,2));
                    finalLocations.add(new Point(2,2));
                    finalLocations.add(new Point(6,7));
                    finalLocations.add(new Point(1,7));
                    positions[2][2]=1;
                    positions[6][7]=1;
                    positions[1][7]=1;
                    positions[3][2]=1;
                    positions[7][4]=1;
                    positions[3][5]=1;
                    positions[3][6]=1;
                    positions[3][7]=1;
                    positions[5][5]=1;
                    positions[5][6]=1;
                }
            });
        levelsList.add(new Level()
            {  
                public void generate(List<Piece> pieces, List<Point> finalLocations, int[][] positions) 
                {
                    pieces.add(new Knight(1,3));
                    pieces.add(new Knight(1,4));
                    pieces.add(new Rook(3,7));
                    finalLocations.add(new Point(5,7));
                    finalLocations.add(new Point(6,0));
                    finalLocations.add(new Point(2,0));
                    positions[3][4]=1;
                    positions[3][3]=1;
                    positions[5][3]=2;
                    positions[5][7]=1;
                    positions[4][1]=1;
                    positions[6][0]=1;
                    positions[5][5]=1;
                    positions[2][0]=1;
                    positions[0][1]=1;
                    positions[6][5]=2;
                    positions[2][2]=2;
                } 
            });
        levelsList.add(new Level()
            {  
                public void generate(List<Piece> pieces, List<Point> finalLocations, int[][] positions) 
                {
                    pieces.add(new Knight(0,7));
                    pieces.add(new Queen(5,1));
                    pieces.add(new Queen(6,7));
                    finalLocations.add(new Point(4,0));
                    finalLocations.add(new Point(7,2));
                    finalLocations.add(new Point(3,7));
                    positions[6][1]=1;
                    positions[1][5]=1;
                    positions[2][6]=1;
                    positions[4][5]=1;
                    positions[3][4]=1;
                    positions[5][3]=1;
                    positions[6][4]=1;
                    positions[4][0]=1;
                    positions[7][2]=1;
                    positions[3][1]=1;
                    positions[3][7]=1;
                } 
            });
        // level 16
        levelsList.add(new Level()
            {
                public void generate(List<Piece> pieces, List<Point> finalLocations, int[][] positions)
                {
                    pieces.add(new Bishop(4,4));
                    pieces.add(new Knight(2,6));
                    pieces.add(new Knight(6,2));
                    finalLocations.add(new Point(2,6));
                    finalLocations.add(new Point(4,4));
                    finalLocations.add(new Point(6,2));
                    positions[2][6]=1;
                    positions[4][4]=1;
                    positions[6][2]=1;
                    positions[1][7]=1;
                    positions[3][3]=1;
                    positions[4][1]=1;
                    positions[4][5]=2;
                    positions[4][7]=1;
                    positions[5][3]=1;
                    positions[5][6]=1;
                    positions[6][6]=1;
                    positions[7][1]=1;
                    positions[6][5]=1;
                    positions[7][7]=1;
                }
            });
           levelsList.add(new Level()
            {
                public void generate(List<Piece> pieces, List<Point> finalLocations, int[][] positions)
                {
                    pieces.add(new Knight(5,2));
                    pieces.add(new Bishop(1,1));
                    pieces.add(new Bishop(1,4));
                    pieces.add(new Queen(4,6));
                    finalLocations.add(new Point(2,2));
                    finalLocations.add(new Point(4,3));
                    finalLocations.add(new Point(6,5));
                    finalLocations.add(new Point(2,6));
                    positions[2][1]=1;
                    positions[0][2]=1;
                    positions[3][2]=1;
                    positions[3][3]=2;
                    positions[2][4]=2;
                    positions[4][5]=1;
                    positions[2][2]=1;
                    positions[4][3]=1;
                    positions[6][5]=1;
                    positions[2][6]=1;
                }
            });

        levelsList.add(new Level()
            {
                public void generate(List<Piece> pieces, List<Point> finalLocations, int[][] positions)
                {
                    pieces.add(new Rook(1,1));
                    pieces.add(new Knight(5,2));
                    pieces.add(new Knight(5,3));
                    pieces.add(new Bishop(5,7));
                    finalLocations.add(new Point(3,3));
                    finalLocations.add(new Point(6,1));
                    finalLocations.add(new Point(1,5));
                    finalLocations.add(new Point(3,5));
                    positions[3][5]=1;
                    positions[1][5]=1;
                    positions[6][1]=1;
                    positions[3][3]=1;
                    positions[3][1]=1;
                    positions[4][1]=1;
                    positions[1][2]=1;
                    positions[2][3]=1;
                    positions[3][4]=1;
                    positions[4][4]=1;
                    positions[4][5]=1;
                    positions[6][5]=1;
                }
            });
        levelsList.add(new Level()
            {
                public void generate(List<Piece> pieces, List<Point> finalLocations, int[][] positions)
                {
                    pieces.add(new King(7,3));
                    pieces.add(new King(0,4));
                    pieces.add(new Knight(4,0));
                    pieces.add(new Bishop(1,6));
                    finalLocations.add(new Point(1,4));
                    finalLocations.add(new Point(4,7));
                    finalLocations.add(new Point(4,1));
                    finalLocations.add(new Point(6,3));
                    positions[2][4]=1;
                    positions[3][4]=1;
                    positions[4][4]=1;
                    positions[5][4]=1;
                    positions[6][4]=1;
                    positions[1][4]=1;
                    positions[7][4]=1;
                    positions[5][5]=1;
                    positions[6][5]=1;
                    positions[7][5]=1;
                    positions[4][5]=1;
                    positions[3][5]=1;
                    positions[2][5]=1;
                    positions[1][5]=1;
                    positions[0][5]=1;
                    positions[0][3]=1;
                    positions[1][3]=1;
                    positions[2][3]=1;
                    positions[3][3]=1;
                    positions[4][3]=1;
                    positions[5][3]=1;
                    positions[6][3]=1;
                    positions[7][2]=1;
                    positions[6][2]=1;
                    positions[5][2]=1;
                    positions[4][2]=1;
                    positions[3][2]=1;
                    positions[2][2]=1;
                    positions[1][2]=1;
                    positions[0][2]=1;
                    positions[4][7]=1;
                    positions[4][1]=1;
                    positions[2][1]=2;
                    positions[5][6]=2;
                }
            });
        levelsList.add(new Level()
            {
                public void generate(List<Piece> pieces, List<Point> finalLocations, int[][] positions)
                {
                    pieces.add(new King(3,3));
                    pieces.add(new Rook(2,7));
                    pieces.add(new Knight(2,1));
                    pieces.add(new Knight(6,1));
                    pieces.add(new Bishop(0,5));
                    finalLocations.add(new Point(3,3));
                    finalLocations.add(new Point(3,2));
                    finalLocations.add(new Point(2,3));
                    finalLocations.add(new Point(4,3));
                    finalLocations.add(new Point(3,4));
                    positions[4][2]=2;
                    positions[5][2]=2;
                    positions[5][4]=2;
                    positions[2][4]=1;
                    positions[3][4]=1;
                    positions[1][6]=1;
                    positions[4][6]=1;
                    positions[5][7]=1;
                    positions[3][3]=1;
                    positions[3][2]=1;
                    positions[2][3]=1;
                    positions[4][3]=1;
                    positions[3][4]=1;
                }
            });
        levelsList.add(new Level()
            {
                public void generate(List<Piece> pieces, List<Point> finalLocations, int[][] positions)
                {
                    pieces.add(new Rook(2,1));
                    pieces.add(new Knight(5,3));
                    pieces.add(new Bishop(6,1));
                    pieces.add(new King(3,4));
                    pieces.add(new Queen(6,7));
                    finalLocations.add(new Point(5,0));
                    finalLocations.add(new Point(2,3));
                    finalLocations.add(new Point(6,3));
                    finalLocations.add(new Point(1,6));
                    finalLocations.add(new Point(6,5));
                    positions[5][0]=1;
                    positions[2][3]=1;
                    positions[6][3]=1;
                    positions[1][6]=1;
                    positions[6][5]=1;
                    positions[5][1]=2;
                    positions[5][2]=1;
                    positions[7][2]=1;
                    positions[4][3]=1;
                    positions[4][5]=2;
                    positions[5][6]=1;
                    positions[5][7]=1;
                    positions[2][7]=1;
                }
            });

        levelsList.add(new Level()
            {
                public void generate(List<Piece> pieces, List<Point> finalLocations, int[][] positions)
                {
                    pieces.add(new Knight(0,0));
                    finalLocations.add(new Point(7,0));
                    for(int row=0; row<positions.length; row++)
                    {
                        for(int col=0; col<positions[row].length; col++)
                        {
                            if(!(row==0 && col==0))
                                positions[row][col]=1;
                        }
                    }
                }
            });
        // total of 22 levels
    }

    public Board nextLevel()
    {
        currentLevel++;
        return generateLevel();
    }

    public void setLevel(int level)
    {
        currentLevel = level;
    }

    public int getNumLevels()
    {
        return levelsList.size();
    }

    public Board restartLevel()
    {
        return generateLevel();
    }

    public int getCurrentLevel()
    {
        return currentLevel;
    }

    public void resetGame()
    {
        board = null;
        currentLevel = 0;
    }

    private Board generateLevel()
    {
        List<Piece> pieces = new ArrayList<Piece>();
        List<Point> finalLocations = new ArrayList<Point>();
        int[][] positions = new int[8][8];

        levelsList.get(currentLevel-1).generate(pieces, finalLocations, positions);

        board = new Board(pieces, positions, finalLocations);
        if (pieces.size() == 1)
            board.selectPiece(pieces.get(0));
        return board;
    }
}

