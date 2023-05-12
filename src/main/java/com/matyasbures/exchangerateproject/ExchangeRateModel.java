package com.matyasbures.exchangerateproject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

/**
 * This class represents the Exchange Rate Model.
 * It is mapped to a database table named "Exchange_Rate" using the @Table annotation.
 * The @Entity annotation indicates that this class is a JPA entity.
 * The class has 16 fields, each mapped to a column in the "Exchange_Rate" table using the @Column annotation.
 * The @Id annotation is used to specify the primary key field of the entity.
 * The @Override annotation is used to indicate that the toString method has been overridden to provide a string representation of the object.
 * It has getters and setters.
 */
@Entity
@Table(name = "${exchange_rate.table.name}")
public class ExchangeRateModel {

    @Id
    @Column(name = "${short_name.column.name}", unique = true)
    private String shortName;

    @Column(name = "${valid_from.column.name}")
    private LocalDateTime validFrom;

    @Column(name = "${name.column.name}")
    private String name;

    @Column(name = "${country.column.name}")
    private String country;

    @Column(name = "${move.column.name}")
    private double move;

    @Column(name = "${amount.column.name}")
    private double amount;

    @Column(name = "${val_buy.column.name}")
    private double valBuy;

    @Column(name = "${val_sell.column.name}")
    private double valSell;

    @Column(name = "${val_mid.column.name}")
    private double valMid;

    @Column(name = "${curr_buy.column.name}")
    private double currBuy;

    @Column(name = "${curr_sell.column.name}")
    private double currSell;

    @Column(name = "${curr_mid.column.name}")
    private double currMid;

    @Column(name = "${version.column.name}")
    private int version;

    @Column(name = "${cnb_mid.column.name}")
    private double cnbMid;

    @Column(name = "${ecb_mid.column.name}")
    private double ecbMid;

    @Override
    public String toString() {
        return "ExchangeRateModel{" +
                ", shortName='" + shortName + '\'' +
                ", validFrom=" + validFrom +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", move=" + move +
                ", amount=" + amount +
                ", valBuy=" + valBuy +
                ", valSell=" + valSell +
                ", valMid=" + valMid +
                ", currBuy=" + currBuy +
                ", currSell=" + currSell +
                ", currMid=" + currMid +
                ", version=" + version +
                ", cnbMid=" + cnbMid +
                ", ecbMid=" + ecbMid +
                '}';
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getMove() {
        return move;
    }

    public void setMove(double move) {
        this.move = move;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getValBuy() {
        return valBuy;
    }

    public void setValBuy(double valBuy) {
        this.valBuy = valBuy;
    }

    public double getValSell() {
        return valSell;
    }

    public void setValSell(double valSell) {
        this.valSell = valSell;
    }

    public double getValMid() {
        return valMid;
    }

    public void setValMid(double valMid) {
        this.valMid = valMid;
    }

    public double getCurrBuy() {
        return currBuy;
    }

    public void setCurrBuy(double currBuy) {
        this.currBuy = currBuy;
    }

    public double getCurrSell() {
        return currSell;
    }

    public void setCurrSell(double currSell) {
        this.currSell = currSell;
    }

    public double getCurrMid() {
        return currMid;
    }

    public void setCurrMid(double currMid) {
        this.currMid = currMid;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public double getCnbMid() {
        return cnbMid;
    }

    public void setCnbMid(double cnbMid) {
        this.cnbMid = cnbMid;
    }

    public double getEcbMid() {
        return ecbMid;
    }

    public void setEcbMid(double ecbMid) {
        this.ecbMid = ecbMid;
    }
}