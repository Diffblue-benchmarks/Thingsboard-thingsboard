package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

class AbstractAlarmEntityDiffblueTest {
  /**
   * Test {@link AbstractAlarmEntity#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link AlarmEntity#AlarmEntity()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmEntity#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when AlarmEntity(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractAlarmEntity.canEqual(Object)"})
  void testCanEqual_whenAlarmEntity_thenReturnTrue() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    // Act and Assert
    assertTrue(alarmEntity.canEqual(new AlarmEntity()));
  }

  /**
   * Test {@link AbstractAlarmEntity#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@code Other}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmEntity#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractAlarmEntity.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new AlarmEntity().canEqual("Other"));
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}, and {@link AbstractAlarmEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractAlarmEntity.equals(Object)",
    "int AbstractAlarmEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    AlarmEntity alarmEntity2 = new AlarmEntity();

    // Act and Assert
    assertEquals(alarmEntity, alarmEntity2);
    assertEquals(alarmEntity.hashCode(), alarmEntity2.hashCode());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}, and {@link AbstractAlarmEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractAlarmEntity.equals(Object)",
    "int AbstractAlarmEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    // Act and Assert
    assertEquals(alarmEntity, alarmEntity);
    int expectedHashCodeResult = alarmEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmEntity.hashCode());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractAlarmEntity.equals(Object)",
    "int AbstractAlarmEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(1L);
    adminSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    adminSettingsEntity.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity.setKey("Key");
    adminSettingsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    adminSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(alarmEntity, adminSettingsEntity);
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractAlarmEntity.equals(Object)",
    "int AbstractAlarmEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    AlarmEntity alarmEntity2 = mock(AlarmEntity.class);
    when(alarmEntity2.isAcknowledged()).thenReturn(true);
    when(alarmEntity2.isCleared()).thenReturn(true);
    when(alarmEntity2.getStartTs()).thenReturn(1L);
    when(alarmEntity2.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(alarmEntity2.getCreatedTime()).thenReturn(1L);
    when(alarmEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(alarmEntity, alarmEntity2);
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractAlarmEntity.equals(Object)",
    "int AbstractAlarmEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmEntity(), null);
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractAlarmEntity.equals(Object)",
    "int AbstractAlarmEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmEntity(), "Different type to AbstractAlarmEntity");
  }

  /**
   * Test {@link AbstractAlarmEntity#getAckTs()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getAckTs()}
   */
  @Test
  @DisplayName("Test getAckTs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AbstractAlarmEntity.getAckTs()"})
  void testGetAckTs() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getAckTs());
  }

  /**
   * Test {@link AbstractAlarmEntity#getAssignTs()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getAssignTs()}
   */
  @Test
  @DisplayName("Test getAssignTs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AbstractAlarmEntity.getAssignTs()"})
  void testGetAssignTs() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getAssignTs());
  }

  /**
   * Test {@link AbstractAlarmEntity#getAssigneeId()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getAssigneeId()}
   */
  @Test
  @DisplayName("Test getAssigneeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractAlarmEntity.getAssigneeId()"})
  void testGetAssigneeId() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getAssigneeId());
  }

  /**
   * Test {@link AbstractAlarmEntity#getClearTs()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getClearTs()}
   */
  @Test
  @DisplayName("Test getClearTs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AbstractAlarmEntity.getClearTs()"})
  void testGetClearTs() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getClearTs());
  }

  /**
   * Test {@link AbstractAlarmEntity#getCustomerId()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getCustomerId()}
   */
  @Test
  @DisplayName("Test getCustomerId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractAlarmEntity.getCustomerId()"})
  void testGetCustomerId() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getCustomerId());
  }

  /**
   * Test {@link AbstractAlarmEntity#getDetails()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getDetails()}
   */
  @Test
  @DisplayName("Test getDetails()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode AbstractAlarmEntity.getDetails()"})
  void testGetDetails() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getDetails());
  }

  /**
   * Test {@link AbstractAlarmEntity#getEndTs()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getEndTs()}
   */
  @Test
  @DisplayName("Test getEndTs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AbstractAlarmEntity.getEndTs()"})
  void testGetEndTs() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getEndTs());
  }

  /**
   * Test {@link AbstractAlarmEntity#getOriginatorId()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getOriginatorId()}
   */
  @Test
  @DisplayName("Test getOriginatorId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractAlarmEntity.getOriginatorId()"})
  void testGetOriginatorId() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getOriginatorId());
  }

  /**
   * Test {@link AbstractAlarmEntity#getOriginatorType()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getOriginatorType()}
   */
  @Test
  @DisplayName("Test getOriginatorType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType AbstractAlarmEntity.getOriginatorType()"})
  void testGetOriginatorType() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getOriginatorType());
  }

  /**
   * Test {@link AbstractAlarmEntity#getPropagateRelationTypes()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getPropagateRelationTypes()}
   */
  @Test
  @DisplayName("Test getPropagateRelationTypes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractAlarmEntity.getPropagateRelationTypes()"})
  void testGetPropagateRelationTypes() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getPropagateRelationTypes());
  }

  /**
   * Test {@link AbstractAlarmEntity#getPropagateToOwner()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} PropagateToOwner is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getPropagateToOwner()}
   */
  @Test
  @DisplayName(
      "Test getPropagateToOwner(); given AlarmEntity() PropagateToOwner is 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AbstractAlarmEntity.getPropagateToOwner()"})
  void testGetPropagateToOwner_givenAlarmEntityPropagateToOwnerIsFalse_thenReturnFalse() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setPropagateToOwner(false);

    // Act and Assert
    assertFalse(alarmEntity.getPropagateToOwner());
  }

  /**
   * Test {@link AbstractAlarmEntity#getPropagateToOwner()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} PropagateToOwner is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getPropagateToOwner()}
   */
  @Test
  @DisplayName(
      "Test getPropagateToOwner(); given AlarmEntity() PropagateToOwner is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AbstractAlarmEntity.getPropagateToOwner()"})
  void testGetPropagateToOwner_givenAlarmEntityPropagateToOwnerIsTrue_thenReturnTrue() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setPropagateToOwner(true);

    // Act and Assert
    assertTrue(alarmEntity.getPropagateToOwner());
  }

  /**
   * Test {@link AbstractAlarmEntity#getPropagateToOwner()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getPropagateToOwner()}
   */
  @Test
  @DisplayName("Test getPropagateToOwner(); given AlarmEntity(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AbstractAlarmEntity.getPropagateToOwner()"})
  void testGetPropagateToOwner_givenAlarmEntity_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getPropagateToOwner());
  }

  /**
   * Test {@link AbstractAlarmEntity#getPropagateToTenant()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} PropagateToTenant is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getPropagateToTenant()}
   */
  @Test
  @DisplayName(
      "Test getPropagateToTenant(); given AlarmEntity() PropagateToTenant is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AbstractAlarmEntity.getPropagateToTenant()"})
  void testGetPropagateToTenant_givenAlarmEntityPropagateToTenantIsTrue_thenReturnTrue() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setPropagateToTenant(true);

    // Act and Assert
    assertTrue(alarmEntity.getPropagateToTenant());
  }

  /**
   * Test {@link AbstractAlarmEntity#getPropagateToTenant()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getPropagateToTenant()}
   */
  @Test
  @DisplayName("Test getPropagateToTenant(); given AlarmEntity(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AbstractAlarmEntity.getPropagateToTenant()"})
  void testGetPropagateToTenant_givenAlarmEntity_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getPropagateToTenant());
  }

  /**
   * Test {@link AbstractAlarmEntity#getPropagateToTenant()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getPropagateToTenant()}
   */
  @Test
  @DisplayName("Test getPropagateToTenant(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AbstractAlarmEntity.getPropagateToTenant()"})
  void testGetPropagateToTenant_thenReturnFalse() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setPropagateToTenant(false);

    // Act and Assert
    assertFalse(alarmEntity.getPropagateToTenant());
  }

  /**
   * Test {@link AbstractAlarmEntity#getPropagate()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} Propagate is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getPropagate()}
   */
  @Test
  @DisplayName("Test getPropagate(); given AlarmEntity() Propagate is 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AbstractAlarmEntity.getPropagate()"})
  void testGetPropagate_givenAlarmEntityPropagateIsFalse_thenReturnFalse() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setPropagate(false);

    // Act and Assert
    assertFalse(alarmEntity.getPropagate());
  }

  /**
   * Test {@link AbstractAlarmEntity#getPropagate()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} Propagate is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getPropagate()}
   */
  @Test
  @DisplayName("Test getPropagate(); given AlarmEntity() Propagate is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AbstractAlarmEntity.getPropagate()"})
  void testGetPropagate_givenAlarmEntityPropagateIsTrue_thenReturnTrue() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setPropagate(true);

    // Act and Assert
    assertTrue(alarmEntity.getPropagate());
  }

  /**
   * Test {@link AbstractAlarmEntity#getPropagate()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getPropagate()}
   */
  @Test
  @DisplayName("Test getPropagate(); given AlarmEntity(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AbstractAlarmEntity.getPropagate()"})
  void testGetPropagate_givenAlarmEntity_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getPropagate());
  }

  /**
   * Test {@link AbstractAlarmEntity#getSeverity()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getSeverity()}
   */
  @Test
  @DisplayName("Test getSeverity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmSeverity AbstractAlarmEntity.getSeverity()"})
  void testGetSeverity() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getSeverity());
  }

  /**
   * Test {@link AbstractAlarmEntity#getStartTs()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getStartTs()}
   */
  @Test
  @DisplayName("Test getStartTs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AbstractAlarmEntity.getStartTs()"})
  void testGetStartTs() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getStartTs());
  }

  /**
   * Test {@link AbstractAlarmEntity#getTenantId()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractAlarmEntity.getTenantId()"})
  void testGetTenantId() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getTenantId());
  }

  /**
   * Test {@link AbstractAlarmEntity#getType()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractAlarmEntity.getType()"})
  void testGetType() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getType());
  }

  /**
   * Test {@link AbstractAlarmEntity#isAcknowledged()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} Acknowledged is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmEntity#isAcknowledged()}
   */
  @Test
  @DisplayName(
      "Test isAcknowledged(); given AlarmEntity() Acknowledged is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractAlarmEntity.isAcknowledged()"})
  void testIsAcknowledged_givenAlarmEntityAcknowledgedIsTrue_thenReturnTrue() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAcknowledged(true);

    // Act and Assert
    assertTrue(alarmEntity.isAcknowledged());
  }

  /**
   * Test {@link AbstractAlarmEntity#isAcknowledged()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmEntity#isAcknowledged()}
   */
  @Test
  @DisplayName("Test isAcknowledged(); given AlarmEntity(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractAlarmEntity.isAcknowledged()"})
  void testIsAcknowledged_givenAlarmEntity_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new AlarmEntity().isAcknowledged());
  }

  /**
   * Test {@link AbstractAlarmEntity#isCleared()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} Cleared is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmEntity#isCleared()}
   */
  @Test
  @DisplayName("Test isCleared(); given AlarmEntity() Cleared is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractAlarmEntity.isCleared()"})
  void testIsCleared_givenAlarmEntityClearedIsTrue_thenReturnTrue() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setCleared(true);

    // Act and Assert
    assertTrue(alarmEntity.isCleared());
  }

  /**
   * Test {@link AbstractAlarmEntity#isCleared()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmEntity#isCleared()}
   */
  @Test
  @DisplayName("Test isCleared(); given AlarmEntity(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractAlarmEntity.isCleared()"})
  void testIsCleared_givenAlarmEntity_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new AlarmEntity().isCleared());
  }

  /**
   * Test {@link AbstractAlarmEntity#setAckTs(Long)}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#setAckTs(Long)}
   */
  @Test
  @DisplayName("Test setAckTs(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setAckTs(Long)"})
  void testSetAckTs() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    // Act
    alarmEntity.setAckTs(1L);

    // Assert
    assertEquals(1L, alarmEntity.getAckTs().longValue());
  }

  /**
   * Test {@link AbstractAlarmEntity#setAcknowledged(boolean)}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#setAcknowledged(boolean)}
   */
  @Test
  @DisplayName("Test setAcknowledged(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setAcknowledged(boolean)"})
  void testSetAcknowledged() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    // Act
    alarmEntity.setAcknowledged(true);

    // Assert
    assertTrue(alarmEntity.isAcknowledged());
  }

  /**
   * Test {@link AbstractAlarmEntity#setAssignTs(Long)}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#setAssignTs(Long)}
   */
  @Test
  @DisplayName("Test setAssignTs(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setAssignTs(Long)"})
  void testSetAssignTs() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    // Act
    alarmEntity.setAssignTs(1L);

    // Assert
    assertEquals(1L, alarmEntity.getAssignTs().longValue());
  }

  /**
   * Test {@link AbstractAlarmEntity#setAssigneeId(UUID)}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#setAssigneeId(UUID)}
   */
  @Test
  @DisplayName("Test setAssigneeId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setAssigneeId(UUID)"})
  void testSetAssigneeId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    UUID assigneeId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    alarmEntity.setAssigneeId(assigneeId);

    // Assert
    assertSame(assigneeId, alarmEntity.getAssigneeId());
  }

  /**
   * Test {@link AbstractAlarmEntity#setClearTs(Long)}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#setClearTs(Long)}
   */
  @Test
  @DisplayName("Test setClearTs(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setClearTs(Long)"})
  void testSetClearTs() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    // Act
    alarmEntity.setClearTs(1L);

    // Assert
    assertEquals(1L, alarmEntity.getClearTs().longValue());
  }

  /**
   * Test {@link AbstractAlarmEntity#setCleared(boolean)}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#setCleared(boolean)}
   */
  @Test
  @DisplayName("Test setCleared(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setCleared(boolean)"})
  void testSetCleared() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    // Act
    alarmEntity.setCleared(true);

    // Assert
    assertTrue(alarmEntity.isCleared());
  }

  /**
   * Test {@link AbstractAlarmEntity#setCustomerId(UUID)}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#setCustomerId(UUID)}
   */
  @Test
  @DisplayName("Test setCustomerId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setCustomerId(UUID)"})
  void testSetCustomerId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    alarmEntity.setCustomerId(customerId);

    // Assert
    assertSame(customerId, alarmEntity.getCustomerId());
  }

  /**
   * Test {@link AbstractAlarmEntity#setDetails(JsonNode)}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#setDetails(JsonNode)}
   */
  @Test
  @DisplayName("Test setDetails(JsonNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setDetails(JsonNode)"})
  void testSetDetails() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    JsonNode details = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    alarmEntity.setDetails(details);

    // Assert
    assertSame(details, alarmEntity.getDetails());
  }

  /**
   * Test {@link AbstractAlarmEntity#setEndTs(Long)}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#setEndTs(Long)}
   */
  @Test
  @DisplayName("Test setEndTs(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setEndTs(Long)"})
  void testSetEndTs() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    // Act
    alarmEntity.setEndTs(1L);

    // Assert
    assertEquals(1L, alarmEntity.getEndTs().longValue());
  }

  /**
   * Test {@link AbstractAlarmEntity#setOriginatorId(UUID)}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#setOriginatorId(UUID)}
   */
  @Test
  @DisplayName("Test setOriginatorId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setOriginatorId(UUID)"})
  void testSetOriginatorId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    alarmEntity.setOriginatorId(originatorId);

    // Assert
    assertSame(originatorId, alarmEntity.getOriginatorId());
  }

  /**
   * Test {@link AbstractAlarmEntity#setOriginatorType(EntityType)}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#setOriginatorType(EntityType)}
   */
  @Test
  @DisplayName("Test setOriginatorType(EntityType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setOriginatorType(EntityType)"})
  void testSetOriginatorType() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    // Act
    alarmEntity.setOriginatorType(EntityType.TENANT);

    // Assert
    assertEquals(EntityType.TENANT, alarmEntity.getOriginatorType());
  }

  /**
   * Test {@link AbstractAlarmEntity#setPropagate(Boolean)}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#setPropagate(Boolean)}
   */
  @Test
  @DisplayName("Test setPropagate(Boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setPropagate(Boolean)"})
  void testSetPropagate() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    // Act
    alarmEntity.setPropagate(true);

    // Assert
    assertTrue(alarmEntity.getPropagate());
  }

  /**
   * Test {@link AbstractAlarmEntity#setPropagateRelationTypes(String)}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#setPropagateRelationTypes(String)}
   */
  @Test
  @DisplayName("Test setPropagateRelationTypes(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setPropagateRelationTypes(String)"})
  void testSetPropagateRelationTypes() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    // Act
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");

    // Assert
    assertEquals("Propagate Relation Types", alarmEntity.getPropagateRelationTypes());
  }

  /**
   * Test {@link AbstractAlarmEntity#setPropagateToOwner(Boolean)}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#setPropagateToOwner(Boolean)}
   */
  @Test
  @DisplayName("Test setPropagateToOwner(Boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setPropagateToOwner(Boolean)"})
  void testSetPropagateToOwner() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    // Act
    alarmEntity.setPropagateToOwner(true);

    // Assert
    assertTrue(alarmEntity.getPropagateToOwner());
  }

  /**
   * Test {@link AbstractAlarmEntity#setPropagateToTenant(Boolean)}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#setPropagateToTenant(Boolean)}
   */
  @Test
  @DisplayName("Test setPropagateToTenant(Boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setPropagateToTenant(Boolean)"})
  void testSetPropagateToTenant() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    // Act
    alarmEntity.setPropagateToTenant(true);

    // Assert
    assertTrue(alarmEntity.getPropagateToTenant());
  }

  /**
   * Test {@link AbstractAlarmEntity#setSeverity(AlarmSeverity)}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#setSeverity(AlarmSeverity)}
   */
  @Test
  @DisplayName("Test setSeverity(AlarmSeverity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setSeverity(AlarmSeverity)"})
  void testSetSeverity() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    // Act
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);

    // Assert
    assertEquals(AlarmSeverity.CRITICAL, alarmEntity.getSeverity());
  }

  /**
   * Test {@link AbstractAlarmEntity#setStartTs(Long)}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#setStartTs(Long)}
   */
  @Test
  @DisplayName("Test setStartTs(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setStartTs(Long)"})
  void testSetStartTs() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    // Act
    alarmEntity.setStartTs(1L);

    // Assert
    assertEquals(1L, alarmEntity.getStartTs().longValue());
  }

  /**
   * Test {@link AbstractAlarmEntity#setTenantId(UUID)}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#setTenantId(UUID)}
   */
  @Test
  @DisplayName("Test setTenantId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setTenantId(UUID)"})
  void testSetTenantId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    alarmEntity.setTenantId(tenantId);

    // Assert
    assertSame(tenantId, alarmEntity.getTenantId());
  }

  /**
   * Test {@link AbstractAlarmEntity#setType(String)}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#setType(String)}
   */
  @Test
  @DisplayName("Test setType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setType(String)"})
  void testSetType() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    // Act
    alarmEntity.setType("Type");

    // Assert
    assertEquals("Type", alarmEntity.getType());
  }

  /**
   * Test {@link AbstractAlarmEntity#toString()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractAlarmEntity.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("AlarmEntity()", new AlarmEntity().toString());
  }
}
