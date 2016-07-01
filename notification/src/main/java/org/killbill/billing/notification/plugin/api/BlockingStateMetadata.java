/*
 * Copyright 2016 Groupon, Inc
 * Copyright 2016 The Billing Project, LLC
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

import java.util.UUID;

import org.joda.time.DateTime;
import org.killbill.billing.entitlement.api.BlockingStateType;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BlockingStateMetadata {

    private UUID blockableId;
    private String service;
    private String stateName;
    private BlockingStateType blockingType;
    private DateTime effectiveDate;
    private Boolean isTransitionedToBlockedBilling;
    private Boolean isTransitionedToUnblockedBilling;
    private Boolean isTransitionedToBlockedEntitlement;
    private Boolean isTransitionedToUnblockedEntitlement;

    public BlockingStateMetadata() {
    }

    @JsonCreator
    public BlockingStateMetadata(@JsonProperty("blockableId") final UUID blockableId,
                                 @JsonProperty("service") final String service,
                                 @JsonProperty("stateName") final String stateName,
                                 @JsonProperty("blockingType") final BlockingStateType blockingType,
                                 @JsonProperty("effectiveDate") final DateTime effectiveDate,
                                 @JsonProperty("isTransitionedToBlockedBilling") final Boolean isTransitionedToBlockedBilling,
                                 @JsonProperty("isTransitionedToUnblockedBilling") final Boolean isTransitionedToUnblockedBilling,
                                 @JsonProperty("isTransitionedToBlockedEntitlement") final Boolean isTransitionedToBlockedEntitlement,
                                 @JsonProperty("isTransitionedToUnblockedEntitlement") final Boolean isTransitionedToUnblockedEntitlement) {
        this.blockableId = blockableId;
        this.service = service;
        this.stateName = stateName;
        this.blockingType = blockingType;
        this.effectiveDate = effectiveDate;
        this.isTransitionedToBlockedBilling = isTransitionedToBlockedBilling;
        this.isTransitionedToUnblockedBilling = isTransitionedToUnblockedBilling;
        this.isTransitionedToBlockedEntitlement = isTransitionedToBlockedEntitlement;
        this.isTransitionedToUnblockedEntitlement = isTransitionedToUnblockedEntitlement;
    }

    public UUID getBlockableId() {
        return blockableId;
    }

    public String getService() {
        return service;
    }

    public String getStateName() {
        return stateName;
    }

    public BlockingStateType getBlockingType() {
        return blockingType;
    }

    public DateTime getEffectiveDate() {
        return effectiveDate;
    }

    public Boolean getTransitionedToBlockedBilling() {
        return isTransitionedToBlockedBilling;
    }

    public Boolean getTransitionedToUnblockedBilling() {
        return isTransitionedToUnblockedBilling;
    }

    public Boolean getTransitionedToBlockedEntitlement() {
        return isTransitionedToBlockedEntitlement;
    }

    public Boolean getTransitionedToUnblockedEntitlement() {
        return isTransitionedToUnblockedEntitlement;
    }
}
