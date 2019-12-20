# ERICA_AndroidJava

기계공학과 2015040537 장창우

오픈소스SW기초 수업의 기말 프로젝트를 Android_Studio에서 Java언어를 사용하여 간단한 게임을 만들어 보려고 한다.

학업의 순서로는
1. Java언어에 대해서 학습
2. Android_Studio의 환경에 대해서 학습
3. Android_Studio내에서 Java언어를 사용한 여러가지 프로그램을 코딩하고 실행해본다.
4. 최종 프로그램으로는 농장 키우기 게임이나 RPG형태의 게임을 목표로 하고있다.

---------------------------------------------------------------------------------------------

study1과 study2는 terminal의  vi환경에서 java를 실습해본 것이고

study파일에 있는 JavaStudy3부터는 ubuntu의 이클립스 환경에서 java언어를 학습한 것이다.

- JavaStudy3 : 같은 패키지내 다른 클래스에서 변수를 설정하고 불러온다.

- JavaStudy4 : 사용자에게 입력값을 받아 총 합을 계산한 뒤 등급을 매긴다.

- JavaStudy5 : 입력된 베열의 값중 n번째로 큰 수를 찾는다.

- JavaStudy6 : 은행계좌 입출금 시스템을 만든다. (JavaStudy 3,4 의 융합)

- JavaStudy7 : 문자열에서 모음을 찾고 출력한다.

- JavaStudy8 : 입력된 두 배열의 값을 작은순으로 나열한다.

- JavaStudy9 : GUI1, 이클립스에서 GUI를 이용한 Frame과 Panel을 만들어본다.

- JavaStudy10 : GUI2, 이클립스에서 GUI를 이용한 환전기를 만든다.

- JavaStudy11 : GUI3, 이클립스에서 GUI와 이벤트 처리기를 이용해 숫자 찾기 게임을 만든다.

- JavaStudy12 : String을 입력받아서 길이가 20이 넘거나 null일때 예외처리를 해준다.

- JavaStudy13 : String을 받아서 그 안에 있는 정수를 찾아 정수의 합을 구한다. 다른 문자가 있다면 0으로 반환한다.

------------------------------------------------------------------------------------------

Android Studio를 사용한 간단한 게임 만들기

~2019.12.8

Android Studio를 사용하기 위해 Ubuntu에 Andorid Studio를 설치하고 java언어를 사용할 수 있게 JDK를 다운 받았다.
우분투상에서 간단한 게임을 시행하기 위해서는 안드로이드 스튜디오에 있는 에뮬레이터 기능을 사용하여 구현을 하거나
핸드폰을 연결하여 핸드폰에서 구현을 하는 방법이 있다. 버추얼박스의 우분투에서는 두 가지 기능이 모두 구현되지 않아서
버추얼박스에 다른 가상머신을 만들어서 우분투에 연결시킨뒤 구현해보려고 한다.

- https://github.com/limjinha95/DEMS_MoleGame 의 두더지게임의 코드를 기반으로 비슷하지만 기능이 추가된 농장가꾸기 게임을 만들어보려고 한다.
- https://kutar37.tistory.com/entry/Thread-handler%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EB%91%90%EB%8D%94%EC%A7%80%EA%B2%8C%EC%9E%84-2 링크에서 안드로이드 스튜디오의 Thread handler의 기능을 구현하였다.

------------------------------------------------------------------------------------------

- 2019.12.8

농장가꾸기 게임의 레이아웃과 두더지 게임의 레이아웃은 같지만 식물을 고를 부분, 잔액표시기, 여러가지 그림이 다르기 때문에 필요한 그림 이미지를 다운받아서 넣었고 기종 크기에 맞춰서 레이아웃을 설정하였다. 기존의 패키지명이 다르다 보니 아직 오류로 표시되는 부분이 많다.

- 2019.12.12

가장 중요한 3x3 농장부분이 표시가 되지 않아서 레이아웃의 디자인파트에서 gridlayout을 다운받아 표시되게 하였다. 또한 게임에 필요한 여러 문장들을 string.xml에 추가하여 여러번 사용할 수 있게 하였다.

- 2019.12.13

누를수 있는 버튼의 색깔을 지정해 주었고 에뮬레이터의 기종인 NEXUS 5크기에 맞춰서 다양한 그림들의 배치와 크기를 맞추었다.
또한 MainActivity를 작성하기 위하여 github에서 가져온 코드를 분석하여 앞으로 수정해 나가야 할 방향을 잡았다.

1. 원하는 게임에 맞게 각각의 버튼마다 Thread handler를 사용하여 기능을 추가할 것이다.
2. 물건을 구매하였을 때 가격을 정하고 내가 가진 돈에서 가격이 빠지고 추가되는 기능을 넣을 것이다.
3. 에뮬레이터를 끌 때 농장은 초기화 되지만 내가 가지고 있는 잔액은 그대로 남게 한다.

- 2019.12.19

Github에서 받아온 코드를 바탕으로 MainActivity의 import선언과 text, imege 선언을 하고 thread handler 구현을 하기 전 준비를 하였다.
안드로이드 스튜디오의 구동방법은 여러가지가 있는데 첫 번째로 안드로이드 스튜디오 내의 에뮬레이터를 사용하여 구동을 하는 방법이 있다. 하지만 버추얼박스 내의 안드로이드 스튜디오의 에뮬레이터 구동은 가상머신안에서 가상머신을 사용하기 때문에 불가하다고 판단되었다. 두 번째 방법으로는 안드로이드 기반의 핸드폰에 직접 연결하여 구동하는 방법이다. 하지만 버추얼박스에서는 핸드폰을 잘 인식하지 못한다고 커뮤니티를 통하여 알게 되었다. 그래서 생각해 낸 방법이 버추얼박스에 따로 에뮬레이터를 만들어서 우분투의 안드로이드 스튜디오와 연결하려고 해보았다. 이론상으로 가능했기 때문에 7일간 에뮬레이터를 안드로이드 스튜디오에 연결 해보려고 노력했다. 하지만 문제점을 해결할 수 없었고 다른 방법을 찾게되었다. 커뮤니티에 질문에 답글중 VM pro에서는 안드로이드 핸드폰을 인식하는데 문제가 없다는 블로그의 글을 보게 되었고 핸드폰을 연결할 수 있다면 두 번째 방법으로 구동할 수 있기 때문에 VM pro의 30일 체험판을 설치하였고 우분투를 설치하였다. VM pro에서는 핸드폰이 인식되었고 핸드폰의 안드로이드로 구동할 수 있었기 때문에 구동 방식은 핸드폰을 직접 연결해서 구동하는 것으로 채택하였다. 조건은 버추얼박스에서는 안되고 VM pro에서는 가능하다.

- 2019.12.20

버추얼박스의 우분투의 안드로이드 스튜디오에서 하던 작업을 모두 VM pro의 안드로이드 스튜디오로 가져왔다. 기존 두더지 게임의 thread와 handler를 응용하여 일정한 시간이 아닌 각 사물마다 다른 시간을 부여하여 상황이 발생 되도록 하였다. 또한 업그레이드를 할 수 있는 기능을 추가하여 기능을 실행했을 때 과일이 크는데 시간이 적게들고 일정 금액을 내가 보유한 금액에서 차감하여 실행되도록 하였다. 그리고 각 상황을 선택할 때 마다 어떤 상황에 대해 실행되는지 알림창이 뜨게 하였고 만약 기능을 실행했을 때 보유한 금액이 실행되는 금액보다 적다면 실행되지 않고 오류라고 문자열을 출력하도록 설정하였다. 시간이 없어서 정신없이 코딩을 하다보니 잘 안되는 부분도 많고 에뮬레이터를 Nexus 5행에서 갤럭시 노트 8로 변경하면서 크기를 다시 맞춰줘야 하는 부분이 있다.
