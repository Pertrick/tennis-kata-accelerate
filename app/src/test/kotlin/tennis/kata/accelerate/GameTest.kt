package tennis.kata.accelerate


import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class GameTest {

    lateinit var player1:Player;
    lateinit var player2:Player;
    lateinit var game:Game;

    @BeforeEach
    fun gameSetup(){
        player1 = Player("Aisha");
        player2 = Player("Williams");
        game = Game(player1, player2);

    }

    @Test
    fun loveShouldBeTheDescriptionForScore0(){
        var game = Game(player1, player2);
        Assertions.assertThat(game.score()).isEqualTo("Love Love");
    }

    @Test
    fun fifteenShouldBeTheDescriptionForScore1(){
        player2.winBall();
        Assertions.assertThat(game.score()).isEqualTo("Love Fifteen");
    }

    @Test
    fun thirtyShouldBeTheDescriptionForScore2(){
        player1.winBall();
        player1.winBall();
        player2.winBall();
        Assertions.assertThat(game.score()).isEqualTo("Thirty Fifteen");
    }

    @Test
    fun fortyShouldBeTheDescriptionForScore2(){
        for(i in 1..3){
            player1.winBall();
        }

        player2.winBall();
        Assertions.assertThat(game.score()).isEqualTo("Forty Fifteen");
    }

    @Test
    fun deuceShouldBeTheDescriptionWhenEachPlayerHasScoredAtLeast3PointsAndTheScoresAreEqual(){
        for(i in 1..3){
            player1.winBall();
            player2.winBall();
        }
        Assertions.assertThat(game.score()).isEqualTo("deuce");
    }

    @Test
    fun advantageShouldBeTheDescriptionWhenEachPlayerHasScoredAtLeast3PointsAndAPlayerHasOnePointMoreThanHisOpponent(){
        for(i in 1..3){
            player2.winBall();
        }

        for(i in 1..4){
            player1.winBall();
        }

        Assertions.assertThat(game.score()).isEqualTo("advantage Aisha");
    }


    @Test
    fun gameShouldBeWonBYTheFirstPlayerToWin4PointsAndWithAtLeastTwoPointsMoreThanTheOpponent(){

        for(i in 1..4){
            player1.winBall();
        }

        player2.winBall();

        Assertions.assertThat(game.score()).isEqualTo("Aisha win");
    }





}