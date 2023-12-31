# WorkerWholic

----
# API 명세서 📋
https://documenter.getpostman.com/view/30923517/2s9YeEbBbT

----
# ERD 다이어그램
![스크린샷 2023-11-27 오후 12 50 50](https://github.com/Kim-Jong-Gyu/WorkerWholic/assets/62927374/248f6d89-4212-49c7-ae48-dbf6bfe197a6)

---
# 기능 구현
- [ ]  **사용자 인증 기능**
    - 회원가입 기능
        - 새로운 사용자가 ID와 비밀번호의 형태로 서비스에 가입할 수 있다.
            - 이 때, 비밀번호는 암호화되어 저장
    - 로그인 및 로그아웃 기능
      - 로그인 시 "Access Token + Refresh Token 발행"
      - 로그아웃 시 "서버 DB Refresh Token 삭제"
- [ ]  **프로필 관리**
    - 프로필 자기소개 작성
    - 프로필 수정 기능
        - 비밀번호 수정 시 현재 비밀번호와 바꿀 비밀번호가 request에 포함되어야 한다.
        - 프로필 수정은 nickname, 이메일, 비밀번호, 자기소개 만 바꿀수 있다.
- [ ]  **게시물 CRUD 기능**
    - 게시물 작성, 조회, 수정, 삭제 기능
        - "Access Token"을 헤더에 함께 보내는 방식 구현 -> Client Local Storage에 저장되있다고 가정
- [ ]  **뉴스 피드 기능**
    - 뉴스 피드 페이지
        - 사용자가 다른 사용자의 게시물을 한 눈에 볼 수 있는 뉴스 피드 페이지 제공.
- [ ]  **댓글 CRUD 기능**
    - 댓글 작성, 조회, 수정, 삭제 기능
