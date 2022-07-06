# 블랙잭
> 블랙잭 게임을 변형한 프로그램을 구현한다. 블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.

## 기능 요구사항
- [x] 게임 준비 
  - [x] 게임을 시작하기 위해 카드 뭉치(Card Deck) 하나를 생성한다.
    - [x] 카드 뭉치는 중복되지 않는 52장(4 * 13)의 카드로 구성된다.
      - [x] 카드 뭉치에서 카드를 한 장씩 뽑을 수 있다.
      - [x] 한 번 뽑은 카드는 다시 뽑힐 수 없다.
    - [x] 카드는 4개의 모양과 13개의 숫자의 조합으로 만들어질 수 있다.
      - [x] 카드 무늬(Card Suit)는 하트(Heart), 다이아몬드(Diamond), 스페이드(Spade), 클럽(Club) 중 하나이다.
      - [x] 각 무늬당 카드는 Ace, 2-10, Jack, Queen, King 숫자에 대하여 13장씩 이루어져있다.
  - [x] 카드 셔플러는 카드 뭉치를 무작위로 섞는다.
    - [x] 카드를 섞고 난 이후 카드 개수는 같다.
    - [x] 카드를 섞으면서 카드가 바뀌지 않는다.
  - [x] 플레이어(Player)는 자신의 패에 카드를 추가할 수 있다.
    - [x] 플레이어는 배팅을 하는 플레이어(Gambler)와 게임을 진행하는 플레이어(Dealer) 중 하나이다.
    - [x] 배팅에 참여하기 위한 플레이어를 게임에 참여시킬 수 있다.
      - [x] 플레이어는 이름을 가지고 있다.
      - [x] 플레이어는 처음에 카드를 가지고 있지 않는다.
    - [x] 게임은 한 명의 딜러(Dealer)가 진행한다.
      - [x] 딜러가 카드덱에서 카드를 뽑을 수 있다.
      - [x] 딜러가 카드를 플레이어에게 나누어 줄 수 있다.
- [x] 게임 시작과 규칙
  - [x] 게임이 시작되면 카드 뭉치를 섞는다.
  - [x] 게임이 시작되면 딜러가 각 플레이어에게 카드 뭉치에서 카드를 2장씩 제공(Serving)한다.
    - [x] 플레이어 순서대로 한 장씩 2회 분배합니다. (Player A -> Player B -> Dealer -> Player A -> Player B -> Dealer)
    - [x] 각 플레이어에게 분배된 카드를 확인할 수 있다.
      - [x] 플레이어는 카드 패(Hand)를 통해 카드를 확인합니다. 
    - [x] 딜러가 뽑은 카드를 확인할 수 있다.
      - [x] 딜러의 카드는 첫번째 숫자가 10 혹은 에이스이면 두번째 카드를 공개하고 아니면 비공개한다.    
  - [x] 플레이어 순서대로 원하는만큼 카드를 더 받을 수 있다. (Hit or Stay)
    - [x] 21점이 넘으면 더 뽑을 수 없다. (Bust)
  - [x] 모든 플레이어가 카드를 뽑으면 딜러는 패를 공개하고 정해진 규칙에 의해 카드를 더 뽑거나 뽑지 말아야 한다.
    - [x] 딜러의 카드 총합이 16이하이면 더 뽑아야 한다.
    - [x] 딜러의 카드 총합이 17이상이면 멈추어야 한다.
  - [x] 플레이어의 점수를 계산한다.
    - [x] 점수는 각 카드의 숫자를 모두 더한다.
    - [x] Ace 는 1점 혹은 11점 중 유리한 숫자로 한다.
    - [x] Jack, Queen, King 은 10점으로 한다.
- [x] 게임 종료
  - [x] 각 플레이어별 점수를 확인할 수 있다. 
  - [x] 딜러와 각 플레이어 점수를 통해 승패를 결정할 수 있다. (딜러 vs 플레이어)
    - [x] 21점을 넘으면 패배한다.
    - [x] 21점이면 우승한다.
      - [x] 딜러와 플레이어가 동시에 21이면 무승부이다. (Push)
    - [x] 21점에 가장 가까운 사람이 우승한다.
  - [x] 딜러와 각 플레이어의 게임 결과(승/패/무)를 확인할 수 있다.
    
