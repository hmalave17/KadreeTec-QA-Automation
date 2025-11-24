package co.com.kadreeTech.certification.models.request;

import co.com.kadreeTech.certification.models.BookingDates;
import co.com.kadreeTech.certification.utils.Utilities;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

import static co.com.kadreeTech.certification.utils.ConstantsExcel.*;

public class CreateBookingRequest {

    @SerializedName("firstname")
    @Expose
    private String firstname;

    @SerializedName("lastname")
    @Expose
    private String lastname;

    @SerializedName("totalprice")
    @Expose
    private Integer totalprice;

    @SerializedName("depositpaid")
    @Expose
    private Boolean depositpaid;

    @SerializedName("bookingdates")
    @Expose
    private BookingDates bookingdates;

    @SerializedName("additionalneeds")
    @Expose
    private String additionalneeds;

    public CreateBookingRequest(Map<String, String> data) {
        this.firstname = Utilities.normalize(data.get(FIRSTNAME));
        this.lastname = Utilities.normalize(data.get(LASTNAME));
        this.totalprice = Utilities.parseInteger(data.get(TOTAL_PRICE));
        this.depositpaid = Utilities.parseBoolean(data.get(DEPOSIT_PAID));
        this.bookingdates = new BookingDates(data);
        this.additionalneeds = Utilities.normalize(data.get(ADDITIONAL_NEEDS));
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalPrice() {
        return totalprice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalprice = totalPrice;
    }

    public Boolean getDepositPaid() {
        return depositpaid;
    }

    public void setDepositPaid(Boolean depositPaid) {
        this.depositpaid = depositPaid;
    }

    public void setDepositPaid(String value) {
        this.depositpaid = Utilities.parseBoolean(value);
    }

    public BookingDates getBookingDates() {
        return bookingdates;
    }

    public void setBookingDates(BookingDates bookingDates) {
        this.bookingdates = bookingDates;
    }

    public String getAdditionalNeeds() {
        return additionalneeds;
    }

    public void setAdditionalNeeds(String additionalNeeds) {
        this.additionalneeds = additionalNeeds;
    }

    @Override
    public String toString() {
        return "{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}
