package org.thingsboard.server.transport.lwm2m.server.downlink.composite;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.eclipse.leshan.core.request.ContentFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MReadCompositeRequest.TbLwM2MReadCompositeRequestBuilder;

@ContextConfiguration(classes = {TbLwM2MReadCompositeRequestBuilder.class})
@ExtendWith(SpringExtension.class)
class TbLwM2MReadCompositeRequestDiffblueTest {
  @Autowired
  private TbLwM2MReadCompositeRequestBuilder tbLwM2MReadCompositeRequestBuilder;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional TbLwM2MReadCompositeRequest.getRequestContentFormat()",
      "ContentFormat TbLwM2MReadCompositeRequest.getResponseContentFormat()",
      "LwM2MOperationType TbLwM2MReadCompositeRequest.getType()"})
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MReadCompositeRequestBuilder builderResult = TbLwM2MReadCompositeRequest.builder();
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);
    TbLwM2MReadCompositeRequestBuilder requestContentFormatResult = builderResult
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
   * Test TbLwM2MReadCompositeRequestBuilder {@link TbLwM2MReadCompositeRequestBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MReadCompositeRequestBuilder#build()}
   *   <li>{@link TbLwM2MReadCompositeRequestBuilder#requestContentFormat(ContentFormat)}
   *   <li>{@link TbLwM2MReadCompositeRequestBuilder#responseContentFormat(ContentFormat)}
   *   <li>{@link TbLwM2MReadCompositeRequestBuilder#timeout(long)}
   *   <li>{@link TbLwM2MReadCompositeRequestBuilder#versionedIds(String[])}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MReadCompositeRequestBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbLwM2MReadCompositeRequestBuilder.<init>()",
      "TbLwM2MReadCompositeRequest TbLwM2MReadCompositeRequestBuilder.build()",
      "TbLwM2MReadCompositeRequestBuilder TbLwM2MReadCompositeRequestBuilder.requestContentFormat(ContentFormat)",
      "TbLwM2MReadCompositeRequestBuilder TbLwM2MReadCompositeRequestBuilder.responseContentFormat(ContentFormat)",
      "TbLwM2MReadCompositeRequestBuilder TbLwM2MReadCompositeRequestBuilder.timeout(long)",
      "String TbLwM2MReadCompositeRequestBuilder.toString()",
      "TbLwM2MReadCompositeRequestBuilder TbLwM2MReadCompositeRequestBuilder.versionedIds(String[])"})
  void testTbLwM2MReadCompositeRequestBuilderBuild() {
    // Arrange
    TbLwM2MReadCompositeRequestBuilder builderResult = TbLwM2MReadCompositeRequest.builder();
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);
    TbLwM2MReadCompositeRequestBuilder requestContentFormatResult = builderResult
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
