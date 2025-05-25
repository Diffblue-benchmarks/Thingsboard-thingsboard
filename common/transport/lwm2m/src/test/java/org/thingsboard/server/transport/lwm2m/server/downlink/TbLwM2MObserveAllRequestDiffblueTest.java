package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MObserveAllRequest.TbLwM2MObserveAllRequestBuilder;

@ContextConfiguration(classes = {TbLwM2MObserveAllRequestBuilder.class})
@ExtendWith(SpringExtension.class)
class TbLwM2MObserveAllRequestDiffblueTest {
  @Autowired
  private TbLwM2MObserveAllRequestBuilder tbLwM2MObserveAllRequestBuilder;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long TbLwM2MObserveAllRequest.getTimeout()",
      "LwM2MOperationType TbLwM2MObserveAllRequest.getType()"})
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
   * Test TbLwM2MObserveAllRequestBuilder {@link TbLwM2MObserveAllRequestBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MObserveAllRequestBuilder#build()}
   *   <li>{@link TbLwM2MObserveAllRequestBuilder#timeout(long)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MObserveAllRequestBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbLwM2MObserveAllRequestBuilder.<init>()",
      "TbLwM2MObserveAllRequest TbLwM2MObserveAllRequestBuilder.build()",
      "TbLwM2MObserveAllRequestBuilder TbLwM2MObserveAllRequestBuilder.timeout(long)",
      "java.lang.String TbLwM2MObserveAllRequestBuilder.toString()"})
  void testTbLwM2MObserveAllRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MObserveAllRequest actualBuildResult = TbLwM2MObserveAllRequest.builder().timeout(10L).build();

    // Assert
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.OBSERVE_READ_ALL, actualBuildResult.getType());
  }
}
