package org.thingsboard.server.transport.mqtt.util.sparkplug;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.exception.ThingsboardException;

class SparkplugMessageTypeDiffblueTest {
  /**
   * Test {@link SparkplugMessageType#isBirth()}.
   * <ul>
   *   <li>Given {@code DBIRTH}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMessageType#isBirth()}
   */
  @Test
  @DisplayName("Test isBirth(); given 'DBIRTH'; then return 'true'")
  void testIsBirth_givenDbirth_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SparkplugMessageType.DBIRTH.isBirth());
  }

  /**
   * Test {@link SparkplugMessageType#isBirth()}.
   * <ul>
   *   <li>Given {@code NBIRTH}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMessageType#isBirth()}
   */
  @Test
  @DisplayName("Test isBirth(); given 'NBIRTH'; then return 'true'")
  void testIsBirth_givenNbirth_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SparkplugMessageType.NBIRTH.isBirth());
  }

  /**
   * Test {@link SparkplugMessageType#isBirth()}.
   * <ul>
   *   <li>Given {@code NDEATH}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMessageType#isBirth()}
   */
  @Test
  @DisplayName("Test isBirth(); given 'NDEATH'; then return 'false'")
  void testIsBirth_givenNdeath_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SparkplugMessageType.NDEATH.isBirth());
  }

  /**
   * Test {@link SparkplugMessageType#isCommand()}.
   * <ul>
   *   <li>Given {@code DCMD}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMessageType#isCommand()}
   */
  @Test
  @DisplayName("Test isCommand(); given 'DCMD'; then return 'true'")
  void testIsCommand_givenDcmd_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SparkplugMessageType.DCMD.isCommand());
  }

  /**
   * Test {@link SparkplugMessageType#isCommand()}.
   * <ul>
   *   <li>Given {@code NBIRTH}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMessageType#isCommand()}
   */
  @Test
  @DisplayName("Test isCommand(); given 'NBIRTH'; then return 'false'")
  void testIsCommand_givenNbirth_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SparkplugMessageType.NBIRTH.isCommand());
  }

  /**
   * Test {@link SparkplugMessageType#isCommand()}.
   * <ul>
   *   <li>Given {@code NCMD}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMessageType#isCommand()}
   */
  @Test
  @DisplayName("Test isCommand(); given 'NCMD'; then return 'true'")
  void testIsCommand_givenNcmd_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SparkplugMessageType.NCMD.isCommand());
  }

  /**
   * Test {@link SparkplugMessageType#isData()}.
   * <ul>
   *   <li>Given {@code DDATA}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMessageType#isData()}
   */
  @Test
  @DisplayName("Test isData(); given 'DDATA'; then return 'true'")
  void testIsData_givenDdata_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SparkplugMessageType.DDATA.isData());
  }

  /**
   * Test {@link SparkplugMessageType#isData()}.
   * <ul>
   *   <li>Given {@code NBIRTH}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMessageType#isData()}
   */
  @Test
  @DisplayName("Test isData(); given 'NBIRTH'; then return 'false'")
  void testIsData_givenNbirth_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SparkplugMessageType.NBIRTH.isData());
  }

  /**
   * Test {@link SparkplugMessageType#isData()}.
   * <ul>
   *   <li>Given {@code NDATA}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMessageType#isData()}
   */
  @Test
  @DisplayName("Test isData(); given 'NDATA'; then return 'true'")
  void testIsData_givenNdata_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SparkplugMessageType.NDATA.isData());
  }

  /**
   * Test {@link SparkplugMessageType#isDeath()}.
   * <ul>
   *   <li>Given {@code DDEATH}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMessageType#isDeath()}
   */
  @Test
  @DisplayName("Test isDeath(); given 'DDEATH'; then return 'true'")
  void testIsDeath_givenDdeath_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SparkplugMessageType.DDEATH.isDeath());
  }

  /**
   * Test {@link SparkplugMessageType#isDeath()}.
   * <ul>
   *   <li>Given {@code NBIRTH}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMessageType#isDeath()}
   */
  @Test
  @DisplayName("Test isDeath(); given 'NBIRTH'; then return 'false'")
  void testIsDeath_givenNbirth_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SparkplugMessageType.NBIRTH.isDeath());
  }

  /**
   * Test {@link SparkplugMessageType#isDeath()}.
   * <ul>
   *   <li>Given {@code NDEATH}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMessageType#isDeath()}
   */
  @Test
  @DisplayName("Test isDeath(); given 'NDEATH'; then return 'true'")
  void testIsDeath_givenNdeath_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SparkplugMessageType.NDEATH.isDeath());
  }

  /**
   * Test {@link SparkplugMessageType#isRecord()}.
   * <ul>
   *   <li>Given {@code DRECORD}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMessageType#isRecord()}
   */
  @Test
  @DisplayName("Test isRecord(); given 'DRECORD'; then return 'true'")
  void testIsRecord_givenDrecord_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SparkplugMessageType.DRECORD.isRecord());
  }

  /**
   * Test {@link SparkplugMessageType#isRecord()}.
   * <ul>
   *   <li>Given {@code NBIRTH}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMessageType#isRecord()}
   */
  @Test
  @DisplayName("Test isRecord(); given 'NBIRTH'; then return 'false'")
  void testIsRecord_givenNbirth_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SparkplugMessageType.NBIRTH.isRecord());
  }

  /**
   * Test {@link SparkplugMessageType#isRecord()}.
   * <ul>
   *   <li>Given {@code NRECORD}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMessageType#isRecord()}
   */
  @Test
  @DisplayName("Test isRecord(); given 'NRECORD'; then return 'true'")
  void testIsRecord_givenNrecord_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SparkplugMessageType.NRECORD.isRecord());
  }

  /**
   * Test {@link SparkplugMessageType#messageName(SparkplugMessageType)}.
   * <ul>
   *   <li>When {@code NBIRTH}.</li>
   *   <li>Then return {@code NBIRTH}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMessageType#messageName(SparkplugMessageType)}
   */
  @Test
  @DisplayName("Test messageName(SparkplugMessageType); when 'NBIRTH'; then return 'NBIRTH'")
  void testMessageName_whenNbirth_thenReturnNbirth() {
    // Arrange, Act and Assert
    assertEquals("NBIRTH", SparkplugMessageType.messageName(SparkplugMessageType.NBIRTH));
  }

  /**
   * Test {@link SparkplugMessageType#messageName(SparkplugMessageType)}.
   * <ul>
   *   <li>When {@code STATE}.</li>
   *   <li>Then return {@code sparkplugConnectionState}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMessageType#messageName(SparkplugMessageType)}
   */
  @Test
  @DisplayName("Test messageName(SparkplugMessageType); when 'STATE'; then return 'sparkplugConnectionState'")
  void testMessageName_whenState_thenReturnSparkplugConnectionState() {
    // Arrange, Act and Assert
    assertEquals("sparkplugConnectionState", SparkplugMessageType.messageName(SparkplugMessageType.STATE));
  }

  /**
   * Test {@link SparkplugMessageType#parseMessageType(String)}.
   * <ul>
   *   <li>When {@code NBIRTH}.</li>
   *   <li>Then return {@code NBIRTH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMessageType#parseMessageType(String)}
   */
  @Test
  @DisplayName("Test parseMessageType(String); when 'NBIRTH'; then return 'NBIRTH'")
  void testParseMessageType_whenNbirth_thenReturnNbirth() throws ThingsboardException {
    // Arrange, Act and Assert
    assertEquals(SparkplugMessageType.NBIRTH, SparkplugMessageType.parseMessageType("NBIRTH"));
  }

  /**
   * Test {@link SparkplugMessageType#parseMessageType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugMessageType#parseMessageType(String)}
   */
  @Test
  @DisplayName("Test parseMessageType(String); when 'Type'; then throw ThingsboardException")
  void testParseMessageType_whenType_thenThrowThingsboardException() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> SparkplugMessageType.parseMessageType("Type"));
  }
}
