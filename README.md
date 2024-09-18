# 안드로이드 프로젝트 - Today's Lunch

## 선정 이유
: 오늘 점심 뭐 먹을까? 는 매일 하는 고민이지만 내일도 똑같이 뭐 먹지?에 대해서 고민하곤 합니다. 이러한 점을 착안하여 우리가 사용 할 점심메뉴를 골라주는 프로그램을 만들어보자
  라는 취지로 투데이 런치라는 프로그램을 선정하게 되었습니다.
  오늘 뭐먹지? 라는 어플을 참고하였습니다.
  
  기존의 어플과 차이점을 두기위해서 메뉴와 해당매뉴를 판매하는 가게들을 추천, 어떠한 것도 먹고 싶은것이 없어 "아무거나"만을 말하는 날을 생각하여 랜덤 추천 기능들을 추가하였습니다.
  또한 사용자가 직접 메뉴를 추가, 수정, 삭제 할수 있는 기능을 넣었습니다.

## ER 다이어그램
![image](https://user-images.githubusercontent.com/99931188/181588819-1e807f6c-6f96-4238-bb57-25dde334c3e8.png)


## 기능
1. 메뉴 카테고리별 매장 조회
2. 랜덤 메뉴 추천 + 가게 리스트
3. 카테고리별 랜덤 메뉴 추천
4. 메뉴 추가, 수정, 삭제

## 사용 기술
Android Studio, Gradle, retrofit2(http 메시지를 주고받기 위한), material 디자인 
## 작업 기간
#### 2022.06.09~2022.06.14 (약 5일)
----
## 화면 구성
### <시작화면>
![시작화면](https://user-images.githubusercontent.com/99931188/181199060-5e9a9bb9-ae46-4d77-91fd-3d72009e1d8e.jpg)

### <메인화면>
![메인화면](https://user-images.githubusercontent.com/99931188/181199313-4b13a9cc-8bd3-4584-b0b6-cdf480e11981.jpg)


### <메뉴 탭 구성 >
![탭 구성](https://user-images.githubusercontent.com/99931188/181200477-a404c485-539c-4bf8-8426-7a9c18656bbf.jpg)


### <랜덤 뽑기 이벤트>
![뽑기 이벤트](https://user-images.githubusercontent.com/99931188/181457911-738c1b33-6fab-44d4-80c5-810af2faaabb.gif)


2. 랜덤 메뉴 추천<br/>
![Screenshot_3](https://user-images.githubusercontent.com/99931188/181203092-0f1c4156-42a2-44cb-ae3b-513596fac5b9.jpg)
![Screenshot_4](https://user-images.githubusercontent.com/99931188/181203109-f70f4ad8-b897-49e4-921a-16b50b6c963f.jpg)

- 매장 클릭시 구글 맵 화면 띄움<br/>
![Screenshot_12](https://user-images.githubusercontent.com/99931188/181201455-370f3779-d7a1-452e-a554-06b6cc4c951c.jpg)


### <카테고리별 메뉴 화면><br/>
![Screenshot_5](https://user-images.githubusercontent.com/99931188/181200236-c73a1cca-77d8-4d13-a2a0-eaa2171c58db.jpg)
![Screenshot_6](https://user-images.githubusercontent.com/99931188/181200276-6161a757-d578-4c5c-b770-dae09b793bfb.jpg)
![Screenshot_7](https://user-images.githubusercontent.com/99931188/181200307-6f83c2dd-453e-4177-8be8-6cd372862207.jpg)

### <가까운 매장 추천><br/>
![Screenshot_10](https://user-images.githubusercontent.com/99931188/181200404-31f9afd4-ecdc-48ff-a3f0-76d0ada23c8a.jpg)

### <메뉴 수정, 삭제>
- 화면<br/>
![Screenshot_11](https://user-images.githubusercontent.com/99931188/181200632-794cc819-2ce5-49b5-a828-b33e2b2a8d2c.jpg)

- 메뉴 검색시 메뉴에 해당하는 데이터 내려받음<br/>
![Screenshot_13](https://user-images.githubusercontent.com/99931188/181201075-95f21e9d-c11d-4cbc-b11b-fa4c78422223.jpg)
- 수정<br/>
![Screenshot_14](https://user-images.githubusercontent.com/99931188/181201338-baaf4c13-3ebf-4f8a-ba8c-3dd90a07231f.jpg)
- 삭제<br/>
![삭제후](https://user-images.githubusercontent.com/99931188/181201397-2b0d493f-be84-4754-9be2-b76893b02010.jpg)






   
