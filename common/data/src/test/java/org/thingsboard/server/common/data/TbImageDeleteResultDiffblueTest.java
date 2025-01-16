package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.TbImageDeleteResult.TbImageDeleteResultBuilder;
import org.thingsboard.server.common.data.id.HasId;

class TbImageDeleteResultDiffblueTest {
  /**
   * Test {@link TbImageDeleteResult#equals(Object)}, and
   * {@link TbImageDeleteResult#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbImageDeleteResult#equals(Object)}
   *   <li>{@link TbImageDeleteResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link TbImageDeleteResult#equals(Object)}, and
   * {@link TbImageDeleteResult#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbImageDeleteResult#equals(Object)}
   *   <li>{@link TbImageDeleteResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * Test {@link TbImageDeleteResult#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbImageDeleteResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TbImageDeleteResult.TbImageDeleteResultBuilder builderResult = TbImageDeleteResult.builder();
    TbImageDeleteResult buildResult = builderResult.references(new HashMap<>()).success(true).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link TbImageDeleteResult#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbImageDeleteResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TbImageDeleteResult.TbImageDeleteResultBuilder builderResult = TbImageDeleteResult.builder();
    TbImageDeleteResult buildResult = builderResult.references(new HashMap<>()).success(true).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to TbImageDeleteResult");
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
   * Test TbImageDeleteResultBuilder {@link TbImageDeleteResultBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbImageDeleteResult.TbImageDeleteResultBuilder#build()}
   *   <li>{@link TbImageDeleteResult.TbImageDeleteResultBuilder#references(Map)}
   *   <li>{@link TbImageDeleteResult.TbImageDeleteResultBuilder#success(boolean)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbImageDeleteResultBuilder build()")
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
