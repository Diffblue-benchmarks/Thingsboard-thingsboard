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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.TbImageDeleteResult.TbImageDeleteResultBuilder;
import org.thingsboard.server.common.data.id.HasId;

@ContextConfiguration(classes = {TbImageDeleteResultBuilder.class})
@ExtendWith(SpringExtension.class)
class TbImageDeleteResultDiffblueTest {
  @Autowired private TbImageDeleteResultBuilder tbImageDeleteResultBuilder;

  /**
   * Test {@link TbImageDeleteResult#equals(Object)}, and {@link TbImageDeleteResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbImageDeleteResult#equals(Object)}
   *   <li>{@link TbImageDeleteResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbImageDeleteResult.equals(Object)",
    "int TbImageDeleteResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbImageDeleteResultBuilder builderResult = TbImageDeleteResult.builder();
    TbImageDeleteResult tbImageDeleteResult =
        builderResult.references(new HashMap<>()).success(true).build();

    TbImageDeleteResultBuilder builderResult2 = TbImageDeleteResult.builder();
    TbImageDeleteResult tbImageDeleteResult2 =
        builderResult2.references(new HashMap<>()).success(true).build();

    // Act and Assert
    assertEquals(tbImageDeleteResult, tbImageDeleteResult2);
    assertEquals(tbImageDeleteResult.hashCode(), tbImageDeleteResult2.hashCode());
  }

  /**
   * Test {@link TbImageDeleteResult#equals(Object)}, and {@link TbImageDeleteResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbImageDeleteResult#equals(Object)}
   *   <li>{@link TbImageDeleteResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbImageDeleteResult.equals(Object)",
    "int TbImageDeleteResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbImageDeleteResultBuilder builderResult = TbImageDeleteResult.builder();
    TbImageDeleteResult tbImageDeleteResult =
        builderResult.references(new HashMap<>()).success(true).build();

    // Act and Assert
    assertEquals(tbImageDeleteResult, tbImageDeleteResult);
    int expectedHashCodeResult = tbImageDeleteResult.hashCode();
    assertEquals(expectedHashCodeResult, tbImageDeleteResult.hashCode());
  }

  /**
   * Test {@link TbImageDeleteResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbImageDeleteResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbImageDeleteResult.equals(Object)",
    "int TbImageDeleteResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashMap<String, List<? extends HasId<?>>> references = new HashMap<>();
    references.put("foo", new ArrayList<>());
    TbImageDeleteResult tbImageDeleteResult =
        TbImageDeleteResult.builder().references(references).success(true).build();

    TbImageDeleteResultBuilder builderResult = TbImageDeleteResult.builder();

    // Act and Assert
    assertNotEquals(
        tbImageDeleteResult, builderResult.references(new HashMap<>()).success(true).build());
  }

  /**
   * Test {@link TbImageDeleteResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbImageDeleteResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbImageDeleteResult.equals(Object)",
    "int TbImageDeleteResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbImageDeleteResultBuilder builderResult = TbImageDeleteResult.builder();
    TbImageDeleteResult tbImageDeleteResult =
        builderResult.references(new HashMap<>()).success(false).build();

    TbImageDeleteResultBuilder builderResult2 = TbImageDeleteResult.builder();

    // Act and Assert
    assertNotEquals(
        tbImageDeleteResult, builderResult2.references(new HashMap<>()).success(true).build());
  }

  /**
   * Test {@link TbImageDeleteResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbImageDeleteResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbImageDeleteResult.equals(Object)",
    "int TbImageDeleteResult.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TbImageDeleteResultBuilder builderResult = TbImageDeleteResult.builder();

    // Act and Assert
    assertNotEquals(builderResult.references(new HashMap<>()).success(true).build(), null);
  }

  /**
   * Test {@link TbImageDeleteResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbImageDeleteResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbImageDeleteResult.equals(Object)",
    "int TbImageDeleteResult.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TbImageDeleteResultBuilder builderResult = TbImageDeleteResult.builder();

    // Act and Assert
    assertNotEquals(
        builderResult.references(new HashMap<>()).success(true).build(),
        "Different type to TbImageDeleteResult");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbImageDeleteResult#TbImageDeleteResult(boolean, Map)}
   *   <li>{@link TbImageDeleteResult#setReferences(Map)}
   *   <li>{@link TbImageDeleteResult#setSuccess(boolean)}
   *   <li>{@link TbImageDeleteResult#toString()}
   *   <li>{@link TbImageDeleteResult#getReferences()}
   *   <li>{@link TbImageDeleteResult#isSuccess()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbImageDeleteResult.<init>(boolean, Map)",
    "Map TbImageDeleteResult.getReferences()",
    "boolean TbImageDeleteResult.isSuccess()",
    "void TbImageDeleteResult.setReferences(Map)",
    "void TbImageDeleteResult.setSuccess(boolean)",
    "String TbImageDeleteResult.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbImageDeleteResult actualTbImageDeleteResult = new TbImageDeleteResult(true, new HashMap<>());
    HashMap<String, List<? extends HasId<?>>> references = new HashMap<>();
    actualTbImageDeleteResult.setReferences(references);
    actualTbImageDeleteResult.setSuccess(true);
    String actualToStringResult = actualTbImageDeleteResult.toString();
    Map<String, List<? extends HasId<?>>> actualReferences =
        actualTbImageDeleteResult.getReferences();
    boolean actualIsSuccessResult = actualTbImageDeleteResult.isSuccess();

    // Assert
    assertEquals("TbImageDeleteResult(success=true, references={})", actualToStringResult);
    assertTrue(actualReferences.isEmpty());
    assertTrue(actualIsSuccessResult);
    assertSame(references, actualReferences);
  }

  /**
   * Test TbImageDeleteResultBuilder {@link TbImageDeleteResultBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbImageDeleteResultBuilder#build()}
   *   <li>{@link TbImageDeleteResultBuilder#references(Map)}
   *   <li>{@link TbImageDeleteResultBuilder#success(boolean)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbImageDeleteResultBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbImageDeleteResultBuilder.<init>()",
    "TbImageDeleteResult TbImageDeleteResultBuilder.build()",
    "TbImageDeleteResultBuilder TbImageDeleteResultBuilder.references(Map)",
    "TbImageDeleteResultBuilder TbImageDeleteResultBuilder.success(boolean)",
    "String TbImageDeleteResultBuilder.toString()"
  })
  void testTbImageDeleteResultBuilderBuild() {
    // Arrange and Act
    TbImageDeleteResultBuilder actualBuilderResult = TbImageDeleteResult.builder();
    HashMap<String, List<? extends HasId<?>>> references = new HashMap<>();
    TbImageDeleteResult actualTbImageDeleteResult =
        actualBuilderResult.references(references).success(true).build();

    // Assert
    Map<String, List<? extends HasId<?>>> references2 = actualTbImageDeleteResult.getReferences();
    assertTrue(references2.isEmpty());
    assertTrue(actualTbImageDeleteResult.isSuccess());
    assertSame(references, references2);
  }
}
