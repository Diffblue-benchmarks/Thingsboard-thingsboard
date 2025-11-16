/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.transport.lwm2m.secure;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.transport.TransportServiceCallback;
import org.thingsboard.server.common.transport.auth.ValidateDeviceCredentialsResponse;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.ValidateDeviceLwM2MCredentialsRequestMsg;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2MAuthException;
import org.thingsboard.server.transport.lwm2m.server.uplink.LwM2mTypeServer;

@ExtendWith(MockitoExtension.class)
class LwM2mCredentialsSecurityInfoValidatorDiffblueTest {
  @Mock private LwM2MTransportServerConfig lwM2MTransportServerConfig;

  @InjectMocks private LwM2mCredentialsSecurityInfoValidator lwM2mCredentialsSecurityInfoValidator;

  @Mock private LwM2mTransportContext lwM2mTransportContext;

  /**
   * Test {@link
   * LwM2mCredentialsSecurityInfoValidator#getEndpointSecurityInfoByCredentialsId(String,
   * LwM2mTypeServer)}.
   *
   * <p>Method under test: {@link
   * LwM2mCredentialsSecurityInfoValidator#getEndpointSecurityInfoByCredentialsId(String,
   * LwM2mTypeServer)}
   */
  @Test
  @DisplayName("Test getEndpointSecurityInfoByCredentialsId(String, LwM2mTypeServer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.transport.lwm2m.secure.TbLwM2MSecurityInfo LwM2mCredentialsSecurityInfoValidator.getEndpointSecurityInfoByCredentialsId(String, LwM2mTypeServer)"
  })
  void testGetEndpointSecurityInfoByCredentialsId() {
    // Arrange
    when(lwM2mTransportContext.getTransportService()).thenThrow(new LwM2MAuthException());

    // Act and Assert
    assertThrows(
        LwM2MAuthException.class,
        () ->
            lwM2mCredentialsSecurityInfoValidator.getEndpointSecurityInfoByCredentialsId(
                "42", LwM2mTypeServer.BOOTSTRAP));
    verify(lwM2mTransportContext).getTransportService();
  }

  /**
   * Test {@link
   * LwM2mCredentialsSecurityInfoValidator#getEndpointSecurityInfoByCredentialsId(String,
   * LwM2mTypeServer)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       DefaultTransportService#process(ValidateDeviceLwM2MCredentialsRequestMsg,
   *       TransportServiceCallback)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mCredentialsSecurityInfoValidator#getEndpointSecurityInfoByCredentialsId(String,
   * LwM2mTypeServer)}
   */
  @Test
  @DisplayName(
      "Test getEndpointSecurityInfoByCredentialsId(String, LwM2mTypeServer); then calls process(ValidateDeviceLwM2MCredentialsRequestMsg, TransportServiceCallback)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.transport.lwm2m.secure.TbLwM2MSecurityInfo LwM2mCredentialsSecurityInfoValidator.getEndpointSecurityInfoByCredentialsId(String, LwM2mTypeServer)"
  })
  void testGetEndpointSecurityInfoByCredentialsId_thenCallsProcess() {
    // Arrange
    DefaultTransportService defaultTransportService = mock(DefaultTransportService.class);
    doNothing()
        .when(defaultTransportService)
        .process(
            Mockito.<ValidateDeviceLwM2MCredentialsRequestMsg>any(),
            Mockito.<TransportServiceCallback<ValidateDeviceCredentialsResponse>>any());
    when(lwM2mTransportContext.getTransportService()).thenReturn(defaultTransportService);
    when(lwM2MTransportServerConfig.getTimeout()).thenThrow(new LwM2MAuthException());

    // Act and Assert
    assertThrows(
        LwM2MAuthException.class,
        () ->
            lwM2mCredentialsSecurityInfoValidator.getEndpointSecurityInfoByCredentialsId(
                "42", LwM2mTypeServer.BOOTSTRAP));
    verify(lwM2mTransportContext).getTransportService();
    verify(defaultTransportService)
        .process(
            isA(ValidateDeviceLwM2MCredentialsRequestMsg.class),
            isA(TransportServiceCallback.class));
    verify(lwM2MTransportServerConfig).getTimeout();
  }
}
