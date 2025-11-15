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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import org.eclipse.leshan.core.request.ContentFormat;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;

class TbLwM2MObserveCompositeRequestDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MObserveCompositeRequest#getRequestContentFormat()}
   *   <li>{@link TbLwM2MObserveCompositeRequest#getResponseContentFormat()}
   *   <li>{@link TbLwM2MObserveCompositeRequest#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MObserveCompositeRequest.TbLwM2MObserveCompositeRequestBuilder builderResult = TbLwM2MObserveCompositeRequest
        .builder();
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);
    TbLwM2MObserveCompositeRequest.TbLwM2MObserveCompositeRequestBuilder requestContentFormatResult = builderResult
        .requestContentFormat(requestContentFormat);
    ContentFormat responseContentFormat = ContentFormat.fromCode(1);
    TbLwM2MObserveCompositeRequest buildResult = requestContentFormatResult.responseContentFormat(responseContentFormat)
        .timeout(10L)
        .versionedIds(new String[]{"1.0.2"})
        .build();

    // Act
    Optional<ContentFormat> actualRequestContentFormat = buildResult.getRequestContentFormat();
    ContentFormat actualResponseContentFormat = buildResult.getResponseContentFormat();

    // Assert
    assertEquals(LwM2MOperationType.OBSERVE_COMPOSITE, buildResult.getType());
    assertTrue(actualRequestContentFormat.isPresent());
    assertSame(requestContentFormat, actualRequestContentFormat.get());
    assertSame(responseContentFormat, actualResponseContentFormat);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TbLwM2MObserveCompositeRequest.TbLwM2MObserveCompositeRequestBuilder#build()}
   *   <li>
   * {@link TbLwM2MObserveCompositeRequest.TbLwM2MObserveCompositeRequestBuilder#requestContentFormat(ContentFormat)}
   *   <li>
   * {@link TbLwM2MObserveCompositeRequest.TbLwM2MObserveCompositeRequestBuilder#responseContentFormat(ContentFormat)}
   *   <li>
   * {@link TbLwM2MObserveCompositeRequest.TbLwM2MObserveCompositeRequestBuilder#timeout(long)}
   *   <li>
   * {@link TbLwM2MObserveCompositeRequest.TbLwM2MObserveCompositeRequestBuilder#versionedIds(String[])}
   * </ul>
   */
  @Test
  void testTbLwM2MObserveCompositeRequestBuilderBuild() {
    // Arrange
    TbLwM2MObserveCompositeRequest.TbLwM2MObserveCompositeRequestBuilder builderResult = TbLwM2MObserveCompositeRequest
        .builder();
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);
    TbLwM2MObserveCompositeRequest.TbLwM2MObserveCompositeRequestBuilder requestContentFormatResult = builderResult
        .requestContentFormat(requestContentFormat);
    ContentFormat responseContentFormat = ContentFormat.fromCode(1);

    // Act
    TbLwM2MObserveCompositeRequest actualBuildResult = requestContentFormatResult
        .responseContentFormat(responseContentFormat)
        .timeout(10L)
        .versionedIds(new String[]{"1.0.2"})
        .build();

    // Assert
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.OBSERVE_COMPOSITE, actualBuildResult.getType());
    Optional<ContentFormat> requestContentFormat2 = actualBuildResult.getRequestContentFormat();
    assertTrue(requestContentFormat2.isPresent());
    assertSame(requestContentFormat, requestContentFormat2.get());
    assertSame(responseContentFormat, actualBuildResult.getResponseContentFormat());
    assertArrayEquals(new String[]{"1.0.2"}, actualBuildResult.getObjectIds());
    assertArrayEquals(new String[]{"1.0.2"}, actualBuildResult.getVersionedIds());
  }
}
