package org.thingsboard.server.service.ws.telemetry.cmd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.service.ws.WsCommandsWrapper;
import org.thingsboard.server.service.ws.telemetry.cmd.v1.AttributesSubscriptionCmd;
import org.thingsboard.server.service.ws.telemetry.cmd.v1.GetHistoryCmd;
import org.thingsboard.server.service.ws.telemetry.cmd.v1.TimeseriesSubscriptionCmd;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.AlarmCountCmd;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.AlarmCountUnsubscribeCmd;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.AlarmDataCmd;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.AlarmDataUnsubscribeCmd;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.EntityCountCmd;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.EntityCountUnsubscribeCmd;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.EntityDataCmd;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.EntityDataUnsubscribeCmd;

@ContextConfiguration(classes = {TelemetryCmdsWrapper.class})
@ExtendWith(SpringExtension.class)
class TelemetryCmdsWrapperDiffblueTest {
  @Autowired
  private TelemetryCmdsWrapper telemetryCmdsWrapper;

  /**
   * Test {@link TelemetryCmdsWrapper#toCommonCmdsWrapper()}.
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#toCommonCmdsWrapper()}
   */
  @Test
  @DisplayName("Test toCommonCmdsWrapper()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WsCommandsWrapper TelemetryCmdsWrapper.toCommonCmdsWrapper()"})
  void testToCommonCmdsWrapper() {
    // Arrange and Act
    WsCommandsWrapper actualToCommonCmdsWrapperResult = telemetryCmdsWrapper.toCommonCmdsWrapper();

    // Assert
    assertNull(actualToCommonCmdsWrapperResult.getAuthCmd());
    assertTrue(actualToCommonCmdsWrapperResult.getCmds().isEmpty());
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}, and {@link TelemetryCmdsWrapper#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TelemetryCmdsWrapper#equals(Object)}
   *   <li>{@link TelemetryCmdsWrapper#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TelemetryCmdsWrapper telemetryCmdsWrapper = new TelemetryCmdsWrapper();
    TelemetryCmdsWrapper telemetryCmdsWrapper2 = new TelemetryCmdsWrapper();

    // Act and Assert
    assertEquals(telemetryCmdsWrapper, telemetryCmdsWrapper2);
    int expectedHashCodeResult = telemetryCmdsWrapper.hashCode();
    assertEquals(expectedHashCodeResult, telemetryCmdsWrapper2.hashCode());
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}, and {@link TelemetryCmdsWrapper#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TelemetryCmdsWrapper#equals(Object)}
   *   <li>{@link TelemetryCmdsWrapper#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TelemetryCmdsWrapper telemetryCmdsWrapper = new TelemetryCmdsWrapper();

    // Act and Assert
    assertEquals(telemetryCmdsWrapper, telemetryCmdsWrapper);
    int expectedHashCodeResult = telemetryCmdsWrapper.hashCode();
    assertEquals(expectedHashCodeResult, telemetryCmdsWrapper.hashCode());
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TelemetryCmdsWrapper(), 1);
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TelemetryCmdsWrapper telemetryCmdsWrapper = new TelemetryCmdsWrapper();
    telemetryCmdsWrapper.setAttrSubCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(telemetryCmdsWrapper, new TelemetryCmdsWrapper());
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TelemetryCmdsWrapper telemetryCmdsWrapper = new TelemetryCmdsWrapper();
    telemetryCmdsWrapper.setTsSubCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(telemetryCmdsWrapper, new TelemetryCmdsWrapper());
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TelemetryCmdsWrapper telemetryCmdsWrapper = new TelemetryCmdsWrapper();
    telemetryCmdsWrapper.setHistoryCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(telemetryCmdsWrapper, new TelemetryCmdsWrapper());
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TelemetryCmdsWrapper telemetryCmdsWrapper = new TelemetryCmdsWrapper();
    telemetryCmdsWrapper.setEntityDataCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(telemetryCmdsWrapper, new TelemetryCmdsWrapper());
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TelemetryCmdsWrapper telemetryCmdsWrapper = new TelemetryCmdsWrapper();
    telemetryCmdsWrapper.setEntityDataUnsubscribeCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(telemetryCmdsWrapper, new TelemetryCmdsWrapper());
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TelemetryCmdsWrapper telemetryCmdsWrapper = new TelemetryCmdsWrapper();
    telemetryCmdsWrapper.setAlarmDataCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(telemetryCmdsWrapper, new TelemetryCmdsWrapper());
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TelemetryCmdsWrapper telemetryCmdsWrapper = new TelemetryCmdsWrapper();
    telemetryCmdsWrapper.setAlarmDataUnsubscribeCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(telemetryCmdsWrapper, new TelemetryCmdsWrapper());
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TelemetryCmdsWrapper telemetryCmdsWrapper = new TelemetryCmdsWrapper();
    telemetryCmdsWrapper.setEntityCountCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(telemetryCmdsWrapper, new TelemetryCmdsWrapper());
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TelemetryCmdsWrapper telemetryCmdsWrapper = new TelemetryCmdsWrapper();
    telemetryCmdsWrapper.setEntityCountUnsubscribeCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(telemetryCmdsWrapper, new TelemetryCmdsWrapper());
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TelemetryCmdsWrapper telemetryCmdsWrapper = new TelemetryCmdsWrapper();
    telemetryCmdsWrapper.setAlarmCountCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(telemetryCmdsWrapper, new TelemetryCmdsWrapper());
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TelemetryCmdsWrapper telemetryCmdsWrapper = new TelemetryCmdsWrapper();
    telemetryCmdsWrapper.setAlarmCountUnsubscribeCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(telemetryCmdsWrapper, new TelemetryCmdsWrapper());
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TelemetryCmdsWrapper telemetryCmdsWrapper = new TelemetryCmdsWrapper();

    TelemetryCmdsWrapper telemetryCmdsWrapper2 = new TelemetryCmdsWrapper();
    telemetryCmdsWrapper2.setAttrSubCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(telemetryCmdsWrapper, telemetryCmdsWrapper2);
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TelemetryCmdsWrapper telemetryCmdsWrapper = new TelemetryCmdsWrapper();

    TelemetryCmdsWrapper telemetryCmdsWrapper2 = new TelemetryCmdsWrapper();
    telemetryCmdsWrapper2.setTsSubCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(telemetryCmdsWrapper, telemetryCmdsWrapper2);
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    TelemetryCmdsWrapper telemetryCmdsWrapper = new TelemetryCmdsWrapper();

    TelemetryCmdsWrapper telemetryCmdsWrapper2 = new TelemetryCmdsWrapper();
    telemetryCmdsWrapper2.setHistoryCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(telemetryCmdsWrapper, telemetryCmdsWrapper2);
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    TelemetryCmdsWrapper telemetryCmdsWrapper = new TelemetryCmdsWrapper();

    TelemetryCmdsWrapper telemetryCmdsWrapper2 = new TelemetryCmdsWrapper();
    telemetryCmdsWrapper2.setEntityDataCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(telemetryCmdsWrapper, telemetryCmdsWrapper2);
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    TelemetryCmdsWrapper telemetryCmdsWrapper = new TelemetryCmdsWrapper();

    TelemetryCmdsWrapper telemetryCmdsWrapper2 = new TelemetryCmdsWrapper();
    telemetryCmdsWrapper2.setEntityDataUnsubscribeCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(telemetryCmdsWrapper, telemetryCmdsWrapper2);
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    TelemetryCmdsWrapper telemetryCmdsWrapper = new TelemetryCmdsWrapper();

    TelemetryCmdsWrapper telemetryCmdsWrapper2 = new TelemetryCmdsWrapper();
    telemetryCmdsWrapper2.setAlarmDataCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(telemetryCmdsWrapper, telemetryCmdsWrapper2);
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    TelemetryCmdsWrapper telemetryCmdsWrapper = new TelemetryCmdsWrapper();

    TelemetryCmdsWrapper telemetryCmdsWrapper2 = new TelemetryCmdsWrapper();
    telemetryCmdsWrapper2.setAlarmDataUnsubscribeCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(telemetryCmdsWrapper, telemetryCmdsWrapper2);
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    TelemetryCmdsWrapper telemetryCmdsWrapper = new TelemetryCmdsWrapper();

    TelemetryCmdsWrapper telemetryCmdsWrapper2 = new TelemetryCmdsWrapper();
    telemetryCmdsWrapper2.setEntityCountCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(telemetryCmdsWrapper, telemetryCmdsWrapper2);
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    TelemetryCmdsWrapper telemetryCmdsWrapper = new TelemetryCmdsWrapper();

    TelemetryCmdsWrapper telemetryCmdsWrapper2 = new TelemetryCmdsWrapper();
    telemetryCmdsWrapper2.setEntityCountUnsubscribeCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(telemetryCmdsWrapper, telemetryCmdsWrapper2);
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    TelemetryCmdsWrapper telemetryCmdsWrapper = new TelemetryCmdsWrapper();

    TelemetryCmdsWrapper telemetryCmdsWrapper2 = new TelemetryCmdsWrapper();
    telemetryCmdsWrapper2.setAlarmCountCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(telemetryCmdsWrapper, telemetryCmdsWrapper2);
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    TelemetryCmdsWrapper telemetryCmdsWrapper = new TelemetryCmdsWrapper();

    TelemetryCmdsWrapper telemetryCmdsWrapper2 = new TelemetryCmdsWrapper();
    telemetryCmdsWrapper2.setAlarmCountUnsubscribeCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(telemetryCmdsWrapper, telemetryCmdsWrapper2);
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TelemetryCmdsWrapper(), null);
  }

  /**
   * Test {@link TelemetryCmdsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryCmdsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryCmdsWrapper.equals(Object)", "int TelemetryCmdsWrapper.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TelemetryCmdsWrapper(), "Different type to TelemetryCmdsWrapper");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TelemetryCmdsWrapper}
   *   <li>{@link TelemetryCmdsWrapper#setAlarmCountCmds(List)}
   *   <li>{@link TelemetryCmdsWrapper#setAlarmCountUnsubscribeCmds(List)}
   *   <li>{@link TelemetryCmdsWrapper#setAlarmDataCmds(List)}
   *   <li>{@link TelemetryCmdsWrapper#setAlarmDataUnsubscribeCmds(List)}
   *   <li>{@link TelemetryCmdsWrapper#setAttrSubCmds(List)}
   *   <li>{@link TelemetryCmdsWrapper#setEntityCountCmds(List)}
   *   <li>{@link TelemetryCmdsWrapper#setEntityCountUnsubscribeCmds(List)}
   *   <li>{@link TelemetryCmdsWrapper#setEntityDataCmds(List)}
   *   <li>{@link TelemetryCmdsWrapper#setEntityDataUnsubscribeCmds(List)}
   *   <li>{@link TelemetryCmdsWrapper#setHistoryCmds(List)}
   *   <li>{@link TelemetryCmdsWrapper#setTsSubCmds(List)}
   *   <li>{@link TelemetryCmdsWrapper#toString()}
   *   <li>{@link TelemetryCmdsWrapper#getAlarmCountCmds()}
   *   <li>{@link TelemetryCmdsWrapper#getAlarmCountUnsubscribeCmds()}
   *   <li>{@link TelemetryCmdsWrapper#getAlarmDataCmds()}
   *   <li>{@link TelemetryCmdsWrapper#getAlarmDataUnsubscribeCmds()}
   *   <li>{@link TelemetryCmdsWrapper#getAttrSubCmds()}
   *   <li>{@link TelemetryCmdsWrapper#getEntityCountCmds()}
   *   <li>{@link TelemetryCmdsWrapper#getEntityCountUnsubscribeCmds()}
   *   <li>{@link TelemetryCmdsWrapper#getEntityDataCmds()}
   *   <li>{@link TelemetryCmdsWrapper#getEntityDataUnsubscribeCmds()}
   *   <li>{@link TelemetryCmdsWrapper#getHistoryCmds()}
   *   <li>{@link TelemetryCmdsWrapper#getTsSubCmds()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TelemetryCmdsWrapper.<init>()", "List TelemetryCmdsWrapper.getAlarmCountCmds()",
      "List TelemetryCmdsWrapper.getAlarmCountUnsubscribeCmds()", "List TelemetryCmdsWrapper.getAlarmDataCmds()",
      "List TelemetryCmdsWrapper.getAlarmDataUnsubscribeCmds()", "List TelemetryCmdsWrapper.getAttrSubCmds()",
      "List TelemetryCmdsWrapper.getEntityCountCmds()", "List TelemetryCmdsWrapper.getEntityCountUnsubscribeCmds()",
      "List TelemetryCmdsWrapper.getEntityDataCmds()", "List TelemetryCmdsWrapper.getEntityDataUnsubscribeCmds()",
      "List TelemetryCmdsWrapper.getHistoryCmds()", "List TelemetryCmdsWrapper.getTsSubCmds()",
      "void TelemetryCmdsWrapper.setAlarmCountCmds(List)",
      "void TelemetryCmdsWrapper.setAlarmCountUnsubscribeCmds(List)",
      "void TelemetryCmdsWrapper.setAlarmDataCmds(List)", "void TelemetryCmdsWrapper.setAlarmDataUnsubscribeCmds(List)",
      "void TelemetryCmdsWrapper.setAttrSubCmds(List)", "void TelemetryCmdsWrapper.setEntityCountCmds(List)",
      "void TelemetryCmdsWrapper.setEntityCountUnsubscribeCmds(List)",
      "void TelemetryCmdsWrapper.setEntityDataCmds(List)",
      "void TelemetryCmdsWrapper.setEntityDataUnsubscribeCmds(List)", "void TelemetryCmdsWrapper.setHistoryCmds(List)",
      "void TelemetryCmdsWrapper.setTsSubCmds(List)", "String TelemetryCmdsWrapper.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TelemetryCmdsWrapper actualTelemetryCmdsWrapper = new TelemetryCmdsWrapper();
    ArrayList<AlarmCountCmd> alarmCountCmds = new ArrayList<>();
    actualTelemetryCmdsWrapper.setAlarmCountCmds(alarmCountCmds);
    ArrayList<AlarmCountUnsubscribeCmd> alarmCountUnsubscribeCmds = new ArrayList<>();
    actualTelemetryCmdsWrapper.setAlarmCountUnsubscribeCmds(alarmCountUnsubscribeCmds);
    ArrayList<AlarmDataCmd> alarmDataCmds = new ArrayList<>();
    actualTelemetryCmdsWrapper.setAlarmDataCmds(alarmDataCmds);
    ArrayList<AlarmDataUnsubscribeCmd> alarmDataUnsubscribeCmds = new ArrayList<>();
    actualTelemetryCmdsWrapper.setAlarmDataUnsubscribeCmds(alarmDataUnsubscribeCmds);
    ArrayList<AttributesSubscriptionCmd> attrSubCmds = new ArrayList<>();
    actualTelemetryCmdsWrapper.setAttrSubCmds(attrSubCmds);
    ArrayList<EntityCountCmd> entityCountCmds = new ArrayList<>();
    actualTelemetryCmdsWrapper.setEntityCountCmds(entityCountCmds);
    ArrayList<EntityCountUnsubscribeCmd> entityCountUnsubscribeCmds = new ArrayList<>();
    actualTelemetryCmdsWrapper.setEntityCountUnsubscribeCmds(entityCountUnsubscribeCmds);
    ArrayList<EntityDataCmd> entityDataCmds = new ArrayList<>();
    actualTelemetryCmdsWrapper.setEntityDataCmds(entityDataCmds);
    ArrayList<EntityDataUnsubscribeCmd> entityDataUnsubscribeCmds = new ArrayList<>();
    actualTelemetryCmdsWrapper.setEntityDataUnsubscribeCmds(entityDataUnsubscribeCmds);
    ArrayList<GetHistoryCmd> historyCmds = new ArrayList<>();
    actualTelemetryCmdsWrapper.setHistoryCmds(historyCmds);
    ArrayList<TimeseriesSubscriptionCmd> tsSubCmds = new ArrayList<>();
    actualTelemetryCmdsWrapper.setTsSubCmds(tsSubCmds);
    String actualToStringResult = actualTelemetryCmdsWrapper.toString();
    List<AlarmCountCmd> actualAlarmCountCmds = actualTelemetryCmdsWrapper.getAlarmCountCmds();
    List<AlarmCountUnsubscribeCmd> actualAlarmCountUnsubscribeCmds = actualTelemetryCmdsWrapper
        .getAlarmCountUnsubscribeCmds();
    List<AlarmDataCmd> actualAlarmDataCmds = actualTelemetryCmdsWrapper.getAlarmDataCmds();
    List<AlarmDataUnsubscribeCmd> actualAlarmDataUnsubscribeCmds = actualTelemetryCmdsWrapper
        .getAlarmDataUnsubscribeCmds();
    List<AttributesSubscriptionCmd> actualAttrSubCmds = actualTelemetryCmdsWrapper.getAttrSubCmds();
    List<EntityCountCmd> actualEntityCountCmds = actualTelemetryCmdsWrapper.getEntityCountCmds();
    List<EntityCountUnsubscribeCmd> actualEntityCountUnsubscribeCmds = actualTelemetryCmdsWrapper
        .getEntityCountUnsubscribeCmds();
    List<EntityDataCmd> actualEntityDataCmds = actualTelemetryCmdsWrapper.getEntityDataCmds();
    List<EntityDataUnsubscribeCmd> actualEntityDataUnsubscribeCmds = actualTelemetryCmdsWrapper
        .getEntityDataUnsubscribeCmds();
    List<GetHistoryCmd> actualHistoryCmds = actualTelemetryCmdsWrapper.getHistoryCmds();
    List<TimeseriesSubscriptionCmd> actualTsSubCmds = actualTelemetryCmdsWrapper.getTsSubCmds();

    // Assert
    assertEquals("TelemetryCmdsWrapper(attrSubCmds=[], tsSubCmds=[], historyCmds=[], entityDataCmds=[], entityDataUnsu"
        + "bscribeCmds=[], alarmDataCmds=[], alarmDataUnsubscribeCmds=[], entityCountCmds=[], entityCountUnsubscribeCmds"
        + "=[], alarmCountCmds=[], alarmCountUnsubscribeCmds=[])", actualToStringResult);
    assertTrue(actualAlarmCountCmds.isEmpty());
    assertTrue(actualAlarmCountUnsubscribeCmds.isEmpty());
    assertTrue(actualAlarmDataCmds.isEmpty());
    assertTrue(actualAlarmDataUnsubscribeCmds.isEmpty());
    assertTrue(actualAttrSubCmds.isEmpty());
    assertTrue(actualEntityCountCmds.isEmpty());
    assertTrue(actualEntityCountUnsubscribeCmds.isEmpty());
    assertTrue(actualEntityDataCmds.isEmpty());
    assertTrue(actualEntityDataUnsubscribeCmds.isEmpty());
    assertTrue(actualHistoryCmds.isEmpty());
    assertTrue(actualTsSubCmds.isEmpty());
    assertSame(alarmCountCmds, actualAlarmCountCmds);
    assertSame(alarmCountUnsubscribeCmds, actualAlarmCountUnsubscribeCmds);
    assertSame(alarmDataCmds, actualAlarmDataCmds);
    assertSame(alarmDataUnsubscribeCmds, actualAlarmDataUnsubscribeCmds);
    assertSame(attrSubCmds, actualAttrSubCmds);
    assertSame(entityCountCmds, actualEntityCountCmds);
    assertSame(entityCountUnsubscribeCmds, actualEntityCountUnsubscribeCmds);
    assertSame(entityDataCmds, actualEntityDataCmds);
    assertSame(entityDataUnsubscribeCmds, actualEntityDataUnsubscribeCmds);
    assertSame(historyCmds, actualHistoryCmds);
    assertSame(tsSubCmds, actualTsSubCmds);
  }
}
