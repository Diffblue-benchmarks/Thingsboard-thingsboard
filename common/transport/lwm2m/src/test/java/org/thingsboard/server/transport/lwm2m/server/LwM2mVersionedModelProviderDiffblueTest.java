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
package org.thingsboard.server.transport.lwm2m.server;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Mock private LwM2mClientContext lwM2mClientContext;

  @InjectMocks private LwM2mVersionedModelProvider lwM2mVersionedModelProvider;

  /**
   * Test {@link LwM2mVersionedModelProvider#getObjectModel(Registration)}.
   *
   * <p>Method under test: {@link LwM2mVersionedModelProvider#getObjectModel(Registration)}
   */
  @Test
  @DisplayName("Test getObjectModel(Registration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.eclipse.leshan.core.model.LwM2mModel LwM2mVersionedModelProvider.getObjectModel(Registration)"
  })
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
    verify(lwM2mClientContext).getClientByEndpoint("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link LwM2mVersionedModelProvider#getObjectModel(Registration)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mVersionedModelProvider#getObjectModel(Registration)}
   */
  @Test
  @DisplayName("Test getObjectModel(Registration); then calls getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.eclipse.leshan.core.model.LwM2mModel LwM2mVersionedModelProvider.getObjectModel(Registration)"
  })
  void testGetObjectModel_thenCallsGetTenantId() {
    // Arrange
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    when(lwM2mClient.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any())).thenReturn(lwM2mClient);

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    lwM2mVersionedModelProvider.getObjectModel(registration);

    // Assert
    verify(registration).getEndpoint();
    verify(lwM2mClient).getTenantId();
    verify(lwM2mClientContext).getClientByEndpoint("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link LwM2mVersionedModelProvider#evict(TenantId, String)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link TenantId} {@link TenantId#isNullUid()} return {@code true}.
   *   <li>Then calls {@link TenantId#isNullUid()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mVersionedModelProvider#evict(TenantId, String)}
   */
  @Test
  @DisplayName(
      "Test evict(TenantId, String); given 'true'; when TenantId isNullUid() return 'true'; then calls isNullUid()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mVersionedModelProvider.evict(TenantId, String)"})
  void testEvict_givenTrue_whenTenantIdIsNullUidReturnTrue_thenCallsIsNullUid() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isNullUid()).thenReturn(true);

    // Act
    lwM2mVersionedModelProvider.evict(tenantId, "Key");

    // Assert
    verify(tenantId).isNullUid();
  }
}
