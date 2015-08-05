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

import org.killbill.billing.payment.api.PluginProperty;

public interface PaymentControlPluginApi {

    public PriorPaymentControlResult priorCall(PaymentControlContext context, Iterable<PluginProperty> properties) throws PaymentControlApiException;

    public OnSuccessPaymentControlResult onSuccessCall(PaymentControlContext context, Iterable<PluginProperty> properties) throws PaymentControlApiException;

    public OnFailurePaymentControlResult onFailureCall(PaymentControlContext context, Iterable<PluginProperty> properties) throws PaymentControlApiException;
}
