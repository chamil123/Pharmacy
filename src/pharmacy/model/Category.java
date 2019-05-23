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
public class Category {

    private Integer cat_id;
    private String cat_name;
    private String cat_description;
    private int cat_status;
    private Date created_at;
    private Date updated_at;

    public Category() {
    }

    
    public Category(Integer cat_id, String cat_name, String cat_description, int cat_status, Date created_at, Date updated_at) {
        this.cat_id = cat_id;
        this.cat_name = cat_name;
        this.cat_description = cat_description;
        this.cat_status = cat_status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    /**
     * @return the cat_id
     */
    public Integer getCat_id() {
        return cat_id;
    }

    /**
     * @param cat_id the cat_id to set
     */
    public void setCat_id(Integer cat_id) {
        this.cat_id = cat_id;
    }

    /**
     * @return the cat_name
     */
    public String getCat_name() {
        return cat_name;
    }

    /**
     * @param cat_name the cat_name to set
     */
    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    /**
     * @return the cat_description
     */
    public String getCat_description() {
        return cat_description;
    }

    /**
     * @param cat_description the cat_description to set
     */
    public void setCat_description(String cat_description) {
        this.cat_description = cat_description;
    }

    /**
     * @return the cat_status
     */
    public int getCat_status() {
        return cat_status;
    }

    /**
     * @param cat_status the cat_status to set
     */
    public void setCat_status(int cat_status) {
        this.cat_status = cat_status;
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
