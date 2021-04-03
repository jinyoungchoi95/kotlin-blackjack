package blackjack

import blackjack.domain.participants.Dealer
import blackjack.domain.participants.Players
import blackjack.domain.participants.Player
import blackjack.ui.InputView
import blackjack.ui.OutputView

fun main() {
    val players = createPlayers()
    val dealer = Dealer()

    OutputView.printAllPlayerCards(players, dealer)

    gameStart(players, dealer)

    OutputView.printResult(players, dealer)

    val playersEarnRate = players.getPlayersEarnRate(dealer)
    OutputView.printGameWinning(playersEarnRate)
}

fun createPlayers(): Players {
    val names = InputView.inputPlayers()
    val bettingTable = InputView.inputBatting(names)

    return Players(
        names.zip(bettingTable) { name, money ->
            Player(name, initMoney = money)
        }
    )
}

fun gameStart(players: Players, dealer: Dealer) {
    for (player in players.values) {
        playerTurn(player)
    }
    dealerTurn(dealer)
}

fun playerTurn(player: Player) {
    var answer = "Y"
    while (answer == "Y" && player.checkCardDrawAvailable()) {
        answer = InputView.selectDrawCard(player.name)
        playSelection(player, answer)
    }
}

fun dealerTurn(dealer: Dealer) {
    OutputView.printDealerDrawInfo(dealer, dealer.checkCardDrawAvailable())
    dealer.drawCard()
}

fun playSelection(player: Player, answer: String) {
    if (answer == "Y") {
        player.drawCard()
        OutputView.printPlayerCards(player)
        return
    }
    player.stay()
}