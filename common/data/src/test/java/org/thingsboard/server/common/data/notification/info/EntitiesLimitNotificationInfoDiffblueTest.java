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
package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.info.EntitiesLimitNotificationInfo.EntitiesLimitNotificationInfoBuilder;

@ContextConfiguration(classes = {EntitiesLimitNotificationInfoBuilder.class})
@ExtendWith(SpringExtension.class)
class EntitiesLimitNotificationInfoDiffblueTest {
  @Autowired private EntitiesLimitNotificationInfoBuilder entitiesLimitNotificationInfoBuilder;

  /**
   * Test EntitiesLimitNotificationInfoBuilder {@link EntitiesLimitNotificationInfoBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesLimitNotificationInfoBuilder#build()}
   *   <li>{@link EntitiesLimitNotificationInfoBuilder#currentCount(long)}
   *   <li>{@link EntitiesLimitNotificationInfoBuilder#entityType(EntityType)}
   *   <li>{@link EntitiesLimitNotificationInfoBuilder#limit(long)}
   *   <li>{@link EntitiesLimitNotificationInfoBuilder#percents(int)}
   *   <li>{@link EntitiesLimitNotificationInfoBuilder#tenantId(TenantId)}
   *   <li>{@link EntitiesLimitNotificationInfoBuilder#tenantName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test EntitiesLimitNotificationInfoBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntitiesLimitNotificationInfoBuilder.<init>()",
    "EntitiesLimitNotificationInfo EntitiesLimitNotificationInfoBuilder.build()",
    "EntitiesLimitNotificationInfoBuilder EntitiesLimitNotificationInfoBuilder.currentCount(long)",
    "EntitiesLimitNotificationInfoBuilder EntitiesLimitNotificationInfoBuilder.entityType(EntityType)",
    "EntitiesLimitNotificationInfoBuilder EntitiesLimitNotificationInfoBuilder.limit(long)",
    "EntitiesLimitNotificationInfoBuilder EntitiesLimitNotificationInfoBuilder.percents(int)",
    "EntitiesLimitNotificationInfoBuilder EntitiesLimitNotificationInfoBuilder.tenantId(TenantId)",
    "EntitiesLimitNotificationInfoBuilder EntitiesLimitNotificationInfoBuilder.tenantName(String)",
    "String EntitiesLimitNotificationInfoBuilder.toString()"
  })
  void testEntitiesLimitNotificationInfoBuilderBuild() {
    // Arrange and Act
    EntitiesLimitNotificationInfo actualEntitiesLimitNotificationInfo =
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Assert
    Map<String, String> templateData = actualEntitiesLimitNotificationInfo.getTemplateData();
    assertEquals(6, templateData.size());
    assertEquals("1", templateData.get("limit"));
    assertEquals("1", templateData.get("percents"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateData.get("tenantId"));
    assertEquals("3", templateData.get("currentCount"));
    assertEquals("Tenant Name", templateData.get("tenantName"));
    assertEquals("Tenant Name", actualEntitiesLimitNotificationInfo.getTenantName());
    assertEquals("Tenant", templateData.get("entityType"));
    assertNull(actualEntitiesLimitNotificationInfo.getAffectedCustomerId());
    assertNull(actualEntitiesLimitNotificationInfo.getDashboardId());
    assertNull(actualEntitiesLimitNotificationInfo.getStateEntityId());
    assertNull(actualEntitiesLimitNotificationInfo.getAffectedUserId());
    assertEquals(1, actualEntitiesLimitNotificationInfo.getPercents());
    assertEquals(1L, actualEntitiesLimitNotificationInfo.getLimit());
    assertEquals(3L, actualEntitiesLimitNotificationInfo.getCurrentCount());
    assertEquals(EntityType.TENANT, actualEntitiesLimitNotificationInfo.getEntityType());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualEntitiesLimitNotificationInfo.getAffectedTenantId());
    assertSame(tenantId, actualEntitiesLimitNotificationInfo.getTenantId());
  }

  /**
   * Test {@link EntitiesLimitNotificationInfo#getTemplateData()}.
   *
   * <ul>
   *   <li>Then return size is six.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return size is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntitiesLimitNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnSizeIsSix() {
    // Arrange and Act
    Map<String, String> actualTemplateData =
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build()
            .getTemplateData();

    // Assert
    assertEquals(6, actualTemplateData.size());
    assertEquals("1", actualTemplateData.get("limit"));
    assertEquals("1", actualTemplateData.get("percents"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("tenantId"));
    assertEquals("3", actualTemplateData.get("currentCount"));
    assertEquals("Tenant Name", actualTemplateData.get("tenantName"));
    assertEquals("Tenant", actualTemplateData.get("entityType"));
  }

  /**
   * Test {@link EntitiesLimitNotificationInfo#equals(Object)}, and {@link
   * EntitiesLimitNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesLimitNotificationInfo#equals(Object)}
   *   <li>{@link EntitiesLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationInfo.equals(Object)",
    "int EntitiesLimitNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntitiesLimitNotificationInfo entitiesLimitNotificationInfo =
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();
    EntitiesLimitNotificationInfo entitiesLimitNotificationInfo2 =
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertEquals(entitiesLimitNotificationInfo, entitiesLimitNotificationInfo2);
    assertEquals(
        entitiesLimitNotificationInfo.hashCode(), entitiesLimitNotificationInfo2.hashCode());
  }

  /**
   * Test {@link EntitiesLimitNotificationInfo#equals(Object)}, and {@link
   * EntitiesLimitNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesLimitNotificationInfo#equals(Object)}
   *   <li>{@link EntitiesLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationInfo.equals(Object)",
    "int EntitiesLimitNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntitiesLimitNotificationInfo entitiesLimitNotificationInfo =
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(null)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();
    EntitiesLimitNotificationInfo entitiesLimitNotificationInfo2 =
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(null)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertEquals(entitiesLimitNotificationInfo, entitiesLimitNotificationInfo2);
    assertEquals(
        entitiesLimitNotificationInfo.hashCode(), entitiesLimitNotificationInfo2.hashCode());
  }

  /**
   * Test {@link EntitiesLimitNotificationInfo#equals(Object)}, and {@link
   * EntitiesLimitNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesLimitNotificationInfo#equals(Object)}
   *   <li>{@link EntitiesLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationInfo.equals(Object)",
    "int EntitiesLimitNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntitiesLimitNotificationInfo entitiesLimitNotificationInfo =
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(null)
            .tenantName("Tenant Name")
            .build();
    EntitiesLimitNotificationInfo entitiesLimitNotificationInfo2 =
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(null)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertEquals(entitiesLimitNotificationInfo, entitiesLimitNotificationInfo2);
    assertEquals(
        entitiesLimitNotificationInfo.hashCode(), entitiesLimitNotificationInfo2.hashCode());
  }

  /**
   * Test {@link EntitiesLimitNotificationInfo#equals(Object)}, and {@link
   * EntitiesLimitNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesLimitNotificationInfo#equals(Object)}
   *   <li>{@link EntitiesLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationInfo.equals(Object)",
    "int EntitiesLimitNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EntitiesLimitNotificationInfo entitiesLimitNotificationInfo =
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName(null)
            .build();
    EntitiesLimitNotificationInfo entitiesLimitNotificationInfo2 =
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName(null)
            .build();

    // Act and Assert
    assertEquals(entitiesLimitNotificationInfo, entitiesLimitNotificationInfo2);
    assertEquals(
        entitiesLimitNotificationInfo.hashCode(), entitiesLimitNotificationInfo2.hashCode());
  }

  /**
   * Test {@link EntitiesLimitNotificationInfo#equals(Object)}, and {@link
   * EntitiesLimitNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesLimitNotificationInfo#equals(Object)}
   *   <li>{@link EntitiesLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationInfo.equals(Object)",
    "int EntitiesLimitNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntitiesLimitNotificationInfo entitiesLimitNotificationInfo =
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertEquals(entitiesLimitNotificationInfo, entitiesLimitNotificationInfo);
    int expectedHashCodeResult = entitiesLimitNotificationInfo.hashCode();
    assertEquals(expectedHashCodeResult, entitiesLimitNotificationInfo.hashCode());
  }

  /**
   * Test {@link EntitiesLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationInfo.equals(Object)",
    "int EntitiesLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntitiesLimitNotificationInfo entitiesLimitNotificationInfo =
        EntitiesLimitNotificationInfo.builder()
            .currentCount(1L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        entitiesLimitNotificationInfo,
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link EntitiesLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationInfo.equals(Object)",
    "int EntitiesLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntitiesLimitNotificationInfo entitiesLimitNotificationInfo =
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(null)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        entitiesLimitNotificationInfo,
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link EntitiesLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationInfo.equals(Object)",
    "int EntitiesLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntitiesLimitNotificationInfo entitiesLimitNotificationInfo =
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.CUSTOMER)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        entitiesLimitNotificationInfo,
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link EntitiesLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationInfo.equals(Object)",
    "int EntitiesLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntitiesLimitNotificationInfo entitiesLimitNotificationInfo =
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(3L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        entitiesLimitNotificationInfo,
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link EntitiesLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationInfo.equals(Object)",
    "int EntitiesLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntitiesLimitNotificationInfo entitiesLimitNotificationInfo =
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(3)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        entitiesLimitNotificationInfo,
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link EntitiesLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationInfo.equals(Object)",
    "int EntitiesLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntitiesLimitNotificationInfo entitiesLimitNotificationInfo =
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(null)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        entitiesLimitNotificationInfo,
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link EntitiesLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationInfo.equals(Object)",
    "int EntitiesLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntitiesLimitNotificationInfo entitiesLimitNotificationInfo =
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName(null)
            .build();

    // Act and Assert
    assertNotEquals(
        entitiesLimitNotificationInfo,
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link EntitiesLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationInfo.equals(Object)",
    "int EntitiesLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntitiesLimitNotificationInfo entitiesLimitNotificationInfo =
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("42")
            .build();

    // Act and Assert
    assertNotEquals(
        entitiesLimitNotificationInfo,
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link EntitiesLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationInfo.equals(Object)",
    "int EntitiesLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EntitiesLimitNotificationInfo entitiesLimitNotificationInfo =
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        entitiesLimitNotificationInfo,
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(null)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link EntitiesLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationInfo.equals(Object)",
    "int EntitiesLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build(),
        null);
  }

  /**
   * Test {@link EntitiesLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationInfo.equals(Object)",
    "int EntitiesLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build(),
        "Different type to EntitiesLimitNotificationInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesLimitNotificationInfo#EntitiesLimitNotificationInfo()}
   *   <li>{@link EntitiesLimitNotificationInfo#setCurrentCount(long)}
   *   <li>{@link EntitiesLimitNotificationInfo#setEntityType(EntityType)}
   *   <li>{@link EntitiesLimitNotificationInfo#setLimit(long)}
   *   <li>{@link EntitiesLimitNotificationInfo#setPercents(int)}
   *   <li>{@link EntitiesLimitNotificationInfo#setTenantId(TenantId)}
   *   <li>{@link EntitiesLimitNotificationInfo#setTenantName(String)}
   *   <li>{@link EntitiesLimitNotificationInfo#toString()}
   *   <li>{@link EntitiesLimitNotificationInfo#getAffectedTenantId()}
   *   <li>{@link EntitiesLimitNotificationInfo#getCurrentCount()}
   *   <li>{@link EntitiesLimitNotificationInfo#getEntityType()}
   *   <li>{@link EntitiesLimitNotificationInfo#getLimit()}
   *   <li>{@link EntitiesLimitNotificationInfo#getPercents()}
   *   <li>{@link EntitiesLimitNotificationInfo#getTenantId()}
   *   <li>{@link EntitiesLimitNotificationInfo#getTenantName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntitiesLimitNotificationInfo.<init>()",
    "TenantId EntitiesLimitNotificationInfo.getAffectedTenantId()",
    "long EntitiesLimitNotificationInfo.getCurrentCount()",
    "EntityType EntitiesLimitNotificationInfo.getEntityType()",
    "long EntitiesLimitNotificationInfo.getLimit()",
    "int EntitiesLimitNotificationInfo.getPercents()",
    "TenantId EntitiesLimitNotificationInfo.getTenantId()",
    "String EntitiesLimitNotificationInfo.getTenantName()",
    "void EntitiesLimitNotificationInfo.setCurrentCount(long)",
    "void EntitiesLimitNotificationInfo.setEntityType(EntityType)",
    "void EntitiesLimitNotificationInfo.setLimit(long)",
    "void EntitiesLimitNotificationInfo.setPercents(int)",
    "void EntitiesLimitNotificationInfo.setTenantId(TenantId)",
    "void EntitiesLimitNotificationInfo.setTenantName(String)",
    "String EntitiesLimitNotificationInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntitiesLimitNotificationInfo actualEntitiesLimitNotificationInfo =
        new EntitiesLimitNotificationInfo();
    actualEntitiesLimitNotificationInfo.setCurrentCount(3L);
    actualEntitiesLimitNotificationInfo.setEntityType(EntityType.TENANT);
    actualEntitiesLimitNotificationInfo.setLimit(1L);
    actualEntitiesLimitNotificationInfo.setPercents(1);
    actualEntitiesLimitNotificationInfo.setTenantId(TenantId.SYS_TENANT_ID);
    actualEntitiesLimitNotificationInfo.setTenantName("Tenant Name");
    String actualToStringResult = actualEntitiesLimitNotificationInfo.toString();
    TenantId actualAffectedTenantId = actualEntitiesLimitNotificationInfo.getAffectedTenantId();
    long actualCurrentCount = actualEntitiesLimitNotificationInfo.getCurrentCount();
    EntityType actualEntityType = actualEntitiesLimitNotificationInfo.getEntityType();
    long actualLimit = actualEntitiesLimitNotificationInfo.getLimit();
    int actualPercents = actualEntitiesLimitNotificationInfo.getPercents();
    TenantId actualTenantId = actualEntitiesLimitNotificationInfo.getTenantId();

    // Assert
    assertEquals(
        "EntitiesLimitNotificationInfo(entityType=TENANT, currentCount=3, limit=1, percents=1, tenantId=13814000"
            + "-1dd2-11b2-8080-808080808080, tenantName=Tenant Name)",
        actualToStringResult);
    assertEquals("Tenant Name", actualEntitiesLimitNotificationInfo.getTenantName());
    assertEquals(1, actualPercents);
    assertEquals(1L, actualLimit);
    assertEquals(3L, actualCurrentCount);
    assertEquals(EntityType.TENANT, actualEntityType);
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualAffectedTenantId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link EntitiesLimitNotificationInfo#EntitiesLimitNotificationInfo(EntityType, long, long,
   * int, TenantId, String)}.
   *
   * <p>Method under test: {@link
   * EntitiesLimitNotificationInfo#EntitiesLimitNotificationInfo(EntityType, long, long, int,
   * TenantId, String)}
   */
  @Test
  @DisplayName(
      "Test new EntitiesLimitNotificationInfo(EntityType, long, long, int, TenantId, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntitiesLimitNotificationInfo.<init>(EntityType, long, long, int, TenantId, String)"
  })
  void testNewEntitiesLimitNotificationInfo() {
    // Arrange and Act
    EntitiesLimitNotificationInfo actualEntitiesLimitNotificationInfo =
        new EntitiesLimitNotificationInfo(
            EntityType.TENANT, 3L, 1L, 1, TenantId.SYS_TENANT_ID, "Tenant Name");

    // Assert
    assertEquals("Tenant Name", actualEntitiesLimitNotificationInfo.getTenantName());
    assertNull(actualEntitiesLimitNotificationInfo.getAffectedCustomerId());
    assertNull(actualEntitiesLimitNotificationInfo.getDashboardId());
    assertNull(actualEntitiesLimitNotificationInfo.getStateEntityId());
    assertNull(actualEntitiesLimitNotificationInfo.getAffectedUserId());
    assertEquals(1, actualEntitiesLimitNotificationInfo.getPercents());
    assertEquals(1L, actualEntitiesLimitNotificationInfo.getLimit());
    assertEquals(3L, actualEntitiesLimitNotificationInfo.getCurrentCount());
    Map<String, String> templateData = actualEntitiesLimitNotificationInfo.getTemplateData();
    assertEquals(6, templateData.size());
    assertEquals(EntityType.TENANT, actualEntitiesLimitNotificationInfo.getEntityType());
    assertTrue(templateData.containsKey("currentCount"));
    assertTrue(templateData.containsKey("entityType"));
    assertTrue(templateData.containsKey("limit"));
    assertTrue(templateData.containsKey("percents"));
    assertTrue(templateData.containsKey("tenantId"));
    assertTrue(templateData.containsKey("tenantName"));
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualEntitiesLimitNotificationInfo.getAffectedTenantId());
    assertSame(tenantId, actualEntitiesLimitNotificationInfo.getTenantId());
  }
}
