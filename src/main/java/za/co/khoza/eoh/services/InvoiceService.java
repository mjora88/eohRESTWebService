package za.co.khoza.eoh.services;

import za.co.khoza.eoh.model.Invoice;

import java.util.List;

public interface InvoiceService
{

  Invoice addInvoice(Invoice invoice);

  List<Invoice> retrieveAllInvoices();

  Invoice getInvoice(long invoiceId);
}
