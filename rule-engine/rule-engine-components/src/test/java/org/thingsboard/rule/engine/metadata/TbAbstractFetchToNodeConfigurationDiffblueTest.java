package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.util.TbMsgSource;
import org.thingsboard.server.common.msg.TbMsg;

class TbAbstractFetchToNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbAbstractFetchToNodeConfiguration#canEqual(Object)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractFetchToNodeConfiguration#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbAbstractFetchToNodeConfiguration.canEqual(Object)"})
  void testCanEqual_thenReturnFalse() {
    // Arrange
    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration =
        new TbFetchDeviceCredentialsNodeConfiguration();
    TbMsg telemetryMsgResult =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertFalse(tbFetchDeviceCredentialsNodeConfiguration.canEqual(telemetryMsgResult));
  }

  /**
   * Test {@link TbAbstractFetchToNodeConfiguration#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link TbFetchDeviceCredentialsNodeConfiguration} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractFetchToNodeConfiguration#canEqual(Object)}
   */
  @Test
  @DisplayName(
      "Test canEqual(Object); when TbFetchDeviceCredentialsNodeConfiguration (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbAbstractFetchToNodeConfiguration.canEqual(Object)"})
  void testCanEqual_whenTbFetchDeviceCredentialsNodeConfiguration_thenReturnTrue() {
    // Arrange
    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration =
        new TbFetchDeviceCredentialsNodeConfiguration();

    // Act and Assert
    assertTrue(
        tbFetchDeviceCredentialsNodeConfiguration.canEqual(
            new TbFetchDeviceCredentialsNodeConfiguration()));
  }

  /**
   * Test {@link TbAbstractFetchToNodeConfiguration#equals(Object)}, and {@link
   * TbAbstractFetchToNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractFetchToNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractFetchToNodeConfiguration.equals(Object)",
    "int TbAbstractFetchToNodeConfiguration.hashCode()"
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
   * Test {@link TbAbstractFetchToNodeConfiguration#equals(Object)}, and {@link
   * TbAbstractFetchToNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractFetchToNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractFetchToNodeConfiguration.equals(Object)",
    "int TbAbstractFetchToNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration =
        new TbFetchDeviceCredentialsNodeConfiguration();
    tbFetchDeviceCredentialsNodeConfiguration.setFetchTo(TbMsgSource.DATA);

    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration2 =
        mock(TbFetchDeviceCredentialsNodeConfiguration.class);
    when(tbFetchDeviceCredentialsNodeConfiguration2.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbFetchDeviceCredentialsNodeConfiguration2.canEqual(Mockito.<Object>any()))
        .thenReturn(true);

    // Act and Assert
    assertEquals(
        tbFetchDeviceCredentialsNodeConfiguration, tbFetchDeviceCredentialsNodeConfiguration2);
    assertNotEquals(
        tbFetchDeviceCredentialsNodeConfiguration.hashCode(),
        tbFetchDeviceCredentialsNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbAbstractFetchToNodeConfiguration#equals(Object)}, and {@link
   * TbAbstractFetchToNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractFetchToNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractFetchToNodeConfiguration.equals(Object)",
    "int TbAbstractFetchToNodeConfiguration.hashCode()"
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
   * Test {@link TbAbstractFetchToNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractFetchToNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractFetchToNodeConfiguration.equals(Object)",
    "int TbAbstractFetchToNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbFetchDeviceCredentialsNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbAbstractFetchToNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractFetchToNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractFetchToNodeConfiguration.equals(Object)",
    "int TbAbstractFetchToNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration =
        new TbFetchDeviceCredentialsNodeConfiguration();

    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration2 =
        mock(TbFetchDeviceCredentialsNodeConfiguration.class);
    when(tbFetchDeviceCredentialsNodeConfiguration2.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbFetchDeviceCredentialsNodeConfiguration2.canEqual(Mockito.<Object>any()))
        .thenReturn(true);

    // Act and Assert
    assertNotEquals(
        tbFetchDeviceCredentialsNodeConfiguration, tbFetchDeviceCredentialsNodeConfiguration2);
  }

  /**
   * Test {@link TbAbstractFetchToNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractFetchToNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractFetchToNodeConfiguration.equals(Object)",
    "int TbAbstractFetchToNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration =
        new TbFetchDeviceCredentialsNodeConfiguration();
    tbFetchDeviceCredentialsNodeConfiguration.setFetchTo(TbMsgSource.METADATA);

    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration2 =
        mock(TbFetchDeviceCredentialsNodeConfiguration.class);
    when(tbFetchDeviceCredentialsNodeConfiguration2.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbFetchDeviceCredentialsNodeConfiguration2.canEqual(Mockito.<Object>any()))
        .thenReturn(true);

    // Act and Assert
    assertNotEquals(
        tbFetchDeviceCredentialsNodeConfiguration, tbFetchDeviceCredentialsNodeConfiguration2);
  }

  /**
   * Test {@link TbAbstractFetchToNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractFetchToNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractFetchToNodeConfiguration.equals(Object)",
    "int TbAbstractFetchToNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbFetchDeviceCredentialsNodeConfiguration(), null);
  }

  /**
   * Test {@link TbAbstractFetchToNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractFetchToNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractFetchToNodeConfiguration.equals(Object)",
    "int TbAbstractFetchToNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbFetchDeviceCredentialsNodeConfiguration(),
        "Different type to TbAbstractFetchToNodeConfiguration");
  }

  /**
   * Test {@link TbAbstractFetchToNodeConfiguration#getFetchTo()}.
   *
   * <p>Method under test: {@link TbAbstractFetchToNodeConfiguration#getFetchTo()}
   */
  @Test
  @DisplayName("Test getFetchTo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsgSource TbAbstractFetchToNodeConfiguration.getFetchTo()"})
  void testGetFetchTo() {
    // Arrange, Act and Assert
    assertNull(new TbFetchDeviceCredentialsNodeConfiguration().getFetchTo());
  }

  /**
   * Test {@link TbAbstractFetchToNodeConfiguration#setFetchTo(TbMsgSource)}.
   *
   * <p>Method under test: {@link TbAbstractFetchToNodeConfiguration#setFetchTo(TbMsgSource)}
   */
  @Test
  @DisplayName("Test setFetchTo(TbMsgSource)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractFetchToNodeConfiguration.setFetchTo(TbMsgSource)"})
  void testSetFetchTo() {
    // Arrange
    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration =
        new TbFetchDeviceCredentialsNodeConfiguration();

    // Act
    tbFetchDeviceCredentialsNodeConfiguration.setFetchTo(TbMsgSource.DATA);

    // Assert
    assertEquals(TbMsgSource.DATA, tbFetchDeviceCredentialsNodeConfiguration.getFetchTo());
  }

  /**
   * Test {@link TbAbstractFetchToNodeConfiguration#toString()}.
   *
   * <p>Method under test: {@link TbAbstractFetchToNodeConfiguration#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TbAbstractFetchToNodeConfiguration.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "TbFetchDeviceCredentialsNodeConfiguration()",
        new TbFetchDeviceCredentialsNodeConfiguration().toString());
  }
}
