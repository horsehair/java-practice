# 기능 구현 목록

## UI
### InputView
- [x] 다리 길이 입력
  - [x] (예외 처리) 숫자가 아닌 경우
- [x] 이동할 방향 입력
- [x] 게임 재시작 여부 입력

### OutputView
- [x] 게임 시작 안내
- [x] 이동 결과 출력
- [x] 최종 게임 결과 출력
- [x] 게임 성공 여부 출력
- [x] 총 시도한 횟수 출력
- [x] 에러 메시지 출력
---

## Controller
### BridgeController
- [x] 게임 실행
- [x] 한 턴의 이동 실행
  - [x] (실패 시) 게임 재시작 여부 확인
- [x] 최종 결과 반환
---

## Domain

### BridgeGame
- [x] 초기 설정
  - [x] 다리 생성
- [x] 진행 중인지 확인
- [x] 다리 상태 반환
- [x] 이동
- [x] 재시작
- [x] 시도 횟수 반환

### BridgeReferee
- [x] 현재 이동 성공 판단
- [x] 마지막 위치인지 판단

### BridgePicture
- [x] 생성
- [x] 현재 위치 반환
- [x] 현재 이동 기록
- [x] 현재 실패인지 확인
- [x] 현재 성공인지 확인
- [x] 현재 다리 반환

### BridgeMaker
- [x] 다리 생성
  - [x] (예외 처리) 잘못된 다리 길이

### BridgeRandomNumberGenerator
- [x] 다리 방향을 나타내는 랜덤 숫자 생성

### Moving (Enum)
- [x] 이동 방향 상수 집합 구현
- [x] 특정 커맨드의 값인지 확인
- [x] 특정 커맨드의 값 반환
  - [x] (예외 처리) 잘못된 이동 방향
- [x] 특정 숫자의 값인지 확인
- [x] 특정 숫자의 값 반환
- [x] 커맨드 반환

### GameCommand (Enum)
- [x] 게임 재시작 커맨드 상수 집합 구현
- [x] 특정 커맨드의 값인지 확인
- [x] 특정 커맨드의 값 반환
  - [x] (예외 처리) 잘못된 게임 재시작 여부
- [x] 커맨드 반환

### GameStatus (Enum)
- [x] 게임 상태 상수 집합 구현
- [x] 진행 중인지 확인
---

## Constant
### BridgeRule
- [x] 게임 전체 룰 상수 집합 구현
---