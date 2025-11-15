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

class TbLwM2MExecuteRequestDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MExecuteRequest#getParams()}
   *   <li>{@link TbLwM2MExecuteRequest#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MExecuteRequest buildResult = TbLwM2MExecuteRequest.builder()
        .params("Params")
        .timeout(10L)
        .versionedId("42")
        .build();

    // Act
    Object actualParams = buildResult.getParams();

    // Assert
    assertEquals("Params", actualParams);
    assertEquals(LwM2MOperationType.EXECUTE, buildResult.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MExecuteRequest.TbLwM2MExecuteRequestBuilder#build()}
   *   <li>{@link TbLwM2MExecuteRequest.TbLwM2MExecuteRequestBuilder#params(Object)}
   *   <li>{@link TbLwM2MExecuteRequest.TbLwM2MExecuteRequestBuilder#timeout(long)}
   *   <li>
   * {@link TbLwM2MExecuteRequest.TbLwM2MExecuteRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  void testTbLwM2MExecuteRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MExecuteRequest actualBuildResult = TbLwM2MExecuteRequest.builder()
        .params("Params")
        .timeout(10L)
        .versionedId("42")
        .build();

    // Assert
    assertEquals("42", actualBuildResult.getVersionedId());
    assertEquals("42", actualBuildResult.getObjectId());
    assertEquals("Params", actualBuildResult.getParams());
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.EXECUTE, actualBuildResult.getType());
  }
}
