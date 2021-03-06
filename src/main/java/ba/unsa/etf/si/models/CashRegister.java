package ba.unsa.etf.si.models;

import ba.unsa.etf.si.utility.date.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

import javax.persistence.Table;
import javax.persistence.*;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cash_register")
public class CashRegister {

    @Id
    @Column(name = "id")
    private Long id;

    @Transient
    private String cashRegisterName;

    @Transient
    private Long officeID;

    @Transient
    private Long merchantID;

    @Transient
    private String merchantName;

    @Transient
    private String uuid;

    @Transient
    private LocalTime startTime;

    @Transient
    private LocalTime endTime;

    @Transient
    private boolean restaurant;

    @Transient
    private String placeName;

    @Column(name = "receipt_path")
    private String receiptPath;

    @Column(name = "report_path")
    private String reportPath;

    public void initialize(JSONObject jsonObject) {
        try {
            tryInit(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void tryInit(JSONObject jsonObject) {
        id = jsonObject.getLong("cashRegisterId");
        cashRegisterName = jsonObject.getString("cashRegisterName");
        officeID = (!jsonObject.isNull("officeId")) ? jsonObject.getLong("officeId") : 0L;
        merchantID = jsonObject.getLong("businessId");
        merchantName = jsonObject.getString("businessName");
        uuid = jsonObject.getString("uuid");
        restaurant = jsonObject.getBoolean("restaurant");
        placeName = jsonObject.getString("placeName");
        startTime = DateUtils.localTimeFromString(jsonObject.getString("startTime"));
        endTime = DateUtils.localTimeFromString(jsonObject.getString("endTime"));
    }
}
