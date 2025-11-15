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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.vc.VersionLoadResult.VersionLoadResultBuilder;

@ContextConfiguration(classes = {VersionLoadResultBuilder.class})
@ExtendWith(SpringExtension.class)
class VersionLoadResultDiffblueTest {
  @Autowired
  private VersionLoadResultBuilder versionLoadResultBuilder;

  /**
   * Test {@link VersionLoadResult#empty()}.
   * <p>
   * Method under test: {@link VersionLoadResult#empty()}
   */
  @Test
  @DisplayName("Test empty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"VersionLoadResult VersionLoadResult.empty()"})
  void testEmpty() {
    // Arrange and Act
    VersionLoadResult actualEmptyResult = VersionLoadResult.empty();

    // Assert
    assertNull(actualEmptyResult.getError());
    assertFalse(actualEmptyResult.isDone());
    assertTrue(actualEmptyResult.getResult().isEmpty());
  }

  /**
   * Test {@link VersionLoadResult#success(EntityTypeLoadResult)} with {@code EntityTypeLoadResult}.
   * <ul>
   *   <li>Then return Error is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadResult#success(EntityTypeLoadResult)}
   */
  @Test
  @DisplayName("Test success(EntityTypeLoadResult) with 'EntityTypeLoadResult'; then return Error is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"VersionLoadResult VersionLoadResult.success(EntityTypeLoadResult)"})
  void testSuccessWithEntityTypeLoadResult_thenReturnErrorIsNull() {
    // Arrange
    EntityTypeLoadResult result = new EntityTypeLoadResult(EntityType.TENANT);

    // Act
    VersionLoadResult actualSuccessResult = VersionLoadResult.success(result);

    // Assert
    assertNull(actualSuccessResult.getError());
    List<EntityTypeLoadResult> result2 = actualSuccessResult.getResult();
    assertEquals(1, result2.size());
    assertFalse(actualSuccessResult.isDone());
    assertSame(result, result2.get(0));
  }

  /**
   * Test {@link VersionLoadResult#success(List)} with {@code List}.
   * <ul>
   *   <li>Then return Result is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadResult#success(List)}
   */
  @Test
  @DisplayName("Test success(List) with 'List'; then return Result is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"VersionLoadResult VersionLoadResult.success(List)"})
  void testSuccessWithList_thenReturnResultIsArrayList() {
    // Arrange
    ArrayList<EntityTypeLoadResult> result = new ArrayList<>();
    EntityTypeLoadResult buildResult = EntityTypeLoadResult.builder()
        .created(1)
        .deleted(1)
        .entityType(EntityType.TENANT)
        .updated(1)
        .build();
    result.add(buildResult);

    // Act and Assert
    assertSame(result, VersionLoadResult.success(result).getResult());
  }

  /**
   * Test {@link VersionLoadResult#success(List)} with {@code List}.
   * <ul>
   *   <li>Then return Result is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadResult#success(List)}
   */
  @Test
  @DisplayName("Test success(List) with 'List'; then return Result is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"VersionLoadResult VersionLoadResult.success(List)"})
  void testSuccessWithList_thenReturnResultIsArrayList2() {
    // Arrange
    ArrayList<EntityTypeLoadResult> result = new ArrayList<>();
    EntityTypeLoadResult buildResult = EntityTypeLoadResult.builder()
        .created(1)
        .deleted(1)
        .entityType(EntityType.TENANT)
        .updated(1)
        .build();
    result.add(buildResult);
    EntityTypeLoadResult buildResult2 = EntityTypeLoadResult.builder()
        .created(1)
        .deleted(1)
        .entityType(EntityType.TENANT)
        .updated(1)
        .build();
    result.add(buildResult2);

    // Act and Assert
    assertSame(result, VersionLoadResult.success(result).getResult());
  }

  /**
   * Test {@link VersionLoadResult#success(List)} with {@code List}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Error is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadResult#success(List)}
   */
  @Test
  @DisplayName("Test success(List) with 'List'; when ArrayList(); then return Error is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"VersionLoadResult VersionLoadResult.success(List)"})
  void testSuccessWithList_whenArrayList_thenReturnErrorIsNull() {
    // Arrange and Act
    VersionLoadResult actualSuccessResult = VersionLoadResult.success(new ArrayList<>());

    // Assert
    assertNull(actualSuccessResult.getError());
    assertFalse(actualSuccessResult.isDone());
    assertTrue(actualSuccessResult.getResult().isEmpty());
  }

  /**
   * Test {@link VersionLoadResult#error(EntityLoadError)}.
   * <p>
   * Method under test: {@link VersionLoadResult#error(EntityLoadError)}
   */
  @Test
  @DisplayName("Test error(EntityLoadError)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"VersionLoadResult VersionLoadResult.error(EntityLoadError)"})
  void testError() {
    // Arrange
    EntityLoadError error = new EntityLoadError("Type", TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID,
        "Not all who wander are lost");

    // Act
    VersionLoadResult actualErrorResult = VersionLoadResult.error(error);

    // Assert
    assertNull(actualErrorResult.getResult());
    assertTrue(actualErrorResult.isDone());
    assertSame(error, actualErrorResult.getError());
  }

  /**
   * Test {@link VersionLoadResult#equals(Object)}, and {@link VersionLoadResult#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VersionLoadResult#equals(Object)}
   *   <li>{@link VersionLoadResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionLoadResult.equals(Object)", "int VersionLoadResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    VersionLoadResultBuilder doneResult = VersionLoadResult.builder().done(true);
    EntityLoadError error = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();
    VersionLoadResultBuilder errorResult = doneResult.error(error);
    VersionLoadResult buildResult = errorResult.result(new ArrayList<>()).build();
    VersionLoadResultBuilder doneResult2 = VersionLoadResult.builder().done(true);
    EntityLoadError error2 = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();
    VersionLoadResultBuilder errorResult2 = doneResult2.error(error2);
    VersionLoadResult buildResult2 = errorResult2.result(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link VersionLoadResult#equals(Object)}, and {@link VersionLoadResult#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VersionLoadResult#equals(Object)}
   *   <li>{@link VersionLoadResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionLoadResult.equals(Object)", "int VersionLoadResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    VersionLoadResultBuilder doneResult = VersionLoadResult.builder().done(true);
    EntityLoadError error = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();
    VersionLoadResultBuilder errorResult = doneResult.error(error);
    VersionLoadResult buildResult = errorResult.result(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link VersionLoadResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionLoadResult.equals(Object)", "int VersionLoadResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    VersionLoadResultBuilder versionLoadResultBuilder = mock(VersionLoadResultBuilder.class);
    when(versionLoadResultBuilder.done(anyBoolean())).thenReturn(VersionLoadResult.builder());
    VersionLoadResultBuilder doneResult = versionLoadResultBuilder.done(true);
    EntityLoadError error = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();
    VersionLoadResultBuilder errorResult = doneResult.error(error);
    VersionLoadResult buildResult = errorResult.result(new ArrayList<>()).build();
    VersionLoadResultBuilder doneResult2 = VersionLoadResult.builder().done(true);
    EntityLoadError error2 = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();
    VersionLoadResultBuilder errorResult2 = doneResult2.error(error2);
    VersionLoadResult buildResult2 = errorResult2.result(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link VersionLoadResult#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionLoadResult.equals(Object)", "int VersionLoadResult.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    VersionLoadResultBuilder doneResult = VersionLoadResult.builder().done(true);
    EntityLoadError error = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();
    VersionLoadResultBuilder errorResult = doneResult.error(error);
    VersionLoadResult buildResult = errorResult.result(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link VersionLoadResult#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionLoadResult.equals(Object)", "int VersionLoadResult.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    VersionLoadResultBuilder doneResult = VersionLoadResult.builder().done(true);
    EntityLoadError error = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();
    VersionLoadResultBuilder errorResult = doneResult.error(error);
    VersionLoadResult buildResult = errorResult.result(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to VersionLoadResult");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VersionLoadResult#VersionLoadResult(List, EntityLoadError, boolean)}
   *   <li>{@link VersionLoadResult#setDone(boolean)}
   *   <li>{@link VersionLoadResult#setError(EntityLoadError)}
   *   <li>{@link VersionLoadResult#setResult(List)}
   *   <li>{@link VersionLoadResult#toString()}
   *   <li>{@link VersionLoadResult#getError()}
   *   <li>{@link VersionLoadResult#getResult()}
   *   <li>{@link VersionLoadResult#isDone()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void VersionLoadResult.<init>(List, EntityLoadError, boolean)",
      "EntityLoadError VersionLoadResult.getError()", "List VersionLoadResult.getResult()",
      "boolean VersionLoadResult.isDone()", "void VersionLoadResult.setDone(boolean)",
      "void VersionLoadResult.setError(EntityLoadError)", "void VersionLoadResult.setResult(List)",
      "String VersionLoadResult.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ArrayList<EntityTypeLoadResult> result = new ArrayList<>();
    EntityLoadError error = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();

    // Act
    VersionLoadResult actualVersionLoadResult = new VersionLoadResult(result, error, true);
    actualVersionLoadResult.setDone(true);
    EntityLoadError error2 = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();
    actualVersionLoadResult.setError(error2);
    ArrayList<EntityTypeLoadResult> result2 = new ArrayList<>();
    actualVersionLoadResult.setResult(result2);
    String actualToStringResult = actualVersionLoadResult.toString();
    EntityLoadError actualError = actualVersionLoadResult.getError();
    List<EntityTypeLoadResult> actualResult = actualVersionLoadResult.getResult();
    boolean actualIsDoneResult = actualVersionLoadResult.isDone();

    // Assert
    assertEquals("VersionLoadResult(result=[], error=EntityLoadError(type=Type, source=13814000-1dd2-11b2-8080"
        + "-808080808080, target=13814000-1dd2-11b2-8080-808080808080, message=Not all who wander are lost),"
        + " done=true)", actualToStringResult);
    assertTrue(actualResult.isEmpty());
    assertTrue(actualIsDoneResult);
    assertSame(result2, actualResult);
    assertSame(error2, actualError);
  }

  /**
   * Test VersionLoadResultBuilder {@link VersionLoadResultBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VersionLoadResultBuilder#build()}
   *   <li>{@link VersionLoadResultBuilder#done(boolean)}
   *   <li>{@link VersionLoadResultBuilder#error(EntityLoadError)}
   *   <li>{@link VersionLoadResultBuilder#result(List)}
   * </ul>
   */
  @Test
  @DisplayName("Test VersionLoadResultBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void VersionLoadResultBuilder.<init>()", "VersionLoadResult VersionLoadResultBuilder.build()",
      "VersionLoadResultBuilder VersionLoadResultBuilder.done(boolean)",
      "VersionLoadResultBuilder VersionLoadResultBuilder.error(EntityLoadError)",
      "VersionLoadResultBuilder VersionLoadResultBuilder.result(List)", "String VersionLoadResultBuilder.toString()"})
  void testVersionLoadResultBuilderBuild() {
    // Arrange
    VersionLoadResultBuilder doneResult = VersionLoadResult.builder().done(true);
    EntityLoadError error = EntityLoadError.builder()
        .message("Not all who wander are lost")
        .source(TenantId.SYS_TENANT_ID)
        .target(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();
    VersionLoadResultBuilder errorResult = doneResult.error(error);
    ArrayList<EntityTypeLoadResult> result = new ArrayList<>();

    // Act
    VersionLoadResult actualBuildResult = errorResult.result(result).build();

    // Assert
    EntityLoadError error2 = actualBuildResult.getError();
    EntityId source = error2.getSource();
    assertTrue(source instanceof TenantId);
    assertEquals("Not all who wander are lost", error2.getMessage());
    assertEquals("Type", error2.getType());
    List<EntityTypeLoadResult> result2 = actualBuildResult.getResult();
    assertTrue(result2.isEmpty());
    assertTrue(actualBuildResult.isDone());
    assertSame(result, result2);
    assertSame(source, error2.getTarget());
  }
}
