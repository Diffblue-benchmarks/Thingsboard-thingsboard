package org.thingsboard.server.common.data.mail;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MailOauth2ProviderDiffblueTest {
  /**
   * Test {@link MailOauth2Provider#toString()}.
   * <p>
   * Method under test: {@link MailOauth2Provider#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String MailOauth2Provider.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("Google", MailOauth2Provider.valueOf("GOOGLE").toString());
  }
}
