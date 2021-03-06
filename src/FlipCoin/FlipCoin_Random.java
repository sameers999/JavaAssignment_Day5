package FlipCoin;
import java.util.*;

public class FlipCoin_Random {
	private enum Coin { HEADS, TAILS };

    private static final Random randomNumbers = new Random();

    private static final int HEAD = 1;
   // private static final int TAIL = 2;

    public static void main(String[] args)
    {
        Scanner input = new Scanner( System.in );

        int choice;
        //int toss = 0;
        int tosses = 0;
        int frontflip = 0;
        int backflip = 0;

        Coin gameStatus;

        System.out.println("Welcome to the Coin Toss Program.\n");
        System.out.println("Choose from the menu what you want to do.");
        System.out.print("1. Toss the coin\n2. Quit program\n");
        choice = input.nextInt();
        input.close();

        while ( choice != 0 )
        {
            if ( choice == 1 )
            {
                int CoinTossed = Flip();

                switch ( CoinTossed )
                {
                                //added tosses to switch statement to make the counter work perfect.
                case HEAD:
                    gameStatus = Coin.HEADS;
                    tosses++; // add amount of tosses
                    break;
                default: // changed case TAIL to default. Easy and works.
                    gameStatus = Coin.TAILS;
                    tosses++; // add amount of tosses
                    break;
                }

                if ( gameStatus == Coin.HEADS )
                {
                    frontflip++; //Add amount of heads
                }
                else // gameStatus == TAILS
                    backflip++; //Add amount of tails       
            }

            // A try to make an real exit out of a program

            if ( choice == 2 )
            {
                EndProgram( frontflip, backflip, tosses );
            }

            System.out.println("\nChoose from the menu what you want to do.");
            System.out.print("1. Toss the coin\n2. Quit program\n");
            choice = input.nextInt();   
        }   
    }

    //Toss the coin to determine 1 or 2.
    public static int Flip()
    {
        int toss;

        toss = 1 + randomNumbers.nextInt( 2 );

        if ( toss == 1 )
        {
            System.out.println("You toss the coin and it lands on head!");
        }
        else
        {
            System.out.println("You toss the coin and it lands on tail!");
        }
        return toss;
    }

    public static void EndProgram( int frontflip, int backflip, int tosses )
    {
        System.out.printf("You have tossed %d times.\n", tosses);
        System.out.printf("Of all those tosses, %d landed on heads, and %d on tails.\n", frontflip, backflip);
        System.exit(0);
    }

}
