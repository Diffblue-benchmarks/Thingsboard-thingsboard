package org.thingsboard.server.common.data.sync.ie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.common.data.rule.RuleChainMetaData;

class RuleChainExportDataDiffblueTest {
  /**
   * Test {@link RuleChainExportData#equals(Object)}, and {@link RuleChainExportData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainExportData#equals(Object)}
   *   <li>{@link RuleChainExportData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleChainExportData.equals(Object)",
    "int RuleChainExportData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleChainExportData ruleChainExportData = new RuleChainExportData();
    RuleChainExportData ruleChainExportData2 = new RuleChainExportData();

    // Act and Assert
    assertEquals(ruleChainExportData, ruleChainExportData2);
    int expectedHashCodeResult = ruleChainExportData.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainExportData2.hashCode());
  }

  /**
   * Test {@link RuleChainExportData#equals(Object)}, and {@link RuleChainExportData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainExportData#equals(Object)}
   *   <li>{@link RuleChainExportData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleChainExportData.equals(Object)",
    "int RuleChainExportData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RuleChainExportData ruleChainExportData = new RuleChainExportData();
    ruleChainExportData.setMetaData(new RuleChainMetaData());

    RuleChainExportData ruleChainExportData2 = new RuleChainExportData();
    ruleChainExportData2.setMetaData(new RuleChainMetaData());

    // Act and Assert
    assertEquals(ruleChainExportData, ruleChainExportData2);
    int expectedHashCodeResult = ruleChainExportData.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainExportData2.hashCode());
  }

  /**
   * Test {@link RuleChainExportData#equals(Object)}, and {@link RuleChainExportData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainExportData#equals(Object)}
   *   <li>{@link RuleChainExportData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleChainExportData.equals(Object)",
    "int RuleChainExportData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChainExportData ruleChainExportData = new RuleChainExportData();

    // Act and Assert
    assertEquals(ruleChainExportData, ruleChainExportData);
    int expectedHashCodeResult = ruleChainExportData.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainExportData.hashCode());
  }

  /**
   * Test {@link RuleChainExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleChainExportData.equals(Object)",
    "int RuleChainExportData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleChainExportData(), 1);
  }

  /**
   * Test {@link RuleChainExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleChainExportData.equals(Object)",
    "int RuleChainExportData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleChainExportData ruleChainExportData = new RuleChainExportData();
    ruleChainExportData.setMetaData(new RuleChainMetaData());

    // Act and Assert
    assertNotEquals(ruleChainExportData, new RuleChainExportData());
  }

  /**
   * Test {@link RuleChainExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleChainExportData.equals(Object)",
    "int RuleChainExportData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleChainExportData ruleChainExportData = new RuleChainExportData();
    ruleChainExportData.setEntity(new RuleChain());

    // Act and Assert
    assertNotEquals(ruleChainExportData, new RuleChainExportData());
  }

  /**
   * Test {@link RuleChainExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleChainExportData.equals(Object)",
    "int RuleChainExportData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleChainExportData ruleChainExportData = new RuleChainExportData();

    RuleChainExportData ruleChainExportData2 = new RuleChainExportData();
    ruleChainExportData2.setMetaData(new RuleChainMetaData());

    // Act and Assert
    assertNotEquals(ruleChainExportData, ruleChainExportData2);
  }

  /**
   * Test {@link RuleChainExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleChainExportData.equals(Object)",
    "int RuleChainExportData.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleChainExportData(), null);
  }

  /**
   * Test {@link RuleChainExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleChainExportData.equals(Object)",
    "int RuleChainExportData.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleChainExportData(), "Different type to RuleChainExportData");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link RuleChainExportData}
   *   <li>{@link RuleChainExportData#setMetaData(RuleChainMetaData)}
   *   <li>{@link RuleChainExportData#toString()}
   *   <li>{@link RuleChainExportData#getMetaData()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void RuleChainExportData.<init>()",
    "RuleChainMetaData RuleChainExportData.getMetaData()",
    "void RuleChainExportData.setMetaData(RuleChainMetaData)",
    "String RuleChainExportData.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RuleChainExportData actualRuleChainExportData = new RuleChainExportData();
    RuleChainMetaData metaData = new RuleChainMetaData();
    actualRuleChainExportData.setMetaData(metaData);
    String actualToStringResult = actualRuleChainExportData.toString();
    RuleChainMetaData actualMetaData = actualRuleChainExportData.getMetaData();

    // Assert
    assertEquals(
        "RuleChainExportData(super=EntityExportData(entity=null, entityType=null, relations=null, attributes=null),"
            + " metaData=RuleChainMetaData(ruleChainId=null, version=null, firstNodeIndex=null, nodes=null,"
            + " connections=null, ruleChainConnections=null))",
        actualToStringResult);
    assertNull(actualRuleChainExportData.getRelations());
    assertNull(actualRuleChainExportData.getAttributes());
    assertNull(actualRuleChainExportData.getEntityType());
    assertNull(actualRuleChainExportData.getEntity());
    assertSame(metaData, actualMetaData);
  }
}
