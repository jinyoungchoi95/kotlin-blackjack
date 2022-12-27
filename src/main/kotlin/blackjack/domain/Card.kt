package blackjack.domain

import blackjack.domain.Point.Companion.ACE

enum class Card(
    val shape: Shape,
    val point: Point,
    val korean: String,
) {
    HEART_A(Shape.HEART, ACE, "A하트"),
    HEART_2(Shape.HEART, Point(2), "2하트"),
    HEART_3(Shape.HEART, Point(3), "3하트"),
    HEART_4(Shape.HEART, Point(4), "4하트"),
    HEART_5(Shape.HEART, Point(5), "5하트"),
    HEART_6(Shape.HEART, Point(6), "6하트"),
    HEART_7(Shape.HEART, Point(7), "7하트"),
    HEART_8(Shape.HEART, Point(8), "8하트"),
    HEART_9(Shape.HEART, Point(9), "9하트"),
    HEART_10(Shape.HEART, Point(10), "10하트"),
    HEART_J(Shape.HEART, Point(10), "J하트"),
    HEART_Q(Shape.HEART, Point(10), "Q하트"),
    HEART_K(Shape.HEART, Point(10), "K하트"),
    DIAMOND_A(Shape.DIAMOND, ACE, "A다이아몬드"),
    DIAMOND_2(Shape.DIAMOND, Point(2), "2다이아몬드"),
    DIAMOND_3(Shape.DIAMOND, Point(3), "3다이아몬드"),
    DIAMOND_4(Shape.DIAMOND, Point(4), "4다이아몬드"),
    DIAMOND_5(Shape.DIAMOND, Point(5), "5다이아몬드"),
    DIAMOND_6(Shape.DIAMOND, Point(6), "6다이아몬드"),
    DIAMOND_7(Shape.DIAMOND, Point(7), "7다이아몬드"),
    DIAMOND_8(Shape.DIAMOND, Point(8), "8다이아몬드"),
    DIAMOND_9(Shape.DIAMOND, Point(9), "9다이아몬드"),
    DIAMOND_10(Shape.DIAMOND, Point(10), "10다이아몬드"),
    DIAMOND_J(Shape.DIAMOND, Point(10), "J다이아몬드"),
    DIAMOND_Q(Shape.DIAMOND, Point(10), "Q다이아몬드"),
    DIAMOND_K(Shape.DIAMOND, Point(10), "K다이아몬드"),
    SPADE_A(Shape.SPADE, ACE, "A스페이드"),
    SPADE_2(Shape.SPADE, Point(2), "2스페이드"),
    SPADE_3(Shape.SPADE, Point(3), "3스페이드"),
    SPADE_4(Shape.SPADE, Point(4), "4스페이드"),
    SPADE_5(Shape.SPADE, Point(5), "5스페이드"),
    SPADE_6(Shape.SPADE, Point(6), "6스페이드"),
    SPADE_7(Shape.SPADE, Point(7), "7스페이드"),
    SPADE_8(Shape.SPADE, Point(8), "8스페이드"),
    SPADE_9(Shape.SPADE, Point(9), "9스페이드"),
    SPADE_10(Shape.SPADE, Point(10), "10스페이드"),
    SPADE_J(Shape.SPADE, Point(10), "J스페이드"),
    SPADE_Q(Shape.SPADE, Point(10), "Q스페이드"),
    SPADE_K(Shape.SPADE, Point(10), "K스페이드"),
    CLOVER_A(Shape.CLOVER, ACE, "A클로버"),
    CLOVER_2(Shape.CLOVER, Point(2), "2클로버"),
    CLOVER_3(Shape.CLOVER, Point(3), "3클로버"),
    CLOVER_4(Shape.CLOVER, Point(4), "4클로버"),
    CLOVER_5(Shape.CLOVER, Point(5), "5클로버"),
    CLOVER_6(Shape.CLOVER, Point(6), "6클로버"),
    CLOVER_7(Shape.CLOVER, Point(7), "7클로버"),
    CLOVER_8(Shape.CLOVER, Point(8), "8클로버"),
    CLOVER_9(Shape.CLOVER, Point(9), "9클로버"),
    CLOVER_10(Shape.CLOVER, Point(10), "10클로버"),
    CLOVER_J(Shape.CLOVER, Point(10), "J클로버"),
    CLOVER_Q(Shape.CLOVER, Point(10), "Q클로버"),
    CLOVER_K(Shape.CLOVER, Point(10), "K클로버");

    fun isAce(): Boolean {
        return this in setOf(
            CLOVER_A,
            HEART_A,
            DIAMOND_A,
            SPADE_A,
        )
    }
}
