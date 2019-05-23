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
public class User {

    private Integer user_id;
    private String user_firstName;
    private String user_lastName;
    private String user_email;
    private String user_NIC;
    private String user_DOB;
    private String user_phoneNumber;
    private String user_gender;
    private String user_addess;
    private String user_image;
    private int user_status;
    private String created_at;
    private String updaated_at;
    private Role role_id;

    public User() {
    }

    public User(Integer user_id, String user_firstName, String user_lastName, String user_email, String user_NIC, String user_DOB, String user_phoneNumber, String user_gender, String user_addess, String user_image, int user_status, String created_at, String updaated_at, Role role_id) {
        this.user_id = user_id;
        this.user_firstName = user_firstName;
        this.user_lastName = user_lastName;
        this.user_email = user_email;
        this.user_NIC = user_NIC;
        this.user_DOB = user_DOB;
        this.user_phoneNumber = user_phoneNumber;
        this.user_gender = user_gender;
        this.user_addess = user_addess;
        this.user_image = user_image;
        this.user_status = user_status;
        this.created_at = created_at;
        this.updaated_at = updaated_at;
        this.role_id = role_id;
    }

    /**
     * @return the user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the user_firstName
     */
    public String getUser_firstName() {
        return user_firstName;
    }

    /**
     * @param user_firstName the user_firstName to set
     */
    public void setUser_firstName(String user_firstName) {
        this.user_firstName = user_firstName;
    }

    /**
     * @return the user_lastName
     */
    public String getUser_lastName() {
        return user_lastName;
    }

    /**
     * @param user_lastName the user_lastName to set
     */
    public void setUser_lastName(String user_lastName) {
        this.user_lastName = user_lastName;
    }

    /**
     * @return the user_email
     */
    public String getUser_email() {
        return user_email;
    }

    /**
     * @param user_email the user_email to set
     */
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    /**
     * @return the user_NIC
     */
    public String getUser_NIC() {
        return user_NIC;
    }

    /**
     * @param user_NIC the user_NIC to set
     */
    public void setUser_NIC(String user_NIC) {
        this.user_NIC = user_NIC;
    }

    /**
     * @return the user_DOB
     */
    public String getUser_DOB() {
        return user_DOB;
    }

    /**
     * @param user_DOB the user_DOB to set
     */
    public void setUser_DOB(String user_DOB) {
        this.user_DOB = user_DOB;
    }

    /**
     * @return the user_phoneNumber
     */
    public String getUser_phoneNumber() {
        return user_phoneNumber;
    }

    /**
     * @param user_phoneNumber the user_phoneNumber to set
     */
    public void setUser_phoneNumber(String user_phoneNumber) {
        this.user_phoneNumber = user_phoneNumber;
    }

    /**
     * @return the user_gender
     */
    public String getUser_gender() {
        return user_gender;
    }

    /**
     * @param user_gender the user_gender to set
     */
    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
    }

    /**
     * @return the user_addess
     */
    public String getUser_addess() {
        return user_addess;
    }

    /**
     * @param user_addess the user_addess to set
     */
    public void setUser_addess(String user_addess) {
        this.user_addess = user_addess;
    }

    /**
     * @return the user_image
     */
    public String getUser_image() {
        return user_image;
    }

    /**
     * @param user_image the user_image to set
     */
    public void setUser_image(String user_image) {
        this.user_image = user_image;
    }

    /**
     * @return the user_status
     */
    public int getUser_status() {
        return user_status;
    }

    /**
     * @param user_status the user_status to set
     */
    public void setUser_status(int user_status) {
        this.user_status = user_status;
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
     * @return the updaated_at
     */
    public String getUpdaated_at() {
        return updaated_at;
    }

    /**
     * @param updaated_at the updaated_at to set
     */
    public void setUpdaated_at(String updaated_at) {
        this.updaated_at = updaated_at;
    }

    /**
     * @return the role_id
     */
    public Role getRole_id() {
        return role_id;
    }

    /**
     * @param role_id the role_id to set
     */
    public void setRole_id(Role role_id) {
        this.role_id = role_id;
    }

  
}
