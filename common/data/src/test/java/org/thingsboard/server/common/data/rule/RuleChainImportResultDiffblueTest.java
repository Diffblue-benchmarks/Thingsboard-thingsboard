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
package org.thingsboard.server.common.data.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;

class RuleChainImportResultDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainImportResult#equals(Object)}
   *   <li>{@link RuleChainImportResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleChainImportResult ruleChainImportResult = new RuleChainImportResult();
    ruleChainImportResult.setError("An error occurred");
    ruleChainImportResult.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult.setRuleChainName("Rule Chain Name");
    ruleChainImportResult.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult.setUpdated(true);

    RuleChainImportResult ruleChainImportResult2 = new RuleChainImportResult();
    ruleChainImportResult2.setError("An error occurred");
    ruleChainImportResult2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult2.setRuleChainName("Rule Chain Name");
    ruleChainImportResult2.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult2.setUpdated(true);

    // Act and Assert
    assertEquals(ruleChainImportResult, ruleChainImportResult2);
    int expectedHashCodeResult = ruleChainImportResult.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainImportResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainImportResult#equals(Object)}
   *   <li>{@link RuleChainImportResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RuleChainImportResult ruleChainImportResult = new RuleChainImportResult();
    ruleChainImportResult.setError(null);
    ruleChainImportResult.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult.setRuleChainName("Rule Chain Name");
    ruleChainImportResult.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult.setUpdated(true);

    RuleChainImportResult ruleChainImportResult2 = new RuleChainImportResult();
    ruleChainImportResult2.setError(null);
    ruleChainImportResult2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult2.setRuleChainName("Rule Chain Name");
    ruleChainImportResult2.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult2.setUpdated(true);

    // Act and Assert
    assertEquals(ruleChainImportResult, ruleChainImportResult2);
    int expectedHashCodeResult = ruleChainImportResult.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainImportResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainImportResult#equals(Object)}
   *   <li>{@link RuleChainImportResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RuleChainImportResult ruleChainImportResult = new RuleChainImportResult();
    ruleChainImportResult.setError("An error occurred");
    ruleChainImportResult.setRuleChainId(null);
    ruleChainImportResult.setRuleChainName("Rule Chain Name");
    ruleChainImportResult.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult.setUpdated(true);

    RuleChainImportResult ruleChainImportResult2 = new RuleChainImportResult();
    ruleChainImportResult2.setError("An error occurred");
    ruleChainImportResult2.setRuleChainId(null);
    ruleChainImportResult2.setRuleChainName("Rule Chain Name");
    ruleChainImportResult2.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult2.setUpdated(true);

    // Act and Assert
    assertEquals(ruleChainImportResult, ruleChainImportResult2);
    int expectedHashCodeResult = ruleChainImportResult.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainImportResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainImportResult#equals(Object)}
   *   <li>{@link RuleChainImportResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    RuleChainImportResult ruleChainImportResult = new RuleChainImportResult();
    ruleChainImportResult.setError("An error occurred");
    ruleChainImportResult.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult.setRuleChainName(null);
    ruleChainImportResult.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult.setUpdated(true);

    RuleChainImportResult ruleChainImportResult2 = new RuleChainImportResult();
    ruleChainImportResult2.setError("An error occurred");
    ruleChainImportResult2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult2.setRuleChainName(null);
    ruleChainImportResult2.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult2.setUpdated(true);

    // Act and Assert
    assertEquals(ruleChainImportResult, ruleChainImportResult2);
    int expectedHashCodeResult = ruleChainImportResult.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainImportResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainImportResult#equals(Object)}
   *   <li>{@link RuleChainImportResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    RuleChainImportResult ruleChainImportResult = new RuleChainImportResult();
    ruleChainImportResult.setError("An error occurred");
    ruleChainImportResult.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult.setRuleChainName("Rule Chain Name");
    ruleChainImportResult.setTenantId(null);
    ruleChainImportResult.setUpdated(true);

    RuleChainImportResult ruleChainImportResult2 = new RuleChainImportResult();
    ruleChainImportResult2.setError("An error occurred");
    ruleChainImportResult2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult2.setRuleChainName("Rule Chain Name");
    ruleChainImportResult2.setTenantId(null);
    ruleChainImportResult2.setUpdated(true);

    // Act and Assert
    assertEquals(ruleChainImportResult, ruleChainImportResult2);
    int expectedHashCodeResult = ruleChainImportResult.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainImportResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainImportResult#equals(Object)}
   *   <li>{@link RuleChainImportResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChainImportResult ruleChainImportResult = new RuleChainImportResult();
    ruleChainImportResult.setError("An error occurred");
    ruleChainImportResult.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult.setRuleChainName("Rule Chain Name");
    ruleChainImportResult.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult.setUpdated(true);

    // Act and Assert
    assertEquals(ruleChainImportResult, ruleChainImportResult);
    int expectedHashCodeResult = ruleChainImportResult.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainImportResult.hashCode());
  }

  /**
   * Method under test: {@link RuleChainImportResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleChainImportResult ruleChainImportResult = new RuleChainImportResult();
    ruleChainImportResult.setError("Rule Chain Name");
    ruleChainImportResult.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult.setRuleChainName("Rule Chain Name");
    ruleChainImportResult.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult.setUpdated(true);

    RuleChainImportResult ruleChainImportResult2 = new RuleChainImportResult();
    ruleChainImportResult2.setError("An error occurred");
    ruleChainImportResult2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult2.setRuleChainName("Rule Chain Name");
    ruleChainImportResult2.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult2.setUpdated(true);

    // Act and Assert
    assertNotEquals(ruleChainImportResult, ruleChainImportResult2);
  }

  /**
   * Method under test: {@link RuleChainImportResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleChainImportResult ruleChainImportResult = new RuleChainImportResult();
    ruleChainImportResult.setError(null);
    ruleChainImportResult.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult.setRuleChainName("Rule Chain Name");
    ruleChainImportResult.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult.setUpdated(true);

    RuleChainImportResult ruleChainImportResult2 = new RuleChainImportResult();
    ruleChainImportResult2.setError("An error occurred");
    ruleChainImportResult2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult2.setRuleChainName("Rule Chain Name");
    ruleChainImportResult2.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult2.setUpdated(true);

    // Act and Assert
    assertNotEquals(ruleChainImportResult, ruleChainImportResult2);
  }

  /**
   * Method under test: {@link RuleChainImportResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleChainImportResult ruleChainImportResult = new RuleChainImportResult();
    ruleChainImportResult.setError("An error occurred");
    ruleChainImportResult.setRuleChainId(new RuleChainId(UUID.randomUUID()));
    ruleChainImportResult.setRuleChainName("Rule Chain Name");
    ruleChainImportResult.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult.setUpdated(true);

    RuleChainImportResult ruleChainImportResult2 = new RuleChainImportResult();
    ruleChainImportResult2.setError("An error occurred");
    ruleChainImportResult2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult2.setRuleChainName("Rule Chain Name");
    ruleChainImportResult2.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult2.setUpdated(true);

    // Act and Assert
    assertNotEquals(ruleChainImportResult, ruleChainImportResult2);
  }

  /**
   * Method under test: {@link RuleChainImportResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleChainImportResult ruleChainImportResult = new RuleChainImportResult();
    ruleChainImportResult.setError("An error occurred");
    ruleChainImportResult.setRuleChainId(null);
    ruleChainImportResult.setRuleChainName("Rule Chain Name");
    ruleChainImportResult.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult.setUpdated(true);

    RuleChainImportResult ruleChainImportResult2 = new RuleChainImportResult();
    ruleChainImportResult2.setError("An error occurred");
    ruleChainImportResult2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult2.setRuleChainName("Rule Chain Name");
    ruleChainImportResult2.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult2.setUpdated(true);

    // Act and Assert
    assertNotEquals(ruleChainImportResult, ruleChainImportResult2);
  }

  /**
   * Method under test: {@link RuleChainImportResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleChainImportResult ruleChainImportResult = new RuleChainImportResult();
    ruleChainImportResult.setError("An error occurred");
    ruleChainImportResult.setRuleChainId(mock(RuleChainId.class));
    ruleChainImportResult.setRuleChainName("Rule Chain Name");
    ruleChainImportResult.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult.setUpdated(true);

    RuleChainImportResult ruleChainImportResult2 = new RuleChainImportResult();
    ruleChainImportResult2.setError("An error occurred");
    ruleChainImportResult2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult2.setRuleChainName("Rule Chain Name");
    ruleChainImportResult2.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult2.setUpdated(true);

    // Act and Assert
    assertNotEquals(ruleChainImportResult, ruleChainImportResult2);
  }

  /**
   * Method under test: {@link RuleChainImportResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleChainImportResult ruleChainImportResult = new RuleChainImportResult();
    ruleChainImportResult.setError("An error occurred");
    ruleChainImportResult.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult.setRuleChainName("An error occurred");
    ruleChainImportResult.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult.setUpdated(true);

    RuleChainImportResult ruleChainImportResult2 = new RuleChainImportResult();
    ruleChainImportResult2.setError("An error occurred");
    ruleChainImportResult2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult2.setRuleChainName("Rule Chain Name");
    ruleChainImportResult2.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult2.setUpdated(true);

    // Act and Assert
    assertNotEquals(ruleChainImportResult, ruleChainImportResult2);
  }

  /**
   * Method under test: {@link RuleChainImportResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleChainImportResult ruleChainImportResult = new RuleChainImportResult();
    ruleChainImportResult.setError("An error occurred");
    ruleChainImportResult.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult.setRuleChainName(null);
    ruleChainImportResult.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult.setUpdated(true);

    RuleChainImportResult ruleChainImportResult2 = new RuleChainImportResult();
    ruleChainImportResult2.setError("An error occurred");
    ruleChainImportResult2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult2.setRuleChainName("Rule Chain Name");
    ruleChainImportResult2.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult2.setUpdated(true);

    // Act and Assert
    assertNotEquals(ruleChainImportResult, ruleChainImportResult2);
  }

  /**
   * Method under test: {@link RuleChainImportResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleChainImportResult ruleChainImportResult = new RuleChainImportResult();
    ruleChainImportResult.setError("An error occurred");
    ruleChainImportResult.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult.setRuleChainName("Rule Chain Name");
    ruleChainImportResult.setTenantId(null);
    ruleChainImportResult.setUpdated(true);

    RuleChainImportResult ruleChainImportResult2 = new RuleChainImportResult();
    ruleChainImportResult2.setError("An error occurred");
    ruleChainImportResult2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult2.setRuleChainName("Rule Chain Name");
    ruleChainImportResult2.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult2.setUpdated(true);

    // Act and Assert
    assertNotEquals(ruleChainImportResult, ruleChainImportResult2);
  }

  /**
   * Method under test: {@link RuleChainImportResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleChainImportResult ruleChainImportResult = new RuleChainImportResult();
    ruleChainImportResult.setError("An error occurred");
    ruleChainImportResult.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult.setRuleChainName("Rule Chain Name");
    ruleChainImportResult.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult.setUpdated(false);

    RuleChainImportResult ruleChainImportResult2 = new RuleChainImportResult();
    ruleChainImportResult2.setError("An error occurred");
    ruleChainImportResult2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult2.setRuleChainName("Rule Chain Name");
    ruleChainImportResult2.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult2.setUpdated(true);

    // Act and Assert
    assertNotEquals(ruleChainImportResult, ruleChainImportResult2);
  }

  /**
   * Method under test: {@link RuleChainImportResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleChainImportResult ruleChainImportResult = new RuleChainImportResult();
    ruleChainImportResult.setError("An error occurred");
    ruleChainImportResult.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult.setRuleChainName("Rule Chain Name");
    ruleChainImportResult.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult.setUpdated(true);

    RuleChainImportResult ruleChainImportResult2 = new RuleChainImportResult();
    ruleChainImportResult2.setError("An error occurred");
    ruleChainImportResult2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult2.setRuleChainName("Rule Chain Name");
    ruleChainImportResult2.setTenantId(null);
    ruleChainImportResult2.setUpdated(true);

    // Act and Assert
    assertNotEquals(ruleChainImportResult, ruleChainImportResult2);
  }

  /**
   * Method under test: {@link RuleChainImportResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleChainImportResult ruleChainImportResult = new RuleChainImportResult();
    ruleChainImportResult.setError("An error occurred");
    ruleChainImportResult.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult.setRuleChainName("Rule Chain Name");
    ruleChainImportResult.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult.setUpdated(true);

    // Act and Assert
    assertNotEquals(ruleChainImportResult, null);
  }

  /**
   * Method under test: {@link RuleChainImportResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleChainImportResult ruleChainImportResult = new RuleChainImportResult();
    ruleChainImportResult.setError("An error occurred");
    ruleChainImportResult.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainImportResult.setRuleChainName("Rule Chain Name");
    ruleChainImportResult.setTenantId(TenantId.SYS_TENANT_ID);
    ruleChainImportResult.setUpdated(true);

    // Act and Assert
    assertNotEquals(ruleChainImportResult, "Different type to RuleChainImportResult");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RuleChainImportResult}
   *   <li>{@link RuleChainImportResult#setError(String)}
   *   <li>{@link RuleChainImportResult#setRuleChainId(RuleChainId)}
   *   <li>{@link RuleChainImportResult#setRuleChainName(String)}
   *   <li>{@link RuleChainImportResult#setTenantId(TenantId)}
   *   <li>{@link RuleChainImportResult#setUpdated(boolean)}
   *   <li>{@link RuleChainImportResult#toString()}
   *   <li>{@link RuleChainImportResult#getError()}
   *   <li>{@link RuleChainImportResult#getRuleChainId()}
   *   <li>{@link RuleChainImportResult#getRuleChainName()}
   *   <li>{@link RuleChainImportResult#getTenantId()}
   *   <li>{@link RuleChainImportResult#isUpdated()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RuleChainImportResult actualRuleChainImportResult = new RuleChainImportResult();
    actualRuleChainImportResult.setError("An error occurred");
    RuleChainId ruleChainId = new RuleChainId(EntityId.NULL_UUID);
    actualRuleChainImportResult.setRuleChainId(ruleChainId);
    actualRuleChainImportResult.setRuleChainName("Rule Chain Name");
    actualRuleChainImportResult.setTenantId(TenantId.SYS_TENANT_ID);
    actualRuleChainImportResult.setUpdated(true);
    String actualToStringResult = actualRuleChainImportResult.toString();
    String actualError = actualRuleChainImportResult.getError();
    RuleChainId actualRuleChainId = actualRuleChainImportResult.getRuleChainId();
    String actualRuleChainName = actualRuleChainImportResult.getRuleChainName();
    TenantId actualTenantId = actualRuleChainImportResult.getTenantId();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualError);
    assertEquals("Rule Chain Name", actualRuleChainName);
    assertEquals(
        "RuleChainImportResult(tenantId=13814000-1dd2-11b2-8080-808080808080, ruleChainId=13814000-1dd2-11b2"
            + "-8080-808080808080, ruleChainName=Rule Chain Name, updated=true, error=An error occurred)",
        actualToStringResult);
    assertTrue(actualRuleChainImportResult.isUpdated());
    assertSame(ruleChainId, actualRuleChainId);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }
}
