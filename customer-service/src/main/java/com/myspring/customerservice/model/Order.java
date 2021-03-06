package com.myspring.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Builder
@Entity
@Table(name = "T_ORDER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.id
     *
     * @mbg.generated Tue Jun 16 21:41:08 GMT+08:00 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.create_time
     *
     * @mbg.generated Tue Jun 16 21:41:08 GMT+08:00 2020
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.update_time
     *
     * @mbg.generated Tue Jun 16 21:41:08 GMT+08:00 2020
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.customer
     *
     * @mbg.generated Tue Jun 16 21:41:08 GMT+08:00 2020
     */
    private String customer;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.state
     *
     * @mbg.generated Tue Jun 16 21:41:08 GMT+08:00 2020
     */
    private OrderState state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_order
     *
     * @mbg.generated Tue Jun 16 21:41:08 GMT+08:00 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.id
     *
     * @return the value of t_order.id
     *
     * @mbg.generated Tue Jun 16 21:41:08 GMT+08:00 2020
     */
    public Long getId() {
        return id;
    }
    @ManyToMany
    @JoinTable(name = "T_ORDER_COFFEE")
    @OrderBy("id")
    private List<Coffee> items;
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Tue Jun 16 21:41:08 GMT+08:00 2020
     */
    public Order withId(Long id) {
        this.setId(id);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.id
     *
     * @param id the value for t_order.id
     *
     * @mbg.generated Tue Jun 16 21:41:08 GMT+08:00 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.create_time
     *
     * @return the value of t_order.create_time
     *
     * @mbg.generated Tue Jun 16 21:41:08 GMT+08:00 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Tue Jun 16 21:41:08 GMT+08:00 2020
     */
    public Order withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.create_time
     *
     * @param createTime the value for t_order.create_time
     *
     * @mbg.generated Tue Jun 16 21:41:08 GMT+08:00 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.update_time
     *
     * @return the value of t_order.update_time
     *
     * @mbg.generated Tue Jun 16 21:41:08 GMT+08:00 2020
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Tue Jun 16 21:41:08 GMT+08:00 2020
     */
    public Order withUpdateTime(Date updateTime) {
        this.setUpdateTime(updateTime);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.update_time
     *
     * @param updateTime the value for t_order.update_time
     *
     * @mbg.generated Tue Jun 16 21:41:08 GMT+08:00 2020
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.customer
     *
     * @return the value of t_order.customer
     *
     * @mbg.generated Tue Jun 16 21:41:08 GMT+08:00 2020
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Tue Jun 16 21:41:08 GMT+08:00 2020
     */
    public Order withCustomer(String customer) {
        this.setCustomer(customer);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.customer
     *
     * @param customer the value for t_order.customer
     *
     * @mbg.generated Tue Jun 16 21:41:08 GMT+08:00 2020
     */
    public void setCustomer(String customer) {
        this.customer = customer == null ? null : customer.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.state
     *
     * @return the value of t_order.state
     *
     * @mbg.generated Tue Jun 16 21:41:08 GMT+08:00 2020
     */
    public OrderState getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Tue Jun 16 21:41:08 GMT+08:00 2020
     */
    public Order withState(OrderState state) {
        this.setState(state);
        return this;
    }

    public Order withItems(List<Coffee> items) {
        this.setItems(items);
        return this;
    }
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.state
     *
     * @param state the value for t_order.state
     *
     * @mbg.generated Tue Jun 16 21:41:08 GMT+08:00 2020
     */
    public void setState(OrderState state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Tue Jun 16 21:41:08 GMT+08:00 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", customer=").append(customer);
        sb.append(", state=").append(state);
        sb.append(", items=").append(items);
        sb.append("]");
        return sb.toString();
    }
}