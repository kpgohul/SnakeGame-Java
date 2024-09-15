import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SnakeGame {
    Queue<Node> queue=new LinkedList<>();
    String[][] board=null;
    String ball="o";
    String snake=".";
    String space="X";
    public SnakeGame(int row,int col)
    {
        board=new String[row][col];
        prepareBoard();
        //board[0][0]=".";
        board[2][1]=ball;
        board[1][2]=ball;
        queue.add(new Node(0,0));
    }

    private void prepareBoard() {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                board[i][j]=space;
            }
        }
    }
    public void startGame(int row,int col)
    {
        if(row>=0&&row<board.length&&col>=0&&col<board[0].length)
        {
            if(board[row][col].equals(snake))
            {
                System.out.println("Game is Over!!!");
                System.exit(0);
            }

            if(!board[row][col].equals(ball))
            {
                Node temp=queue.poll();
                int r=temp.getRow();
                int c=temp.getCol();
                board[r][c]=space;
            }
            queue.add(new Node(row,col));
            board[row][col]=".";
            for(int i=0;i<board.length;i++) {
                for (int j = 0; j < board[0].length; j++) {
                    System.out.print(board[i][j] + "  ");
                }
                System.out.println();
            }
            while(true)
            {
                System.out.println("Enter the direction ( R / L / U / D) : ");
                String responce=new Scanner(System.in).next();
                if(responce.equals("R")) startGame(row,col+1);
                if(responce.equals("L")) startGame(row,col-1);
                if(responce.equals("U")) startGame(row-1,col);
                if(responce.equals("D")) startGame(row+1,col);
                else System.out.println("enter a corrct direction");
            }
        }
        else{ System.out.println("Invalid Move !!! ");}
    }

}
