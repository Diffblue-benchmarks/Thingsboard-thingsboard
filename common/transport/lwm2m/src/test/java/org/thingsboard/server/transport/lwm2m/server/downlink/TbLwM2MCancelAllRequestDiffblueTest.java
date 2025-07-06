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
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MCancelAllRequest.TbLwM2MCancelAllRequestBuilder;

@ContextConfiguration(classes = {TbLwM2MCancelAllRequestBuilder.class})
@ExtendWith(SpringExtension.class)
class TbLwM2MCancelAllRequestDiffblueTest {
  @Autowired private TbLwM2MCancelAllRequestBuilder tbLwM2MCancelAllRequestBuilder;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MCancelAllRequest#getTimeout()}
   *   <li>{@link TbLwM2MCancelAllRequest#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "long TbLwM2MCancelAllRequest.getTimeout()",
    "LwM2MOperationType TbLwM2MCancelAllRequest.getType()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbLwM2MCancelAllRequest buildResult = TbLwM2MCancelAllRequest.builder().timeout(10L).build();

    // Act
    long actualTimeout = buildResult.getTimeout();

    // Assert
    assertEquals(10L, actualTimeout);
    assertEquals(LwM2MOperationType.OBSERVE_CANCEL_ALL, buildResult.getType());
  }

  /**
   * Test TbLwM2MCancelAllRequestBuilder {@link TbLwM2MCancelAllRequestBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MCancelAllRequestBuilder#build()}
   *   <li>{@link TbLwM2MCancelAllRequestBuilder#timeout(long)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MCancelAllRequestBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbLwM2MCancelAllRequestBuilder.<init>()",
    "TbLwM2MCancelAllRequest TbLwM2MCancelAllRequestBuilder.build()",
    "TbLwM2MCancelAllRequestBuilder TbLwM2MCancelAllRequestBuilder.timeout(long)",
    "java.lang.String TbLwM2MCancelAllRequestBuilder.toString()"
  })
  void testTbLwM2MCancelAllRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MCancelAllRequest actualBuildResult =
        TbLwM2MCancelAllRequest.builder().timeout(10L).build();

    // Assert
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.OBSERVE_CANCEL_ALL, actualBuildResult.getType());
  }
}
