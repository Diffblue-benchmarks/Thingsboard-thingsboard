package org.thingsboard.server.transport.lwm2m.server.downlink.composite;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import org.eclipse.leshan.core.request.ContentFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MObserveCompositeRequest.TbLwM2MObserveCompositeRequestBuilder;

class TbLwM2MObserveCompositeRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MObserveCompositeRequest#getRequestContentFormat()}
   *   <li>{@link TbLwM2MObserveCompositeRequest#getResponseContentFormat()}
   *   <li>{@link TbLwM2MObserveCompositeRequest#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MObserveCompositeRequest.TbLwM2MObserveCompositeRequestBuilder builderResult = TbLwM2MObserveCompositeRequest
        .builder();
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);
    TbLwM2MObserveCompositeRequest.TbLwM2MObserveCompositeRequestBuilder requestContentFormatResult = builderResult
        .requestContentFormat(requestContentFormat);
    ContentFormat responseContentFormat = ContentFormat.fromCode(1);
    TbLwM2MObserveCompositeRequest buildResult = requestContentFormatResult.responseContentFormat(responseContentFormat)
        .timeout(10L)
        .versionedIds(new String[]{"1.0.2"})
        .build();

    // Act
    Optional<ContentFormat> actualRequestContentFormat = buildResult.getRequestContentFormat();
    ContentFormat actualResponseContentFormat = buildResult.getResponseContentFormat();

    // Assert
    assertEquals(LwM2MOperationType.OBSERVE_COMPOSITE, buildResult.getType());
    assertTrue(actualRequestContentFormat.isPresent());
    assertSame(requestContentFormat, actualRequestContentFormat.get());
    assertSame(responseContentFormat, actualResponseContentFormat);
  }

  /**
   * Test TbLwM2MObserveCompositeRequestBuilder
   * {@link TbLwM2MObserveCompositeRequestBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TbLwM2MObserveCompositeRequest.TbLwM2MObserveCompositeRequestBuilder#build()}
   *   <li>
   * {@link TbLwM2MObserveCompositeRequest.TbLwM2MObserveCompositeRequestBuilder#requestContentFormat(ContentFormat)}
   *   <li>
   * {@link TbLwM2MObserveCompositeRequest.TbLwM2MObserveCompositeRequestBuilder#responseContentFormat(ContentFormat)}
   *   <li>
   * {@link TbLwM2MObserveCompositeRequest.TbLwM2MObserveCompositeRequestBuilder#timeout(long)}
   *   <li>
   * {@link TbLwM2MObserveCompositeRequest.TbLwM2MObserveCompositeRequestBuilder#versionedIds(String[])}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MObserveCompositeRequestBuilder build()")
  void testTbLwM2MObserveCompositeRequestBuilderBuild() {
    // Arrange
    TbLwM2MObserveCompositeRequest.TbLwM2MObserveCompositeRequestBuilder builderResult = TbLwM2MObserveCompositeRequest
        .builder();
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);
    TbLwM2MObserveCompositeRequest.TbLwM2MObserveCompositeRequestBuilder requestContentFormatResult = builderResult
        .requestContentFormat(requestContentFormat);
    ContentFormat responseContentFormat = ContentFormat.fromCode(1);

    // Act
    TbLwM2MObserveCompositeRequest actualBuildResult = requestContentFormatResult
        .responseContentFormat(responseContentFormat)
        .timeout(10L)
        .versionedIds(new String[]{"1.0.2"})
        .build();

    // Assert
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.OBSERVE_COMPOSITE, actualBuildResult.getType());
    Optional<ContentFormat> requestContentFormat2 = actualBuildResult.getRequestContentFormat();
    assertTrue(requestContentFormat2.isPresent());
    assertSame(requestContentFormat, requestContentFormat2.get());
    assertSame(responseContentFormat, actualBuildResult.getResponseContentFormat());
    assertArrayEquals(new String[]{"1.0.2"}, actualBuildResult.getObjectIds());
    assertArrayEquals(new String[]{"1.0.2"}, actualBuildResult.getVersionedIds());
  }
}
