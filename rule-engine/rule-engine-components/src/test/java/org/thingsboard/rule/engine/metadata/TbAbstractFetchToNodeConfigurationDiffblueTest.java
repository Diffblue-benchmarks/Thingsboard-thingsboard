package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.util.TbMsgSource;

class TbAbstractFetchToNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbAbstractFetchToNodeConfiguration#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractFetchToNodeConfiguration#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new TbFetchDeviceCredentialsNodeConfiguration()).canEqual("Other"));
  }

  /**
   * Test {@link TbAbstractFetchToNodeConfiguration#canEqual(Object)}.
   * <ul>
   *   <li>When {@link TbFetchDeviceCredentialsNodeConfiguration} (default
   * constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractFetchToNodeConfiguration#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when TbFetchDeviceCredentialsNodeConfiguration (default constructor); then return 'true'")
  void testCanEqual_whenTbFetchDeviceCredentialsNodeConfiguration_thenReturnTrue() {
    // Arrange
    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration = new TbFetchDeviceCredentialsNodeConfiguration();

    // Act and Assert
    assertTrue(tbFetchDeviceCredentialsNodeConfiguration.canEqual(new TbFetchDeviceCredentialsNodeConfiguration()));
  }

  /**
   * Test {@link TbAbstractFetchToNodeConfiguration#equals(Object)}, and
   * {@link TbAbstractFetchToNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractFetchToNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration = new TbFetchDeviceCredentialsNodeConfiguration();
    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration2 = new TbFetchDeviceCredentialsNodeConfiguration();

    // Act and Assert
    assertEquals(tbFetchDeviceCredentialsNodeConfiguration, tbFetchDeviceCredentialsNodeConfiguration2);
    int expectedHashCodeResult = tbFetchDeviceCredentialsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbFetchDeviceCredentialsNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbAbstractFetchToNodeConfiguration#equals(Object)}, and
   * {@link TbAbstractFetchToNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractFetchToNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration = new TbFetchDeviceCredentialsNodeConfiguration();
    tbFetchDeviceCredentialsNodeConfiguration.setFetchTo(TbMsgSource.DATA);
    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration2 = mock(
        TbFetchDeviceCredentialsNodeConfiguration.class);
    when(tbFetchDeviceCredentialsNodeConfiguration2.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbFetchDeviceCredentialsNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(tbFetchDeviceCredentialsNodeConfiguration, tbFetchDeviceCredentialsNodeConfiguration2);
    int notExpectedHashCodeResult = tbFetchDeviceCredentialsNodeConfiguration.hashCode();
    assertNotEquals(notExpectedHashCodeResult, tbFetchDeviceCredentialsNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbAbstractFetchToNodeConfiguration#equals(Object)}, and
   * {@link TbAbstractFetchToNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractFetchToNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration = new TbFetchDeviceCredentialsNodeConfiguration();

    // Act and Assert
    assertEquals(tbFetchDeviceCredentialsNodeConfiguration, tbFetchDeviceCredentialsNodeConfiguration);
    int expectedHashCodeResult = tbFetchDeviceCredentialsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbFetchDeviceCredentialsNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbAbstractFetchToNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractFetchToNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbFetchDeviceCredentialsNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbAbstractFetchToNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractFetchToNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration = new TbFetchDeviceCredentialsNodeConfiguration();
    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration2 = mock(
        TbFetchDeviceCredentialsNodeConfiguration.class);
    when(tbFetchDeviceCredentialsNodeConfiguration2.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbFetchDeviceCredentialsNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbFetchDeviceCredentialsNodeConfiguration, tbFetchDeviceCredentialsNodeConfiguration2);
  }

  /**
   * Test {@link TbAbstractFetchToNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractFetchToNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration = new TbFetchDeviceCredentialsNodeConfiguration();
    tbFetchDeviceCredentialsNodeConfiguration.setFetchTo(TbMsgSource.METADATA);
    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration2 = mock(
        TbFetchDeviceCredentialsNodeConfiguration.class);
    when(tbFetchDeviceCredentialsNodeConfiguration2.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbFetchDeviceCredentialsNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbFetchDeviceCredentialsNodeConfiguration, tbFetchDeviceCredentialsNodeConfiguration2);
  }

  /**
   * Test {@link TbAbstractFetchToNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractFetchToNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbFetchDeviceCredentialsNodeConfiguration(), null);
  }

  /**
   * Test {@link TbAbstractFetchToNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractFetchToNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbFetchDeviceCredentialsNodeConfiguration(),
        "Different type to TbAbstractFetchToNodeConfiguration");
  }

  /**
   * Test {@link TbAbstractFetchToNodeConfiguration#getFetchTo()}.
   * <p>
   * Method under test: {@link TbAbstractFetchToNodeConfiguration#getFetchTo()}
   */
  @Test
  @DisplayName("Test getFetchTo()")
  void testGetFetchTo() {
    // Arrange, Act and Assert
    assertNull((new TbFetchDeviceCredentialsNodeConfiguration()).getFetchTo());
  }

  /**
   * Test {@link TbAbstractFetchToNodeConfiguration#setFetchTo(TbMsgSource)}.
   * <p>
   * Method under test:
   * {@link TbAbstractFetchToNodeConfiguration#setFetchTo(TbMsgSource)}
   */
  @Test
  @DisplayName("Test setFetchTo(TbMsgSource)")
  void testSetFetchTo() {
    // Arrange
    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration = new TbFetchDeviceCredentialsNodeConfiguration();

    // Act
    tbFetchDeviceCredentialsNodeConfiguration.setFetchTo(TbMsgSource.DATA);

    // Assert
    assertEquals(TbMsgSource.DATA, tbFetchDeviceCredentialsNodeConfiguration.getFetchTo());
  }

  /**
   * Test {@link TbAbstractFetchToNodeConfiguration#toString()}.
   * <p>
   * Method under test: {@link TbAbstractFetchToNodeConfiguration#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("TbFetchDeviceCredentialsNodeConfiguration()",
        (new TbFetchDeviceCredentialsNodeConfiguration()).toString());
  }
}
