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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.event.StatisticsEvent;
import org.thingsboard.server.common.data.id.EventId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class StatisticsEventEntityDiffblueTest {
  /**
   * Test {@link StatisticsEventEntity#equals(Object)}, and {@link
   * StatisticsEventEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StatisticsEventEntity#equals(Object)}
   *   <li>{@link StatisticsEventEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StatisticsEventEntity.equals(Object)",
    "int StatisticsEventEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StatisticsEventEntity statisticsEventEntity = new StatisticsEventEntity();
    statisticsEventEntity.setCreatedTime(1L);
    statisticsEventEntity.setEntityId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setErrorsOccurred(-1L);
    statisticsEventEntity.setId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setMessagesProcessed(1L);
    statisticsEventEntity.setServiceId("42");
    statisticsEventEntity.setTenantId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setTs(1L);
    statisticsEventEntity.setUuid(ModelConstants.NULL_UUID);

    StatisticsEventEntity statisticsEventEntity2 = new StatisticsEventEntity();
    statisticsEventEntity2.setCreatedTime(1L);
    statisticsEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    statisticsEventEntity2.setErrorsOccurred(-1L);
    statisticsEventEntity2.setId(ModelConstants.NULL_UUID);
    statisticsEventEntity2.setMessagesProcessed(1L);
    statisticsEventEntity2.setServiceId("42");
    statisticsEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    statisticsEventEntity2.setTs(1L);
    statisticsEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(statisticsEventEntity, statisticsEventEntity2);
    assertEquals(statisticsEventEntity.hashCode(), statisticsEventEntity2.hashCode());
  }

  /**
   * Test {@link StatisticsEventEntity#equals(Object)}, and {@link
   * StatisticsEventEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StatisticsEventEntity#equals(Object)}
   *   <li>{@link StatisticsEventEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StatisticsEventEntity.equals(Object)",
    "int StatisticsEventEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StatisticsEventEntity statisticsEventEntity = new StatisticsEventEntity();
    statisticsEventEntity.setCreatedTime(1L);
    statisticsEventEntity.setEntityId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setErrorsOccurred(-1L);
    statisticsEventEntity.setId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setMessagesProcessed(1L);
    statisticsEventEntity.setServiceId("42");
    statisticsEventEntity.setTenantId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setTs(1L);
    statisticsEventEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(statisticsEventEntity, statisticsEventEntity);
    int expectedHashCodeResult = statisticsEventEntity.hashCode();
    assertEquals(expectedHashCodeResult, statisticsEventEntity.hashCode());
  }

  /**
   * Test {@link StatisticsEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEventEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StatisticsEventEntity.equals(Object)",
    "int StatisticsEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StatisticsEventEntity statisticsEventEntity = new StatisticsEventEntity();
    statisticsEventEntity.setCreatedTime(1L);
    statisticsEventEntity.setEntityId(UUID.randomUUID());
    statisticsEventEntity.setErrorsOccurred(-1L);
    statisticsEventEntity.setId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setMessagesProcessed(1L);
    statisticsEventEntity.setServiceId("42");
    statisticsEventEntity.setTenantId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setTs(1L);
    statisticsEventEntity.setUuid(ModelConstants.NULL_UUID);

    StatisticsEventEntity statisticsEventEntity2 = new StatisticsEventEntity();
    statisticsEventEntity2.setCreatedTime(1L);
    statisticsEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    statisticsEventEntity2.setErrorsOccurred(-1L);
    statisticsEventEntity2.setId(ModelConstants.NULL_UUID);
    statisticsEventEntity2.setMessagesProcessed(1L);
    statisticsEventEntity2.setServiceId("42");
    statisticsEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    statisticsEventEntity2.setTs(1L);
    statisticsEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(statisticsEventEntity, statisticsEventEntity2);
  }

  /**
   * Test {@link StatisticsEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEventEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StatisticsEventEntity.equals(Object)",
    "int StatisticsEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StatisticsEventEntity statisticsEventEntity = new StatisticsEventEntity();
    statisticsEventEntity.setCreatedTime(1L);
    statisticsEventEntity.setEntityId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setErrorsOccurred(1L);
    statisticsEventEntity.setId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setMessagesProcessed(1L);
    statisticsEventEntity.setServiceId("42");
    statisticsEventEntity.setTenantId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setTs(1L);
    statisticsEventEntity.setUuid(ModelConstants.NULL_UUID);

    StatisticsEventEntity statisticsEventEntity2 = new StatisticsEventEntity();
    statisticsEventEntity2.setCreatedTime(1L);
    statisticsEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    statisticsEventEntity2.setErrorsOccurred(-1L);
    statisticsEventEntity2.setId(ModelConstants.NULL_UUID);
    statisticsEventEntity2.setMessagesProcessed(1L);
    statisticsEventEntity2.setServiceId("42");
    statisticsEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    statisticsEventEntity2.setTs(1L);
    statisticsEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(statisticsEventEntity, statisticsEventEntity2);
  }

  /**
   * Test {@link StatisticsEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEventEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StatisticsEventEntity.equals(Object)",
    "int StatisticsEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    StatisticsEventEntity statisticsEventEntity = new StatisticsEventEntity();
    statisticsEventEntity.setCreatedTime(1L);
    statisticsEventEntity.setEntityId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setErrorsOccurred(-1L);
    statisticsEventEntity.setId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setMessagesProcessed(3L);
    statisticsEventEntity.setServiceId("42");
    statisticsEventEntity.setTenantId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setTs(1L);
    statisticsEventEntity.setUuid(ModelConstants.NULL_UUID);

    StatisticsEventEntity statisticsEventEntity2 = new StatisticsEventEntity();
    statisticsEventEntity2.setCreatedTime(1L);
    statisticsEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    statisticsEventEntity2.setErrorsOccurred(-1L);
    statisticsEventEntity2.setId(ModelConstants.NULL_UUID);
    statisticsEventEntity2.setMessagesProcessed(1L);
    statisticsEventEntity2.setServiceId("42");
    statisticsEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    statisticsEventEntity2.setTs(1L);
    statisticsEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(statisticsEventEntity, statisticsEventEntity2);
  }

  /**
   * Test {@link StatisticsEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEventEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StatisticsEventEntity.equals(Object)",
    "int StatisticsEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StatisticsEventEntity statisticsEventEntity = new StatisticsEventEntity();
    statisticsEventEntity.setCreatedTime(1L);
    statisticsEventEntity.setEntityId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setErrorsOccurred(-1L);
    statisticsEventEntity.setId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setMessagesProcessed(1L);
    statisticsEventEntity.setServiceId("42");
    statisticsEventEntity.setTenantId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setTs(1L);
    statisticsEventEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(statisticsEventEntity, null);
  }

  /**
   * Test {@link StatisticsEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEventEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StatisticsEventEntity.equals(Object)",
    "int StatisticsEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StatisticsEventEntity statisticsEventEntity = new StatisticsEventEntity();
    statisticsEventEntity.setCreatedTime(1L);
    statisticsEventEntity.setEntityId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setErrorsOccurred(-1L);
    statisticsEventEntity.setId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setMessagesProcessed(1L);
    statisticsEventEntity.setServiceId("42");
    statisticsEventEntity.setTenantId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setTs(1L);
    statisticsEventEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(statisticsEventEntity, "Different type to StatisticsEventEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StatisticsEventEntity#StatisticsEventEntity()}
   *   <li>{@link StatisticsEventEntity#setErrorsOccurred(long)}
   *   <li>{@link StatisticsEventEntity#setMessagesProcessed(long)}
   *   <li>{@link StatisticsEventEntity#toString()}
   *   <li>{@link StatisticsEventEntity#getErrorsOccurred()}
   *   <li>{@link StatisticsEventEntity#getMessagesProcessed()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StatisticsEventEntity.<init>()",
    "long StatisticsEventEntity.getErrorsOccurred()",
    "long StatisticsEventEntity.getMessagesProcessed()",
    "void StatisticsEventEntity.setErrorsOccurred(long)",
    "void StatisticsEventEntity.setMessagesProcessed(long)",
    "String StatisticsEventEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    StatisticsEventEntity actualStatisticsEventEntity = new StatisticsEventEntity();
    actualStatisticsEventEntity.setErrorsOccurred(-1L);
    actualStatisticsEventEntity.setMessagesProcessed(1L);
    String actualToStringResult = actualStatisticsEventEntity.toString();
    long actualErrorsOccurred = actualStatisticsEventEntity.getErrorsOccurred();
    long actualMessagesProcessed = actualStatisticsEventEntity.getMessagesProcessed();

    // Assert
    assertEquals(
        "StatisticsEventEntity(messagesProcessed=1, errorsOccurred=-1)", actualToStringResult);
    assertNull(actualStatisticsEventEntity.getServiceId());
    assertNull(actualStatisticsEventEntity.getEntityId());
    assertNull(actualStatisticsEventEntity.getId());
    assertNull(actualStatisticsEventEntity.getTenantId());
    assertNull(actualStatisticsEventEntity.getUuid());
    assertEquals(-1L, actualErrorsOccurred);
    assertEquals(0L, actualStatisticsEventEntity.getCreatedTime());
    assertEquals(0L, actualStatisticsEventEntity.getTs());
    assertEquals(1L, actualMessagesProcessed);
  }

  /**
   * Test {@link StatisticsEventEntity#StatisticsEventEntity(StatisticsEvent)}.
   *
   * <p>Method under test: {@link StatisticsEventEntity#StatisticsEventEntity(StatisticsEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatisticsEventEntity.<init>(StatisticsEvent)"})
  public void testNewStatisticsEventEntity() {
    // Arrange
    StatisticsEvent event =
        StatisticsEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .errorsOccurred(-1L)
            .id(ModelConstants.NULL_UUID)
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build();

    // Act
    StatisticsEventEntity actualStatisticsEventEntity = new StatisticsEventEntity(event);

    // Assert
    UUID entityId = actualStatisticsEventEntity.getEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.toString());
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualStatisticsEventEntity.getTenantId().toString());
    assertEquals("42", actualStatisticsEventEntity.getServiceId());
    assertEquals(-1L, actualStatisticsEventEntity.getErrorsOccurred());
    assertEquals(1L, actualStatisticsEventEntity.getCreatedTime());
    assertEquals(1L, actualStatisticsEventEntity.getTs());
    assertEquals(1L, actualStatisticsEventEntity.getMessagesProcessed());
    assertSame(entityId, actualStatisticsEventEntity.getId());
    assertSame(entityId, actualStatisticsEventEntity.getUuid());
  }

  /**
   * Test {@link StatisticsEventEntity#StatisticsEventEntity(StatisticsEvent)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link StatisticsEvent#getCreatedTime()}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEventEntity#StatisticsEventEntity(StatisticsEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatisticsEventEntity.<init>(StatisticsEvent)"})
  public void testNewStatisticsEventEntity_givenSystem_tenant_thenCallsGetCreatedTime() {
    // Arrange
    StatisticsEvent event = mock(StatisticsEvent.class);
    when(event.getServiceId()).thenReturn("42");
    when(event.getEntityId()).thenReturn(ModelConstants.NULL_UUID);
    when(event.getCreatedTime()).thenReturn(1L);
    when(event.getErrorsOccurred()).thenReturn(-1L);
    when(event.getMessagesProcessed()).thenReturn(1L);
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(event.getId()).thenReturn(new EventId(ModelConstants.NULL_UUID));

    // Act
    StatisticsEventEntity actualStatisticsEventEntity = new StatisticsEventEntity(event);

    // Assert
    verify(event).getCreatedTime();
    verify(event).getEntityId();
    verify(event).getServiceId();
    verify(event).getTenantId();
    verify(event).getErrorsOccurred();
    verify(event).getMessagesProcessed();
    verify(event).getId();
    UUID entityId = actualStatisticsEventEntity.getEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.toString());
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualStatisticsEventEntity.getTenantId().toString());
    assertEquals("42", actualStatisticsEventEntity.getServiceId());
    assertEquals(-1L, actualStatisticsEventEntity.getErrorsOccurred());
    assertEquals(1L, actualStatisticsEventEntity.getCreatedTime());
    assertEquals(1L, actualStatisticsEventEntity.getTs());
    assertEquals(1L, actualStatisticsEventEntity.getMessagesProcessed());
    assertSame(entityId, actualStatisticsEventEntity.getId());
    assertSame(entityId, actualStatisticsEventEntity.getUuid());
  }

  /**
   * Test {@link StatisticsEventEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link StatisticsEventEntity#StatisticsEventEntity()}.
   *   <li>Then return ServiceId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEventEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StatisticsEvent StatisticsEventEntity.toData()"})
  public void testToData_givenStatisticsEventEntity_thenReturnServiceIdIsNull() {
    // Arrange and Act
    StatisticsEvent actualToDataResult = new StatisticsEventEntity().toData();

    // Assert
    assertNull(actualToDataResult.getServiceId());
    assertNull(actualToDataResult.getEntityId());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getTenantId().getId());
    assertNull(actualToDataResult.getId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(0L, actualToDataResult.getErrorsOccurred());
    assertEquals(0L, actualToDataResult.getMessagesProcessed());
  }

  /**
   * Test {@link StatisticsEventEntity#toData()}.
   *
   * <ul>
   *   <li>Then return not TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEventEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StatisticsEvent StatisticsEventEntity.toData()"})
  public void testToData_thenReturnNotTenantIdNullUid() {
    // Arrange
    StatisticsEventEntity statisticsEventEntity = new StatisticsEventEntity();
    statisticsEventEntity.setCreatedTime(1L);
    statisticsEventEntity.setEntityId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setErrorsOccurred(-1L);
    statisticsEventEntity.setId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setMessagesProcessed(1L);
    statisticsEventEntity.setServiceId("42");
    UUID tenantId = UUID.randomUUID();
    statisticsEventEntity.setTenantId(tenantId);
    statisticsEventEntity.setTs(1L);
    statisticsEventEntity.setUuid(ModelConstants.NULL_UUID);

    // Act
    StatisticsEvent actualToDataResult = statisticsEventEntity.toData();

    // Assert
    UUID entityId = actualToDataResult.getEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.toString());
    assertEquals("42", actualToDataResult.getServiceId());
    assertEquals(-1L, actualToDataResult.getErrorsOccurred());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(1L, actualToDataResult.getMessagesProcessed());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(entityId, actualToDataResult.getUuidId());
    assertSame(entityId, actualToDataResult.getId().getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link StatisticsEventEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEventEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StatisticsEvent StatisticsEventEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    StatisticsEventEntity statisticsEventEntity = new StatisticsEventEntity();
    statisticsEventEntity.setCreatedTime(1L);
    statisticsEventEntity.setEntityId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setErrorsOccurred(-1L);
    statisticsEventEntity.setId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setMessagesProcessed(1L);
    statisticsEventEntity.setServiceId("42");
    statisticsEventEntity.setTenantId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setTs(1L);
    statisticsEventEntity.setUuid(ModelConstants.NULL_UUID);

    // Act
    StatisticsEvent actualToDataResult = statisticsEventEntity.toData();

    // Assert
    UUID entityId = actualToDataResult.getEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.toString());
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("42", actualToDataResult.getServiceId());
    assertEquals(-1L, actualToDataResult.getErrorsOccurred());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(1L, actualToDataResult.getMessagesProcessed());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, actualToDataResult.getUuidId());
    assertSame(entityId, actualToDataResult.getId().getId());
  }
}
