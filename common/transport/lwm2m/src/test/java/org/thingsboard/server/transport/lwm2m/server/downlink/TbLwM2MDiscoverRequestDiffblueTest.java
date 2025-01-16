package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MDiscoverRequest.TbLwM2MDiscoverRequestBuilder;

class TbLwM2MDiscoverRequestDiffblueTest {
  /**
   * Test {@link TbLwM2MDiscoverRequest#getType()}.
   * <p>
   * Method under test: {@link TbLwM2MDiscoverRequest#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  void testGetType() {
    // Arrange
    TbLwM2MDiscoverRequest buildResult = TbLwM2MDiscoverRequest.builder().timeout(10L).versionedId("42").build();

    // Act and Assert
    assertEquals(LwM2MOperationType.DISCOVER, buildResult.getType());
  }

  /**
   * Test TbLwM2MDiscoverRequestBuilder
   * {@link TbLwM2MDiscoverRequestBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MDiscoverRequest.TbLwM2MDiscoverRequestBuilder#build()}
   *   <li>
   * {@link TbLwM2MDiscoverRequest.TbLwM2MDiscoverRequestBuilder#timeout(long)}
   *   <li>
   * {@link TbLwM2MDiscoverRequest.TbLwM2MDiscoverRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MDiscoverRequestBuilder build()")
  void testTbLwM2MDiscoverRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MDiscoverRequest actualBuildResult = TbLwM2MDiscoverRequest.builder().timeout(10L).versionedId("42").build();

    // Assert
    assertEquals("42", actualBuildResult.getVersionedId());
    assertEquals("42", actualBuildResult.getObjectId());
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.DISCOVER, actualBuildResult.getType());
  }
}
