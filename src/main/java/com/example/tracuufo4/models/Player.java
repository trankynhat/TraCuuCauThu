package com.example.tracuufo4.models;

import jakarta.persistence.*;

@Entity
@Table(name="tblPlayer")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @SequenceGenerator(
            name = "player_sequence",
            sequenceName = "player_sequence",
            allocationSize = 1
    )
    @Column(nullable = false,unique = true,length = 300)
    private String playerName;
    private int age;
    private Double price;
    private String url;
    public Player (){}

    public Player( String playerName, int age, Double price, String url) {

        this.playerName = playerName;
        this.age = age;
        this.price = price;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getAge() {
        return age;
    }

    public Double getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", playerName='" + playerName + '\'' +
                ", age=" + age +
                ", price=" + price +
                ", url='" + url + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
