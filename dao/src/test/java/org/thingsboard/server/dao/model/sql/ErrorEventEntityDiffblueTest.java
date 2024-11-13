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
import org.thingsboard.server.common.data.event.ErrorEvent;
import org.thingsboard.server.common.data.id.EventId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class ErrorEventEntityDiffblueTest {
  /**
   * Test {@link ErrorEventEntity#equals(Object)}, and
   * {@link ErrorEventEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorEventEntity#equals(Object)}
   *   <li>{@link ErrorEventEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(ModelConstants.NULL_UUID);
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(ModelConstants.NULL_UUID);
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(ModelConstants.NULL_UUID);
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(ModelConstants.NULL_UUID);

    ErrorEventEntity errorEventEntity2 = new ErrorEventEntity();
    errorEventEntity2.setCreatedTime(1L);
    errorEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    errorEventEntity2.setError("An error occurred");
    errorEventEntity2.setId(ModelConstants.NULL_UUID);
    errorEventEntity2.setMethod("Method");
    errorEventEntity2.setServiceId("42");
    errorEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    errorEventEntity2.setTs(1L);
    errorEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(errorEventEntity, errorEventEntity2);
    int expectedHashCodeResult = errorEventEntity.hashCode();
    assertEquals(expectedHashCodeResult, errorEventEntity2.hashCode());
  }

  /**
   * Test {@link ErrorEventEntity#equals(Object)}, and
   * {@link ErrorEventEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorEventEntity#equals(Object)}
   *   <li>{@link ErrorEventEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(ModelConstants.NULL_UUID);
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(ModelConstants.NULL_UUID);
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(ModelConstants.NULL_UUID);
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(errorEventEntity, errorEventEntity);
    int expectedHashCodeResult = errorEventEntity.hashCode();
    assertEquals(expectedHashCodeResult, errorEventEntity.hashCode());
  }

  /**
   * Test {@link ErrorEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(UUID.randomUUID());
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(ModelConstants.NULL_UUID);
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(ModelConstants.NULL_UUID);
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(ModelConstants.NULL_UUID);

    ErrorEventEntity errorEventEntity2 = new ErrorEventEntity();
    errorEventEntity2.setCreatedTime(1L);
    errorEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    errorEventEntity2.setError("An error occurred");
    errorEventEntity2.setId(ModelConstants.NULL_UUID);
    errorEventEntity2.setMethod("Method");
    errorEventEntity2.setServiceId("42");
    errorEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    errorEventEntity2.setTs(1L);
    errorEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(errorEventEntity, errorEventEntity2);
  }

  /**
   * Test {@link ErrorEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(ModelConstants.NULL_UUID);
    errorEventEntity.setError("42");
    errorEventEntity.setId(ModelConstants.NULL_UUID);
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(ModelConstants.NULL_UUID);
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(ModelConstants.NULL_UUID);

    ErrorEventEntity errorEventEntity2 = new ErrorEventEntity();
    errorEventEntity2.setCreatedTime(1L);
    errorEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    errorEventEntity2.setError("An error occurred");
    errorEventEntity2.setId(ModelConstants.NULL_UUID);
    errorEventEntity2.setMethod("Method");
    errorEventEntity2.setServiceId("42");
    errorEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    errorEventEntity2.setTs(1L);
    errorEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(errorEventEntity, errorEventEntity2);
  }

  /**
   * Test {@link ErrorEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(ModelConstants.NULL_UUID);
    errorEventEntity.setError(null);
    errorEventEntity.setId(ModelConstants.NULL_UUID);
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(ModelConstants.NULL_UUID);
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(ModelConstants.NULL_UUID);

    ErrorEventEntity errorEventEntity2 = new ErrorEventEntity();
    errorEventEntity2.setCreatedTime(1L);
    errorEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    errorEventEntity2.setError("An error occurred");
    errorEventEntity2.setId(ModelConstants.NULL_UUID);
    errorEventEntity2.setMethod("Method");
    errorEventEntity2.setServiceId("42");
    errorEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    errorEventEntity2.setTs(1L);
    errorEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(errorEventEntity, errorEventEntity2);
  }

  /**
   * Test {@link ErrorEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(ModelConstants.NULL_UUID);
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(ModelConstants.NULL_UUID);
    errorEventEntity.setMethod("42");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(ModelConstants.NULL_UUID);
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(ModelConstants.NULL_UUID);

    ErrorEventEntity errorEventEntity2 = new ErrorEventEntity();
    errorEventEntity2.setCreatedTime(1L);
    errorEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    errorEventEntity2.setError("An error occurred");
    errorEventEntity2.setId(ModelConstants.NULL_UUID);
    errorEventEntity2.setMethod("Method");
    errorEventEntity2.setServiceId("42");
    errorEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    errorEventEntity2.setTs(1L);
    errorEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(errorEventEntity, errorEventEntity2);
  }

  /**
   * Test {@link ErrorEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(ModelConstants.NULL_UUID);
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(ModelConstants.NULL_UUID);
    errorEventEntity.setMethod(null);
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(ModelConstants.NULL_UUID);
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(ModelConstants.NULL_UUID);

    ErrorEventEntity errorEventEntity2 = new ErrorEventEntity();
    errorEventEntity2.setCreatedTime(1L);
    errorEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    errorEventEntity2.setError("An error occurred");
    errorEventEntity2.setId(ModelConstants.NULL_UUID);
    errorEventEntity2.setMethod("Method");
    errorEventEntity2.setServiceId("42");
    errorEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    errorEventEntity2.setTs(1L);
    errorEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(errorEventEntity, errorEventEntity2);
  }

  /**
   * Test {@link ErrorEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(ModelConstants.NULL_UUID);
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(ModelConstants.NULL_UUID);
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(ModelConstants.NULL_UUID);
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(errorEventEntity, null);
  }

  /**
   * Test {@link ErrorEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorEventEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(ModelConstants.NULL_UUID);
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(ModelConstants.NULL_UUID);
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(ModelConstants.NULL_UUID);
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(errorEventEntity, "Different type to ErrorEventEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorEventEntity#ErrorEventEntity()}
   *   <li>{@link ErrorEventEntity#setError(String)}
   *   <li>{@link ErrorEventEntity#setMethod(String)}
   *   <li>{@link ErrorEventEntity#toString()}
   *   <li>{@link ErrorEventEntity#getError()}
   *   <li>{@link ErrorEventEntity#getMethod()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ErrorEventEntity actualErrorEventEntity = new ErrorEventEntity();
    actualErrorEventEntity.setError("An error occurred");
    actualErrorEventEntity.setMethod("Method");
    String actualToStringResult = actualErrorEventEntity.toString();
    String actualError = actualErrorEventEntity.getError();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualError);
    assertEquals("ErrorEventEntity(method=Method, error=An error occurred)", actualToStringResult);
    assertEquals("Method", actualErrorEventEntity.getMethod());
    assertEquals(0L, actualErrorEventEntity.getCreatedTime());
    assertEquals(0L, actualErrorEventEntity.getTs());
  }

  /**
   * Test {@link ErrorEventEntity#ErrorEventEntity(ErrorEvent)}.
   * <p>
   * Method under test: {@link ErrorEventEntity#ErrorEventEntity(ErrorEvent)}
   */
  @Test
  public void testNewErrorEventEntity() {
    // Arrange
    ErrorEvent event = ErrorEvent.builder()
        .entityId(ModelConstants.NULL_UUID)
        .error("An error occurred")
        .id(ModelConstants.NULL_UUID)
        .method("Method")
        .serviceId("42")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .ts(1L)
        .build();

    // Act
    ErrorEventEntity actualErrorEventEntity = new ErrorEventEntity(event);

    // Assert
    UUID entityId = actualErrorEventEntity.getEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.toString());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualErrorEventEntity.getTenantId().toString());
    assertEquals("42", actualErrorEventEntity.getServiceId());
    assertEquals("An error occurred", actualErrorEventEntity.getError());
    assertEquals("Method", actualErrorEventEntity.getMethod());
    assertEquals(1L, actualErrorEventEntity.getCreatedTime());
    assertEquals(1L, actualErrorEventEntity.getTs());
    assertSame(entityId, actualErrorEventEntity.getId());
    assertSame(entityId, actualErrorEventEntity.getUuid());
  }

  /**
   * Test {@link ErrorEventEntity#ErrorEventEntity(ErrorEvent)}.
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls {@link BaseData#getCreatedTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorEventEntity#ErrorEventEntity(ErrorEvent)}
   */
  @Test
  public void testNewErrorEventEntity_givenSystem_tenant_thenCallsGetCreatedTime() {
    // Arrange
    ErrorEvent event = mock(ErrorEvent.class);
    when(event.getError()).thenReturn("An error occurred");
    when(event.getMethod()).thenReturn("Method");
    when(event.getServiceId()).thenReturn("42");
    when(event.getEntityId()).thenReturn(ModelConstants.NULL_UUID);
    when(event.getCreatedTime()).thenReturn(1L);
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(event.getId()).thenReturn(new EventId(ModelConstants.NULL_UUID));

    // Act
    ErrorEventEntity actualErrorEventEntity = new ErrorEventEntity(event);

    // Assert
    verify(event).getCreatedTime();
    verify(event).getError();
    verify(event).getMethod();
    verify(event).getEntityId();
    verify(event).getServiceId();
    verify(event).getTenantId();
    verify(event).getId();
    UUID entityId = actualErrorEventEntity.getEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.toString());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualErrorEventEntity.getTenantId().toString());
    assertEquals("42", actualErrorEventEntity.getServiceId());
    assertEquals("An error occurred", actualErrorEventEntity.getError());
    assertEquals("Method", actualErrorEventEntity.getMethod());
    assertEquals(1L, actualErrorEventEntity.getCreatedTime());
    assertEquals(1L, actualErrorEventEntity.getTs());
    assertSame(entityId, actualErrorEventEntity.getId());
    assertSame(entityId, actualErrorEventEntity.getUuid());
  }

  /**
   * Test {@link ErrorEventEntity#toData()}.
   * <ul>
   *   <li>Given {@link ErrorEventEntity#ErrorEventEntity()}.</li>
   *   <li>Then return Error is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorEventEntity#toData()}
   */
  @Test
  public void testToData_givenErrorEventEntity_thenReturnErrorIsNull() {
    // Arrange and Act
    ErrorEvent actualToDataResult = (new ErrorEventEntity()).toData();

    // Assert
    assertNull(actualToDataResult.getError());
    assertNull(actualToDataResult.getMethod());
    assertNull(actualToDataResult.getServiceId());
    assertNull(actualToDataResult.getEntityId());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getTenantId().getId());
    assertNull(actualToDataResult.getId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link ErrorEventEntity#toData()}.
   * <ul>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorEventEntity#toData()}
   */
  @Test
  public void testToData_thenReturnNotTenantIdNullUid() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(ModelConstants.NULL_UUID);
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(ModelConstants.NULL_UUID);
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    UUID tenantId = UUID.randomUUID();
    errorEventEntity.setTenantId(tenantId);
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(ModelConstants.NULL_UUID);

    // Act
    ErrorEvent actualToDataResult = errorEventEntity.toData();

    // Assert
    UUID entityId = actualToDataResult.getEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.toString());
    assertEquals("42", actualToDataResult.getServiceId());
    assertEquals("An error occurred", actualToDataResult.getError());
    assertEquals("Method", actualToDataResult.getMethod());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(entityId, actualToDataResult.getUuidId());
    assertSame(entityId, actualToDataResult.getId().getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link ErrorEventEntity#toData()}.
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorEventEntity#toData()}
   */
  @Test
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(ModelConstants.NULL_UUID);
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(ModelConstants.NULL_UUID);
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(ModelConstants.NULL_UUID);
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(ModelConstants.NULL_UUID);

    // Act
    ErrorEvent actualToDataResult = errorEventEntity.toData();

    // Assert
    UUID entityId = actualToDataResult.getEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.toString());
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("42", actualToDataResult.getServiceId());
    assertEquals("An error occurred", actualToDataResult.getError());
    assertEquals("Method", actualToDataResult.getMethod());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, actualToDataResult.getUuidId());
    assertSame(entityId, actualToDataResult.getId().getId());
  }
}
