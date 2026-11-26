package com.example.demo.menu;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MenuCatalog {

    private final List<MenuSection> sections = List.of(
        section("starters", "Starters", List.of(
            item("Veg Spring Rolls", 120), item("Paneer Tikka", 180), item("Chicken Tikka", 220),
            item("Gobi Manchurian", 140), item("Veg Manchurian", 130), item("Chicken 65", 200),
            item("French Fries", 100), item("Chilli Paneer", 190), item("Crispy Corn", 150),
            item("Chicken Lollipop", 240)
        )),
        section("main-course", "Main Course – Indian", List.of(
            item("Paneer Butter Masala", 220), item("Kadai Paneer", 210), item("Butter Chicken", 280),
            item("Chicken Curry", 240), item("Dal Tadka", 150), item("Dal Makhani", 190),
            item("Mix Veg Curry", 170), item("Chole Masala", 160), item("Palak Paneer", 200),
            item("Egg Curry", 180)
        )),
        section("biryani-rice", "Biryani and Rice", List.of(
            item("Veg Biryani", 160), item("Chicken Biryani", 220), item("Mutton Biryani", 300),
            item("Paneer Biryani", 190), item("Egg Biryani", 180), item("Hyderabadi Chicken Biryani", 250),
            item("Jeera Rice", 120), item("Fried Rice", 150), item("Chicken Fried Rice", 190),
            item("Schezwan Fried Rice", 170)
        )),
        section("pizza-burgers", "Pizza and Burgers", List.of(
            item("Margherita Pizza", 199), item("Farmhouse Pizza", 299), item("Paneer Pizza", 249),
            item("Chicken Pizza", 299), item("Veg Burger", 99), item("Cheese Burger", 129),
            item("Chicken Burger", 159), item("Double Cheese Burger", 179), item("BBQ Chicken Burger", 189),
            item("Peri Peri Fries", 130)
        )),
        section("south-indian", "South Indian Food", List.of(
            item("Plain Dosa", 70), item("Masala Dosa", 100), item("Mysore Masala Dosa", 120),
            item("Onion Dosa", 90), item("Idli (2 Pieces)", 50), item("Vada (2 Pieces)", 60),
            item("Plain Uttapam", 90), item("Onion Uttapam", 110), item("Puri Bhaji", 100),
            item("Pongal", 80)
        )),
        section("beverages", "Beverages", List.of(
            item("Coca-Cola", 40), item("Sprite", 40), item("Fresh Lime Soda", 60),
            item("Mango Milkshake", 100), item("Chocolate Milkshake", 120), item("Cold Coffee", 100),
            item("Masala Chai", 30), item("Filter Coffee", 40), item("Fresh Orange Juice", 90),
            item("Buttermilk", 35)
        )),
        section("desserts", "Desserts", List.of(
            item("Gulab Jamun", 60), item("Rasmalai", 90), item("Chocolate Brownie", 120),
            item("Vanilla Ice Cream", 70), item("Chocolate Ice Cream", 80), item("Chocolate Lava Cake", 130),
            item("Cheesecake", 180), item("Fruit Salad", 100), item("Gajar Ka Halwa", 90),
            item("Kulfi", 60)
        ))
    );

    public List<MenuSection> getSections() {
        return sections;
    }

    private static MenuSection section(String slug, String title, List<MenuItem> items) {
        return new MenuSection(slug, title, items);
    }

    private static MenuItem item(String name, int price) {
        return new MenuItem(name, price);
    }

    public static class MenuSection {
        private final String slug;
        private final String title;
        private final List<MenuItem> items;

        MenuSection(String slug, String title, List<MenuItem> items) {
            this.slug = slug;
            this.title = title;
            this.items = items;
        }

        public String getSlug() { return slug; }
        public String getTitle() { return title; }
        public List<MenuItem> getItems() { return items; }
    }

    public static class MenuItem {
        private final String name;
        private final int price;

        MenuItem(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() { return name; }
        public int getPrice() { return price; }
    }
}
