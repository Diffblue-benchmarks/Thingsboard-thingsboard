package org.thingsboard.server.transport.lwm2m.bootstrap.store;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.eclipse.leshan.core.peer.OscoreIdentity;
import org.eclipse.leshan.server.bootstrap.BootstrapConfig;
import org.eclipse.leshan.server.bootstrap.EditableBootstrapConfigStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2MAuthException;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class LwM2MBootstrapSecurityStoreDiffblueTest {
  @Mock
  private EditableBootstrapConfigStore editableBootstrapConfigStore;

  @InjectMocks
  private LwM2MBootstrapSecurityStore lwM2MBootstrapSecurityStore;

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getByOscoreIdentity(OscoreIdentity)}.
   * <p>
   * Method under test: {@link LwM2MBootstrapSecurityStore#getByOscoreIdentity(OscoreIdentity)}
   */
  @Test
  @DisplayName("Test getByOscoreIdentity(OscoreIdentity)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.eclipse.leshan.server.security.SecurityInfo LwM2MBootstrapSecurityStore.getByOscoreIdentity(OscoreIdentity)"})
  void testGetByOscoreIdentity() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(lwM2MBootstrapSecurityStore.getByOscoreIdentity(new OscoreIdentity("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getSessionByEndpoint(String)}.
   * <p>
   * Method under test: {@link LwM2MBootstrapSecurityStore#getSessionByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getSessionByEndpoint(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto LwM2MBootstrapSecurityStore.getSessionByEndpoint(String)"})
  void testGetSessionByEndpoint() {
    // Arrange, Act and Assert
    assertNull(lwM2MBootstrapSecurityStore.getSessionByEndpoint("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#removeSessionByEndpoint(String)}.
   * <p>
   * Method under test: {@link LwM2MBootstrapSecurityStore#removeSessionByEndpoint(String)}
   */
  @Test
  @DisplayName("Test removeSessionByEndpoint(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto LwM2MBootstrapSecurityStore.removeSessionByEndpoint(String)"})
  void testRemoveSessionByEndpoint() {
    // Arrange, Act and Assert
    assertNull(lwM2MBootstrapSecurityStore.removeSessionByEndpoint("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getBootstrapConfigByEndpoint(String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MBootstrapSecurityStore#getBootstrapConfigByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getBootstrapConfigByEndpoint(String); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BootstrapConfig LwM2MBootstrapSecurityStore.getBootstrapConfigByEndpoint(String)"})
  void testGetBootstrapConfigByEndpoint_thenReturnNull() {
    // Arrange
    when(editableBootstrapConfigStore.getAll()).thenReturn(new HashMap<>());

    // Act
    BootstrapConfig actualBootstrapConfigByEndpoint = lwM2MBootstrapSecurityStore
        .getBootstrapConfigByEndpoint("https://config.us-east-2.amazonaws.com");

    // Assert
    verify(editableBootstrapConfigStore).getAll();
    assertNull(actualBootstrapConfigByEndpoint);
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getBootstrapConfigByEndpoint(String)}.
   * <ul>
   *   <li>Then throw {@link LwM2MAuthException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MBootstrapSecurityStore#getBootstrapConfigByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getBootstrapConfigByEndpoint(String); then throw LwM2MAuthException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BootstrapConfig LwM2MBootstrapSecurityStore.getBootstrapConfigByEndpoint(String)"})
  void testGetBootstrapConfigByEndpoint_thenThrowLwM2MAuthException() {
    // Arrange
    when(editableBootstrapConfigStore.getAll()).thenThrow(new LwM2MAuthException());

    // Act and Assert
    assertThrows(LwM2MAuthException.class,
        () -> lwM2MBootstrapSecurityStore.getBootstrapConfigByEndpoint("https://config.us-east-2.amazonaws.com"));
    verify(editableBootstrapConfigStore).getAll();
  }
}
