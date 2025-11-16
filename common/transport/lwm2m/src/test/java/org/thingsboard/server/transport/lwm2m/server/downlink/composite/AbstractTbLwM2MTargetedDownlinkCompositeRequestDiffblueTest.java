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
package org.thingsboard.server.transport.lwm2m.server.downlink.composite;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.eclipse.leshan.core.request.ContentFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MObserveCompositeRequest.TbLwM2MObserveCompositeRequestBuilder;

class AbstractTbLwM2MTargetedDownlinkCompositeRequestDiffblueTest {
  /**
   * Test {@link AbstractTbLwM2MTargetedDownlinkCompositeRequest#getTimeout()}.
   *
   * <p>Method under test: {@link AbstractTbLwM2MTargetedDownlinkCompositeRequest#getTimeout()}
   */
  @Test
  @DisplayName("Test getTimeout()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AbstractTbLwM2MTargetedDownlinkCompositeRequest.getTimeout()"})
  void testGetTimeout() {
    // Arrange
    TbLwM2MObserveCompositeRequestBuilder builderResult = TbLwM2MObserveCompositeRequest.builder();

    TbLwM2MObserveCompositeRequestBuilder requestContentFormatResult =
        builderResult.requestContentFormat(ContentFormat.fromCode(1));

    // Act and Assert
    assertEquals(
        10L,
        requestContentFormatResult
            .responseContentFormat(ContentFormat.fromCode(1))
            .timeout(10L)
            .versionedIds(new String[] {"1.0.2"})
            .build()
            .getTimeout());
  }

  /**
   * Test {@link AbstractTbLwM2MTargetedDownlinkCompositeRequest#getVersionedIds()}.
   *
   * <p>Method under test: {@link AbstractTbLwM2MTargetedDownlinkCompositeRequest#getVersionedIds()}
   */
  @Test
  @DisplayName("Test getVersionedIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] AbstractTbLwM2MTargetedDownlinkCompositeRequest.getVersionedIds()"})
  void testGetVersionedIds() {
    // Arrange
    TbLwM2MObserveCompositeRequestBuilder builderResult = TbLwM2MObserveCompositeRequest.builder();

    TbLwM2MObserveCompositeRequestBuilder requestContentFormatResult =
        builderResult.requestContentFormat(ContentFormat.fromCode(1));

    // Act and Assert
    assertArrayEquals(
        new String[] {"1.0.2"},
        requestContentFormatResult
            .responseContentFormat(ContentFormat.fromCode(1))
            .timeout(10L)
            .versionedIds(new String[] {"1.0.2"})
            .build()
            .getVersionedIds());
  }
}
