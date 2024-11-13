package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MCancelObserveRequest.TbLwM2MCancelObserveRequestBuilder;

class TbLwM2MCancelObserveRequestDiffblueTest {
  /**
   * Test {@link TbLwM2MCancelObserveRequest#getType()}.
   * <p>
   * Method under test: {@link TbLwM2MCancelObserveRequest#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  void testGetType() {
    // Arrange
    TbLwM2MCancelObserveRequest buildResult = TbLwM2MCancelObserveRequest.builder()
        .timeout(10L)
        .versionedId("42")
        .build();

    // Act and Assert
    assertEquals(LwM2MOperationType.OBSERVE_CANCEL, buildResult.getType());
  }

  /**
   * Test TbLwM2MCancelObserveRequestBuilder
   * {@link TbLwM2MCancelObserveRequestBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TbLwM2MCancelObserveRequest.TbLwM2MCancelObserveRequestBuilder#build()}
   *   <li>
   * {@link TbLwM2MCancelObserveRequest.TbLwM2MCancelObserveRequestBuilder#timeout(long)}
   *   <li>
   * {@link TbLwM2MCancelObserveRequest.TbLwM2MCancelObserveRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MCancelObserveRequestBuilder build()")
  void testTbLwM2MCancelObserveRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MCancelObserveRequest actualBuildResult = TbLwM2MCancelObserveRequest.builder()
        .timeout(10L)
        .versionedId("42")
        .build();

    // Assert
    assertEquals("42", actualBuildResult.getVersionedId());
    assertEquals("42", actualBuildResult.getObjectId());
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.OBSERVE_CANCEL, actualBuildResult.getType());
  }
}
