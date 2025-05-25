package org.thingsboard.server.transport.lwm2m.server;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.eclipse.leshan.server.registration.Registration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClientContext;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class LwM2mVersionedModelProviderDiffblueTest {
  @Mock
  private LwM2mClientContext lwM2mClientContext;

  @InjectMocks
  private LwM2mVersionedModelProvider lwM2mVersionedModelProvider;

  /**
   * Test {@link LwM2mVersionedModelProvider#getObjectModel(Registration)}.
   * <p>
   * Method under test: {@link LwM2mVersionedModelProvider#getObjectModel(Registration)}
   */
  @Test
  @DisplayName("Test getObjectModel(Registration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.eclipse.leshan.core.model.LwM2mModel LwM2mVersionedModelProvider.getObjectModel(Registration)"})
  void testGetObjectModel() {
    // Arrange
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    lwM2mVersionedModelProvider.getObjectModel(registration);

    // Assert
    verify(registration).getEndpoint();
    verify(lwM2mClientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2mVersionedModelProvider#getObjectModel(Registration)}.
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getTenantId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mVersionedModelProvider#getObjectModel(Registration)}
   */
  @Test
  @DisplayName("Test getObjectModel(Registration); then calls getTenantId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.eclipse.leshan.core.model.LwM2mModel LwM2mVersionedModelProvider.getObjectModel(Registration)"})
  void testGetObjectModel_thenCallsGetTenantId() {
    // Arrange
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    when(lwM2mClient.getTenantId()).thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any())).thenReturn(lwM2mClient);
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    lwM2mVersionedModelProvider.getObjectModel(registration);

    // Assert
    verify(registration).getEndpoint();
    verify(lwM2mClient).getTenantId();
    verify(lwM2mClientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }
}
