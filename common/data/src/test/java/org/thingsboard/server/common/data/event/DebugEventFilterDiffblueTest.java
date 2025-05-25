package org.thingsboard.server.common.data.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DebugEventFilterDiffblueTest {
  /**
   * Test {@link DebugEventFilter#setIsError(boolean)}.
   * <p>
   * Method under test: {@link DebugEventFilter#setIsError(boolean)}
   */
  @Test
  @DisplayName("Test setIsError(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DebugEventFilter.setIsError(boolean)"})
  void testSetIsError() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();

    // Act
    ruleChainDebugEventFilter.setIsError(true);

    // Assert
    assertTrue(ruleChainDebugEventFilter.isError());
    assertTrue(ruleChainDebugEventFilter.isNotEmpty());
  }

  /**
   * Test {@link DebugEventFilter#getErrorStr()}.
   * <p>
   * Method under test: {@link DebugEventFilter#getErrorStr()}
   */
  @Test
  @DisplayName("Test getErrorStr()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DebugEventFilter.getErrorStr()"})
  void testGetErrorStr() {
    // Arrange, Act and Assert
    assertNull((new RuleChainDebugEventFilter()).getErrorStr());
  }

  /**
   * Test {@link DebugEventFilter#getServer()}.
   * <p>
   * Method under test: {@link DebugEventFilter#getServer()}
   */
  @Test
  @DisplayName("Test getServer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DebugEventFilter.getServer()"})
  void testGetServer() {
    // Arrange, Act and Assert
    assertNull((new RuleChainDebugEventFilter()).getServer());
  }

  /**
   * Test {@link DebugEventFilter#isError()}.
   * <ul>
   *   <li>Given {@link RuleChainDebugEventFilter} (default constructor) IsError is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DebugEventFilter#isError()}
   */
  @Test
  @DisplayName("Test isError(); given RuleChainDebugEventFilter (default constructor) IsError is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DebugEventFilter.isError()"})
  void testIsError_givenRuleChainDebugEventFilterIsErrorIsTrue_thenReturnTrue() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setIsError(true);

    // Act and Assert
    assertTrue(ruleChainDebugEventFilter.isError());
  }

  /**
   * Test {@link DebugEventFilter#isError()}.
   * <ul>
   *   <li>Given {@link RuleChainDebugEventFilter} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DebugEventFilter#isError()}
   */
  @Test
  @DisplayName("Test isError(); given RuleChainDebugEventFilter (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DebugEventFilter.isError()"})
  void testIsError_givenRuleChainDebugEventFilter_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new RuleChainDebugEventFilter()).isError());
  }

  /**
   * Test {@link DebugEventFilter#isNotEmpty()}.
   * <ul>
   *   <li>Given {@link RuleChainDebugEventFilter} (default constructor) ErrorStr is {@code foo}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DebugEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given RuleChainDebugEventFilter (default constructor) ErrorStr is 'foo'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DebugEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenRuleChainDebugEventFilterErrorStrIsFoo_thenReturnTrue() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setServer("");
    ruleChainDebugEventFilter.setIsError(false);
    ruleChainDebugEventFilter.setErrorStr("foo");

    // Act and Assert
    assertTrue(ruleChainDebugEventFilter.isNotEmpty());
  }

  /**
   * Test {@link DebugEventFilter#isNotEmpty()}.
   * <ul>
   *   <li>Given {@link RuleChainDebugEventFilter} (default constructor) IsError is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DebugEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given RuleChainDebugEventFilter (default constructor) IsError is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DebugEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenRuleChainDebugEventFilterIsErrorIsTrue_thenReturnTrue() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setIsError(true);

    // Act and Assert
    assertTrue(ruleChainDebugEventFilter.isNotEmpty());
  }

  /**
   * Test {@link DebugEventFilter#isNotEmpty()}.
   * <ul>
   *   <li>Given {@link RuleChainDebugEventFilter} (default constructor) Server is empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DebugEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given RuleChainDebugEventFilter (default constructor) Server is empty string; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DebugEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenRuleChainDebugEventFilterServerIsEmptyString_thenReturnFalse() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setServer("");
    ruleChainDebugEventFilter.setIsError(false);
    ruleChainDebugEventFilter.setErrorStr("");

    // Act and Assert
    assertFalse(ruleChainDebugEventFilter.isNotEmpty());
  }

  /**
   * Test {@link DebugEventFilter#isNotEmpty()}.
   * <ul>
   *   <li>Given {@link RuleChainDebugEventFilter} (default constructor) Server is {@code foo}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DebugEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given RuleChainDebugEventFilter (default constructor) Server is 'foo'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DebugEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenRuleChainDebugEventFilterServerIsFoo_thenReturnTrue() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setServer("foo");
    ruleChainDebugEventFilter.setIsError(false);
    ruleChainDebugEventFilter.setErrorStr("");

    // Act and Assert
    assertTrue(ruleChainDebugEventFilter.isNotEmpty());
  }

  /**
   * Test {@link DebugEventFilter#isNotEmpty()}.
   * <ul>
   *   <li>Given {@link RuleChainDebugEventFilter} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DebugEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given RuleChainDebugEventFilter (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DebugEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenRuleChainDebugEventFilter_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new RuleChainDebugEventFilter()).isNotEmpty());
  }

  /**
   * Test {@link DebugEventFilter#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DebugEventFilter#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DebugEventFilter.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new RuleChainDebugEventFilter()).canEqual("Other"));
  }

  /**
   * Test {@link DebugEventFilter#canEqual(Object)}.
   * <ul>
   *   <li>When {@link RuleChainDebugEventFilter} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DebugEventFilter#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when RuleChainDebugEventFilter (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DebugEventFilter.canEqual(Object)"})
  void testCanEqual_whenRuleChainDebugEventFilter_thenReturnTrue() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();

    // Act and Assert
    assertTrue(ruleChainDebugEventFilter.canEqual(new RuleChainDebugEventFilter()));
  }

  /**
   * Test {@link DebugEventFilter#equals(Object)}, and {@link DebugEventFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DebugEventFilter.equals(Object)", "int DebugEventFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    RuleChainDebugEventFilter ruleChainDebugEventFilter2 = new RuleChainDebugEventFilter();

    // Act and Assert
    assertEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter2);
    int expectedHashCodeResult = ruleChainDebugEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainDebugEventFilter2.hashCode());
  }

  /**
   * Test {@link DebugEventFilter#equals(Object)}, and {@link DebugEventFilter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DebugEventFilter.equals(Object)", "int DebugEventFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();

    // Act and Assert
    assertEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter);
    int expectedHashCodeResult = ruleChainDebugEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainDebugEventFilter.hashCode());
  }

  /**
   * Test {@link DebugEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DebugEventFilter.equals(Object)", "int DebugEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();

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
    assertNotEquals(ruleChainDebugEventFilter, ruleNodeDebugEventFilter);
  }

  /**
   * Test {@link DebugEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DebugEventFilter.equals(Object)", "int DebugEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    RuleChainDebugEventFilter ruleChainDebugEventFilter2 = mock(RuleChainDebugEventFilter.class);
    when(ruleChainDebugEventFilter2.isError()).thenReturn(true);
    when(ruleChainDebugEventFilter2.getErrorStr()).thenReturn("An error occurred");
    when(ruleChainDebugEventFilter2.getServer()).thenReturn("Server");
    when(ruleChainDebugEventFilter2.getMessage()).thenReturn("Not all who wander are lost");
    when(ruleChainDebugEventFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter2);
  }

  /**
   * Test {@link DebugEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DebugEventFilter.equals(Object)", "int DebugEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    RuleChainDebugEventFilter ruleChainDebugEventFilter2 = mock(RuleChainDebugEventFilter.class);
    when(ruleChainDebugEventFilter2.isError()).thenReturn(false);
    when(ruleChainDebugEventFilter2.getErrorStr()).thenReturn("An error occurred");
    when(ruleChainDebugEventFilter2.getServer()).thenReturn("Server");
    when(ruleChainDebugEventFilter2.getMessage()).thenReturn("Not all who wander are lost");
    when(ruleChainDebugEventFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter2);
  }

  /**
   * Test {@link DebugEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DebugEventFilter.equals(Object)", "int DebugEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setIsError(true);
    RuleChainDebugEventFilter ruleChainDebugEventFilter2 = mock(RuleChainDebugEventFilter.class);
    when(ruleChainDebugEventFilter2.isError()).thenReturn(true);
    when(ruleChainDebugEventFilter2.getErrorStr()).thenReturn("An error occurred");
    when(ruleChainDebugEventFilter2.getServer()).thenReturn("Server");
    when(ruleChainDebugEventFilter2.getMessage()).thenReturn("Not all who wander are lost");
    when(ruleChainDebugEventFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter2);
  }

  /**
   * Test {@link DebugEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DebugEventFilter.equals(Object)", "int DebugEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    RuleChainDebugEventFilter ruleChainDebugEventFilter2 = mock(RuleChainDebugEventFilter.class);
    when(ruleChainDebugEventFilter2.isError()).thenReturn(false);
    when(ruleChainDebugEventFilter2.getErrorStr()).thenReturn("An error occurred");
    when(ruleChainDebugEventFilter2.getServer()).thenReturn(null);
    when(ruleChainDebugEventFilter2.getMessage()).thenReturn("Not all who wander are lost");
    when(ruleChainDebugEventFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter2);
  }

  /**
   * Test {@link DebugEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DebugEventFilter.equals(Object)", "int DebugEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setServer("Server");
    RuleChainDebugEventFilter ruleChainDebugEventFilter2 = mock(RuleChainDebugEventFilter.class);
    when(ruleChainDebugEventFilter2.isError()).thenReturn(false);
    when(ruleChainDebugEventFilter2.getErrorStr()).thenReturn("An error occurred");
    when(ruleChainDebugEventFilter2.getServer()).thenReturn("Server");
    when(ruleChainDebugEventFilter2.getMessage()).thenReturn("Not all who wander are lost");
    when(ruleChainDebugEventFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter2);
  }

  /**
   * Test {@link DebugEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DebugEventFilter.equals(Object)", "int DebugEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setServer("org.thingsboard.server.common.data.event.DebugEventFilter");
    RuleChainDebugEventFilter ruleChainDebugEventFilter2 = mock(RuleChainDebugEventFilter.class);
    when(ruleChainDebugEventFilter2.isError()).thenReturn(false);
    when(ruleChainDebugEventFilter2.getErrorStr()).thenReturn("An error occurred");
    when(ruleChainDebugEventFilter2.getServer()).thenReturn("Server");
    when(ruleChainDebugEventFilter2.getMessage()).thenReturn("Not all who wander are lost");
    when(ruleChainDebugEventFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter2);
  }

  /**
   * Test {@link DebugEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DebugEventFilter.equals(Object)", "int DebugEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setErrorStr("An error occurred");
    RuleChainDebugEventFilter ruleChainDebugEventFilter2 = mock(RuleChainDebugEventFilter.class);
    when(ruleChainDebugEventFilter2.isError()).thenReturn(false);
    when(ruleChainDebugEventFilter2.getErrorStr()).thenReturn("An error occurred");
    when(ruleChainDebugEventFilter2.getServer()).thenReturn(null);
    when(ruleChainDebugEventFilter2.getMessage()).thenReturn("Not all who wander are lost");
    when(ruleChainDebugEventFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter2);
  }

  /**
   * Test {@link DebugEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DebugEventFilter.equals(Object)", "int DebugEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setErrorStr("Error Str");
    RuleChainDebugEventFilter ruleChainDebugEventFilter2 = mock(RuleChainDebugEventFilter.class);
    when(ruleChainDebugEventFilter2.isError()).thenReturn(false);
    when(ruleChainDebugEventFilter2.getErrorStr()).thenReturn("An error occurred");
    when(ruleChainDebugEventFilter2.getServer()).thenReturn(null);
    when(ruleChainDebugEventFilter2.getMessage()).thenReturn("Not all who wander are lost");
    when(ruleChainDebugEventFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter2);
  }

  /**
   * Test {@link DebugEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DebugEventFilter.equals(Object)", "int DebugEventFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleChainDebugEventFilter(), null);
  }

  /**
   * Test {@link DebugEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DebugEventFilter.equals(Object)", "int DebugEventFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleChainDebugEventFilter(), "Different type to DebugEventFilter");
  }

  /**
   * Test {@link DebugEventFilter#setErrorStr(String)}.
   * <p>
   * Method under test: {@link DebugEventFilter#setErrorStr(String)}
   */
  @Test
  @DisplayName("Test setErrorStr(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DebugEventFilter.setErrorStr(String)"})
  void testSetErrorStr() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();

    // Act
    ruleChainDebugEventFilter.setErrorStr("An error occurred");

    // Assert
    assertEquals("An error occurred", ruleChainDebugEventFilter.getErrorStr());
    assertTrue(ruleChainDebugEventFilter.isNotEmpty());
  }

  /**
   * Test {@link DebugEventFilter#setServer(String)}.
   * <p>
   * Method under test: {@link DebugEventFilter#setServer(String)}
   */
  @Test
  @DisplayName("Test setServer(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DebugEventFilter.setServer(String)"})
  void testSetServer() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();

    // Act
    ruleChainDebugEventFilter.setServer("Server");

    // Assert
    assertEquals("Server", ruleChainDebugEventFilter.getServer());
    assertTrue(ruleChainDebugEventFilter.isNotEmpty());
  }

  /**
   * Test {@link DebugEventFilter#toString()}.
   * <p>
   * Method under test: {@link DebugEventFilter#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DebugEventFilter.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("RuleChainDebugEventFilter(message=null)", (new RuleChainDebugEventFilter()).toString());
  }
}
