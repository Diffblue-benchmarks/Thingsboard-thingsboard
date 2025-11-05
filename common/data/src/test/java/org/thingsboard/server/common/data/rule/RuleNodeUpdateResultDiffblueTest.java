package org.thingsboard.server.common.data.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.RuleNodeId;

class RuleNodeUpdateResultDiffblueTest {
  /**
   * Test {@link RuleNodeUpdateResult#equals(Object)}, and {@link RuleNodeUpdateResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeUpdateResult#equals(Object)}
   *   <li>{@link RuleNodeUpdateResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeUpdateResult.equals(Object)",
    "int RuleNodeUpdateResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleNode oldRuleNode = new RuleNode();
    RuleNodeUpdateResult ruleNodeUpdateResult =
        new RuleNodeUpdateResult(oldRuleNode, new RuleNode());
    RuleNode oldRuleNode2 = new RuleNode();
    RuleNodeUpdateResult ruleNodeUpdateResult2 =
        new RuleNodeUpdateResult(oldRuleNode2, new RuleNode());

    // Act and Assert
    assertEquals(ruleNodeUpdateResult, ruleNodeUpdateResult2);
    assertEquals(ruleNodeUpdateResult.hashCode(), ruleNodeUpdateResult2.hashCode());
  }

  /**
   * Test {@link RuleNodeUpdateResult#equals(Object)}, and {@link RuleNodeUpdateResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeUpdateResult#equals(Object)}
   *   <li>{@link RuleNodeUpdateResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeUpdateResult.equals(Object)",
    "int RuleNodeUpdateResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RuleNodeUpdateResult ruleNodeUpdateResult = new RuleNodeUpdateResult(null, new RuleNode());
    RuleNodeUpdateResult ruleNodeUpdateResult2 = new RuleNodeUpdateResult(null, new RuleNode());

    // Act and Assert
    assertEquals(ruleNodeUpdateResult, ruleNodeUpdateResult2);
    assertEquals(ruleNodeUpdateResult.hashCode(), ruleNodeUpdateResult2.hashCode());
  }

  /**
   * Test {@link RuleNodeUpdateResult#equals(Object)}, and {@link RuleNodeUpdateResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeUpdateResult#equals(Object)}
   *   <li>{@link RuleNodeUpdateResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeUpdateResult.equals(Object)",
    "int RuleNodeUpdateResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RuleNodeUpdateResult ruleNodeUpdateResult = new RuleNodeUpdateResult(new RuleNode(), null);
    RuleNodeUpdateResult ruleNodeUpdateResult2 = new RuleNodeUpdateResult(new RuleNode(), null);

    // Act and Assert
    assertEquals(ruleNodeUpdateResult, ruleNodeUpdateResult2);
    assertEquals(ruleNodeUpdateResult.hashCode(), ruleNodeUpdateResult2.hashCode());
  }

  /**
   * Test {@link RuleNodeUpdateResult#equals(Object)}, and {@link RuleNodeUpdateResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeUpdateResult#equals(Object)}
   *   <li>{@link RuleNodeUpdateResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeUpdateResult.equals(Object)",
    "int RuleNodeUpdateResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleNode oldRuleNode = new RuleNode();
    RuleNodeUpdateResult ruleNodeUpdateResult =
        new RuleNodeUpdateResult(oldRuleNode, new RuleNode());

    // Act and Assert
    assertEquals(ruleNodeUpdateResult, ruleNodeUpdateResult);
    int expectedHashCodeResult = ruleNodeUpdateResult.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeUpdateResult.hashCode());
  }

  /**
   * Test {@link RuleNodeUpdateResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeUpdateResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeUpdateResult.equals(Object)",
    "int RuleNodeUpdateResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleNodeUpdateResult ruleNodeUpdateResult = new RuleNodeUpdateResult(null, new RuleNode());
    RuleNode oldRuleNode = new RuleNode();
    RuleNodeUpdateResult ruleNodeUpdateResult2 =
        new RuleNodeUpdateResult(oldRuleNode, new RuleNode());

    // Act and Assert
    assertNotEquals(ruleNodeUpdateResult, ruleNodeUpdateResult2);
  }

  /**
   * Test {@link RuleNodeUpdateResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeUpdateResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeUpdateResult.equals(Object)",
    "int RuleNodeUpdateResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleNodeId id = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNode oldRuleNode = new RuleNode(id);
    RuleNodeUpdateResult ruleNodeUpdateResult =
        new RuleNodeUpdateResult(oldRuleNode, new RuleNode());
    RuleNode oldRuleNode2 = new RuleNode();
    RuleNodeUpdateResult ruleNodeUpdateResult2 =
        new RuleNodeUpdateResult(oldRuleNode2, new RuleNode());

    // Act and Assert
    assertNotEquals(ruleNodeUpdateResult, ruleNodeUpdateResult2);
  }

  /**
   * Test {@link RuleNodeUpdateResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeUpdateResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeUpdateResult.equals(Object)",
    "int RuleNodeUpdateResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleNodeUpdateResult ruleNodeUpdateResult = new RuleNodeUpdateResult(new RuleNode(), null);
    RuleNode oldRuleNode = new RuleNode();
    RuleNodeUpdateResult ruleNodeUpdateResult2 =
        new RuleNodeUpdateResult(oldRuleNode, new RuleNode());

    // Act and Assert
    assertNotEquals(ruleNodeUpdateResult, ruleNodeUpdateResult2);
  }

  /**
   * Test {@link RuleNodeUpdateResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeUpdateResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeUpdateResult.equals(Object)",
    "int RuleNodeUpdateResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleNode oldRuleNode = new RuleNode();
    RuleNodeId id = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNode newRuleNode = new RuleNode(id);

    RuleNodeUpdateResult ruleNodeUpdateResult = new RuleNodeUpdateResult(oldRuleNode, newRuleNode);
    RuleNode oldRuleNode2 = new RuleNode();
    RuleNodeUpdateResult ruleNodeUpdateResult2 =
        new RuleNodeUpdateResult(oldRuleNode2, new RuleNode());

    // Act and Assert
    assertNotEquals(ruleNodeUpdateResult, ruleNodeUpdateResult2);
  }

  /**
   * Test {@link RuleNodeUpdateResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeUpdateResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeUpdateResult.equals(Object)",
    "int RuleNodeUpdateResult.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleNode oldRuleNode = new RuleNode();
    RuleNodeUpdateResult ruleNodeUpdateResult =
        new RuleNodeUpdateResult(oldRuleNode, new RuleNode());

    // Act and Assert
    assertNotEquals(ruleNodeUpdateResult, null);
  }

  /**
   * Test {@link RuleNodeUpdateResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeUpdateResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeUpdateResult.equals(Object)",
    "int RuleNodeUpdateResult.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleNode oldRuleNode = new RuleNode();
    RuleNodeUpdateResult ruleNodeUpdateResult =
        new RuleNodeUpdateResult(oldRuleNode, new RuleNode());

    // Act and Assert
    assertNotEquals(ruleNodeUpdateResult, "Different type to RuleNodeUpdateResult");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeUpdateResult#RuleNodeUpdateResult(RuleNode, RuleNode)}
   *   <li>{@link RuleNodeUpdateResult#toString()}
   *   <li>{@link RuleNodeUpdateResult#getNewRuleNode()}
   *   <li>{@link RuleNodeUpdateResult#getOldRuleNode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleNodeUpdateResult.<init>(RuleNode, RuleNode)",
    "RuleNode RuleNodeUpdateResult.getNewRuleNode()",
    "RuleNode RuleNodeUpdateResult.getOldRuleNode()",
    "String RuleNodeUpdateResult.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    RuleNode oldRuleNode = new RuleNode();
    RuleNode newRuleNode = new RuleNode();

    // Act
    RuleNodeUpdateResult actualRuleNodeUpdateResult =
        new RuleNodeUpdateResult(oldRuleNode, newRuleNode);
    String actualToStringResult = actualRuleNodeUpdateResult.toString();
    RuleNode actualNewRuleNode = actualRuleNodeUpdateResult.getNewRuleNode();

    // Assert
    assertEquals(
        "RuleNodeUpdateResult(oldRuleNode=RuleNode(ruleChainId=null, type=null, name=null, debugMode=false,"
            + " singletonMode=false, queueName=null, configurationVersion=0, configuration=null, configurationBytes=null,"
            + " externalId=null), newRuleNode=RuleNode(ruleChainId=null, type=null, name=null, debugMode=false,"
            + " singletonMode=false, queueName=null, configurationVersion=0, configuration=null, configurationBytes=null,"
            + " externalId=null))",
        actualToStringResult);
    assertSame(newRuleNode, actualNewRuleNode);
    assertSame(oldRuleNode, actualRuleNodeUpdateResult.getOldRuleNode());
  }
}
