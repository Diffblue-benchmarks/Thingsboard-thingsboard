package org.thingsboard.server.common.data.transport.snmp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AuthenticationProtocolDiffblueTest {
  /**
   * Test {@link AuthenticationProtocol#forName(String)}.
   *
   * <ul>
   *   <li>When {@code MD5}.
   *   <li>Then return {@link Optional#get()} is {@code MD5}.
   * </ul>
   *
   * <p>Method under test: {@link AuthenticationProtocol#forName(String)}
   */
  @Test
  @DisplayName("Test forName(String); when 'MD5'; then return get() is 'MD5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional AuthenticationProtocol.forName(String)"})
  void testForName_whenMd5_thenReturnGetIsMd5() {
    // Arrange and Act
    Optional<AuthenticationProtocol> actualForNameResult = AuthenticationProtocol.forName("MD5");

    // Assert
    assertEquals(AuthenticationProtocol.MD5, actualForNameResult.get());
    assertTrue(actualForNameResult.isPresent());
  }

  /**
   * Test {@link AuthenticationProtocol#forName(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link AuthenticationProtocol#forName(String)}
   */
  @Test
  @DisplayName("Test forName(String); when 'Name'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional AuthenticationProtocol.forName(String)"})
  void testForName_whenName_thenReturnNotPresent() {
    // Arrange and Act
    Optional<AuthenticationProtocol> actualForNameResult = AuthenticationProtocol.forName("Name");

    // Assert
    assertFalse(actualForNameResult.isPresent());
  }
}
