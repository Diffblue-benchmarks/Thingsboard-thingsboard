package org.thingsboard.server.dao.asset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.asset.AssetCacheKey.AssetCacheKeyBuilder;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {AssetCacheKeyBuilder.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AssetCacheKeyDiffblueTest {
  @Autowired private AssetCacheKeyBuilder assetCacheKeyBuilder;

  /**
   * Test AssetCacheKeyBuilder {@link AssetCacheKeyBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetCacheKeyBuilder#build()}
   *   <li>{@link AssetCacheKeyBuilder#name(String)}
   *   <li>{@link AssetCacheKeyBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void AssetCacheKeyBuilder.<init>()",
    "AssetCacheKey AssetCacheKeyBuilder.build()",
    "AssetCacheKeyBuilder AssetCacheKeyBuilder.name(String)",
    "AssetCacheKeyBuilder AssetCacheKeyBuilder.tenantId(TenantId)",
    "String AssetCacheKeyBuilder.toString()"
  })
  public void testAssetCacheKeyBuilderBuild() {
    // Arrange and Act
    AssetCacheKey actualBuildResult =
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Assert
    TenantId tenantId = actualBuildResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Name", actualBuildResult.getName());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}, and {@link AssetCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetCacheKey#equals(Object)}
   *   <li>{@link AssetCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetCacheKey buildResult =
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();
    AssetCacheKey buildResult2 =
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}, and {@link AssetCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetCacheKey#equals(Object)}
   *   <li>{@link AssetCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetCacheKey buildResult =
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetCacheKeyBuilder assetCacheKeyBuilder = mock(AssetCacheKeyBuilder.class);
    when(assetCacheKeyBuilder.name(Mockito.<String>any())).thenReturn(AssetCacheKey.builder());
    AssetCacheKey buildResult =
        assetCacheKeyBuilder.name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();
    AssetCacheKey buildResult2 =
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetCacheKeyBuilder assetCacheKeyBuilder = mock(AssetCacheKeyBuilder.class);
    when(assetCacheKeyBuilder.tenantId(Mockito.<TenantId>any()))
        .thenReturn(AssetCacheKey.builder());
    AssetCacheKeyBuilder assetCacheKeyBuilder2 = mock(AssetCacheKeyBuilder.class);
    when(assetCacheKeyBuilder2.name(Mockito.<String>any())).thenReturn(assetCacheKeyBuilder);
    AssetCacheKey buildResult =
        assetCacheKeyBuilder2.name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();
    AssetCacheKey buildResult2 =
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetCacheKeyBuilder assetCacheKeyBuilder = mock(AssetCacheKeyBuilder.class);
    when(assetCacheKeyBuilder.tenantId(Mockito.<TenantId>any()))
        .thenReturn(AssetCacheKey.builder());
    AssetCacheKeyBuilder assetCacheKeyBuilder2 = mock(AssetCacheKeyBuilder.class);
    when(assetCacheKeyBuilder2.name(Mockito.<String>any())).thenReturn(assetCacheKeyBuilder);
    AssetCacheKey buildResult =
        assetCacheKeyBuilder2.name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();
    AssetCacheKey buildResult2 = AssetCacheKey.builder().name("Name").tenantId(null).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetCacheKeyBuilder assetCacheKeyBuilder = mock(AssetCacheKeyBuilder.class);
    AssetCacheKey buildResult =
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();
    when(assetCacheKeyBuilder.build()).thenReturn(buildResult);
    AssetCacheKeyBuilder assetCacheKeyBuilder2 = mock(AssetCacheKeyBuilder.class);
    when(assetCacheKeyBuilder2.tenantId(Mockito.<TenantId>any())).thenReturn(assetCacheKeyBuilder);
    AssetCacheKeyBuilder assetCacheKeyBuilder3 = mock(AssetCacheKeyBuilder.class);
    when(assetCacheKeyBuilder3.name(Mockito.<String>any())).thenReturn(assetCacheKeyBuilder2);
    AssetCacheKey buildResult2 =
        assetCacheKeyBuilder3.name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();
    AssetCacheKey buildResult3 = AssetCacheKey.builder().name("Name").tenantId(null).build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AssetCacheKeyBuilder assetCacheKeyBuilder = mock(AssetCacheKeyBuilder.class);
    AssetCacheKey buildResult = AssetCacheKey.builder().name("42").tenantId(null).build();
    when(assetCacheKeyBuilder.build()).thenReturn(buildResult);
    AssetCacheKeyBuilder assetCacheKeyBuilder2 = mock(AssetCacheKeyBuilder.class);
    when(assetCacheKeyBuilder2.tenantId(Mockito.<TenantId>any())).thenReturn(assetCacheKeyBuilder);
    AssetCacheKeyBuilder assetCacheKeyBuilder3 = mock(AssetCacheKeyBuilder.class);
    when(assetCacheKeyBuilder3.name(Mockito.<String>any())).thenReturn(assetCacheKeyBuilder2);
    AssetCacheKey buildResult2 =
        assetCacheKeyBuilder3.name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();
    AssetCacheKey buildResult3 = AssetCacheKey.builder().name("Name").tenantId(null).build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AssetCacheKey buildResult =
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link AssetCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AssetCacheKey buildResult =
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to AssetCacheKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetCacheKey#AssetCacheKey(TenantId, String)}
   *   <li>{@link AssetCacheKey#toString()}
   *   <li>{@link AssetCacheKey#getName()}
   *   <li>{@link AssetCacheKey#getTenantId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void AssetCacheKey.<init>(TenantId, String)",
    "String AssetCacheKey.getName()",
    "TenantId AssetCacheKey.getTenantId()",
    "String AssetCacheKey.toString()"
  })
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
