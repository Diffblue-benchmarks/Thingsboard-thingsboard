package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.event.StatisticsEvent;
import org.thingsboard.server.common.data.event.StatisticsEvent.StatisticsEventBuilder;
import org.thingsboard.server.common.data.id.EventId;
import org.thingsboard.server.dao.model.ModelConstants;

class StatisticsEventEntityDiffblueTest {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean StatisticsEventEntity.equals(Object)",
    "int StatisticsEventEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StatisticsEventEntity statisticsEventEntity = new StatisticsEventEntity();
    statisticsEventEntity.setCreatedTime(1L);
    statisticsEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity.setErrorsOccurred(-1L);
    statisticsEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity.setMessagesProcessed(1L);
    statisticsEventEntity.setServiceId("42");
    statisticsEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity.setTs(1L);
    statisticsEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    StatisticsEventEntity statisticsEventEntity2 = new StatisticsEventEntity();
    statisticsEventEntity2.setCreatedTime(1L);
    statisticsEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity2.setErrorsOccurred(-1L);
    statisticsEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity2.setMessagesProcessed(1L);
    statisticsEventEntity2.setServiceId("42");
    statisticsEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity2.setTs(1L);
    statisticsEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(statisticsEventEntity, statisticsEventEntity2);
    int expectedHashCodeResult = statisticsEventEntity.hashCode();
    assertEquals(expectedHashCodeResult, statisticsEventEntity2.hashCode());
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean StatisticsEventEntity.equals(Object)",
    "int StatisticsEventEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StatisticsEventEntity statisticsEventEntity = new StatisticsEventEntity();
    statisticsEventEntity.setCreatedTime(1L);
    statisticsEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity.setErrorsOccurred(-1L);
    statisticsEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity.setMessagesProcessed(1L);
    statisticsEventEntity.setServiceId("42");
    statisticsEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity.setTs(1L);
    statisticsEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean StatisticsEventEntity.equals(Object)",
    "int StatisticsEventEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StatisticsEventEntity statisticsEventEntity = new StatisticsEventEntity();
    statisticsEventEntity.setCreatedTime(1L);
    statisticsEventEntity.setEntityId(ModelConstants.NULL_UUID);
    statisticsEventEntity.setErrorsOccurred(-1L);
    statisticsEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity.setMessagesProcessed(1L);
    statisticsEventEntity.setServiceId("42");
    statisticsEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity.setTs(1L);
    statisticsEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    StatisticsEventEntity statisticsEventEntity2 = new StatisticsEventEntity();
    statisticsEventEntity2.setCreatedTime(1L);
    statisticsEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity2.setErrorsOccurred(-1L);
    statisticsEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity2.setMessagesProcessed(1L);
    statisticsEventEntity2.setServiceId("42");
    statisticsEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity2.setTs(1L);
    statisticsEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean StatisticsEventEntity.equals(Object)",
    "int StatisticsEventEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StatisticsEventEntity statisticsEventEntity = new StatisticsEventEntity();
    statisticsEventEntity.setCreatedTime(1L);
    statisticsEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity.setErrorsOccurred(1L);
    statisticsEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity.setMessagesProcessed(1L);
    statisticsEventEntity.setServiceId("42");
    statisticsEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity.setTs(1L);
    statisticsEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    StatisticsEventEntity statisticsEventEntity2 = new StatisticsEventEntity();
    statisticsEventEntity2.setCreatedTime(1L);
    statisticsEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity2.setErrorsOccurred(-1L);
    statisticsEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity2.setMessagesProcessed(1L);
    statisticsEventEntity2.setServiceId("42");
    statisticsEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity2.setTs(1L);
    statisticsEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean StatisticsEventEntity.equals(Object)",
    "int StatisticsEventEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    StatisticsEventEntity statisticsEventEntity = new StatisticsEventEntity();
    statisticsEventEntity.setCreatedTime(1L);
    statisticsEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity.setErrorsOccurred(-1L);
    statisticsEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity.setMessagesProcessed(3L);
    statisticsEventEntity.setServiceId("42");
    statisticsEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity.setTs(1L);
    statisticsEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    StatisticsEventEntity statisticsEventEntity2 = new StatisticsEventEntity();
    statisticsEventEntity2.setCreatedTime(1L);
    statisticsEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity2.setErrorsOccurred(-1L);
    statisticsEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity2.setMessagesProcessed(1L);
    statisticsEventEntity2.setServiceId("42");
    statisticsEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity2.setTs(1L);
    statisticsEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean StatisticsEventEntity.equals(Object)",
    "int StatisticsEventEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StatisticsEventEntity statisticsEventEntity = new StatisticsEventEntity();
    statisticsEventEntity.setCreatedTime(1L);
    statisticsEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity.setErrorsOccurred(-1L);
    statisticsEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity.setMessagesProcessed(1L);
    statisticsEventEntity.setServiceId("42");
    statisticsEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity.setTs(1L);
    statisticsEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean StatisticsEventEntity.equals(Object)",
    "int StatisticsEventEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StatisticsEventEntity statisticsEventEntity = new StatisticsEventEntity();
    statisticsEventEntity.setCreatedTime(1L);
    statisticsEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity.setErrorsOccurred(-1L);
    statisticsEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity.setMessagesProcessed(1L);
    statisticsEventEntity.setServiceId("42");
    statisticsEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity.setTs(1L);
    statisticsEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void StatisticsEventEntity.<init>()",
    "long StatisticsEventEntity.getErrorsOccurred()",
    "long StatisticsEventEntity.getMessagesProcessed()",
    "void StatisticsEventEntity.setErrorsOccurred(long)",
    "void StatisticsEventEntity.setMessagesProcessed(long)",
    "String StatisticsEventEntity.toString()"
  })
  void testGettersAndSetters() {
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
  @DisplayName("Test new StatisticsEventEntity(StatisticsEvent)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StatisticsEventEntity.<init>(StatisticsEvent)"})
  void testNewStatisticsEventEntity() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    StatisticsEventBuilder errorsOccurredResult =
        builderResult.entityId(entityId).errorsOccurred(-1L);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    StatisticsEvent event =
        errorsOccurredResult
            .id(id)
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build();

    // Act
    StatisticsEventEntity actualStatisticsEventEntity = new StatisticsEventEntity(event);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualStatisticsEventEntity.getTenantId().toString());
    assertEquals("42", actualStatisticsEventEntity.getServiceId());
    UUID entityId2 = actualStatisticsEventEntity.getEntityId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId2.toString());
    UUID id2 = actualStatisticsEventEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertEquals(-1L, actualStatisticsEventEntity.getErrorsOccurred());
    assertEquals(1L, actualStatisticsEventEntity.getCreatedTime());
    assertEquals(1L, actualStatisticsEventEntity.getTs());
    assertEquals(1L, actualStatisticsEventEntity.getMessagesProcessed());
    assertSame(entityId, entityId2);
    assertSame(id, id2);
    assertSame(id, actualStatisticsEventEntity.getUuid());
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
  @DisplayName(
      "Test new StatisticsEventEntity(StatisticsEvent); given SYSTEM_TENANT; then calls getCreatedTime()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StatisticsEventEntity.<init>(StatisticsEvent)"})
  void testNewStatisticsEventEntity_givenSystem_tenant_thenCallsGetCreatedTime() {
    // Arrange
    StatisticsEvent event = mock(StatisticsEvent.class);
    when(event.getServiceId()).thenReturn("42");
    UUID fromStringResult = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    when(event.getEntityId()).thenReturn(fromStringResult);
    when(event.getCreatedTime()).thenReturn(1L);
    when(event.getErrorsOccurred()).thenReturn(-1L);
    when(event.getMessagesProcessed()).thenReturn(1L);
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    when(event.getId()).thenReturn(new EventId(id));

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
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualStatisticsEventEntity.getTenantId().toString());
    assertEquals("42", actualStatisticsEventEntity.getServiceId());
    UUID entityId = actualStatisticsEventEntity.getEntityId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId.toString());
    UUID id2 = actualStatisticsEventEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertEquals(-1L, actualStatisticsEventEntity.getErrorsOccurred());
    assertEquals(1L, actualStatisticsEventEntity.getCreatedTime());
    assertEquals(1L, actualStatisticsEventEntity.getTs());
    assertEquals(1L, actualStatisticsEventEntity.getMessagesProcessed());
    assertSame(fromStringResult, entityId);
    assertSame(id, id2);
    assertSame(id, actualStatisticsEventEntity.getUuid());
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
  @DisplayName("Test toData(); given StatisticsEventEntity(); then return ServiceId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StatisticsEvent StatisticsEventEntity.toData()"})
  void testToData_givenStatisticsEventEntity_thenReturnServiceIdIsNull() {
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
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEventEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return TenantId Id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StatisticsEvent StatisticsEventEntity.toData()"})
  void testToData_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    StatisticsEventEntity statisticsEventEntity = new StatisticsEventEntity();
    statisticsEventEntity.setCreatedTime(1L);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    statisticsEventEntity.setEntityId(entityId);
    statisticsEventEntity.setErrorsOccurred(-1L);
    statisticsEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity.setMessagesProcessed(1L);
    statisticsEventEntity.setServiceId("42");
    UUID tenantId = UUID.randomUUID();
    statisticsEventEntity.setTenantId(tenantId);
    statisticsEventEntity.setTs(1L);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    statisticsEventEntity.setUuid(id);

    // Act
    StatisticsEvent actualToDataResult = statisticsEventEntity.toData();

    // Assert
    assertEquals("42", actualToDataResult.getServiceId());
    UUID entityId2 = actualToDataResult.getEntityId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId2.toString());
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    assertEquals(-1L, actualToDataResult.getErrorsOccurred());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(1L, actualToDataResult.getMessagesProcessed());
    assertSame(entityId, entityId2);
    assertSame(id, uuidId);
    assertSame(id, actualToDataResult.getId().getId());
    assertSame(tenantId, actualToDataResult.getTenantId().getId());
  }

  /**
   * Test {@link StatisticsEventEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEventEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return TenantId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StatisticsEvent StatisticsEventEntity.toData()"})
  void testToData_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    StatisticsEventEntity statisticsEventEntity = new StatisticsEventEntity();
    statisticsEventEntity.setCreatedTime(1L);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    statisticsEventEntity.setEntityId(entityId);
    statisticsEventEntity.setErrorsOccurred(-1L);
    statisticsEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity.setMessagesProcessed(1L);
    statisticsEventEntity.setServiceId("42");
    statisticsEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    statisticsEventEntity.setTs(1L);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    statisticsEventEntity.setUuid(id);

    // Act
    StatisticsEvent actualToDataResult = statisticsEventEntity.toData();

    // Assert
    assertEquals("42", actualToDataResult.getServiceId());
    UUID entityId2 = actualToDataResult.getEntityId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId2.toString());
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    assertEquals(
        "784f394c-42b6-435a-983c-b7beff2784f9",
        actualToDataResult.getTenantId().getId().toString());
    assertEquals(-1L, actualToDataResult.getErrorsOccurred());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(1L, actualToDataResult.getMessagesProcessed());
    assertSame(entityId, entityId2);
    assertSame(id, uuidId);
    assertSame(id, actualToDataResult.getId().getId());
  }
}
