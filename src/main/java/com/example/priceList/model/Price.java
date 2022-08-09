package com.example.priceList.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "prices")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceId;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(name = "price_list", nullable = false)
    private Long priceList;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "priority", nullable = false)
    private Integer priority;

    @Column(name = "price", nullable = false, scale = 2)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Currency curr;

    public Price() { }

    public Price(
            Long priceId,
            Brand brand,
            Date startDate,
            Date endDate,
            Long priceList,
            Long productId,
            Integer priority,
            BigDecimal price,
            Currency curr
    ) {
        this.priceId = priceId;
        this.brand = brand;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
    }

    public Long getPriceId() {
        return priceId;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getPriceList() {
        return priceList;
    }

    public void setPriceList(Long priceList) {
        this.priceList = priceList;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Currency getCurr() {
        return curr;
    }

    public void setCurr(Currency curr) {
        this.curr = curr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Objects.equals(priceId, price1.priceId) && Objects.equals(brand, price1.brand) && Objects.equals(startDate, price1.startDate) && Objects.equals(endDate, price1.endDate) && Objects.equals(priceList, price1.priceList) && Objects.equals(productId, price1.productId) && Objects.equals(priority, price1.priority) && Objects.equals(price, price1.price) && curr == price1.curr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceId, brand, startDate, endDate, priceList, productId, priority, price, curr);
    }
}