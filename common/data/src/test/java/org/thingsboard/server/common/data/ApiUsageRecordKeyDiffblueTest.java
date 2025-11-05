package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ApiUsageRecordKeyDiffblueTest {
  /**
   * Test {@link ApiUsageRecordKey#getKeys(ApiFeature)}.
   *
   * <p>Method under test: {@link ApiUsageRecordKey#getKeys(ApiFeature)}
   */
  @Test
  @DisplayName("Test getKeys(ApiFeature)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ApiUsageRecordKey[] ApiUsageRecordKey.getKeys(ApiFeature)"})
  void testGetKeys() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new ApiUsageRecordKey[] {
          ApiUsageRecordKey.TRANSPORT_MSG_COUNT, ApiUsageRecordKey.TRANSPORT_DP_COUNT
        },
        ApiUsageRecordKey.getKeys(ApiFeature.TRANSPORT));
  }

  /**
   * Test {@link ApiUsageRecordKey#getKeys(ApiFeature)}.
   *
   * <ul>
   *   <li>When {@code ALARM}.
   *   <li>Then return array of {@link ApiUsageRecordKey} with {@code CREATED_ALARMS_COUNT}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageRecordKey#getKeys(ApiFeature)}
   */
  @Test
  @DisplayName(
      "Test getKeys(ApiFeature); when 'ALARM'; then return array of ApiUsageRecordKey with 'CREATED_ALARMS_COUNT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ApiUsageRecordKey[] ApiUsageRecordKey.getKeys(ApiFeature)"})
  void testGetKeys_whenAlarm_thenReturnArrayOfApiUsageRecordKeyWithCreatedAlarmsCount() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new ApiUsageRecordKey[] {ApiUsageRecordKey.CREATED_ALARMS_COUNT},
        ApiUsageRecordKey.getKeys(ApiFeature.ALARM));
  }

  /**
   * Test {@link ApiUsageRecordKey#getKeys(ApiFeature)}.
   *
   * <ul>
   *   <li>When {@code DB}.
   *   <li>Then return array of {@link ApiUsageRecordKey} with {@code STORAGE_DP_COUNT}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageRecordKey#getKeys(ApiFeature)}
   */
  @Test
  @DisplayName(
      "Test getKeys(ApiFeature); when 'DB'; then return array of ApiUsageRecordKey with 'STORAGE_DP_COUNT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ApiUsageRecordKey[] ApiUsageRecordKey.getKeys(ApiFeature)"})
  void testGetKeys_whenDb_thenReturnArrayOfApiUsageRecordKeyWithStorageDpCount() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new ApiUsageRecordKey[] {ApiUsageRecordKey.STORAGE_DP_COUNT},
        ApiUsageRecordKey.getKeys(ApiFeature.DB));
  }

  /**
   * Test {@link ApiUsageRecordKey#getKeys(ApiFeature)}.
   *
   * <ul>
   *   <li>When {@code EMAIL}.
   *   <li>Then return array of {@link ApiUsageRecordKey} with {@code EMAIL_EXEC_COUNT}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageRecordKey#getKeys(ApiFeature)}
   */
  @Test
  @DisplayName(
      "Test getKeys(ApiFeature); when 'EMAIL'; then return array of ApiUsageRecordKey with 'EMAIL_EXEC_COUNT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ApiUsageRecordKey[] ApiUsageRecordKey.getKeys(ApiFeature)"})
  void testGetKeys_whenEmail_thenReturnArrayOfApiUsageRecordKeyWithEmailExecCount() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new ApiUsageRecordKey[] {ApiUsageRecordKey.EMAIL_EXEC_COUNT},
        ApiUsageRecordKey.getKeys(ApiFeature.EMAIL));
  }

  /**
   * Test {@link ApiUsageRecordKey#getKeys(ApiFeature)}.
   *
   * <ul>
   *   <li>When {@code JS}.
   *   <li>Then return array of {@link ApiUsageRecordKey} with {@code JS_EXEC_COUNT}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageRecordKey#getKeys(ApiFeature)}
   */
  @Test
  @DisplayName(
      "Test getKeys(ApiFeature); when 'JS'; then return array of ApiUsageRecordKey with 'JS_EXEC_COUNT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ApiUsageRecordKey[] ApiUsageRecordKey.getKeys(ApiFeature)"})
  void testGetKeys_whenJs_thenReturnArrayOfApiUsageRecordKeyWithJsExecCount() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new ApiUsageRecordKey[] {ApiUsageRecordKey.JS_EXEC_COUNT},
        ApiUsageRecordKey.getKeys(ApiFeature.JS));
  }

  /**
   * Test {@link ApiUsageRecordKey#getKeys(ApiFeature)}.
   *
   * <ul>
   *   <li>When {@code RE}.
   *   <li>Then return array of {@link ApiUsageRecordKey} with {@code RE_EXEC_COUNT}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageRecordKey#getKeys(ApiFeature)}
   */
  @Test
  @DisplayName(
      "Test getKeys(ApiFeature); when 'RE'; then return array of ApiUsageRecordKey with 'RE_EXEC_COUNT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ApiUsageRecordKey[] ApiUsageRecordKey.getKeys(ApiFeature)"})
  void testGetKeys_whenRe_thenReturnArrayOfApiUsageRecordKeyWithReExecCount() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new ApiUsageRecordKey[] {ApiUsageRecordKey.RE_EXEC_COUNT},
        ApiUsageRecordKey.getKeys(ApiFeature.RE));
  }

  /**
   * Test {@link ApiUsageRecordKey#getKeys(ApiFeature)}.
   *
   * <ul>
   *   <li>When {@code SMS}.
   *   <li>Then return array of {@link ApiUsageRecordKey} with {@code SMS_EXEC_COUNT}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageRecordKey#getKeys(ApiFeature)}
   */
  @Test
  @DisplayName(
      "Test getKeys(ApiFeature); when 'SMS'; then return array of ApiUsageRecordKey with 'SMS_EXEC_COUNT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ApiUsageRecordKey[] ApiUsageRecordKey.getKeys(ApiFeature)"})
  void testGetKeys_whenSms_thenReturnArrayOfApiUsageRecordKeyWithSmsExecCount() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new ApiUsageRecordKey[] {ApiUsageRecordKey.SMS_EXEC_COUNT},
        ApiUsageRecordKey.getKeys(ApiFeature.SMS));
  }

  /**
   * Test {@link ApiUsageRecordKey#getKeys(ApiFeature)}.
   *
   * <ul>
   *   <li>When {@code TBEL}.
   *   <li>Then return array of {@link ApiUsageRecordKey} with {@code TBEL_EXEC_COUNT}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageRecordKey#getKeys(ApiFeature)}
   */
  @Test
  @DisplayName(
      "Test getKeys(ApiFeature); when 'TBEL'; then return array of ApiUsageRecordKey with 'TBEL_EXEC_COUNT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ApiUsageRecordKey[] ApiUsageRecordKey.getKeys(ApiFeature)"})
  void testGetKeys_whenTbel_thenReturnArrayOfApiUsageRecordKeyWithTbelExecCount() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new ApiUsageRecordKey[] {ApiUsageRecordKey.TBEL_EXEC_COUNT},
        ApiUsageRecordKey.getKeys(ApiFeature.TBEL));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageRecordKey#getApiCountKey()}
   *   <li>{@link ApiUsageRecordKey#getApiFeature()}
   *   <li>{@link ApiUsageRecordKey#getApiLimitKey()}
   *   <li>{@link ApiUsageRecordKey#getUnitLabel()}
   *   <li>{@link ApiUsageRecordKey#isCounter()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ApiUsageRecordKey.getApiCountKey()",
    "ApiFeature ApiUsageRecordKey.getApiFeature()",
    "String ApiUsageRecordKey.getApiLimitKey()",
    "String ApiUsageRecordKey.getUnitLabel()",
    "boolean ApiUsageRecordKey.isCounter()"
  })
  void testGettersAndSetters() {
    // Arrange
    ApiUsageRecordKey valueOfResult = ApiUsageRecordKey.valueOf("TRANSPORT_MSG_COUNT");

    // Act
    String actualApiCountKey = valueOfResult.getApiCountKey();
    ApiFeature actualApiFeature = valueOfResult.getApiFeature();
    String actualApiLimitKey = valueOfResult.getApiLimitKey();
    String actualUnitLabel = valueOfResult.getUnitLabel();

    // Assert
    assertEquals("message", actualUnitLabel);
    assertEquals("transportMsgCount", actualApiCountKey);
    assertEquals("transportMsgLimit", actualApiLimitKey);
    assertEquals(ApiFeature.TRANSPORT, actualApiFeature);
    assertTrue(valueOfResult.isCounter());
  }
}
