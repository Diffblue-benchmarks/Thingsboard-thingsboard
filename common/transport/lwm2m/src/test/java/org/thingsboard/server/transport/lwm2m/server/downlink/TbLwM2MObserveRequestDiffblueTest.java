package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import org.eclipse.leshan.core.request.ContentFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MObserveRequest.TbLwM2MObserveRequestBuilder;

class TbLwM2MObserveRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MObserveRequest#getRequestContentFormat()}
   *   <li>{@link TbLwM2MObserveRequest#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MObserveRequest.TbLwM2MObserveRequestBuilder builderResult = TbLwM2MObserveRequest.builder();
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);
    TbLwM2MObserveRequest buildResult = builderResult.requestContentFormat(requestContentFormat)
        .timeout(10L)
        .versionedId("42")
        .build();

    // Act
    Optional<ContentFormat> actualRequestContentFormat = buildResult.getRequestContentFormat();

    // Assert
    assertEquals(LwM2MOperationType.OBSERVE, buildResult.getType());
    assertTrue(actualRequestContentFormat.isPresent());
    assertSame(requestContentFormat, actualRequestContentFormat.get());
  }

  /**
   * Test TbLwM2MObserveRequestBuilder
   * {@link TbLwM2MObserveRequestBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MObserveRequest.TbLwM2MObserveRequestBuilder#build()}
   *   <li>
   * {@link TbLwM2MObserveRequest.TbLwM2MObserveRequestBuilder#requestContentFormat(ContentFormat)}
   *   <li>{@link TbLwM2MObserveRequest.TbLwM2MObserveRequestBuilder#timeout(long)}
   *   <li>
   * {@link TbLwM2MObserveRequest.TbLwM2MObserveRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MObserveRequestBuilder build()")
  void testTbLwM2MObserveRequestBuilderBuild() {
    // Arrange
    TbLwM2MObserveRequest.TbLwM2MObserveRequestBuilder builderResult = TbLwM2MObserveRequest.builder();
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);

    // Act
    TbLwM2MObserveRequest actualBuildResult = builderResult.requestContentFormat(requestContentFormat)
        .timeout(10L)
        .versionedId("42")
        .build();

    // Assert
    assertEquals("42", actualBuildResult.getVersionedId());
    assertEquals("42", actualBuildResult.getObjectId());
    assertNull(actualBuildResult.getResponseContentFormat());
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.OBSERVE, actualBuildResult.getType());
    Optional<ContentFormat> requestContentFormat2 = actualBuildResult.getRequestContentFormat();
    assertTrue(requestContentFormat2.isPresent());
    assertSame(requestContentFormat, requestContentFormat2.get());
  }
}
