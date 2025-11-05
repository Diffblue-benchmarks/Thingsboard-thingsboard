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
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MObserveCompositeRequest.TbLwM2MObserveCompositeRequestBuilder;

@ContextConfiguration(classes = {TbLwM2MObserveCompositeRequestBuilder.class})
@ExtendWith(SpringExtension.class)
class TbLwM2MObserveCompositeRequestDiffblueTest {
  @Autowired private TbLwM2MObserveCompositeRequestBuilder tbLwM2MObserveCompositeRequestBuilder;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MObserveCompositeRequest#getRequestContentFormat()}
   *   <li>{@link TbLwM2MObserveCompositeRequest#getResponseContentFormat()}
   *   <li>{@link TbLwM2MObserveCompositeRequest#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional TbLwM2MObserveCompositeRequest.getRequestContentFormat()",
    "ContentFormat TbLwM2MObserveCompositeRequest.getResponseContentFormat()",
    "LwM2MOperationType TbLwM2MObserveCompositeRequest.getType()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MObserveCompositeRequestBuilder builderResult = TbLwM2MObserveCompositeRequest.builder();
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);

    TbLwM2MObserveCompositeRequestBuilder requestContentFormatResult =
        builderResult.requestContentFormat(requestContentFormat);
    ContentFormat responseContentFormat = ContentFormat.fromCode(1);
    TbLwM2MObserveCompositeRequest tbLwM2MObserveCompositeRequest =
        requestContentFormatResult
            .responseContentFormat(responseContentFormat)
            .timeout(10L)
            .versionedIds(new String[] {"1.0.2"})
            .build();

    // Act
    Optional<ContentFormat> actualRequestContentFormat =
        tbLwM2MObserveCompositeRequest.getRequestContentFormat();
    ContentFormat actualResponseContentFormat =
        tbLwM2MObserveCompositeRequest.getResponseContentFormat();

    // Assert
    assertEquals(LwM2MOperationType.OBSERVE_COMPOSITE, tbLwM2MObserveCompositeRequest.getType());
    assertTrue(actualRequestContentFormat.isPresent());
    assertSame(requestContentFormat, actualRequestContentFormat.get());
    assertSame(responseContentFormat, actualResponseContentFormat);
  }

  /**
   * Test TbLwM2MObserveCompositeRequestBuilder {@link
   * TbLwM2MObserveCompositeRequestBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MObserveCompositeRequestBuilder#build()}
   *   <li>{@link TbLwM2MObserveCompositeRequestBuilder#requestContentFormat(ContentFormat)}
   *   <li>{@link TbLwM2MObserveCompositeRequestBuilder#responseContentFormat(ContentFormat)}
   *   <li>{@link TbLwM2MObserveCompositeRequestBuilder#timeout(long)}
   *   <li>{@link TbLwM2MObserveCompositeRequestBuilder#versionedIds(String[])}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MObserveCompositeRequestBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbLwM2MObserveCompositeRequestBuilder.<init>()",
    "TbLwM2MObserveCompositeRequest TbLwM2MObserveCompositeRequestBuilder.build()",
    "TbLwM2MObserveCompositeRequestBuilder TbLwM2MObserveCompositeRequestBuilder.requestContentFormat(ContentFormat)",
    "TbLwM2MObserveCompositeRequestBuilder TbLwM2MObserveCompositeRequestBuilder.responseContentFormat(ContentFormat)",
    "TbLwM2MObserveCompositeRequestBuilder TbLwM2MObserveCompositeRequestBuilder.timeout(long)",
    "String TbLwM2MObserveCompositeRequestBuilder.toString()",
    "TbLwM2MObserveCompositeRequestBuilder TbLwM2MObserveCompositeRequestBuilder.versionedIds(String[])"
  })
  void testTbLwM2MObserveCompositeRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MObserveCompositeRequestBuilder actualBuilderResult =
        TbLwM2MObserveCompositeRequest.builder();
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);
    TbLwM2MObserveCompositeRequestBuilder actualRequestContentFormatResult =
        actualBuilderResult.requestContentFormat(requestContentFormat);
    ContentFormat responseContentFormat = ContentFormat.fromCode(1);
    String[] versionedIds = new String[] {"1.0.2"};
    TbLwM2MObserveCompositeRequest actualTbLwM2MObserveCompositeRequest =
        actualRequestContentFormatResult
            .responseContentFormat(responseContentFormat)
            .timeout(10L)
            .versionedIds(versionedIds)
            .build();

    // Assert
    assertEquals(10L, actualTbLwM2MObserveCompositeRequest.getTimeout());
    assertEquals(
        LwM2MOperationType.OBSERVE_COMPOSITE, actualTbLwM2MObserveCompositeRequest.getType());
    Optional<ContentFormat> requestContentFormat2 =
        actualTbLwM2MObserveCompositeRequest.getRequestContentFormat();
    assertTrue(requestContentFormat2.isPresent());
    assertSame(requestContentFormat, requestContentFormat2.get());
    assertSame(
        responseContentFormat, actualTbLwM2MObserveCompositeRequest.getResponseContentFormat());
    String[] versionedIds2 = actualTbLwM2MObserveCompositeRequest.getVersionedIds();
    assertSame(versionedIds, versionedIds2);
    assertArrayEquals(new String[] {"1.0.2"}, actualTbLwM2MObserveCompositeRequest.getObjectIds());
    assertArrayEquals(new String[] {"1.0.2"}, versionedIds2);
  }
}
