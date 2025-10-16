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
package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.UserCredentialsId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.security.UserCredentials;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class UserCredentialsEntityDiffblueTest {
  /**
   * Test {@link UserCredentialsEntity#equals(Object)}, and {@link
   * UserCredentialsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserCredentialsEntity#equals(Object)}
   *   <li>{@link UserCredentialsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    UserCredentialsEntity userCredentialsEntity2 = new UserCredentialsEntity();
    userCredentialsEntity2.setActivateToken("ABC123");
    userCredentialsEntity2.setActivateTokenExpTime(1L);
    userCredentialsEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity2.setCreatedTime(1L);
    userCredentialsEntity2.setEnabled(true);
    userCredentialsEntity2.setFailedLoginAttempts(1);
    userCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setLastLoginTs(1L);
    userCredentialsEntity2.setPassword("iloveyou");
    userCredentialsEntity2.setResetToken("ABC123");
    userCredentialsEntity2.setResetTokenExpTime(1L);
    userCredentialsEntity2.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(userCredentialsEntity, userCredentialsEntity2);
    assertEquals(userCredentialsEntity.hashCode(), userCredentialsEntity2.hashCode());
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}, and {@link
   * UserCredentialsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserCredentialsEntity#equals(Object)}
   *   <li>{@link UserCredentialsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken(null);
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    UserCredentialsEntity userCredentialsEntity2 = new UserCredentialsEntity();
    userCredentialsEntity2.setActivateToken(null);
    userCredentialsEntity2.setActivateTokenExpTime(1L);
    userCredentialsEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity2.setCreatedTime(1L);
    userCredentialsEntity2.setEnabled(true);
    userCredentialsEntity2.setFailedLoginAttempts(1);
    userCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setLastLoginTs(1L);
    userCredentialsEntity2.setPassword("iloveyou");
    userCredentialsEntity2.setResetToken("ABC123");
    userCredentialsEntity2.setResetTokenExpTime(1L);
    userCredentialsEntity2.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(userCredentialsEntity, userCredentialsEntity2);
    assertEquals(userCredentialsEntity.hashCode(), userCredentialsEntity2.hashCode());
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}, and {@link
   * UserCredentialsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserCredentialsEntity#equals(Object)}
   *   <li>{@link UserCredentialsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(null);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    UserCredentialsEntity userCredentialsEntity2 = new UserCredentialsEntity();
    userCredentialsEntity2.setActivateToken("ABC123");
    userCredentialsEntity2.setActivateTokenExpTime(null);
    userCredentialsEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity2.setCreatedTime(1L);
    userCredentialsEntity2.setEnabled(true);
    userCredentialsEntity2.setFailedLoginAttempts(1);
    userCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setLastLoginTs(1L);
    userCredentialsEntity2.setPassword("iloveyou");
    userCredentialsEntity2.setResetToken("ABC123");
    userCredentialsEntity2.setResetTokenExpTime(1L);
    userCredentialsEntity2.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(userCredentialsEntity, userCredentialsEntity2);
    assertEquals(userCredentialsEntity.hashCode(), userCredentialsEntity2.hashCode());
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}, and {@link
   * UserCredentialsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserCredentialsEntity#equals(Object)}
   *   <li>{@link UserCredentialsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(null);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    UserCredentialsEntity userCredentialsEntity2 = new UserCredentialsEntity();
    userCredentialsEntity2.setActivateToken("ABC123");
    userCredentialsEntity2.setActivateTokenExpTime(1L);
    userCredentialsEntity2.setAdditionalInfo(null);
    userCredentialsEntity2.setCreatedTime(1L);
    userCredentialsEntity2.setEnabled(true);
    userCredentialsEntity2.setFailedLoginAttempts(1);
    userCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setLastLoginTs(1L);
    userCredentialsEntity2.setPassword("iloveyou");
    userCredentialsEntity2.setResetToken("ABC123");
    userCredentialsEntity2.setResetTokenExpTime(1L);
    userCredentialsEntity2.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(userCredentialsEntity, userCredentialsEntity2);
    assertEquals(userCredentialsEntity.hashCode(), userCredentialsEntity2.hashCode());
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}, and {@link
   * UserCredentialsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserCredentialsEntity#equals(Object)}
   *   <li>{@link UserCredentialsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(userCredentialsEntity, userCredentialsEntity);
    int expectedHashCodeResult = userCredentialsEntity.hashCode();
    assertEquals(expectedHashCodeResult, userCredentialsEntity.hashCode());
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("iloveyou");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    UserCredentialsEntity userCredentialsEntity2 = new UserCredentialsEntity();
    userCredentialsEntity2.setActivateToken("ABC123");
    userCredentialsEntity2.setActivateTokenExpTime(1L);
    userCredentialsEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity2.setCreatedTime(1L);
    userCredentialsEntity2.setEnabled(true);
    userCredentialsEntity2.setFailedLoginAttempts(1);
    userCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setLastLoginTs(1L);
    userCredentialsEntity2.setPassword("iloveyou");
    userCredentialsEntity2.setResetToken("ABC123");
    userCredentialsEntity2.setResetTokenExpTime(1L);
    userCredentialsEntity2.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userCredentialsEntity, userCredentialsEntity2);
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken(null);
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    UserCredentialsEntity userCredentialsEntity2 = new UserCredentialsEntity();
    userCredentialsEntity2.setActivateToken("ABC123");
    userCredentialsEntity2.setActivateTokenExpTime(1L);
    userCredentialsEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity2.setCreatedTime(1L);
    userCredentialsEntity2.setEnabled(true);
    userCredentialsEntity2.setFailedLoginAttempts(1);
    userCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setLastLoginTs(1L);
    userCredentialsEntity2.setPassword("iloveyou");
    userCredentialsEntity2.setResetToken("ABC123");
    userCredentialsEntity2.setResetTokenExpTime(1L);
    userCredentialsEntity2.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userCredentialsEntity, userCredentialsEntity2);
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(3L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    UserCredentialsEntity userCredentialsEntity2 = new UserCredentialsEntity();
    userCredentialsEntity2.setActivateToken("ABC123");
    userCredentialsEntity2.setActivateTokenExpTime(1L);
    userCredentialsEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity2.setCreatedTime(1L);
    userCredentialsEntity2.setEnabled(true);
    userCredentialsEntity2.setFailedLoginAttempts(1);
    userCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setLastLoginTs(1L);
    userCredentialsEntity2.setPassword("iloveyou");
    userCredentialsEntity2.setResetToken("ABC123");
    userCredentialsEntity2.setResetTokenExpTime(1L);
    userCredentialsEntity2.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userCredentialsEntity, userCredentialsEntity2);
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(null);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    UserCredentialsEntity userCredentialsEntity2 = new UserCredentialsEntity();
    userCredentialsEntity2.setActivateToken("ABC123");
    userCredentialsEntity2.setActivateTokenExpTime(1L);
    userCredentialsEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity2.setCreatedTime(1L);
    userCredentialsEntity2.setEnabled(true);
    userCredentialsEntity2.setFailedLoginAttempts(1);
    userCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setLastLoginTs(1L);
    userCredentialsEntity2.setPassword("iloveyou");
    userCredentialsEntity2.setResetToken("ABC123");
    userCredentialsEntity2.setResetTokenExpTime(1L);
    userCredentialsEntity2.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userCredentialsEntity, userCredentialsEntity2);
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    UserCredentialsEntity userCredentialsEntity2 = new UserCredentialsEntity();
    userCredentialsEntity2.setActivateToken("ABC123");
    userCredentialsEntity2.setActivateTokenExpTime(1L);
    userCredentialsEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity2.setCreatedTime(1L);
    userCredentialsEntity2.setEnabled(true);
    userCredentialsEntity2.setFailedLoginAttempts(1);
    userCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setLastLoginTs(1L);
    userCredentialsEntity2.setPassword("iloveyou");
    userCredentialsEntity2.setResetToken("ABC123");
    userCredentialsEntity2.setResetTokenExpTime(1L);
    userCredentialsEntity2.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userCredentialsEntity, userCredentialsEntity2);
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(null);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    UserCredentialsEntity userCredentialsEntity2 = new UserCredentialsEntity();
    userCredentialsEntity2.setActivateToken("ABC123");
    userCredentialsEntity2.setActivateTokenExpTime(1L);
    userCredentialsEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity2.setCreatedTime(1L);
    userCredentialsEntity2.setEnabled(true);
    userCredentialsEntity2.setFailedLoginAttempts(1);
    userCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setLastLoginTs(1L);
    userCredentialsEntity2.setPassword("iloveyou");
    userCredentialsEntity2.setResetToken("ABC123");
    userCredentialsEntity2.setResetTokenExpTime(1L);
    userCredentialsEntity2.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userCredentialsEntity, userCredentialsEntity2);
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(3L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    UserCredentialsEntity userCredentialsEntity2 = new UserCredentialsEntity();
    userCredentialsEntity2.setActivateToken("ABC123");
    userCredentialsEntity2.setActivateTokenExpTime(1L);
    userCredentialsEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity2.setCreatedTime(1L);
    userCredentialsEntity2.setEnabled(true);
    userCredentialsEntity2.setFailedLoginAttempts(1);
    userCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setLastLoginTs(1L);
    userCredentialsEntity2.setPassword("iloveyou");
    userCredentialsEntity2.setResetToken("ABC123");
    userCredentialsEntity2.setResetTokenExpTime(1L);
    userCredentialsEntity2.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userCredentialsEntity, userCredentialsEntity2);
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(false);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    UserCredentialsEntity userCredentialsEntity2 = new UserCredentialsEntity();
    userCredentialsEntity2.setActivateToken("ABC123");
    userCredentialsEntity2.setActivateTokenExpTime(1L);
    userCredentialsEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity2.setCreatedTime(1L);
    userCredentialsEntity2.setEnabled(true);
    userCredentialsEntity2.setFailedLoginAttempts(1);
    userCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setLastLoginTs(1L);
    userCredentialsEntity2.setPassword("iloveyou");
    userCredentialsEntity2.setResetToken("ABC123");
    userCredentialsEntity2.setResetTokenExpTime(1L);
    userCredentialsEntity2.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userCredentialsEntity, userCredentialsEntity2);
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(3);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    UserCredentialsEntity userCredentialsEntity2 = new UserCredentialsEntity();
    userCredentialsEntity2.setActivateToken("ABC123");
    userCredentialsEntity2.setActivateTokenExpTime(1L);
    userCredentialsEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity2.setCreatedTime(1L);
    userCredentialsEntity2.setEnabled(true);
    userCredentialsEntity2.setFailedLoginAttempts(1);
    userCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setLastLoginTs(1L);
    userCredentialsEntity2.setPassword("iloveyou");
    userCredentialsEntity2.setResetToken("ABC123");
    userCredentialsEntity2.setResetTokenExpTime(1L);
    userCredentialsEntity2.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userCredentialsEntity, userCredentialsEntity2);
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(null);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    UserCredentialsEntity userCredentialsEntity2 = new UserCredentialsEntity();
    userCredentialsEntity2.setActivateToken("ABC123");
    userCredentialsEntity2.setActivateTokenExpTime(1L);
    userCredentialsEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity2.setCreatedTime(1L);
    userCredentialsEntity2.setEnabled(true);
    userCredentialsEntity2.setFailedLoginAttempts(1);
    userCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setLastLoginTs(1L);
    userCredentialsEntity2.setPassword("iloveyou");
    userCredentialsEntity2.setResetToken("ABC123");
    userCredentialsEntity2.setResetTokenExpTime(1L);
    userCredentialsEntity2.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userCredentialsEntity, userCredentialsEntity2);
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(3L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    UserCredentialsEntity userCredentialsEntity2 = new UserCredentialsEntity();
    userCredentialsEntity2.setActivateToken("ABC123");
    userCredentialsEntity2.setActivateTokenExpTime(1L);
    userCredentialsEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity2.setCreatedTime(1L);
    userCredentialsEntity2.setEnabled(true);
    userCredentialsEntity2.setFailedLoginAttempts(1);
    userCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setLastLoginTs(1L);
    userCredentialsEntity2.setPassword("iloveyou");
    userCredentialsEntity2.setResetToken("ABC123");
    userCredentialsEntity2.setResetTokenExpTime(1L);
    userCredentialsEntity2.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userCredentialsEntity, userCredentialsEntity2);
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(null);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    UserCredentialsEntity userCredentialsEntity2 = new UserCredentialsEntity();
    userCredentialsEntity2.setActivateToken("ABC123");
    userCredentialsEntity2.setActivateTokenExpTime(1L);
    userCredentialsEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity2.setCreatedTime(1L);
    userCredentialsEntity2.setEnabled(true);
    userCredentialsEntity2.setFailedLoginAttempts(1);
    userCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setLastLoginTs(1L);
    userCredentialsEntity2.setPassword("iloveyou");
    userCredentialsEntity2.setResetToken("ABC123");
    userCredentialsEntity2.setResetTokenExpTime(1L);
    userCredentialsEntity2.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userCredentialsEntity, userCredentialsEntity2);
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("ABC123");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    UserCredentialsEntity userCredentialsEntity2 = new UserCredentialsEntity();
    userCredentialsEntity2.setActivateToken("ABC123");
    userCredentialsEntity2.setActivateTokenExpTime(1L);
    userCredentialsEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity2.setCreatedTime(1L);
    userCredentialsEntity2.setEnabled(true);
    userCredentialsEntity2.setFailedLoginAttempts(1);
    userCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setLastLoginTs(1L);
    userCredentialsEntity2.setPassword("iloveyou");
    userCredentialsEntity2.setResetToken("ABC123");
    userCredentialsEntity2.setResetTokenExpTime(1L);
    userCredentialsEntity2.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userCredentialsEntity, userCredentialsEntity2);
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword(null);
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    UserCredentialsEntity userCredentialsEntity2 = new UserCredentialsEntity();
    userCredentialsEntity2.setActivateToken("ABC123");
    userCredentialsEntity2.setActivateTokenExpTime(1L);
    userCredentialsEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity2.setCreatedTime(1L);
    userCredentialsEntity2.setEnabled(true);
    userCredentialsEntity2.setFailedLoginAttempts(1);
    userCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setLastLoginTs(1L);
    userCredentialsEntity2.setPassword("iloveyou");
    userCredentialsEntity2.setResetToken("ABC123");
    userCredentialsEntity2.setResetTokenExpTime(1L);
    userCredentialsEntity2.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userCredentialsEntity, userCredentialsEntity2);
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("iloveyou");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    UserCredentialsEntity userCredentialsEntity2 = new UserCredentialsEntity();
    userCredentialsEntity2.setActivateToken("ABC123");
    userCredentialsEntity2.setActivateTokenExpTime(1L);
    userCredentialsEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity2.setCreatedTime(1L);
    userCredentialsEntity2.setEnabled(true);
    userCredentialsEntity2.setFailedLoginAttempts(1);
    userCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setLastLoginTs(1L);
    userCredentialsEntity2.setPassword("iloveyou");
    userCredentialsEntity2.setResetToken("ABC123");
    userCredentialsEntity2.setResetTokenExpTime(1L);
    userCredentialsEntity2.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userCredentialsEntity, userCredentialsEntity2);
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken(null);
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    UserCredentialsEntity userCredentialsEntity2 = new UserCredentialsEntity();
    userCredentialsEntity2.setActivateToken("ABC123");
    userCredentialsEntity2.setActivateTokenExpTime(1L);
    userCredentialsEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity2.setCreatedTime(1L);
    userCredentialsEntity2.setEnabled(true);
    userCredentialsEntity2.setFailedLoginAttempts(1);
    userCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setLastLoginTs(1L);
    userCredentialsEntity2.setPassword("iloveyou");
    userCredentialsEntity2.setResetToken("ABC123");
    userCredentialsEntity2.setResetTokenExpTime(1L);
    userCredentialsEntity2.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userCredentialsEntity, userCredentialsEntity2);
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(3L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    UserCredentialsEntity userCredentialsEntity2 = new UserCredentialsEntity();
    userCredentialsEntity2.setActivateToken("ABC123");
    userCredentialsEntity2.setActivateTokenExpTime(1L);
    userCredentialsEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity2.setCreatedTime(1L);
    userCredentialsEntity2.setEnabled(true);
    userCredentialsEntity2.setFailedLoginAttempts(1);
    userCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setLastLoginTs(1L);
    userCredentialsEntity2.setPassword("iloveyou");
    userCredentialsEntity2.setResetToken("ABC123");
    userCredentialsEntity2.setResetTokenExpTime(1L);
    userCredentialsEntity2.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userCredentialsEntity, userCredentialsEntity2);
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(null);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    UserCredentialsEntity userCredentialsEntity2 = new UserCredentialsEntity();
    userCredentialsEntity2.setActivateToken("ABC123");
    userCredentialsEntity2.setActivateTokenExpTime(1L);
    userCredentialsEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity2.setCreatedTime(1L);
    userCredentialsEntity2.setEnabled(true);
    userCredentialsEntity2.setFailedLoginAttempts(1);
    userCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setLastLoginTs(1L);
    userCredentialsEntity2.setPassword("iloveyou");
    userCredentialsEntity2.setResetToken("ABC123");
    userCredentialsEntity2.setResetTokenExpTime(1L);
    userCredentialsEntity2.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userCredentialsEntity, userCredentialsEntity2);
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(UUID.randomUUID());
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    UserCredentialsEntity userCredentialsEntity2 = new UserCredentialsEntity();
    userCredentialsEntity2.setActivateToken("ABC123");
    userCredentialsEntity2.setActivateTokenExpTime(1L);
    userCredentialsEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity2.setCreatedTime(1L);
    userCredentialsEntity2.setEnabled(true);
    userCredentialsEntity2.setFailedLoginAttempts(1);
    userCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setLastLoginTs(1L);
    userCredentialsEntity2.setPassword("iloveyou");
    userCredentialsEntity2.setResetToken("ABC123");
    userCredentialsEntity2.setResetTokenExpTime(1L);
    userCredentialsEntity2.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userCredentialsEntity, userCredentialsEntity2);
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(null);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    UserCredentialsEntity userCredentialsEntity2 = new UserCredentialsEntity();
    userCredentialsEntity2.setActivateToken("ABC123");
    userCredentialsEntity2.setActivateTokenExpTime(1L);
    userCredentialsEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity2.setCreatedTime(1L);
    userCredentialsEntity2.setEnabled(true);
    userCredentialsEntity2.setFailedLoginAttempts(1);
    userCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setLastLoginTs(1L);
    userCredentialsEntity2.setPassword("iloveyou");
    userCredentialsEntity2.setResetToken("ABC123");
    userCredentialsEntity2.setResetTokenExpTime(1L);
    userCredentialsEntity2.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userCredentialsEntity, userCredentialsEntity2);
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userCredentialsEntity, null);
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserCredentialsEntity.equals(Object)",
    "int UserCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userCredentialsEntity, "Different type to UserCredentialsEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserCredentialsEntity#UserCredentialsEntity()}
   *   <li>{@link UserCredentialsEntity#setActivateToken(String)}
   *   <li>{@link UserCredentialsEntity#setActivateTokenExpTime(Long)}
   *   <li>{@link UserCredentialsEntity#setAdditionalInfo(JsonNode)}
   *   <li>{@link UserCredentialsEntity#setEnabled(boolean)}
   *   <li>{@link UserCredentialsEntity#setFailedLoginAttempts(Integer)}
   *   <li>{@link UserCredentialsEntity#setLastLoginTs(Long)}
   *   <li>{@link UserCredentialsEntity#setPassword(String)}
   *   <li>{@link UserCredentialsEntity#setResetToken(String)}
   *   <li>{@link UserCredentialsEntity#setResetTokenExpTime(Long)}
   *   <li>{@link UserCredentialsEntity#setUserId(UUID)}
   *   <li>{@link UserCredentialsEntity#toString()}
   *   <li>{@link UserCredentialsEntity#getActivateToken()}
   *   <li>{@link UserCredentialsEntity#getActivateTokenExpTime()}
   *   <li>{@link UserCredentialsEntity#getAdditionalInfo()}
   *   <li>{@link UserCredentialsEntity#getFailedLoginAttempts()}
   *   <li>{@link UserCredentialsEntity#getLastLoginTs()}
   *   <li>{@link UserCredentialsEntity#getPassword()}
   *   <li>{@link UserCredentialsEntity#getResetToken()}
   *   <li>{@link UserCredentialsEntity#getResetTokenExpTime()}
   *   <li>{@link UserCredentialsEntity#getUserId()}
   *   <li>{@link UserCredentialsEntity#isEnabled()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserCredentialsEntity.<init>()",
    "String UserCredentialsEntity.getActivateToken()",
    "Long UserCredentialsEntity.getActivateTokenExpTime()",
    "JsonNode UserCredentialsEntity.getAdditionalInfo()",
    "Integer UserCredentialsEntity.getFailedLoginAttempts()",
    "Long UserCredentialsEntity.getLastLoginTs()",
    "String UserCredentialsEntity.getPassword()",
    "String UserCredentialsEntity.getResetToken()",
    "Long UserCredentialsEntity.getResetTokenExpTime()",
    "UUID UserCredentialsEntity.getUserId()",
    "boolean UserCredentialsEntity.isEnabled()",
    "void UserCredentialsEntity.setActivateToken(String)",
    "void UserCredentialsEntity.setActivateTokenExpTime(Long)",
    "void UserCredentialsEntity.setAdditionalInfo(JsonNode)",
    "void UserCredentialsEntity.setEnabled(boolean)",
    "void UserCredentialsEntity.setFailedLoginAttempts(Integer)",
    "void UserCredentialsEntity.setLastLoginTs(Long)",
    "void UserCredentialsEntity.setPassword(String)",
    "void UserCredentialsEntity.setResetToken(String)",
    "void UserCredentialsEntity.setResetTokenExpTime(Long)",
    "void UserCredentialsEntity.setUserId(UUID)",
    "String UserCredentialsEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    UserCredentialsEntity actualUserCredentialsEntity = new UserCredentialsEntity();
    actualUserCredentialsEntity.setActivateToken("ABC123");
    actualUserCredentialsEntity.setActivateTokenExpTime(1L);
    JsonNode additionalInfo = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualUserCredentialsEntity.setAdditionalInfo(additionalInfo);
    actualUserCredentialsEntity.setEnabled(true);
    actualUserCredentialsEntity.setFailedLoginAttempts(1);
    actualUserCredentialsEntity.setLastLoginTs(1L);
    actualUserCredentialsEntity.setPassword("iloveyou");
    actualUserCredentialsEntity.setResetToken("ABC123");
    actualUserCredentialsEntity.setResetTokenExpTime(1L);
    UUID userId = ModelConstants.NULL_UUID;
    actualUserCredentialsEntity.setUserId(userId);
    String actualToStringResult = actualUserCredentialsEntity.toString();
    String actualActivateToken = actualUserCredentialsEntity.getActivateToken();
    Long actualActivateTokenExpTime = actualUserCredentialsEntity.getActivateTokenExpTime();
    JsonNode actualAdditionalInfo = actualUserCredentialsEntity.getAdditionalInfo();
    Integer actualFailedLoginAttempts = actualUserCredentialsEntity.getFailedLoginAttempts();
    Long actualLastLoginTs = actualUserCredentialsEntity.getLastLoginTs();
    String actualPassword = actualUserCredentialsEntity.getPassword();
    String actualResetToken = actualUserCredentialsEntity.getResetToken();
    Long actualResetTokenExpTime = actualUserCredentialsEntity.getResetTokenExpTime();
    UUID actualUserId = actualUserCredentialsEntity.getUserId();
    boolean actualIsEnabledResult = actualUserCredentialsEntity.isEnabled();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualUserId.toString());
    assertEquals("ABC123", actualActivateToken);
    assertEquals("ABC123", actualResetToken);
    assertEquals(
        "UserCredentialsEntity(userId=13814000-1dd2-11b2-8080-808080808080, enabled=true, password=iloveyou,"
            + " activateToken=ABC123, activateTokenExpTime=1, resetToken=ABC123, resetTokenExpTime=1, additionalInfo"
            + "={\"isPublic\":true}, lastLoginTs=1, failedLoginAttempts=1)",
        actualToStringResult);
    assertEquals("iloveyou", actualPassword);
    assertNull(actualUserCredentialsEntity.getId());
    assertNull(actualUserCredentialsEntity.getUuid());
    assertEquals(0L, actualUserCredentialsEntity.getCreatedTime());
    assertEquals(1, actualFailedLoginAttempts.intValue());
    assertEquals(1L, actualActivateTokenExpTime.longValue());
    assertEquals(1L, actualLastLoginTs.longValue());
    assertEquals(1L, actualResetTokenExpTime.longValue());
    assertTrue(actualIsEnabledResult);
    assertSame(additionalInfo, actualAdditionalInfo);
    assertSame(userId, actualUserId);
  }

  /**
   * Test {@link UserCredentialsEntity#UserCredentialsEntity(UserCredentials)}.
   *
   * <ul>
   *   <li>Given {@link UserId#UserId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#UserCredentialsEntity(UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserCredentialsEntity.<init>(UserCredentials)"})
  public void testNewUserCredentialsEntity_givenUserIdWithIdIsNull_uuid() {
    // Arrange
    UserCredentials userCredentials =
        new UserCredentials(new UserCredentialsId(ModelConstants.NULL_UUID));
    userCredentials.setUserId(new UserId(ModelConstants.NULL_UUID));

    // Act
    UserCredentialsEntity actualUserCredentialsEntity = new UserCredentialsEntity(userCredentials);

    // Assert
    assertNull(actualUserCredentialsEntity.getAdditionalInfo());
    assertNull(actualUserCredentialsEntity.getFailedLoginAttempts());
    assertNull(actualUserCredentialsEntity.getActivateTokenExpTime());
    assertNull(actualUserCredentialsEntity.getLastLoginTs());
    assertNull(actualUserCredentialsEntity.getResetTokenExpTime());
    assertNull(actualUserCredentialsEntity.getActivateToken());
    assertNull(actualUserCredentialsEntity.getPassword());
    assertNull(actualUserCredentialsEntity.getResetToken());
    assertEquals(0L, actualUserCredentialsEntity.getCreatedTime());
    assertFalse(actualUserCredentialsEntity.isEnabled());
  }

  /**
   * Test {@link UserCredentialsEntity#UserCredentialsEntity(UserCredentials)}.
   *
   * <ul>
   *   <li>When {@link UserCredentials#UserCredentials()}.
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#UserCredentialsEntity(UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserCredentialsEntity.<init>(UserCredentials)"})
  public void testNewUserCredentialsEntity_whenUserCredentials_thenReturnIdIsNull() {
    // Arrange and Act
    UserCredentialsEntity actualUserCredentialsEntity =
        new UserCredentialsEntity(new UserCredentials());

    // Assert
    assertNull(actualUserCredentialsEntity.getAdditionalInfo());
    assertNull(actualUserCredentialsEntity.getFailedLoginAttempts());
    assertNull(actualUserCredentialsEntity.getActivateTokenExpTime());
    assertNull(actualUserCredentialsEntity.getLastLoginTs());
    assertNull(actualUserCredentialsEntity.getResetTokenExpTime());
    assertNull(actualUserCredentialsEntity.getActivateToken());
    assertNull(actualUserCredentialsEntity.getPassword());
    assertNull(actualUserCredentialsEntity.getResetToken());
    assertNull(actualUserCredentialsEntity.getId());
    assertNull(actualUserCredentialsEntity.getUuid());
    assertNull(actualUserCredentialsEntity.getUserId());
    assertEquals(0L, actualUserCredentialsEntity.getCreatedTime());
    assertFalse(actualUserCredentialsEntity.isEnabled());
  }

  /**
   * Test {@link UserCredentialsEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link UserCredentialsEntity#UserCredentialsEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserCredentials UserCredentialsEntity.toData()"})
  public void testToData_givenUserCredentialsEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    UserCredentials actualToDataResult = new UserCredentialsEntity().toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualToDataResult.getFailedLoginAttempts());
    assertNull(actualToDataResult.getActivateTokenExpTime());
    assertNull(actualToDataResult.getLastLoginTs());
    assertNull(actualToDataResult.getResetTokenExpTime());
    assertNull(actualToDataResult.getActivateToken());
    assertNull(actualToDataResult.getPassword());
    assertNull(actualToDataResult.getResetToken());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getUserId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(0L, actualToDataResult.getActivationTokenTtl());
    assertEquals(0L, actualToDataResult.getResetTokenTtl());
    assertFalse(actualToDataResult.isEnabled());
    assertTrue(actualToDataResult.isActivationTokenExpired());
    assertTrue(actualToDataResult.isResetTokenExpired());
  }

  /**
   * Test {@link UserCredentialsEntity#toData()}.
   *
   * <ul>
   *   <li>Then AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserCredentials UserCredentialsEntity.toData()"})
  public void testToData_thenAdditionalInfoReturnObjectNode() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);

    // Act
    UserCredentials actualToDataResult = userCredentialsEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("ABC123", actualToDataResult.getActivateToken());
    assertEquals("ABC123", actualToDataResult.getResetToken());
    assertEquals("iloveyou", actualToDataResult.getPassword());
    assertEquals(1, actualToDataResult.getFailedLoginAttempts().intValue());
    assertEquals(1L, actualToDataResult.getActivateTokenExpTime().longValue());
    assertEquals(1L, actualToDataResult.getLastLoginTs().longValue());
    assertEquals(1L, actualToDataResult.getResetTokenExpTime().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertTrue(actualToDataResult.isEnabled());
  }
}
