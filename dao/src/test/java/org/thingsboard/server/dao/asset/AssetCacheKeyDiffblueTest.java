package org.thingsboard.server.dao.asset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.asset.AssetCacheKey.AssetCacheKeyBuilder;
import org.thingsboard.server.dao.model.ModelConstants;

public class AssetCacheKeyDiffblueTest {
  /**
   * Test AssetCacheKeyBuilder {@link AssetCacheKeyBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AssetCacheKey.AssetCacheKeyBuilder#build()}
   *   <li>{@link AssetCacheKey.AssetCacheKeyBuilder#name(String)}
   *   <li>{@link AssetCacheKey.AssetCacheKeyBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  public void testAssetCacheKeyBuilderBuild() {
    // Arrange and Act
    AssetCacheKey actualBuildResult = AssetCacheKey.builder()
        .name("Name")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Assert
    TenantId tenantId = actualBuildResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Name", actualBuildResult.getName());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}, and
   * {@link AssetCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AssetCacheKey#equals(Object)}
   *   <li>{@link AssetCacheKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetCacheKey buildResult = AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();
    AssetCacheKey buildResult2 = AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}, and
   * {@link AssetCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AssetCacheKey#equals(Object)}
   *   <li>{@link AssetCacheKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetCacheKey buildResult = AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetCacheKey.AssetCacheKeyBuilder assetCacheKeyBuilder = mock(AssetCacheKey.AssetCacheKeyBuilder.class);
    when(assetCacheKeyBuilder.name(Mockito.<String>any())).thenReturn(AssetCacheKey.builder());
    AssetCacheKey buildResult = assetCacheKeyBuilder.name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();
    AssetCacheKey buildResult2 = AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetCacheKey.AssetCacheKeyBuilder assetCacheKeyBuilder = mock(AssetCacheKey.AssetCacheKeyBuilder.class);
    when(assetCacheKeyBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(AssetCacheKey.builder());
    AssetCacheKey.AssetCacheKeyBuilder assetCacheKeyBuilder2 = mock(AssetCacheKey.AssetCacheKeyBuilder.class);
    when(assetCacheKeyBuilder2.name(Mockito.<String>any())).thenReturn(assetCacheKeyBuilder);
    AssetCacheKey buildResult = assetCacheKeyBuilder2.name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();
    AssetCacheKey buildResult2 = AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetCacheKey.AssetCacheKeyBuilder assetCacheKeyBuilder = mock(AssetCacheKey.AssetCacheKeyBuilder.class);
    when(assetCacheKeyBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(AssetCacheKey.builder());
    AssetCacheKey.AssetCacheKeyBuilder assetCacheKeyBuilder2 = mock(AssetCacheKey.AssetCacheKeyBuilder.class);
    when(assetCacheKeyBuilder2.name(Mockito.<String>any())).thenReturn(assetCacheKeyBuilder);
    AssetCacheKey buildResult = assetCacheKeyBuilder2.name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();
    AssetCacheKey buildResult2 = AssetCacheKey.builder().name("Name").tenantId(null).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetCacheKey.AssetCacheKeyBuilder assetCacheKeyBuilder = mock(AssetCacheKey.AssetCacheKeyBuilder.class);
    AssetCacheKey buildResult = AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();
    when(assetCacheKeyBuilder.build()).thenReturn(buildResult);
    AssetCacheKey.AssetCacheKeyBuilder assetCacheKeyBuilder2 = mock(AssetCacheKey.AssetCacheKeyBuilder.class);
    when(assetCacheKeyBuilder2.tenantId(Mockito.<TenantId>any())).thenReturn(assetCacheKeyBuilder);
    AssetCacheKey.AssetCacheKeyBuilder assetCacheKeyBuilder3 = mock(AssetCacheKey.AssetCacheKeyBuilder.class);
    when(assetCacheKeyBuilder3.name(Mockito.<String>any())).thenReturn(assetCacheKeyBuilder2);
    AssetCacheKey buildResult2 = assetCacheKeyBuilder3.name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();
    AssetCacheKey buildResult3 = AssetCacheKey.builder().name("Name").tenantId(null).build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AssetCacheKey.AssetCacheKeyBuilder assetCacheKeyBuilder = mock(AssetCacheKey.AssetCacheKeyBuilder.class);
    AssetCacheKey buildResult = AssetCacheKey.builder().name("42").tenantId(null).build();
    when(assetCacheKeyBuilder.build()).thenReturn(buildResult);
    AssetCacheKey.AssetCacheKeyBuilder assetCacheKeyBuilder2 = mock(AssetCacheKey.AssetCacheKeyBuilder.class);
    when(assetCacheKeyBuilder2.tenantId(Mockito.<TenantId>any())).thenReturn(assetCacheKeyBuilder);
    AssetCacheKey.AssetCacheKeyBuilder assetCacheKeyBuilder3 = mock(AssetCacheKey.AssetCacheKeyBuilder.class);
    when(assetCacheKeyBuilder3.name(Mockito.<String>any())).thenReturn(assetCacheKeyBuilder2);
    AssetCacheKey buildResult2 = assetCacheKeyBuilder3.name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();
    AssetCacheKey buildResult3 = AssetCacheKey.builder().name("Name").tenantId(null).build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AssetCacheKey buildResult = AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AssetCacheKey buildResult = AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to AssetCacheKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AssetCacheKey#AssetCacheKey(TenantId, String)}
   *   <li>{@link AssetCacheKey#toString()}
   *   <li>{@link AssetCacheKey#getName()}
   *   <li>{@link AssetCacheKey#getTenantId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    AssetCacheKey actualAssetCacheKey = new AssetCacheKey(ModelConstants.SYSTEM_TENANT, "Name");
    String actualToStringResult = actualAssetCacheKey.toString();
    String actualName = actualAssetCacheKey.getName();
    TenantId actualTenantId = actualAssetCacheKey.getTenantId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080_Name", actualToStringResult);
    assertEquals("Name", actualName);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }
}
