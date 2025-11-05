package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MReadRequest.TbLwM2MReadRequestBuilder;

@ContextConfiguration(classes = {TbLwM2MReadRequestBuilder.class})
@ExtendWith(SpringExtension.class)
class TbLwM2MReadRequestDiffblueTest {
  @Autowired private TbLwM2MReadRequestBuilder tbLwM2MReadRequestBuilder;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MReadRequest#getRequestContentFormat()}
   *   <li>{@link TbLwM2MReadRequest#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional TbLwM2MReadRequest.getRequestContentFormat()",
    "LwM2MOperationType TbLwM2MReadRequest.getType()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MReadRequestBuilder builderResult = TbLwM2MReadRequest.builder();
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);
    TbLwM2MReadRequest tbLwM2MReadRequest =
        builderResult
            .requestContentFormat(requestContentFormat)
            .timeout(10L)
            .versionedId("42")
            .build();

    // Act
    Optional<ContentFormat> actualRequestContentFormat =
        tbLwM2MReadRequest.getRequestContentFormat();

    // Assert
    assertEquals(LwM2MOperationType.READ, tbLwM2MReadRequest.getType());
    assertTrue(actualRequestContentFormat.isPresent());
    assertSame(requestContentFormat, actualRequestContentFormat.get());
  }

  /**
   * Test TbLwM2MReadRequestBuilder {@link TbLwM2MReadRequestBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MReadRequestBuilder#build()}
   *   <li>{@link TbLwM2MReadRequestBuilder#requestContentFormat(ContentFormat)}
   *   <li>{@link TbLwM2MReadRequestBuilder#timeout(long)}
   *   <li>{@link TbLwM2MReadRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MReadRequestBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbLwM2MReadRequestBuilder.<init>()",
    "TbLwM2MReadRequest TbLwM2MReadRequestBuilder.build()",
    "TbLwM2MReadRequestBuilder TbLwM2MReadRequestBuilder.requestContentFormat(ContentFormat)",
    "TbLwM2MReadRequestBuilder TbLwM2MReadRequestBuilder.timeout(long)",
    "String TbLwM2MReadRequestBuilder.toString()",
    "TbLwM2MReadRequestBuilder TbLwM2MReadRequestBuilder.versionedId(String)"
  })
  void testTbLwM2MReadRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MReadRequestBuilder actualBuilderResult = TbLwM2MReadRequest.builder();
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);
    TbLwM2MReadRequest actualTbLwM2MReadRequest =
        actualBuilderResult
            .requestContentFormat(requestContentFormat)
            .timeout(10L)
            .versionedId("42")
            .build();

    // Assert
    assertEquals("42", actualTbLwM2MReadRequest.getVersionedId());
    assertEquals("42", actualTbLwM2MReadRequest.getObjectId());
    assertNull(actualTbLwM2MReadRequest.getResponseContentFormat());
    assertEquals(10L, actualTbLwM2MReadRequest.getTimeout());
    assertEquals(LwM2MOperationType.READ, actualTbLwM2MReadRequest.getType());
    Optional<ContentFormat> requestContentFormat2 =
        actualTbLwM2MReadRequest.getRequestContentFormat();
    assertTrue(requestContentFormat2.isPresent());
    assertSame(requestContentFormat, requestContentFormat2.get());
  }
}
