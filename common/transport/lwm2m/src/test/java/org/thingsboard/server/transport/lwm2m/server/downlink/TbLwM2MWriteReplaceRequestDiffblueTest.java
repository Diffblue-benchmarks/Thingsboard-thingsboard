package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.eclipse.leshan.core.request.ContentFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MWriteReplaceRequest.TbLwM2MWriteReplaceRequestBuilder;

class TbLwM2MWriteReplaceRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MWriteReplaceRequest#getContentFormat()}
   *   <li>{@link TbLwM2MWriteReplaceRequest#getType()}
   *   <li>{@link TbLwM2MWriteReplaceRequest#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MWriteReplaceRequest.TbLwM2MWriteReplaceRequestBuilder builderResult = TbLwM2MWriteReplaceRequest.builder();
    ContentFormat contentFormat = ContentFormat.fromCode(1);
    TbLwM2MWriteReplaceRequest buildResult = builderResult.contentFormat(contentFormat)
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
   * Test TbLwM2MWriteReplaceRequestBuilder
   * {@link TbLwM2MWriteReplaceRequestBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TbLwM2MWriteReplaceRequest.TbLwM2MWriteReplaceRequestBuilder#build()}
   *   <li>
   * {@link TbLwM2MWriteReplaceRequest.TbLwM2MWriteReplaceRequestBuilder#contentFormat(ContentFormat)}
   *   <li>
   * {@link TbLwM2MWriteReplaceRequest.TbLwM2MWriteReplaceRequestBuilder#timeout(long)}
   *   <li>
   * {@link TbLwM2MWriteReplaceRequest.TbLwM2MWriteReplaceRequestBuilder#value(Object)}
   *   <li>
   * {@link TbLwM2MWriteReplaceRequest.TbLwM2MWriteReplaceRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MWriteReplaceRequestBuilder build()")
  void testTbLwM2MWriteReplaceRequestBuilderBuild() {
    // Arrange
    TbLwM2MWriteReplaceRequest.TbLwM2MWriteReplaceRequestBuilder builderResult = TbLwM2MWriteReplaceRequest.builder();
    ContentFormat contentFormat = ContentFormat.fromCode(1);

    // Act
    TbLwM2MWriteReplaceRequest actualBuildResult = builderResult.contentFormat(contentFormat)
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
