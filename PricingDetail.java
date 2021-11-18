package com.example.demo.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "pricing_detail")
public class PricingDetail {
    @Id
    @Column(name = "uuid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uuid;

    @Column(name = "tableId", insertable = false, updatable = false)
    private Integer tableId;

    @Column(name = "fromAmount")
    private BigDecimal fromAmount;

    @Column(name = "toAmount")
    private BigDecimal toAmount;

    @ManyToOne
    @JoinColumn(name = "tableId", referencedColumnName = "id")
    private PricingMasterTable pricingMasterTableByTableId;

    @OneToMany(mappedBy = "pricingDetailByUuid", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<PricingHandlingFee> pricingHandlingFeeByUuid;

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public BigDecimal getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(BigDecimal fromAmount) {
        this.fromAmount = fromAmount;
    }

    public BigDecimal getToAmount() {
        return toAmount;
    }

    public void setToAmount(BigDecimal toAmount) {
        this.toAmount = toAmount;
    }

    public PricingMasterTable getPricingMasterTableByTableId() {
        return pricingMasterTableByTableId;
    }

    public void setPricingMasterTableByTableId(PricingMasterTable pricingMasterTableByTableId) {
        this.pricingMasterTableByTableId = pricingMasterTableByTableId;
    }

    public Collection<PricingHandlingFee> getPricingHandlingFeeByUuid() {
        return pricingHandlingFeeByUuid;
    }

    public void setPricingHandlingFeeByUuid(Collection<PricingHandlingFee> pricingHandlingFeeByUuid) {
        this.pricingHandlingFeeByUuid = pricingHandlingFeeByUuid;
    }
}
