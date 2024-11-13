package org.thingsboard.server.common.data.device.profile.lwm2m;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.device.data.CoapDeviceTransportConfiguration;
import org.thingsboard.server.common.data.device.data.PowerMode;

class OtherConfigurationDiffblueTest {
  /**
   * Test {@link OtherConfiguration#equals(Object)}, and
   * {@link OtherConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtherConfiguration#equals(Object)}
   *   <li>{@link OtherConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OtherConfiguration otherConfiguration = new OtherConfiguration();
    OtherConfiguration otherConfiguration2 = new OtherConfiguration();

    // Act and Assert
    assertEquals(otherConfiguration, otherConfiguration2);
    int expectedHashCodeResult = otherConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, otherConfiguration2.hashCode());
  }

  /**
   * Test {@link OtherConfiguration#equals(Object)}, and
   * {@link OtherConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtherConfiguration#equals(Object)}
   *   <li>{@link OtherConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OtherConfiguration otherConfiguration = new OtherConfiguration(1, 1, 1, PowerMode.PSM, 1L, 1L, 1L, "2020-03-01",
        "2020-03-01", "Default Object IDVer");
    OtherConfiguration otherConfiguration2 = new OtherConfiguration(1, 1, 1, PowerMode.PSM, 1L, 1L, 1L, "2020-03-01",
        "2020-03-01", "Default Object IDVer");

    // Act and Assert
    assertEquals(otherConfiguration, otherConfiguration2);
    int expectedHashCodeResult = otherConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, otherConfiguration2.hashCode());
  }

  /**
   * Test {@link OtherConfiguration#equals(Object)}, and
   * {@link OtherConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtherConfiguration#equals(Object)}
   *   <li>{@link OtherConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OtherConfiguration otherConfiguration = new OtherConfiguration();

    // Act and Assert
    assertEquals(otherConfiguration, otherConfiguration);
    int expectedHashCodeResult = otherConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, otherConfiguration.hashCode());
  }

  /**
   * Test {@link OtherConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtherConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OtherConfiguration otherConfiguration = new OtherConfiguration(1, 1, 1, PowerMode.PSM, 1L, 1L, 1L, "2020-03-01",
        "2020-03-01", "Default Object IDVer");

    // Act and Assert
    assertNotEquals(otherConfiguration, new OtherConfiguration());
  }

  /**
   * Test {@link OtherConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtherConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new OtherConfiguration(), mock(CoapDeviceTransportConfiguration.class));
  }

  /**
   * Test {@link OtherConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtherConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OtherConfiguration otherConfiguration = new OtherConfiguration();
    otherConfiguration.setFwUpdateStrategy(1);

    // Act and Assert
    assertNotEquals(otherConfiguration, new OtherConfiguration());
  }

  /**
   * Test {@link OtherConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtherConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OtherConfiguration otherConfiguration = new OtherConfiguration();
    otherConfiguration.setSwUpdateStrategy(1);

    // Act and Assert
    assertNotEquals(otherConfiguration, new OtherConfiguration());
  }

  /**
   * Test {@link OtherConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtherConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OtherConfiguration otherConfiguration = new OtherConfiguration();
    otherConfiguration.setClientOnlyObserveAfterConnect(1);

    // Act and Assert
    assertNotEquals(otherConfiguration, new OtherConfiguration());
  }

  /**
   * Test {@link OtherConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtherConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OtherConfiguration otherConfiguration = new OtherConfiguration();
    otherConfiguration.setFwUpdateResource("2020-03-01");

    // Act and Assert
    assertNotEquals(otherConfiguration, new OtherConfiguration());
  }

  /**
   * Test {@link OtherConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtherConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    OtherConfiguration otherConfiguration = new OtherConfiguration();
    otherConfiguration.setSwUpdateResource("2020-03-01");

    // Act and Assert
    assertNotEquals(otherConfiguration, new OtherConfiguration());
  }

  /**
   * Test {@link OtherConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtherConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    OtherConfiguration otherConfiguration = new OtherConfiguration();
    otherConfiguration.setDefaultObjectIDVer("Default Object IDVer");

    // Act and Assert
    assertNotEquals(otherConfiguration, new OtherConfiguration());
  }

  /**
   * Test {@link OtherConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtherConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    OtherConfiguration otherConfiguration = new OtherConfiguration();

    OtherConfiguration otherConfiguration2 = new OtherConfiguration();
    otherConfiguration2.setFwUpdateStrategy(1);

    // Act and Assert
    assertNotEquals(otherConfiguration, otherConfiguration2);
  }

  /**
   * Test {@link OtherConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtherConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    OtherConfiguration otherConfiguration = new OtherConfiguration();

    OtherConfiguration otherConfiguration2 = new OtherConfiguration();
    otherConfiguration2.setSwUpdateStrategy(1);

    // Act and Assert
    assertNotEquals(otherConfiguration, otherConfiguration2);
  }

  /**
   * Test {@link OtherConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtherConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    OtherConfiguration otherConfiguration = new OtherConfiguration();

    OtherConfiguration otherConfiguration2 = new OtherConfiguration();
    otherConfiguration2.setClientOnlyObserveAfterConnect(1);

    // Act and Assert
    assertNotEquals(otherConfiguration, otherConfiguration2);
  }

  /**
   * Test {@link OtherConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtherConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    OtherConfiguration otherConfiguration = new OtherConfiguration();

    OtherConfiguration otherConfiguration2 = new OtherConfiguration();
    otherConfiguration2.setFwUpdateResource("2020-03-01");

    // Act and Assert
    assertNotEquals(otherConfiguration, otherConfiguration2);
  }

  /**
   * Test {@link OtherConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtherConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    OtherConfiguration otherConfiguration = new OtherConfiguration();

    OtherConfiguration otherConfiguration2 = new OtherConfiguration();
    otherConfiguration2.setSwUpdateResource("2020-03-01");

    // Act and Assert
    assertNotEquals(otherConfiguration, otherConfiguration2);
  }

  /**
   * Test {@link OtherConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtherConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    OtherConfiguration otherConfiguration = new OtherConfiguration();

    OtherConfiguration otherConfiguration2 = new OtherConfiguration();
    otherConfiguration2.setDefaultObjectIDVer("Default Object IDVer");

    // Act and Assert
    assertNotEquals(otherConfiguration, otherConfiguration2);
  }

  /**
   * Test {@link OtherConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtherConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OtherConfiguration(), null);
  }

  /**
   * Test {@link OtherConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtherConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OtherConfiguration(), "Different type to OtherConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtherConfiguration#OtherConfiguration()}
   *   <li>{@link OtherConfiguration#setClientOnlyObserveAfterConnect(Integer)}
   *   <li>{@link OtherConfiguration#setDefaultObjectIDVer(String)}
   *   <li>{@link OtherConfiguration#setEdrxCycle(Long)}
   *   <li>{@link OtherConfiguration#setFwUpdateResource(String)}
   *   <li>{@link OtherConfiguration#setFwUpdateStrategy(Integer)}
   *   <li>{@link OtherConfiguration#setPagingTransmissionWindow(Long)}
   *   <li>{@link OtherConfiguration#setPowerMode(PowerMode)}
   *   <li>{@link OtherConfiguration#setPsmActivityTimer(Long)}
   *   <li>{@link OtherConfiguration#setSwUpdateResource(String)}
   *   <li>{@link OtherConfiguration#setSwUpdateStrategy(Integer)}
   *   <li>{@link OtherConfiguration#toString()}
   *   <li>{@link OtherConfiguration#getClientOnlyObserveAfterConnect()}
   *   <li>{@link OtherConfiguration#getDefaultObjectIDVer()}
   *   <li>{@link OtherConfiguration#getEdrxCycle()}
   *   <li>{@link OtherConfiguration#getFwUpdateResource()}
   *   <li>{@link OtherConfiguration#getFwUpdateStrategy()}
   *   <li>{@link OtherConfiguration#getPagingTransmissionWindow()}
   *   <li>{@link OtherConfiguration#getPowerMode()}
   *   <li>{@link OtherConfiguration#getPsmActivityTimer()}
   *   <li>{@link OtherConfiguration#getSwUpdateResource()}
   *   <li>{@link OtherConfiguration#getSwUpdateStrategy()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    OtherConfiguration actualOtherConfiguration = new OtherConfiguration();
    actualOtherConfiguration.setClientOnlyObserveAfterConnect(1);
    actualOtherConfiguration.setDefaultObjectIDVer("Default Object IDVer");
    actualOtherConfiguration.setEdrxCycle(1L);
    actualOtherConfiguration.setFwUpdateResource("2020-03-01");
    actualOtherConfiguration.setFwUpdateStrategy(1);
    actualOtherConfiguration.setPagingTransmissionWindow(1L);
    actualOtherConfiguration.setPowerMode(PowerMode.PSM);
    actualOtherConfiguration.setPsmActivityTimer(1L);
    actualOtherConfiguration.setSwUpdateResource("2020-03-01");
    actualOtherConfiguration.setSwUpdateStrategy(1);
    String actualToStringResult = actualOtherConfiguration.toString();
    Integer actualClientOnlyObserveAfterConnect = actualOtherConfiguration.getClientOnlyObserveAfterConnect();
    String actualDefaultObjectIDVer = actualOtherConfiguration.getDefaultObjectIDVer();
    Long actualEdrxCycle = actualOtherConfiguration.getEdrxCycle();
    String actualFwUpdateResource = actualOtherConfiguration.getFwUpdateResource();
    Integer actualFwUpdateStrategy = actualOtherConfiguration.getFwUpdateStrategy();
    Long actualPagingTransmissionWindow = actualOtherConfiguration.getPagingTransmissionWindow();
    PowerMode actualPowerMode = actualOtherConfiguration.getPowerMode();
    Long actualPsmActivityTimer = actualOtherConfiguration.getPsmActivityTimer();
    String actualSwUpdateResource = actualOtherConfiguration.getSwUpdateResource();
    Integer actualSwUpdateStrategy = actualOtherConfiguration.getSwUpdateStrategy();

    // Assert that nothing has changed
    assertEquals("2020-03-01", actualFwUpdateResource);
    assertEquals("2020-03-01", actualSwUpdateResource);
    assertEquals("Default Object IDVer", actualDefaultObjectIDVer);
    assertEquals(
        "OtherConfiguration(fwUpdateStrategy=1, swUpdateStrategy=1, clientOnlyObserveAfterConnect=1, powerMode=PSM,"
            + " psmActivityTimer=1, edrxCycle=1, pagingTransmissionWindow=1, fwUpdateResource=2020-03-01, swUpdateResource"
            + "=2020-03-01, defaultObjectIDVer=Default Object IDVer)",
        actualToStringResult);
    assertEquals(1, actualClientOnlyObserveAfterConnect.intValue());
    assertEquals(1, actualFwUpdateStrategy.intValue());
    assertEquals(1, actualSwUpdateStrategy.intValue());
    assertEquals(1L, actualEdrxCycle.longValue());
    assertEquals(1L, actualPagingTransmissionWindow.longValue());
    assertEquals(1L, actualPsmActivityTimer.longValue());
    assertEquals(PowerMode.PSM, actualPowerMode);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link OtherConfiguration#OtherConfiguration(Integer, Integer, Integer, PowerMode, Long, Long, Long, String, String, String)}
   *   <li>{@link OtherConfiguration#setClientOnlyObserveAfterConnect(Integer)}
   *   <li>{@link OtherConfiguration#setDefaultObjectIDVer(String)}
   *   <li>{@link OtherConfiguration#setEdrxCycle(Long)}
   *   <li>{@link OtherConfiguration#setFwUpdateResource(String)}
   *   <li>{@link OtherConfiguration#setFwUpdateStrategy(Integer)}
   *   <li>{@link OtherConfiguration#setPagingTransmissionWindow(Long)}
   *   <li>{@link OtherConfiguration#setPowerMode(PowerMode)}
   *   <li>{@link OtherConfiguration#setPsmActivityTimer(Long)}
   *   <li>{@link OtherConfiguration#setSwUpdateResource(String)}
   *   <li>{@link OtherConfiguration#setSwUpdateStrategy(Integer)}
   *   <li>{@link OtherConfiguration#toString()}
   *   <li>{@link OtherConfiguration#getClientOnlyObserveAfterConnect()}
   *   <li>{@link OtherConfiguration#getDefaultObjectIDVer()}
   *   <li>{@link OtherConfiguration#getEdrxCycle()}
   *   <li>{@link OtherConfiguration#getFwUpdateResource()}
   *   <li>{@link OtherConfiguration#getFwUpdateStrategy()}
   *   <li>{@link OtherConfiguration#getPagingTransmissionWindow()}
   *   <li>{@link OtherConfiguration#getPowerMode()}
   *   <li>{@link OtherConfiguration#getPsmActivityTimer()}
   *   <li>{@link OtherConfiguration#getSwUpdateResource()}
   *   <li>{@link OtherConfiguration#getSwUpdateStrategy()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one")
  void testGettersAndSetters_whenOne() {
    // Arrange and Act
    OtherConfiguration actualOtherConfiguration = new OtherConfiguration(1, 1, 1, PowerMode.PSM, 1L, 1L, 1L,
        "2020-03-01", "2020-03-01", "Default Object IDVer");
    actualOtherConfiguration.setClientOnlyObserveAfterConnect(1);
    actualOtherConfiguration.setDefaultObjectIDVer("Default Object IDVer");
    actualOtherConfiguration.setEdrxCycle(1L);
    actualOtherConfiguration.setFwUpdateResource("2020-03-01");
    actualOtherConfiguration.setFwUpdateStrategy(1);
    actualOtherConfiguration.setPagingTransmissionWindow(1L);
    actualOtherConfiguration.setPowerMode(PowerMode.PSM);
    actualOtherConfiguration.setPsmActivityTimer(1L);
    actualOtherConfiguration.setSwUpdateResource("2020-03-01");
    actualOtherConfiguration.setSwUpdateStrategy(1);
    String actualToStringResult = actualOtherConfiguration.toString();
    Integer actualClientOnlyObserveAfterConnect = actualOtherConfiguration.getClientOnlyObserveAfterConnect();
    String actualDefaultObjectIDVer = actualOtherConfiguration.getDefaultObjectIDVer();
    Long actualEdrxCycle = actualOtherConfiguration.getEdrxCycle();
    String actualFwUpdateResource = actualOtherConfiguration.getFwUpdateResource();
    Integer actualFwUpdateStrategy = actualOtherConfiguration.getFwUpdateStrategy();
    Long actualPagingTransmissionWindow = actualOtherConfiguration.getPagingTransmissionWindow();
    PowerMode actualPowerMode = actualOtherConfiguration.getPowerMode();
    Long actualPsmActivityTimer = actualOtherConfiguration.getPsmActivityTimer();
    String actualSwUpdateResource = actualOtherConfiguration.getSwUpdateResource();
    Integer actualSwUpdateStrategy = actualOtherConfiguration.getSwUpdateStrategy();

    // Assert that nothing has changed
    assertEquals("2020-03-01", actualFwUpdateResource);
    assertEquals("2020-03-01", actualSwUpdateResource);
    assertEquals("Default Object IDVer", actualDefaultObjectIDVer);
    assertEquals(
        "OtherConfiguration(fwUpdateStrategy=1, swUpdateStrategy=1, clientOnlyObserveAfterConnect=1, powerMode=PSM,"
            + " psmActivityTimer=1, edrxCycle=1, pagingTransmissionWindow=1, fwUpdateResource=2020-03-01, swUpdateResource"
            + "=2020-03-01, defaultObjectIDVer=Default Object IDVer)",
        actualToStringResult);
    assertEquals(1, actualClientOnlyObserveAfterConnect.intValue());
    assertEquals(1, actualFwUpdateStrategy.intValue());
    assertEquals(1, actualSwUpdateStrategy.intValue());
    assertEquals(1L, actualEdrxCycle.longValue());
    assertEquals(1L, actualPagingTransmissionWindow.longValue());
    assertEquals(1L, actualPsmActivityTimer.longValue());
    assertEquals(PowerMode.PSM, actualPowerMode);
  }
}
