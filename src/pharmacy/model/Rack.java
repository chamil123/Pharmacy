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
public class Rack {

    private Integer rack_id;
    private String rack_name;
    private int rack_status;

    public Rack() {
    }

    public Rack(Integer rack_id, String rack_name, int rack_status) {
        this.rack_id = rack_id;
        this.rack_name = rack_name;
        this.rack_status = rack_status;
    }

    /**
     * @return the rack_id
     */
    public Integer getRack_id() {
        return rack_id;
    }

    /**
     * @param rack_id the rack_id to set
     */
    public void setRack_id(Integer rack_id) {
        this.rack_id = rack_id;
    }

    /**
     * @return the rack_name
     */
    public String getRack_name() {
        return rack_name;
    }

    /**
     * @param rack_name the rack_name to set
     */
    public void setRack_name(String rack_name) {
        this.rack_name = rack_name;
    }

    /**
     * @return the rack_status
     */
    public int getRack_status() {
        return rack_status;
    }

    /**
     * @param rack_status the rack_status to set
     */
    public void setRack_status(int rack_status) {
        this.rack_status = rack_status;
    }
    
}
