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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.limit.LimitedApi;
import org.thingsboard.server.common.data.notification.rule.trigger.RateLimitsTrigger.RateLimitsTriggerBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

@ContextConfiguration(classes = {RateLimitsTriggerBuilder.class})
@ExtendWith(SpringExtension.class)
class RateLimitsTriggerDiffblueTest {
  @Autowired
  private RateLimitsTriggerBuilder rateLimitsTriggerBuilder;

  /**
   * Test {@link RateLimitsTrigger#getOriginatorEntityId()}.
   * <p>
   * Method under test: {@link RateLimitsTrigger#getOriginatorEntityId()}
   */
  @Test
  @DisplayName("Test getOriginatorEntityId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId RateLimitsTrigger.getOriginatorEntityId()"})
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
   * Test {@link RateLimitsTrigger#getOriginatorEntityId()}.
   * <p>
   * Method under test: {@link RateLimitsTrigger#getOriginatorEntityId()}
   */
  @Test
  @DisplayName("Test getOriginatorEntityId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId RateLimitsTrigger.getOriginatorEntityId()"})
  void testGetOriginatorEntityId2() {
    // Arrange
    RateLimitsTrigger rateLimitsTrigger = new RateLimitsTrigger(TenantId.SYS_TENANT_ID, LimitedApi.ENTITY_EXPORT, null,
        "Limit Level Entity Name");

    // Act
    EntityId actualOriginatorEntityId = rateLimitsTrigger.getOriginatorEntityId();

    // Assert
    assertNull(rateLimitsTrigger.getLimitLevel());
    TenantId tenantId = ((TenantId) actualOriginatorEntityId).SYS_TENANT_ID;
    assertSame(tenantId, actualOriginatorEntityId);
    assertSame(tenantId, rateLimitsTrigger.getTenantId());
  }

  /**
   * Test {@link RateLimitsTrigger#deduplicate()}.
   * <p>
   * Method under test: {@link RateLimitsTrigger#deduplicate()}
   */
  @Test
  @DisplayName("Test deduplicate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RateLimitsTrigger.deduplicate()"})
  void testDeduplicate() {
    // Arrange, Act and Assert
    assertTrue((new RateLimitsTrigger(TenantId.SYS_TENANT_ID, LimitedApi.ENTITY_EXPORT, TenantId.SYS_TENANT_ID,
        "Limit Level Entity Name")).deduplicate());
  }

  /**
   * Test {@link RateLimitsTrigger#getDeduplicationKey()}.
   * <p>
   * Method under test: {@link RateLimitsTrigger#getDeduplicationKey()}
   */
  @Test
  @DisplayName("Test getDeduplicationKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RateLimitsTrigger.getDeduplicationKey()"})
  void testGetDeduplicationKey() {
    // Arrange, Act and Assert
    assertEquals("RATE_LIMITS:TENANT:13814000-1dd2-11b2-8080-808080808080:ENTITY_EXPORT",
        (new RateLimitsTrigger(TenantId.SYS_TENANT_ID, LimitedApi.ENTITY_EXPORT, TenantId.SYS_TENANT_ID,
            "Limit Level Entity Name")).getDeduplicationKey());
  }

  /**
   * Test {@link RateLimitsTrigger#getDeduplicationKey()}.
   * <p>
   * Method under test: {@link RateLimitsTrigger#getDeduplicationKey()}
   */
  @Test
  @DisplayName("Test getDeduplicationKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RateLimitsTrigger.getDeduplicationKey()"})
  void testGetDeduplicationKey2() {
    // Arrange, Act and Assert
    assertEquals("RATE_LIMITS:TENANT:13814000-1dd2-11b2-8080-808080808080:ENTITY_EXPORT",
        (new RateLimitsTrigger(TenantId.SYS_TENANT_ID, LimitedApi.ENTITY_EXPORT, null, "Limit Level Entity Name"))
            .getDeduplicationKey());
  }

  /**
   * Test {@link RateLimitsTrigger#getDefaultDeduplicationDuration()}.
   * <p>
   * Method under test: {@link RateLimitsTrigger#getDefaultDeduplicationDuration()}
   */
  @Test
  @DisplayName("Test getDefaultDeduplicationDuration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long RateLimitsTrigger.getDefaultDeduplicationDuration()"})
  void testGetDefaultDeduplicationDuration() {
    // Arrange, Act and Assert
    assertEquals(14400000L, (new RateLimitsTrigger(TenantId.SYS_TENANT_ID, LimitedApi.ENTITY_EXPORT,
        TenantId.SYS_TENANT_ID, "Limit Level Entity Name")).getDefaultDeduplicationDuration());
  }

  /**
   * Test {@link RateLimitsTrigger#equals(Object)}, and {@link RateLimitsTrigger#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsTrigger#equals(Object)}
   *   <li>{@link RateLimitsTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RateLimitsTrigger.equals(Object)", "int RateLimitsTrigger.hashCode()"})
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
   * Test {@link RateLimitsTrigger#equals(Object)}, and {@link RateLimitsTrigger#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsTrigger#equals(Object)}
   *   <li>{@link RateLimitsTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RateLimitsTrigger.equals(Object)", "int RateLimitsTrigger.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder.api(Mockito.<LimitedApi>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTrigger buildResult = rateLimitsTriggerBuilder.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder2 = mock(RateLimitsTriggerBuilder.class);
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
   * Test {@link RateLimitsTrigger#equals(Object)}, and {@link RateLimitsTrigger#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsTrigger#equals(Object)}
   *   <li>{@link RateLimitsTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RateLimitsTrigger.equals(Object)", "int RateLimitsTrigger.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder.limitLevel(Mockito.<EntityId>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder2 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder2.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder);
    RateLimitsTrigger buildResult = rateLimitsTriggerBuilder2.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder3 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder3.limitLevel(Mockito.<EntityId>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder4 = mock(RateLimitsTriggerBuilder.class);
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
   * Test {@link RateLimitsTrigger#equals(Object)}, and {@link RateLimitsTrigger#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsTrigger#equals(Object)}
   *   <li>{@link RateLimitsTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RateLimitsTrigger.equals(Object)", "int RateLimitsTrigger.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder.limitLevelEntityName(Mockito.<String>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder2 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder2.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder3 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder3.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder2);
    RateLimitsTrigger buildResult = rateLimitsTriggerBuilder3.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder4 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder4.limitLevelEntityName(Mockito.<String>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder5 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder5.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder4);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder6 = mock(RateLimitsTriggerBuilder.class);
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
   * Test {@link RateLimitsTrigger#equals(Object)}, and {@link RateLimitsTrigger#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsTrigger#equals(Object)}
   *   <li>{@link RateLimitsTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RateLimitsTrigger.equals(Object)", "int RateLimitsTrigger.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder2 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder2.limitLevelEntityName(Mockito.<String>any())).thenReturn(rateLimitsTriggerBuilder);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder3 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder3.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder2);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder4 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder4.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder3);
    RateLimitsTrigger buildResult = rateLimitsTriggerBuilder4.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder5 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder5.tenantId(Mockito.<TenantId>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder6 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder6.limitLevelEntityName(Mockito.<String>any())).thenReturn(rateLimitsTriggerBuilder5);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder7 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder7.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder6);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder8 = mock(RateLimitsTriggerBuilder.class);
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
   * Test {@link RateLimitsTrigger#equals(Object)}, and {@link RateLimitsTrigger#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsTrigger#equals(Object)}
   *   <li>{@link RateLimitsTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RateLimitsTrigger.equals(Object)", "int RateLimitsTrigger.hashCode()"})
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
   * Test {@link RateLimitsTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RateLimitsTrigger.equals(Object)", "int RateLimitsTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder = mock(RateLimitsTriggerBuilder.class);
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
   * Test {@link RateLimitsTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RateLimitsTrigger.equals(Object)", "int RateLimitsTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder = mock(RateLimitsTriggerBuilder.class);
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
   * Test {@link RateLimitsTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RateLimitsTrigger.equals(Object)", "int RateLimitsTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder.limitLevel(Mockito.<EntityId>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder2 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder2.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder);
    RateLimitsTrigger buildResult = rateLimitsTriggerBuilder2.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder3 = mock(RateLimitsTriggerBuilder.class);
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
   * Test {@link RateLimitsTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RateLimitsTrigger.equals(Object)", "int RateLimitsTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder.limitLevelEntityName(Mockito.<String>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder2 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder2.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder3 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder3.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder2);
    RateLimitsTrigger buildResult = rateLimitsTriggerBuilder3.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder4 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder4.limitLevel(Mockito.<EntityId>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder5 = mock(RateLimitsTriggerBuilder.class);
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
   * Test {@link RateLimitsTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RateLimitsTrigger.equals(Object)", "int RateLimitsTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder.limitLevelEntityName(Mockito.<String>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder2 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder2.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder3 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder3.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder2);
    RateLimitsTrigger buildResult = rateLimitsTriggerBuilder3.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder4 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder4.tenantId(Mockito.<TenantId>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder5 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder5.limitLevelEntityName(Mockito.<String>any())).thenReturn(rateLimitsTriggerBuilder4);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder6 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder6.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder5);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder7 = mock(RateLimitsTriggerBuilder.class);
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
   * Test {@link RateLimitsTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RateLimitsTrigger.equals(Object)", "int RateLimitsTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RateLimitsTriggerBuilder builderResult = RateLimitsTrigger.builder();
    builderResult.api(LimitedApi.ENTITY_EXPORT);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(builderResult);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder2 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder2.limitLevelEntityName(Mockito.<String>any())).thenReturn(rateLimitsTriggerBuilder);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder3 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder3.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder2);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder4 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder4.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder3);
    RateLimitsTrigger buildResult = rateLimitsTriggerBuilder4.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder5 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder5.tenantId(Mockito.<TenantId>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder6 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder6.limitLevelEntityName(Mockito.<String>any())).thenReturn(rateLimitsTriggerBuilder5);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder7 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder7.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder6);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder8 = mock(RateLimitsTriggerBuilder.class);
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
   * Test {@link RateLimitsTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RateLimitsTrigger.equals(Object)", "int RateLimitsTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RateLimitsTriggerBuilder builderResult = RateLimitsTrigger.builder();
    builderResult.limitLevel(TenantId.SYS_TENANT_ID);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(builderResult);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder2 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder2.limitLevelEntityName(Mockito.<String>any())).thenReturn(rateLimitsTriggerBuilder);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder3 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder3.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder2);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder4 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder4.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder3);
    RateLimitsTrigger buildResult = rateLimitsTriggerBuilder4.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder5 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder5.tenantId(Mockito.<TenantId>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder6 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder6.limitLevelEntityName(Mockito.<String>any())).thenReturn(rateLimitsTriggerBuilder5);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder7 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder7.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder6);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder8 = mock(RateLimitsTriggerBuilder.class);
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
   * Test {@link RateLimitsTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RateLimitsTrigger.equals(Object)", "int RateLimitsTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RateLimitsTriggerBuilder builderResult = RateLimitsTrigger.builder();
    builderResult.limitLevelEntityName("Limit Level Entity Name");
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(builderResult);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder2 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder2.limitLevelEntityName(Mockito.<String>any())).thenReturn(rateLimitsTriggerBuilder);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder3 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder3.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder2);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder4 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder4.api(Mockito.<LimitedApi>any())).thenReturn(rateLimitsTriggerBuilder3);
    RateLimitsTrigger buildResult = rateLimitsTriggerBuilder4.api(LimitedApi.ENTITY_EXPORT)
        .limitLevel(TenantId.SYS_TENANT_ID)
        .limitLevelEntityName("Limit Level Entity Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder5 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder5.tenantId(Mockito.<TenantId>any())).thenReturn(RateLimitsTrigger.builder());
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder6 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder6.limitLevelEntityName(Mockito.<String>any())).thenReturn(rateLimitsTriggerBuilder5);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder7 = mock(RateLimitsTriggerBuilder.class);
    when(rateLimitsTriggerBuilder7.limitLevel(Mockito.<EntityId>any())).thenReturn(rateLimitsTriggerBuilder6);
    RateLimitsTriggerBuilder rateLimitsTriggerBuilder8 = mock(RateLimitsTriggerBuilder.class);
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
   * Test {@link RateLimitsTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RateLimitsTrigger.equals(Object)", "int RateLimitsTrigger.hashCode()"})
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
   * Test {@link RateLimitsTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RateLimitsTrigger.equals(Object)", "int RateLimitsTrigger.hashCode()"})
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
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsTrigger#RateLimitsTrigger(TenantId, LimitedApi, EntityId, String)}
   *   <li>{@link RateLimitsTrigger#toString()}
   *   <li>{@link RateLimitsTrigger#getApi()}
   *   <li>{@link RateLimitsTrigger#getLimitLevel()}
   *   <li>{@link RateLimitsTrigger#getLimitLevelEntityName()}
   *   <li>{@link RateLimitsTrigger#getTenantId()}
   *   <li>{@link RateLimitsTrigger#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RateLimitsTrigger.<init>(TenantId, LimitedApi, EntityId, String)",
      "LimitedApi RateLimitsTrigger.getApi()", "EntityId RateLimitsTrigger.getLimitLevel()",
      "String RateLimitsTrigger.getLimitLevelEntityName()", "TenantId RateLimitsTrigger.getTenantId()",
      "NotificationRuleTriggerType RateLimitsTrigger.getType()", "String RateLimitsTrigger.toString()"})
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
   * Test RateLimitsTriggerBuilder {@link RateLimitsTriggerBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RateLimitsTriggerBuilder#build()}
   *   <li>{@link RateLimitsTriggerBuilder#api(LimitedApi)}
   *   <li>{@link RateLimitsTriggerBuilder#limitLevel(EntityId)}
   *   <li>{@link RateLimitsTriggerBuilder#limitLevelEntityName(String)}
   *   <li>{@link RateLimitsTriggerBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  @DisplayName("Test RateLimitsTriggerBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RateLimitsTriggerBuilder.<init>()",
      "RateLimitsTriggerBuilder RateLimitsTriggerBuilder.api(LimitedApi)",
      "RateLimitsTrigger RateLimitsTriggerBuilder.build()",
      "RateLimitsTriggerBuilder RateLimitsTriggerBuilder.limitLevel(EntityId)",
      "RateLimitsTriggerBuilder RateLimitsTriggerBuilder.limitLevelEntityName(String)",
      "RateLimitsTriggerBuilder RateLimitsTriggerBuilder.tenantId(TenantId)",
      "String RateLimitsTriggerBuilder.toString()"})
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
