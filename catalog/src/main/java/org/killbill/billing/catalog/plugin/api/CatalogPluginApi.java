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

package org.killbill.billing.catalog.plugin.api;

import java.util.Set;

import org.joda.time.DateTime;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.util.callcontext.TenantContext;

public interface CatalogPluginApi {

    public DateTime getLatestCatalogVersion(Iterable<PluginProperty> properties, final TenantContext context);

    /**
     * Returns a plugin versioned catalog for this tenant containing all plans.
     *
     * @param properties plugin properties
     * @param context    tenant context
     * @return versioned catalog or null if this plugin does not manage the catalog for this tenant
     */
    public VersionedPluginCatalog getVersionedPluginCatalog(Iterable<PluginProperty> properties, final TenantContext context);

    /**
     * Returns a plugin versioned catalog restricted to the specified plan names.
     * <p>
     * Kill Bill calls this overload when it already knows which plans are required (e.g. during
     * invoice generation) so that plugins managing large catalogs can return a shallow subset
     * rather than the full catalog, reducing serialization and processing overhead.
     * <p>
     * Implementations that do not need this optimization may rely on the default, which
     * delegates to {@link #getVersionedPluginCatalog(Iterable, TenantContext)}.
     *
     * @param planNames  the set of plan names Kill Bill needs; never null but may be empty
     * @param properties plugin properties
     * @param context    tenant context
     * @return versioned catalog or null if this plugin does not manage the catalog for this tenant
     */
    default VersionedPluginCatalog getVersionedPluginCatalog(final Set<String> planNames, final Iterable<PluginProperty> properties, final TenantContext context) {
        return getVersionedPluginCatalog(properties, context);
    }
}
