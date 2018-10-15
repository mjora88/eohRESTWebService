package za.co.khoza.eoh.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table
public class Invoice
{
  @Id
  @GeneratedValue
  private Long id;

  @Column
  private String client;

  @Column
  private LocalDate invoiceDate;

  @OneToMany(cascade = CascadeType.ALL)
  private List<LineItem> lineItems;

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getClient()
  {
    return client;
  }

  public void setClient(String client)
  {
    this.client = client;
  }

  public LocalDate getInvoiceDate()
  {
    return invoiceDate;
  }

  public void setInvoiceDate(LocalDate invoiceDate)
  {
    this.invoiceDate = invoiceDate;
  }

  public List<LineItem> getLineItems()
  {
    return lineItems;
  }

  public void setLineItems(List<LineItem> lineItems)
  {
    this.lineItems = lineItems;
  }

  public BigDecimal getSubTotal()
  {
    return getTotal().subtract(getVat()).round(new MathContext(2, RoundingMode.HALF_UP));
  }

  public BigDecimal getVat()
  {
    return getTotal().multiply(BigDecimal.valueOf(0.15)).round(new MathContext(2, RoundingMode.HALF_UP));
  }

  public BigDecimal getTotal()
  {
    //this may suffer loss of precision --> big dec to double
    double total = lineItems.stream().mapToDouble(lineItem -> lineItem.getLineItemTotal().doubleValue()).sum();

    return BigDecimal.valueOf(total).round(new MathContext(2, RoundingMode.HALF_UP));
  }
}

