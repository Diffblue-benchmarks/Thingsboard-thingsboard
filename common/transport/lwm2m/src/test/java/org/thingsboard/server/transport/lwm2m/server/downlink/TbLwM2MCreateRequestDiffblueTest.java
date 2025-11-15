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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.leshan.core.request.ContentFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MCreateRequest.TbLwM2MCreateRequestBuilder;

@ContextConfiguration(classes = {TbLwM2MCreateRequestBuilder.class})
@ExtendWith(SpringExtension.class)
class TbLwM2MCreateRequestDiffblueTest {
  @Autowired
  private TbLwM2MCreateRequestBuilder tbLwM2MCreateRequestBuilder;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MCreateRequest#getNodes()}
   *   <li>{@link TbLwM2MCreateRequest#getObjectContentFormat()}
   *   <li>{@link TbLwM2MCreateRequest#getType()}
   *   <li>{@link TbLwM2MCreateRequest#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TbLwM2MCreateRequest.getNodes()",
      "ContentFormat TbLwM2MCreateRequest.getObjectContentFormat()",
      "LwM2MOperationType TbLwM2MCreateRequest.getType()", "Object TbLwM2MCreateRequest.getValue()"})
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MCreateRequestBuilder builderResult = TbLwM2MCreateRequest.builder();
    HashMap<String, Object> nodes = new HashMap<>();
    TbLwM2MCreateRequestBuilder nodesResult = builderResult.nodes(nodes);
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
   * Test TbLwM2MCreateRequestBuilder {@link TbLwM2MCreateRequestBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MCreateRequestBuilder#build()}
   *   <li>{@link TbLwM2MCreateRequestBuilder#nodes(Map)}
   *   <li>{@link TbLwM2MCreateRequestBuilder#objectContentFormat(ContentFormat)}
   *   <li>{@link TbLwM2MCreateRequestBuilder#timeout(long)}
   *   <li>{@link TbLwM2MCreateRequestBuilder#value(Object)}
   *   <li>{@link TbLwM2MCreateRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MCreateRequestBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbLwM2MCreateRequestBuilder.<init>()",
      "TbLwM2MCreateRequest TbLwM2MCreateRequestBuilder.build()",
      "TbLwM2MCreateRequestBuilder TbLwM2MCreateRequestBuilder.nodes(Map)",
      "TbLwM2MCreateRequestBuilder TbLwM2MCreateRequestBuilder.objectContentFormat(ContentFormat)",
      "TbLwM2MCreateRequestBuilder TbLwM2MCreateRequestBuilder.timeout(long)",
      "String TbLwM2MCreateRequestBuilder.toString()",
      "TbLwM2MCreateRequestBuilder TbLwM2MCreateRequestBuilder.value(Object)",
      "TbLwM2MCreateRequestBuilder TbLwM2MCreateRequestBuilder.versionedId(String)"})
  void testTbLwM2MCreateRequestBuilderBuild() {
    // Arrange
    TbLwM2MCreateRequestBuilder builderResult = TbLwM2MCreateRequest.builder();
    HashMap<String, Object> nodes = new HashMap<>();
    TbLwM2MCreateRequestBuilder nodesResult = builderResult.nodes(nodes);
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
