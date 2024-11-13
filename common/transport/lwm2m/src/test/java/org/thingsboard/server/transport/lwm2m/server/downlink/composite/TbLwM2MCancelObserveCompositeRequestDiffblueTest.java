package org.thingsboard.server.transport.lwm2m.server.downlink.composite;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MCancelObserveCompositeRequest.TbLwM2MCancelObserveCompositeRequestBuilder;

class TbLwM2MCancelObserveCompositeRequestDiffblueTest {
  /**
   * Test {@link TbLwM2MCancelObserveCompositeRequest#getType()}.
   * <p>
   * Method under test: {@link TbLwM2MCancelObserveCompositeRequest#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  void testGetType() {
    // Arrange
    TbLwM2MCancelObserveCompositeRequest buildResult = TbLwM2MCancelObserveCompositeRequest.builder()
        .timeout(10L)
        .versionedIds(new String[]{"1.0.2"})
        .build();

    // Act and Assert
    assertEquals(LwM2MOperationType.OBSERVE_COMPOSITE_CANCEL, buildResult.getType());
  }

  /**
   * Test TbLwM2MCancelObserveCompositeRequestBuilder
   * {@link TbLwM2MCancelObserveCompositeRequestBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TbLwM2MCancelObserveCompositeRequest.TbLwM2MCancelObserveCompositeRequestBuilder#build()}
   *   <li>
   * {@link TbLwM2MCancelObserveCompositeRequest.TbLwM2MCancelObserveCompositeRequestBuilder#timeout(long)}
   *   <li>
   * {@link TbLwM2MCancelObserveCompositeRequest.TbLwM2MCancelObserveCompositeRequestBuilder#versionedIds(String[])}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MCancelObserveCompositeRequestBuilder build()")
  void testTbLwM2MCancelObserveCompositeRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MCancelObserveCompositeRequest actualBuildResult = TbLwM2MCancelObserveCompositeRequest.builder()
        .timeout(10L)
        .versionedIds(new String[]{"1.0.2"})
        .build();

    // Assert
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.OBSERVE_COMPOSITE_CANCEL, actualBuildResult.getType());
    assertArrayEquals(new String[]{"1.0.2"}, actualBuildResult.getObjectIds());
    assertArrayEquals(new String[]{"1.0.2"}, actualBuildResult.getVersionedIds());
  }
}
