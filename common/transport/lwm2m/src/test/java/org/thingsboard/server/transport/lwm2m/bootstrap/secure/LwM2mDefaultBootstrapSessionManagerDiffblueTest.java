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
package org.thingsboard.server.transport.lwm2m.bootstrap.secure;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.eclipse.leshan.server.bootstrap.BootstrapConfigStore;
import org.eclipse.leshan.server.model.LwM2mBootstrapModelProvider;
import org.eclipse.leshan.server.security.BootstrapSecurityStore;
import org.eclipse.leshan.server.security.SecurityChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.bootstrap.store.LwM2MBootstrapConfigStoreTaskProvider;
import org.thingsboard.server.transport.lwm2m.bootstrap.store.LwM2MBootstrapSecurityStore;
import org.thingsboard.server.transport.lwm2m.bootstrap.store.LwM2MBootstrapTaskProvider;
import org.thingsboard.server.transport.lwm2m.bootstrap.store.LwM2MInMemoryBootstrapConfigStore;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.secure.LwM2mCredentialsSecurityInfoValidator;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportServerHelper;

class LwM2mDefaultBootstrapSessionManagerDiffblueTest {
  /**
   * Test {@link LwM2mDefaultBootstrapSessionManager#LwM2mDefaultBootstrapSessionManager(BootstrapSecurityStore, BootstrapConfigStore, SecurityChecker, LwM2MBootstrapTaskProvider, LwM2mBootstrapModelProvider)}.
   * <p>
   * Method under test: {@link LwM2mDefaultBootstrapSessionManager#LwM2mDefaultBootstrapSessionManager(BootstrapSecurityStore, BootstrapConfigStore, SecurityChecker, LwM2MBootstrapTaskProvider, LwM2mBootstrapModelProvider)}
   */
  @Test
  @DisplayName("Test new LwM2mDefaultBootstrapSessionManager(BootstrapSecurityStore, BootstrapConfigStore, SecurityChecker, LwM2MBootstrapTaskProvider, LwM2mBootstrapModelProvider)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void LwM2mDefaultBootstrapSessionManager.<init>(BootstrapSecurityStore, BootstrapConfigStore, SecurityChecker, LwM2MBootstrapTaskProvider, LwM2mBootstrapModelProvider)"})
  void testNewLwM2mDefaultBootstrapSessionManager() {
    // Arrange
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MBootstrapSecurityStore bsSecurityStore = new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, context2, new LwM2mTransportServerHelper(new LwM2mTransportContext()));

    BootstrapConfigStore configStore = mock(BootstrapConfigStore.class);
    SecurityChecker securityChecker = new SecurityChecker();

    // Act and Assert
    assertFalse((new LwM2mDefaultBootstrapSessionManager(bsSecurityStore, configStore, securityChecker,
        new LwM2MBootstrapConfigStoreTaskProvider(mock(BootstrapConfigStore.class)),
        mock(LwM2mBootstrapModelProvider.class))).hasConfigFor(null));
  }
}
