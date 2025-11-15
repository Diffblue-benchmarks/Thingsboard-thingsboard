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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.limit.LimitedApi;

class RateLimitsNotificationInfoDiffblueTest {
  /**
   * Method under test: {@link RateLimitsNotificationInfo#getTemplateData()}
   */
  @Test
  void testGetTemplateData() {
    // Arrange
    RateLimitsNotificationInfo buildResult = RateLimitsNotificationInfo.builder()
        .api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act
    Map<String, String> actualTemplateData = buildResult.getTemplateData();

    // Assert
    assertEquals(6, actualTemplateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("limitLevelEntityId"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("tenantId"));
    assertEquals("Limit Level Entity Name", actualTemplateData.get("limitLevelEntityName"));
    assertEquals("Tenant Name", actualTemplateData.get("tenantName"));
    assertEquals("Tenant", actualTemplateData.get("limitLevelEntityType"));
    assertEquals("entity version creation", actualTemplateData.get("api"));
  }

  /**
   * Method under test: {@link RateLimitsNotificationInfo#getTemplateData()}
   */
  @Test
  void testGetTemplateData2() {
    // Arrange
    RateLimitsNotificationInfo buildResult = RateLimitsNotificationInfo.builder()
        .api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    buildResult.setLimitLevel(null);

    // Act
    Map<String, String> actualTemplateData = buildResult.getTemplateData();

    // Assert
    assertEquals(6, actualTemplateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("tenantId"));
    assertEquals("Limit Level Entity Name", actualTemplateData.get("limitLevelEntityName"));
    assertEquals("Tenant Name", actualTemplateData.get("tenantName"));
    assertEquals("entity version creation", actualTemplateData.get("api"));
    assertNull(actualTemplateData.get("limitLevelEntityId"));
    assertNull(actualTemplateData.get("limitLevelEntityType"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsNotificationInfo#equals(Object)}
   *   <li>{@link RateLimitsNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RateLimitsNotificationInfo buildResult = RateLimitsNotificationInfo.builder()
        .api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    RateLimitsNotificationInfo buildResult2 = RateLimitsNotificationInfo.builder()
        .api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsNotificationInfo#equals(Object)}
   *   <li>{@link RateLimitsNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.api(Mockito.<LimitedApi>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo buildResult = rateLimitsNotificationInfoBuilder.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder2 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder2.api(Mockito.<LimitedApi>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo buildResult2 = rateLimitsNotificationInfoBuilder2.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsNotificationInfo#equals(Object)}
   *   <li>{@link RateLimitsNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder2 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder2.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder);
    RateLimitsNotificationInfo buildResult = rateLimitsNotificationInfoBuilder2.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder3 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder3.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder4 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder4.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder3);
    RateLimitsNotificationInfo buildResult2 = rateLimitsNotificationInfoBuilder4.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsNotificationInfo#equals(Object)}
   *   <li>{@link RateLimitsNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.limitLevelEntityName(Mockito.<String>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder2 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder2.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder3 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder3.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder2);
    RateLimitsNotificationInfo buildResult = rateLimitsNotificationInfoBuilder3.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder4 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder4.limitLevelEntityName(Mockito.<String>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder5 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder5.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder4);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder6 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder6.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder5);
    RateLimitsNotificationInfo buildResult2 = rateLimitsNotificationInfoBuilder6.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsNotificationInfo#equals(Object)}
   *   <li>{@link RateLimitsNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.tenantId(Mockito.<TenantId>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder2 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder2.limitLevelEntityName(Mockito.<String>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder3 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder3.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder2);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder4 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder4.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder3);
    RateLimitsNotificationInfo buildResult = rateLimitsNotificationInfoBuilder4.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder5 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder5.tenantId(Mockito.<TenantId>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder6 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder6.limitLevelEntityName(Mockito.<String>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder5);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder7 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder7.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder6);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder8 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder8.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder7);
    RateLimitsNotificationInfo buildResult2 = rateLimitsNotificationInfoBuilder8.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsNotificationInfo#equals(Object)}
   *   <li>{@link RateLimitsNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RateLimitsNotificationInfo buildResult = RateLimitsNotificationInfo.builder()
        .api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link RateLimitsNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.api(Mockito.<LimitedApi>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo buildResult = rateLimitsNotificationInfoBuilder.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    RateLimitsNotificationInfo buildResult2 = RateLimitsNotificationInfo.builder()
        .api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RateLimitsNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.api(Mockito.<LimitedApi>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo buildResult = rateLimitsNotificationInfoBuilder.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(null)
        .tenantName("Tenant Name")
        .build();
    RateLimitsNotificationInfo buildResult2 = RateLimitsNotificationInfo.builder()
        .api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RateLimitsNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.api(Mockito.<LimitedApi>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo buildResult = rateLimitsNotificationInfoBuilder.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName(null)
        .build();
    RateLimitsNotificationInfo buildResult2 = RateLimitsNotificationInfo.builder()
        .api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RateLimitsNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.api(Mockito.<LimitedApi>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo buildResult = rateLimitsNotificationInfoBuilder.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("42")
        .build();
    RateLimitsNotificationInfo buildResult2 = RateLimitsNotificationInfo.builder()
        .api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RateLimitsNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder2 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder2.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder);
    RateLimitsNotificationInfo buildResult = rateLimitsNotificationInfoBuilder2.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder3 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder3.api(Mockito.<LimitedApi>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo buildResult2 = rateLimitsNotificationInfoBuilder3.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RateLimitsNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.limitLevelEntityName(Mockito.<String>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder2 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder2.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder3 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder3.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder2);
    RateLimitsNotificationInfo buildResult = rateLimitsNotificationInfoBuilder3.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder4 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder4.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder5 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder5.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder4);
    RateLimitsNotificationInfo buildResult2 = rateLimitsNotificationInfoBuilder5.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RateLimitsNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.limitLevelEntityName(Mockito.<String>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder2 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder2.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder3 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder3.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder2);
    RateLimitsNotificationInfo buildResult = rateLimitsNotificationInfoBuilder3.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder4 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder4.tenantId(Mockito.<TenantId>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder5 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder5.limitLevelEntityName(Mockito.<String>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder4);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder6 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder6.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder5);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder7 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder7.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder6);
    RateLimitsNotificationInfo buildResult2 = rateLimitsNotificationInfoBuilder7.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RateLimitsNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder builderResult = RateLimitsNotificationInfo.builder();
    builderResult.api(LimitedApi.ENTITY_EXPORT);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(builderResult);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder2 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder2.limitLevelEntityName(Mockito.<String>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder3 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder3.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder2);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder4 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder4.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder3);
    RateLimitsNotificationInfo buildResult = rateLimitsNotificationInfoBuilder4.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder5 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder5.tenantId(Mockito.<TenantId>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder6 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder6.limitLevelEntityName(Mockito.<String>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder5);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder7 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder7.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder6);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder8 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder8.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder7);
    RateLimitsNotificationInfo buildResult2 = rateLimitsNotificationInfoBuilder8.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RateLimitsNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder builderResult = RateLimitsNotificationInfo.builder();
    builderResult.limitLevel(TenantId.SYS_TENANT_ID);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(builderResult);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder2 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder2.limitLevelEntityName(Mockito.<String>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder3 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder3.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder2);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder4 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder4.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder3);
    RateLimitsNotificationInfo buildResult = rateLimitsNotificationInfoBuilder4.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder5 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder5.tenantId(Mockito.<TenantId>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder6 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder6.limitLevelEntityName(Mockito.<String>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder5);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder7 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder7.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder6);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder8 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder8.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder7);
    RateLimitsNotificationInfo buildResult2 = rateLimitsNotificationInfoBuilder8.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RateLimitsNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder builderResult = RateLimitsNotificationInfo.builder();
    builderResult.limitLevelEntityName("Tenant Name");
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(builderResult);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder2 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder2.limitLevelEntityName(Mockito.<String>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder3 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder3.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder2);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder4 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder4.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder3);
    RateLimitsNotificationInfo buildResult = rateLimitsNotificationInfoBuilder4.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder5 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder5.tenantId(Mockito.<TenantId>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder6 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder6.limitLevelEntityName(Mockito.<String>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder5);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder7 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder7.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder6);
    RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder8 = mock(
        RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder8.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder7);
    RateLimitsNotificationInfo buildResult2 = rateLimitsNotificationInfoBuilder8.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RateLimitsNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RateLimitsNotificationInfo buildResult = RateLimitsNotificationInfo.builder()
        .api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link RateLimitsNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RateLimitsNotificationInfo buildResult = RateLimitsNotificationInfo.builder()
        .api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to RateLimitsNotificationInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsNotificationInfo#RateLimitsNotificationInfo()}
   *   <li>{@link RateLimitsNotificationInfo#setApi(LimitedApi)}
   *   <li>{@link RateLimitsNotificationInfo#setLimitLevel(EntityId)}
   *   <li>{@link RateLimitsNotificationInfo#setLimitLevelEntityName(String)}
   *   <li>{@link RateLimitsNotificationInfo#setTenantId(TenantId)}
   *   <li>{@link RateLimitsNotificationInfo#setTenantName(String)}
   *   <li>{@link RateLimitsNotificationInfo#toString()}
   *   <li>{@link RateLimitsNotificationInfo#getAffectedTenantId()}
   *   <li>{@link RateLimitsNotificationInfo#getApi()}
   *   <li>{@link RateLimitsNotificationInfo#getLimitLevel()}
   *   <li>{@link RateLimitsNotificationInfo#getLimitLevelEntityName()}
   *   <li>{@link RateLimitsNotificationInfo#getTenantId()}
   *   <li>{@link RateLimitsNotificationInfo#getTenantName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RateLimitsNotificationInfo actualRateLimitsNotificationInfo = new RateLimitsNotificationInfo();
    actualRateLimitsNotificationInfo.setApi(LimitedApi.ENTITY_EXPORT);
    actualRateLimitsNotificationInfo.setLimitLevel(TenantId.SYS_TENANT_ID);
    actualRateLimitsNotificationInfo.setLimitLevelEntityName("Limit Level Entity Name");
    actualRateLimitsNotificationInfo.setTenantId(TenantId.SYS_TENANT_ID);
    actualRateLimitsNotificationInfo.setTenantName("Tenant Name");
    String actualToStringResult = actualRateLimitsNotificationInfo.toString();
    TenantId actualAffectedTenantId = actualRateLimitsNotificationInfo.getAffectedTenantId();
    LimitedApi actualApi = actualRateLimitsNotificationInfo.getApi();
    EntityId actualLimitLevel = actualRateLimitsNotificationInfo.getLimitLevel();
    String actualLimitLevelEntityName = actualRateLimitsNotificationInfo.getLimitLevelEntityName();
    TenantId actualTenantId = actualRateLimitsNotificationInfo.getTenantId();

    // Assert that nothing has changed
    assertEquals("Limit Level Entity Name", actualLimitLevelEntityName);
    assertEquals("RateLimitsNotificationInfo(tenantId=13814000-1dd2-11b2-8080-808080808080, tenantName=Tenant Name,"
        + " api=ENTITY_EXPORT, limitLevel=13814000-1dd2-11b2-8080-808080808080, limitLevelEntityName=Limit Level"
        + " Entity Name)", actualToStringResult);
    assertEquals("Tenant Name", actualRateLimitsNotificationInfo.getTenantName());
    assertEquals(LimitedApi.ENTITY_EXPORT, actualApi);
    TenantId tenantId = actualTenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualAffectedTenantId);
    assertSame(tenantId, actualLimitLevel);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RateLimitsNotificationInfo#RateLimitsNotificationInfo(TenantId, String, LimitedApi, EntityId, String)}
   *   <li>{@link RateLimitsNotificationInfo#setApi(LimitedApi)}
   *   <li>{@link RateLimitsNotificationInfo#setLimitLevel(EntityId)}
   *   <li>{@link RateLimitsNotificationInfo#setLimitLevelEntityName(String)}
   *   <li>{@link RateLimitsNotificationInfo#setTenantId(TenantId)}
   *   <li>{@link RateLimitsNotificationInfo#setTenantName(String)}
   *   <li>{@link RateLimitsNotificationInfo#toString()}
   *   <li>{@link RateLimitsNotificationInfo#getAffectedTenantId()}
   *   <li>{@link RateLimitsNotificationInfo#getApi()}
   *   <li>{@link RateLimitsNotificationInfo#getLimitLevel()}
   *   <li>{@link RateLimitsNotificationInfo#getLimitLevelEntityName()}
   *   <li>{@link RateLimitsNotificationInfo#getTenantId()}
   *   <li>{@link RateLimitsNotificationInfo#getTenantName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    RateLimitsNotificationInfo actualRateLimitsNotificationInfo = new RateLimitsNotificationInfo(TenantId.SYS_TENANT_ID,
        "Tenant Name", LimitedApi.ENTITY_EXPORT, TenantId.SYS_TENANT_ID, "Limit Level Entity Name");
    actualRateLimitsNotificationInfo.setApi(LimitedApi.ENTITY_EXPORT);
    actualRateLimitsNotificationInfo.setLimitLevel(TenantId.SYS_TENANT_ID);
    actualRateLimitsNotificationInfo.setLimitLevelEntityName("Limit Level Entity Name");
    actualRateLimitsNotificationInfo.setTenantId(TenantId.SYS_TENANT_ID);
    actualRateLimitsNotificationInfo.setTenantName("Tenant Name");
    String actualToStringResult = actualRateLimitsNotificationInfo.toString();
    TenantId actualAffectedTenantId = actualRateLimitsNotificationInfo.getAffectedTenantId();
    LimitedApi actualApi = actualRateLimitsNotificationInfo.getApi();
    EntityId actualLimitLevel = actualRateLimitsNotificationInfo.getLimitLevel();
    String actualLimitLevelEntityName = actualRateLimitsNotificationInfo.getLimitLevelEntityName();
    TenantId actualTenantId = actualRateLimitsNotificationInfo.getTenantId();

    // Assert that nothing has changed
    assertEquals("Limit Level Entity Name", actualLimitLevelEntityName);
    assertEquals("RateLimitsNotificationInfo(tenantId=13814000-1dd2-11b2-8080-808080808080, tenantName=Tenant Name,"
        + " api=ENTITY_EXPORT, limitLevel=13814000-1dd2-11b2-8080-808080808080, limitLevelEntityName=Limit Level"
        + " Entity Name)", actualToStringResult);
    assertEquals("Tenant Name", actualRateLimitsNotificationInfo.getTenantName());
    assertEquals(LimitedApi.ENTITY_EXPORT, actualApi);
    TenantId tenantId = actualTenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualAffectedTenantId);
    assertSame(tenantId, actualLimitLevel);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder#build()}
   *   <li>
   * {@link RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder#api(LimitedApi)}
   *   <li>
   * {@link RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder#limitLevel(EntityId)}
   *   <li>
   * {@link RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder#limitLevelEntityName(String)}
   *   <li>
   * {@link RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder#tenantId(TenantId)}
   *   <li>
   * {@link RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder#tenantName(String)}
   * </ul>
   */
  @Test
  void testRateLimitsNotificationInfoBuilderBuild() {
    // Arrange and Act
    RateLimitsNotificationInfo actualBuildResult = RateLimitsNotificationInfo.builder()
        .api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Assert
    Map<String, String> templateData = actualBuildResult.getTemplateData();
    assertEquals(6, templateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateData.get("limitLevelEntityId"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateData.get("tenantId"));
    TenantId affectedTenantId = actualBuildResult.getAffectedTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", affectedTenantId.getId().toString());
    assertEquals("Limit Level Entity Name", templateData.get("limitLevelEntityName"));
    assertEquals("Limit Level Entity Name", actualBuildResult.getLimitLevelEntityName());
    assertEquals("Tenant Name", templateData.get("tenantName"));
    assertEquals("Tenant Name", actualBuildResult.getTenantName());
    assertEquals("Tenant", templateData.get("limitLevelEntityType"));
    assertEquals("entity version creation", templateData.get("api"));
    assertNull(actualBuildResult.getAffectedCustomerId());
    assertNull(actualBuildResult.getDashboardId());
    assertNull(actualBuildResult.getStateEntityId());
    assertNull(actualBuildResult.getAffectedUserId());
    assertEquals(EntityType.TENANT, affectedTenantId.getEntityType());
    assertEquals(LimitedApi.ENTITY_EXPORT, actualBuildResult.getApi());
    assertTrue(affectedTenantId.isNullUid());
    assertTrue(affectedTenantId.isSysTenantId());
  }
}
