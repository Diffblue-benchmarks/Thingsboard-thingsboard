package org.thingsboard.server.common.data.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.vc.EntityLoadError.EntityLoadErrorBuilder;

class EntityLoadErrorDiffblueTest {
  /**
   * Test {@link EntityLoadError#credentialsError(EntityId)}.
   * <p>
   * Method under test: {@link EntityLoadError#credentialsError(EntityId)}
   */
  @Test
  @DisplayName("Test credentialsError(EntityId)")
  void testCredentialsError() {
    // Arrange
    TenantId sourceId = TenantId.SYS_TENANT_ID;

    // Act
    EntityLoadError actualCredentialsErrorResult = EntityLoadError.credentialsError(sourceId);

    // Assert
    assertEquals("DEVICE_CREDENTIALS_CONFLICT", actualCredentialsErrorResult.getType());
    assertNull(actualCredentialsErrorResult.getMessage());
    assertNull(actualCredentialsErrorResult.getTarget());
    TenantId expectedSource = sourceId.SYS_TENANT_ID;
    assertSame(expectedSource, actualCredentialsErrorResult.getSource());
  }

  /**
   * Test EntityLoadErrorBuilder {@link EntityLoadErrorBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityLoadError.EntityLoadErrorBuilder#build()}
   *   <li>{@link EntityLoadError.EntityLoadErrorBuilder#message(String)}
   *   <li>{@link EntityLoadError.EntityLoadErrorBuilder#source(EntityId)}
   *   <li>{@link EntityLoadError.EntityLoadErrorBuilder#target(EntityId)}
   *   <li>{@link EntityLoadError.EntityLoadErrorBuilder#type(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test EntityLoadErrorBuilder build()")
  void testEntityLoadErrorBuilderBuild() {
    // Arrange and Act
    EntityLoadError actualBuildResult = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();

    // Assert
    EntityId source = actualBuildResult.getSource();
    assertTrue(source instanceof TenantId);
    assertEquals("Not all who wander are lost", actualBuildResult.getMessage());
    assertEquals("Type", actualBuildResult.getType());
    assertSame(source, actualBuildResult.getTarget());
  }

  /**
   * Test {@link EntityLoadError#referenceEntityError(EntityId, EntityId)}.
   * <p>
   * Method under test:
   * {@link EntityLoadError#referenceEntityError(EntityId, EntityId)}
   */
  @Test
  @DisplayName("Test referenceEntityError(EntityId, EntityId)")
  void testReferenceEntityError() {
    // Arrange
    TenantId targetId = TenantId.SYS_TENANT_ID;

    // Act
    EntityLoadError actualReferenceEntityErrorResult = EntityLoadError.referenceEntityError(TenantId.SYS_TENANT_ID,
        targetId);

    // Assert
    assertEquals("MISSING_REFERENCED_ENTITY", actualReferenceEntityErrorResult.getType());
    assertNull(actualReferenceEntityErrorResult.getMessage());
    TenantId tenantId = targetId.SYS_TENANT_ID;
    assertSame(tenantId, actualReferenceEntityErrorResult.getSource());
    assertSame(tenantId, actualReferenceEntityErrorResult.getTarget());
  }

  /**
   * Test {@link EntityLoadError#runtimeError(Throwable)}.
   * <ul>
   *   <li>When {@link IOException#IOException(String)} with empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLoadError#runtimeError(Throwable)}
   */
  @Test
  @DisplayName("Test runtimeError(Throwable); when IOException(String) with empty string")
  void testRuntimeError_whenIOExceptionWithEmptyString() {
    // Arrange and Act
    EntityLoadError actualRuntimeErrorResult = EntityLoadError.runtimeError(new IOException(""));

    // Assert
    assertEquals("RUNTIME", actualRuntimeErrorResult.getType());
    assertEquals("unexpected error (IOException)", actualRuntimeErrorResult.getMessage());
    assertNull(actualRuntimeErrorResult.getSource());
    assertNull(actualRuntimeErrorResult.getTarget());
  }

  /**
   * Test {@link EntityLoadError#runtimeError(Throwable)}.
   * <ul>
   *   <li>When {@link IOException#IOException(String)} with {@code RUNTIME}.</li>
   *   <li>Then return Message is {@code RUNTIME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLoadError#runtimeError(Throwable)}
   */
  @Test
  @DisplayName("Test runtimeError(Throwable); when IOException(String) with 'RUNTIME'; then return Message is 'RUNTIME'")
  void testRuntimeError_whenIOExceptionWithRuntime_thenReturnMessageIsRuntime() {
    // Arrange and Act
    EntityLoadError actualRuntimeErrorResult = EntityLoadError.runtimeError(new IOException("RUNTIME"));

    // Assert
    assertEquals("RUNTIME", actualRuntimeErrorResult.getMessage());
    assertEquals("RUNTIME", actualRuntimeErrorResult.getType());
    assertNull(actualRuntimeErrorResult.getSource());
    assertNull(actualRuntimeErrorResult.getTarget());
  }

  /**
   * Test {@link EntityLoadError#runtimeError(Throwable)}.
   * <ul>
   *   <li>When {@link IOException#IOException()}.</li>
   *   <li>Then return Message is {@code unexpected error (IOException)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLoadError#runtimeError(Throwable)}
   */
  @Test
  @DisplayName("Test runtimeError(Throwable); when IOException(); then return Message is 'unexpected error (IOException)'")
  void testRuntimeError_whenIOException_thenReturnMessageIsUnexpectedErrorIOException() {
    // Arrange and Act
    EntityLoadError actualRuntimeErrorResult = EntityLoadError.runtimeError(new IOException());

    // Assert
    assertEquals("RUNTIME", actualRuntimeErrorResult.getType());
    assertEquals("unexpected error (IOException)", actualRuntimeErrorResult.getMessage());
    assertNull(actualRuntimeErrorResult.getSource());
    assertNull(actualRuntimeErrorResult.getTarget());
  }

  /**
   * Test {@link EntityLoadError#runtimeError(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code unexpected error (Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLoadError#runtimeError(Throwable)}
   */
  @Test
  @DisplayName("Test runtimeError(Throwable); when Throwable(); then return Message is 'unexpected error (Throwable)'")
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
   * Test {@link EntityLoadError#equals(Object)}, and
   * {@link EntityLoadError#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityLoadError#equals(Object)}
   *   <li>{@link EntityLoadError#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityLoadError buildResult = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();
    EntityLoadError buildResult2 = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}, and
   * {@link EntityLoadError#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityLoadError#equals(Object)}
   *   <li>{@link EntityLoadError#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder.target(Mockito.<EntityId>any())).thenReturn(EntityLoadError.builder());
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder2 = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder2.source(Mockito.<EntityId>any())).thenReturn(entityLoadErrorBuilder);
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder3 = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder3.message(Mockito.<String>any())).thenReturn(entityLoadErrorBuilder2);
    EntityLoadError buildResult = entityLoadErrorBuilder3.message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder4 = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder4.message(Mockito.<String>any())).thenReturn(EntityLoadError.builder());
    EntityLoadError buildResult2 = entityLoadErrorBuilder4.message("Not all who wander are lost")
        .source(null)
        .target(null)
        .type("Type")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}, and
   * {@link EntityLoadError#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityLoadError#equals(Object)}
   *   <li>{@link EntityLoadError#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityLoadError buildResult = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder.message(Mockito.<String>any())).thenReturn(EntityLoadError.builder());
    EntityLoadError buildResult = entityLoadErrorBuilder.message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();
    EntityLoadError buildResult2 = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder.source(Mockito.<EntityId>any())).thenReturn(EntityLoadError.builder());
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder2 = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder2.message(Mockito.<String>any())).thenReturn(entityLoadErrorBuilder);
    EntityLoadError buildResult = entityLoadErrorBuilder2.message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();
    EntityLoadError buildResult2 = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder.source(Mockito.<EntityId>any())).thenReturn(EntityLoadError.builder());
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder2 = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder2.message(Mockito.<String>any())).thenReturn(entityLoadErrorBuilder);
    EntityLoadError buildResult = entityLoadErrorBuilder2.message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type(null)
        .build();
    EntityLoadError buildResult2 = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder.source(Mockito.<EntityId>any())).thenReturn(EntityLoadError.builder());
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder2 = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder2.message(Mockito.<String>any())).thenReturn(entityLoadErrorBuilder);
    EntityLoadError buildResult = entityLoadErrorBuilder2.message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("42")
        .build();
    EntityLoadError buildResult2 = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder.source(Mockito.<EntityId>any())).thenReturn(EntityLoadError.builder());
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder2 = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder2.message(Mockito.<String>any())).thenReturn(entityLoadErrorBuilder);
    EntityLoadError buildResult = entityLoadErrorBuilder2.message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();
    EntityLoadError buildResult2 = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(null)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder.source(Mockito.<EntityId>any())).thenReturn(EntityLoadError.builder());
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder2 = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder2.message(Mockito.<String>any())).thenReturn(entityLoadErrorBuilder);
    EntityLoadError buildResult = entityLoadErrorBuilder2.message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type(null)
        .build();
    EntityLoadError buildResult2 = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type(null)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder.target(Mockito.<EntityId>any())).thenReturn(EntityLoadError.builder());
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder2 = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder2.source(Mockito.<EntityId>any())).thenReturn(entityLoadErrorBuilder);
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder3 = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder3.message(Mockito.<String>any())).thenReturn(entityLoadErrorBuilder2);
    EntityLoadError buildResult = entityLoadErrorBuilder3.message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();
    EntityLoadError buildResult2 = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(null)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder.target(Mockito.<EntityId>any())).thenReturn(EntityLoadError.builder());
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder2 = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder2.source(Mockito.<EntityId>any())).thenReturn(entityLoadErrorBuilder);
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder3 = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder3.message(Mockito.<String>any())).thenReturn(entityLoadErrorBuilder2);
    EntityLoadError buildResult = entityLoadErrorBuilder3.message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();
    EntityLoadError buildResult2 = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(null)
        .target(null)
        .type("Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EntityLoadError.EntityLoadErrorBuilder builderResult = EntityLoadError.builder();
    builderResult.source(TenantId.SYS_TENANT_ID);
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder.target(Mockito.<EntityId>any())).thenReturn(builderResult);
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder2 = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder2.source(Mockito.<EntityId>any())).thenReturn(entityLoadErrorBuilder);
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder3 = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder3.message(Mockito.<String>any())).thenReturn(entityLoadErrorBuilder2);
    EntityLoadError buildResult = entityLoadErrorBuilder3.message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();
    EntityLoadError buildResult2 = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(null)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EntityLoadError.EntityLoadErrorBuilder builderResult = EntityLoadError.builder();
    builderResult.target(TenantId.SYS_TENANT_ID);
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder.target(Mockito.<EntityId>any())).thenReturn(builderResult);
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder2 = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder2.source(Mockito.<EntityId>any())).thenReturn(entityLoadErrorBuilder);
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder3 = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder3.message(Mockito.<String>any())).thenReturn(entityLoadErrorBuilder2);
    EntityLoadError buildResult = entityLoadErrorBuilder3.message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder4 = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder4.message(Mockito.<String>any())).thenReturn(EntityLoadError.builder());
    EntityLoadError buildResult2 = entityLoadErrorBuilder4.message("Not all who wander are lost")
        .source(null)
        .target(null)
        .type("Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    EntityLoadError.EntityLoadErrorBuilder builderResult = EntityLoadError.builder();
    builderResult.message("Not all who wander are lost");
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder.target(Mockito.<EntityId>any())).thenReturn(builderResult);
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder2 = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder2.source(Mockito.<EntityId>any())).thenReturn(entityLoadErrorBuilder);
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder3 = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder3.message(Mockito.<String>any())).thenReturn(entityLoadErrorBuilder2);
    EntityLoadError buildResult = entityLoadErrorBuilder3.message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();
    EntityLoadError.EntityLoadErrorBuilder entityLoadErrorBuilder4 = mock(EntityLoadError.EntityLoadErrorBuilder.class);
    when(entityLoadErrorBuilder4.message(Mockito.<String>any())).thenReturn(EntityLoadError.builder());
    EntityLoadError buildResult2 = entityLoadErrorBuilder4.message("Not all who wander are lost")
        .source(null)
        .target(null)
        .type("Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityLoadError buildResult = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link EntityLoadError#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityLoadError buildResult = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to EntityLoadError");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntityLoadError#EntityLoadError(String, EntityId, EntityId, String)}
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
  void testGettersAndSetters() {
    // Arrange and Act
    EntityLoadError actualEntityLoadError = new EntityLoadError("Type", TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID,
        "Not all who wander are lost");
    actualEntityLoadError.setMessage("Not all who wander are lost");
    actualEntityLoadError.setSource(TenantId.SYS_TENANT_ID);
    actualEntityLoadError.setTarget(TenantId.SYS_TENANT_ID);
    actualEntityLoadError.setType("Type");
    String actualToStringResult = actualEntityLoadError.toString();
    String actualMessage = actualEntityLoadError.getMessage();
    EntityId actualSource = actualEntityLoadError.getSource();
    EntityId actualTarget = actualEntityLoadError.getTarget();

    // Assert that nothing has changed
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
