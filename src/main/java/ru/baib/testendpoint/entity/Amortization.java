package ru.baib.testendpoint.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "amortizations")
public class Amortization {

    @Id
    private UUID uuid;
    private UUID vehicleKindUuid;
    private Integer usePeriod;
    private Double avgPrice;
    private Double totalPrice;

    public Amortization() {
    }

    public Amortization(UUID uuid, UUID vehicleKindUuid, Integer usePeriod, Double avgPrice, Double totalPrice) {
        this.uuid = uuid;
        this.vehicleKindUuid = vehicleKindUuid;
        this.usePeriod = usePeriod;
        this.avgPrice = avgPrice;
        this.totalPrice = totalPrice;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getVehicleKindUuid() {
        return vehicleKindUuid;
    }

    public void setVehicleKindUuid(UUID vehicleKindUuid) {
        this.vehicleKindUuid = vehicleKindUuid;
    }

    public Integer getUsePeriod() {
        return usePeriod;
    }

    public void setUsePeriod(Integer usePeriod) {
        this.usePeriod = usePeriod;
    }

    public Double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amortization that = (Amortization) o;
        return Objects.equals(uuid, that.uuid) &&
                Objects.equals(vehicleKindUuid, that.vehicleKindUuid) &&
                Objects.equals(usePeriod, that.usePeriod) &&
                Objects.equals(avgPrice, that.avgPrice) &&
                Objects.equals(totalPrice, that.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, vehicleKindUuid, usePeriod, avgPrice, totalPrice);
    }

    @Override
    public String toString() {
        return "Amortization{" +
                "uuid=" + uuid +
                ", vehicleKindUuid=" + vehicleKindUuid +
                ", usePeriod=" + usePeriod +
                ", avgPrice=" + avgPrice +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
