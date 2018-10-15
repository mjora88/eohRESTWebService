package za.co.khoza.eoh.data;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.khoza.eoh.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>
{
}
