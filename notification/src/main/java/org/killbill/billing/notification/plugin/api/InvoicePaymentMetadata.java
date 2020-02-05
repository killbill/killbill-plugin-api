/*
 * Copyright 2014-2017 Groupon, Inc
 * Copyright 2014-2017 The Billing Project, LLC
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

package org.killbill.billing.notification.plugin.api;

import java.math.BigDecimal;
import java.util.UUID;

import org.joda.time.DateTime;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.invoice.api.InvoicePaymentType;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvoicePaymentMetadata {

    private UUID paymentId;
    private UUID paymentAttemptId;
    private InvoicePaymentType invoicePaymentType;
    private DateTime paymentDate;
    private BigDecimal amount;
    private Currency currency;
    private UUID linkedInvoicePaymentId;
    private String paymentCookieId;
    private Currency processedCurrency;

    /**
     * This is needed for object deserialization.
     */
    public InvoicePaymentMetadata() {}

    public InvoicePaymentMetadata(@JsonProperty("paymentId") final UUID paymentId,
                                  @JsonProperty("paymentAttemptId") final UUID paymentAttemptId,
                                  @JsonProperty("invoicePaymentType") final InvoicePaymentType invoicePaymentType,
                                  @JsonProperty("paymentDate") final DateTime paymentDate,
                                  @JsonProperty("amount") final BigDecimal amount,
                                  @JsonProperty("currency") final Currency currency,
                                  @JsonProperty("linkedInvoicePaymentId") final UUID linkedInvoicePaymentId,
                                  @JsonProperty("paymentCookieId") final String paymentCookieId,
                                  @JsonProperty("processedCurrency") final Currency processedCurrency) {
        this.paymentId = paymentId;
        this.paymentAttemptId = paymentAttemptId;
        this.invoicePaymentType = invoicePaymentType;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.currency = currency;
        this.linkedInvoicePaymentId = linkedInvoicePaymentId;
        this.paymentCookieId = paymentCookieId;
        this.processedCurrency = processedCurrency;
    }

    public UUID getPaymentId() {
        return paymentId;
    }

    public UUID getPaymentAttemptId() {
        return paymentAttemptId;
    }

    public InvoicePaymentType getInvoicePaymentType() {
        return invoicePaymentType;
    }

    public DateTime getPaymentDate() {
        return paymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public UUID getLinkedInvoicePaymentId() {
        return linkedInvoicePaymentId;
    }

    public String getPaymentCookieId() {
        return paymentCookieId;
    }

    public Currency getProcessedCurrency() {
        return processedCurrency;
    }
}
