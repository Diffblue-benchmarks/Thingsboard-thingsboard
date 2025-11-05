package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.event.ErrorEvent;
import org.thingsboard.server.common.data.event.ErrorEvent.ErrorEventBuilder;
import org.thingsboard.server.common.data.id.EventId;
import org.thingsboard.server.dao.model.ModelConstants;

class ErrorEventEntityDiffblueTest {
  /**
   * Test {@link ErrorEventEntity#equals(Object)}, and {@link ErrorEventEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ErrorEventEntity#equals(Object)}
   *   <li>{@link ErrorEventEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ErrorEventEntity.equals(Object)", "int ErrorEventEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ErrorEventEntity errorEventEntity2 = new ErrorEventEntity();
    errorEventEntity2.setCreatedTime(1L);
    errorEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setError("An error occurred");
    errorEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setMethod("Method");
    errorEventEntity2.setServiceId("42");
    errorEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setTs(1L);
    errorEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(errorEventEntity, errorEventEntity2);
    assertEquals(errorEventEntity.hashCode(), errorEventEntity2.hashCode());
  }

  /**
   * Test {@link ErrorEventEntity#equals(Object)}, and {@link ErrorEventEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ErrorEventEntity#equals(Object)}
   *   <li>{@link ErrorEventEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ErrorEventEntity.equals(Object)", "int ErrorEventEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setError(null);
    errorEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ErrorEventEntity errorEventEntity2 = new ErrorEventEntity();
    errorEventEntity2.setCreatedTime(1L);
    errorEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setError(null);
    errorEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setMethod("Method");
    errorEventEntity2.setServiceId("42");
    errorEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setTs(1L);
    errorEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(errorEventEntity, errorEventEntity2);
    assertEquals(errorEventEntity.hashCode(), errorEventEntity2.hashCode());
  }

  /**
   * Test {@link ErrorEventEntity#equals(Object)}, and {@link ErrorEventEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ErrorEventEntity#equals(Object)}
   *   <li>{@link ErrorEventEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ErrorEventEntity.equals(Object)", "int ErrorEventEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setMethod(null);
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ErrorEventEntity errorEventEntity2 = new ErrorEventEntity();
    errorEventEntity2.setCreatedTime(1L);
    errorEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setError("An error occurred");
    errorEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setMethod(null);
    errorEventEntity2.setServiceId("42");
    errorEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setTs(1L);
    errorEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(errorEventEntity, errorEventEntity2);
    assertEquals(errorEventEntity.hashCode(), errorEventEntity2.hashCode());
  }

  /**
   * Test {@link ErrorEventEntity#equals(Object)}, and {@link ErrorEventEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ErrorEventEntity#equals(Object)}
   *   <li>{@link ErrorEventEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ErrorEventEntity.equals(Object)", "int ErrorEventEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(errorEventEntity, errorEventEntity);
    int expectedHashCodeResult = errorEventEntity.hashCode();
    assertEquals(expectedHashCodeResult, errorEventEntity.hashCode());
  }

  /**
   * Test {@link ErrorEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEventEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ErrorEventEntity.equals(Object)", "int ErrorEventEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(ModelConstants.NULL_UUID);
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ErrorEventEntity errorEventEntity2 = new ErrorEventEntity();
    errorEventEntity2.setCreatedTime(1L);
    errorEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setError("An error occurred");
    errorEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setMethod("Method");
    errorEventEntity2.setServiceId("42");
    errorEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setTs(1L);
    errorEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(errorEventEntity, errorEventEntity2);
  }

  /**
   * Test {@link ErrorEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEventEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ErrorEventEntity.equals(Object)", "int ErrorEventEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setError("42");
    errorEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ErrorEventEntity errorEventEntity2 = new ErrorEventEntity();
    errorEventEntity2.setCreatedTime(1L);
    errorEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setError("An error occurred");
    errorEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setMethod("Method");
    errorEventEntity2.setServiceId("42");
    errorEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setTs(1L);
    errorEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(errorEventEntity, errorEventEntity2);
  }

  /**
   * Test {@link ErrorEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEventEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ErrorEventEntity.equals(Object)", "int ErrorEventEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setError(null);
    errorEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ErrorEventEntity errorEventEntity2 = new ErrorEventEntity();
    errorEventEntity2.setCreatedTime(1L);
    errorEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setError("An error occurred");
    errorEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setMethod("Method");
    errorEventEntity2.setServiceId("42");
    errorEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setTs(1L);
    errorEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(errorEventEntity, errorEventEntity2);
  }

  /**
   * Test {@link ErrorEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEventEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ErrorEventEntity.equals(Object)", "int ErrorEventEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setMethod("42");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ErrorEventEntity errorEventEntity2 = new ErrorEventEntity();
    errorEventEntity2.setCreatedTime(1L);
    errorEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setError("An error occurred");
    errorEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setMethod("Method");
    errorEventEntity2.setServiceId("42");
    errorEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setTs(1L);
    errorEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(errorEventEntity, errorEventEntity2);
  }

  /**
   * Test {@link ErrorEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEventEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ErrorEventEntity.equals(Object)", "int ErrorEventEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setMethod(null);
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ErrorEventEntity errorEventEntity2 = new ErrorEventEntity();
    errorEventEntity2.setCreatedTime(1L);
    errorEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setError("An error occurred");
    errorEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setMethod("Method");
    errorEventEntity2.setServiceId("42");
    errorEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setTs(1L);
    errorEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(errorEventEntity, errorEventEntity2);
  }

  /**
   * Test {@link ErrorEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEventEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ErrorEventEntity.equals(Object)", "int ErrorEventEntity.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(errorEventEntity, null);
  }

  /**
   * Test {@link ErrorEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEventEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ErrorEventEntity.equals(Object)", "int ErrorEventEntity.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(errorEventEntity, "Different type to ErrorEventEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ErrorEventEntity.<init>()",
    "String ErrorEventEntity.getError()",
    "String ErrorEventEntity.getMethod()",
    "void ErrorEventEntity.setError(String)",
    "void ErrorEventEntity.setMethod(String)",
    "String ErrorEventEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ErrorEventEntity actualErrorEventEntity = new ErrorEventEntity();
    actualErrorEventEntity.setError("An error occurred");
    actualErrorEventEntity.setMethod("Method");
    String actualToStringResult = actualErrorEventEntity.toString();
    String actualError = actualErrorEventEntity.getError();

    // Assert
    assertEquals("An error occurred", actualError);
    assertEquals("ErrorEventEntity(method=Method, error=An error occurred)", actualToStringResult);
    assertEquals("Method", actualErrorEventEntity.getMethod());
    assertNull(actualErrorEventEntity.getServiceId());
    assertNull(actualErrorEventEntity.getEntityId());
    assertNull(actualErrorEventEntity.getId());
    assertNull(actualErrorEventEntity.getTenantId());
    assertNull(actualErrorEventEntity.getUuid());
    assertEquals(0L, actualErrorEventEntity.getCreatedTime());
    assertEquals(0L, actualErrorEventEntity.getTs());
  }

  /**
   * Test {@link ErrorEventEntity#ErrorEventEntity(ErrorEvent)}.
   *
   * <p>Method under test: {@link ErrorEventEntity#ErrorEventEntity(ErrorEvent)}
   */
  @Test
  @DisplayName("Test new ErrorEventEntity(ErrorEvent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ErrorEventEntity.<init>(ErrorEvent)"})
  void testNewErrorEventEntity() {
    // Arrange
    ErrorEventBuilder builderResult = ErrorEvent.builder();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    ErrorEventBuilder errorResult = builderResult.entityId(entityId).error("An error occurred");
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ErrorEvent event =
        errorResult
            .id(id)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build();

    // Act
    ErrorEventEntity actualErrorEventEntity = new ErrorEventEntity(event);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualErrorEventEntity.getTenantId().toString());
    assertEquals("42", actualErrorEventEntity.getServiceId());
    UUID entityId2 = actualErrorEventEntity.getEntityId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId2.toString());
    UUID id2 = actualErrorEventEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertEquals("An error occurred", actualErrorEventEntity.getError());
    assertEquals("Method", actualErrorEventEntity.getMethod());
    assertEquals(1L, actualErrorEventEntity.getCreatedTime());
    assertEquals(1L, actualErrorEventEntity.getTs());
    assertSame(entityId, entityId2);
    assertSame(id, id2);
    assertSame(id, actualErrorEventEntity.getUuid());
  }

  /**
   * Test {@link ErrorEventEntity#ErrorEventEntity(ErrorEvent)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link ErrorEvent#getCreatedTime()}.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEventEntity#ErrorEventEntity(ErrorEvent)}
   */
  @Test
  @DisplayName(
      "Test new ErrorEventEntity(ErrorEvent); given SYSTEM_TENANT; then calls getCreatedTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ErrorEventEntity.<init>(ErrorEvent)"})
  void testNewErrorEventEntity_givenSystem_tenant_thenCallsGetCreatedTime() {
    // Arrange
    ErrorEvent event = mock(ErrorEvent.class);
    when(event.getError()).thenReturn("An error occurred");
    when(event.getMethod()).thenReturn("Method");
    when(event.getServiceId()).thenReturn("42");
    UUID fromStringResult = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    when(event.getEntityId()).thenReturn(fromStringResult);
    when(event.getCreatedTime()).thenReturn(1L);
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    when(event.getId()).thenReturn(new EventId(id));

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
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualErrorEventEntity.getTenantId().toString());
    assertEquals("42", actualErrorEventEntity.getServiceId());
    UUID entityId = actualErrorEventEntity.getEntityId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId.toString());
    UUID id2 = actualErrorEventEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertEquals("An error occurred", actualErrorEventEntity.getError());
    assertEquals("Method", actualErrorEventEntity.getMethod());
    assertEquals(1L, actualErrorEventEntity.getCreatedTime());
    assertEquals(1L, actualErrorEventEntity.getTs());
    assertSame(fromStringResult, entityId);
    assertSame(id, id2);
    assertSame(id, actualErrorEventEntity.getUuid());
  }

  /**
   * Test {@link ErrorEventEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link ErrorEventEntity#ErrorEventEntity()}.
   *   <li>Then return Error is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEventEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given ErrorEventEntity(); then return Error is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ErrorEvent ErrorEventEntity.toData()"})
  void testToData_givenErrorEventEntity_thenReturnErrorIsNull() {
    // Arrange and Act
    ErrorEvent actualToDataResult = new ErrorEventEntity().toData();

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
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEventEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return TenantId Id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ErrorEvent ErrorEventEntity.toData()"})
  void testToData_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    errorEventEntity.setEntityId(entityId);
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    UUID tenantId = UUID.randomUUID();
    errorEventEntity.setTenantId(tenantId);
    errorEventEntity.setTs(1L);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    errorEventEntity.setUuid(id);

    // Act
    ErrorEvent actualToDataResult = errorEventEntity.toData();

    // Assert
    assertEquals("42", actualToDataResult.getServiceId());
    UUID entityId2 = actualToDataResult.getEntityId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId2.toString());
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    assertEquals("An error occurred", actualToDataResult.getError());
    assertEquals("Method", actualToDataResult.getMethod());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertSame(entityId, entityId2);
    assertSame(id, uuidId);
    assertSame(id, actualToDataResult.getId().getId());
    assertSame(tenantId, actualToDataResult.getTenantId().getId());
  }

  /**
   * Test {@link ErrorEventEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEventEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return TenantId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ErrorEvent ErrorEventEntity.toData()"})
  void testToData_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    errorEventEntity.setEntityId(entityId);
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setTs(1L);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    errorEventEntity.setUuid(id);

    // Act
    ErrorEvent actualToDataResult = errorEventEntity.toData();

    // Assert
    assertEquals("42", actualToDataResult.getServiceId());
    UUID entityId2 = actualToDataResult.getEntityId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId2.toString());
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    assertEquals(
        "784f394c-42b6-435a-983c-b7beff2784f9",
        actualToDataResult.getTenantId().getId().toString());
    assertEquals("An error occurred", actualToDataResult.getError());
    assertEquals("Method", actualToDataResult.getMethod());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertSame(entityId, entityId2);
    assertSame(id, uuidId);
    assertSame(id, actualToDataResult.getId().getId());
  }
}
