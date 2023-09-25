import  java.util.*;
public class textadventuregame {

    Scanner myScanner = new Scanner(System.in);
    Scanner enterScanner = new Scanner(System.in);

    int playerHP;
    String playerName;
    String playerWeapon;
    int choice;
    int playerMonsterHP;
    int silverRing;

    public static void main(String[] args){
        textadventuregame game= new textadventuregame();
        game.playersetup();
        game.townGate();
        int choice;

    }
    public void playersetup(){
        int playerHP= 1000000;
        playerMonsterHP=5;
        String playerWeapon="knife";
        System.out.println("Your HP"+playerHP);
        System.out.println("Your Weapon "+playerWeapon);
        String playername;


        System.out.print("Please enter your name:");
        playername=myScanner.nextLine();
        System.out.println("Helloji"+playername+", let's play the game");
    }

    public void townGate(){
        System.out.println("\n------------------------------------------------\n");
        System.out.println("Your at the gate of the town");
        System.out.println("A Guard is standing in front of you");
        System.out.println("");
        System.out.println("What do you wnat to do?");
        System.out.println("");
        System.out.println("1: Talk to the Guard");
        System.out.println("2: Attack the Guard");
        System.out.println("3: Leave");
        System.out.println("\n------------------------------------------------\n");

        choice = myScanner.nextInt();
        if(choice == 1){
            if(silverRing == 1){
                ending();
            }else{
                System.out.println("Guard: Hello there stranger.So your name is"+playerName+"? Sorry but we cannot let stranger enter your town.");
                enterScanner.nextLine();
                townGate();}
        }else if(choice == 2){
            playerHP = playerHP - 1;
            System.out.println("Guard: Hey don't be stupid.\nThe guard hit you so hard and you gave up.\n(You receive 1 damage) ");
            System.out.println("Your HP: "+playerHP);
            enterScanner.nextLine();
            townGate();
        } else if(choice == 3){
            crossroad();

        }else{townGate();}
    }
    public void crossroad(){
        System.out.println("\n--------------------------------\n");
        System.out.println("Your are at a crossroad.If you go south, you will go back to the town\n\n");
        System.out.println("1: Go north");
        System.out.println("2: Go east");
        System.out.println("3: Go south");
        System.out.println("4: Go west");
        System.out.println("\n--------------------------------\n");
        choice =myScanner.nextInt();
        if(choice==1){north();}
        if(choice==2){east();}
        if(choice==3){townGate();}
        if(choice==4){west();}
        else{crossroad();   }
    }
    public void north() {
        System.out.println("\n--------------------------------\n");
        System.out.println("There is a river.You can drink water and rest near the river.");
        System.out.println("Your HP is recovered.");
        playerHP =playerHP + 1;
        System.out.println("Your HP"+playerHP);
        System.out.println("\n\n1: Go back to the crossroad");
        System.out.println("\n--------------------------------\n");
        choice=myScanner.nextInt();
        if(choice==1){crossroad();}
        else{north();}
    }


    public void east() {
        System.out.println("\n--------------------------------\n");
        System.out.println("You walked into a forest and found a Long sword!.");
        playerWeapon="Long sword";
        System.out.println("Your weapon"+playerWeapon);
        System.out.println("\n\n1: Go back to the crossroad");
        System.out.println("\n--------------------------------\n");
        choice=myScanner.nextInt();
        if(choice==1){crossroad();}
        else{east();}
    }

    public void west() {
        System.out.println("\n--------------------------------\n");
        System.out.println("You encounter a goblin!\n");
        System.out.println("1: Fight");
        System.out.println("2: Run");
        System.out.println("\n--------------------------------\n");
        choice=myScanner.nextInt();
        if(choice==1){fight();}
        if(choice==2){crossroad();}
        else{west();}
    }
    public void fight(){
        System.out.println("\n--------------------------------\n");
        System.out.println("HP: " +playerHP);
        System.out.println("Monster HP: " + playerMonsterHP);
        System.out.println("\n--------------------------------\n");
        System.out.println("\n1: Attack");
        System.out.println("2: Run");
        System.out.println("\n--------------------------------\n");
        choice=myScanner.nextInt();
        if(choice==1){attack();}
        if(choice==2){crossroad();}
        else{fight();}
    }
    public void attack(){
        int playerDamage=0;
        if(playerWeapon.equals("Knife")){
            playerDamage=new java.util.Random().nextInt(5);}
        else if(playerWeapon.equals("Long Sword")){
            playerDamage=new java.util.Random().nextInt(8);}
        System.out.println("You attack the monster and gave"+playerDamage+"damage");
        playerMonsterHP=playerMonsterHP-playerDamage;
        System.out.println("Monster HP: "+playerMonsterHP);
        if(playerMonsterHP<1){win();}
        else if(playerMonsterHP>0){
            int monsterDamage=0;
            monsterDamage=new java.util.Random().nextInt(4);
            System.out.println("The monster attacked you and gave"+monsterDamage+"damage!");
            playerHP=playerHP-monsterDamage;
            System.out.println("Player HP: "+playerHP);
            if (playerHP < 1) {
                dead();
            } else if (playerHP > 0) {
                fight();
            }

        }
    }
    public void dead() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You are dead!!!");
        System.out.println("\n\nGAME OVER");
        System.out.println("\n------------------------------------------------------------------\n");

    }

    public void win() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You killed the monster!");
        System.out.println("The monster dropped a ring!");
        System.out.println("You obtaind a silver ring!\n\n");
        System.out.println("1: Go east");
        System.out.println("\n------------------------------------------------------------------\n");

        silverRing = 1;

        choice = myScanner.nextInt();
        if (choice == 1) {
            crossroad();
        } else {
            win();
        }

    }

    public void ending() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Guard: Oh you killed that goblin!?? Great!");
        System.out.println("Guard: It seems you are a trustworthy guy. Welcome to our town!");
        System.out.println("\n\n           THE END                    ");
        System.out.println("\n------------------------------------------------------------------\n");
    }


}






