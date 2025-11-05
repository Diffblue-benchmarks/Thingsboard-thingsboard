package org.thingsboard.server.transport.lwm2m.server.downlink.composite;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.eclipse.leshan.core.request.ContentFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MObserveCompositeRequest.TbLwM2MObserveCompositeRequestBuilder;

class AbstractTbLwM2MTargetedDownlinkCompositeRequestDiffblueTest {
  /**
   * Test {@link AbstractTbLwM2MTargetedDownlinkCompositeRequest#getTimeout()}.
   *
   * <p>Method under test: {@link AbstractTbLwM2MTargetedDownlinkCompositeRequest#getTimeout()}
   */
  @Test
  @DisplayName("Test getTimeout()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AbstractTbLwM2MTargetedDownlinkCompositeRequest.getTimeout()"})
  void testGetTimeout() {
    // Arrange
    TbLwM2MObserveCompositeRequestBuilder builderResult = TbLwM2MObserveCompositeRequest.builder();

    TbLwM2MObserveCompositeRequestBuilder requestContentFormatResult =
        builderResult.requestContentFormat(ContentFormat.fromCode(1));

    // Act and Assert
    assertEquals(
        10L,
        requestContentFormatResult
            .responseContentFormat(ContentFormat.fromCode(1))
            .timeout(10L)
            .versionedIds(new String[] {"1.0.2"})
            .build()
            .getTimeout());
  }

  /**
   * Test {@link AbstractTbLwM2MTargetedDownlinkCompositeRequest#getVersionedIds()}.
   *
   * <p>Method under test: {@link AbstractTbLwM2MTargetedDownlinkCompositeRequest#getVersionedIds()}
   */
  @Test
  @DisplayName("Test getVersionedIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] AbstractTbLwM2MTargetedDownlinkCompositeRequest.getVersionedIds()"})
  void testGetVersionedIds() {
    // Arrange
    TbLwM2MObserveCompositeRequestBuilder builderResult = TbLwM2MObserveCompositeRequest.builder();

    TbLwM2MObserveCompositeRequestBuilder requestContentFormatResult =
        builderResult.requestContentFormat(ContentFormat.fromCode(1));

    // Act and Assert
    assertArrayEquals(
        new String[] {"1.0.2"},
        requestContentFormatResult
            .responseContentFormat(ContentFormat.fromCode(1))
            .timeout(10L)
            .versionedIds(new String[] {"1.0.2"})
            .build()
            .getVersionedIds());
  }
}
