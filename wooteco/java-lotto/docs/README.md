# 기능 구현 목록

## UI

### InputView

- [x] 구입금액 입력 받기
- [x] 당첨 번호 입력 받기
- [x] 보너스 번호 입력 받기

### OutputView

- [x] 구입금액 입력 안내 멘트 출력
- [x] 구매 내역 출력
    - [x] 구매 개수 출력
    - [x] 구입한 로또 번호 출력
- [x] 당첨 번호 입력 안내 멘트 출력
- [x] 보너스 번호 입력 안내 멘트 출력
- [x] 당첨 통계 출력
    - [x] 등수 별 당첨 개수 출력
    - [x] 수익률 출력

---

## Controller

### LottoController

- [x] 구입금액만큼의 로또 발행 요청
- [x] 당첨 결과 계산 요청

---

## Domain

### Lotto

- [x] 로또 번호 리스트가 특정 값을 포함하는지 확인
- [x] 유효성 검사 : 숫자 개수가 적절한지 확인

### NumberGenerator

- [x] 번호 생성

### Cashier

- [x] 구입금액에 해당하는 로또 개수 계산
- [x] 유효성 검사 : 구입금액

### WinningCalculator

- [x] 입력한 당첨 숫자 변환
- [x] 여러 장의 로또에 대한 당첨 결과 계산
    - [x] 당첨 숫자를 포함하는 개수 계산

### ResultTable (Value Object)

- [x] 당첨 결과 개수 더하기
- [x] 당첨 결과 개수 반환
    - [x] 5등 개수 반환
    - [x] 4등 개수 반환
    - [x] 3등 개수 반환
    - [x] 2등 개수 반환
    - [x] 1등 개수 반환
- [x] 수익률 계산

### WinningResult (Enum)

- [x] 구현
- [x] 알맞은 결과 반환

## Constant

### LottoRule

- [x] 구현