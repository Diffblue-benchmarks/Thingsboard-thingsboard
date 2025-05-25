package org.thingsboard.server.common.data.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StatisticsEventFilterDiffblueTest {
  /**
   * Test {@link StatisticsEventFilter#isNotEmpty()}.
   * <ul>
   *   <li>Given {@link StatisticsEventFilter} (default constructor) MaxErrorsOccurred is one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given StatisticsEventFilter (default constructor) MaxErrorsOccurred is one; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenStatisticsEventFilterMaxErrorsOccurredIsOne_thenReturnTrue() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setServer("");
    statisticsEventFilter.setMinMessagesProcessed(null);
    statisticsEventFilter.setMinErrorsOccurred(null);
    statisticsEventFilter.setMaxMessagesProcessed(null);
    statisticsEventFilter.setMaxErrorsOccurred(1);

    // Act and Assert
    assertTrue(statisticsEventFilter.isNotEmpty());
  }

  /**
   * Test {@link StatisticsEventFilter#isNotEmpty()}.
   * <ul>
   *   <li>Given {@link StatisticsEventFilter} (default constructor) MaxErrorsOccurred is zero.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given StatisticsEventFilter (default constructor) MaxErrorsOccurred is zero; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenStatisticsEventFilterMaxErrorsOccurredIsZero_thenReturnFalse() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setServer("");
    statisticsEventFilter.setMinMessagesProcessed(null);
    statisticsEventFilter.setMinErrorsOccurred(null);
    statisticsEventFilter.setMaxMessagesProcessed(null);
    statisticsEventFilter.setMaxErrorsOccurred(0);

    // Act and Assert
    assertFalse(statisticsEventFilter.isNotEmpty());
  }

  /**
   * Test {@link StatisticsEventFilter#isNotEmpty()}.
   * <ul>
   *   <li>Given {@link StatisticsEventFilter} (default constructor) MaxMessagesProcessed is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given StatisticsEventFilter (default constructor) MaxMessagesProcessed is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenStatisticsEventFilterMaxMessagesProcessedIsOne() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setServer("");
    statisticsEventFilter.setMinMessagesProcessed(null);
    statisticsEventFilter.setMinErrorsOccurred(null);
    statisticsEventFilter.setMaxMessagesProcessed(1);
    statisticsEventFilter.setMaxErrorsOccurred(null);

    // Act and Assert
    assertTrue(statisticsEventFilter.isNotEmpty());
  }

  /**
   * Test {@link StatisticsEventFilter#isNotEmpty()}.
   * <ul>
   *   <li>Given {@link StatisticsEventFilter} (default constructor) MaxMessagesProcessed is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given StatisticsEventFilter (default constructor) MaxMessagesProcessed is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenStatisticsEventFilterMaxMessagesProcessedIsZero() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setServer("");
    statisticsEventFilter.setMinMessagesProcessed(null);
    statisticsEventFilter.setMinErrorsOccurred(null);
    statisticsEventFilter.setMaxMessagesProcessed(0);
    statisticsEventFilter.setMaxErrorsOccurred(null);

    // Act and Assert
    assertFalse(statisticsEventFilter.isNotEmpty());
  }

  /**
   * Test {@link StatisticsEventFilter#isNotEmpty()}.
   * <ul>
   *   <li>Given {@link StatisticsEventFilter} (default constructor) MinErrorsOccurred is {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given StatisticsEventFilter (default constructor) MinErrorsOccurred is 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenStatisticsEventFilterMinErrorsOccurredIsNull_thenReturnFalse() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setServer("");
    statisticsEventFilter.setMinMessagesProcessed(null);
    statisticsEventFilter.setMinErrorsOccurred(null);
    statisticsEventFilter.setMaxMessagesProcessed(null);
    statisticsEventFilter.setMaxErrorsOccurred(null);

    // Act and Assert
    assertFalse(statisticsEventFilter.isNotEmpty());
  }

  /**
   * Test {@link StatisticsEventFilter#isNotEmpty()}.
   * <ul>
   *   <li>Given {@link StatisticsEventFilter} (default constructor) MinErrorsOccurred is one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given StatisticsEventFilter (default constructor) MinErrorsOccurred is one; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenStatisticsEventFilterMinErrorsOccurredIsOne_thenReturnTrue() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setServer("");
    statisticsEventFilter.setMinMessagesProcessed(null);
    statisticsEventFilter.setMinErrorsOccurred(1);
    statisticsEventFilter.setMaxMessagesProcessed(null);
    statisticsEventFilter.setMaxErrorsOccurred(null);

    // Act and Assert
    assertTrue(statisticsEventFilter.isNotEmpty());
  }

  /**
   * Test {@link StatisticsEventFilter#isNotEmpty()}.
   * <ul>
   *   <li>Given {@link StatisticsEventFilter} (default constructor) MinErrorsOccurred is zero.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given StatisticsEventFilter (default constructor) MinErrorsOccurred is zero; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenStatisticsEventFilterMinErrorsOccurredIsZero_thenReturnFalse() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setServer("");
    statisticsEventFilter.setMinMessagesProcessed(null);
    statisticsEventFilter.setMinErrorsOccurred(0);
    statisticsEventFilter.setMaxMessagesProcessed(null);
    statisticsEventFilter.setMaxErrorsOccurred(null);

    // Act and Assert
    assertFalse(statisticsEventFilter.isNotEmpty());
  }

  /**
   * Test {@link StatisticsEventFilter#isNotEmpty()}.
   * <ul>
   *   <li>Given {@link StatisticsEventFilter} (default constructor) MinMessagesProcessed is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given StatisticsEventFilter (default constructor) MinMessagesProcessed is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenStatisticsEventFilterMinMessagesProcessedIsOne() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMinMessagesProcessed(1);

    // Act and Assert
    assertTrue(statisticsEventFilter.isNotEmpty());
  }

  /**
   * Test {@link StatisticsEventFilter#isNotEmpty()}.
   * <ul>
   *   <li>Given {@link StatisticsEventFilter} (default constructor) MinMessagesProcessed is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given StatisticsEventFilter (default constructor) MinMessagesProcessed is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenStatisticsEventFilterMinMessagesProcessedIsZero() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMinMessagesProcessed(0);

    // Act and Assert
    assertFalse(statisticsEventFilter.isNotEmpty());
  }

  /**
   * Test {@link StatisticsEventFilter#isNotEmpty()}.
   * <ul>
   *   <li>Given {@link StatisticsEventFilter} (default constructor) Server is {@code Server}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given StatisticsEventFilter (default constructor) Server is 'Server'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenStatisticsEventFilterServerIsServer_thenReturnTrue() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setServer("Server");

    // Act and Assert
    assertTrue(statisticsEventFilter.isNotEmpty());
  }

  /**
   * Test {@link StatisticsEventFilter#isNotEmpty()}.
   * <ul>
   *   <li>Given {@link StatisticsEventFilter} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given StatisticsEventFilter (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenStatisticsEventFilter_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new StatisticsEventFilter()).isNotEmpty());
  }

  /**
   * Test {@link StatisticsEventFilter#equals(Object)}, and {@link StatisticsEventFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEventFilter#equals(Object)}
   *   <li>{@link StatisticsEventFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.equals(Object)", "int StatisticsEventFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertEquals(statisticsEventFilter, statisticsEventFilter2);
    int expectedHashCodeResult = statisticsEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, statisticsEventFilter2.hashCode());
  }

  /**
   * Test {@link StatisticsEventFilter#equals(Object)}, and {@link StatisticsEventFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEventFilter#equals(Object)}
   *   <li>{@link StatisticsEventFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.equals(Object)", "int StatisticsEventFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(null);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(null);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertEquals(statisticsEventFilter, statisticsEventFilter2);
    int expectedHashCodeResult = statisticsEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, statisticsEventFilter2.hashCode());
  }

  /**
   * Test {@link StatisticsEventFilter#equals(Object)}, and {@link StatisticsEventFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEventFilter#equals(Object)}
   *   <li>{@link StatisticsEventFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.equals(Object)", "int StatisticsEventFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(null);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(null);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertEquals(statisticsEventFilter, statisticsEventFilter2);
    int expectedHashCodeResult = statisticsEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, statisticsEventFilter2.hashCode());
  }

  /**
   * Test {@link StatisticsEventFilter#equals(Object)}, and {@link StatisticsEventFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEventFilter#equals(Object)}
   *   <li>{@link StatisticsEventFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.equals(Object)", "int StatisticsEventFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(null);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(null);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertEquals(statisticsEventFilter, statisticsEventFilter2);
    int expectedHashCodeResult = statisticsEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, statisticsEventFilter2.hashCode());
  }

  /**
   * Test {@link StatisticsEventFilter#equals(Object)}, and {@link StatisticsEventFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEventFilter#equals(Object)}
   *   <li>{@link StatisticsEventFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.equals(Object)", "int StatisticsEventFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(null);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(null);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertEquals(statisticsEventFilter, statisticsEventFilter2);
    int expectedHashCodeResult = statisticsEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, statisticsEventFilter2.hashCode());
  }

  /**
   * Test {@link StatisticsEventFilter#equals(Object)}, and {@link StatisticsEventFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEventFilter#equals(Object)}
   *   <li>{@link StatisticsEventFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.equals(Object)", "int StatisticsEventFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer(null);

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer(null);

    // Act and Assert
    assertEquals(statisticsEventFilter, statisticsEventFilter2);
    int expectedHashCodeResult = statisticsEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, statisticsEventFilter2.hashCode());
  }

  /**
   * Test {@link StatisticsEventFilter#equals(Object)}, and {@link StatisticsEventFilter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEventFilter#equals(Object)}
   *   <li>{@link StatisticsEventFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.equals(Object)", "int StatisticsEventFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    // Act and Assert
    assertEquals(statisticsEventFilter, statisticsEventFilter);
    int expectedHashCodeResult = statisticsEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, statisticsEventFilter.hashCode());
  }

  /**
   * Test {@link StatisticsEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.equals(Object)", "int StatisticsEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(3);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(statisticsEventFilter, statisticsEventFilter2);
  }

  /**
   * Test {@link StatisticsEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.equals(Object)", "int StatisticsEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(null);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(statisticsEventFilter, statisticsEventFilter2);
  }

  /**
   * Test {@link StatisticsEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.equals(Object)", "int StatisticsEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(1);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(statisticsEventFilter, statisticsEventFilter2);
  }

  /**
   * Test {@link StatisticsEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.equals(Object)", "int StatisticsEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(null);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(statisticsEventFilter, statisticsEventFilter2);
  }

  /**
   * Test {@link StatisticsEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.equals(Object)", "int StatisticsEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(statisticsEventFilter, statisticsEventFilter2);
  }

  /**
   * Test {@link StatisticsEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.equals(Object)", "int StatisticsEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(null);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(statisticsEventFilter, statisticsEventFilter2);
  }

  /**
   * Test {@link StatisticsEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.equals(Object)", "int StatisticsEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(3);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(statisticsEventFilter, statisticsEventFilter2);
  }

  /**
   * Test {@link StatisticsEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.equals(Object)", "int StatisticsEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(null);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(statisticsEventFilter, statisticsEventFilter2);
  }

  /**
   * Test {@link StatisticsEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.equals(Object)", "int StatisticsEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer(null);

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(statisticsEventFilter, statisticsEventFilter2);
  }

  /**
   * Test {@link StatisticsEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.equals(Object)", "int StatisticsEventFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("org.thingsboard.server.common.data.event.StatisticsEventFilter");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(statisticsEventFilter, statisticsEventFilter2);
  }

  /**
   * Test {@link StatisticsEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.equals(Object)", "int StatisticsEventFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    // Act and Assert
    assertNotEquals(statisticsEventFilter, null);
  }

  /**
   * Test {@link StatisticsEventFilter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StatisticsEventFilter.equals(Object)", "int StatisticsEventFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    // Act and Assert
    assertNotEquals(statisticsEventFilter, "Different type to StatisticsEventFilter");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StatisticsEventFilter}
   *   <li>{@link StatisticsEventFilter#setMaxErrorsOccurred(Integer)}
   *   <li>{@link StatisticsEventFilter#setMaxMessagesProcessed(Integer)}
   *   <li>{@link StatisticsEventFilter#setMinErrorsOccurred(Integer)}
   *   <li>{@link StatisticsEventFilter#setMinMessagesProcessed(Integer)}
   *   <li>{@link StatisticsEventFilter#setServer(String)}
   *   <li>{@link StatisticsEventFilter#toString()}
   *   <li>{@link StatisticsEventFilter#getEventType()}
   *   <li>{@link StatisticsEventFilter#getMaxErrorsOccurred()}
   *   <li>{@link StatisticsEventFilter#getMaxMessagesProcessed()}
   *   <li>{@link StatisticsEventFilter#getMinErrorsOccurred()}
   *   <li>{@link StatisticsEventFilter#getMinMessagesProcessed()}
   *   <li>{@link StatisticsEventFilter#getServer()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StatisticsEventFilter.<init>()", "EventType StatisticsEventFilter.getEventType()",
      "Integer StatisticsEventFilter.getMaxErrorsOccurred()", "Integer StatisticsEventFilter.getMaxMessagesProcessed()",
      "Integer StatisticsEventFilter.getMinErrorsOccurred()", "Integer StatisticsEventFilter.getMinMessagesProcessed()",
      "String StatisticsEventFilter.getServer()", "void StatisticsEventFilter.setMaxErrorsOccurred(Integer)",
      "void StatisticsEventFilter.setMaxMessagesProcessed(Integer)",
      "void StatisticsEventFilter.setMinErrorsOccurred(Integer)",
      "void StatisticsEventFilter.setMinMessagesProcessed(Integer)", "void StatisticsEventFilter.setServer(String)",
      "String StatisticsEventFilter.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    StatisticsEventFilter actualStatisticsEventFilter = new StatisticsEventFilter();
    actualStatisticsEventFilter.setMaxErrorsOccurred(-1);
    actualStatisticsEventFilter.setMaxMessagesProcessed(3);
    actualStatisticsEventFilter.setMinErrorsOccurred(-1);
    actualStatisticsEventFilter.setMinMessagesProcessed(1);
    actualStatisticsEventFilter.setServer("Server");
    String actualToStringResult = actualStatisticsEventFilter.toString();
    EventType actualEventType = actualStatisticsEventFilter.getEventType();
    Integer actualMaxErrorsOccurred = actualStatisticsEventFilter.getMaxErrorsOccurred();
    Integer actualMaxMessagesProcessed = actualStatisticsEventFilter.getMaxMessagesProcessed();
    Integer actualMinErrorsOccurred = actualStatisticsEventFilter.getMinErrorsOccurred();
    Integer actualMinMessagesProcessed = actualStatisticsEventFilter.getMinMessagesProcessed();

    // Assert
    assertEquals("Server", actualStatisticsEventFilter.getServer());
    assertEquals(
        "StatisticsEventFilter(server=Server, minMessagesProcessed=1, maxMessagesProcessed=3, minErrorsOccurred=-1,"
            + " maxErrorsOccurred=-1)",
        actualToStringResult);
    assertEquals(-1, actualMaxErrorsOccurred.intValue());
    assertEquals(-1, actualMinErrorsOccurred.intValue());
    assertEquals(1, actualMinMessagesProcessed.intValue());
    assertEquals(3, actualMaxMessagesProcessed.intValue());
    assertEquals(EventType.STATS, actualEventType);
  }
}
