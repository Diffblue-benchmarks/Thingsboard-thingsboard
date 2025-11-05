package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JavaSerDesUtilDiffblueTest {
  /**
   * Test {@link JavaSerDesUtil#encode(Object)}, and {@link JavaSerDesUtil#decode(byte[])}.
   *
   * <ul>
   *   <li>When {@code Msq}.
   *   <li>Then return decode is {@code Msq}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JavaSerDesUtil#encode(Object)}
   *   <li>{@link JavaSerDesUtil#decode(byte[])}
   * </ul>
   */
  @Test
  @DisplayName("Test encode(Object), and decode(byte[]); when 'Msq'; then return decode is 'Msq'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] JavaSerDesUtil.encode(Object)",
    "Object JavaSerDesUtil.decode(byte[])"
  })
  void testEncodeAndDecode_whenMsq_thenReturnDecodeIsMsq() {
    // Arrange, Act and Assert
    assertEquals("Msq", JavaSerDesUtil.decode(JavaSerDesUtil.encode("Msq")));
  }

  /**
   * Test {@link JavaSerDesUtil#encode(Object)}, and {@link JavaSerDesUtil#decode(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return decode is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JavaSerDesUtil#encode(Object)}
   *   <li>{@link JavaSerDesUtil#decode(byte[])}
   * </ul>
   */
  @Test
  @DisplayName("Test encode(Object), and decode(byte[]); when 'null'; then return decode is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] JavaSerDesUtil.encode(Object)",
    "Object JavaSerDesUtil.decode(byte[])"
  })
  void testEncodeAndDecode_whenNull_thenReturnDecodeIsNull() {
    // Arrange, Act and Assert
    assertNull(JavaSerDesUtil.decode(JavaSerDesUtil.encode(null)));
  }
}
