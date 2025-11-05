package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MDiscoverRequest.TbLwM2MDiscoverRequestBuilder;

@ContextConfiguration(classes = {TbLwM2MDiscoverRequestBuilder.class})
@ExtendWith(SpringExtension.class)
class TbLwM2MDiscoverRequestDiffblueTest {
  @Autowired private TbLwM2MDiscoverRequestBuilder tbLwM2MDiscoverRequestBuilder;

  /**
   * Test {@link TbLwM2MDiscoverRequest#getType()}.
   *
   * <p>Method under test: {@link TbLwM2MDiscoverRequest#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LwM2MOperationType TbLwM2MDiscoverRequest.getType()"})
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals(
        LwM2MOperationType.DISCOVER,
        TbLwM2MDiscoverRequest.builder().timeout(10L).versionedId("42").build().getType());
  }

  /**
   * Test TbLwM2MDiscoverRequestBuilder {@link TbLwM2MDiscoverRequestBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MDiscoverRequestBuilder#build()}
   *   <li>{@link TbLwM2MDiscoverRequestBuilder#timeout(long)}
   *   <li>{@link TbLwM2MDiscoverRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MDiscoverRequestBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbLwM2MDiscoverRequestBuilder.<init>()",
    "TbLwM2MDiscoverRequest TbLwM2MDiscoverRequestBuilder.build()",
    "TbLwM2MDiscoverRequestBuilder TbLwM2MDiscoverRequestBuilder.timeout(long)",
    "String TbLwM2MDiscoverRequestBuilder.toString()",
    "TbLwM2MDiscoverRequestBuilder TbLwM2MDiscoverRequestBuilder.versionedId(String)"
  })
  void testTbLwM2MDiscoverRequestBuilderBuild() {
    // Arrange and Act
    TbLwM2MDiscoverRequest actualTbLwM2MDiscoverRequest =
        TbLwM2MDiscoverRequest.builder().timeout(10L).versionedId("42").build();

    // Assert
    assertEquals("42", actualTbLwM2MDiscoverRequest.getVersionedId());
    assertEquals("42", actualTbLwM2MDiscoverRequest.getObjectId());
    assertEquals(10L, actualTbLwM2MDiscoverRequest.getTimeout());
    assertEquals(LwM2MOperationType.DISCOVER, actualTbLwM2MDiscoverRequest.getType());
  }
}
