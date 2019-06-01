/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy.model;

import java.util.Date;

/**
 *
 * @author chami
 */
public class Drug {

    private Integer drug_id;
    private String drug_name;
    private String drug_generic_name;
    private String drug_minimum_stock;
    private int drug_status;
    private String created_at;
    private String updated_at;
    private Category category_id;
    private Brand brand_id;
    private Rack rack_id;

    public Drug() {
    }

    public Drug(Integer drug_id, String drug_name, String drug_generic_name, String drug_minimum_stock, int drug_status, String created_at, String updated_at, Category category_id, Brand brand_id, Rack rack_id) {
        this.drug_id = drug_id;
        this.drug_name = drug_name;
        this.drug_generic_name = drug_generic_name;
        this.drug_minimum_stock = drug_minimum_stock;
        this.drug_status = drug_status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.category_id = category_id;
        this.brand_id = brand_id;
        this.rack_id = rack_id;
    }

    /**
     * @return the drug_id
     */
    public Integer getDrug_id() {
        return drug_id;
    }

    /**
     * @param drug_id the drug_id to set
     */
    public void setDrug_id(Integer drug_id) {
        this.drug_id = drug_id;
    }

    /**
     * @return the drug_name
     */
    public String getDrug_name() {
        return drug_name;
    }

    /**
     * @param drug_name the drug_name to set
     */
    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    /**
     * @return the drug_generic_name
     */
    public String getDrug_generic_name() {
        return drug_generic_name;
    }

    /**
     * @param drug_generic_name the drug_generic_name to set
     */
    public void setDrug_generic_name(String drug_generic_name) {
        this.drug_generic_name = drug_generic_name;
    }

    /**
     * @return the drug_minimum_stock
     */
    public String getDrug_minimum_stock() {
        return drug_minimum_stock;
    }

    /**
     * @param drug_minimum_stock the drug_minimum_stock to set
     */
    public void setDrug_minimum_stock(String drug_minimum_stock) {
        this.drug_minimum_stock = drug_minimum_stock;
    }

    /**
     * @return the drug_status
     */
    public int getDrug_status() {
        return drug_status;
    }

    /**
     * @param drug_status the drug_status to set
     */
    public void setDrug_status(int drug_status) {
        this.drug_status = drug_status;
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
     * @return the category_id
     */
    public Category getCategory_id() {
        return category_id;
    }

    /**
     * @param category_id the category_id to set
     */
    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }

    /**
     * @return the brand_id
     */
    public Brand getBrand_id() {
        return brand_id;
    }

    /**
     * @param brand_id the brand_id to set
     */
    public void setBrand_id(Brand brand_id) {
        this.brand_id = brand_id;
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
