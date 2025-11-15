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
package org.thingsboard.server.common.data.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RpcId;
import org.thingsboard.server.common.data.id.TenantId;

class RpcDiffblueTest {
  /**
   * Method under test: {@link Rpc#getId()}
   */
  @Test
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new Rpc()).getId());
  }

  /**
   * Method under test: {@link Rpc#getCreatedTime()}
   */
  @Test
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new Rpc()).getCreatedTime());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Rpc#equals(Object)}
   *   <li>{@link Rpc#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Rpc rpc = new Rpc();
    Rpc rpc2 = new Rpc();

    // Act and Assert
    assertEquals(rpc, rpc2);
    int expectedHashCodeResult = rpc.hashCode();
    assertEquals(expectedHashCodeResult, rpc2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Rpc#equals(Object)}
   *   <li>{@link Rpc#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setTenantId(TenantId.SYS_TENANT_ID);

    Rpc rpc2 = new Rpc();
    rpc2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(rpc, rpc2);
    int expectedHashCodeResult = rpc.hashCode();
    assertEquals(expectedHashCodeResult, rpc2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Rpc#equals(Object)}
   *   <li>{@link Rpc#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setRequest(MissingNode.getInstance());

    Rpc rpc2 = new Rpc();
    rpc2.setRequest(MissingNode.getInstance());

    // Act and Assert
    assertEquals(rpc, rpc2);
    int expectedHashCodeResult = rpc.hashCode();
    assertEquals(expectedHashCodeResult, rpc2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Rpc#equals(Object)}
   *   <li>{@link Rpc#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setResponse(MissingNode.getInstance());

    Rpc rpc2 = new Rpc();
    rpc2.setResponse(MissingNode.getInstance());

    // Act and Assert
    assertEquals(rpc, rpc2);
    int expectedHashCodeResult = rpc.hashCode();
    assertEquals(expectedHashCodeResult, rpc2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Rpc#equals(Object)}
   *   <li>{@link Rpc#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setStatus(RpcStatus.QUEUED);

    Rpc rpc2 = new Rpc();
    rpc2.setStatus(RpcStatus.QUEUED);

    // Act and Assert
    assertEquals(rpc, rpc2);
    int expectedHashCodeResult = rpc.hashCode();
    assertEquals(expectedHashCodeResult, rpc2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Rpc#equals(Object)}
   *   <li>{@link Rpc#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setAdditionalInfo(MissingNode.getInstance());

    Rpc rpc2 = new Rpc();
    rpc2.setAdditionalInfo(MissingNode.getInstance());

    // Act and Assert
    assertEquals(rpc, rpc2);
    int expectedHashCodeResult = rpc.hashCode();
    assertEquals(expectedHashCodeResult, rpc2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Rpc#equals(Object)}
   *   <li>{@link Rpc#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Rpc rpc = new Rpc();

    // Act and Assert
    assertEquals(rpc, rpc);
    int expectedHashCodeResult = rpc.hashCode();
    assertEquals(expectedHashCodeResult, rpc.hashCode());
  }

  /**
   * Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Rpc rpc = new Rpc(new RpcId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(rpc, new Rpc());
  }

  /**
   * Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new Rpc(), mock(AdminSettings.class));
  }

  /**
   * Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(rpc, new Rpc());
  }

  /**
   * Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setExpirationTime(1L);

    // Act and Assert
    assertNotEquals(rpc, new Rpc());
  }

  /**
   * Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setRequest(MissingNode.getInstance());

    // Act and Assert
    assertNotEquals(rpc, new Rpc());
  }

  /**
   * Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setResponse(MissingNode.getInstance());

    // Act and Assert
    assertNotEquals(rpc, new Rpc());
  }

  /**
   * Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setStatus(RpcStatus.QUEUED);

    // Act and Assert
    assertNotEquals(rpc, new Rpc());
  }

  /**
   * Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setAdditionalInfo(MissingNode.getInstance());

    // Act and Assert
    assertNotEquals(rpc, new Rpc());
  }

  /**
   * Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Rpc rpc = new Rpc();

    Rpc rpc2 = new Rpc();
    rpc2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(rpc, rpc2);
  }

  /**
   * Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Rpc rpc = new Rpc();

    Rpc rpc2 = new Rpc();
    rpc2.setRequest(MissingNode.getInstance());

    // Act and Assert
    assertNotEquals(rpc, rpc2);
  }

  /**
   * Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Rpc rpc = new Rpc();

    Rpc rpc2 = new Rpc();
    rpc2.setResponse(MissingNode.getInstance());

    // Act and Assert
    assertNotEquals(rpc, rpc2);
  }

  /**
   * Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Rpc rpc = new Rpc();

    Rpc rpc2 = new Rpc();
    rpc2.setStatus(RpcStatus.QUEUED);

    // Act and Assert
    assertNotEquals(rpc, rpc2);
  }

  /**
   * Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    Rpc rpc = new Rpc();

    Rpc rpc2 = new Rpc();
    rpc2.setAdditionalInfo(MissingNode.getInstance());

    // Act and Assert
    assertNotEquals(rpc, rpc2);
  }

  /**
   * Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Rpc(), null);
  }

  /**
   * Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Rpc(), "Different type to Rpc");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Rpc#Rpc()}
   *   <li>{@link Rpc#setAdditionalInfo(JsonNode)}
   *   <li>{@link Rpc#setExpirationTime(long)}
   *   <li>{@link Rpc#setRequest(JsonNode)}
   *   <li>{@link Rpc#setResponse(JsonNode)}
   *   <li>{@link Rpc#setStatus(RpcStatus)}
   *   <li>{@link Rpc#setTenantId(TenantId)}
   *   <li>{@link Rpc#toString()}
   *   <li>{@link Rpc#getAdditionalInfo()}
   *   <li>{@link Rpc#getDeviceId()}
   *   <li>{@link Rpc#getExpirationTime()}
   *   <li>{@link Rpc#getRequest()}
   *   <li>{@link Rpc#getResponse()}
   *   <li>{@link Rpc#getStatus()}
   *   <li>{@link Rpc#getTenantId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Rpc actualRpc = new Rpc();
    actualRpc.setAdditionalInfo(MissingNode.getInstance());
    actualRpc.setExpirationTime(1L);
    actualRpc.setRequest(MissingNode.getInstance());
    MissingNode response = MissingNode.getInstance();
    actualRpc.setResponse(response);
    actualRpc.setStatus(RpcStatus.QUEUED);
    actualRpc.setTenantId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualRpc.toString();
    JsonNode actualAdditionalInfo = actualRpc.getAdditionalInfo();
    actualRpc.getDeviceId();
    long actualExpirationTime = actualRpc.getExpirationTime();
    JsonNode actualRequest = actualRpc.getRequest();
    JsonNode actualResponse = actualRpc.getResponse();
    RpcStatus actualStatus = actualRpc.getStatus();
    TenantId actualTenantId = actualRpc.getTenantId();

    // Assert that nothing has changed
    assertEquals(
        "Rpc(tenantId=13814000-1dd2-11b2-8080-808080808080, deviceId=null, expirationTime=1, request=, response=,"
            + " status=QUEUED, additionalInfo=)",
        actualToStringResult);
    assertEquals(0L, actualRpc.getCreatedTime());
    assertEquals(1L, actualExpirationTime);
    assertEquals(RpcStatus.QUEUED, actualStatus);
    assertSame(response, actualAdditionalInfo);
    assertSame(response, actualRequest);
    assertSame(response, actualResponse);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Rpc#Rpc(RpcId)}
   *   <li>{@link Rpc#setAdditionalInfo(JsonNode)}
   *   <li>{@link Rpc#setExpirationTime(long)}
   *   <li>{@link Rpc#setRequest(JsonNode)}
   *   <li>{@link Rpc#setResponse(JsonNode)}
   *   <li>{@link Rpc#setStatus(RpcStatus)}
   *   <li>{@link Rpc#setTenantId(TenantId)}
   *   <li>{@link Rpc#toString()}
   *   <li>{@link Rpc#getAdditionalInfo()}
   *   <li>{@link Rpc#getDeviceId()}
   *   <li>{@link Rpc#getExpirationTime()}
   *   <li>{@link Rpc#getRequest()}
   *   <li>{@link Rpc#getResponse()}
   *   <li>{@link Rpc#getStatus()}
   *   <li>{@link Rpc#getTenantId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    RpcId id = new RpcId(EntityId.NULL_UUID);

    // Act
    Rpc actualRpc = new Rpc(id);
    actualRpc.setAdditionalInfo(MissingNode.getInstance());
    actualRpc.setExpirationTime(1L);
    actualRpc.setRequest(MissingNode.getInstance());
    MissingNode response = MissingNode.getInstance();
    actualRpc.setResponse(response);
    actualRpc.setStatus(RpcStatus.QUEUED);
    actualRpc.setTenantId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualRpc.toString();
    JsonNode actualAdditionalInfo = actualRpc.getAdditionalInfo();
    actualRpc.getDeviceId();
    long actualExpirationTime = actualRpc.getExpirationTime();
    JsonNode actualRequest = actualRpc.getRequest();
    JsonNode actualResponse = actualRpc.getResponse();
    RpcStatus actualStatus = actualRpc.getStatus();
    TenantId actualTenantId = actualRpc.getTenantId();

    // Assert that nothing has changed
    assertEquals(
        "Rpc(tenantId=13814000-1dd2-11b2-8080-808080808080, deviceId=null, expirationTime=1, request=, response=,"
            + " status=QUEUED, additionalInfo=)",
        actualToStringResult);
    assertEquals(0L, actualRpc.getCreatedTime());
    assertEquals(1L, actualExpirationTime);
    assertEquals(RpcStatus.QUEUED, actualStatus);
    assertSame(id, actualRpc.getId());
    assertSame(response, actualAdditionalInfo);
    assertSame(response, actualRequest);
    assertSame(response, actualResponse);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Method under test: {@link Rpc#Rpc(Rpc)}
   */
  @Test
  void testNewRpc() {
    // Arrange
    Rpc rpc = new Rpc();

    // Act and Assert
    assertEquals(rpc, new Rpc(rpc));
  }
}
