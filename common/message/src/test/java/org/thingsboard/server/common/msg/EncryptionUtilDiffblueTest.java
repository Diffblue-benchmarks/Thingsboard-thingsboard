package org.thingsboard.server.common.msg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EncryptionUtilDiffblueTest {
  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String)")
  void testCertTrimNewLines() {
    // Arrange, Act and Assert
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("org.thingsboard.server.common.msg.EncryptionUtil-----END CERTIFICATE-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .certTrimNewLines("-----BEGIN CERTIFICATE-----\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .certTrimNewLines("-----BEGIN CERTIFICATE-----\rorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil.certTrimNewLines(
        "-----BEGIN CERTIFICATE----------END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .certTrimNewLines("-----BEGIN CERTIFICATE-----Inputorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .certTrimNewLines("-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .certTrimNewLines("-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil\r"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil.certTrimNewLines(
        "-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil-----END CERTIFICATE-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilInput", EncryptionUtil
        .certTrimNewLines("-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtilInput"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines(
            "-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server"
                + ".common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil42", EncryptionUtil
        .certTrimNewLines("-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil42"));
    assertEquals("42org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .certTrimNewLines("-----BEGIN CERTIFICATE-----42org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .certTrimNewLines("\n-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("\n-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .certTrimNewLines("\norg.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("\norg.thingsboard.server.common.msg.EncryptionUtil-----END CERTIFICATE-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines(
            "\norg.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .certTrimNewLines("\r-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("\r-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .certTrimNewLines("\rorg.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("\rorg.thingsboard.server.common.msg.EncryptionUtil-----END CERTIFICATE-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines(
            "\rorg.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil.certTrimNewLines(
        "-----END CERTIFICATE----------BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----\rorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil.certTrimNewLines(
        "-----END CERTIFICATE----------END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .certTrimNewLines("-----END CERTIFICATE-----Inputorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil.certTrimNewLines(
        "-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil\r"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil.certTrimNewLines(
        "-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil-----END CERTIFICATE-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilInput", EncryptionUtil
        .certTrimNewLines("-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtilInput"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines(
            "-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common"
                + ".msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil42",
        EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil42"));
    assertEquals("42org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----42org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .certTrimNewLines("Input-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .certTrimNewLines("Input-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .certTrimNewLines("Inputorg.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .certTrimNewLines("Inputorg.thingsboard.server.common.msg.EncryptionUtil-----END CERTIFICATE-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .certTrimNewLines("org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .certTrimNewLines("org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----\r"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil.certTrimNewLines(
        "org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE----------END CERTIFICATE-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilInput", EncryptionUtil
        .certTrimNewLines("org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----Input"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines(
            "org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----org.thingsboard.server"
                + ".common.msg.EncryptionUtil"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code 42-----BEGIN CERTIFICATE-----}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '42-----BEGIN CERTIFICATE-----'; then return '42'")
  void testCertTrimNewLines_when42BeginCertificate_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.certTrimNewLines("42-----BEGIN CERTIFICATE-----"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("\n42-----BEGIN CERTIFICATE-----"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("\r42-----BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code 42-----END CERTIFICATE-----}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '42-----END CERTIFICATE-----'; then return '42'")
  void testCertTrimNewLines_when42EndCertificate_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.certTrimNewLines("42-----END CERTIFICATE-----"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("\n42-----END CERTIFICATE-----"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("\r42-----END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code 42Input}.</li>
   *   <li>Then return {@code 42Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '42Input'; then return '42Input'")
  void testCertTrimNewLines_when42Input_thenReturn42Input() {
    // Arrange, Act and Assert
    assertEquals("42Input", EncryptionUtil.certTrimNewLines("\n42Input"));
    assertEquals("42Input", EncryptionUtil.certTrimNewLines("\r42Input"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '42'; then return '42'")
  void testCertTrimNewLines_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.certTrimNewLines("\n42"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("\r42"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("42\n"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("42\r"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("\n\n42"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("\n\r42"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("\n42\n"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("\n42\r"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("\r\n42"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("\r\r42"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("\r42\n"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("\r42\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code 42org.thingsboard.server.common.msg.EncryptionUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '42org.thingsboard.server.common.msg.EncryptionUtil'")
  void testCertTrimNewLines_when42orgThingsboardServerCommonMsgEncryptionUtil() {
    // Arrange, Act and Assert
    assertEquals("42org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("\n42org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("42org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("\r42org.thingsboard.server.common.msg.EncryptionUtil"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code 4242}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '4242'; then return '4242'")
  void testCertTrimNewLines_when4242_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", EncryptionUtil.certTrimNewLines("\n4242"));
    assertEquals("4242", EncryptionUtil.certTrimNewLines("\r4242"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when a string")
  void testCertTrimNewLines_whenAString() {
    // Arrange, Act and Assert
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil.certTrimNewLines(
        "-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----org.thingsboard.server.common.msg" + ".EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil.certTrimNewLines(
        "-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN" + " CERTIFICATE-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil.certTrimNewLines(
        "org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE----------BEGIN" + " CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN CERTIFICATE-----42-----BEGIN CERTIFICATE-----}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----BEGIN CERTIFICATE-----42-----BEGIN CERTIFICATE-----'; then return '42'")
  void testCertTrimNewLines_whenBeginCertificate42BeginCertificate_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----42-----BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----42-----END CERTIFICATE-----}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----BEGIN CERTIFICATE-----42-----END CERTIFICATE-----'; then return '42'")
  void testCertTrimNewLines_whenBeginCertificate42EndCertificate_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----42-----END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----42Input}.</li>
   *   <li>Then return {@code 42Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----BEGIN CERTIFICATE-----42Input'; then return '42Input'")
  void testCertTrimNewLines_whenBeginCertificate42Input_thenReturn42Input() {
    // Arrange, Act and Assert
    assertEquals("42Input", EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----42Input"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----BEGIN CERTIFICATE-----42'; then return '42'")
  void testCertTrimNewLines_whenBeginCertificate42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----42"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----\n42"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----\r42"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----42\n"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----42\r"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("\n-----BEGIN CERTIFICATE-----42"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("\r-----BEGIN CERTIFICATE-----42"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----4242}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----BEGIN CERTIFICATE-----4242'; then return '4242'")
  void testCertTrimNewLines_whenBeginCertificate4242_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----4242"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----42'; then return '42'")
  void testCertTrimNewLines_whenBeginCertificateBeginCertificate42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----42"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN CERTIFICATE----------BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----'")
  void testCertTrimNewLines_whenBeginCertificateBeginCertificateBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil
        .certTrimNewLines("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN CERTIFICATE----------BEGIN CERTIFICATE----------END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE----------END CERTIFICATE-----'")
  void testCertTrimNewLines_whenBeginCertificateBeginCertificateEndCertificate() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil
        .certTrimNewLines("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE----------END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----Input'; then return 'Input'")
  void testCertTrimNewLines_whenBeginCertificateBeginCertificateInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input",
        EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----Input"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----}.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----'; then return EMPTY_STRING")
  void testCertTrimNewLines_whenBeginCertificateBeginCertificate_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----\n"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----\r"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----\r-----BEGIN CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("\n-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("\r-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE----------END CERTIFICATE-----42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----BEGIN CERTIFICATE----------END CERTIFICATE-----42'; then return '42'")
  void testCertTrimNewLines_whenBeginCertificateEndCertificate42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE----------END CERTIFICATE-----42"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN CERTIFICATE----------END CERTIFICATE----------BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----BEGIN CERTIFICATE----------END CERTIFICATE----------BEGIN CERTIFICATE-----'")
  void testCertTrimNewLines_whenBeginCertificateEndCertificateBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil
        .certTrimNewLines("-----BEGIN CERTIFICATE----------END CERTIFICATE----------BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN CERTIFICATE----------END CERTIFICATE----------END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----BEGIN CERTIFICATE----------END CERTIFICATE----------END CERTIFICATE-----'")
  void testCertTrimNewLines_whenBeginCertificateEndCertificateEndCertificate() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil
        .certTrimNewLines("-----BEGIN CERTIFICATE----------END CERTIFICATE----------END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN CERTIFICATE----------END CERTIFICATE-----Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----BEGIN CERTIFICATE----------END CERTIFICATE-----Input'; then return 'Input'")
  void testCertTrimNewLines_whenBeginCertificateEndCertificateInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE----------END CERTIFICATE-----Input"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE----------END CERTIFICATE-----}.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----BEGIN CERTIFICATE----------END CERTIFICATE-----'; then return EMPTY_STRING")
  void testCertTrimNewLines_whenBeginCertificateEndCertificate_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE----------END CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----\n-----END CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----\r-----END CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE----------END CERTIFICATE-----\n"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE----------END CERTIFICATE-----\r"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("\n-----BEGIN CERTIFICATE----------END CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("\r-----BEGIN CERTIFICATE----------END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----Input42}.</li>
   *   <li>Then return {@code Input42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----BEGIN CERTIFICATE-----Input42'; then return 'Input42'")
  void testCertTrimNewLines_whenBeginCertificateInput42_thenReturnInput42() {
    // Arrange, Act and Assert
    assertEquals("Input42", EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----Input42"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN CERTIFICATE-----Input-----BEGIN CERTIFICATE-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----BEGIN CERTIFICATE-----Input-----BEGIN CERTIFICATE-----'; then return 'Input'")
  void testCertTrimNewLines_whenBeginCertificateInputBeginCertificate_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input",
        EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----Input-----BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN CERTIFICATE-----Input-----END CERTIFICATE-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----BEGIN CERTIFICATE-----Input-----END CERTIFICATE-----'; then return 'Input'")
  void testCertTrimNewLines_whenBeginCertificateInputEndCertificate_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----Input-----END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----InputInput}.</li>
   *   <li>Then return {@code InputInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----BEGIN CERTIFICATE-----InputInput'; then return 'InputInput'")
  void testCertTrimNewLines_whenBeginCertificateInputInput_thenReturnInputInput() {
    // Arrange, Act and Assert
    assertEquals("InputInput", EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----InputInput"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----BEGIN CERTIFICATE-----Input'; then return 'Input'")
  void testCertTrimNewLines_whenBeginCertificateInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----Input"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----\nInput"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----\rInput"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----Input\n"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----Input\r"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("\n-----BEGIN CERTIFICATE-----Input"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("\r-----BEGIN CERTIFICATE-----Input"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----}.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----BEGIN CERTIFICATE-----'; then return EMPTY_STRING")
  void testCertTrimNewLines_whenBeginCertificate_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\n-----BEGIN CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\r-----BEGIN CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----\n\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----\n\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----\r\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("-----BEGIN CERTIFICATE-----\r\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\n-----BEGIN CERTIFICATE-----\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\n-----BEGIN CERTIFICATE-----\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\n\n-----BEGIN CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\n\r-----BEGIN CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\r-----BEGIN CERTIFICATE-----\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\r-----BEGIN CERTIFICATE-----\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\r\n-----BEGIN CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\r\r-----BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When cr cr cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when cr cr cr; then return EMPTY_STRING")
  void testCertTrimNewLines_whenCrCrCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\r\r\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When cr cr lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when cr cr lf; then return EMPTY_STRING")
  void testCertTrimNewLines_whenCrCrLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\r\r\n"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When cr cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when cr cr; then return EMPTY_STRING")
  void testCertTrimNewLines_whenCrCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\r\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When cr lf cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when cr lf cr; then return EMPTY_STRING")
  void testCertTrimNewLines_whenCrLfCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\r\n\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When cr lf lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when cr lf lf; then return EMPTY_STRING")
  void testCertTrimNewLines_whenCrLfLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\r\n\n"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When cr lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when cr lf; then return EMPTY_STRING")
  void testCertTrimNewLines_whenCrLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\r\n"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when cr; then return EMPTY_STRING")
  void testCertTrimNewLines_whenCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----42-----BEGIN CERTIFICATE-----}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----END CERTIFICATE-----42-----BEGIN CERTIFICATE-----'; then return '42'")
  void testCertTrimNewLines_whenEndCertificate42BeginCertificate_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----42-----BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----42-----END CERTIFICATE-----}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----END CERTIFICATE-----42-----END CERTIFICATE-----'; then return '42'")
  void testCertTrimNewLines_whenEndCertificate42EndCertificate_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----42-----END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----42Input}.</li>
   *   <li>Then return {@code 42Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----END CERTIFICATE-----42Input'; then return '42Input'")
  void testCertTrimNewLines_whenEndCertificate42Input_thenReturn42Input() {
    // Arrange, Act and Assert
    assertEquals("42Input", EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----42Input"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----END CERTIFICATE-----42'; then return '42'")
  void testCertTrimNewLines_whenEndCertificate42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----42"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("\n-----END CERTIFICATE-----42"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("\r-----END CERTIFICATE-----42"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----\n42"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----\r42"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----42\n"));
    assertEquals("42", EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----42\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----4242}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----END CERTIFICATE-----4242'; then return '4242'")
  void testCertTrimNewLines_whenEndCertificate4242_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----4242"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE----------BEGIN CERTIFICATE-----42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----END CERTIFICATE----------BEGIN CERTIFICATE-----42'; then return '42'")
  void testCertTrimNewLines_whenEndCertificateBeginCertificate42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.certTrimNewLines("-----END CERTIFICATE----------BEGIN CERTIFICATE-----42"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END CERTIFICATE----------BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----END CERTIFICATE----------BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----'")
  void testCertTrimNewLines_whenEndCertificateBeginCertificateBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil
        .certTrimNewLines("-----END CERTIFICATE----------BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END CERTIFICATE----------BEGIN CERTIFICATE----------END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----END CERTIFICATE----------BEGIN CERTIFICATE----------END CERTIFICATE-----'")
  void testCertTrimNewLines_whenEndCertificateBeginCertificateEndCertificate() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil
        .certTrimNewLines("-----END CERTIFICATE----------BEGIN CERTIFICATE----------END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END CERTIFICATE----------BEGIN CERTIFICATE-----Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----END CERTIFICATE----------BEGIN CERTIFICATE-----Input'; then return 'Input'")
  void testCertTrimNewLines_whenEndCertificateBeginCertificateInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.certTrimNewLines("-----END CERTIFICATE----------BEGIN CERTIFICATE-----Input"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE----------BEGIN CERTIFICATE-----}.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----END CERTIFICATE----------BEGIN CERTIFICATE-----'; then return EMPTY_STRING")
  void testCertTrimNewLines_whenEndCertificateBeginCertificate_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("-----END CERTIFICATE----------BEGIN CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("\n-----END CERTIFICATE----------BEGIN CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("\r-----END CERTIFICATE----------BEGIN CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("-----END CERTIFICATE----------BEGIN CERTIFICATE-----\n"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("-----END CERTIFICATE----------BEGIN CERTIFICATE-----\r"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----\r-----BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE----------END CERTIFICATE-----42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----END CERTIFICATE----------END CERTIFICATE-----42'; then return '42'")
  void testCertTrimNewLines_whenEndCertificateEndCertificate42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.certTrimNewLines("-----END CERTIFICATE----------END CERTIFICATE-----42"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END CERTIFICATE----------END CERTIFICATE----------BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----END CERTIFICATE----------END CERTIFICATE----------BEGIN CERTIFICATE-----'")
  void testCertTrimNewLines_whenEndCertificateEndCertificateBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil
        .certTrimNewLines("-----END CERTIFICATE----------END CERTIFICATE----------BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END CERTIFICATE----------END CERTIFICATE----------END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----END CERTIFICATE----------END CERTIFICATE----------END CERTIFICATE-----'")
  void testCertTrimNewLines_whenEndCertificateEndCertificateEndCertificate() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("-----END CERTIFICATE----------END CERTIFICATE----------END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END CERTIFICATE----------END CERTIFICATE-----Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----END CERTIFICATE----------END CERTIFICATE-----Input'; then return 'Input'")
  void testCertTrimNewLines_whenEndCertificateEndCertificateInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.certTrimNewLines("-----END CERTIFICATE----------END CERTIFICATE-----Input"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE----------END CERTIFICATE-----}.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----END CERTIFICATE----------END CERTIFICATE-----'; then return EMPTY_STRING")
  void testCertTrimNewLines_whenEndCertificateEndCertificate_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("-----END CERTIFICATE----------END CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("\n-----END CERTIFICATE----------END CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("\r-----END CERTIFICATE----------END CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----\n-----END CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----\r-----END CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("-----END CERTIFICATE----------END CERTIFICATE-----\n"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.certTrimNewLines("-----END CERTIFICATE----------END CERTIFICATE-----\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----Input42}.</li>
   *   <li>Then return {@code Input42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----END CERTIFICATE-----Input42'; then return 'Input42'")
  void testCertTrimNewLines_whenEndCertificateInput42_thenReturnInput42() {
    // Arrange, Act and Assert
    assertEquals("Input42", EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----Input42"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END CERTIFICATE-----Input-----BEGIN CERTIFICATE-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----END CERTIFICATE-----Input-----BEGIN CERTIFICATE-----'; then return 'Input'")
  void testCertTrimNewLines_whenEndCertificateInputBeginCertificate_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----Input-----BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END CERTIFICATE-----Input-----END CERTIFICATE-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----END CERTIFICATE-----Input-----END CERTIFICATE-----'; then return 'Input'")
  void testCertTrimNewLines_whenEndCertificateInputEndCertificate_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----Input-----END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----InputInput}.</li>
   *   <li>Then return {@code InputInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----END CERTIFICATE-----InputInput'; then return 'InputInput'")
  void testCertTrimNewLines_whenEndCertificateInputInput_thenReturnInputInput() {
    // Arrange, Act and Assert
    assertEquals("InputInput", EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----InputInput"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----END CERTIFICATE-----Input'; then return 'Input'")
  void testCertTrimNewLines_whenEndCertificateInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----Input"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("\n-----END CERTIFICATE-----Input"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("\r-----END CERTIFICATE-----Input"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----\nInput"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----\rInput"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----Input\n"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----Input\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----}.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when '-----END CERTIFICATE-----'; then return EMPTY_STRING")
  void testCertTrimNewLines_whenEndCertificate_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\n-----END CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\r-----END CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\n\n-----END CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\n\r-----END CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\n-----END CERTIFICATE-----\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\n-----END CERTIFICATE-----\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\r\n-----END CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\r\r-----END CERTIFICATE-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\r-----END CERTIFICATE-----\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\r-----END CERTIFICATE-----\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----\n\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----\n\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----\r\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("-----END CERTIFICATE-----\r\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input42-----BEGIN CERTIFICATE-----}.</li>
   *   <li>Then return {@code Input42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when 'Input42-----BEGIN CERTIFICATE-----'; then return 'Input42'")
  void testCertTrimNewLines_whenInput42BeginCertificate_thenReturnInput42() {
    // Arrange, Act and Assert
    assertEquals("Input42", EncryptionUtil.certTrimNewLines("Input42-----BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input42-----END CERTIFICATE-----}.</li>
   *   <li>Then return {@code Input42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when 'Input42-----END CERTIFICATE-----'; then return 'Input42'")
  void testCertTrimNewLines_whenInput42EndCertificate_thenReturnInput42() {
    // Arrange, Act and Assert
    assertEquals("Input42", EncryptionUtil.certTrimNewLines("Input42-----END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input42}.</li>
   *   <li>Then return {@code Input42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when 'Input42'; then return 'Input42'")
  void testCertTrimNewLines_whenInput42_thenReturnInput42() {
    // Arrange, Act and Assert
    assertEquals("Input42", EncryptionUtil.certTrimNewLines("\nInput42"));
    assertEquals("Input42", EncryptionUtil.certTrimNewLines("\rInput42"));
    assertEquals("Input42", EncryptionUtil.certTrimNewLines("Input\n42"));
    assertEquals("Input42", EncryptionUtil.certTrimNewLines("Input\r42"));
    assertEquals("Input42", EncryptionUtil.certTrimNewLines("Input42\n"));
    assertEquals("Input42", EncryptionUtil.certTrimNewLines("Input42\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input-----BEGIN CERTIFICATE-----42}.</li>
   *   <li>Then return {@code Input42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when 'Input-----BEGIN CERTIFICATE-----42'; then return 'Input42'")
  void testCertTrimNewLines_whenInputBeginCertificate42_thenReturnInput42() {
    // Arrange, Act and Assert
    assertEquals("Input42", EncryptionUtil.certTrimNewLines("Input-----BEGIN CERTIFICATE-----42"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code Input-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when 'Input-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----'; then return 'Input'")
  void testCertTrimNewLines_whenInputBeginCertificateBeginCertificate_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input",
        EncryptionUtil.certTrimNewLines("Input-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code Input-----BEGIN CERTIFICATE----------END CERTIFICATE-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when 'Input-----BEGIN CERTIFICATE----------END CERTIFICATE-----'; then return 'Input'")
  void testCertTrimNewLines_whenInputBeginCertificateEndCertificate_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.certTrimNewLines("Input-----BEGIN CERTIFICATE----------END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input-----BEGIN CERTIFICATE-----Input}.</li>
   *   <li>Then return {@code InputInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when 'Input-----BEGIN CERTIFICATE-----Input'; then return 'InputInput'")
  void testCertTrimNewLines_whenInputBeginCertificateInput_thenReturnInputInput() {
    // Arrange, Act and Assert
    assertEquals("InputInput", EncryptionUtil.certTrimNewLines("Input-----BEGIN CERTIFICATE-----Input"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input-----BEGIN CERTIFICATE-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when 'Input-----BEGIN CERTIFICATE-----'; then return 'Input'")
  void testCertTrimNewLines_whenInputBeginCertificate_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.certTrimNewLines("Input-----BEGIN CERTIFICATE-----"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("\nInput-----BEGIN CERTIFICATE-----"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("\rInput-----BEGIN CERTIFICATE-----"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("Input-----BEGIN CERTIFICATE-----\n"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("Input-----BEGIN CERTIFICATE-----\r"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("Input\n-----BEGIN CERTIFICATE-----"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("Input\r-----BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input-----END CERTIFICATE-----42}.</li>
   *   <li>Then return {@code Input42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when 'Input-----END CERTIFICATE-----42'; then return 'Input42'")
  void testCertTrimNewLines_whenInputEndCertificate42_thenReturnInput42() {
    // Arrange, Act and Assert
    assertEquals("Input42", EncryptionUtil.certTrimNewLines("Input-----END CERTIFICATE-----42"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code Input-----END CERTIFICATE----------BEGIN CERTIFICATE-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when 'Input-----END CERTIFICATE----------BEGIN CERTIFICATE-----'; then return 'Input'")
  void testCertTrimNewLines_whenInputEndCertificateBeginCertificate_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.certTrimNewLines("Input-----END CERTIFICATE----------BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code Input-----END CERTIFICATE----------END CERTIFICATE-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when 'Input-----END CERTIFICATE----------END CERTIFICATE-----'; then return 'Input'")
  void testCertTrimNewLines_whenInputEndCertificateEndCertificate_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.certTrimNewLines("Input-----END CERTIFICATE----------END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input-----END CERTIFICATE-----Input}.</li>
   *   <li>Then return {@code InputInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when 'Input-----END CERTIFICATE-----Input'; then return 'InputInput'")
  void testCertTrimNewLines_whenInputEndCertificateInput_thenReturnInputInput() {
    // Arrange, Act and Assert
    assertEquals("InputInput", EncryptionUtil.certTrimNewLines("Input-----END CERTIFICATE-----Input"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input-----END CERTIFICATE-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when 'Input-----END CERTIFICATE-----'; then return 'Input'")
  void testCertTrimNewLines_whenInputEndCertificate_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.certTrimNewLines("Input-----END CERTIFICATE-----"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("\nInput-----END CERTIFICATE-----"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("\rInput-----END CERTIFICATE-----"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("Input\n-----END CERTIFICATE-----"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("Input\r-----END CERTIFICATE-----"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("Input-----END CERTIFICATE-----\n"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("Input-----END CERTIFICATE-----\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code InputInput-----BEGIN CERTIFICATE-----}.</li>
   *   <li>Then return {@code InputInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when 'InputInput-----BEGIN CERTIFICATE-----'; then return 'InputInput'")
  void testCertTrimNewLines_whenInputInputBeginCertificate_thenReturnInputInput() {
    // Arrange, Act and Assert
    assertEquals("InputInput", EncryptionUtil.certTrimNewLines("InputInput-----BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code InputInput-----END CERTIFICATE-----}.</li>
   *   <li>Then return {@code InputInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when 'InputInput-----END CERTIFICATE-----'; then return 'InputInput'")
  void testCertTrimNewLines_whenInputInputEndCertificate_thenReturnInputInput() {
    // Arrange, Act and Assert
    assertEquals("InputInput", EncryptionUtil.certTrimNewLines("InputInput-----END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code InputInput}.</li>
   *   <li>Then return {@code InputInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when 'InputInput'; then return 'InputInput'")
  void testCertTrimNewLines_whenInputInput_thenReturnInputInput() {
    // Arrange, Act and Assert
    assertEquals("InputInput", EncryptionUtil.certTrimNewLines("\nInputInput"));
    assertEquals("InputInput", EncryptionUtil.certTrimNewLines("\rInputInput"));
    assertEquals("InputInput", EncryptionUtil.certTrimNewLines("Input\nInput"));
    assertEquals("InputInput", EncryptionUtil.certTrimNewLines("Input\rInput"));
    assertEquals("InputInput", EncryptionUtil.certTrimNewLines("InputInput\n"));
    assertEquals("InputInput", EncryptionUtil.certTrimNewLines("InputInput\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input org.thingsboard.server.common.msg.EncryptionUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when 'Input org.thingsboard.server.common.msg.EncryptionUtil'")
  void testCertTrimNewLines_whenInputOrgThingsboardServerCommonMsgEncryptionUtil() {
    // Arrange, Act and Assert
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("Input\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("Input\rorg.thingsboard.server.common.msg.EncryptionUtil"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when 'Input'; then return 'Input'")
  void testCertTrimNewLines_whenInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.certTrimNewLines("Input"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("\nInput"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("\rInput"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("Input\n"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("Input\r"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("\n\nInput"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("\n\rInput"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("\nInput\n"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("\nInput\r"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("\r\nInput"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("\r\rInput"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("\rInput\n"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("\rInput\r"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("Input\n\n"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("Input\n\r"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("Input\r\n"));
    assertEquals("Input", EncryptionUtil.certTrimNewLines("Input\r\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Inputorg.thingsboard.server.common.msg.EncryptionUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when 'Inputorg.thingsboard.server.common.msg.EncryptionUtil'")
  void testCertTrimNewLines_whenInputorgThingsboardServerCommonMsgEncryptionUtil() {
    // Arrange, Act and Assert
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("\nInputorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("\rInputorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("Inputorg.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("Inputorg.thingsboard.server.common.msg.EncryptionUtil\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When lf cr cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when lf cr cr; then return EMPTY_STRING")
  void testCertTrimNewLines_whenLfCrCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\n\r\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When lf cr lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when lf cr lf; then return EMPTY_STRING")
  void testCertTrimNewLines_whenLfCrLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\n\r\n"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When lf cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when lf cr; then return EMPTY_STRING")
  void testCertTrimNewLines_whenLfCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\n\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When lf lf cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when lf lf cr; then return EMPTY_STRING")
  void testCertTrimNewLines_whenLfLfCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\n\n\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When lf lf lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when lf lf lf; then return EMPTY_STRING")
  void testCertTrimNewLines_whenLfLfLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\n\n\n"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When lf lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when lf lf; then return EMPTY_STRING")
  void testCertTrimNewLines_whenLfLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\n\n"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when lf; then return EMPTY_STRING")
  void testCertTrimNewLines_whenLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLines("\n"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code org.thingsboard.server.common.msg.EncryptionUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when 'org.thingsboard.server.common.msg.EncryptionUtil'")
  void testCertTrimNewLines_whenOrgThingsboardServerCommonMsgEncryptionUtil() {
    // Arrange, Act and Assert
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("\rorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("org.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("org.thingsboard.server.common.msg.EncryptionUtil\r"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("\n\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("\n\rorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("\norg.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("\norg.thingsboard.server.common.msg.EncryptionUtil\r"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("\r\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("\r\rorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("\rorg.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLines("\rorg.thingsboard.server.common.msg.EncryptionUtil\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code org.thingsboard.server.common.msg.EncryptionUtil42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when 'org.thingsboard.server.common.msg.EncryptionUtil42'")
  void testCertTrimNewLines_whenOrgThingsboardServerCommonMsgEncryptionUtil42() {
    // Arrange, Act and Assert
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil42",
        EncryptionUtil.certTrimNewLines("\norg.thingsboard.server.common.msg.EncryptionUtil42"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil42",
        EncryptionUtil.certTrimNewLines("\rorg.thingsboard.server.common.msg.EncryptionUtil42"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code org.thingsboard.server.common.msg.EncryptionUtilInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#certTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLines(String); when 'org.thingsboard.server.common.msg.EncryptionUtilInput'")
  void testCertTrimNewLines_whenOrgThingsboardServerCommonMsgEncryptionUtilInput() {
    // Arrange, Act and Assert
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilInput",
        EncryptionUtil.certTrimNewLines("\norg.thingsboard.server.common.msg.EncryptionUtilInput"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilInput",
        EncryptionUtil.certTrimNewLines("\rorg.thingsboard.server.common.msg.EncryptionUtilInput"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String)")
  void testCertTrimNewLinesForChainInDeviceProfile() {
    // Arrange, Act and Assert
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\rorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("-----BEGIN CERTIFICATE-----\norg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("-----END CERTIFICATE-----\norg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("-----BEGIN CERTIFICATE-----\norg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "-----BEGIN CERTIFICATE-----\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("-----END CERTIFICATE-----\norg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "\n-----END CERTIFICATE-----\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("org.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("org.thingsboard.server.common.msg.EncryptionUtil\r"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "org.thingsboard.server.common.msg.EncryptionUtil-----END CERTIFICATE-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "org.thingsboard.server.common.msg.EncryptionUtil\n-----END CERTIFICATE-----\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\rorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("-----BEGIN CERTIFICATE-----\norg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "\n-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("-----END CERTIFICATE-----\norg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "\n-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("-----BEGIN CERTIFICATE-----\norg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "\n-----BEGIN CERTIFICATE-----\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\nInputorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("-----END CERTIFICATE-----\norg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "\n\n-----END CERTIFICATE-----\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\norg.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\norg.thingsboard.server.common.msg.EncryptionUtil\r"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "\norg.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "\norg.thingsboard.server.common.msg.EncryptionUtil-----END CERTIFICATE-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "\norg.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilInput", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\norg.thingsboard.server.common.msg.EncryptionUtilInput"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "\norg.thingsboard.server.common.msg.EncryptionUtil\n-----END CERTIFICATE-----\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "\norg.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil42",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\norg.thingsboard.server.common.msg.EncryptionUtil42"));
    assertEquals("42org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n42org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\rorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("-----BEGIN CERTIFICATE-----\norg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "\r-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("-----END CERTIFICATE-----\norg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "\r-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("-----BEGIN CERTIFICATE-----\norg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "\r-----BEGIN CERTIFICATE-----\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\rInputorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("-----END CERTIFICATE-----\norg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "\r\n-----END CERTIFICATE-----\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\rorg.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\rorg.thingsboard.server.common.msg.EncryptionUtil\r"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "\rorg.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "\rorg.thingsboard.server.common.msg.EncryptionUtil-----END CERTIFICATE-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "\rorg.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilInput", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\rorg.thingsboard.server.common.msg.EncryptionUtilInput"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "\rorg.thingsboard.server.common.msg.EncryptionUtil\n-----END CERTIFICATE-----\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "\rorg.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil42",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\rorg.thingsboard.server.common.msg.EncryptionUtil42"));
    assertEquals("42org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r42org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("-----BEGIN CERTIFICATE-----\norg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "-----BEGIN CERTIFICATE-----\rorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE----------END CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----\nInput", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----Input"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----\n-----END CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----\n42", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----42"));
    assertEquals("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "-----BEGIN CERTIFICATE----------END CERTIFICATE----------BEGIN CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----\n\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "-----BEGIN CERTIFICATE----------END CERTIFICATE----------END CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----\nInput", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE----------END CERTIFICATE-----Input"));
    assertEquals("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----\n\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "-----BEGIN CERTIFICATE----------END CERTIFICATE-----\n-----END CERTIFICATE-----\n"));
    assertEquals(
        "-----BEGIN CERTIFICATE-----\n" + "\n" + "-----END CERTIFICATE-----\n"
            + "org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "-----BEGIN CERTIFICATE----------END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----\n42", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE----------END CERTIFICATE-----42"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----\n-----END CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----\nInput", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----\nInput"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----\n42", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----\n42"));
    assertEquals("-----BEGIN CERTIFICATE-----\nInput-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----Input-----BEGIN CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----\nInput\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----Input-----END CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----\nInput\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----Input\n-----END CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----\nInputorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "-----BEGIN CERTIFICATE-----Inputorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "-----BEGIN CERTIFICATE-----\n-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>Then return {@code 42-----BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); then return '42-----BEGIN CERTIFICATE-----'")
  void testCertTrimNewLinesForChainInDeviceProfile_thenReturn42BeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("42-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("42-----BEGIN CERTIFICATE-----"));
    assertEquals("42-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("42-----BEGIN CERTIFICATE-----\n"));
    assertEquals("42-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n42-----BEGIN CERTIFICATE-----"));
    assertEquals("42-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n42-----BEGIN CERTIFICATE-----\n"));
    assertEquals("42-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r42-----BEGIN CERTIFICATE-----"));
    assertEquals("42-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r42-----BEGIN CERTIFICATE-----\n"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>Then return {@code -----BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); then return '-----BEGIN CERTIFICATE-----'")
  void testCertTrimNewLinesForChainInDeviceProfile_thenReturnBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n-----BEGIN CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n-----BEGIN CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r-----BEGIN CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r-----BEGIN CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----\r"));
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----\n\n"));
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----\n\r"));
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\n-----BEGIN CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\n-----BEGIN CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\r-----BEGIN CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\r-----BEGIN CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n-----BEGIN CERTIFICATE-----\r"));
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n-----BEGIN CERTIFICATE-----\n\n"));
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n-----BEGIN CERTIFICATE-----\n\r"));
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\n-----BEGIN CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\n-----BEGIN CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\r-----BEGIN CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\r-----BEGIN CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r-----BEGIN CERTIFICATE-----\r"));
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r-----BEGIN CERTIFICATE-----\n\n"));
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r-----BEGIN CERTIFICATE-----\n\r"));
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----\r\n"));
    assertEquals("-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----\r\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>Then return {@code -----BEGIN CERTIFICATE----- Input42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); then return '-----BEGIN CERTIFICATE----- Input42'")
  void testCertTrimNewLinesForChainInDeviceProfile_thenReturnBeginCertificateInput42() {
    // Arrange, Act and Assert
    assertEquals("-----BEGIN CERTIFICATE-----\nInput42",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----Input42"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>Then return {@code -----BEGIN CERTIFICATE----- InputInput}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); then return '-----BEGIN CERTIFICATE----- InputInput'")
  void testCertTrimNewLinesForChainInDeviceProfile_thenReturnBeginCertificateInputInput() {
    // Arrange, Act and Assert
    assertEquals("-----BEGIN CERTIFICATE-----\nInputInput",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----InputInput"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>Then return {@code -----END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); then return '-----END CERTIFICATE-----'")
  void testCertTrimNewLinesForChainInDeviceProfile_thenReturnEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----END CERTIFICATE-----"));
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n-----END CERTIFICATE-----\n"));
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n-----END CERTIFICATE-----"));
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\n-----END CERTIFICATE-----\n"));
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r-----END CERTIFICATE-----"));
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\n-----END CERTIFICATE-----\n"));
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----END CERTIFICATE-----\n"));
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----END CERTIFICATE-----\r"));
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n-----END CERTIFICATE-----\n\n"));
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n-----END CERTIFICATE-----\n\r"));
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\n-----END CERTIFICATE-----"));
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\n\n-----END CERTIFICATE-----\n"));
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\r-----END CERTIFICATE-----"));
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\r\n-----END CERTIFICATE-----\n"));
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n-----END CERTIFICATE-----\r"));
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\n-----END CERTIFICATE-----\n\n"));
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\n-----END CERTIFICATE-----\n\r"));
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\n-----END CERTIFICATE-----"));
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\n\n-----END CERTIFICATE-----\n"));
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\r-----END CERTIFICATE-----"));
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\r\n-----END CERTIFICATE-----\n"));
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r-----END CERTIFICATE-----\n"));
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r-----END CERTIFICATE-----\r"));
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\n-----END CERTIFICATE-----\n\n"));
    assertEquals("-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\n-----END CERTIFICATE-----\n\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>Then return {@code Input-----BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); then return 'Input-----BEGIN CERTIFICATE-----'")
  void testCertTrimNewLinesForChainInDeviceProfile_thenReturnInputBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("Input-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("Input-----BEGIN CERTIFICATE-----"));
    assertEquals("Input-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("Input-----BEGIN CERTIFICATE-----\n"));
    assertEquals("Input-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\nInput-----BEGIN CERTIFICATE-----"));
    assertEquals("Input-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\nInput-----BEGIN CERTIFICATE-----\n"));
    assertEquals("Input-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\rInput-----BEGIN CERTIFICATE-----"));
    assertEquals("Input-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\rInput-----BEGIN CERTIFICATE-----\n"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When {@code 42-----END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when '42-----END CERTIFICATE-----'")
  void testCertTrimNewLinesForChainInDeviceProfile_when42EndCertificate() {
    // Arrange, Act and Assert
    assertEquals("42\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("42-----END CERTIFICATE-----"));
    assertEquals("42\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("42\n-----END CERTIFICATE-----\n"));
    assertEquals("42\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n42-----END CERTIFICATE-----"));
    assertEquals("42\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n42\n-----END CERTIFICATE-----\n"));
    assertEquals("42\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r42-----END CERTIFICATE-----"));
    assertEquals("42\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r42\n-----END CERTIFICATE-----\n"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When {@code 42Input}.</li>
   *   <li>Then return {@code 42Input}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when '42Input'; then return '42Input'")
  void testCertTrimNewLinesForChainInDeviceProfile_when42Input_thenReturn42Input() {
    // Arrange, Act and Assert
    assertEquals("42Input", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n42Input"));
    assertEquals("42Input", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r42Input"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when '42'; then return '42'")
  void testCertTrimNewLinesForChainInDeviceProfile_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n42"));
    assertEquals("42", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r42"));
    assertEquals("42", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("42\n"));
    assertEquals("42", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("42\r"));
    assertEquals("42", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\n42"));
    assertEquals("42", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\r42"));
    assertEquals("42", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n42\n"));
    assertEquals("42", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n42\r"));
    assertEquals("42", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\n42"));
    assertEquals("42", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\r42"));
    assertEquals("42", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r42\n"));
    assertEquals("42", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r42\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When {@code 4242}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when '4242'; then return '4242'")
  void testCertTrimNewLinesForChainInDeviceProfile_when4242_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n4242"));
    assertEquals("4242", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r4242"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When a string.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when a string; then return a string")
  void testCertTrimNewLinesForChainInDeviceProfile_whenAString_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "-----BEGIN CERTIFICATE-----\n" + "-----BEGIN CERTIFICATE-----\n"
            + "org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile(
            "-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----org.thingsboard.server.common.msg"
                + ".EncryptionUtil"));
    assertEquals(
        "-----BEGIN CERTIFICATE-----\n" + "-----BEGIN CERTIFICATE-----\n"
            + "org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil
            .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----\n"
                + "org.thingsboard.server.common.msg.EncryptionUtil"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when '-----BEGIN CERTIFICATE-----42'")
  void testCertTrimNewLinesForChainInDeviceProfile_whenBeginCertificate42() {
    // Arrange, Act and Assert
    assertEquals("-----BEGIN CERTIFICATE-----\n42",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----42"));
    assertEquals("-----BEGIN CERTIFICATE-----\n42",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----\n42"));
    assertEquals("-----BEGIN CERTIFICATE-----\n42",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n-----BEGIN CERTIFICATE-----42"));
    assertEquals("-----BEGIN CERTIFICATE-----\n42",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n-----BEGIN CERTIFICATE-----\n42"));
    assertEquals("-----BEGIN CERTIFICATE-----\n42",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r-----BEGIN CERTIFICATE-----42"));
    assertEquals("-----BEGIN CERTIFICATE-----\n42",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r-----BEGIN CERTIFICATE-----\n42"));
    assertEquals("-----BEGIN CERTIFICATE-----\n42",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----\r42"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when '-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----'")
  void testCertTrimNewLinesForChainInDeviceProfile_whenBeginCertificateBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\n-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\n-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\n-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\n-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\r-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\r-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\r-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\r-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----\r-----BEGIN CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----\r-----BEGIN CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----\r"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----\n\n"));
    assertEquals("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----\n\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE----------END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when '-----BEGIN CERTIFICATE----------END CERTIFICATE-----'")
  void testCertTrimNewLinesForChainInDeviceProfile_whenBeginCertificateEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE----------END CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----\n-----END CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----\n-----END CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\n-----BEGIN CERTIFICATE----------END CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\n-----BEGIN CERTIFICATE-----\n-----END CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\n-----BEGIN CERTIFICATE-----\n-----END CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\n-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\r-----BEGIN CERTIFICATE----------END CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\r-----BEGIN CERTIFICATE-----\n-----END CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\r-----BEGIN CERTIFICATE-----\n-----END CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\r-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----\r-----END CERTIFICATE-----"));
    assertEquals("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----\r\n-----END CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE----------END CERTIFICATE-----\n"));
    assertEquals("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE----------END CERTIFICATE-----\r"));
    assertEquals("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----\n-----END CERTIFICATE-----\n\n"));
    assertEquals("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----\n-----END CERTIFICATE-----\n\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----Input}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when '-----BEGIN CERTIFICATE-----Input'")
  void testCertTrimNewLinesForChainInDeviceProfile_whenBeginCertificateInput() {
    // Arrange, Act and Assert
    assertEquals("-----BEGIN CERTIFICATE-----\nInput",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----Input"));
    assertEquals("-----BEGIN CERTIFICATE-----\nInput",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----\nInput"));
    assertEquals("-----BEGIN CERTIFICATE-----\nInput",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n-----BEGIN CERTIFICATE-----Input"));
    assertEquals("-----BEGIN CERTIFICATE-----\nInput",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n-----BEGIN CERTIFICATE-----\nInput"));
    assertEquals("-----BEGIN CERTIFICATE-----\nInput",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r-----BEGIN CERTIFICATE-----Input"));
    assertEquals("-----BEGIN CERTIFICATE-----\nInput",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r-----BEGIN CERTIFICATE-----\nInput"));
    assertEquals("-----BEGIN CERTIFICATE-----\nInput",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----\rInput"));
    assertEquals("-----BEGIN CERTIFICATE-----\nInput",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----Input\n"));
    assertEquals("-----BEGIN CERTIFICATE-----\nInput",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----BEGIN CERTIFICATE-----Input\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When cr cr cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when cr cr cr; then return EMPTY_STRING")
  void testCertTrimNewLinesForChainInDeviceProfile_whenCrCrCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\r\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When cr cr lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when cr cr lf; then return EMPTY_STRING")
  void testCertTrimNewLinesForChainInDeviceProfile_whenCrCrLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\r\n"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When cr cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when cr cr; then return EMPTY_STRING")
  void testCertTrimNewLinesForChainInDeviceProfile_whenCrCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When cr lf cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when cr lf cr; then return EMPTY_STRING")
  void testCertTrimNewLinesForChainInDeviceProfile_whenCrLfCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\n\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When cr lf lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when cr lf lf; then return EMPTY_STRING")
  void testCertTrimNewLinesForChainInDeviceProfile_whenCrLfLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\n\n"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When cr lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when cr lf; then return EMPTY_STRING")
  void testCertTrimNewLinesForChainInDeviceProfile_whenCrLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\n"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when cr; then return EMPTY_STRING")
  void testCertTrimNewLinesForChainInDeviceProfile_whenCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when '-----END CERTIFICATE-----42'")
  void testCertTrimNewLinesForChainInDeviceProfile_whenEndCertificate42() {
    // Arrange, Act and Assert
    assertEquals("-----END CERTIFICATE-----\n42",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----END CERTIFICATE-----42"));
    assertEquals("-----END CERTIFICATE-----\n42",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n-----END CERTIFICATE-----\n42"));
    assertEquals("-----END CERTIFICATE-----\n42",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n-----END CERTIFICATE-----42"));
    assertEquals("-----END CERTIFICATE-----\n42",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\n-----END CERTIFICATE-----\n42"));
    assertEquals("-----END CERTIFICATE-----\n42",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r-----END CERTIFICATE-----42"));
    assertEquals("-----END CERTIFICATE-----\n42",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\n-----END CERTIFICATE-----\n42"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE----------BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when '-----END CERTIFICATE----------BEGIN CERTIFICATE-----'")
  void testCertTrimNewLinesForChainInDeviceProfile_whenEndCertificateBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----END CERTIFICATE----------BEGIN CERTIFICATE-----"));
    assertEquals("-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("-----END CERTIFICATE----------BEGIN CERTIFICATE-----\n"));
    assertEquals("-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\n-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----"));
    assertEquals("-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\n-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----\n"));
    assertEquals("-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\n-----END CERTIFICATE----------BEGIN CERTIFICATE-----"));
    assertEquals("-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\n-----END CERTIFICATE----------BEGIN CERTIFICATE-----\n"));
    assertEquals("-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\n\n-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----"));
    assertEquals("-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\n\n-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----\n"));
    assertEquals("-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\r-----END CERTIFICATE----------BEGIN CERTIFICATE-----"));
    assertEquals("-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\r-----END CERTIFICATE----------BEGIN CERTIFICATE-----\n"));
    assertEquals("-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\r\n-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----"));
    assertEquals("-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\r\n-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----\n"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE----------END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when '-----END CERTIFICATE----------END CERTIFICATE-----'")
  void testCertTrimNewLinesForChainInDeviceProfile_whenEndCertificateEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("-----END CERTIFICATE-----\n\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----END CERTIFICATE----------END CERTIFICATE-----"));
    assertEquals("-----END CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\n-----END CERTIFICATE-----\n-----END CERTIFICATE-----"));
    assertEquals("-----END CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\n-----END CERTIFICATE-----\n\n-----END CERTIFICATE-----\n"));
    assertEquals("-----END CERTIFICATE-----\n\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n-----END CERTIFICATE----------END CERTIFICATE-----"));
    assertEquals("-----END CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\n-----END CERTIFICATE-----\n-----END CERTIFICATE-----\n"));
    assertEquals("-----END CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\n\n-----END CERTIFICATE-----\n-----END CERTIFICATE-----"));
    assertEquals("-----END CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\n\n-----END CERTIFICATE-----\n\n-----END CERTIFICATE-----\n"));
    assertEquals("-----END CERTIFICATE-----\n\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r-----END CERTIFICATE----------END CERTIFICATE-----"));
    assertEquals("-----END CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\r-----END CERTIFICATE-----\n-----END CERTIFICATE-----\n"));
    assertEquals("-----END CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\r\n-----END CERTIFICATE-----\n-----END CERTIFICATE-----"));
    assertEquals("-----END CERTIFICATE-----\n\n-----END CERTIFICATE-----", EncryptionUtil
        .certTrimNewLinesForChainInDeviceProfile("\r\n-----END CERTIFICATE-----\n\n-----END CERTIFICATE-----\n"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----Input}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when '-----END CERTIFICATE-----Input'")
  void testCertTrimNewLinesForChainInDeviceProfile_whenEndCertificateInput() {
    // Arrange, Act and Assert
    assertEquals("-----END CERTIFICATE-----\nInput",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("-----END CERTIFICATE-----Input"));
    assertEquals("-----END CERTIFICATE-----\nInput",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n-----END CERTIFICATE-----\nInput"));
    assertEquals("-----END CERTIFICATE-----\nInput",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n-----END CERTIFICATE-----Input"));
    assertEquals("-----END CERTIFICATE-----\nInput",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\n-----END CERTIFICATE-----\nInput"));
    assertEquals("-----END CERTIFICATE-----\nInput",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r-----END CERTIFICATE-----Input"));
    assertEquals("-----END CERTIFICATE-----\nInput",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\n-----END CERTIFICATE-----\nInput"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When {@code Input42}.</li>
   *   <li>Then return {@code Input42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when 'Input42'; then return 'Input42'")
  void testCertTrimNewLinesForChainInDeviceProfile_whenInput42_thenReturnInput42() {
    // Arrange, Act and Assert
    assertEquals("Input42", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\nInput42"));
    assertEquals("Input42", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\rInput42"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When {@code Input-----END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when 'Input-----END CERTIFICATE-----'")
  void testCertTrimNewLinesForChainInDeviceProfile_whenInputEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("Input\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("Input-----END CERTIFICATE-----"));
    assertEquals("Input\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("Input\n-----END CERTIFICATE-----\n"));
    assertEquals("Input\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\nInput-----END CERTIFICATE-----"));
    assertEquals("Input\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\nInput\n-----END CERTIFICATE-----\n"));
    assertEquals("Input\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\rInput-----END CERTIFICATE-----"));
    assertEquals("Input\n-----END CERTIFICATE-----",
        EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\rInput\n-----END CERTIFICATE-----\n"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When {@code InputInput}.</li>
   *   <li>Then return {@code InputInput}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when 'InputInput'; then return 'InputInput'")
  void testCertTrimNewLinesForChainInDeviceProfile_whenInputInput_thenReturnInputInput() {
    // Arrange, Act and Assert
    assertEquals("InputInput", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\nInputInput"));
    assertEquals("InputInput", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\rInputInput"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When {@code Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when 'Input'; then return 'Input'")
  void testCertTrimNewLinesForChainInDeviceProfile_whenInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("Input"));
    assertEquals("Input", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\nInput"));
    assertEquals("Input", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\rInput"));
    assertEquals("Input", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("Input\n"));
    assertEquals("Input", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("Input\r"));
    assertEquals("Input", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\nInput"));
    assertEquals("Input", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\rInput"));
    assertEquals("Input", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\nInput\n"));
    assertEquals("Input", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\nInput\r"));
    assertEquals("Input", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\nInput"));
    assertEquals("Input", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\r\rInput"));
    assertEquals("Input", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\rInput\n"));
    assertEquals("Input", EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\rInput\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When lf cr cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when lf cr cr; then return EMPTY_STRING")
  void testCertTrimNewLinesForChainInDeviceProfile_whenLfCrCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\r\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When lf cr lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when lf cr lf; then return EMPTY_STRING")
  void testCertTrimNewLinesForChainInDeviceProfile_whenLfCrLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\r\n"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When lf cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when lf cr; then return EMPTY_STRING")
  void testCertTrimNewLinesForChainInDeviceProfile_whenLfCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When lf lf cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when lf lf cr; then return EMPTY_STRING")
  void testCertTrimNewLinesForChainInDeviceProfile_whenLfLfCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\n\r"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When lf lf lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when lf lf lf; then return EMPTY_STRING")
  void testCertTrimNewLinesForChainInDeviceProfile_whenLfLfLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\n\n"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When lf lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when lf lf; then return EMPTY_STRING")
  void testCertTrimNewLinesForChainInDeviceProfile_whenLfLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n\n"));
  }

  /**
   * Test {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EncryptionUtil#certTrimNewLinesForChainInDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test certTrimNewLinesForChainInDeviceProfile(String); when lf; then return EMPTY_STRING")
  void testCertTrimNewLinesForChainInDeviceProfile_whenLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.certTrimNewLinesForChainInDeviceProfile("\n"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String)")
  void testPubkTrimNewLines() {
    // Arrange, Act and Assert
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN PUBLIC KEY-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil.pubkTrimNewLines(
        "-----BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .pubkTrimNewLines("-----BEGIN PUBLIC KEY-----\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .pubkTrimNewLines("-----BEGIN PUBLIC KEY-----\rorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil.pubkTrimNewLines(
        "-----BEGIN PUBLIC KEY----------END PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .pubkTrimNewLines("-----BEGIN PUBLIC KEY-----Inputorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil.pubkTrimNewLines(
        "-----BEGIN PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN PUBLIC KEY-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .pubkTrimNewLines("-----BEGIN PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .pubkTrimNewLines("-----BEGIN PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtil\r"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil.pubkTrimNewLines(
        "-----BEGIN PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtil-----END PUBLIC KEY-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilInput", EncryptionUtil
        .pubkTrimNewLines("-----BEGIN PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtilInput"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil42", EncryptionUtil
        .pubkTrimNewLines("-----BEGIN PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtil42"));
    assertEquals("42org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .pubkTrimNewLines("-----BEGIN PUBLIC KEY-----42org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .pubkTrimNewLines("\n-----BEGIN PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .pubkTrimNewLines("\norg.thingsboard.server.common.msg.EncryptionUtil-----BEGIN PUBLIC KEY-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines(
            "\norg.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .pubkTrimNewLines("\r-----BEGIN PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .pubkTrimNewLines("\rorg.thingsboard.server.common.msg.EncryptionUtil-----BEGIN PUBLIC KEY-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines(
            "\rorg.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil.pubkTrimNewLines(
        "-----END PUBLIC KEY----------BEGIN PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil.pubkTrimNewLines(
        "-----END PUBLIC KEY----------END PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .pubkTrimNewLines("-----END PUBLIC KEY-----Inputorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil.pubkTrimNewLines(
        "-----END PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN PUBLIC KEY-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil.pubkTrimNewLines(
        "-----END PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtil-----END PUBLIC KEY-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilInput", EncryptionUtil
        .pubkTrimNewLines("-----END PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtilInput"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil42",
        EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtil42"));
    assertEquals("42org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----42org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .pubkTrimNewLines("Input-----BEGIN PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .pubkTrimNewLines("Input-----END PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .pubkTrimNewLines("Inputorg.thingsboard.server.common.msg.EncryptionUtil-----BEGIN PUBLIC KEY-----"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .pubkTrimNewLines("Inputorg.thingsboard.server.common.msg.EncryptionUtil-----END PUBLIC KEY-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil.pubkTrimNewLines(
        "org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .pubkTrimNewLines("org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN PUBLIC KEY-----\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .pubkTrimNewLines("org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN PUBLIC KEY-----\r"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil.pubkTrimNewLines(
        "org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN PUBLIC KEY----------END PUBLIC KEY-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilInput", EncryptionUtil
        .pubkTrimNewLines("org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN PUBLIC KEY-----Input"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code 42-----BEGIN PUBLIC KEY-----}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '42-----BEGIN PUBLIC KEY-----'; then return '42'")
  void testPubkTrimNewLines_when42BeginPublicKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("42-----BEGIN PUBLIC KEY-----"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("\n42-----BEGIN PUBLIC KEY-----"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("\r42-----BEGIN PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code 42-----END PUBLIC KEY-----}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '42-----END PUBLIC KEY-----'; then return '42'")
  void testPubkTrimNewLines_when42EndPublicKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("42-----END PUBLIC KEY-----"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("\n42-----END PUBLIC KEY-----"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("\r42-----END PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code 42Input}.</li>
   *   <li>Then return {@code 42Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '42Input'; then return '42Input'")
  void testPubkTrimNewLines_when42Input_thenReturn42Input() {
    // Arrange, Act and Assert
    assertEquals("42Input", EncryptionUtil.pubkTrimNewLines("\n42Input"));
    assertEquals("42Input", EncryptionUtil.pubkTrimNewLines("\r42Input"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '42'; then return '42'")
  void testPubkTrimNewLines_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("\n42"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("\r42"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("42\n"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("42\r"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("\n\n42"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("\n\r42"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("\n42\n"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("\n42\r"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("\r\n42"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("\r\r42"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("\r42\n"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("\r42\r"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code 42org.thingsboard.server.common.msg.EncryptionUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '42org.thingsboard.server.common.msg.EncryptionUtil'")
  void testPubkTrimNewLines_when42orgThingsboardServerCommonMsgEncryptionUtil() {
    // Arrange, Act and Assert
    assertEquals("42org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("\n42org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("42org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("\r42org.thingsboard.server.common.msg.EncryptionUtil"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code 4242}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '4242'; then return '4242'")
  void testPubkTrimNewLines_when4242_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", EncryptionUtil.pubkTrimNewLines("\n4242"));
    assertEquals("4242", EncryptionUtil.pubkTrimNewLines("\r4242"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when a string")
  void testPubkTrimNewLines_whenAString() {
    // Arrange, Act and Assert
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines(
            "-----BEGIN PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common"
                + ".msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines(
            "-----END PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common"
                + ".msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines(
            "org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN PUBLIC KEY-----org.thingsboard.server.common"
                + ".msg.EncryptionUtil"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN PUBLIC KEY-----42-----BEGIN PUBLIC KEY-----}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----BEGIN PUBLIC KEY-----42-----BEGIN PUBLIC KEY-----'; then return '42'")
  void testPubkTrimNewLines_whenBeginPublicKey42BeginPublicKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----42-----BEGIN PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN PUBLIC KEY-----42-----END PUBLIC KEY-----}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----BEGIN PUBLIC KEY-----42-----END PUBLIC KEY-----'; then return '42'")
  void testPubkTrimNewLines_whenBeginPublicKey42EndPublicKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----42-----END PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN PUBLIC KEY-----42Input}.</li>
   *   <li>Then return {@code 42Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----BEGIN PUBLIC KEY-----42Input'; then return '42Input'")
  void testPubkTrimNewLines_whenBeginPublicKey42Input_thenReturn42Input() {
    // Arrange, Act and Assert
    assertEquals("42Input", EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----42Input"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN PUBLIC KEY-----42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----BEGIN PUBLIC KEY-----42'; then return '42'")
  void testPubkTrimNewLines_whenBeginPublicKey42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----42"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----\n42"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----\r42"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----42\n"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----42\r"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("\n-----BEGIN PUBLIC KEY-----42"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("\r-----BEGIN PUBLIC KEY-----42"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN PUBLIC KEY-----4242}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----BEGIN PUBLIC KEY-----4242'; then return '4242'")
  void testPubkTrimNewLines_whenBeginPublicKey4242_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----4242"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY-----42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY-----42'; then return '42'")
  void testPubkTrimNewLines_whenBeginPublicKeyBeginPublicKey42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY-----42"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY-----'")
  void testPubkTrimNewLines_whenBeginPublicKeyBeginPublicKeyBeginPublicKey() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil
        .pubkTrimNewLines("-----BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY----------END PUBLIC KEY-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY----------END PUBLIC KEY-----'")
  void testPubkTrimNewLines_whenBeginPublicKeyBeginPublicKeyEndPublicKey() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil
        .pubkTrimNewLines("-----BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY----------END PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY-----Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY-----Input'; then return 'Input'")
  void testPubkTrimNewLines_whenBeginPublicKeyBeginPublicKeyInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY-----Input"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY-----}.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY-----'; then return EMPTY_STRING")
  void testPubkTrimNewLines_whenBeginPublicKeyBeginPublicKey_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY-----\n"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY-----\r"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----\n-----BEGIN PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----\r-----BEGIN PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("\n-----BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("\r-----BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN PUBLIC KEY----------END PUBLIC KEY-----42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----BEGIN PUBLIC KEY----------END PUBLIC KEY-----42'; then return '42'")
  void testPubkTrimNewLines_whenBeginPublicKeyEndPublicKey42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY----------END PUBLIC KEY-----42"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN PUBLIC KEY----------END PUBLIC KEY----------BEGIN PUBLIC KEY-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----BEGIN PUBLIC KEY----------END PUBLIC KEY----------BEGIN PUBLIC KEY-----'")
  void testPubkTrimNewLines_whenBeginPublicKeyEndPublicKeyBeginPublicKey() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil
        .pubkTrimNewLines("-----BEGIN PUBLIC KEY----------END PUBLIC KEY----------BEGIN PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN PUBLIC KEY----------END PUBLIC KEY----------END PUBLIC KEY-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----BEGIN PUBLIC KEY----------END PUBLIC KEY----------END PUBLIC KEY-----'")
  void testPubkTrimNewLines_whenBeginPublicKeyEndPublicKeyEndPublicKey() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY----------END PUBLIC KEY----------END PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN PUBLIC KEY----------END PUBLIC KEY-----Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----BEGIN PUBLIC KEY----------END PUBLIC KEY-----Input'; then return 'Input'")
  void testPubkTrimNewLines_whenBeginPublicKeyEndPublicKeyInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY----------END PUBLIC KEY-----Input"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN PUBLIC KEY----------END PUBLIC KEY-----}.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----BEGIN PUBLIC KEY----------END PUBLIC KEY-----'; then return EMPTY_STRING")
  void testPubkTrimNewLines_whenBeginPublicKeyEndPublicKey_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY----------END PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----\n-----END PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----\r-----END PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY----------END PUBLIC KEY-----\n"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY----------END PUBLIC KEY-----\r"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("\n-----BEGIN PUBLIC KEY----------END PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("\r-----BEGIN PUBLIC KEY----------END PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN PUBLIC KEY-----Input42}.</li>
   *   <li>Then return {@code Input42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----BEGIN PUBLIC KEY-----Input42'; then return 'Input42'")
  void testPubkTrimNewLines_whenBeginPublicKeyInput42_thenReturnInput42() {
    // Arrange, Act and Assert
    assertEquals("Input42", EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----Input42"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN PUBLIC KEY-----Input-----BEGIN PUBLIC KEY-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----BEGIN PUBLIC KEY-----Input-----BEGIN PUBLIC KEY-----'; then return 'Input'")
  void testPubkTrimNewLines_whenBeginPublicKeyInputBeginPublicKey_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----Input-----BEGIN PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN PUBLIC KEY-----Input-----END PUBLIC KEY-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----BEGIN PUBLIC KEY-----Input-----END PUBLIC KEY-----'; then return 'Input'")
  void testPubkTrimNewLines_whenBeginPublicKeyInputEndPublicKey_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----Input-----END PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN PUBLIC KEY-----InputInput}.</li>
   *   <li>Then return {@code InputInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----BEGIN PUBLIC KEY-----InputInput'; then return 'InputInput'")
  void testPubkTrimNewLines_whenBeginPublicKeyInputInput_thenReturnInputInput() {
    // Arrange, Act and Assert
    assertEquals("InputInput", EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----InputInput"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN PUBLIC KEY-----Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----BEGIN PUBLIC KEY-----Input'; then return 'Input'")
  void testPubkTrimNewLines_whenBeginPublicKeyInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----Input"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----\nInput"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----\rInput"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----Input\n"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----Input\r"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("\n-----BEGIN PUBLIC KEY-----Input"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("\r-----BEGIN PUBLIC KEY-----Input"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN PUBLIC KEY-----}.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----BEGIN PUBLIC KEY-----'; then return EMPTY_STRING")
  void testPubkTrimNewLines_whenBeginPublicKey_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\n-----BEGIN PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\r-----BEGIN PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----\n\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----\n\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----\r\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("-----BEGIN PUBLIC KEY-----\r\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\n-----BEGIN PUBLIC KEY-----\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\n-----BEGIN PUBLIC KEY-----\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\n\n-----BEGIN PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\n\r-----BEGIN PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\r-----BEGIN PUBLIC KEY-----\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\r-----BEGIN PUBLIC KEY-----\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\r\n-----BEGIN PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\r\r-----BEGIN PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When cr cr cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when cr cr cr; then return EMPTY_STRING")
  void testPubkTrimNewLines_whenCrCrCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\r\r\r"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When cr cr lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when cr cr lf; then return EMPTY_STRING")
  void testPubkTrimNewLines_whenCrCrLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\r\r\n"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When cr cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when cr cr; then return EMPTY_STRING")
  void testPubkTrimNewLines_whenCrCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\r\r"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When cr lf cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when cr lf cr; then return EMPTY_STRING")
  void testPubkTrimNewLines_whenCrLfCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\r\n\r"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When cr lf lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when cr lf lf; then return EMPTY_STRING")
  void testPubkTrimNewLines_whenCrLfLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\r\n\n"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When cr lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when cr lf; then return EMPTY_STRING")
  void testPubkTrimNewLines_whenCrLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\r\n"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when cr; then return EMPTY_STRING")
  void testPubkTrimNewLines_whenCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\r"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END PUBLIC KEY-----42-----BEGIN PUBLIC KEY-----}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----END PUBLIC KEY-----42-----BEGIN PUBLIC KEY-----'; then return '42'")
  void testPubkTrimNewLines_whenEndPublicKey42BeginPublicKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----42-----BEGIN PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END PUBLIC KEY-----42-----END PUBLIC KEY-----}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----END PUBLIC KEY-----42-----END PUBLIC KEY-----'; then return '42'")
  void testPubkTrimNewLines_whenEndPublicKey42EndPublicKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----42-----END PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END PUBLIC KEY-----42Input}.</li>
   *   <li>Then return {@code 42Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----END PUBLIC KEY-----42Input'; then return '42Input'")
  void testPubkTrimNewLines_whenEndPublicKey42Input_thenReturn42Input() {
    // Arrange, Act and Assert
    assertEquals("42Input", EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----42Input"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END PUBLIC KEY-----42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----END PUBLIC KEY-----42'; then return '42'")
  void testPubkTrimNewLines_whenEndPublicKey42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----42"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("\n-----END PUBLIC KEY-----42"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("\r-----END PUBLIC KEY-----42"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----\n42"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----\r42"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----42\n"));
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----42\r"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END PUBLIC KEY-----4242}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----END PUBLIC KEY-----4242'; then return '4242'")
  void testPubkTrimNewLines_whenEndPublicKey4242_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----4242"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END PUBLIC KEY----------BEGIN PUBLIC KEY-----42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----END PUBLIC KEY----------BEGIN PUBLIC KEY-----42'; then return '42'")
  void testPubkTrimNewLines_whenEndPublicKeyBeginPublicKey42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY----------BEGIN PUBLIC KEY-----42"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END PUBLIC KEY----------BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----END PUBLIC KEY----------BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY-----'")
  void testPubkTrimNewLines_whenEndPublicKeyBeginPublicKeyBeginPublicKey() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil
        .pubkTrimNewLines("-----END PUBLIC KEY----------BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END PUBLIC KEY----------BEGIN PUBLIC KEY----------END PUBLIC KEY-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----END PUBLIC KEY----------BEGIN PUBLIC KEY----------END PUBLIC KEY-----'")
  void testPubkTrimNewLines_whenEndPublicKeyBeginPublicKeyEndPublicKey() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY----------BEGIN PUBLIC KEY----------END PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END PUBLIC KEY----------BEGIN PUBLIC KEY-----Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----END PUBLIC KEY----------BEGIN PUBLIC KEY-----Input'; then return 'Input'")
  void testPubkTrimNewLines_whenEndPublicKeyBeginPublicKeyInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY----------BEGIN PUBLIC KEY-----Input"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END PUBLIC KEY----------BEGIN PUBLIC KEY-----}.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----END PUBLIC KEY----------BEGIN PUBLIC KEY-----'; then return EMPTY_STRING")
  void testPubkTrimNewLines_whenEndPublicKeyBeginPublicKey_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY----------BEGIN PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("\n-----END PUBLIC KEY----------BEGIN PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("\r-----END PUBLIC KEY----------BEGIN PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY----------BEGIN PUBLIC KEY-----\n"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY----------BEGIN PUBLIC KEY-----\r"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----\n-----BEGIN PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----\r-----BEGIN PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END PUBLIC KEY----------END PUBLIC KEY-----42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----END PUBLIC KEY----------END PUBLIC KEY-----42'; then return '42'")
  void testPubkTrimNewLines_whenEndPublicKeyEndPublicKey42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY----------END PUBLIC KEY-----42"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END PUBLIC KEY----------END PUBLIC KEY----------BEGIN PUBLIC KEY-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----END PUBLIC KEY----------END PUBLIC KEY----------BEGIN PUBLIC KEY-----'")
  void testPubkTrimNewLines_whenEndPublicKeyEndPublicKeyBeginPublicKey() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY----------END PUBLIC KEY----------BEGIN PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END PUBLIC KEY----------END PUBLIC KEY----------END PUBLIC KEY-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----END PUBLIC KEY----------END PUBLIC KEY----------END PUBLIC KEY-----'")
  void testPubkTrimNewLines_whenEndPublicKeyEndPublicKeyEndPublicKey() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY----------END PUBLIC KEY----------END PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END PUBLIC KEY----------END PUBLIC KEY-----Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----END PUBLIC KEY----------END PUBLIC KEY-----Input'; then return 'Input'")
  void testPubkTrimNewLines_whenEndPublicKeyEndPublicKeyInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY----------END PUBLIC KEY-----Input"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END PUBLIC KEY----------END PUBLIC KEY-----}.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----END PUBLIC KEY----------END PUBLIC KEY-----'; then return EMPTY_STRING")
  void testPubkTrimNewLines_whenEndPublicKeyEndPublicKey_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY----------END PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("\n-----END PUBLIC KEY----------END PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("\r-----END PUBLIC KEY----------END PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----\n-----END PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----\r-----END PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY----------END PUBLIC KEY-----\n"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY----------END PUBLIC KEY-----\r"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END PUBLIC KEY-----Input42}.</li>
   *   <li>Then return {@code Input42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----END PUBLIC KEY-----Input42'; then return 'Input42'")
  void testPubkTrimNewLines_whenEndPublicKeyInput42_thenReturnInput42() {
    // Arrange, Act and Assert
    assertEquals("Input42", EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----Input42"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END PUBLIC KEY-----Input-----BEGIN PUBLIC KEY-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----END PUBLIC KEY-----Input-----BEGIN PUBLIC KEY-----'; then return 'Input'")
  void testPubkTrimNewLines_whenEndPublicKeyInputBeginPublicKey_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----Input-----BEGIN PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END PUBLIC KEY-----Input-----END PUBLIC KEY-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----END PUBLIC KEY-----Input-----END PUBLIC KEY-----'; then return 'Input'")
  void testPubkTrimNewLines_whenEndPublicKeyInputEndPublicKey_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----Input-----END PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END PUBLIC KEY-----InputInput}.</li>
   *   <li>Then return {@code InputInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----END PUBLIC KEY-----InputInput'; then return 'InputInput'")
  void testPubkTrimNewLines_whenEndPublicKeyInputInput_thenReturnInputInput() {
    // Arrange, Act and Assert
    assertEquals("InputInput", EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----InputInput"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END PUBLIC KEY-----Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----END PUBLIC KEY-----Input'; then return 'Input'")
  void testPubkTrimNewLines_whenEndPublicKeyInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----Input"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("\n-----END PUBLIC KEY-----Input"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("\r-----END PUBLIC KEY-----Input"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----\nInput"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----\rInput"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----Input\n"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----Input\r"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----END PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtil'")
  void testPubkTrimNewLines_whenEndPublicKeyOrgThingsboardServerCommonMsgEncryptionUtil() {
    // Arrange, Act and Assert
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("\n-----END PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("\r-----END PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----\rorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----org.thingsboard.server.common.msg.EncryptionUtil\r"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END PUBLIC KEY-----}.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when '-----END PUBLIC KEY-----'; then return EMPTY_STRING")
  void testPubkTrimNewLines_whenEndPublicKey_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\n-----END PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\r-----END PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\n\n-----END PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\n\r-----END PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\n-----END PUBLIC KEY-----\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\n-----END PUBLIC KEY-----\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\r\n-----END PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\r\r-----END PUBLIC KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\r-----END PUBLIC KEY-----\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\r-----END PUBLIC KEY-----\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----\n\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----\n\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----\r\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("-----END PUBLIC KEY-----\r\r"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input42-----BEGIN PUBLIC KEY-----}.</li>
   *   <li>Then return {@code Input42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when 'Input42-----BEGIN PUBLIC KEY-----'; then return 'Input42'")
  void testPubkTrimNewLines_whenInput42BeginPublicKey_thenReturnInput42() {
    // Arrange, Act and Assert
    assertEquals("Input42", EncryptionUtil.pubkTrimNewLines("Input42-----BEGIN PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input42-----END PUBLIC KEY-----}.</li>
   *   <li>Then return {@code Input42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when 'Input42-----END PUBLIC KEY-----'; then return 'Input42'")
  void testPubkTrimNewLines_whenInput42EndPublicKey_thenReturnInput42() {
    // Arrange, Act and Assert
    assertEquals("Input42", EncryptionUtil.pubkTrimNewLines("Input42-----END PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input42}.</li>
   *   <li>Then return {@code Input42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when 'Input42'; then return 'Input42'")
  void testPubkTrimNewLines_whenInput42_thenReturnInput42() {
    // Arrange, Act and Assert
    assertEquals("Input42", EncryptionUtil.pubkTrimNewLines("\nInput42"));
    assertEquals("Input42", EncryptionUtil.pubkTrimNewLines("\rInput42"));
    assertEquals("Input42", EncryptionUtil.pubkTrimNewLines("Input\n42"));
    assertEquals("Input42", EncryptionUtil.pubkTrimNewLines("Input\r42"));
    assertEquals("Input42", EncryptionUtil.pubkTrimNewLines("Input42\n"));
    assertEquals("Input42", EncryptionUtil.pubkTrimNewLines("Input42\r"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input-----BEGIN PUBLIC KEY-----42}.</li>
   *   <li>Then return {@code Input42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when 'Input-----BEGIN PUBLIC KEY-----42'; then return 'Input42'")
  void testPubkTrimNewLines_whenInputBeginPublicKey42_thenReturnInput42() {
    // Arrange, Act and Assert
    assertEquals("Input42", EncryptionUtil.pubkTrimNewLines("Input-----BEGIN PUBLIC KEY-----42"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code Input-----BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when 'Input-----BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY-----'; then return 'Input'")
  void testPubkTrimNewLines_whenInputBeginPublicKeyBeginPublicKey_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("Input-----BEGIN PUBLIC KEY----------BEGIN PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code Input-----BEGIN PUBLIC KEY----------END PUBLIC KEY-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when 'Input-----BEGIN PUBLIC KEY----------END PUBLIC KEY-----'; then return 'Input'")
  void testPubkTrimNewLines_whenInputBeginPublicKeyEndPublicKey_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("Input-----BEGIN PUBLIC KEY----------END PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input-----BEGIN PUBLIC KEY-----Input}.</li>
   *   <li>Then return {@code InputInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when 'Input-----BEGIN PUBLIC KEY-----Input'; then return 'InputInput'")
  void testPubkTrimNewLines_whenInputBeginPublicKeyInput_thenReturnInputInput() {
    // Arrange, Act and Assert
    assertEquals("InputInput", EncryptionUtil.pubkTrimNewLines("Input-----BEGIN PUBLIC KEY-----Input"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input-----BEGIN PUBLIC KEY-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when 'Input-----BEGIN PUBLIC KEY-----'; then return 'Input'")
  void testPubkTrimNewLines_whenInputBeginPublicKey_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("Input-----BEGIN PUBLIC KEY-----"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("\nInput-----BEGIN PUBLIC KEY-----"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("\rInput-----BEGIN PUBLIC KEY-----"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("Input-----BEGIN PUBLIC KEY-----\n"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("Input-----BEGIN PUBLIC KEY-----\r"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("Input\n-----BEGIN PUBLIC KEY-----"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("Input\r-----BEGIN PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input-----END PUBLIC KEY-----42}.</li>
   *   <li>Then return {@code Input42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when 'Input-----END PUBLIC KEY-----42'; then return 'Input42'")
  void testPubkTrimNewLines_whenInputEndPublicKey42_thenReturnInput42() {
    // Arrange, Act and Assert
    assertEquals("Input42", EncryptionUtil.pubkTrimNewLines("Input-----END PUBLIC KEY-----42"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code Input-----END PUBLIC KEY----------BEGIN PUBLIC KEY-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when 'Input-----END PUBLIC KEY----------BEGIN PUBLIC KEY-----'; then return 'Input'")
  void testPubkTrimNewLines_whenInputEndPublicKeyBeginPublicKey_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("Input-----END PUBLIC KEY----------BEGIN PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input-----END PUBLIC KEY----------END PUBLIC KEY-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when 'Input-----END PUBLIC KEY----------END PUBLIC KEY-----'; then return 'Input'")
  void testPubkTrimNewLines_whenInputEndPublicKeyEndPublicKey_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("Input-----END PUBLIC KEY----------END PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input-----END PUBLIC KEY-----Input}.</li>
   *   <li>Then return {@code InputInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when 'Input-----END PUBLIC KEY-----Input'; then return 'InputInput'")
  void testPubkTrimNewLines_whenInputEndPublicKeyInput_thenReturnInputInput() {
    // Arrange, Act and Assert
    assertEquals("InputInput", EncryptionUtil.pubkTrimNewLines("Input-----END PUBLIC KEY-----Input"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input-----END PUBLIC KEY-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when 'Input-----END PUBLIC KEY-----'; then return 'Input'")
  void testPubkTrimNewLines_whenInputEndPublicKey_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("Input-----END PUBLIC KEY-----"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("\nInput-----END PUBLIC KEY-----"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("\rInput-----END PUBLIC KEY-----"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("Input\n-----END PUBLIC KEY-----"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("Input\r-----END PUBLIC KEY-----"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("Input-----END PUBLIC KEY-----\n"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("Input-----END PUBLIC KEY-----\r"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code InputInput-----BEGIN PUBLIC KEY-----}.</li>
   *   <li>Then return {@code InputInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when 'InputInput-----BEGIN PUBLIC KEY-----'; then return 'InputInput'")
  void testPubkTrimNewLines_whenInputInputBeginPublicKey_thenReturnInputInput() {
    // Arrange, Act and Assert
    assertEquals("InputInput", EncryptionUtil.pubkTrimNewLines("InputInput-----BEGIN PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code InputInput-----END PUBLIC KEY-----}.</li>
   *   <li>Then return {@code InputInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when 'InputInput-----END PUBLIC KEY-----'; then return 'InputInput'")
  void testPubkTrimNewLines_whenInputInputEndPublicKey_thenReturnInputInput() {
    // Arrange, Act and Assert
    assertEquals("InputInput", EncryptionUtil.pubkTrimNewLines("InputInput-----END PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code InputInput}.</li>
   *   <li>Then return {@code InputInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when 'InputInput'; then return 'InputInput'")
  void testPubkTrimNewLines_whenInputInput_thenReturnInputInput() {
    // Arrange, Act and Assert
    assertEquals("InputInput", EncryptionUtil.pubkTrimNewLines("\nInputInput"));
    assertEquals("InputInput", EncryptionUtil.pubkTrimNewLines("\rInputInput"));
    assertEquals("InputInput", EncryptionUtil.pubkTrimNewLines("Input\nInput"));
    assertEquals("InputInput", EncryptionUtil.pubkTrimNewLines("Input\rInput"));
    assertEquals("InputInput", EncryptionUtil.pubkTrimNewLines("InputInput\n"));
    assertEquals("InputInput", EncryptionUtil.pubkTrimNewLines("InputInput\r"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input org.thingsboard.server.common.msg.EncryptionUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when 'Input org.thingsboard.server.common.msg.EncryptionUtil'")
  void testPubkTrimNewLines_whenInputOrgThingsboardServerCommonMsgEncryptionUtil() {
    // Arrange, Act and Assert
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("Input\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("Input\rorg.thingsboard.server.common.msg.EncryptionUtil"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when 'Input'; then return 'Input'")
  void testPubkTrimNewLines_whenInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("Input"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("\nInput"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("\rInput"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("Input\n"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("Input\r"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("\n\nInput"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("\n\rInput"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("\nInput\n"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("\nInput\r"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("\r\nInput"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("\r\rInput"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("\rInput\n"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("\rInput\r"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("Input\n\n"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("Input\n\r"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("Input\r\n"));
    assertEquals("Input", EncryptionUtil.pubkTrimNewLines("Input\r\r"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Inputorg.thingsboard.server.common.msg.EncryptionUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when 'Inputorg.thingsboard.server.common.msg.EncryptionUtil'")
  void testPubkTrimNewLines_whenInputorgThingsboardServerCommonMsgEncryptionUtil() {
    // Arrange, Act and Assert
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("\nInputorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("\rInputorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("Inputorg.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("Inputorg.thingsboard.server.common.msg.EncryptionUtil\r"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When lf cr cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when lf cr cr; then return EMPTY_STRING")
  void testPubkTrimNewLines_whenLfCrCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\n\r\r"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When lf cr lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when lf cr lf; then return EMPTY_STRING")
  void testPubkTrimNewLines_whenLfCrLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\n\r\n"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When lf cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when lf cr; then return EMPTY_STRING")
  void testPubkTrimNewLines_whenLfCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\n\r"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When lf lf cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when lf lf cr; then return EMPTY_STRING")
  void testPubkTrimNewLines_whenLfLfCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\n\n\r"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When lf lf lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when lf lf lf; then return EMPTY_STRING")
  void testPubkTrimNewLines_whenLfLfLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\n\n\n"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When lf lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when lf lf; then return EMPTY_STRING")
  void testPubkTrimNewLines_whenLfLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\n\n"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when lf; then return EMPTY_STRING")
  void testPubkTrimNewLines_whenLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.pubkTrimNewLines("\n"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code org.thingsboard.server.common.msg.EncryptionUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when 'org.thingsboard.server.common.msg.EncryptionUtil'")
  void testPubkTrimNewLines_whenOrgThingsboardServerCommonMsgEncryptionUtil() {
    // Arrange, Act and Assert
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("\rorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("org.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("org.thingsboard.server.common.msg.EncryptionUtil\r"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("\n\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("\n\rorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("\norg.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("\norg.thingsboard.server.common.msg.EncryptionUtil\r"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("\r\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("\r\rorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("\rorg.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("\rorg.thingsboard.server.common.msg.EncryptionUtil\r"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code org.thingsboard.server.common.msg.EncryptionUtil42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when 'org.thingsboard.server.common.msg.EncryptionUtil42'")
  void testPubkTrimNewLines_whenOrgThingsboardServerCommonMsgEncryptionUtil42() {
    // Arrange, Act and Assert
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil42",
        EncryptionUtil.pubkTrimNewLines("\norg.thingsboard.server.common.msg.EncryptionUtil42"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil42",
        EncryptionUtil.pubkTrimNewLines("\rorg.thingsboard.server.common.msg.EncryptionUtil42"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code org.thingsboard.server.common.msg.EncryptionUtil-----END PUBLIC KEY-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when 'org.thingsboard.server.common.msg.EncryptionUtil-----END PUBLIC KEY-----'")
  void testPubkTrimNewLines_whenOrgThingsboardServerCommonMsgEncryptionUtilEndPublicKey() {
    // Arrange, Act and Assert
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("org.thingsboard.server.common.msg.EncryptionUtil-----END PUBLIC KEY-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("\norg.thingsboard.server.common.msg.EncryptionUtil-----END PUBLIC KEY-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.pubkTrimNewLines("\rorg.thingsboard.server.common.msg.EncryptionUtil-----END PUBLIC KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#pubkTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code org.thingsboard.server.common.msg.EncryptionUtilInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#pubkTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test pubkTrimNewLines(String); when 'org.thingsboard.server.common.msg.EncryptionUtilInput'")
  void testPubkTrimNewLines_whenOrgThingsboardServerCommonMsgEncryptionUtilInput() {
    // Arrange, Act and Assert
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilInput",
        EncryptionUtil.pubkTrimNewLines("\norg.thingsboard.server.common.msg.EncryptionUtilInput"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilInput",
        EncryptionUtil.pubkTrimNewLines("\rorg.thingsboard.server.common.msg.EncryptionUtilInput"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String)")
  void testPrikTrimNewLines() {
    // Arrange, Act and Assert
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("-----END EC PRIVATE KEY-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN EC PRIVATE KEY-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("org.thingsboard.server.common.msg.EncryptionUtil-----END EC PRIVATE KEY-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----\rorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----Inputorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----org.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----org.thingsboard.server.common.msg.EncryptionUtil\r"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilInput", EncryptionUtil
        .prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----org.thingsboard.server.common.msg.EncryptionUtilInput"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines(
            "-----BEGIN EC PRIVATE KEY-----org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server"
                + ".common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil42", EncryptionUtil
        .prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----org.thingsboard.server.common.msg.EncryptionUtil42"));
    assertEquals("42org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----42org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("\n-----BEGIN EC PRIVATE KEY-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("\n-----END EC PRIVATE KEY-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("\norg.thingsboard.server.common.msg.EncryptionUtil-----BEGIN EC PRIVATE KEY-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("\norg.thingsboard.server.common.msg.EncryptionUtil-----END EC PRIVATE KEY-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines(
            "\norg.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("\r-----BEGIN EC PRIVATE KEY-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("\r-----END EC PRIVATE KEY-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("\rorg.thingsboard.server.common.msg.EncryptionUtil-----BEGIN EC PRIVATE KEY-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("\rorg.thingsboard.server.common.msg.EncryptionUtil-----END EC PRIVATE KEY-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines(
            "\rorg.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("-----END EC PRIVATE KEY-----\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("-----END EC PRIVATE KEY-----\rorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("-----END EC PRIVATE KEY-----Inputorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("-----END EC PRIVATE KEY-----org.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("-----END EC PRIVATE KEY-----org.thingsboard.server.common.msg.EncryptionUtil\r"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilInput", EncryptionUtil
        .prikTrimNewLines("-----END EC PRIVATE KEY-----org.thingsboard.server.common.msg.EncryptionUtilInput"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines(
            "-----END EC PRIVATE KEY-----org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server"
                + ".common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil42", EncryptionUtil
        .prikTrimNewLines("-----END EC PRIVATE KEY-----org.thingsboard.server.common.msg.EncryptionUtil42"));
    assertEquals("42org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("-----END EC PRIVATE KEY-----42org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("Input-----BEGIN EC PRIVATE KEY-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("Input-----END EC PRIVATE KEY-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("Inputorg.thingsboard.server.common.msg.EncryptionUtil-----BEGIN EC PRIVATE KEY-----"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("Inputorg.thingsboard.server.common.msg.EncryptionUtil-----END EC PRIVATE KEY-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN EC PRIVATE KEY-----\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil", EncryptionUtil
        .prikTrimNewLines("org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN EC PRIVATE KEY-----\r"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilInput", EncryptionUtil
        .prikTrimNewLines("org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN EC PRIVATE KEY-----Input"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines(
            "org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN EC PRIVATE KEY-----org.thingsboard.server"
                + ".common.msg.EncryptionUtil"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code 42-----BEGIN EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '42-----BEGIN EC PRIVATE KEY-----'; then return '42'")
  void testPrikTrimNewLines_when42BeginEcPrivateKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.prikTrimNewLines("42-----BEGIN EC PRIVATE KEY-----"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("\n42-----BEGIN EC PRIVATE KEY-----"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("\r42-----BEGIN EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code 42-----END EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '42-----END EC PRIVATE KEY-----'; then return '42'")
  void testPrikTrimNewLines_when42EndEcPrivateKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.prikTrimNewLines("42-----END EC PRIVATE KEY-----"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("\n42-----END EC PRIVATE KEY-----"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("\r42-----END EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code 42Input}.</li>
   *   <li>Then return {@code 42Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '42Input'; then return '42Input'")
  void testPrikTrimNewLines_when42Input_thenReturn42Input() {
    // Arrange, Act and Assert
    assertEquals("42Input", EncryptionUtil.prikTrimNewLines("\n42Input"));
    assertEquals("42Input", EncryptionUtil.prikTrimNewLines("\r42Input"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '42'; then return '42'")
  void testPrikTrimNewLines_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.prikTrimNewLines("\n42"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("\r42"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("42\n"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("42\r"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("\n\n42"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("\n\r42"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("\n42\n"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("\n42\r"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("\r\n42"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("\r\r42"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("\r42\n"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("\r42\r"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code 42org.thingsboard.server.common.msg.EncryptionUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '42org.thingsboard.server.common.msg.EncryptionUtil'")
  void testPrikTrimNewLines_when42orgThingsboardServerCommonMsgEncryptionUtil() {
    // Arrange, Act and Assert
    assertEquals("42org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines("\n42org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("42org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines("\r42org.thingsboard.server.common.msg.EncryptionUtil"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code 4242}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '4242'; then return '4242'")
  void testPrikTrimNewLines_when4242_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", EncryptionUtil.prikTrimNewLines("\n4242"));
    assertEquals("4242", EncryptionUtil.prikTrimNewLines("\r4242"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when a string")
  void testPrikTrimNewLines_whenAString() {
    // Arrange, Act and Assert
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines(
            "-----BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----org.thingsboard.server.common.msg"
                + ".EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines(
            "-----BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY-----org.thingsboard.server.common.msg"
                + ".EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines(
            "-----BEGIN EC PRIVATE KEY-----org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN EC PRIVATE"
                + " KEY-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines(
            "-----BEGIN EC PRIVATE KEY-----org.thingsboard.server.common.msg.EncryptionUtil-----END EC PRIVATE"
                + " KEY-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines(
            "-----END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----org.thingsboard.server.common.msg"
                + ".EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines(
            "-----END EC PRIVATE KEY----------END EC PRIVATE KEY-----org.thingsboard.server.common.msg"
                + ".EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines(
            "-----END EC PRIVATE KEY-----org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN EC PRIVATE"
                + " KEY-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines(
            "-----END EC PRIVATE KEY-----org.thingsboard.server.common.msg.EncryptionUtil-----END EC PRIVATE"
                + " KEY-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines(
            "org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE"
                + " KEY-----"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines(
            "org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN EC PRIVATE KEY----------END EC PRIVATE"
                + " KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN EC PRIVATE KEY-----42-----BEGIN EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----BEGIN EC PRIVATE KEY-----42-----BEGIN EC PRIVATE KEY-----'; then return '42'")
  void testPrikTrimNewLines_whenBeginEcPrivateKey42BeginEcPrivateKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42",
        EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----42-----BEGIN EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN EC PRIVATE KEY-----42-----END EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----BEGIN EC PRIVATE KEY-----42-----END EC PRIVATE KEY-----'; then return '42'")
  void testPrikTrimNewLines_whenBeginEcPrivateKey42EndEcPrivateKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----42-----END EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN EC PRIVATE KEY-----42Input}.</li>
   *   <li>Then return {@code 42Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----BEGIN EC PRIVATE KEY-----42Input'; then return '42Input'")
  void testPrikTrimNewLines_whenBeginEcPrivateKey42Input_thenReturn42Input() {
    // Arrange, Act and Assert
    assertEquals("42Input", EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----42Input"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN EC PRIVATE KEY-----42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----BEGIN EC PRIVATE KEY-----42'; then return '42'")
  void testPrikTrimNewLines_whenBeginEcPrivateKey42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----42"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----\n42"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----\r42"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----42\n"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----42\r"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("\n-----BEGIN EC PRIVATE KEY-----42"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("\r-----BEGIN EC PRIVATE KEY-----42"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN EC PRIVATE KEY-----4242}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----BEGIN EC PRIVATE KEY-----4242'; then return '4242'")
  void testPrikTrimNewLines_whenBeginEcPrivateKey4242_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----4242"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----'")
  void testPrikTrimNewLines_whenBeginEcPrivateKeyBeginEcPrivateKey() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----\n"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----\r"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----\n-----BEGIN EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----\r-----BEGIN EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("\n-----BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("\r-----BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----42'; then return '42'")
  void testPrikTrimNewLines_whenBeginEcPrivateKeyBeginEcPrivateKey42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42",
        EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----42"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----'")
  void testPrikTrimNewLines_whenBeginEcPrivateKeyBeginEcPrivateKeyBeginEcPrivateKey() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines(
        "-----BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY-----'")
  void testPrikTrimNewLines_whenBeginEcPrivateKeyBeginEcPrivateKeyEndEcPrivateKey() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil
        .prikTrimNewLines("-----BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----Input'; then return 'Input'")
  void testPrikTrimNewLines_whenBeginEcPrivateKeyBeginEcPrivateKeyInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input",
        EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----Input"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY-----42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY-----42'; then return '42'")
  void testPrikTrimNewLines_whenBeginEcPrivateKeyEndEcPrivateKey42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY-----42"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----'")
  void testPrikTrimNewLines_whenBeginEcPrivateKeyEndEcPrivateKeyBeginEcPrivateKey() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil
        .prikTrimNewLines("-----BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY----------END EC PRIVATE KEY-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY----------END EC PRIVATE KEY-----'")
  void testPrikTrimNewLines_whenBeginEcPrivateKeyEndEcPrivateKeyEndEcPrivateKey() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil
        .prikTrimNewLines("-----BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY----------END EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY-----Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY-----Input'; then return 'Input'")
  void testPrikTrimNewLines_whenBeginEcPrivateKeyEndEcPrivateKeyInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input",
        EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY-----Input"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY-----'; then return EMPTY_STRING")
  void testPrikTrimNewLines_whenBeginEcPrivateKeyEndEcPrivateKey_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----\n-----END EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----\r-----END EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY-----\n"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY-----\r"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("\n-----BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("\r-----BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN EC PRIVATE KEY-----Input42}.</li>
   *   <li>Then return {@code Input42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----BEGIN EC PRIVATE KEY-----Input42'; then return 'Input42'")
  void testPrikTrimNewLines_whenBeginEcPrivateKeyInput42_thenReturnInput42() {
    // Arrange, Act and Assert
    assertEquals("Input42", EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----Input42"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN EC PRIVATE KEY-----Input-----BEGIN EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----BEGIN EC PRIVATE KEY-----Input-----BEGIN EC PRIVATE KEY-----'; then return 'Input'")
  void testPrikTrimNewLines_whenBeginEcPrivateKeyInputBeginEcPrivateKey_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input",
        EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----Input-----BEGIN EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN EC PRIVATE KEY-----Input-----END EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----BEGIN EC PRIVATE KEY-----Input-----END EC PRIVATE KEY-----'; then return 'Input'")
  void testPrikTrimNewLines_whenBeginEcPrivateKeyInputEndEcPrivateKey_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input",
        EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----Input-----END EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN EC PRIVATE KEY-----InputInput}.</li>
   *   <li>Then return {@code InputInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----BEGIN EC PRIVATE KEY-----InputInput'; then return 'InputInput'")
  void testPrikTrimNewLines_whenBeginEcPrivateKeyInputInput_thenReturnInputInput() {
    // Arrange, Act and Assert
    assertEquals("InputInput", EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----InputInput"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN EC PRIVATE KEY-----Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----BEGIN EC PRIVATE KEY-----Input'; then return 'Input'")
  void testPrikTrimNewLines_whenBeginEcPrivateKeyInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----Input"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----\nInput"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----\rInput"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----Input\n"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----Input\r"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("\n-----BEGIN EC PRIVATE KEY-----Input"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("\r-----BEGIN EC PRIVATE KEY-----Input"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----BEGIN EC PRIVATE KEY-----'; then return EMPTY_STRING")
  void testPrikTrimNewLines_whenBeginEcPrivateKey_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\n-----BEGIN EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\r-----BEGIN EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----\n\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----\n\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----\r\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("-----BEGIN EC PRIVATE KEY-----\r\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\n-----BEGIN EC PRIVATE KEY-----\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\n-----BEGIN EC PRIVATE KEY-----\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\n\n-----BEGIN EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\n\r-----BEGIN EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\r-----BEGIN EC PRIVATE KEY-----\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\r-----BEGIN EC PRIVATE KEY-----\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\r\n-----BEGIN EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\r\r-----BEGIN EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When cr cr cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when cr cr cr; then return EMPTY_STRING")
  void testPrikTrimNewLines_whenCrCrCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\r\r\r"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When cr cr lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when cr cr lf; then return EMPTY_STRING")
  void testPrikTrimNewLines_whenCrCrLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\r\r\n"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When cr cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when cr cr; then return EMPTY_STRING")
  void testPrikTrimNewLines_whenCrCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\r\r"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When cr lf cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when cr lf cr; then return EMPTY_STRING")
  void testPrikTrimNewLines_whenCrLfCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\r\n\r"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When cr lf lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when cr lf lf; then return EMPTY_STRING")
  void testPrikTrimNewLines_whenCrLfLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\r\n\n"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When cr lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when cr lf; then return EMPTY_STRING")
  void testPrikTrimNewLines_whenCrLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\r\n"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when cr; then return EMPTY_STRING")
  void testPrikTrimNewLines_whenCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\r"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END EC PRIVATE KEY-----42-----BEGIN EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----END EC PRIVATE KEY-----42-----BEGIN EC PRIVATE KEY-----'; then return '42'")
  void testPrikTrimNewLines_whenEndEcPrivateKey42BeginEcPrivateKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----42-----BEGIN EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END EC PRIVATE KEY-----42-----END EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----END EC PRIVATE KEY-----42-----END EC PRIVATE KEY-----'; then return '42'")
  void testPrikTrimNewLines_whenEndEcPrivateKey42EndEcPrivateKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----42-----END EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END EC PRIVATE KEY-----42Input}.</li>
   *   <li>Then return {@code 42Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----END EC PRIVATE KEY-----42Input'; then return '42Input'")
  void testPrikTrimNewLines_whenEndEcPrivateKey42Input_thenReturn42Input() {
    // Arrange, Act and Assert
    assertEquals("42Input", EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----42Input"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END EC PRIVATE KEY-----42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----END EC PRIVATE KEY-----42'; then return '42'")
  void testPrikTrimNewLines_whenEndEcPrivateKey42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----42"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("\n-----END EC PRIVATE KEY-----42"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("\r-----END EC PRIVATE KEY-----42"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----\n42"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----\r42"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----42\n"));
    assertEquals("42", EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----42\r"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END EC PRIVATE KEY-----4242}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----END EC PRIVATE KEY-----4242'; then return '4242'")
  void testPrikTrimNewLines_whenEndEcPrivateKey4242_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----4242"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----42'; then return '42'")
  void testPrikTrimNewLines_whenEndEcPrivateKeyBeginEcPrivateKey42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----42"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----'")
  void testPrikTrimNewLines_whenEndEcPrivateKeyBeginEcPrivateKeyBeginEcPrivateKey() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil
        .prikTrimNewLines("-----END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY-----'")
  void testPrikTrimNewLines_whenEndEcPrivateKeyBeginEcPrivateKeyEndEcPrivateKey() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil
        .prikTrimNewLines("-----END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----Input'; then return 'Input'")
  void testPrikTrimNewLines_whenEndEcPrivateKeyBeginEcPrivateKeyInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input",
        EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----Input"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----'; then return EMPTY_STRING")
  void testPrikTrimNewLines_whenEndEcPrivateKeyBeginEcPrivateKey_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("\n-----END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("\r-----END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----\n"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----\r"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----\n-----BEGIN EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----\r-----BEGIN EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END EC PRIVATE KEY----------END EC PRIVATE KEY-----42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----END EC PRIVATE KEY----------END EC PRIVATE KEY-----42'; then return '42'")
  void testPrikTrimNewLines_whenEndEcPrivateKeyEndEcPrivateKey42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY----------END EC PRIVATE KEY-----42"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END EC PRIVATE KEY----------END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----END EC PRIVATE KEY----------END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----'")
  void testPrikTrimNewLines_whenEndEcPrivateKeyEndEcPrivateKeyBeginEcPrivateKey() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil
        .prikTrimNewLines("-----END EC PRIVATE KEY----------END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END EC PRIVATE KEY----------END EC PRIVATE KEY----------END EC PRIVATE KEY-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----END EC PRIVATE KEY----------END EC PRIVATE KEY----------END EC PRIVATE KEY-----'")
  void testPrikTrimNewLines_whenEndEcPrivateKeyEndEcPrivateKeyEndEcPrivateKey() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil
        .prikTrimNewLines("-----END EC PRIVATE KEY----------END EC PRIVATE KEY----------END EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END EC PRIVATE KEY----------END EC PRIVATE KEY-----Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----END EC PRIVATE KEY----------END EC PRIVATE KEY-----Input'; then return 'Input'")
  void testPrikTrimNewLines_whenEndEcPrivateKeyEndEcPrivateKeyInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input",
        EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY----------END EC PRIVATE KEY-----Input"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END EC PRIVATE KEY----------END EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----END EC PRIVATE KEY----------END EC PRIVATE KEY-----'; then return EMPTY_STRING")
  void testPrikTrimNewLines_whenEndEcPrivateKeyEndEcPrivateKey_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY----------END EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("\n-----END EC PRIVATE KEY----------END EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("\r-----END EC PRIVATE KEY----------END EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----\n-----END EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----\r-----END EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY----------END EC PRIVATE KEY-----\n"));
    assertEquals(TbMsg.EMPTY_STRING,
        EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY----------END EC PRIVATE KEY-----\r"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END EC PRIVATE KEY-----Input42}.</li>
   *   <li>Then return {@code Input42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----END EC PRIVATE KEY-----Input42'; then return 'Input42'")
  void testPrikTrimNewLines_whenEndEcPrivateKeyInput42_thenReturnInput42() {
    // Arrange, Act and Assert
    assertEquals("Input42", EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----Input42"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END EC PRIVATE KEY-----Input-----BEGIN EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----END EC PRIVATE KEY-----Input-----BEGIN EC PRIVATE KEY-----'; then return 'Input'")
  void testPrikTrimNewLines_whenEndEcPrivateKeyInputBeginEcPrivateKey_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input",
        EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----Input-----BEGIN EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code -----END EC PRIVATE KEY-----Input-----END EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----END EC PRIVATE KEY-----Input-----END EC PRIVATE KEY-----'; then return 'Input'")
  void testPrikTrimNewLines_whenEndEcPrivateKeyInputEndEcPrivateKey_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input",
        EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----Input-----END EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END EC PRIVATE KEY-----InputInput}.</li>
   *   <li>Then return {@code InputInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----END EC PRIVATE KEY-----InputInput'; then return 'InputInput'")
  void testPrikTrimNewLines_whenEndEcPrivateKeyInputInput_thenReturnInputInput() {
    // Arrange, Act and Assert
    assertEquals("InputInput", EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----InputInput"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END EC PRIVATE KEY-----Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----END EC PRIVATE KEY-----Input'; then return 'Input'")
  void testPrikTrimNewLines_whenEndEcPrivateKeyInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----Input"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("\n-----END EC PRIVATE KEY-----Input"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("\r-----END EC PRIVATE KEY-----Input"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----\nInput"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----\rInput"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----Input\n"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----Input\r"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code -----END EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when '-----END EC PRIVATE KEY-----'; then return EMPTY_STRING")
  void testPrikTrimNewLines_whenEndEcPrivateKey_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\n-----END EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\r-----END EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\n\n-----END EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\n\r-----END EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\n-----END EC PRIVATE KEY-----\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\n-----END EC PRIVATE KEY-----\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\r\n-----END EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\r\r-----END EC PRIVATE KEY-----"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\r-----END EC PRIVATE KEY-----\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\r-----END EC PRIVATE KEY-----\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----\n\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----\n\r"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----\r\n"));
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("-----END EC PRIVATE KEY-----\r\r"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input42-----BEGIN EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@code Input42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when 'Input42-----BEGIN EC PRIVATE KEY-----'; then return 'Input42'")
  void testPrikTrimNewLines_whenInput42BeginEcPrivateKey_thenReturnInput42() {
    // Arrange, Act and Assert
    assertEquals("Input42", EncryptionUtil.prikTrimNewLines("Input42-----BEGIN EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input42-----END EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@code Input42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when 'Input42-----END EC PRIVATE KEY-----'; then return 'Input42'")
  void testPrikTrimNewLines_whenInput42EndEcPrivateKey_thenReturnInput42() {
    // Arrange, Act and Assert
    assertEquals("Input42", EncryptionUtil.prikTrimNewLines("Input42-----END EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input42}.</li>
   *   <li>Then return {@code Input42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when 'Input42'; then return 'Input42'")
  void testPrikTrimNewLines_whenInput42_thenReturnInput42() {
    // Arrange, Act and Assert
    assertEquals("Input42", EncryptionUtil.prikTrimNewLines("\nInput42"));
    assertEquals("Input42", EncryptionUtil.prikTrimNewLines("\rInput42"));
    assertEquals("Input42", EncryptionUtil.prikTrimNewLines("Input\n42"));
    assertEquals("Input42", EncryptionUtil.prikTrimNewLines("Input\r42"));
    assertEquals("Input42", EncryptionUtil.prikTrimNewLines("Input42\n"));
    assertEquals("Input42", EncryptionUtil.prikTrimNewLines("Input42\r"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input-----BEGIN EC PRIVATE KEY-----42}.</li>
   *   <li>Then return {@code Input42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when 'Input-----BEGIN EC PRIVATE KEY-----42'; then return 'Input42'")
  void testPrikTrimNewLines_whenInputBeginEcPrivateKey42_thenReturnInput42() {
    // Arrange, Act and Assert
    assertEquals("Input42", EncryptionUtil.prikTrimNewLines("Input-----BEGIN EC PRIVATE KEY-----42"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code Input-----BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when 'Input-----BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----'; then return 'Input'")
  void testPrikTrimNewLines_whenInputBeginEcPrivateKeyBeginEcPrivateKey_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input",
        EncryptionUtil.prikTrimNewLines("Input-----BEGIN EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code Input-----BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when 'Input-----BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY-----'; then return 'Input'")
  void testPrikTrimNewLines_whenInputBeginEcPrivateKeyEndEcPrivateKey_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input",
        EncryptionUtil.prikTrimNewLines("Input-----BEGIN EC PRIVATE KEY----------END EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input-----BEGIN EC PRIVATE KEY-----Input}.</li>
   *   <li>Then return {@code InputInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when 'Input-----BEGIN EC PRIVATE KEY-----Input'; then return 'InputInput'")
  void testPrikTrimNewLines_whenInputBeginEcPrivateKeyInput_thenReturnInputInput() {
    // Arrange, Act and Assert
    assertEquals("InputInput", EncryptionUtil.prikTrimNewLines("Input-----BEGIN EC PRIVATE KEY-----Input"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input-----BEGIN EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when 'Input-----BEGIN EC PRIVATE KEY-----'; then return 'Input'")
  void testPrikTrimNewLines_whenInputBeginEcPrivateKey_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("Input-----BEGIN EC PRIVATE KEY-----"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("\nInput-----BEGIN EC PRIVATE KEY-----"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("\rInput-----BEGIN EC PRIVATE KEY-----"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("Input-----BEGIN EC PRIVATE KEY-----\n"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("Input-----BEGIN EC PRIVATE KEY-----\r"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("Input\n-----BEGIN EC PRIVATE KEY-----"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("Input\r-----BEGIN EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input-----END EC PRIVATE KEY-----42}.</li>
   *   <li>Then return {@code Input42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when 'Input-----END EC PRIVATE KEY-----42'; then return 'Input42'")
  void testPrikTrimNewLines_whenInputEndEcPrivateKey42_thenReturnInput42() {
    // Arrange, Act and Assert
    assertEquals("Input42", EncryptionUtil.prikTrimNewLines("Input-----END EC PRIVATE KEY-----42"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code Input-----END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when 'Input-----END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----'; then return 'Input'")
  void testPrikTrimNewLines_whenInputEndEcPrivateKeyBeginEcPrivateKey_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input",
        EncryptionUtil.prikTrimNewLines("Input-----END EC PRIVATE KEY----------BEGIN EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When
   * {@code Input-----END EC PRIVATE KEY----------END EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when 'Input-----END EC PRIVATE KEY----------END EC PRIVATE KEY-----'; then return 'Input'")
  void testPrikTrimNewLines_whenInputEndEcPrivateKeyEndEcPrivateKey_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input",
        EncryptionUtil.prikTrimNewLines("Input-----END EC PRIVATE KEY----------END EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input-----END EC PRIVATE KEY-----Input}.</li>
   *   <li>Then return {@code InputInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when 'Input-----END EC PRIVATE KEY-----Input'; then return 'InputInput'")
  void testPrikTrimNewLines_whenInputEndEcPrivateKeyInput_thenReturnInputInput() {
    // Arrange, Act and Assert
    assertEquals("InputInput", EncryptionUtil.prikTrimNewLines("Input-----END EC PRIVATE KEY-----Input"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input-----END EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when 'Input-----END EC PRIVATE KEY-----'; then return 'Input'")
  void testPrikTrimNewLines_whenInputEndEcPrivateKey_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("Input-----END EC PRIVATE KEY-----"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("\nInput-----END EC PRIVATE KEY-----"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("\rInput-----END EC PRIVATE KEY-----"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("Input\n-----END EC PRIVATE KEY-----"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("Input\r-----END EC PRIVATE KEY-----"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("Input-----END EC PRIVATE KEY-----\n"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("Input-----END EC PRIVATE KEY-----\r"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code InputInput-----BEGIN EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@code InputInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when 'InputInput-----BEGIN EC PRIVATE KEY-----'; then return 'InputInput'")
  void testPrikTrimNewLines_whenInputInputBeginEcPrivateKey_thenReturnInputInput() {
    // Arrange, Act and Assert
    assertEquals("InputInput", EncryptionUtil.prikTrimNewLines("InputInput-----BEGIN EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code InputInput-----END EC PRIVATE KEY-----}.</li>
   *   <li>Then return {@code InputInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when 'InputInput-----END EC PRIVATE KEY-----'; then return 'InputInput'")
  void testPrikTrimNewLines_whenInputInputEndEcPrivateKey_thenReturnInputInput() {
    // Arrange, Act and Assert
    assertEquals("InputInput", EncryptionUtil.prikTrimNewLines("InputInput-----END EC PRIVATE KEY-----"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code InputInput}.</li>
   *   <li>Then return {@code InputInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when 'InputInput'; then return 'InputInput'")
  void testPrikTrimNewLines_whenInputInput_thenReturnInputInput() {
    // Arrange, Act and Assert
    assertEquals("InputInput", EncryptionUtil.prikTrimNewLines("\nInputInput"));
    assertEquals("InputInput", EncryptionUtil.prikTrimNewLines("\rInputInput"));
    assertEquals("InputInput", EncryptionUtil.prikTrimNewLines("Input\nInput"));
    assertEquals("InputInput", EncryptionUtil.prikTrimNewLines("Input\rInput"));
    assertEquals("InputInput", EncryptionUtil.prikTrimNewLines("InputInput\n"));
    assertEquals("InputInput", EncryptionUtil.prikTrimNewLines("InputInput\r"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input org.thingsboard.server.common.msg.EncryptionUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when 'Input org.thingsboard.server.common.msg.EncryptionUtil'")
  void testPrikTrimNewLines_whenInputOrgThingsboardServerCommonMsgEncryptionUtil() {
    // Arrange, Act and Assert
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines("Input\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines("Input\rorg.thingsboard.server.common.msg.EncryptionUtil"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when 'Input'; then return 'Input'")
  void testPrikTrimNewLines_whenInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("Input"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("\nInput"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("\rInput"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("Input\n"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("Input\r"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("\n\nInput"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("\n\rInput"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("\nInput\n"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("\nInput\r"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("\r\nInput"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("\r\rInput"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("\rInput\n"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("\rInput\r"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("Input\n\n"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("Input\n\r"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("Input\r\n"));
    assertEquals("Input", EncryptionUtil.prikTrimNewLines("Input\r\r"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code Inputorg.thingsboard.server.common.msg.EncryptionUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when 'Inputorg.thingsboard.server.common.msg.EncryptionUtil'")
  void testPrikTrimNewLines_whenInputorgThingsboardServerCommonMsgEncryptionUtil() {
    // Arrange, Act and Assert
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines("\nInputorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines("\rInputorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines("Inputorg.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("Inputorg.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines("Inputorg.thingsboard.server.common.msg.EncryptionUtil\r"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When lf cr cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when lf cr cr; then return EMPTY_STRING")
  void testPrikTrimNewLines_whenLfCrCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\n\r\r"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When lf cr lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when lf cr lf; then return EMPTY_STRING")
  void testPrikTrimNewLines_whenLfCrLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\n\r\n"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When lf cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when lf cr; then return EMPTY_STRING")
  void testPrikTrimNewLines_whenLfCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\n\r"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When lf lf cr.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when lf lf cr; then return EMPTY_STRING")
  void testPrikTrimNewLines_whenLfLfCr_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\n\n\r"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When lf lf lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when lf lf lf; then return EMPTY_STRING")
  void testPrikTrimNewLines_whenLfLfLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\n\n\n"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When lf lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when lf lf; then return EMPTY_STRING")
  void testPrikTrimNewLines_whenLfLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\n\n"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then return {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when lf; then return EMPTY_STRING")
  void testPrikTrimNewLines_whenLf_thenReturnEmpty_string() {
    // Arrange, Act and Assert
    assertEquals(TbMsg.EMPTY_STRING, EncryptionUtil.prikTrimNewLines("\n"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code org.thingsboard.server.common.msg.EncryptionUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when 'org.thingsboard.server.common.msg.EncryptionUtil'")
  void testPrikTrimNewLines_whenOrgThingsboardServerCommonMsgEncryptionUtil() {
    // Arrange, Act and Assert
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines("\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines("\rorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines("org.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines("org.thingsboard.server.common.msg.EncryptionUtil\r"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines("\n\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines("\n\rorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines("\norg.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines("\norg.thingsboard.server.common.msg.EncryptionUtil\r"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines("\r\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines("\r\rorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines("\rorg.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil",
        EncryptionUtil.prikTrimNewLines("\rorg.thingsboard.server.common.msg.EncryptionUtil\r"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code org.thingsboard.server.common.msg.EncryptionUtil42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when 'org.thingsboard.server.common.msg.EncryptionUtil42'")
  void testPrikTrimNewLines_whenOrgThingsboardServerCommonMsgEncryptionUtil42() {
    // Arrange, Act and Assert
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil42",
        EncryptionUtil.prikTrimNewLines("\norg.thingsboard.server.common.msg.EncryptionUtil42"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtil42",
        EncryptionUtil.prikTrimNewLines("\rorg.thingsboard.server.common.msg.EncryptionUtil42"));
  }

  /**
   * Test {@link EncryptionUtil#prikTrimNewLines(String)}.
   * <ul>
   *   <li>When {@code org.thingsboard.server.common.msg.EncryptionUtilInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#prikTrimNewLines(String)}
   */
  @Test
  @DisplayName("Test prikTrimNewLines(String); when 'org.thingsboard.server.common.msg.EncryptionUtilInput'")
  void testPrikTrimNewLines_whenOrgThingsboardServerCommonMsgEncryptionUtilInput() {
    // Arrange, Act and Assert
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilInput",
        EncryptionUtil.prikTrimNewLines("\norg.thingsboard.server.common.msg.EncryptionUtilInput"));
    assertEquals("org.thingsboard.server.common.msg.EncryptionUtilInput",
        EncryptionUtil.prikTrimNewLines("\rorg.thingsboard.server.common.msg.EncryptionUtilInput"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'")
  void testGetSha3HashWithData() {
    // Arrange, Act and Assert
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil-----END CERTIFICATE-----"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----\rorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a", EncryptionUtil.getSha3Hash(
        "-----BEGIN CERTIFICATE----------END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("133758e9322074cb0349537bd1ff5656746f81fbee7fa766b0b831293b716c98",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----Dataorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil\r"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a", EncryptionUtil.getSha3Hash(
        "-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil-----END CERTIFICATE-----"));
    assertEquals("164a5014e755fc1998d3bfe6ad0bbcf6285fff1ef921908efdf254df50cd5830",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtilData"));
    assertEquals("26b0b812bd9a29778537005cbecb93a83a9b6442016ae447828136e1c66b4c37",
        EncryptionUtil.getSha3Hash(
            "-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server"
                + ".common.msg.EncryptionUtil"));
    assertEquals("ee3019e7b2a1b39ad7d018afaf798bb7eb88b4f7f6fb1296d202a02f6c4c0583",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil42"));
    assertEquals("f2629d8d190200631f0a521266621771aef1c371c025381e44ceca7cbaad5ff0",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----42org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("\n-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("\n-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("\norg.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("\norg.thingsboard.server.common.msg.EncryptionUtil-----END CERTIFICATE-----"));
    assertEquals("26b0b812bd9a29778537005cbecb93a83a9b6442016ae447828136e1c66b4c37", EncryptionUtil.getSha3Hash(
        "\norg.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("\r-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("\r-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("\rorg.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("\rorg.thingsboard.server.common.msg.EncryptionUtil-----END CERTIFICATE-----"));
    assertEquals("26b0b812bd9a29778537005cbecb93a83a9b6442016ae447828136e1c66b4c37", EncryptionUtil.getSha3Hash(
        "\rorg.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a", EncryptionUtil.getSha3Hash(
        "-----END CERTIFICATE----------BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----\rorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a", EncryptionUtil.getSha3Hash(
        "-----END CERTIFICATE----------END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("133758e9322074cb0349537bd1ff5656746f81fbee7fa766b0b831293b716c98",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----Dataorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a", EncryptionUtil.getSha3Hash(
        "-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil\r"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a", EncryptionUtil.getSha3Hash(
        "-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil-----END CERTIFICATE-----"));
    assertEquals("164a5014e755fc1998d3bfe6ad0bbcf6285fff1ef921908efdf254df50cd5830",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtilData"));
    assertEquals("26b0b812bd9a29778537005cbecb93a83a9b6442016ae447828136e1c66b4c37",
        EncryptionUtil.getSha3Hash(
            "-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtilorg.thingsboard.server.common"
                + ".msg.EncryptionUtil"));
    assertEquals("ee3019e7b2a1b39ad7d018afaf798bb7eb88b4f7f6fb1296d202a02f6c4c0583",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil42"));
    assertEquals("f2629d8d190200631f0a521266621771aef1c371c025381e44ceca7cbaad5ff0",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----42org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("133758e9322074cb0349537bd1ff5656746f81fbee7fa766b0b831293b716c98",
        EncryptionUtil.getSha3Hash("Data-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("133758e9322074cb0349537bd1ff5656746f81fbee7fa766b0b831293b716c98",
        EncryptionUtil.getSha3Hash("Data-----END CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("133758e9322074cb0349537bd1ff5656746f81fbee7fa766b0b831293b716c98",
        EncryptionUtil.getSha3Hash("Dataorg.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----"));
    assertEquals("133758e9322074cb0349537bd1ff5656746f81fbee7fa766b0b831293b716c98",
        EncryptionUtil.getSha3Hash("Dataorg.thingsboard.server.common.msg.EncryptionUtil-----END CERTIFICATE-----"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----\n"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----\r"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a", EncryptionUtil.getSha3Hash(
        "org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE----------END CERTIFICATE-----"));
    assertEquals("164a5014e755fc1998d3bfe6ad0bbcf6285fff1ef921908efdf254df50cd5830",
        EncryptionUtil.getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----Data"));
    assertEquals("26b0b812bd9a29778537005cbecb93a83a9b6442016ae447828136e1c66b4c37",
        EncryptionUtil.getSha3Hash(
            "org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE-----org.thingsboard.server"
                + ".common.msg.EncryptionUtil"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '42'")
  void testGetSha3HashWithData_when42() {
    // Arrange, Act and Assert
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("\n42"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("\r42"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("42\n"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("42\r"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("\n\n42"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("\n\r42"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("\n42\n"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("\n42\r"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("\r\n42"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("\r\r42"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("\r42\n"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("\r42\r"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code 42-----BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '42-----BEGIN CERTIFICATE-----'")
  void testGetSha3HashWithData_when42BeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("42-----BEGIN CERTIFICATE-----"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("\n42-----BEGIN CERTIFICATE-----"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("\r42-----BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code 42Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '42Data'")
  void testGetSha3HashWithData_when42Data() {
    // Arrange, Act and Assert
    assertEquals("d73386e5499303a98da6630c7c7823a8b55475d45a9cd94f5cb86fff070d6fe5",
        EncryptionUtil.getSha3Hash("\n42Data"));
    assertEquals("d73386e5499303a98da6630c7c7823a8b55475d45a9cd94f5cb86fff070d6fe5",
        EncryptionUtil.getSha3Hash("\r42Data"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code 42-----END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '42-----END CERTIFICATE-----'")
  void testGetSha3HashWithData_when42EndCertificate() {
    // Arrange, Act and Assert
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("42-----END CERTIFICATE-----"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("\n42-----END CERTIFICATE-----"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("\r42-----END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code 42org.thingsboard.server.common.msg.EncryptionUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '42org.thingsboard.server.common.msg.EncryptionUtil'")
  void testGetSha3HashWithData_when42orgThingsboardServerCommonMsgEncryptionUtil() {
    // Arrange, Act and Assert
    assertEquals("f2629d8d190200631f0a521266621771aef1c371c025381e44ceca7cbaad5ff0",
        EncryptionUtil.getSha3Hash("\n42org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("f2629d8d190200631f0a521266621771aef1c371c025381e44ceca7cbaad5ff0",
        EncryptionUtil.getSha3Hash("\r42org.thingsboard.server.common.msg.EncryptionUtil"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '4242'")
  void testGetSha3HashWithData_when4242() {
    // Arrange, Act and Assert
    assertEquals("46cd1951574c887e3c703c2da9b9ce0dc1c53909f790dd4c6301787cb16ac6b1",
        EncryptionUtil.getSha3Hash("\n4242"));
    assertEquals("46cd1951574c887e3c703c2da9b9ce0dc1c53909f790dd4c6301787cb16ac6b1",
        EncryptionUtil.getSha3Hash("\r4242"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when a string")
  void testGetSha3HashWithData_whenAString() {
    // Arrange, Act and Assert
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a", EncryptionUtil.getSha3Hash(
        "-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----org.thingsboard.server.common.msg" + ".EncryptionUtil"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a", EncryptionUtil.getSha3Hash(
        "-----BEGIN CERTIFICATE-----org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN" + " CERTIFICATE-----"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a", EncryptionUtil.getSha3Hash(
        "org.thingsboard.server.common.msg.EncryptionUtil-----BEGIN CERTIFICATE----------BEGIN" + " CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----BEGIN CERTIFICATE-----'")
  void testGetSha3HashWithData_whenBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----\n"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----\r"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\n-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\r-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----\n\n"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----\n\r"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----\r\n"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----\r\r"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\n-----BEGIN CERTIFICATE-----\n"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\n-----BEGIN CERTIFICATE-----\r"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\n\n-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\n\r-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\r-----BEGIN CERTIFICATE-----\n"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\r-----BEGIN CERTIFICATE-----\r"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\r\n-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\r\r-----BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----BEGIN CERTIFICATE-----42'")
  void testGetSha3HashWithData_whenBeginCertificate42() {
    // Arrange, Act and Assert
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----42"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----\n42"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----\r42"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----42\n"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----42\r"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("\n-----BEGIN CERTIFICATE-----42"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("\r-----BEGIN CERTIFICATE-----42"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN CERTIFICATE-----42-----BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----BEGIN CERTIFICATE-----42-----BEGIN CERTIFICATE-----'")
  void testGetSha3HashWithData_whenBeginCertificate42BeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----42-----BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----42Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----BEGIN CERTIFICATE-----42Data'")
  void testGetSha3HashWithData_whenBeginCertificate42Data() {
    // Arrange, Act and Assert
    assertEquals("d73386e5499303a98da6630c7c7823a8b55475d45a9cd94f5cb86fff070d6fe5",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----42Data"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----42-----END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----BEGIN CERTIFICATE-----42-----END CERTIFICATE-----'")
  void testGetSha3HashWithData_whenBeginCertificate42EndCertificate() {
    // Arrange, Act and Assert
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----42-----END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----BEGIN CERTIFICATE-----4242'")
  void testGetSha3HashWithData_whenBeginCertificate4242() {
    // Arrange, Act and Assert
    assertEquals("46cd1951574c887e3c703c2da9b9ce0dc1c53909f790dd4c6301787cb16ac6b1",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----4242"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----'")
  void testGetSha3HashWithData_whenBeginCertificateBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----\n"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----\r"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----\n-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----\r-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\n-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\r-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----42'")
  void testGetSha3HashWithData_whenBeginCertificateBeginCertificate42() {
    // Arrange, Act and Assert
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----42"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN CERTIFICATE----------BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----'")
  void testGetSha3HashWithData_whenBeginCertificateBeginCertificateBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a", EncryptionUtil
        .getSha3Hash("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----Data'")
  void testGetSha3HashWithData_whenBeginCertificateBeginCertificateData() {
    // Arrange, Act and Assert
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----Data"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN CERTIFICATE----------BEGIN CERTIFICATE----------END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE----------END CERTIFICATE-----'")
  void testGetSha3HashWithData_whenBeginCertificateBeginCertificateEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE----------END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----BEGIN CERTIFICATE-----Data'")
  void testGetSha3HashWithData_whenBeginCertificateData() {
    // Arrange, Act and Assert
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----Data"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----\nData"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----\rData"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----Data\n"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----Data\r"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("\n-----BEGIN CERTIFICATE-----Data"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("\r-----BEGIN CERTIFICATE-----Data"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----Data42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----BEGIN CERTIFICATE-----Data42'")
  void testGetSha3HashWithData_whenBeginCertificateData42() {
    // Arrange, Act and Assert
    assertEquals("bdde8029a0ae8aea16f03d8f3ac14b9f7a9245480a6c2123d464962bd083f43f",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----Data42"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN CERTIFICATE-----Data-----BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----BEGIN CERTIFICATE-----Data-----BEGIN CERTIFICATE-----'")
  void testGetSha3HashWithData_whenBeginCertificateDataBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----Data-----BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----DataData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----BEGIN CERTIFICATE-----DataData'")
  void testGetSha3HashWithData_whenBeginCertificateDataData() {
    // Arrange, Act and Assert
    assertEquals("b2dfc23002ae9d45d6fd14abd233d4cf0452aa9310efc80ffebb5f3a82f478ed",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----DataData"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN CERTIFICATE-----Data-----END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----BEGIN CERTIFICATE-----Data-----END CERTIFICATE-----'")
  void testGetSha3HashWithData_whenBeginCertificateDataEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----Data-----END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE----------END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----BEGIN CERTIFICATE----------END CERTIFICATE-----'")
  void testGetSha3HashWithData_whenBeginCertificateEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE----------END CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----\n-----END CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----\r-----END CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE----------END CERTIFICATE-----\n"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE----------END CERTIFICATE-----\r"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\n-----BEGIN CERTIFICATE----------END CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\r-----BEGIN CERTIFICATE----------END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE----------END CERTIFICATE-----42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----BEGIN CERTIFICATE----------END CERTIFICATE-----42'")
  void testGetSha3HashWithData_whenBeginCertificateEndCertificate42() {
    // Arrange, Act and Assert
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE----------END CERTIFICATE-----42"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN CERTIFICATE----------END CERTIFICATE----------BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----BEGIN CERTIFICATE----------END CERTIFICATE----------BEGIN CERTIFICATE-----'")
  void testGetSha3HashWithData_whenBeginCertificateEndCertificateBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE----------END CERTIFICATE----------BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN CERTIFICATE----------END CERTIFICATE-----Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----BEGIN CERTIFICATE----------END CERTIFICATE-----Data'")
  void testGetSha3HashWithData_whenBeginCertificateEndCertificateData() {
    // Arrange, Act and Assert
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE----------END CERTIFICATE-----Data"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When
   * {@code -----BEGIN CERTIFICATE----------END CERTIFICATE----------END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----BEGIN CERTIFICATE----------END CERTIFICATE----------END CERTIFICATE-----'")
  void testGetSha3HashWithData_whenBeginCertificateEndCertificateEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE----------END CERTIFICATE----------END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When cr.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when cr")
  void testGetSha3HashWithData_whenCr() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a", EncryptionUtil.getSha3Hash("\r"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When cr cr.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when cr cr")
  void testGetSha3HashWithData_whenCrCr() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\r\r"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When cr cr cr.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when cr cr cr")
  void testGetSha3HashWithData_whenCrCrCr() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\r\r\r"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When cr cr lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when cr cr lf")
  void testGetSha3HashWithData_whenCrCrLf() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\r\r\n"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When cr lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when cr lf")
  void testGetSha3HashWithData_whenCrLf() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\r\n"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When cr lf cr.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when cr lf cr")
  void testGetSha3HashWithData_whenCrLfCr() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\r\n\r"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When cr lf lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when cr lf lf")
  void testGetSha3HashWithData_whenCrLfLf() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\r\n\n"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when 'Data'")
  void testGetSha3HashWithData_whenData() {
    // Arrange, Act and Assert
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("Data"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("\nData"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("\rData"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("Data\n"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("Data\r"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("\n\nData"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("\n\rData"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("\nData\n"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("\nData\r"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("\r\nData"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("\r\rData"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("\rData\n"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("\rData\r"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("Data\n\n"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("Data\n\r"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("Data\r\n"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("Data\r\r"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code Data42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when 'Data42'")
  void testGetSha3HashWithData_whenData42() {
    // Arrange, Act and Assert
    assertEquals("bdde8029a0ae8aea16f03d8f3ac14b9f7a9245480a6c2123d464962bd083f43f",
        EncryptionUtil.getSha3Hash("\nData42"));
    assertEquals("bdde8029a0ae8aea16f03d8f3ac14b9f7a9245480a6c2123d464962bd083f43f",
        EncryptionUtil.getSha3Hash("\rData42"));
    assertEquals("bdde8029a0ae8aea16f03d8f3ac14b9f7a9245480a6c2123d464962bd083f43f",
        EncryptionUtil.getSha3Hash("Data\n42"));
    assertEquals("bdde8029a0ae8aea16f03d8f3ac14b9f7a9245480a6c2123d464962bd083f43f",
        EncryptionUtil.getSha3Hash("Data\r42"));
    assertEquals("bdde8029a0ae8aea16f03d8f3ac14b9f7a9245480a6c2123d464962bd083f43f",
        EncryptionUtil.getSha3Hash("Data42\n"));
    assertEquals("bdde8029a0ae8aea16f03d8f3ac14b9f7a9245480a6c2123d464962bd083f43f",
        EncryptionUtil.getSha3Hash("Data42\r"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code Data42-----BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when 'Data42-----BEGIN CERTIFICATE-----'")
  void testGetSha3HashWithData_whenData42BeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("bdde8029a0ae8aea16f03d8f3ac14b9f7a9245480a6c2123d464962bd083f43f",
        EncryptionUtil.getSha3Hash("Data42-----BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code Data42-----END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when 'Data42-----END CERTIFICATE-----'")
  void testGetSha3HashWithData_whenData42EndCertificate() {
    // Arrange, Act and Assert
    assertEquals("bdde8029a0ae8aea16f03d8f3ac14b9f7a9245480a6c2123d464962bd083f43f",
        EncryptionUtil.getSha3Hash("Data42-----END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code Data-----BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when 'Data-----BEGIN CERTIFICATE-----'")
  void testGetSha3HashWithData_whenDataBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("Data-----BEGIN CERTIFICATE-----"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("\nData-----BEGIN CERTIFICATE-----"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("\rData-----BEGIN CERTIFICATE-----"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("Data-----BEGIN CERTIFICATE-----\n"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("Data-----BEGIN CERTIFICATE-----\r"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("Data\n-----BEGIN CERTIFICATE-----"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("Data\r-----BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code Data-----BEGIN CERTIFICATE-----42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when 'Data-----BEGIN CERTIFICATE-----42'")
  void testGetSha3HashWithData_whenDataBeginCertificate42() {
    // Arrange, Act and Assert
    assertEquals("bdde8029a0ae8aea16f03d8f3ac14b9f7a9245480a6c2123d464962bd083f43f",
        EncryptionUtil.getSha3Hash("Data-----BEGIN CERTIFICATE-----42"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When
   * {@code Data-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when 'Data-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----'")
  void testGetSha3HashWithData_whenDataBeginCertificateBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("Data-----BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code Data-----BEGIN CERTIFICATE-----Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when 'Data-----BEGIN CERTIFICATE-----Data'")
  void testGetSha3HashWithData_whenDataBeginCertificateData() {
    // Arrange, Act and Assert
    assertEquals("b2dfc23002ae9d45d6fd14abd233d4cf0452aa9310efc80ffebb5f3a82f478ed",
        EncryptionUtil.getSha3Hash("Data-----BEGIN CERTIFICATE-----Data"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When
   * {@code Data-----BEGIN CERTIFICATE----------END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when 'Data-----BEGIN CERTIFICATE----------END CERTIFICATE-----'")
  void testGetSha3HashWithData_whenDataBeginCertificateEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("Data-----BEGIN CERTIFICATE----------END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code DataData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when 'DataData'")
  void testGetSha3HashWithData_whenDataData() {
    // Arrange, Act and Assert
    assertEquals("b2dfc23002ae9d45d6fd14abd233d4cf0452aa9310efc80ffebb5f3a82f478ed",
        EncryptionUtil.getSha3Hash("\nDataData"));
    assertEquals("b2dfc23002ae9d45d6fd14abd233d4cf0452aa9310efc80ffebb5f3a82f478ed",
        EncryptionUtil.getSha3Hash("\rDataData"));
    assertEquals("b2dfc23002ae9d45d6fd14abd233d4cf0452aa9310efc80ffebb5f3a82f478ed",
        EncryptionUtil.getSha3Hash("Data\nData"));
    assertEquals("b2dfc23002ae9d45d6fd14abd233d4cf0452aa9310efc80ffebb5f3a82f478ed",
        EncryptionUtil.getSha3Hash("Data\rData"));
    assertEquals("b2dfc23002ae9d45d6fd14abd233d4cf0452aa9310efc80ffebb5f3a82f478ed",
        EncryptionUtil.getSha3Hash("DataData\n"));
    assertEquals("b2dfc23002ae9d45d6fd14abd233d4cf0452aa9310efc80ffebb5f3a82f478ed",
        EncryptionUtil.getSha3Hash("DataData\r"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code DataData-----BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when 'DataData-----BEGIN CERTIFICATE-----'")
  void testGetSha3HashWithData_whenDataDataBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("b2dfc23002ae9d45d6fd14abd233d4cf0452aa9310efc80ffebb5f3a82f478ed",
        EncryptionUtil.getSha3Hash("DataData-----BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code DataData-----END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when 'DataData-----END CERTIFICATE-----'")
  void testGetSha3HashWithData_whenDataDataEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("b2dfc23002ae9d45d6fd14abd233d4cf0452aa9310efc80ffebb5f3a82f478ed",
        EncryptionUtil.getSha3Hash("DataData-----END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code Data-----END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when 'Data-----END CERTIFICATE-----'")
  void testGetSha3HashWithData_whenDataEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("Data-----END CERTIFICATE-----"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("\nData-----END CERTIFICATE-----"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("\rData-----END CERTIFICATE-----"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("Data\n-----END CERTIFICATE-----"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("Data\r-----END CERTIFICATE-----"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("Data-----END CERTIFICATE-----\n"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("Data-----END CERTIFICATE-----\r"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code Data-----END CERTIFICATE-----42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when 'Data-----END CERTIFICATE-----42'")
  void testGetSha3HashWithData_whenDataEndCertificate42() {
    // Arrange, Act and Assert
    assertEquals("bdde8029a0ae8aea16f03d8f3ac14b9f7a9245480a6c2123d464962bd083f43f",
        EncryptionUtil.getSha3Hash("Data-----END CERTIFICATE-----42"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When
   * {@code Data-----END CERTIFICATE----------BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when 'Data-----END CERTIFICATE----------BEGIN CERTIFICATE-----'")
  void testGetSha3HashWithData_whenDataEndCertificateBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("Data-----END CERTIFICATE----------BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code Data-----END CERTIFICATE-----Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when 'Data-----END CERTIFICATE-----Data'")
  void testGetSha3HashWithData_whenDataEndCertificateData() {
    // Arrange, Act and Assert
    assertEquals("b2dfc23002ae9d45d6fd14abd233d4cf0452aa9310efc80ffebb5f3a82f478ed",
        EncryptionUtil.getSha3Hash("Data-----END CERTIFICATE-----Data"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code Data-----END CERTIFICATE----------END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when 'Data-----END CERTIFICATE----------END CERTIFICATE-----'")
  void testGetSha3HashWithData_whenDataEndCertificateEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("Data-----END CERTIFICATE----------END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code Data org.thingsboard.server.common.msg.EncryptionUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when 'Data org.thingsboard.server.common.msg.EncryptionUtil'")
  void testGetSha3HashWithData_whenDataOrgThingsboardServerCommonMsgEncryptionUtil() {
    // Arrange, Act and Assert
    assertEquals("133758e9322074cb0349537bd1ff5656746f81fbee7fa766b0b831293b716c98",
        EncryptionUtil.getSha3Hash("Data\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("133758e9322074cb0349537bd1ff5656746f81fbee7fa766b0b831293b716c98",
        EncryptionUtil.getSha3Hash("Data\rorg.thingsboard.server.common.msg.EncryptionUtil"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code Dataorg.thingsboard.server.common.msg.EncryptionUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when 'Dataorg.thingsboard.server.common.msg.EncryptionUtil'")
  void testGetSha3HashWithData_whenDataorgThingsboardServerCommonMsgEncryptionUtil() {
    // Arrange, Act and Assert
    assertEquals("133758e9322074cb0349537bd1ff5656746f81fbee7fa766b0b831293b716c98",
        EncryptionUtil.getSha3Hash("\nDataorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("133758e9322074cb0349537bd1ff5656746f81fbee7fa766b0b831293b716c98",
        EncryptionUtil.getSha3Hash("\rDataorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("133758e9322074cb0349537bd1ff5656746f81fbee7fa766b0b831293b716c98",
        EncryptionUtil.getSha3Hash("Dataorg.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("133758e9322074cb0349537bd1ff5656746f81fbee7fa766b0b831293b716c98",
        EncryptionUtil.getSha3Hash("Dataorg.thingsboard.server.common.msg.EncryptionUtil\r"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----END CERTIFICATE-----'")
  void testGetSha3HashWithData_whenEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\n-----END CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\r-----END CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----\n"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----\r"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\n\n-----END CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\n\r-----END CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\n-----END CERTIFICATE-----\n"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\n-----END CERTIFICATE-----\r"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\r\n-----END CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\r\r-----END CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\r-----END CERTIFICATE-----\n"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\r-----END CERTIFICATE-----\r"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----\n\n"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----\n\r"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----\r\n"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----\r\r"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----END CERTIFICATE-----42'")
  void testGetSha3HashWithData_whenEndCertificate42() {
    // Arrange, Act and Assert
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----42"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("\n-----END CERTIFICATE-----42"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("\r-----END CERTIFICATE-----42"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----\n42"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----\r42"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----42\n"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----42\r"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----42-----BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----END CERTIFICATE-----42-----BEGIN CERTIFICATE-----'")
  void testGetSha3HashWithData_whenEndCertificate42BeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----42-----BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----42Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----END CERTIFICATE-----42Data'")
  void testGetSha3HashWithData_whenEndCertificate42Data() {
    // Arrange, Act and Assert
    assertEquals("d73386e5499303a98da6630c7c7823a8b55475d45a9cd94f5cb86fff070d6fe5",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----42Data"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----42-----END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----END CERTIFICATE-----42-----END CERTIFICATE-----'")
  void testGetSha3HashWithData_whenEndCertificate42EndCertificate() {
    // Arrange, Act and Assert
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----42-----END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----END CERTIFICATE-----4242'")
  void testGetSha3HashWithData_whenEndCertificate4242() {
    // Arrange, Act and Assert
    assertEquals("46cd1951574c887e3c703c2da9b9ce0dc1c53909f790dd4c6301787cb16ac6b1",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----4242"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE----------BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----END CERTIFICATE----------BEGIN CERTIFICATE-----'")
  void testGetSha3HashWithData_whenEndCertificateBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE----------BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\n-----END CERTIFICATE----------BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\r-----END CERTIFICATE----------BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE----------BEGIN CERTIFICATE-----\n"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE----------BEGIN CERTIFICATE-----\r"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----\r-----BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE----------BEGIN CERTIFICATE-----42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----END CERTIFICATE----------BEGIN CERTIFICATE-----42'")
  void testGetSha3HashWithData_whenEndCertificateBeginCertificate42() {
    // Arrange, Act and Assert
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE----------BEGIN CERTIFICATE-----42"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When
   * {@code -----END CERTIFICATE----------BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----END CERTIFICATE----------BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----'")
  void testGetSha3HashWithData_whenEndCertificateBeginCertificateBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE----------BEGIN CERTIFICATE----------BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When
   * {@code -----END CERTIFICATE----------BEGIN CERTIFICATE-----Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----END CERTIFICATE----------BEGIN CERTIFICATE-----Data'")
  void testGetSha3HashWithData_whenEndCertificateBeginCertificateData() {
    // Arrange, Act and Assert
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE----------BEGIN CERTIFICATE-----Data"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When
   * {@code -----END CERTIFICATE----------BEGIN CERTIFICATE----------END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----END CERTIFICATE----------BEGIN CERTIFICATE----------END CERTIFICATE-----'")
  void testGetSha3HashWithData_whenEndCertificateBeginCertificateEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE----------BEGIN CERTIFICATE----------END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----END CERTIFICATE-----Data'")
  void testGetSha3HashWithData_whenEndCertificateData() {
    // Arrange, Act and Assert
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----Data"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("\n-----END CERTIFICATE-----Data"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("\r-----END CERTIFICATE-----Data"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----\nData"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----\rData"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----Data\n"));
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----Data\r"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----Data42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----END CERTIFICATE-----Data42'")
  void testGetSha3HashWithData_whenEndCertificateData42() {
    // Arrange, Act and Assert
    assertEquals("bdde8029a0ae8aea16f03d8f3ac14b9f7a9245480a6c2123d464962bd083f43f",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----Data42"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When
   * {@code -----END CERTIFICATE-----Data-----BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----END CERTIFICATE-----Data-----BEGIN CERTIFICATE-----'")
  void testGetSha3HashWithData_whenEndCertificateDataBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----Data-----BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----DataData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----END CERTIFICATE-----DataData'")
  void testGetSha3HashWithData_whenEndCertificateDataData() {
    // Arrange, Act and Assert
    assertEquals("b2dfc23002ae9d45d6fd14abd233d4cf0452aa9310efc80ffebb5f3a82f478ed",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----DataData"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----Data-----END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----END CERTIFICATE-----Data-----END CERTIFICATE-----'")
  void testGetSha3HashWithData_whenEndCertificateDataEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----Data-----END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE----------END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----END CERTIFICATE----------END CERTIFICATE-----'")
  void testGetSha3HashWithData_whenEndCertificateEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE----------END CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\n-----END CERTIFICATE----------END CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\r-----END CERTIFICATE----------END CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----\n-----END CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----\r-----END CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE----------END CERTIFICATE-----\n"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE----------END CERTIFICATE-----\r"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE----------END CERTIFICATE-----42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----END CERTIFICATE----------END CERTIFICATE-----42'")
  void testGetSha3HashWithData_whenEndCertificateEndCertificate42() {
    // Arrange, Act and Assert
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE----------END CERTIFICATE-----42"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When
   * {@code -----END CERTIFICATE----------END CERTIFICATE----------BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----END CERTIFICATE----------END CERTIFICATE----------BEGIN CERTIFICATE-----'")
  void testGetSha3HashWithData_whenEndCertificateEndCertificateBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE----------END CERTIFICATE----------BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE----------END CERTIFICATE-----Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----END CERTIFICATE----------END CERTIFICATE-----Data'")
  void testGetSha3HashWithData_whenEndCertificateEndCertificateData() {
    // Arrange, Act and Assert
    assertEquals("09b3a79b25e34167f695ae162d6741115cfd10c66af85fbf0df2e0798b939497",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE----------END CERTIFICATE-----Data"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When
   * {@code -----END CERTIFICATE----------END CERTIFICATE----------END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when '-----END CERTIFICATE----------END CERTIFICATE----------END CERTIFICATE-----'")
  void testGetSha3HashWithData_whenEndCertificateEndCertificateEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE----------END CERTIFICATE----------END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when lf")
  void testGetSha3HashWithData_whenLf() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a", EncryptionUtil.getSha3Hash("\n"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When lf cr.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when lf cr")
  void testGetSha3HashWithData_whenLfCr() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\n\r"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When lf cr cr.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when lf cr cr")
  void testGetSha3HashWithData_whenLfCrCr() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\n\r\r"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When lf cr lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when lf cr lf")
  void testGetSha3HashWithData_whenLfCrLf() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\n\r\n"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When lf lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when lf lf")
  void testGetSha3HashWithData_whenLfLf() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\n\n"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When lf lf cr.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when lf lf cr")
  void testGetSha3HashWithData_whenLfLfCr() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\n\n\r"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When lf lf lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when lf lf lf")
  void testGetSha3HashWithData_whenLfLfLf() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\n\n\n"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code org.thingsboard.server.common.msg.EncryptionUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when 'org.thingsboard.server.common.msg.EncryptionUtil'")
  void testGetSha3HashWithData_whenOrgThingsboardServerCommonMsgEncryptionUtil() {
    // Arrange, Act and Assert
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("\rorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil\r"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("\n\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("\n\rorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("\norg.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("\norg.thingsboard.server.common.msg.EncryptionUtil\r"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("\r\norg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("\r\rorg.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("\rorg.thingsboard.server.common.msg.EncryptionUtil\n"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("\rorg.thingsboard.server.common.msg.EncryptionUtil\r"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code org.thingsboard.server.common.msg.EncryptionUtil42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when 'org.thingsboard.server.common.msg.EncryptionUtil42'")
  void testGetSha3HashWithData_whenOrgThingsboardServerCommonMsgEncryptionUtil42() {
    // Arrange, Act and Assert
    assertEquals("ee3019e7b2a1b39ad7d018afaf798bb7eb88b4f7f6fb1296d202a02f6c4c0583",
        EncryptionUtil.getSha3Hash("\norg.thingsboard.server.common.msg.EncryptionUtil42"));
    assertEquals("ee3019e7b2a1b39ad7d018afaf798bb7eb88b4f7f6fb1296d202a02f6c4c0583",
        EncryptionUtil.getSha3Hash("\rorg.thingsboard.server.common.msg.EncryptionUtil42"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String)} with {@code data}.
   * <ul>
   *   <li>When {@code org.thingsboard.server.common.msg.EncryptionUtilData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String)}
   */
  @Test
  @DisplayName("Test getSha3Hash(String) with 'data'; when 'org.thingsboard.server.common.msg.EncryptionUtilData'")
  void testGetSha3HashWithData_whenOrgThingsboardServerCommonMsgEncryptionUtilData() {
    // Arrange, Act and Assert
    assertEquals("164a5014e755fc1998d3bfe6ad0bbcf6285fff1ef921908efdf254df50cd5830",
        EncryptionUtil.getSha3Hash("\norg.thingsboard.server.common.msg.EncryptionUtilData"));
    assertEquals("164a5014e755fc1998d3bfe6ad0bbcf6285fff1ef921908efdf254df50cd5830",
        EncryptionUtil.getSha3Hash("\rorg.thingsboard.server.common.msg.EncryptionUtilData"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'")
  void testGetSha3HashWithDelimTokens() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("Delim", "-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("Delim", "\n"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("Delim", "\r"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("Delim", "-----END CERTIFICATE-----"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("Delim", "org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("ed25a850e38f9cf59dcde657c2e86e1261a37492c89be355097b8d136ba5891f",
        EncryptionUtil.getSha3Hash("Delim", "ABC123", "-----BEGIN CERTIFICATE-----"));
    assertEquals("fc06f96e48db2390476668734cda5a7fa0d5ada80cf418b9db07bac87a018193",
        EncryptionUtil.getSha3Hash("Delim", "ABC123", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("4bfb73bed87399006c607d72941a21f40fbc9aa129423aeecf413aa3e539fa80",
        EncryptionUtil.getSha3Hash(null, "ABC123", "-----BEGIN CERTIFICATE-----"));
    assertEquals("e71ae2066324b4073d49a47c979f7662dfe26729a53cba20a832f404034c9801", EncryptionUtil
        .getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil", "ABC123", "-----BEGIN CERTIFICATE-----"));
    assertEquals("91d0113e615d2b0e7231bc106671c7d2d1542376e31e4bbc0d60cf62adc4d79e",
        EncryptionUtil.getSha3Hash("42", "ABC123", "-----BEGIN CERTIFICATE-----"));
    assertEquals("be09633c6cf03b003e0a4ae878e9d6149ed87886be559ca485a7545dbf8180ff",
        EncryptionUtil.getSha3Hash("Delim", "-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----"));
    assertEquals("be09633c6cf03b003e0a4ae878e9d6149ed87886be559ca485a7545dbf8180ff",
        EncryptionUtil.getSha3Hash("Delim", "\n", "-----BEGIN CERTIFICATE-----"));
    assertEquals("be09633c6cf03b003e0a4ae878e9d6149ed87886be559ca485a7545dbf8180ff",
        EncryptionUtil.getSha3Hash("Delim", "\r", "-----BEGIN CERTIFICATE-----"));
    assertEquals("be09633c6cf03b003e0a4ae878e9d6149ed87886be559ca485a7545dbf8180ff",
        EncryptionUtil.getSha3Hash("Delim", "-----END CERTIFICATE-----", "-----BEGIN CERTIFICATE-----"));
    assertEquals("2cfbbb58632c5668b9aee0ff8ae49464cd6cd450e47970cf1840b002926e7f44",
        EncryptionUtil.getSha3Hash("Delim", "Tokens", "-----BEGIN CERTIFICATE-----"));
    assertEquals("92b1ea0d08741ab7ef896745ab54a94dfaabaf9c6b215459d2277957e2040a5b", EncryptionUtil.getSha3Hash("Delim",
        "org.thingsboard.server.common.msg.EncryptionUtil", "-----BEGIN CERTIFICATE-----"));
    assertEquals("dfa60180abf5668560379a665b36499dc10f252d7fb3ad23f1775bc8f6bcd8ad",
        EncryptionUtil.getSha3Hash("Delim", "42", "-----BEGIN CERTIFICATE-----"));
    assertEquals("ed25a850e38f9cf59dcde657c2e86e1261a37492c89be355097b8d136ba5891f",
        EncryptionUtil.getSha3Hash("Delim", "ABC123", "\n"));
    assertEquals("ed25a850e38f9cf59dcde657c2e86e1261a37492c89be355097b8d136ba5891f",
        EncryptionUtil.getSha3Hash("Delim", "ABC123", "\r"));
    assertEquals("ed25a850e38f9cf59dcde657c2e86e1261a37492c89be355097b8d136ba5891f",
        EncryptionUtil.getSha3Hash("Delim", "ABC123", "-----END CERTIFICATE-----"));
    assertEquals("288b2faa6e7cc8338cbd20d5740f2f13be7597a4687f1189442df10882a23a91",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "ABC123", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("288b2faa6e7cc8338cbd20d5740f2f13be7597a4687f1189442df10882a23a91",
        EncryptionUtil.getSha3Hash("\n", "ABC123", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("288b2faa6e7cc8338cbd20d5740f2f13be7597a4687f1189442df10882a23a91",
        EncryptionUtil.getSha3Hash("\r", "ABC123", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("288b2faa6e7cc8338cbd20d5740f2f13be7597a4687f1189442df10882a23a91",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "ABC123", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("39a5422fed03e718f3315eac6a844ed26c6287a30435c915873ab4ed961d545a",
        EncryptionUtil.getSha3Hash(null, "ABC123", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("e6504eb8db2527fae6748a733f3c4b60a289b362e5d74afe553c01b49997be64", EncryptionUtil.getSha3Hash(
        "org.thingsboard.server.common.msg.EncryptionUtil", "ABC123", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("5e5e6912aef8bb27979d0556b6435afd6058387c497ef61b4f6adbdc33587962",
        EncryptionUtil.getSha3Hash("42", "ABC123", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("37d83611c45bd082bb34c774e58dd36af7c8bbfcf91c539fafb99d15296fc0cc",
        EncryptionUtil.getSha3Hash("Delim", "-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("37d83611c45bd082bb34c774e58dd36af7c8bbfcf91c539fafb99d15296fc0cc",
        EncryptionUtil.getSha3Hash("Delim", "\n", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("37d83611c45bd082bb34c774e58dd36af7c8bbfcf91c539fafb99d15296fc0cc",
        EncryptionUtil.getSha3Hash("Delim", "\r", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("37d83611c45bd082bb34c774e58dd36af7c8bbfcf91c539fafb99d15296fc0cc",
        EncryptionUtil.getSha3Hash("Delim", "-----END CERTIFICATE-----", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("92b147f409d73bea82034da9a7d71b21c6bd2d5daafd65437d9336c7b5b5d003",
        EncryptionUtil.getSha3Hash("Delim", "Tokens", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("a8d2e68389492719474a653248565f9ee07daf0132cce349c7f6b3261c4ffe3d",
        EncryptionUtil.getSha3Hash("Delim", null, "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("d3b278ded16599cb8480380d6882a67dc834abd5497a38dfcc7299ccad882b75", EncryptionUtil.getSha3Hash("Delim",
        "org.thingsboard.server.common.msg.EncryptionUtil", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("37300d4c51750f0f2d2d3d385edcaf6da95a5e940e4710b86efb95e70880299e",
        EncryptionUtil.getSha3Hash("Delim", "42", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("fc06f96e48db2390476668734cda5a7fa0d5ada80cf418b9db07bac87a018193",
        EncryptionUtil.getSha3Hash("Delim", "ABC123", "\n", "ABC123"));
    assertEquals("fc06f96e48db2390476668734cda5a7fa0d5ada80cf418b9db07bac87a018193",
        EncryptionUtil.getSha3Hash("Delim", "ABC123", "\r", "ABC123"));
    assertEquals("fc06f96e48db2390476668734cda5a7fa0d5ada80cf418b9db07bac87a018193",
        EncryptionUtil.getSha3Hash("Delim", "ABC123", "-----END CERTIFICATE-----", "ABC123"));
    assertEquals("ed298eafc0d30d02d47ee60ad65066edfdb2ea2bc4f9b8e357b01b71e07b35d0",
        EncryptionUtil.getSha3Hash("Delim", "ABC123", "-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----"));
    assertEquals("ed298eafc0d30d02d47ee60ad65066edfdb2ea2bc4f9b8e357b01b71e07b35d0",
        EncryptionUtil.getSha3Hash("Delim", "ABC123", "-----BEGIN CERTIFICATE-----", "\n"));
    assertEquals("ed298eafc0d30d02d47ee60ad65066edfdb2ea2bc4f9b8e357b01b71e07b35d0",
        EncryptionUtil.getSha3Hash("Delim", "ABC123", "-----BEGIN CERTIFICATE-----", "\r"));
    assertEquals("ed298eafc0d30d02d47ee60ad65066edfdb2ea2bc4f9b8e357b01b71e07b35d0",
        EncryptionUtil.getSha3Hash("Delim", "ABC123", "-----BEGIN CERTIFICATE-----", "-----END CERTIFICATE-----"));
    assertEquals("b86edb3b4be9d432128f0870fefe2ced4c8e763b57e2af862e1b427bd6e9cd6b",
        EncryptionUtil.getSha3Hash("Delim", "ABC123", "-----BEGIN CERTIFICATE-----", "Tokens"));
    assertEquals("9ff8c91aa1be355a33881775f5471d05c44d767253e10d1f5358060855d10733", EncryptionUtil.getSha3Hash("Delim",
        "ABC123", "-----BEGIN CERTIFICATE-----", "org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("1b9b4a2620cfe395270c824ac73ae5fe48b8b18c7037f390ec7950e21c1a0361",
        EncryptionUtil.getSha3Hash("Delim", "ABC123", "-----BEGIN CERTIFICATE-----", "42"));
    assertEquals("f8e05e85de44da2d1828afb7cb8acf189d80882bcc817de1aafbca47eef6f885",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "Tokens", "-----BEGIN CERTIFICATE-----"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "org.thingsboard.server.common.msg.EncryptionUtil",
            "-----BEGIN CERTIFICATE-----"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "42", "-----BEGIN CERTIFICATE-----"));
    assertEquals("51a470c693b011d140a19037d76f38948f2fd4eb9e09ecc9f147f2206534b1e9",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "ABC123", "Tokens"));
    assertEquals("e71ae2066324b4073d49a47c979f7662dfe26729a53cba20a832f404034c9801", EncryptionUtil
        .getSha3Hash("-----BEGIN CERTIFICATE-----", "ABC123", "org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("f8e05e85de44da2d1828afb7cb8acf189d80882bcc817de1aafbca47eef6f885",
        EncryptionUtil.getSha3Hash("\n", "Tokens", "-----BEGIN CERTIFICATE-----"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a", EncryptionUtil.getSha3Hash("\n",
        "org.thingsboard.server.common.msg.EncryptionUtil", "-----BEGIN CERTIFICATE-----"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("\n", "42", "-----BEGIN CERTIFICATE-----"));
    assertEquals("51a470c693b011d140a19037d76f38948f2fd4eb9e09ecc9f147f2206534b1e9",
        EncryptionUtil.getSha3Hash("\n", "ABC123", "Tokens"));
    assertEquals("e71ae2066324b4073d49a47c979f7662dfe26729a53cba20a832f404034c9801",
        EncryptionUtil.getSha3Hash("\n", "ABC123", "org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("f8e05e85de44da2d1828afb7cb8acf189d80882bcc817de1aafbca47eef6f885",
        EncryptionUtil.getSha3Hash("\r", "Tokens", "-----BEGIN CERTIFICATE-----"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a", EncryptionUtil.getSha3Hash("\r",
        "org.thingsboard.server.common.msg.EncryptionUtil", "-----BEGIN CERTIFICATE-----"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("\r", "42", "-----BEGIN CERTIFICATE-----"));
    assertEquals("51a470c693b011d140a19037d76f38948f2fd4eb9e09ecc9f147f2206534b1e9",
        EncryptionUtil.getSha3Hash("\r", "ABC123", "Tokens"));
    assertEquals("e71ae2066324b4073d49a47c979f7662dfe26729a53cba20a832f404034c9801",
        EncryptionUtil.getSha3Hash("\r", "ABC123", "org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("f8e05e85de44da2d1828afb7cb8acf189d80882bcc817de1aafbca47eef6f885",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "Tokens", "-----BEGIN CERTIFICATE-----"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "org.thingsboard.server.common.msg.EncryptionUtil",
            "-----BEGIN CERTIFICATE-----"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "42", "-----BEGIN CERTIFICATE-----"));
    assertEquals("51a470c693b011d140a19037d76f38948f2fd4eb9e09ecc9f147f2206534b1e9",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "ABC123", "Tokens"));
    assertEquals("e71ae2066324b4073d49a47c979f7662dfe26729a53cba20a832f404034c9801", EncryptionUtil
        .getSha3Hash("-----END CERTIFICATE-----", "ABC123", "org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("3ea445410f608e6453cdcb7dbe42d57a89aca018993d7e87da85993cbccc6308",
        EncryptionUtil.getSha3Hash(null, "-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----"));
    assertEquals("3ea445410f608e6453cdcb7dbe42d57a89aca018993d7e87da85993cbccc6308",
        EncryptionUtil.getSha3Hash(null, "\n", "-----BEGIN CERTIFICATE-----"));
    assertEquals("3ea445410f608e6453cdcb7dbe42d57a89aca018993d7e87da85993cbccc6308",
        EncryptionUtil.getSha3Hash(null, "\r", "-----BEGIN CERTIFICATE-----"));
    assertEquals("3ea445410f608e6453cdcb7dbe42d57a89aca018993d7e87da85993cbccc6308",
        EncryptionUtil.getSha3Hash(null, "-----END CERTIFICATE-----", "-----BEGIN CERTIFICATE-----"));
    assertEquals("ed6fc50a4d5bd84f7a270394739314e97f1acffa3ca0c6e73b8c3040062b6f71",
        EncryptionUtil.getSha3Hash(null, "Tokens", "-----BEGIN CERTIFICATE-----"));
    assertEquals("5c532288650bc4578b3eab0e4fac53c8eabfa972b7aeecc42c8861c976256db2", EncryptionUtil.getSha3Hash(null,
        "org.thingsboard.server.common.msg.EncryptionUtil", "-----BEGIN CERTIFICATE-----"));
    assertEquals("1b9b2d3a6bae54d5adcc1897d2ba1e267597e78c642b3e71bc02303d116977a9",
        EncryptionUtil.getSha3Hash(null, "42", "-----BEGIN CERTIFICATE-----"));
    assertEquals("4bfb73bed87399006c607d72941a21f40fbc9aa129423aeecf413aa3e539fa80",
        EncryptionUtil.getSha3Hash(null, "ABC123", "\n"));
    assertEquals("4bfb73bed87399006c607d72941a21f40fbc9aa129423aeecf413aa3e539fa80",
        EncryptionUtil.getSha3Hash(null, "ABC123", "\r"));
    assertEquals("4bfb73bed87399006c607d72941a21f40fbc9aa129423aeecf413aa3e539fa80",
        EncryptionUtil.getSha3Hash(null, "ABC123", "-----END CERTIFICATE-----"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil", "-----BEGIN CERTIFICATE-----",
            "-----BEGIN CERTIFICATE-----"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a", EncryptionUtil
        .getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil", "\n", "-----BEGIN CERTIFICATE-----"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a", EncryptionUtil
        .getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil", "\r", "-----BEGIN CERTIFICATE-----"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a",
        EncryptionUtil.getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil", "-----END CERTIFICATE-----",
            "-----BEGIN CERTIFICATE-----"));
    assertEquals("d2f0af97d8b60e89933027573c19fc34946a0beb28860823b2ae735522e41f96", EncryptionUtil
        .getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil", "Tokens", "-----BEGIN CERTIFICATE-----"));
    assertEquals("26b0b812bd9a29778537005cbecb93a83a9b6442016ae447828136e1c66b4c37",
        EncryptionUtil.getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil",
            "org.thingsboard.server.common.msg.EncryptionUtil", "-----BEGIN CERTIFICATE-----"));
    assertEquals("f2629d8d190200631f0a521266621771aef1c371c025381e44ceca7cbaad5ff0", EncryptionUtil
        .getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil", "42", "-----BEGIN CERTIFICATE-----"));
    assertEquals("e71ae2066324b4073d49a47c979f7662dfe26729a53cba20a832f404034c9801",
        EncryptionUtil.getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil", "ABC123", "\n"));
    assertEquals("e71ae2066324b4073d49a47c979f7662dfe26729a53cba20a832f404034c9801",
        EncryptionUtil.getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil", "ABC123", "\r"));
    assertEquals("e71ae2066324b4073d49a47c979f7662dfe26729a53cba20a832f404034c9801", EncryptionUtil
        .getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil", "ABC123", "-----END CERTIFICATE-----"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("42", "-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("42", "\n", "-----BEGIN CERTIFICATE-----"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("42", "\r", "-----BEGIN CERTIFICATE-----"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash("42", "-----END CERTIFICATE-----", "-----BEGIN CERTIFICATE-----"));
    assertEquals("e00f49fe2875f0639a0f4269bec8644f18eacb107d282235c099a1e284b328e9",
        EncryptionUtil.getSha3Hash("42", "Tokens", "-----BEGIN CERTIFICATE-----"));
    assertEquals("ee3019e7b2a1b39ad7d018afaf798bb7eb88b4f7f6fb1296d202a02f6c4c0583", EncryptionUtil.getSha3Hash("42",
        "org.thingsboard.server.common.msg.EncryptionUtil", "-----BEGIN CERTIFICATE-----"));
    assertEquals("46cd1951574c887e3c703c2da9b9ce0dc1c53909f790dd4c6301787cb16ac6b1",
        EncryptionUtil.getSha3Hash("42", "42", "-----BEGIN CERTIFICATE-----"));
    assertEquals("91d0113e615d2b0e7231bc106671c7d2d1542376e31e4bbc0d60cf62adc4d79e",
        EncryptionUtil.getSha3Hash("42", "ABC123", "\n"));
    assertEquals("91d0113e615d2b0e7231bc106671c7d2d1542376e31e4bbc0d60cf62adc4d79e",
        EncryptionUtil.getSha3Hash("42", "ABC123", "\r"));
    assertEquals("91d0113e615d2b0e7231bc106671c7d2d1542376e31e4bbc0d60cf62adc4d79e",
        EncryptionUtil.getSha3Hash("42", "ABC123", "-----END CERTIFICATE-----"));
    assertEquals("f8e05e85de44da2d1828afb7cb8acf189d80882bcc817de1aafbca47eef6f885",
        EncryptionUtil.getSha3Hash(TbMsg.EMPTY_STRING, "Tokens", "-----BEGIN CERTIFICATE-----"));
    assertEquals("dbcbe8dce1ae0fe06be882b0b891a8de3d637e1174245cf9d8ee4b84670c254a", EncryptionUtil.getSha3Hash(
        TbMsg.EMPTY_STRING, "org.thingsboard.server.common.msg.EncryptionUtil", "-----BEGIN CERTIFICATE-----"));
    assertEquals("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        EncryptionUtil.getSha3Hash(TbMsg.EMPTY_STRING, "42", "-----BEGIN CERTIFICATE-----"));
    assertEquals("25e7cb3021a872794ba7685784a609b9482e03aa82b52953a85ceaaf93974996", EncryptionUtil.getSha3Hash("Delim",
        "-----BEGIN CERTIFICATE-----", "org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("25e7cb3021a872794ba7685784a609b9482e03aa82b52953a85ceaaf93974996",
        EncryptionUtil.getSha3Hash("Delim", "\n", "org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("25e7cb3021a872794ba7685784a609b9482e03aa82b52953a85ceaaf93974996",
        EncryptionUtil.getSha3Hash("Delim", "\r", "org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("25e7cb3021a872794ba7685784a609b9482e03aa82b52953a85ceaaf93974996", EncryptionUtil.getSha3Hash("Delim",
        "-----END CERTIFICATE-----", "org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("92b1ea0d08741ab7ef896745ab54a94dfaabaf9c6b215459d2277957e2040a5b",
        EncryptionUtil.getSha3Hash("Delim", "org.thingsboard.server.common.msg.EncryptionUtil", "\n"));
    assertEquals("92b1ea0d08741ab7ef896745ab54a94dfaabaf9c6b215459d2277957e2040a5b",
        EncryptionUtil.getSha3Hash("Delim", "org.thingsboard.server.common.msg.EncryptionUtil", "\r"));
    assertEquals("92b1ea0d08741ab7ef896745ab54a94dfaabaf9c6b215459d2277957e2040a5b", EncryptionUtil.getSha3Hash("Delim",
        "org.thingsboard.server.common.msg.EncryptionUtil", "-----END CERTIFICATE-----"));
    assertEquals("fb8cb9e4049290c8b4970171c9f4a5800f3e1a55c3b16fa6c61392c993d20309",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "Tokens", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("fdea703554906bcc1724adca25e2c18b7b38f500eff57946c4c9da38ee50df7c",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "org.thingsboard.server.common.msg.EncryptionUtil",
            "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("13123a2a542849502e09dd6fac2ef1bca4dba9d09e1e8911cbb2ba842442a551",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "42", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("caeb1bfa5de870c2c7e6a000e141d9296119722e5a51b81b4336c0d45b3fc4a2",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "ABC123", "ABC123", "ABC123"));
    assertEquals("9d626a4e89c8adff7e550ea14fa726741bfb56824127e364a3aa1ae559bd8ff6",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "ABC123", "Tokens", "ABC123"));
    assertEquals("3d7f92498a9c4b9dba1195ac4a43f19800de0915093c955ce5f4ac2a3ec21b00", EncryptionUtil.getSha3Hash(
        "-----BEGIN CERTIFICATE-----", "ABC123", "org.thingsboard.server.common.msg.EncryptionUtil", "ABC123"));
    assertEquals("f55cc089d5fc8936d87b85f788617aa6dd54f70ae6e6c409a7e90c17a1e163d0",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "ABC123", "42", "ABC123"));
    assertEquals("51a470c693b011d140a19037d76f38948f2fd4eb9e09ecc9f147f2206534b1e9",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "ABC123", "-----BEGIN CERTIFICATE-----", "Tokens"));
    assertEquals("e71ae2066324b4073d49a47c979f7662dfe26729a53cba20a832f404034c9801",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "ABC123", "-----BEGIN CERTIFICATE-----",
            "org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("91d0113e615d2b0e7231bc106671c7d2d1542376e31e4bbc0d60cf62adc4d79e",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "ABC123", "-----BEGIN CERTIFICATE-----", "42"));
    assertEquals("fb8cb9e4049290c8b4970171c9f4a5800f3e1a55c3b16fa6c61392c993d20309",
        EncryptionUtil.getSha3Hash("\n", "Tokens", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("fdea703554906bcc1724adca25e2c18b7b38f500eff57946c4c9da38ee50df7c", EncryptionUtil.getSha3Hash("\n",
        "org.thingsboard.server.common.msg.EncryptionUtil", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("13123a2a542849502e09dd6fac2ef1bca4dba9d09e1e8911cbb2ba842442a551",
        EncryptionUtil.getSha3Hash("\n", "42", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("caeb1bfa5de870c2c7e6a000e141d9296119722e5a51b81b4336c0d45b3fc4a2",
        EncryptionUtil.getSha3Hash("\n", "ABC123", "ABC123", "ABC123"));
    assertEquals("9d626a4e89c8adff7e550ea14fa726741bfb56824127e364a3aa1ae559bd8ff6",
        EncryptionUtil.getSha3Hash("\n", "ABC123", "Tokens", "ABC123"));
    assertEquals("3d7f92498a9c4b9dba1195ac4a43f19800de0915093c955ce5f4ac2a3ec21b00",
        EncryptionUtil.getSha3Hash("\n", "ABC123", "org.thingsboard.server.common.msg.EncryptionUtil", "ABC123"));
    assertEquals("f55cc089d5fc8936d87b85f788617aa6dd54f70ae6e6c409a7e90c17a1e163d0",
        EncryptionUtil.getSha3Hash("\n", "ABC123", "42", "ABC123"));
    assertEquals("51a470c693b011d140a19037d76f38948f2fd4eb9e09ecc9f147f2206534b1e9",
        EncryptionUtil.getSha3Hash("\n", "ABC123", "-----BEGIN CERTIFICATE-----", "Tokens"));
    assertEquals("e71ae2066324b4073d49a47c979f7662dfe26729a53cba20a832f404034c9801", EncryptionUtil.getSha3Hash("\n",
        "ABC123", "-----BEGIN CERTIFICATE-----", "org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("91d0113e615d2b0e7231bc106671c7d2d1542376e31e4bbc0d60cf62adc4d79e",
        EncryptionUtil.getSha3Hash("\n", "ABC123", "-----BEGIN CERTIFICATE-----", "42"));
    assertEquals("fb8cb9e4049290c8b4970171c9f4a5800f3e1a55c3b16fa6c61392c993d20309",
        EncryptionUtil.getSha3Hash("\r", "Tokens", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("fdea703554906bcc1724adca25e2c18b7b38f500eff57946c4c9da38ee50df7c", EncryptionUtil.getSha3Hash("\r",
        "org.thingsboard.server.common.msg.EncryptionUtil", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("13123a2a542849502e09dd6fac2ef1bca4dba9d09e1e8911cbb2ba842442a551",
        EncryptionUtil.getSha3Hash("\r", "42", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("caeb1bfa5de870c2c7e6a000e141d9296119722e5a51b81b4336c0d45b3fc4a2",
        EncryptionUtil.getSha3Hash("\r", "ABC123", "ABC123", "ABC123"));
    assertEquals("9d626a4e89c8adff7e550ea14fa726741bfb56824127e364a3aa1ae559bd8ff6",
        EncryptionUtil.getSha3Hash("\r", "ABC123", "Tokens", "ABC123"));
    assertEquals("3d7f92498a9c4b9dba1195ac4a43f19800de0915093c955ce5f4ac2a3ec21b00",
        EncryptionUtil.getSha3Hash("\r", "ABC123", "org.thingsboard.server.common.msg.EncryptionUtil", "ABC123"));
    assertEquals("f55cc089d5fc8936d87b85f788617aa6dd54f70ae6e6c409a7e90c17a1e163d0",
        EncryptionUtil.getSha3Hash("\r", "ABC123", "42", "ABC123"));
    assertEquals("51a470c693b011d140a19037d76f38948f2fd4eb9e09ecc9f147f2206534b1e9",
        EncryptionUtil.getSha3Hash("\r", "ABC123", "-----BEGIN CERTIFICATE-----", "Tokens"));
    assertEquals("e71ae2066324b4073d49a47c979f7662dfe26729a53cba20a832f404034c9801", EncryptionUtil.getSha3Hash("\r",
        "ABC123", "-----BEGIN CERTIFICATE-----", "org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("91d0113e615d2b0e7231bc106671c7d2d1542376e31e4bbc0d60cf62adc4d79e",
        EncryptionUtil.getSha3Hash("\r", "ABC123", "-----BEGIN CERTIFICATE-----", "42"));
    assertEquals("fb8cb9e4049290c8b4970171c9f4a5800f3e1a55c3b16fa6c61392c993d20309",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "Tokens", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("fdea703554906bcc1724adca25e2c18b7b38f500eff57946c4c9da38ee50df7c",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "org.thingsboard.server.common.msg.EncryptionUtil",
            "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("13123a2a542849502e09dd6fac2ef1bca4dba9d09e1e8911cbb2ba842442a551",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "42", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("caeb1bfa5de870c2c7e6a000e141d9296119722e5a51b81b4336c0d45b3fc4a2",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "ABC123", "ABC123", "ABC123"));
    assertEquals("9d626a4e89c8adff7e550ea14fa726741bfb56824127e364a3aa1ae559bd8ff6",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "ABC123", "Tokens", "ABC123"));
    assertEquals("3d7f92498a9c4b9dba1195ac4a43f19800de0915093c955ce5f4ac2a3ec21b00", EncryptionUtil.getSha3Hash(
        "-----END CERTIFICATE-----", "ABC123", "org.thingsboard.server.common.msg.EncryptionUtil", "ABC123"));
    assertEquals("f55cc089d5fc8936d87b85f788617aa6dd54f70ae6e6c409a7e90c17a1e163d0",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "ABC123", "42", "ABC123"));
    assertEquals("51a470c693b011d140a19037d76f38948f2fd4eb9e09ecc9f147f2206534b1e9",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "ABC123", "-----BEGIN CERTIFICATE-----", "Tokens"));
    assertEquals("e71ae2066324b4073d49a47c979f7662dfe26729a53cba20a832f404034c9801",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "ABC123", "-----BEGIN CERTIFICATE-----",
            "org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("91d0113e615d2b0e7231bc106671c7d2d1542376e31e4bbc0d60cf62adc4d79e",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "ABC123", "-----BEGIN CERTIFICATE-----", "42"));
    assertEquals("a5503985962b292e843ba6109dca366a32c0737410b380d22e13095c3f150cff",
        EncryptionUtil.getSha3Hash(null, "-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("a5503985962b292e843ba6109dca366a32c0737410b380d22e13095c3f150cff",
        EncryptionUtil.getSha3Hash(null, "\n", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("a5503985962b292e843ba6109dca366a32c0737410b380d22e13095c3f150cff",
        EncryptionUtil.getSha3Hash(null, "\r", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("a5503985962b292e843ba6109dca366a32c0737410b380d22e13095c3f150cff",
        EncryptionUtil.getSha3Hash(null, "-----END CERTIFICATE-----", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("019afe82e049c131adf70a57ae46cada010354dc297677ccd7e68842da924901",
        EncryptionUtil.getSha3Hash(null, "Tokens", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("16c7a073e1e813d0788452f1d131063354d4f42ce765701ec6f999b594230527",
        EncryptionUtil.getSha3Hash(null, null, "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("c8249ecc72361fa18782ffa6df5575560de801bb4a1849b43a13291a5bdf156e", EncryptionUtil.getSha3Hash(null,
        "org.thingsboard.server.common.msg.EncryptionUtil", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("b8bf5fb1e79fd1b47ef9d2cc21f170b1d60c2fd7f83d205f7dc5ac4d073a4c7b",
        EncryptionUtil.getSha3Hash(null, "42", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("39a5422fed03e718f3315eac6a844ed26c6287a30435c915873ab4ed961d545a",
        EncryptionUtil.getSha3Hash(null, "ABC123", "\n", "ABC123"));
    assertEquals("39a5422fed03e718f3315eac6a844ed26c6287a30435c915873ab4ed961d545a",
        EncryptionUtil.getSha3Hash(null, "ABC123", "\r", "ABC123"));
    assertEquals("39a5422fed03e718f3315eac6a844ed26c6287a30435c915873ab4ed961d545a",
        EncryptionUtil.getSha3Hash(null, "ABC123", "-----END CERTIFICATE-----", "ABC123"));
    assertEquals("8c7d8f674d55e56a09ae09627656579de3216a98e5def14b04c6099a1ad664d3",
        EncryptionUtil.getSha3Hash(null, "ABC123", "-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----"));
    assertEquals("8c7d8f674d55e56a09ae09627656579de3216a98e5def14b04c6099a1ad664d3",
        EncryptionUtil.getSha3Hash(null, "ABC123", "-----BEGIN CERTIFICATE-----", "\n"));
    assertEquals("8c7d8f674d55e56a09ae09627656579de3216a98e5def14b04c6099a1ad664d3",
        EncryptionUtil.getSha3Hash(null, "ABC123", "-----BEGIN CERTIFICATE-----", "\r"));
    assertEquals("8c7d8f674d55e56a09ae09627656579de3216a98e5def14b04c6099a1ad664d3",
        EncryptionUtil.getSha3Hash(null, "ABC123", "-----BEGIN CERTIFICATE-----", "-----END CERTIFICATE-----"));
    assertEquals("21d45042a9b37595a15e1ce46c1694abc4e4001c77c3011798e395a392917940",
        EncryptionUtil.getSha3Hash(null, "ABC123", "-----BEGIN CERTIFICATE-----", "Tokens"));
    assertEquals("ed08e396c9b91862015e0eee93505514bf9f2f826a36de5c3373387c1c72a213", EncryptionUtil.getSha3Hash(null,
        "ABC123", "-----BEGIN CERTIFICATE-----", "org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("e3e2315b310f93ff20039345b62184b650391d67c8601b7fce460f8bcb541e84",
        EncryptionUtil.getSha3Hash(null, "ABC123", "-----BEGIN CERTIFICATE-----", "42"));
    assertEquals("2bea259a3db710b2fc40b4da1fc683b6c43dc1114bac04d1dc4e2a1936097762",
        EncryptionUtil.getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil", "-----BEGIN CERTIFICATE-----",
            "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("2bea259a3db710b2fc40b4da1fc683b6c43dc1114bac04d1dc4e2a1936097762", EncryptionUtil.getSha3Hash(
        "org.thingsboard.server.common.msg.EncryptionUtil", "\n", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("2bea259a3db710b2fc40b4da1fc683b6c43dc1114bac04d1dc4e2a1936097762", EncryptionUtil.getSha3Hash(
        "org.thingsboard.server.common.msg.EncryptionUtil", "\r", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("2bea259a3db710b2fc40b4da1fc683b6c43dc1114bac04d1dc4e2a1936097762",
        EncryptionUtil.getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil", "-----END CERTIFICATE-----",
            "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("a12409f611d1113eafca52d5067ac36413145b58b9a1dcb64250157c920f4d1e", EncryptionUtil.getSha3Hash(
        "org.thingsboard.server.common.msg.EncryptionUtil", "Tokens", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("fdea703554906bcc1724adca25e2c18b7b38f500eff57946c4c9da38ee50df7c", EncryptionUtil.getSha3Hash(
        "org.thingsboard.server.common.msg.EncryptionUtil", null, "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("be611f676f59012bc04dbf2d865d834a2c76b67188c51723d298713f127ebbbe",
        EncryptionUtil.getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil",
            "org.thingsboard.server.common.msg.EncryptionUtil", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("7a92ee82171c17abcdfc31efb7f9e9a32c8eadb76de4e8bd9144164c92a4e8eb", EncryptionUtil.getSha3Hash(
        "org.thingsboard.server.common.msg.EncryptionUtil", "42", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("e6504eb8db2527fae6748a733f3c4b60a289b362e5d74afe553c01b49997be64",
        EncryptionUtil.getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil", "ABC123", "\n", "ABC123"));
    assertEquals("e6504eb8db2527fae6748a733f3c4b60a289b362e5d74afe553c01b49997be64",
        EncryptionUtil.getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil", "ABC123", "\r", "ABC123"));
    assertEquals("e6504eb8db2527fae6748a733f3c4b60a289b362e5d74afe553c01b49997be64", EncryptionUtil.getSha3Hash(
        "org.thingsboard.server.common.msg.EncryptionUtil", "ABC123", "-----END CERTIFICATE-----", "ABC123"));
    assertEquals("f81168812cf1a1bdc13dc5c70c12908a6f57425c16496f00e4c3df1ca0d0f6fe",
        EncryptionUtil.getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil", "ABC123",
            "-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----"));
    assertEquals("f81168812cf1a1bdc13dc5c70c12908a6f57425c16496f00e4c3df1ca0d0f6fe", EncryptionUtil.getSha3Hash(
        "org.thingsboard.server.common.msg.EncryptionUtil", "ABC123", "-----BEGIN CERTIFICATE-----", "\n"));
    assertEquals("f81168812cf1a1bdc13dc5c70c12908a6f57425c16496f00e4c3df1ca0d0f6fe", EncryptionUtil.getSha3Hash(
        "org.thingsboard.server.common.msg.EncryptionUtil", "ABC123", "-----BEGIN CERTIFICATE-----", "\r"));
    assertEquals("f81168812cf1a1bdc13dc5c70c12908a6f57425c16496f00e4c3df1ca0d0f6fe",
        EncryptionUtil.getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil", "ABC123",
            "-----BEGIN CERTIFICATE-----", "-----END CERTIFICATE-----"));
    assertEquals("27bbb986ddb8e662e3be2763bc80a5ee7a21cd28eb25a5787716d084f50f2178", EncryptionUtil.getSha3Hash(
        "org.thingsboard.server.common.msg.EncryptionUtil", "ABC123", "-----BEGIN CERTIFICATE-----", "Tokens"));
    assertEquals("4c764321bb567c8e5ec032b0020b2059b8f4899f842786cb0fae53dd2289f23c",
        EncryptionUtil.getSha3Hash("org.thingsboard.server.common.msg.EncryptionUtil", "ABC123",
            "-----BEGIN CERTIFICATE-----", "org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("99c449b54c0d02332ec746c13a9fb450cafb3d07d0d6f819346046982ed18435", EncryptionUtil.getSha3Hash(
        "org.thingsboard.server.common.msg.EncryptionUtil", "ABC123", "-----BEGIN CERTIFICATE-----", "42"));
    assertEquals("a6b4a26d9f0436de31837f48af310cce7e8689c1fe05d3ff1baf783b5a094ca6",
        EncryptionUtil.getSha3Hash("42", "-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("a6b4a26d9f0436de31837f48af310cce7e8689c1fe05d3ff1baf783b5a094ca6",
        EncryptionUtil.getSha3Hash("42", "\n", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("a6b4a26d9f0436de31837f48af310cce7e8689c1fe05d3ff1baf783b5a094ca6",
        EncryptionUtil.getSha3Hash("42", "\r", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("a6b4a26d9f0436de31837f48af310cce7e8689c1fe05d3ff1baf783b5a094ca6",
        EncryptionUtil.getSha3Hash("42", "-----END CERTIFICATE-----", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("d023991dfb02d95b3635a7ef1a394043748b7c86110346bdd0aa4843d3f53b97",
        EncryptionUtil.getSha3Hash("42", "Tokens", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("13123a2a542849502e09dd6fac2ef1bca4dba9d09e1e8911cbb2ba842442a551",
        EncryptionUtil.getSha3Hash("42", null, "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("0bccc4dd56f10473e39ac9924f5a96537bab989787f0b022eb6101a8dd6cf234", EncryptionUtil.getSha3Hash("42",
        "org.thingsboard.server.common.msg.EncryptionUtil", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("b7a92b3c21ad4b51cd6b8e297e46a254f77950e7800af3715e8886eac8ac1d8f",
        EncryptionUtil.getSha3Hash("42", "42", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("5e5e6912aef8bb27979d0556b6435afd6058387c497ef61b4f6adbdc33587962",
        EncryptionUtil.getSha3Hash("42", "ABC123", "\n", "ABC123"));
    assertEquals("5e5e6912aef8bb27979d0556b6435afd6058387c497ef61b4f6adbdc33587962",
        EncryptionUtil.getSha3Hash("42", "ABC123", "\r", "ABC123"));
    assertEquals("5e5e6912aef8bb27979d0556b6435afd6058387c497ef61b4f6adbdc33587962",
        EncryptionUtil.getSha3Hash("42", "ABC123", "-----END CERTIFICATE-----", "ABC123"));
    assertEquals("2d32c1ea1645d849e4e95cda9700351035133ad734c0d648a98a5da8c99dd5ee",
        EncryptionUtil.getSha3Hash("42", "ABC123", "-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----"));
    assertEquals("2d32c1ea1645d849e4e95cda9700351035133ad734c0d648a98a5da8c99dd5ee",
        EncryptionUtil.getSha3Hash("42", "ABC123", "-----BEGIN CERTIFICATE-----", "\n"));
    assertEquals("2d32c1ea1645d849e4e95cda9700351035133ad734c0d648a98a5da8c99dd5ee",
        EncryptionUtil.getSha3Hash("42", "ABC123", "-----BEGIN CERTIFICATE-----", "\r"));
    assertEquals("2d32c1ea1645d849e4e95cda9700351035133ad734c0d648a98a5da8c99dd5ee",
        EncryptionUtil.getSha3Hash("42", "ABC123", "-----BEGIN CERTIFICATE-----", "-----END CERTIFICATE-----"));
    assertEquals("030924b9deaa8d3eed5056b25e20d657872767303e2f7a334171f67a7f4e209d",
        EncryptionUtil.getSha3Hash("42", "ABC123", "-----BEGIN CERTIFICATE-----", "Tokens"));
    assertEquals("933c25a56d42c517c2388979595b100b9d27ccd37d741ca44e9e3484fef64af3", EncryptionUtil.getSha3Hash("42",
        "ABC123", "-----BEGIN CERTIFICATE-----", "org.thingsboard.server.common.msg.EncryptionUtil"));
    assertEquals("419e375c069e75fc35c9f722bebeac79ce84579f32f0c4a7d0b3383cc829a8b0",
        EncryptionUtil.getSha3Hash("42", "ABC123", "-----BEGIN CERTIFICATE-----", "42"));
    assertEquals("fb8cb9e4049290c8b4970171c9f4a5800f3e1a55c3b16fa6c61392c993d20309",
        EncryptionUtil.getSha3Hash(TbMsg.EMPTY_STRING, "Tokens", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("fdea703554906bcc1724adca25e2c18b7b38f500eff57946c4c9da38ee50df7c",
        EncryptionUtil.getSha3Hash(TbMsg.EMPTY_STRING, "org.thingsboard.server.common.msg.EncryptionUtil",
            "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("13123a2a542849502e09dd6fac2ef1bca4dba9d09e1e8911cbb2ba842442a551",
        EncryptionUtil.getSha3Hash(TbMsg.EMPTY_STRING, "42", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("bc581d47f14b71633c3124ab02d554df35b62f339bb6d7f43477712bb7aa2652",
        EncryptionUtil.getSha3Hash("Delim", "-----BEGIN CERTIFICATE-----", "ABC123", "ABC123"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code 42} and cr.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when '42' and cr")
  void testGetSha3HashWithDelimTokens_when42AndCr() {
    // Arrange, Act and Assert
    assertEquals("dfa60180abf5668560379a665b36499dc10f252d7fb3ad23f1775bc8f6bcd8ad",
        EncryptionUtil.getSha3Hash("Delim", "42", "\r"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code 42} and {@code -----END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when '42' and '-----END CERTIFICATE-----'")
  void testGetSha3HashWithDelimTokens_when42AndEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("dfa60180abf5668560379a665b36499dc10f252d7fb3ad23f1775bc8f6bcd8ad",
        EncryptionUtil.getSha3Hash("Delim", "42", "-----END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code 42} and lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when '42' and lf")
  void testGetSha3HashWithDelimTokens_when42AndLf() {
    // Arrange, Act and Assert
    assertEquals("dfa60180abf5668560379a665b36499dc10f252d7fb3ad23f1775bc8f6bcd8ad",
        EncryptionUtil.getSha3Hash("Delim", "42", "\n"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code ABC123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when 'ABC123'")
  void testGetSha3HashWithDelimTokens_whenAbc123() {
    // Arrange, Act and Assert
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("Delim", "ABC123"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code ABC123} and {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when 'ABC123' and '42'")
  void testGetSha3HashWithDelimTokens_whenAbc123And42() {
    // Arrange, Act and Assert
    assertEquals("91d0113e615d2b0e7231bc106671c7d2d1542376e31e4bbc0d60cf62adc4d79e",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "ABC123", "42"));
    assertEquals("91d0113e615d2b0e7231bc106671c7d2d1542376e31e4bbc0d60cf62adc4d79e",
        EncryptionUtil.getSha3Hash("\n", "ABC123", "42"));
    assertEquals("91d0113e615d2b0e7231bc106671c7d2d1542376e31e4bbc0d60cf62adc4d79e",
        EncryptionUtil.getSha3Hash("\r", "ABC123", "42"));
    assertEquals("91d0113e615d2b0e7231bc106671c7d2d1542376e31e4bbc0d60cf62adc4d79e",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "ABC123", "42"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code ABC123} and {@code ABC123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when 'ABC123' and 'ABC123'")
  void testGetSha3HashWithDelimTokens_whenAbc123AndAbc123() {
    // Arrange, Act and Assert
    assertEquals("288b2faa6e7cc8338cbd20d5740f2f13be7597a4687f1189442df10882a23a91",
        EncryptionUtil.getSha3Hash("\n", "ABC123", "ABC123"));
    assertEquals("288b2faa6e7cc8338cbd20d5740f2f13be7597a4687f1189442df10882a23a91",
        EncryptionUtil.getSha3Hash("\r", "ABC123", "ABC123"));
    assertEquals("288b2faa6e7cc8338cbd20d5740f2f13be7597a4687f1189442df10882a23a91",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "ABC123", "ABC123"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code ABC123} and cr.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when 'ABC123' and cr")
  void testGetSha3HashWithDelimTokens_whenAbc123AndCr() {
    // Arrange, Act and Assert
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "ABC123", "\r"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\n", "ABC123", "\r"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\r", "ABC123", "\r"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "ABC123", "\r"));
    assertEquals("288b2faa6e7cc8338cbd20d5740f2f13be7597a4687f1189442df10882a23a91",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "ABC123", "\r", "ABC123"));
    assertEquals("288b2faa6e7cc8338cbd20d5740f2f13be7597a4687f1189442df10882a23a91",
        EncryptionUtil.getSha3Hash("\n", "ABC123", "\r", "ABC123"));
    assertEquals("288b2faa6e7cc8338cbd20d5740f2f13be7597a4687f1189442df10882a23a91",
        EncryptionUtil.getSha3Hash("\r", "ABC123", "\r", "ABC123"));
    assertEquals("288b2faa6e7cc8338cbd20d5740f2f13be7597a4687f1189442df10882a23a91",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "ABC123", "\r", "ABC123"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code ABC123} and {@code -----END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when 'ABC123' and '-----END CERTIFICATE-----'")
  void testGetSha3HashWithDelimTokens_whenAbc123AndEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "ABC123", "-----END CERTIFICATE-----"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\n", "ABC123", "-----END CERTIFICATE-----"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\r", "ABC123", "-----END CERTIFICATE-----"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "ABC123", "-----END CERTIFICATE-----"));
    assertEquals("288b2faa6e7cc8338cbd20d5740f2f13be7597a4687f1189442df10882a23a91",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "ABC123", "-----END CERTIFICATE-----", "ABC123"));
    assertEquals("288b2faa6e7cc8338cbd20d5740f2f13be7597a4687f1189442df10882a23a91",
        EncryptionUtil.getSha3Hash("\n", "ABC123", "-----END CERTIFICATE-----", "ABC123"));
    assertEquals("288b2faa6e7cc8338cbd20d5740f2f13be7597a4687f1189442df10882a23a91",
        EncryptionUtil.getSha3Hash("\r", "ABC123", "-----END CERTIFICATE-----", "ABC123"));
    assertEquals("288b2faa6e7cc8338cbd20d5740f2f13be7597a4687f1189442df10882a23a91",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "ABC123", "-----END CERTIFICATE-----", "ABC123"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code ABC123} and lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when 'ABC123' and lf")
  void testGetSha3HashWithDelimTokens_whenAbc123AndLf() {
    // Arrange, Act and Assert
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "ABC123", "\n"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\n", "ABC123", "\n"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\r", "ABC123", "\n"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "ABC123", "\n"));
    assertEquals("288b2faa6e7cc8338cbd20d5740f2f13be7597a4687f1189442df10882a23a91",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "ABC123", "\n", "ABC123"));
    assertEquals("288b2faa6e7cc8338cbd20d5740f2f13be7597a4687f1189442df10882a23a91",
        EncryptionUtil.getSha3Hash("\n", "ABC123", "\n", "ABC123"));
    assertEquals("288b2faa6e7cc8338cbd20d5740f2f13be7597a4687f1189442df10882a23a91",
        EncryptionUtil.getSha3Hash("\r", "ABC123", "\n", "ABC123"));
    assertEquals("288b2faa6e7cc8338cbd20d5740f2f13be7597a4687f1189442df10882a23a91",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "ABC123", "\n", "ABC123"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when '-----BEGIN CERTIFICATE-----'")
  void testGetSha3HashWithDelimTokens_whenBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "ABC123", "-----BEGIN CERTIFICATE-----"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463", EncryptionUtil.getSha3Hash(
        "-----BEGIN CERTIFICATE-----", "ABC123", "-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "ABC123", "-----BEGIN CERTIFICATE-----", "\n"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "ABC123", "-----BEGIN CERTIFICATE-----", "\r"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463", EncryptionUtil.getSha3Hash(
        "-----BEGIN CERTIFICATE-----", "ABC123", "-----BEGIN CERTIFICATE-----", "-----END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----} and {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when '-----BEGIN CERTIFICATE-----' and '42'")
  void testGetSha3HashWithDelimTokens_whenBeginCertificateAnd42() {
    // Arrange, Act and Assert
    assertEquals("9c9532f85452cdd3999181a1ced58a027e922239cfb8372063a0e4b421040c8f",
        EncryptionUtil.getSha3Hash("Delim", "-----BEGIN CERTIFICATE-----", "42"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----} and
   * {@code -----BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when '-----BEGIN CERTIFICATE-----' and '-----BEGIN CERTIFICATE-----'")
  void testGetSha3HashWithDelimTokens_whenBeginCertificateAndBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a", EncryptionUtil
        .getSha3Hash("-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\n", "-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\r", "-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a", EncryptionUtil
        .getSha3Hash("-----END CERTIFICATE-----", "-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463", EncryptionUtil.getSha3Hash(
        "-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\n", "-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\r", "-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463", EncryptionUtil.getSha3Hash(
        "-----END CERTIFICATE-----", "-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----", "ABC123"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----} and cr.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when '-----BEGIN CERTIFICATE-----' and cr")
  void testGetSha3HashWithDelimTokens_whenBeginCertificateAndCr() {
    // Arrange, Act and Assert
    assertEquals("be09633c6cf03b003e0a4ae878e9d6149ed87886be559ca485a7545dbf8180ff",
        EncryptionUtil.getSha3Hash("Delim", "-----BEGIN CERTIFICATE-----", "\r"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----} and
   * {@code -----END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when '-----BEGIN CERTIFICATE-----' and '-----END CERTIFICATE-----'")
  void testGetSha3HashWithDelimTokens_whenBeginCertificateAndEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("be09633c6cf03b003e0a4ae878e9d6149ed87886be559ca485a7545dbf8180ff",
        EncryptionUtil.getSha3Hash("Delim", "-----BEGIN CERTIFICATE-----", "-----END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----} and lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when '-----BEGIN CERTIFICATE-----' and lf")
  void testGetSha3HashWithDelimTokens_whenBeginCertificateAndLf() {
    // Arrange, Act and Assert
    assertEquals("be09633c6cf03b003e0a4ae878e9d6149ed87886be559ca485a7545dbf8180ff",
        EncryptionUtil.getSha3Hash("Delim", "-----BEGIN CERTIFICATE-----", "\n"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----} and {@code Tokens}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when '-----BEGIN CERTIFICATE-----' and 'Tokens'")
  void testGetSha3HashWithDelimTokens_whenBeginCertificateAndTokens() {
    // Arrange, Act and Assert
    assertEquals("03232c36674e72bce1445fe2ef1ac28ecfb9f4ca29c4b4a847f129d8608408cb",
        EncryptionUtil.getSha3Hash("Delim", "-----BEGIN CERTIFICATE-----", "Tokens"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When cr.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when cr")
  void testGetSha3HashWithDelimTokens_whenCr() {
    // Arrange, Act and Assert
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\r", "ABC123", "-----BEGIN CERTIFICATE-----"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\r", "ABC123", "-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\r", "ABC123", "-----BEGIN CERTIFICATE-----", "\n"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\r", "ABC123", "-----BEGIN CERTIFICATE-----", "\r"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\r", "ABC123", "-----BEGIN CERTIFICATE-----", "-----END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When cr and {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when cr and '42'")
  void testGetSha3HashWithDelimTokens_whenCrAnd42() {
    // Arrange, Act and Assert
    assertEquals("9c9532f85452cdd3999181a1ced58a027e922239cfb8372063a0e4b421040c8f",
        EncryptionUtil.getSha3Hash("Delim", "\r", "42"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When cr and {@code ABC123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when cr and 'ABC123'")
  void testGetSha3HashWithDelimTokens_whenCrAndAbc123() {
    // Arrange, Act and Assert
    assertEquals("a8d2e68389492719474a653248565f9ee07daf0132cce349c7f6b3261c4ffe3d",
        EncryptionUtil.getSha3Hash("Delim", "\r", "ABC123"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When cr and {@code -----BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when cr and '-----BEGIN CERTIFICATE-----'")
  void testGetSha3HashWithDelimTokens_whenCrAndBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "\r", "-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\n", "\r", "-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\r", "\r", "-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "\r", "-----BEGIN CERTIFICATE-----"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "\r", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\n", "\r", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\r", "\r", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "\r", "-----BEGIN CERTIFICATE-----", "ABC123"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When cr and cr.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when cr and cr")
  void testGetSha3HashWithDelimTokens_whenCrAndCr() {
    // Arrange, Act and Assert
    assertEquals("be09633c6cf03b003e0a4ae878e9d6149ed87886be559ca485a7545dbf8180ff",
        EncryptionUtil.getSha3Hash("Delim", "\r", "\r"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When cr and {@code -----END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when cr and '-----END CERTIFICATE-----'")
  void testGetSha3HashWithDelimTokens_whenCrAndEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("be09633c6cf03b003e0a4ae878e9d6149ed87886be559ca485a7545dbf8180ff",
        EncryptionUtil.getSha3Hash("Delim", "\r", "-----END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When cr and lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when cr and lf")
  void testGetSha3HashWithDelimTokens_whenCrAndLf() {
    // Arrange, Act and Assert
    assertEquals("be09633c6cf03b003e0a4ae878e9d6149ed87886be559ca485a7545dbf8180ff",
        EncryptionUtil.getSha3Hash("Delim", "\r", "\n"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When cr and {@code Tokens}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when cr and 'Tokens'")
  void testGetSha3HashWithDelimTokens_whenCrAndTokens() {
    // Arrange, Act and Assert
    assertEquals("03232c36674e72bce1445fe2ef1ac28ecfb9f4ca29c4b4a847f129d8608408cb",
        EncryptionUtil.getSha3Hash("Delim", "\r", "Tokens"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@link TbMsg#EMPTY_STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when EMPTY_STRING")
  void testGetSha3HashWithDelimTokens_whenEmpty_string() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("Delim", TbMsg.EMPTY_STRING));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash(TbMsg.EMPTY_STRING, "ABC123", "-----BEGIN CERTIFICATE-----"));
    assertEquals("288b2faa6e7cc8338cbd20d5740f2f13be7597a4687f1189442df10882a23a91",
        EncryptionUtil.getSha3Hash(TbMsg.EMPTY_STRING, "ABC123", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash(TbMsg.EMPTY_STRING, "-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash(TbMsg.EMPTY_STRING, "\n", "-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash(TbMsg.EMPTY_STRING, "\r", "-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash(TbMsg.EMPTY_STRING, "-----END CERTIFICATE-----", "-----BEGIN CERTIFICATE-----"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash(TbMsg.EMPTY_STRING, "\n", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash(TbMsg.EMPTY_STRING, "\r", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463", EncryptionUtil
        .getSha3Hash(TbMsg.EMPTY_STRING, "-----END CERTIFICATE-----", "-----BEGIN CERTIFICATE-----", "ABC123"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when '-----END CERTIFICATE-----'")
  void testGetSha3HashWithDelimTokens_whenEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "ABC123", "-----BEGIN CERTIFICATE-----"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463", EncryptionUtil.getSha3Hash(
        "-----END CERTIFICATE-----", "ABC123", "-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "ABC123", "-----BEGIN CERTIFICATE-----", "\n"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "ABC123", "-----BEGIN CERTIFICATE-----", "\r"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463", EncryptionUtil.getSha3Hash(
        "-----END CERTIFICATE-----", "ABC123", "-----BEGIN CERTIFICATE-----", "-----END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----} and {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when '-----END CERTIFICATE-----' and '42'")
  void testGetSha3HashWithDelimTokens_whenEndCertificateAnd42() {
    // Arrange, Act and Assert
    assertEquals("9c9532f85452cdd3999181a1ced58a027e922239cfb8372063a0e4b421040c8f",
        EncryptionUtil.getSha3Hash("Delim", "-----END CERTIFICATE-----", "42"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----} and {@code ABC123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when '-----END CERTIFICATE-----' and 'ABC123'")
  void testGetSha3HashWithDelimTokens_whenEndCertificateAndAbc123() {
    // Arrange, Act and Assert
    assertEquals("a8d2e68389492719474a653248565f9ee07daf0132cce349c7f6b3261c4ffe3d",
        EncryptionUtil.getSha3Hash("Delim", "-----END CERTIFICATE-----", "ABC123"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----} and
   * {@code -----BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when '-----END CERTIFICATE-----' and '-----BEGIN CERTIFICATE-----'")
  void testGetSha3HashWithDelimTokens_whenEndCertificateAndBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a", EncryptionUtil
        .getSha3Hash("-----BEGIN CERTIFICATE-----", "-----END CERTIFICATE-----", "-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\n", "-----END CERTIFICATE-----", "-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\r", "-----END CERTIFICATE-----", "-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a", EncryptionUtil
        .getSha3Hash("-----END CERTIFICATE-----", "-----END CERTIFICATE-----", "-----BEGIN CERTIFICATE-----"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463", EncryptionUtil.getSha3Hash(
        "-----BEGIN CERTIFICATE-----", "-----END CERTIFICATE-----", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\n", "-----END CERTIFICATE-----", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\r", "-----END CERTIFICATE-----", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463", EncryptionUtil.getSha3Hash(
        "-----END CERTIFICATE-----", "-----END CERTIFICATE-----", "-----BEGIN CERTIFICATE-----", "ABC123"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----} and cr.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when '-----END CERTIFICATE-----' and cr")
  void testGetSha3HashWithDelimTokens_whenEndCertificateAndCr() {
    // Arrange, Act and Assert
    assertEquals("be09633c6cf03b003e0a4ae878e9d6149ed87886be559ca485a7545dbf8180ff",
        EncryptionUtil.getSha3Hash("Delim", "-----END CERTIFICATE-----", "\r"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----} and
   * {@code -----END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when '-----END CERTIFICATE-----' and '-----END CERTIFICATE-----'")
  void testGetSha3HashWithDelimTokens_whenEndCertificateAndEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("be09633c6cf03b003e0a4ae878e9d6149ed87886be559ca485a7545dbf8180ff",
        EncryptionUtil.getSha3Hash("Delim", "-----END CERTIFICATE-----", "-----END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----} and lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when '-----END CERTIFICATE-----' and lf")
  void testGetSha3HashWithDelimTokens_whenEndCertificateAndLf() {
    // Arrange, Act and Assert
    assertEquals("be09633c6cf03b003e0a4ae878e9d6149ed87886be559ca485a7545dbf8180ff",
        EncryptionUtil.getSha3Hash("Delim", "-----END CERTIFICATE-----", "\n"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code -----END CERTIFICATE-----} and {@code Tokens}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when '-----END CERTIFICATE-----' and 'Tokens'")
  void testGetSha3HashWithDelimTokens_whenEndCertificateAndTokens() {
    // Arrange, Act and Assert
    assertEquals("03232c36674e72bce1445fe2ef1ac28ecfb9f4ca29c4b4a847f129d8608408cb",
        EncryptionUtil.getSha3Hash("Delim", "-----END CERTIFICATE-----", "Tokens"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when lf")
  void testGetSha3HashWithDelimTokens_whenLf() {
    // Arrange, Act and Assert
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\n", "ABC123", "-----BEGIN CERTIFICATE-----"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\n", "ABC123", "-----BEGIN CERTIFICATE-----", "-----BEGIN CERTIFICATE-----"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\n", "ABC123", "-----BEGIN CERTIFICATE-----", "\n"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\n", "ABC123", "-----BEGIN CERTIFICATE-----", "\r"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\n", "ABC123", "-----BEGIN CERTIFICATE-----", "-----END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When lf and {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when lf and '42'")
  void testGetSha3HashWithDelimTokens_whenLfAnd42() {
    // Arrange, Act and Assert
    assertEquals("9c9532f85452cdd3999181a1ced58a027e922239cfb8372063a0e4b421040c8f",
        EncryptionUtil.getSha3Hash("Delim", "\n", "42"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When lf and {@code ABC123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when lf and 'ABC123'")
  void testGetSha3HashWithDelimTokens_whenLfAndAbc123() {
    // Arrange, Act and Assert
    assertEquals("a8d2e68389492719474a653248565f9ee07daf0132cce349c7f6b3261c4ffe3d",
        EncryptionUtil.getSha3Hash("Delim", "\n", "ABC123"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When lf and {@code -----BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when lf and '-----BEGIN CERTIFICATE-----'")
  void testGetSha3HashWithDelimTokens_whenLfAndBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "\n", "-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\n", "\n", "-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("\r", "\n", "-----BEGIN CERTIFICATE-----"));
    assertEquals("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "\n", "-----BEGIN CERTIFICATE-----"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", "\n", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\n", "\n", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\r", "\n", "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", "\n", "-----BEGIN CERTIFICATE-----", "ABC123"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When lf and cr.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when lf and cr")
  void testGetSha3HashWithDelimTokens_whenLfAndCr() {
    // Arrange, Act and Assert
    assertEquals("be09633c6cf03b003e0a4ae878e9d6149ed87886be559ca485a7545dbf8180ff",
        EncryptionUtil.getSha3Hash("Delim", "\n", "\r"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When lf and {@code -----END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when lf and '-----END CERTIFICATE-----'")
  void testGetSha3HashWithDelimTokens_whenLfAndEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("be09633c6cf03b003e0a4ae878e9d6149ed87886be559ca485a7545dbf8180ff",
        EncryptionUtil.getSha3Hash("Delim", "\n", "-----END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When lf and lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when lf and lf")
  void testGetSha3HashWithDelimTokens_whenLfAndLf() {
    // Arrange, Act and Assert
    assertEquals("be09633c6cf03b003e0a4ae878e9d6149ed87886be559ca485a7545dbf8180ff",
        EncryptionUtil.getSha3Hash("Delim", "\n", "\n"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When lf and {@code Tokens}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when lf and 'Tokens'")
  void testGetSha3HashWithDelimTokens_whenLfAndTokens() {
    // Arrange, Act and Assert
    assertEquals("03232c36674e72bce1445fe2ef1ac28ecfb9f4ca29c4b4a847f129d8608408cb",
        EncryptionUtil.getSha3Hash("Delim", "\n", "Tokens"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code null} and {@code -----BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when 'null' and '-----BEGIN CERTIFICATE-----'")
  void testGetSha3HashWithDelimTokens_whenNullAndBeginCertificate() {
    // Arrange, Act and Assert
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("-----BEGIN CERTIFICATE-----", null, "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\n", null, "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("\r", null, "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash("-----END CERTIFICATE-----", null, "-----BEGIN CERTIFICATE-----", "ABC123"));
    assertEquals("69d8afb7d16c5ffc245caf297a3d91ea17924ea4f6835f666882eff859cde463",
        EncryptionUtil.getSha3Hash(TbMsg.EMPTY_STRING, null, "-----BEGIN CERTIFICATE-----", "ABC123"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code Tokens} and cr.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when 'Tokens' and cr")
  void testGetSha3HashWithDelimTokens_whenTokensAndCr() {
    // Arrange, Act and Assert
    assertEquals("2cfbbb58632c5668b9aee0ff8ae49464cd6cd450e47970cf1840b002926e7f44",
        EncryptionUtil.getSha3Hash("Delim", "Tokens", "\r"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code Tokens} and {@code -----END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when 'Tokens' and '-----END CERTIFICATE-----'")
  void testGetSha3HashWithDelimTokens_whenTokensAndEndCertificate() {
    // Arrange, Act and Assert
    assertEquals("2cfbbb58632c5668b9aee0ff8ae49464cd6cd450e47970cf1840b002926e7f44",
        EncryptionUtil.getSha3Hash("Delim", "Tokens", "-----END CERTIFICATE-----"));
  }

  /**
   * Test {@link EncryptionUtil#getSha3Hash(String, String[])} with {@code delim},
   * {@code tokens}.
   * <ul>
   *   <li>When {@code Tokens} and lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptionUtil#getSha3Hash(String, String[])}
   */
  @Test
  @DisplayName("Test getSha3Hash(String, String[]) with 'delim', 'tokens'; when 'Tokens' and lf")
  void testGetSha3HashWithDelimTokens_whenTokensAndLf() {
    // Arrange, Act and Assert
    assertEquals("2cfbbb58632c5668b9aee0ff8ae49464cd6cd450e47970cf1840b002926e7f44",
        EncryptionUtil.getSha3Hash("Delim", "Tokens", "\n"));
  }
}
