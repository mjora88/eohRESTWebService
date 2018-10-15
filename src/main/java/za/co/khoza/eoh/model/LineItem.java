package za.co.khoza.eoh.model;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Entity
@Table
public class LineItem
{
  @Id
  @GeneratedValue
  private Long id;

  @Column
  private long quantity;

  @Column
  private String description;


  @Column
  @Digits(integer=5, fraction=2)
  private BigDecimal unitPrice;

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public long getQuantity()
  {
    return quantity;
  }

  public void setQuantity(long quantity)
  {
    this.quantity = quantity;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public BigDecimal getUnitPrice()
  {
    return unitPrice;
  }

  public void setUnitPrice(BigDecimal unitPrice)
  {
    this.unitPrice = unitPrice;
  }

  public BigDecimal getLineItemTotal(){
    return this.unitPrice.multiply(BigDecimal.valueOf(quantity)).round(new MathContext(2, RoundingMode.HALF_UP));
  }
}
