package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleNodeState;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class RuleNodeStateEntityDiffblueTest {
  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}, and
   * {@link RuleNodeStateEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeStateEntity#equals(Object)}
   *   <li>{@link RuleNodeStateEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
    int expectedHashCodeResult = ruleNodeStateEntity.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeStateEntity2.hashCode());
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}, and
   * {@link RuleNodeStateEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeStateEntity#equals(Object)}
   *   <li>{@link RuleNodeStateEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(ruleNodeStateEntity, ruleNodeStateEntity);
    int expectedHashCodeResult = ruleNodeStateEntity.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeStateEntity.hashCode());
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(3L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(UUID.randomUUID());
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(null);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("MD");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType(null);
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(UUID.randomUUID());
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(null);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("Entity Type");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData(null);
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeStateEntity, null);
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeStateEntity, "Different type to RuleNodeStateEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeStateEntity#RuleNodeStateEntity()}
   *   <li>{@link RuleNodeStateEntity#setEntityId(UUID)}
   *   <li>{@link RuleNodeStateEntity#setEntityType(String)}
   *   <li>{@link RuleNodeStateEntity#setRuleNodeId(UUID)}
   *   <li>{@link RuleNodeStateEntity#setStateData(String)}
   *   <li>{@link RuleNodeStateEntity#toString()}
   *   <li>{@link RuleNodeStateEntity#getEntityId()}
   *   <li>{@link RuleNodeStateEntity#getEntityType()}
   *   <li>{@link RuleNodeStateEntity#getRuleNodeId()}
   *   <li>{@link RuleNodeStateEntity#getStateData()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    RuleNodeStateEntity actualRuleNodeStateEntity = new RuleNodeStateEntity();
    actualRuleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    actualRuleNodeStateEntity.setEntityType("Entity Type");
    UUID ruleNodeId = ModelConstants.NULL_UUID;
    actualRuleNodeStateEntity.setRuleNodeId(ruleNodeId);
    actualRuleNodeStateEntity.setStateData("MD");
    String actualToStringResult = actualRuleNodeStateEntity.toString();
    UUID actualEntityId = actualRuleNodeStateEntity.getEntityId();
    String actualEntityType = actualRuleNodeStateEntity.getEntityType();
    UUID actualRuleNodeId = actualRuleNodeStateEntity.getRuleNodeId();
    String actualStateData = actualRuleNodeStateEntity.getStateData();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.toString());
    assertEquals("Entity Type", actualEntityType);
    assertEquals("MD", actualStateData);
    assertEquals("RuleNodeStateEntity(ruleNodeId=13814000-1dd2-11b2-8080-808080808080, entityType=Entity Type,"
        + " entityId=13814000-1dd2-11b2-8080-808080808080, stateData=MD)", actualToStringResult);
    assertEquals(0L, actualRuleNodeStateEntity.getCreatedTime());
    assertSame(ruleNodeId, actualEntityId);
    assertSame(ruleNodeId, actualRuleNodeId);
  }

  /**
   * Test {@link RuleNodeStateEntity#RuleNodeStateEntity(RuleNodeState)}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return EntityType is {@code CUSTOMER}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleNodeStateEntity#RuleNodeStateEntity(RuleNodeState)}
   */
  @Test
  public void testNewRuleNodeStateEntity_givenNull_customer_id_thenReturnEntityTypeIsCustomer() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    RuleNodeStateEntity actualRuleNodeStateEntity = new RuleNodeStateEntity(ruleNodeState);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualRuleNodeStateEntity.getEntityId().toString());
    assertEquals("CUSTOMER", actualRuleNodeStateEntity.getEntityType());
    assertNull(actualRuleNodeStateEntity.getStateData());
    assertNull(actualRuleNodeStateEntity.getId());
    assertNull(actualRuleNodeStateEntity.getUuid());
    assertNull(actualRuleNodeStateEntity.getRuleNodeId());
    assertEquals(0L, actualRuleNodeStateEntity.getCreatedTime());
  }

  /**
   * Test {@link RuleNodeStateEntity#RuleNodeStateEntity(RuleNodeState)}.
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return EntityType is {@code TENANT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleNodeStateEntity#RuleNodeStateEntity(RuleNodeState)}
   */
  @Test
  public void testNewRuleNodeStateEntity_givenSystem_tenant_thenReturnEntityTypeIsTenant() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setEntityId(ModelConstants.SYSTEM_TENANT);

    // Act
    RuleNodeStateEntity actualRuleNodeStateEntity = new RuleNodeStateEntity(ruleNodeState);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualRuleNodeStateEntity.getEntityId().toString());
    assertEquals("TENANT", actualRuleNodeStateEntity.getEntityType());
    assertNull(actualRuleNodeStateEntity.getStateData());
    assertNull(actualRuleNodeStateEntity.getId());
    assertNull(actualRuleNodeStateEntity.getUuid());
    assertNull(actualRuleNodeStateEntity.getRuleNodeId());
    assertEquals(0L, actualRuleNodeStateEntity.getCreatedTime());
  }

  /**
   * Test {@link RuleNodeStateEntity#toData()}.
   * <ul>
   *   <li>Given {@link RuleNodeState#RuleNodeState()} EntityId is
   * {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then EntityId return {@link TenantId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#toData()}
   */
  @Test
  public void testToData_givenRuleNodeStateEntityIdIsSystem_tenant_thenEntityIdReturnTenantId() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setEntityId(ModelConstants.SYSTEM_TENANT);

    // Act
    RuleNodeState actualToDataResult = (new RuleNodeStateEntity(ruleNodeState)).toData();

    // Assert
    EntityId entityId = actualToDataResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    RuleNodeId ruleNodeId = actualToDataResult.getRuleNodeId();
    assertNull(ruleNodeId.getId());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertFalse(ruleNodeId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
  }

  /**
   * Test {@link RuleNodeStateEntity#toData()}.
   * <ul>
   *   <li>Then EntityId return {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#toData()}
   */
  @Test
  public void testToData_thenEntityIdReturnAlarmId() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    AlarmId entityId = new AlarmId(ModelConstants.NULL_UUID);
    ruleNodeState.setEntityId(entityId);

    // Act
    RuleNodeState actualToDataResult = (new RuleNodeStateEntity(ruleNodeState)).toData();

    // Assert
    EntityId entityId2 = actualToDataResult.getEntityId();
    assertTrue(entityId2 instanceof AlarmId);
    RuleNodeId ruleNodeId = actualToDataResult.getRuleNodeId();
    assertNull(ruleNodeId.getId());
    assertFalse(ruleNodeId.isNullUid());
    assertEquals(entityId, entityId2);
  }

  /**
   * Test {@link RuleNodeStateEntity#toData()}.
   * <ul>
   *   <li>Then EntityId return {@link ApiUsageStateId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#toData()}
   */
  @Test
  public void testToData_thenEntityIdReturnApiUsageStateId() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    ApiUsageStateId entityId = new ApiUsageStateId(ModelConstants.NULL_UUID);
    ruleNodeState.setEntityId(entityId);

    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity(ruleNodeState);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);

    // Act
    RuleNodeState actualToDataResult = ruleNodeStateEntity.toData();

    // Assert
    EntityId entityId2 = actualToDataResult.getEntityId();
    assertTrue(entityId2 instanceof ApiUsageStateId);
    RuleNodeId ruleNodeId = actualToDataResult.getRuleNodeId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", ruleNodeId.getId().toString());
    assertTrue(ruleNodeId.isNullUid());
    assertEquals(entityId, entityId2);
  }

  /**
   * Test {@link RuleNodeStateEntity#toData()}.
   * <ul>
   *   <li>Then EntityId return {@link AssetId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#toData()}
   */
  @Test
  public void testToData_thenEntityIdReturnAssetId() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    AssetId entityId = new AssetId(ModelConstants.NULL_UUID);
    ruleNodeState.setEntityId(entityId);

    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity(ruleNodeState);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);

    // Act
    RuleNodeState actualToDataResult = ruleNodeStateEntity.toData();

    // Assert
    EntityId entityId2 = actualToDataResult.getEntityId();
    assertTrue(entityId2 instanceof AssetId);
    RuleNodeId ruleNodeId = actualToDataResult.getRuleNodeId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", ruleNodeId.getId().toString());
    assertTrue(ruleNodeId.isNullUid());
    assertEquals(entityId, entityId2);
  }

  /**
   * Test {@link RuleNodeStateEntity#toData()}.
   * <ul>
   *   <li>Then EntityId return {@link AssetProfileId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#toData()}
   */
  @Test
  public void testToData_thenEntityIdReturnAssetProfileId() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    AssetProfileId entityId = new AssetProfileId(ModelConstants.NULL_UUID);
    ruleNodeState.setEntityId(entityId);

    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity(ruleNodeState);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);

    // Act
    RuleNodeState actualToDataResult = ruleNodeStateEntity.toData();

    // Assert
    EntityId entityId2 = actualToDataResult.getEntityId();
    assertTrue(entityId2 instanceof AssetProfileId);
    RuleNodeId ruleNodeId = actualToDataResult.getRuleNodeId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", ruleNodeId.getId().toString());
    assertTrue(ruleNodeId.isNullUid());
    assertEquals(entityId, entityId2);
  }

  /**
   * Test {@link RuleNodeStateEntity#toData()}.
   * <ul>
   *   <li>Then EntityId return {@link CustomerId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#toData()}
   */
  @Test
  public void testToData_thenEntityIdReturnCustomerId() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    RuleNodeState actualToDataResult = (new RuleNodeStateEntity(ruleNodeState)).toData();

    // Assert
    EntityId entityId = actualToDataResult.getEntityId();
    assertTrue(entityId instanceof CustomerId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    RuleNodeId ruleNodeId = actualToDataResult.getRuleNodeId();
    assertNull(ruleNodeId.getId());
    assertEquals(EntityType.CUSTOMER, entityId.getEntityType());
    assertFalse(ruleNodeId.isNullUid());
  }

  /**
   * Test {@link RuleNodeStateEntity#toData()}.
   * <ul>
   *   <li>Then EntityId return {@link DashboardId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#toData()}
   */
  @Test
  public void testToData_thenEntityIdReturnDashboardId() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    DashboardId entityId = new DashboardId(ModelConstants.NULL_UUID);
    ruleNodeState.setEntityId(entityId);

    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity(ruleNodeState);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);

    // Act
    RuleNodeState actualToDataResult = ruleNodeStateEntity.toData();

    // Assert
    EntityId entityId2 = actualToDataResult.getEntityId();
    assertTrue(entityId2 instanceof DashboardId);
    RuleNodeId ruleNodeId = actualToDataResult.getRuleNodeId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", ruleNodeId.getId().toString());
    assertTrue(ruleNodeId.isNullUid());
    assertEquals(entityId, entityId2);
  }
}
