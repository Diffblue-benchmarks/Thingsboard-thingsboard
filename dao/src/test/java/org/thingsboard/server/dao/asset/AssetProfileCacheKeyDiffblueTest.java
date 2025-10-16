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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class AssetProfileCacheKeyDiffblueTest {
  /**
   * Test {@link AssetProfileCacheKey#forName(TenantId, String)}.
   *
   * <p>Method under test: {@link AssetProfileCacheKey#forName(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfileCacheKey AssetProfileCacheKey.forName(TenantId, String)"})
  public void testForName() {
    // Arrange and Act
    AssetProfileCacheKey actualForNameResult =
        AssetProfileCacheKey.forName(ModelConstants.SYSTEM_TENANT, "Name");

    // Assert
    assertEquals("Name", actualForNameResult.getName());
    assertNull(actualForNameResult.getAssetProfileId());
    assertFalse(actualForNameResult.isDefaultProfile());
    assertFalse(actualForNameResult.isVersioned());
    assertSame(TenantId.SYS_TENANT_ID, actualForNameResult.getTenantId());
  }

  /**
   * Test {@link AssetProfileCacheKey#forId(AssetProfileId)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#forId(AssetProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfileCacheKey AssetProfileCacheKey.forId(AssetProfileId)"})
  public void testForId_whenNull_thenReturnNameIsNull() {
    // Arrange and Act
    AssetProfileCacheKey actualForIdResult = AssetProfileCacheKey.forId(null);

    // Assert
    assertNull(actualForIdResult.getName());
    assertNull(actualForIdResult.getAssetProfileId());
    assertNull(actualForIdResult.getTenantId());
    assertFalse(actualForIdResult.isDefaultProfile());
    assertFalse(actualForIdResult.isVersioned());
  }

  /**
   * Test {@link AssetProfileCacheKey#forDefaultProfile(TenantId)}.
   *
   * <p>Method under test: {@link AssetProfileCacheKey#forDefaultProfile(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfileCacheKey AssetProfileCacheKey.forDefaultProfile(TenantId)"})
  public void testForDefaultProfile() {
    // Arrange and Act
    AssetProfileCacheKey actualForDefaultProfileResult =
        AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT);

    // Assert
    assertNull(actualForDefaultProfileResult.getName());
    assertNull(actualForDefaultProfileResult.getAssetProfileId());
    assertFalse(actualForDefaultProfileResult.isVersioned());
    assertTrue(actualForDefaultProfileResult.isDefaultProfile());
    assertSame(TenantId.SYS_TENANT_ID, actualForDefaultProfileResult.getTenantId());
  }

  /**
   * Test {@link AssetProfileCacheKey#toString()}.
   *
   * <ul>
   *   <li>Given forDefaultProfile {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AssetProfileCacheKey.toString()"})
  public void testToString_givenForDefaultProfileSystem_tenant() {
    // Arrange, Act and Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT).toString());
  }

  /**
   * Test {@link AssetProfileCacheKey#toString()}.
   *
   * <ul>
   *   <li>Given forId {@link AssetProfileId#AssetProfileId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AssetProfileCacheKey.toString()"})
  public void testToString_givenForIdAssetProfileIdWithIdIsNull_uuid() {
    // Arrange, Act and Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        AssetProfileCacheKey.forId(new AssetProfileId(ModelConstants.NULL_UUID)).toString());
  }

  /**
   * Test {@link AssetProfileCacheKey#toString()}.
   *
   * <ul>
   *   <li>Then return {@code 13814000-1dd2-11b2-8080-808080808080_Name}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AssetProfileCacheKey.toString()"})
  public void testToString_thenReturn138140001dd211b28080808080808080Name() {
    // Arrange, Act and Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080_Name",
        AssetProfileCacheKey.forName(ModelConstants.SYSTEM_TENANT, "Name").toString());
  }

  /**
   * Test {@link AssetProfileCacheKey#isVersioned()}.
   *
   * <ul>
   *   <li>Given forDefaultProfile {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#isVersioned()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetProfileCacheKey.isVersioned()"})
  public void testIsVersioned_givenForDefaultProfileSystem_tenant_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT).isVersioned());
  }

  /**
   * Test {@link AssetProfileCacheKey#isVersioned()}.
   *
   * <ul>
   *   <li>Given forId {@link AssetProfileId#AssetProfileId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#isVersioned()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetProfileCacheKey.isVersioned()"})
  public void testIsVersioned_givenForIdAssetProfileIdWithIdIsNull_uuid_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        AssetProfileCacheKey.forId(new AssetProfileId(ModelConstants.NULL_UUID)).isVersioned());
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}, and {@link AssetProfileCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetProfileCacheKey#equals(Object)}
   *   <li>{@link AssetProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileCacheKey.equals(Object)",
    "int AssetProfileCacheKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetProfileCacheKey forDefaultProfileResult =
        AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT);
    AssetProfileCacheKey forDefaultProfileResult2 =
        AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertEquals(forDefaultProfileResult, forDefaultProfileResult2);
    assertEquals(forDefaultProfileResult.hashCode(), forDefaultProfileResult2.hashCode());
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}, and {@link AssetProfileCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetProfileCacheKey#equals(Object)}
   *   <li>{@link AssetProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileCacheKey.equals(Object)",
    "int AssetProfileCacheKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AssetProfileCacheKey forNameResult =
        AssetProfileCacheKey.forName(ModelConstants.SYSTEM_TENANT, "Name");
    AssetProfileCacheKey forNameResult2 =
        AssetProfileCacheKey.forName(ModelConstants.SYSTEM_TENANT, "Name");

    // Act and Assert
    assertEquals(forNameResult, forNameResult2);
    assertEquals(forNameResult.hashCode(), forNameResult2.hashCode());
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}, and {@link AssetProfileCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetProfileCacheKey#equals(Object)}
   *   <li>{@link AssetProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileCacheKey.equals(Object)",
    "int AssetProfileCacheKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AssetProfileCacheKey forDefaultProfileResult = AssetProfileCacheKey.forDefaultProfile(null);
    AssetProfileCacheKey forDefaultProfileResult2 = AssetProfileCacheKey.forDefaultProfile(null);

    // Act and Assert
    assertEquals(forDefaultProfileResult, forDefaultProfileResult2);
    assertEquals(forDefaultProfileResult.hashCode(), forDefaultProfileResult2.hashCode());
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}, and {@link AssetProfileCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetProfileCacheKey#equals(Object)}
   *   <li>{@link AssetProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileCacheKey.equals(Object)",
    "int AssetProfileCacheKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetProfileCacheKey forDefaultProfileResult =
        AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertEquals(forDefaultProfileResult, forDefaultProfileResult);
    int expectedHashCodeResult = forDefaultProfileResult.hashCode();
    assertEquals(expectedHashCodeResult, forDefaultProfileResult.hashCode());
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileCacheKey.equals(Object)",
    "int AssetProfileCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetProfileCacheKey forNameResult =
        AssetProfileCacheKey.forName(ModelConstants.SYSTEM_TENANT, "Name");

    // Act and Assert
    assertNotEquals(
        forNameResult, AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT));
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileCacheKey.equals(Object)",
    "int AssetProfileCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetProfileCacheKey forDefaultProfileResult = AssetProfileCacheKey.forDefaultProfile(null);

    // Act and Assert
    assertNotEquals(
        forDefaultProfileResult,
        AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT));
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileCacheKey.equals(Object)",
    "int AssetProfileCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetProfileCacheKey forDefaultProfileResult =
        AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertNotEquals(forDefaultProfileResult, AssetProfileCacheKey.forDefaultProfile(null));
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileCacheKey.equals(Object)",
    "int AssetProfileCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetProfileCacheKey forNameResult =
        AssetProfileCacheKey.forName(ModelConstants.SYSTEM_TENANT, null);

    // Act and Assert
    assertNotEquals(
        forNameResult, AssetProfileCacheKey.forName(ModelConstants.SYSTEM_TENANT, "Name"));
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileCacheKey.equals(Object)",
    "int AssetProfileCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AssetProfileCacheKey forNameResult =
        AssetProfileCacheKey.forName(
            ModelConstants.SYSTEM_TENANT, "org.thingsboard.server.dao.asset.AssetProfileCacheKey");

    // Act and Assert
    assertNotEquals(
        forNameResult, AssetProfileCacheKey.forName(ModelConstants.SYSTEM_TENANT, "Name"));
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileCacheKey.equals(Object)",
    "int AssetProfileCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT), null);
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileCacheKey.equals(Object)",
    "int AssetProfileCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT),
        "Different type to AssetProfileCacheKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetProfileCacheKey#getAssetProfileId()}
   *   <li>{@link AssetProfileCacheKey#getName()}
   *   <li>{@link AssetProfileCacheKey#getTenantId()}
   *   <li>{@link AssetProfileCacheKey#isDefaultProfile()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssetProfileId AssetProfileCacheKey.getAssetProfileId()",
    "String AssetProfileCacheKey.getName()",
    "TenantId AssetProfileCacheKey.getTenantId()",
    "boolean AssetProfileCacheKey.isDefaultProfile()"
  })
  public void testGettersAndSetters() {
    // Arrange
    AssetProfileCacheKey forDefaultProfileResult =
        AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT);

    // Act
    AssetProfileId actualAssetProfileId = forDefaultProfileResult.getAssetProfileId();
    String actualName = forDefaultProfileResult.getName();
    TenantId actualTenantId = forDefaultProfileResult.getTenantId();

    // Assert
    assertNull(actualName);
    assertNull(actualAssetProfileId);
    assertTrue(forDefaultProfileResult.isDefaultProfile());
    assertSame(TenantId.SYS_TENANT_ID, actualTenantId);
  }
}
