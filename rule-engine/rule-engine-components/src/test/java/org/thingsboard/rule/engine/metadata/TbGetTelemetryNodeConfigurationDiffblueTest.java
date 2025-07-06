package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.kv.Aggregation;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.page.SortOrder.Direction;

class TbGetTelemetryNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbGetTelemetryNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbGetTelemetryNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbGetTelemetryNodeConfiguration TbGetTelemetryNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange and Act
    TbGetTelemetryNodeConfiguration actualDefaultConfigurationResult =
        new TbGetTelemetryNodeConfiguration().defaultConfiguration();

    // Assert
    assertEquals("", actualDefaultConfigurationResult.getEndIntervalPattern());
    assertEquals("", actualDefaultConfigurationResult.getStartIntervalPattern());
    assertEquals("MINUTES", actualDefaultConfigurationResult.getEndIntervalTimeUnit());
    assertEquals("MINUTES", actualDefaultConfigurationResult.getStartIntervalTimeUnit());
    assertEquals(1, actualDefaultConfigurationResult.getEndInterval());
    assertEquals(2, actualDefaultConfigurationResult.getStartInterval());
    assertEquals(FetchMode.FIRST, actualDefaultConfigurationResult.getFetchMode());
    assertEquals(Aggregation.NONE, actualDefaultConfigurationResult.getAggregation());
    assertEquals(Direction.ASC, actualDefaultConfigurationResult.getOrderBy());
    assertFalse(actualDefaultConfigurationResult.isUseMetadataIntervalPatterns());
    assertTrue(actualDefaultConfigurationResult.getLatestTsKeyNames().isEmpty());
    assertEquals(
        TbGetTelemetryNodeConfiguration.MAX_FETCH_SIZE,
        actualDefaultConfigurationResult.getLimit());
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}, and {@link
   * TbGetTelemetryNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGetTelemetryNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetTelemetryNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration2 =
        new TbGetTelemetryNodeConfiguration();

    // Act and Assert
    assertEquals(tbGetTelemetryNodeConfiguration, tbGetTelemetryNodeConfiguration2);
    int expectedHashCodeResult = tbGetTelemetryNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetTelemetryNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}, and {@link
   * TbGetTelemetryNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGetTelemetryNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetTelemetryNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration.setStartIntervalPattern("Start Interval Pattern");

    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration2 =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration2.setStartIntervalPattern("Start Interval Pattern");

    // Act and Assert
    assertEquals(tbGetTelemetryNodeConfiguration, tbGetTelemetryNodeConfiguration2);
    int expectedHashCodeResult = tbGetTelemetryNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetTelemetryNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}, and {@link
   * TbGetTelemetryNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGetTelemetryNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetTelemetryNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration.setEndIntervalPattern("End Interval Pattern");

    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration2 =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration2.setEndIntervalPattern("End Interval Pattern");

    // Act and Assert
    assertEquals(tbGetTelemetryNodeConfiguration, tbGetTelemetryNodeConfiguration2);
    int expectedHashCodeResult = tbGetTelemetryNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetTelemetryNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}, and {@link
   * TbGetTelemetryNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGetTelemetryNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetTelemetryNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration.setStartIntervalTimeUnit("Start Interval Time Unit");

    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration2 =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration2.setStartIntervalTimeUnit("Start Interval Time Unit");

    // Act and Assert
    assertEquals(tbGetTelemetryNodeConfiguration, tbGetTelemetryNodeConfiguration2);
    int expectedHashCodeResult = tbGetTelemetryNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetTelemetryNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}, and {@link
   * TbGetTelemetryNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGetTelemetryNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetTelemetryNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration.setEndIntervalTimeUnit("End Interval Time Unit");

    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration2 =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration2.setEndIntervalTimeUnit("End Interval Time Unit");

    // Act and Assert
    assertEquals(tbGetTelemetryNodeConfiguration, tbGetTelemetryNodeConfiguration2);
    int expectedHashCodeResult = tbGetTelemetryNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetTelemetryNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}, and {@link
   * TbGetTelemetryNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGetTelemetryNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetTelemetryNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration.setFetchMode(FetchMode.FIRST);

    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration2 =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration2.setFetchMode(FetchMode.FIRST);

    // Act and Assert
    assertEquals(tbGetTelemetryNodeConfiguration, tbGetTelemetryNodeConfiguration2);
    int expectedHashCodeResult = tbGetTelemetryNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetTelemetryNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}, and {@link
   * TbGetTelemetryNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGetTelemetryNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetTelemetryNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration.setOrderBy(Direction.ASC);

    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration2 =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration2.setOrderBy(Direction.ASC);

    // Act and Assert
    assertEquals(tbGetTelemetryNodeConfiguration, tbGetTelemetryNodeConfiguration2);
    int expectedHashCodeResult = tbGetTelemetryNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetTelemetryNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}, and {@link
   * TbGetTelemetryNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGetTelemetryNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetTelemetryNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual8() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration.setAggregation(Aggregation.MIN);

    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration2 =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration2.setAggregation(Aggregation.MIN);

    // Act and Assert
    assertEquals(tbGetTelemetryNodeConfiguration, tbGetTelemetryNodeConfiguration2);
    int expectedHashCodeResult = tbGetTelemetryNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetTelemetryNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}, and {@link
   * TbGetTelemetryNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGetTelemetryNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetTelemetryNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual9() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration.setLatestTsKeyNames(new ArrayList<>());

    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration2 =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration2.setLatestTsKeyNames(new ArrayList<>());

    // Act and Assert
    assertEquals(tbGetTelemetryNodeConfiguration, tbGetTelemetryNodeConfiguration2);
    int expectedHashCodeResult = tbGetTelemetryNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetTelemetryNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}, and {@link
   * TbGetTelemetryNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGetTelemetryNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetTelemetryNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();

    // Act and Assert
    assertEquals(tbGetTelemetryNodeConfiguration, tbGetTelemetryNodeConfiguration);
    int expectedHashCodeResult = tbGetTelemetryNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetTelemetryNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGetTelemetryNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration.setStartInterval(1);

    // Act and Assert
    assertNotEquals(tbGetTelemetryNodeConfiguration, new TbGetTelemetryNodeConfiguration());
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration.setEndInterval(3);

    // Act and Assert
    assertNotEquals(tbGetTelemetryNodeConfiguration, new TbGetTelemetryNodeConfiguration());
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration.setStartIntervalPattern("Start Interval Pattern");

    // Act and Assert
    assertNotEquals(tbGetTelemetryNodeConfiguration, new TbGetTelemetryNodeConfiguration());
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration.setEndIntervalPattern("End Interval Pattern");

    // Act and Assert
    assertNotEquals(tbGetTelemetryNodeConfiguration, new TbGetTelemetryNodeConfiguration());
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration.setUseMetadataIntervalPatterns(true);

    // Act and Assert
    assertNotEquals(tbGetTelemetryNodeConfiguration, new TbGetTelemetryNodeConfiguration());
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration.setStartIntervalTimeUnit("Start Interval Time Unit");

    // Act and Assert
    assertNotEquals(tbGetTelemetryNodeConfiguration, new TbGetTelemetryNodeConfiguration());
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration.setEndIntervalTimeUnit("End Interval Time Unit");

    // Act and Assert
    assertNotEquals(tbGetTelemetryNodeConfiguration, new TbGetTelemetryNodeConfiguration());
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration.setFetchMode(FetchMode.FIRST);

    // Act and Assert
    assertNotEquals(tbGetTelemetryNodeConfiguration, new TbGetTelemetryNodeConfiguration());
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration.setOrderBy(Direction.ASC);

    // Act and Assert
    assertNotEquals(tbGetTelemetryNodeConfiguration, new TbGetTelemetryNodeConfiguration());
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration.setAggregation(Aggregation.MIN);

    // Act and Assert
    assertNotEquals(tbGetTelemetryNodeConfiguration, new TbGetTelemetryNodeConfiguration());
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration.setLimit(1);

    // Act and Assert
    assertNotEquals(tbGetTelemetryNodeConfiguration, new TbGetTelemetryNodeConfiguration());
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration.setLatestTsKeyNames(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tbGetTelemetryNodeConfiguration, new TbGetTelemetryNodeConfiguration());
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();

    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration2 =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration2.setStartIntervalPattern("Start Interval Pattern");

    // Act and Assert
    assertNotEquals(tbGetTelemetryNodeConfiguration, tbGetTelemetryNodeConfiguration2);
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();

    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration2 =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration2.setEndIntervalPattern("End Interval Pattern");

    // Act and Assert
    assertNotEquals(tbGetTelemetryNodeConfiguration, tbGetTelemetryNodeConfiguration2);
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();

    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration2 =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration2.setStartIntervalTimeUnit("Start Interval Time Unit");

    // Act and Assert
    assertNotEquals(tbGetTelemetryNodeConfiguration, tbGetTelemetryNodeConfiguration2);
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();

    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration2 =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration2.setEndIntervalTimeUnit("End Interval Time Unit");

    // Act and Assert
    assertNotEquals(tbGetTelemetryNodeConfiguration, tbGetTelemetryNodeConfiguration2);
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();

    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration2 =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration2.setFetchMode(FetchMode.FIRST);

    // Act and Assert
    assertNotEquals(tbGetTelemetryNodeConfiguration, tbGetTelemetryNodeConfiguration2);
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();

    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration2 =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration2.setOrderBy(Direction.ASC);

    // Act and Assert
    assertNotEquals(tbGetTelemetryNodeConfiguration, tbGetTelemetryNodeConfiguration2);
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();

    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration2 =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration2.setAggregation(Aggregation.MIN);

    // Act and Assert
    assertNotEquals(tbGetTelemetryNodeConfiguration, tbGetTelemetryNodeConfiguration2);
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();

    TbGetTelemetryNodeConfiguration tbGetTelemetryNodeConfiguration2 =
        new TbGetTelemetryNodeConfiguration();
    tbGetTelemetryNodeConfiguration2.setLatestTsKeyNames(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tbGetTelemetryNodeConfiguration, tbGetTelemetryNodeConfiguration2);
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGetTelemetryNodeConfiguration(), null);
  }

  /**
   * Test {@link TbGetTelemetryNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetTelemetryNodeConfiguration.equals(Object)",
    "int TbGetTelemetryNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbGetTelemetryNodeConfiguration(), "Different type to TbGetTelemetryNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbGetTelemetryNodeConfiguration}
   *   <li>{@link TbGetTelemetryNodeConfiguration#setAggregation(Aggregation)}
   *   <li>{@link TbGetTelemetryNodeConfiguration#setEndInterval(int)}
   *   <li>{@link TbGetTelemetryNodeConfiguration#setEndIntervalPattern(String)}
   *   <li>{@link TbGetTelemetryNodeConfiguration#setEndIntervalTimeUnit(String)}
   *   <li>{@link TbGetTelemetryNodeConfiguration#setFetchMode(FetchMode)}
   *   <li>{@link TbGetTelemetryNodeConfiguration#setLatestTsKeyNames(List)}
   *   <li>{@link TbGetTelemetryNodeConfiguration#setLimit(int)}
   *   <li>{@link TbGetTelemetryNodeConfiguration#setOrderBy(SortOrder.Direction)}
   *   <li>{@link TbGetTelemetryNodeConfiguration#setStartInterval(int)}
   *   <li>{@link TbGetTelemetryNodeConfiguration#setStartIntervalPattern(String)}
   *   <li>{@link TbGetTelemetryNodeConfiguration#setStartIntervalTimeUnit(String)}
   *   <li>{@link TbGetTelemetryNodeConfiguration#setUseMetadataIntervalPatterns(boolean)}
   *   <li>{@link TbGetTelemetryNodeConfiguration#toString()}
   *   <li>{@link TbGetTelemetryNodeConfiguration#getAggregation()}
   *   <li>{@link TbGetTelemetryNodeConfiguration#getEndInterval()}
   *   <li>{@link TbGetTelemetryNodeConfiguration#getEndIntervalPattern()}
   *   <li>{@link TbGetTelemetryNodeConfiguration#getEndIntervalTimeUnit()}
   *   <li>{@link TbGetTelemetryNodeConfiguration#getFetchMode()}
   *   <li>{@link TbGetTelemetryNodeConfiguration#getLatestTsKeyNames()}
   *   <li>{@link TbGetTelemetryNodeConfiguration#getLimit()}
   *   <li>{@link TbGetTelemetryNodeConfiguration#getOrderBy()}
   *   <li>{@link TbGetTelemetryNodeConfiguration#getStartInterval()}
   *   <li>{@link TbGetTelemetryNodeConfiguration#getStartIntervalPattern()}
   *   <li>{@link TbGetTelemetryNodeConfiguration#getStartIntervalTimeUnit()}
   *   <li>{@link TbGetTelemetryNodeConfiguration#isUseMetadataIntervalPatterns()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbGetTelemetryNodeConfiguration.<init>()",
    "Aggregation TbGetTelemetryNodeConfiguration.getAggregation()",
    "int TbGetTelemetryNodeConfiguration.getEndInterval()",
    "String TbGetTelemetryNodeConfiguration.getEndIntervalPattern()",
    "String TbGetTelemetryNodeConfiguration.getEndIntervalTimeUnit()",
    "FetchMode TbGetTelemetryNodeConfiguration.getFetchMode()",
    "List TbGetTelemetryNodeConfiguration.getLatestTsKeyNames()",
    "int TbGetTelemetryNodeConfiguration.getLimit()",
    "SortOrder.Direction TbGetTelemetryNodeConfiguration.getOrderBy()",
    "int TbGetTelemetryNodeConfiguration.getStartInterval()",
    "String TbGetTelemetryNodeConfiguration.getStartIntervalPattern()",
    "String TbGetTelemetryNodeConfiguration.getStartIntervalTimeUnit()",
    "boolean TbGetTelemetryNodeConfiguration.isUseMetadataIntervalPatterns()",
    "void TbGetTelemetryNodeConfiguration.setAggregation(Aggregation)",
    "void TbGetTelemetryNodeConfiguration.setEndInterval(int)",
    "void TbGetTelemetryNodeConfiguration.setEndIntervalPattern(String)",
    "void TbGetTelemetryNodeConfiguration.setEndIntervalTimeUnit(String)",
    "void TbGetTelemetryNodeConfiguration.setFetchMode(FetchMode)",
    "void TbGetTelemetryNodeConfiguration.setLatestTsKeyNames(List)",
    "void TbGetTelemetryNodeConfiguration.setLimit(int)",
    "void TbGetTelemetryNodeConfiguration.setOrderBy(SortOrder.Direction)",
    "void TbGetTelemetryNodeConfiguration.setStartInterval(int)",
    "void TbGetTelemetryNodeConfiguration.setStartIntervalPattern(String)",
    "void TbGetTelemetryNodeConfiguration.setStartIntervalTimeUnit(String)",
    "void TbGetTelemetryNodeConfiguration.setUseMetadataIntervalPatterns(boolean)",
    "String TbGetTelemetryNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbGetTelemetryNodeConfiguration actualTbGetTelemetryNodeConfiguration =
        new TbGetTelemetryNodeConfiguration();
    actualTbGetTelemetryNodeConfiguration.setAggregation(Aggregation.MIN);
    actualTbGetTelemetryNodeConfiguration.setEndInterval(3);
    actualTbGetTelemetryNodeConfiguration.setEndIntervalPattern("End Interval Pattern");
    actualTbGetTelemetryNodeConfiguration.setEndIntervalTimeUnit("End Interval Time Unit");
    actualTbGetTelemetryNodeConfiguration.setFetchMode(FetchMode.FIRST);
    ArrayList<String> latestTsKeyNames = new ArrayList<>();
    actualTbGetTelemetryNodeConfiguration.setLatestTsKeyNames(latestTsKeyNames);
    actualTbGetTelemetryNodeConfiguration.setLimit(1);
    actualTbGetTelemetryNodeConfiguration.setOrderBy(Direction.ASC);
    actualTbGetTelemetryNodeConfiguration.setStartInterval(1);
    actualTbGetTelemetryNodeConfiguration.setStartIntervalPattern("Start Interval Pattern");
    actualTbGetTelemetryNodeConfiguration.setStartIntervalTimeUnit("Start Interval Time Unit");
    actualTbGetTelemetryNodeConfiguration.setUseMetadataIntervalPatterns(true);
    String actualToStringResult = actualTbGetTelemetryNodeConfiguration.toString();
    Aggregation actualAggregation = actualTbGetTelemetryNodeConfiguration.getAggregation();
    int actualEndInterval = actualTbGetTelemetryNodeConfiguration.getEndInterval();
    String actualEndIntervalPattern = actualTbGetTelemetryNodeConfiguration.getEndIntervalPattern();
    String actualEndIntervalTimeUnit =
        actualTbGetTelemetryNodeConfiguration.getEndIntervalTimeUnit();
    FetchMode actualFetchMode = actualTbGetTelemetryNodeConfiguration.getFetchMode();
    List<String> actualLatestTsKeyNames =
        actualTbGetTelemetryNodeConfiguration.getLatestTsKeyNames();
    int actualLimit = actualTbGetTelemetryNodeConfiguration.getLimit();
    Direction actualOrderBy = actualTbGetTelemetryNodeConfiguration.getOrderBy();
    int actualStartInterval = actualTbGetTelemetryNodeConfiguration.getStartInterval();
    String actualStartIntervalPattern =
        actualTbGetTelemetryNodeConfiguration.getStartIntervalPattern();
    String actualStartIntervalTimeUnit =
        actualTbGetTelemetryNodeConfiguration.getStartIntervalTimeUnit();
    boolean actualIsUseMetadataIntervalPatternsResult =
        actualTbGetTelemetryNodeConfiguration.isUseMetadataIntervalPatterns();

    // Assert
    assertEquals("End Interval Pattern", actualEndIntervalPattern);
    assertEquals("End Interval Time Unit", actualEndIntervalTimeUnit);
    assertEquals("Start Interval Pattern", actualStartIntervalPattern);
    assertEquals("Start Interval Time Unit", actualStartIntervalTimeUnit);
    assertEquals(
        "TbGetTelemetryNodeConfiguration(startInterval=1, endInterval=3, startIntervalPattern=Start Interval"
            + " Pattern, endIntervalPattern=End Interval Pattern, useMetadataIntervalPatterns=true, startIntervalTimeUnit"
            + "=Start Interval Time Unit, endIntervalTimeUnit=End Interval Time Unit, fetchMode=FIRST, orderBy=ASC,"
            + " aggregation=MIN, limit=1, latestTsKeyNames=[])",
        actualToStringResult);
    assertEquals(1, actualLimit);
    assertEquals(1, actualStartInterval);
    assertEquals(3, actualEndInterval);
    assertEquals(FetchMode.FIRST, actualFetchMode);
    assertEquals(Aggregation.MIN, actualAggregation);
    assertEquals(Direction.ASC, actualOrderBy);
    assertTrue(actualLatestTsKeyNames.isEmpty());
    assertTrue(actualIsUseMetadataIntervalPatternsResult);
    assertSame(latestTsKeyNames, actualLatestTsKeyNames);
  }
}
