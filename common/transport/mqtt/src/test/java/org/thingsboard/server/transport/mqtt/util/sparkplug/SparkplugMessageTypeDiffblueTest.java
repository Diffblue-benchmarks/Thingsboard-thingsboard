/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.transport.mqtt.util.sparkplug;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.exception.ThingsboardException;

class SparkplugMessageTypeDiffblueTest {
  /**
   * Test {@link SparkplugMessageType#parseMessageType(String)}.
   *
   * <ul>
   *   <li>When {@code NBIRTH}.
   *   <li>Then return {@code NBIRTH}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMessageType#parseMessageType(String)}
   */
  @Test
  @DisplayName("Test parseMessageType(String); when 'NBIRTH'; then return 'NBIRTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SparkplugMessageType SparkplugMessageType.parseMessageType(String)"})
  void testParseMessageType_whenNbirth_thenReturnNbirth() throws ThingsboardException {
    // Arrange, Act and Assert
    assertEquals(SparkplugMessageType.NBIRTH, SparkplugMessageType.parseMessageType("NBIRTH"));
  }

  /**
   * Test {@link SparkplugMessageType#parseMessageType(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMessageType#parseMessageType(String)}
   */
  @Test
  @DisplayName("Test parseMessageType(String); when 'Type'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SparkplugMessageType SparkplugMessageType.parseMessageType(String)"})
  void testParseMessageType_whenType_thenThrowThingsboardException() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> SparkplugMessageType.parseMessageType("Type"));
  }

  /**
   * Test {@link SparkplugMessageType#messageName(SparkplugMessageType)}.
   *
   * <ul>
   *   <li>When {@code NBIRTH}.
   *   <li>Then return {@code NBIRTH}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMessageType#messageName(SparkplugMessageType)}
   */
  @Test
  @DisplayName("Test messageName(SparkplugMessageType); when 'NBIRTH'; then return 'NBIRTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SparkplugMessageType.messageName(SparkplugMessageType)"})
  void testMessageName_whenNbirth_thenReturnNbirth() {
    // Arrange, Act and Assert
    assertEquals("NBIRTH", SparkplugMessageType.messageName(SparkplugMessageType.NBIRTH));
  }

  /**
   * Test {@link SparkplugMessageType#messageName(SparkplugMessageType)}.
   *
   * <ul>
   *   <li>When {@code STATE}.
   *   <li>Then return {@code sparkplugConnectionState}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMessageType#messageName(SparkplugMessageType)}
   */
  @Test
  @DisplayName(
      "Test messageName(SparkplugMessageType); when 'STATE'; then return 'sparkplugConnectionState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SparkplugMessageType.messageName(SparkplugMessageType)"})
  void testMessageName_whenState_thenReturnSparkplugConnectionState() {
    // Arrange, Act and Assert
    assertEquals(
        "sparkplugConnectionState", SparkplugMessageType.messageName(SparkplugMessageType.STATE));
  }

  /**
   * Test {@link SparkplugMessageType#isDeath()}.
   *
   * <ul>
   *   <li>Given {@code DDEATH}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMessageType#isDeath()}
   */
  @Test
  @DisplayName("Test isDeath(); given 'DDEATH'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SparkplugMessageType.isDeath()"})
  void testIsDeath_givenDdeath_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SparkplugMessageType.DDEATH.isDeath());
  }

  /**
   * Test {@link SparkplugMessageType#isDeath()}.
   *
   * <ul>
   *   <li>Given {@code NBIRTH}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMessageType#isDeath()}
   */
  @Test
  @DisplayName("Test isDeath(); given 'NBIRTH'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SparkplugMessageType.isDeath()"})
  void testIsDeath_givenNbirth_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SparkplugMessageType.NBIRTH.isDeath());
  }

  /**
   * Test {@link SparkplugMessageType#isDeath()}.
   *
   * <ul>
   *   <li>Given {@code NDEATH}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMessageType#isDeath()}
   */
  @Test
  @DisplayName("Test isDeath(); given 'NDEATH'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SparkplugMessageType.isDeath()"})
  void testIsDeath_givenNdeath_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SparkplugMessageType.NDEATH.isDeath());
  }

  /**
   * Test {@link SparkplugMessageType#isCommand()}.
   *
   * <ul>
   *   <li>Given {@code DCMD}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMessageType#isCommand()}
   */
  @Test
  @DisplayName("Test isCommand(); given 'DCMD'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SparkplugMessageType.isCommand()"})
  void testIsCommand_givenDcmd_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SparkplugMessageType.DCMD.isCommand());
  }

  /**
   * Test {@link SparkplugMessageType#isCommand()}.
   *
   * <ul>
   *   <li>Given {@code NBIRTH}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMessageType#isCommand()}
   */
  @Test
  @DisplayName("Test isCommand(); given 'NBIRTH'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SparkplugMessageType.isCommand()"})
  void testIsCommand_givenNbirth_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SparkplugMessageType.NBIRTH.isCommand());
  }

  /**
   * Test {@link SparkplugMessageType#isCommand()}.
   *
   * <ul>
   *   <li>Given {@code NCMD}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMessageType#isCommand()}
   */
  @Test
  @DisplayName("Test isCommand(); given 'NCMD'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SparkplugMessageType.isCommand()"})
  void testIsCommand_givenNcmd_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SparkplugMessageType.NCMD.isCommand());
  }

  /**
   * Test {@link SparkplugMessageType#isData()}.
   *
   * <ul>
   *   <li>Given {@code DDATA}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMessageType#isData()}
   */
  @Test
  @DisplayName("Test isData(); given 'DDATA'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SparkplugMessageType.isData()"})
  void testIsData_givenDdata_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SparkplugMessageType.DDATA.isData());
  }

  /**
   * Test {@link SparkplugMessageType#isData()}.
   *
   * <ul>
   *   <li>Given {@code NBIRTH}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMessageType#isData()}
   */
  @Test
  @DisplayName("Test isData(); given 'NBIRTH'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SparkplugMessageType.isData()"})
  void testIsData_givenNbirth_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SparkplugMessageType.NBIRTH.isData());
  }

  /**
   * Test {@link SparkplugMessageType#isData()}.
   *
   * <ul>
   *   <li>Given {@code NDATA}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMessageType#isData()}
   */
  @Test
  @DisplayName("Test isData(); given 'NDATA'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SparkplugMessageType.isData()"})
  void testIsData_givenNdata_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SparkplugMessageType.NDATA.isData());
  }

  /**
   * Test {@link SparkplugMessageType#isBirth()}.
   *
   * <ul>
   *   <li>Given {@code DBIRTH}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMessageType#isBirth()}
   */
  @Test
  @DisplayName("Test isBirth(); given 'DBIRTH'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SparkplugMessageType.isBirth()"})
  void testIsBirth_givenDbirth_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SparkplugMessageType.DBIRTH.isBirth());
  }

  /**
   * Test {@link SparkplugMessageType#isBirth()}.
   *
   * <ul>
   *   <li>Given {@code NBIRTH}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMessageType#isBirth()}
   */
  @Test
  @DisplayName("Test isBirth(); given 'NBIRTH'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SparkplugMessageType.isBirth()"})
  void testIsBirth_givenNbirth_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SparkplugMessageType.NBIRTH.isBirth());
  }

  /**
   * Test {@link SparkplugMessageType#isBirth()}.
   *
   * <ul>
   *   <li>Given {@code NDEATH}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMessageType#isBirth()}
   */
  @Test
  @DisplayName("Test isBirth(); given 'NDEATH'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SparkplugMessageType.isBirth()"})
  void testIsBirth_givenNdeath_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SparkplugMessageType.NDEATH.isBirth());
  }

  /**
   * Test {@link SparkplugMessageType#isRecord()}.
   *
   * <ul>
   *   <li>Given {@code DRECORD}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMessageType#isRecord()}
   */
  @Test
  @DisplayName("Test isRecord(); given 'DRECORD'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SparkplugMessageType.isRecord()"})
  void testIsRecord_givenDrecord_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SparkplugMessageType.DRECORD.isRecord());
  }

  /**
   * Test {@link SparkplugMessageType#isRecord()}.
   *
   * <ul>
   *   <li>Given {@code NBIRTH}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMessageType#isRecord()}
   */
  @Test
  @DisplayName("Test isRecord(); given 'NBIRTH'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SparkplugMessageType.isRecord()"})
  void testIsRecord_givenNbirth_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SparkplugMessageType.NBIRTH.isRecord());
  }

  /**
   * Test {@link SparkplugMessageType#isRecord()}.
   *
   * <ul>
   *   <li>Given {@code NRECORD}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMessageType#isRecord()}
   */
  @Test
  @DisplayName("Test isRecord(); given 'NRECORD'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SparkplugMessageType.isRecord()"})
  void testIsRecord_givenNrecord_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SparkplugMessageType.NRECORD.isRecord());
  }
}
