package tennis.kata.accelerate

import kotlin.math.abs
class Game(p1: Player, p2: Player) {

    private var player1: Player;
    private var player2: Player;

    init {
        player1 = p1;
        player2 = p2;
    }

    enum class GameStatus(val value:String) {

        WIN("won"), ADVANTAGE("advantage"), DEUCE("deuce");
    }

    fun play(): String{
        return if(player1.getPoint() > 3 &&  player2.getPoint() > 3 ){
            if(abs(player2.getPoint() - player1.getPoint()) >=2){
                getLeadPlayer().name + " " + GameStatus.WIN.value;
            } else if (player1.getPoint() == player2.getPoint()){
                GameStatus.DEUCE.value
            } else{
                GameStatus.ADVANTAGE.value + " " + getLeadPlayer().name
            }
        } else{
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