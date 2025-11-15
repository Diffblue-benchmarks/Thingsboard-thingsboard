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
package org.thingsboard.server.common.data.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.limit.LimitedApi;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

class RateLimitsTriggerDiffblueTest {
  /**
   * Method under test: {@link RateLimitsTrigger#getOriginatorEntityId()}
   */
  @Test
  void testGetOriginatorEntityId() {
    // Arrange
    RateLimitsTrigger rateLimitsTrigger = new RateLimitsTrigger(TenantId.SYS_TENANT_ID, LimitedApi.ENTITY_EXPORT,
        TenantId.SYS_TENANT_ID, "Limit Level Entity Name");

    // Act
    EntityId actualOriginatorEntityId = rateLimitsTrigger.getOriginatorEntityId();

    // Assert
    TenantId tenantId = ((TenantId) actualOriginatorEntityId).SYS_TENANT_ID;
    assertSame(tenantId, rateLimitsTrigger.getLimitLevel());
    assertSame(tenantId, actualOriginatorEntityId);
    assertSame(tenantId, rateLimitsTrigger.getTenantId());
  }

  /**
   * Method under test: {@link RateLimitsTrigger#getOriginatorEntityId()}
   */
  @Test
  void testGetOriginatorEntityId2() {
    // Arrange
    RateLimitsTrigger rateLimitsTrigger = new RateLimitsTrigger(TenantId.SYS_TENANT_ID, LimitedApi.ENTITY_EXPORT, null,
        "Limit Level Entity Name");

    // Act
    EntityId actualOriginatorEntityId = rateLimitsTrigger.getOriginatorEntityId();

    // Assert
    TenantId tenantId = ((TenantId) actualOriginatorEntityId).SYS_TENANT_ID;
    assertSame(tenantId, actualOriginatorEntityId);
    assertSame(tenantId, rateLimitsTrigger.getTenantId());
  }

  /**
   * Method under test: {@link RateLimitsTrigger#deduplicate()}
   */
  @Test
  void testDeduplicate() {
    // Arrange, Act and Assert
    assertTrue((new RateLimitsTrigger(TenantId.SYS_TENANT_ID, LimitedApi.ENTITY_EXPORT, TenantId.SYS_TENANT_ID,
        "Limit Level Entity Name")).deduplicate());
  }

  /**
   * Method under test: {@link RateLimitsTrigger#getDeduplicationKey()}
   */
  @Test
  void testGetDeduplicationKey() {
    // Arrange, Act and Assert
    assertEquals("RATE_LIMITS:TENANT:13814000-1dd2-11b2-8080-808080808080:ENTITY_EXPORT",
        (new RateLimitsTrigger(TenantId.SYS_TENANT_ID, LimitedApi.ENTITY_EXPORT, TenantId.SYS_TENANT_ID,
            "Limit Level Entity Name")).getDeduplicationKey());
    assertEquals("RATE_LIMITS:TENANT:13814000-1dd2-11b2-8080-808080808080:ENTITY_EXPORT",
        (new RateLimitsTrigger(TenantId.SYS_TENANT_ID, LimitedApi.ENTITY_EXPORT, null, "Limit Level Entity Name"))
            .getDeduplicationKey());
  }

  /**
   * Method under test:
   * {@link RateLimitsTrigger#getDefaultDeduplicationDuration()}
   */
  @Test
  void testGetDefaultDeduplicationDuration() {
    // Arrange, Act and Assert
    assertEquals(14400000L, (new RateLimitsTrigger(TenantId.SYS_TENANT_ID, LimitedApi.ENTITY_EXPORT,
        TenantId.SYS_TENANT_ID, "Limit Level Entity Name")).getDefaultDeduplicationDuration());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsTrigger#equals(Object)}
   *   <li>{@link RateLimitsTrigger#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RateLimitsTrigger buildResult = RateLimitsTrigger.builder()
        .api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RateLimitsTrigger buildResult2 = RateLimitsTrigger.builder()
        .api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsTrigger#equals(Object)}
   *   <li>{@link RateLimitsTrigger#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder.api(Mockito.<LimitedApi>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTrigger buildResult = rateLimitsTriggerBuilder.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder2 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder2.api(Mockito.<LimitedApi>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTrigger buildResult2 = rateLimitsTriggerBuilder2.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsTrigger#equals(Object)}
   *   <li>{@link RateLimitsTrigger#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder.limitLevel(Mockito.<EntityId>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder2 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder2.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder);
    RateLimitsTrigger buildResult = rateLimitsTriggerBuilder2.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder3 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder3.limitLevel(Mockito.<EntityId>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder4 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder4.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder3);
    RateLimitsTrigger buildResult2 = rateLimitsTriggerBuilder4.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsTrigger#equals(Object)}
   *   <li>{@link RateLimitsTrigger#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder.limitLevelEntityName(Mockito.<String>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder2 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder2.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder3 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder3.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder2);
    RateLimitsTrigger buildResult = rateLimitsTriggerBuilder3.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder4 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder4.limitLevelEntityName(Mockito.<String>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder5 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder5.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder4);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder6 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder6.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder5);
    RateLimitsTrigger buildResult2 = rateLimitsTriggerBuilder6.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsTrigger#equals(Object)}
   *   <li>{@link RateLimitsTrigger#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder2 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder2.limitLevelEntityName(Mockito.<String>any())).thenReturn(rateLimitsTriggerBuilder);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder3 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder3.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder2);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder4 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder4.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder3);
    RateLimitsTrigger buildResult = rateLimitsTriggerBuilder4.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder5 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder5.tenantId(Mockito.<TenantId>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder6 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder6.limitLevelEntityName(Mockito.<String>any())).thenReturn(rateLimitsTriggerBuilder5);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder7 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder7.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder6);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder8 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder8.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder7);
    RateLimitsTrigger buildResult2 = rateLimitsTriggerBuilder8.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsTrigger#equals(Object)}
   *   <li>{@link RateLimitsTrigger#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RateLimitsTrigger buildResult = RateLimitsTrigger.builder()
        .api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder.api(Mockito.<LimitedApi>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTrigger buildResult = rateLimitsTriggerBuilder.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RateLimitsTrigger buildResult2 = RateLimitsTrigger.builder()
        .api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder.api(Mockito.<LimitedApi>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTrigger buildResult = rateLimitsTriggerBuilder.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(null)
        .build();
    RateLimitsTrigger buildResult2 = RateLimitsTrigger.builder()
        .api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder.limitLevel(Mockito.<EntityId>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder2 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder2.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder);
    RateLimitsTrigger buildResult = rateLimitsTriggerBuilder2.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder3 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder3.api(Mockito.<LimitedApi>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTrigger buildResult2 = rateLimitsTriggerBuilder3.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder.limitLevelEntityName(Mockito.<String>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder2 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder2.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder3 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder3.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder2);
    RateLimitsTrigger buildResult = rateLimitsTriggerBuilder3.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder4 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder4.limitLevel(Mockito.<EntityId>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder5 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder5.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder4);
    RateLimitsTrigger buildResult2 = rateLimitsTriggerBuilder5.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder.limitLevelEntityName(Mockito.<String>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder2 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder2.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder3 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder3.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder2);
    RateLimitsTrigger buildResult = rateLimitsTriggerBuilder3.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder4 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder4.tenantId(Mockito.<TenantId>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder5 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder5.limitLevelEntityName(Mockito.<String>any())).thenReturn(rateLimitsTriggerBuilder4);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder6 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder6.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder5);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder7 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder7.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder6);
    RateLimitsTrigger buildResult2 = rateLimitsTriggerBuilder7.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RateLimitsTrigger.RateLimitsTriggerBuilder builderResult = RateLimitsTrigger.builder();
    builderResult.api(LimitedApi.ENTITY_EXPORT);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(builderResult);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder2 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder2.limitLevelEntityName(Mockito.<String>any())).thenReturn(rateLimitsTriggerBuilder);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder3 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder3.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder2);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder4 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder4.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder3);
    RateLimitsTrigger buildResult = rateLimitsTriggerBuilder4.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder5 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder5.tenantId(Mockito.<TenantId>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder6 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder6.limitLevelEntityName(Mockito.<String>any())).thenReturn(rateLimitsTriggerBuilder5);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder7 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder7.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder6);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder8 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder8.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder7);
    RateLimitsTrigger buildResult2 = rateLimitsTriggerBuilder8.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RateLimitsTrigger.RateLimitsTriggerBuilder builderResult = RateLimitsTrigger.builder();
    builderResult.limitLevel(TenantId.SYS_TENANT_ID);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(builderResult);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder2 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder2.limitLevelEntityName(Mockito.<String>any())).thenReturn(rateLimitsTriggerBuilder);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder3 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder3.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder2);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder4 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder4.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder3);
    RateLimitsTrigger buildResult = rateLimitsTriggerBuilder4.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder5 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder5.tenantId(Mockito.<TenantId>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder6 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder6.limitLevelEntityName(Mockito.<String>any())).thenReturn(rateLimitsTriggerBuilder5);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder7 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder7.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder6);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder8 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder8.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder7);
    RateLimitsTrigger buildResult2 = rateLimitsTriggerBuilder8.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RateLimitsTrigger.RateLimitsTriggerBuilder builderResult = RateLimitsTrigger.builder();
    builderResult.limitLevelEntityName("Limit Level Entity Name");
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(builderResult);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder2 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder2.limitLevelEntityName(Mockito.<String>any())).thenReturn(rateLimitsTriggerBuilder);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder3 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder3.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder2);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder4 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder4.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder3);
    RateLimitsTrigger buildResult = rateLimitsTriggerBuilder4.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder5 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder5.tenantId(Mockito.<TenantId>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder6 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder6.limitLevelEntityName(Mockito.<String>any())).thenReturn(rateLimitsTriggerBuilder5);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder7 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder7.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder6);
    RateLimitsTrigger.RateLimitsTriggerBuilder rateLimitsTriggerBuilder8 = mock(
        RateLimitsTrigger.RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder8.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder7);
    RateLimitsTrigger buildResult2 = rateLimitsTriggerBuilder8.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RateLimitsTrigger buildResult = RateLimitsTrigger.builder()
        .api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RateLimitsTrigger buildResult = RateLimitsTrigger.builder()
        .api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to RateLimitsTrigger");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RateLimitsTrigger#RateLimitsTrigger(TenantId, LimitedApi, EntityId, String)}
   *   <li>{@link RateLimitsTrigger#toString()}
   *   <li>{@link RateLimitsTrigger#getApi()}
   *   <li>{@link RateLimitsTrigger#getLimitLevel()}
   *   <li>{@link RateLimitsTrigger#getLimitLevelEntityName()}
   *   <li>{@link RateLimitsTrigger#getTenantId()}
   *   <li>{@link RateLimitsTrigger#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RateLimitsTrigger actualRateLimitsTrigger = new RateLimitsTrigger(TenantId.SYS_TENANT_ID, LimitedApi.ENTITY_EXPORT,
        TenantId.SYS_TENANT_ID, "Limit Level Entity Name");
    String actualToStringResult = actualRateLimitsTrigger.toString();
    LimitedApi actualApi = actualRateLimitsTrigger.getApi();
    EntityId actualLimitLevel = actualRateLimitsTrigger.getLimitLevel();
    String actualLimitLevelEntityName = actualRateLimitsTrigger.getLimitLevelEntityName();
    TenantId actualTenantId = actualRateLimitsTrigger.getTenantId();

    // Assert
    assertEquals("Limit Level Entity Name", actualLimitLevelEntityName);
    assertEquals(
        "RateLimitsTrigger(tenantId=13814000-1dd2-11b2-8080-808080808080, api=ENTITY_EXPORT, limitLevel=13814000"
            + "-1dd2-11b2-8080-808080808080, limitLevelEntityName=Limit Level Entity Name)",
        actualToStringResult);
    assertEquals(LimitedApi.ENTITY_EXPORT, actualApi);
    assertEquals(NotificationRuleTriggerType.RATE_LIMITS, actualRateLimitsTrigger.getType());
    TenantId tenantId = actualTenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualLimitLevel);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsTrigger.RateLimitsTriggerBuilder#build()}
   *   <li>{@link RateLimitsTrigger.RateLimitsTriggerBuilder#api(LimitedApi)}
   *   <li>{@link RateLimitsTrigger.RateLimitsTriggerBuilder#limitLevel(EntityId)}
   *   <li>
   * {@link RateLimitsTrigger.RateLimitsTriggerBuilder#limitLevelEntityName(String)}
   *   <li>{@link RateLimitsTrigger.RateLimitsTriggerBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  void testRateLimitsTriggerBuilderBuild() {
    // Arrange and Act
    RateLimitsTrigger actualBuildResult = RateLimitsTrigger.builder()
        .api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Assert
    EntityId limitLevel = actualBuildResult.getLimitLevel();
    assertTrue(limitLevel instanceof TenantId);
    assertEquals("Limit Level Entity Name", actualBuildResult.getLimitLevelEntityName());
    assertEquals("RATE_LIMITS:TENANT:13814000-1dd2-11b2-8080-808080808080:ENTITY_EXPORT",
        actualBuildResult.getDeduplicationKey());
    assertEquals(14400000L, actualBuildResult.getDefaultDeduplicationDuration());
    assertEquals(LimitedApi.ENTITY_EXPORT, actualBuildResult.getApi());
    assertEquals(NotificationRuleTriggerType.RATE_LIMITS, actualBuildResult.getType());
    assertTrue(actualBuildResult.deduplicate());
    assertSame(limitLevel, actualBuildResult.getOriginatorEntityId());
    assertSame(limitLevel, actualBuildResult.getTenantId());
  }
}
