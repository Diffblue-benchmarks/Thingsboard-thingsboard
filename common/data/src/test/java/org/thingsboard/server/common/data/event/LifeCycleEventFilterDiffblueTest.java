package org.thingsboard.server.common.data.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LifeCycleEventFilterDiffblueTest {
  /**
   * Test {@link LifeCycleEventFilter#isNotEmpty()}.
   * <ul>
   *   <li>Given {@link LifeCycleEventFilter} (default constructor) ErrorStr is {@code foo}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifeCycleEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given LifeCycleEventFilter (default constructor) ErrorStr is 'foo'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifeCycleEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenLifeCycleEventFilterErrorStrIsFoo_thenReturnTrue() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setServer("");
    lifeCycleEventFilter.setEvent("");
    lifeCycleEventFilter.setStatus("");
    lifeCycleEventFilter.setErrorStr("foo");

    // Act and Assert
    assertTrue(lifeCycleEventFilter.isNotEmpty());
  }

  /**
   * Test {@link LifeCycleEventFilter#isNotEmpty()}.
   * <ul>
   *   <li>Given {@link LifeCycleEventFilter} (default constructor) Event is empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifeCycleEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given LifeCycleEventFilter (default constructor) Event is empty string; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifeCycleEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenLifeCycleEventFilterEventIsEmptyString_thenReturnFalse() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setServer("");
    lifeCycleEventFilter.setEvent("");
    lifeCycleEventFilter.setStatus("");
    lifeCycleEventFilter.setErrorStr("");

    // Act and Assert
    assertFalse(lifeCycleEventFilter.isNotEmpty());
  }

  /**
   * Test {@link LifeCycleEventFilter#isNotEmpty()}.
   * <ul>
   *   <li>Given {@link LifeCycleEventFilter} (default constructor) Event is {@code foo}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifeCycleEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given LifeCycleEventFilter (default constructor) Event is 'foo'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifeCycleEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenLifeCycleEventFilterEventIsFoo_thenReturnTrue() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setServer("");
    lifeCycleEventFilter.setEvent("foo");
    lifeCycleEventFilter.setStatus("");
    lifeCycleEventFilter.setErrorStr("");

    // Act and Assert
    assertTrue(lifeCycleEventFilter.isNotEmpty());
  }

  /**
   * Test {@link LifeCycleEventFilter#isNotEmpty()}.
   * <ul>
   *   <li>Given {@link LifeCycleEventFilter} (default constructor) Server is {@code Server}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifeCycleEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given LifeCycleEventFilter (default constructor) Server is 'Server'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifeCycleEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenLifeCycleEventFilterServerIsServer_thenReturnTrue() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setServer("Server");

    // Act and Assert
    assertTrue(lifeCycleEventFilter.isNotEmpty());
  }

  /**
   * Test {@link LifeCycleEventFilter#isNotEmpty()}.
   * <ul>
   *   <li>Given {@link LifeCycleEventFilter} (default constructor) Status is {@code foo}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifeCycleEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given LifeCycleEventFilter (default constructor) Status is 'foo'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifeCycleEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenLifeCycleEventFilterStatusIsFoo_thenReturnTrue() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setServer("");
    lifeCycleEventFilter.setEvent("");
    lifeCycleEventFilter.setStatus("foo");
    lifeCycleEventFilter.setErrorStr("");

    // Act and Assert
    assertTrue(lifeCycleEventFilter.isNotEmpty());
  }

  /**
   * Test {@link LifeCycleEventFilter#isNotEmpty()}.
   * <ul>
   *   <li>Given {@link LifeCycleEventFilter} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifeCycleEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given LifeCycleEventFilter (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifeCycleEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenLifeCycleEventFilter_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new LifeCycleEventFilter()).isNotEmpty());
  }

  /**
   * Test {@link LifeCycleEventFilter#equals(Object)}, and {@link LifeCycleEventFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LifeCycleEventFilter#equals(Object)}
   *   <li>{@link LifeCycleEventFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifeCycleEventFilter.equals(Object)", "int LifeCycleEventFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus("Status");

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr("An error occurred");
    lifeCycleEventFilter2.setEvent("Event");
    lifeCycleEventFilter2.setServer("Server");
    lifeCycleEventFilter2.setStatus("Status");

    // Act and Assert
    assertEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
    int expectedHashCodeResult = lifeCycleEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, lifeCycleEventFilter2.hashCode());
  }

  /**
   * Test {@link LifeCycleEventFilter#equals(Object)}, and {@link LifeCycleEventFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LifeCycleEventFilter#equals(Object)}
   *   <li>{@link LifeCycleEventFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifeCycleEventFilter.equals(Object)", "int LifeCycleEventFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr(null);
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus("Status");

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr(null);
    lifeCycleEventFilter2.setEvent("Event");
    lifeCycleEventFilter2.setServer("Server");
    lifeCycleEventFilter2.setStatus("Status");

    // Act and Assert
    assertEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
    int expectedHashCodeResult = lifeCycleEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, lifeCycleEventFilter2.hashCode());
  }

  /**
   * Test {@link LifeCycleEventFilter#equals(Object)}, and {@link LifeCycleEventFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LifeCycleEventFilter#equals(Object)}
   *   <li>{@link LifeCycleEventFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifeCycleEventFilter.equals(Object)", "int LifeCycleEventFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent(null);
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus("Status");

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr("An error occurred");
    lifeCycleEventFilter2.setEvent(null);
    lifeCycleEventFilter2.setServer("Server");
    lifeCycleEventFilter2.setStatus("Status");

    // Act and Assert
    assertEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
    int expectedHashCodeResult = lifeCycleEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, lifeCycleEventFilter2.hashCode());
  }

  /**
   * Test {@link LifeCycleEventFilter#equals(Object)}, and {@link LifeCycleEventFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LifeCycleEventFilter#equals(Object)}
   *   <li>{@link LifeCycleEventFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifeCycleEventFilter.equals(Object)", "int LifeCycleEventFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer(null);
    lifeCycleEventFilter.setStatus("Status");

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr("An error occurred");
    lifeCycleEventFilter2.setEvent("Event");
    lifeCycleEventFilter2.setServer(null);
    lifeCycleEventFilter2.setStatus("Status");

    // Act and Assert
    assertEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
    int expectedHashCodeResult = lifeCycleEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, lifeCycleEventFilter2.hashCode());
  }

  /**
   * Test {@link LifeCycleEventFilter#equals(Object)}, and {@link LifeCycleEventFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LifeCycleEventFilter#equals(Object)}
   *   <li>{@link LifeCycleEventFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifeCycleEventFilter.equals(Object)", "int LifeCycleEventFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus(null);

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr("An error occurred");
    lifeCycleEventFilter2.setEvent("Event");
    lifeCycleEventFilter2.setServer("Server");
    lifeCycleEventFilter2.setStatus(null);

    // Act and Assert
    assertEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
    int expectedHashCodeResult = lifeCycleEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, lifeCycleEventFilter2.hashCode());
  }

  /**
   * Test {@link LifeCycleEventFilter#equals(Object)}, and {@link LifeCycleEventFilter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LifeCycleEventFilter#equals(Object)}
   *   <li>{@link LifeCycleEventFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifeCycleEventFilter.equals(Object)", "int LifeCycleEventFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus("Status");

    // Act and Assert
    assertEquals(lifeCycleEventFilter, lifeCycleEventFilter);
    int expectedHashCodeResult = lifeCycleEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, lifeCycleEventFilter.hashCode());
  }

  /**
   * Test {@link LifeCycleEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifeCycleEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifeCycleEventFilter.equals(Object)", "int LifeCycleEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("Server");
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus("Status");

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr("An error occurred");
    lifeCycleEventFilter2.setEvent("Event");
    lifeCycleEventFilter2.setServer("Server");
    lifeCycleEventFilter2.setStatus("Status");

    // Act and Assert
    assertNotEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
  }

  /**
   * Test {@link LifeCycleEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifeCycleEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifeCycleEventFilter.equals(Object)", "int LifeCycleEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr(null);
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus("Status");

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr("An error occurred");
    lifeCycleEventFilter2.setEvent("Event");
    lifeCycleEventFilter2.setServer("Server");
    lifeCycleEventFilter2.setStatus("Status");

    // Act and Assert
    assertNotEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
  }

  /**
   * Test {@link LifeCycleEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifeCycleEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifeCycleEventFilter.equals(Object)", "int LifeCycleEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent("Server");
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus("Status");

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr("An error occurred");
    lifeCycleEventFilter2.setEvent("Event");
    lifeCycleEventFilter2.setServer("Server");
    lifeCycleEventFilter2.setStatus("Status");

    // Act and Assert
    assertNotEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
  }

  /**
   * Test {@link LifeCycleEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifeCycleEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifeCycleEventFilter.equals(Object)", "int LifeCycleEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent(null);
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus("Status");

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr("An error occurred");
    lifeCycleEventFilter2.setEvent("Event");
    lifeCycleEventFilter2.setServer("Server");
    lifeCycleEventFilter2.setStatus("Status");

    // Act and Assert
    assertNotEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
  }

  /**
   * Test {@link LifeCycleEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifeCycleEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifeCycleEventFilter.equals(Object)", "int LifeCycleEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer("Event");
    lifeCycleEventFilter.setStatus("Status");

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr("An error occurred");
    lifeCycleEventFilter2.setEvent("Event");
    lifeCycleEventFilter2.setServer("Server");
    lifeCycleEventFilter2.setStatus("Status");

    // Act and Assert
    assertNotEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
  }

  /**
   * Test {@link LifeCycleEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifeCycleEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifeCycleEventFilter.equals(Object)", "int LifeCycleEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer(null);
    lifeCycleEventFilter.setStatus("Status");

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr("An error occurred");
    lifeCycleEventFilter2.setEvent("Event");
    lifeCycleEventFilter2.setServer("Server");
    lifeCycleEventFilter2.setStatus("Status");

    // Act and Assert
    assertNotEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
  }

  /**
   * Test {@link LifeCycleEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifeCycleEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifeCycleEventFilter.equals(Object)", "int LifeCycleEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus("Server");

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr("An error occurred");
    lifeCycleEventFilter2.setEvent("Event");
    lifeCycleEventFilter2.setServer("Server");
    lifeCycleEventFilter2.setStatus("Status");

    // Act and Assert
    assertNotEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
  }

  /**
   * Test {@link LifeCycleEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifeCycleEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifeCycleEventFilter.equals(Object)", "int LifeCycleEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus(null);

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr("An error occurred");
    lifeCycleEventFilter2.setEvent("Event");
    lifeCycleEventFilter2.setServer("Server");
    lifeCycleEventFilter2.setStatus("Status");

    // Act and Assert
    assertNotEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
  }

  /**
   * Test {@link LifeCycleEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifeCycleEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifeCycleEventFilter.equals(Object)", "int LifeCycleEventFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus("Status");

    // Act and Assert
    assertNotEquals(lifeCycleEventFilter, null);
  }

  /**
   * Test {@link LifeCycleEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifeCycleEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifeCycleEventFilter.equals(Object)", "int LifeCycleEventFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus("Status");

    // Act and Assert
    assertNotEquals(lifeCycleEventFilter, "Different type to LifeCycleEventFilter");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LifeCycleEventFilter}
   *   <li>{@link LifeCycleEventFilter#setErrorStr(String)}
   *   <li>{@link LifeCycleEventFilter#setEvent(String)}
   *   <li>{@link LifeCycleEventFilter#setServer(String)}
   *   <li>{@link LifeCycleEventFilter#setStatus(String)}
   *   <li>{@link LifeCycleEventFilter#toString()}
   *   <li>{@link LifeCycleEventFilter#getErrorStr()}
   *   <li>{@link LifeCycleEventFilter#getEvent()}
   *   <li>{@link LifeCycleEventFilter#getEventType()}
   *   <li>{@link LifeCycleEventFilter#getServer()}
   *   <li>{@link LifeCycleEventFilter#getStatus()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LifeCycleEventFilter.<init>()", "String LifeCycleEventFilter.getErrorStr()",
      "String LifeCycleEventFilter.getEvent()", "EventType LifeCycleEventFilter.getEventType()",
      "String LifeCycleEventFilter.getServer()", "String LifeCycleEventFilter.getStatus()",
      "void LifeCycleEventFilter.setErrorStr(String)", "void LifeCycleEventFilter.setEvent(String)",
      "void LifeCycleEventFilter.setServer(String)", "void LifeCycleEventFilter.setStatus(String)",
      "String LifeCycleEventFilter.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    LifeCycleEventFilter actualLifeCycleEventFilter = new LifeCycleEventFilter();
    actualLifeCycleEventFilter.setErrorStr("An error occurred");
    actualLifeCycleEventFilter.setEvent("Event");
    actualLifeCycleEventFilter.setServer("Server");
    actualLifeCycleEventFilter.setStatus("Status");
    String actualToStringResult = actualLifeCycleEventFilter.toString();
    String actualErrorStr = actualLifeCycleEventFilter.getErrorStr();
    String actualEvent = actualLifeCycleEventFilter.getEvent();
    EventType actualEventType = actualLifeCycleEventFilter.getEventType();
    String actualServer = actualLifeCycleEventFilter.getServer();

    // Assert
    assertEquals("An error occurred", actualErrorStr);
    assertEquals("Event", actualEvent);
    assertEquals("LifeCycleEventFilter(server=Server, event=Event, status=Status, errorStr=An error occurred)",
        actualToStringResult);
    assertEquals("Server", actualServer);
    assertEquals("Status", actualLifeCycleEventFilter.getStatus());
    assertEquals(EventType.LC_EVENT, actualEventType);
  }
}
