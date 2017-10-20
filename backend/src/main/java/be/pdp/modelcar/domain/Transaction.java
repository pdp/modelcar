package be.pdp.modelcar.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by peterdp on 07/10/2017.
 */
@Entity
@Table(name = "Transaction")
@Getter @Setter
public class Transaction extends DomainObject{

    @Id
    @SequenceGenerator(name = "TRANSACTION_GEN", sequenceName = "TRANSACTION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTION_GEN")
    private Long id;

    @Column(name = "TRANSACTION_NO")
    private String transactionNumber;

    @Column(name = "TRANSACTION_TYPE")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private BigDecimal price;

    @Column(name = "SHOP_PRICE")
    private Date shopPrice;

    @Column(name = "SHIPMENT_AMOUNT")
    private BigDecimal shipmentAmount;

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (getClass() != object.getClass()) {
            return false;
        }

        final Transaction other = (Transaction) object;
        return Objects.equal(transactionNumber, other.transactionNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(transactionNumber);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("transactionNumber", transactionNumber)
                .add("transactionType", transactionType)
                .toString();
    }
}