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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class AbstractAlarmEntityDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractAlarmEntity.canEqual(Object)"})
  public void testCanEqual_whenAlarmEntity_thenReturnTrue() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractAlarmEntity.canEqual(Object)"})
  public void testCanEqual_whenOther_thenReturnFalse() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractAlarmEntity.equals(Object)",
    "int AbstractAlarmEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractAlarmEntity.equals(Object)",
    "int AbstractAlarmEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractAlarmEntity.equals(Object)",
    "int AbstractAlarmEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(1L);
    adminSettingsEntity.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity.setKey("Key");
    adminSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractAlarmEntity.equals(Object)",
    "int AbstractAlarmEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    AlarmEntity alarmEntity2 = mock(AlarmEntity.class);
    when(alarmEntity2.isAcknowledged()).thenReturn(true);
    when(alarmEntity2.isCleared()).thenReturn(true);
    when(alarmEntity2.getStartTs()).thenReturn(1L);
    when(alarmEntity2.getId()).thenReturn(ModelConstants.NULL_UUID);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractAlarmEntity.equals(Object)",
    "int AbstractAlarmEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractAlarmEntity.equals(Object)",
    "int AbstractAlarmEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmEntity(), "Different type to AbstractAlarmEntity");
  }

  /**
   * Test {@link AbstractAlarmEntity#getAckTs()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getAckTs()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AbstractAlarmEntity.getAckTs()"})
  public void testGetAckTs() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getAckTs());
  }

  /**
   * Test {@link AbstractAlarmEntity#getAssignTs()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getAssignTs()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AbstractAlarmEntity.getAssignTs()"})
  public void testGetAssignTs() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getAssignTs());
  }

  /**
   * Test {@link AbstractAlarmEntity#getAssigneeId()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getAssigneeId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractAlarmEntity.getAssigneeId()"})
  public void testGetAssigneeId() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getAssigneeId());
  }

  /**
   * Test {@link AbstractAlarmEntity#getClearTs()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getClearTs()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AbstractAlarmEntity.getClearTs()"})
  public void testGetClearTs() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getClearTs());
  }

  /**
   * Test {@link AbstractAlarmEntity#getCustomerId()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getCustomerId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractAlarmEntity.getCustomerId()"})
  public void testGetCustomerId() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getCustomerId());
  }

  /**
   * Test {@link AbstractAlarmEntity#getDetails()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getDetails()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode AbstractAlarmEntity.getDetails()"})
  public void testGetDetails() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getDetails());
  }

  /**
   * Test {@link AbstractAlarmEntity#getEndTs()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getEndTs()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AbstractAlarmEntity.getEndTs()"})
  public void testGetEndTs() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getEndTs());
  }

  /**
   * Test {@link AbstractAlarmEntity#getOriginatorId()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getOriginatorId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractAlarmEntity.getOriginatorId()"})
  public void testGetOriginatorId() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getOriginatorId());
  }

  /**
   * Test {@link AbstractAlarmEntity#getOriginatorType()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getOriginatorType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType AbstractAlarmEntity.getOriginatorType()"})
  public void testGetOriginatorType() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getOriginatorType());
  }

  /**
   * Test {@link AbstractAlarmEntity#getPropagateRelationTypes()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getPropagateRelationTypes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractAlarmEntity.getPropagateRelationTypes()"})
  public void testGetPropagateRelationTypes() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AbstractAlarmEntity.getPropagateToOwner()"})
  public void testGetPropagateToOwner_givenAlarmEntityPropagateToOwnerIsFalse_thenReturnFalse() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AbstractAlarmEntity.getPropagateToOwner()"})
  public void testGetPropagateToOwner_givenAlarmEntityPropagateToOwnerIsTrue_thenReturnTrue() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AbstractAlarmEntity.getPropagateToOwner()"})
  public void testGetPropagateToOwner_givenAlarmEntity_thenReturnNull() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AbstractAlarmEntity.getPropagateToTenant()"})
  public void testGetPropagateToTenant_givenAlarmEntityPropagateToTenantIsTrue_thenReturnTrue() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AbstractAlarmEntity.getPropagateToTenant()"})
  public void testGetPropagateToTenant_givenAlarmEntity_thenReturnNull() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AbstractAlarmEntity.getPropagateToTenant()"})
  public void testGetPropagateToTenant_thenReturnFalse() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AbstractAlarmEntity.getPropagate()"})
  public void testGetPropagate_givenAlarmEntityPropagateIsFalse_thenReturnFalse() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AbstractAlarmEntity.getPropagate()"})
  public void testGetPropagate_givenAlarmEntityPropagateIsTrue_thenReturnTrue() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AbstractAlarmEntity.getPropagate()"})
  public void testGetPropagate_givenAlarmEntity_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getPropagate());
  }

  /**
   * Test {@link AbstractAlarmEntity#getSeverity()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getSeverity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmSeverity AbstractAlarmEntity.getSeverity()"})
  public void testGetSeverity() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getSeverity());
  }

  /**
   * Test {@link AbstractAlarmEntity#getStartTs()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getStartTs()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AbstractAlarmEntity.getStartTs()"})
  public void testGetStartTs() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getStartTs());
  }

  /**
   * Test {@link AbstractAlarmEntity#getTenantId()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getTenantId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractAlarmEntity.getTenantId()"})
  public void testGetTenantId() {
    // Arrange, Act and Assert
    assertNull(new AlarmEntity().getTenantId());
  }

  /**
   * Test {@link AbstractAlarmEntity#getType()}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractAlarmEntity.getType()"})
  public void testGetType() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractAlarmEntity.isAcknowledged()"})
  public void testIsAcknowledged_givenAlarmEntityAcknowledgedIsTrue_thenReturnTrue() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractAlarmEntity.isAcknowledged()"})
  public void testIsAcknowledged_givenAlarmEntity_thenReturnFalse() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractAlarmEntity.isCleared()"})
  public void testIsCleared_givenAlarmEntityClearedIsTrue_thenReturnTrue() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractAlarmEntity.isCleared()"})
  public void testIsCleared_givenAlarmEntity_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new AlarmEntity().isCleared());
  }

  /**
   * Test {@link AbstractAlarmEntity#setAckTs(Long)}.
   *
   * <p>Method under test: {@link AbstractAlarmEntity#setAckTs(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setAckTs(Long)"})
  public void testSetAckTs() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setAcknowledged(boolean)"})
  public void testSetAcknowledged() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setAssignTs(Long)"})
  public void testSetAssignTs() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setAssigneeId(UUID)"})
  public void testSetAssigneeId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    UUID assigneeId = ModelConstants.NULL_UUID;

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setClearTs(Long)"})
  public void testSetClearTs() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setCleared(boolean)"})
  public void testSetCleared() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setCustomerId(UUID)"})
  public void testSetCustomerId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    UUID customerId = ModelConstants.NULL_UUID;

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setDetails(JsonNode)"})
  public void testSetDetails() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setEndTs(Long)"})
  public void testSetEndTs() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setOriginatorId(UUID)"})
  public void testSetOriginatorId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    UUID originatorId = ModelConstants.NULL_UUID;

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setOriginatorType(EntityType)"})
  public void testSetOriginatorType() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setPropagate(Boolean)"})
  public void testSetPropagate() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setPropagateRelationTypes(String)"})
  public void testSetPropagateRelationTypes() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setPropagateToOwner(Boolean)"})
  public void testSetPropagateToOwner() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setPropagateToTenant(Boolean)"})
  public void testSetPropagateToTenant() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setSeverity(AlarmSeverity)"})
  public void testSetSeverity() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setStartTs(Long)"})
  public void testSetStartTs() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setTenantId(UUID)"})
  public void testSetTenantId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    UUID tenantId = ModelConstants.NULL_UUID;

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAlarmEntity.setType(String)"})
  public void testSetType() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractAlarmEntity.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("AlarmEntity()", new AlarmEntity().toString());
  }
}
