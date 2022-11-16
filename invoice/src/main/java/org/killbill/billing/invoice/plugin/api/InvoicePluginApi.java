/*
 * Copyright 2014-2015 Groupon, Inc
 * Copyright 2014-2015 The Billing Project, LLC
 *
 * The Billing Project licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.killbill.billing.invoice.plugin.api;

import java.util.List;

import org.killbill.billing.invoice.api.Invoice;
import org.killbill.billing.invoice.api.InvoiceItem;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.util.callcontext.CallContext;

public interface InvoicePluginApi {

    PriorInvoiceResult priorCall(InvoiceContext context, Iterable<PluginProperty> properties);

    /**
     * Returns additional invoice items (setup fees, VAT tax, etc) to be added to the invoice upon creation
     *
     * @param invoice the invoice that is being created
     * @param dryRun  if true, the invoice won't be persisted
     * @param context the call context
     * @return the list of additional invoice items to add to the new invoice
     */
    AdditionalItemsResult getAdditionalInvoiceItems(Invoice invoice, boolean dryRun, Iterable<PluginProperty> properties, InvoiceContext context);

    InvoiceGroupingResult getInvoiceGrouping(Invoice invoice, boolean dryRun, Iterable<PluginProperty> properties, InvoiceContext context);

    OnSuccessInvoiceResult onSuccessCall(InvoiceContext context, Iterable<PluginProperty> properties);

    OnFailureInvoiceResult onFailureCall(InvoiceContext context, Iterable<PluginProperty> properties);
}
