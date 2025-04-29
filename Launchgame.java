import java.util.Scanner;

class TicTacToe
{
	static char[][] board;   //Static used to inherit board in other classes
	
	public TicTacToe()
	{
		board = new char[3][3];
		initBoard();

	}
	
	void initBoard() 
	{
		for(int i=0; i<board.length; i++)
		{
			for(int j=0; j<board[i].length;j++)
			{
				board[i][j]=' ';
               
			}
		}
	   	
	}
	
	static void dispBoard()
	{
		System.out.println("-------------");
		for(int i=0; i<board.length; i++)
		{
			System.out.print("| ");
			for(int j=0; j<board[i].length;j++)
			{
				System.out.print(board[i][j] + " | ");
               
			}
			System.out.println("");
			System.out.println("-------------");
		}
	   	
	}
	
	
	
	static void placemark(int row,int coloum,char mark)
	{
		if(row>=0 && row<=2 && coloum >=0 && coloum <=2)
		{
			board[row][coloum]=mark;
		}
		else {
			System.out.println("invalid position..");
		}
		
	}
	
	static boolean checkcolwin()
	{
		for(int j=0; j<=2; j++)
		{
			if(board[0][j]!= ' ' &&       board[0][j] == board[1][j]&& board[1][j] == board[2][j] )
			{
				return true;
			}
		}
		return false;
	}
	static boolean checkrowwin()
	{
		for(int i=0; i<=2;i++)
		{
			if( board[i][0]!=' ' &&  board[i][0]==board[i][1]&&board[i][1]==board[i][2])
			{
				return true;
			}
				
		}
		return false;
	}
	
	static boolean checkdiagwin()
	{
		if(board[0][0]!=' '&&   board[0][0]==board[1][1]&&board[1][1]==board[2][2] ||board[0][2]!=' '&& board[0][2]==board[1][1]&& board[0][2]==board[1][1])
		{
			return true;
			
		}
		else {
			return false;
		}
	}
	
	
}





class HumanPlayer
{
	String name;
	char mark;
	
	HumanPlayer(String name, char mark)
	{
		this.name = name;
		this.mark = mark;
	}
	void makemove()
	{
		Scanner scan = new Scanner(System.in);
		int row;
		int coloum;
		do {
			System.out.println("enter the row and coloum");
			 row = scan.nextInt();
			 coloum = scan.nextInt();
		}while(!ismovevalid(row, coloum));
		
		TicTacToe.placemark(row, coloum, mark);
		
	}
	boolean ismovevalid(int row, int coloum)
	{
		if(row>=0 && row<=2 && coloum>=0 && coloum<=2)
		{
			if(TicTacToe.board[row][coloum] ==' ' )
			{
				return true;
			}
		}
		return false;
	}
}











public class Launchgame {

	public static void main(String[] args) {
		TicTacToe t= new TicTacToe();
       t.dispBoard();
        
	
		
		
		
		HumanPlayer p1 = new HumanPlayer("ankit",'x');
		HumanPlayer p2 = new HumanPlayer("karan" , 'o');
		
		HumanPlayer cp;
		cp = p1;
		
		
		while(true)
		{
			System.out.println(cp.name + "turn");
			cp.makemove();
			TicTacToe.dispBoard();
			
			if(TicTacToe.checkcolwin() || TicTacToe.checkrowwin()  ||TicTacToe.checkdiagwin())
			{
				System.out.println(cp.name + "has won");
				break;
			}
			else 
			{
				if(cp==p1)
				{
					cp = p2;
				}
				else 
				{
					cp = p1;
				}
			}
		}
		


	}

}
