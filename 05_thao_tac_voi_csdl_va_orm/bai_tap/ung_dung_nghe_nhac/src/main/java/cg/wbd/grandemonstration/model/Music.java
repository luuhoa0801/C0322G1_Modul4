package cg.wbd.grandemonstration.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity(name = "music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String showMan;
    private String category;
    private String url;
    @ColumnDefault("0")
    private int status;

    public Music() {
    }

    public Music(String name, String showMan, String category, String url) {
        this.name = name;
        this.showMan = showMan;
        this.category = category;
        this.url = url;
    }

    public Music(String name, String showMan, String category, String url, int status) {
        this.name = name;
        this.showMan = showMan;
        this.category = category;
        this.url = url;
        this.status = status;
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

    public String getShowMan() {
        return showMan;
    }

    public void setShowMan(String showMan) {
        this.showMan = showMan;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
