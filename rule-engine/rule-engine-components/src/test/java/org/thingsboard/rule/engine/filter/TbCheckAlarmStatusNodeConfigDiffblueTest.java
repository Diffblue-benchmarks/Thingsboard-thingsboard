package org.thingsboard.rule.engine.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.alarm.AlarmStatus;

class TbCheckAlarmStatusNodeConfigDiffblueTest {
  /**
   * Test {@link TbCheckAlarmStatusNodeConfig#defaultConfiguration()}.
   * <p>
   * Method under test:
   * {@link TbCheckAlarmStatusNodeConfig#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  void testDefaultConfiguration() {
    // Arrange, Act and Assert
    List<AlarmStatus> alarmStatusList = (new TbCheckAlarmStatusNodeConfig()).defaultConfiguration()
        .getAlarmStatusList();
    assertEquals(2, alarmStatusList.size());
    assertEquals(AlarmStatus.ACTIVE_ACK, alarmStatusList.get(0));
    assertEquals(AlarmStatus.ACTIVE_UNACK, alarmStatusList.get(1));
  }

  /**
   * Test {@link TbCheckAlarmStatusNodeConfig#equals(Object)}, and
   * {@link TbCheckAlarmStatusNodeConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbCheckAlarmStatusNodeConfig#equals(Object)}
   *   <li>{@link TbCheckAlarmStatusNodeConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbCheckAlarmStatusNodeConfig tbCheckAlarmStatusNodeConfig = new TbCheckAlarmStatusNodeConfig();
    TbCheckAlarmStatusNodeConfig tbCheckAlarmStatusNodeConfig2 = new TbCheckAlarmStatusNodeConfig();

    // Act and Assert
    assertEquals(tbCheckAlarmStatusNodeConfig, tbCheckAlarmStatusNodeConfig2);
    int expectedHashCodeResult = tbCheckAlarmStatusNodeConfig.hashCode();
    assertEquals(expectedHashCodeResult, tbCheckAlarmStatusNodeConfig2.hashCode());
  }

  /**
   * Test {@link TbCheckAlarmStatusNodeConfig#equals(Object)}, and
   * {@link TbCheckAlarmStatusNodeConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbCheckAlarmStatusNodeConfig#equals(Object)}
   *   <li>{@link TbCheckAlarmStatusNodeConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbCheckAlarmStatusNodeConfig tbCheckAlarmStatusNodeConfig = new TbCheckAlarmStatusNodeConfig();
    tbCheckAlarmStatusNodeConfig.setAlarmStatusList(new ArrayList<>());

    TbCheckAlarmStatusNodeConfig tbCheckAlarmStatusNodeConfig2 = new TbCheckAlarmStatusNodeConfig();
    tbCheckAlarmStatusNodeConfig2.setAlarmStatusList(new ArrayList<>());

    // Act and Assert
    assertEquals(tbCheckAlarmStatusNodeConfig, tbCheckAlarmStatusNodeConfig2);
    int expectedHashCodeResult = tbCheckAlarmStatusNodeConfig.hashCode();
    assertEquals(expectedHashCodeResult, tbCheckAlarmStatusNodeConfig2.hashCode());
  }

  /**
   * Test {@link TbCheckAlarmStatusNodeConfig#equals(Object)}, and
   * {@link TbCheckAlarmStatusNodeConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbCheckAlarmStatusNodeConfig#equals(Object)}
   *   <li>{@link TbCheckAlarmStatusNodeConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbCheckAlarmStatusNodeConfig tbCheckAlarmStatusNodeConfig = new TbCheckAlarmStatusNodeConfig();

    // Act and Assert
    assertEquals(tbCheckAlarmStatusNodeConfig, tbCheckAlarmStatusNodeConfig);
    int expectedHashCodeResult = tbCheckAlarmStatusNodeConfig.hashCode();
    assertEquals(expectedHashCodeResult, tbCheckAlarmStatusNodeConfig.hashCode());
  }

  /**
   * Test {@link TbCheckAlarmStatusNodeConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbCheckAlarmStatusNodeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbCheckAlarmStatusNodeConfig(), 1);
  }

  /**
   * Test {@link TbCheckAlarmStatusNodeConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbCheckAlarmStatusNodeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbCheckAlarmStatusNodeConfig tbCheckAlarmStatusNodeConfig = new TbCheckAlarmStatusNodeConfig();
    tbCheckAlarmStatusNodeConfig.setAlarmStatusList(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tbCheckAlarmStatusNodeConfig, new TbCheckAlarmStatusNodeConfig());
  }

  /**
   * Test {@link TbCheckAlarmStatusNodeConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbCheckAlarmStatusNodeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbCheckAlarmStatusNodeConfig tbCheckAlarmStatusNodeConfig = new TbCheckAlarmStatusNodeConfig();

    TbCheckAlarmStatusNodeConfig tbCheckAlarmStatusNodeConfig2 = new TbCheckAlarmStatusNodeConfig();
    tbCheckAlarmStatusNodeConfig2.setAlarmStatusList(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tbCheckAlarmStatusNodeConfig, tbCheckAlarmStatusNodeConfig2);
  }

  /**
   * Test {@link TbCheckAlarmStatusNodeConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbCheckAlarmStatusNodeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbCheckAlarmStatusNodeConfig(), null);
  }

  /**
   * Test {@link TbCheckAlarmStatusNodeConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbCheckAlarmStatusNodeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbCheckAlarmStatusNodeConfig(), "Different type to TbCheckAlarmStatusNodeConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TbCheckAlarmStatusNodeConfig}
   *   <li>{@link TbCheckAlarmStatusNodeConfig#setAlarmStatusList(List)}
   *   <li>{@link TbCheckAlarmStatusNodeConfig#toString()}
   *   <li>{@link TbCheckAlarmStatusNodeConfig#getAlarmStatusList()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbCheckAlarmStatusNodeConfig actualTbCheckAlarmStatusNodeConfig = new TbCheckAlarmStatusNodeConfig();
    ArrayList<AlarmStatus> alarmStatusList = new ArrayList<>();
    actualTbCheckAlarmStatusNodeConfig.setAlarmStatusList(alarmStatusList);
    String actualToStringResult = actualTbCheckAlarmStatusNodeConfig.toString();
    List<AlarmStatus> actualAlarmStatusList = actualTbCheckAlarmStatusNodeConfig.getAlarmStatusList();

    // Assert that nothing has changed
    assertEquals("TbCheckAlarmStatusNodeConfig(alarmStatusList=[])", actualToStringResult);
    assertTrue(actualAlarmStatusList.isEmpty());
    assertSame(alarmStatusList, actualAlarmStatusList);
  }
}
