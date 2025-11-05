package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.util.TbMsgSource;

class TbFetchDeviceCredentialsNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbFetchDeviceCredentialsNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbFetchDeviceCredentialsNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbFetchDeviceCredentialsNodeConfiguration TbFetchDeviceCredentialsNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange, Act and Assert
    assertEquals(
        TbMsgSource.METADATA,
        new TbFetchDeviceCredentialsNodeConfiguration().defaultConfiguration().getFetchTo());
  }

  /**
   * Test {@link TbFetchDeviceCredentialsNodeConfiguration#equals(Object)}, and {@link
   * TbFetchDeviceCredentialsNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbFetchDeviceCredentialsNodeConfiguration#equals(Object)}
   *   <li>{@link TbFetchDeviceCredentialsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbFetchDeviceCredentialsNodeConfiguration.equals(Object)",
    "int TbFetchDeviceCredentialsNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration =
        new TbFetchDeviceCredentialsNodeConfiguration();
    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration2 =
        new TbFetchDeviceCredentialsNodeConfiguration();

    // Act and Assert
    assertEquals(
        tbFetchDeviceCredentialsNodeConfiguration, tbFetchDeviceCredentialsNodeConfiguration2);
    assertEquals(
        tbFetchDeviceCredentialsNodeConfiguration.hashCode(),
        tbFetchDeviceCredentialsNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbFetchDeviceCredentialsNodeConfiguration#equals(Object)}, and {@link
   * TbFetchDeviceCredentialsNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbFetchDeviceCredentialsNodeConfiguration#equals(Object)}
   *   <li>{@link TbFetchDeviceCredentialsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbFetchDeviceCredentialsNodeConfiguration.equals(Object)",
    "int TbFetchDeviceCredentialsNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration =
        new TbFetchDeviceCredentialsNodeConfiguration();

    // Act and Assert
    assertEquals(
        tbFetchDeviceCredentialsNodeConfiguration, tbFetchDeviceCredentialsNodeConfiguration);
    int expectedHashCodeResult = tbFetchDeviceCredentialsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbFetchDeviceCredentialsNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbFetchDeviceCredentialsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbFetchDeviceCredentialsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbFetchDeviceCredentialsNodeConfiguration.equals(Object)",
    "int TbFetchDeviceCredentialsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbFetchDeviceCredentialsNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbFetchDeviceCredentialsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbFetchDeviceCredentialsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbFetchDeviceCredentialsNodeConfiguration.equals(Object)",
    "int TbFetchDeviceCredentialsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration =
        new TbFetchDeviceCredentialsNodeConfiguration();
    tbFetchDeviceCredentialsNodeConfiguration.setFetchTo(TbMsgSource.DATA);

    // Act and Assert
    assertNotEquals(
        tbFetchDeviceCredentialsNodeConfiguration, new TbFetchDeviceCredentialsNodeConfiguration());
  }

  /**
   * Test {@link TbFetchDeviceCredentialsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbFetchDeviceCredentialsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbFetchDeviceCredentialsNodeConfiguration.equals(Object)",
    "int TbFetchDeviceCredentialsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbFetchDeviceCredentialsNodeConfiguration(), null);
  }

  /**
   * Test {@link TbFetchDeviceCredentialsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbFetchDeviceCredentialsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbFetchDeviceCredentialsNodeConfiguration.equals(Object)",
    "int TbFetchDeviceCredentialsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbFetchDeviceCredentialsNodeConfiguration(),
        "Different type to TbFetchDeviceCredentialsNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbFetchDeviceCredentialsNodeConfiguration}
   *   <li>{@link TbFetchDeviceCredentialsNodeConfiguration#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbFetchDeviceCredentialsNodeConfiguration.<init>()",
    "java.lang.String TbFetchDeviceCredentialsNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbFetchDeviceCredentialsNodeConfiguration actualTbFetchDeviceCredentialsNodeConfiguration =
        new TbFetchDeviceCredentialsNodeConfiguration();

    // Assert
    assertEquals(
        "TbFetchDeviceCredentialsNodeConfiguration()",
        actualTbFetchDeviceCredentialsNodeConfiguration.toString());
    assertNull(actualTbFetchDeviceCredentialsNodeConfiguration.getFetchTo());
  }
}
