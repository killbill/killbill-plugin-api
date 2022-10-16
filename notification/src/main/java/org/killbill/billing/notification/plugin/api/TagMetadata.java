/*
 * Copyright 2022 Groupon, Inc
 * Copyright 2022 The Billing Project, LLC
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

import org.killbill.billing.ObjectType;
import org.killbill.billing.util.tag.TagDefinition;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TagMetadata {

	private final UUID tagId;
	private final UUID objectId;
	private final ObjectType objectType;
	private final TagDefinition tagDefinition;

	@JsonCreator
	public TagMetadata(@JsonProperty("tagId") final UUID tagId, @JsonProperty("objectId") final UUID objectId,
			@JsonProperty("objectType") final ObjectType objectType,
			@JsonProperty("tagDefinition") final TagDefinition tagDefinition) {
		this.tagId = tagId;
		this.objectId = objectId;
		this.objectType = objectType;
		this.tagDefinition = tagDefinition;
	}

	public UUID getTagId() {
		return tagId;
	}

	public UUID getObjectId() {
		return objectId;
	}

	public ObjectType getObjectType() {
		return objectType;
	}

	public TagDefinition getTagDefinition() {
		return tagDefinition;
	}

}
