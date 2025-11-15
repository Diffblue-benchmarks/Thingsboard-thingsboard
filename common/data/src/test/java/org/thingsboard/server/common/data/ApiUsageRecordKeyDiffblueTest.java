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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ApiUsageRecordKeyDiffblueTest {
  /**
   * Method under test: {@link ApiUsageRecordKey#getKeys(ApiFeature)}
   */
  @Test
  void testGetKeys() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new ApiUsageRecordKey[]{ApiUsageRecordKey.TRANSPORT_MSG_COUNT, ApiUsageRecordKey.TRANSPORT_DP_COUNT},
        ApiUsageRecordKey.getKeys(ApiFeature.TRANSPORT));
    assertArrayEquals(new ApiUsageRecordKey[]{ApiUsageRecordKey.STORAGE_DP_COUNT},
        ApiUsageRecordKey.getKeys(ApiFeature.DB));
    assertArrayEquals(new ApiUsageRecordKey[]{ApiUsageRecordKey.RE_EXEC_COUNT},
        ApiUsageRecordKey.getKeys(ApiFeature.RE));
    assertArrayEquals(new ApiUsageRecordKey[]{ApiUsageRecordKey.JS_EXEC_COUNT},
        ApiUsageRecordKey.getKeys(ApiFeature.JS));
    assertArrayEquals(new ApiUsageRecordKey[]{ApiUsageRecordKey.TBEL_EXEC_COUNT},
        ApiUsageRecordKey.getKeys(ApiFeature.TBEL));
    assertArrayEquals(new ApiUsageRecordKey[]{ApiUsageRecordKey.EMAIL_EXEC_COUNT},
        ApiUsageRecordKey.getKeys(ApiFeature.EMAIL));
    assertArrayEquals(new ApiUsageRecordKey[]{ApiUsageRecordKey.SMS_EXEC_COUNT},
        ApiUsageRecordKey.getKeys(ApiFeature.SMS));
    assertArrayEquals(new ApiUsageRecordKey[]{ApiUsageRecordKey.CREATED_ALARMS_COUNT},
        ApiUsageRecordKey.getKeys(ApiFeature.ALARM));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageRecordKey#getApiCountKey()}
   *   <li>{@link ApiUsageRecordKey#getApiFeature()}
   *   <li>{@link ApiUsageRecordKey#getApiLimitKey()}
   *   <li>{@link ApiUsageRecordKey#getUnitLabel()}
   *   <li>{@link ApiUsageRecordKey#isCounter()}
   * </ul>
   */
  @Test
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
