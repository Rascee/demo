package com.example.demo.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PricingHandlingFeePK implements Serializable {
    private Integer uuid;
    private Integer tenor;

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public Integer getTenor() {
        return tenor;
    }

    public void setTenor(Integer tenor) {
        this.tenor = tenor;
    }
}
