package org.thingsboard.server.service.edge.rpc.constructor.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.security.Authority;
import org.thingsboard.server.common.data.security.UserCredentials;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;
import org.thingsboard.server.gen.edge.v1.UserCredentialsUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UserUpdateMsg;

class UserMsgConstructorV1DiffblueTest {
  /**
   * Test {@link UserMsgConstructorV1#constructUserUpdatedMsg(UpdateMsgType, User)}.
   *
   * <ul>
   *   <li>Given {@code Doe}.
   *   <li>Then return LastName is {@code Doe}.
   * </ul>
   *
   * <p>Method under test: {@link UserMsgConstructorV1#constructUserUpdatedMsg(UpdateMsgType, User)}
   */
  @Test
  @DisplayName(
      "Test constructUserUpdatedMsg(UpdateMsgType, User); given 'Doe'; then return LastName is 'Doe'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "UserUpdateMsg UserMsgConstructorV1.constructUserUpdatedMsg(UpdateMsgType, User)"
  })
  void testConstructUserUpdatedMsg_givenDoe_thenReturnLastNameIsDoe() {
    // Arrange
    UserMsgConstructorV1 userMsgConstructorV1 = new UserMsgConstructorV1();

    User user = new User();
    user.setLastName("Doe");
    user.setAuthority(Authority.SYS_ADMIN);
    user.setEmail("john.smith@example.org");
    user.setId(new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    UserUpdateMsg actualConstructUserUpdatedMsgResult =
        userMsgConstructorV1.constructUserUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, user);

    // Assert
    assertEquals("Doe", actualConstructUserUpdatedMsgResult.getLastName());
    ByteString lastNameBytes = actualConstructUserUpdatedMsgResult.getLastNameBytes();
    assertFalse(lastNameBytes.isEmpty());
    ByteIterator iteratorResult = lastNameBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    Byte nextResult3 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('D', nextResult.byteValue());
    assertEquals('o', nextResult2.byteValue());
    assertEquals('e', nextResult3.byteValue());
    assertEquals("Doe", lastNameBytes.toStringUtf8());
    assertEquals(61, actualConstructUserUpdatedMsgResult.getSerializedSize());
    assertTrue(actualConstructUserUpdatedMsgResult.hasLastName());
  }

  /**
   * Test {@link UserMsgConstructorV1#constructUserUpdatedMsg(UpdateMsgType, User)}.
   *
   * <ul>
   *   <li>Given {@code Jane}.
   *   <li>Then return FirstNameBytes toStringUtf8 is {@code Jane}.
   * </ul>
   *
   * <p>Method under test: {@link UserMsgConstructorV1#constructUserUpdatedMsg(UpdateMsgType, User)}
   */
  @Test
  @DisplayName(
      "Test constructUserUpdatedMsg(UpdateMsgType, User); given 'Jane'; then return FirstNameBytes toStringUtf8 is 'Jane'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "UserUpdateMsg UserMsgConstructorV1.constructUserUpdatedMsg(UpdateMsgType, User)"
  })
  void testConstructUserUpdatedMsg_givenJane_thenReturnFirstNameBytesToStringUtf8IsJane() {
    // Arrange
    UserMsgConstructorV1 userMsgConstructorV1 = new UserMsgConstructorV1();

    User user = new User();
    user.setFirstName("Jane");
    user.setAuthority(Authority.SYS_ADMIN);
    user.setEmail("john.smith@example.org");
    user.setId(new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    UserUpdateMsg actualConstructUserUpdatedMsgResult =
        userMsgConstructorV1.constructUserUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, user);

    // Assert
    ByteString firstNameBytes = actualConstructUserUpdatedMsgResult.getFirstNameBytes();
    assertEquals("Jane", firstNameBytes.toStringUtf8());
    assertEquals("Jane", actualConstructUserUpdatedMsgResult.getFirstName());
    assertEquals(62, actualConstructUserUpdatedMsgResult.getSerializedSize());
    assertFalse(firstNameBytes.isEmpty());
    ByteIterator iteratorResult = firstNameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(actualConstructUserUpdatedMsgResult.hasFirstName());
    assertEquals('J', iteratorResult.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    assertEquals('n', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link UserMsgConstructorV1#constructUserUpdatedMsg(UpdateMsgType, User)}.
   *
   * <ul>
   *   <li>Given {@code SYS_ADMIN}.
   *   <li>Then return FirstName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link UserMsgConstructorV1#constructUserUpdatedMsg(UpdateMsgType, User)}
   */
  @Test
  @DisplayName(
      "Test constructUserUpdatedMsg(UpdateMsgType, User); given 'SYS_ADMIN'; then return FirstName is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "UserUpdateMsg UserMsgConstructorV1.constructUserUpdatedMsg(UpdateMsgType, User)"
  })
  void testConstructUserUpdatedMsg_givenSysAdmin_thenReturnFirstNameIsEmptyString() {
    // Arrange
    UserMsgConstructorV1 userMsgConstructorV1 = new UserMsgConstructorV1();

    User user = new User();
    user.setAuthority(Authority.SYS_ADMIN);
    user.setEmail("john.smith@example.org");
    user.setId(new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    UserUpdateMsg actualConstructUserUpdatedMsgResult =
        userMsgConstructorV1.constructUserUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, user);

    // Assert
    assertEquals("", actualConstructUserUpdatedMsgResult.getFirstName());
    assertEquals("", actualConstructUserUpdatedMsgResult.getLastName());
    assertEquals(0L, actualConstructUserUpdatedMsgResult.getCustomerIdLSB());
    assertEquals(0L, actualConstructUserUpdatedMsgResult.getCustomerIdMSB());
    assertEquals(4, actualConstructUserUpdatedMsgResult.getAllFields().size());
    assertEquals(56, actualConstructUserUpdatedMsgResult.getSerializedSize());
    assertFalse(actualConstructUserUpdatedMsgResult.hasCustomerIdLSB());
    assertFalse(actualConstructUserUpdatedMsgResult.hasCustomerIdMSB());
    assertFalse(actualConstructUserUpdatedMsgResult.hasFirstName());
    assertFalse(actualConstructUserUpdatedMsgResult.hasLastName());
  }

  /**
   * Test {@link UserMsgConstructorV1#constructUserUpdatedMsg(UpdateMsgType, User)}.
   *
   * <ul>
   *   <li>Then return CustomerIdLSB is {@code -7476899250389416711}.
   * </ul>
   *
   * <p>Method under test: {@link UserMsgConstructorV1#constructUserUpdatedMsg(UpdateMsgType, User)}
   */
  @Test
  @DisplayName(
      "Test constructUserUpdatedMsg(UpdateMsgType, User); then return CustomerIdLSB is '-7476899250389416711'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "UserUpdateMsg UserMsgConstructorV1.constructUserUpdatedMsg(UpdateMsgType, User)"
  })
  void testConstructUserUpdatedMsg_thenReturnCustomerIdLSBIs7476899250389416711() {
    // Arrange
    UserMsgConstructorV1 userMsgConstructorV1 = new UserMsgConstructorV1();

    User user = new User();
    user.setCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    user.setAuthority(Authority.SYS_ADMIN);
    user.setEmail("john.smith@example.org");
    user.setId(new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    UserUpdateMsg actualConstructUserUpdatedMsgResult =
        userMsgConstructorV1.constructUserUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, user);

    // Assert
    assertEquals(-7476899250389416711L, actualConstructUserUpdatedMsgResult.getCustomerIdLSB());
    assertEquals(6, actualConstructUserUpdatedMsgResult.getAllFields().size());
    assertEquals(77, actualConstructUserUpdatedMsgResult.getSerializedSize());
    assertEquals(8669210807411032922L, actualConstructUserUpdatedMsgResult.getCustomerIdMSB());
    assertTrue(actualConstructUserUpdatedMsgResult.hasCustomerIdLSB());
    assertTrue(actualConstructUserUpdatedMsgResult.hasCustomerIdMSB());
  }

  /**
   * Test {@link UserMsgConstructorV1#constructUserCredentialsUpdatedMsg(UserCredentials)}.
   *
   * <p>Method under test: {@link
   * UserMsgConstructorV1#constructUserCredentialsUpdatedMsg(UserCredentials)}
   */
  @Test
  @DisplayName("Test constructUserCredentialsUpdatedMsg(UserCredentials)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "UserCredentialsUpdateMsg UserMsgConstructorV1.constructUserCredentialsUpdatedMsg(UserCredentials)"
  })
  void testConstructUserCredentialsUpdatedMsg() {
    // Arrange
    UserMsgConstructorV1 userMsgConstructorV1 = new UserMsgConstructorV1();

    UserCredentials userCredentials = new UserCredentials();
    userCredentials.setPassword("iloveyou");
    userCredentials.setUserId(new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    UserCredentialsUpdateMsg actualConstructUserCredentialsUpdatedMsgResult =
        userMsgConstructorV1.constructUserCredentialsUpdatedMsg(userCredentials);

    // Assert
    assertEquals("", actualConstructUserCredentialsUpdatedMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructUserCredentialsUpdatedMsgResult.getEntity());
    assertEquals("iloveyou", actualConstructUserCredentialsUpdatedMsgResult.getPassword());
    assertEquals(
        -7476899250389416711L, actualConstructUserCredentialsUpdatedMsgResult.getUserIdLSB());
    assertEquals(3, actualConstructUserCredentialsUpdatedMsgResult.getAllFields().size());
    assertEquals(31, actualConstructUserCredentialsUpdatedMsgResult.getSerializedSize());
    assertEquals(
        8669210807411032922L, actualConstructUserCredentialsUpdatedMsgResult.getUserIdMSB());
    assertFalse(actualConstructUserCredentialsUpdatedMsgResult.getEnabled());
    assertTrue(actualConstructUserCredentialsUpdatedMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConstructUserCredentialsUpdatedMsgResult.isInitialized());
  }
}
