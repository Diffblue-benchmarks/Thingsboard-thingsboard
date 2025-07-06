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
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MDiscoverAllRequest.TbLwM2MDiscoverAllRequestBuilder;

@ContextConfiguration(classes = {TbLwM2MDiscoverAllRequestBuilder.class})
@ExtendWith(SpringExtension.class)
class TbLwM2MDiscoverAllRequestDiffblueTest {
  @Autowired private TbLwM2MDiscoverAllRequestBuilder tbLwM2MDiscoverAllRequestBuilder;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MDiscoverAllRequest#getTimeout()}
   *   <li>{@link TbLwM2MDiscoverAllRequest#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "long TbLwM2MDiscoverAllRequest.getTimeout()",
    "LwM2MOperationType TbLwM2MDiscoverAllRequest.getType()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MDiscoverAllRequest buildResult =
        TbLwM2MDiscoverAllRequest.builder().timeout(10L).build();

    // Act
    long actualTimeout = buildResult.getTimeout();

    // Assert
    assertEquals(10L, actualTimeout);
    assertEquals(LwM2MOperationType.DISCOVER_ALL, buildResult.getType());
  }

  /**
   * Test TbLwM2MDiscoverAllRequestBuilder {@link TbLwM2MDiscoverAllRequestBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MDiscoverAllRequestBuilder#build()}
   *   <li>{@link TbLwM2MDiscoverAllRequestBuilder#timeout(long)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MDiscoverAllRequestBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbLwM2MDiscoverAllRequestBuilder.<init>()",
    "TbLwM2MDiscoverAllRequest TbLwM2MDiscoverAllRequestBuilder.build()",
    "TbLwM2MDiscoverAllRequestBuilder TbLwM2MDiscoverAllRequestBuilder.timeout(long)",
    "java.lang.String TbLwM2MDiscoverAllRequestBuilder.toString()"
  })
  void testTbLwM2MDiscoverAllRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MDiscoverAllRequest actualBuildResult =
        TbLwM2MDiscoverAllRequest.builder().timeout(10L).build();

    // Assert
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.DISCOVER_ALL, actualBuildResult.getType());
  }
}
