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
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MCancelObserveRequest.TbLwM2MCancelObserveRequestBuilder;

@ContextConfiguration(classes = {TbLwM2MCancelObserveRequestBuilder.class})
@ExtendWith(SpringExtension.class)
class TbLwM2MCancelObserveRequestDiffblueTest {
  @Autowired private TbLwM2MCancelObserveRequestBuilder tbLwM2MCancelObserveRequestBuilder;

  /**
   * Test {@link TbLwM2MCancelObserveRequest#getType()}.
   *
   * <p>Method under test: {@link TbLwM2MCancelObserveRequest#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LwM2MOperationType TbLwM2MCancelObserveRequest.getType()"})
  void testGetType() {
    // Arrange
    TbLwM2MCancelObserveRequest buildResult =
        TbLwM2MCancelObserveRequest.builder().timeout(10L).versionedId("42").build();

    // Act and Assert
    assertEquals(LwM2MOperationType.OBSERVE_CANCEL, buildResult.getType());
  }

  /**
   * Test TbLwM2MCancelObserveRequestBuilder {@link TbLwM2MCancelObserveRequestBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MCancelObserveRequestBuilder#build()}
   *   <li>{@link TbLwM2MCancelObserveRequestBuilder#timeout(long)}
   *   <li>{@link TbLwM2MCancelObserveRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MCancelObserveRequestBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbLwM2MCancelObserveRequestBuilder.<init>()",
    "TbLwM2MCancelObserveRequest TbLwM2MCancelObserveRequestBuilder.build()",
    "TbLwM2MCancelObserveRequestBuilder TbLwM2MCancelObserveRequestBuilder.timeout(long)",
    "String TbLwM2MCancelObserveRequestBuilder.toString()",
    "TbLwM2MCancelObserveRequestBuilder TbLwM2MCancelObserveRequestBuilder.versionedId(String)"
  })
  void testTbLwM2MCancelObserveRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MCancelObserveRequest actualBuildResult =
        TbLwM2MCancelObserveRequest.builder().timeout(10L).versionedId("42").build();

    // Assert
    assertEquals("42", actualBuildResult.getVersionedId());
    assertEquals("42", actualBuildResult.getObjectId());
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.OBSERVE_CANCEL, actualBuildResult.getType());
  }
}
