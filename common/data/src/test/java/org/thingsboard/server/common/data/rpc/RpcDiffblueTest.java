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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RpcId;
import org.thingsboard.server.common.data.id.TenantId;

class RpcDiffblueTest {
  /**
   * Test {@link Rpc#equals(Object)}, and {@link Rpc#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Rpc#equals(Object)}
   *   <li>{@link Rpc#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rpc.equals(Object)", "int Rpc.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Rpc rpc = new Rpc();
    Rpc rpc2 = new Rpc();

    // Act and Assert
    assertEquals(rpc, rpc2);
    assertEquals(rpc.hashCode(), rpc2.hashCode());
  }

  /**
   * Test {@link Rpc#equals(Object)}, and {@link Rpc#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Rpc#equals(Object)}
   *   <li>{@link Rpc#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rpc.equals(Object)", "int Rpc.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setTenantId(TenantId.SYS_TENANT_ID);

    Rpc rpc2 = new Rpc();
    rpc2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(rpc, rpc2);
    assertEquals(rpc.hashCode(), rpc2.hashCode());
  }

  /**
   * Test {@link Rpc#equals(Object)}, and {@link Rpc#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Rpc#equals(Object)}
   *   <li>{@link Rpc#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rpc.equals(Object)", "int Rpc.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setRequest(DoubleNode.valueOf(10.0d));

    Rpc rpc2 = new Rpc();
    rpc2.setRequest(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertEquals(rpc, rpc2);
    assertEquals(rpc.hashCode(), rpc2.hashCode());
  }

  /**
   * Test {@link Rpc#equals(Object)}, and {@link Rpc#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Rpc#equals(Object)}
   *   <li>{@link Rpc#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rpc.equals(Object)", "int Rpc.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setResponse(DoubleNode.valueOf(10.0d));

    Rpc rpc2 = new Rpc();
    rpc2.setResponse(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertEquals(rpc, rpc2);
    assertEquals(rpc.hashCode(), rpc2.hashCode());
  }

  /**
   * Test {@link Rpc#equals(Object)}, and {@link Rpc#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Rpc#equals(Object)}
   *   <li>{@link Rpc#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rpc.equals(Object)", "int Rpc.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setStatus(RpcStatus.QUEUED);

    Rpc rpc2 = new Rpc();
    rpc2.setStatus(RpcStatus.QUEUED);

    // Act and Assert
    assertEquals(rpc, rpc2);
    assertEquals(rpc.hashCode(), rpc2.hashCode());
  }

  /**
   * Test {@link Rpc#equals(Object)}, and {@link Rpc#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Rpc#equals(Object)}
   *   <li>{@link Rpc#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rpc.equals(Object)", "int Rpc.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setAdditionalInfo(DoubleNode.valueOf(10.0d));

    Rpc rpc2 = new Rpc();
    rpc2.setAdditionalInfo(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertEquals(rpc, rpc2);
    assertEquals(rpc.hashCode(), rpc2.hashCode());
  }

  /**
   * Test {@link Rpc#equals(Object)}, and {@link Rpc#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Rpc#equals(Object)}
   *   <li>{@link Rpc#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rpc.equals(Object)", "int Rpc.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Rpc rpc = new Rpc();

    // Act and Assert
    assertEquals(rpc, rpc);
    int expectedHashCodeResult = rpc.hashCode();
    assertEquals(expectedHashCodeResult, rpc.hashCode());
  }

  /**
   * Test {@link Rpc#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rpc.equals(Object)", "int Rpc.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Rpc rpc = new Rpc(new RpcId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(rpc, new Rpc());
  }

  /**
   * Test {@link Rpc#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rpc.equals(Object)", "int Rpc.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(rpc, new Rpc());
  }

  /**
   * Test {@link Rpc#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rpc.equals(Object)", "int Rpc.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setExpirationTime(1L);

    // Act and Assert
    assertNotEquals(rpc, new Rpc());
  }

  /**
   * Test {@link Rpc#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rpc.equals(Object)", "int Rpc.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setRequest(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertNotEquals(rpc, new Rpc());
  }

  /**
   * Test {@link Rpc#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rpc.equals(Object)", "int Rpc.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setResponse(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertNotEquals(rpc, new Rpc());
  }

  /**
   * Test {@link Rpc#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rpc.equals(Object)", "int Rpc.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setStatus(RpcStatus.QUEUED);

    // Act and Assert
    assertNotEquals(rpc, new Rpc());
  }

  /**
   * Test {@link Rpc#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rpc.equals(Object)", "int Rpc.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Rpc rpc = new Rpc();
    rpc.setAdditionalInfo(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertNotEquals(rpc, new Rpc());
  }

  /**
   * Test {@link Rpc#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rpc.equals(Object)", "int Rpc.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Rpc rpc = new Rpc();

    Rpc rpc2 = new Rpc();
    rpc2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(rpc, rpc2);
  }

  /**
   * Test {@link Rpc#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rpc.equals(Object)", "int Rpc.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Rpc rpc = new Rpc();

    Rpc rpc2 = new Rpc();
    rpc2.setRequest(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertNotEquals(rpc, rpc2);
  }

  /**
   * Test {@link Rpc#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rpc.equals(Object)", "int Rpc.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Rpc rpc = new Rpc();

    Rpc rpc2 = new Rpc();
    rpc2.setResponse(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertNotEquals(rpc, rpc2);
  }

  /**
   * Test {@link Rpc#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rpc.equals(Object)", "int Rpc.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Rpc rpc = new Rpc();

    Rpc rpc2 = new Rpc();
    rpc2.setStatus(RpcStatus.QUEUED);

    // Act and Assert
    assertNotEquals(rpc, rpc2);
  }

  /**
   * Test {@link Rpc#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rpc.equals(Object)", "int Rpc.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Rpc rpc = new Rpc();

    Rpc rpc2 = new Rpc();
    rpc2.setAdditionalInfo(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertNotEquals(rpc, rpc2);
  }

  /**
   * Test {@link Rpc#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rpc.equals(Object)", "int Rpc.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Rpc(), null);
  }

  /**
   * Test {@link Rpc#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Rpc#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Rpc.equals(Object)", "int Rpc.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Rpc(), "Different type to Rpc");
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters; then return Id is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Rpc.<init>()",
    "void Rpc.<init>(RpcId)",
    "JsonNode Rpc.getAdditionalInfo()",
    "DeviceId Rpc.getDeviceId()",
    "long Rpc.getExpirationTime()",
    "JsonNode Rpc.getRequest()",
    "JsonNode Rpc.getResponse()",
    "RpcStatus Rpc.getStatus()",
    "TenantId Rpc.getTenantId()",
    "void Rpc.setAdditionalInfo(JsonNode)",
    "void Rpc.setDeviceId(DeviceId)",
    "void Rpc.setExpirationTime(long)",
    "void Rpc.setRequest(JsonNode)",
    "void Rpc.setResponse(JsonNode)",
    "void Rpc.setStatus(RpcStatus)",
    "void Rpc.setTenantId(TenantId)",
    "String Rpc.toString()"
  })
  void testGettersAndSetters_thenReturnIdIsNull() {
    // Arrange and Act
    Rpc actualRpc = new Rpc();
    DoubleNode additionalInfo = DoubleNode.valueOf(10.0d);
    actualRpc.setAdditionalInfo(additionalInfo);
    actualRpc.setExpirationTime(1L);
    DoubleNode request = DoubleNode.valueOf(10.0d);
    actualRpc.setRequest(request);
    DoubleNode response = DoubleNode.valueOf(10.0d);
    actualRpc.setResponse(response);
    actualRpc.setStatus(RpcStatus.QUEUED);
    actualRpc.setTenantId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualRpc.toString();
    JsonNode actualAdditionalInfo = actualRpc.getAdditionalInfo();
    DeviceId actualDeviceId = actualRpc.getDeviceId();
    long actualExpirationTime = actualRpc.getExpirationTime();
    JsonNode actualRequest = actualRpc.getRequest();
    JsonNode actualResponse = actualRpc.getResponse();
    RpcStatus actualStatus = actualRpc.getStatus();
    TenantId actualTenantId = actualRpc.getTenantId();

    // Assert
    assertEquals(
        "Rpc(tenantId=13814000-1dd2-11b2-8080-808080808080, deviceId=null, expirationTime=1, request=10.0,"
            + " response=10.0, status=QUEUED, additionalInfo=10.0)",
        actualToStringResult);
    assertNull(actualDeviceId);
    assertNull(actualRpc.getId());
    assertEquals(1L, actualExpirationTime);
    assertEquals(RpcStatus.QUEUED, actualStatus);
    assertSame(additionalInfo, actualAdditionalInfo);
    assertSame(request, actualRequest);
    assertSame(response, actualResponse);
    assertSame(TenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Id is {@link RpcId#RpcId(UUID)} with id is {@link EntityId#NULL_UUID}.
   * </ul>
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters; then return Id is RpcId(UUID) with id is NULL_UUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Rpc.<init>()",
    "void Rpc.<init>(RpcId)",
    "JsonNode Rpc.getAdditionalInfo()",
    "DeviceId Rpc.getDeviceId()",
    "long Rpc.getExpirationTime()",
    "JsonNode Rpc.getRequest()",
    "JsonNode Rpc.getResponse()",
    "RpcStatus Rpc.getStatus()",
    "TenantId Rpc.getTenantId()",
    "void Rpc.setAdditionalInfo(JsonNode)",
    "void Rpc.setDeviceId(DeviceId)",
    "void Rpc.setExpirationTime(long)",
    "void Rpc.setRequest(JsonNode)",
    "void Rpc.setResponse(JsonNode)",
    "void Rpc.setStatus(RpcStatus)",
    "void Rpc.setTenantId(TenantId)",
    "String Rpc.toString()"
  })
  void testGettersAndSetters_thenReturnIdIsRpcIdWithIdIsNull_uuid() {
    // Arrange
    RpcId id = new RpcId(EntityId.NULL_UUID);

    // Act
    Rpc actualRpc = new Rpc(id);
    DoubleNode additionalInfo = DoubleNode.valueOf(10.0d);
    actualRpc.setAdditionalInfo(additionalInfo);
    actualRpc.setExpirationTime(1L);
    DoubleNode request = DoubleNode.valueOf(10.0d);
    actualRpc.setRequest(request);
    DoubleNode response = DoubleNode.valueOf(10.0d);
    actualRpc.setResponse(response);
    actualRpc.setStatus(RpcStatus.QUEUED);
    actualRpc.setTenantId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualRpc.toString();
    JsonNode actualAdditionalInfo = actualRpc.getAdditionalInfo();
    DeviceId actualDeviceId = actualRpc.getDeviceId();
    long actualExpirationTime = actualRpc.getExpirationTime();
    JsonNode actualRequest = actualRpc.getRequest();
    JsonNode actualResponse = actualRpc.getResponse();
    RpcStatus actualStatus = actualRpc.getStatus();
    TenantId actualTenantId = actualRpc.getTenantId();

    // Assert
    assertEquals(
        "Rpc(tenantId=13814000-1dd2-11b2-8080-808080808080, deviceId=null, expirationTime=1, request=10.0,"
            + " response=10.0, status=QUEUED, additionalInfo=10.0)",
        actualToStringResult);
    assertNull(actualDeviceId);
    assertEquals(1L, actualExpirationTime);
    assertEquals(RpcStatus.QUEUED, actualStatus);
    assertSame(id, actualRpc.getId());
    assertSame(additionalInfo, actualAdditionalInfo);
    assertSame(request, actualRequest);
    assertSame(response, actualResponse);
    assertSame(TenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test {@link Rpc#Rpc(Rpc)}.
   *
   * <p>Method under test: {@link Rpc#Rpc(Rpc)}
   */
  @Test
  @DisplayName("Test new Rpc(Rpc)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Rpc.<init>(Rpc)"})
  void testNewRpc() {
    // Arrange
    Rpc rpc = new Rpc();

    // Act
    Rpc actualRpc = new Rpc(rpc);

    // Assert
    assertEquals(rpc, actualRpc);
  }

  /**
   * Test {@link Rpc#getId()}.
   *
   * <p>Method under test: {@link Rpc#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RpcId Rpc.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull(new Rpc().getId());
  }

  /**
   * Test {@link Rpc#getCreatedTime()}.
   *
   * <p>Method under test: {@link Rpc#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Rpc.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new Rpc().getCreatedTime());
  }
}
