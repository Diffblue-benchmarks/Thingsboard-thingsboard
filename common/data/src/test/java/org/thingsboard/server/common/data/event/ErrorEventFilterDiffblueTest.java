package org.thingsboard.server.common.data.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ErrorEventFilterDiffblueTest {
  /**
   * Test {@link ErrorEventFilter#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link ErrorEventFilter} (default constructor) ErrorStr is {@code foo}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given ErrorEventFilter (default constructor) ErrorStr is 'foo'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenErrorEventFilterErrorStrIsFoo_thenReturnTrue() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setServer("");
    errorEventFilter.setMethod("");
    errorEventFilter.setErrorStr("foo");

    // Act and Assert
    assertTrue(errorEventFilter.isNotEmpty());
  }

  /**
   * Test {@link ErrorEventFilter#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link ErrorEventFilter} (default constructor) Method is {@code foo}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given ErrorEventFilter (default constructor) Method is 'foo'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenErrorEventFilterMethodIsFoo_thenReturnTrue() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setServer("");
    errorEventFilter.setMethod("foo");
    errorEventFilter.setErrorStr("");

    // Act and Assert
    assertTrue(errorEventFilter.isNotEmpty());
  }

  /**
   * Test {@link ErrorEventFilter#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link ErrorEventFilter} (default constructor) Server is empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given ErrorEventFilter (default constructor) Server is empty string; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenErrorEventFilterServerIsEmptyString_thenReturnFalse() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setServer("");
    errorEventFilter.setMethod("");
    errorEventFilter.setErrorStr("");

    // Act and Assert
    assertFalse(errorEventFilter.isNotEmpty());
  }

  /**
   * Test {@link ErrorEventFilter#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link ErrorEventFilter} (default constructor) Server is {@code foo}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given ErrorEventFilter (default constructor) Server is 'foo'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenErrorEventFilterServerIsFoo_thenReturnTrue() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setServer("foo");
    errorEventFilter.setMethod("");
    errorEventFilter.setErrorStr("");

    // Act and Assert
    assertTrue(errorEventFilter.isNotEmpty());
  }

  /**
   * Test {@link ErrorEventFilter#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link ErrorEventFilter} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given ErrorEventFilter (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenErrorEventFilter_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ErrorEventFilter().isNotEmpty());
  }

  /**
   * Test {@link ErrorEventFilter#equals(Object)}, and {@link ErrorEventFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ErrorEventFilter#equals(Object)}
   *   <li>{@link ErrorEventFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEventFilter.equals(Object)", "int ErrorEventFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr("An error occurred");
    errorEventFilter.setMethod("Method");
    errorEventFilter.setServer("Server");

    ErrorEventFilter errorEventFilter2 = new ErrorEventFilter();
    errorEventFilter2.setErrorStr("An error occurred");
    errorEventFilter2.setMethod("Method");
    errorEventFilter2.setServer("Server");

    // Act and Assert
    assertEquals(errorEventFilter, errorEventFilter2);
    int expectedHashCodeResult = errorEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, errorEventFilter2.hashCode());
  }

  /**
   * Test {@link ErrorEventFilter#equals(Object)}, and {@link ErrorEventFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ErrorEventFilter#equals(Object)}
   *   <li>{@link ErrorEventFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEventFilter.equals(Object)", "int ErrorEventFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr(null);
    errorEventFilter.setMethod("Method");
    errorEventFilter.setServer("Server");

    ErrorEventFilter errorEventFilter2 = new ErrorEventFilter();
    errorEventFilter2.setErrorStr(null);
    errorEventFilter2.setMethod("Method");
    errorEventFilter2.setServer("Server");

    // Act and Assert
    assertEquals(errorEventFilter, errorEventFilter2);
    int expectedHashCodeResult = errorEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, errorEventFilter2.hashCode());
  }

  /**
   * Test {@link ErrorEventFilter#equals(Object)}, and {@link ErrorEventFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ErrorEventFilter#equals(Object)}
   *   <li>{@link ErrorEventFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEventFilter.equals(Object)", "int ErrorEventFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr("An error occurred");
    errorEventFilter.setMethod(null);
    errorEventFilter.setServer("Server");

    ErrorEventFilter errorEventFilter2 = new ErrorEventFilter();
    errorEventFilter2.setErrorStr("An error occurred");
    errorEventFilter2.setMethod(null);
    errorEventFilter2.setServer("Server");

    // Act and Assert
    assertEquals(errorEventFilter, errorEventFilter2);
    int expectedHashCodeResult = errorEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, errorEventFilter2.hashCode());
  }

  /**
   * Test {@link ErrorEventFilter#equals(Object)}, and {@link ErrorEventFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ErrorEventFilter#equals(Object)}
   *   <li>{@link ErrorEventFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEventFilter.equals(Object)", "int ErrorEventFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr("An error occurred");
    errorEventFilter.setMethod("Method");
    errorEventFilter.setServer(null);

    ErrorEventFilter errorEventFilter2 = new ErrorEventFilter();
    errorEventFilter2.setErrorStr("An error occurred");
    errorEventFilter2.setMethod("Method");
    errorEventFilter2.setServer(null);

    // Act and Assert
    assertEquals(errorEventFilter, errorEventFilter2);
    int expectedHashCodeResult = errorEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, errorEventFilter2.hashCode());
  }

  /**
   * Test {@link ErrorEventFilter#equals(Object)}, and {@link ErrorEventFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ErrorEventFilter#equals(Object)}
   *   <li>{@link ErrorEventFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEventFilter.equals(Object)", "int ErrorEventFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr("An error occurred");
    errorEventFilter.setMethod("Method");
    errorEventFilter.setServer("Server");

    // Act and Assert
    assertEquals(errorEventFilter, errorEventFilter);
    int expectedHashCodeResult = errorEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, errorEventFilter.hashCode());
  }

  /**
   * Test {@link ErrorEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEventFilter.equals(Object)", "int ErrorEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr("Server");
    errorEventFilter.setMethod("Method");
    errorEventFilter.setServer("Server");

    ErrorEventFilter errorEventFilter2 = new ErrorEventFilter();
    errorEventFilter2.setErrorStr("An error occurred");
    errorEventFilter2.setMethod("Method");
    errorEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(errorEventFilter, errorEventFilter2);
  }

  /**
   * Test {@link ErrorEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEventFilter.equals(Object)", "int ErrorEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr(null);
    errorEventFilter.setMethod("Method");
    errorEventFilter.setServer("Server");

    ErrorEventFilter errorEventFilter2 = new ErrorEventFilter();
    errorEventFilter2.setErrorStr("An error occurred");
    errorEventFilter2.setMethod("Method");
    errorEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(errorEventFilter, errorEventFilter2);
  }

  /**
   * Test {@link ErrorEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEventFilter.equals(Object)", "int ErrorEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr("An error occurred");
    errorEventFilter.setMethod("Server");
    errorEventFilter.setServer("Server");

    ErrorEventFilter errorEventFilter2 = new ErrorEventFilter();
    errorEventFilter2.setErrorStr("An error occurred");
    errorEventFilter2.setMethod("Method");
    errorEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(errorEventFilter, errorEventFilter2);
  }

  /**
   * Test {@link ErrorEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEventFilter.equals(Object)", "int ErrorEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr("An error occurred");
    errorEventFilter.setMethod(null);
    errorEventFilter.setServer("Server");

    ErrorEventFilter errorEventFilter2 = new ErrorEventFilter();
    errorEventFilter2.setErrorStr("An error occurred");
    errorEventFilter2.setMethod("Method");
    errorEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(errorEventFilter, errorEventFilter2);
  }

  /**
   * Test {@link ErrorEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEventFilter.equals(Object)", "int ErrorEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr("An error occurred");
    errorEventFilter.setMethod("Method");
    errorEventFilter.setServer("Method");

    ErrorEventFilter errorEventFilter2 = new ErrorEventFilter();
    errorEventFilter2.setErrorStr("An error occurred");
    errorEventFilter2.setMethod("Method");
    errorEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(errorEventFilter, errorEventFilter2);
  }

  /**
   * Test {@link ErrorEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEventFilter.equals(Object)", "int ErrorEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr("An error occurred");
    errorEventFilter.setMethod("Method");
    errorEventFilter.setServer(null);

    ErrorEventFilter errorEventFilter2 = new ErrorEventFilter();
    errorEventFilter2.setErrorStr("An error occurred");
    errorEventFilter2.setMethod("Method");
    errorEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(errorEventFilter, errorEventFilter2);
  }

  /**
   * Test {@link ErrorEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEventFilter.equals(Object)", "int ErrorEventFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr("An error occurred");
    errorEventFilter.setMethod("Method");
    errorEventFilter.setServer("Server");

    // Act and Assert
    assertNotEquals(errorEventFilter, null);
  }

  /**
   * Test {@link ErrorEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ErrorEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ErrorEventFilter.equals(Object)", "int ErrorEventFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr("An error occurred");
    errorEventFilter.setMethod("Method");
    errorEventFilter.setServer("Server");

    // Act and Assert
    assertNotEquals(errorEventFilter, "Different type to ErrorEventFilter");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ErrorEventFilter}
   *   <li>{@link ErrorEventFilter#setErrorStr(String)}
   *   <li>{@link ErrorEventFilter#setMethod(String)}
   *   <li>{@link ErrorEventFilter#setServer(String)}
   *   <li>{@link ErrorEventFilter#toString()}
   *   <li>{@link ErrorEventFilter#getErrorStr()}
   *   <li>{@link ErrorEventFilter#getEventType()}
   *   <li>{@link ErrorEventFilter#getMethod()}
   *   <li>{@link ErrorEventFilter#getServer()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void ErrorEventFilter.<init>()",
    "String ErrorEventFilter.getErrorStr()",
    "EventType ErrorEventFilter.getEventType()",
    "String ErrorEventFilter.getMethod()",
    "String ErrorEventFilter.getServer()",
    "void ErrorEventFilter.setErrorStr(String)",
    "void ErrorEventFilter.setMethod(String)",
    "void ErrorEventFilter.setServer(String)",
    "String ErrorEventFilter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ErrorEventFilter actualErrorEventFilter = new ErrorEventFilter();
    actualErrorEventFilter.setErrorStr("An error occurred");
    actualErrorEventFilter.setMethod("Method");
    actualErrorEventFilter.setServer("Server");
    String actualToStringResult = actualErrorEventFilter.toString();
    String actualErrorStr = actualErrorEventFilter.getErrorStr();
    EventType actualEventType = actualErrorEventFilter.getEventType();
    String actualMethod = actualErrorEventFilter.getMethod();

    // Assert
    assertEquals("An error occurred", actualErrorStr);
    assertEquals(
        "ErrorEventFilter(server=Server, method=Method, errorStr=An error occurred)",
        actualToStringResult);
    assertEquals("Method", actualMethod);
    assertEquals("Server", actualErrorEventFilter.getServer());
    assertEquals(EventType.ERROR, actualEventType);
  }
}
