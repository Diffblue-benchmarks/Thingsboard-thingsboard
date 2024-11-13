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
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MReadCompositeRequest.TbLwM2MReadCompositeRequestBuilder;

class TbLwM2MReadCompositeRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MReadCompositeRequest#getRequestContentFormat()}
   *   <li>{@link TbLwM2MReadCompositeRequest#getResponseContentFormat()}
   *   <li>{@link TbLwM2MReadCompositeRequest#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MReadCompositeRequest.TbLwM2MReadCompositeRequestBuilder builderResult = TbLwM2MReadCompositeRequest
        .builder();
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);
    TbLwM2MReadCompositeRequest.TbLwM2MReadCompositeRequestBuilder requestContentFormatResult = builderResult
        .requestContentFormat(requestContentFormat);
    ContentFormat responseContentFormat = ContentFormat.fromCode(1);
    TbLwM2MReadCompositeRequest buildResult = requestContentFormatResult.responseContentFormat(responseContentFormat)
        .timeout(10L)
        .versionedIds(new String[]{"1.0.2"})
        .build();

    // Act
    Optional<ContentFormat> actualRequestContentFormat = buildResult.getRequestContentFormat();
    ContentFormat actualResponseContentFormat = buildResult.getResponseContentFormat();

    // Assert
    assertEquals(LwM2MOperationType.READ_COMPOSITE, buildResult.getType());
    assertTrue(actualRequestContentFormat.isPresent());
    assertSame(requestContentFormat, actualRequestContentFormat.get());
    assertSame(responseContentFormat, actualResponseContentFormat);
  }

  /**
   * Test TbLwM2MReadCompositeRequestBuilder
   * {@link TbLwM2MReadCompositeRequestBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TbLwM2MReadCompositeRequest.TbLwM2MReadCompositeRequestBuilder#build()}
   *   <li>
   * {@link TbLwM2MReadCompositeRequest.TbLwM2MReadCompositeRequestBuilder#requestContentFormat(ContentFormat)}
   *   <li>
   * {@link TbLwM2MReadCompositeRequest.TbLwM2MReadCompositeRequestBuilder#responseContentFormat(ContentFormat)}
   *   <li>
   * {@link TbLwM2MReadCompositeRequest.TbLwM2MReadCompositeRequestBuilder#timeout(long)}
   *   <li>
   * {@link TbLwM2MReadCompositeRequest.TbLwM2MReadCompositeRequestBuilder#versionedIds(String[])}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MReadCompositeRequestBuilder build()")
  void testTbLwM2MReadCompositeRequestBuilderBuild() {
    // Arrange
    TbLwM2MReadCompositeRequest.TbLwM2MReadCompositeRequestBuilder builderResult = TbLwM2MReadCompositeRequest
        .builder();
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);
    TbLwM2MReadCompositeRequest.TbLwM2MReadCompositeRequestBuilder requestContentFormatResult = builderResult
        .requestContentFormat(requestContentFormat);
    ContentFormat responseContentFormat = ContentFormat.fromCode(1);

    // Act
    TbLwM2MReadCompositeRequest actualBuildResult = requestContentFormatResult
        .responseContentFormat(responseContentFormat)
        .timeout(10L)
        .versionedIds(new String[]{"1.0.2"})
        .build();

    // Assert
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.READ_COMPOSITE, actualBuildResult.getType());
    Optional<ContentFormat> requestContentFormat2 = actualBuildResult.getRequestContentFormat();
    assertTrue(requestContentFormat2.isPresent());
    assertSame(requestContentFormat, requestContentFormat2.get());
    assertSame(responseContentFormat, actualBuildResult.getResponseContentFormat());
    assertArrayEquals(new String[]{"1.0.2"}, actualBuildResult.getObjectIds());
    assertArrayEquals(new String[]{"1.0.2"}, actualBuildResult.getVersionedIds());
  }
}
