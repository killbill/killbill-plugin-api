/*
 * Copyright 2016 Groupon, Inc
 * Copyright 2016 The Billing Project, LLC
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
import org.killbill.billing.payment.api.TransactionStatus;
import org.killbill.billing.payment.api.TransactionType;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentMetadata {

    private UUID paymentTransactionId;
    private BigDecimal amount;
    private Currency currency;
    private TransactionStatus status;
    private TransactionType transactionType;
    private DateTime effectiveDate;

    public PaymentMetadata() {}

    @JsonCreator
    public PaymentMetadata(@JsonProperty("paymentTransactionId") final UUID paymentTransactionId,
                           @JsonProperty("amount") final BigDecimal amount,
                           @JsonProperty("currency") final Currency currency,
                           @JsonProperty("status") final TransactionStatus status,
                           @JsonProperty("transactionType") final TransactionType transactionType,
                           @JsonProperty("effectiveDate") final DateTime effectiveDate) {
        this.paymentTransactionId = paymentTransactionId;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
        this.transactionType = transactionType;
        this.effectiveDate = effectiveDate;
    }

    public UUID getPaymentTransactionId() {
        return paymentTransactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public DateTime getEffectiveDate() {
        return effectiveDate;
    }
}
