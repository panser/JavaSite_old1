package ua.org.gostroy.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by panser on 5/20/14.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;

    private String email;
    private String password;
    private boolean enabled;
    private String role;

    @ElementCollection(fetch=FetchType.LAZY)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserAddress> userAddresses;
    private UserSex sex;

    private byte[] avatorImage;
    @DateTimeFormat(pattern="dd.MM.yyyy")
    private Date birthDay;
    @DateTimeFormat
    private Date createDate;
    @DateTimeFormat
    private Date deleteDate;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<UserAddress> getUserAddresses() {
        return userAddresses;
    }

    public void setUserAddresses(List<UserAddress> userAddresses) {
        this.userAddresses = userAddresses;
    }

    public UserSex getSex() {
        return sex;
    }

    public void setSex(UserSex sex) {
        this.sex = sex;
    }

    public byte[] getAvatorImage() {
        return avatorImage;
    }

    public void setAvatorImage(byte[] avatorImage) {
        this.avatorImage = avatorImage;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

}
