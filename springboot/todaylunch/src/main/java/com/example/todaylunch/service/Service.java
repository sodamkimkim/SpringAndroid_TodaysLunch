package com.example.todaylunch.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.example.todaylunch.dto.Food;
import com.example.todaylunch.dto.Store;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Service {
	private static Service instance;
	private List<Food> foodList = new ArrayList<Food>();
	private List<Store> storeList = new ArrayList<Store>();

	
	
	private Service() {
		sampledate();
	}
	
	public static Service getinstance() {
		if(instance == null) {
			return new Service();
		}
		return instance;
	}
	
	/**
	 * 해당하는 이름을 가진 Fooddto 를 반환합니다
	 * @param foodName
	 * @return
	 */
	public Food findFood(String foodName) {
		for (Food food : foodList) {
			if(food.getFoodName().equals(foodName)) {
				return food;
			}
		}
		return null;
		
		
	}
	


	/**
	 * 샘플 데이터 넣는 메서드입니다. 필요없을 시에 삭제해도 됩니다.
	 */
	public void sampledate() {
		ArrayList<String> list1 = new ArrayList<String>(); //밀면
		list1.add(CategoryType.NOODLE.toString());
		list1.add(CategoryType.SOUP.toString());
		list1.add(CategoryType.SEASON.toString());

		ArrayList<String> list2 = new ArrayList<String>(); // 국밥
		list2.add(CategoryType.RICE.toString());
		list2.add(CategoryType.SOUP.toString());

		ArrayList<String> list3 = new ArrayList<String>(); //샌드위치
		list3.add(CategoryType.INSTANT.toString());
		list3.add(CategoryType.DIET.toString());
		list3.add(CategoryType.OVERSEA.toString());

		ArrayList<String> list4 = new ArrayList<String>(); // 샐러드
		list4.add(CategoryType.DIET.toString());
		list4.add(CategoryType.INSTANT.toString());

		ArrayList<String> list5 = new ArrayList<String>(); //덮밥
		list5.add(CategoryType.RICE.toString());

		ArrayList<String> list6 = new ArrayList<String>(); // 돈
		list6.add(CategoryType.RICE.toString());
		list6.add(CategoryType.BUNSIG.toString());
		list6.add(CategoryType.OVERSEA.toString());


		ArrayList<String> list7 = new ArrayList<String>(); // 비빔
		list7.add(CategoryType.RICE.toString());

		ArrayList<String> list8 = new ArrayList<String>(); // 냉면
		list8.add(CategoryType.NOODLE.toString());
		list8.add(CategoryType.SOUP.toString());
		list8.add(CategoryType.SEASON.toString());

		ArrayList<String> list9 = new ArrayList<String>(); // 짬뽕
		list9.add(CategoryType.NOODLE.toString());
		list9.add(CategoryType.SOUP.toString());
		list9.add(CategoryType.OVERSEA.toString());

		ArrayList<String> list10 = new ArrayList<String>(); // 김밥
		list10.add(CategoryType.RICE.toString());
		list10.add(CategoryType.BUNSIG.toString());
		list10.add(CategoryType.INSTANT.toString());

		ArrayList<String> list11 = new ArrayList<String>(); // 유부
		list11.add(CategoryType.RICE.toString());
		list11.add(CategoryType.OVERSEA.toString());
		

		ArrayList<String> list12 = new ArrayList<String>(); // 보쌈
		list12.add(CategoryType.RICE.toString());

		ArrayList<String> list13 = new ArrayList<String>(); // 한정식
		list13.add(CategoryType.RICE.toString());

		ArrayList<String> list14 = new ArrayList<String>(); // 파스타
		list14.add(CategoryType.NOODLE.toString());
		list14.add(CategoryType.OVERSEA.toString());

		ArrayList<String> list15 = new ArrayList<String>(); // 볶음밥
		list15.add(CategoryType.RICE.toString());
		list15.add(CategoryType.OVERSEA.toString());

		ArrayList<String> list16 = new ArrayList<String>(); // 피자
		list16.add(CategoryType.OVERSEA.toString());
		list16.add(CategoryType.INSTANT.toString());

		ArrayList<String> list17 = new ArrayList<String>(); // 해장국
		list17.add(CategoryType.RICE.toString());
		list17.add(CategoryType.SOUP.toString());

		ArrayList<Store> storeList1 = new ArrayList<Store>();
		storeList.add(new Store("부산밀면", "부산시 진구 부산밀면",
				"http://here.busan.com/data/file/food_time/20120720232451240_C.JPG", 100));
		storeList.add(new Store("호랭이밀면", "부산시 진구 부산밀면2",
				"http://here.busan.com/data/file/food_time/20120720232451240_C.JPG", 120));

		ArrayList<Store> storeList2 = new ArrayList<Store>();
		storeList2
				.add(new Store("부산국밥", "부산시 진구 부산국밥", "https://t1.daumcdn.net/cfile/tistory/99D1683C5DA281F934", 200));
		storeList2.add(new Store("밀양국밥", "부산시 진구 밀양국밥",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSj3Y9nCjgra2bVyu6WKrfZkPoC6RZtY0Epkw&usqp=CAU",
				180));

		ArrayList<Store> storeList3 = new ArrayList<Store>();
		storeList3.add(new Store("서브웨이 서면점", "부산시 진구 서면 중앙대로 690",
				"https://www.newsfc.co.kr/news/photo/201903/35517_26006_224.jpg", 100));
		storeList3.add(new Store("샌드위치샵", "부산시 진구 샌드위치샵",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRkD-0GkCLKZSqq3wiSHzwxW6NP-ZriSQUdVw&usqp=CAU",
				180));

		ArrayList<Store> storeList4 = new ArrayList<Store>();
		storeList4.add(new Store("서브웨이 서면점", "부산시 진구 서면 중앙대로 690",
				"https://www.google.com/maps/uv?pb=!1s0x3568eb703cd22929:0xff0693e73247a117!3m1!7e115!4shttps://lh5.googleusercontent.com/p/AF1QipMuJtfcyodlHcVrig_e4UbnvzGrtZnQRG22IBn_%3Dw260-h175-n-k-no!5z7ISc66m0IOyEnOu4jOybqOydtCAtIEdvb2dsZSDqsoDsg4k!15zQ2dJZ0FRPT0&imagekey=!1e10!2sAF1QipMuJtfcyodlHcVrig_e4UbnvzGrtZnQRG22IBn_&hl=ko\"",
				100));
		storeList4.add(new Store("샐러디 부산서면점", "부산시 진구 중앙대로 668 에이원프라자 1층",
				"https://www.fnnews.com/resource/media/image/2020/09/09/202009091754581993_l.jpg", 0));
		storeList4.add(new Store("투고샐러드 삼정타워점", "부산광역시 부산진구 중앙대로 672 삼정타워 5층 509",
				"http://www.fcmedia.co.kr/news/photo/201704/9097_14140_558.jpg", 40));

		ArrayList<Store> storeList5 = new ArrayList<Store>(); //덮밥
		storeList5.add(new Store("홍대개미 삼정타워점", "부산광역시 부산진구 중앙대로 672 삼정타워 5층 507호",
				"https://blog.kakaocdn.net/dn/sb6f1/btradTqwUH1/H5kbCxz8UaBaFvOtQzKQyK/img.jpg", 40));
		storeList5.add(new Store("면작 삼정타워점", "부산광역시 부산진구 부전동 227-2번지 삼정타워 5층 508호",
				"https://t1.daumcdn.net/cfile/tistory/99B8674E5F17FB1307", 40));
		storeList5.add(new Store("동백초밥 서면점", "부산광역시 부산진구 부전2동 신천대로50번길 68",
				"https://mblogthumb-phinf.pstatic.net/MjAyMTEwMjJfODkg/MDAxNjM0ODk3MjY1MzMy.kvFkXfM8aN-gH71_jSEOMlIYos9YI2GqbDPSjNzoP5Qg.znHMBCCigwJE524qgDkPr3tkJwPNly3NZ6C72YizuZ0g.JPEG.velyvley0/1.jpg?type=w800",
				90));
		storeList5.add(new Store("마마도마 서면점", "부산광역시 부산진구 중앙대로680번길 41",
				"https://mblogthumb-phinf.pstatic.net/MjAyMDA1MjBfNSAg/MDAxNTg5OTQ0MTU5NDY1.wQ4X1kz0wnyH0_HpppwWelCirlRSfnjsJCGMg-0MCtwg.TcAIZhwHuErJH12ctM13g0RYObF0VOwumxrweiDla5cg.JPEG.ochawonjiha/SE-063b7b4b-81e1-48ff-adb4-42aea208342c.jpg?type=w800",
				200));

		ArrayList<Store> storeList6 = new ArrayList<Store>(); //돈까스
		storeList6.add(new Store("마마도마 서면점", "부산광역시 부산진구 중앙대로680번길 41",
				"https://mblogthumb-phinf.pstatic.net/MjAyMDA1MjBfNSAg/MDAxNTg5OTQ0MTU5NDY1.wQ4X1kz0wnyH0_HpppwWelCirlRSfnjsJCGMg-0MCtwg.TcAIZhwHuErJH12ctM13g0RYObF0VOwumxrweiDla5cg.JPEG.ochawonjiha/SE-063b7b4b-81e1-48ff-adb4-42aea208342c.jpg?type=w800",
				200));
		storeList6.add(new Store("대쿠이 부산직영점", "부산 부산진구 전포대로175번길 39 1층",
				"https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTEyMjJfMjI1%2FMDAxNTc2OTQ0OTE2NDY4.YNJ-sa12d4KlS3i4OHKLexV2v2QBgS7qMjEP4cnZGAsg.Vhk-kAnifCo2xhivlDInaThhp9IUsesHYNOKXu0u9nkg.JPEG.marveljinny%2Foutput_1826583792.jpg",
				200));

		ArrayList<Store> storeList7 = new ArrayList<Store>(); // 비빔밥
		storeList7.add(new Store("우정돌솥비빔밥", "부산 부산진구 동천로85번길 3",
				"https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODAxMjZfMjc1%2FMDAxNTE2OTU5NjU1NzA5._cX_D25lYSlO5nNiJJ9VCPw0W2qPPPMW5CO-1-RpyM4g.dQyCDCEy4C3zUJlKFzMIRE3OhSUSIUTKHASTE1UXM1kg.JPEG.jiruck%2FKakaoTalk_20180126_182503403.jpg",
				40));
		storeList7.add(new Store("고봉민김밥인 부산서면포스코점", "부산광역시 부산진구 중앙대로 668",
				"https://www.google.com/maps/uv?pb=!1s0x3568eb700c644a85%3A0x98d4bddc8f4a93f7!3m1!7e115!4shttps%3A%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipN9MN7wJOrA660eRJ0Zn7VY3OzeAFfBM_OD-Vuj%3Dw143-h95-n-k-no!5z6rOg67SJ66-86rmA67ClIC0gR29vZ2xlIOqygOyDiQ!15sCgIgAQ&imagekey=!1e10!2sAF1QipN9MN7wJOrA660eRJ0Zn7VY3OzeAFfBM_OD-Vuj&hl=ko#",
				100));
		ArrayList<Store> storeList8 = new ArrayList<Store>(); // 냉면
		storeList8.add(new Store("호랭이밀면 부산 서면본점", "부산광역시 부산진구 부전2동 중앙대로692번길 16",
				"https://www.google.com/maps/uv?pb=!1s0x3568eba2334102cb%3A0x79d9f03e30a7e520!3m1!7e115!4shttps%3A%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipNJzaAi8pas-NJ780NG8MgesMS867Ss2rmuFQ93%3Dw286-h192-n-k-no!5z7ISc66m0IOuDieuptCAtIEdvb2dsZSDqsoDsg4k!15sCgIgAQ&imagekey=!1e10!2sAF1QipNJzaAi8pas-NJ780NG8MgesMS867Ss2rmuFQ93&hl=ko#",
				100));
		storeList8.add(new Store("수향냉면", "부산광역시 부산진구 부전동 중앙대로680번가길 27",
				"https://www.google.com/maps/uv?pb=!1s0x3568eb6555c1d67f%3A0x11ff70773d6e9806!3m1!7e115!4shttps%3A%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipNGshKNJXURxPq9oyVHeuvaZRhKEsEelNraTBPG%3Dw94-h95-n-k-no!5z7ISc66m0IOuDieuptCAtIEdvb2dsZSDqsoDsg4k!15sCgIYIg&imagekey=!1e10!2sAF1QipOaKS7mHm_18XXkFqvz-KjYFJcvsGp7b8-nBMN9&hl=ko#",
				100));
		storeList8.add(new Store("서면 개금밀면", "부산광역시 부산진구 서면로68번길 39",
				"https://www.google.com/maps/uv?pb=!1s0x3568eb6555c1d67f%3A0x11ff70773d6e9806!3m1!7e115!4shttps%3A%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipNGshKNJXURxPq9oyVHeuvaZRhKEsEelNraTBPG%3Dw94-h95-n-k-no!5z7ISc66m0IOuDieuptCAtIEdvb2dsZSDqsoDsg4k!15sCgIYIg&imagekey=!1e10!2sAF1QipOaKS7mHm_18XXkFqvz-KjYFJcvsGp7b8-nBMN9&hl=ko#",
				100));

		ArrayList<Store> storeList9 = new ArrayList<Store>(); // 짬뽕
		storeList9.add(new Store("더시카고짬뽕 서면점", "부산광역시 부산진구 부전2동 중앙대로702번길 15",
				"https://www.google.com/maps/uv?pb=!1s0x3568ebd2ac57df95%3A0x9085ccbefcc23b04!3m1!7e115!4shttps%3A%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipO5opdba70e-W7w3hQPX_ixopUkoP5fZ-f_Pr4Y%3Dw286-h192-n-k-no!5z7ISc66m0IOynrOu9lSAtIEdvb2dsZSDqsoDsg4k!15sCgIYIg&imagekey=!1e10!2sAF1QipODsbExZMRsVCS_sPym98CxEZGikEHd1C_xdGU3&hl=ko#",
				100));
		storeList9.add(new Store("홍콩반점0410 서면점", "부산광역시 부산진구 중앙대로680번가길 38",
				"https://www.google.com/maps/uv?pb=!1s0x3568eb6f91477409%3A0x4f7d4e5a6fd9c984!3m1!7e115!4shttps%3A%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipO-BTymj9N6e7ZRp3PdmvA3ELH_rODoK_LeiHGl%3Dw94-h95-n-k-no!5z7ISc66m0IOynrOu9lSAtIEdvb2dsZSDqsoDsg4k!15sCgIYIQ&imagekey=!1e10!2sAF1QipPm1mZiM3unypgG9VQVBghssnMnG4UnUJoG6l7U&hl=ko#",
				100));

		ArrayList<Store> storeList10 = new ArrayList<Store>(); // 김밥
		storeList10.add(new Store("고봉민김밥인 부산서면포스코점", "부산광역시 부산진구 중앙대로 668",
				"https://www.google.com/maps/uv?pb=!1s0x3568eb700c644a85%3A0x98d4bddc8f4a93f7!3m1!7e115!4shttps%3A%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipN9MN7wJOrA660eRJ0Zn7VY3OzeAFfBM_OD-Vuj%3Dw143-h95-n-k-no!5z6rOg67SJ66-86rmA67ClIC0gR29vZ2xlIOqygOyDiQ!15sCgIgAQ&imagekey=!1e10!2sAF1QipN9MN7wJOrA660eRJ0Zn7VY3OzeAFfBM_OD-Vuj&hl=ko#",
				100));
		storeList10.add(new Store("김가네 서면1번가점", "부산광역시 부산진구 부전2동 신천대로62번길 62",
				"https://www.google.com/maps/uv?pb=!1s0x3568eb464ff4cb37%3A0x558e7e558b4665e6!3m1!7e115!4shttps%3A%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipN2lDcClkj2gwzz9egNQYXr7RxafA59zRmytmQZ%3Dw190-h192-n-k-no!5z6rmA6rCA64Sk6rmA67ClIC0gR29vZ2xlIOqygOyDiQ!15sCgIgAQ&imagekey=!1e10!2sAF1QipN2lDcClkj2gwzz9egNQYXr7RxafA59zRmytmQZ&hl=ko#",
				100));
		storeList10.add(new Store("할매충무김밥", "부산광역시 부산진구 서면로 30",
				"https://www.google.com/maps/uv?pb=!1s0x3568eb7054b1b1e5%3A0x3c5281f25a189ca5!3m1!7e115!4shttps%3A%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipPfaEWIimPctEPAliiJ91cPQJrPxDkZ9sbwM0HJ%3Dw143-h95-n-k-no!5z7ISc66m0IOq5gOuwpSAtIEdvb2dsZSDqsoDsg4k!15sCgIgAQ&imagekey=!1e10!2sAF1QipPfaEWIimPctEPAliiJ91cPQJrPxDkZ9sbwM0HJ&hl=ko#",
				100));

		ArrayList<Store> storeList11 = new ArrayList<Store>(); // 유부
		storeList11.add(new Store("우성돈까스 삼정타워점", "부산광역시 부산진구 중앙대로 672 삼정타워 5F",
				"https://www.google.com/maps/uv?pb=!1s0x3568ebb06c704713%3A0x2ac6f0c2aece210a!3m1!7e115!4shttps%3A%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipMmtGRCI4AxvIQc_ecxdvgtsbVja8FuRVhO63NH%3Dw94-h95-n-k-no!5z7Jyg67aA7LSI67ClIC0gR29vZ2xlIOqygOyDiQ!15sCgIgAQ&imagekey=!1e10!2sAF1QipOZW2t4Odwp1RNooj06pVDvK1nMabB18jQ5F4_9&hl=ko#",
				100));
		storeList11.add(new Store("정직유부 서면1호점", "부산광역시 부산진구 부전동 번지 1층 198-7",
				"https://www.google.com/maps/uv?pb=!1s0x3568eb7aa0b52beb%3A0xc21f706fdbad6497!3m1!7e115!4shttps%3A%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipPYEJlXtylYy77yy7Plvnm9NDl1asWY4IThM_HI%3Dw286-h192-n-k-no!5z7Jyg67aA7LSI67ClIC0gR29vZ2xlIOqygOyDiQ!15sCgIgAQ&imagekey=!1e10!2sAF1QipPYEJlXtylYy77yy7Plvnm9NDl1asWY4IThM_HI&hl=ko#",
				100));

		ArrayList<Store> storeList12 = new ArrayList<Store>(); // 보쌈
		storeList12.add(new Store("행복한밥상 미밥", "부산 부산진구 중앙대로680번길 49",
				"https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fmyplace-phinf.pstatic.net%2F20220224_273%2F1645674443336e99zU_JPEG%2Fupload_f2824a11843780c551a18a5c0b700a9d.jpg",
				100));

		ArrayList<Store> storeList13 = new ArrayList<Store>(); // 한정식
		storeList13.add(new Store("행복한밥상 미밥", "부산 부산진구 중앙대로680번길 49",
				"https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fmyplace-phinf.pstatic.net%2F20220224_273%2F1645674443336e99zU_JPEG%2Fupload_f2824a11843780c551a18a5c0b700a9d.jpg",
				100));
		storeList13.add(new Store("밥상", "부산 부산진구 중앙대로 673",
				"https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTEwMDVfMjY3%2FMDAxNjMzNDMzMDYzMzUy.VOcmm-mM8vAow2av7VIWZ6QAjV0IvOLOVKTwrlJTBBog.s9M7XxdmOs4Zb0H9TaZuXwwjtGcNyAAabYTOrmVMlMYg.JPEG.kms112964%2F1633419718247%25A3%25AD28.jpg",
				100));

		ArrayList<Store> storeList14 = new ArrayList<Store>(); // 파스타
		storeList14.add(new Store("농부파스타", "부산 부산진구 중앙대로 672 5층",
				"https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTAxMjdfMjM3%2FMDAxNjExNzA4ODExNzAx.6a3uXbGqpm5Swj2i8rGsui3vbODvuoF5bnieUGvZQ-4g.FOFnnyTwiqNtVx1ybVtVJ9M1oVZKIPLxmQFMhQ56zQog.JPEG.kangjh126%2F20210125%25A3%25DF133109.jpg",
				100));
		storeList14.add(new Store("한끼맛있다 서면점", "부산 부산진구 중앙대로692번길 49",
				"https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2F20160417_81%2Ftnwls0698_1460879163033wS8Fw_JPEG%2FDSC02617.JPG",
				100));

		ArrayList<Store> storeList15 = new ArrayList<Store>(); // 볶음밥
		storeList15.add(new Store("한끼맛있다 서면점", "부산 부산진구 중앙대로692번길 49",
				"https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2F20160417_81%2Ftnwls0698_1460879163033wS8Fw_JPEG%2FDSC02617.JPG",
				100));
		ArrayList<Store> storeList16 = new ArrayList<Store>(); // 피자
		storeList16.add(new Store("EU 피자&파스타 서면 본점", "부산 부산진구 중앙대로680번길 29",
				"https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fpup-review-phinf.pstatic.net%2FMjAyMjA2MTBfMTIz%2FMDAxNjU0ODM0NDg0NzE3.SREP5mKiFRFAxzOZEuRLlgDVp5tFtxFFfiIOt-wZsC0g.EJT2DyZobxNVXtqkAfg_-9BacRCXhd3t1XGt5vdpQqYg.JPEG%2Fupload_81ca0b6b3be4db05b3bb85039f0d8689.jpeg",
				100));
		storeList16.add(new Store("솔탭하우스 서면삼정타워점", "부산 부산진구 중앙대로 672 삼정타워 8층",
				"https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fpup-review-phinf.pstatic.net%2FMjAyMjA2MDVfMjU3%2FMDAxNjU0MzU2NjgzMDk3.5qch0Vk2hRTuiNSlT0NHNj8rt4iWNwXLNI7ZAfzLo_8g.QzG8gLnlSRygjWR-apzOQNvCtJlrKD9xjkNTDcVKx3wg.JPEG%2Fupload_adbf4ba67d8958115eb173740feb0aa4.jpeg",
				100));

		ArrayList<Store> storeList17 = new ArrayList<Store>(); // 해장국
		storeList17.add(new Store("양평해장국&뼈다귀해장국", "부산광역시 부산진구 신천대로50번길 62",
				"https://www.google.com/maps/uv?pb=!1s0x3568ebabfebeb601%3A0x1466c8ce7af9b2dc!3m1!7e115!4shttps%3A%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipPNHVQ3NOseAQT4yfXuV7EUGjusOkjy3E1ztSMj%3Dw286-h192-n-k-no!5z7ISc66m0IO2VtOyepeq1rSAtIEdvb2dsZSDqsoDsg4k!15sCgIgAQ&imagekey=!1e10!2sAF1QipPNHVQ3NOseAQT4yfXuV7EUGjusOkjy3E1ztSMj&hl=ko#",
				100));

		Food food1 = new Food().builder().foodName("밀면")
				.url("https://cdn.pixabay.com/photo/2018/09/17/05/14/water-noodle-3683050__340.jpg").category(list1)
				.storelist(storeList1).build();

		Food food2 = new Food().builder().foodName("국밥")
				.url("https://cdn.pixabay.com/photo/2019/07/07/10/40/for-money-4322226__340.jpg").category(list2)
				.storelist(storeList2).build();

		Food food3 = new Food().builder().foodName("샌드위치")
				.url("https://cdn.pixabay.com/photo/2017/03/10/13/49/fast-food-2132863__340.jpg").category(list3)
				.storelist(storeList3).build();

		Food food4 = new Food().builder().foodName("샐러드")
				.url("https://cdn.pixabay.com/photo/2016/08/18/18/40/salad-1603608__340.jpg").category(list4)
				.storelist(storeList4).build();
		Food food5 = new Food().builder().foodName("덮밥")
				.url("https://cdn.pixabay.com/photo/2021/02/09/03/54/thai-food-5997307__340.jpg").category(list5)
				.storelist(storeList5).build();

		Food food6 = new Food().builder().foodName("돈까스")
				.url("https://cdn.pixabay.com/photo/2016/09/23/23/23/restaurant-1690696_960_720.jpg").category(list6)
				.storelist(storeList6).build();
		Food food7 = new Food().builder().foodName("비빔밥")
				.url("https://cdn.pixabay.com/photo/2017/08/08/09/44/food-photography-2610863_960_720.jpg")
				.category(list7).storelist(storeList7).build();
		Food food8 = new Food().builder().foodName("냉면")
				.url("https://cdn.pixabay.com/photo/2018/06/04/13/36/cold-noodles-3453218_960_720.jpg")
				.category(list8).storelist(storeList8).build();
		Food food9 = new Food().builder().foodName("짬뽕")
				.url("https://cdn.pixabay.com/photo/2018/12/03/01/04/spicy-seafood-3852529_960_720.jpg").category(list9)
				.storelist(storeList9).build();
		Food food10 = new Food().builder().foodName("김밥")
				.url("https://cdn.pixabay.com/photo/2016/02/28/07/47/kim-rice-1226569_960_720.jpg").category(list10)
				.storelist(storeList10).build();
		Food food11 = new Food().builder().foodName("유부초밥")
				.url("https://cdn.pixabay.com/photo/2019/12/15/10/37/inari-4696793_960_720.jpg").category(list11)
				.storelist(storeList11).build();
		Food food12 = new Food().builder().foodName("보쌈")
				.url("https://cdn.pixabay.com/photo/2015/05/02/00/56/bossam-749357_960_720.jpg").category(list12)
				.storelist(storeList12).build();
		Food food13 = new Food().builder().foodName("한정식")
				.url("https://cdn.pixabay.com/photo/2016/08/23/07/25/traditional-korean-meal-1613680_960_720.jpg")
				.category(list13).storelist(storeList13).build();
		Food food14 = new Food().builder().foodName("파스타")
				.url("https://cdn.pixabay.com/photo/2018/07/18/19/12/pasta-3547078_960_720.jpg").category(list14)
				.storelist(storeList14).build();

		Food food15 = new Food().builder().foodName("볶음밥")
				.url("https://cdn.pixabay.com/photo/2019/12/20/17/05/fried-rice-4708866_960_720.jpg").category(list15)
				.storelist(storeList15).build();
		Food food16 = new Food().builder().foodName("피자")
				.url("https://cdn.pixabay.com/photo/2020/06/08/16/49/pizza-5275191_960_720.jpg").category(list16)
				.storelist(storeList16).build();

		Food food17 = new Food().builder().foodName("해장국")
				.url("https://cdn.pixabay.com/photo/2015/07/08/19/40/food-836806_960_720.jpg").category(list17)
				.storelist(storeList17).build();

		addFood(food1);
		addFood(food2);
		addFood(food3);
		addFood(food4);
		addFood(food5);
		addFood(food6);
		addFood(food7);
		addFood(food8);
		addFood(food9);
		addFood(food10);
		addFood(food11);
		addFood(food12);
		addFood(food13);
		addFood(food14);
		addFood(food15);
		addFood(food16);
		addFood(food17);

	}
	
	/**
	 * foodDto에 있는 매장들을 storelist 에 집어 넣습니다.
	 * 거리별 매장을 빠르게 반환해주기 위해서 만들어둔 메서드입니다.
	 * @param food
	 */
	public void addFood(Food food) {
		food.getStorelist().forEach(store -> {
			if(!(storeList.contains(store))) {
				storeList.add(store);
			}		
		});
		foodList.add(food);
	}
	
	/**
	 * 해당 음식에 추가로 매장을 넣을 때 사용하는 메서드입니다.
	 * @param foodName
	 * @param store
	 */
	public void addStore(String foodName, Store store) {
		if(storeList.contains(store)) {
			return;
		}
		
		for (Food food : foodList) {
			if(food.getFoodName().equals(foodName)) {
				storeList.add(store);
				food.getStorelist().add(store);
				return;
			}
		}
	}
	
	
	/**
	 * 거리별 내림차순으로 순위(limit)까지 매장을 반환합니다.
	 * @param limit
	 * @return
	 */
	public List<Store> getNearStorelist(int limit) {
		sortStore();
		ArrayList<Store> nearStores = new ArrayList<Store>();
		for (int i = 0; i < limit; i++) {
			nearStores.add(storeList.get(i));
		}
		return nearStores;
	}
	
	/**
	 * 랜덤한 fooddto를 반환합니다. 두번 섞은 이유는 데이터가 많이 없어서
	 * 잘 안섞여서 두번 섞었습니다.
	 * @return
	 */
	public Food suffleFood() {
		ArrayList<Food> tempList = new ArrayList<Food>();
		tempList.addAll(foodList);
		Collections.shuffle(tempList);
		Collections.shuffle(tempList);
		return tempList.get(0);	
	}
	
	/**
	 * 매장을 거리별로 내림차순으로 정렬하는 메서드입니다.
	 */
	private void sortStore(){
		Collections.sort(storeList, new Comparator<Store>() {
			@Override
			public int compare(Store o1, Store o2) {
				int result = -1;
				if(o1.getDistance() >= o2.getDistance()) {
					result = 1;
				}
				return result;
			}
		});
	}
	
	/**
	 * 해당 카테고리별 food리스트를 반환합니다.
	 * @param category
	 * @return
	 */
	public List<Food> getCategoryFood(String category){
		ArrayList<Food> categoryFood = new ArrayList<Food>();
		for (Food food : foodList) {
			if(food.getCategory().contains(category)) {
				categoryFood.add(food);
			}
		}
		return categoryFood;
	}
	/**
	 * 해당 카테고리별 food리스트 중 랜덤으로 하나 뽑기
	 * 
	 * @param
	 * @return
	 */
	public Food getRandomCategoryFood(String category) {
		Food ramdomFood = new Food();
		ArrayList<Food> categoryFoods = new ArrayList<Food>();
		categoryFoods = (ArrayList<Food>) getCategoryFood(category);
		Collections.shuffle(categoryFoods);
		Collections.shuffle(categoryFoods);
		return categoryFoods.get(0);

	}

}
