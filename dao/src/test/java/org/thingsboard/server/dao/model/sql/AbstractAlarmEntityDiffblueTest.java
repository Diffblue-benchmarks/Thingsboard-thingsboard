package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class AbstractAlarmEntityDiffblueTest {
  /**
   * Test {@link AbstractAlarmEntity#canEqual(Object)}.
   * <ul>
   *   <li>When {@link AlarmEntity#AlarmEntity()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#canEqual(Object)}
   */
  @Test
  public void testCanEqual_whenAlarmEntity_thenReturnTrue() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    // Act and Assert
    assertTrue(alarmEntity.canEqual(new AlarmEntity()));
  }

  /**
   * Test {@link AbstractAlarmEntity#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#canEqual(Object)}
   */
  @Test
  public void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AlarmEntity()).canEqual("Other"));
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}, and
   * {@link AbstractAlarmEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    AlarmEntity alarmEntity2 = new AlarmEntity();

    // Act and Assert
    assertEquals(alarmEntity, alarmEntity2);
    int expectedHashCodeResult = alarmEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmEntity2.hashCode());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}, and
   * {@link AbstractAlarmEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmEntity(), mock(AlarmInfoEntity.class));
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmEntity, new AlarmEntity());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmEntity, new AlarmEntity());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmEntity, new AlarmEntity());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setOriginatorType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(alarmEntity, new AlarmEntity());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setType("Type");

    // Act and Assert
    assertNotEquals(alarmEntity, new AlarmEntity());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);

    // Act and Assert
    assertNotEquals(alarmEntity, new AlarmEntity());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmEntity, new AlarmEntity());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setStartTs(1L);

    // Act and Assert
    assertNotEquals(alarmEntity, new AlarmEntity());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setEndTs(1L);

    // Act and Assert
    assertNotEquals(alarmEntity, new AlarmEntity());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAcknowledged(true);

    // Act and Assert
    assertNotEquals(alarmEntity, new AlarmEntity());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);

    // Act and Assert
    assertNotEquals(alarmEntity, new AlarmEntity());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setCleared(true);

    // Act and Assert
    assertNotEquals(alarmEntity, new AlarmEntity());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setClearTs(1L);

    // Act and Assert
    assertNotEquals(alarmEntity, new AlarmEntity());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAssignTs(1L);

    // Act and Assert
    assertNotEquals(alarmEntity, new AlarmEntity());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertNotEquals(alarmEntity, new AlarmEntity());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setPropagate(true);

    // Act and Assert
    assertNotEquals(alarmEntity, new AlarmEntity());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setPropagateToOwner(true);

    // Act and Assert
    assertNotEquals(alarmEntity, new AlarmEntity());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setPropagateToTenant(true);

    // Act and Assert
    assertNotEquals(alarmEntity, new AlarmEntity());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");

    // Act and Assert
    assertNotEquals(alarmEntity, new AlarmEntity());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmEntity, new AlarmEntity());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmEntity, alarmEntity2);
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setCustomerId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmEntity, alarmEntity2);
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setOriginatorId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmEntity, alarmEntity2);
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setOriginatorType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(alarmEntity, alarmEntity2);
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setType("Type");

    // Act and Assert
    assertNotEquals(alarmEntity, alarmEntity2);
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual28() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setSeverity(AlarmSeverity.CRITICAL);

    // Act and Assert
    assertNotEquals(alarmEntity, alarmEntity2);
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual29() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setAssigneeId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmEntity, alarmEntity2);
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual30() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setStartTs(1L);

    // Act and Assert
    assertNotEquals(alarmEntity, alarmEntity2);
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual31() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setEndTs(1L);

    // Act and Assert
    assertNotEquals(alarmEntity, alarmEntity2);
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual32() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setAckTs(1L);

    // Act and Assert
    assertNotEquals(alarmEntity, alarmEntity2);
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual33() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setClearTs(1L);

    // Act and Assert
    assertNotEquals(alarmEntity, alarmEntity2);
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual34() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setAssignTs(1L);

    // Act and Assert
    assertNotEquals(alarmEntity, alarmEntity2);
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual35() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertNotEquals(alarmEntity, alarmEntity2);
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual36() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setPropagate(true);

    // Act and Assert
    assertNotEquals(alarmEntity, alarmEntity2);
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual37() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setPropagateToOwner(true);

    // Act and Assert
    assertNotEquals(alarmEntity, alarmEntity2);
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual38() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setPropagateToTenant(true);

    // Act and Assert
    assertNotEquals(alarmEntity, alarmEntity2);
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual39() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setPropagateRelationTypes("Propagate Relation Types");

    // Act and Assert
    assertNotEquals(alarmEntity, alarmEntity2);
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmEntity(), null);
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmEntity(), "Different type to AbstractAlarmEntity");
  }

  /**
   * Test {@link AbstractAlarmEntity#getAckTs()}.
   * <p>
   * Method under test: {@link AbstractAlarmEntity#getAckTs()}
   */
  @Test
  public void testGetAckTs() {
    // Arrange, Act and Assert
    assertNull((new AlarmEntity()).getAckTs());
  }

  /**
   * Test {@link AbstractAlarmEntity#getAssignTs()}.
   * <p>
   * Method under test: {@link AbstractAlarmEntity#getAssignTs()}
   */
  @Test
  public void testGetAssignTs() {
    // Arrange, Act and Assert
    assertNull((new AlarmEntity()).getAssignTs());
  }

  /**
   * Test {@link AbstractAlarmEntity#getAssigneeId()}.
   * <p>
   * Method under test: {@link AbstractAlarmEntity#getAssigneeId()}
   */
  @Test
  public void testGetAssigneeId() {
    // Arrange, Act and Assert
    assertNull((new AlarmEntity()).getAssigneeId());
  }

  /**
   * Test {@link AbstractAlarmEntity#getClearTs()}.
   * <p>
   * Method under test: {@link AbstractAlarmEntity#getClearTs()}
   */
  @Test
  public void testGetClearTs() {
    // Arrange, Act and Assert
    assertNull((new AlarmEntity()).getClearTs());
  }

  /**
   * Test {@link AbstractAlarmEntity#getCustomerId()}.
   * <p>
   * Method under test: {@link AbstractAlarmEntity#getCustomerId()}
   */
  @Test
  public void testGetCustomerId() {
    // Arrange, Act and Assert
    assertNull((new AlarmEntity()).getCustomerId());
  }

  /**
   * Test {@link AbstractAlarmEntity#getDetails()}.
   * <p>
   * Method under test: {@link AbstractAlarmEntity#getDetails()}
   */
  @Test
  public void testGetDetails() {
    // Arrange, Act and Assert
    assertNull((new AlarmEntity()).getDetails());
  }

  /**
   * Test {@link AbstractAlarmEntity#getEndTs()}.
   * <p>
   * Method under test: {@link AbstractAlarmEntity#getEndTs()}
   */
  @Test
  public void testGetEndTs() {
    // Arrange, Act and Assert
    assertNull((new AlarmEntity()).getEndTs());
  }

  /**
   * Test {@link AbstractAlarmEntity#getOriginatorId()}.
   * <p>
   * Method under test: {@link AbstractAlarmEntity#getOriginatorId()}
   */
  @Test
  public void testGetOriginatorId() {
    // Arrange, Act and Assert
    assertNull((new AlarmEntity()).getOriginatorId());
  }

  /**
   * Test {@link AbstractAlarmEntity#getOriginatorType()}.
   * <p>
   * Method under test: {@link AbstractAlarmEntity#getOriginatorType()}
   */
  @Test
  public void testGetOriginatorType() {
    // Arrange, Act and Assert
    assertNull((new AlarmEntity()).getOriginatorType());
  }

  /**
   * Test {@link AbstractAlarmEntity#getPropagateRelationTypes()}.
   * <p>
   * Method under test: {@link AbstractAlarmEntity#getPropagateRelationTypes()}
   */
  @Test
  public void testGetPropagateRelationTypes() {
    // Arrange, Act and Assert
    assertNull((new AlarmEntity()).getPropagateRelationTypes());
  }

  /**
   * Test {@link AbstractAlarmEntity#getPropagateToOwner()}.
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} PropagateToOwner is
   * {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#getPropagateToOwner()}
   */
  @Test
  public void testGetPropagateToOwner_givenAlarmEntityPropagateToOwnerIsFalse_thenReturnFalse() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setPropagateToOwner(false);

    // Act and Assert
    assertFalse(alarmEntity.getPropagateToOwner());
  }

  /**
   * Test {@link AbstractAlarmEntity#getPropagateToOwner()}.
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} PropagateToOwner is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#getPropagateToOwner()}
   */
  @Test
  public void testGetPropagateToOwner_givenAlarmEntityPropagateToOwnerIsTrue_thenReturnTrue() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setPropagateToOwner(true);

    // Act and Assert
    assertTrue(alarmEntity.getPropagateToOwner());
  }

  /**
   * Test {@link AbstractAlarmEntity#getPropagateToOwner()}.
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#getPropagateToOwner()}
   */
  @Test
  public void testGetPropagateToOwner_givenAlarmEntity_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AlarmEntity()).getPropagateToOwner());
  }

  /**
   * Test {@link AbstractAlarmEntity#getPropagateToTenant()}.
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} PropagateToTenant is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#getPropagateToTenant()}
   */
  @Test
  public void testGetPropagateToTenant_givenAlarmEntityPropagateToTenantIsTrue_thenReturnTrue() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setPropagateToTenant(true);

    // Act and Assert
    assertTrue(alarmEntity.getPropagateToTenant());
  }

  /**
   * Test {@link AbstractAlarmEntity#getPropagateToTenant()}.
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#getPropagateToTenant()}
   */
  @Test
  public void testGetPropagateToTenant_givenAlarmEntity_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AlarmEntity()).getPropagateToTenant());
  }

  /**
   * Test {@link AbstractAlarmEntity#getPropagateToTenant()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#getPropagateToTenant()}
   */
  @Test
  public void testGetPropagateToTenant_thenReturnFalse() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setPropagateToTenant(false);

    // Act and Assert
    assertFalse(alarmEntity.getPropagateToTenant());
  }

  /**
   * Test {@link AbstractAlarmEntity#getPropagate()}.
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} Propagate is {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#getPropagate()}
   */
  @Test
  public void testGetPropagate_givenAlarmEntityPropagateIsFalse_thenReturnFalse() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setPropagate(false);

    // Act and Assert
    assertFalse(alarmEntity.getPropagate());
  }

  /**
   * Test {@link AbstractAlarmEntity#getPropagate()}.
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} Propagate is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#getPropagate()}
   */
  @Test
  public void testGetPropagate_givenAlarmEntityPropagateIsTrue_thenReturnTrue() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setPropagate(true);

    // Act and Assert
    assertTrue(alarmEntity.getPropagate());
  }

  /**
   * Test {@link AbstractAlarmEntity#getPropagate()}.
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#getPropagate()}
   */
  @Test
  public void testGetPropagate_givenAlarmEntity_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AlarmEntity()).getPropagate());
  }

  /**
   * Test {@link AbstractAlarmEntity#getSeverity()}.
   * <p>
   * Method under test: {@link AbstractAlarmEntity#getSeverity()}
   */
  @Test
  public void testGetSeverity() {
    // Arrange, Act and Assert
    assertNull((new AlarmEntity()).getSeverity());
  }

  /**
   * Test {@link AbstractAlarmEntity#getStartTs()}.
   * <p>
   * Method under test: {@link AbstractAlarmEntity#getStartTs()}
   */
  @Test
  public void testGetStartTs() {
    // Arrange, Act and Assert
    assertNull((new AlarmEntity()).getStartTs());
  }

  /**
   * Test {@link AbstractAlarmEntity#getTenantId()}.
   * <p>
   * Method under test: {@link AbstractAlarmEntity#getTenantId()}
   */
  @Test
  public void testGetTenantId() {
    // Arrange, Act and Assert
    assertNull((new AlarmEntity()).getTenantId());
  }

  /**
   * Test {@link AbstractAlarmEntity#getType()}.
   * <p>
   * Method under test: {@link AbstractAlarmEntity#getType()}
   */
  @Test
  public void testGetType() {
    // Arrange, Act and Assert
    assertNull((new AlarmEntity()).getType());
  }

  /**
   * Test {@link AbstractAlarmEntity#isAcknowledged()}.
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} Acknowledged is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#isAcknowledged()}
   */
  @Test
  public void testIsAcknowledged_givenAlarmEntityAcknowledgedIsTrue_thenReturnTrue() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAcknowledged(true);

    // Act and Assert
    assertTrue(alarmEntity.isAcknowledged());
  }

  /**
   * Test {@link AbstractAlarmEntity#isAcknowledged()}.
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#isAcknowledged()}
   */
  @Test
  public void testIsAcknowledged_givenAlarmEntity_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AlarmEntity()).isAcknowledged());
  }

  /**
   * Test {@link AbstractAlarmEntity#isCleared()}.
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} Cleared is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#isCleared()}
   */
  @Test
  public void testIsCleared_givenAlarmEntityClearedIsTrue_thenReturnTrue() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setCleared(true);

    // Act and Assert
    assertTrue(alarmEntity.isCleared());
  }

  /**
   * Test {@link AbstractAlarmEntity#isCleared()}.
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#isCleared()}
   */
  @Test
  public void testIsCleared_givenAlarmEntity_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AlarmEntity()).isCleared());
  }

  /**
   * Test {@link AbstractAlarmEntity#setAckTs(Long)}.
   * <p>
   * Method under test: {@link AbstractAlarmEntity#setAckTs(Long)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractAlarmEntity#setAcknowledged(boolean)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractAlarmEntity#setAssignTs(Long)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractAlarmEntity#setAssigneeId(UUID)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractAlarmEntity#setClearTs(Long)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractAlarmEntity#setCleared(boolean)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractAlarmEntity#setCustomerId(UUID)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractAlarmEntity#setDetails(JsonNode)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractAlarmEntity#setEndTs(Long)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractAlarmEntity#setOriginatorId(UUID)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractAlarmEntity#setOriginatorType(EntityType)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractAlarmEntity#setPropagate(Boolean)}
   */
  @Test
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
   * <p>
   * Method under test:
   * {@link AbstractAlarmEntity#setPropagateRelationTypes(String)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractAlarmEntity#setPropagateToOwner(Boolean)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractAlarmEntity#setPropagateToTenant(Boolean)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractAlarmEntity#setSeverity(AlarmSeverity)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractAlarmEntity#setStartTs(Long)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractAlarmEntity#setTenantId(UUID)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractAlarmEntity#setType(String)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractAlarmEntity#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("AlarmEntity()", (new AlarmEntity()).toString());
  }
}
