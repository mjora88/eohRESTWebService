package za.co.khoza.eoh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.khoza.eoh.data.InvoiceRepository;
import za.co.khoza.eoh.model.Invoice;

import java.util.List;


@Service
public class InvoiceServiceImpl implements InvoiceService
{

  @Autowired
  private InvoiceRepository invoiceRepository;
  @Override
  public Invoice addInvoice(Invoice invoice)
  {
    return invoiceRepository.save(invoice);
  }

  @Override
  public List<Invoice> retrieveAllInvoices()
  {
    return invoiceRepository.findAll();
  }

  @Override
  public Invoice getInvoice(long invoiceId)
  {
    return invoiceRepository.getOne(invoiceId);
  }
}
