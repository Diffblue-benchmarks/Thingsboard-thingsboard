package org.thingsboard.server.common.data.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.vc.EntityLoadError.EntityLoadErrorBuilder;

@ContextConfiguration(classes = {EntityLoadErrorBuilder.class})
@ExtendWith(SpringExtension.class)
class EntityLoadErrorDiffblueTest {
  @Autowired private EntityLoadErrorBuilder entityLoadErrorBuilder;

  /**
   * Test {@link EntityLoadError#credentialsError(EntityId)}.
   *
   * <p>Method under test: {@link EntityLoadError#credentialsError(EntityId)}
   */
  @Test
  @DisplayName("Test credentialsError(EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLoadError EntityLoadError.credentialsError(EntityId)"})
  void testCredentialsError() {
    // Arrange and Act
    EntityLoadError actualCredentialsErrorResult =
        EntityLoadError.credentialsError(TenantId.SYS_TENANT_ID);

    // Assert
    assertEquals("DEVICE_CREDENTIALS_CONFLICT", actualCredentialsErrorResult.getType());
    assertNull(actualCredentialsErrorResult.getMessage());
    assertNull(actualCredentialsErrorResult.getTarget());
    assertSame(TenantId.SYS_TENANT_ID, actualCredentialsErrorResult.getSource());
  }

  /**
   * Test EntityLoadErrorBuilder {@link EntityLoadErrorBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityLoadErrorBuilder#build()}
   *   <li>{@link EntityLoadErrorBuilder#message(String)}
   *   <li>{@link EntityLoadErrorBuilder#source(EntityId)}
   *   <li>{@link EntityLoadErrorBuilder#target(EntityId)}
   *   <li>{@link EntityLoadErrorBuilder#type(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test EntityLoadErrorBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityLoadErrorBuilder.<init>()",
    "EntityLoadError EntityLoadErrorBuilder.build()",
    "EntityLoadErrorBuilder EntityLoadErrorBuilder.message(String)",
    "EntityLoadErrorBuilder EntityLoadErrorBuilder.source(EntityId)",
    "EntityLoadErrorBuilder EntityLoadErrorBuilder.target(EntityId)",
    "String EntityLoadErrorBuilder.toString()",
    "EntityLoadErrorBuilder EntityLoadErrorBuilder.type(String)"
  })
  void testEntityLoadErrorBuilderBuild() {
    // Arrange and Act
    EntityLoadError actualEntityLoadError =
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(TenantId.SYS_TENANT_ID)
            .target(TenantId.SYS_TENANT_ID)
            .type("Type")
            .build();

    // Assert
    assertEquals("Not all who wander are lost", actualEntityLoadError.getMessage());
    assertEquals("Type", actualEntityLoadError.getType());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualEntityLoadError.getSource());
    assertSame(tenantId, actualEntityLoadError.getTarget());
  }

  /**
   * Test {@link EntityLoadError#referenceEntityError(EntityId, EntityId)}.
   *
   * <p>Method under test: {@link EntityLoadError#referenceEntityError(EntityId, EntityId)}
   */
  @Test
  @DisplayName("Test referenceEntityError(EntityId, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLoadError EntityLoadError.referenceEntityError(EntityId, EntityId)"})
  void testReferenceEntityError() {
    // Arrange and Act
    EntityLoadError actualReferenceEntityErrorResult =
        EntityLoadError.referenceEntityError(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID);

    // Assert
    assertEquals("MISSING_REFERENCED_ENTITY", actualReferenceEntityErrorResult.getType());
    assertNull(actualReferenceEntityErrorResult.getMessage());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualReferenceEntityErrorResult.getSource());
    assertSame(tenantId, actualReferenceEntityErrorResult.getTarget());
  }

  /**
   * Test {@link EntityLoadError#runtimeError(Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link EntityLoadError#runtimeError(Throwable)}
   */
  @Test
  @DisplayName("Test runtimeError(Throwable); then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLoadError EntityLoadError.runtimeError(Throwable)"})
  void testRuntimeError_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    EntityLoadError actualRuntimeErrorResult =
        EntityLoadError.runtimeError(new IOException("An error occurred"));

    // Assert
    assertEquals("An error occurred", actualRuntimeErrorResult.getMessage());
    assertEquals("RUNTIME", actualRuntimeErrorResult.getType());
    assertNull(actualRuntimeErrorResult.getSource());
    assertNull(actualRuntimeErrorResult.getTarget());
  }

  /**
   * Test {@link EntityLoadError#runtimeError(Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code unexpected error (Error)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityLoadError#runtimeError(Throwable)}
   */
  @Test
  @DisplayName("Test runtimeError(Throwable); then return Message is 'unexpected error (Error)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLoadError EntityLoadError.runtimeError(Throwable)"})
  void testRuntimeError_thenReturnMessageIsUnexpectedErrorError() {
    // Arrange and Act
    EntityLoadError actualRuntimeErrorResult = EntityLoadError.runtimeError(new Error(""));

    // Assert
    assertEquals("RUNTIME", actualRuntimeErrorResult.getType());
    assertEquals("unexpected error (Error)", actualRuntimeErrorResult.getMessage());
    assertNull(actualRuntimeErrorResult.getSource());
    assertNull(actualRuntimeErrorResult.getTarget());
  }

  /**
   * Test {@link EntityLoadError#runtimeError(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code unexpected error (Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityLoadError#runtimeError(Throwable)}
   */
  @Test
  @DisplayName(
      "Test runtimeError(Throwable); when Throwable(); then return Message is 'unexpected error (Throwable)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLoadError EntityLoadError.runtimeError(Throwable)"})
  void testRuntimeError_whenThrowable_thenReturnMessageIsUnexpectedErrorThrowable() {
    // Arrange and Act
    EntityLoadError actualRuntimeErrorResult = EntityLoadError.runtimeError(new Throwable());

    // Assert
    assertEquals("RUNTIME", actualRuntimeErrorResult.getType());
    assertEquals("unexpected error (Throwable)", actualRuntimeErrorResult.getMessage());
    assertNull(actualRuntimeErrorResult.getSource());
    assertNull(actualRuntimeErrorResult.getTarget());
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}, and {@link EntityLoadError#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityLoadError#equals(Object)}
   *   <li>{@link EntityLoadError#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLoadError.equals(Object)", "int EntityLoadError.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityLoadError entityLoadError =
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(TenantId.SYS_TENANT_ID)
            .target(TenantId.SYS_TENANT_ID)
            .type("Type")
            .build();
    EntityLoadError entityLoadError2 =
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(TenantId.SYS_TENANT_ID)
            .target(TenantId.SYS_TENANT_ID)
            .type("Type")
            .build();

    // Act and Assert
    assertEquals(entityLoadError, entityLoadError2);
    assertEquals(entityLoadError.hashCode(), entityLoadError2.hashCode());
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}, and {@link EntityLoadError#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityLoadError#equals(Object)}
   *   <li>{@link EntityLoadError#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLoadError.equals(Object)", "int EntityLoadError.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityLoadError entityLoadError =
        EntityLoadError.builder()
            .message(null)
            .source(TenantId.SYS_TENANT_ID)
            .target(TenantId.SYS_TENANT_ID)
            .type("Type")
            .build();
    EntityLoadError entityLoadError2 =
        EntityLoadError.builder()
            .message(null)
            .source(TenantId.SYS_TENANT_ID)
            .target(TenantId.SYS_TENANT_ID)
            .type("Type")
            .build();

    // Act and Assert
    assertEquals(entityLoadError, entityLoadError2);
    assertEquals(entityLoadError.hashCode(), entityLoadError2.hashCode());
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}, and {@link EntityLoadError#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityLoadError#equals(Object)}
   *   <li>{@link EntityLoadError#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLoadError.equals(Object)", "int EntityLoadError.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityLoadError entityLoadError =
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(null)
            .target(TenantId.SYS_TENANT_ID)
            .type("Type")
            .build();
    EntityLoadError entityLoadError2 =
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(null)
            .target(TenantId.SYS_TENANT_ID)
            .type("Type")
            .build();

    // Act and Assert
    assertEquals(entityLoadError, entityLoadError2);
    assertEquals(entityLoadError.hashCode(), entityLoadError2.hashCode());
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}, and {@link EntityLoadError#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityLoadError#equals(Object)}
   *   <li>{@link EntityLoadError#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLoadError.equals(Object)", "int EntityLoadError.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EntityLoadError entityLoadError =
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(TenantId.SYS_TENANT_ID)
            .target(null)
            .type("Type")
            .build();
    EntityLoadError entityLoadError2 =
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(TenantId.SYS_TENANT_ID)
            .target(null)
            .type("Type")
            .build();

    // Act and Assert
    assertEquals(entityLoadError, entityLoadError2);
    assertEquals(entityLoadError.hashCode(), entityLoadError2.hashCode());
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}, and {@link EntityLoadError#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityLoadError#equals(Object)}
   *   <li>{@link EntityLoadError#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLoadError.equals(Object)", "int EntityLoadError.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    EntityLoadError entityLoadError =
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(TenantId.SYS_TENANT_ID)
            .target(TenantId.SYS_TENANT_ID)
            .type(null)
            .build();
    EntityLoadError entityLoadError2 =
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(TenantId.SYS_TENANT_ID)
            .target(TenantId.SYS_TENANT_ID)
            .type(null)
            .build();

    // Act and Assert
    assertEquals(entityLoadError, entityLoadError2);
    assertEquals(entityLoadError.hashCode(), entityLoadError2.hashCode());
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}, and {@link EntityLoadError#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityLoadError#equals(Object)}
   *   <li>{@link EntityLoadError#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLoadError.equals(Object)", "int EntityLoadError.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityLoadError entityLoadError =
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(TenantId.SYS_TENANT_ID)
            .target(TenantId.SYS_TENANT_ID)
            .type("Type")
            .build();

    // Act and Assert
    assertEquals(entityLoadError, entityLoadError);
    int expectedHashCodeResult = entityLoadError.hashCode();
    assertEquals(expectedHashCodeResult, entityLoadError.hashCode());
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLoadError.equals(Object)", "int EntityLoadError.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityLoadError entityLoadError =
        EntityLoadError.builder()
            .message("Type")
            .source(TenantId.SYS_TENANT_ID)
            .target(TenantId.SYS_TENANT_ID)
            .type("Type")
            .build();

    // Act and Assert
    assertNotEquals(
        entityLoadError,
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(TenantId.SYS_TENANT_ID)
            .target(TenantId.SYS_TENANT_ID)
            .type("Type")
            .build());
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLoadError.equals(Object)", "int EntityLoadError.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityLoadError entityLoadError =
        EntityLoadError.builder()
            .message(null)
            .source(TenantId.SYS_TENANT_ID)
            .target(TenantId.SYS_TENANT_ID)
            .type("Type")
            .build();

    // Act and Assert
    assertNotEquals(
        entityLoadError,
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(TenantId.SYS_TENANT_ID)
            .target(TenantId.SYS_TENANT_ID)
            .type("Type")
            .build());
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLoadError.equals(Object)", "int EntityLoadError.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityLoadError entityLoadError =
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(null)
            .target(TenantId.SYS_TENANT_ID)
            .type("Type")
            .build();

    // Act and Assert
    assertNotEquals(
        entityLoadError,
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(TenantId.SYS_TENANT_ID)
            .target(TenantId.SYS_TENANT_ID)
            .type("Type")
            .build());
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLoadError.equals(Object)", "int EntityLoadError.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityLoadErrorBuilder messageResult =
        EntityLoadError.builder().message("Not all who wander are lost");
    EntityLoadError entityLoadError =
        messageResult
            .source(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .target(TenantId.SYS_TENANT_ID)
            .type("Type")
            .build();

    // Act and Assert
    assertNotEquals(
        entityLoadError,
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(TenantId.SYS_TENANT_ID)
            .target(TenantId.SYS_TENANT_ID)
            .type("Type")
            .build());
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLoadError.equals(Object)", "int EntityLoadError.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityLoadError entityLoadError =
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(TenantId.SYS_TENANT_ID)
            .target(null)
            .type("Type")
            .build();

    // Act and Assert
    assertNotEquals(
        entityLoadError,
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(TenantId.SYS_TENANT_ID)
            .target(TenantId.SYS_TENANT_ID)
            .type("Type")
            .build());
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLoadError.equals(Object)", "int EntityLoadError.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityLoadErrorBuilder sourceResult =
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(TenantId.SYS_TENANT_ID);
    EntityLoadError entityLoadError =
        sourceResult
            .target(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .type("Type")
            .build();

    // Act and Assert
    assertNotEquals(
        entityLoadError,
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(TenantId.SYS_TENANT_ID)
            .target(TenantId.SYS_TENANT_ID)
            .type("Type")
            .build());
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLoadError.equals(Object)", "int EntityLoadError.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityLoadError entityLoadError =
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(TenantId.SYS_TENANT_ID)
            .target(TenantId.SYS_TENANT_ID)
            .type("Not all who wander are lost")
            .build();

    // Act and Assert
    assertNotEquals(
        entityLoadError,
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(TenantId.SYS_TENANT_ID)
            .target(TenantId.SYS_TENANT_ID)
            .type("Type")
            .build());
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLoadError.equals(Object)", "int EntityLoadError.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityLoadError entityLoadError =
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(TenantId.SYS_TENANT_ID)
            .target(TenantId.SYS_TENANT_ID)
            .type(null)
            .build();

    // Act and Assert
    assertNotEquals(
        entityLoadError,
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(TenantId.SYS_TENANT_ID)
            .target(TenantId.SYS_TENANT_ID)
            .type("Type")
            .build());
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLoadError.equals(Object)", "int EntityLoadError.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(TenantId.SYS_TENANT_ID)
            .target(TenantId.SYS_TENANT_ID)
            .type("Type")
            .build(),
        null);
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLoadError.equals(Object)", "int EntityLoadError.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        EntityLoadError.builder()
            .message("Not all who wander are lost")
            .source(TenantId.SYS_TENANT_ID)
            .target(TenantId.SYS_TENANT_ID)
            .type("Type")
            .build(),
        "Different type to EntityLoadError");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityLoadError#EntityLoadError(String, EntityId, EntityId, String)}
   *   <li>{@link EntityLoadError#setMessage(String)}
   *   <li>{@link EntityLoadError#setSource(EntityId)}
   *   <li>{@link EntityLoadError#setTarget(EntityId)}
   *   <li>{@link EntityLoadError#setType(String)}
   *   <li>{@link EntityLoadError#toString()}
   *   <li>{@link EntityLoadError#getMessage()}
   *   <li>{@link EntityLoadError#getSource()}
   *   <li>{@link EntityLoadError#getTarget()}
   *   <li>{@link EntityLoadError#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityLoadError.<init>(String, EntityId, EntityId, String)",
    "String EntityLoadError.getMessage()",
    "EntityId EntityLoadError.getSource()",
    "EntityId EntityLoadError.getTarget()",
    "String EntityLoadError.getType()",
    "void EntityLoadError.setMessage(String)",
    "void EntityLoadError.setSource(EntityId)",
    "void EntityLoadError.setTarget(EntityId)",
    "void EntityLoadError.setType(String)",
    "String EntityLoadError.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntityLoadError actualEntityLoadError =
        new EntityLoadError(
            "Type", TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, "Not all who wander are lost");
    actualEntityLoadError.setMessage("Not all who wander are lost");
    actualEntityLoadError.setSource(TenantId.SYS_TENANT_ID);
    actualEntityLoadError.setTarget(TenantId.SYS_TENANT_ID);
    actualEntityLoadError.setType("Type");
    String actualToStringResult = actualEntityLoadError.toString();
    String actualMessage = actualEntityLoadError.getMessage();
    EntityId actualSource = actualEntityLoadError.getSource();
    EntityId actualTarget = actualEntityLoadError.getTarget();

    // Assert
    assertEquals(
        "EntityLoadError(type=Type, source=13814000-1dd2-11b2-8080-808080808080, target=13814000-1dd2-11b2-8080"
            + "-808080808080, message=Not all who wander are lost)",
        actualToStringResult);
    assertEquals("Not all who wander are lost", actualMessage);
    assertEquals("Type", actualEntityLoadError.getType());
    TenantId tenantId = ((TenantId) actualTarget).SYS_TENANT_ID;
    assertSame(tenantId, actualSource);
    assertSame(tenantId, actualTarget);
  }
}
