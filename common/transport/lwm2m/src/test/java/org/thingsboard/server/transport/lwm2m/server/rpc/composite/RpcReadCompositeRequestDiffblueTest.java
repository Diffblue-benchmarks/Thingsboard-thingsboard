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
package org.thingsboard.server.transport.lwm2m.server.rpc.composite;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RpcReadCompositeRequestDiffblueTest {
  /**
   * Test {@link RpcReadCompositeRequest#equals(Object)}, and {@link
   * RpcReadCompositeRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RpcReadCompositeRequest#equals(Object)}
   *   <li>{@link RpcReadCompositeRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RpcReadCompositeRequest.equals(Object)",
    "int RpcReadCompositeRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RpcReadCompositeRequest rpcReadCompositeRequest = new RpcReadCompositeRequest();
    rpcReadCompositeRequest.setIds(new String[] {"Ids"});
    rpcReadCompositeRequest.setKeys(new String[] {"Keys"});

    RpcReadCompositeRequest rpcReadCompositeRequest2 = new RpcReadCompositeRequest();
    rpcReadCompositeRequest2.setIds(new String[] {"Ids"});
    rpcReadCompositeRequest2.setKeys(new String[] {"Keys"});

    // Act and Assert
    assertEquals(rpcReadCompositeRequest, rpcReadCompositeRequest2);
    assertEquals(rpcReadCompositeRequest.hashCode(), rpcReadCompositeRequest2.hashCode());
  }

  /**
   * Test {@link RpcReadCompositeRequest#equals(Object)}, and {@link
   * RpcReadCompositeRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RpcReadCompositeRequest#equals(Object)}
   *   <li>{@link RpcReadCompositeRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RpcReadCompositeRequest.equals(Object)",
    "int RpcReadCompositeRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RpcReadCompositeRequest rpcReadCompositeRequest = new RpcReadCompositeRequest();
    rpcReadCompositeRequest.setIds(new String[] {"Ids"});
    rpcReadCompositeRequest.setKeys(new String[] {"Keys"});

    // Act and Assert
    assertEquals(rpcReadCompositeRequest, rpcReadCompositeRequest);
    int expectedHashCodeResult = rpcReadCompositeRequest.hashCode();
    assertEquals(expectedHashCodeResult, rpcReadCompositeRequest.hashCode());
  }

  /**
   * Test {@link RpcReadCompositeRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcReadCompositeRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RpcReadCompositeRequest.equals(Object)",
    "int RpcReadCompositeRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RpcReadCompositeRequest rpcReadCompositeRequest = new RpcReadCompositeRequest();
    rpcReadCompositeRequest.setIds(new String[] {});
    rpcReadCompositeRequest.setKeys(new String[] {"Keys"});

    RpcReadCompositeRequest rpcReadCompositeRequest2 = new RpcReadCompositeRequest();
    rpcReadCompositeRequest2.setIds(new String[] {"Ids"});
    rpcReadCompositeRequest2.setKeys(new String[] {"Keys"});

    // Act and Assert
    assertNotEquals(rpcReadCompositeRequest, rpcReadCompositeRequest2);
  }

  /**
   * Test {@link RpcReadCompositeRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcReadCompositeRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RpcReadCompositeRequest.equals(Object)",
    "int RpcReadCompositeRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RpcReadCompositeRequest rpcReadCompositeRequest = new RpcReadCompositeRequest();
    rpcReadCompositeRequest.setIds(new String[] {"Ids"});
    rpcReadCompositeRequest.setKeys(new String[] {});

    RpcReadCompositeRequest rpcReadCompositeRequest2 = new RpcReadCompositeRequest();
    rpcReadCompositeRequest2.setIds(new String[] {"Ids"});
    rpcReadCompositeRequest2.setKeys(new String[] {"Keys"});

    // Act and Assert
    assertNotEquals(rpcReadCompositeRequest, rpcReadCompositeRequest2);
  }

  /**
   * Test {@link RpcReadCompositeRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcReadCompositeRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RpcReadCompositeRequest.equals(Object)",
    "int RpcReadCompositeRequest.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RpcReadCompositeRequest rpcReadCompositeRequest = new RpcReadCompositeRequest();
    rpcReadCompositeRequest.setIds(new String[] {"Ids"});
    rpcReadCompositeRequest.setKeys(new String[] {"Keys"});

    // Act and Assert
    assertNotEquals(rpcReadCompositeRequest, null);
  }

  /**
   * Test {@link RpcReadCompositeRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcReadCompositeRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RpcReadCompositeRequest.equals(Object)",
    "int RpcReadCompositeRequest.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RpcReadCompositeRequest rpcReadCompositeRequest = new RpcReadCompositeRequest();
    rpcReadCompositeRequest.setIds(new String[] {"Ids"});
    rpcReadCompositeRequest.setKeys(new String[] {"Keys"});

    // Act and Assert
    assertNotEquals(rpcReadCompositeRequest, "Different type to RpcReadCompositeRequest");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link RpcReadCompositeRequest}
   *   <li>{@link RpcReadCompositeRequest#setIds(String[])}
   *   <li>{@link RpcReadCompositeRequest#setKeys(String[])}
   *   <li>{@link RpcReadCompositeRequest#toString()}
   *   <li>{@link RpcReadCompositeRequest#getIds()}
   *   <li>{@link RpcReadCompositeRequest#getKeys()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcReadCompositeRequest.<init>()",
    "String[] RpcReadCompositeRequest.getIds()",
    "String[] RpcReadCompositeRequest.getKeys()",
    "void RpcReadCompositeRequest.setIds(String[])",
    "void RpcReadCompositeRequest.setKeys(String[])",
    "String RpcReadCompositeRequest.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RpcReadCompositeRequest actualRpcReadCompositeRequest = new RpcReadCompositeRequest();
    String[] ids = new String[] {"Ids"};
    actualRpcReadCompositeRequest.setIds(ids);
    String[] keys = new String[] {"Keys"};
    actualRpcReadCompositeRequest.setKeys(keys);
    String actualToStringResult = actualRpcReadCompositeRequest.toString();
    String[] actualIds = actualRpcReadCompositeRequest.getIds();
    String[] actualKeys = actualRpcReadCompositeRequest.getKeys();

    // Assert
    assertEquals("RpcReadCompositeRequest(keys=[Keys], ids=[Ids])", actualToStringResult);
    assertSame(ids, actualIds);
    assertSame(keys, actualKeys);
    assertArrayEquals(new String[] {"Ids"}, actualIds);
    assertArrayEquals(new String[] {"Keys"}, actualKeys);
  }
}
