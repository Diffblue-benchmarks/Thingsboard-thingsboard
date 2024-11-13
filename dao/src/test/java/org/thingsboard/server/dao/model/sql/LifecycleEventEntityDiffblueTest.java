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
import org.thingsboard.server.common.data.event.LifecycleEvent;
import org.thingsboard.server.common.data.id.EventId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class LifecycleEventEntityDiffblueTest {
  /**
   * Test {@link LifecycleEventEntity#equals(Object)}, and
   * {@link LifecycleEventEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LifecycleEventEntity#equals(Object)}
   *   <li>{@link LifecycleEventEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(ModelConstants.NULL_UUID);

    LifecycleEventEntity lifecycleEventEntity2 = new LifecycleEventEntity();
    lifecycleEventEntity2.setCreatedTime(1L);
    lifecycleEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    lifecycleEventEntity2.setError("An error occurred");
    lifecycleEventEntity2.setEventType("Event Type");
    lifecycleEventEntity2.setId(ModelConstants.NULL_UUID);
    lifecycleEventEntity2.setServiceId("42");
    lifecycleEventEntity2.setSuccess(true);
    lifecycleEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    lifecycleEventEntity2.setTs(1L);
    lifecycleEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(lifecycleEventEntity, lifecycleEventEntity2);
    int expectedHashCodeResult = lifecycleEventEntity.hashCode();
    assertEquals(expectedHashCodeResult, lifecycleEventEntity2.hashCode());
  }

  /**
   * Test {@link LifecycleEventEntity#equals(Object)}, and
   * {@link LifecycleEventEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LifecycleEventEntity#equals(Object)}
   *   <li>{@link LifecycleEventEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(lifecycleEventEntity, lifecycleEventEntity);
    int expectedHashCodeResult = lifecycleEventEntity.hashCode();
    assertEquals(expectedHashCodeResult, lifecycleEventEntity.hashCode());
  }

  /**
   * Test {@link LifecycleEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(UUID.randomUUID());
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(ModelConstants.NULL_UUID);

    LifecycleEventEntity lifecycleEventEntity2 = new LifecycleEventEntity();
    lifecycleEventEntity2.setCreatedTime(1L);
    lifecycleEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    lifecycleEventEntity2.setError("An error occurred");
    lifecycleEventEntity2.setEventType("Event Type");
    lifecycleEventEntity2.setId(ModelConstants.NULL_UUID);
    lifecycleEventEntity2.setServiceId("42");
    lifecycleEventEntity2.setSuccess(true);
    lifecycleEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    lifecycleEventEntity2.setTs(1L);
    lifecycleEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(lifecycleEventEntity, lifecycleEventEntity2);
  }

  /**
   * Test {@link LifecycleEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setError("42");
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(ModelConstants.NULL_UUID);

    LifecycleEventEntity lifecycleEventEntity2 = new LifecycleEventEntity();
    lifecycleEventEntity2.setCreatedTime(1L);
    lifecycleEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    lifecycleEventEntity2.setError("An error occurred");
    lifecycleEventEntity2.setEventType("Event Type");
    lifecycleEventEntity2.setId(ModelConstants.NULL_UUID);
    lifecycleEventEntity2.setServiceId("42");
    lifecycleEventEntity2.setSuccess(true);
    lifecycleEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    lifecycleEventEntity2.setTs(1L);
    lifecycleEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(lifecycleEventEntity, lifecycleEventEntity2);
  }

  /**
   * Test {@link LifecycleEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setError(null);
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(ModelConstants.NULL_UUID);

    LifecycleEventEntity lifecycleEventEntity2 = new LifecycleEventEntity();
    lifecycleEventEntity2.setCreatedTime(1L);
    lifecycleEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    lifecycleEventEntity2.setError("An error occurred");
    lifecycleEventEntity2.setEventType("Event Type");
    lifecycleEventEntity2.setId(ModelConstants.NULL_UUID);
    lifecycleEventEntity2.setServiceId("42");
    lifecycleEventEntity2.setSuccess(true);
    lifecycleEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    lifecycleEventEntity2.setTs(1L);
    lifecycleEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(lifecycleEventEntity, lifecycleEventEntity2);
  }

  /**
   * Test {@link LifecycleEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType("42");
    lifecycleEventEntity.setId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(ModelConstants.NULL_UUID);

    LifecycleEventEntity lifecycleEventEntity2 = new LifecycleEventEntity();
    lifecycleEventEntity2.setCreatedTime(1L);
    lifecycleEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    lifecycleEventEntity2.setError("An error occurred");
    lifecycleEventEntity2.setEventType("Event Type");
    lifecycleEventEntity2.setId(ModelConstants.NULL_UUID);
    lifecycleEventEntity2.setServiceId("42");
    lifecycleEventEntity2.setSuccess(true);
    lifecycleEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    lifecycleEventEntity2.setTs(1L);
    lifecycleEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(lifecycleEventEntity, lifecycleEventEntity2);
  }

  /**
   * Test {@link LifecycleEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType(null);
    lifecycleEventEntity.setId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(ModelConstants.NULL_UUID);

    LifecycleEventEntity lifecycleEventEntity2 = new LifecycleEventEntity();
    lifecycleEventEntity2.setCreatedTime(1L);
    lifecycleEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    lifecycleEventEntity2.setError("An error occurred");
    lifecycleEventEntity2.setEventType("Event Type");
    lifecycleEventEntity2.setId(ModelConstants.NULL_UUID);
    lifecycleEventEntity2.setServiceId("42");
    lifecycleEventEntity2.setSuccess(true);
    lifecycleEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    lifecycleEventEntity2.setTs(1L);
    lifecycleEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(lifecycleEventEntity, lifecycleEventEntity2);
  }

  /**
   * Test {@link LifecycleEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(false);
    lifecycleEventEntity.setTenantId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(ModelConstants.NULL_UUID);

    LifecycleEventEntity lifecycleEventEntity2 = new LifecycleEventEntity();
    lifecycleEventEntity2.setCreatedTime(1L);
    lifecycleEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    lifecycleEventEntity2.setError("An error occurred");
    lifecycleEventEntity2.setEventType("Event Type");
    lifecycleEventEntity2.setId(ModelConstants.NULL_UUID);
    lifecycleEventEntity2.setServiceId("42");
    lifecycleEventEntity2.setSuccess(true);
    lifecycleEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    lifecycleEventEntity2.setTs(1L);
    lifecycleEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(lifecycleEventEntity, lifecycleEventEntity2);
  }

  /**
   * Test {@link LifecycleEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(lifecycleEventEntity, null);
  }

  /**
   * Test {@link LifecycleEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(lifecycleEventEntity, "Different type to LifecycleEventEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LifecycleEventEntity#LifecycleEventEntity()}
   *   <li>{@link LifecycleEventEntity#setError(String)}
   *   <li>{@link LifecycleEventEntity#setEventType(String)}
   *   <li>{@link LifecycleEventEntity#setSuccess(boolean)}
   *   <li>{@link LifecycleEventEntity#toString()}
   *   <li>{@link LifecycleEventEntity#getError()}
   *   <li>{@link LifecycleEventEntity#getEventType()}
   *   <li>{@link LifecycleEventEntity#isSuccess()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    LifecycleEventEntity actualLifecycleEventEntity = new LifecycleEventEntity();
    actualLifecycleEventEntity.setError("An error occurred");
    actualLifecycleEventEntity.setEventType("Event Type");
    actualLifecycleEventEntity.setSuccess(true);
    String actualToStringResult = actualLifecycleEventEntity.toString();
    String actualError = actualLifecycleEventEntity.getError();
    String actualEventType = actualLifecycleEventEntity.getEventType();
    boolean actualIsSuccessResult = actualLifecycleEventEntity.isSuccess();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualError);
    assertEquals("Event Type", actualEventType);
    assertEquals("LifecycleEventEntity(eventType=Event Type, success=true, error=An error occurred)",
        actualToStringResult);
    assertEquals(0L, actualLifecycleEventEntity.getCreatedTime());
    assertEquals(0L, actualLifecycleEventEntity.getTs());
    assertTrue(actualIsSuccessResult);
  }

  /**
   * Test {@link LifecycleEventEntity#LifecycleEventEntity(LifecycleEvent)}.
   * <p>
   * Method under test:
   * {@link LifecycleEventEntity#LifecycleEventEntity(LifecycleEvent)}
   */
  @Test
  public void testNewLifecycleEventEntity() {
    // Arrange
    LifecycleEvent event = LifecycleEvent.builder()
        .entityId(ModelConstants.NULL_UUID)
        .error("An error occurred")
        .id(ModelConstants.NULL_UUID)
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .ts(1L)
        .build();

    // Act
    LifecycleEventEntity actualLifecycleEventEntity = new LifecycleEventEntity(event);

    // Assert
    UUID entityId = actualLifecycleEventEntity.getEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.toString());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualLifecycleEventEntity.getTenantId().toString());
    assertEquals("42", actualLifecycleEventEntity.getServiceId());
    assertEquals("An error occurred", actualLifecycleEventEntity.getError());
    assertEquals("Lc Event Type", actualLifecycleEventEntity.getEventType());
    assertEquals(1L, actualLifecycleEventEntity.getCreatedTime());
    assertEquals(1L, actualLifecycleEventEntity.getTs());
    assertTrue(actualLifecycleEventEntity.isSuccess());
    assertSame(entityId, actualLifecycleEventEntity.getId());
    assertSame(entityId, actualLifecycleEventEntity.getUuid());
  }

  /**
   * Test {@link LifecycleEventEntity#LifecycleEventEntity(LifecycleEvent)}.
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls {@link BaseData#getCreatedTime()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LifecycleEventEntity#LifecycleEventEntity(LifecycleEvent)}
   */
  @Test
  public void testNewLifecycleEventEntity_givenSystem_tenant_thenCallsGetCreatedTime() {
    // Arrange
    LifecycleEvent event = mock(LifecycleEvent.class);
    when(event.isSuccess()).thenReturn(true);
    when(event.getServiceId()).thenReturn("42");
    when(event.getError()).thenReturn("An error occurred");
    when(event.getLcEventType()).thenReturn("Lc Event Type");
    when(event.getEntityId()).thenReturn(ModelConstants.NULL_UUID);
    when(event.getCreatedTime()).thenReturn(1L);
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(event.getId()).thenReturn(new EventId(ModelConstants.NULL_UUID));

    // Act
    LifecycleEventEntity actualLifecycleEventEntity = new LifecycleEventEntity(event);

    // Assert
    verify(event).getCreatedTime();
    verify(event).getEntityId();
    verify(event).getServiceId();
    verify(event).getTenantId();
    verify(event).getError();
    verify(event).getLcEventType();
    verify(event).isSuccess();
    verify(event).getId();
    UUID entityId = actualLifecycleEventEntity.getEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.toString());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualLifecycleEventEntity.getTenantId().toString());
    assertEquals("42", actualLifecycleEventEntity.getServiceId());
    assertEquals("An error occurred", actualLifecycleEventEntity.getError());
    assertEquals("Lc Event Type", actualLifecycleEventEntity.getEventType());
    assertEquals(1L, actualLifecycleEventEntity.getCreatedTime());
    assertEquals(1L, actualLifecycleEventEntity.getTs());
    assertTrue(actualLifecycleEventEntity.isSuccess());
    assertSame(entityId, actualLifecycleEventEntity.getId());
    assertSame(entityId, actualLifecycleEventEntity.getUuid());
  }

  /**
   * Test {@link LifecycleEventEntity#toData()}.
   * <ul>
   *   <li>Given {@link LifecycleEventEntity#LifecycleEventEntity()}.</li>
   *   <li>Then return ServiceId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEventEntity#toData()}
   */
  @Test
  public void testToData_givenLifecycleEventEntity_thenReturnServiceIdIsNull() {
    // Arrange and Act
    LifecycleEvent actualToDataResult = (new LifecycleEventEntity()).toData();

    // Assert
    assertNull(actualToDataResult.getServiceId());
    assertNull(actualToDataResult.getError());
    assertNull(actualToDataResult.getLcEventType());
    assertNull(actualToDataResult.getEntityId());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getTenantId().getId());
    assertNull(actualToDataResult.getId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isSuccess());
  }

  /**
   * Test {@link LifecycleEventEntity#toData()}.
   * <ul>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEventEntity#toData()}
   */
  @Test
  public void testToData_thenReturnNotTenantIdNullUid() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    UUID tenantId = UUID.randomUUID();
    lifecycleEventEntity.setTenantId(tenantId);
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(ModelConstants.NULL_UUID);

    // Act
    LifecycleEvent actualToDataResult = lifecycleEventEntity.toData();

    // Assert
    UUID entityId = actualToDataResult.getEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.toString());
    assertEquals("42", actualToDataResult.getServiceId());
    assertEquals("An error occurred", actualToDataResult.getError());
    assertEquals("Event Type", actualToDataResult.getLcEventType());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(actualToDataResult.isSuccess());
    assertSame(entityId, actualToDataResult.getUuidId());
    assertSame(entityId, actualToDataResult.getId().getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link LifecycleEventEntity#toData()}.
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEventEntity#toData()}
   */
  @Test
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(ModelConstants.NULL_UUID);

    // Act
    LifecycleEvent actualToDataResult = lifecycleEventEntity.toData();

    // Assert
    UUID entityId = actualToDataResult.getEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.toString());
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("42", actualToDataResult.getServiceId());
    assertEquals("An error occurred", actualToDataResult.getError());
    assertEquals("Event Type", actualToDataResult.getLcEventType());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertTrue(actualToDataResult.isSuccess());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, actualToDataResult.getUuidId());
    assertSame(entityId, actualToDataResult.getId().getId());
  }
}
