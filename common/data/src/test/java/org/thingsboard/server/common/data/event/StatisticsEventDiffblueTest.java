package org.thingsboard.server.common.data.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.event.StatisticsEvent.StatisticsEventBuilder;
import org.thingsboard.server.common.data.id.TenantId;

class StatisticsEventDiffblueTest {
  /**
   * Test {@link StatisticsEvent#equals(Object)}, and
   * {@link StatisticsEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEvent#equals(Object)}
   *   <li>{@link StatisticsEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StatisticsEvent.StatisticsEventBuilder builderResult = StatisticsEvent.builder();
    StatisticsEvent.StatisticsEventBuilder errorsOccurredResult = builderResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .errorsOccurred(-1L);
    StatisticsEvent buildResult = errorsOccurredResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .messagesProcessed(1L)
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    StatisticsEvent.StatisticsEventBuilder builderResult2 = StatisticsEvent.builder();
    StatisticsEvent.StatisticsEventBuilder errorsOccurredResult2 = builderResult2
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .errorsOccurred(-1L);
    StatisticsEvent buildResult2 = errorsOccurredResult2.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .messagesProcessed(1L)
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link StatisticsEvent#equals(Object)}, and
   * {@link StatisticsEvent#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEvent#equals(Object)}
   *   <li>{@link StatisticsEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StatisticsEvent.StatisticsEventBuilder builderResult = StatisticsEvent.builder();
    StatisticsEvent.StatisticsEventBuilder errorsOccurredResult = builderResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .errorsOccurred(-1L);
    StatisticsEvent buildResult = errorsOccurredResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .messagesProcessed(1L)
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link StatisticsEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StatisticsEvent.StatisticsEventBuilder statisticsEventBuilder = mock(StatisticsEvent.StatisticsEventBuilder.class);
    when(statisticsEventBuilder.entityId(Mockito.<UUID>any())).thenReturn(StatisticsEvent.builder());
    StatisticsEvent.StatisticsEventBuilder errorsOccurredResult = statisticsEventBuilder
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .errorsOccurred(-1L);
    StatisticsEvent buildResult = errorsOccurredResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .messagesProcessed(1L)
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    StatisticsEvent.StatisticsEventBuilder builderResult = StatisticsEvent.builder();
    StatisticsEvent.StatisticsEventBuilder errorsOccurredResult2 = builderResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .errorsOccurred(-1L);
    StatisticsEvent buildResult2 = errorsOccurredResult2.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .messagesProcessed(1L)
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link StatisticsEvent#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StatisticsEvent.StatisticsEventBuilder builderResult = StatisticsEvent.builder();
    StatisticsEvent.StatisticsEventBuilder errorsOccurredResult = builderResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .errorsOccurred(-1L);
    StatisticsEvent buildResult = errorsOccurredResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .messagesProcessed(1L)
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link StatisticsEvent#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StatisticsEvent.StatisticsEventBuilder builderResult = StatisticsEvent.builder();
    StatisticsEvent.StatisticsEventBuilder errorsOccurredResult = builderResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .errorsOccurred(-1L);
    StatisticsEvent buildResult = errorsOccurredResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .messagesProcessed(1L)
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to StatisticsEvent");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEvent#toString()}
   *   <li>{@link StatisticsEvent#getErrorsOccurred()}
   *   <li>{@link StatisticsEvent#getMessagesProcessed()}
   *   <li>{@link StatisticsEvent#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    StatisticsEvent.StatisticsEventBuilder builderResult = StatisticsEvent.builder();
    StatisticsEvent.StatisticsEventBuilder errorsOccurredResult = builderResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .errorsOccurred(-1L);
    StatisticsEvent buildResult = errorsOccurredResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .messagesProcessed(1L)
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    String actualToStringResult = buildResult.toString();
    long actualErrorsOccurred = buildResult.getErrorsOccurred();
    long actualMessagesProcessed = buildResult.getMessagesProcessed();

    // Assert
    assertEquals("StatisticsEvent(messagesProcessed=1, errorsOccurred=-1)", actualToStringResult);
    assertEquals(-1L, actualErrorsOccurred);
    assertEquals(1L, actualMessagesProcessed);
    assertEquals(EventType.STATS, buildResult.getType());
  }

  /**
   * Test StatisticsEventBuilder {@link StatisticsEventBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEvent.StatisticsEventBuilder#build()}
   *   <li>{@link StatisticsEvent.StatisticsEventBuilder#entityId(UUID)}
   *   <li>{@link StatisticsEvent.StatisticsEventBuilder#errorsOccurred(long)}
   *   <li>{@link StatisticsEvent.StatisticsEventBuilder#id(UUID)}
   *   <li>{@link StatisticsEvent.StatisticsEventBuilder#messagesProcessed(long)}
   *   <li>{@link StatisticsEvent.StatisticsEventBuilder#serviceId(String)}
   *   <li>{@link StatisticsEvent.StatisticsEventBuilder#tenantId(TenantId)}
   *   <li>{@link StatisticsEvent.StatisticsEventBuilder#ts(long)}
   * </ul>
   */
  @Test
  @DisplayName("Test StatisticsEventBuilder build()")
  void testStatisticsEventBuilderBuild() {
    // Arrange
    StatisticsEvent.StatisticsEventBuilder builderResult = StatisticsEvent.builder();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    StatisticsEvent.StatisticsEventBuilder errorsOccurredResult = builderResult.entityId(entityId).errorsOccurred(-1L);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    StatisticsEvent actualBuildResult = errorsOccurredResult.id(id)
        .messagesProcessed(1L)
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Assert
    TenantId tenantId = actualBuildResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("42", actualBuildResult.getServiceId());
    UUID entityId2 = actualBuildResult.getEntityId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId2.toString());
    UUID uuidId = actualBuildResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    assertEquals(-1L, actualBuildResult.getErrorsOccurred());
    assertEquals(1L, actualBuildResult.getCreatedTime());
    assertEquals(1L, actualBuildResult.getMessagesProcessed());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(EventType.STATS, actualBuildResult.getType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, entityId2);
    assertSame(id, uuidId);
    assertSame(id, actualBuildResult.getId().getId());
  }
}
