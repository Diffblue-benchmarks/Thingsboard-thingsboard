package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JavaSerDesUtilDiffblueTest {
  /**
   * Test {@link JavaSerDesUtil#encode(Object)}, and
   * {@link JavaSerDesUtil#decode(byte[])}.
   * <ul>
   *   <li>When {@code Msq}.</li>
   *   <li>Then return decode is {@code Msq}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JavaSerDesUtil#encode(Object)}
   *   <li>{@link JavaSerDesUtil#decode(byte[])}
   * </ul>
   */
  @Test
  @DisplayName("Test encode(Object), and decode(byte[]); when 'Msq'; then return decode is 'Msq'")
  void testEncodeAndDecode_whenMsq_thenReturnDecodeIsMsq() {
    // Arrange, Act and Assert
    assertEquals("Msq", JavaSerDesUtil.decode(JavaSerDesUtil.encode("Msq")));
  }

  /**
   * Test {@link JavaSerDesUtil#encode(Object)}, and
   * {@link JavaSerDesUtil#decode(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return decode is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JavaSerDesUtil#encode(Object)}
   *   <li>{@link JavaSerDesUtil#decode(byte[])}
   * </ul>
   */
  @Test
  @DisplayName("Test encode(Object), and decode(byte[]); when 'null'; then return decode is 'null'")
  void testEncodeAndDecode_whenNull_thenReturnDecodeIsNull() {
    // Arrange, Act and Assert
    assertNull(JavaSerDesUtil.decode(JavaSerDesUtil.encode(null)));
  }
}
