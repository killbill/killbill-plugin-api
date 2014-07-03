/*
 * Copyright 2010-2013 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
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

package org.killbill.billing.currency.plugin.api;

import java.util.Set;
import java.util.SortedSet;

import org.joda.time.DateTime;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.currency.api.Rate;

public interface CurrencyPluginApi {

    /**
     * @return all the base rates supported
     */
    public Set<Currency> getBaseCurrencies();

    /**
     * @return the last conversion date for a given currency
     */
    public DateTime getLatestConversionDate(Currency baseCurrency);

    /**
     * @param baseCurrency the base currency
     * @return the conversions dates for that currency
     */
    public SortedSet<DateTime> getConversionDates(Currency baseCurrency);

    /**
     * @param baseCurrency the base currency
     * @return the list of rates for that currency
     */
    public Set<Rate> getCurrentRates(Currency baseCurrency);

    /**
     * @param baseCurrency   the base currency
     * @param conversionDate the conversion date
     * @return the list of rates for that currency and that conversion date
     */
    public Set<Rate> getRates(Currency baseCurrency, DateTime conversionDate);
}
