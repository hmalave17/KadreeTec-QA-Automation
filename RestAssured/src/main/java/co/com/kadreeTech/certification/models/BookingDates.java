package co.com.kadreeTech.certification.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

import static co.com.kadreeTech.certification.utils.ConstantsExcel.CHECK_IN;
import static co.com.kadreeTech.certification.utils.ConstantsExcel.CHECK_OUT;

public class BookingDates {

    @SerializedName("checkin")
    @Expose
    private String checkin;

    @SerializedName("checkout")
    @Expose
    private String checkout;

    public BookingDates(Map<String, String> data) {
        this.checkin = clean(data.get(CHECK_IN));
        this.checkout = clean(data.get(CHECK_OUT));
    }

    private String clean(String value) {
        return (value == null || value.trim().isEmpty()) ? null : value.trim();
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = clean(checkin);
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = clean(checkout);
    }

    @Override
    public String toString() {
        return "{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
