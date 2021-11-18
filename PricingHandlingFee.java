package com.example.demo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "pricing_handling_fee")
public class PricingHandlingFee {
    @EmbeddedId
    private PricingHandlingFeePK pricingHandlingFeePK;

    @Column(name = "fee")
    private BigDecimal fee;

    @MapsId("uuid")
    @ManyToOne
    @JoinColumn(name = "uuid", referencedColumnName = "uuid", nullable = false)
    private PricingDetail pricingDetailByUuid;

    public PricingHandlingFeePK getPricingHandlingFeePK() {
        return pricingHandlingFeePK;
    }

    public void setPricingHandlingFeePK(PricingHandlingFeePK pricingHandlingFeePK) {
        this.pricingHandlingFeePK = pricingHandlingFeePK;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public PricingDetail getPricingDetailByUuid() {
        return pricingDetailByUuid;
    }

    public void setPricingDetailByUuid(PricingDetail pricingDetailByUuid) {
        this.pricingDetailByUuid = pricingDetailByUuid;
    }
}
