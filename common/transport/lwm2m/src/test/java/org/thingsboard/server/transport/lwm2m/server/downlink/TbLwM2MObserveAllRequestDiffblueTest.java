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
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;

class TbLwM2MObserveAllRequestDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MObserveAllRequest#getTimeout()}
   *   <li>{@link TbLwM2MObserveAllRequest#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MObserveAllRequest buildResult = TbLwM2MObserveAllRequest.builder().timeout(10L).build();

    // Act
    long actualTimeout = buildResult.getTimeout();

    // Assert
    assertEquals(10L, actualTimeout);
    assertEquals(LwM2MOperationType.OBSERVE_READ_ALL, buildResult.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MObserveAllRequest.TbLwM2MObserveAllRequestBuilder#build()}
   *   <li>
   * {@link TbLwM2MObserveAllRequest.TbLwM2MObserveAllRequestBuilder#timeout(long)}
   * </ul>
   */
  @Test
  void testTbLwM2MObserveAllRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MObserveAllRequest actualBuildResult = TbLwM2MObserveAllRequest.builder().timeout(10L).build();

    // Assert
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.OBSERVE_READ_ALL, actualBuildResult.getType());
  }
}
