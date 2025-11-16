/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.asset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AssetCacheKeyBuilder.<init>()",
    "AssetCacheKey AssetCacheKeyBuilder.build()",
    "AssetCacheKeyBuilder AssetCacheKeyBuilder.name(String)",
    "AssetCacheKeyBuilder AssetCacheKeyBuilder.tenantId(TenantId)",
    "String AssetCacheKeyBuilder.toString()"
  })
  public void testAssetCacheKeyBuilderBuild() {
    // Arrange and Act
    AssetCacheKey actualAssetCacheKey =
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Assert
    assertEquals("Name", actualAssetCacheKey.getName());
    assertSame(TenantId.SYS_TENANT_ID, actualAssetCacheKey.getTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetCacheKey assetCacheKey =
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();
    AssetCacheKey assetCacheKey2 =
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Act and Assert
    assertEquals(assetCacheKey, assetCacheKey2);
    assertEquals(assetCacheKey.hashCode(), assetCacheKey2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AssetCacheKey assetCacheKey =
        AssetCacheKey.builder().name(null).tenantId(ModelConstants.SYSTEM_TENANT).build();
    AssetCacheKey assetCacheKey2 =
        AssetCacheKey.builder().name(null).tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Act and Assert
    assertEquals(assetCacheKey, assetCacheKey2);
    assertEquals(assetCacheKey.hashCode(), assetCacheKey2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AssetCacheKey assetCacheKey = AssetCacheKey.builder().name("Name").tenantId(null).build();
    AssetCacheKey assetCacheKey2 = AssetCacheKey.builder().name("Name").tenantId(null).build();

    // Act and Assert
    assertEquals(assetCacheKey, assetCacheKey2);
    assertEquals(assetCacheKey.hashCode(), assetCacheKey2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetCacheKey assetCacheKey =
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Act and Assert
    assertEquals(assetCacheKey, assetCacheKey);
    int expectedHashCodeResult = assetCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, assetCacheKey.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetCacheKey assetCacheKey =
        AssetCacheKey.builder().name(null).tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Act and Assert
    assertNotEquals(
        assetCacheKey,
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetCacheKey assetCacheKey =
        AssetCacheKey.builder().name("42").tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Act and Assert
    assertNotEquals(
        assetCacheKey,
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetCacheKey assetCacheKey = AssetCacheKey.builder().name("Name").tenantId(null).build();

    // Act and Assert
    assertNotEquals(
        assetCacheKey,
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetCacheKey assetCacheKey =
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build();

    // Act and Assert
    assertNotEquals(assetCacheKey, AssetCacheKey.builder().name("Name").tenantId(null).build());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build(), null);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetCacheKey.equals(Object)", "int AssetCacheKey.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        AssetCacheKey.builder().name("Name").tenantId(ModelConstants.SYSTEM_TENANT).build(),
        "Different type to AssetCacheKey");
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080_Name", actualToStringResult);
    assertEquals("Name", actualName);
    assertSame(TenantId.SYS_TENANT_ID, actualAssetCacheKey.getTenantId());
  }
}
