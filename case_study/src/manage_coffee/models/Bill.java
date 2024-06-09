package manage_coffee.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Bill {
    private LocalDate date;
    private LocalTime time;
    private double totalMoney;

    public Bill(){
    }

    public Bill(LocalDate date, LocalTime time, double totalMoney) {
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

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
}
