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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class ApiUsageStateDiffblueTest {
  /**
   * Method under test: {@link ApiUsageState#isTransportEnabled()}
   */
  @Test
  void testIsTransportEnabled() {
    // Arrange, Act and Assert
    assertTrue((new ApiUsageState()).isTransportEnabled());
  }

  /**
   * Method under test: {@link ApiUsageState#isTransportEnabled()}
   */
  @Test
  void testIsTransportEnabled2() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setTransportState(ApiUsageStateValue.DISABLED);

    // Act and Assert
    assertFalse(apiUsageState.isTransportEnabled());
  }

  /**
   * Method under test: {@link ApiUsageState#isReExecEnabled()}
   */
  @Test
  void testIsReExecEnabled() {
    // Arrange, Act and Assert
    assertTrue((new ApiUsageState()).isReExecEnabled());
  }

  /**
   * Method under test: {@link ApiUsageState#isReExecEnabled()}
   */
  @Test
  void testIsReExecEnabled2() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setReExecState(ApiUsageStateValue.DISABLED);

    // Act and Assert
    assertFalse(apiUsageState.isReExecEnabled());
  }

  /**
   * Method under test: {@link ApiUsageState#isDbStorageEnabled()}
   */
  @Test
  void testIsDbStorageEnabled() {
    // Arrange, Act and Assert
    assertTrue((new ApiUsageState()).isDbStorageEnabled());
  }

  /**
   * Method under test: {@link ApiUsageState#isDbStorageEnabled()}
   */
  @Test
  void testIsDbStorageEnabled2() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setDbStorageState(ApiUsageStateValue.DISABLED);

    // Act and Assert
    assertFalse(apiUsageState.isDbStorageEnabled());
  }

  /**
   * Method under test: {@link ApiUsageState#isJsExecEnabled()}
   */
  @Test
  void testIsJsExecEnabled() {
    // Arrange, Act and Assert
    assertTrue((new ApiUsageState()).isJsExecEnabled());
  }

  /**
   * Method under test: {@link ApiUsageState#isJsExecEnabled()}
   */
  @Test
  void testIsJsExecEnabled2() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setJsExecState(ApiUsageStateValue.DISABLED);

    // Act and Assert
    assertFalse(apiUsageState.isJsExecEnabled());
  }

  /**
   * Method under test: {@link ApiUsageState#isTbelExecEnabled()}
   */
  @Test
  void testIsTbelExecEnabled() {
    // Arrange, Act and Assert
    assertTrue((new ApiUsageState()).isTbelExecEnabled());
  }

  /**
   * Method under test: {@link ApiUsageState#isTbelExecEnabled()}
   */
  @Test
  void testIsTbelExecEnabled2() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setTbelExecState(ApiUsageStateValue.DISABLED);

    // Act and Assert
    assertFalse(apiUsageState.isTbelExecEnabled());
  }

  /**
   * Method under test: {@link ApiUsageState#isEmailSendEnabled()}
   */
  @Test
  void testIsEmailSendEnabled() {
    // Arrange, Act and Assert
    assertTrue((new ApiUsageState()).isEmailSendEnabled());
  }

  /**
   * Method under test: {@link ApiUsageState#isEmailSendEnabled()}
   */
  @Test
  void testIsEmailSendEnabled2() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setEmailExecState(ApiUsageStateValue.DISABLED);

    // Act and Assert
    assertFalse(apiUsageState.isEmailSendEnabled());
  }

  /**
   * Method under test: {@link ApiUsageState#isSmsSendEnabled()}
   */
  @Test
  void testIsSmsSendEnabled() {
    // Arrange, Act and Assert
    assertTrue((new ApiUsageState()).isSmsSendEnabled());
  }

  /**
   * Method under test: {@link ApiUsageState#isSmsSendEnabled()}
   */
  @Test
  void testIsSmsSendEnabled2() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setSmsExecState(ApiUsageStateValue.DISABLED);

    // Act and Assert
    assertFalse(apiUsageState.isSmsSendEnabled());
  }

  /**
   * Method under test: {@link ApiUsageState#isAlarmCreationEnabled()}
   */
  @Test
  void testIsAlarmCreationEnabled() {
    // Arrange, Act and Assert
    assertTrue((new ApiUsageState()).isAlarmCreationEnabled());
  }

  /**
   * Method under test: {@link ApiUsageState#isAlarmCreationEnabled()}
   */
  @Test
  void testIsAlarmCreationEnabled2() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setAlarmExecState(ApiUsageStateValue.DISABLED);

    // Act and Assert
    assertFalse(apiUsageState.isAlarmCreationEnabled());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageState#equals(Object)}
   *   <li>{@link ApiUsageState#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    ApiUsageState apiUsageState2 = new ApiUsageState();

    // Act and Assert
    assertEquals(apiUsageState, apiUsageState2);
    int expectedHashCodeResult = apiUsageState.hashCode();
    assertEquals(expectedHashCodeResult, apiUsageState2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageState#equals(Object)}
   *   <li>{@link ApiUsageState#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();

    // Act and Assert
    assertEquals(apiUsageState, apiUsageState);
    int expectedHashCodeResult = apiUsageState.hashCode();
    assertEquals(expectedHashCodeResult, apiUsageState.hashCode());
  }

  /**
   * Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ApiUsageState(), 1);
    assertNotEquals(new ApiUsageState(), mock(AdminSettings.class));
  }

  /**
   * Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(apiUsageState, new ApiUsageState());
  }

  /**
   * Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setEntityId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(apiUsageState, new ApiUsageState());
  }

  /**
   * Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setTransportState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, new ApiUsageState());
  }

  /**
   * Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setDbStorageState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, new ApiUsageState());
  }

  /**
   * Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setReExecState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, new ApiUsageState());
  }

  /**
   * Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setJsExecState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, new ApiUsageState());
  }

  /**
   * Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setTbelExecState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, new ApiUsageState());
  }

  /**
   * Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setEmailExecState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, new ApiUsageState());
  }

  /**
   * Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setSmsExecState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, new ApiUsageState());
  }

  /**
   * Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setAlarmExecState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, new ApiUsageState());
  }

  /**
   * Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(apiUsageState, new ApiUsageState());
  }

  /**
   * Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();

    ApiUsageState apiUsageState2 = new ApiUsageState();
    apiUsageState2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(apiUsageState, apiUsageState2);
  }

  /**
   * Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();

    ApiUsageState apiUsageState2 = new ApiUsageState();
    apiUsageState2.setEntityId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(apiUsageState, apiUsageState2);
  }

  /**
   * Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();

    ApiUsageState apiUsageState2 = new ApiUsageState();
    apiUsageState2.setTransportState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, apiUsageState2);
  }

  /**
   * Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();

    ApiUsageState apiUsageState2 = new ApiUsageState();
    apiUsageState2.setDbStorageState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, apiUsageState2);
  }

  /**
   * Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();

    ApiUsageState apiUsageState2 = new ApiUsageState();
    apiUsageState2.setReExecState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, apiUsageState2);
  }

  /**
   * Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();

    ApiUsageState apiUsageState2 = new ApiUsageState();
    apiUsageState2.setJsExecState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, apiUsageState2);
  }

  /**
   * Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();

    ApiUsageState apiUsageState2 = new ApiUsageState();
    apiUsageState2.setTbelExecState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, apiUsageState2);
  }

  /**
   * Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();

    ApiUsageState apiUsageState2 = new ApiUsageState();
    apiUsageState2.setEmailExecState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, apiUsageState2);
  }

  /**
   * Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();

    ApiUsageState apiUsageState2 = new ApiUsageState();
    apiUsageState2.setSmsExecState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, apiUsageState2);
  }

  /**
   * Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();

    ApiUsageState apiUsageState2 = new ApiUsageState();
    apiUsageState2.setAlarmExecState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, apiUsageState2);
  }

  /**
   * Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ApiUsageState(), null);
  }

  /**
   * Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ApiUsageState(), "Different type to ApiUsageState");
  }

  /**
   * Method under test: {@link ApiUsageState#ApiUsageState(ApiUsageState)}
   */
  @Test
  void testNewApiUsageState() {
    // Arrange
    ApiUsageState ur = new ApiUsageState();

    // Act and Assert
    assertEquals(ur, new ApiUsageState(ur));
  }
}
