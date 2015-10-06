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

package org.killbill.billing.payment.plugin.api;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.payment.api.PaymentMethodPlugin;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.util.callcontext.CallContext;
import org.killbill.billing.util.callcontext.TenantContext;
import org.killbill.billing.util.entity.Pagination;

public interface PaymentPluginApi {

    /**
     * Authorize a specific amount in the Gateway.
     *
     * @param kbAccountId       killbill accountId
     * @param kbPaymentId       killbill payment id
     * @param kbTransactionId   killbill transaction id
     * @param kbPaymentMethodId killbill payment method id
     * @param amount            amount to charge
     * @param currency          currency
     * @param properties        custom properties for the gateway
     * @param context           call context
     * @return information about the authorization in the gateway
     * @throws PaymentPluginApiException If any unexpected error occurs
     */
    public PaymentTransactionInfoPlugin authorizePayment(UUID kbAccountId, UUID kbPaymentId, UUID kbTransactionId, UUID kbPaymentMethodId, BigDecimal amount, Currency currency, Iterable<PluginProperty> properties, CallContext context)
            throws PaymentPluginApiException;

    /**
     * Capture a specific amount in the Gateway.
     *
     * @param kbAccountId       killbill accountId
     * @param kbPaymentId       killbill payment id
     * @param kbTransactionId   killbill transaction id
     * @param kbPaymentMethodId killbill payment method id
     * @param amount            amount to charge
     * @param currency          currency
     * @param properties        custom properties for the gateway
     * @param context           call context
     * @return information about the capture in the gateway
     * @throws PaymentPluginApiException If any unexpected error occurs
     */
    public PaymentTransactionInfoPlugin capturePayment(UUID kbAccountId, UUID kbPaymentId, UUID kbTransactionId, UUID kbPaymentMethodId, BigDecimal amount, Currency currency, Iterable<PluginProperty> properties, CallContext context)
            throws PaymentPluginApiException;

    /**
     * Charge a specific amount in the Gateway.
     *
     * @param kbAccountId       killbill accountId
     * @param kbPaymentId       killbill payment id
     * @param kbTransactionId   killbill transaction id
     * @param kbPaymentMethodId killbill payment method id
     * @param amount            amount to charge
     * @param currency          currency
     * @param properties        custom properties for the gateway
     * @param context           call context
     * @return information about the payment in the gateway
     * @throws PaymentPluginApiException If any unexpected error occurs
     */
    public PaymentTransactionInfoPlugin purchasePayment(UUID kbAccountId, UUID kbPaymentId, UUID kbTransactionId, UUID kbPaymentMethodId, BigDecimal amount, Currency currency, Iterable<PluginProperty> properties, CallContext context)
            throws PaymentPluginApiException;

    /**
     * Void an authorization in the Gateway.
     *
     * @param kbAccountId       killbill accountId
     * @param kbPaymentId       killbill payment id
     * @param kbTransactionId   killbill transaction id
     * @param kbPaymentMethodId killbill payment method id
     * @param properties        custom properties for the gateway
     * @param context           call context
     * @return information about the capture in the gateway
     * @throws PaymentPluginApiException If any unexpected error occurs
     */
    public PaymentTransactionInfoPlugin voidPayment(UUID kbAccountId, UUID kbPaymentId, UUID kbTransactionId, UUID kbPaymentMethodId, Iterable<PluginProperty> properties, CallContext context)
            throws PaymentPluginApiException;

    /**
     * Credit a specific amount in the Gateway.
     *
     * @param kbAccountId       killbill accountId
     * @param kbPaymentId       killbill payment id
     * @param kbTransactionId   killbill transaction id
     * @param kbPaymentMethodId killbill payment method id
     * @param amount            amount to credit
     * @param currency          currency
     * @param properties        custom properties for the gateway
     * @param context           call context
     * @return information about the credit in the gateway
     * @throws PaymentPluginApiException If any unexpected error occurs
     */
    public PaymentTransactionInfoPlugin creditPayment(UUID kbAccountId, UUID kbPaymentId, UUID kbTransactionId, UUID kbPaymentMethodId, BigDecimal amount, Currency currency, Iterable<PluginProperty> properties, CallContext context)
            throws PaymentPluginApiException;

    /**
     * Process a refund against a given payment.
     *
     * @param kbAccountId       killbill accountId
     * @param kbPaymentId       killbill payment id
     * @param kbTransactionId   killbill transaction id
     * @param kbPaymentMethodId killbill payment method id
     * @param amount            refund amount
     * @param currency          currency
     * @param properties        custom properties for the gateway
     * @param context           call context
     * @return information about the refund in the gateway
     * @throws PaymentPluginApiException If any unexpected error occurs
     */
    public PaymentTransactionInfoPlugin refundPayment(UUID kbAccountId, UUID kbPaymentId, UUID kbTransactionId, UUID kbPaymentMethodId, BigDecimal amount, Currency currency, Iterable<PluginProperty> properties, CallContext context)
            throws PaymentPluginApiException;

    /**
     * Retrieve information about a given payment.
     *
     * @param kbAccountId killbill accountId
     * @param kbPaymentId killbill payment id
     * @param properties  custom properties for the gateway
     * @param context     call context
     * @return information about the payment in the gateway
     * @throws PaymentPluginApiException If any unexpected error occurs
     */
    public List<PaymentTransactionInfoPlugin> getPaymentInfo(UUID kbAccountId, UUID kbPaymentId, Iterable<PluginProperty> properties, TenantContext context)
            throws PaymentPluginApiException;

    /**
     * Search payments.
     * <p>
     * The search is plugin specific, there is no constraint on how the searchKey should be interpreted.
     *
     * @param offset     the offset of the first result
     * @param limit      the maximum number of results to retrieve
     * @param properties custom properties for the gateway
     * @param context    call context
     * @return payments matching the search key
     * @throws PaymentPluginApiException If any unexpected error occurs
     */
    public Pagination<PaymentTransactionInfoPlugin> searchPayments(String searchKey, Long offset, Long limit, Iterable<PluginProperty> properties, TenantContext context)
            throws PaymentPluginApiException;

    /**
     * Add a payment method for a Killbill account in the gateway.
     * <p>
     * Note: the payment method doesn't exist yet in Killbill when receiving the call in
     * the plugin (kbPaymentMethodId is a placeholder).
     *
     * @param kbAccountId        killbill accountId
     * @param paymentMethodProps payment method details
     * @param setDefault         set it as the default payment method in the gateway
     * @param properties         custom properties for the gateway
     * @param context            call context
     * @throws PaymentPluginApiException If any unexpected error occurs
     */
    public void addPaymentMethod(UUID kbAccountId, UUID kbPaymentMethodId, PaymentMethodPlugin paymentMethodProps, boolean setDefault, Iterable<PluginProperty> properties, CallContext context)
            throws PaymentPluginApiException;

    /**
     * Delete a payment method in the gateway.
     *
     * @param kbAccountId       killbill accountId
     * @param kbPaymentMethodId killbill payment method id
     * @param properties        custom properties for the gateway
     * @param context           call context
     * @throws PaymentPluginApiException If any unexpected error occurs
     */
    public void deletePaymentMethod(UUID kbAccountId, UUID kbPaymentMethodId, Iterable<PluginProperty> properties, CallContext context)
            throws PaymentPluginApiException;

    /**
     * Get payment method details for a given payment method.
     *
     * @param kbAccountId       killbill account id
     * @param kbPaymentMethodId killbill payment method id
     * @param properties        custom properties for the gateway
     * @param context           call context
     * @return PaymentMethodPlugin info for the payment method
     * @throws PaymentPluginApiException If any unexpected error occurs
     */
    public PaymentMethodPlugin getPaymentMethodDetail(UUID kbAccountId, UUID kbPaymentMethodId, Iterable<PluginProperty> properties, TenantContext context)
            throws PaymentPluginApiException;

    /**
     * Set a payment method as default in the gateway.
     *
     * @param kbAccountId       killbill accountId
     * @param kbPaymentMethodId killbill payment method id
     * @param properties        custom properties for the gateway
     * @param context           call context
     * @throws PaymentPluginApiException If any unexpected error occurs
     */
    public void setDefaultPaymentMethod(UUID kbAccountId, UUID kbPaymentMethodId, Iterable<PluginProperty> properties, CallContext context)
            throws PaymentPluginApiException;

    /**
     * This is used to see the view of paymentMethods kept by the plugin or the view of
     * existing payment method on the gateway.
     * <p>
     * Sometimes payment methods have to be added directly to the gateway for PCI compliance issues
     * and so Kill Bill needs to refresh its state.
     *
     * @param kbAccountId        killbill accountId
     * @param refreshFromGateway fetch the list of existing  payment methods from gateway -- if supported
     * @param properties         custom properties for the gateway
     * @param context            call context
     * @return all payment methods for that account
     * @throws PaymentPluginApiException If any unexpected error occurs
     */
    public List<PaymentMethodInfoPlugin> getPaymentMethods(UUID kbAccountId, boolean refreshFromGateway, Iterable<PluginProperty> properties, CallContext context)
            throws PaymentPluginApiException;

    /**
     * Search payment methods
     * <p>
     * The search is plugin specific, there is no constraint on how the searchKey should be interpreted.
     *
     * @param offset     the offset of the first result
     * @param limit      the maximum number of results to retrieve
     * @param properties custom properties for the gateway
     * @param context    call context
     * @return payment methods matching the search key
     * @throws PaymentPluginApiException If any unexpected error occurs
     */
    public Pagination<PaymentMethodPlugin> searchPaymentMethods(String searchKey, Long offset, Long limit, Iterable<PluginProperty> properties, TenantContext context)
            throws PaymentPluginApiException;

    /**
     * This is used after Killbill decided to refresh its state from the gateway
     *
     * @param kbAccountId    killbill accountId
     * @param paymentMethods the list of payment methods
     * @param properties     custom properties for the gateway
     * @param context        call context
     * @throws PaymentPluginApiException If any unexpected error occurs
     */
    public void resetPaymentMethods(UUID kbAccountId, List<PaymentMethodInfoPlugin> paymentMethods, Iterable<PluginProperty> properties, CallContext context)
            throws PaymentPluginApiException;

    /**
     * Build metadata for the client to create a redirect form
     *
     * @param kbAccountId  killbill accountId
     * @param customFields form fields
     * @param properties   custom properties for the gateway
     * @param context      call context
     * @return redirect form metadata
     * @throws PaymentPluginApiException If any unexpected error occurs
     */
    public HostedPaymentPageFormDescriptor buildFormDescriptor(UUID kbAccountId, Iterable<PluginProperty> customFields, Iterable<PluginProperty> properties, CallContext context)
            throws PaymentPluginApiException;

    /**
     * Process a notification from the gateway
     * <p>
     * This potentially does more than just deserialize the payload. The plugin may have to acknowledge it
     * with the gateway.
     *
     * @param notification serialized notification object
     * @param properties   custom properties for the gateway
     * @param context      call context
     * @return gateway notification object used to build the response to the gateway
     * @throws PaymentPluginApiException If any unexpected error occurs
     */
    public GatewayNotification processNotification(String notification, Iterable<PluginProperty> properties, CallContext context)
            throws PaymentPluginApiException;
}
