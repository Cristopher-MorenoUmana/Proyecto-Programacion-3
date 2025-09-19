/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author neynm
 */
@Entity
@Table(name = "TBL_USER")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUsId", query = "SELECT u FROM User u WHERE u.usId = :usId"),
    @NamedQuery(name = "User.findByUsName", query = "SELECT u FROM User u WHERE u.usName = :usName"),
    @NamedQuery(name = "User.findByUsPassword", query = "SELECT u FROM User u WHERE u.usPassword = :usPassword"),
    @NamedQuery(name = "User.findByUsRole", query = "SELECT u FROM User u WHERE u.usRole = :usRole")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "US_ID")
    private BigDecimal usId;
    @Basic(optional = false)
    @Column(name = "US_NAME")
    private String usName;
    @Basic(optional = false)
    @Column(name = "US_PASSWORD")
    private String usPassword;
    @Basic(optional = false)
    @Column(name = "US_ROLE")
    private String usRole;

    public User() {
    }

    public User(BigDecimal usId) {
        this.usId = usId;
    }

    public User(BigDecimal usId, String usName, String usPassword, String usRole) {
        this.usId = usId;
        this.usName = usName;
        this.usPassword = usPassword;
        this.usRole = usRole;
    }

    public BigDecimal getUsId() {
        return usId;
    }

    public void setUsId(BigDecimal usId) {
        this.usId = usId;
    }

    public String getUsName() {
        return usName;
    }

    public void setUsName(String usName) {
        this.usName = usName;
    }

    public String getUsPassword() {
        return usPassword;
    }

    public void setUsPassword(String usPassword) {
        this.usPassword = usPassword;
    }

    public String getUsRole() {
        return usRole;
    }

    public void setUsRole(String usRole) {
        this.usRole = usRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usId != null ? usId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.usId == null && other.usId != null) || (this.usId != null && !this.usId.equals(other.usId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.entity.User[ usId=" + usId + " ]";
    }
    
}
