package co.com.kadreeTech.certification.models.request;

import co.com.kadreeTech.certification.utils.Utilities;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

import static co.com.kadreeTech.certification.utils.ConstantsExcel.PASSWORD;
import static co.com.kadreeTech.certification.utils.ConstantsExcel.USERNAME;

public class CreateTokenRequest {

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("password")
    @Expose
    private String password;

    public CreateTokenRequest(Map<String, String> data) {
        this.username = Utilities.normalize(data.get(USERNAME));
        this.password = Utilities.normalize(data.get(PASSWORD));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
