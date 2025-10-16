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
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class AssetProfileEntityDiffblueTest {
  /**
   * Test {@link AssetProfileEntity#equals(Object)}, and {@link AssetProfileEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetProfileEntity#equals(Object)}
   *   <li>{@link AssetProfileEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(assetProfileEntity, assetProfileEntity2);
    assertEquals(assetProfileEntity.hashCode(), assetProfileEntity2.hashCode());
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}, and {@link AssetProfileEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetProfileEntity#equals(Object)}
   *   <li>{@link AssetProfileEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(null);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(null);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(assetProfileEntity, assetProfileEntity2);
    assertEquals(assetProfileEntity.hashCode(), assetProfileEntity2.hashCode());
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}, and {@link AssetProfileEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetProfileEntity#equals(Object)}
   *   <li>{@link AssetProfileEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(null);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(null);
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(assetProfileEntity, assetProfileEntity2);
    assertEquals(assetProfileEntity.hashCode(), assetProfileEntity2.hashCode());
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}, and {@link AssetProfileEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetProfileEntity#equals(Object)}
   *   <li>{@link AssetProfileEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName(null);
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName(null);
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(assetProfileEntity, assetProfileEntity2);
    assertEquals(assetProfileEntity.hashCode(), assetProfileEntity2.hashCode());
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}, and {@link AssetProfileEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetProfileEntity#equals(Object)}
   *   <li>{@link AssetProfileEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    // Act and Assert
    assertEquals(assetProfileEntity, assetProfileEntity);
    int expectedHashCodeResult = assetProfileEntity.hashCode();
    assertEquals(expectedHashCodeResult, assetProfileEntity.hashCode());
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(3L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(false);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(UUID.randomUUID());
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(null);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(UUID.randomUUID());
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(null);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName(null);
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(UUID.randomUUID());
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(null);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("Name");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription(null);
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(UUID.randomUUID());
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(null);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Name");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage(null);
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Image");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName(null);
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.randomUUID());
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(null);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(1L);
    assetProfileEntity2.setDefault(true);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName("Default Queue Name");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("The characteristics of someone or something");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("Image");
    assetProfileEntity2.setName("Name");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, assetProfileEntity2);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, null);
  }

  /**
   * Test {@link AssetProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileEntity.equals(Object)",
    "int AssetProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetProfileEntity, "Different type to AssetProfileEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetProfileEntity#AssetProfileEntity()}
   *   <li>{@link AssetProfileEntity#setDefault(boolean)}
   *   <li>{@link AssetProfileEntity#setDefaultDashboardId(UUID)}
   *   <li>{@link AssetProfileEntity#setDefaultEdgeRuleChainId(UUID)}
   *   <li>{@link AssetProfileEntity#setDefaultQueueName(String)}
   *   <li>{@link AssetProfileEntity#setDefaultRuleChainId(UUID)}
   *   <li>{@link AssetProfileEntity#setDescription(String)}
   *   <li>{@link AssetProfileEntity#setExternalId(UUID)}
   *   <li>{@link AssetProfileEntity#setImage(String)}
   *   <li>{@link AssetProfileEntity#setName(String)}
   *   <li>{@link AssetProfileEntity#setTenantId(UUID)}
   *   <li>{@link AssetProfileEntity#toString()}
   *   <li>{@link AssetProfileEntity#getDefaultDashboardId()}
   *   <li>{@link AssetProfileEntity#getDefaultEdgeRuleChainId()}
   *   <li>{@link AssetProfileEntity#getDefaultQueueName()}
   *   <li>{@link AssetProfileEntity#getDefaultRuleChainId()}
   *   <li>{@link AssetProfileEntity#getDescription()}
   *   <li>{@link AssetProfileEntity#getExternalId()}
   *   <li>{@link AssetProfileEntity#getImage()}
   *   <li>{@link AssetProfileEntity#getName()}
   *   <li>{@link AssetProfileEntity#getTenantId()}
   *   <li>{@link AssetProfileEntity#isDefault()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AssetProfileEntity.<init>()",
    "UUID AssetProfileEntity.getDefaultDashboardId()",
    "UUID AssetProfileEntity.getDefaultEdgeRuleChainId()",
    "String AssetProfileEntity.getDefaultQueueName()",
    "UUID AssetProfileEntity.getDefaultRuleChainId()",
    "String AssetProfileEntity.getDescription()",
    "UUID AssetProfileEntity.getExternalId()",
    "String AssetProfileEntity.getImage()",
    "String AssetProfileEntity.getName()",
    "UUID AssetProfileEntity.getTenantId()",
    "boolean AssetProfileEntity.isDefault()",
    "void AssetProfileEntity.setDefault(boolean)",
    "void AssetProfileEntity.setDefaultDashboardId(UUID)",
    "void AssetProfileEntity.setDefaultEdgeRuleChainId(UUID)",
    "void AssetProfileEntity.setDefaultQueueName(String)",
    "void AssetProfileEntity.setDefaultRuleChainId(UUID)",
    "void AssetProfileEntity.setDescription(String)",
    "void AssetProfileEntity.setExternalId(UUID)",
    "void AssetProfileEntity.setImage(String)",
    "void AssetProfileEntity.setName(String)",
    "void AssetProfileEntity.setTenantId(UUID)",
    "String AssetProfileEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    AssetProfileEntity actualAssetProfileEntity = new AssetProfileEntity();
    actualAssetProfileEntity.setDefault(true);
    actualAssetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    actualAssetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    actualAssetProfileEntity.setDefaultQueueName("Default Queue Name");
    actualAssetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    actualAssetProfileEntity.setDescription("The characteristics of someone or something");
    actualAssetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    actualAssetProfileEntity.setImage("Image");
    actualAssetProfileEntity.setName("Name");
    UUID tenantId = ModelConstants.NULL_UUID;
    actualAssetProfileEntity.setTenantId(tenantId);
    String actualToStringResult = actualAssetProfileEntity.toString();
    UUID actualDefaultDashboardId = actualAssetProfileEntity.getDefaultDashboardId();
    UUID actualDefaultEdgeRuleChainId = actualAssetProfileEntity.getDefaultEdgeRuleChainId();
    String actualDefaultQueueName = actualAssetProfileEntity.getDefaultQueueName();
    UUID actualDefaultRuleChainId = actualAssetProfileEntity.getDefaultRuleChainId();
    String actualDescription = actualAssetProfileEntity.getDescription();
    UUID actualExternalId = actualAssetProfileEntity.getExternalId();
    String actualImage = actualAssetProfileEntity.getImage();
    String actualName = actualAssetProfileEntity.getName();
    UUID actualTenantId = actualAssetProfileEntity.getTenantId();
    boolean actualIsDefaultResult = actualAssetProfileEntity.isDefault();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDefaultDashboardId.toString());
    assertEquals(
        "AssetProfileEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, name=Name, image=Image, description=The"
            + " characteristics of someone or something, isDefault=true, defaultRuleChainId=13814000-1dd2-11b2-8080"
            + "-808080808080, defaultDashboardId=13814000-1dd2-11b2-8080-808080808080, defaultQueueName=Default Queue"
            + " Name, defaultEdgeRuleChainId=13814000-1dd2-11b2-8080-808080808080, externalId=13814000-1dd2-11b2-8080"
            + "-808080808080)",
        actualToStringResult);
    assertEquals("Default Queue Name", actualDefaultQueueName);
    assertEquals("Image", actualImage);
    assertEquals("Name", actualName);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertNull(actualAssetProfileEntity.getVersion());
    assertNull(actualAssetProfileEntity.getId());
    assertNull(actualAssetProfileEntity.getUuid());
    assertEquals(0L, actualAssetProfileEntity.getCreatedTime());
    assertTrue(actualIsDefaultResult);
    assertSame(tenantId, actualDefaultDashboardId);
    assertSame(tenantId, actualDefaultEdgeRuleChainId);
    assertSame(tenantId, actualDefaultRuleChainId);
    assertSame(tenantId, actualExternalId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link AssetProfileEntity#AssetProfileEntity(AssetProfile)}.
   *
   * <p>Method under test: {@link AssetProfileEntity#AssetProfileEntity(AssetProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileEntity.<init>(AssetProfile)"})
  public void testNewAssetProfileEntity() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile(new AssetProfile());
    assetProfile.setTenantId(null);
    assetProfile.setDefaultRuleChainId(null);
    assetProfile.setDefaultDashboardId(null);
    assetProfile.setDefaultEdgeRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));
    assetProfile.setExternalId(null);

    // Act
    AssetProfileEntity actualAssetProfileEntity = new AssetProfileEntity(assetProfile);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualAssetProfileEntity.getDefaultEdgeRuleChainId().toString());
    assertNull(actualAssetProfileEntity.getDefaultDashboardId());
    assertNull(actualAssetProfileEntity.getDefaultRuleChainId());
    assertNull(actualAssetProfileEntity.getExternalId());
    assertNull(actualAssetProfileEntity.getTenantId());
  }

  /**
   * Test {@link AssetProfileEntity#AssetProfileEntity(AssetProfile)}.
   *
   * <p>Method under test: {@link AssetProfileEntity#AssetProfileEntity(AssetProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileEntity.<init>(AssetProfile)"})
  public void testNewAssetProfileEntity2() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile(new AssetProfile());
    assetProfile.setTenantId(null);
    assetProfile.setDefaultRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));
    assetProfile.setDefaultDashboardId(null);
    assetProfile.setDefaultEdgeRuleChainId(null);
    assetProfile.setExternalId(null);

    // Act
    AssetProfileEntity actualAssetProfileEntity = new AssetProfileEntity(assetProfile);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualAssetProfileEntity.getDefaultRuleChainId().toString());
    assertNull(actualAssetProfileEntity.getDefaultDashboardId());
    assertNull(actualAssetProfileEntity.getDefaultEdgeRuleChainId());
    assertNull(actualAssetProfileEntity.getExternalId());
    assertNull(actualAssetProfileEntity.getTenantId());
  }

  /**
   * Test {@link AssetProfileEntity#AssetProfileEntity(AssetProfile)}.
   *
   * <p>Method under test: {@link AssetProfileEntity#AssetProfileEntity(AssetProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileEntity.<init>(AssetProfile)"})
  public void testNewAssetProfileEntity3() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile(new AssetProfile());
    assetProfile.setTenantId(ModelConstants.SYSTEM_TENANT);
    assetProfile.setDefaultRuleChainId(null);
    assetProfile.setDefaultDashboardId(null);
    assetProfile.setDefaultEdgeRuleChainId(null);
    assetProfile.setExternalId(null);

    // Act
    AssetProfileEntity actualAssetProfileEntity = new AssetProfileEntity(assetProfile);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualAssetProfileEntity.getTenantId().toString());
    assertNull(actualAssetProfileEntity.getDefaultDashboardId());
    assertNull(actualAssetProfileEntity.getDefaultEdgeRuleChainId());
    assertNull(actualAssetProfileEntity.getDefaultRuleChainId());
    assertNull(actualAssetProfileEntity.getExternalId());
  }

  /**
   * Test {@link AssetProfileEntity#AssetProfileEntity(AssetProfile)}.
   *
   * <p>Method under test: {@link AssetProfileEntity#AssetProfileEntity(AssetProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileEntity.<init>(AssetProfile)"})
  public void testNewAssetProfileEntity4() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile(new AssetProfile());
    assetProfile.setTenantId(null);
    assetProfile.setDefaultRuleChainId(null);
    assetProfile.setDefaultDashboardId(new DashboardId(ModelConstants.NULL_UUID));
    assetProfile.setDefaultEdgeRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));
    assetProfile.setExternalId(null);

    // Act
    AssetProfileEntity actualAssetProfileEntity = new AssetProfileEntity(assetProfile);

    // Assert
    UUID defaultDashboardId = actualAssetProfileEntity.getDefaultDashboardId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", defaultDashboardId.toString());
    assertNull(actualAssetProfileEntity.getDefaultRuleChainId());
    assertNull(actualAssetProfileEntity.getExternalId());
    assertNull(actualAssetProfileEntity.getTenantId());
    assertSame(defaultDashboardId, actualAssetProfileEntity.getDefaultEdgeRuleChainId());
  }

  /**
   * Test {@link AssetProfileEntity#AssetProfileEntity(AssetProfile)}.
   *
   * <ul>
   *   <li>Then return ExternalId is DefaultEdgeRuleChainId.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#AssetProfileEntity(AssetProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileEntity.<init>(AssetProfile)"})
  public void testNewAssetProfileEntity_thenReturnExternalIdIsDefaultEdgeRuleChainId() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile(new AssetProfile());
    assetProfile.setTenantId(null);
    assetProfile.setDefaultRuleChainId(null);
    assetProfile.setDefaultDashboardId(null);
    assetProfile.setDefaultEdgeRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));
    assetProfile.setExternalId(new AssetProfileId(ModelConstants.NULL_UUID));

    // Act
    AssetProfileEntity actualAssetProfileEntity = new AssetProfileEntity(assetProfile);

    // Assert
    UUID defaultEdgeRuleChainId = actualAssetProfileEntity.getDefaultEdgeRuleChainId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", defaultEdgeRuleChainId.toString());
    assertNull(actualAssetProfileEntity.getDefaultDashboardId());
    assertNull(actualAssetProfileEntity.getDefaultRuleChainId());
    assertNull(actualAssetProfileEntity.getTenantId());
    assertSame(defaultEdgeRuleChainId, actualAssetProfileEntity.getExternalId());
  }

  /**
   * Test {@link AssetProfileEntity#AssetProfileEntity(AssetProfile)}.
   *
   * <ul>
   *   <li>When {@link AssetProfile#AssetProfile()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#AssetProfileEntity(AssetProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileEntity.<init>(AssetProfile)"})
  public void testNewAssetProfileEntity_whenAssetProfile() {
    // Arrange and Act
    AssetProfileEntity actualAssetProfileEntity = new AssetProfileEntity(new AssetProfile());

    // Assert
    assertNull(actualAssetProfileEntity.getDefaultDashboardId());
    assertNull(actualAssetProfileEntity.getDefaultEdgeRuleChainId());
    assertNull(actualAssetProfileEntity.getDefaultRuleChainId());
    assertNull(actualAssetProfileEntity.getExternalId());
    assertNull(actualAssetProfileEntity.getTenantId());
  }

  /**
   * Test {@link AssetProfileEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AssetProfileEntity#AssetProfileEntity()}.
   *   <li>Then return Version is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile AssetProfileEntity.toData()"})
  public void testToData_givenAssetProfileEntity_thenReturnVersionIsNull() {
    // Arrange and Act
    AssetProfile actualToDataResult = new AssetProfileEntity().toData();

    // Assert
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getDefaultQueueName());
    assertNull(actualToDataResult.getDescription());
    assertNull(actualToDataResult.getImage());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getUuidId());
    AssetProfileId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isDefault());
    assertFalse(id.isNullUid());
  }

  /**
   * Test {@link AssetProfileEntity#toData()}.
   *
   * <ul>
   *   <li>Then return DefaultDashboardId EntityType is {@code DASHBOARD}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile AssetProfileEntity.toData()"})
  public void testToData_thenReturnDefaultDashboardIdEntityTypeIsDashboard() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    assetProfileEntity.setTenantId(null);
    assetProfileEntity.setDefaultRuleChainId(null);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(null);
    assetProfileEntity.setExternalId(null);

    // Act
    AssetProfile actualToDataResult = assetProfileEntity.toData();

    // Assert
    DashboardId defaultDashboardId = actualToDataResult.getDefaultDashboardId();
    assertEquals(EntityType.DASHBOARD, defaultDashboardId.getEntityType());
    assertTrue(defaultDashboardId.isNullUid());
    assertTrue(actualToDataResult.getId().isNullUid());
  }

  /**
   * Test {@link AssetProfileEntity#toData()}.
   *
   * <ul>
   *   <li>Then return DefaultEdgeRuleChainId EntityType is {@code RULE_CHAIN}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile AssetProfileEntity.toData()"})
  public void testToData_thenReturnDefaultEdgeRuleChainIdEntityTypeIsRuleChain() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    assetProfileEntity.setTenantId(null);
    assetProfileEntity.setDefaultRuleChainId(null);
    assetProfileEntity.setDefaultDashboardId(null);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setExternalId(null);

    // Act
    AssetProfile actualToDataResult = assetProfileEntity.toData();

    // Assert
    RuleChainId defaultEdgeRuleChainId = actualToDataResult.getDefaultEdgeRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, defaultEdgeRuleChainId.getEntityType());
    assertTrue(defaultEdgeRuleChainId.isNullUid());
    assertTrue(actualToDataResult.getId().isNullUid());
  }

  /**
   * Test {@link AssetProfileEntity#toData()}.
   *
   * <ul>
   *   <li>Then return DefaultRuleChainId EntityType is {@code RULE_CHAIN}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile AssetProfileEntity.toData()"})
  public void testToData_thenReturnDefaultRuleChainIdEntityTypeIsRuleChain() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    assetProfileEntity.setTenantId(null);
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultDashboardId(null);
    assetProfileEntity.setDefaultEdgeRuleChainId(null);
    assetProfileEntity.setExternalId(null);

    // Act
    AssetProfile actualToDataResult = assetProfileEntity.toData();

    // Assert
    RuleChainId defaultRuleChainId = actualToDataResult.getDefaultRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, defaultRuleChainId.getEntityType());
    assertTrue(defaultRuleChainId.isNullUid());
    assertTrue(actualToDataResult.getId().isNullUid());
  }

  /**
   * Test {@link AssetProfileEntity#toData()}.
   *
   * <ul>
   *   <li>Then return ExternalId EntityType is {@code ASSET_PROFILE}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile AssetProfileEntity.toData()"})
  public void testToData_thenReturnExternalIdEntityTypeIsAssetProfile() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    assetProfileEntity.setTenantId(null);
    assetProfileEntity.setDefaultRuleChainId(null);
    assetProfileEntity.setDefaultDashboardId(null);
    assetProfileEntity.setDefaultEdgeRuleChainId(null);
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    AssetProfile actualToDataResult = assetProfileEntity.toData();

    // Assert
    AssetProfileId externalId = actualToDataResult.getExternalId();
    assertEquals(EntityType.ASSET_PROFILE, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, actualToDataResult.getId());
  }

  /**
   * Test {@link AssetProfileEntity#toData()}.
   *
   * <ul>
   *   <li>Then return not TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile AssetProfileEntity.toData()"})
  public void testToData_thenReturnNotTenantIdNullUid() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    UUID tenantId = UUID.randomUUID();
    assetProfileEntity.setTenantId(tenantId);
    assetProfileEntity.setDefaultRuleChainId(null);
    assetProfileEntity.setDefaultDashboardId(null);
    assetProfileEntity.setDefaultEdgeRuleChainId(null);
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    AssetProfile actualToDataResult = assetProfileEntity.toData();

    // Assert
    AssetProfileId externalId = actualToDataResult.getExternalId();
    assertEquals(EntityType.ASSET_PROFILE, externalId.getEntityType());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, actualToDataResult.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link AssetProfileEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile AssetProfileEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultRuleChainId(null);
    assetProfileEntity.setDefaultDashboardId(null);
    assetProfileEntity.setDefaultEdgeRuleChainId(null);
    assetProfileEntity.setExternalId(null);

    // Act and Assert
    TenantId tenantId = assetProfileEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
