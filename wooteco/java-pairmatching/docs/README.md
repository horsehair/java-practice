# 기능 구현 목록

## UI
### InputView
- [x] 기능 번호 입력
- [x] 과정, 레벨, 미션 입력
  - [x] (예외 처리) 입력 형식 검증
- [x] 재매칭 여부 입력

### OutputView
- [x] 과정, 레벨, 미션 정보 출력
- [x] 페어매칭 결과 출력
- [x] 초기화 안내
- [x] 에러 메시지 출력
---

## Controller
### CourseController
- [x] 프로그램 실행
  - [x] 페어 매칭
    - [x] 이미 매칭된 미션 되묻기
  - [x] 페어 조회
  - [x] 페어 초기화
---

## Domain

### Courses
- [x] 생성
- [x] 코스 정보 반환
- [x] 미션 반환

### Course
- [x] 생성
- [x] 이름 반환
- [x] 레벨 정보 리스트 반환
- [x] 미션 반환

### Level
- [x] 생성
- [x] 미션 추가
- [x] 특정 이름의 레벨인지 확인
- [x] 레벨 정보 반환
- [x] 미션 반환

### Mission
- [x] 생성
- [x] 이름 반환
- [x] 매칭
  - [x] 매칭 결과 반환
  - [x] 3번 이상 매칭 시도 시 에러 출력
- [x] 매칭 이력이 있는지 확인

### Members
- [x] 코스 구분에 따른 멤버 목록 생성
- [x] 이름 목록 반환
- [x] 더이상 매칭이 불가능한지 확인
- [x] 페어 기록 저장
  - [x] 가능 여부 확인

### Member
- [x] 페어 기록 추가
- [x] 이전 페어 여부 확인

### CourseStatus (Value Object)
- [x] 생성
- [x] 과정 이름 반환

### LevelStatus (Value Object)
- [x] 생성
- [x] 레벨 정보 텍스트 반환

### MissionInfo (Value Object)
- [x] 생성
- [x] 값 반환
---

### FunctionCommand 
- [x] 구현
- [x] 커맨드에 맞는 메시지 반환
---