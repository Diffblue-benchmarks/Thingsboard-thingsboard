package org.thingsboard.server.common.data.device.credentials.lwm2m;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractLwM2MClientCredentialDiffblueTest {
  /**
   * Test {@link AbstractLwM2MClientCredential#getEndpoint()}.
   *
   * <p>Method under test: {@link AbstractLwM2MClientCredential#getEndpoint()}
   */
  @Test
  @DisplayName("Test getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractLwM2MClientCredential.getEndpoint()"})
  void testGetEndpoint() {
    // Arrange, Act and Assert
    assertNull(new NoSecClientCredential().getEndpoint());
  }

  /**
   * Test {@link AbstractLwM2MClientCredential#setEndpoint(String)}.
   *
   * <p>Method under test: {@link AbstractLwM2MClientCredential#setEndpoint(String)}
   */
  @Test
  @DisplayName("Test setEndpoint(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractLwM2MClientCredential.setEndpoint(String)"})
  void testSetEndpoint() {
    // Arrange
    NoSecClientCredential noSecClientCredential = new NoSecClientCredential();

    // Act
    noSecClientCredential.setEndpoint("https://config.us-east-2.amazonaws.com");

    // Assert
    assertEquals("https://config.us-east-2.amazonaws.com", noSecClientCredential.getEndpoint());
  }
}
