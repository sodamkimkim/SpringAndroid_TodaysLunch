package com.example.project.models;

import com.example.project.Define.CategoryType;

import java.util.ArrayList;
import java.util.List;

public class Food {
    //    NOODLE, RICE, SOUP, BUNSIG, DIET, INSTANT,OVERSEA, SEASON
    private String foodName;
    private String url;
    private List<String> category;
    private List<Store> storelist;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public List<Store> getStorelist() {
        return storelist;
    }

    public void setStorelist(List<Store> storelist) {
        this.storelist = storelist;
    }

    public Food() {
    }

    public Food(String foodName, String url, List<String> category, List<Store> storelist) {
        this.foodName = foodName;
        this.url = url;
        this.category = category;
        this.storelist = storelist;
    }

//    public static ArrayList<Food> getFoodData1() {
//        //대충 데이터 아무거나 들고와서 넣었어욤
//        ArrayList<String> list12 = new ArrayList<String>(); // 보쌈
//        list12.add(CategoryType.RICE.toString());
//
//        ArrayList<Store> storeList4 = new ArrayList<Store>();
//        storeList4.add(new Store(1, "서브웨이 서면점", "부산시 진구 서면 중앙대로 690",
//                "https://www.google.com/maps/uv?pb=!1s0x3568eb703cd22929:0xff0693e73247a117!3m1!7e115!4shttps://lh5.googleusercontent.com/p/AF1QipMuJtfcyodlHcVrig_e4UbnvzGrtZnQRG22IBn_%3Dw260-h175-n-k-no!5z7ISc66m0IOyEnOu4jOybqOydtCAtIEdvb2dsZSDqsoDsg4k!15zQ2dJZ0FRPT0&imagekey=!1e10!2sAF1QipMuJtfcyodlHcVrig_e4UbnvzGrtZnQRG22IBn_&hl=ko\"",
//                100));
//
//        ArrayList<Food> foodSamples = new ArrayList<>();
//        foodSamples.add(new Food("비빔밥", "https://cdn.pixabay.com/photo/2017/08/08/09/44/food-photography-2610863_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("칼국수", "https://cdn.pixabay.com/photo/2014/09/24/09/30/seafood-458853_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("짬뽕", "https://cdn.pixabay.com/photo/2018/12/03/01/04/spicy-seafood-3852529_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("떡볶이", "https://cdn.pixabay.com/photo/2016/02/26/11/42/toppokki-1223900_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("피자", "https://cdn.pixabay.com/photo/2020/06/08/16/49/pizza-5275191_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("샌드위치", "https://cdn.pixabay.com/photo/2017/03/10/13/49/fast-food-2132863_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("샐러드", "https://cdn.pixabay.com/photo/2016/09/15/19/24/salad-1672505_960_720.jpg", list12, storeList4));
//
//        foodSamples.add(new Food("만두", "https://cdn.pixabay.com/photo/2017/06/11/17/03/dumplings-2392893_960_720.jpg", list12, storeList4));
//
//        foodSamples.add(new Food("햄버거", "https://cdn.pixabay.com/photo/2020/03/21/11/17/burger-4953465_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("파스타", "https://cdn.pixabay.com/photo/2018/07/18/19/12/pasta-3547078_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("냉면", "https://cdn.pixabay.com/photo/2018/06/04/13/36/cold-noodles-3453218_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("김밥", "https://cdn.pixabay.com/photo/2016/02/28/07/47/kim-rice-1226569_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("연어덮밥", "https://cdn.pixabay.com/photo/2019/12/01/15/08/salmon-plate-with-rice-4665684_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("돈까스", "https://cdn.pixabay.com/photo/2016/09/23/23/23/restaurant-1690696_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("해장국", "https://cdn.pixabay.com/photo/2015/07/08/19/40/food-836806_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("유부초밥", "https://cdn.pixabay.com/photo/2019/12/15/10/37/inari-4696793_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("생선구이", "https://cdn.pixabay.com/photo/2017/05/23/04/51/grilled-fish-2336227_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("보쌈", "https://cdn.pixabay.com/photo/2015/05/02/00/56/bossam-749357_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("쌀국수", "https://cdn.pixabay.com/photo/2020/06/02/12/20/soup-5250765_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("타코", "https://cdn.pixabay.com/photo/2016/08/23/08/53/tacos-1613795_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("콩국수", "https://cdn.pixabay.com/photo/2021/06/06/09/49/kongguksu-6314887_960_720.jpg", list12, storeList4));
//        return foodSamples;
//    }
//
//    public static ArrayList<Food> getFoodData2() { // 밥
//        //대충 데이터 아무거나 들고와서 넣었어욤
//        ArrayList<String> list12 = new ArrayList<String>(); // 보쌈
//        list12.add(CategoryType.RICE.toString());
//
//        ArrayList<Store> storeList4 = new ArrayList<Store>();
//        storeList4.add(new Store(1, "서브웨이 서면점", "부산시 진구 서면 중앙대로 690",
//                "https://www.google.com/maps/uv?pb=!1s0x3568eb703cd22929:0xff0693e73247a117!3m1!7e115!4shttps://lh5.googleusercontent.com/p/AF1QipMuJtfcyodlHcVrig_e4UbnvzGrtZnQRG22IBn_%3Dw260-h175-n-k-no!5z7ISc66m0IOyEnOu4jOybqOydtCAtIEdvb2dsZSDqsoDsg4k!15zQ2dJZ0FRPT0&imagekey=!1e10!2sAF1QipMuJtfcyodlHcVrig_e4UbnvzGrtZnQRG22IBn_&hl=ko\"",
//                100));
//
//        ArrayList<Food> foodSamples = new ArrayList<>();
//        foodSamples.add(new Food("비빔밥", "https://cdn.pixabay.com/photo/2017/08/08/09/44/food-photography-2610863_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("김밥", "https://cdn.pixabay.com/photo/2016/02/28/07/47/kim-rice-1226569_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("연어덮밥", "https://cdn.pixabay.com/photo/2019/12/01/15/08/salmon-plate-with-rice-4665684_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("돈까스", "https://cdn.pixabay.com/photo/2016/09/23/23/23/restaurant-1690696_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("해장국", "https://cdn.pixabay.com/photo/2015/07/08/19/40/food-836806_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("유부초밥", "https://cdn.pixabay.com/photo/2019/12/15/10/37/inari-4696793_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("생선구이", "https://cdn.pixabay.com/photo/2017/05/23/04/51/grilled-fish-2336227_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("보쌈", "https://cdn.pixabay.com/photo/2015/05/02/00/56/bossam-749357_960_720.jpg", list12, storeList4));
//        return foodSamples;
//    }
//
//    public static ArrayList<Food> getFoodData3() { // 면
//        //대충 데이터 아무거나 들고와서 넣었어욤
//        ArrayList<String> list12 = new ArrayList<String>(); // 보쌈
//        list12.add(CategoryType.RICE.toString());
//
//        ArrayList<Store> storeList4 = new ArrayList<Store>();
//        storeList4.add(new Store(1, "서브웨이 서면점", "부산시 진구 서면 중앙대로 690",
//                "https://www.google.com/maps/uv?pb=!1s0x3568eb703cd22929:0xff0693e73247a117!3m1!7e115!4shttps://lh5.googleusercontent.com/p/AF1QipMuJtfcyodlHcVrig_e4UbnvzGrtZnQRG22IBn_%3Dw260-h175-n-k-no!5z7ISc66m0IOyEnOu4jOybqOydtCAtIEdvb2dsZSDqsoDsg4k!15zQ2dJZ0FRPT0&imagekey=!1e10!2sAF1QipMuJtfcyodlHcVrig_e4UbnvzGrtZnQRG22IBn_&hl=ko\"",
//                100));
//
//        ArrayList<Food> foodSamples = new ArrayList<>();
//        foodSamples.add(new Food("칼국수", "https://cdn.pixabay.com/photo/2014/09/24/09/30/seafood-458853_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("짬뽕", "https://cdn.pixabay.com/photo/2018/12/03/01/04/spicy-seafood-3852529_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("파스타", "https://cdn.pixabay.com/photo/2018/07/18/19/12/pasta-3547078_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("냉면", "https://cdn.pixabay.com/photo/2018/06/04/13/36/cold-noodles-3453218_960_720.jpg", list12, storeList4));
//
//        return foodSamples;
//    }
//
//    public static ArrayList<Food> getFoodData4() { // 국물
//        //대충 데이터 아무거나 들고와서 넣었어욤
//        ArrayList<String> list12 = new ArrayList<String>(); // 보쌈
//        list12.add(CategoryType.RICE.toString());
//
//        ArrayList<Store> storeList4 = new ArrayList<Store>();
//        storeList4.add(new Store(1, "서브웨이 서면점", "부산시 진구 서면 중앙대로 690",
//                "https://www.google.com/maps/uv?pb=!1s0x3568eb703cd22929:0xff0693e73247a117!3m1!7e115!4shttps://lh5.googleusercontent.com/p/AF1QipMuJtfcyodlHcVrig_e4UbnvzGrtZnQRG22IBn_%3Dw260-h175-n-k-no!5z7ISc66m0IOyEnOu4jOybqOydtCAtIEdvb2dsZSDqsoDsg4k!15zQ2dJZ0FRPT0&imagekey=!1e10!2sAF1QipMuJtfcyodlHcVrig_e4UbnvzGrtZnQRG22IBn_&hl=ko\"",
//                100));
//
//        ArrayList<Food> foodSamples = new ArrayList<>();
//        foodSamples.add(new Food("칼국수", "https://cdn.pixabay.com/photo/2014/09/24/09/30/seafood-458853_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("짬뽕", "https://cdn.pixabay.com/photo/2018/12/03/01/04/spicy-seafood-3852529_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("냉면", "https://cdn.pixabay.com/photo/2018/06/04/13/36/cold-noodles-3453218_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("해장국", "https://cdn.pixabay.com/photo/2015/07/08/19/40/food-836806_960_720.jpg", list12, storeList4));
//
//
//        return foodSamples;
//    }
//
//    public static ArrayList<Food> getFoodData5() { // 분식
//        //대충 데이터 아무거나 들고와서 넣었어욤
//        ArrayList<String> list12 = new ArrayList<String>(); // 보쌈
//        list12.add(CategoryType.RICE.toString());
//
//        ArrayList<Store> storeList4 = new ArrayList<Store>();
//        storeList4.add(new Store(1, "서브웨이 서면점", "부산시 진구 서면 중앙대로 690",
//                "https://www.google.com/maps/uv?pb=!1s0x3568eb703cd22929:0xff0693e73247a117!3m1!7e115!4shttps://lh5.googleusercontent.com/p/AF1QipMuJtfcyodlHcVrig_e4UbnvzGrtZnQRG22IBn_%3Dw260-h175-n-k-no!5z7ISc66m0IOyEnOu4jOybqOydtCAtIEdvb2dsZSDqsoDsg4k!15zQ2dJZ0FRPT0&imagekey=!1e10!2sAF1QipMuJtfcyodlHcVrig_e4UbnvzGrtZnQRG22IBn_&hl=ko\"",
//                100));
//
//        ArrayList<Food> foodSamples = new ArrayList<>();
//        foodSamples.add(new Food("칼국수", "https://cdn.pixabay.com/photo/2014/09/24/09/30/seafood-458853_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("떡볶이", "https://cdn.pixabay.com/photo/2016/02/26/11/42/toppokki-1223900_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("만두", "https://cdn.pixabay.com/photo/2017/06/11/17/03/dumplings-2392893_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("김밥", "https://cdn.pixabay.com/photo/2016/02/28/07/47/kim-rice-1226569_960_720.jpg", list12, storeList4));
//        return foodSamples;
//    }
//
//    public static ArrayList<Food> getFoodData6() {// 다이어트
//        //대충 데이터 아무거나 들고와서 넣었어욤
//        ArrayList<String> list12 = new ArrayList<String>(); // 보쌈
//        list12.add(CategoryType.RICE.toString());
//
//        ArrayList<Store> storeList4 = new ArrayList<Store>();
//        storeList4.add(new Store(1, "서브웨이 서면점", "부산시 진구 서면 중앙대로 690",
//                "https://www.google.com/maps/uv?pb=!1s0x3568eb703cd22929:0xff0693e73247a117!3m1!7e115!4shttps://lh5.googleusercontent.com/p/AF1QipMuJtfcyodlHcVrig_e4UbnvzGrtZnQRG22IBn_%3Dw260-h175-n-k-no!5z7ISc66m0IOyEnOu4jOybqOydtCAtIEdvb2dsZSDqsoDsg4k!15zQ2dJZ0FRPT0&imagekey=!1e10!2sAF1QipMuJtfcyodlHcVrig_e4UbnvzGrtZnQRG22IBn_&hl=ko\"",
//                100));
//
//        ArrayList<Food> foodSamples = new ArrayList<>();
//
//        foodSamples.add(new Food("샌드위치", "https://cdn.pixabay.com/photo/2017/03/10/13/49/fast-food-2132863_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("샐러드", "https://cdn.pixabay.com/photo/2016/09/15/19/24/salad-1672505_960_720.jpg", list12, storeList4));
//        return foodSamples;
//    }
//
//    public static ArrayList<Food> getFoodData7() { // 인스턴트
//        //대충 데이터 아무거나 들고와서 넣었어욤
//        ArrayList<String> list12 = new ArrayList<String>(); // 보쌈
//        list12.add(CategoryType.RICE.toString());
//
//        ArrayList<Store> storeList4 = new ArrayList<Store>();
//        storeList4.add(new Store(1, "서브웨이 서면점", "부산시 진구 서면 중앙대로 690",
//                "https://www.google.com/maps/uv?pb=!1s0x3568eb703cd22929:0xff0693e73247a117!3m1!7e115!4shttps://lh5.googleusercontent.com/p/AF1QipMuJtfcyodlHcVrig_e4UbnvzGrtZnQRG22IBn_%3Dw260-h175-n-k-no!5z7ISc66m0IOyEnOu4jOybqOydtCAtIEdvb2dsZSDqsoDsg4k!15zQ2dJZ0FRPT0&imagekey=!1e10!2sAF1QipMuJtfcyodlHcVrig_e4UbnvzGrtZnQRG22IBn_&hl=ko\"",
//                100));
//
//        ArrayList<Food> foodSamples = new ArrayList<>();
//        foodSamples.add(new Food("떡볶이", "https://cdn.pixabay.com/photo/2016/02/26/11/42/toppokki-1223900_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("피자", "https://cdn.pixabay.com/photo/2020/06/08/16/49/pizza-5275191_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("샌드위치", "https://cdn.pixabay.com/photo/2017/03/10/13/49/fast-food-2132863_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("햄버거", "https://cdn.pixabay.com/photo/2020/03/21/11/17/burger-4953465_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("김밥", "https://cdn.pixabay.com/photo/2016/02/28/07/47/kim-rice-1226569_960_720.jpg", list12, storeList4));
//        return foodSamples;
//    }
//
//    public static ArrayList<Food> getFoodData8() {// 다른나라
//        //대충 데이터 아무거나 들고와서 넣었어욤
//        ArrayList<String> list12 = new ArrayList<String>(); // 보쌈
//        list12.add(CategoryType.RICE.toString());
//
//        ArrayList<Store> storeList4 = new ArrayList<Store>();
//        storeList4.add(new Store(1, "서브웨이 서면점", "부산시 진구 서면 중앙대로 690",
//                "https://www.google.com/maps/uv?pb=!1s0x3568eb703cd22929:0xff0693e73247a117!3m1!7e115!4shttps://lh5.googleusercontent.com/p/AF1QipMuJtfcyodlHcVrig_e4UbnvzGrtZnQRG22IBn_%3Dw260-h175-n-k-no!5z7ISc66m0IOyEnOu4jOybqOydtCAtIEdvb2dsZSDqsoDsg4k!15zQ2dJZ0FRPT0&imagekey=!1e10!2sAF1QipMuJtfcyodlHcVrig_e4UbnvzGrtZnQRG22IBn_&hl=ko\"",
//                100));
//
//        ArrayList<Food> foodSamples = new ArrayList<>();
//
//        foodSamples.add(new Food("쌀국수", "https://cdn.pixabay.com/photo/2020/06/02/12/20/soup-5250765_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("타코", "https://cdn.pixabay.com/photo/2016/08/23/08/53/tacos-1613795_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("피자", "https://cdn.pixabay.com/photo/2020/06/08/16/49/pizza-5275191_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("샌드위치", "https://cdn.pixabay.com/photo/2017/03/10/13/49/fast-food-2132863_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("샐러드", "https://cdn.pixabay.com/photo/2016/09/15/19/24/salad-1672505_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("햄버거", "https://cdn.pixabay.com/photo/2020/03/21/11/17/burger-4953465_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("파스타", "https://cdn.pixabay.com/photo/2018/07/18/19/12/pasta-3547078_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("돈까스", "https://cdn.pixabay.com/photo/2016/09/23/23/23/restaurant-1690696_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("유부초밥", "https://cdn.pixabay.com/photo/2019/12/15/10/37/inari-4696793_960_720.jpg", list12, storeList4));
//
//        return foodSamples;
//    }
//
//    public static ArrayList<Food> getFoodData9() {// 계절메뉴
//        //대충 데이터 아무거나 들고와서 넣었어욤
//        ArrayList<String> list12 = new ArrayList<String>(); // 보쌈
//        list12.add(CategoryType.RICE.toString());
//
//        ArrayList<Store> storeList4 = new ArrayList<Store>();
//        storeList4.add(new Store(1, "서브웨이 서면점", "부산시 진구 서면 중앙대로 690",
//                "https://www.google.com/maps/uv?pb=!1s0x3568eb703cd22929:0xff0693e73247a117!3m1!7e115!4shttps://lh5.googleusercontent.com/p/AF1QipMuJtfcyodlHcVrig_e4UbnvzGrtZnQRG22IBn_%3Dw260-h175-n-k-no!5z7ISc66m0IOyEnOu4jOybqOydtCAtIEdvb2dsZSDqsoDsg4k!15zQ2dJZ0FRPT0&imagekey=!1e10!2sAF1QipMuJtfcyodlHcVrig_e4UbnvzGrtZnQRG22IBn_&hl=ko\"",
//                100));
//
//        ArrayList<Food> foodSamples = new ArrayList<>();
//        foodSamples.add(new Food("냉면", "https://cdn.pixabay.com/photo/2018/06/04/13/36/cold-noodles-3453218_960_720.jpg", list12, storeList4));
//        foodSamples.add(new Food("콩국수", "https://cdn.pixabay.com/photo/2021/06/06/09/49/kongguksu-6314887_960_720.jpg", list12, storeList4));
//        return foodSamples;
//    }


}
