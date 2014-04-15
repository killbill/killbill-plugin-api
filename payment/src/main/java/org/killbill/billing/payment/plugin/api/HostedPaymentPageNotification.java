/*
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

package org.killbill.billing.payment.plugin.api;

import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * Represents a transaction notification from the remote service
 */
public interface HostedPaymentPageNotification {

    public boolean isComplete();

    public String getItemId();

    public String getTransactionId();

    // When was this payment received by the client
    public DateTime getReceivedAt();

    public String getPayerEmail();

    public String getReceiverEmail();

    public String getSecurityKey();

    public BigDecimal getGrossAmount();

    public String getStatus();

    /**
     * Acknowledge the transaction with the remote service
     *
     * @return true on success, false otherwise
     */
    public boolean acknowledge() throws PaymentPluginApiException;
}
