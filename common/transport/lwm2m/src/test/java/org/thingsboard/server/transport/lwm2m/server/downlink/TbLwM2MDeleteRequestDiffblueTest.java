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

class TbLwM2MDeleteRequestDiffblueTest {
  /**
   * Method under test: {@link TbLwM2MDeleteRequest#getType()}
   */
  @Test
  void testGetType() {
    // Arrange
    TbLwM2MDeleteRequest buildResult = TbLwM2MDeleteRequest.builder().timeout(10L).versionedId("42").build();

    // Act and Assert
    assertEquals(LwM2MOperationType.DELETE, buildResult.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MDeleteRequest.TbLwM2MDeleteRequestBuilder#build()}
   *   <li>{@link TbLwM2MDeleteRequest.TbLwM2MDeleteRequestBuilder#timeout(long)}
   *   <li>
   * {@link TbLwM2MDeleteRequest.TbLwM2MDeleteRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  void testTbLwM2MDeleteRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MDeleteRequest actualBuildResult = TbLwM2MDeleteRequest.builder().timeout(10L).versionedId("42").build();

    // Assert
    assertEquals("42", actualBuildResult.getVersionedId());
    assertEquals("42", actualBuildResult.getObjectId());
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.DELETE, actualBuildResult.getType());
  }
}
