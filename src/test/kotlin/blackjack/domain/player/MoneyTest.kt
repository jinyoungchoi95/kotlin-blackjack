package blackjack.domain.player

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MoneyTest : FunSpec({

    context("init") {
        test("돈이 0원 이하가 되는 경우 예외가 발생한다.") {
            val exception = shouldThrowExactly<IllegalArgumentException> { Money(0) }
            exception.message shouldBe "돈은 0원 이하가 될 수 없습니다."
        }
    }

    context("times") {
        test("값을 입력받아 곱한 돈을 반환한다.") {
            val actual = Money(10_000).times(1.5)
            actual shouldBe 15_000
        }
    }
})
