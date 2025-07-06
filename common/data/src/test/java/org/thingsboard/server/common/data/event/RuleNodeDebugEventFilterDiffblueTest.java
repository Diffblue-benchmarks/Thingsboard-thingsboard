package org.thingsboard.server.common.data.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RuleNodeDebugEventFilterDiffblueTest {
  /**
   * Test {@link RuleNodeDebugEventFilter#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeDebugEventFilter} (default constructor) DataSearch is {@code Data
   *       Search}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given RuleNodeDebugEventFilter (default constructor) DataSearch is 'Data Search'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeDebugEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenRuleNodeDebugEventFilterDataSearchIsDataSearch() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");

    // Act and Assert
    assertTrue(ruleNodeDebugEventFilter.isNotEmpty());
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeDebugEventFilter} (default constructor) EntityId is {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given RuleNodeDebugEventFilter (default constructor) EntityId is '42'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeDebugEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenRuleNodeDebugEventFilterEntityIdIs42_thenReturnTrue() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setEntityId("42");

    // Act and Assert
    assertTrue(ruleNodeDebugEventFilter.isNotEmpty());
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeDebugEventFilter} (default constructor) EntityType is {@code Entity
   *       Type}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given RuleNodeDebugEventFilter (default constructor) EntityType is 'Entity Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeDebugEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenRuleNodeDebugEventFilterEntityTypeIsEntityType() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setEntityType("Entity Type");

    // Act and Assert
    assertTrue(ruleNodeDebugEventFilter.isNotEmpty());
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeDebugEventFilter} (default constructor) ErrorStr is {@code foo}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given RuleNodeDebugEventFilter (default constructor) ErrorStr is 'foo'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeDebugEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenRuleNodeDebugEventFilterErrorStrIsFoo_thenReturnTrue() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("");
    ruleNodeDebugEventFilter.setIsError(false);
    ruleNodeDebugEventFilter.setErrorStr("foo");

    // Act and Assert
    assertTrue(ruleNodeDebugEventFilter.isNotEmpty());
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeDebugEventFilter} (default constructor) IsError is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given RuleNodeDebugEventFilter (default constructor) IsError is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeDebugEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenRuleNodeDebugEventFilterIsErrorIsTrue_thenReturnTrue() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setIsError(true);

    // Act and Assert
    assertTrue(ruleNodeDebugEventFilter.isNotEmpty());
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeDebugEventFilter} (default constructor) MetadataSearch is {@code
   *       Metadata Search}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given RuleNodeDebugEventFilter (default constructor) MetadataSearch is 'Metadata Search'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeDebugEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenRuleNodeDebugEventFilterMetadataSearchIsMetadataSearch() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");

    // Act and Assert
    assertTrue(ruleNodeDebugEventFilter.isNotEmpty());
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeDebugEventFilter} (default constructor) MsgId is {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given RuleNodeDebugEventFilter (default constructor) MsgId is '42'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeDebugEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenRuleNodeDebugEventFilterMsgIdIs42_thenReturnTrue() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setMsgId("42");

    // Act and Assert
    assertTrue(ruleNodeDebugEventFilter.isNotEmpty());
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeDebugEventFilter} (default constructor) MsgType is {@code Msg Type}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given RuleNodeDebugEventFilter (default constructor) MsgType is 'Msg Type'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeDebugEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenRuleNodeDebugEventFilterMsgTypeIsMsgType_thenReturnTrue() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setMsgType("Msg Type");

    // Act and Assert
    assertTrue(ruleNodeDebugEventFilter.isNotEmpty());
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeDebugEventFilter} (default constructor) RelationType is {@code
   *       Relation Type}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given RuleNodeDebugEventFilter (default constructor) RelationType is 'Relation Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeDebugEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenRuleNodeDebugEventFilterRelationTypeIsRelationType() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setRelationType("Relation Type");

    // Act and Assert
    assertTrue(ruleNodeDebugEventFilter.isNotEmpty());
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeDebugEventFilter} (default constructor) Server is empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given RuleNodeDebugEventFilter (default constructor) Server is empty string; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeDebugEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenRuleNodeDebugEventFilterServerIsEmptyString_thenReturnTrue() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("");
    ruleNodeDebugEventFilter.setIsError(false);
    ruleNodeDebugEventFilter.setErrorStr("");

    // Act and Assert
    assertTrue(ruleNodeDebugEventFilter.isNotEmpty());
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeDebugEventFilter} (default constructor) Server is {@code foo}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given RuleNodeDebugEventFilter (default constructor) Server is 'foo'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeDebugEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenRuleNodeDebugEventFilterServerIsFoo_thenReturnTrue() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("foo");
    ruleNodeDebugEventFilter.setIsError(false);
    ruleNodeDebugEventFilter.setErrorStr("");

    // Act and Assert
    assertTrue(ruleNodeDebugEventFilter.isNotEmpty());
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeDebugEventFilter} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given RuleNodeDebugEventFilter (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeDebugEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenRuleNodeDebugEventFilter_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new RuleNodeDebugEventFilter().isNotEmpty());
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#equals(Object)}, and {@link
   * RuleNodeDebugEventFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeDebugEventFilter#equals(Object)}
   *   <li>{@link RuleNodeDebugEventFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventFilter.equals(Object)",
    "int RuleNodeDebugEventFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
    int expectedHashCodeResult = ruleNodeDebugEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeDebugEventFilter2.hashCode());
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#equals(Object)}, and {@link
   * RuleNodeDebugEventFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeDebugEventFilter#equals(Object)}
   *   <li>{@link RuleNodeDebugEventFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventFilter.equals(Object)",
    "int RuleNodeDebugEventFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    // Act and Assert
    assertEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter);
    int expectedHashCodeResult = ruleNodeDebugEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeDebugEventFilter.hashCode());
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventFilter.equals(Object)",
    "int RuleNodeDebugEventFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Server");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventFilter.equals(Object)",
    "int RuleNodeDebugEventFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch(null);
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventFilter.equals(Object)",
    "int RuleNodeDebugEventFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("Server");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventFilter.equals(Object)",
    "int RuleNodeDebugEventFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId(null);
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventFilter.equals(Object)",
    "int RuleNodeDebugEventFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Server");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventFilter.equals(Object)",
    "int RuleNodeDebugEventFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType(null);
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventFilter.equals(Object)",
    "int RuleNodeDebugEventFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("Server");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventFilter.equals(Object)",
    "int RuleNodeDebugEventFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Server");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventFilter.equals(Object)",
    "int RuleNodeDebugEventFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch(null);
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventFilter.equals(Object)",
    "int RuleNodeDebugEventFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Server");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventFilter.equals(Object)",
    "int RuleNodeDebugEventFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType(null);
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventFilter.equals(Object)",
    "int RuleNodeDebugEventFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("Server");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventFilter.equals(Object)",
    "int RuleNodeDebugEventFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId(null);
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventFilter.equals(Object)",
    "int RuleNodeDebugEventFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Server");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventFilter.equals(Object)",
    "int RuleNodeDebugEventFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType(null);
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventFilter.equals(Object)",
    "int RuleNodeDebugEventFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Server");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventFilter.equals(Object)",
    "int RuleNodeDebugEventFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType(null);
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventFilter.equals(Object)",
    "int RuleNodeDebugEventFilter.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, null);
  }

  /**
   * Test {@link RuleNodeDebugEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventFilter.equals(Object)",
    "int RuleNodeDebugEventFilter.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, "Different type to RuleNodeDebugEventFilter");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link RuleNodeDebugEventFilter}
   *   <li>{@link RuleNodeDebugEventFilter#setDataSearch(String)}
   *   <li>{@link RuleNodeDebugEventFilter#setEntityId(String)}
   *   <li>{@link RuleNodeDebugEventFilter#setEntityType(String)}
   *   <li>{@link RuleNodeDebugEventFilter#setMetadataSearch(String)}
   *   <li>{@link RuleNodeDebugEventFilter#setMsgDirectionType(String)}
   *   <li>{@link RuleNodeDebugEventFilter#setMsgId(String)}
   *   <li>{@link RuleNodeDebugEventFilter#setMsgType(String)}
   *   <li>{@link RuleNodeDebugEventFilter#setRelationType(String)}
   *   <li>{@link RuleNodeDebugEventFilter#toString()}
   *   <li>{@link RuleNodeDebugEventFilter#getDataSearch()}
   *   <li>{@link RuleNodeDebugEventFilter#getEntityId()}
   *   <li>{@link RuleNodeDebugEventFilter#getEntityType()}
   *   <li>{@link RuleNodeDebugEventFilter#getEventType()}
   *   <li>{@link RuleNodeDebugEventFilter#getMetadataSearch()}
   *   <li>{@link RuleNodeDebugEventFilter#getMsgDirectionType()}
   *   <li>{@link RuleNodeDebugEventFilter#getMsgId()}
   *   <li>{@link RuleNodeDebugEventFilter#getMsgType()}
   *   <li>{@link RuleNodeDebugEventFilter#getRelationType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void RuleNodeDebugEventFilter.<init>()",
    "String RuleNodeDebugEventFilter.getDataSearch()",
    "String RuleNodeDebugEventFilter.getEntityId()",
    "String RuleNodeDebugEventFilter.getEntityType()",
    "EventType RuleNodeDebugEventFilter.getEventType()",
    "String RuleNodeDebugEventFilter.getMetadataSearch()",
    "String RuleNodeDebugEventFilter.getMsgDirectionType()",
    "String RuleNodeDebugEventFilter.getMsgId()",
    "String RuleNodeDebugEventFilter.getMsgType()",
    "String RuleNodeDebugEventFilter.getRelationType()",
    "void RuleNodeDebugEventFilter.setDataSearch(String)",
    "void RuleNodeDebugEventFilter.setEntityId(String)",
    "void RuleNodeDebugEventFilter.setEntityType(String)",
    "void RuleNodeDebugEventFilter.setMetadataSearch(String)",
    "void RuleNodeDebugEventFilter.setMsgDirectionType(String)",
    "void RuleNodeDebugEventFilter.setMsgId(String)",
    "void RuleNodeDebugEventFilter.setMsgType(String)",
    "void RuleNodeDebugEventFilter.setRelationType(String)",
    "String RuleNodeDebugEventFilter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RuleNodeDebugEventFilter actualRuleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    actualRuleNodeDebugEventFilter.setDataSearch("Data Search");
    actualRuleNodeDebugEventFilter.setEntityId("42");
    actualRuleNodeDebugEventFilter.setEntityType("Entity Type");
    actualRuleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    actualRuleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    actualRuleNodeDebugEventFilter.setMsgId("42");
    actualRuleNodeDebugEventFilter.setMsgType("Msg Type");
    actualRuleNodeDebugEventFilter.setRelationType("Relation Type");
    String actualToStringResult = actualRuleNodeDebugEventFilter.toString();
    String actualDataSearch = actualRuleNodeDebugEventFilter.getDataSearch();
    String actualEntityId = actualRuleNodeDebugEventFilter.getEntityId();
    String actualEntityType = actualRuleNodeDebugEventFilter.getEntityType();
    EventType actualEventType = actualRuleNodeDebugEventFilter.getEventType();
    String actualMetadataSearch = actualRuleNodeDebugEventFilter.getMetadataSearch();
    String actualMsgDirectionType = actualRuleNodeDebugEventFilter.getMsgDirectionType();
    String actualMsgId = actualRuleNodeDebugEventFilter.getMsgId();
    String actualMsgType = actualRuleNodeDebugEventFilter.getMsgType();

    // Assert
    assertEquals("42", actualEntityId);
    assertEquals("42", actualMsgId);
    assertEquals("Data Search", actualDataSearch);
    assertEquals("Entity Type", actualEntityType);
    assertEquals("Metadata Search", actualMetadataSearch);
    assertEquals("Msg Direction Type", actualMsgDirectionType);
    assertEquals("Msg Type", actualMsgType);
    assertEquals("Relation Type", actualRuleNodeDebugEventFilter.getRelationType());
    assertEquals(
        "RuleNodeDebugEventFilter(msgDirectionType=Msg Direction Type, entityId=42, entityType=Entity Type,"
            + " msgId=42, msgType=Msg Type, relationType=Relation Type, dataSearch=Data Search, metadataSearch=Metadata"
            + " Search)",
        actualToStringResult);
    assertNull(actualRuleNodeDebugEventFilter.getErrorStr());
    assertNull(actualRuleNodeDebugEventFilter.getServer());
    assertEquals(EventType.DEBUG_RULE_NODE, actualEventType);
    assertFalse(actualRuleNodeDebugEventFilter.isError());
  }
}
