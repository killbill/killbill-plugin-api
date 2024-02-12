/*
 * Copyright 2020-2024 Equinix, Inc
 * Copyright 2014-2024 The Billing Project, LLC
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

import java.util.Locale;
import java.util.ResourceBundle;

import org.killbill.billing.currency.api.CurrencyConversionApi;
import org.killbill.billing.invoice.api.Invoice;
import org.killbill.billing.invoice.api.formatters.InvoiceFormatter;

public interface InvoiceFormatterFactory {

    /**
     *
     * @param defaultLocale Default Killbill locale
     * @param catalogBundlePath Path to the catalog translation bundle
     * @param invoice the invoice that is being formatted
     * @param locale locale associated with the account
     * @param currencyConversionApi API used for currency conversion
     * @param bundle ResourceBundle corresponding to the account locale and catalogBundlePath
     * @param defaultBundle ResourceBundle corresponding to the default locale and catalogBundlePath
     * @return InvoiceFormatter corresponding to the formatted invoice
     */
    InvoiceFormatter createInvoiceFormatter(final String defaultLocale, final String catalogBundlePath, final Invoice invoice, final Locale locale, final CurrencyConversionApi currencyConversionApi, ResourceBundle bundle, ResourceBundle defaultBundle);
}
