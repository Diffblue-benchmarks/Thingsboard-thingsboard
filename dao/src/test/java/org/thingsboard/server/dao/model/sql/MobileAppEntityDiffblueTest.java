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
package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.MobileAppId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.mobile.MobileApp;
import org.thingsboard.server.dao.model.ModelConstants;

public class MobileAppEntityDiffblueTest {
  /**
   * Test {@link MobileAppEntity#equals(Object)}, and {@link MobileAppEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppEntity#equals(Object)}
   *   <li>{@link MobileAppEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(ModelConstants.NULL_UUID);
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(mobileAppEntity, mobileAppEntity2);
    assertEquals(mobileAppEntity.hashCode(), mobileAppEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}, and {@link MobileAppEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppEntity#equals(Object)}
   *   <li>{@link MobileAppEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret(null);
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(ModelConstants.NULL_UUID);
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret(null);
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(mobileAppEntity, mobileAppEntity2);
    assertEquals(mobileAppEntity.hashCode(), mobileAppEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}, and {@link MobileAppEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppEntity#equals(Object)}
   *   <li>{@link MobileAppEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(ModelConstants.NULL_UUID);
    mobileAppEntity.setOauth2Enabled(null);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setOauth2Enabled(null);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(mobileAppEntity, mobileAppEntity2);
    assertEquals(mobileAppEntity.hashCode(), mobileAppEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}, and {@link MobileAppEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppEntity#equals(Object)}
   *   <li>{@link MobileAppEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(ModelConstants.NULL_UUID);
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName(null);
    mobileAppEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName(null);
    mobileAppEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(mobileAppEntity, mobileAppEntity2);
    assertEquals(mobileAppEntity.hashCode(), mobileAppEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}, and {@link MobileAppEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppEntity#equals(Object)}
   *   <li>{@link MobileAppEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(ModelConstants.NULL_UUID);
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(null);
    mobileAppEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(null);
    mobileAppEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(mobileAppEntity, mobileAppEntity2);
    assertEquals(mobileAppEntity.hashCode(), mobileAppEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}, and {@link MobileAppEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppEntity#equals(Object)}
   *   <li>{@link MobileAppEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(ModelConstants.NULL_UUID);
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(mobileAppEntity, mobileAppEntity);
    int expectedHashCodeResult = mobileAppEntity.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppEntity.hashCode());
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("Pkg Name");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(ModelConstants.NULL_UUID);
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppEntity, mobileAppEntity2);
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret(null);
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(ModelConstants.NULL_UUID);
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppEntity, mobileAppEntity2);
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(3L);
    mobileAppEntity.setId(ModelConstants.NULL_UUID);
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppEntity, mobileAppEntity2);
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(ModelConstants.NULL_UUID);
    mobileAppEntity.setOauth2Enabled(false);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppEntity, mobileAppEntity2);
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(ModelConstants.NULL_UUID);
    mobileAppEntity.setOauth2Enabled(null);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppEntity, mobileAppEntity2);
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(ModelConstants.NULL_UUID);
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("App Secret");
    mobileAppEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppEntity, mobileAppEntity2);
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(ModelConstants.NULL_UUID);
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName(null);
    mobileAppEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppEntity, mobileAppEntity2);
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(ModelConstants.NULL_UUID);
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(UUID.randomUUID());
    mobileAppEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppEntity, mobileAppEntity2);
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(ModelConstants.NULL_UUID);
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(null);
    mobileAppEntity.setUuid(ModelConstants.NULL_UUID);

    MobileAppEntity mobileAppEntity2 = new MobileAppEntity();
    mobileAppEntity2.setAppSecret("App Secret");
    mobileAppEntity2.setCreatedTime(1L);
    mobileAppEntity2.setId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setOauth2Enabled(true);
    mobileAppEntity2.setPkgName("Pkg Name");
    mobileAppEntity2.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppEntity, mobileAppEntity2);
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(ModelConstants.NULL_UUID);
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppEntity, null);
  }

  /**
   * Test {@link MobileAppEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileAppEntity.equals(Object)", "int MobileAppEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(ModelConstants.NULL_UUID);
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setTenantId(ModelConstants.NULL_UUID);
    mobileAppEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppEntity, "Different type to MobileAppEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppEntity#MobileAppEntity()}
   *   <li>{@link MobileAppEntity#setAppSecret(String)}
   *   <li>{@link MobileAppEntity#setOauth2Enabled(Boolean)}
   *   <li>{@link MobileAppEntity#setPkgName(String)}
   *   <li>{@link MobileAppEntity#setTenantId(UUID)}
   *   <li>{@link MobileAppEntity#toString()}
   *   <li>{@link MobileAppEntity#getAppSecret()}
   *   <li>{@link MobileAppEntity#getOauth2Enabled()}
   *   <li>{@link MobileAppEntity#getPkgName()}
   *   <li>{@link MobileAppEntity#getTenantId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MobileAppEntity.<init>()",
    "String MobileAppEntity.getAppSecret()",
    "Boolean MobileAppEntity.getOauth2Enabled()",
    "String MobileAppEntity.getPkgName()",
    "UUID MobileAppEntity.getTenantId()",
    "void MobileAppEntity.setAppSecret(String)",
    "void MobileAppEntity.setOauth2Enabled(Boolean)",
    "void MobileAppEntity.setPkgName(String)",
    "void MobileAppEntity.setTenantId(UUID)",
    "String MobileAppEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    MobileAppEntity actualMobileAppEntity = new MobileAppEntity();
    actualMobileAppEntity.setAppSecret("App Secret");
    actualMobileAppEntity.setOauth2Enabled(true);
    actualMobileAppEntity.setPkgName("Pkg Name");
    UUID tenantId = ModelConstants.NULL_UUID;
    actualMobileAppEntity.setTenantId(tenantId);
    String actualToStringResult = actualMobileAppEntity.toString();
    String actualAppSecret = actualMobileAppEntity.getAppSecret();
    Boolean actualOauth2Enabled = actualMobileAppEntity.getOauth2Enabled();
    String actualPkgName = actualMobileAppEntity.getPkgName();
    UUID actualTenantId = actualMobileAppEntity.getTenantId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTenantId.toString());
    assertEquals("App Secret", actualAppSecret);
    assertEquals(
        "MobileAppEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, pkgName=Pkg Name, appSecret=App Secret,"
            + " oauth2Enabled=true)",
        actualToStringResult);
    assertEquals("Pkg Name", actualPkgName);
    assertNull(actualMobileAppEntity.getId());
    assertNull(actualMobileAppEntity.getUuid());
    assertEquals(0L, actualMobileAppEntity.getCreatedTime());
    assertTrue(actualOauth2Enabled);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link MobileAppEntity#MobileAppEntity(MobileApp)}.
   *
   * <p>Method under test: {@link MobileAppEntity#MobileAppEntity(MobileApp)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MobileAppEntity.<init>(MobileApp)"})
  public void testNewMobileAppEntity() {
    // Arrange
    MobileApp mobile = new MobileApp();
    mobile.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    MobileAppEntity actualMobileAppEntity = new MobileAppEntity(mobile);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualMobileAppEntity.getTenantId().toString());
    assertNull(actualMobileAppEntity.getAppSecret());
    assertNull(actualMobileAppEntity.getPkgName());
    assertNull(actualMobileAppEntity.getId());
    assertNull(actualMobileAppEntity.getUuid());
    assertEquals(0L, actualMobileAppEntity.getCreatedTime());
    assertFalse(actualMobileAppEntity.getOauth2Enabled());
  }

  /**
   * Test {@link MobileAppEntity#MobileAppEntity(MobileApp)}.
   *
   * <ul>
   *   <li>When {@link MobileApp#MobileApp()}.
   *   <li>Then return TenantId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#MobileAppEntity(MobileApp)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MobileAppEntity.<init>(MobileApp)"})
  public void testNewMobileAppEntity_whenMobileApp_thenReturnTenantIdIsNull() {
    // Arrange and Act
    MobileAppEntity actualMobileAppEntity = new MobileAppEntity(new MobileApp());

    // Assert
    assertNull(actualMobileAppEntity.getAppSecret());
    assertNull(actualMobileAppEntity.getPkgName());
    assertNull(actualMobileAppEntity.getId());
    assertNull(actualMobileAppEntity.getUuid());
    assertNull(actualMobileAppEntity.getTenantId());
    assertEquals(0L, actualMobileAppEntity.getCreatedTime());
    assertFalse(actualMobileAppEntity.getOauth2Enabled());
  }

  /**
   * Test {@link MobileAppEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link MobileAppEntity#MobileAppEntity()} TenantId is randomUUID.
   *   <li>Then return not TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MobileApp MobileAppEntity.toData()"})
  public void testToData_givenMobileAppEntityTenantIdIsRandomUUID_thenReturnNotTenantIdNullUid() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(ModelConstants.NULL_UUID);
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setUuid(ModelConstants.NULL_UUID);
    UUID tenantId = UUID.randomUUID();
    mobileAppEntity.setTenantId(tenantId);

    // Act and Assert
    TenantId tenantId2 = mobileAppEntity.toData().getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link MobileAppEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MobileApp MobileAppEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(ModelConstants.NULL_UUID);
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setUuid(ModelConstants.NULL_UUID);
    mobileAppEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    TenantId tenantId = mobileAppEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link MobileAppEntity#toData()}.
   *
   * <ul>
   *   <li>Then return UuidId toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MobileApp MobileAppEntity.toData()"})
  public void testToData_thenReturnUuidIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    MobileAppEntity mobileAppEntity = new MobileAppEntity();
    mobileAppEntity.setAppSecret("App Secret");
    mobileAppEntity.setCreatedTime(1L);
    mobileAppEntity.setId(ModelConstants.NULL_UUID);
    mobileAppEntity.setOauth2Enabled(true);
    mobileAppEntity.setPkgName("Pkg Name");
    mobileAppEntity.setUuid(ModelConstants.NULL_UUID);
    mobileAppEntity.setTenantId(null);

    // Act
    MobileApp actualToDataResult = mobileAppEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("App Secret", actualToDataResult.getAppSecret());
    assertEquals("Pkg Name", actualToDataResult.getName());
    assertEquals("Pkg Name", actualToDataResult.getPkgName());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    MobileAppId id = actualToDataResult.getId();
    assertEquals(EntityType.MOBILE_APP, id.getEntityType());
    assertTrue(id.isNullUid());
    assertTrue(actualToDataResult.isOauth2Enabled());
    assertSame(uuidId, id.getId());
  }
}
