/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KBT
 */
@Entity
@Table(name = "orrderdetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orrderdetail.findAll", query = "SELECT o FROM Orrderdetail o"),
    @NamedQuery(name = "Orrderdetail.findById", query = "SELECT o FROM Orrderdetail o WHERE o.id = :id"),
    @NamedQuery(name = "Orrderdetail.findByQuantity", query = "SELECT o FROM Orrderdetail o WHERE o.quantity = :quantity"),
    @NamedQuery(name = "Orrderdetail.findByUnitPrice", query = "SELECT o FROM Orrderdetail o WHERE o.unitPrice = :unitPrice")})
public class Orrderdetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "unit_price")
    private String unitPrice;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne
    private Product productId;

    public Orrderdetail() {
    }

    public Orrderdetail(Integer id) {
        this.id = id;
    }

    public Orrderdetail(Integer id, int quantity, String unitPrice) {
        this.id = id;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orrderdetail)) {
            return false;
        }
        Orrderdetail other = (Orrderdetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Orrderdetail[ id=" + id + " ]";
    }
    
}
