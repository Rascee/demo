package com.example.demo.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "pricing_master_table")
public class PricingMasterTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToMany(mappedBy = "pricingMasterTableByTableId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<PricingDetail> pricingDetailById;

    @OneToMany(mappedBy = "pricingRelationByPricingTable")
    private Collection<PricingTagTableMap> pricingTagTableMapsById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection<PricingDetail> getPricingDetailById() {
        return pricingDetailById;
    }

    public void setPricingDetailById(Collection<PricingDetail> pricingDetailById) {
        this.pricingDetailById = pricingDetailById;
    }

    public Collection<PricingTagTableMap> getPricingTagTableMapsById() {
        return pricingTagTableMapsById;
    }

    public void setPricingTagTableMapsById(Collection<PricingTagTableMap> pricingTagTableMapsById) {
        this.pricingTagTableMapsById = pricingTagTableMapsById;
    }
}
