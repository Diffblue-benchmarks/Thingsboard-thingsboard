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
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.leshan.core.request.ContentFormat;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;

class TbLwM2MCreateRequestDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MCreateRequest#getNodes()}
   *   <li>{@link TbLwM2MCreateRequest#getObjectContentFormat()}
   *   <li>{@link TbLwM2MCreateRequest#getType()}
   *   <li>{@link TbLwM2MCreateRequest#getValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MCreateRequest.TbLwM2MCreateRequestBuilder builderResult = TbLwM2MCreateRequest.builder();
    HashMap<String, Object> nodes = new HashMap<>();
    TbLwM2MCreateRequest.TbLwM2MCreateRequestBuilder nodesResult = builderResult.nodes(nodes);
    ContentFormat objectContentFormat = ContentFormat.fromCode(1);
    TbLwM2MCreateRequest buildResult = nodesResult.objectContentFormat(objectContentFormat)
        .timeout(10L)
        .value("Value")
        .versionedId("42")
        .build();

    // Act
    Map<String, Object> actualNodes = buildResult.getNodes();
    ContentFormat actualObjectContentFormat = buildResult.getObjectContentFormat();
    LwM2MOperationType actualType = buildResult.getType();

    // Assert
    assertEquals("Value", buildResult.getValue());
    assertEquals(LwM2MOperationType.CREATE, actualType);
    assertTrue(actualNodes.isEmpty());
    assertSame(nodes, actualNodes);
    assertSame(objectContentFormat, actualObjectContentFormat);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MCreateRequest.TbLwM2MCreateRequestBuilder#build()}
   *   <li>{@link TbLwM2MCreateRequest.TbLwM2MCreateRequestBuilder#nodes(Map)}
   *   <li>
   * {@link TbLwM2MCreateRequest.TbLwM2MCreateRequestBuilder#objectContentFormat(ContentFormat)}
   *   <li>{@link TbLwM2MCreateRequest.TbLwM2MCreateRequestBuilder#timeout(long)}
   *   <li>{@link TbLwM2MCreateRequest.TbLwM2MCreateRequestBuilder#value(Object)}
   *   <li>
   * {@link TbLwM2MCreateRequest.TbLwM2MCreateRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  void testTbLwM2MCreateRequestBuilderBuild() {
    // Arrange
    TbLwM2MCreateRequest.TbLwM2MCreateRequestBuilder builderResult = TbLwM2MCreateRequest.builder();
    HashMap<String, Object> nodes = new HashMap<>();
    TbLwM2MCreateRequest.TbLwM2MCreateRequestBuilder nodesResult = builderResult.nodes(nodes);
    ContentFormat objectContentFormat = ContentFormat.fromCode(1);

    // Act
    TbLwM2MCreateRequest actualBuildResult = nodesResult.objectContentFormat(objectContentFormat)
        .timeout(10L)
        .value("Value")
        .versionedId("42")
        .build();

    // Assert
    assertEquals("42", actualBuildResult.getVersionedId());
    assertEquals("42", actualBuildResult.getObjectId());
    assertEquals("Value", actualBuildResult.getValue());
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.CREATE, actualBuildResult.getType());
    Map<String, Object> nodes2 = actualBuildResult.getNodes();
    assertTrue(nodes2.isEmpty());
    assertSame(nodes, nodes2);
    assertSame(objectContentFormat, actualBuildResult.getObjectContentFormat());
  }
}
