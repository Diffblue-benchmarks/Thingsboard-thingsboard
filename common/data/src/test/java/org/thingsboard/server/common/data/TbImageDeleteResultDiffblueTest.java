package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
  @Autowired
  private TbImageDeleteResultBuilder tbImageDeleteResultBuilder;

  /**
   * Test {@link TbImageDeleteResult#equals(Object)}, and {@link TbImageDeleteResult#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbImageDeleteResult.equals(Object)", "int TbImageDeleteResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbImageDeleteResultBuilder builderResult = TbImageDeleteResult.builder();
    TbImageDeleteResult buildResult = builderResult.references(new HashMap<>()).success(true).build();
    TbImageDeleteResultBuilder builderResult2 = TbImageDeleteResult.builder();
    TbImageDeleteResult buildResult2 = builderResult2.references(new HashMap<>()).success(true).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link TbImageDeleteResult#equals(Object)}, and {@link TbImageDeleteResult#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbImageDeleteResult.equals(Object)", "int TbImageDeleteResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbImageDeleteResultBuilder builderResult = TbImageDeleteResult.builder();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbImageDeleteResult.equals(Object)", "int TbImageDeleteResult.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TbImageDeleteResultBuilder builderResult = TbImageDeleteResult.builder();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbImageDeleteResult.equals(Object)", "int TbImageDeleteResult.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TbImageDeleteResultBuilder builderResult = TbImageDeleteResult.builder();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbImageDeleteResult.<init>(boolean, Map)", "Map TbImageDeleteResult.getReferences()",
      "boolean TbImageDeleteResult.isSuccess()", "void TbImageDeleteResult.setReferences(Map)",
      "void TbImageDeleteResult.setSuccess(boolean)", "String TbImageDeleteResult.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TbImageDeleteResult actualTbImageDeleteResult = new TbImageDeleteResult(true, new HashMap<>());
    HashMap<String, List<? extends HasId<?>>> references = new HashMap<>();
    actualTbImageDeleteResult.setReferences(references);
    actualTbImageDeleteResult.setSuccess(true);
    String actualToStringResult = actualTbImageDeleteResult.toString();
    Map<String, List<? extends HasId<?>>> actualReferences = actualTbImageDeleteResult.getReferences();
    boolean actualIsSuccessResult = actualTbImageDeleteResult.isSuccess();

    // Assert
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
   *   <li>{@link TbImageDeleteResultBuilder#build()}
   *   <li>{@link TbImageDeleteResultBuilder#references(Map)}
   *   <li>{@link TbImageDeleteResultBuilder#success(boolean)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbImageDeleteResultBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbImageDeleteResultBuilder.<init>()",
      "TbImageDeleteResult TbImageDeleteResultBuilder.build()",
      "TbImageDeleteResultBuilder TbImageDeleteResultBuilder.references(Map)",
      "TbImageDeleteResultBuilder TbImageDeleteResultBuilder.success(boolean)",
      "String TbImageDeleteResultBuilder.toString()"})
  void testTbImageDeleteResultBuilderBuild() {
    // Arrange
    TbImageDeleteResultBuilder builderResult = TbImageDeleteResult.builder();
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
