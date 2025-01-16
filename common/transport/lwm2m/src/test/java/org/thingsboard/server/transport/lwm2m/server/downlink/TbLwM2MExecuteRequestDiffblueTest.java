package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MExecuteRequest.TbLwM2MExecuteRequestBuilder;

class TbLwM2MExecuteRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MExecuteRequest#getParams()}
   *   <li>{@link TbLwM2MExecuteRequest#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MExecuteRequest buildResult = TbLwM2MExecuteRequest.builder()
        .params("Params")
        .timeout(10L)
        .versionedId("42")
        .build();

    // Act
    Object actualParams = buildResult.getParams();

    // Assert
    assertEquals("Params", actualParams);
    assertEquals(LwM2MOperationType.EXECUTE, buildResult.getType());
  }

  /**
   * Test TbLwM2MExecuteRequestBuilder
   * {@link TbLwM2MExecuteRequestBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MExecuteRequest.TbLwM2MExecuteRequestBuilder#build()}
   *   <li>{@link TbLwM2MExecuteRequest.TbLwM2MExecuteRequestBuilder#params(Object)}
   *   <li>{@link TbLwM2MExecuteRequest.TbLwM2MExecuteRequestBuilder#timeout(long)}
   *   <li>
   * {@link TbLwM2MExecuteRequest.TbLwM2MExecuteRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MExecuteRequestBuilder build()")
  void testTbLwM2MExecuteRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MExecuteRequest actualBuildResult = TbLwM2MExecuteRequest.builder()
        .params("Params")
        .timeout(10L)
        .versionedId("42")
        .build();

    // Assert
    assertEquals("42", actualBuildResult.getVersionedId());
    assertEquals("42", actualBuildResult.getObjectId());
    assertEquals("Params", actualBuildResult.getParams());
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.EXECUTE, actualBuildResult.getType());
  }
}
