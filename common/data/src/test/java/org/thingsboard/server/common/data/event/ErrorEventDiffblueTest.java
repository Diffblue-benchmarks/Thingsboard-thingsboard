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
import org.thingsboard.server.common.data.event.ErrorEvent.ErrorEventBuilder;
import org.thingsboard.server.common.data.id.TenantId;

class ErrorEventDiffblueTest {
  /**
   * Test {@link ErrorEvent#equals(Object)}, and {@link ErrorEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorEvent#equals(Object)}
   *   <li>{@link ErrorEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ErrorEvent.ErrorEventBuilder builderResult = ErrorEvent.builder();
    ErrorEvent.ErrorEventBuilder errorResult = builderResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    ErrorEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .method("Method")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    ErrorEvent.ErrorEventBuilder builderResult2 = ErrorEvent.builder();
    ErrorEvent.ErrorEventBuilder errorResult2 = builderResult2
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    ErrorEvent buildResult2 = errorResult2.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .method("Method")
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
   * Test {@link ErrorEvent#equals(Object)}, and {@link ErrorEvent#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorEvent#equals(Object)}
   *   <li>{@link ErrorEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ErrorEvent.ErrorEventBuilder builderResult = ErrorEvent.builder();
    ErrorEvent.ErrorEventBuilder errorResult = builderResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    ErrorEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .method("Method")
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
   * Test {@link ErrorEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ErrorEvent.ErrorEventBuilder errorEventBuilder = mock(ErrorEvent.ErrorEventBuilder.class);
    when(errorEventBuilder.entityId(Mockito.<UUID>any())).thenReturn(ErrorEvent.builder());
    ErrorEvent.ErrorEventBuilder errorResult = errorEventBuilder
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    ErrorEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .method("Method")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    ErrorEvent.ErrorEventBuilder builderResult = ErrorEvent.builder();
    ErrorEvent.ErrorEventBuilder errorResult2 = builderResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    ErrorEvent buildResult2 = errorResult2.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .method("Method")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ErrorEvent#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ErrorEvent.ErrorEventBuilder builderResult = ErrorEvent.builder();
    ErrorEvent.ErrorEventBuilder errorResult = builderResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    ErrorEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .method("Method")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ErrorEvent#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ErrorEvent.ErrorEventBuilder builderResult = ErrorEvent.builder();
    ErrorEvent.ErrorEventBuilder errorResult = builderResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    ErrorEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .method("Method")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ErrorEvent");
  }

  /**
   * Test ErrorEventBuilder {@link ErrorEventBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorEvent.ErrorEventBuilder#build()}
   *   <li>{@link ErrorEvent.ErrorEventBuilder#entityId(UUID)}
   *   <li>{@link ErrorEvent.ErrorEventBuilder#error(String)}
   *   <li>{@link ErrorEvent.ErrorEventBuilder#id(UUID)}
   *   <li>{@link ErrorEvent.ErrorEventBuilder#method(String)}
   *   <li>{@link ErrorEvent.ErrorEventBuilder#serviceId(String)}
   *   <li>{@link ErrorEvent.ErrorEventBuilder#tenantId(TenantId)}
   *   <li>{@link ErrorEvent.ErrorEventBuilder#ts(long)}
   * </ul>
   */
  @Test
  @DisplayName("Test ErrorEventBuilder build()")
  void testErrorEventBuilderBuild() {
    // Arrange
    ErrorEvent.ErrorEventBuilder builderResult = ErrorEvent.builder();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ErrorEvent.ErrorEventBuilder errorResult = builderResult.entityId(entityId).error("An error occurred");
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    ErrorEvent actualBuildResult = errorResult.id(id)
        .method("Method")
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
    assertEquals("An error occurred", actualBuildResult.getError());
    assertEquals("Method", actualBuildResult.getMethod());
    assertEquals(1L, actualBuildResult.getCreatedTime());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(EventType.ERROR, actualBuildResult.getType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, entityId2);
    assertSame(id, uuidId);
    assertSame(id, actualBuildResult.getId().getId());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorEvent#setError(String)}
   *   <li>{@link ErrorEvent#setMethod(String)}
   *   <li>{@link ErrorEvent#toString()}
   *   <li>{@link ErrorEvent#getError()}
   *   <li>{@link ErrorEvent#getMethod()}
   *   <li>{@link ErrorEvent#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    ErrorEvent.ErrorEventBuilder builderResult = ErrorEvent.builder();
    ErrorEvent.ErrorEventBuilder errorResult = builderResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    ErrorEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .method("Method")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    buildResult.setError("An error occurred");
    buildResult.setMethod("Method");
    String actualToStringResult = buildResult.toString();
    String actualError = buildResult.getError();
    String actualMethod = buildResult.getMethod();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualError);
    assertEquals("ErrorEvent(method=Method, error=An error occurred)", actualToStringResult);
    assertEquals("Method", actualMethod);
    assertEquals(EventType.ERROR, buildResult.getType());
  }
}
