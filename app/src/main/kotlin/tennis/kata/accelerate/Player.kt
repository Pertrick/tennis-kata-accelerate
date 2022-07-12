package tennis.kata.accelerate

class Player (val name:String, private var point: Int = 0){

        private val pointDescription = listOf("Love", "Fifteen", "Thirty", "Forty");

        fun getPoint(): Int {
            return point;
        }

        fun winBall(){
            point += 1;
        }

        fun getPointDescription(): String {
            return pointDescription[point];
        }

    }