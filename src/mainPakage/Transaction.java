/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPakage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author aik
 */
@Entity
@Table(name = "transaction", catalog = "idb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t")
    , @NamedQuery(name = "Transaction.findByCardnumber", query = "SELECT t FROM Transaction t WHERE t.cardnumber = :cardnumber")
    , @NamedQuery(name = "Transaction.findByName", query = "SELECT t FROM Transaction t WHERE t.name = :name")
    , @NamedQuery(name = "Transaction.findByAmount", query = "SELECT t FROM Transaction t WHERE t.amount = :amount")
    , @NamedQuery(name = "Transaction.findByType", query = "SELECT t FROM Transaction t WHERE t.type = :type")
    , @NamedQuery(name = "Transaction.findByRecaccno", query = "SELECT t FROM Transaction t WHERE t.recaccno = :recaccno")
    , @NamedQuery(name = "Transaction.findByDate", query = "SELECT t FROM Transaction t WHERE t.date = :date")
    , @NamedQuery(name = "Transaction.findByTime", query = "SELECT t FROM Transaction t WHERE t.time = :time")
    , @NamedQuery(name = "Transaction.findByNumber", query = "SELECT t FROM Transaction t WHERE t.number = :number")})
public class Transaction implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Column(name = "Card_number")
    private String cardnumber;
    @Column(name = "Name")
    private String name;
    @Column(name = "Amount")
    private String amount;
    @Column(name = "Type")
    private String type;
    @Column(name = "Rec_acc_no")
    private String recaccno;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "Time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Id
    @Basic(optional = false)
    @Column(name = "Number")
    private String number;

    public Transaction() {
    }

    public Transaction(String number) {
        this.number = number;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        String oldCardnumber = this.cardnumber;
        this.cardnumber = cardnumber;
        changeSupport.firePropertyChange("cardnumber", oldCardnumber, cardnumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        String oldAmount = this.amount;
        this.amount = amount;
        changeSupport.firePropertyChange("amount", oldAmount, amount);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        String oldType = this.type;
        this.type = type;
        changeSupport.firePropertyChange("type", oldType, type);
    }

    public String getRecaccno() {
        return recaccno;
    }

    public void setRecaccno(String recaccno) {
        String oldRecaccno = this.recaccno;
        this.recaccno = recaccno;
        changeSupport.firePropertyChange("recaccno", oldRecaccno, recaccno);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        Date oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        Date oldTime = this.time;
        this.time = time;
        changeSupport.firePropertyChange("time", oldTime, time);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        String oldNumber = this.number;
        this.number = number;
        changeSupport.firePropertyChange("number", oldNumber, number);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (number != null ? number.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) object;
        if ((this.number == null && other.number != null) || (this.number != null && !this.number.equals(other.number))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mainPakage.Transaction[ number=" + number + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
