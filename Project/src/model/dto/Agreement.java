package model.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class Agreement {

    LocalDateTime date;
    String vehicles;
    String options;

    public void setAgreement(LocalDateTime date, String vehicles, String options) {
        this.date = date;
        this.vehicles = vehicles;
        this.options = options;
    }

    public LocalDateTime getNowTime() {
        LocalDateTime date = LocalDateTime.now();
        return date;
    }

    public String getAgreement(){
        return "[ 계약일시: " + date + ", 차종: " + vehicles + ", 옵션: " + options + "]";
    }
}
