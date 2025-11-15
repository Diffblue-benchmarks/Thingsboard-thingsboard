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
package org.thingsboard.server.transport.lwm2m.server.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LwM2MRpcRequestHeaderDiffblueTest {
  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}, and {@link LwM2MRpcRequestHeader#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MRpcRequestHeader#equals(Object)}
   *   <li>{@link LwM2MRpcRequestHeader#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcRequestHeader.equals(Object)", "int LwM2MRpcRequestHeader.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader.setId("42");
    lwM2MRpcRequestHeader.setKey("Key");

    LwM2MRpcRequestHeader lwM2MRpcRequestHeader2 = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader2.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader2.setId("42");
    lwM2MRpcRequestHeader2.setKey("Key");

    // Act and Assert
    assertEquals(lwM2MRpcRequestHeader, lwM2MRpcRequestHeader2);
    int expectedHashCodeResult = lwM2MRpcRequestHeader.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MRpcRequestHeader2.hashCode());
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}, and {@link LwM2MRpcRequestHeader#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MRpcRequestHeader#equals(Object)}
   *   <li>{@link LwM2MRpcRequestHeader#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcRequestHeader.equals(Object)", "int LwM2MRpcRequestHeader.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader.setId("42");
    lwM2MRpcRequestHeader.setKey("Key");
    RpcCreateRequest rpcCreateRequest = mock(RpcCreateRequest.class);
    when(rpcCreateRequest.getContentFormat()).thenReturn("Not all who wander are lost");
    when(rpcCreateRequest.getId()).thenReturn("42");
    when(rpcCreateRequest.getKey()).thenReturn("Key");
    when(rpcCreateRequest.canEqual(Mockito.<Object>any())).thenReturn(true);
    doNothing().when(rpcCreateRequest).setId(Mockito.<String>any());
    doNothing().when(rpcCreateRequest).setKey(Mockito.<String>any());
    doNothing().when(rpcCreateRequest).setContentFormat(Mockito.<String>any());
    rpcCreateRequest.setContentFormat("Not all who wander are lost");
    rpcCreateRequest.setId("42");
    rpcCreateRequest.setKey("Key");

    // Act and Assert
    assertEquals(lwM2MRpcRequestHeader, rpcCreateRequest);
    int notExpectedHashCodeResult = lwM2MRpcRequestHeader.hashCode();
    assertNotEquals(notExpectedHashCodeResult, rpcCreateRequest.hashCode());
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}, and {@link LwM2MRpcRequestHeader#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcRequestHeader.equals(Object)", "int LwM2MRpcRequestHeader.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RpcCreateRequest rpcCreateRequest = new RpcCreateRequest();
    rpcCreateRequest.setContentFormat("Not all who wander are lost");
    rpcCreateRequest.setId("42");
    rpcCreateRequest.setKey("Key");
    rpcCreateRequest.setNodes(new HashMap<>());
    rpcCreateRequest.setValue("Value");
    rpcCreateRequest.setContentFormat("Not all who wander are lost");
    rpcCreateRequest.setId("42");
    rpcCreateRequest.setKey("Key");
    RpcCreateRequest rpcCreateRequest2 = mock(RpcCreateRequest.class);
    when(rpcCreateRequest2.getNodes()).thenReturn(new HashMap<>());
    when(rpcCreateRequest2.getValue()).thenReturn("Value");
    when(rpcCreateRequest2.getContentFormat()).thenReturn("Not all who wander are lost");
    when(rpcCreateRequest2.getId()).thenReturn("42");
    when(rpcCreateRequest2.getKey()).thenReturn("Key");
    when(rpcCreateRequest2.canEqual(Mockito.<Object>any())).thenReturn(true);
    doNothing().when(rpcCreateRequest2).setId(Mockito.<String>any());
    doNothing().when(rpcCreateRequest2).setKey(Mockito.<String>any());
    doNothing().when(rpcCreateRequest2).setContentFormat(Mockito.<String>any());
    rpcCreateRequest2.setContentFormat("Not all who wander are lost");
    rpcCreateRequest2.setId("42");
    rpcCreateRequest2.setKey("Key");

    // Act and Assert
    assertEquals(rpcCreateRequest, rpcCreateRequest2);
    int notExpectedHashCodeResult = rpcCreateRequest.hashCode();
    assertNotEquals(notExpectedHashCodeResult, rpcCreateRequest2.hashCode());
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}, and {@link LwM2MRpcRequestHeader#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MRpcRequestHeader#equals(Object)}
   *   <li>{@link LwM2MRpcRequestHeader#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcRequestHeader.equals(Object)", "int LwM2MRpcRequestHeader.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader.setId("42");
    lwM2MRpcRequestHeader.setKey("Key");

    // Act and Assert
    assertEquals(lwM2MRpcRequestHeader, lwM2MRpcRequestHeader);
    int expectedHashCodeResult = lwM2MRpcRequestHeader.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MRpcRequestHeader.hashCode());
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcRequestHeader.equals(Object)", "int LwM2MRpcRequestHeader.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RpcCreateRequest rpcCreateRequest = new RpcCreateRequest();
    rpcCreateRequest.setContentFormat("Not all who wander are lost");
    rpcCreateRequest.setId("42");
    rpcCreateRequest.setKey("Key");
    rpcCreateRequest.setNodes(new HashMap<>());
    rpcCreateRequest.setValue("Value");
    rpcCreateRequest.setContentFormat("Not all who wander are lost");
    rpcCreateRequest.setId("42");
    rpcCreateRequest.setKey("Key");

    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader.setId("42");
    lwM2MRpcRequestHeader.setKey("Key");

    // Act and Assert
    assertNotEquals(rpcCreateRequest, lwM2MRpcRequestHeader);
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcRequestHeader.equals(Object)", "int LwM2MRpcRequestHeader.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat("Key");
    lwM2MRpcRequestHeader.setId("42");
    lwM2MRpcRequestHeader.setKey("Key");

    LwM2MRpcRequestHeader lwM2MRpcRequestHeader2 = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader2.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader2.setId("42");
    lwM2MRpcRequestHeader2.setKey("Key");

    // Act and Assert
    assertNotEquals(lwM2MRpcRequestHeader, lwM2MRpcRequestHeader2);
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcRequestHeader.equals(Object)", "int LwM2MRpcRequestHeader.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat(null);
    lwM2MRpcRequestHeader.setId("42");
    lwM2MRpcRequestHeader.setKey("Key");

    LwM2MRpcRequestHeader lwM2MRpcRequestHeader2 = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader2.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader2.setId("42");
    lwM2MRpcRequestHeader2.setKey("Key");

    // Act and Assert
    assertNotEquals(lwM2MRpcRequestHeader, lwM2MRpcRequestHeader2);
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcRequestHeader.equals(Object)", "int LwM2MRpcRequestHeader.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader.setId("Key");
    lwM2MRpcRequestHeader.setKey("Key");

    LwM2MRpcRequestHeader lwM2MRpcRequestHeader2 = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader2.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader2.setId("42");
    lwM2MRpcRequestHeader2.setKey("Key");

    // Act and Assert
    assertNotEquals(lwM2MRpcRequestHeader, lwM2MRpcRequestHeader2);
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcRequestHeader.equals(Object)", "int LwM2MRpcRequestHeader.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader.setId(null);
    lwM2MRpcRequestHeader.setKey("Key");

    LwM2MRpcRequestHeader lwM2MRpcRequestHeader2 = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader2.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader2.setId("42");
    lwM2MRpcRequestHeader2.setKey("Key");

    // Act and Assert
    assertNotEquals(lwM2MRpcRequestHeader, lwM2MRpcRequestHeader2);
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcRequestHeader.equals(Object)", "int LwM2MRpcRequestHeader.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader.setId("42");
    lwM2MRpcRequestHeader.setKey("42");

    LwM2MRpcRequestHeader lwM2MRpcRequestHeader2 = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader2.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader2.setId("42");
    lwM2MRpcRequestHeader2.setKey("Key");

    // Act and Assert
    assertNotEquals(lwM2MRpcRequestHeader, lwM2MRpcRequestHeader2);
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcRequestHeader.equals(Object)", "int LwM2MRpcRequestHeader.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader.setId("42");
    lwM2MRpcRequestHeader.setKey(null);

    LwM2MRpcRequestHeader lwM2MRpcRequestHeader2 = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader2.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader2.setId("42");
    lwM2MRpcRequestHeader2.setKey("Key");

    // Act and Assert
    assertNotEquals(lwM2MRpcRequestHeader, lwM2MRpcRequestHeader2);
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcRequestHeader.equals(Object)", "int LwM2MRpcRequestHeader.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader.setId("42");
    lwM2MRpcRequestHeader.setKey("Key");

    RpcCreateRequest rpcCreateRequest = new RpcCreateRequest();
    rpcCreateRequest.setContentFormat("Not all who wander are lost");
    rpcCreateRequest.setId("42");
    rpcCreateRequest.setKey("Key");
    rpcCreateRequest.setNodes(new HashMap<>());
    rpcCreateRequest.setValue("Value");
    rpcCreateRequest.setContentFormat("Not all who wander are lost");
    rpcCreateRequest.setId("42");
    rpcCreateRequest.setKey("Key");

    // Act and Assert
    assertNotEquals(lwM2MRpcRequestHeader, rpcCreateRequest);
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcRequestHeader.equals(Object)", "int LwM2MRpcRequestHeader.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader.setId("42");
    lwM2MRpcRequestHeader.setKey("Key");

    RpcCreateRequest rpcCreateRequest = new RpcCreateRequest();
    rpcCreateRequest.setContentFormat("Not all who wander are lost");
    rpcCreateRequest.setId("42");
    rpcCreateRequest.setKey("Key");
    rpcCreateRequest.setNodes(new HashMap<>());
    rpcCreateRequest.setValue(lwM2MRpcRequestHeader);
    rpcCreateRequest.setContentFormat("Not all who wander are lost");
    rpcCreateRequest.setId("42");
    rpcCreateRequest.setKey("Key");
    RpcCreateRequest rpcCreateRequest2 = mock(RpcCreateRequest.class);
    when(rpcCreateRequest2.getNodes()).thenReturn(new HashMap<>());
    when(rpcCreateRequest2.getValue()).thenReturn("Value");
    when(rpcCreateRequest2.getContentFormat()).thenReturn("Not all who wander are lost");
    when(rpcCreateRequest2.getId()).thenReturn("42");
    when(rpcCreateRequest2.getKey()).thenReturn("Key");
    when(rpcCreateRequest2.canEqual(Mockito.<Object>any())).thenReturn(true);
    doNothing().when(rpcCreateRequest2).setId(Mockito.<String>any());
    doNothing().when(rpcCreateRequest2).setKey(Mockito.<String>any());
    doNothing().when(rpcCreateRequest2).setContentFormat(Mockito.<String>any());
    rpcCreateRequest2.setContentFormat("Not all who wander are lost");
    rpcCreateRequest2.setId("42");
    rpcCreateRequest2.setKey("Key");

    // Act and Assert
    assertNotEquals(rpcCreateRequest, rpcCreateRequest2);
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcRequestHeader.equals(Object)", "int LwM2MRpcRequestHeader.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader.setId("42");
    lwM2MRpcRequestHeader.setKey("Key");

    // Act and Assert
    assertNotEquals(lwM2MRpcRequestHeader, null);
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcRequestHeader.equals(Object)", "int LwM2MRpcRequestHeader.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader.setId("42");
    lwM2MRpcRequestHeader.setKey("Key");

    // Act and Assert
    assertNotEquals(lwM2MRpcRequestHeader, "Different type to LwM2MRpcRequestHeader");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LwM2MRpcRequestHeader}
   *   <li>{@link LwM2MRpcRequestHeader#setContentFormat(String)}
   *   <li>{@link LwM2MRpcRequestHeader#setId(String)}
   *   <li>{@link LwM2MRpcRequestHeader#setKey(String)}
   *   <li>{@link LwM2MRpcRequestHeader#toString()}
   *   <li>{@link LwM2MRpcRequestHeader#getContentFormat()}
   *   <li>{@link LwM2MRpcRequestHeader#getId()}
   *   <li>{@link LwM2MRpcRequestHeader#getKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2MRpcRequestHeader.<init>()", "String LwM2MRpcRequestHeader.getContentFormat()",
      "String LwM2MRpcRequestHeader.getId()", "String LwM2MRpcRequestHeader.getKey()",
      "void LwM2MRpcRequestHeader.setContentFormat(String)", "void LwM2MRpcRequestHeader.setId(String)",
      "void LwM2MRpcRequestHeader.setKey(String)", "String LwM2MRpcRequestHeader.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2MRpcRequestHeader actualLwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    actualLwM2MRpcRequestHeader.setContentFormat("Not all who wander are lost");
    actualLwM2MRpcRequestHeader.setId("42");
    actualLwM2MRpcRequestHeader.setKey("Key");
    String actualToStringResult = actualLwM2MRpcRequestHeader.toString();
    String actualContentFormat = actualLwM2MRpcRequestHeader.getContentFormat();
    String actualId = actualLwM2MRpcRequestHeader.getId();

    // Assert
    assertEquals("42", actualId);
    assertEquals("Key", actualLwM2MRpcRequestHeader.getKey());
    assertEquals("LwM2MRpcRequestHeader(key=Key, id=42, contentFormat=Not all who wander are lost)",
        actualToStringResult);
    assertEquals("Not all who wander are lost", actualContentFormat);
  }
}
