public class DanceCharacter extends Character{
    //variable initializer
    int moves;
    int time;
    String[] dance;

    //constructor
    public DanceCharacter(String c, int m, int t){
        super(c);
        moves = m;
        dance = new String[moves];
        time = t;
    }

    //setter/mutator
    public void createDance(int m){
        for(int i = 0; i < dance.length; i++){
            dance[i] = way();
        }
    }

    //getters
    public String getMove(int m){
        return dance[m];
    }

    public int getTime(){
        return time;
    }
    
    //sets the specific dance moves of a character randomly
    public String way(){
        int num = (int)(Math.random()*(4)) + 1;
        if(num == 1){
            return "w";
        }
        else if(num == 2){
            return "a";
        }
        else if(num == 3){
            return "s";
        }
        else{
            return "d";
        }
    }
}
