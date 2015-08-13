/*
 * Copyright 2014 Groupon, Inc
 * Copyright 2014 The Billing Project, LLC
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

package org.killbill.billing.control.plugin.api;

import java.math.BigDecimal;
import java.util.UUID;

import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.payment.api.TransactionType;
import org.killbill.billing.util.callcontext.CallContext;

public interface PaymentControlContext extends CallContext {

    public UUID getAccountId();

    public UUID getPaymentId();

    public UUID getAttemptPaymentId();

    public String getPaymentExternalKey();

    public UUID getTransactionId();

    public String getTransactionExternalKey();

    public PaymentApiType getPaymentApiType();

    public TransactionType getTransactionType();

    public HPPType getHPPType();

    public BigDecimal getAmount();

    public Currency getCurrency();

    public UUID getPaymentMethodId();

    public BigDecimal getProcessedAmount();

    public Currency getProcessedCurrency();

    public boolean isApiPayment();
}
