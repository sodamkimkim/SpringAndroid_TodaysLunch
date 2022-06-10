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
		ArrayList<String> list = new ArrayList<String>();
		list.add(CategoryType.NOODLE.toString());
		list.add(CategoryType.SEASON.toString());
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add(CategoryType.RICE.toString());
		list2.add(CategoryType.SOUP.toString());
		
		ArrayList<String> list3 = new ArrayList<String>();
		list3.add(CategoryType.INSTANT.toString());
		list3.add(CategoryType.DIET.toString());
		
		ArrayList<String> list4 = new ArrayList<String>();
		list4.add(CategoryType.DIET.toString());
		list4.add(CategoryType.INSTANT.toString());
		
		ArrayList<String> list5 = new ArrayList<String>();
		list5.add(CategoryType.RICE.toString());
		list5.add(CategoryType.INSTANT.toString());
		
		ArrayList<Store> storeList = new ArrayList<Store>();
		storeList.add(new Store("부산밀면", "부산시 진구 부산밀면", "http://here.busan.com/data/file/food_time/20120720232451240_C.JPG", 100));
		storeList.add(new Store("부산밀면2", "부산시 진구 부산밀면2","http://here.busan.com/data/file/food_time/20120720232451240_C.JPG", 120));
		
		ArrayList<Store> storeList2 = new ArrayList<Store>();
		storeList2.add(new Store("부산국밥", "부산시 진구 부산국밥", "https://t1.daumcdn.net/cfile/tistory/99D1683C5DA281F934",200));
		storeList2.add(new Store("밀양국밥", "부산시 진구 밀양국밥", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSj3Y9nCjgra2bVyu6WKrfZkPoC6RZtY0Epkw&usqp=CAU",180));
		
		ArrayList<Store> storeList3 = new ArrayList<Store>();
		storeList3.add(new Store("서브웨이 서면점", "부산시 진구 서면 중앙대로 690","https://www.newsfc.co.kr/news/photo/201903/35517_26006_224.jpg", 100));
		storeList3.add(new Store("샌드위치샵", "부산시 진구 샌드위치샵","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRkD-0GkCLKZSqq3wiSHzwxW6NP-ZriSQUdVw&usqp=CAU", 180));
		
		ArrayList<Store> storeList4 = new ArrayList<Store>();
		storeList4.add(new Store("서브웨이 서면점", "부산시 진구 서면 중앙대로 690","https://www.google.com/maps/uv?pb=!1s0x3568eb703cd22929:0xff0693e73247a117!3m1!7e115!4shttps://lh5.googleusercontent.com/p/AF1QipMuJtfcyodlHcVrig_e4UbnvzGrtZnQRG22IBn_%3Dw260-h175-n-k-no!5z7ISc66m0IOyEnOu4jOybqOydtCAtIEdvb2dsZSDqsoDsg4k!15zQ2dJZ0FRPT0&imagekey=!1e10!2sAF1QipMuJtfcyodlHcVrig_e4UbnvzGrtZnQRG22IBn_&hl=ko\"", 100));
		storeList4.add(new Store("셀러디 부산서면점", "부산시 진구 중앙대로 668 에이원프라자 1층","https://www.fnnews.com/resource/media/image/2020/09/09/202009091754581993_l.jpg", 0));
		storeList4.add(new Store("투고샐러드 삼정타워점", "부산광역시 부산진구 중앙대로 672 삼정타워 5층 509","http://www.fcmedia.co.kr/news/photo/201704/9097_14140_558.jpg", 40));
		
		ArrayList<Store> storeList5 = new ArrayList<Store>();
		storeList5.add(new Store("홍대개미 삼정타워점", "부산광역시 부산진구 중앙대로 672 삼정타워 5층 507호","https://blog.kakaocdn.net/dn/sb6f1/btradTqwUH1/H5kbCxz8UaBaFvOtQzKQyK/img.jpg", 40));
		storeList5.add(new Store("면작 삼정타워점", "부산광역시 부산진구 부전동 227-2번지 삼정타워 5층 508호","https://t1.daumcdn.net/cfile/tistory/99B8674E5F17FB1307", 40));
		storeList5.add(new Store("동백초밥 서면점", "부산광역시 부산진구 부전2동 신천대로50번길 68","https://mblogthumb-phinf.pstatic.net/MjAyMTEwMjJfODkg/MDAxNjM0ODk3MjY1MzMy.kvFkXfM8aN-gH71_jSEOMlIYos9YI2GqbDPSjNzoP5Qg.znHMBCCigwJE524qgDkPr3tkJwPNly3NZ6C72YizuZ0g.JPEG.velyvley0/1.jpg?type=w800", 90));
		storeList5.add(new Store("마마도마 서면점", "부산광역시 부산진구 중앙대로680번길 41","https://mblogthumb-phinf.pstatic.net/MjAyMDA1MjBfNSAg/MDAxNTg5OTQ0MTU5NDY1.wQ4X1kz0wnyH0_HpppwWelCirlRSfnjsJCGMg-0MCtwg.TcAIZhwHuErJH12ctM13g0RYObF0VOwumxrweiDla5cg.JPEG.ochawonjiha/SE-063b7b4b-81e1-48ff-adb4-42aea208342c.jpg?type=w800", 200));
		
		Food food = new Food().builder().foodName("밀면").
				url("https://cdn.pixabay.com/photo/2018/09/17/05/14/water-noodle-3683050__340.jpg").
				category(list).
				storelist(storeList).
				build();
		
		Food food2 = new Food().builder().foodName("국밥").
				url("https://cdn.pixabay.com/photo/2019/07/07/10/40/for-money-4322226__340.jpg").
				category(list2).
				storelist(storeList2).
				build();
		
		Food food3 = new Food().builder().foodName("샌드위치").
				url("https://cdn.pixabay.com/photo/2017/03/10/13/49/fast-food-2132863__340.jpg").
				category(list3).
				storelist(storeList3).
				build();
		
		Food food4 = new Food().builder().foodName("셀러드").
				url("https://cdn.pixabay.com/photo/2016/08/18/18/40/salad-1603608__340.jpg").
				category(list4).
				storelist(storeList4).
				build();
		
		Food food5 = new Food().builder().foodName("덮밥").
				url("https://cdn.pixabay.com/photo/2021/02/09/03/54/thai-food-5997307__340.jpg").
				category(list5).
				storelist(storeList5).
				build();
		
		addFood(food);
		addFood(food2);
		addFood(food3);
		addFood(food4);
		addFood(food5);
		
	}
	
	/**
	 * foodDto에 있는 매장들을 storelist 에 집어 넣습니다.
	 * 거리별 매장을 빠르게 반환해주기 위해서 만들어둔 메서드입니다.
	 * @param food
	 */
	private void addFood(Food food) {
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

}
