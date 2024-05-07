package spring.mvc_hibernate_aop.entity;
import javax.persistence.*;
@Entity
@Table(name = "dancer")
public class Dancer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "surname")
    String surName;
    @Column(name = "year_of_birth")
    int year;
    @Column(name = "dance_club")
    String danceClub;
    public Dancer(){
    }

    public Dancer(String name, String surName, int year, String danceClub) {
        this.name = name;
        this.surName = surName;
        this.year = year;
        this.danceClub = danceClub;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDanceClub() {
        return danceClub;
    }

    public void setDanceClub(String danceClub) {
        this.danceClub = danceClub;
    }
}
