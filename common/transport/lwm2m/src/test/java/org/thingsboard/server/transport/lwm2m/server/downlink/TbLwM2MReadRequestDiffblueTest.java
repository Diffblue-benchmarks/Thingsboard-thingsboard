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
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MReadRequest.TbLwM2MReadRequestBuilder;

class TbLwM2MReadRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MReadRequest#getRequestContentFormat()}
   *   <li>{@link TbLwM2MReadRequest#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MReadRequest.TbLwM2MReadRequestBuilder builderResult = TbLwM2MReadRequest.builder();
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);
    TbLwM2MReadRequest buildResult = builderResult.requestContentFormat(requestContentFormat)
        .timeout(10L)
        .versionedId("42")
        .build();

    // Act
    Optional<ContentFormat> actualRequestContentFormat = buildResult.getRequestContentFormat();

    // Assert
    assertEquals(LwM2MOperationType.READ, buildResult.getType());
    assertTrue(actualRequestContentFormat.isPresent());
    assertSame(requestContentFormat, actualRequestContentFormat.get());
  }

  /**
   * Test TbLwM2MReadRequestBuilder {@link TbLwM2MReadRequestBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MReadRequest.TbLwM2MReadRequestBuilder#build()}
   *   <li>
   * {@link TbLwM2MReadRequest.TbLwM2MReadRequestBuilder#requestContentFormat(ContentFormat)}
   *   <li>{@link TbLwM2MReadRequest.TbLwM2MReadRequestBuilder#timeout(long)}
   *   <li>{@link TbLwM2MReadRequest.TbLwM2MReadRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MReadRequestBuilder build()")
  void testTbLwM2MReadRequestBuilderBuild() {
    // Arrange
    TbLwM2MReadRequest.TbLwM2MReadRequestBuilder builderResult = TbLwM2MReadRequest.builder();
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);

    // Act
    TbLwM2MReadRequest actualBuildResult = builderResult.requestContentFormat(requestContentFormat)
        .timeout(10L)
        .versionedId("42")
        .build();

    // Assert
    assertEquals("42", actualBuildResult.getVersionedId());
    assertEquals("42", actualBuildResult.getObjectId());
    assertNull(actualBuildResult.getResponseContentFormat());
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.READ, actualBuildResult.getType());
    Optional<ContentFormat> requestContentFormat2 = actualBuildResult.getRequestContentFormat();
    assertTrue(requestContentFormat2.isPresent());
    assertSame(requestContentFormat, requestContentFormat2.get());
  }
}
