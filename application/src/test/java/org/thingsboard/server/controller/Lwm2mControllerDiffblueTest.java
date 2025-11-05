package org.thingsboard.server.controller;

import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.device.profile.lwm2m.bootstrap.LwM2MServerSecurityConfigDefault;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.service.lwm2m.LwM2MService;

@ExtendWith(MockitoExtension.class)
class Lwm2mControllerDiffblueTest {
  @Mock private LwM2MService lwM2MService;

  @InjectMocks private Lwm2mController lwm2mController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link Lwm2mController#getLwm2mBootstrapSecurityInfo(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link Lwm2mController#getLwm2mBootstrapSecurityInfo(boolean)}
   */
  @Test
  @DisplayName(
      "Test getLwm2mBootstrapSecurityInfo(boolean); when 'true'; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LwM2MServerSecurityConfigDefault Lwm2mController.getLwm2mBootstrapSecurityInfo(boolean)"
  })
  void testGetLwm2mBootstrapSecurityInfo_whenTrue_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    LwM2MServerSecurityConfigDefault lwM2MServerSecurityConfigDefault =
        new LwM2MServerSecurityConfigDefault();
    lwM2MServerSecurityConfigDefault.setBinding("Binding");
    lwM2MServerSecurityConfigDefault.setBootstrapServerAccountTimeout(3);
    lwM2MServerSecurityConfigDefault.setBootstrapServerIs(true);
    lwM2MServerSecurityConfigDefault.setClientHoldOffTime(1);
    lwM2MServerSecurityConfigDefault.setDefaultMinPeriod(1);
    lwM2MServerSecurityConfigDefault.setHost("localhost");
    lwM2MServerSecurityConfigDefault.setLifetime(1);
    lwM2MServerSecurityConfigDefault.setNotifIfDisabled(true);
    lwM2MServerSecurityConfigDefault.setPort(8080);
    lwM2MServerSecurityConfigDefault.setSecurityHost("localhost");
    lwM2MServerSecurityConfigDefault.setSecurityPort(8080);
    lwM2MServerSecurityConfigDefault.setServerCertificate("Server Certificate");
    lwM2MServerSecurityConfigDefault.setServerPublicKey("Server Public Key");
    lwM2MServerSecurityConfigDefault.setShortServerId(1);
    when(lwM2MService.getServerSecurityInfo(anyBoolean()))
        .thenReturn(lwM2MServerSecurityConfigDefault);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/lwm2m/deviceProfile/bootstrap/{isBootstrapServer}", true);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(lwm2mController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"shortServerId\":1,\"bootstrapServerIs\":true,\"host\":\"localhost\",\"port\":8080,\"clientHoldOffTime\":1,"
                        + "\"serverPublicKey\":\"Server Public Key\",\"serverCertificate\":\"Server Certificate\",\"bootstrapServerAccountTimeout"
                        + "\":3,\"lifetime\":1,\"defaultMinPeriod\":1,\"notifIfDisabled\":true,\"binding\":\"Binding\",\"securityHost\":"
                        + "\"localhost\",\"securityPort\":8080}"));
  }
}
