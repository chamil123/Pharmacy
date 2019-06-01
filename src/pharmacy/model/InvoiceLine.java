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
public class InvoiceLine {
    private Integer inv_line_id;
    private double inv_line_qty;
    private double inv_line_price;
    private double inv_line_discount;
     private double inv_lineAmount;
    private int inv_id;
    private int drug_id;

    public InvoiceLine() {
    }

    public InvoiceLine(Integer inv_line_id, double inv_line_qty, double inv_line_price, double inv_line_discount, double inv_lineAmount, int inv_id, int drug_id) {
        this.inv_line_id = inv_line_id;
        this.inv_line_qty = inv_line_qty;
        this.inv_line_price = inv_line_price;
        this.inv_line_discount = inv_line_discount;
        this.inv_lineAmount = inv_lineAmount;
        this.inv_id = inv_id;
        this.drug_id = drug_id;
    }

    /**
     * @return the inv_line_id
     */
    public Integer getInv_line_id() {
        return inv_line_id;
    }

    /**
     * @param inv_line_id the inv_line_id to set
     */
    public void setInv_line_id(Integer inv_line_id) {
        this.inv_line_id = inv_line_id;
    }

    /**
     * @return the inv_line_qty
     */
    public double getInv_line_qty() {
        return inv_line_qty;
    }

    /**
     * @param inv_line_qty the inv_line_qty to set
     */
    public void setInv_line_qty(double inv_line_qty) {
        this.inv_line_qty = inv_line_qty;
    }

    /**
     * @return the inv_line_price
     */
    public double getInv_line_price() {
        return inv_line_price;
    }

    /**
     * @param inv_line_price the inv_line_price to set
     */
    public void setInv_line_price(double inv_line_price) {
        this.inv_line_price = inv_line_price;
    }

    /**
     * @return the inv_line_discount
     */
    public double getInv_line_discount() {
        return inv_line_discount;
    }

    /**
     * @param inv_line_discount the inv_line_discount to set
     */
    public void setInv_line_discount(double inv_line_discount) {
        this.inv_line_discount = inv_line_discount;
    }

    /**
     * @return the inv_lineAmount
     */
    public double getInv_lineAmount() {
        return inv_lineAmount;
    }

    /**
     * @param inv_lineAmount the inv_lineAmount to set
     */
    public void setInv_lineAmount(double inv_lineAmount) {
        this.inv_lineAmount = inv_lineAmount;
    }

    /**
     * @return the inv_id
     */
    public int getInv_id() {
        return inv_id;
    }

    /**
     * @param inv_id the inv_id to set
     */
    public void setInv_id(int inv_id) {
        this.inv_id = inv_id;
    }

    /**
     * @return the drug_id
     */
    public int getDrug_id() {
        return drug_id;
    }

    /**
     * @param drug_id the drug_id to setF
     */
    public void setDrug_id(int drug_id) {
        this.drug_id = drug_id;
    }

   
}
