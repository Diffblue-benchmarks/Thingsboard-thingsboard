package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MObserveAllRequest.TbLwM2MObserveAllRequestBuilder;

class TbLwM2MObserveAllRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MObserveAllRequest#getTimeout()}
   *   <li>{@link TbLwM2MObserveAllRequest#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MObserveAllRequest buildResult = TbLwM2MObserveAllRequest.builder().timeout(10L).build();

    // Act
    long actualTimeout = buildResult.getTimeout();

    // Assert
    assertEquals(10L, actualTimeout);
    assertEquals(LwM2MOperationType.OBSERVE_READ_ALL, buildResult.getType());
  }

  /**
   * Test TbLwM2MObserveAllRequestBuilder
   * {@link TbLwM2MObserveAllRequestBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MObserveAllRequest.TbLwM2MObserveAllRequestBuilder#build()}
   *   <li>
   * {@link TbLwM2MObserveAllRequest.TbLwM2MObserveAllRequestBuilder#timeout(long)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MObserveAllRequestBuilder build()")
  void testTbLwM2MObserveAllRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MObserveAllRequest actualBuildResult = TbLwM2MObserveAllRequest.builder().timeout(10L).build();

    // Assert
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.OBSERVE_READ_ALL, actualBuildResult.getType());
  }
}
