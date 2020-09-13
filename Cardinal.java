/**
* Cardinal - Final project a solo player game in which you battle various monsters
*            gaining exp and leveling up to defeat the final boss.
*
* @author Bryan Perez, CS 2011-2
*/
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Cardinal{
 public static final String ANSI_RED = "\u001B[31m";
 public static final String ANSI_RESET = "\u001B[0m";
 public static final String ANSI_BLUE = "\u001B[34m";
 public static final String ANSI_GREEN = "\u001B[32m";
 public static void main(String[] args) throws InterruptedException{
   for (int i = 0; i < args.length; i++){
     System.out.println(args[i] + "\n\n Welcome to the help screen."
     + "\n\n Here you can learn the mechanics of the game."
     + "\n You will find yourself given with an option to choose any weapon"
     + "\n including a bow, sword, spear, and a shield, but choose wisely"
     + "\n as there are slight benefits in choosing one over the other."
     + "\n Further, you must traverse through 4 different locations."
     + "\n Each location has their own monsters dwelling there."
     + "\n The player gains XP respective to the monster type,"
     + "\n so you must choose your approach carefully."
     + "\n Ultimately, the goal is to reach level 10 and go through"
     + "\n all locations in order to fight the final boss."
     + "\n If there are no more questions simply carry on with the game"
     + "\n by running the code without -help."
     + "\n Let's hope YOU are the destined warrior to save us from doom. \n");

     System.exit(1);
   }

  Scanner input = new Scanner(System.in);
  char choice;
  int hp = 0;
  int attack = 0;
  int defense = 0;
  int level = 0;
  int exp = 0;
  String weapon = "";

  System.out.println("Welcome to Cardinal.");
  Thread.sleep(1500);
  System.out.println("To begin your adventure you must choose your weapon.");
  Thread.sleep(1000);
  System.out.println("You have a choice between a bow, sword, spear and shield? ");
  Thread.sleep(750);
  System.out.println("What weapon would you like?");
  do{
  choice = input.next().charAt(1);
  }while(choice != 'o' && choice != 'O' && choice != 'w'  && choice != 'W'  && choice != 'p'  && choice != 'P' && choice != 'h'  && choice != 'H' );

  if(choice == 'o'){
    hp = 150;
    attack = 20;
    defense = 5;
    level = 1;
    exp = 0;
    weapon = "bow.";
  }
  if(choice == 'w'){
    hp = 150;
    attack = 15;
    defense = 14;
    level = 1;
    exp = 0;
    weapon = "sword.";
  }
  if(choice == 'p'){
    hp = 150;
    attack = 17;
    defense = 10;
    level = 1;
    exp = 0;
    weapon = "spear.";
  }
  if(choice == 'h'){
    hp = 200;
    attack = 10;
    defense = 35;
    level = 1;
    exp = 0;
    weapon = "shield.";
  }
  yourWeapon(choice, hp, attack, defense, level, exp, weapon);
  }

 public static void yourWeapon(char choice, int hp, int attack, int defense, int level, int exp, String weapon) throws InterruptedException{
    Scanner input = new Scanner(System.in);
    boolean[] locationArray = new boolean[5];
    char location;
    if(choice == 'o'){
      hp = 150;
      attack = 20;
      defense = 5;
      level = 1;
      exp = 0;
      weapon = "bow.";
    }
    if(choice == 'w'){
      hp = 150;
      attack = 15;
      defense = 14;
      level = 1;
      exp = 0;
      weapon = "sword.";
    }
    if(choice == 'p'){
      hp = 150;
      attack = 17;
      defense = 10;
      level = 1;
      exp = 0;
      weapon = "spear.";
    }
    if(choice == 'h'){
      hp = 200;
      attack = 10;
      defense = 35;
      level = 1;
      exp = 0;
      weapon = "shield.";
    }

    System.out.println("You have chosen the " + weapon);
    Thread.sleep(1000);
    System.out.println("Would you like to see your stats?");
    char choice2 = input.next().charAt(0);

    statsYorN(choice2, choice, hp, attack, defense, level, exp);
    Thread.sleep(1000);
    System.out.println("Before you fight the boss you have to gain levels.");
    Thread.sleep(1000);
    System.out.println("Do you want to go into the forest or the cave?");
    do{
      location = input.next().charAt(0);
    }while(location != 'f' && location != 'F' && location != 'c' && location != 'C');

    exp = monsterStats(location , choice, hp, attack, defense, level, exp, locationArray);
  }

 public static void statsYorN(char choice2, char choice, int hp, int attack, int defense , int level, int exp)
    throws InterruptedException{
   if (choice2 == 'y' || choice2 == 'Y')
     stats(choice, hp, attack, defense, level, exp);
   else if(choice2 != 'y')
      System.out.println("Alright your choice.");
 }

 public static int[] statChange(int statsArray[], char choice, int hp, int attack, int defense , int level, int exp){
   int defenseUp = 0;
   int hpUp = 0;
   int attackUp = 0;

   if (choice == 'h'){
     defenseUp = 15;
     hpUp = 20;
     attackUp = 5;
   }
   else if (choice == 'w'){
     defenseUp = 7;
     attackUp = 8;
     hpUp = 15;
   }
   else if (choice == 'p'){
     defenseUp = 5;
     attackUp = 10;
     hpUp = 15;
   }
   else if (choice == 'o'){
     defenseUp = 5;
     attackUp = 12;
     hpUp = 13;
   }
   for(int a = 0; a < 10; a++){
     int maxLevels[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
     int expCaps[] = {50, 150, 250, 350, 450, 550, 650, 750, 850, 950};

     if (level == maxLevels[a] && exp >= expCaps[a]){
       hp += hpUp;
       level += 1;
       defense += defenseUp;
       attack += attackUp;
     }
   }
   statsArray[0] = hp;
   statsArray[1] = defense;
   statsArray[2] = attack;
   statsArray[3] = level;


   return statsArray;
 }

 public static void stats(char choice, int hp, int attack, int defense , int level, int exp)
    throws InterruptedException{
   System.out.println("LvL: " + level + " Exp: " + exp + " Hp: " + hp + " Attack: " + attack + " Defense: " + defense);
   System.out.println("");
 }

 public static void story(char location, boolean[] locationArray ) throws InterruptedException{
     if((location == 'C' || location == 'c') && locationArray[0] == false){
       Thread.sleep(1000);
       System.out.println("You walk inside the cave and it's pitch black. You have no idea what's around you.");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("Then you strike up a torch and bats suddenly swarm past you.");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("You gasp for breath and continue to walk further down the cave as the only thing keeping "
       + "you grounded is your source of light");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("5 minutes pass by and you see some light further in front of you.");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("As you walk towards it, you see a large pit of lava. You walk towards the pit, "
       + "looking for a way across.");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("You hear multiple growls and barking behind you. As you turn around...");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("A human-sized three-headed hound with sharp claws stands in front you, eyeing its prey.");
       System.out.println("");
     }
     else if((location == 'f'|| location == 'F') && locationArray[1] == false){
       Thread.sleep(1000);
       System.out.println("It's a breezy day. You absorb the greenery around with your eyes.");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("Even though the forest looks peaceful, you keep your guard up for anything that tries "
       + "to attack you.");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("In the distance, you see a horde of red balloon monsters in one spot.");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("One balloon monster strays away from the horde and you follow it as an opportunity "
       + "to kill it.");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("It notices you following it, and you get ready to fight.");
       System.out.println("");
     }
     else if((location == 'm' || location == 'M') && locationArray[2] == false){
       Thread.sleep(1000);
       System.out.println("You will now enter the mountains.");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("You tread carefully through each rocky gap as you ascend.");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("The air starts to thin out and you start to breath heavily.");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("After 10 minutes of hiking up the mountains, you come across a huge, spacious "
          + "platform with jagged rocks surround it.");
          System.out.println("");
       Thread.sleep(2000);
       System.out.println("You hear a large roar, you look up and see a creature land from the sky.");
       System.out.println("");
     }
     else if((location == 'v' || location == 'V') && locationArray[3] == false){
       Thread.sleep(1000);
       System.out.println("You stumble upon a village. Seeking shelter from the rain that suddenly poured.");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("As you walk into a door, you get pulled into a different reality.");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("It does have a resemblance to the world you're used to, but it is much darker.");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("As you blink, different images emerge.");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("On every third blink of yours, a cloaked figure approaches closer and closer.");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("You notice this trend, which gives you time to draw your weapon and fight.");
       System.out.println("");
     }
     else if((location == 'b' || location == 'B') && locationArray[4] == false){
       Thread.sleep(1000);
       System.out.println("Growing tired but stronger than ever, you feel as if you've cleansed the world of evil.");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("However, something doesn't seem right as people are still either hiding or preparing to leave their homes.");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("You approach one civilian and ask what this fear is and as soon as he opens his mouth");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("the purest form of evil explodes from down below and sweeps the houses with one strike.");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("You try to guide the remaining people out, but there are just too many injuries.");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("As people run out of their homes, the monster sends in a rain of fire from the sky");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("while explosions are happening from around the perimeter.");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("It locks on to you and proceeds to grab and throw you across the field far from civilization.");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("As you stagger back up, you readily draw your weapons as it is approaching you fast.");
       System.out.println("");
     }
     Thread.sleep(2000);
 }

 public static int afterBattleOptions(char choice, int hp, int attack, int defense , int level, int exp,
   boolean[] locationArray) throws InterruptedException{
   Scanner input = new Scanner(System.in);
   char location, continueGame;
   int statsArray[] = new int[4];
   statChange(statsArray, choice, hp, attack, defense, level, exp);
   level = statsArray[3];
   attack = statsArray[2];
   defense = statsArray[1];
   hp = statsArray[0];
   System.out.println("Would you like to quit the game or continue fighting?(q/c)");
   do{
     continueGame = input.nextLine().charAt(0);
   }while(continueGame != 'c' && continueGame != 'C' && continueGame != 'q' && continueGame != 'Q');
   if(continueGame == 'q' || continueGame =='Q'){
     System.out.println("Thank you for playing.");
     System.exit(0);
   }
   else if(continueGame == 'c' || continueGame == 'C'){
     if(locationArray[0] == false || locationArray[1] == false){
       stats(choice, hp, attack, defense, level, exp);
       Thread.sleep(1000);
       System.out.println("Before you can face the final the boss you have to gain levels.");
       System.out.println("");
       System.out.println("You must get past the cave and the forest to unlock the other areas.");
       System.out.println("");
       Thread.sleep(1000);
       System.out.println("Do you want to go into the forest or the cave?");
       do{
         location = input.next().charAt(0);
       }while(location != 'f' && location != 'F' && location != 'c' && location != 'C');
       exp = monsterStats(location, choice, hp, attack, defense, level, exp, locationArray);
       return exp;
     }
     else if((locationArray[2] == true && locationArray[3] == true) && (level >= 10)){
       stats(choice, hp, attack, defense, level, exp);
       Thread.sleep(2000);
       System.out.println("You have reached level 10.");
       Thread.sleep(2000);
       System.out.println("You have unlocked the boss battle.");
       System.out.println("");
       Thread.sleep(2000);
       System.out.println("Do you want to fight against the boss?");
       do{
         location = input.next().charAt(0);
       }while(location != 'Y' && location != 'y' && location != 'n' && location != 'N');
       if(location == 'y' || location == 'Y')
          location = 'b';
       if(location == 'n' || location == 'N'){
         System.out.println("Do you want to go into the forest, cave, mountains or the village?");
         do{
           location = input.next().charAt(0);
         }while(location != 'f' && location != 'F' && location != 'c' && location != 'C' && location != 'm'
         && location != 'M' && location != 'v' && location != 'V' && location != 'b' && location != 'B');
       }
       exp = monsterStats(location, choice, hp, attack, defense, level, exp, locationArray);
       return exp;
     }
     else if(locationArray[0] == true && locationArray[1] == true){
       stats(choice, hp, attack, defense, level, exp);
       Thread.sleep(2000);
       if (locationArray[2] == false && locationArray[3] == false)
          System.out.println("You've unlocked two locations: mountains and village.");
       if (level < 10)
          System.out.println("You must be at level 10 to fight the boss.");
       Thread.sleep(2000);
       System.out.println("Do you want to go into the forest, cave, mountains or the village?");
       do{
         location = input.next().charAt(0);
       }while(location != 'f' && location != 'F' && location != 'c' && location != 'C' && location != 'm'
       && location != 'M' && location != 'v' && location != 'V');
       exp = monsterStats(location, choice, hp, attack, defense, level, exp, locationArray);
       return exp;
     }
   }
    return exp;
 }

 public static int monsterStats(char location, char choice, int hp, int attack, int defense , int level, int exp,
    boolean[] locationArray) throws InterruptedException{
    Scanner input = new Scanner(System.in);
    int monsterHp;
    int monsterAttack;
    if(location == 'C' || location == 'c'){
      monsterHp = 100;
      monsterAttack = 25;
      story(location, locationArray);
      exp = encountered(location, monsterHp , monsterAttack , choice, hp, attack, defense, level, exp, locationArray);
      return exp;
    }
    else if(location == 'f'|| location == 'F'){
      monsterAttack = 17;
      monsterHp = 50;
      story(location, locationArray);
      exp = encountered(location, monsterHp , monsterAttack , choice, hp, attack, defense, level, exp, locationArray);
      return exp;
    }
    else if(location == 'm' || location == 'M'){
      monsterAttack = 35;
      monsterHp = 175;
      story(location, locationArray);
      exp = encountered(location, monsterHp , monsterAttack , choice, hp, attack, defense, level, exp, locationArray);
    }
    else if(location == 'v' || location == 'V'){
      monsterAttack = 40;
      monsterHp = 160;
      story(location, locationArray);
      exp = encountered(location, monsterHp , monsterAttack , choice, hp, attack, defense, level, exp, locationArray);
    }
    else if(location == 'b' || location == 'B'){
      monsterAttack = 70;
      monsterHp = (int)(hp * 1.5);
      story(location, locationArray);
      exp = encountered(location, monsterHp , monsterAttack , choice, hp, attack, defense, level, exp, locationArray);
    }
    return exp;
 }

 public static int encountered(char location, int monsterHp, int monsterAttack, char choice, int hp, int attack, int defense , int level, int exp, boolean[] locationArray) throws InterruptedException{
    Scanner input = new Scanner(System.in);
    char responce;
    String monsterName = "";
    String locationName = "";
    Random RandNum = new Random();
    int expGain = 0;
    int evade = 1;
    double crit = 1;
    int popUpExp = 0;
    int chance = RandNum.nextInt(100);
    boolean unlocked;
    int locationIndex = 0;
    int statsArray[] = new int[4];
    int characterHp = hp;
    int reserves[] = new int[2];
    double criticalAndEvade[] = new double[2];
    double charged[] = new double[3];
    double popUpArray[] = new double[3];
    boolean popUpRun = false;
    popUpArray[0] = monsterHp;
    reserves[1] = 5;
    charged[0] = attack;
    charged[1] = attack;
    charged[2] = attack;


    if(location == 'C' || location == 'c'){
      monsterName = "(small) Cerberus";
      locationName = "cave";
      expGain = 35;
      unlocked = locationArray[0];
      locationIndex = 0;
    }
    else if(location == 'f'|| location == 'F'){
      monsterName = "Balloon";
      locationName = "forest";
      expGain = 15;
      unlocked = locationArray[1];
      locationIndex = 1;
    }
    else if(location == 'm' || location == 'M'){
      monsterName = "Wyvern";
      locationName = "mountains";
      expGain = 50;
      unlocked = locationArray[2];
      locationIndex = 2;
    }
    else if(location == 'v' || location == 'V'){
      monsterName = "Cloaked Two-Horn";
      locationName = "village";
      expGain = 60;
      unlocked = locationArray[3];
      locationIndex = 3;
    }
    else if(location == 'b' || location == 'B'){
      monsterName = "Glass (The Fan Hero)";
      locationName = "Boss Battle";
      expGain = 100;
      unlocked = locationArray[4];
      locationIndex = 4;
    }

    System.out.println("Welcome to the " + locationName + ".");
    Thread.sleep(1000);
    if( location == 'b'){
      System.out.println("You have encountered " + monsterName + ".");
    }
    else{
      System.out.println("You have enountered a " + monsterName + ".");
    }
    Thread.sleep(800);
    System.out.println("Do you want to battle (yes or no)?");
    do{
    responce = input.next().charAt(0);
    }while(responce != 'y' && responce != 'Y' && responce != 'n' && responce != 'N');

    if (responce == 'y' ||responce =='Y'){
      do {

        Thread.sleep(600);
        System.out.println("Your hp: " + characterHp);
        System.out.println(monsterName + " hp: " + monsterHp);
        Thread.sleep(600);

        chance = RandNum.nextInt(100);
        if(monsterHp < 20 && location != 'b' && chance <= 40 && popUpRun == false && location != 'B'){
          chance = RandNum.nextInt(3);
          if(chance != 0){
          popUp(chance, choice, characterHp, attack, defense, expGain, popUpArray, monsterAttack, monsterName, crit, evade, responce, charged, criticalAndEvade, location);
          characterHp = (int)(popUpArray[2]);
          popUpExp = (int)(popUpArray[1]);
          popUpRun = true;
          }
        }

        System.out.println("Do you want to attack or run or charge an attack?");
        do{
        responce = input.next().charAt(0);
        }while(responce != 'a' && responce != 'A' && responce != 'r' && responce != 'R' && responce != 'c' && responce != 'C');

        charged(choice, attack, charged, responce);
        attack = (int)(charged[2]);

        critAndEvade( choice, location, evade, crit, monsterName, criticalAndEvade);

        crit = criticalAndEvade[0];
        evade = (int)(criticalAndEvade[1]);

        if (location == 'b'){
          monsterHp = monsterHp - attack*evade;
        }
        else{
          monsterHp = monsterHp - (int)(attack*crit);
        }
        crit = 1;
        if((double)(defense)/4 > monsterAttack){
          characterHp = characterHp;
        }
        else{
          characterHp = characterHp - ((monsterAttack - defense/4) * evade);
        }
        evade = 1;
        if(location == 'b'){
          characterHp = potions(characterHp, reserves);
          reserves[0] = characterHp;
        }

        attack = (int)(charged[1]);


      }while(monsterHp > 0 && (responce == 'a' || responce =='A' || responce == 'c' || responce == 'C') && characterHp > 0);
      if (characterHp <= 0){
        System.out.println("You lost.");
        afterBattleOptions(choice, hp, attack, defense, level, exp, locationArray);
      }
      else if (monsterHp <= 0 && location == 'b'){
        System.out.println("We hope you have enjoyed our game.");
        System.out.println("And congratulations for beating our final boss.");
        System.out.println("We hope that you use our other weapons.");
        System.exit(0);
      }
      else if (monsterHp == 0 || monsterHp < 0){
        Thread.sleep(1000);
        System.out.println("");
        System.out.println("You have gained " + (expGain + popUpExp) + " exp.");
        exp += expGain + popUpExp;
        unlocked = true;
        locationArray[locationIndex] = unlocked;
        exp = afterBattleOptions(choice, hp, attack, defense, level, exp, locationArray);
      }
      else if (responce == 'r' || responce == 'R'){
        Thread.sleep(1000);
        System.out.println("You have regained your hp and will now move on to the next adventure.");
        afterBattleOptions(choice, hp, attack, defense, level, exp, locationArray);
      }
    }
    else{
      exp = afterBattleOptions(choice, hp, attack, defense, level, exp, locationArray);
    }
  return exp;
 }

 public static int potions(int characterHp, int reserves[]){
    Scanner input = new Scanner(System.in);
    if(reserves[1] == 0){
      System.out.println("");
    }
    else if(reserves[1] != 0){
      System.out.println("You have some health potions do you wish to use one?");
      char potionsYesOrNo = input.next().charAt(0);
      if (potionsYesOrNo == 'y' || potionsYesOrNo == 'Y'){
        reserves[1] = reserves[1] - 1;
        if (reserves[1] > 0 ){
          characterHp = characterHp + 50;
          System.out.println("You have " + reserves[1] + " left.");
          System.out.println("");
        }
        else if(reserves[1] == 0){
        reserves[1] = 0;
        System.out.println("You have no more potions.");
        System.out.println("Good luck in you battle.");
        characterHp = characterHp;
      }

      }
      else if (potionsYesOrNo == 'n' || potionsYesOrNo == 'N'){
        characterHp = characterHp;
        System.out.println("Good luck in your battle.");
      }
     }
    return characterHp;
  }

 public static double[] critAndEvade(char choice, char location, int evade, double crit, String monsterName, double criticalAndEvade[]){
   Random RandNum = new Random();
   int chance = RandNum.nextInt(100);
   chance = RandNum.nextInt(100);
     if(choice == 'o' && chance <= 30){
       evade = 0;
       System.out.println(ANSI_BLUE + "You Evaded!" + ANSI_RESET);
     }
     if(choice == 'w' && chance <= 25){
       evade = 0;
       System.out.println(ANSI_BLUE + "You Evaded!" + ANSI_RESET);
     }
     if(choice == 'p' && chance <= 20){
       evade = 0;
       System.out.println(ANSI_BLUE + "You Evaded!" + ANSI_RESET);
     }
     if(choice == 'h' && chance <= 15){
       evade = 0;
       System.out.println(ANSI_BLUE + "You Evaded!" + ANSI_RESET);
     }
     chance = RandNum.nextInt(100);
     if (location == 'b' && chance <= 18){
       evade = 0;
       System.out.println("");
       System.out.println(ANSI_GREEN + "" + monsterName + " Has Evaded!");
       System.out.println(ANSI_RESET);
     }
     chance = RandNum.nextInt(100);
     if(chance <= 25){
       crit = 1.5;
       System.out.println(ANSI_RED + "Critical Hit!" + ANSI_RESET);
     }

     criticalAndEvade[0] = crit;
     criticalAndEvade[1] = evade;

  return criticalAndEvade;
 }

 public static double[] charged(char choice, int attack, double charged[], char responce){
   Random RandNum = new Random();
   int chance = RandNum.nextInt(100);
   if(responce == 'c' || responce == 'C'){
     if( chance <= 40 ){
      charged[0] = charged[0] * 1.5;
      charged[2] = 0;
      System.out.println("Your attack has successfully increased.");
     }
     else if(chance > 40){
       charged [0] = charged[1];
       charged[2] = 0;
       System.out.println("Your attack charge has failed.");
     }
   }
   else if(responce == 'a' || responce == 'A'){
     if(charged[0] == charged[1]){
       charged[2] =(int)(charged[1]);
     }
     else if (charged[0] > charged[1]){
       charged[2] = (int)(charged[0]);
       charged[0] = charged[1];
     }
   }

  return charged;
 }

 public static double[] popUp(int chance, char choice, int characterHp, int attack, int defense, int expGain, double[] popUpArray, int monsterAttack, String monsterName, double crit, int evade, char responce, double[] charged, double[] criticalAndEvade, char location)throws InterruptedException{
   Random RandNum = new Random();
   Scanner input = new Scanner(System.in);

     Thread.sleep(800);
     System.out.println("");
     System.out.println("The number of monsters that appeared: " + chance);
     System.out.println("");

     for(int a = 0;  a < chance; a++){
       int[] monsterArrayHp = new int[chance];
       int[] monsterArrayAttack = new int [chance];
       monsterArrayHp[a] = (int)(popUpArray[0]);
       monsterArrayAttack[a] = monsterAttack;

       do{
         Thread.sleep(600);
         System.out.println("Your hp: " + characterHp);
         System.out.println(monsterName + " number " + (a + 1) + " hp: " + monsterArrayHp[a]);
         Thread.sleep(600);
         System.out.println("Do you want to attack or run or charge an attack?");
         do{
         responce = input.next().charAt(0);
         }while(responce != 'a' && responce != 'A' && responce != 'r' && responce != 'R' && responce != 'c' && responce != 'C');

         charged(choice, attack, charged, responce);
         attack = (int)(charged[2]);

         critAndEvade( choice, location, evade, crit, monsterName, criticalAndEvade);

         crit = criticalAndEvade[0];
         evade = (int)(criticalAndEvade[1]);

         monsterArrayHp[a] = monsterArrayHp[a] - (int)(attack*crit);

         crit = 1;
         if((double)(defense)/4 > monsterArrayAttack[a]){
           characterHp = characterHp;
         }
         else{
           characterHp = characterHp - ((monsterArrayAttack[a] - defense / 4)*evade);
         }
         evade = 1;

         attack = (int)(charged[1]);

       }while(monsterArrayHp[a] > 0 && (responce == 'a' || responce =='A' || responce == 'c' || responce == 'C') && characterHp > 0);
       popUpArray[1] += expGain;
       popUpArray[2] = characterHp;

     }
     Thread.sleep(800);
     System.out.println("You are now returning to battle the original " + monsterName + ".");

   return popUpArray;
 }

}
