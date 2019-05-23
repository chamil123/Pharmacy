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
public class Customer {

    private Integer cus_id;
    private String cus_firstName;
    private String cus_lastName;
    private String cus_IDNumber;
    private String cus_address;
    private String cus_email;
    private String cus_mobile;
    private int cus_status;
    private String created_at;
    private String updated_at;

    public Customer() {
    }

    public Customer(Integer cus_id, String cus_firstName, String cus_lastName, String cus_IDNumber, String cus_address, String cus_email, String cus_mobile, int cus_status, String created_at, String updated_at) {
        this.cus_id = cus_id;
        this.cus_firstName = cus_firstName;
        this.cus_lastName = cus_lastName;
        this.cus_IDNumber = cus_IDNumber;
        this.cus_address = cus_address;
        this.cus_email = cus_email;
        this.cus_mobile = cus_mobile;
        this.cus_status = cus_status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    /**
     * @return the cus_id
     */
    public Integer getCus_id() {
        return cus_id;
    }

    /**
     * @param cus_id the cus_id to set
     */
    public void setCus_id(Integer cus_id) {
        this.cus_id = cus_id;
    }

    /**
     * @return the cus_firstName
     */
    public String getCus_firstName() {
        return cus_firstName;
    }

    /**
     * @param cus_firstName the cus_firstName to set
     */
    public void setCus_firstName(String cus_firstName) {
        this.cus_firstName = cus_firstName;
    }

    /**
     * @return the cus_lastName
     */
    public String getCus_lastName() {
        return cus_lastName;
    }

    /**
     * @param cus_lastName the cus_lastName to set
     */
    public void setCus_lastName(String cus_lastName) {
        this.cus_lastName = cus_lastName;
    }

    /**
     * @return the cus_IDNumber
     */
    public String getCus_IDNumber() {
        return cus_IDNumber;
    }

    /**
     * @param cus_IDNumber the cus_IDNumber to set
     */
    public void setCus_IDNumber(String cus_IDNumber) {
        this.cus_IDNumber = cus_IDNumber;
    }

    /**
     * @return the cus_address
     */
    public String getCus_address() {
        return cus_address;
    }

    /**
     * @param cus_address the cus_address to set
     */
    public void setCus_address(String cus_address) {
        this.cus_address = cus_address;
    }

    /**
     * @return the cus_email
     */
    public String getCus_email() {
        return cus_email;
    }

    /**
     * @param cus_email the cus_email to set
     */
    public void setCus_email(String cus_email) {
        this.cus_email = cus_email;
    }

    /**
     * @return the cus_mobile
     */
    public String getCus_mobile() {
        return cus_mobile;
    }

    /**
     * @param cus_mobile the cus_mobile to set
     */
    public void setCus_mobile(String cus_mobile) {
        this.cus_mobile = cus_mobile;
    }

    /**
     * @return the cus_status
     */
    public int getCus_status() {
        return cus_status;
    }

    /**
     * @param cus_status the cus_status to set
     */
    public void setCus_status(int cus_status) {
        this.cus_status = cus_status;
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
    
    
}
