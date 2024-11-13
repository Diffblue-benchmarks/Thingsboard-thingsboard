package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MDeleteRequest.TbLwM2MDeleteRequestBuilder;

class TbLwM2MDeleteRequestDiffblueTest {
  /**
   * Test {@link TbLwM2MDeleteRequest#getType()}.
   * <p>
   * Method under test: {@link TbLwM2MDeleteRequest#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  void testGetType() {
    // Arrange
    TbLwM2MDeleteRequest buildResult = TbLwM2MDeleteRequest.builder().timeout(10L).versionedId("42").build();

    // Act and Assert
    assertEquals(LwM2MOperationType.DELETE, buildResult.getType());
  }

  /**
   * Test TbLwM2MDeleteRequestBuilder {@link TbLwM2MDeleteRequestBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MDeleteRequest.TbLwM2MDeleteRequestBuilder#build()}
   *   <li>{@link TbLwM2MDeleteRequest.TbLwM2MDeleteRequestBuilder#timeout(long)}
   *   <li>
   * {@link TbLwM2MDeleteRequest.TbLwM2MDeleteRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MDeleteRequestBuilder build()")
  void testTbLwM2MDeleteRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MDeleteRequest actualBuildResult = TbLwM2MDeleteRequest.builder().timeout(10L).versionedId("42").build();

    // Assert
    assertEquals("42", actualBuildResult.getVersionedId());
    assertEquals("42", actualBuildResult.getObjectId());
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.DELETE, actualBuildResult.getType());
  }
}
