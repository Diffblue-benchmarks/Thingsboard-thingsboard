package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;

class AlarmDiffblueTest {
  /**
   * Test
   * {@link Alarm#Alarm(TenantId, CustomerId, String, EntityId, AlarmSeverity, boolean, boolean, UserId, long, long, long, long, long, JsonNode, boolean, boolean, boolean, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Alarm#Alarm(TenantId, CustomerId, String, EntityId, AlarmSeverity, boolean, boolean, UserId, long, long, long, long, long, JsonNode, boolean, boolean, boolean, List)}
   */
  @Test
  @DisplayName("Test new Alarm(TenantId, CustomerId, String, EntityId, AlarmSeverity, boolean, boolean, UserId, long, long, long, long, long, JsonNode, boolean, boolean, boolean, List); given '42'; when ArrayList() add '42'")
  void testNewAlarm_given42_whenArrayListAdd42() {
    // Arrange
    CustomerId customerId = new CustomerId(EntityId.NULL_UUID);
    TenantId originator = TenantId.SYS_TENANT_ID;
    MissingNode details = MissingNode.getInstance();

    ArrayList<String> propagateRelationTypes = new ArrayList<>();
    propagateRelationTypes.add("42");
    propagateRelationTypes.add("foo");

    // Act
    Alarm actualAlarm = new Alarm(TenantId.SYS_TENANT_ID, customerId, "Type", originator, AlarmSeverity.CRITICAL, true,
        true, null, 1L, 1L, 1L, 1L, 1L, details, true, true, true, propagateRelationTypes);

    // Assert
    assertEquals("Type", actualAlarm.getName());
    assertEquals("Type", actualAlarm.getType());
    assertNull(actualAlarm.getUuidId());
    assertNull(actualAlarm.getId());
    assertNull(actualAlarm.getDashboardId());
    assertNull(actualAlarm.getAssigneeId());
    assertEquals(0L, actualAlarm.getCreatedTime());
    assertEquals(1L, actualAlarm.getAckTs());
    assertEquals(1L, actualAlarm.getAssignTs());
    assertEquals(1L, actualAlarm.getClearTs());
    assertEquals(1L, actualAlarm.getEndTs());
    assertEquals(1L, actualAlarm.getStartTs());
    assertEquals(AlarmSeverity.CRITICAL, actualAlarm.getSeverity());
    assertEquals(AlarmStatus.CLEARED_ACK, actualAlarm.getStatus());
    assertTrue(actualAlarm.isAcknowledged());
    assertTrue(actualAlarm.isCleared());
    assertTrue(actualAlarm.isPropagate());
    assertTrue(actualAlarm.isPropagateToOwner());
    assertTrue(actualAlarm.isPropagateToTenant());
    assertSame(propagateRelationTypes, actualAlarm.getPropagateRelationTypes());
    assertSame(customerId, actualAlarm.getCustomerId());
    assertSame(details, actualAlarm.getDetails());
    TenantId tenantId = originator.SYS_TENANT_ID;
    assertSame(tenantId, actualAlarm.getOriginator());
    assertSame(tenantId, actualAlarm.getTenantId());
  }

  /**
   * Test
   * {@link Alarm#Alarm(TenantId, CustomerId, String, EntityId, AlarmSeverity, boolean, boolean, UserId, long, long, long, long, long, JsonNode, boolean, boolean, boolean, List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return PropagateRelationTypes is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Alarm#Alarm(TenantId, CustomerId, String, EntityId, AlarmSeverity, boolean, boolean, UserId, long, long, long, long, long, JsonNode, boolean, boolean, boolean, List)}
   */
  @Test
  @DisplayName("Test new Alarm(TenantId, CustomerId, String, EntityId, AlarmSeverity, boolean, boolean, UserId, long, long, long, long, long, JsonNode, boolean, boolean, boolean, List); given 'foo'; then return PropagateRelationTypes is ArrayList()")
  void testNewAlarm_givenFoo_thenReturnPropagateRelationTypesIsArrayList() {
    // Arrange
    CustomerId customerId = new CustomerId(EntityId.NULL_UUID);
    TenantId originator = TenantId.SYS_TENANT_ID;
    MissingNode details = MissingNode.getInstance();

    ArrayList<String> propagateRelationTypes = new ArrayList<>();
    propagateRelationTypes.add("foo");

    // Act
    Alarm actualAlarm = new Alarm(TenantId.SYS_TENANT_ID, customerId, "Type", originator, AlarmSeverity.CRITICAL, true,
        true, null, 1L, 1L, 1L, 1L, 1L, details, true, true, true, propagateRelationTypes);

    // Assert
    assertEquals("Type", actualAlarm.getName());
    assertEquals("Type", actualAlarm.getType());
    assertNull(actualAlarm.getUuidId());
    assertNull(actualAlarm.getId());
    assertNull(actualAlarm.getDashboardId());
    assertNull(actualAlarm.getAssigneeId());
    assertEquals(0L, actualAlarm.getCreatedTime());
    assertEquals(1L, actualAlarm.getAckTs());
    assertEquals(1L, actualAlarm.getAssignTs());
    assertEquals(1L, actualAlarm.getClearTs());
    assertEquals(1L, actualAlarm.getEndTs());
    assertEquals(1L, actualAlarm.getStartTs());
    assertEquals(AlarmSeverity.CRITICAL, actualAlarm.getSeverity());
    assertEquals(AlarmStatus.CLEARED_ACK, actualAlarm.getStatus());
    assertTrue(actualAlarm.isAcknowledged());
    assertTrue(actualAlarm.isCleared());
    assertTrue(actualAlarm.isPropagate());
    assertTrue(actualAlarm.isPropagateToOwner());
    assertTrue(actualAlarm.isPropagateToTenant());
    assertSame(propagateRelationTypes, actualAlarm.getPropagateRelationTypes());
    assertSame(customerId, actualAlarm.getCustomerId());
    assertSame(details, actualAlarm.getDetails());
    TenantId tenantId = originator.SYS_TENANT_ID;
    assertSame(tenantId, actualAlarm.getOriginator());
    assertSame(tenantId, actualAlarm.getTenantId());
  }

  /**
   * Test {@link Alarm#Alarm(Alarm)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link Alarm#Alarm()} Acknowledged is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Alarm#Alarm(Alarm)}
   */
  @Test
  @DisplayName("Test new Alarm(Alarm); given 'true'; when Alarm() Acknowledged is 'true'")
  void testNewAlarm_givenTrue_whenAlarmAcknowledgedIsTrue() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setAcknowledged(true);

    // Act and Assert
    assertEquals(alarm, new Alarm(alarm));
  }

  /**
   * Test {@link Alarm#Alarm(Alarm)}.
   * <ul>
   *   <li>When {@link Alarm#Alarm()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Alarm#Alarm(Alarm)}
   */
  @Test
  @DisplayName("Test new Alarm(Alarm); when Alarm()")
  void testNewAlarm_whenAlarm() {
    // Arrange
    Alarm alarm = new Alarm();

    // Act and Assert
    assertEquals(alarm, new Alarm(alarm));
  }

  /**
   * Test
   * {@link Alarm#Alarm(TenantId, CustomerId, String, EntityId, AlarmSeverity, boolean, boolean, UserId, long, long, long, long, long, JsonNode, boolean, boolean, boolean, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return PropagateRelationTypes Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Alarm#Alarm(TenantId, CustomerId, String, EntityId, AlarmSeverity, boolean, boolean, UserId, long, long, long, long, long, JsonNode, boolean, boolean, boolean, List)}
   */
  @Test
  @DisplayName("Test new Alarm(TenantId, CustomerId, String, EntityId, AlarmSeverity, boolean, boolean, UserId, long, long, long, long, long, JsonNode, boolean, boolean, boolean, List); when ArrayList(); then return PropagateRelationTypes Empty")
  void testNewAlarm_whenArrayList_thenReturnPropagateRelationTypesEmpty() {
    // Arrange
    CustomerId customerId = new CustomerId(EntityId.NULL_UUID);
    TenantId originator = TenantId.SYS_TENANT_ID;
    MissingNode details = MissingNode.getInstance();

    // Act
    Alarm actualAlarm = new Alarm(TenantId.SYS_TENANT_ID, customerId, "Type", originator, AlarmSeverity.CRITICAL, true,
        true, null, 1L, 1L, 1L, 1L, 1L, details, true, true, true, new ArrayList<>());

    // Assert
    assertEquals("Type", actualAlarm.getName());
    assertEquals("Type", actualAlarm.getType());
    assertNull(actualAlarm.getUuidId());
    assertNull(actualAlarm.getId());
    assertNull(actualAlarm.getDashboardId());
    assertNull(actualAlarm.getAssigneeId());
    assertEquals(0L, actualAlarm.getCreatedTime());
    assertEquals(1L, actualAlarm.getAckTs());
    assertEquals(1L, actualAlarm.getAssignTs());
    assertEquals(1L, actualAlarm.getClearTs());
    assertEquals(1L, actualAlarm.getEndTs());
    assertEquals(1L, actualAlarm.getStartTs());
    assertEquals(AlarmSeverity.CRITICAL, actualAlarm.getSeverity());
    assertEquals(AlarmStatus.CLEARED_ACK, actualAlarm.getStatus());
    assertTrue(actualAlarm.getPropagateRelationTypes().isEmpty());
    assertTrue(actualAlarm.isAcknowledged());
    assertTrue(actualAlarm.isCleared());
    assertTrue(actualAlarm.isPropagate());
    assertTrue(actualAlarm.isPropagateToOwner());
    assertTrue(actualAlarm.isPropagateToTenant());
    assertSame(customerId, actualAlarm.getCustomerId());
    assertSame(details, actualAlarm.getDetails());
    TenantId tenantId = originator.SYS_TENANT_ID;
    assertSame(tenantId, actualAlarm.getOriginator());
    assertSame(tenantId, actualAlarm.getTenantId());
  }

  /**
   * Test {@link Alarm#getId()}.
   * <p>
   * Method under test: {@link Alarm#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new Alarm()).getId());
  }

  /**
   * Test {@link Alarm#getCreatedTime()}.
   * <p>
   * Method under test: {@link Alarm#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new Alarm()).getCreatedTime());
  }

  /**
   * Test {@link Alarm#getStatus()}.
   * <ul>
   *   <li>Given {@link Alarm#Alarm()} Acknowledged is {@code true}.</li>
   *   <li>Then return {@code ACTIVE_ACK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Alarm#getStatus()}
   */
  @Test
  @DisplayName("Test getStatus(); given Alarm() Acknowledged is 'true'; then return 'ACTIVE_ACK'")
  void testGetStatus_givenAlarmAcknowledgedIsTrue_thenReturnActiveAck() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setAcknowledged(true);

    // Act and Assert
    assertEquals(AlarmStatus.ACTIVE_ACK, alarm.getStatus());
  }

  /**
   * Test {@link Alarm#getStatus()}.
   * <ul>
   *   <li>Given {@link Alarm#Alarm()} Cleared is {@code true}.</li>
   *   <li>Then return {@code CLEARED_ACK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Alarm#getStatus()}
   */
  @Test
  @DisplayName("Test getStatus(); given Alarm() Cleared is 'true'; then return 'CLEARED_ACK'")
  void testGetStatus_givenAlarmClearedIsTrue_thenReturnClearedAck() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setCleared(true);
    alarm.setAcknowledged(true);

    // Act and Assert
    assertEquals(AlarmStatus.CLEARED_ACK, alarm.getStatus());
  }

  /**
   * Test {@link Alarm#getStatus()}.
   * <ul>
   *   <li>Given {@link Alarm#Alarm()} Cleared is {@code true}.</li>
   *   <li>Then return {@code CLEARED_UNACK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Alarm#getStatus()}
   */
  @Test
  @DisplayName("Test getStatus(); given Alarm() Cleared is 'true'; then return 'CLEARED_UNACK'")
  void testGetStatus_givenAlarmClearedIsTrue_thenReturnClearedUnack() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setCleared(true);

    // Act and Assert
    assertEquals(AlarmStatus.CLEARED_UNACK, alarm.getStatus());
  }

  /**
   * Test {@link Alarm#getStatus()}.
   * <ul>
   *   <li>Given {@link Alarm#Alarm()}.</li>
   *   <li>Then return {@code ACTIVE_UNACK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Alarm#getStatus()}
   */
  @Test
  @DisplayName("Test getStatus(); given Alarm(); then return 'ACTIVE_UNACK'")
  void testGetStatus_givenAlarm_thenReturnActiveUnack() {
    // Arrange, Act and Assert
    assertEquals(AlarmStatus.ACTIVE_UNACK, (new Alarm()).getStatus());
  }

  /**
   * Test {@link Alarm#toStatus(boolean, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code ACTIVE_ACK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Alarm#toStatus(boolean, boolean)}
   */
  @Test
  @DisplayName("Test toStatus(boolean, boolean); when 'false'; then return 'ACTIVE_ACK'")
  void testToStatus_whenFalse_thenReturnActiveAck() {
    // Arrange, Act and Assert
    assertEquals(AlarmStatus.ACTIVE_ACK, Alarm.toStatus(false, true));
  }

  /**
   * Test {@link Alarm#toStatus(boolean, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code ACTIVE_UNACK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Alarm#toStatus(boolean, boolean)}
   */
  @Test
  @DisplayName("Test toStatus(boolean, boolean); when 'false'; then return 'ACTIVE_UNACK'")
  void testToStatus_whenFalse_thenReturnActiveUnack() {
    // Arrange, Act and Assert
    assertEquals(AlarmStatus.ACTIVE_UNACK, Alarm.toStatus(false, false));
  }

  /**
   * Test {@link Alarm#toStatus(boolean, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code CLEARED_ACK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Alarm#toStatus(boolean, boolean)}
   */
  @Test
  @DisplayName("Test toStatus(boolean, boolean); when 'true'; then return 'CLEARED_ACK'")
  void testToStatus_whenTrue_thenReturnClearedAck() {
    // Arrange, Act and Assert
    assertEquals(AlarmStatus.CLEARED_ACK, Alarm.toStatus(true, true));
  }

  /**
   * Test {@link Alarm#toStatus(boolean, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code CLEARED_UNACK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Alarm#toStatus(boolean, boolean)}
   */
  @Test
  @DisplayName("Test toStatus(boolean, boolean); when 'true'; then return 'CLEARED_UNACK'")
  void testToStatus_whenTrue_thenReturnClearedUnack() {
    // Arrange, Act and Assert
    assertEquals(AlarmStatus.CLEARED_UNACK, Alarm.toStatus(true, false));
  }

  /**
   * Test {@link Alarm#getDashboardId()}.
   * <ul>
   *   <li>Given {@link Alarm#Alarm()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Alarm#getDashboardId()}
   */
  @Test
  @DisplayName("Test getDashboardId(); given Alarm()")
  void testGetDashboardId_givenAlarm() {
    // Arrange, Act and Assert
    assertNull((new Alarm()).getDashboardId());
  }

  /**
   * Test {@link Alarm#getDashboardId()}.
   * <ul>
   *   <li>Given {@link Alarm#Alarm()} Details is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link Alarm#getDashboardId()}
   */
  @Test
  @DisplayName("Test getDashboardId(); given Alarm() Details is Instance")
  void testGetDashboardId_givenAlarmDetailsIsInstance() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setDetails(MissingNode.getInstance());

    // Act and Assert
    assertNull(alarm.getDashboardId());
  }
}
