//imports
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Thread;

class Main{
    // character creation, sends over color of text
    public static Character client = new Character("\u001B[35m");
    public static Character worm = new Character("\u001B[36m");
    public static Character talker1 = new Character("\u001B[31m");
    public static Character talker2 = new Character("\u001B[32m");
    // dance character creation, sends color of text, number of moves in dance sequence, and time a move is shown
    public static DanceCharacter dance1 = new DanceCharacter("\u001B[33m", 3, 4000);
    public static DanceCharacter dance2 = new DanceCharacter("\u001B[32m", 5, 2000);
    public static DanceCharacter dance3 = new DanceCharacter("\u001B[31m", 7, 800);
    
    public static void main(String[] args){
        //clear screen
        System.out.print("\033[H\033[2J");

        //ask user for name
        System.out.print("Please input a name: ");
        Scanner reader = new Scanner(System.in);  // Create a Scanner object
        String name = reader.nextLine();
        while(name.length() > 10){
            System.out.print("\nPlease enter a shorter name: ");
            name = reader.nextLine();
        }
        print("Press enter to continue...", null);

        //chunks of text to loop through
        String[] intro = {
            "Hello " + name + ", you need to meet with your new client. ",
            "They are in need of some gems from the other side of the Line of Dubiety.",
            "The Line of Dubiety is not really a line. It’s a hypothetical wall that separates the real world from a magical alternate world of a possibly endless corridor of rooms. Every room is said to attempt to confuse anyone who enters.",
            "You aren't authorized to technically be there, but that isn’t vital to the story.",
            "As you enter the club with the set meeting place, you quickly find the one who you are supposed to talk with. She lounges by a counter, clearly growing impatient. Not that it is very obvious since you can’t see her face.",
            "“Gosh, finally you have come " + name + ", I wish to make this request of mine brief since you already spent quite the time getting here: ”",
            "“As said before, I need 3 gems from the other side of the Line, as for what reason it is highly unimportant for you. I have asked another named Filliro to have a portal set to a beggining of the corridor. You'll find the gems exploring. You have done tasks like this before so it should be of no trouble.”",
            "“I shall only pay you after a job done by the way. Good day now " + name + ".”",
            "She leaves and you have little guarantee that she will actually pay you, yet the idea of finding these mysterious gems is enough to make you want to go anyway. And thankfully you know Filliro: a friendly and trustworthy character who has yet to mess up with his portal creation.",
            "And thus you head straight off.",
            "Filliro greets you with the portal already done.",
            "And so you waste no further time and enter."
        };

        String[] part1 = { //sorta escape room
            "Part 1: One item is to be used at another. Clickety-click-clack.",
            "You enter with the portal dissipating behind you. You enter what looks to be a small casino. In front of you stands a mannequin with a keycard that it won’t let go of.",
            "You look around and see some game machines, tables, and other random things. One would now suggest to look around, since the exit door is locked and needs that keycard."
        };

        String[] part2 = { //house plan puzzle
            "Part 2: Your knowledge alone will not be enough. How about searching up a few things in the infinitely growing, glowing light up book?",
            "After you enter, you are in a room. In front of you are two house plans and some lines that sort of look like a strange math equation.",
            "“There must be numbers associated with those floor plans " + name + "!”",
            "A small fluffy-looking worm pops out of who knows where. Skipping the formalities, this is now your friend. For the time being.",
            "Hope nothing happens to them.",
            "“You know "+ name +", they look similar to something I’ve seen on Collections of Plans.”",
            "“Wait, no. That isn’t right…”",
            "“I don’t know. Somethin’ similar to Collections of Plans.”",
            "“It also seems you need to subtract two 3-digit numbers, and two 4-digit numbers. This should result in a positive number.\nAfter that, you subtract the 2-digit number from the 3-digit one.\nI think that this will give you a positive answer, which will let you progress.”\n",
            "You also notice these two plans on the wall: https://www.theplancollection.com/Upload/Designers/145/1686/flr_lr10917fp_684.jpg\nand\nhttps://www.theplancollection.com/Upload/Designers/106/1102/FLR_LRHOUMAS1_684.JPG .\nAnd these numbers underneath them respectively: 0-2000 and 4800-5000."
        };

        String[] part2Maps = { //map puzzle
            "After flawlessly entering the conversation, you ask them which door can let you continue, and thus you enter the one they say and continue.",
            "Entering the next area, you find maps lining all the walls in a cramped room.",
            "“Ohh, interesting. There is some text on that wall, what’s it say " + name + "? I can’t read.”",
            "The wall reads:",
            "I wonder what river is beside?\n32.152888, -110.837846\nNot there of course. But what if the plane flew 90 degrees left until 131.4?",
            "What is the population of -24.477712, -46.676749? (Let's say on Wikipedia to be sure.)",
            "Correction: of snakes? As per Skratch?",
            "Did you know that the first 7 letters of the alphabet are next to a Satsang Society in Virginia? What’s its name translated from Swedish? (Without the voice actor.)"
        };

        String[] part3 = { //random fight scene
            "Part 3: This part was totally planned out super well and not a realiziation that a character needs to quickly disappear but in line with the rest of the story and it was supposed to happen in the previous part but just didn't so now there is a part 3.",
            "After you answer your friend's question correctly, a wall also opens up to another room. You enter with the purple flying worm… who isn’t a worm anymore but a much larger being. I guess it evolved, hurray!",
            "But oh no! An opponent approaches… One that looks similar to Filliro? Irrelevant. Time to fight!",
            "Actually we don’t have the time or funding for that so just imagine a cool fight scene.",
            "Your not-anymore-worm friend beats the other thing, but barely.",
            "Your friend has sustained fatal wounds, and you watch on as your buddy dies in your arms. It's very dramatic.", 
            "You may have had little to no connection, but the not-anymore-worm friend will live in your heart forever.",
            "Also you find a gem💎 laying on the floor.",
            "🙂!!!"
        };

        //main portion of code
        boolean done = false; //checks if the game done
        int count = 0; //index for text arrays
        int part = 0; //0, 1, 2, 3, 4
        String con = " "; //checks user input to continue

        //checks if game is done
        while(!done){
            con = reader.nextLine();
            while (!con.equals("")){ 
                con = reader.nextLine();
            }
            if(part == 0){
                //change color because of character speaking
                if(count == 5 || count == 6 || count == 7){
                    print(intro[count], client);
                }
                else{
                    print(intro[count], null);
                }
                count++;
                if(count == 12){
                    count = 0;
                    part++;
                }
            }
            else if(part == 1){
                print(part1[count], null);
                ArrayList<String> items = new ArrayList<String>(); //keeps track of keys, eyes, and keycard
                count++;

                if(count >= 3){
                    boolean bothEyes = false;
                    String pass = String.valueOf((int)(Math.random() * (999-100+1))+100);
                    while(!bothEyes){
                        //options to interact
                        System.out.println("What would you like to check?");
                        System.out.println("0-Poker table");
                        System.out.println("1-Marionette standing behind poker table");
                        System.out.println("2-Marionette's hand");
                        System.out.println("3-Box in marionette's hand");
                        System.out.println("4-Carpet");
                        System.out.println("5-Roulette table");
                        System.out.println("6-Chandelier");
                        System.out.println("7-Mario game");
                        System.out.println("8-Slot machine");
                        System.out.println("9-Slot machine compartment");
                        System.out.println();
                        con = reader.nextLine();

                        //makes sure valid option
                        while(!con.equals("0") && !con.equals("1") && !con.equals("2") && !con.equals("3") && !con.equals("4") && !con.equals("5") && !con.equals("6") && !con.equals("7") && !con.equals("8") && !con.equals("9")){ 
                            con = reader.nextLine();
                        }
                        //prints something according to option and stuff in items 
                        if(con.equals("0")){
                            print("A poker table stands before. It looks nice.", null);
                        }
                        else if(con.equals("1")){
                            if(items.contains("Leye") && items.contains("Reye")){
                                print("Putting both eyes in the marionette, it stares at you and opens its hand.", null);
                                items.add("openHand");
                            }
                            else if(items.contains("Leye") || items.contains("Reye")){
                                print("You see that an eye fits in the marionette. Look for a second one.", null);
                            }
                            else{//0
                                print("You see a life sized marionette standing behind the poker table. It seems to be missing its eyes?", null);
                            }
                        }
                        else if(con.equals("2")){
                            if(items.contains("openHand")){
                                print("You grab the keycard and leave the casino themed area. Right as you walk out the door, a gem💎 falls on your head. Must be one of the three the client wanted.", null);
                                bothEyes = true;
                                count = 0;
                                part++;
                            }
                            else{
                                print("In the marionette's hand you see a keycard. Trying to grab it, the marionette won't let go.", null);
                            }
                        }
                        else if(con.equals("3")){
                            if(items.contains("redKey")){
                                print("You use your red key to open the box, inside you find a glass eye.", null);
                                items.add("Reye");
                            }
                            else{
                                print("An intricate box sits in the marionette's hand. It needs a key to be opened. The lock is a bright red.", null);
                            }
                        }
                        else if(con.equals("4")){
                            print("Yes, the floor is indeed made of floor.", null);
                        }
                        else if(con.equals("5")){
                            print("You look at the fancy roulette table. In the center you see a strange piece... turns out it's a yellow key.", null);
                            items.add("yellowKey");
                        }
                        else if(con.equals("6")){
                            print("The intricate chandelier is made up of many clear gems. Looking at it from a certain angle, you see the numbers " + pass + " etched into some gems.", null);
                            items.add("pass");
                        }
                        else if(con.equals("7")){
                            print("Wonder why this is in an casino.", null);
                        }
                        else if(con.equals("8")){
                            if(items.contains("pass")){
                                print("You try moving the numbers in the machine to what the numbers on the chandelier were, and a red key drops out.", null);
                                items.add("redKey");
                            }
                            else{
                                print("Looking at the slot machine, it seems you can just rotate the 3 spinning parts as you wish. Each part has numbers 0-9.", null);
                            }
                        }
                        else{//9
                            if(items.contains("yellowKey")){
                                print("Bringing forth your yellow key, you open the compartment and find a glass eye inside.", null);
                                items.add("Leye");
                            }
                            else{
                                print("There is a small compartment on the slot machine, but you can't pry it open. It seems to need a key. Maybe yellow.", null);
                            }
                        }
                        System.out.println();
                    }
                }
                
            }
            else if(part == 2){ //part == 2
                System.out.println("\033[H\033[2J");
                //changes color based on speaker
                if(count == 2 || count == 5 || count == 6 || count == 7 || count == 8){
                    print(part2[count], worm);
                }
                else{
                    print(part2[count], null);
                }
                count++;
                if(count == 9){
                    //puzzle one - house plans
                    String ans = "";
                    print(part2[count-1], worm);
                    System.out.println("☐ ☐ ☐ - ☐ ☐ ☐ = ♢♢");
                    System.out.println("☐ ☐ ☐ ☐ - ☐ ☐ ☐ ☐ = ♢♢♢");
                    System.out.println("⛋ ⛋ ⛋ - ⛋ ⛋ = ⚿ ⚿ ⚿");
                    System.out.println(white + part2[count]);
                    while(!ans.equals("545")){
                        System.out.println("You must input the correct 3-digit number: ");
                        ans = reader.nextLine();
                    }
                    System.out.println("\033[H\033[2J");
                    // puzzle two - random discussion
                    System.out.println("You input the correct code and enter the next room. It isn't actually much of a room. It looks like an endless void of doors everywhere. Too many to count. Who knows which one you are supposed to go in. A warning sign hangs above you with the warning that entering the wrong door will lead to bad things. What bad things? Better not to know.");
                    con = "-";
                    con = reader.nextLine();
                    while (!con.equals("")){ 
                        con = reader.nextLine();
                    }
                    con = "-";
                    System.out.println("Except, you find two strange beings talking to each other.");
                    while (!con.equals("")){ 
                        con = reader.nextLine();
                    }
                    con = "-";
                    print("“I see two folks talkin’ over there! I think we could ask them for help. But you should only say something if you know what they are talking about.”\n", worm);
                    while (!con.equals("")){ 
                        con = reader.nextLine();
                    }
                    System.out.println(talker1.getColor() + "“Golly! I didn’t know a drink could have a naval fleet. Isn’t that cool?”");
                    System.out.println(talker2.getColor() + "“You do know that that had never happened, right?”\n");
                    System.out.println(white + "What are they talking about?: ");
                    con = "-";
                    while (!con.equals("pepsi")){ 
                        con = reader.nextLine();
                        con = con.toLowerCase();
                        con = con.replaceAll("\\s", "");
                    }
                    //puzzle 3 - maps
                    count = 0;
                    con = "";
                    while(count < part2Maps.length){
                        while (!con.equals("")){ 
                            con = reader.nextLine();
                        }
                        if(count == 2){
                            print(part2Maps[count], worm);
                        }
                        else{
                            print(part2Maps[count], null);
                        }
                        con = "!";
                        //questions/prompts in part2Maps array
                        if(count == 4){
                            while(!con.equals("serae") && !con.equals("seraeriver")){ 
                                con = reader.nextLine();
                                con = con.toLowerCase();
                                con = con.replaceAll("\\s", "");
                            }
                            con = "";
                        }
                        else if(count == 5){
                            while (!con.equals("0") && !con.equals("zero")){ 
                                con = reader.nextLine();
                                con = con.toLowerCase();
                                con = con.replaceAll("\\s", "");
                            }
                            con = "";
                        }
                        else if(count == 6){
                            while (!con.equals("430,000") && !con.equals("430000") && !con.equals("fourhundredthirtythousand")){ 
                                con = reader.nextLine();
                                con = con.toLowerCase();
                                con = con.replaceAll("\\s", "");
                            }
                            con = "";
                        }
                        else if(count == 7){
                            while (!con.equals("corneranchors")){ 
                                con = reader.nextLine();
                                con = con.toLowerCase();
                                con = con.replaceAll("\\s", "");
                            }
                            con = "";
                        }
                        else{
                            while(!con.equals("")){ 
                                con = reader.nextLine();
                            }
                        }
                        count++;         
                    }

                    //puzzle 4 - recursive math
                    print("“Good job solving those questions. I also actually have a fun question for you!”", worm);
                    con = "!";
                    while(!con.equals("")){ 
                        con = reader.nextLine();
                    }
                    int x = (int)(Math.random() * (40-8+1) + 8);
                    print("“Let's say x = " + x + ".\nAnd also there is a function f(x), that will call itself if certain conditions are met.”", worm);
                    System.out.println("“f(x) = ");
                    System.out.println("if x < 10, then x");
                    System.out.println("if 10 ≤ x < 20, then f(x+2)");
                    System.out.println("if x ≥ 20, then f(x-15)");
                    System.out.println("\nWhat is the final answer?: ”");
                    con = "!";
                    String answer = String.valueOf(solveX(x));
                    con = reader.nextLine();
                    while(!con.equals(answer)){ 
                        con = reader.nextLine();
                    }
                    System.out.println("Correct!");
                    con = "";
                    count = 0;
                    part++;
                }    
            }
            else if(part == 3){//part == 3
                //just loops through filler text
                print(part3[count], null);
                count++;
                if(count == part3.length){
                    con = "";
                    count = 0;
                    part++;
                }
            }
            else{
                //goes through text, but without loop like previously
                print("Part 4: Sometimes a dance is better than disputation.", null);
                con = "-";
                while (!con.equals("")){ 
                    con = reader.nextLine();
                }
                print("Continuing your adventure, you enter a new area which looks like a disco club...", null);
                con = "-";
                while (!con.equals("")){ 
                    con = reader.nextLine();
                }
                print("And someone approaches you... Looks like a weird green fluff monster. And apparently it is now challenging you to a memorization dance battle.", null);
                con = "-";
                while (!con.equals("")){ 
                    con = reader.nextLine();
                }
                print("Don't worry the rules are simple " + name + ". The opponent will dance a sequences made up of 'w', 'a', 's', or 'd'. One move will show up at a time.", null);
                con = "-";
                while (!con.equals("")){ 
                    con = reader.nextLine();
                }
                print("Afterwards, you will enter, one at a time, the sequence. Meaning enter 'w', and then press enter. Do not type the whole sequence.", null);
                con = "-";
                while (!con.equals("")){ 
                    con = reader.nextLine();
                }
                print("Also, the sequence doesn't change if you mess up, up to 3 times. So that should make things a bit easier.", null);
                con = "-";
                while (!con.equals("")){ 
                    con = reader.nextLine();
                }
                print("But if you do mess up 3 times, then the character's sequence will reset.", null);
                con = "-";
                while (!con.equals("")){ 
                    con = reader.nextLine();
                }
                print("Good luck.", null);
                con = "-";
                while (!con.equals("")){ 
                    con = reader.nextLine();
                }
                System.out.print("\033[H\033[2J");

                //dances 1, 2, and 3 begin here
                danceTime(dance1);

                print("You completed the first dance- A new opponent approaches! This one looks like a crouton with a top hat.", null);
                con = "-";
                while (!con.equals("")){ 
                    con = reader.nextLine();
                }
                System.out.print("\033[H\033[2J");

                danceTime(dance2);

                print("You completed the second dance, and now comes the final round... This one looks like a character from Just Dance. Have fun with that.", null);
                con = "-";
                while (!con.equals("")){ 
                    con = reader.nextLine();
                }
                System.out.print("\033[H\033[2J");

                danceTime(dance3);

                print("You won! Great job. You opponent gives you the final gem💎, and right after that the dancing stage lifts up into a shining, blinding white light...", null);
                con = "-";
                while (!con.equals("")){ 
                    con = reader.nextLine();
                }
                System.out.print("\033[H\033[2J");

                print("And you find yourself back at Filliro's portal. How you went vertically up with the stage but horizontally through a portal is beyond my scope of science.", null);
                con = "-";
                while (!con.equals("")){ 
                    con = reader.nextLine();
                }
                System.out.print("\033[H\033[2J");

                print("Anyways, you are back now, and you find the client and give her the gems. To which you learn that it is actually part of her evil plan to take over the world but that's for another game that will probably never exist.", null);
                con = "-";
                while (!con.equals("")){ 
                    con = reader.nextLine();
                }
                System.out.print("\033[H\033[2J");

                //game end
                print("The end.\nThanks for playing.", null);
                done = true;

            }
        }
    }

    //color to reset text back to white
    public static final String white = "\u001B[0m";

    //function for printing text, used for printing character colors faster and for clearing screen
    public static void print(String text, Character ch){
        System.out.print("\033[H\033[2J");
        if(ch == null){
            System.out.println(white + text);
        }
        else{
            System.out.println(ch.getColor() + text);
        }
    }

    //recursive function for math problem
    public static int solveX(int x){
        if(x < 10){
            return(x);
        }
        else if(10 <= x && x < 20){
            return solveX(x+2);
        }
        else{
            return solveX(x-15);
        }
    }

    //dancing part that gets recalled for each character
    public static void danceTime(DanceCharacter dc){
        Scanner reader = new Scanner(System.in);  // Create a Scanner object
        String con = "";

        int level = dc.moves;
        dc.createDance(level);
        boolean done = false;
        int wrong = 0;
        int check = -1;

        while(!done){
            printMoves(dc);
            check = -1; //checks that user did not get the sequence wrong 3 times in a row
            for(int i = 0; i < level; i++){
                System.out.println(white + "What was move " + String.valueOf((int)(i+1)) + "?");
                con = reader.nextLine();

                // prompts moves one at a time
                if(!con.equals(dc.getMove(i))){
                    wrong++;
                    i = -1;
                    System.out.println("Incorrect...wait");
                    try{
                        Thread.sleep(2000);
                        System.out.print("\033[H\033[2J");
                    }   
                    catch(Exception e){
                        System.out.println("Fatal Error");
                    }    
                }

                // resets sequence when wrong 3 times in a row
                if(wrong == 3){
                    i = level+1;
                    check = level+1;
                    wrong = 0;
                    System.out.println("Resetting moves");
                    dc.createDance(level);
                    try{
                        Thread.sleep(2000);
                        System.out.print("\033[H\033[2J");
                    }   
                    catch(Exception e){
                        System.out.println("Fatal Error");
                    } 
                }
            }

            //finished sequence with not having 3 errors
            if(check != level+1){
                done = true;
            }
            
        }
        
    }

    //prints the moves of a dancing character with time pauses
    public static void printMoves(DanceCharacter dc){
        try{
            for(int i = 0; i < dc.moves; i++){
                System.out.println(white + "Move " + String.valueOf((int)(i+1)) + ":");
                System.out.println(dc.getColor() + dc.getMove(i));
                Thread.sleep(dc.getTime());
                System.out.print("\033[H\033[2J");
            }
        }
        catch(Exception e){
            System.out.println("Fatal error");
        }
    }
}