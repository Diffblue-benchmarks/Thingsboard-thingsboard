package org.thingsboard.server.service.queue.processing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbRuleEngineProcessingDecisionDiffblueTest {
  /**
   * Test {@link TbRuleEngineProcessingDecision#equals(Object)}, and {@link TbRuleEngineProcessingDecision#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbRuleEngineProcessingDecision#equals(Object)}
   *   <li>{@link TbRuleEngineProcessingDecision#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbRuleEngineProcessingDecision.equals(Object)",
      "int TbRuleEngineProcessingDecision.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbRuleEngineProcessingDecision tbRuleEngineProcessingDecision = new TbRuleEngineProcessingDecision(true,
        new ConcurrentHashMap<>());
    TbRuleEngineProcessingDecision tbRuleEngineProcessingDecision2 = new TbRuleEngineProcessingDecision(true,
        new ConcurrentHashMap<>());

    // Act and Assert
    assertEquals(tbRuleEngineProcessingDecision, tbRuleEngineProcessingDecision2);
    int expectedHashCodeResult = tbRuleEngineProcessingDecision.hashCode();
    assertEquals(expectedHashCodeResult, tbRuleEngineProcessingDecision2.hashCode());
  }

  /**
   * Test {@link TbRuleEngineProcessingDecision#equals(Object)}, and {@link TbRuleEngineProcessingDecision#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbRuleEngineProcessingDecision#equals(Object)}
   *   <li>{@link TbRuleEngineProcessingDecision#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbRuleEngineProcessingDecision.equals(Object)",
      "int TbRuleEngineProcessingDecision.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbRuleEngineProcessingDecision tbRuleEngineProcessingDecision = new TbRuleEngineProcessingDecision(true,
        new ConcurrentHashMap<>());

    // Act and Assert
    assertEquals(tbRuleEngineProcessingDecision, tbRuleEngineProcessingDecision);
    int expectedHashCodeResult = tbRuleEngineProcessingDecision.hashCode();
    assertEquals(expectedHashCodeResult, tbRuleEngineProcessingDecision.hashCode());
  }

  /**
   * Test {@link TbRuleEngineProcessingDecision#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRuleEngineProcessingDecision#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbRuleEngineProcessingDecision.equals(Object)",
      "int TbRuleEngineProcessingDecision.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbRuleEngineProcessingDecision tbRuleEngineProcessingDecision = new TbRuleEngineProcessingDecision(false,
        new ConcurrentHashMap<>());

    // Act and Assert
    assertNotEquals(tbRuleEngineProcessingDecision,
        new TbRuleEngineProcessingDecision(true, new ConcurrentHashMap<>()));
  }

  /**
   * Test {@link TbRuleEngineProcessingDecision#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRuleEngineProcessingDecision#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbRuleEngineProcessingDecision.equals(Object)",
      "int TbRuleEngineProcessingDecision.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbRuleEngineProcessingDecision(true, new ConcurrentHashMap<>()), null);
  }

  /**
   * Test {@link TbRuleEngineProcessingDecision#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRuleEngineProcessingDecision#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbRuleEngineProcessingDecision.equals(Object)",
      "int TbRuleEngineProcessingDecision.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbRuleEngineProcessingDecision(true, new ConcurrentHashMap<>()),
        "Different type to TbRuleEngineProcessingDecision");
  }
}
