/*
 * Copyright 2010-2013 Ning, Inc.
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

package org.killbill.billing.retry.plugin.api;

import java.math.BigDecimal;
import java.util.UUID;

import org.joda.time.DateTime;
import org.killbill.billing.account.api.Account;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.payment.api.TransactionType;
import org.killbill.billing.util.callcontext.CallContext;

public interface PaymentControlPluginApi {

    public PriorPaymentControlResult priorCall(PaymentControlContext context) throws PaymentControlApiException, UnknownEntryException;

    public void onCompletionCall(PaymentControlContext context) throws PaymentControlApiException;

    public FailureCallResult onFailureCall(PaymentControlContext context) throws PaymentControlApiException;

    public interface PriorPaymentControlResult {

        /**
         * @return true if call should not proceed
         */
        public boolean isAborted();

        /**
         * @return the new amount that should be used for that attempt
         */
        public BigDecimal getAdjustedAmount();
    }

    public interface FailureCallResult {

        /**
         * @return the date the call should be retried or null if there should be no retry
         */
        public DateTime getNextRetryDate();
    }

    public interface PaymentControlContext extends CallContext {

        public Account getAccount();

        public String getPaymentExternalKey();

        public String getTransactionExternalKey();

        public TransactionType getTransactionType();

        public BigDecimal getAmount();

        public Currency getCurrency();

        public UUID getPaymentMethodId();

        public UUID getPaymentId();

        public BigDecimal getProcessedAmount();

        public Currency getProcessedCurrency();

        public boolean isApiPayment();

        public Iterable<PluginProperty> getPluginProperties();

    }
}
