# `팀 이름 : 어데가노` - `청년 정책 알림이`
  

해커그라운드 해커톤에 참여하는 `어데가노` 팀의 `청년 정책 알림이`입니다.





----------------------------------------------------------------------------------------------------------------------
## 참고 문서
- [순한맛](./REFERENCES_BASIC.md)
- [매운맛](./REFERENCES_ADVANCED.md)

## 제품/서비스 소개

<!-- 아래 링크는 지우지 마세요 -->
[제품/서비스 소개 보기](TOPIC.md)
<!-- 위 링크는 지우지 마세요 -->

## 오픈 소스 라이센스

<!-- 아래 링크는 지우지 마세요 -->
[오픈소스 라이센스 보기](./LICENSE)
<!-- 위 링크는 지우지 마세요 -->

## 설치 방법



### 사전 준비 사항

- 크롬 최신버전 https://www.google.com/chrome/
- 자신의 OS에 맞는 드라이버를 설치해서 Resource에 Driver파일에 넣으시면 됩니다 https://chromedriver.storage.googleapis.com/index.html?path=114.0.5735.16/ 

## 시작하기

- 기본적으로 생서앟는 리소스의 리소스 그룹은 모두 동일하게 설정합니다.

1. <Azure포털에서 리소스 생성> https://portal.azure.com/
   
  리소스 그룹 : 우리의 리소스를 모아둘 폴더 역할
Hackers Ground 구독에서는 저희가 직접 리소스 그룹을 만들 수 있는 권한이 없기에 패스하고

![image](https://github.com/hackersground-kr/httpsgithubcomjchyngHackerGround/assets/69470424/1ea48e1c-9d28-4d30-be93-310de43dd422)


아래와 같이 할당 받은 리소스 그룹에서 리소스들을 생성하겠습니다.
![image](https://github.com/hackersground-kr/httpsgithubcomjchyngHackerGround/assets/69470424/ba8e7832-494c-4ce0-887b-4e35d06a26d6)


할당 받은 리소스 내에서 만들기를 통해 리소스를 만들겠습니다.
![image](https://github.com/hackersground-kr/httpsgithubcomjchyngHackerGround/assets/69470424/accdd596-dcf1-44ad-b8df-4dbe9c4d27a7)



웹 앱을 만들어 주겠습니다

![image](https://github.com/hackersground-kr/httpsgithubcomjchyngHackerGround/assets/69470424/ef038d43-c2dc-4d72-bfe0-804693404817)

리소스 그룹 : 앞 서 할당 받은 리소스 그룹 선택 (필자의 경우 Hackers Ground)
인스턴스 정보 : {사용자 지정} - Ex) dhkim1206
게시 : 코드
런타임 스택 : Java 11
Java 웹 서버 스택 : Java Se(Embedded Web Server)
운영체제 : Linux
지역 : Korea Central
![image](https://github.com/hackersground-kr/httpsgithubcomjchyngHackerGround/assets/69470424/356680d7-a263-464d-bc2f-5114c4106483)
<Linux 플랜>
새로 만들기 클릭
가격 책정 플랜 - 기본 B1 선택

위의 사항을 입력 후 검토 + 만들기, 만들기
----------------------------------------------------------------------------------------------------------------------
똑같이 리소스 그룹에 드어가서 만들기를 진행합니다


![image](https://github.com/hackersground-kr/httpsgithubcomjchyngHackerGround/assets/69470424/b568c767-9385-44a5-a8d8-64b4cca37a43)

서버 이름 : {사용자 지정} - Ex) sqlserver-dhkim1206
위치 : korea central


<인증 방법>

SQL 인증 사용
서버 관리자 이름, 암호 작성
관리자 이름과 암호를 알아야 DB 접속 후 확인이 가능하기 때문에 메모해둡니다.

<네트워킹>

Azure 서비스 및 리소스가 이 서버에 액세스할 수 있도록 허용: 예

검토 + 만들기, 만들
----------------------------------------------------------------------------------------------------------------------

SQL 데이터베이스 생성
![image](https://github.com/hackersground-kr/httpsgithubcomjchyngHackerGround/assets/69470424/3a5add86-2a26-4130-82f7-73b9ff0c8513)

<데이터베이스 이름> : 사용자 지정 - Ex) sqldb-dhkim1206

<서버>

서버를 생성한 지 얼마 지나지 않았으면 선택지에 생성되지 않으니 새로고침 후 다시 하도록 합니다.
방금 생성한 서버 선택

만들기.

sqlserver-dhkim1206(필자 sql server이름 예시) -> 네트워킹 -> 방화벽 규칙 -> 클라이언트 ipv4 주소 추가

----------------------------------------------------------------------------------------------------------------------
Storage API 구성 설정하기

AzureSQL DB 연결 문자열 가져오기

SQL 데이터베이스 > 연결 문자열 > JDBC 값 복사

웹앱에 들어가서 -> 구성 -> 연결 문자열 -> 새 연결 문자열에서

이름: STORAGE

값: AzureSQL DB 연결 문자열 붙여넣은 후에 Pwd={your_password_here} 부분에 실제 DB 비밀번호 입력

형식: SQLAzure

하고 저장

github action 자동 배포 설정 방법
----------------------------------------------------------------------------------------------------------------------
웹 앱에 -> 배포센터 -> 소스 : Github
각 사용자 깃허브로 로그
조직 : hackerground-kr
리포지토리 : fork한 리포지토리 
분기 : main
워크플로 추가

저장 














