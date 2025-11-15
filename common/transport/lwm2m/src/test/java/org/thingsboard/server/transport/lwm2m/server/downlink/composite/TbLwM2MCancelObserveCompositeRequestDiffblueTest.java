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
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;

class TbLwM2MCancelObserveCompositeRequestDiffblueTest {
  /**
   * Method under test: {@link TbLwM2MCancelObserveCompositeRequest#getType()}
   */
  @Test
  void testGetType() {
    // Arrange
    TbLwM2MCancelObserveCompositeRequest buildResult = TbLwM2MCancelObserveCompositeRequest.builder()
        .timeout(10L)
        .versionedIds(new String[]{"1.0.2"})
        .build();

    // Act and Assert
    assertEquals(LwM2MOperationType.OBSERVE_COMPOSITE_CANCEL, buildResult.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TbLwM2MCancelObserveCompositeRequest.TbLwM2MCancelObserveCompositeRequestBuilder#build()}
   *   <li>
   * {@link TbLwM2MCancelObserveCompositeRequest.TbLwM2MCancelObserveCompositeRequestBuilder#timeout(long)}
   *   <li>
   * {@link TbLwM2MCancelObserveCompositeRequest.TbLwM2MCancelObserveCompositeRequestBuilder#versionedIds(String[])}
   * </ul>
   */
  @Test
  void testTbLwM2MCancelObserveCompositeRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MCancelObserveCompositeRequest actualBuildResult = TbLwM2MCancelObserveCompositeRequest.builder()
        .timeout(10L)
        .versionedIds(new String[]{"1.0.2"})
        .build();

    // Assert
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.OBSERVE_COMPOSITE_CANCEL, actualBuildResult.getType());
    assertArrayEquals(new String[]{"1.0.2"}, actualBuildResult.getObjectIds());
    assertArrayEquals(new String[]{"1.0.2"}, actualBuildResult.getVersionedIds());
  }
}
