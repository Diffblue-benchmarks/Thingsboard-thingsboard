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
package org.thingsboard.server.transport.coap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Any;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DynamicMessage.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TransportConfigurationContainerDiffblueTest {
  /**
   * Test {@link TransportConfigurationContainer#equals(Object)}, and {@link TransportConfigurationContainer#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportConfigurationContainer#equals(Object)}
   *   <li>{@link TransportConfigurationContainer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportConfigurationContainer.equals(Object)",
      "int TransportConfigurationContainer.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportConfigurationContainer transportConfigurationContainer = new TransportConfigurationContainer(true);
    TransportConfigurationContainer transportConfigurationContainer2 = new TransportConfigurationContainer(true);

    // Act and Assert
    assertEquals(transportConfigurationContainer, transportConfigurationContainer2);
    int expectedHashCodeResult = transportConfigurationContainer.hashCode();
    assertEquals(expectedHashCodeResult, transportConfigurationContainer2.hashCode());
  }

  /**
   * Test {@link TransportConfigurationContainer#equals(Object)}, and {@link TransportConfigurationContainer#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportConfigurationContainer#equals(Object)}
   *   <li>{@link TransportConfigurationContainer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportConfigurationContainer.equals(Object)",
      "int TransportConfigurationContainer.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Descriptor telemetryMsgDescriptor = Any.getDescriptor();
    Descriptor attributesMsgDescriptor = Any.getDescriptor();
    TransportConfigurationContainer transportConfigurationContainer = new TransportConfigurationContainer(true,
        telemetryMsgDescriptor, attributesMsgDescriptor, Any.getDescriptor(), null);
    Descriptor telemetryMsgDescriptor2 = Any.getDescriptor();
    Descriptor attributesMsgDescriptor2 = Any.getDescriptor();
    TransportConfigurationContainer transportConfigurationContainer2 = new TransportConfigurationContainer(true,
        telemetryMsgDescriptor2, attributesMsgDescriptor2, Any.getDescriptor(), null);

    // Act and Assert
    assertEquals(transportConfigurationContainer, transportConfigurationContainer2);
    int expectedHashCodeResult = transportConfigurationContainer.hashCode();
    assertEquals(expectedHashCodeResult, transportConfigurationContainer2.hashCode());
  }

  /**
   * Test {@link TransportConfigurationContainer#equals(Object)}, and {@link TransportConfigurationContainer#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportConfigurationContainer#equals(Object)}
   *   <li>{@link TransportConfigurationContainer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportConfigurationContainer.equals(Object)",
      "int TransportConfigurationContainer.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportConfigurationContainer transportConfigurationContainer = new TransportConfigurationContainer(true);

    // Act and Assert
    assertEquals(transportConfigurationContainer, transportConfigurationContainer);
    int expectedHashCodeResult = transportConfigurationContainer.hashCode();
    assertEquals(expectedHashCodeResult, transportConfigurationContainer.hashCode());
  }

  /**
   * Test {@link TransportConfigurationContainer#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportConfigurationContainer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportConfigurationContainer.equals(Object)",
      "int TransportConfigurationContainer.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TransportConfigurationContainer transportConfigurationContainer = new TransportConfigurationContainer(false);

    // Act and Assert
    assertNotEquals(transportConfigurationContainer, new TransportConfigurationContainer(true));
  }

  /**
   * Test {@link TransportConfigurationContainer#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportConfigurationContainer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportConfigurationContainer.equals(Object)",
      "int TransportConfigurationContainer.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Descriptor telemetryMsgDescriptor = Any.getDescriptor();
    Descriptor attributesMsgDescriptor = Any.getDescriptor();
    TransportConfigurationContainer transportConfigurationContainer = new TransportConfigurationContainer(true,
        telemetryMsgDescriptor, attributesMsgDescriptor, Any.getDescriptor(), null);

    // Act and Assert
    assertNotEquals(transportConfigurationContainer, new TransportConfigurationContainer(true));
  }

  /**
   * Test {@link TransportConfigurationContainer#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportConfigurationContainer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportConfigurationContainer.equals(Object)",
      "int TransportConfigurationContainer.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TransportConfigurationContainer transportConfigurationContainer = new TransportConfigurationContainer(true);
    Descriptor telemetryMsgDescriptor = Any.getDescriptor();
    Descriptor attributesMsgDescriptor = Any.getDescriptor();

    // Act and Assert
    assertNotEquals(transportConfigurationContainer, new TransportConfigurationContainer(true, telemetryMsgDescriptor,
        attributesMsgDescriptor, Any.getDescriptor(), null));
  }

  /**
   * Test {@link TransportConfigurationContainer#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportConfigurationContainer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportConfigurationContainer.equals(Object)",
      "int TransportConfigurationContainer.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TransportConfigurationContainer transportConfigurationContainer = new TransportConfigurationContainer(true);
    transportConfigurationContainer.setAttributesMsgDescriptor(Any.getDescriptor());

    // Act and Assert
    assertNotEquals(transportConfigurationContainer, new TransportConfigurationContainer(true));
  }

  /**
   * Test {@link TransportConfigurationContainer#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportConfigurationContainer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportConfigurationContainer.equals(Object)",
      "int TransportConfigurationContainer.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TransportConfigurationContainer transportConfigurationContainer = new TransportConfigurationContainer(true);
    transportConfigurationContainer.setRpcResponseMsgDescriptor(Any.getDescriptor());

    // Act and Assert
    assertNotEquals(transportConfigurationContainer, new TransportConfigurationContainer(true));
  }

  /**
   * Test {@link TransportConfigurationContainer#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportConfigurationContainer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportConfigurationContainer.equals(Object)",
      "int TransportConfigurationContainer.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TransportConfigurationContainer transportConfigurationContainer = new TransportConfigurationContainer(true);

    TransportConfigurationContainer transportConfigurationContainer2 = new TransportConfigurationContainer(true);
    transportConfigurationContainer2.setAttributesMsgDescriptor(Any.getDescriptor());

    // Act and Assert
    assertNotEquals(transportConfigurationContainer, transportConfigurationContainer2);
  }

  /**
   * Test {@link TransportConfigurationContainer#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportConfigurationContainer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportConfigurationContainer.equals(Object)",
      "int TransportConfigurationContainer.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TransportConfigurationContainer transportConfigurationContainer = new TransportConfigurationContainer(true);

    TransportConfigurationContainer transportConfigurationContainer2 = new TransportConfigurationContainer(true);
    transportConfigurationContainer2.setRpcResponseMsgDescriptor(Any.getDescriptor());

    // Act and Assert
    assertNotEquals(transportConfigurationContainer, transportConfigurationContainer2);
  }

  /**
   * Test {@link TransportConfigurationContainer#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportConfigurationContainer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportConfigurationContainer.equals(Object)",
      "int TransportConfigurationContainer.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TransportConfigurationContainer(true), null);
  }

  /**
   * Test {@link TransportConfigurationContainer#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportConfigurationContainer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportConfigurationContainer.equals(Object)",
      "int TransportConfigurationContainer.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TransportConfigurationContainer(true), "Different type to TransportConfigurationContainer");
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When Descriptor.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportConfigurationContainer#TransportConfigurationContainer(boolean, Descriptor, Descriptor, Descriptor, Builder)}
   *   <li>{@link TransportConfigurationContainer#setAttributesMsgDescriptor(Descriptor)}
   *   <li>{@link TransportConfigurationContainer#setJsonPayload(boolean)}
   *   <li>{@link TransportConfigurationContainer#setRpcRequestDynamicMessageBuilder(Builder)}
   *   <li>{@link TransportConfigurationContainer#setRpcResponseMsgDescriptor(Descriptor)}
   *   <li>{@link TransportConfigurationContainer#setTelemetryMsgDescriptor(Descriptor)}
   *   <li>{@link TransportConfigurationContainer#toString()}
   *   <li>{@link TransportConfigurationContainer#getAttributesMsgDescriptor()}
   *   <li>{@link TransportConfigurationContainer#getRpcRequestDynamicMessageBuilder()}
   *   <li>{@link TransportConfigurationContainer#getRpcResponseMsgDescriptor()}
   *   <li>{@link TransportConfigurationContainer#getTelemetryMsgDescriptor()}
   *   <li>{@link TransportConfigurationContainer#isJsonPayload()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Descriptor")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TransportConfigurationContainer.<init>(boolean)",
      "void TransportConfigurationContainer.<init>(boolean, Descriptor, Descriptor, Descriptor, Builder)",
      "Descriptor TransportConfigurationContainer.getAttributesMsgDescriptor()",
      "Builder TransportConfigurationContainer.getRpcRequestDynamicMessageBuilder()",
      "Descriptor TransportConfigurationContainer.getRpcResponseMsgDescriptor()",
      "Descriptor TransportConfigurationContainer.getTelemetryMsgDescriptor()",
      "boolean TransportConfigurationContainer.isJsonPayload()",
      "void TransportConfigurationContainer.setAttributesMsgDescriptor(Descriptor)",
      "void TransportConfigurationContainer.setJsonPayload(boolean)",
      "void TransportConfigurationContainer.setRpcRequestDynamicMessageBuilder(Builder)",
      "void TransportConfigurationContainer.setRpcResponseMsgDescriptor(Descriptor)",
      "void TransportConfigurationContainer.setTelemetryMsgDescriptor(Descriptor)",
      "java.lang.String TransportConfigurationContainer.toString()"})
  void testGettersAndSetters_whenDescriptor() {
    // Arrange
    Descriptor telemetryMsgDescriptor = Any.getDescriptor();
    Descriptor attributesMsgDescriptor = Any.getDescriptor();

    // Act
    TransportConfigurationContainer actualTransportConfigurationContainer = new TransportConfigurationContainer(true,
        telemetryMsgDescriptor, attributesMsgDescriptor, Any.getDescriptor(), null);
    actualTransportConfigurationContainer.setAttributesMsgDescriptor(Any.getDescriptor());
    actualTransportConfigurationContainer.setJsonPayload(true);
    actualTransportConfigurationContainer.setRpcRequestDynamicMessageBuilder(null);
    actualTransportConfigurationContainer.setRpcResponseMsgDescriptor(Any.getDescriptor());
    Descriptor telemetryMsgDescriptor2 = Any.getDescriptor();
    actualTransportConfigurationContainer.setTelemetryMsgDescriptor(telemetryMsgDescriptor2);
    actualTransportConfigurationContainer.toString();
    Descriptor actualAttributesMsgDescriptor = actualTransportConfigurationContainer.getAttributesMsgDescriptor();
    Builder actualRpcRequestDynamicMessageBuilder = actualTransportConfigurationContainer
        .getRpcRequestDynamicMessageBuilder();
    Descriptor actualRpcResponseMsgDescriptor = actualTransportConfigurationContainer.getRpcResponseMsgDescriptor();
    Descriptor actualTelemetryMsgDescriptor = actualTransportConfigurationContainer.getTelemetryMsgDescriptor();

    // Assert
    assertNull(actualRpcRequestDynamicMessageBuilder);
    assertTrue(actualTransportConfigurationContainer.isJsonPayload());
    assertSame(telemetryMsgDescriptor2, actualAttributesMsgDescriptor);
    assertSame(telemetryMsgDescriptor2, actualRpcResponseMsgDescriptor);
    assertSame(telemetryMsgDescriptor2, actualTelemetryMsgDescriptor);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportConfigurationContainer#TransportConfigurationContainer(boolean)}
   *   <li>{@link TransportConfigurationContainer#setAttributesMsgDescriptor(Descriptor)}
   *   <li>{@link TransportConfigurationContainer#setJsonPayload(boolean)}
   *   <li>{@link TransportConfigurationContainer#setRpcRequestDynamicMessageBuilder(Builder)}
   *   <li>{@link TransportConfigurationContainer#setRpcResponseMsgDescriptor(Descriptor)}
   *   <li>{@link TransportConfigurationContainer#setTelemetryMsgDescriptor(Descriptor)}
   *   <li>{@link TransportConfigurationContainer#toString()}
   *   <li>{@link TransportConfigurationContainer#getAttributesMsgDescriptor()}
   *   <li>{@link TransportConfigurationContainer#getRpcRequestDynamicMessageBuilder()}
   *   <li>{@link TransportConfigurationContainer#getRpcResponseMsgDescriptor()}
   *   <li>{@link TransportConfigurationContainer#getTelemetryMsgDescriptor()}
   *   <li>{@link TransportConfigurationContainer#isJsonPayload()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TransportConfigurationContainer.<init>(boolean)",
      "void TransportConfigurationContainer.<init>(boolean, Descriptor, Descriptor, Descriptor, Builder)",
      "Descriptor TransportConfigurationContainer.getAttributesMsgDescriptor()",
      "Builder TransportConfigurationContainer.getRpcRequestDynamicMessageBuilder()",
      "Descriptor TransportConfigurationContainer.getRpcResponseMsgDescriptor()",
      "Descriptor TransportConfigurationContainer.getTelemetryMsgDescriptor()",
      "boolean TransportConfigurationContainer.isJsonPayload()",
      "void TransportConfigurationContainer.setAttributesMsgDescriptor(Descriptor)",
      "void TransportConfigurationContainer.setJsonPayload(boolean)",
      "void TransportConfigurationContainer.setRpcRequestDynamicMessageBuilder(Builder)",
      "void TransportConfigurationContainer.setRpcResponseMsgDescriptor(Descriptor)",
      "void TransportConfigurationContainer.setTelemetryMsgDescriptor(Descriptor)",
      "java.lang.String TransportConfigurationContainer.toString()"})
  void testGettersAndSetters_whenTrue() {
    // Arrange and Act
    TransportConfigurationContainer actualTransportConfigurationContainer = new TransportConfigurationContainer(true);
    actualTransportConfigurationContainer.setAttributesMsgDescriptor(Any.getDescriptor());
    actualTransportConfigurationContainer.setJsonPayload(true);
    actualTransportConfigurationContainer.setRpcRequestDynamicMessageBuilder(null);
    actualTransportConfigurationContainer.setRpcResponseMsgDescriptor(Any.getDescriptor());
    Descriptor telemetryMsgDescriptor = Any.getDescriptor();
    actualTransportConfigurationContainer.setTelemetryMsgDescriptor(telemetryMsgDescriptor);
    actualTransportConfigurationContainer.toString();
    Descriptor actualAttributesMsgDescriptor = actualTransportConfigurationContainer.getAttributesMsgDescriptor();
    Builder actualRpcRequestDynamicMessageBuilder = actualTransportConfigurationContainer
        .getRpcRequestDynamicMessageBuilder();
    Descriptor actualRpcResponseMsgDescriptor = actualTransportConfigurationContainer.getRpcResponseMsgDescriptor();
    Descriptor actualTelemetryMsgDescriptor = actualTransportConfigurationContainer.getTelemetryMsgDescriptor();

    // Assert
    assertNull(actualRpcRequestDynamicMessageBuilder);
    assertTrue(actualTransportConfigurationContainer.isJsonPayload());
    assertSame(telemetryMsgDescriptor, actualAttributesMsgDescriptor);
    assertSame(telemetryMsgDescriptor, actualRpcResponseMsgDescriptor);
    assertSame(telemetryMsgDescriptor, actualTelemetryMsgDescriptor);
  }
}
