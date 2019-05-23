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
public class Supplier {

    private Integer sup_id;
    private String sup_name;
    private String sup_address;
    private String sup_teliphone;
    private String sup_email;
    private int sup_status;
    private String sup_companyName;
    private String sup_IDnumber;
    private String created_at;
    private String updated_at;
    private User user_id;

    public Supplier() {
    }

    public Supplier(Integer sup_id, String sup_name, String sup_address, String sup_teliphone, String sup_email, int sup_status, String sup_companyName, String sup_IDnumber, String created_at, String updated_at, User user_id) {
        this.sup_id = sup_id;
        this.sup_name = sup_name;
        this.sup_address = sup_address;
        this.sup_teliphone = sup_teliphone;
        this.sup_email = sup_email;
        this.sup_status = sup_status;
        this.sup_companyName = sup_companyName;
        this.sup_IDnumber = sup_IDnumber;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.user_id = user_id;
    }

    /**
     * @return the sup_id
     */
    public Integer getSup_id() {
        return sup_id;
    }

    /**
     * @param sup_id the sup_id to set
     */
    public void setSup_id(Integer sup_id) {
        this.sup_id = sup_id;
    }

    /**
     * @return the sup_name
     */
    public String getSup_name() {
        return sup_name;
    }

    /**
     * @param sup_name the sup_name to set
     */
    public void setSup_name(String sup_name) {
        this.sup_name = sup_name;
    }

    /**
     * @return the sup_address
     */
    public String getSup_address() {
        return sup_address;
    }

    /**
     * @param sup_address the sup_address to set
     */
    public void setSup_address(String sup_address) {
        this.sup_address = sup_address;
    }

    /**
     * @return the sup_teliphone
     */
    public String getSup_teliphone() {
        return sup_teliphone;
    }

    /**
     * @param sup_teliphone the sup_teliphone to set
     */
    public void setSup_teliphone(String sup_teliphone) {
        this.sup_teliphone = sup_teliphone;
    }

    /**
     * @return the sup_email
     */
    public String getSup_email() {
        return sup_email;
    }

    /**
     * @param sup_email the sup_email to set
     */
    public void setSup_email(String sup_email) {
        this.sup_email = sup_email;
    }

    /**
     * @return the sup_status
     */
    public int getSup_status() {
        return sup_status;
    }

    /**
     * @param sup_status the sup_status to set
     */
    public void setSup_status(int sup_status) {
        this.sup_status = sup_status;
    }

    /**
     * @return the sup_companyName
     */
    public String getSup_companyName() {
        return sup_companyName;
    }

    /**
     * @param sup_companyName the sup_companyName to set
     */
    public void setSup_companyName(String sup_companyName) {
        this.sup_companyName = sup_companyName;
    }

    /**
     * @return the sup_IDnumber
     */
    public String getSup_IDnumber() {
        return sup_IDnumber;
    }

    /**
     * @param sup_IDnumber the sup_IDnumber to set
     */
    public void setSup_IDnumber(String sup_IDnumber) {
        this.sup_IDnumber = sup_IDnumber;
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

   
}
