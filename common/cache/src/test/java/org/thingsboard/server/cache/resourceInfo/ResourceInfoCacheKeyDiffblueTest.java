package org.thingsboard.server.cache.resourceInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.cache.resourceInfo.ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;

class ResourceInfoCacheKeyDiffblueTest {
  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}, and
   * {@link ResourceInfoCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResourceInfoCacheKey#equals(Object)}
   *   <li>{@link ResourceInfoCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(ResourceInfoCacheKey.builder());
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder2 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder2.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult = resourceInfoCacheKeyBuilder2
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult = tbResourceIdResult.tenantId(new TenantId(UUID.randomUUID())).build();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder3 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder3.tenantId(Mockito.<TenantId>any())).thenReturn(ResourceInfoCacheKey.builder());
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder4 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder4.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder3);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult2 = resourceInfoCacheKeyBuilder4
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult2 = tbResourceIdResult2.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}, and
   * {@link ResourceInfoCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResourceInfoCacheKey#equals(Object)}
   *   <li>{@link ResourceInfoCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult = builderResult
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult = tbResourceIdResult.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult = builderResult
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult = tbResourceIdResult.tenantId(new TenantId(UUID.randomUUID())).build();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder builderResult2 = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult2 = builderResult2
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult2 = tbResourceIdResult2.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(ResourceInfoCacheKey.builder());
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult = resourceInfoCacheKeyBuilder
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult = tbResourceIdResult.tenantId(new TenantId(UUID.randomUUID())).build();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult2 = builderResult
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult2 = tbResourceIdResult2.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(ResourceInfoCacheKey.builder());
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder2 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder2.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult = resourceInfoCacheKeyBuilder2
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult = tbResourceIdResult.tenantId(new TenantId(UUID.randomUUID())).build();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult2 = builderResult
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult2 = tbResourceIdResult2.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    builderResult.tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(builderResult);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder2 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder2.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult = resourceInfoCacheKeyBuilder2
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult = tbResourceIdResult.tenantId(new TenantId(UUID.randomUUID())).build();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder3 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder3.tenantId(Mockito.<TenantId>any())).thenReturn(ResourceInfoCacheKey.builder());
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder4 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder4.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder3);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult2 = resourceInfoCacheKeyBuilder4
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult2 = tbResourceIdResult2.tenantId(new TenantId(UUID.randomUUID())).build();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder5 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder5.build()).thenReturn(buildResult2);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder6 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder6.tenantId(Mockito.<TenantId>any())).thenReturn(resourceInfoCacheKeyBuilder5);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder7 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder7.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder6);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult3 = resourceInfoCacheKeyBuilder7
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult3 = tbResourceIdResult3.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult3);
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(ResourceInfoCacheKey.builder());
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder2 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder2.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult = resourceInfoCacheKeyBuilder2
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult = tbResourceIdResult.tenantId(new TenantId(UUID.randomUUID())).build();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    builderResult.tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder3 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder3.tenantId(Mockito.<TenantId>any())).thenReturn(builderResult);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder4 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder4.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder3);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult2 = resourceInfoCacheKeyBuilder4
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult2 = tbResourceIdResult2.tenantId(new TenantId(UUID.randomUUID())).build();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder5 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder5.build()).thenReturn(buildResult2);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder6 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder6.tenantId(Mockito.<TenantId>any())).thenReturn(resourceInfoCacheKeyBuilder5);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder resourceInfoCacheKeyBuilder7 = mock(
        ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder.class);
    when(resourceInfoCacheKeyBuilder7.tbResourceId(Mockito.<TbResourceId>any()))
        .thenReturn(resourceInfoCacheKeyBuilder6);
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult3 = resourceInfoCacheKeyBuilder7
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult3 = tbResourceIdResult3.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult3);
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult = builderResult
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult = tbResourceIdResult.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ResourceInfoCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInfoCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult = builderResult
        .tbResourceId(new TbResourceId(UUID.randomUUID()));
    ResourceInfoCacheKey buildResult = tbResourceIdResult.tenantId(new TenantId(UUID.randomUUID())).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ResourceInfoCacheKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResourceInfoCacheKey#ResourceInfoCacheKey(TenantId, TbResourceId)}
   *   <li>{@link ResourceInfoCacheKey#toString()}
   *   <li>{@link ResourceInfoCacheKey#getTbResourceId()}
   *   <li>{@link ResourceInfoCacheKey#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    TbResourceId tbResourceId = new TbResourceId(UUID.randomUUID());

    // Act
    ResourceInfoCacheKey actualResourceInfoCacheKey = new ResourceInfoCacheKey(tenantId, tbResourceId);
    actualResourceInfoCacheKey.toString();
    TbResourceId actualTbResourceId = actualResourceInfoCacheKey.getTbResourceId();

    // Assert
    assertSame(tbResourceId, actualTbResourceId);
    assertSame(tenantId, actualResourceInfoCacheKey.getTenantId());
  }

  /**
   * Test ResourceInfoCacheKeyBuilder {@link ResourceInfoCacheKeyBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder#build()}
   *   <li>
   * {@link ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder#tbResourceId(TbResourceId)}
   *   <li>
   * {@link ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  @DisplayName("Test ResourceInfoCacheKeyBuilder build()")
  void testResourceInfoCacheKeyBuilderBuild() {
    // Arrange
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder builderResult = ResourceInfoCacheKey.builder();
    TbResourceId tbResourceId = new TbResourceId(UUID.randomUUID());
    ResourceInfoCacheKey.ResourceInfoCacheKeyBuilder tbResourceIdResult = builderResult.tbResourceId(tbResourceId);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    ResourceInfoCacheKey actualBuildResult = tbResourceIdResult.tenantId(tenantId).build();

    // Assert
    assertSame(tbResourceId, actualBuildResult.getTbResourceId());
    assertSame(tenantId, actualBuildResult.getTenantId());
  }
}
