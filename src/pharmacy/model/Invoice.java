/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy.model;

/**
 *
 * @author chami
 */
public class Invoice {

    private Integer inv_id;
    private String Inv_number;
    private String Inv_date;
    private double Inv_discount;
    private double inv_total;
    private String inv_pay_method;
    private double inv_lineDiscount;
    private double inv_lineDisAmount;
     private int inv_status;
    private String created_at;
    private String updated_at;
    private User user_id;
    private Customer cus_id;

    public Invoice() {
    }

    public Invoice(Integer inv_id, String Inv_number, String Inv_date, double Inv_discount, double inv_total, String inv_pay_method, double inv_lineDiscount, double inv_lineDisAmount, int inv_status, String created_at, String updated_at, User user_id, Customer cus_id) {
        this.inv_id = inv_id;
        this.Inv_number = Inv_number;
        this.Inv_date = Inv_date;
        this.Inv_discount = Inv_discount;
        this.inv_total = inv_total;
        this.inv_pay_method = inv_pay_method;
        this.inv_lineDiscount = inv_lineDiscount;
        this.inv_lineDisAmount = inv_lineDisAmount;
        this.inv_status = inv_status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.user_id = user_id;
        this.cus_id = cus_id;
    }

    /**
     * @return the inv_id
     */
    public Integer getInv_id() {
        return inv_id;
    }

    /**
     * @param inv_id the inv_id to set
     */
    public void setInv_id(Integer inv_id) {
        this.inv_id = inv_id;
    }

    /**
     * @return the Inv_number
     */
    public String getInv_number() {
        return Inv_number;
    }

    /**
     * @param Inv_number the Inv_number to set
     */
    public void setInv_number(String Inv_number) {
        this.Inv_number = Inv_number;
    }

    /**
     * @return the Inv_date
     */
    public String getInv_date() {
        return Inv_date;
    }

    /**
     * @param Inv_date the Inv_date to set
     */
    public void setInv_date(String Inv_date) {
        this.Inv_date = Inv_date;
    }

    /**
     * @return the Inv_discount
     */
    public double getInv_discount() {
        return Inv_discount;
    }

    /**
     * @param Inv_discount the Inv_discount to set
     */
    public void setInv_discount(double Inv_discount) {
        this.Inv_discount = Inv_discount;
    }

    /**
     * @return the inv_total
     */
    public double getInv_total() {
        return inv_total;
    }

    /**
     * @param inv_total the inv_total to set
     */
    public void setInv_total(double inv_total) {
        this.inv_total = inv_total;
    }

    /**
     * @return the inv_pay_method
     */
    public String getInv_pay_method() {
        return inv_pay_method;
    }

    /**
     * @param inv_pay_method the inv_pay_method to set
     */
    public void setInv_pay_method(String inv_pay_method) {
        this.inv_pay_method = inv_pay_method;
    }

    /**
     * @return the inv_lineDiscount
     */
    public double getInv_lineDiscount() {
        return inv_lineDiscount;
    }

    /**
     * @param inv_lineDiscount the inv_lineDiscount to set
     */
    public void setInv_lineDiscount(double inv_lineDiscount) {
        this.inv_lineDiscount = inv_lineDiscount;
    }

    /**
     * @return the inv_lineDisAmount
     */
    public double getInv_lineDisAmount() {
        return inv_lineDisAmount;
    }

    /**
     * @param inv_lineDisAmount the inv_lineDisAmount to set
     */
    public void setInv_lineDisAmount(double inv_lineDisAmount) {
        this.inv_lineDisAmount = inv_lineDisAmount;
    }

    /**
     * @return the inv_status
     */
    public int getInv_status() {
        return inv_status;
    }

    /**
     * @param inv_status the inv_status to set
     */
    public void setInv_status(int inv_status) {
        this.inv_status = inv_status;
    }

    /**
     * @return the created_at
     */
    public String getCreated_at() {
        return created_at;
    }

    /**
     * @param created_at the created_at to set
     */
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    /**
     * @return the updated_at
     */
    public String getUpdated_at() {
        return updated_at;
    }

    /**
     * @param updated_at the updated_at to set
     */
    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    /**
     * @return the user_id
     */
    public User getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the cus_id
     */
    public Customer getCus_id() {
        return cus_id;
    }

    /**
     * @param cus_id the cus_id to set
     */
    public void setCus_id(Customer cus_id) {
        this.cus_id = cus_id;
    }

}
