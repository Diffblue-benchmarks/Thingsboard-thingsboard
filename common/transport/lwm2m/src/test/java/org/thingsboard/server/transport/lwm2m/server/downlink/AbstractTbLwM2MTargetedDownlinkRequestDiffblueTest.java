package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.eclipse.leshan.core.request.ContentFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MCreateRequest.TbLwM2MCreateRequestBuilder;

class AbstractTbLwM2MTargetedDownlinkRequestDiffblueTest {
  /**
   * Test {@link AbstractTbLwM2MTargetedDownlinkRequest#getTimeout()}.
   *
   * <p>Method under test: {@link AbstractTbLwM2MTargetedDownlinkRequest#getTimeout()}
   */
  @Test
  @DisplayName("Test getTimeout()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AbstractTbLwM2MTargetedDownlinkRequest.getTimeout()"})
  void testGetTimeout() {
    // Arrange
    TbLwM2MCreateRequestBuilder builderResult = TbLwM2MCreateRequest.builder();

    TbLwM2MCreateRequestBuilder nodesResult = builderResult.nodes(new HashMap<>());

    // Act and Assert
    assertEquals(
        10L,
        nodesResult
            .objectContentFormat(ContentFormat.fromCode(1))
            .timeout(10L)
            .value("Value")
            .versionedId("42")
            .build()
            .getTimeout());
  }

  /**
   * Test {@link AbstractTbLwM2MTargetedDownlinkRequest#getVersionedId()}.
   *
   * <p>Method under test: {@link AbstractTbLwM2MTargetedDownlinkRequest#getVersionedId()}
   */
  @Test
  @DisplayName("Test getVersionedId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AbstractTbLwM2MTargetedDownlinkRequest.getVersionedId()"})
  void testGetVersionedId() {
    // Arrange
    TbLwM2MCreateRequestBuilder builderResult = TbLwM2MCreateRequest.builder();

    TbLwM2MCreateRequestBuilder nodesResult = builderResult.nodes(new HashMap<>());

    // Act and Assert
    assertEquals(
        "42",
        nodesResult
            .objectContentFormat(ContentFormat.fromCode(1))
            .timeout(10L)
            .value("Value")
            .versionedId("42")
            .build()
            .getVersionedId());
  }
}
