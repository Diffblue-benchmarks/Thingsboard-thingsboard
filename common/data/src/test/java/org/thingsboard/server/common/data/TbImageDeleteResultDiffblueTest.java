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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.HasId;

class TbImageDeleteResultDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbImageDeleteResult#equals(Object)}
   *   <li>{@link TbImageDeleteResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbImageDeleteResult.TbImageDeleteResultBuilder builderResult = TbImageDeleteResult.builder();
    TbImageDeleteResult buildResult = builderResult.references(new HashMap<>()).success(true).build();
    TbImageDeleteResult.TbImageDeleteResultBuilder builderResult2 = TbImageDeleteResult.builder();
    TbImageDeleteResult buildResult2 = builderResult2.references(new HashMap<>()).success(true).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbImageDeleteResult#equals(Object)}
   *   <li>{@link TbImageDeleteResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbImageDeleteResult.TbImageDeleteResultBuilder builderResult = TbImageDeleteResult.builder();
    TbImageDeleteResult buildResult = builderResult.references(new HashMap<>()).success(true).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link TbImageDeleteResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TbImageDeleteResult.TbImageDeleteResultBuilder builderResult = TbImageDeleteResult.builder();
    TbImageDeleteResult buildResult = builderResult.references(new HashMap<>()).success(true).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link TbImageDeleteResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TbImageDeleteResult.TbImageDeleteResultBuilder builderResult = TbImageDeleteResult.builder();
    TbImageDeleteResult buildResult = builderResult.references(new HashMap<>()).success(true).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to TbImageDeleteResult");
  }

  /**
   * Methods under test:
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
  void testGettersAndSetters() {
    // Arrange and Act
    TbImageDeleteResult actualTbImageDeleteResult = new TbImageDeleteResult(true, new HashMap<>());
    HashMap<String, List<? extends HasId<?>>> references = new HashMap<>();
    actualTbImageDeleteResult.setReferences(references);
    actualTbImageDeleteResult.setSuccess(true);
    String actualToStringResult = actualTbImageDeleteResult.toString();
    Map<String, List<? extends HasId<?>>> actualReferences = actualTbImageDeleteResult.getReferences();
    boolean actualIsSuccessResult = actualTbImageDeleteResult.isSuccess();

    // Assert that nothing has changed
    assertEquals("TbImageDeleteResult(success=true, references={})", actualToStringResult);
    assertTrue(actualReferences.isEmpty());
    assertTrue(actualIsSuccessResult);
    assertSame(references, actualReferences);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbImageDeleteResult.TbImageDeleteResultBuilder#build()}
   *   <li>{@link TbImageDeleteResult.TbImageDeleteResultBuilder#references(Map)}
   *   <li>{@link TbImageDeleteResult.TbImageDeleteResultBuilder#success(boolean)}
   * </ul>
   */
  @Test
  void testTbImageDeleteResultBuilderBuild() {
    // Arrange
    TbImageDeleteResult.TbImageDeleteResultBuilder builderResult = TbImageDeleteResult.builder();
    HashMap<String, List<? extends HasId<?>>> references = new HashMap<>();

    // Act
    TbImageDeleteResult actualBuildResult = builderResult.references(references).success(true).build();

    // Assert
    Map<String, List<? extends HasId<?>>> references2 = actualBuildResult.getReferences();
    assertTrue(references2.isEmpty());
    assertTrue(actualBuildResult.isSuccess());
    assertSame(references, references2);
  }
}
