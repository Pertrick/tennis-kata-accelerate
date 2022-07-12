package tennis.kata.accelerate

import kotlin.math.abs
class Game(p1: Player, p2: Player) {

     var player1: Player;
     var player2: Player;

    init {
        player1 = p1;
        player2 = p2;
    }

    enum class GameStatus(val value:String) {

        WIN("win"), ADVANTAGE("advantage"), DEUCE("deuce");
    }

    fun score(): String{
        return if(player1.getPoint() >= 3 &&  player2.getPoint() >= 3 ){
            if(abs(player2.getPoint() - player1.getPoint()) >=2){
                getLeadPlayer().name + " " + GameStatus.WIN.value;
            } else if (player1.getPoint() == player2.getPoint()){
                GameStatus.DEUCE.value
            } else{
                GameStatus.ADVANTAGE.value + " " + getLeadPlayer().name
            }

        } else if(player1.getPoint() > 3 && player2.getPoint() <=1){
                  player1.name + " " + GameStatus.WIN.value;
        }

        else if(player2.getPoint() > 3  && player1.getPoint() <=1){
                player2.name + " " + GameStatus.WIN.value;
        }

        else if(player2.getPoint() >= 3  && player2.getPoint() >=1){
            player1.name + " " + GameStatus.WIN.value;
        }
        else{
            player1.getPointDescription() + " " + player2.getPointDescription();
        }
    }

    fun getLeadPlayer():Player{
        return if(player1.getPoint() > player2.getPoint()){
            player1;
        } else{
            player2;
        }

    }







}