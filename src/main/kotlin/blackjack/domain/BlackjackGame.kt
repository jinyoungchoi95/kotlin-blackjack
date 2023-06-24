package blackjack.domain

import blackjack.domain.card.CardDeck

class BlackjackGame(
    turn: Int = -1,
    val players: List<Player>,
    val cardDeck: CardDeck = CardDeck.randomCardDeck(),
) {
    var turn: Int = turn
        private set

    fun firstDraw(): List<DrawResult> {
        check(turn == BEFORE_FIRST_DRAW_TURN) { "first draw 턴이 아닙니다." }
        players.forEach { it.draw(cardDeck.draw()) }
        players.forEach { it.draw(cardDeck.draw()) }
        turn++
        return players.map { it.currentStatus() }
    }

    fun currentPlayerDraw(): DrawResult {
        val player = currentPlayer()
        player.draw(cardDeck.draw())
        return DrawResult(playerName = player.name, cards = player.gameState.cards())
    }

    fun isEndGame(): Boolean = players.size == turn

    fun currentTurnPlayerName(): String = currentPlayer().name

    private fun currentPlayer(): Player {
        check(turn != BEFORE_FIRST_DRAW_TURN) { "첫 드로우가 시작되지 않았다." }
        check(turn < players.size) { "모든 드로우가 종료되었다." }
        return players[turn]
    }

    companion object {
        private const val BEFORE_FIRST_DRAW_TURN = -1

        fun from(playerNames: List<String>) = BlackjackGame(players = playerNames.map { Player(it) })
    }
}
