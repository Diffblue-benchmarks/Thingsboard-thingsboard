/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.eclipse.leshan.core.request.ContentFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MCreateRequest.TbLwM2MCreateRequestBuilder;

class AbstractTbLwM2MTargetedDownlinkRequestDiffblueTest {
  /**
   * Test {@link AbstractTbLwM2MTargetedDownlinkRequest#getTimeout()}.
   *
   * <p>Method under test: {@link AbstractTbLwM2MTargetedDownlinkRequest#getTimeout()}
   */
  @Test
  @DisplayName("Test getTimeout()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AbstractTbLwM2MTargetedDownlinkRequest.getTimeout()"})
  void testGetTimeout() {
    // Arrange
    TbLwM2MCreateRequestBuilder builderResult = TbLwM2MCreateRequest.builder();

    TbLwM2MCreateRequestBuilder nodesResult = builderResult.nodes(new HashMap<>());

    // Act and Assert
    assertEquals(
        10L,
        nodesResult
            .objectContentFormat(ContentFormat.fromCode(1))
            .timeout(10L)
            .value("Value")
            .versionedId("42")
            .build()
            .getTimeout());
  }

  /**
   * Test {@link AbstractTbLwM2MTargetedDownlinkRequest#getVersionedId()}.
   *
   * <p>Method under test: {@link AbstractTbLwM2MTargetedDownlinkRequest#getVersionedId()}
   */
  @Test
  @DisplayName("Test getVersionedId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AbstractTbLwM2MTargetedDownlinkRequest.getVersionedId()"})
  void testGetVersionedId() {
    // Arrange
    TbLwM2MCreateRequestBuilder builderResult = TbLwM2MCreateRequest.builder();

    TbLwM2MCreateRequestBuilder nodesResult = builderResult.nodes(new HashMap<>());

    // Act and Assert
    assertEquals(
        "42",
        nodesResult
            .objectContentFormat(ContentFormat.fromCode(1))
            .timeout(10L)
            .value("Value")
            .versionedId("42")
            .build()
            .getVersionedId());
  }
}
