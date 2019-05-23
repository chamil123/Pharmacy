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
public class Batch {

    private Integer batch_id;
    private String batch_no;
    private String batch_exp_date;
    private double batch_unit_cost;
    private double batch_unit_price;
    private int batch_status;
    private String created_at;
    private String updated_at;
    private Drug drug_id;
    private Rack rack_id;

    public Batch() {
    }

    public Batch(Integer batch_id, String batch_no, String batch_exp_date, double batch_unit_cost, double batch_unit_price, int batch_status, String created_at, String updated_at, Drug drug_id, Rack rack_id) {
        this.batch_id = batch_id;
        this.batch_no = batch_no;
        this.batch_exp_date = batch_exp_date;
        this.batch_unit_cost = batch_unit_cost;
        this.batch_unit_price = batch_unit_price;
        this.batch_status = batch_status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.drug_id = drug_id;
        this.rack_id = rack_id;
    }

    /**
     * @return the batch_id
     */
    public Integer getBatch_id() {
        return batch_id;
    }

    /**
     * @param batch_id the batch_id to set
     */
    public void setBatch_id(Integer batch_id) {
        this.batch_id = batch_id;
    }

    /**
     * @return the batch_no
     */
    public String getBatch_no() {
        return batch_no;
    }

    /**
     * @param batch_no the batch_no to set
     */
    public void setBatch_no(String batch_no) {
        this.batch_no = batch_no;
    }

    /**
     * @return the batch_exp_date
     */
    public String getBatch_exp_date() {
        return batch_exp_date;
    }

    /**
     * @param batch_exp_date the batch_exp_date to set
     */
    public void setBatch_exp_date(String batch_exp_date) {
        this.batch_exp_date = batch_exp_date;
    }

    /**
     * @return the batch_unit_cost
     */
    public double getBatch_unit_cost() {
        return batch_unit_cost;
    }

    /**
     * @param batch_unit_cost the batch_unit_cost to set
     */
    public void setBatch_unit_cost(double batch_unit_cost) {
        this.batch_unit_cost = batch_unit_cost;
    }

    /**
     * @return the batch_unit_price
     */
    public double getBatch_unit_price() {
        return batch_unit_price;
    }

    /**
     * @param batch_unit_price the batch_unit_price to set
     */
    public void setBatch_unit_price(double batch_unit_price) {
        this.batch_unit_price = batch_unit_price;
    }

    /**
     * @return the batch_status
     */
    public int getBatch_status() {
        return batch_status;
    }

    /**
     * @param batch_status the batch_status to set
     */
    public void setBatch_status(int batch_status) {
        this.batch_status = batch_status;
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
     * @return the drug_id
     */
    public Drug getDrug_id() {
        return drug_id;
    }

    /**
     * @param drug_id the drug_id to set
     */
    public void setDrug_id(Drug drug_id) {
        this.drug_id = drug_id;
    }

    /**
     * @return the rack_id
     */
    public Rack getRack_id() {
        return rack_id;
    }

    /**
     * @param rack_id the rack_id to set
     */
    public void setRack_id(Rack rack_id) {
        this.rack_id = rack_id;
    }

    
}
