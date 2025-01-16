package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.security.UserCredentials;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class UserCredentialsEntityDiffblueTest {
  /**
   * Test {@link UserCredentialsEntity#equals(Object)}, and
   * {@link UserCredentialsEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserCredentialsEntity#equals(Object)}
   *   <li>{@link UserCredentialsEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    userCredentialsEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    int expectedHashCodeResult = userCredentialsEntity.hashCode();
    assertEquals(expectedHashCodeResult, userCredentialsEntity2.hashCode());
  }

  /**
   * Test {@link UserCredentialsEntity#equals(Object)}, and
   * {@link UserCredentialsEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserCredentialsEntity#equals(Object)}
   *   <li>{@link UserCredentialsEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("iloveyou");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    userCredentialsEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken(null);
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    userCredentialsEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(3L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    userCredentialsEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(null);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    userCredentialsEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(MissingNode.getInstance());
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
    userCredentialsEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
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
    userCredentialsEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(mock(JsonNode.class));
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
    userCredentialsEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    userCredentialsEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    userCredentialsEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    userCredentialsEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    userCredentialsEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    userCredentialsEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    userCredentialsEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    userCredentialsEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    userCredentialsEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    userCredentialsEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    userCredentialsEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    userCredentialsEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    userCredentialsEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    userCredentialsEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    userCredentialsEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * <p>
   * Methods under test:
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

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualUserId.toString());
    assertEquals("ABC123", actualActivateToken);
    assertEquals("ABC123", actualResetToken);
    assertEquals("UserCredentialsEntity(userId=13814000-1dd2-11b2-8080-808080808080, enabled=true, password=iloveyou,"
        + " activateToken=ABC123, activateTokenExpTime=1, resetToken=ABC123, resetTokenExpTime=1, additionalInfo"
        + "={\"isPublic\":true}, lastLoginTs=1, failedLoginAttempts=1)", actualToStringResult);
    assertEquals("iloveyou", actualPassword);
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
   * <p>
   * Method under test:
   * {@link UserCredentialsEntity#UserCredentialsEntity(UserCredentials)}
   */
  @Test
  public void testNewUserCredentialsEntity() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    userCredentials.setUserId(new UserId(ModelConstants.NULL_UUID));

    // Act
    UserCredentialsEntity actualUserCredentialsEntity = new UserCredentialsEntity(userCredentials);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualUserCredentialsEntity.getUserId().toString());
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
    assertEquals(0L, actualUserCredentialsEntity.getCreatedTime());
    assertFalse(actualUserCredentialsEntity.isEnabled());
  }

  /**
   * Test {@link UserCredentialsEntity#UserCredentialsEntity(UserCredentials)}.
   * <ul>
   *   <li>When {@link UserCredentials#UserCredentials()}.</li>
   *   <li>Then return UserId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserCredentialsEntity#UserCredentialsEntity(UserCredentials)}
   */
  @Test
  public void testNewUserCredentialsEntity_whenUserCredentials_thenReturnUserIdIsNull() {
    // Arrange and Act
    UserCredentialsEntity actualUserCredentialsEntity = new UserCredentialsEntity(new UserCredentials());

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
   * <ul>
   *   <li>Given {@link UserCredentialsEntity#UserCredentialsEntity()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#toData()}
   */
  @Test
  public void testToData_givenUserCredentialsEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    UserCredentials actualToDataResult = (new UserCredentialsEntity()).toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(actualToDataResult.getFailedLoginAttempts());
    assertNull(actualToDataResult.getActivateTokenExpTime());
    assertNull(actualToDataResult.getLastLoginTs());
    assertNull(actualToDataResult.getResetTokenExpTime());
    assertNull(actualToDataResult.getActivateToken());
    assertNull(actualToDataResult.getPassword());
    assertNull(actualToDataResult.getResetToken());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getId().getId());
    assertNull(actualToDataResult.getUserId());
    assertEquals(0, additionalInfo.size());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(0L, actualToDataResult.getActivationTokenTtl());
    assertEquals(0L, actualToDataResult.getResetTokenTtl());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.iterator().hasNext());
    assertFalse(actualToDataResult.isEnabled());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertTrue(actualToDataResult.isActivationTokenExpired());
    assertTrue(actualToDataResult.isResetTokenExpired());
  }

  /**
   * Test {@link UserCredentialsEntity#toData()}.
   * <ul>
   *   <li>Then AdditionalInfo iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsEntity#toData()}
   */
  @Test
  public void testToData_thenAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("ABC123", actualToDataResult.getActivateToken());
    assertEquals("ABC123", actualToDataResult.getResetToken());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("iloveyou", actualToDataResult.getPassword());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, additionalInfo.size());
    assertEquals(1, actualToDataResult.getFailedLoginAttempts().intValue());
    assertEquals(1L, actualToDataResult.getActivateTokenExpTime().longValue());
    assertEquals(1L, actualToDataResult.getLastLoginTs().longValue());
    assertEquals(1L, actualToDataResult.getResetTokenExpTime().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    UserId userId = actualToDataResult.getUserId();
    assertEquals(EntityType.USER, userId.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(additionalInfo.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(userId.isNullUid());
    assertTrue(actualToDataResult.isEnabled());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(uuidId, actualToDataResult.getId().getId());
    assertSame(uuidId, userId.getId());
  }
}
