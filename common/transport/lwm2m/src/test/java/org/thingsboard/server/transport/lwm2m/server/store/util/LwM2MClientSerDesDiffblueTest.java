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
package org.thingsboard.server.transport.lwm2m.server.store.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.eclipse.leshan.core.LwM2m;
import org.eclipse.leshan.core.LwM2m.Version;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;

class LwM2MClientSerDesDiffblueTest {
  /**
   * Test {@link LwM2MClientSerDes#serialize(LwM2mClient)} with {@code client}.
   *
   * <p>Method under test: {@link LwM2MClientSerDes#serialize(LwM2mClient)}
   */
  @Test
  @DisplayName("Test serialize(LwM2mClient) with 'client'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] LwM2MClientSerDes.serialize(LwM2mClient)"})
  void testSerializeWithClient() {
    // Arrange and Act
    byte[] actualSerializeResult =
        LwM2MClientSerDes.serialize(
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Assert
    assertEquals(246, actualSerializeResult.length);
    assertEquals(',', actualSerializeResult[227]);
    assertEquals('0', actualSerializeResult[244]);
    assertEquals('2', actualSerializeResult[12]);
    assertEquals('4', actualSerializeResult[11]);
    assertEquals(':', actualSerializeResult[222]);
    assertEquals(':', actualSerializeResult[243]);
    assertEquals('A', actualSerializeResult[234]);
    assertEquals('"', actualSerializeResult[10]);
    assertEquals('"', actualSerializeResult[13]);
    assertEquals('"', actualSerializeResult[221]);
    assertEquals('"', actualSerializeResult[228]);
    assertEquals('"', actualSerializeResult[242]);
    assertEquals('e', actualSerializeResult[226]);
    assertEquals('e', actualSerializeResult[230]);
    assertEquals('e', actualSerializeResult[237]);
    assertEquals('m', actualSerializeResult[238]);
    assertEquals('p', actualSerializeResult[239]);
    assertEquals('r', actualSerializeResult[224]);
    assertEquals('r', actualSerializeResult[229]);
    assertEquals('r', actualSerializeResult[232]);
    assertEquals('s', actualSerializeResult[241]);
    assertEquals('t', actualSerializeResult[223]);
    assertEquals('t', actualSerializeResult[231]);
    assertEquals('t', actualSerializeResult[235]);
    assertEquals('t', actualSerializeResult[236]);
    assertEquals('t', actualSerializeResult[240]);
    assertEquals('u', actualSerializeResult[225]);
    assertEquals('y', actualSerializeResult[233]);
    assertEquals('}', actualSerializeResult[245]);
  }

  /**
   * Test {@link LwM2MClientSerDes#serialize(LwM2mClient)} with {@code client}.
   *
   * <ul>
   *   <li>Given Default.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MClientSerDes#serialize(LwM2mClient)}
   */
  @Test
  @DisplayName("Test serialize(LwM2mClient) with 'client'; given Default")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] LwM2MClientSerDes.serialize(LwM2mClient)"})
  void testSerializeWithClient_givenDefault() {
    // Arrange
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    client.setDefaultObjectIDVer(Version.getDefault());

    // Act
    byte[] actualSerializeResult = LwM2MClientSerDes.serialize(client);

    // Assert
    assertEquals(246, actualSerializeResult.length);
    assertEquals(',', actualSerializeResult[227]);
    assertEquals('0', actualSerializeResult[244]);
    assertEquals('2', actualSerializeResult[12]);
    assertEquals('4', actualSerializeResult[11]);
    assertEquals(':', actualSerializeResult[222]);
    assertEquals(':', actualSerializeResult[243]);
    assertEquals('A', actualSerializeResult[234]);
    assertEquals('"', actualSerializeResult[10]);
    assertEquals('"', actualSerializeResult[13]);
    assertEquals('"', actualSerializeResult[221]);
    assertEquals('"', actualSerializeResult[228]);
    assertEquals('"', actualSerializeResult[242]);
    assertEquals('e', actualSerializeResult[226]);
    assertEquals('e', actualSerializeResult[230]);
    assertEquals('e', actualSerializeResult[237]);
    assertEquals('m', actualSerializeResult[238]);
    assertEquals('p', actualSerializeResult[239]);
    assertEquals('r', actualSerializeResult[224]);
    assertEquals('r', actualSerializeResult[229]);
    assertEquals('r', actualSerializeResult[232]);
    assertEquals('s', actualSerializeResult[241]);
    assertEquals('t', actualSerializeResult[223]);
    assertEquals('t', actualSerializeResult[231]);
    assertEquals('t', actualSerializeResult[235]);
    assertEquals('t', actualSerializeResult[236]);
    assertEquals('t', actualSerializeResult[240]);
    assertEquals('u', actualSerializeResult[225]);
    assertEquals('y', actualSerializeResult[233]);
    assertEquals('}', actualSerializeResult[245]);
  }

  /**
   * Test {@link LwM2MClientSerDes#serialize(LwM2mClient)} with {@code client}.
   *
   * <ul>
   *   <li>Given randomUUID.
   *   <li>Then return array length is three hundred one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MClientSerDes#serialize(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test serialize(LwM2mClient) with 'client'; given randomUUID; then return array length is three hundred one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] LwM2MClientSerDes.serialize(LwM2mClient)"})
  void testSerializeWithClient_givenRandomUUID_thenReturnArrayLengthIsThreeHundredOne() {
    // Arrange
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    client.setLastSentRpcId(UUID.randomUUID());

    // Act
    byte[] actualSerializeResult = LwM2MClientSerDes.serialize(client);

    // Assert
    assertEquals(301, actualSerializeResult.length);
    assertEquals('-', actualSerializeResult[276]);
    assertEquals('-', actualSerializeResult[281]);
    assertEquals('-', actualSerializeResult[286]);
    assertEquals('4', actualSerializeResult[277]);
    assertEquals('"', actualSerializeResult[299]);
    assertEquals('}', actualSerializeResult[300]);
  }

  /**
   * Test {@link LwM2MClientSerDes#serialize(LwM2mClient)} with {@code client}.
   *
   * <ul>
   *   <li>Then return thirteenth element is {@code l}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MClientSerDes#serialize(LwM2mClient)}
   */
  @Test
  @DisplayName("Test serialize(LwM2mClient) with 'client'; then return thirteenth element is 'l'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] LwM2MClientSerDes.serialize(LwM2mClient)"})
  void testSerializeWithClient_thenReturnThirteenthElementIsL() {
    // Arrange and Act
    byte[] actualSerializeResult =
        LwM2MClientSerDes.serialize(
            new LwM2mClient(null, "https://config.us-east-2.amazonaws.com"));

    // Assert
    assertEquals(246, actualSerializeResult.length);
    assertEquals('l', actualSerializeResult[12]);
    assertEquals('l', actualSerializeResult[13]);
    assertEquals('n', actualSerializeResult[10]);
    assertEquals('u', actualSerializeResult[11]);
  }
}
