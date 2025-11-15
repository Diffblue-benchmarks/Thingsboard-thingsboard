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
import static org.junit.jupiter.api.Assertions.assertSame;
import org.eclipse.leshan.core.request.ContentFormat;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;

class TbLwM2MWriteUpdateRequestDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MWriteUpdateRequest#getObjectContentFormat()}
   *   <li>{@link TbLwM2MWriteUpdateRequest#getType()}
   *   <li>{@link TbLwM2MWriteUpdateRequest#getValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MWriteUpdateRequest.TbLwM2MWriteUpdateRequestBuilder builderResult = TbLwM2MWriteUpdateRequest.builder();
    ContentFormat objectContentFormat = ContentFormat.fromCode(1);
    TbLwM2MWriteUpdateRequest buildResult = builderResult.objectContentFormat(objectContentFormat)
        .timeout(10L)
        .value("Value")
        .versionedId("42")
        .build();

    // Act
    ContentFormat actualObjectContentFormat = buildResult.getObjectContentFormat();
    LwM2MOperationType actualType = buildResult.getType();

    // Assert
    assertEquals("Value", buildResult.getValue());
    assertEquals(LwM2MOperationType.WRITE_UPDATE, actualType);
    assertSame(objectContentFormat, actualObjectContentFormat);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TbLwM2MWriteUpdateRequest.TbLwM2MWriteUpdateRequestBuilder#build()}
   *   <li>
   * {@link TbLwM2MWriteUpdateRequest.TbLwM2MWriteUpdateRequestBuilder#objectContentFormat(ContentFormat)}
   *   <li>
   * {@link TbLwM2MWriteUpdateRequest.TbLwM2MWriteUpdateRequestBuilder#timeout(long)}
   *   <li>
   * {@link TbLwM2MWriteUpdateRequest.TbLwM2MWriteUpdateRequestBuilder#value(Object)}
   *   <li>
   * {@link TbLwM2MWriteUpdateRequest.TbLwM2MWriteUpdateRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  void testTbLwM2MWriteUpdateRequestBuilderBuild() {
    // Arrange
    TbLwM2MWriteUpdateRequest.TbLwM2MWriteUpdateRequestBuilder builderResult = TbLwM2MWriteUpdateRequest.builder();
    ContentFormat objectContentFormat = ContentFormat.fromCode(1);

    // Act
    TbLwM2MWriteUpdateRequest actualBuildResult = builderResult.objectContentFormat(objectContentFormat)
        .timeout(10L)
        .value("Value")
        .versionedId("42")
        .build();

    // Assert
    assertEquals("42", actualBuildResult.getVersionedId());
    assertEquals("42", actualBuildResult.getObjectId());
    assertEquals("Value", actualBuildResult.getValue());
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.WRITE_UPDATE, actualBuildResult.getType());
    assertSame(objectContentFormat, actualBuildResult.getObjectContentFormat());
  }
}
