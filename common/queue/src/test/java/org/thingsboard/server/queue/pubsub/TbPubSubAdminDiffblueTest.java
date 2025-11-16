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
package org.thingsboard.server.queue.pubsub;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpResponseException.Builder;
import com.google.api.gax.core.CredentialsProvider;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TbPubSubAdminDiffblueTest {
  /**
   * Test {@link TbPubSubAdmin#TbPubSubAdmin(TbPubSubSettings, Map)}.
   *
   * <p>Method under test: {@link TbPubSubAdmin#TbPubSubAdmin(TbPubSubSettings, Map)}
   */
  @Test
  @DisplayName("Test new TbPubSubAdmin(TbPubSubSettings, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbPubSubAdmin.<init>(TbPubSubSettings, Map)"})
  void testNewTbPubSubAdmin() throws IOException {
    // Arrange
    CredentialsProvider credentialsProvider = mock(CredentialsProvider.class);

    Builder builder = new Builder(1, "https://example.org/example", new HttpHeaders());

    Builder setContentResult = builder.setAttemptCount(3).setContent("https://example.org/example");
    when(credentialsProvider.getCredentials())
        .thenThrow(
            setContentResult
                .setHeaders(new HttpHeaders())
                .setMessage("https://example.org/example")
                .setStatusCode(1)
                .setStatusMessage("https://example.org/example")
                .build());

    TbPubSubSettings pubSubSettings = mock(TbPubSubSettings.class);
    when(pubSubSettings.getCredentialsProvider()).thenReturn(credentialsProvider);
    doNothing().when(pubSubSettings).setCredentialsProvider(Mockito.<CredentialsProvider>any());
    pubSubSettings.setCredentialsProvider(mock(CredentialsProvider.class));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new TbPubSubAdmin(pubSubSettings, new HashMap<>()));
    verify(credentialsProvider).getCredentials();
    verify(pubSubSettings, atLeast(1)).getCredentialsProvider();
    verify(pubSubSettings).setCredentialsProvider(isA(CredentialsProvider.class));
  }
}
