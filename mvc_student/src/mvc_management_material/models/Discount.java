package mvc_management_material.models;

import java.time.LocalDate;

public interface Discount {
    double getRealMoney(LocalDate now);
}
