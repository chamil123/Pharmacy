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
public class Brand {

    private Integer brand_id;
    private String brand_name;
    private String brand_description;
    private int brand_status;
    private Date created_at;
    private Date updated_at;

    public Brand() {
    }

    public Brand(Integer brand_id, String brand_name, String brand_description, int brand_status, Date created_at, Date updated_at) {
        this.brand_id = brand_id;
        this.brand_name = brand_name;
        this.brand_description = brand_description;
        this.brand_status = brand_status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    /**
     * @return the brand_id
     */
    public Integer getBrand_id() {
        return brand_id;
    }

    /**
     * @param brand_id the brand_id to set
     */
    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }

    /**
     * @return the brand_name
     */
    public String getBrand_name() {
        return brand_name;
    }

    /**
     * @param brand_name the brand_name to set
     */
    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    /**
     * @return the brand_description
     */
    public String getBrand_description() {
        return brand_description;
    }

    /**
     * @param brand_description the brand_description to set
     */
    public void setBrand_description(String brand_description) {
        this.brand_description = brand_description;
    }

    /**
     * @return the brand_status
     */
    public int getBrand_status() {
        return brand_status;
    }

    /**
     * @param brand_status the brand_status to set
     */
    public void setBrand_status(int brand_status) {
        this.brand_status = brand_status;
    }

    /**
     * @return the created_at
     */
    public Date getCreated_at() {
        return created_at;
    }

    /**
     * @param created_at the created_at to set
     */
    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    /**
     * @return the updated_at
     */
    public Date getUpdated_at() {
        return updated_at;
    }

    /**
     * @param updated_at the updated_at to set
     */
    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

}
