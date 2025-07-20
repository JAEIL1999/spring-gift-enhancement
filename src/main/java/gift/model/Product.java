package gift.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "image_url")
    private String imageUrl;

    @Transient
    private boolean usableKakao;

    public Product() {

    }

    public Product(String name, int price, boolean usableKakao, String imageUrl) {
        this.name = name;
        this.price = price;
        this.usableKakao = usableKakao;
        this.imageUrl = imageUrl;
    }
    public Product(String name, int price, boolean usableKakao) {
        this.name = name;
        this.price = price;
        this.usableKakao = usableKakao;
    }

    public Product(Long id, String name, int price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    //Getters and Setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getPrice() {return price;}
    public void setPrice(int price) {this.price = price;}
    public boolean isUsableKakao() {return usableKakao;}
    public void setUsableKakao(boolean usableKakao) {this.usableKakao = usableKakao;}
    public String getImageUrl() {return imageUrl;}
    public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}

}
