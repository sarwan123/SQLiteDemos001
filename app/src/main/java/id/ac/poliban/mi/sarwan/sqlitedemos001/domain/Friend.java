package id.ac.poliban.mi.sarwan.sqlitedemos001.domain;

import java.io.Serializable;

public class Friend implements Serializable {
    private int id;
    private String name;
    private String address;
    private String phone;
    private String photo;

    public Friend(int id, String name, String address, String phone, String photo) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.photo = photo;
    }

    public Friend(String name, String address, String phone, String photo) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;     }

    public String getPhone() {
        return phone;
    }

    public String getPhoto() {
        return photo;     }

    @Override
    public String toString() {
        return String.format("%3d %25s %24s", getId(), getName(), getPhone());
    }
}
