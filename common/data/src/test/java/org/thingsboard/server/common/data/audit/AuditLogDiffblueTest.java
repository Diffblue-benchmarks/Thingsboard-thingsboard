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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.id.AuditLogId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class AuditLogDiffblueTest {
  /**
   * Method under test: {@link AuditLog#getCreatedTime()}
   */
  @Test
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new AuditLog()).getCreatedTime());
  }

  /**
   * Method under test: {@link AuditLog#getId()}
   */
  @Test
  void testGetId() {
    // Arrange
    AuditLogId id = mock(AuditLogId.class);
    when(id.getId()).thenReturn(EntityId.NULL_UUID);

    // Act
    (new AuditLog(id)).getId().getId();

    // Assert
    verify(id).getId();
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AuditLog#equals(Object)}
   *   <li>{@link AuditLog#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    AuditLog auditLog2 = new AuditLog();

    // Act and Assert
    assertEquals(auditLog, auditLog2);
    int expectedHashCodeResult = auditLog.hashCode();
    assertEquals(expectedHashCodeResult, auditLog2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AuditLog#equals(Object)}
   *   <li>{@link AuditLog#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AuditLog auditLog = new AuditLog();

    // Act and Assert
    assertEquals(auditLog, auditLog);
    int expectedHashCodeResult = auditLog.hashCode();
    assertEquals(expectedHashCodeResult, auditLog.hashCode());
  }

  /**
   * Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AuditLog(), 1);
    assertNotEquals(new AuditLog(), mock(AdminSettings.class));
  }

  /**
   * Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(auditLog, new AuditLog());
  }

  /**
   * Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(auditLog, new AuditLog());
  }

  /**
   * Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setEntityId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(auditLog, new AuditLog());
  }

  /**
   * Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setEntityName("Entity Name");

    // Act and Assert
    assertNotEquals(auditLog, new AuditLog());
  }

  /**
   * Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(auditLog, new AuditLog());
  }

  /**
   * Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setActionType(ActionType.ADDED);

    // Act and Assert
    assertNotEquals(auditLog, new AuditLog());
  }

  /**
   * Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setActionData(MissingNode.getInstance());

    // Act and Assert
    assertNotEquals(auditLog, new AuditLog());
  }

  /**
   * Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setActionStatus(ActionStatus.SUCCESS);

    // Act and Assert
    assertNotEquals(auditLog, new AuditLog());
  }

  /**
   * Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setActionFailureDetails("Action Failure Details");

    // Act and Assert
    assertNotEquals(auditLog, new AuditLog());
  }

  /**
   * Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(auditLog, new AuditLog());
  }

  /**
   * Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    AuditLog auditLog = new AuditLog();

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(auditLog, auditLog2);
  }

  /**
   * Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    AuditLog auditLog = new AuditLog();

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(auditLog, auditLog2);
  }

  /**
   * Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    AuditLog auditLog = new AuditLog();

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setEntityId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(auditLog, auditLog2);
  }

  /**
   * Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    AuditLog auditLog = new AuditLog();

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setEntityName("Entity Name");

    // Act and Assert
    assertNotEquals(auditLog, auditLog2);
  }

  /**
   * Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    AuditLog auditLog = new AuditLog();

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(auditLog, auditLog2);
  }

  /**
   * Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    AuditLog auditLog = new AuditLog();

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setActionType(ActionType.ADDED);

    // Act and Assert
    assertNotEquals(auditLog, auditLog2);
  }

  /**
   * Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    AuditLog auditLog = new AuditLog();

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setActionData(MissingNode.getInstance());

    // Act and Assert
    assertNotEquals(auditLog, auditLog2);
  }

  /**
   * Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    AuditLog auditLog = new AuditLog();

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setActionStatus(ActionStatus.SUCCESS);

    // Act and Assert
    assertNotEquals(auditLog, auditLog2);
  }

  /**
   * Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    AuditLog auditLog = new AuditLog();

    AuditLog auditLog2 = new AuditLog();
    auditLog2.setActionFailureDetails("Action Failure Details");

    // Act and Assert
    assertNotEquals(auditLog, auditLog2);
  }

  /**
   * Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AuditLog(), null);
  }

  /**
   * Method under test: {@link AuditLog#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AuditLog(), "Different type to AuditLog");
  }

  /**
   * Method under test: {@link AuditLog#AuditLog(AuditLog)}
   */
  @Test
  void testNewAuditLog() {
    // Arrange
    AuditLog auditLog = new AuditLog();

    // Act and Assert
    assertEquals(auditLog, new AuditLog(auditLog));
  }
}
