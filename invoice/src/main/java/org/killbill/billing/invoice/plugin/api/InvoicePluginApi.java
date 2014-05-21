package org.killbill.billing.invoice.plugin.api;

import java.util.List;

import org.killbill.billing.invoice.api.Invoice;
import org.killbill.billing.invoice.api.InvoiceItem;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.util.callcontext.CallContext;

public interface InvoicePluginApi {

    /**
     * Returns additional invoice items (setup fees, VAT tax, etc) to be added to the invoice upon creation
     * @param invoice the invoice that is being created
     * @param context the call context
     * @return the list of additional invoice items to add to the new invoice
     */
    List<InvoiceItem> getAdditionalInvoiceItems(Invoice invoice, Iterable<PluginProperty> properties, CallContext context);
}
