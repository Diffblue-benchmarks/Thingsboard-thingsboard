package org.thingsboard.server.common.data.device.credentials.lwm2m;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractLwM2MClientSecurityCredentialDiffblueTest {
  /**
   * Test {@link AbstractLwM2MClientSecurityCredential#getKey()}.
   * <p>
   * Method under test: {@link AbstractLwM2MClientSecurityCredential#getKey()}
   */
  @Test
  @DisplayName("Test getKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractLwM2MClientSecurityCredential.getKey()"})
  void testGetKey() {
    // Arrange, Act and Assert
    assertNull((new PSKClientCredential()).getKey());
  }

  /**
   * Test {@link AbstractLwM2MClientSecurityCredential#setKey(String)}.
   * <p>
   * Method under test: {@link AbstractLwM2MClientSecurityCredential#setKey(String)}
   */
  @Test
  @DisplayName("Test setKey(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractLwM2MClientSecurityCredential.setKey(String)"})
  void testSetKey() {
    // Arrange
    PSKClientCredential pskClientCredential = new PSKClientCredential();

    // Act
    pskClientCredential.setKey("Key");

    // Assert
    assertEquals("Key", pskClientCredential.getKey());
  }
}
