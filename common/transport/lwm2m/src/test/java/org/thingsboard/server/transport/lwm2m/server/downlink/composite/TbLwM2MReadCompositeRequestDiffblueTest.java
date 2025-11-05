package org.thingsboard.server.transport.lwm2m.server.downlink.composite;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Autowired private TbLwM2MReadCompositeRequestBuilder tbLwM2MReadCompositeRequestBuilder;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MReadCompositeRequest#getRequestContentFormat()}
   *   <li>{@link TbLwM2MReadCompositeRequest#getResponseContentFormat()}
   *   <li>{@link TbLwM2MReadCompositeRequest#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional TbLwM2MReadCompositeRequest.getRequestContentFormat()",
    "ContentFormat TbLwM2MReadCompositeRequest.getResponseContentFormat()",
    "LwM2MOperationType TbLwM2MReadCompositeRequest.getType()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MReadCompositeRequestBuilder builderResult = TbLwM2MReadCompositeRequest.builder();
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);

    TbLwM2MReadCompositeRequestBuilder requestContentFormatResult =
        builderResult.requestContentFormat(requestContentFormat);
    ContentFormat responseContentFormat = ContentFormat.fromCode(1);
    TbLwM2MReadCompositeRequest tbLwM2MReadCompositeRequest =
        requestContentFormatResult
            .responseContentFormat(responseContentFormat)
            .timeout(10L)
            .versionedIds(new String[] {"1.0.2"})
            .build();

    // Act
    Optional<ContentFormat> actualRequestContentFormat =
        tbLwM2MReadCompositeRequest.getRequestContentFormat();
    ContentFormat actualResponseContentFormat =
        tbLwM2MReadCompositeRequest.getResponseContentFormat();

    // Assert
    assertEquals(LwM2MOperationType.READ_COMPOSITE, tbLwM2MReadCompositeRequest.getType());
    assertTrue(actualRequestContentFormat.isPresent());
    assertSame(requestContentFormat, actualRequestContentFormat.get());
    assertSame(responseContentFormat, actualResponseContentFormat);
  }

  /**
   * Test TbLwM2MReadCompositeRequestBuilder {@link TbLwM2MReadCompositeRequestBuilder#build()}.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbLwM2MReadCompositeRequestBuilder.<init>()",
    "TbLwM2MReadCompositeRequest TbLwM2MReadCompositeRequestBuilder.build()",
    "TbLwM2MReadCompositeRequestBuilder TbLwM2MReadCompositeRequestBuilder.requestContentFormat(ContentFormat)",
    "TbLwM2MReadCompositeRequestBuilder TbLwM2MReadCompositeRequestBuilder.responseContentFormat(ContentFormat)",
    "TbLwM2MReadCompositeRequestBuilder TbLwM2MReadCompositeRequestBuilder.timeout(long)",
    "String TbLwM2MReadCompositeRequestBuilder.toString()",
    "TbLwM2MReadCompositeRequestBuilder TbLwM2MReadCompositeRequestBuilder.versionedIds(String[])"
  })
  void testTbLwM2MReadCompositeRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MReadCompositeRequestBuilder actualBuilderResult = TbLwM2MReadCompositeRequest.builder();
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);
    TbLwM2MReadCompositeRequestBuilder actualRequestContentFormatResult =
        actualBuilderResult.requestContentFormat(requestContentFormat);
    ContentFormat responseContentFormat = ContentFormat.fromCode(1);
    String[] versionedIds = new String[] {"1.0.2"};
    TbLwM2MReadCompositeRequest actualTbLwM2MReadCompositeRequest =
        actualRequestContentFormatResult
            .responseContentFormat(responseContentFormat)
            .timeout(10L)
            .versionedIds(versionedIds)
            .build();

    // Assert
    assertEquals(10L, actualTbLwM2MReadCompositeRequest.getTimeout());
    assertEquals(LwM2MOperationType.READ_COMPOSITE, actualTbLwM2MReadCompositeRequest.getType());
    Optional<ContentFormat> requestContentFormat2 =
        actualTbLwM2MReadCompositeRequest.getRequestContentFormat();
    assertTrue(requestContentFormat2.isPresent());
    assertSame(requestContentFormat, requestContentFormat2.get());
    assertSame(responseContentFormat, actualTbLwM2MReadCompositeRequest.getResponseContentFormat());
    String[] versionedIds2 = actualTbLwM2MReadCompositeRequest.getVersionedIds();
    assertSame(versionedIds, versionedIds2);
    assertArrayEquals(new String[] {"1.0.2"}, actualTbLwM2MReadCompositeRequest.getObjectIds());
    assertArrayEquals(new String[] {"1.0.2"}, versionedIds2);
  }
}
