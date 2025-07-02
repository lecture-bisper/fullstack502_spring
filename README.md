# 풀스택 502반
## Spring 수업 자료

---

1. 1일차 (springtest, test2, test3, board1)
	1. 첫 스프링부트 프로젝트 생성하기
	2. 스프링 MVC 프로젝트 생성하기
	3. start.spring.io 사이트를 통해서 스프링 MVC 프로젝트 생성하기
	4. 스프링부트 게시판 - 프로젝트 생성하기
	5. 스프링부트 게시판 - 데이터베이스 연동 (MyBatis, DTO, Mapper)
	6. 스프링부트 게시판 - Controller, Service 작성 (게시물 목록)
	7. 스프링부트 게시판 - View 작성 (게시물 목록)
2. 2일차 (board1)
	1. thymeleaf 문법 - thymeleaf 사용 설정
	2. thymeleaf 문법 - Controller, DTO, View 작성
	3. thymeleaf 문법 - 변수 사용, 리소스 번들, 링크 URL 사용
	4. thymeleaf 문법 - 선택 변수, 문자열, 문자열 대치, 숫자, Boolean
	5. thymeleaf 문법 - 산술 연산자, 비교 연산자
	6. thymeleaf 문법 - 조건문(삼항 연산자, if/unless, switch ~ case)
	7. thymeleaf 문법 - 반복문(배열, 리스트, 상태변수)
3. 3일차 (board1)
	1. thymeleaf 문법 - 속성값 변경(attr, attrappend, attrprepend)
	2. thymeleaf 문법 - 고정값 논리 속성 변경
	3. thymeleaf 문법 - fragment 사용
	4. board1 - 게시판 글 등록하기, 게시판 글 상세보기
4. 4일차 (board1)
	1. board1 - 게시판 글 수정하기, 게시판 글 삭제하기
	2. bootstrap - 프로젝트에 포함하기, grid system, container
	3. bootstrap - 타이포그라피, 테이블, 테마색상, 버튼
	4. bootstrap - 유틸리티 (border, rounded, float, clearfix, spacing, size)
5. 5일차 (jquery)
	1. jQuery - jquery 설치(다운로드, CDN), jquery 사용법, html 로딩 후 자바스크립트 동작 이벤트, 이벤트 등록 삭제(on, off, one), 마우스/키보드/폼 이벤트
	2. jQuery - 이펙트 함수 (show, hide, toggle, slide, fade)
6. 6일차 (jquerytest)
	1. jQuery - 이펙트 함수 (animate, stop), 체이닝기법
	2. jQuery - 컨텐츠에서 데이터 가져오기, 설정하기 (text, html, val, attr)
	3. jQuery - html 태그 추가/삭제 (append, prepend, after, before, remove, empty), 클래스 추가/삭제(addClass, removeClass, toggleClass)
	4. jQuery - 트래버싱 (parent, parents, parentUntil, children, find, siblings, next, nextAll, nextUntil, first, last, eq, filter, not)
7. 7일차 (jquerytest)
	1. Ajax - ajax 를 사용하지 않고 계산기 만들기
	2. Ajax - ajax 를 사용한 계산기 만들기
	3. Ajax - ajax 를 사용하여 select box의 데이터 수정하기
	4. ajax - ajax 문제 2개 풀이
8. 8일차 (board2)
	1. board2 - 게시판 목록 보기
	2. board2 - 게시판 글 상세보기
	3. board2 - 게시판 글 등록하기
	4. board2 - AuthController (로그인, 로그인 처리, 로그인 실패, 로그아웃)
	5. board2 - AuthService, AuthMapper, sql-auth.xml, UserDTO
	6. board2 - View Templates(login, loginFile, loginOK, logout, join)
9. 9일차 (board2)
	1. board2 - 인터셉터를 사용한 로그인 처리
	2. board2 - 파일 업로드 용 라이브러리 추가
	3. board2 - 파일 업로드를 위한 FileDTO, Controller, Service 추가
	4. board2 - 파일 업로드를 위한 Mapper, sql-board.xml 추가
	5. board2 - 첨부파일 목록을 위한 boardDetail.html, Service, Mapper, xml 추가
	6. board2 - 파일 다운로드를 위한 Controller, Service, Mapper, xml, View 추가
10. 10일차 (outsideDir, board3)
	1. outsideDir - 외부 폴더 등록하여 사용하기
	2. outsideDir - 스케쥴러 사용하기
	3. board3 - REST 방식 게시판 만들기 (Controller)
	4. board3 - REST 방식 게시판 만들기 (Service, DTO, Mapper, xml)
	5. board3 - REST API 라이브러리 만들기 및 테스트 (ApiController)
11. 11일차 (board3, xmljsonparser)
	1. board3 - Paging 사용하기 (PageHelper 라이브러리추가)
	2. board3 - Paging 사용하기 (BoardPagingController, PageBoardService, PageBoardMapper, sql-page-board.xml, page/boardList.html)
	3. xmljsonparser - open api 사용하기 (JAXB 라이브러리 추가)
	4. xmljsonparser - open api 사용하기 (xml 파일 파싱, ParserController, ParserService, fullDataFile)
	5. xmljsonparser - open api 사용하기 (open Api url 파싱, ParserController, ParserService, fullDataUrl, ajax 사용)
12. 12일차 (jpatest)
	1. jpatest - Jpa 사용 설정하기 (옵션별 데이터베이스 동작 확인)
	2. jpatest - Entity 로 데이터베이스 테이블 생성 및 data.sql 로 더미데이터 추가
	3. jpatest - JpaReposity 의 기본 메소드, 쿼리 메소드 (생성 방법 및 사용 방법 설명)
	4. jpatest - JpaReposity 의 기본 메소드 사용하기
13. 13일차 (jpatest, board4, board5)
	1. board4 - JPA를 사용한 게시판 만들기, DB세팅
	2. board4 - Entity, Repository 생성
	3. board4 - Controller, Service, View Templates 생성 및 전체 테스트
	4. board5 - JPA 에서 Entity 관계 설정하기 (OneToOne, ManyToOne, OneToMany)
	5. jpatest - JPA Audit 기능 사용, Entity 상속
14. 14일차 (jpastudy, jpastudy2)
	1. jpastudy - jpa의 Entity 클래스로 테이블 만들기(JpaBoardEntity, JpaReplyEntity, JpaProviderEntity, JpaProductEntity, JpaProductDetailEntity)
	2. jpastudy - jpa Entity 클래스 관계 설정하기 (@OneToOne, @OneToMany, @ManyToOne, @JoinColumn, @ToString.Exclude)
	3. jpastudy - JpaRepository의 기본 메소드 사용하기 (find, findAll, count, save, saveAll, delete, deleteById, deleteAll)
	4. jpastudy2 - Employees Entity 클래스 생성하기
	5. jpastudy2 - JpaRepository 의 쿼리 메소드 생성하기
	6. jpastudy2 - JpaRepository 의 @Query 어노테이션 사용하기