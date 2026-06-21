/*
 * Copyright 2020-2022 Equinix, Inc
 * Copyright 2014-2022 The Billing Project, LLC
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

package org.killbill.billing.usage.plugin.api;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.killbill.billing.invoice.api.DryRunType;
import org.killbill.billing.util.callcontext.TenantContext;

public interface UsageContext extends TenantContext {

    // Specify the type of dry-run operation or null otherwise
    DryRunType getDryRunType();

    // Specify targetDate Associated with the invoice run
    LocalDate getInputTargetDate();

    /**
     * Returns the billing transition times per (subscriptionId, unit-type CSV) pair for the
     * current invoice run, or {@code null} if this information was not provided.
     * <p>
     * Previously this data was smuggled through as a plugin property keyed
     * {@code USAGE_TRANSITIONS}. Exposing it as a typed accessor on {@code UsageContext} lets
     * usage plugins consume it without depending on an undocumented property name, and without
     * the overhead of serialising and deserialising an arbitrary {@code Object}.
     * <p>
     * The map key is a {@code Map.Entry<UUID, String>} where the UUID is the subscription id and
     * the String is a comma-separated list of unit type names for that usage interval.
     * The value is the ordered set of transition {@link DateTime} instants within that interval.
     * <p>
     * The default implementation returns {@code null} for backwards compatibility with existing
     * {@code UsageContext} implementations.
     */
    default Map<Map.Entry<UUID, String>, Set<DateTime>> getUsageTransitions() {
        return null;
    }
}
