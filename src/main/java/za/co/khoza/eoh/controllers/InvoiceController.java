package za.co.khoza.eoh.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.khoza.eoh.model.Invoice;
import za.co.khoza.eoh.services.InvoiceService;

import java.util.List;

@RestController
public class InvoiceController
{

  @Autowired
  private InvoiceService invoiceService;


  @PostMapping("/invoices")
  public Invoice addInvoice(Invoice invoice)
  {
    return invoiceService.addInvoice(invoice);
  }

  @GetMapping("/invoices")
  public List<Invoice> viewAllInvoices()
  {
    return invoiceService.retrieveAllInvoices();
  }


  @GetMapping("/invoice/{invoiceId}")
  public Invoice viewInvoice(@PathVariable long invoiceId)
  {
    return invoiceService.getInvoice(invoiceId);
  }
}
