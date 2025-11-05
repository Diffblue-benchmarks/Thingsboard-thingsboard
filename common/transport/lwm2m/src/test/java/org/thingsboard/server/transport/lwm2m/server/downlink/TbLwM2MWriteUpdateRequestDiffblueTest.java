package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.eclipse.leshan.core.request.ContentFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MWriteUpdateRequest.TbLwM2MWriteUpdateRequestBuilder;

@ContextConfiguration(classes = {TbLwM2MWriteUpdateRequestBuilder.class})
@ExtendWith(SpringExtension.class)
class TbLwM2MWriteUpdateRequestDiffblueTest {
  @Autowired private TbLwM2MWriteUpdateRequestBuilder tbLwM2MWriteUpdateRequestBuilder;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MWriteUpdateRequest#getObjectContentFormat()}
   *   <li>{@link TbLwM2MWriteUpdateRequest#getType()}
   *   <li>{@link TbLwM2MWriteUpdateRequest#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ContentFormat TbLwM2MWriteUpdateRequest.getObjectContentFormat()",
    "LwM2MOperationType TbLwM2MWriteUpdateRequest.getType()",
    "Object TbLwM2MWriteUpdateRequest.getValue()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MWriteUpdateRequestBuilder builderResult = TbLwM2MWriteUpdateRequest.builder();
    ContentFormat objectContentFormat = ContentFormat.fromCode(1);
    TbLwM2MWriteUpdateRequest tbLwM2MWriteUpdateRequest =
        builderResult
            .objectContentFormat(objectContentFormat)
            .timeout(10L)
            .value("Value")
            .versionedId("42")
            .build();

    // Act
    ContentFormat actualObjectContentFormat = tbLwM2MWriteUpdateRequest.getObjectContentFormat();
    LwM2MOperationType actualType = tbLwM2MWriteUpdateRequest.getType();

    // Assert
    assertEquals("Value", tbLwM2MWriteUpdateRequest.getValue());
    assertEquals(LwM2MOperationType.WRITE_UPDATE, actualType);
    assertSame(objectContentFormat, actualObjectContentFormat);
  }

  /**
   * Test TbLwM2MWriteUpdateRequestBuilder {@link TbLwM2MWriteUpdateRequestBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MWriteUpdateRequestBuilder#build()}
   *   <li>{@link TbLwM2MWriteUpdateRequestBuilder#objectContentFormat(ContentFormat)}
   *   <li>{@link TbLwM2MWriteUpdateRequestBuilder#timeout(long)}
   *   <li>{@link TbLwM2MWriteUpdateRequestBuilder#value(Object)}
   *   <li>{@link TbLwM2MWriteUpdateRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MWriteUpdateRequestBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbLwM2MWriteUpdateRequestBuilder.<init>()",
    "TbLwM2MWriteUpdateRequest TbLwM2MWriteUpdateRequestBuilder.build()",
    "TbLwM2MWriteUpdateRequestBuilder TbLwM2MWriteUpdateRequestBuilder.objectContentFormat(ContentFormat)",
    "TbLwM2MWriteUpdateRequestBuilder TbLwM2MWriteUpdateRequestBuilder.timeout(long)",
    "String TbLwM2MWriteUpdateRequestBuilder.toString()",
    "TbLwM2MWriteUpdateRequestBuilder TbLwM2MWriteUpdateRequestBuilder.value(Object)",
    "TbLwM2MWriteUpdateRequestBuilder TbLwM2MWriteUpdateRequestBuilder.versionedId(String)"
  })
  void testTbLwM2MWriteUpdateRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MWriteUpdateRequestBuilder actualBuilderResult = TbLwM2MWriteUpdateRequest.builder();
    ContentFormat objectContentFormat = ContentFormat.fromCode(1);
    TbLwM2MWriteUpdateRequest actualTbLwM2MWriteUpdateRequest =
        actualBuilderResult
            .objectContentFormat(objectContentFormat)
            .timeout(10L)
            .value("Value")
            .versionedId("42")
            .build();

    // Assert
    assertEquals("42", actualTbLwM2MWriteUpdateRequest.getVersionedId());
    assertEquals("42", actualTbLwM2MWriteUpdateRequest.getObjectId());
    assertEquals("Value", actualTbLwM2MWriteUpdateRequest.getValue());
    assertEquals(10L, actualTbLwM2MWriteUpdateRequest.getTimeout());
    assertEquals(LwM2MOperationType.WRITE_UPDATE, actualTbLwM2MWriteUpdateRequest.getType());
    assertSame(objectContentFormat, actualTbLwM2MWriteUpdateRequest.getObjectContentFormat());
  }
}
