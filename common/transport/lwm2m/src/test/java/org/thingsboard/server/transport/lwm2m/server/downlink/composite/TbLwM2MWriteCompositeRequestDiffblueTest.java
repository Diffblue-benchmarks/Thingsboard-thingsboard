package org.thingsboard.server.transport.lwm2m.server.downlink.composite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.eclipse.leshan.core.request.ContentFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MWriteCompositeRequest.TbLwM2MWriteCompositeRequestBuilder;

class TbLwM2MWriteCompositeRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MWriteCompositeRequest#getContentFormat()}
   *   <li>{@link TbLwM2MWriteCompositeRequest#getType()}
   *   <li>{@link TbLwM2MWriteCompositeRequest#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MWriteCompositeRequest.TbLwM2MWriteCompositeRequestBuilder builderResult = TbLwM2MWriteCompositeRequest
        .builder();
    ContentFormat contentFormat = ContentFormat.fromCode(1);
    TbLwM2MWriteCompositeRequest buildResult = builderResult.contentFormat(contentFormat)
        .timeout(10L)
        .value("Value")
        .versionedId("42")
        .build();

    // Act
    ContentFormat actualContentFormat = buildResult.getContentFormat();
    LwM2MOperationType actualType = buildResult.getType();

    // Assert
    assertEquals("Value", buildResult.getValue());
    assertEquals(LwM2MOperationType.WRITE_REPLACE, actualType);
    assertSame(contentFormat, actualContentFormat);
  }

  /**
   * Test TbLwM2MWriteCompositeRequestBuilder
   * {@link TbLwM2MWriteCompositeRequestBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TbLwM2MWriteCompositeRequest.TbLwM2MWriteCompositeRequestBuilder#build()}
   *   <li>
   * {@link TbLwM2MWriteCompositeRequest.TbLwM2MWriteCompositeRequestBuilder#contentFormat(ContentFormat)}
   *   <li>
   * {@link TbLwM2MWriteCompositeRequest.TbLwM2MWriteCompositeRequestBuilder#timeout(long)}
   *   <li>
   * {@link TbLwM2MWriteCompositeRequest.TbLwM2MWriteCompositeRequestBuilder#value(Object)}
   *   <li>
   * {@link TbLwM2MWriteCompositeRequest.TbLwM2MWriteCompositeRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MWriteCompositeRequestBuilder build()")
  void testTbLwM2MWriteCompositeRequestBuilderBuild() {
    // Arrange
    TbLwM2MWriteCompositeRequest.TbLwM2MWriteCompositeRequestBuilder builderResult = TbLwM2MWriteCompositeRequest
        .builder();
    ContentFormat contentFormat = ContentFormat.fromCode(1);

    // Act
    TbLwM2MWriteCompositeRequest actualBuildResult = builderResult.contentFormat(contentFormat)
        .timeout(10L)
        .value("Value")
        .versionedId("42")
        .build();

    // Assert
    assertEquals("42", actualBuildResult.getVersionedId());
    assertEquals("42", actualBuildResult.getObjectId());
    assertEquals("Value", actualBuildResult.getValue());
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.WRITE_REPLACE, actualBuildResult.getType());
    assertSame(contentFormat, actualBuildResult.getContentFormat());
  }
}
