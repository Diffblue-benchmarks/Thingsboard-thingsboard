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
package org.thingsboard.server.common.data.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

@ContextConfiguration(classes = {ErrorEventBuilder.class})
@ExtendWith(SpringExtension.class)
class ErrorEventDiffblueTest {
  @Autowired
  private ErrorEventBuilder errorEventBuilder;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEvent.equals(Object)", "int ErrorEvent.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ErrorEvent buildResult = ErrorEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
        .method("Method")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    ErrorEvent buildResult2 = ErrorEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEvent.equals(Object)", "int ErrorEvent.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ErrorEvent buildResult = ErrorEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEvent.equals(Object)", "int ErrorEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ErrorEventBuilder errorEventBuilder = mock(ErrorEventBuilder.class);
    when(errorEventBuilder.entityId(Mockito.<UUID>any())).thenReturn(ErrorEvent.builder());
    ErrorEvent buildResult = errorEventBuilder.entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
        .method("Method")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    ErrorEvent buildResult2 = ErrorEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEvent.equals(Object)", "int ErrorEvent.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ErrorEvent buildResult = ErrorEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEvent.equals(Object)", "int ErrorEvent.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ErrorEvent buildResult = ErrorEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
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
  @MethodsUnderTest({"void ErrorEventBuilder.<init>()", "ErrorEvent ErrorEventBuilder.build()",
      "ErrorEventBuilder ErrorEventBuilder.entityId(UUID)", "ErrorEventBuilder ErrorEventBuilder.error(String)",
      "ErrorEventBuilder ErrorEventBuilder.id(UUID)", "ErrorEventBuilder ErrorEventBuilder.method(String)",
      "ErrorEventBuilder ErrorEventBuilder.serviceId(String)", "ErrorEventBuilder ErrorEventBuilder.tenantId(TenantId)",
      "String ErrorEventBuilder.toString()", "ErrorEventBuilder ErrorEventBuilder.ts(long)"})
  void testErrorEventBuilderBuild() {
    // Arrange and Act
    ErrorEvent actualBuildResult = ErrorEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
        .method("Method")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualBuildResult.getEntityId().toString());
    assertEquals("42", actualBuildResult.getServiceId());
    assertEquals("An error occurred", actualBuildResult.getError());
    assertEquals("Method", actualBuildResult.getMethod());
    assertEquals(1L, actualBuildResult.getCreatedTime());
    TenantId tenantId = actualBuildResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(EventType.ERROR, actualBuildResult.getType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ErrorEvent.getError()", "String ErrorEvent.getMethod()", "EventType ErrorEvent.getType()",
      "void ErrorEvent.setError(String)", "void ErrorEvent.setMethod(String)", "String ErrorEvent.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ErrorEvent buildResult = ErrorEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
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
