package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.BaseData;
import org.thingsboard.server.common.data.event.RuleChainDebugEvent;
import org.thingsboard.server.common.data.id.EventId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class RuleChainDebugEventEntityDiffblueTest {
  /**
   * Test {@link RuleChainDebugEventEntity#equals(Object)}, and
   * {@link RuleChainDebugEventEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainDebugEventEntity#equals(Object)}
   *   <li>{@link RuleChainDebugEventEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleChainDebugEventEntity ruleChainDebugEventEntity = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity.setCreatedTime(1L);
    ruleChainDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setError("An error occurred");
    ruleChainDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity.setServiceId("42");
    ruleChainDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setTs(1L);
    ruleChainDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleChainDebugEventEntity ruleChainDebugEventEntity2 = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity2.setCreatedTime(1L);
    ruleChainDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity2.setError("An error occurred");
    ruleChainDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity2.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity2.setServiceId("42");
    ruleChainDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity2.setTs(1L);
    ruleChainDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(ruleChainDebugEventEntity, ruleChainDebugEventEntity2);
    int expectedHashCodeResult = ruleChainDebugEventEntity.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainDebugEventEntity2.hashCode());
  }

  /**
   * Test {@link RuleChainDebugEventEntity#equals(Object)}, and
   * {@link RuleChainDebugEventEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainDebugEventEntity#equals(Object)}
   *   <li>{@link RuleChainDebugEventEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChainDebugEventEntity ruleChainDebugEventEntity = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity.setCreatedTime(1L);
    ruleChainDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setError("An error occurred");
    ruleChainDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity.setServiceId("42");
    ruleChainDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setTs(1L);
    ruleChainDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(ruleChainDebugEventEntity, ruleChainDebugEventEntity);
    int expectedHashCodeResult = ruleChainDebugEventEntity.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainDebugEventEntity.hashCode());
  }

  /**
   * Test {@link RuleChainDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainDebugEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleChainDebugEventEntity ruleChainDebugEventEntity = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity.setCreatedTime(1L);
    ruleChainDebugEventEntity.setEntityId(UUID.randomUUID());
    ruleChainDebugEventEntity.setError("An error occurred");
    ruleChainDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity.setServiceId("42");
    ruleChainDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setTs(1L);
    ruleChainDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleChainDebugEventEntity ruleChainDebugEventEntity2 = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity2.setCreatedTime(1L);
    ruleChainDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity2.setError("An error occurred");
    ruleChainDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity2.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity2.setServiceId("42");
    ruleChainDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity2.setTs(1L);
    ruleChainDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleChainDebugEventEntity, ruleChainDebugEventEntity2);
  }

  /**
   * Test {@link RuleChainDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainDebugEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleChainDebugEventEntity ruleChainDebugEventEntity = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity.setCreatedTime(1L);
    ruleChainDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setError("42");
    ruleChainDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity.setServiceId("42");
    ruleChainDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setTs(1L);
    ruleChainDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleChainDebugEventEntity ruleChainDebugEventEntity2 = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity2.setCreatedTime(1L);
    ruleChainDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity2.setError("An error occurred");
    ruleChainDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity2.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity2.setServiceId("42");
    ruleChainDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity2.setTs(1L);
    ruleChainDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleChainDebugEventEntity, ruleChainDebugEventEntity2);
  }

  /**
   * Test {@link RuleChainDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainDebugEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleChainDebugEventEntity ruleChainDebugEventEntity = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity.setCreatedTime(1L);
    ruleChainDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setError(null);
    ruleChainDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity.setServiceId("42");
    ruleChainDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setTs(1L);
    ruleChainDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleChainDebugEventEntity ruleChainDebugEventEntity2 = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity2.setCreatedTime(1L);
    ruleChainDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity2.setError("An error occurred");
    ruleChainDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity2.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity2.setServiceId("42");
    ruleChainDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity2.setTs(1L);
    ruleChainDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleChainDebugEventEntity, ruleChainDebugEventEntity2);
  }

  /**
   * Test {@link RuleChainDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainDebugEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleChainDebugEventEntity ruleChainDebugEventEntity = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity.setCreatedTime(1L);
    ruleChainDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setError("An error occurred");
    ruleChainDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setMessage("42");
    ruleChainDebugEventEntity.setServiceId("42");
    ruleChainDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setTs(1L);
    ruleChainDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleChainDebugEventEntity ruleChainDebugEventEntity2 = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity2.setCreatedTime(1L);
    ruleChainDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity2.setError("An error occurred");
    ruleChainDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity2.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity2.setServiceId("42");
    ruleChainDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity2.setTs(1L);
    ruleChainDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleChainDebugEventEntity, ruleChainDebugEventEntity2);
  }

  /**
   * Test {@link RuleChainDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainDebugEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleChainDebugEventEntity ruleChainDebugEventEntity = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity.setCreatedTime(1L);
    ruleChainDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setError("An error occurred");
    ruleChainDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setMessage(null);
    ruleChainDebugEventEntity.setServiceId("42");
    ruleChainDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setTs(1L);
    ruleChainDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleChainDebugEventEntity ruleChainDebugEventEntity2 = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity2.setCreatedTime(1L);
    ruleChainDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity2.setError("An error occurred");
    ruleChainDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity2.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity2.setServiceId("42");
    ruleChainDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity2.setTs(1L);
    ruleChainDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleChainDebugEventEntity, ruleChainDebugEventEntity2);
  }

  /**
   * Test {@link RuleChainDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainDebugEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleChainDebugEventEntity ruleChainDebugEventEntity = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity.setCreatedTime(1L);
    ruleChainDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setError("An error occurred");
    ruleChainDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity.setServiceId("42");
    ruleChainDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setTs(1L);
    ruleChainDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleChainDebugEventEntity, null);
  }

  /**
   * Test {@link RuleChainDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainDebugEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleChainDebugEventEntity ruleChainDebugEventEntity = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity.setCreatedTime(1L);
    ruleChainDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setError("An error occurred");
    ruleChainDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity.setServiceId("42");
    ruleChainDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setTs(1L);
    ruleChainDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleChainDebugEventEntity, "Different type to RuleChainDebugEventEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainDebugEventEntity#RuleChainDebugEventEntity()}
   *   <li>{@link RuleChainDebugEventEntity#setError(String)}
   *   <li>{@link RuleChainDebugEventEntity#setMessage(String)}
   *   <li>{@link RuleChainDebugEventEntity#toString()}
   *   <li>{@link RuleChainDebugEventEntity#getError()}
   *   <li>{@link RuleChainDebugEventEntity#getMessage()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    RuleChainDebugEventEntity actualRuleChainDebugEventEntity = new RuleChainDebugEventEntity();
    actualRuleChainDebugEventEntity.setError("An error occurred");
    actualRuleChainDebugEventEntity.setMessage("Not all who wander are lost");
    String actualToStringResult = actualRuleChainDebugEventEntity.toString();
    String actualError = actualRuleChainDebugEventEntity.getError();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualError);
    assertEquals("Not all who wander are lost", actualRuleChainDebugEventEntity.getMessage());
    assertEquals("RuleChainDebugEventEntity(message=Not all who wander are lost, error=An error occurred)",
        actualToStringResult);
    assertEquals(0L, actualRuleChainDebugEventEntity.getCreatedTime());
    assertEquals(0L, actualRuleChainDebugEventEntity.getTs());
  }

  /**
   * Test
   * {@link RuleChainDebugEventEntity#RuleChainDebugEventEntity(RuleChainDebugEvent)}.
   * <p>
   * Method under test:
   * {@link RuleChainDebugEventEntity#RuleChainDebugEventEntity(RuleChainDebugEvent)}
   */
  @Test
  public void testNewRuleChainDebugEventEntity() {
    // Arrange
    RuleChainDebugEvent event = RuleChainDebugEvent.builder()
        .entityId(ModelConstants.NULL_UUID)
        .error("An error occurred")
        .id(ModelConstants.NULL_UUID)
        .message("Not all who wander are lost")
        .serviceId("42")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .ts(1L)
        .build();

    // Act
    RuleChainDebugEventEntity actualRuleChainDebugEventEntity = new RuleChainDebugEventEntity(event);

    // Assert
    UUID entityId = actualRuleChainDebugEventEntity.getEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.toString());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualRuleChainDebugEventEntity.getTenantId().toString());
    assertEquals("42", actualRuleChainDebugEventEntity.getServiceId());
    assertEquals("An error occurred", actualRuleChainDebugEventEntity.getError());
    assertEquals("Not all who wander are lost", actualRuleChainDebugEventEntity.getMessage());
    assertEquals(1L, actualRuleChainDebugEventEntity.getCreatedTime());
    assertEquals(1L, actualRuleChainDebugEventEntity.getTs());
    assertSame(entityId, actualRuleChainDebugEventEntity.getId());
    assertSame(entityId, actualRuleChainDebugEventEntity.getUuid());
  }

  /**
   * Test
   * {@link RuleChainDebugEventEntity#RuleChainDebugEventEntity(RuleChainDebugEvent)}.
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls {@link BaseData#getCreatedTime()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainDebugEventEntity#RuleChainDebugEventEntity(RuleChainDebugEvent)}
   */
  @Test
  public void testNewRuleChainDebugEventEntity_givenSystem_tenant_thenCallsGetCreatedTime() {
    // Arrange
    RuleChainDebugEvent event = mock(RuleChainDebugEvent.class);
    when(event.getServiceId()).thenReturn("42");
    when(event.getError()).thenReturn("An error occurred");
    when(event.getMessage()).thenReturn("Not all who wander are lost");
    when(event.getEntityId()).thenReturn(ModelConstants.NULL_UUID);
    when(event.getCreatedTime()).thenReturn(1L);
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(event.getId()).thenReturn(new EventId(ModelConstants.NULL_UUID));

    // Act
    RuleChainDebugEventEntity actualRuleChainDebugEventEntity = new RuleChainDebugEventEntity(event);

    // Assert
    verify(event).getCreatedTime();
    verify(event).getEntityId();
    verify(event).getServiceId();
    verify(event).getTenantId();
    verify(event).getError();
    verify(event).getMessage();
    verify(event).getId();
    UUID entityId = actualRuleChainDebugEventEntity.getEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.toString());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualRuleChainDebugEventEntity.getTenantId().toString());
    assertEquals("42", actualRuleChainDebugEventEntity.getServiceId());
    assertEquals("An error occurred", actualRuleChainDebugEventEntity.getError());
    assertEquals("Not all who wander are lost", actualRuleChainDebugEventEntity.getMessage());
    assertEquals(1L, actualRuleChainDebugEventEntity.getCreatedTime());
    assertEquals(1L, actualRuleChainDebugEventEntity.getTs());
    assertSame(entityId, actualRuleChainDebugEventEntity.getId());
    assertSame(entityId, actualRuleChainDebugEventEntity.getUuid());
  }

  /**
   * Test {@link RuleChainDebugEventEntity#toData()}.
   * <ul>
   *   <li>Given {@link RuleChainDebugEventEntity#RuleChainDebugEventEntity()}.</li>
   *   <li>Then return ServiceId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainDebugEventEntity#toData()}
   */
  @Test
  public void testToData_givenRuleChainDebugEventEntity_thenReturnServiceIdIsNull() {
    // Arrange and Act
    RuleChainDebugEvent actualToDataResult = (new RuleChainDebugEventEntity()).toData();

    // Assert
    assertNull(actualToDataResult.getServiceId());
    assertNull(actualToDataResult.getError());
    assertNull(actualToDataResult.getMessage());
    assertNull(actualToDataResult.getEntityId());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getTenantId().getId());
    assertNull(actualToDataResult.getId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link RuleChainDebugEventEntity#toData()}.
   * <ul>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainDebugEventEntity#toData()}
   */
  @Test
  public void testToData_thenReturnNotTenantIdNullUid() {
    // Arrange
    RuleChainDebugEventEntity ruleChainDebugEventEntity = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity.setCreatedTime(1L);
    ruleChainDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setError("An error occurred");
    ruleChainDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity.setServiceId("42");
    UUID tenantId = UUID.randomUUID();
    ruleChainDebugEventEntity.setTenantId(tenantId);
    ruleChainDebugEventEntity.setTs(1L);
    ruleChainDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    // Act
    RuleChainDebugEvent actualToDataResult = ruleChainDebugEventEntity.toData();

    // Assert
    UUID entityId = actualToDataResult.getEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.toString());
    assertEquals("42", actualToDataResult.getServiceId());
    assertEquals("An error occurred", actualToDataResult.getError());
    assertEquals("Not all who wander are lost", actualToDataResult.getMessage());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(entityId, actualToDataResult.getUuidId());
    assertSame(entityId, actualToDataResult.getId().getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link RuleChainDebugEventEntity#toData()}.
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainDebugEventEntity#toData()}
   */
  @Test
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    RuleChainDebugEventEntity ruleChainDebugEventEntity = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity.setCreatedTime(1L);
    ruleChainDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setError("An error occurred");
    ruleChainDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity.setServiceId("42");
    ruleChainDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setTs(1L);
    ruleChainDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    // Act
    RuleChainDebugEvent actualToDataResult = ruleChainDebugEventEntity.toData();

    // Assert
    UUID entityId = actualToDataResult.getEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.toString());
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("42", actualToDataResult.getServiceId());
    assertEquals("An error occurred", actualToDataResult.getError());
    assertEquals("Not all who wander are lost", actualToDataResult.getMessage());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, actualToDataResult.getUuidId());
    assertSame(entityId, actualToDataResult.getId().getId());
  }
}
