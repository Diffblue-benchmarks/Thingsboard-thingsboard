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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.google.protobuf.Any;
import com.google.protobuf.Descriptors;
import com.google.protobuf.DynamicMessage;
import org.junit.jupiter.api.Test;

class TransportConfigurationContainerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportConfigurationContainer#equals(Object)}
   *   <li>{@link TransportConfigurationContainer#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link TransportConfigurationContainer#equals(Object)}
   *   <li>{@link TransportConfigurationContainer#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Descriptors.Descriptor telemetryMsgDescriptor = Any.getDescriptor();
    Descriptors.Descriptor attributesMsgDescriptor = Any.getDescriptor();
    TransportConfigurationContainer transportConfigurationContainer = new TransportConfigurationContainer(true,
        telemetryMsgDescriptor, attributesMsgDescriptor, Any.getDescriptor(), null);
    Descriptors.Descriptor telemetryMsgDescriptor2 = Any.getDescriptor();
    Descriptors.Descriptor attributesMsgDescriptor2 = Any.getDescriptor();
    TransportConfigurationContainer transportConfigurationContainer2 = new TransportConfigurationContainer(true,
        telemetryMsgDescriptor2, attributesMsgDescriptor2, Any.getDescriptor(), null);

    // Act and Assert
    assertEquals(transportConfigurationContainer, transportConfigurationContainer2);
    int expectedHashCodeResult = transportConfigurationContainer.hashCode();
    assertEquals(expectedHashCodeResult, transportConfigurationContainer2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportConfigurationContainer#equals(Object)}
   *   <li>{@link TransportConfigurationContainer#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportConfigurationContainer transportConfigurationContainer = new TransportConfigurationContainer(true);

    // Act and Assert
    assertEquals(transportConfigurationContainer, transportConfigurationContainer);
    int expectedHashCodeResult = transportConfigurationContainer.hashCode();
    assertEquals(expectedHashCodeResult, transportConfigurationContainer.hashCode());
  }

  /**
   * Method under test: {@link TransportConfigurationContainer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TransportConfigurationContainer transportConfigurationContainer = new TransportConfigurationContainer(false);

    // Act and Assert
    assertNotEquals(transportConfigurationContainer, new TransportConfigurationContainer(true));
  }

  /**
   * Method under test: {@link TransportConfigurationContainer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Descriptors.Descriptor telemetryMsgDescriptor = Any.getDescriptor();
    Descriptors.Descriptor attributesMsgDescriptor = Any.getDescriptor();
    TransportConfigurationContainer transportConfigurationContainer = new TransportConfigurationContainer(true,
        telemetryMsgDescriptor, attributesMsgDescriptor, Any.getDescriptor(), null);

    // Act and Assert
    assertNotEquals(transportConfigurationContainer, new TransportConfigurationContainer(true));
  }

  /**
   * Method under test: {@link TransportConfigurationContainer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TransportConfigurationContainer transportConfigurationContainer = new TransportConfigurationContainer(true);
    Descriptors.Descriptor telemetryMsgDescriptor = Any.getDescriptor();
    Descriptors.Descriptor attributesMsgDescriptor = Any.getDescriptor();

    // Act and Assert
    assertNotEquals(transportConfigurationContainer, new TransportConfigurationContainer(true, telemetryMsgDescriptor,
        attributesMsgDescriptor, Any.getDescriptor(), null));
  }

  /**
   * Method under test: {@link TransportConfigurationContainer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TransportConfigurationContainer transportConfigurationContainer = new TransportConfigurationContainer(true);
    transportConfigurationContainer.setAttributesMsgDescriptor(Any.getDescriptor());

    // Act and Assert
    assertNotEquals(transportConfigurationContainer, new TransportConfigurationContainer(true));
  }

  /**
   * Method under test: {@link TransportConfigurationContainer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TransportConfigurationContainer transportConfigurationContainer = new TransportConfigurationContainer(true);
    transportConfigurationContainer.setRpcResponseMsgDescriptor(Any.getDescriptor());

    // Act and Assert
    assertNotEquals(transportConfigurationContainer, new TransportConfigurationContainer(true));
  }

  /**
   * Method under test: {@link TransportConfigurationContainer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TransportConfigurationContainer transportConfigurationContainer = new TransportConfigurationContainer(true);

    TransportConfigurationContainer transportConfigurationContainer2 = new TransportConfigurationContainer(true);
    transportConfigurationContainer2.setAttributesMsgDescriptor(Any.getDescriptor());

    // Act and Assert
    assertNotEquals(transportConfigurationContainer, transportConfigurationContainer2);
  }

  /**
   * Method under test: {@link TransportConfigurationContainer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TransportConfigurationContainer transportConfigurationContainer = new TransportConfigurationContainer(true);

    TransportConfigurationContainer transportConfigurationContainer2 = new TransportConfigurationContainer(true);
    transportConfigurationContainer2.setRpcResponseMsgDescriptor(Any.getDescriptor());

    // Act and Assert
    assertNotEquals(transportConfigurationContainer, transportConfigurationContainer2);
  }

  /**
   * Method under test: {@link TransportConfigurationContainer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TransportConfigurationContainer(true), null);
  }

  /**
   * Method under test: {@link TransportConfigurationContainer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TransportConfigurationContainer(true), "Different type to TransportConfigurationContainer");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TransportConfigurationContainer#TransportConfigurationContainer(boolean)}
   *   <li>
   * {@link TransportConfigurationContainer#setAttributesMsgDescriptor(Descriptors.Descriptor)}
   *   <li>{@link TransportConfigurationContainer#setJsonPayload(boolean)}
   *   <li>
   * {@link TransportConfigurationContainer#setRpcRequestDynamicMessageBuilder(DynamicMessage.Builder)}
   *   <li>
   * {@link TransportConfigurationContainer#setRpcResponseMsgDescriptor(Descriptors.Descriptor)}
   *   <li>
   * {@link TransportConfigurationContainer#setTelemetryMsgDescriptor(Descriptors.Descriptor)}
   *   <li>{@link TransportConfigurationContainer#toString()}
   *   <li>{@link TransportConfigurationContainer#getAttributesMsgDescriptor()}
   *   <li>
   * {@link TransportConfigurationContainer#getRpcRequestDynamicMessageBuilder()}
   *   <li>{@link TransportConfigurationContainer#getRpcResponseMsgDescriptor()}
   *   <li>{@link TransportConfigurationContainer#getTelemetryMsgDescriptor()}
   *   <li>{@link TransportConfigurationContainer#isJsonPayload()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TransportConfigurationContainer actualTransportConfigurationContainer = new TransportConfigurationContainer(true);
    actualTransportConfigurationContainer.setAttributesMsgDescriptor(Any.getDescriptor());
    actualTransportConfigurationContainer.setJsonPayload(true);
    actualTransportConfigurationContainer.setRpcRequestDynamicMessageBuilder(null);
    actualTransportConfigurationContainer.setRpcResponseMsgDescriptor(Any.getDescriptor());
    Descriptors.Descriptor telemetryMsgDescriptor = Any.getDescriptor();
    actualTransportConfigurationContainer.setTelemetryMsgDescriptor(telemetryMsgDescriptor);
    actualTransportConfigurationContainer.toString();
    Descriptors.Descriptor actualAttributesMsgDescriptor = actualTransportConfigurationContainer
        .getAttributesMsgDescriptor();
    actualTransportConfigurationContainer.getRpcRequestDynamicMessageBuilder();
    Descriptors.Descriptor actualRpcResponseMsgDescriptor = actualTransportConfigurationContainer
        .getRpcResponseMsgDescriptor();
    Descriptors.Descriptor actualTelemetryMsgDescriptor = actualTransportConfigurationContainer
        .getTelemetryMsgDescriptor();

    // Assert that nothing has changed
    assertTrue(actualTransportConfigurationContainer.isJsonPayload());
    assertSame(telemetryMsgDescriptor, actualAttributesMsgDescriptor);
    assertSame(telemetryMsgDescriptor, actualRpcResponseMsgDescriptor);
    assertSame(telemetryMsgDescriptor, actualTelemetryMsgDescriptor);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TransportConfigurationContainer#TransportConfigurationContainer(boolean, Descriptors.Descriptor, Descriptors.Descriptor, Descriptors.Descriptor, DynamicMessage.Builder)}
   *   <li>
   * {@link TransportConfigurationContainer#setAttributesMsgDescriptor(Descriptors.Descriptor)}
   *   <li>{@link TransportConfigurationContainer#setJsonPayload(boolean)}
   *   <li>
   * {@link TransportConfigurationContainer#setRpcRequestDynamicMessageBuilder(DynamicMessage.Builder)}
   *   <li>
   * {@link TransportConfigurationContainer#setRpcResponseMsgDescriptor(Descriptors.Descriptor)}
   *   <li>
   * {@link TransportConfigurationContainer#setTelemetryMsgDescriptor(Descriptors.Descriptor)}
   *   <li>{@link TransportConfigurationContainer#toString()}
   *   <li>{@link TransportConfigurationContainer#getAttributesMsgDescriptor()}
   *   <li>
   * {@link TransportConfigurationContainer#getRpcRequestDynamicMessageBuilder()}
   *   <li>{@link TransportConfigurationContainer#getRpcResponseMsgDescriptor()}
   *   <li>{@link TransportConfigurationContainer#getTelemetryMsgDescriptor()}
   *   <li>{@link TransportConfigurationContainer#isJsonPayload()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    Descriptors.Descriptor telemetryMsgDescriptor = Any.getDescriptor();
    Descriptors.Descriptor attributesMsgDescriptor = Any.getDescriptor();

    // Act
    TransportConfigurationContainer actualTransportConfigurationContainer = new TransportConfigurationContainer(true,
        telemetryMsgDescriptor, attributesMsgDescriptor, Any.getDescriptor(), null);
    actualTransportConfigurationContainer.setAttributesMsgDescriptor(Any.getDescriptor());
    actualTransportConfigurationContainer.setJsonPayload(true);
    actualTransportConfigurationContainer.setRpcRequestDynamicMessageBuilder(null);
    actualTransportConfigurationContainer.setRpcResponseMsgDescriptor(Any.getDescriptor());
    Descriptors.Descriptor telemetryMsgDescriptor2 = Any.getDescriptor();
    actualTransportConfigurationContainer.setTelemetryMsgDescriptor(telemetryMsgDescriptor2);
    actualTransportConfigurationContainer.toString();
    Descriptors.Descriptor actualAttributesMsgDescriptor = actualTransportConfigurationContainer
        .getAttributesMsgDescriptor();
    actualTransportConfigurationContainer.getRpcRequestDynamicMessageBuilder();
    Descriptors.Descriptor actualRpcResponseMsgDescriptor = actualTransportConfigurationContainer
        .getRpcResponseMsgDescriptor();
    Descriptors.Descriptor actualTelemetryMsgDescriptor = actualTransportConfigurationContainer
        .getTelemetryMsgDescriptor();

    // Assert that nothing has changed
    assertTrue(actualTransportConfigurationContainer.isJsonPayload());
    assertSame(telemetryMsgDescriptor2, actualAttributesMsgDescriptor);
    assertSame(telemetryMsgDescriptor2, actualRpcResponseMsgDescriptor);
    assertSame(telemetryMsgDescriptor2, actualTelemetryMsgDescriptor);
  }
}
