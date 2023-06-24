package blackjack.domain

import blackjack.domain.card.Card
import blackjack.domain.gamestate.GameState
import blackjack.domain.gamestate.InitialHand

class Player(
    val name: String,
    gameState: GameState = InitialHand(),
) {
    var gameState: GameState = gameState
        private set

    init {
        require(name.length <= NAME_LENGTH_LIMIT) { "플레이어 이름은 5자를 초과할 수 없다." }
    }

    fun draw(card: Card) {
        gameState = gameState.draw(card)
    }

    fun stay() {
        gameState = gameState.stay()
    }

    fun isBust(): Boolean = gameState.isBust()

    fun cards(): List<Card> = gameState.cards()

    fun hands(): Hands = Hands(name, cards())

    fun score(): Int = gameState.score()

    companion object {
        private const val NAME_LENGTH_LIMIT = 5
    }
}
