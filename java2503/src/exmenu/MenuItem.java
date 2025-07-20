package exmenu;

public class MenuItem {
    private int id;
    private String name;
    private int price;
    private String image; // 이미지 파일명 또는 URL

    public MenuItem(int id, String name, int price, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    // JSON 파싱을 위해 기본 생성자도 필요할 수 있음 (Gson 등 라이브러리 사용 시)
    public MenuItem() {}

    // Getter & Setter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // 디버깅용 toString()
    @Override
    public String toString() {
        return "MenuItem{id=" + id + ", name='" + name + "', price=" + price + ", image='" + image + "'}";
    }
}
