/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package tennis.kata.accelerate

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class PlayerTest {

    private val player = Player("Aisha");
    @Test
    fun initialScoreForPlayerIsZero() {
        Assertions.assertThat(player.getPoint()).isEqualTo(0)
    }


}
