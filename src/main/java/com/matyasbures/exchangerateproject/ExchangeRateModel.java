package com.matyasbures.exchangerateproject;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "Exchange_Rate")
public class ExchangeRateModel {

    @Id
    @SequenceGenerator(
            name = "exchangeRate_sequence",
            sequenceName = "exchangeRate_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "exchangeRate_sequence"
    )
    @Column(name = "exchange_rate_id")
    private Long id;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "valid_from")
    private LocalDateTime validFrom;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "move")
    private double move;

    @Column(name = "amount")
    private double amount;

    @Column(name = "val_buy")
    private double valBuy;

    @Column(name = "val_sell")
    private double valSell;

    @Column(name = "val_mid")
    private double valMid;

    @Column(name = "curr_buy")
    private double currBuy;

    @Column(name = "curr_sell")
    private double currSell;

    @Column(name = "curr_mid")
    private double currMid;

    @Column(name = "version")
    private int version;

    @Column(name = "cnb_mid")
    private double cnbMid;

    @Column(name = "ecb_mid")
    private double ecbMid;
}