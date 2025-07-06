package org.thingsboard.server.common.data.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.event.ErrorEvent.ErrorEventBuilder;
import org.thingsboard.server.common.data.id.TenantId;

@ContextConfiguration(classes = {ErrorEventBuilder.class})
@ExtendWith(SpringExtension.class)
class ErrorEventDiffblueTest {
  @Autowired private ErrorEventBuilder errorEventBuilder;

  /**
   * Test {@link ErrorEvent#equals(Object)}, and {@link ErrorEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ErrorEvent#equals(Object)}
   *   <li>{@link ErrorEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEvent.equals(Object)", "int ErrorEvent.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ErrorEventBuilder builderResult = ErrorEvent.builder();
    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    ErrorEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .method("Method")
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build();
    ErrorEventBuilder builderResult2 = ErrorEvent.builder();
    ErrorEventBuilder errorResult2 =
        builderResult2
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    ErrorEvent buildResult2 =
        errorResult2
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ErrorEvent#equals(Object)}
   *   <li>{@link ErrorEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEvent.equals(Object)", "int ErrorEvent.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ErrorEventBuilder builderResult = ErrorEvent.builder();
    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    ErrorEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEvent.equals(Object)", "int ErrorEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ErrorEventBuilder errorEventBuilder = mock(ErrorEventBuilder.class);
    when(errorEventBuilder.entityId(Mockito.<UUID>any())).thenReturn(ErrorEvent.builder());
    ErrorEventBuilder errorResult =
        errorEventBuilder
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    ErrorEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .method("Method")
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build();
    ErrorEventBuilder builderResult = ErrorEvent.builder();
    ErrorEventBuilder errorResult2 =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    ErrorEvent buildResult2 =
        errorResult2
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEvent.equals(Object)", "int ErrorEvent.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ErrorEventBuilder builderResult = ErrorEvent.builder();
    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    ErrorEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEvent.equals(Object)", "int ErrorEvent.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ErrorEventBuilder builderResult = ErrorEvent.builder();
    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    ErrorEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ErrorEventBuilder#build()}
   *   <li>{@link ErrorEventBuilder#entityId(UUID)}
   *   <li>{@link ErrorEventBuilder#error(String)}
   *   <li>{@link ErrorEventBuilder#id(UUID)}
   *   <li>{@link ErrorEventBuilder#method(String)}
   *   <li>{@link ErrorEventBuilder#serviceId(String)}
   *   <li>{@link ErrorEventBuilder#tenantId(TenantId)}
   *   <li>{@link ErrorEventBuilder#ts(long)}
   * </ul>
   */
  @Test
  @DisplayName("Test ErrorEventBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void ErrorEventBuilder.<init>()",
    "ErrorEvent ErrorEventBuilder.build()",
    "ErrorEventBuilder ErrorEventBuilder.entityId(UUID)",
    "ErrorEventBuilder ErrorEventBuilder.error(String)",
    "ErrorEventBuilder ErrorEventBuilder.id(UUID)",
    "ErrorEventBuilder ErrorEventBuilder.method(String)",
    "ErrorEventBuilder ErrorEventBuilder.serviceId(String)",
    "ErrorEventBuilder ErrorEventBuilder.tenantId(TenantId)",
    "String ErrorEventBuilder.toString()",
    "ErrorEventBuilder ErrorEventBuilder.ts(long)"
  })
  void testErrorEventBuilderBuild() {
    // Arrange
    ErrorEventBuilder builderResult = ErrorEvent.builder();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ErrorEventBuilder errorResult = builderResult.entityId(entityId).error("An error occurred");
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    ErrorEvent actualBuildResult =
        errorResult
            .id(id)
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
   *
   * <p>Methods under test:
   *
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "String ErrorEvent.getError()",
    "String ErrorEvent.getMethod()",
    "EventType ErrorEvent.getType()",
    "void ErrorEvent.setError(String)",
    "void ErrorEvent.setMethod(String)",
    "String ErrorEvent.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ErrorEventBuilder builderResult = ErrorEvent.builder();
    ErrorEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    ErrorEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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

    // Assert
    assertEquals("An error occurred", actualError);
    assertEquals("ErrorEvent(method=Method, error=An error occurred)", actualToStringResult);
    assertEquals("Method", actualMethod);
    assertEquals(EventType.ERROR, buildResult.getType());
  }
}
