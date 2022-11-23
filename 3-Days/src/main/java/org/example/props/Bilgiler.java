
package org.example.props;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Bilgiler {

    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("userSurname")
    @Expose
    private String userSurname;
    @SerializedName("userEmail")
    @Expose
    private String userEmail;
    @SerializedName("userPhone")
    @Expose
    private String userPhone;
    @SerializedName("face")
    @Expose
    private String face;
    @SerializedName("faceID")
    @Expose
    private String faceID;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getFaceID() {
        return faceID;
    }

    public void setFaceID(String faceID) {
        this.faceID = faceID;
    }

}
