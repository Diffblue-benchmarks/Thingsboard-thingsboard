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
package org.thingsboard.server.common.data.audit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.DoubleNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class AuditLogDiffblueTest {
  /**
   * Test {@link AuditLog#AuditLog(AuditLog)}.
   *
   * <p>Method under test: {@link AuditLog#AuditLog(AuditLog)}
   */
  @Test
  @DisplayName("Test new AuditLog(AuditLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AuditLog.<init>(AuditLog)"})
  void testNewAuditLog() {
    // Arrange
    AuditLog auditLog = new AuditLog();

    // Act
    AuditLog actualAuditLog = new AuditLog(auditLog);

    // Assert
    assertEquals(auditLog, actualAuditLog);
  }

  /**
   * Test {@link AuditLog#getCreatedTime()}.
   *
   * <p>Method under test: {@link AuditLog#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AuditLog.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new AuditLog().getCreatedTime());
  }

  /**
   * Test {@link AuditLog#getId()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLog#getId()}
   */
  @Test
  @DisplayName("Test getId(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.thingsboard.server.common.data.id.AuditLogId AuditLog.getId()"})
  void testGetId_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AuditLog().getId());
  }

  /**
   * Test {@link AuditLog#equals(Object)}, and {@link AuditLog#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AuditLog#equals(Object)}
   *   <li>{@link AuditLog#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    AuditLog auditLog2 = new AuditLog();

    // Act and Assert
    assertEquals(auditLog, auditLog2);
    assertEquals(auditLog.hashCode(), auditLog2.hashCode());
  }

  /**
   * Test {@link AuditLog#equals(Object)}, and {@link AuditLog#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AuditLog#equals(Object)}
   *   <li>{@link AuditLog#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setTenantId(TenantId.SYS_TENANT_ID);

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(auditLog, auditLog2);
    assertEquals(auditLog.hashCode(), auditLog2.hashCode());
  }

  /**
   * Test {@link AuditLog#equals(Object)}, and {@link AuditLog#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AuditLog#equals(Object)}
   *   <li>{@link AuditLog#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertEquals(auditLog, auditLog2);
    assertEquals(auditLog.hashCode(), auditLog2.hashCode());
  }

  /**
   * Test {@link AuditLog#equals(Object)}, and {@link AuditLog#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AuditLog#equals(Object)}
   *   <li>{@link AuditLog#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setEntityId(TenantId.SYS_TENANT_ID);

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setEntityId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(auditLog, auditLog2);
    assertEquals(auditLog.hashCode(), auditLog2.hashCode());
  }

  /**
   * Test {@link AuditLog#equals(Object)}, and {@link AuditLog#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AuditLog#equals(Object)}
   *   <li>{@link AuditLog#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setEntityName("Entity Name");

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setEntityName("Entity Name");

    // Act and Assert
    assertEquals(auditLog, auditLog2);
    assertEquals(auditLog.hashCode(), auditLog2.hashCode());
  }

  /**
   * Test {@link AuditLog#equals(Object)}, and {@link AuditLog#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AuditLog#equals(Object)}
   *   <li>{@link AuditLog#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setUserName("janedoe");

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setUserName("janedoe");

    // Act and Assert
    assertEquals(auditLog, auditLog2);
    assertEquals(auditLog.hashCode(), auditLog2.hashCode());
  }

  /**
   * Test {@link AuditLog#equals(Object)}, and {@link AuditLog#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AuditLog#equals(Object)}
   *   <li>{@link AuditLog#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setActionType(ActionType.ADDED);

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setActionType(ActionType.ADDED);

    // Act and Assert
    assertEquals(auditLog, auditLog2);
    assertEquals(auditLog.hashCode(), auditLog2.hashCode());
  }

  /**
   * Test {@link AuditLog#equals(Object)}, and {@link AuditLog#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AuditLog#equals(Object)}
   *   <li>{@link AuditLog#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual8() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setActionData(DoubleNode.valueOf(10.0d));

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setActionData(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertEquals(auditLog, auditLog2);
    assertEquals(auditLog.hashCode(), auditLog2.hashCode());
  }

  /**
   * Test {@link AuditLog#equals(Object)}, and {@link AuditLog#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AuditLog#equals(Object)}
   *   <li>{@link AuditLog#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual9() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setActionStatus(ActionStatus.SUCCESS);

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setActionStatus(ActionStatus.SUCCESS);

    // Act and Assert
    assertEquals(auditLog, auditLog2);
    assertEquals(auditLog.hashCode(), auditLog2.hashCode());
  }

  /**
   * Test {@link AuditLog#equals(Object)}, and {@link AuditLog#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AuditLog#equals(Object)}
   *   <li>{@link AuditLog#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual10() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setActionFailureDetails("Action Failure Details");

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setActionFailureDetails("Action Failure Details");

    // Act and Assert
    assertEquals(auditLog, auditLog2);
    assertEquals(auditLog.hashCode(), auditLog2.hashCode());
  }

  /**
   * Test {@link AuditLog#equals(Object)}, and {@link AuditLog#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AuditLog#equals(Object)}
   *   <li>{@link AuditLog#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AuditLog auditLog = new AuditLog();

    // Act and Assert
    assertEquals(auditLog, auditLog);
    int expectedHashCodeResult = auditLog.hashCode();
    assertEquals(expectedHashCodeResult, auditLog.hashCode());
  }

  /**
   * Test {@link AuditLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AuditLog(), 1);
  }

  /**
   * Test {@link AuditLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(auditLog, new AuditLog());
  }

  /**
   * Test {@link AuditLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(auditLog, new AuditLog());
  }

  /**
   * Test {@link AuditLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setEntityId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(auditLog, new AuditLog());
  }

  /**
   * Test {@link AuditLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setEntityName("Entity Name");

    // Act and Assert
    assertNotEquals(auditLog, new AuditLog());
  }

  /**
   * Test {@link AuditLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(auditLog, new AuditLog());
  }

  /**
   * Test {@link AuditLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setActionType(ActionType.ADDED);

    // Act and Assert
    assertNotEquals(auditLog, new AuditLog());
  }

  /**
   * Test {@link AuditLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setActionData(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertNotEquals(auditLog, new AuditLog());
  }

  /**
   * Test {@link AuditLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setActionStatus(ActionStatus.SUCCESS);

    // Act and Assert
    assertNotEquals(auditLog, new AuditLog());
  }

  /**
   * Test {@link AuditLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setActionFailureDetails("Action Failure Details");

    // Act and Assert
    assertNotEquals(auditLog, new AuditLog());
  }

  /**
   * Test {@link AuditLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(auditLog, new AuditLog());
  }

  /**
   * Test {@link AuditLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    AuditLog auditLog = new AuditLog();

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(auditLog, auditLog2);
  }

  /**
   * Test {@link AuditLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    AuditLog auditLog = new AuditLog();

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(auditLog, auditLog2);
  }

  /**
   * Test {@link AuditLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    AuditLog auditLog = new AuditLog();

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setEntityId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(auditLog, auditLog2);
  }

  /**
   * Test {@link AuditLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    AuditLog auditLog = new AuditLog();

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setEntityName("Entity Name");

    // Act and Assert
    assertNotEquals(auditLog, auditLog2);
  }

  /**
   * Test {@link AuditLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    AuditLog auditLog = new AuditLog();

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(auditLog, auditLog2);
  }

  /**
   * Test {@link AuditLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    AuditLog auditLog = new AuditLog();

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setActionType(ActionType.ADDED);

    // Act and Assert
    assertNotEquals(auditLog, auditLog2);
  }

  /**
   * Test {@link AuditLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    AuditLog auditLog = new AuditLog();

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setActionData(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertNotEquals(auditLog, auditLog2);
  }

  /**
   * Test {@link AuditLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    AuditLog auditLog = new AuditLog();

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setActionStatus(ActionStatus.SUCCESS);

    // Act and Assert
    assertNotEquals(auditLog, auditLog2);
  }

  /**
   * Test {@link AuditLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    AuditLog auditLog = new AuditLog();

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setActionFailureDetails("Action Failure Details");

    // Act and Assert
    assertNotEquals(auditLog, auditLog2);
  }

  /**
   * Test {@link AuditLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AuditLog(), null);
  }

  /**
   * Test {@link AuditLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLog.equals(Object)", "int AuditLog.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AuditLog(), "Different type to AuditLog");
  }
}
