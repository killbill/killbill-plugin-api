package org.killbill.billing.invoice.plugin.api;

import java.util.List;

import org.killbill.billing.invoice.api.Invoice;
import org.killbill.billing.invoice.api.InvoiceItem;

public interface InvoicePluginApi {

    /**
     * Returns additional external charge items (setup fees, etc) to be added to the invoice upon creation
     * @param invoice the invoice that is being created
     * @return the list of additional external charge items to add to the new invoice
     */
    List<InvoiceItem> getAdditionalExternalChargeItems(Invoice invoice);

    /**
     * Returns tax items (VAT, etc) to be added to the invoice upon creation
     * @param invoice the invoice that is being created
     * @return the list of tax items to add to the new invoice
     */
    List<InvoiceItem> getAdditionalTaxItems(Invoice invoice);
}
