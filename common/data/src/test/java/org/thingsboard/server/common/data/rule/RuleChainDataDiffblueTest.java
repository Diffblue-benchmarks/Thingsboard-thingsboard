package org.thingsboard.server.common.data.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RuleChainDataDiffblueTest {
  /**
   * Test {@link RuleChainData#equals(Object)}, and {@link RuleChainData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainData#equals(Object)}
   *   <li>{@link RuleChainData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainData.equals(Object)", "int RuleChainData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(new ArrayList<>());
    ruleChainData.setRuleChains(new ArrayList<>());

    RuleChainData ruleChainData2 = new RuleChainData();
    ruleChainData2.setMetadata(new ArrayList<>());
    ruleChainData2.setRuleChains(new ArrayList<>());

    // Act and Assert
    assertEquals(ruleChainData, ruleChainData2);
    int expectedHashCodeResult = ruleChainData.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainData2.hashCode());
  }

  /**
   * Test {@link RuleChainData#equals(Object)}, and {@link RuleChainData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainData#equals(Object)}
   *   <li>{@link RuleChainData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainData.equals(Object)", "int RuleChainData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(new ArrayList<>());
    ruleChainData.setRuleChains(new ArrayList<>());

    // Act and Assert
    assertEquals(ruleChainData, ruleChainData);
    int expectedHashCodeResult = ruleChainData.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainData.hashCode());
  }

  /**
   * Test {@link RuleChainData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainData.equals(Object)", "int RuleChainData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<RuleChainMetaData> metadata = new ArrayList<>();
    metadata.add(new RuleChainMetaData());

    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(metadata);
    ruleChainData.setRuleChains(new ArrayList<>());

    RuleChainData ruleChainData2 = new RuleChainData();
    ruleChainData2.setMetadata(new ArrayList<>());
    ruleChainData2.setRuleChains(new ArrayList<>());

    // Act and Assert
    assertNotEquals(ruleChainData, ruleChainData2);
  }

  /**
   * Test {@link RuleChainData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainData.equals(Object)", "int RuleChainData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<RuleChain> ruleChains = new ArrayList<>();
    ruleChains.add(new RuleChain());

    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(new ArrayList<>());
    ruleChainData.setRuleChains(ruleChains);

    RuleChainData ruleChainData2 = new RuleChainData();
    ruleChainData2.setMetadata(new ArrayList<>());
    ruleChainData2.setRuleChains(new ArrayList<>());

    // Act and Assert
    assertNotEquals(ruleChainData, ruleChainData2);
  }

  /**
   * Test {@link RuleChainData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainData.equals(Object)", "int RuleChainData.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(new ArrayList<>());
    ruleChainData.setRuleChains(new ArrayList<>());

    // Act and Assert
    assertNotEquals(ruleChainData, null);
  }

  /**
   * Test {@link RuleChainData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainData.equals(Object)", "int RuleChainData.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(new ArrayList<>());
    ruleChainData.setRuleChains(new ArrayList<>());

    // Act and Assert
    assertNotEquals(ruleChainData, "Different type to RuleChainData");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link RuleChainData}
   *   <li>{@link RuleChainData#setMetadata(List)}
   *   <li>{@link RuleChainData#setRuleChains(List)}
   *   <li>{@link RuleChainData#toString()}
   *   <li>{@link RuleChainData#getMetadata()}
   *   <li>{@link RuleChainData#getRuleChains()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void RuleChainData.<init>()",
    "List RuleChainData.getMetadata()",
    "List RuleChainData.getRuleChains()",
    "void RuleChainData.setMetadata(List)",
    "void RuleChainData.setRuleChains(List)",
    "String RuleChainData.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RuleChainData actualRuleChainData = new RuleChainData();
    ArrayList<RuleChainMetaData> metadata = new ArrayList<>();
    actualRuleChainData.setMetadata(metadata);
    ArrayList<RuleChain> ruleChains = new ArrayList<>();
    actualRuleChainData.setRuleChains(ruleChains);
    String actualToStringResult = actualRuleChainData.toString();
    List<RuleChainMetaData> actualMetadata = actualRuleChainData.getMetadata();
    List<RuleChain> actualRuleChains = actualRuleChainData.getRuleChains();

    // Assert
    assertEquals("RuleChainData(ruleChains=[], metadata=[])", actualToStringResult);
    assertTrue(actualMetadata.isEmpty());
    assertTrue(actualRuleChains.isEmpty());
    assertSame(metadata, actualMetadata);
    assertSame(ruleChains, actualRuleChains);
  }
}
