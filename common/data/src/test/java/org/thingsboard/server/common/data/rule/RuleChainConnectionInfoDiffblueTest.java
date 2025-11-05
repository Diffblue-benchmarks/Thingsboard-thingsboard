package org.thingsboard.server.common.data.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;

class RuleChainConnectionInfoDiffblueTest {
  /**
   * Test {@link RuleChainConnectionInfo#equals(Object)}, and {@link
   * RuleChainConnectionInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainConnectionInfo#equals(Object)}
   *   <li>{@link RuleChainConnectionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleChainConnectionInfo.equals(Object)",
    "int RuleChainConnectionInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo.setType("Type");

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo2.setFromIndex(1);
    ruleChainConnectionInfo2.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo2.setType("Type");

    // Act and Assert
    assertEquals(ruleChainConnectionInfo, ruleChainConnectionInfo2);
    assertEquals(ruleChainConnectionInfo.hashCode(), ruleChainConnectionInfo2.hashCode());
  }

  /**
   * Test {@link RuleChainConnectionInfo#equals(Object)}, and {@link
   * RuleChainConnectionInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainConnectionInfo#equals(Object)}
   *   <li>{@link RuleChainConnectionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleChainConnectionInfo.equals(Object)",
    "int RuleChainConnectionInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(null);
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo.setType("Type");

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(null);
    ruleChainConnectionInfo2.setFromIndex(1);
    ruleChainConnectionInfo2.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo2.setType("Type");

    // Act and Assert
    assertEquals(ruleChainConnectionInfo, ruleChainConnectionInfo2);
    assertEquals(ruleChainConnectionInfo.hashCode(), ruleChainConnectionInfo2.hashCode());
  }

  /**
   * Test {@link RuleChainConnectionInfo#equals(Object)}, and {@link
   * RuleChainConnectionInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainConnectionInfo#equals(Object)}
   *   <li>{@link RuleChainConnectionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleChainConnectionInfo.equals(Object)",
    "int RuleChainConnectionInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(null);
    ruleChainConnectionInfo.setType("Type");

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo2.setFromIndex(1);
    ruleChainConnectionInfo2.setTargetRuleChainId(null);
    ruleChainConnectionInfo2.setType("Type");

    // Act and Assert
    assertEquals(ruleChainConnectionInfo, ruleChainConnectionInfo2);
    assertEquals(ruleChainConnectionInfo.hashCode(), ruleChainConnectionInfo2.hashCode());
  }

  /**
   * Test {@link RuleChainConnectionInfo#equals(Object)}, and {@link
   * RuleChainConnectionInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainConnectionInfo#equals(Object)}
   *   <li>{@link RuleChainConnectionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleChainConnectionInfo.equals(Object)",
    "int RuleChainConnectionInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo.setType(null);

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo2.setFromIndex(1);
    ruleChainConnectionInfo2.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo2.setType(null);

    // Act and Assert
    assertEquals(ruleChainConnectionInfo, ruleChainConnectionInfo2);
    assertEquals(ruleChainConnectionInfo.hashCode(), ruleChainConnectionInfo2.hashCode());
  }

  /**
   * Test {@link RuleChainConnectionInfo#equals(Object)}, and {@link
   * RuleChainConnectionInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainConnectionInfo#equals(Object)}
   *   <li>{@link RuleChainConnectionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleChainConnectionInfo.equals(Object)",
    "int RuleChainConnectionInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo.setType("Type");

    // Act and Assert
    assertEquals(ruleChainConnectionInfo, ruleChainConnectionInfo);
    int expectedHashCodeResult = ruleChainConnectionInfo.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainConnectionInfo.hashCode());
  }

  /**
   * Test {@link RuleChainConnectionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainConnectionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleChainConnectionInfo.equals(Object)",
    "int RuleChainConnectionInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(BooleanNode.getFalse());
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo.setType("Type");

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo2.setFromIndex(1);
    ruleChainConnectionInfo2.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo2.setType("Type");

    // Act and Assert
    assertNotEquals(ruleChainConnectionInfo, ruleChainConnectionInfo2);
  }

  /**
   * Test {@link RuleChainConnectionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainConnectionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleChainConnectionInfo.equals(Object)",
    "int RuleChainConnectionInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(null);
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo.setType("Type");

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo2.setFromIndex(1);
    ruleChainConnectionInfo2.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo2.setType("Type");

    // Act and Assert
    assertNotEquals(ruleChainConnectionInfo, ruleChainConnectionInfo2);
  }

  /**
   * Test {@link RuleChainConnectionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainConnectionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleChainConnectionInfo.equals(Object)",
    "int RuleChainConnectionInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo.setFromIndex(3);
    ruleChainConnectionInfo.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo.setType("Type");

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo2.setFromIndex(1);
    ruleChainConnectionInfo2.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo2.setType("Type");

    // Act and Assert
    assertNotEquals(ruleChainConnectionInfo, ruleChainConnectionInfo2);
  }

  /**
   * Test {@link RuleChainConnectionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainConnectionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleChainConnectionInfo.equals(Object)",
    "int RuleChainConnectionInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainConnectionInfo.setType("Type");

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo2.setFromIndex(1);
    ruleChainConnectionInfo2.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo2.setType("Type");

    // Act and Assert
    assertNotEquals(ruleChainConnectionInfo, ruleChainConnectionInfo2);
  }

  /**
   * Test {@link RuleChainConnectionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainConnectionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleChainConnectionInfo.equals(Object)",
    "int RuleChainConnectionInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(null);
    ruleChainConnectionInfo.setType("Type");

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo2.setFromIndex(1);
    ruleChainConnectionInfo2.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo2.setType("Type");

    // Act and Assert
    assertNotEquals(ruleChainConnectionInfo, ruleChainConnectionInfo2);
  }

  /**
   * Test {@link RuleChainConnectionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainConnectionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleChainConnectionInfo.equals(Object)",
    "int RuleChainConnectionInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo.setType(null);

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo2.setFromIndex(1);
    ruleChainConnectionInfo2.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo2.setType("Type");

    // Act and Assert
    assertNotEquals(ruleChainConnectionInfo, ruleChainConnectionInfo2);
  }

  /**
   * Test {@link RuleChainConnectionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainConnectionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleChainConnectionInfo.equals(Object)",
    "int RuleChainConnectionInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo.setType(
        "org.thingsboard.server.common.data.rule.RuleChainConnectionInfo");

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo2.setFromIndex(1);
    ruleChainConnectionInfo2.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo2.setType("Type");

    // Act and Assert
    assertNotEquals(ruleChainConnectionInfo, ruleChainConnectionInfo2);
  }

  /**
   * Test {@link RuleChainConnectionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainConnectionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleChainConnectionInfo.equals(Object)",
    "int RuleChainConnectionInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo.setType("Type");

    // Act and Assert
    assertNotEquals(ruleChainConnectionInfo, null);
  }

  /**
   * Test {@link RuleChainConnectionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainConnectionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleChainConnectionInfo.equals(Object)",
    "int RuleChainConnectionInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo.setType("Type");

    // Act and Assert
    assertNotEquals(ruleChainConnectionInfo, "Different type to RuleChainConnectionInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link RuleChainConnectionInfo}
   *   <li>{@link RuleChainConnectionInfo#setAdditionalInfo(JsonNode)}
   *   <li>{@link RuleChainConnectionInfo#setFromIndex(int)}
   *   <li>{@link RuleChainConnectionInfo#setTargetRuleChainId(RuleChainId)}
   *   <li>{@link RuleChainConnectionInfo#setType(String)}
   *   <li>{@link RuleChainConnectionInfo#toString()}
   *   <li>{@link RuleChainConnectionInfo#getAdditionalInfo()}
   *   <li>{@link RuleChainConnectionInfo#getFromIndex()}
   *   <li>{@link RuleChainConnectionInfo#getTargetRuleChainId()}
   *   <li>{@link RuleChainConnectionInfo#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainConnectionInfo.<init>()",
    "JsonNode RuleChainConnectionInfo.getAdditionalInfo()",
    "int RuleChainConnectionInfo.getFromIndex()",
    "RuleChainId RuleChainConnectionInfo.getTargetRuleChainId()",
    "String RuleChainConnectionInfo.getType()",
    "void RuleChainConnectionInfo.setAdditionalInfo(JsonNode)",
    "void RuleChainConnectionInfo.setFromIndex(int)",
    "void RuleChainConnectionInfo.setTargetRuleChainId(RuleChainId)",
    "void RuleChainConnectionInfo.setType(String)",
    "String RuleChainConnectionInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RuleChainConnectionInfo actualRuleChainConnectionInfo = new RuleChainConnectionInfo();
    DoubleNode additionalInfo = DoubleNode.valueOf(10.0d);
    actualRuleChainConnectionInfo.setAdditionalInfo(additionalInfo);
    actualRuleChainConnectionInfo.setFromIndex(1);
    RuleChainId targetRuleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualRuleChainConnectionInfo.setTargetRuleChainId(targetRuleChainId);
    actualRuleChainConnectionInfo.setType("Type");
    String actualToStringResult = actualRuleChainConnectionInfo.toString();
    JsonNode actualAdditionalInfo = actualRuleChainConnectionInfo.getAdditionalInfo();
    int actualFromIndex = actualRuleChainConnectionInfo.getFromIndex();
    RuleChainId actualTargetRuleChainId = actualRuleChainConnectionInfo.getTargetRuleChainId();

    // Assert
    assertEquals(
        "RuleChainConnectionInfo(fromIndex=1, targetRuleChainId=784f394c-42b6-435a-983c-b7beff2784f9,"
            + " additionalInfo=10.0, type=Type)",
        actualToStringResult);
    assertEquals("Type", actualRuleChainConnectionInfo.getType());
    assertEquals(1, actualFromIndex);
    assertSame(targetRuleChainId, actualTargetRuleChainId);
    assertSame(additionalInfo, actualAdditionalInfo);
  }
}
