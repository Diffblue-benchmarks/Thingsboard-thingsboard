package org.thingsboard.server.transport.lwm2m.server.downlink.composite;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MCancelObserveCompositeRequest.TbLwM2MCancelObserveCompositeRequestBuilder;

@ContextConfiguration(classes = {TbLwM2MCancelObserveCompositeRequestBuilder.class})
@ExtendWith(SpringExtension.class)
class TbLwM2MCancelObserveCompositeRequestDiffblueTest {
  @Autowired
  private TbLwM2MCancelObserveCompositeRequestBuilder tbLwM2MCancelObserveCompositeRequestBuilder;

  /**
   * Test {@link TbLwM2MCancelObserveCompositeRequest#getType()}.
   *
   * <p>Method under test: {@link TbLwM2MCancelObserveCompositeRequest#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LwM2MOperationType TbLwM2MCancelObserveCompositeRequest.getType()"})
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals(
        LwM2MOperationType.OBSERVE_COMPOSITE_CANCEL,
        TbLwM2MCancelObserveCompositeRequest.builder()
            .timeout(10L)
            .versionedIds(new String[] {"1.0.2"})
            .build()
            .getType());
  }

  /**
   * Test TbLwM2MCancelObserveCompositeRequestBuilder {@link
   * TbLwM2MCancelObserveCompositeRequestBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbLwM2MCancelObserveCompositeRequestBuilder#build()}
   *   <li>{@link TbLwM2MCancelObserveCompositeRequestBuilder#timeout(long)}
   *   <li>{@link TbLwM2MCancelObserveCompositeRequestBuilder#versionedIds(String[])}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MCancelObserveCompositeRequestBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbLwM2MCancelObserveCompositeRequestBuilder.<init>()",
    "TbLwM2MCancelObserveCompositeRequest TbLwM2MCancelObserveCompositeRequestBuilder.build()",
    "TbLwM2MCancelObserveCompositeRequestBuilder TbLwM2MCancelObserveCompositeRequestBuilder.timeout(long)",
    "String TbLwM2MCancelObserveCompositeRequestBuilder.toString()",
    "TbLwM2MCancelObserveCompositeRequestBuilder TbLwM2MCancelObserveCompositeRequestBuilder.versionedIds(String[])"
  })
  void testTbLwM2MCancelObserveCompositeRequestBuilderBuild() {
    // Arrange
    String[] versionedIds = new String[] {"1.0.2"};

    // Act
    TbLwM2MCancelObserveCompositeRequest actualTbLwM2MCancelObserveCompositeRequest =
        TbLwM2MCancelObserveCompositeRequest.builder()
            .timeout(10L)
            .versionedIds(versionedIds)
            .build();

    // Assert
    assertEquals(10L, actualTbLwM2MCancelObserveCompositeRequest.getTimeout());
    assertEquals(
        LwM2MOperationType.OBSERVE_COMPOSITE_CANCEL,
        actualTbLwM2MCancelObserveCompositeRequest.getType());
    String[] versionedIds2 = actualTbLwM2MCancelObserveCompositeRequest.getVersionedIds();
    assertSame(versionedIds, versionedIds2);
    assertArrayEquals(
        new String[] {"1.0.2"}, actualTbLwM2MCancelObserveCompositeRequest.getObjectIds());
    assertArrayEquals(new String[] {"1.0.2"}, versionedIds2);
  }
}
