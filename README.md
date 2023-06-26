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
- [x] 초기핸드인지 확인한다.
- [x] 버스트핸드인지 확인한다.

### game state
- 카드를 받을 수 있다.
- 카드를 그만 받기 위해 stay할 수 있다.
#### initial hand
- [x] 카드를 받을 수 있다.
- [x] 생성 시 카드가 2장이상인 경우 예외가 발생한다. 
- [x] 카드를 받은 후 현재 보유카드가 2장인 경우 hit 상태가 된다.
- [x] 카드를 그만 받으려하는 경우 예외가 발생한다.
- [x] score를 계산하는 경우 예외가 발생한다.
#### hit
- [x] 카드를 받을 수 있다.
- [x] 생성 시 카드가 2장 미만인 경우 예외가 발생한다.
- [x] 생성 시 카드가 bust인 경우 예외가 발생한다.
- [x] 카드를 받고, 현재 카드 최소가 21을 넘는 경우 bust 상태가 된다.
- [x] 카드를 그만 받도록 stay 상태로 변경할 수 있다.
- [x] score를 계산하는 경우 예외가 발생한다.
#### stay
- [x] 생성 시 카드가 2장 미만인 경우 예외가 발생한다.
- [x] 생성 시 카드가 bust인 경우 예외가 발생한다.
- [x] 카드를 받으려는 경우 예외가 발생한다.
- [x] 카드를 그만받으려는 경우 예외가 발생한다.
- [x] score를 반환한다.
#### bust
- [x] 생성 시 카드가 2장 미만인 경우 예외가 발생한다.
- [x] 생성 시 카드가 bust가 아닌 경우 예외가 발생한다.
- [x] 카드를 받으려는 경우 예외가 발생한다.
- [x] 카드를 그만받으려는 경우 예외가 발생한다.
- [x] score를 반환한다.

### card deck
- [x] 카드 덱에는 52장의 카드가 저장되어있다.
- [x] 카드 덱에서 보유중인 카드를 deal하여 전달할 수 있다.
- [x] 카드 덱에서 보유중인 카드가 없는데 deal하는 경우 예외가 발생한다.

### player
- [x] 플레이어는 이름을 가질 수 있다.
- [x] 플레이어의 이름이 5자 초과일 경우 예외가 발생한다.
- [x] 플레이어의 초기 상태는 InitialHand이다.
- [x] 플레이어는 카드를 드로우받은 후 상태를 변경한다.
- [x] 현재 본인 카드점수를 반환할 수 있다.
- [x] 현재 본인의 카드 정보를 반환할 수 있다.

### blackjack game
- [x] 플레이어가 0명일 때 예외가 발생한다.
- [x] 현재 turn인 유저의 index를 알 수 있다.
- [x] firstDraw : 첫 2장의 카드를 모든 유저에게 draw한다.
  - [x] 현재 턴이 firstDraw 턴이 아닌 경우 예외가 발생한다. 
  - [x] draw 후 정보를 반환한다.
- [x] 현재 turn인 유저의 정보를 반환한다.
  - [x] 턴이 유효하지 않은데 반환하려하면 예외가 발생한다. 
- [x] 현재 turn인 유저에게 카드를 한장 draw 하고 그 정보를 반환한다.
- [x] 전체 게임 결과에 이름, 카드, 점수를 반환한다.

### input view
```
게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)
pobi,jason

pobi, jason에게 2장의 나누었습니다.
pobi카드: 2하트, 8스페이드
jason카드: 7클로버, K스페이드

pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
y
pobi카드: 2하트, 8스페이드, A클로버
pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason은 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason카드: 7클로버, K스페이드
```
- [x] 사람의 이름을 쉼표로 구분하여 입력받을 수 있다.
- [x] y, n으로 카드를 더 받을 지 반환할 수 있다.
- [x] 카드를 받은 후 현재 카드 정보를 출력한다.

### output view
```
pobi카드: 2하트, 8스페이드, A클로버 - 결과: 21
jason카드: 7클로버, K스페이드 - 결과: 17
```
- [x] 사람에게 나뉘어진 카드 정보를 출력할 수 있다.
- [x] 최종 카드를 계산한 결과를 출력할 수 있다.


## 블랙잭(딜러)
```
블랙잭 게임을 변형한 프로그램을 구현한다. 블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.

카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다.
게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며, 두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다. 21을 넘지 않을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다.
딜러는 처음에 받은 2장의 합계가 16이하이면 반드시 1장의 카드를 추가로 받아야 하고, 17점 이상이면 추가로 받을 수 없다.
딜러가 21을 초과하면 그 시점까지 남아 있던 플레이어들은 가지고 있는 패에 상관 없이 승리한다.
게임을 완료한 후 각 플레이어별로 승패를 출력한다.
```
### dealer
- [ ] 딜러는 종료상태가 아니라면 카드를 항상 한장만 보여준다.
- [ ] 딜러는 16이하의 점수일 경우 계속 카드를 받아야한다.
- [ ] 딜러는 17이상의 점수일 경우 강제로 stay한다.

### 승패
- [ ] 버스트를 상대할때는 항상 승리한다.
  - 따라서 딜러가 버스트면 플레이어는 항상 승리한다.
- [ ] 숫자가 같으면 무승부이다.
- [ ] 상대보다 21에 가까우면 승리한다.
- [ ] 상대보다 21에 멀면 패배한다.

- [ ] InitialHand와 Hit은 Running상태이므로 승패를 계산하려할 경우 예외가 발생한다.


### output view
```
딜러는 16이하라 한장의 카드를 더 받았습니다.

딜러 카드: 3다이아몬드, 9클로버, 8다이아몬드 - 결과: 20
pobi카드: 2하트, 8스페이드, A클로버 - 결과: 21
jason카드: 7클로버, K스페이드 - 결과: 17

## 최종 승패
딜러: 1승 1패
pobi: 승 
jason: 패
```
