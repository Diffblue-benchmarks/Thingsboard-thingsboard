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
package org.thingsboard.server.common.data.device.credentials.lwm2m;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractLwM2MClientSecurityCredentialDiffblueTest {
  /**
   * Test {@link AbstractLwM2MClientSecurityCredential#getKey()}.
   *
   * <p>Method under test: {@link AbstractLwM2MClientSecurityCredential#getKey()}
   */
  @Test
  @DisplayName("Test getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractLwM2MClientSecurityCredential.getKey()"})
  void testGetKey() {
    // Arrange, Act and Assert
    assertNull(new PSKClientCredential().getKey());
  }

  /**
   * Test {@link AbstractLwM2MClientSecurityCredential#setKey(String)}.
   *
   * <p>Method under test: {@link AbstractLwM2MClientSecurityCredential#setKey(String)}
   */
  @Test
  @DisplayName("Test setKey(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
