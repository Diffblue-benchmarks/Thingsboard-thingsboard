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
package org.thingsboard.server.common.data.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class EntityLoadErrorDiffblueTest {
  /**
   * Method under test: {@link EntityLoadError#credentialsError(EntityId)}
   */
  @Test
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
   * Method under test:
   * {@link EntityLoadError#referenceEntityError(EntityId, EntityId)}
   */
  @Test
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
   * Method under test: {@link EntityLoadError#runtimeError(Throwable)}
   */
  @Test
  void testRuntimeError() {
    // Arrange and Act
    EntityLoadError actualRuntimeErrorResult = EntityLoadError.runtimeError(new Throwable());

    // Assert
    assertEquals("RUNTIME", actualRuntimeErrorResult.getType());
    assertEquals("unexpected error (Throwable)", actualRuntimeErrorResult.getMessage());
    assertNull(actualRuntimeErrorResult.getSource());
    assertNull(actualRuntimeErrorResult.getTarget());
  }

  /**
   * Method under test: {@link EntityLoadError#runtimeError(Throwable)}
   */
  @Test
  void testRuntimeError2() {
    // Arrange and Act
    EntityLoadError actualRuntimeErrorResult = EntityLoadError.runtimeError(new IOException("RUNTIME"));

    // Assert
    assertEquals("RUNTIME", actualRuntimeErrorResult.getMessage());
    assertEquals("RUNTIME", actualRuntimeErrorResult.getType());
    assertNull(actualRuntimeErrorResult.getSource());
    assertNull(actualRuntimeErrorResult.getTarget());
  }

  /**
   * Method under test: {@link EntityLoadError#runtimeError(Throwable)}
   */
  @Test
  void testRuntimeError3() {
    // Arrange and Act
    EntityLoadError actualRuntimeErrorResult = EntityLoadError.runtimeError(new IOException());

    // Assert
    assertEquals("RUNTIME", actualRuntimeErrorResult.getType());
    assertEquals("unexpected error (IOException)", actualRuntimeErrorResult.getMessage());
    assertNull(actualRuntimeErrorResult.getSource());
    assertNull(actualRuntimeErrorResult.getTarget());
  }

  /**
   * Method under test: {@link EntityLoadError#runtimeError(Throwable)}
   */
  @Test
  void testRuntimeError4() {
    // Arrange and Act
    EntityLoadError actualRuntimeErrorResult = EntityLoadError.runtimeError(new IOException(""));

    // Assert
    assertEquals("RUNTIME", actualRuntimeErrorResult.getType());
    assertEquals("unexpected error (IOException)", actualRuntimeErrorResult.getMessage());
    assertNull(actualRuntimeErrorResult.getSource());
    assertNull(actualRuntimeErrorResult.getTarget());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityLoadError#equals(Object)}
   *   <li>{@link EntityLoadError#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link EntityLoadError#equals(Object)}
   *   <li>{@link EntityLoadError#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link EntityLoadError#equals(Object)}
   *   <li>{@link EntityLoadError#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
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
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
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
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
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
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
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
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
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
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
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
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
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
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
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
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
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
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
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
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
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
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
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
   * Method under test: {@link EntityLoadError#equals(Object)}
   */
  @Test
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
