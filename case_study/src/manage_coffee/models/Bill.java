package manage_coffee.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Bill {
    private LocalDate date;
    private String time;
    private double totalMoney;

    public Bill(LocalDate now, LocalTime localTime, double totalMoney){
    }

    public Bill(LocalDate date, String time, double totalMoney) {
        this.date = date;
        this.time = time;
        this.totalMoney = totalMoney;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return date + "," + time + "," + totalMoney;
    }
}
