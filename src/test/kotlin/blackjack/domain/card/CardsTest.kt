package blackjack.domain.card

import blackjack.domain.card.CardTest.Companion.SPADE_ACE
import blackjack.domain.card.CardTest.Companion.SPADE_JACK
import blackjack.domain.card.CardTest.Companion.SPADE_KING
import blackjack.domain.card.CardTest.Companion.SPADE_QUEEN
import blackjack.domain.card.CardTest.Companion.SPADE_TWO
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class CardsTest : FunSpec({

    context("init") {
        test("중복된 카드가 저장될 경우 예외가 발생한다.") {
            val givenCards = mutableListOf(SPADE_ACE, SPADE_ACE)
            val exception = shouldThrowExactly<IllegalArgumentException> { Cards(givenCards) }
            exception.message shouldBe "중복된 카드가 저장될 수 없다."
        }

        test("카드 리스트를 생성한다.") {
            val actual = Cards(mutableListOf(SPADE_ACE, SPADE_TWO))
            actual.values shouldHaveSize 2
        }
    }

    context("add") {
        test("중복된 카드를 더하는 경우 예외가 발생한다.") {
            val cards = Cards.of(SPADE_ACE)
            val exception = shouldThrowExactly<IllegalArgumentException> { cards.addCard(SPADE_ACE) }
            exception.message shouldBe "이미 존재하는 카드를 추가할 수 없다."
        }

        test("카드를 추가할 수 있다.") {
            val cards = Cards()
            val actual = cards.addCard(SPADE_TWO)
            actual.values shouldHaveSize 1
        }
    }

    context("isInitialHand") {
        test("초기 핸드인지 확인할 수 있다.") {
            val cards = Cards.of(SPADE_ACE)
            val actual = cards.isInitialHand()
            actual shouldBe true
        }

        test("초기 핸드가 아닌지 확인할 수 있다.") {
            val cards = Cards.of(SPADE_ACE, SPADE_TWO)
            val actual = cards.isInitialHand()
            actual shouldBe false
        }
    }

    context("isBust") {
        forAll(
            row(listOf(SPADE_ACE, SPADE_TWO), false),
            row(listOf(SPADE_ACE, SPADE_KING, SPADE_JACK), false),
            row(listOf(SPADE_ACE, SPADE_KING, SPADE_JACK, SPADE_QUEEN), true),
            row(listOf(SPADE_TWO, SPADE_KING, SPADE_JACK), true),
        ) { input, expected ->
            test("${input}은 버스트가 ${expected}이다") {
                val cards = Cards(input)
                val actual = cards.isBust()
                actual shouldBe expected
            }
        }
    }

    context("of") {
        test("card를 받아 생성한다.") {
            val actual = Cards.of(SPADE_ACE, SPADE_KING)
            actual.values shouldHaveSize 2
        }
    }
})