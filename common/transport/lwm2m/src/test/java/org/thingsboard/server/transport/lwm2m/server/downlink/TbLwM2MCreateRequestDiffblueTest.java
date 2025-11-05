package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Autowired private TbLwM2MCreateRequestBuilder tbLwM2MCreateRequestBuilder;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MCreateRequest#getNodes()}
   *   <li>{@link TbLwM2MCreateRequest#getObjectContentFormat()}
   *   <li>{@link TbLwM2MCreateRequest#getType()}
   *   <li>{@link TbLwM2MCreateRequest#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map TbLwM2MCreateRequest.getNodes()",
    "ContentFormat TbLwM2MCreateRequest.getObjectContentFormat()",
    "LwM2MOperationType TbLwM2MCreateRequest.getType()",
    "Object TbLwM2MCreateRequest.getValue()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MCreateRequestBuilder builderResult = TbLwM2MCreateRequest.builder();
    HashMap<String, Object> nodes = new HashMap<>();

    TbLwM2MCreateRequestBuilder nodesResult = builderResult.nodes(nodes);
    ContentFormat objectContentFormat = ContentFormat.fromCode(1);
    TbLwM2MCreateRequest tbLwM2MCreateRequest =
        nodesResult
            .objectContentFormat(objectContentFormat)
            .timeout(10L)
            .value("Value")
            .versionedId("42")
            .build();

    // Act
    Map<String, Object> actualNodes = tbLwM2MCreateRequest.getNodes();
    ContentFormat actualObjectContentFormat = tbLwM2MCreateRequest.getObjectContentFormat();
    LwM2MOperationType actualType = tbLwM2MCreateRequest.getType();

    // Assert
    assertEquals("Value", tbLwM2MCreateRequest.getValue());
    assertEquals(LwM2MOperationType.CREATE, actualType);
    assertTrue(actualNodes.isEmpty());
    assertSame(nodes, actualNodes);
    assertSame(objectContentFormat, actualObjectContentFormat);
  }

  /**
   * Test TbLwM2MCreateRequestBuilder {@link TbLwM2MCreateRequestBuilder#build()}.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbLwM2MCreateRequestBuilder.<init>()",
    "TbLwM2MCreateRequest TbLwM2MCreateRequestBuilder.build()",
    "TbLwM2MCreateRequestBuilder TbLwM2MCreateRequestBuilder.nodes(Map)",
    "TbLwM2MCreateRequestBuilder TbLwM2MCreateRequestBuilder.objectContentFormat(ContentFormat)",
    "TbLwM2MCreateRequestBuilder TbLwM2MCreateRequestBuilder.timeout(long)",
    "String TbLwM2MCreateRequestBuilder.toString()",
    "TbLwM2MCreateRequestBuilder TbLwM2MCreateRequestBuilder.value(Object)",
    "TbLwM2MCreateRequestBuilder TbLwM2MCreateRequestBuilder.versionedId(String)"
  })
  void testTbLwM2MCreateRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MCreateRequestBuilder actualBuilderResult = TbLwM2MCreateRequest.builder();
    HashMap<String, Object> nodes = new HashMap<>();
    TbLwM2MCreateRequestBuilder actualNodesResult = actualBuilderResult.nodes(nodes);
    ContentFormat objectContentFormat = ContentFormat.fromCode(1);
    TbLwM2MCreateRequest actualTbLwM2MCreateRequest =
        actualNodesResult
            .objectContentFormat(objectContentFormat)
            .timeout(10L)
            .value("Value")
            .versionedId("42")
            .build();

    // Assert
    assertEquals("42", actualTbLwM2MCreateRequest.getVersionedId());
    assertEquals("42", actualTbLwM2MCreateRequest.getObjectId());
    assertEquals("Value", actualTbLwM2MCreateRequest.getValue());
    assertEquals(10L, actualTbLwM2MCreateRequest.getTimeout());
    assertEquals(LwM2MOperationType.CREATE, actualTbLwM2MCreateRequest.getType());
    Map<String, Object> nodes2 = actualTbLwM2MCreateRequest.getNodes();
    assertTrue(nodes2.isEmpty());
    assertSame(nodes, nodes2);
    assertSame(objectContentFormat, actualTbLwM2MCreateRequest.getObjectContentFormat());
  }
}
