# kotlin-blackjack

## dsl
```
introduce {
  name("박재성")
  company("우아한형제들")
  skills {
    soft("A passion for problem solving")
    soft("Good communication skills")
    hard("Kotlin")
  }
  languages {
    "Korean" level 5
    "English" level 3
  }
}
```

## 블랙잭
```
블랙잭 게임을 변형한 프로그램을 구현한다. 블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.

카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다.
게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며, 두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다. 21을 넘지 않을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다.
```

### denomination
- [x] 카드 번호는 1 ~ 10, k, q, j 가 존재한다.
- [x] ace는 1 또는 11로 계산될 수 있다.
- [x] k, q, j는 10으로 계산된다.

### suit
- [x] 문양은 스페이트, 클로버, 하트, 다이아몬드가 존재한다.

### card
- [x] 카드는 denomination과 suit의 조합으로 구성된다.

### cards
- [x] 카드 리스트에 카드가 중복되어 저장될 경우 예외가 발생한다.
- [x] 카드 리스트에 카드를 추가할 때 포함된 카드가 추가되는 경우 예외가 발생한다.
- [x] 카드를 추가한다.

### game state
- 카드를 받을 수 있다.
- 카드를 그만 받기 위해 stay할 수 있다.
#### initial hand
- [x] 카드를 받을 수 있다.
- [x] 카드를 받은 후 현재 보유카드가 2장인 경우 hit 상태가 된다.
- [x] 카드를 그만 받으려하는 경우 예외가 발생한다.
#### hit
- [ ] 카드를 받을 수 있다.
- [ ] 카드를 받고, 현재 카드 최소가 21을 넘는 경우 bust 상태가 된다.
- [ ] 카드를 그만 받도록 stay 상태로 변경할 수 있다.
#### stay
- [x] 카드를 받으려는 경우 예외가 발생한다.
- [x] 카드를 그만받으려는 경우 예외가 발생한다.
#### bust
- [x] 카드를 받으려는 경우 예외가 발생한다.
- [x] 카드를 그만받으려는 경우 예외가 발생한다.

### card deck
- [x] 카드 덱에는 52장의 카드가 저장되어있다.
- [x] 카드 덱에서 보유중인 카드를 deal하여 전달할 수 있다.
- [x] 카드 덱에서 보유중인 카드가 없는데 deal하는 경우 예외가 발생한다.

### player
- [x] 플레이어는 이름을 가질 수 있다.
- [x] 플레이어의 이름이 5자 초과일 경우 예외가 발생한다.
- [ ] 플레이어는 첫 딜(deal)에서 2장의 카드를 받을 수 있다.
- [ ] 21점이 넘는데 카드를 deal하는 경우 예외가 발생한다.
- [ ] 현재 본인의 카드 점수를 반환할 수 있다.

### input view
```
게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)
pobi,jason

pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
y
pobi카드: 2하트, 8스페이드, A클로버
pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason은 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason카드: 7클로버, K스페이드
```
- [ ] 사람의 이름을 쉼표로 구분하여 입력받을 수 있다.
- [ ] y, n으로 카드를 더 받을 지 반환할 수 있다.
- [ ] 카드를 받은 후 현재 카드 정보를 출력한다.

### output view
```
pobi, jason에게 2장의 나누었습니다.
pobi카드: 2하트, 8스페이드
jason카드: 7클로버, K스페이드

pobi카드: 2하트, 8스페이드, A클로버 - 결과: 21
jason카드: 7클로버, K스페이드 - 결과: 17
```
- [ ] 사람에게 나뉘어진 카드 정보를 출력할 수 있다.
- [ ] 최종 카드를 계산한 결과를 출력할 수 있다.
