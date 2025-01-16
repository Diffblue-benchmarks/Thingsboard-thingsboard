package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.leshan.core.request.ContentFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MCreateRequest.TbLwM2MCreateRequestBuilder;

class TbLwM2MCreateRequestDiffblueTest {
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
   * Test TbLwM2MCreateRequestBuilder {@link TbLwM2MCreateRequestBuilder#build()}.
   * <p>
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
  @DisplayName("Test TbLwM2MCreateRequestBuilder build()")
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
