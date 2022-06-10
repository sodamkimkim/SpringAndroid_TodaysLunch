package com.example.project.models;

import java.io.Serializable;
import java.util.ArrayList;

public class FoodSample implements Serializable {
    private String thumbnail;
    private String title;

    public FoodSample(String thumbnail, String title) {
        this.thumbnail = thumbnail;
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "food{" +
                "thumbnail='" + thumbnail + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public static ArrayList<FoodSample> getFoodData() {
        ArrayList<FoodSample> foodSamples = new ArrayList<>();
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2017/08/08/09/44/food-photography-2610863_960_720.jpg", "비빔밥"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2014/09/24/09/30/seafood-458853_960_720.jpg", "칼국수"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2018/12/03/01/04/spicy-seafood-3852529_960_720.jpg", "짬뽕"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2016/02/26/11/42/toppokki-1223900_960_720.jpg", "떡볶이"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2020/06/08/16/49/pizza-5275191_960_720.jpg", "피자"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2017/03/10/13/49/fast-food-2132863_960_720.jpg", "샌드위치"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2016/09/15/19/24/salad-1672505_960_720.jpg", "샐러드"));

        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2017/06/11/17/03/dumplings-2392893_960_720.jpg", "만두"));

        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2020/03/21/11/17/burger-4953465_960_720.jpg", "햄버거"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2018/07/18/19/12/pasta-3547078_960_720.jpg", "파스타"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2018/06/04/13/36/cold-noodles-3453218_960_720.jpg", "냉면"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2016/02/28/07/47/kim-rice-1226569_960_720.jpg", "김밥"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2019/12/01/15/08/salmon-plate-with-rice-4665684_960_720.jpg", "연어덮밥"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2016/09/23/23/23/restaurant-1690696_960_720.jpg", "돈까스"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2015/07/08/19/40/food-836806_960_720.jpg", "해장국"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2019/12/15/10/37/inari-4696793_960_720.jpg", "유부초밥"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2017/05/23/04/51/grilled-fish-2336227_960_720.jpg", "생선구이"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2015/05/02/00/56/bossam-749357_960_720.jpg", "보쌈"));
        return foodSamples;
    }

    public static ArrayList<FoodSample> getFoodData2() {
        ArrayList<FoodSample> foodSamples = new ArrayList<>();
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2017/08/08/09/44/food-photography-2610863_960_720.jpg", "비빔밥"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2016/02/28/07/47/kim-rice-1226569_960_720.jpg", "김밥"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2019/12/01/15/08/salmon-plate-with-rice-4665684_960_720.jpg", "연어덮밥"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2016/09/23/23/23/restaurant-1690696_960_720.jpg", "돈까스"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2015/07/08/19/40/food-836806_960_720.jpg", "해장국"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2019/12/15/10/37/inari-4696793_960_720.jpg", "유부초밥"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2017/05/23/04/51/grilled-fish-2336227_960_720.jpg", "생선구이"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2015/05/02/00/56/bossam-749357_960_720.jpg", "보쌈"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2020/06/02/12/20/soup-5250765_960_720.jpg", "쌀국수"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2016/08/23/08/53/tacos-1613795_960_720.jpg", "타코"));
        return foodSamples;
    }

    public static ArrayList<FoodSample> getFoodData3() {
        ArrayList<FoodSample> foodSamples = new ArrayList<>();
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2014/09/24/09/30/seafood-458853_960_720.jpg", "칼국수"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2018/12/03/01/04/spicy-seafood-3852529_960_720.jpg", "짬뽕"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2018/07/18/19/12/pasta-3547078_960_720.jpg", "파스타"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2018/06/04/13/36/cold-noodles-3453218_960_720.jpg", "냉면"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2016/09/23/23/23/restaurant-1690696_960_720.jpg", "돈까스"));
        return foodSamples;
    }

    public static ArrayList<FoodSample> getFoodData4() {
        ArrayList<FoodSample> foodSamples = new ArrayList<>();
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2014/09/24/09/30/seafood-458853_960_720.jpg", "칼국수"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2018/12/03/01/04/spicy-seafood-3852529_960_720.jpg", "짬뽕"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2018/06/04/13/36/cold-noodles-3453218_960_720.jpg", "냉면"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2015/07/08/19/40/food-836806_960_720.jpg", "해장국"));
        return foodSamples;
    }

    public static ArrayList<FoodSample> getFoodData5() { // 분식
        ArrayList<FoodSample> foodSamples = new ArrayList<>();
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2014/09/24/09/30/seafood-458853_960_720.jpg", "칼국수"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2016/02/26/11/42/toppokki-1223900_960_720.jpg", "떡볶이"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2016/02/28/07/47/kim-rice-1226569_960_720.jpg", "김밥"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2017/06/11/17/03/dumplings-2392893_960_720.jpg", "만두"));
        return foodSamples;
    }

    public static ArrayList<FoodSample> getFoodData6() { // 다이어트
        ArrayList<FoodSample> foodSamples = new ArrayList<>();
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2017/03/10/13/49/fast-food-2132863_960_720.jpg", "샌드위치"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2016/09/15/19/24/salad-1672505_960_720.jpg", "샐러드"));
        return foodSamples;
    }

    public static ArrayList<FoodSample> getFoodData7() { // 간편식
        ArrayList<FoodSample> foodSamples = new ArrayList<>();
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2016/02/28/07/47/kim-rice-1226569_960_720.jpg", "김밥"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2017/03/10/13/49/fast-food-2132863_960_720.jpg", "샌드위치"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2016/09/15/19/24/salad-1672505_960_720.jpg", "샐러드"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2020/03/21/11/17/burger-4953465_960_720.jpg", "햄버거"));
        return foodSamples;
    }

    public static ArrayList<FoodSample> getFoodData8() { // 다른나라
        ArrayList<FoodSample> foodSamples = new ArrayList<>();
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2020/06/02/12/20/soup-5250765_960_720.jpg", "쌀국수"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2016/08/23/08/53/tacos-1613795_960_720.jpg", "타코"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2020/06/08/16/49/pizza-5275191_960_720.jpg", "피자"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2018/07/18/19/12/pasta-3547078_960_720.jpg", "파스타"));
        return foodSamples;
    }

    public static ArrayList<FoodSample> getFoodData9() { // 계절요리
        ArrayList<FoodSample> foodSamples = new ArrayList<>();
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2018/06/04/13/36/cold-noodles-3453218_960_720.jpg", "냉면"));
        foodSamples.add(new FoodSample("https://cdn.pixabay.com/photo/2021/06/06/09/49/kongguksu-6314887_960_720.jpg", "콩국수"));

        return foodSamples;
    }
}
