package models.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import models.dto.UserDto;

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

    @Id
    @Basic(optional = false)
    @Column(name = "US_ID")
    private Integer usId;
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

    public User(Integer usId) {
        this.usId = usId;
    }

    public User(Integer usId, String usName, String usPassword, String usRole) {
        this.usId = usId;
        this.usName = usName;
        this.usPassword = usPassword;
        this.usRole = usRole;
    }

    public User(UserDto pUser) {
        
        this.usId = pUser.getID();
        this.usName = pUser.getName().get();
        this.usPassword = pUser.getName().get();
        this.usRole = pUser.getRole().get();
    }
    
    public Integer getUsId() {
        return usId;
    }

    public void setUsId(Integer usId) {
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

        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        return !((this.usId == null && other.usId != null) || (this.usId != null && !this.usId.equals(other.usId)));
    }

    @Override
    public String toString() {
        return "models.entity.User[ usId=" + usId + " ]";
    }
    
}
