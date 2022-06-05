package blackjack.domain.game

import blackjack.domain.card.Card

class Dealer {
    private val deck: Deck = shuffleNewDeck()

    fun drawCards(num: Int): List<Card> {
        val cards = mutableListOf<Card>()
        repeat(num) {
            cards.add(deck.draw())
        }
        return cards.toList()
    }

    fun drawOneCard(): Card {
        return deck.draw()
    }

    private fun shuffleNewDeck(): Deck {
        return STANDARD_52_CARD_DECK.shuffle()
    }

    companion object {
        private val STANDARD_52_CARD_DECK: Deck = Deck(Game.ALL_CARDS)
    }
}