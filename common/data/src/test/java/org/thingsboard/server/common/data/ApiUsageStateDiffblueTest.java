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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class ApiUsageStateDiffblueTest {
  /**
   * Test {@link ApiUsageState#ApiUsageState(ApiUsageState)}.
   *
   * <p>Method under test: {@link ApiUsageState#ApiUsageState(ApiUsageState)}
   */
  @Test
  @DisplayName("Test new ApiUsageState(ApiUsageState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageState.<init>(ApiUsageState)"})
  void testNewApiUsageState() {
    // Arrange
    ApiUsageState ur = new ApiUsageState();

    // Act
    ApiUsageState actualApiUsageState = new ApiUsageState(ur);

    // Assert
    assertEquals(ur, actualApiUsageState);
  }

  /**
   * Test {@link ApiUsageState#isTransportEnabled()}.
   *
   * <ul>
   *   <li>Given {@link ApiUsageState#ApiUsageState()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#isTransportEnabled()}
   */
  @Test
  @DisplayName("Test isTransportEnabled(); given ApiUsageState(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.isTransportEnabled()"})
  void testIsTransportEnabled_givenApiUsageState_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new ApiUsageState().isTransportEnabled());
  }

  /**
   * Test {@link ApiUsageState#isTransportEnabled()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#isTransportEnabled()}
   */
  @Test
  @DisplayName("Test isTransportEnabled(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.isTransportEnabled()"})
  void testIsTransportEnabled_thenReturnFalse() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setTransportState(ApiUsageStateValue.DISABLED);

    // Act and Assert
    assertFalse(apiUsageState.isTransportEnabled());
  }

  /**
   * Test {@link ApiUsageState#isReExecEnabled()}.
   *
   * <ul>
   *   <li>Given {@link ApiUsageState#ApiUsageState()} ReExecState is {@code DISABLED}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#isReExecEnabled()}
   */
  @Test
  @DisplayName(
      "Test isReExecEnabled(); given ApiUsageState() ReExecState is 'DISABLED'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.isReExecEnabled()"})
  void testIsReExecEnabled_givenApiUsageStateReExecStateIsDisabled_thenReturnFalse() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setReExecState(ApiUsageStateValue.DISABLED);

    // Act and Assert
    assertFalse(apiUsageState.isReExecEnabled());
  }

  /**
   * Test {@link ApiUsageState#isReExecEnabled()}.
   *
   * <ul>
   *   <li>Given {@link ApiUsageState#ApiUsageState()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#isReExecEnabled()}
   */
  @Test
  @DisplayName("Test isReExecEnabled(); given ApiUsageState(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.isReExecEnabled()"})
  void testIsReExecEnabled_givenApiUsageState_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new ApiUsageState().isReExecEnabled());
  }

  /**
   * Test {@link ApiUsageState#isDbStorageEnabled()}.
   *
   * <ul>
   *   <li>Given {@link ApiUsageState#ApiUsageState()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#isDbStorageEnabled()}
   */
  @Test
  @DisplayName("Test isDbStorageEnabled(); given ApiUsageState(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.isDbStorageEnabled()"})
  void testIsDbStorageEnabled_givenApiUsageState_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new ApiUsageState().isDbStorageEnabled());
  }

  /**
   * Test {@link ApiUsageState#isDbStorageEnabled()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#isDbStorageEnabled()}
   */
  @Test
  @DisplayName("Test isDbStorageEnabled(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.isDbStorageEnabled()"})
  void testIsDbStorageEnabled_thenReturnFalse() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setDbStorageState(ApiUsageStateValue.DISABLED);

    // Act and Assert
    assertFalse(apiUsageState.isDbStorageEnabled());
  }

  /**
   * Test {@link ApiUsageState#isJsExecEnabled()}.
   *
   * <ul>
   *   <li>Given {@link ApiUsageState#ApiUsageState()} JsExecState is {@code DISABLED}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#isJsExecEnabled()}
   */
  @Test
  @DisplayName(
      "Test isJsExecEnabled(); given ApiUsageState() JsExecState is 'DISABLED'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.isJsExecEnabled()"})
  void testIsJsExecEnabled_givenApiUsageStateJsExecStateIsDisabled_thenReturnFalse() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setJsExecState(ApiUsageStateValue.DISABLED);

    // Act and Assert
    assertFalse(apiUsageState.isJsExecEnabled());
  }

  /**
   * Test {@link ApiUsageState#isJsExecEnabled()}.
   *
   * <ul>
   *   <li>Given {@link ApiUsageState#ApiUsageState()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#isJsExecEnabled()}
   */
  @Test
  @DisplayName("Test isJsExecEnabled(); given ApiUsageState(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.isJsExecEnabled()"})
  void testIsJsExecEnabled_givenApiUsageState_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new ApiUsageState().isJsExecEnabled());
  }

  /**
   * Test {@link ApiUsageState#isTbelExecEnabled()}.
   *
   * <ul>
   *   <li>Given {@link ApiUsageState#ApiUsageState()} TbelExecState is {@code DISABLED}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#isTbelExecEnabled()}
   */
  @Test
  @DisplayName(
      "Test isTbelExecEnabled(); given ApiUsageState() TbelExecState is 'DISABLED'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.isTbelExecEnabled()"})
  void testIsTbelExecEnabled_givenApiUsageStateTbelExecStateIsDisabled_thenReturnFalse() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setTbelExecState(ApiUsageStateValue.DISABLED);

    // Act and Assert
    assertFalse(apiUsageState.isTbelExecEnabled());
  }

  /**
   * Test {@link ApiUsageState#isTbelExecEnabled()}.
   *
   * <ul>
   *   <li>Given {@link ApiUsageState#ApiUsageState()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#isTbelExecEnabled()}
   */
  @Test
  @DisplayName("Test isTbelExecEnabled(); given ApiUsageState(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.isTbelExecEnabled()"})
  void testIsTbelExecEnabled_givenApiUsageState_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new ApiUsageState().isTbelExecEnabled());
  }

  /**
   * Test {@link ApiUsageState#isEmailSendEnabled()}.
   *
   * <ul>
   *   <li>Given {@link ApiUsageState#ApiUsageState()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#isEmailSendEnabled()}
   */
  @Test
  @DisplayName("Test isEmailSendEnabled(); given ApiUsageState(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.isEmailSendEnabled()"})
  void testIsEmailSendEnabled_givenApiUsageState_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new ApiUsageState().isEmailSendEnabled());
  }

  /**
   * Test {@link ApiUsageState#isEmailSendEnabled()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#isEmailSendEnabled()}
   */
  @Test
  @DisplayName("Test isEmailSendEnabled(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.isEmailSendEnabled()"})
  void testIsEmailSendEnabled_thenReturnFalse() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setEmailExecState(ApiUsageStateValue.DISABLED);

    // Act and Assert
    assertFalse(apiUsageState.isEmailSendEnabled());
  }

  /**
   * Test {@link ApiUsageState#isSmsSendEnabled()}.
   *
   * <ul>
   *   <li>Given {@link ApiUsageState#ApiUsageState()} SmsExecState is {@code DISABLED}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#isSmsSendEnabled()}
   */
  @Test
  @DisplayName(
      "Test isSmsSendEnabled(); given ApiUsageState() SmsExecState is 'DISABLED'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.isSmsSendEnabled()"})
  void testIsSmsSendEnabled_givenApiUsageStateSmsExecStateIsDisabled_thenReturnFalse() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setSmsExecState(ApiUsageStateValue.DISABLED);

    // Act and Assert
    assertFalse(apiUsageState.isSmsSendEnabled());
  }

  /**
   * Test {@link ApiUsageState#isSmsSendEnabled()}.
   *
   * <ul>
   *   <li>Given {@link ApiUsageState#ApiUsageState()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#isSmsSendEnabled()}
   */
  @Test
  @DisplayName("Test isSmsSendEnabled(); given ApiUsageState(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.isSmsSendEnabled()"})
  void testIsSmsSendEnabled_givenApiUsageState_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new ApiUsageState().isSmsSendEnabled());
  }

  /**
   * Test {@link ApiUsageState#isAlarmCreationEnabled()}.
   *
   * <ul>
   *   <li>Given {@link ApiUsageState#ApiUsageState()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#isAlarmCreationEnabled()}
   */
  @Test
  @DisplayName("Test isAlarmCreationEnabled(); given ApiUsageState(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.isAlarmCreationEnabled()"})
  void testIsAlarmCreationEnabled_givenApiUsageState_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new ApiUsageState().isAlarmCreationEnabled());
  }

  /**
   * Test {@link ApiUsageState#isAlarmCreationEnabled()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#isAlarmCreationEnabled()}
   */
  @Test
  @DisplayName("Test isAlarmCreationEnabled(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.isAlarmCreationEnabled()"})
  void testIsAlarmCreationEnabled_thenReturnFalse() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setAlarmExecState(ApiUsageStateValue.DISABLED);

    // Act and Assert
    assertFalse(apiUsageState.isAlarmCreationEnabled());
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}, and {@link ApiUsageState#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageState#equals(Object)}
   *   <li>{@link ApiUsageState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    ApiUsageState apiUsageState2 = new ApiUsageState();

    // Act and Assert
    assertEquals(apiUsageState, apiUsageState2);
    assertEquals(apiUsageState.hashCode(), apiUsageState2.hashCode());
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}, and {@link ApiUsageState#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageState#equals(Object)}
   *   <li>{@link ApiUsageState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();

    // Act and Assert
    assertEquals(apiUsageState, apiUsageState);
    int expectedHashCodeResult = apiUsageState.hashCode();
    assertEquals(expectedHashCodeResult, apiUsageState.hashCode());
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ApiUsageState(), 1);
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(apiUsageState, new ApiUsageState());
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setEntityId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(apiUsageState, new ApiUsageState());
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setTransportState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, new ApiUsageState());
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setDbStorageState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, new ApiUsageState());
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setReExecState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, new ApiUsageState());
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setJsExecState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, new ApiUsageState());
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setTbelExecState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, new ApiUsageState());
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setEmailExecState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, new ApiUsageState());
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setSmsExecState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, new ApiUsageState());
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setAlarmExecState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, new ApiUsageState());
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(apiUsageState, new ApiUsageState());
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();

    ApiUsageState apiUsageState2 = new ApiUsageState();
    apiUsageState2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(apiUsageState, apiUsageState2);
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();

    ApiUsageState apiUsageState2 = new ApiUsageState();
    apiUsageState2.setEntityId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(apiUsageState, apiUsageState2);
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();

    ApiUsageState apiUsageState2 = new ApiUsageState();
    apiUsageState2.setTransportState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, apiUsageState2);
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();

    ApiUsageState apiUsageState2 = new ApiUsageState();
    apiUsageState2.setDbStorageState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, apiUsageState2);
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();

    ApiUsageState apiUsageState2 = new ApiUsageState();
    apiUsageState2.setReExecState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, apiUsageState2);
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();

    ApiUsageState apiUsageState2 = new ApiUsageState();
    apiUsageState2.setJsExecState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, apiUsageState2);
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();

    ApiUsageState apiUsageState2 = new ApiUsageState();
    apiUsageState2.setTbelExecState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, apiUsageState2);
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();

    ApiUsageState apiUsageState2 = new ApiUsageState();
    apiUsageState2.setEmailExecState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, apiUsageState2);
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();

    ApiUsageState apiUsageState2 = new ApiUsageState();
    apiUsageState2.setSmsExecState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, apiUsageState2);
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();

    ApiUsageState apiUsageState2 = new ApiUsageState();
    apiUsageState2.setAlarmExecState(ApiUsageStateValue.ENABLED);

    // Act and Assert
    assertNotEquals(apiUsageState, apiUsageState2);
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ApiUsageState(), null);
  }

  /**
   * Test {@link ApiUsageState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ApiUsageState.equals(Object)", "int ApiUsageState.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ApiUsageState(), "Different type to ApiUsageState");
  }
}
