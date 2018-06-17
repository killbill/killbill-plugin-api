/*
 * Copyright 2014-2018 Groupon, Inc
 * Copyright 2014-2018 The Billing Project, LLC
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

import org.joda.time.DateTime;
import org.killbill.billing.catalog.api.Currency;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InvoiceNotificationMetadata {

    private final DateTime targetDate;
    private final BigDecimal amountOwed;
    private final Currency currency;

    @JsonCreator
    public InvoiceNotificationMetadata(@JsonProperty("targetDate") final DateTime targetDate,
                                       @JsonProperty("amountOwed") final BigDecimal amountOwed,
                                       @JsonProperty("currency") final Currency currency) {
        this.targetDate = targetDate;
        this.amountOwed = amountOwed;
        this.currency = currency;
    }

    public DateTime getTargetDate() {
        return targetDate;
    }

    public BigDecimal getAmountOwed() {
        return amountOwed;
    }

    public Currency getCurrency() {
        return currency;
    }
}
